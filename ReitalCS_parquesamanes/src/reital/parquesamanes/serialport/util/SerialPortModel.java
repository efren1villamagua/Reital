package reital.parquesamanes.serialport.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;
import reital.parquesamanes.lector.util.ParqueSamanesTransactionStatus;

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
	public void initializePortModel() throws SerialPortException, PortInUseException, UnsupportedCommOperationException, IOException {

		boolean portFound = false;
		String defaultPort = null;

		// determine the name of the serial port on several operating systems
		String osname = System.getProperty("os.name", "").toLowerCase();
		if (osname.startsWith("windows")) {
			// windows
			defaultPort = ParqueSamanesConstantes.PUERTO_SERIAL;
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
		this.serialPort = (SerialPort) this.portId.open("ReitalParking" + ParqueSamanesConstantes.EMPRESA_NOMBRE_01, 2000);
		// CommPort commPort = portId.open(this.getClass().getName(), 2000);
		/*
		 * if (commPort instanceof SerialPort) { SerialPort serialPort =
		 * (SerialPort) commPort; serialPort.setSerialPortParams(57600,
		 * SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
		 * SerialPort.PARITY_NONE);
		 * 
		 * //InputStream in = serialPort.getInputStream(); //inputStream =
		 * serialPort.getInputStream(); }
		 */
		// set port parameters
		this.serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		// get the outputstream
		this.outputStream = this.serialPort.getOutputStream();
		try {
			// activate the OUTPUT_BUFFER_EMPTY notifier
			this.serialPort.notifyOnOutputEmpty(true);
		} catch (Exception e) {
			String mensaje = "ERROR setting event notification : " + e.getMessage();
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
	public ParqueSamanesTransactionStatus abrirSalida1() {
		ParqueSamanesTransactionStatus ts = abrir1();
		if (!ts.isOk()) {
			return ts;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cerrar1();
	}

	/**
	 *
	 */
	private ParqueSamanesTransactionStatus abrir1() {
		ParqueSamanesTransactionStatus ts = new ParqueSamanesTransactionStatus();
		try {
			this.writeToPort(ParqueSamanesConstantes.PUERTA_1_OPEN);
			ts.setOk(true);
		} catch (IOException e1) {
			ts.setOk(false);
			ts.setMensaje("ERROR: No se pudo enviar señal de apertura a la salida 1: " + e1.getMessage());
		}
		return ts;
	}

	/**
	 *
	 */
	private ParqueSamanesTransactionStatus cerrar1() {
		ParqueSamanesTransactionStatus ts = new ParqueSamanesTransactionStatus();
		try {
			this.writeToPort(ParqueSamanesConstantes.PUERTA_1_CLOSE);
			ts.setOk(true);
		} catch (IOException e1) {
			ts.setOk(false);
			ts.setMensaje("ERROR: No se pudo enviar señal de cerrar la salida 1: " + e1.getMessage());
		}
		return ts;
	}

	/**
	 *
	 */
	public ParqueSamanesTransactionStatus abrirSalida2() {
		ParqueSamanesTransactionStatus ts = abrir2();
		if (!ts.isOk()) {
			return ts;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cerrar2();
	}

	/**
	 *
	 */
	private ParqueSamanesTransactionStatus abrir2() {
		ParqueSamanesTransactionStatus ts = new ParqueSamanesTransactionStatus();
		try {
			this.writeToPort(ParqueSamanesConstantes.PUERTA_2_OPEN);
			ts.setOk(true);
		} catch (IOException e1) {
			ts.setOk(false);
			ts.setMensaje("ERROR: No se pudo enviar señal de apertura a la salida 2: " + e1.getMessage());
		}
		return ts;
	}

	/**
	 *
	 */
	private ParqueSamanesTransactionStatus cerrar2() {
		ParqueSamanesTransactionStatus ts = new ParqueSamanesTransactionStatus();
		try {
			this.writeToPort(ParqueSamanesConstantes.PUERTA_2_CLOSE);
			ts.setOk(true);
		} catch (IOException e1) {
			ts.setOk(false);
			ts.setMensaje("ERROR: No se pudo enviar señal de cerrar la salida 2: " + e1.getMessage());
		}
		return ts;
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
