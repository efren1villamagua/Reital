package reital.parquesamanes.infra.rxtx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.JTextArea;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class PuertoSerial {

	private SerialPort serialPort = null;
	private OutputStream outputStream = null;
	private InputStream inputStream = null;

	public void initialize(String idPuerto, String requestingAppName, JTextArea logArea)
			throws PuertoSerialException, PortInUseException, UnsupportedCommOperationException, IOException {

		boolean portFound = false;

		OSType os = OSType.getOS();

		switch (os) {
		case WINDOWS:
			// es el mismo id que viene como parametro
			break;
		case UNIX_LINUX:
			idPuerto = "/dev/ttyS0";
			break;
		case MAC_OS:
		case SOLARIS:
			idPuerto = "?????";
			break;
		default:
			idPuerto = "?????";
			String mensaje = "ERROR: Sistema operativo no soportado.";
			System.out.println(mensaje);
			logArea.append(mensaje + System.lineSeparator());
			throw new PuertoSerialException(mensaje);
		}

		System.out.println("Set default port to " + idPuerto);
		logArea.append("Set default port to " + idPuerto + System.lineSeparator());

		// parse ports and if the default port is found, initialized the reader
		@SuppressWarnings("unchecked")
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

		CommPortIdentifier portIdTemp = null;

		while (portList.hasMoreElements()) {
			portIdTemp = portList.nextElement();
			if (portIdTemp.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portIdTemp.getName().equals(idPuerto)) {
					System.out.println("Found port: " + idPuerto);
					logArea.append("Found port: " + idPuerto + System.lineSeparator());
					portFound = true;
					break;
				}
			}
		}
		if (!portFound) {
			String mensaje = "ERROR: El puerto " + idPuerto + " no se ha encontrado.";
			System.out.println(mensaje);
			logArea.append(mensaje + System.lineSeparator());
			throw new PuertoSerialException(mensaje);
		}

		int openTimeout = 2000;
		setSerialPort((SerialPort) portIdTemp.open(requestingAppName, openTimeout));

		getSerialPort().setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		setOutputStream(getSerialPort().getOutputStream());

		setInputStream(getSerialPort().getInputStream());

		try {
			// activate the OUTPUT_BUFFER_EMPTY notifier
			getSerialPort().notifyOnOutputEmpty(true);
			getSerialPort().notifyOnDataAvailable(true);
		} catch (Exception e) {
			String mensaje = "ERROR setting event notification : " + e.getMessage();
			System.out.println(mensaje);
			logArea.append(mensaje + System.lineSeparator());
			throw new PuertoSerialException(mensaje);
		}

	}

	public void writeToPort(String text) throws IOException {
		if (text != null && getOutputStream() != null) {
			getOutputStream().write(text.getBytes());
			getOutputStream().flush();
		}
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

}
