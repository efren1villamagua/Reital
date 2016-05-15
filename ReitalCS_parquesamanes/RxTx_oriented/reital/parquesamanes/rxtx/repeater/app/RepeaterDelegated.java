package reital.parquesamanes.rxtx.repeater.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import efren.util.SystemLogManager;
import gnu.io.PortInUseException;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.rxtx.app.PuertoSerialException;
import reital.parquesamanes.rxtx.app.PuertoSerialIN;
import reital.parquesamanes.rxtx.app.PuertoSerialINOUT;
import reital.parquesamanes.rxtx.app.PuertoSerialOUT;

public class RepeaterDelegated {

	private PuertoSerialIN puertoSerial_BARRERA = null;
	private PuertoSerialINOUT puertoSerial_SERVER = null;
	private PuertoSerialOUT puertoSerial_ARDUINO = null;
	private String requestingAppName;
	private String idPuerto_BARRERA;
	private String idPuerto_SERVER;
	private String idPuerto_ARDUINO;

	public RepeaterDelegated(String requestingAppName, String idPuerto_BARRERA, String idPuerto_SERVER,
			String idPuerto_ARDUINO) {
		super();
		setRequestingAppName(requestingAppName);
		setIdPuerto_BARRERA(idPuerto_BARRERA);
		setIdPuerto_SERVER(idPuerto_SERVER);
		setIdPuerto_ARDUINO(idPuerto_ARDUINO);
		initialize();
	}

