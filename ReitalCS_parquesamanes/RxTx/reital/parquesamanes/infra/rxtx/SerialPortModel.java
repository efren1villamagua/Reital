package reital.parquesamanes.infra.rxtx;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SerialPortModel {

	private CommPortIdentifier portId;
	private Enumeration<CommPortIdentifier> portList;
	private SerialPort serialPort = null;
	private OutputStream outputStream;

	/**
	 *
	 */
	public SerialPortModel() {
		super();
	}
	/**
	 * @throws SerialPortException
	 * @throws PortInUseException
	 * @throws UnsupportedCommOperationException
	 * @throws IOException
	 * @throws Exception
	 *
	 */
	@SuppressWarnings("unchecked")
	public void initializePortModel(String puertoSerialString) throws SerialPortException, PortInUseException, UnsupportedCommOperationException, IOException {

		boolean portFound = false;
		String defaultPort = null;

		// determine the name of the serial port on several operating systems
		String osname = System.getProperty("os.name", "").toLowerCase();
		if (osname.startsWith("windows")) {
			// windows
			defaultPort = puertoSerialString;
		} else if (osname.startsWith("linux")) {
			// linux
			defaultPort = "/dev/ttyS0";
		} else if (osname.startsWith("mac")) {
			// mac
			defaultPort = "????";
		} else {
			String mensaje = "ERROR: Sistema operativo no soportado.";
			System.out.println(mensaje);
			throw new SerialPortException(mensaje);
		}

		System.out.println("Set default port to " + defaultPort);

		// parse ports and if the default port is found, initialized the reader
		this.portList = CommPortIdentifier.getPortIdentifiers();
		while (this.portList.hasMoreElements()) {
			this.portId = this.portList.nextElement();
			if (this.portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (this.portId.getName().equals(defaultPort)) {
					System.out.println("Found port: " + defaultPort);
					portFound = true;
					break;
				}
			}
		}
		if (!portFound) {
			String mensaje = "ERROR: El puerto " + defaultPort + " no se ha encontrado.";
			System.out.println(mensaje);
			throw new SerialPortException(mensaje);
		}

		// initalize serial port
		this.serialPort = (SerialPort) this.portId.open("ReitalParkingCasriba", 2000);
		//CommPort commPort = portId.open(this.getClass().getName(), 2000);
/*
			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

				//InputStream in = serialPort.getInputStream();
				//inputStream = serialPort.getInputStream();
			}
*/
		// set port parameters
		this.serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		// get the outputstream
		this.outputStream = this.serialPort.getOutputStream();
		try {
			// activate the OUTPUT_BUFFER_EMPTY notifier
			this.serialPort.notifyOnOutputEmpty(true);
		} catch (Exception e) {
			String mensaje = "ERROR setting event notification : "+e.getMessage();
			System.out.println(mensaje);
			throw new SerialPortException(mensaje);
		}

	}
	/**
	 * @throws IOException
	 *
	 */
	private void writeToPort(String cadena) throws IOException {
		this.outputStream.write(cadena.getBytes());
	}
	/**
	 *
	 */
	private void close() {
		this.serialPort.close();
	}
	/**
	 *
	 */
	public void enviarCaracter(String cadena) {
		try {
			this.writeToPort(cadena);
			JOptionPane.showMessageDialog(new JFrame(), "Cadena enviada: "+cadena);
		} catch (IOException e1) {
			e1.printStackTrace(System.out);
			JOptionPane.showMessageDialog(new JFrame(), "ERROR: "+e1.getMessage());
		} catch (Exception e2) {
			e2.printStackTrace(System.out);
			JOptionPane.showMessageDialog(new JFrame(), "ERROR: "+e2.getMessage());
		}
	}
	/**
	 *
	 */
	protected void finalize() throws Throwable {
	    try {
	        close();
	    } finally {
	        super.finalize();
	    }
	}

}
