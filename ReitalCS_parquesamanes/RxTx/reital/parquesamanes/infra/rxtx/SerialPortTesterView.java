package reital.parquesamanes.infra.rxtx;

import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

public class SerialPortTesterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonAbrir = null;
	private SerialPortModel model = null;  //  @jve:decl-index=0:
	private JTextField jTextFieldPuertoCOM = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JTextField jTextFieldOpenChar = null;
	private boolean portInited = false;
	private JPanel jPanelCerrar = null;
	private JButton jButtonCerrar = null;
	private JTextField jTextFieldCloseChar = null;
	/**
	 * This method initializes jButtonAbrir
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAbrir() {
		if (jButtonAbrir == null) {
			jButtonAbrir = new JButton();
			jButtonAbrir.setText("Enviar cadena >>");
			jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrir();
				}
			});
		}
		return jButtonAbrir;
	}

	/**
	 * This method initializes jTextFieldPuertoCOM
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPuertoCOM() {
		if (jTextFieldPuertoCOM == null) {
			jTextFieldPuertoCOM = new JTextField();
			jTextFieldPuertoCOM.setText("COM1");
		}
		return jTextFieldPuertoCOM;
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.insets = new Insets(5, 1, 5, 5);
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.gridy = 0;
			gridBagConstraints41.ipadx = 60;
			gridBagConstraints41.weightx = 1.0;
			gridBagConstraints41.weighty = 1.0;
			gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.insets = new Insets(5, 5, 5, 1);
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "ABRIR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213)));
			jPanel1.add(getJButtonAbrir(), gridBagConstraints);
			jPanel1.add(getJTextFieldOpenChar(), gridBagConstraints41);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jTextFieldOpenChar
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldOpenChar() {
		if (jTextFieldOpenChar == null) {
			jTextFieldOpenChar = new JTextField();
			jTextFieldOpenChar.setText("A");
			jTextFieldOpenChar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrir();
				}
			});
		}
		return jTextFieldOpenChar;
	}

	/**
	 * This method initializes jPanelCerrar
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelCerrar() {
		if (jPanelCerrar == null) {
			GridBagConstraints gridBagConstraints411 = new GridBagConstraints();
			gridBagConstraints411.anchor = GridBagConstraints.WEST;
			gridBagConstraints411.insets = new Insets(5, 1, 5, 5);
			gridBagConstraints411.gridx = 1;
			gridBagConstraints411.gridy = 0;
			gridBagConstraints411.ipadx = 60;
			gridBagConstraints411.weightx = 1.0;
			gridBagConstraints411.weighty = 1.0;
			gridBagConstraints411.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 0;
			gridBagConstraints2.weightx = 0.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.insets = new Insets(5, 5, 5, 1);
			jPanelCerrar = new JPanel();
			jPanelCerrar.setLayout(new GridBagLayout());
			jPanelCerrar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "CERRAR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213)));
			jPanelCerrar.add(getJButtonCerrar(), gridBagConstraints2);
			jPanelCerrar.add(getJTextFieldCloseChar(), gridBagConstraints411);
		}
		return jPanelCerrar;
	}

	/**
	 * This method initializes jButtonCerrar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setText("Enviar cadena >>");
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cerrar();
				}
			});
		}
		return jButtonCerrar;
	}

	/**
	 * This method initializes jTextFieldCloseChar
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCloseChar() {
		if (jTextFieldCloseChar == null) {
			jTextFieldCloseChar = new JTextField();
			jTextFieldCloseChar.setText("B");
			jTextFieldCloseChar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cerrar();
				}
			});
		}
		return jTextFieldCloseChar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException exc) {
			exc.getMessage();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SerialPortTesterView thisClass = new SerialPortTesterView();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setLocation(100,100);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public SerialPortTesterView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(418, 278);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("SerialPortTesterView - efren");
		/**
		 *
		 */
		try {
			this.model = new SerialPortModel();
		} catch (Exception exc) {
			exc.getMessage();
		}
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridy = 3;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("Puerto:");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridwidth = 2;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.weighty = 1.0;
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.ipadx = 60;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.gridx = 1;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJTextFieldPuertoCOM(), gridBagConstraints1);
			jContentPane.add(getJPanel1(), gridBagConstraints21);
			jContentPane.add(jLabel, gridBagConstraints3);
			jContentPane.add(getJPanelCerrar(), gridBagConstraints5);
		}
		return jContentPane;
	}
	/**
	 *
	 */
	private void abrir() {
		if (!this.portInited) {
			initPortModel();
			this.portInited = true;
		}
		try {
			this.model.enviarCaracter(getJTextFieldOpenChar().getText().trim());
			getJTextFieldPuertoCOM().setEditable(false);
		} catch (Throwable texc) {
			JOptionPane.showMessageDialog(this, "Error: "+texc.getMessage());
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 */
	private void cerrar() {
		if (!this.portInited) {
			initPortModel();
			this.portInited = true;
		}
		try {
			this.model.enviarCaracter(getJTextFieldCloseChar().getText().trim());
			getJTextFieldPuertoCOM().setEditable(false);
		} catch (Throwable texc) {
			JOptionPane.showMessageDialog(this, "Error: "+texc.getMessage());
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	private void initPortModel() {
		try {
			this.model.initializePortModel(getJTextFieldPuertoCOM().getText().trim());
		} catch (SerialPortException e1) {
			JOptionPane.showMessageDialog(this, "ERROR AL INICIALIZAR EL PUERTO "+getJTextFieldPuertoCOM().getText().trim()+" ["+e1.getMessage()+"]");
			System.exit(-1);
		} catch (PortInUseException e1) {
			JOptionPane.showMessageDialog(this, "ERROR: EL PUERTO "+getJTextFieldPuertoCOM().getText().trim()+" ESTA OCUPADO ["+e1.getMessage()+"]");
			System.exit(-1);
		} catch (UnsupportedCommOperationException e1) {
			JOptionPane.showMessageDialog(this, "ERROR: OPERACION NO SOPORTADA POR EL PUERTO "+getJTextFieldPuertoCOM().getText().trim()+" ["+e1.getMessage()+"]");
			System.exit(-1);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "ERROR DE ESCRITURA EN EL PUERTO "+getJTextFieldPuertoCOM().getText().trim()+" ["+e1.getMessage()+"]");
			System.exit(-1);
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
