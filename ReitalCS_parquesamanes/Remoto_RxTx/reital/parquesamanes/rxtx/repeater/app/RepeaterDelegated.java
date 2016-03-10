package reital.parquesamanes.rxtx.repeater.app;

import java.io.IOException;
import java.io.InputStream;

import efren.util.SystemLogManager;
import gnu.io.PortInUseException;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.rxtx.app.PuertoSerialException;
import reital.parquesamanes.rxtx.app.PuertoSerialIN;
import reital.parquesamanes.rxtx.app.PuertoSerialINOUT;

public class RepeaterDelegated {

	private PuertoSerialIN puertoSerialIN = null;
	private PuertoSerialINOUT puertoSerialINOUT = null;
	private String requestingAppName;
	private String idPuerto_IN;
	private String idPuerto_INOUT;
	private BarreraManager barManager;

	public RepeaterDelegated(String requestingAppName, String idPuerto_IN, String idPuerto_INOUT,
			String osCommandToOpenBar) {
		super();
		setRequestingAppName(requestingAppName);
		setIdPuerto_IN(idPuerto_IN);
		setIdPuerto_INOUT(idPuerto_INOUT);
		setBarManager(new BarreraManager(osCommandToOpenBar));
		initialize();
	}

	private void initialize() {

		// boolean ok1 = false;
		// if (getIdPuerto_IN() == null) {
		// ok1 = true;
		// } else {
		// ok1 = initializeIN_fromMatriz(getIdPuerto_IN());
		// }
		// boolean ok2 = true;

		boolean ok1 = false;
		if (getIdPuerto_IN() == null) {
			ok1 = true;
		} else {
			ok1 = initializeIN(getIdPuerto_IN());
		}
		boolean ok2 = false;
		if (getIdPuerto_INOUT() == null) {
			ok2 = true;
		} else {
			ok2 = initializeINOUT(getIdPuerto_INOUT());
		}

		if (ok1 && ok2) {
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

	private boolean initializeIN(String idPuerto) {

		// LECTURA DEL PUERTO QUE ESTA CONECTADO A LA BARRERA

		setPuertoSerialIN(new PuertoSerialIN());

		boolean ok = false;
		try {
			getPuertoSerialIN().initialize(idPuerto, getRequestingAppName());
			getPuertoSerialIN().getSerialPort().notifyOnDataAvailable(true);

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

			getPuertoSerialIN().getSerialPort().addEventListener(new SerialPortEventListener() {
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

							InputStream is = getPuertoSerialIN().getInputStream();
							while (is.available() > 0) {
								@SuppressWarnings("unused")
								int numBytes = is.read(readBuffer);
							}

							if (getPuertoSerialINOUT() != null) {
								String texto = new String(readBuffer).trim();
								SystemLogManager.info("Puerto \"" + getPuertoSerialIN().getSerialPort().getName()
										+ "\" - lectura desde la barrera: " + texto);
								getPuertoSerialINOUT().write(texto);
								SystemLogManager.info("Puerto \"" + getPuertoSerialINOUT().getSerialPort().getName()
										+ "\" - envio a matriz: " + texto);
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
									String respuestaDesdeMatriz = new String(readBufferTemp).trim();
									SystemLogManager.info("Puerto \"" + getPuertoSerialINOUT().getSerialPort().getName()
											+ "\" - respuesta desde matriz: " + respuestaDesdeMatriz);
									System.out.println(respuestaDesdeMatriz);
									getBarManager().manage(respuestaDesdeMatriz);
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

	private boolean initializeIN_fromMatriz(String idPuerto) {

		// LECTURA DEL PUERTO QUE ESTA CONECTADO A LA BARRERA

		setPuertoSerialIN(new PuertoSerialIN());

		boolean ok = false;
		try {
			getPuertoSerialIN().initialize(idPuerto, getRequestingAppName());
			getPuertoSerialIN().getSerialPort().notifyOnDataAvailable(true);

			String mensaje = idPuerto + " inicializado ok.";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

			while (true) {
				try {
					byte[] readBuffer = new byte[1024];
					try {
						InputStream is = getPuertoSerialIN().getInputStream();
						int numBytes = 0;
						while (is.available() > 0) {
							numBytes = is.read(readBuffer);
						}
						@SuppressWarnings("unused")
						final int numBytesTemp = numBytes;
						final byte[] readBufferTemp = readBuffer;
						new Thread(new Runnable() {
							public void run() {
								String respuestaDesdeMatriz = new String(readBufferTemp).trim();
								SystemLogManager.info("Puerto \"" + getPuertoSerialIN().getSerialPort().getName()
										+ "\" - respuesta desde matriz: " + respuestaDesdeMatriz);
								System.out.println(respuestaDesdeMatriz);
								// getBarManager().manage(respuestaDesdeMatriz);
							}
						}).start();
					} catch (IOException exc1) {
						exc1.printStackTrace();
					}
				} catch (Exception exc) {
					exc.getMessage();
				}
			}
			// ok = true;
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
			getPuertoSerialIN().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		try {
			getPuertoSerialINOUT().close();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
	}

	public PuertoSerialIN getPuertoSerialIN() {
		return puertoSerialIN;
	}

	public void setPuertoSerialIN(PuertoSerialIN puertoSerialIN) {
		this.puertoSerialIN = puertoSerialIN;
	}

	public String getRequestingAppName() {
		return requestingAppName;
	}

	public void setRequestingAppName(String requestingAppName) {
		this.requestingAppName = requestingAppName;
	}

	public String getIdPuerto_IN() {
		return idPuerto_IN;
	}

	public void setIdPuerto_IN(String idPuerto_IN) {
		this.idPuerto_IN = idPuerto_IN;
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

	public BarreraManager getBarManager() {
		return barManager;
	}

	public void setBarManager(BarreraManager barManager) {
		this.barManager = barManager;
	}

}
