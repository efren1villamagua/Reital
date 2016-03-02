package reital.parquesamanes.rxtx.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import efren.util.SystemLogManager;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.rxtx.app.Resultado.Status;

public abstract class PuertoSerial {

	public static enum Tipo {
		IN, OUT, IN_OUT;
	}

	private Tipo tipo;
	private SerialPort serialPort = null;
	private OutputStream outputStream = null;
	private InputStream inputStream = null;

	public PuertoSerial(Tipo tipo) {
		super();
		setTipo(tipo);
	}

	public Resultado initialize(String idPuerto, String requestingAppName)
			throws PuertoSerialException, PortInUseException, UnsupportedCommOperationException, IOException {

		Resultado resultado = new Resultado();

		boolean portFound = false;

		String mensaje = "Puerto configurado en: \"" + idPuerto + "\".";
		SystemLogManager.info(mensaje);
		resultado.appendMensaje(mensaje + System.lineSeparator());

		// parse ports and if the default port is found, initialized the reader
		@SuppressWarnings("unchecked")
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

		CommPortIdentifier portIdTemp = null;

		while (portList.hasMoreElements()) {
			portIdTemp = portList.nextElement();
			if (portIdTemp.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portIdTemp.getName().equals(idPuerto)) {
					mensaje = "Puerto encontrado: \"" + idPuerto + "\".";
					SystemLogManager.info(mensaje);
					resultado.appendMensaje(mensaje + System.lineSeparator());
					portFound = true;
					break;
				}
			}
		}
		if (!portFound) {
			mensaje = "ERROR: El puerto \"" + idPuerto + "\" no se ha encontrado.";
			SystemLogManager.info(mensaje);
			resultado.appendMensaje(mensaje + System.lineSeparator());
			throw new PuertoSerialException(mensaje);
		}

		int openTimeout = 2000;
		setSerialPort((SerialPort) portIdTemp.open(requestingAppName, openTimeout));

		getSerialPort().setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		if (getTipo() != null) {
			switch (getTipo()) {
			case IN:
				setInputStream(getSerialPort().getInputStream());
				break;
			case OUT:
				setOutputStream(getSerialPort().getOutputStream());
				break;
			case IN_OUT:
				setInputStream(getSerialPort().getInputStream());
				setOutputStream(getSerialPort().getOutputStream());
				break;
			default:
				break;
			}

		}
		try {
			// activate the OUTPUT_BUFFER_EMPTY notifier
			getSerialPort().notifyOnOutputEmpty(true);
			getSerialPort().notifyOnDataAvailable(true);
		} catch (Exception e) {
			mensaje = "ERROR setting event notification : " + e.getMessage();
			SystemLogManager.info(mensaje);
			resultado.appendMensaje(mensaje + System.lineSeparator());
			throw new PuertoSerialException(mensaje);
		}

		resultado.setStatus(Status.EXITO);

		return resultado;
	}

	public void close() {
		if (getSerialPort() != null) {
			try {
				getOutputStream().flush();
				getOutputStream().close();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				getInputStream().close();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				getSerialPort().close();
			} catch (Exception exc) {
				exc.getMessage();
			}
		}
	}

	public SerialPort getSerialPort() {
		return this.serialPort;
	}

	private void setSerialPort(SerialPort serialPort) {
		this.serialPort = serialPort;
	}

	public OutputStream getOutputStream() {
		return this.outputStream;
	}

	private void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	private void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Tipo getTipo() {
		return tipo;
	}

	private void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
