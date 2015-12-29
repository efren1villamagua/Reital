package reital.parquesamanes.serialport.util;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class SerialPortTesterView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonAbrir1 = null;

	private SerialPortModel model = null; // @jve:decl-index=0:

	private JButton jButtonAbrir2 = null;

	/**
	 * This method initializes jButtonAbrir1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAbrir1() {
		if (jButtonAbrir1 == null) {
			jButtonAbrir1 = new JButton();
			jButtonAbrir1.setText("Abrir1");
			jButtonAbrir1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrir1();
				}
			});
		}
		return jButtonAbrir1;
	}

	/**
	 * This method initializes jButtonAbrir2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAbrir2() {
		if (jButtonAbrir2 == null) {
			jButtonAbrir2 = new JButton();
			jButtonAbrir2.setText("Abrir2");
			jButtonAbrir2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrir2();
				}
			});
		}
		return jButtonAbrir2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException exc) {
			exc.getMessage();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SerialPortTesterView thisClass = new SerialPortTesterView();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		try {
			ParqueSamanesConstantes.cargarPropiedades();
		} catch (Exception exc4) {
			exc4.getMessage();
		}
		this.setSize(292, 175);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle(ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " - Serial test");
		/**
		 *
		 */
		try {
			this.model = new SerialPortModel();
		} catch (Exception exc) {
			exc.getMessage();
		}
		try {
			this.model.initializePortModel();
		} catch (SerialPortException e1) {
			InfoView.showErrorDialog(this, "ERROR AL INICIALIZAR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			System.exit(-1);
		} catch (PortInUseException e1) {
			InfoView.showErrorDialog(this, "ERROR: EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " ESTA OCUPADO [" + e1.getMessage() + "]");
			System.exit(-1);
		} catch (UnsupportedCommOperationException e1) {
			InfoView.showErrorDialog(this,
					"ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			System.exit(-1);
		} catch (IOException e1) {
			InfoView.showErrorDialog(this, "ERROR DE ESCRITURA EN EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			System.exit(-1);
		}
		WindowManager2.centerWindow(this);
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(5, 20, 1, 5);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(5, 5, 1, 20);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJButtonAbrir1(), gridBagConstraints);
			jContentPane.add(getJButtonAbrir2(), gridBagConstraints2);
		}
		return jContentPane;
	}

	/**
	 *
	 */
	private void abrir1() {
		try {
			this.model.abrirSalida1();
		} catch (Throwable texc) {
			InfoView.showErrorDialog(this, "Error: " + texc.getMessage());
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
	private void abrir2() {
		try {
			this.model.abrirSalida2();
		} catch (Throwable texc) {
			InfoView.showErrorDialog(this, "Error: " + texc.getMessage());
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