	private void initialize() {

		boolean ok1 = false;
		if (getIdPuerto_BARRERA() == null) {
			ok1 = true;
		} else {
			ok1 = initializeBARRERA(getIdPuerto_BARRERA());
		}
		boolean ok2 = false;
		if (getIdPuerto_SERVER() == null) {
			ok2 = true;
		} else {
			ok2 = initializeSERVER(getIdPuerto_SERVER());
		}
		boolean ok3 = false;
		if (getIdPuerto_ARDUINO() == null) {
			ok3 = true;
		} else {
			ok3 = initializeARDUINO(getIdPuerto_ARDUINO());
		}

		if (ok1 && ok2 && ok3) {
			String mensaje = RepeaterApp.class.getName() + " " + ParqueSamanesConstantes.SISTEMA_VERSION
					+ " trabajando...";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);
		} else {
			String mensaje = "ERROR: no hay procesos activos de entrada o salida desde los puertos seriales. Revise logs. Saliendo del sistema.";
			SystemLogManager.error(mensaje);
			System.out.println(mensaje);
			System.exit(1);
		}

	}

	private boolean initializeBARRERA(String idPuerto) {

		setPuertoSerial_BARRERA(new PuertoSerialIN());

		boolean ok = false;
		try {
			getPuertoSerial_BARRERA().initialize(idPuerto, getRequestingAppName());
			getPuertoSerial_BARRERA().getSerialPort().notifyOnDataAvailable(true);

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

			getPuertoSerial_BARRERA().getSerialPort().addEventListener(new SerialPortEventListener() {
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

							InputStream is = getPuertoSerial_BARRERA().getInputStream();
							while (is.available() > 0) {
								@SuppressWarnings("unused")
								int numBytes = is.read(readBuffer);
							}

							if (getPuertoSerial_SERVER() != null) {
								String texto = new String(readBuffer).trim();
								if (texto.trim().length() > 0) {
									SystemLogManager
											.info("[PASO 1] Puerto \"" + getPuertoSerial_BARRERA().getSerialPort().getName()
													+ "\" - lectura desde la barrera: " + texto);
									getPuertoSerial_SERVER().write(texto);
									SystemLogManager
											.info("[PASO 2] Puerto \"" + getPuertoSerial_SERVER().getSerialPort().getName()
													+ "\" - envio a matriz: " + texto);
								}
							}

						} catch (IOException exc1) {
							SystemLogManager.error(exc1);
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

	private boolean initializeSERVER(String idPuerto) {

		setPuertoSerial_SERVER(new PuertoSerialINOUT());

		boolean ok = false;
		try {
			getPuertoSerial_SERVER().initialize(idPuerto, getRequestingAppName());
			getPuertoSerial_SERVER().getSerialPort().notifyOnDataAvailable(true);

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

			getPuertoSerial_SERVER().getSerialPort().addEventListener(new SerialPortEventListener() {
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
							InputStream is = getPuertoSerial_SERVER().getInputStream();
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
										String respuestaDesdeMatriz = new String(readBufferTemp).trim();
										SystemLogManager
												.info("Puerto \"" + getPuertoSerial_SERVER().getSerialPort().getName()
														+ "\" - respuesta desde matriz: " + respuestaDesdeMatriz);
										System.out.println(respuestaDesdeMatriz);
										evaluarYEscribirRespuestaArduino2(respuestaDesdeMatriz.charAt(0));
									} catch (Exception e) {
										e.printStackTrace();
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

	@SuppressWarnings("unused")
	private void evaluarYEscribirRespuestaArduino1(String respuestaDesdeMatriz) {

		try {
			StringTokenizer stk = new StringTokenizer(respuestaDesdeMatriz, "|");
			// @SuppressWarnings("unused")
			String ticket = stk.nextToken();
			boolean resultado = Boolean.parseBoolean(stk.nextToken().trim().toLowerCase());
			getPuertoSerial_ARDUINO().write(resultado ? ParqueSamanesConstantes.ARDUINO_OPEN_CHAR : 'x');
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	private void evaluarYEscribirRespuestaArduino2(char c) {

		try {
			getPuertoSerial_ARDUINO().write(c);
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	private boolean initializeARDUINO(String idPuerto) {

		setPuertoSerial_ARDUINO(new PuertoSerialOUT());

		boolean ok = false;
		try {
			getPuertoSerial_ARDUINO().initialize(idPuerto, getRequestingAppName());

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

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

	public void finalize() {
		try {
			getPuertoSerial_BARRERA().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		try {
			getPuertoSerial_SERVER().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		try {
			getPuertoSerial_ARDUINO().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
	}

	public PuertoSerialIN getPuertoSerial_BARRERA() {
		return puertoSerial_BARRERA;
	}

	public void setPuertoSerial_BARRERA(PuertoSerialIN puertoSerial_BARRERA) {
		this.puertoSerial_BARRERA = puertoSerial_BARRERA;
	}

	public String getRequestingAppName() {
		return requestingAppName;
	}

	public void setRequestingAppName(String requestingAppName) {
		this.requestingAppName = requestingAppName;
	}

	public String getIdPuerto_BARRERA() {
		return idPuerto_BARRERA;
	}

	public void setIdPuerto_BARRERA(String idPuerto_BARRERA) {
		this.idPuerto_BARRERA = idPuerto_BARRERA;
	}

	public PuertoSerialINOUT getPuertoSerial_SERVER() {
		return puertoSerial_SERVER;
	}

	public void setPuertoSerial_SERVER(PuertoSerialINOUT puertoSerial_SERVER) {
		this.puertoSerial_SERVER = puertoSerial_SERVER;
	}

	public String getIdPuerto_SERVER() {
		return idPuerto_SERVER;
	}

	public void setIdPuerto_SERVER(String idPuerto_SERVER) {
		this.idPuerto_SERVER = idPuerto_SERVER;
	}

	public PuertoSerialOUT getPuertoSerial_ARDUINO() {
		return puertoSerial_ARDUINO;
	}

	public void setPuertoSerial_ARDUINO(PuertoSerialOUT puertoSerial_ARDUINO) {
		this.puertoSerial_ARDUINO = puertoSerial_ARDUINO;
	}

	public String getIdPuerto_ARDUINO() {
		return idPuerto_ARDUINO;
	}

	public void setIdPuerto_ARDUINO(String idPuerto_ARDUINO) {
		this.idPuerto_ARDUINO = idPuerto_ARDUINO;
	}

}
