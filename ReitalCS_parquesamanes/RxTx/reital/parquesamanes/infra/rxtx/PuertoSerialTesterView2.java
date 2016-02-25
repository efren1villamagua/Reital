package reital.parquesamanes.infra.rxtx;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import efren.util.lookandfeel.LookAndFeelManager;

public class PuertoSerialTesterView2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton buttonEnviar = null;
	private JTextField textFieldIdPuerto = null;
	private JPanel jPanelEnviar = null;
	private JLabel jLabel = null;
	private JTextField textFieldEnvio = null;
	private JPanel jPanelRecibir = null;
	private JTextArea textAreaLogEnvio;
	private JTextArea textAreaLogRecepcion;
	private PuertoSerialController controller;
	private JScrollPane scrollPaneEnviar;
	private JScrollPane scrollPaneRecibir;

	private JButton getButtonEnviar() {
		if (buttonEnviar == null) {
			buttonEnviar = new JButton();
			buttonEnviar.setText("Enviar texto >>");
		}
		return buttonEnviar;
	}

	private JTextField getTextFieldIdPuerto() {
		if (textFieldIdPuerto == null) {
			textFieldIdPuerto = new JTextField();
			textFieldIdPuerto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldEnvio().requestFocus();
				}
			});
			textFieldIdPuerto.setText("COM1");
		}
		return textFieldIdPuerto;
	}

	private JPanel getJPanelEnviar() {
		if (jPanelEnviar == null) {
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.gridy = 0;
			gridBagConstraints41.weightx = 1.0;
			gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gbc_buttonEnviar = new GridBagConstraints();
			gbc_buttonEnviar.anchor = GridBagConstraints.EAST;
			gbc_buttonEnviar.gridx = 0;
			gbc_buttonEnviar.gridy = 0;
			gbc_buttonEnviar.ipadx = 0;
			gbc_buttonEnviar.ipady = 0;
			gbc_buttonEnviar.weightx = 0.0;
			gbc_buttonEnviar.insets = new Insets(5, 5, 5, 5);
			jPanelEnviar = new JPanel();
			GridBagLayout gbl_jPanelEnviar = new GridBagLayout();
			gbl_jPanelEnviar.rowWeights = new double[] { 0.0, 1.0 };
			gbl_jPanelEnviar.columnWeights = new double[] { 0.0, 1.0 };
			jPanelEnviar.setLayout(gbl_jPanelEnviar);
			jPanelEnviar.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Enviar", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213)));
			jPanelEnviar.add(getButtonEnviar(), gbc_buttonEnviar);
			jPanelEnviar.add(getTextFieldEnvio(), gridBagConstraints41);
			GridBagConstraints gbc_textAreaLogEnvio = new GridBagConstraints();
			gbc_textAreaLogEnvio.gridwidth = 2;
			gbc_textAreaLogEnvio.insets = new Insets(0, 0, 0, 5);
			gbc_textAreaLogEnvio.fill = GridBagConstraints.BOTH;
			gbc_textAreaLogEnvio.gridx = 0;
			gbc_textAreaLogEnvio.gridy = 1;
			jPanelEnviar.add(getScrollPaneEnviar(), gbc_textAreaLogEnvio);
		}
		return jPanelEnviar;
	}

	private JTextField getTextFieldEnvio() {
		if (textFieldEnvio == null) {
			textFieldEnvio = new JTextField();
		}
		return textFieldEnvio;
	}

	private JPanel getJPanelRecibir() {
		if (jPanelRecibir == null) {
			jPanelRecibir = new JPanel();
			GridBagLayout gbl_jPanelRecibir = new GridBagLayout();
			gbl_jPanelRecibir.rowWeights = new double[] { 1.0 };
			gbl_jPanelRecibir.columnWeights = new double[] { 1.0 };
			jPanelRecibir.setLayout(gbl_jPanelRecibir);
			jPanelRecibir
					.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
							"Recibir", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
							new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213)));
			GridBagConstraints gbc_textAreaLogRecepcion = new GridBagConstraints();
			gbc_textAreaLogRecepcion.fill = GridBagConstraints.BOTH;
			gbc_textAreaLogRecepcion.gridx = 0;
			gbc_textAreaLogRecepcion.gridy = 0;
			jPanelRecibir.add(getScrollPaneRecibir(), gbc_textAreaLogRecepcion);
		}
		return jPanelRecibir;
	}

	public static void main(String[] args) {
		LookAndFeelManager.simpleSetLookAndFeel();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PuertoSerialTesterView2 thisClass = new PuertoSerialTesterView2();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setLocation(100, 100);
				thisClass.setVisible(true);
			}
		});
	}

	public PuertoSerialTesterView2() {
		super();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					getController().finalize();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.exit(0);
			}
		});
		initialize();
	}

	private void initialize() {
		this.setSize(586, 462);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("SerialPortTesterView2 [" + PuertoSerialTesterConstantes.SISTEMA_VERSION + "]");
		try {
			setController(new PuertoSerialController(getClass().getSimpleName(), getTextFieldIdPuerto(),
					getButtonEnviar(), getTextFieldEnvio(), getTextAreaLogEnvio(), getTextAreaLogRecepcion(), this));
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gbc_jPanelRecibir = new GridBagConstraints();
			gbc_jPanelRecibir.insets = new Insets(2, 2, 2, 2);
			gbc_jPanelRecibir.gridx = 0;
			gbc_jPanelRecibir.weightx = 1.0;
			gbc_jPanelRecibir.weighty = 1.0;
			gbc_jPanelRecibir.gridwidth = 2;
			gbc_jPanelRecibir.fill = GridBagConstraints.BOTH;
			gbc_jPanelRecibir.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Puerto:");
			GridBagConstraints gbc_jPanelEnviar = new GridBagConstraints();
			gbc_jPanelEnviar.insets = new Insets(0, 0, 5, 0);
			gbc_jPanelEnviar.gridx = 0;
			gbc_jPanelEnviar.gridwidth = 2;
			gbc_jPanelEnviar.weightx = 1.0;
			gbc_jPanelEnviar.weighty = 1.0;
			gbc_jPanelEnviar.fill = GridBagConstraints.BOTH;
			gbc_jPanelEnviar.gridy = 1;
			GridBagConstraints gbc_textFieldIdPuerto = new GridBagConstraints();
			gbc_textFieldIdPuerto.fill = GridBagConstraints.NONE;
			gbc_textFieldIdPuerto.gridy = 0;
			gbc_textFieldIdPuerto.weightx = 1.0;
			gbc_textFieldIdPuerto.insets = new Insets(5, 5, 5, 0);
			gbc_textFieldIdPuerto.gridwidth = 1;
			gbc_textFieldIdPuerto.ipadx = 60;
			gbc_textFieldIdPuerto.anchor = GridBagConstraints.WEST;
			gbc_textFieldIdPuerto.gridx = 1;
			jContentPane = new JPanel();
			GridBagLayout gbl_jContentPane = new GridBagLayout();
			gbl_jContentPane.rowWeights = new double[] { 0.0, 0.0, 0.0 };
			gbl_jContentPane.columnWeights = new double[] { 1.0, 0.0 };
			jContentPane.setLayout(gbl_jContentPane);
			jContentPane.add(getTextFieldIdPuerto(), gbc_textFieldIdPuerto);
			jContentPane.add(getJPanelEnviar(), gbc_jPanelEnviar);
			jContentPane.add(jLabel, gridBagConstraints3);
			jContentPane.add(getJPanelRecibir(), gbc_jPanelRecibir);
		}
		return jContentPane;
	}

	private JTextArea getTextAreaLogEnvio() {
		if (textAreaLogEnvio == null) {
			textAreaLogEnvio = new JTextArea();
		}
		return textAreaLogEnvio;
	}

	private JTextArea getTextAreaLogRecepcion() {
		if (textAreaLogRecepcion == null) {
			textAreaLogRecepcion = new JTextArea();
		}
		return textAreaLogRecepcion;
	}

	public PuertoSerialController getController() {
		return controller;
	}

	public void setController(PuertoSerialController controller) {
		this.controller = controller;
	}

	private JScrollPane getScrollPaneEnviar() {
		if (scrollPaneEnviar == null) {
			scrollPaneEnviar = new JScrollPane(getTextAreaLogEnvio());
		}
		return scrollPaneEnviar;
	}

	private JScrollPane getScrollPaneRecibir() {
		if (scrollPaneRecibir == null) {
			scrollPaneRecibir = new JScrollPane(getTextAreaLogRecepcion());
		}
		return scrollPaneRecibir;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
