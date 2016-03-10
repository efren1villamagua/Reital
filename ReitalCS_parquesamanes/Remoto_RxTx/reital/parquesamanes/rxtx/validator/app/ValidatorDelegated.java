package reital.parquesamanes.rxtx.validator.app;

import java.io.IOException;
import java.io.InputStream;

import efren.util.CalendarManager;
import efren.util.SystemLogManager;
import gnu.io.PortInUseException;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.infra.DBConnectionModel;
import reital.parquesamanes.rxtx.app.PuertoSerialException;
import reital.parquesamanes.rxtx.app.PuertoSerialINOUT;

public class ValidatorDelegated {

	private PuertoSerialINOUT puertoSerialINOUT = null;
	private String requestingAppName;
	private String idPuerto_INOUT;
	private ActividadRepository actividadRepository;

	public ValidatorDelegated(String requestingAppName, String idPuerto_INOUT) {
		super();
		setRequestingAppName(requestingAppName);
		setIdPuerto_INOUT(idPuerto_INOUT);
		initialize();
	}

	private void initialize() {

		setActividadRepository(new Factory().getActividadRepository());

		try {
			ParqueSamanesConstantes.setInitialValues();
			ParqueSamanesConstantes.cargarPropiedades();
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			DBConnectionModel.dbConnect(true);
		} catch (Exception e1) {
			e1.printStackTrace();
			String mensaje = "ERROR: (" + e1.getClass().getSimpleName() + "): " + e1.getMessage();
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);
			System.exit(1);
		}

		boolean ok1 = true;
		boolean ok2 = false;
		if (getIdPuerto_INOUT() == null) {
			ok2 = true;
		} else {
			ok2 = initializeINOUT(getIdPuerto_INOUT());
		}

		if (ok1 && ok2) {
			String mensaje = "Sistema " + ParqueSamanesConstantes.SISTEMA_VERSION + " trabajando...";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);
		} else {
			String mensaje = "ERROR: no hay procesos activos de entrada o salida desde los puertos seriales. Revise logs. Saliendo del sistema.";
			SystemLogManager.error(mensaje);
			System.out.println(mensaje);
			System.exit(1);
		}

	}

	private boolean initializeINOUT(String idPuerto) {

		setPuertoSerialINOUT(new PuertoSerialINOUT());

		boolean ok = false;
		try {
			getPuertoSerialINOUT().initialize(idPuerto, getRequestingAppName());
			getPuertoSerialINOUT().getSerialPort().notifyOnDataAvailable(true);

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

			getPuertoSerialINOUT().getSerialPort().addEventListener(new SerialPortEventListener() {
				public void serialEvent(SerialPortEvent event) {
					switch (event.getEventType()) {
					case SerialPortEvent.BI:
					case SerialPortEvent.OE:
					case SerialPortEvent.FE:
					case SerialPortEvent.PE:
					case SerialPortEvent.CD:
					case SerialPortEvent.CTS:
					case SerialPortEvent.DSR:
					case SerialPortEvent.RI:
					case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
						break;
					case SerialPortEvent.DATA_AVAILABLE:
						byte[] readBuffer = new byte[1024];
						try {
							InputStream is = getPuertoSerialINOUT().getInputStream();
							int numBytes = 0;
							while (is.available() > 0) {
								numBytes = is.read(readBuffer);
							}
							@SuppressWarnings("unused")
							final int numBytesTemp = numBytes;
							final byte[] readBufferTemp = readBuffer;
							new Thread(new Runnable() {
								public void run() {
									try {
										String ticket = new String(readBufferTemp).trim();
										boolean resultado = validarTicket(ticket);
										getPuertoSerialINOUT().write(ticket + "|" + resultado);
										String mensaje = "Ticket validation: (" + ticket + "|" + resultado + ")";
										SystemLogManager.info(mensaje);
										System.out.println(mensaje);
									} catch (IOException exc) {
										exc.printStackTrace();
									}
								}
							}).start();
						} catch (IOException exc1) {
							exc1.printStackTrace();
						}
						break;
					}
				}
			});
			ok = true;
		} catch (PuertoSerialException exc) {
			SystemLogManager.error("ERROR AL INICIALIZAR EL PUERTO " + idPuerto + " [" + exc.getMessage() + "]", exc);
		} catch (PortInUseException exc) {
			SystemLogManager.error("ERROR: EL PUERTO " + idPuerto + " ESTA OCUPADO [" + exc.getMessage() + "]", exc);
		} catch (UnsupportedCommOperationException exc) {
			SystemLogManager.error(
					"ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + idPuerto + " [" + exc.getMessage() + "]", exc);
		} catch (IOException exc) {
			SystemLogManager.error("ERROR DE ESCRITURA EN EL PUERTO " + idPuerto + " [" + exc.getMessage() + "]", exc);
		} catch (Exception exc) {
			SystemLogManager.error("ERROR GENERAL EN EL PUERTO " + idPuerto + " [" + exc.getMessage() + "]", exc);
		}
		return ok;
	}

	private boolean validarTicket(String ticket) {

		boolean salidaOk = false;

		ActividadForPagoEntity actividadEntity = getActividadRepository().getActividad(ticket);

		if (actividadEntity == null) {
			String msg = "ERROR_1: registro no encontrado";
			SystemLogManager.info(msg);
			System.out.println(msg);
			salidaOk = false;
		} else {

			switch (actividadEntity.getEstadoPago()) {
			case PAGADO:
			case PASE_LIBRE:
			case TIEMPO_GRACIA:
				CalendarManager cmEntrada = new CalendarManager(actividadEntity.getEntrada());
				String entradaStr = cmEntrada.getInternationalDateExpression() + "  hora: "
						+ cmEntrada.getTimeExpression2();
				CalendarManager cmSalida = new CalendarManager(actividadEntity.getSalida());
				String salidaStr = cmSalida.getInternationalDateExpression() + "  hora: "
						+ cmSalida.getTimeExpression2();
				String msg = actividadEntity.getCodigo() + " - " + entradaStr + " - " + salidaStr + " - SALIDA OK.";
				SystemLogManager.info(msg);
				System.out.println(msg);
				salidaOk = true;
				break;
			default:
				msg = "ERROR_2: pendiente de pago o pase libre";
				SystemLogManager.info(msg);
				System.out.println(msg);
				salidaOk = false;
				break;
			}
		}

		return salidaOk;
	}

	public void finalize() {
		try {
			getPuertoSerialINOUT().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
	}

	public String getRequestingAppName() {
		return requestingAppName;
	}

	public void setRequestingAppName(String requestingAppName) {
		this.requestingAppName = requestingAppName;
	}

	public PuertoSerialINOUT getPuertoSerialINOUT() {
		return puertoSerialINOUT;
	}

	public void setPuertoSerialINOUT(PuertoSerialINOUT puertoSerialINOUT) {
		this.puertoSerialINOUT = puertoSerialINOUT;
	}

	public String getIdPuerto_INOUT() {
		return idPuerto_INOUT;
	}

	public void setIdPuerto_INOUT(String idPuerto_INOUT) {
		this.idPuerto_INOUT = idPuerto_INOUT;
	}

	public ActividadRepository getActividadRepository() {
		return actividadRepository;
	}

	public void setActividadRepository(ActividadRepository actividadRepository) {
		this.actividadRepository = actividadRepository;
	}

}
