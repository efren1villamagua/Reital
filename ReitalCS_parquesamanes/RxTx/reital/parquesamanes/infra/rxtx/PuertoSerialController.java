package reital.parquesamanes.infra.rxtx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gnu.io.PortInUseException;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class PuertoSerialController {

	private PuertoSerial puertoSerial = null;
	private JTextField cajaTextoIdPuerto;
	private JButton botonEnvio;
	private JTextField cajaTextoEnvio;
	private JTextArea textAreaLogEnvio;
	private JTextArea textAreaLogRecepcion;
	private String requestingAppName;
	private JFrame mainView;
	private boolean primerEnvio = true;

	public PuertoSerialController(String requestingAppName, JTextField cajaTextoIdPuerto, JButton botonEnvio,
			JTextField cajaTextoEnvio, JTextArea textAreaLogEnvio, JTextArea textAreaLogRecepcion, JFrame mainView) {
		super();
		setPrimerEnvio(true);
		setCajaTextoIdPuerto(cajaTextoIdPuerto);
		setBotonEnvio(botonEnvio);
		setCajaTextoEnvio(cajaTextoEnvio);
		setTextAreaLogEnvio(textAreaLogEnvio);
		setTextAreaLogRecepcion(textAreaLogRecepcion);
		setRequestingAppName(requestingAppName);
		setMainView(mainView);
		initialize();
	}

	private void initialize() {
		try {
			if (getBotonEnvio() != null) {
				getBotonEnvio().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarTexto();
					}
				});
			}
			if (getCajaTextoEnvio() != null) {
				getCajaTextoEnvio().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarTexto();
					}
				});
			}
			setPuertoSerial(new PuertoSerial());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private boolean initializeSerialPort(String idPuerto, JTextArea logArea, JFrame mainView) {
		boolean ok = false;
		try {
			getPuertoSerial().initialize(idPuerto, getRequestingAppName(), logArea);
			getPuertoSerial().getSerialPort().notifyOnDataAvailable(true);
			getPuertoSerial().getSerialPort().addEventListener(new SerialPortEventListener() {
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
							InputStream is = getPuertoSerial().getInputStream();
							int numBytes = 0;
							while (is.available() > 0) {
								numBytes = is.read(readBuffer);
							}
							final int numBytesTemp = numBytes;
							final byte[] readBufferTemp = readBuffer;
							new Thread(new Runnable() {
								public void run() {
									getTextAreaLogRecepcion()
											.append("[" + System.currentTimeMillis() + "](" + numBytesTemp + " bytes)"
													+ new String(readBufferTemp) + System.lineSeparator());
								}
							}).start();
						} catch (IOException exc1) {
						}
						break;
					}
				}
			});
			mainView.setTitle(idPuerto + " - " + mainView.getTitle());
			ok = true;
		} catch (PuertoSerialException e1) {
			System.out.println("ERROR AL INICIALIZAR EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]");
			logArea.append("ERROR AL INICIALIZAR EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]"
					+ System.lineSeparator());
		} catch (PortInUseException e1) {
			System.out.println("ERROR: EL PUERTO " + idPuerto + " ESTA OCUPADO [" + e1.getMessage() + "]");
			logArea.append("ERROR: EL PUERTO " + idPuerto + " ESTA OCUPADO [" + e1.getMessage() + "]"
					+ System.lineSeparator());
		} catch (UnsupportedCommOperationException e1) {
			System.out
					.println("ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]");
			logArea.append("ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]"
					+ System.lineSeparator());
		} catch (IOException e1) {
			System.out.println("ERROR DE ESCRITURA EN EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]");
			logArea.append("ERROR DE ESCRITURA EN EL PUERTO " + idPuerto + " [" + e1.getMessage() + "]"
					+ System.lineSeparator());
		} catch (Exception exc) {
			logArea.append(
					"ERROR GENERAL EN EL PUERTO " + idPuerto + " [" + exc.getMessage() + "]" + System.lineSeparator());
			exc.printStackTrace();
		}
		return ok;
	}

	private void enviarTexto() {
		if (getCajaTextoEnvio() == null) {
			return;
		}
		String texto = getCajaTextoEnvio().getText();
		try {
			if (texto != null && texto.trim().length() > 0) {
				if (isPrimerEnvio()) {
					if (initializeSerialPort(getCajaTextoIdPuerto().getText(), getTextAreaLogEnvio(), getMainView())) {
						getCajaTextoIdPuerto().setEditable(false);
						getCajaTextoEnvio().requestFocus();
						setPrimerEnvio(false);
					} else {
						return;
					}
				}
				final String textoTemp = texto;
				new Thread(new Runnable() {
					public void run() {
						try {
							getPuertoSerial().writeToPort(textoTemp);
							logEnvio(textoTemp);
							getCajaTextoEnvio().setText("");
						} catch (Exception exc) {
							exc.printStackTrace();
						}
					}
				}).start();

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private void logEnvio(String texto) {
		if (getTextAreaLogEnvio() != null) {
			getTextAreaLogEnvio().append("[" + System.currentTimeMillis() + "]" + texto + System.lineSeparator());
		}
	}

	public PuertoSerial getPuertoSerial() {
		return puertoSerial;
	}

	private void setPuertoSerial(PuertoSerial puertoSerial) {
		this.puertoSerial = puertoSerial;
	}

	public JButton getBotonEnvio() {
		return botonEnvio;
	}

	private void setBotonEnvio(JButton botonEnvio) {
		this.botonEnvio = botonEnvio;
	}

	public JTextField getCajaTextoEnvio() {
		return cajaTextoEnvio;
	}

	private void setCajaTextoEnvio(JTextField cajaTextoEnvio) {
		this.cajaTextoEnvio = cajaTextoEnvio;
	}

	public JTextArea getTextAreaLogEnvio() {
		return textAreaLogEnvio;
	}

	private void setTextAreaLogEnvio(JTextArea textAreaLogEnvio) {
		this.textAreaLogEnvio = textAreaLogEnvio;
	}

	public JTextArea getTextAreaLogRecepcion() {
		return textAreaLogRecepcion;
	}

	private void setTextAreaLogRecepcion(JTextArea textAreaLogRecepcion) {
		this.textAreaLogRecepcion = textAreaLogRecepcion;
	}

	public String getRequestingAppName() {
		return requestingAppName;
	}

	private void setRequestingAppName(String requestingAppName) {
		this.requestingAppName = requestingAppName;
	}

	private boolean isPrimerEnvio() {
		return primerEnvio;
	}

	private void setPrimerEnvio(boolean primerEnvio) {
		this.primerEnvio = primerEnvio;
	}

	public JTextField getCajaTextoIdPuerto() {
		return cajaTextoIdPuerto;
	}

	private void setCajaTextoIdPuerto(JTextField cajaTextoIdPuerto) {
		this.cajaTextoIdPuerto = cajaTextoIdPuerto;
	}

	public void finalize() {
		try {
			getPuertoSerial().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JFrame getMainView() {
		return mainView;
	}

	private void setMainView(JFrame mainView) {
		this.mainView = mainView;
	}
}
