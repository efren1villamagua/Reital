package reital.parquesamanes.lector.gui.seguridades;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.seguridades.gui.UTILefrenView;
import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import reital.parquesamanes.infra.DBConnectionModel;
import reital.parquesamanes.lector.gui.working.UsuarioABMView;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class LogonToUsuariosView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -556079025843630131L;

	public static String usuario = null;

	private JPanel jContentPane = null;

	private JTextField jTextField = null;

	private JLabel jLabel = null;

	private JPasswordField jPasswordField = null;

	private JLabel jLabel1 = null;

	private JButton jButton = null;

	private JPanel jPanel = null;

	private JLabel jLabel3 = null;

	private JButton jButton1 = null;

	public LogonToUsuariosView() throws HeadlessException {
		super();
		initialize();
	}

	public LogonToUsuariosView(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public LogonToUsuariosView(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public LogonToUsuariosView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setFocusAccelerator('U');
			jTextField.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					getJPasswordField().requestFocus();
				}

			});
		}
		return jTextField;
	}

	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setFocusAccelerator('C');
			jPasswordField.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					accesar();
				}

			});
		}
		return jPasswordField;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Ingresar");
			jButton.setMnemonic(KeyEvent.VK_I);
			jButton.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/key1.png")));
			jButton.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					jButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accesar();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 3;
			gridBagConstraints.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridy = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 2;
			gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridy = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("");
			jLabel3.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/users128x128.png")));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.gridy = 2;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBackground(Color.white);
			jPanel.add(getJContentPane(), gridBagConstraints6);
			jPanel.add(jLabel3, gridBagConstraints11);
			jPanel.add(getJButton1(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setMnemonic(KeyEvent.VK_I);
			jButton1.setText("Encriptador");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/paquete.png")));
			jButton1.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					jButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarEncriptador();
				}
			});
		}
		return jButton1;
	}

	public static void main(String args[]) {
		Locale.setDefault(new Locale("es", "ES"));
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (Throwable exception) {
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LogonToUsuariosView thisClass = new LogonToUsuariosView();
				thisClass.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				thisClass.setResizable(false);
				thisClass.setVisible(true);
			}
		});
	}

	private void initialize() {
		this.setContentPane(getJPanel());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/users16x16.png")));
		setSize(429, 297);
		setTitle("Reital - " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " - Usuarios - [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		setResizable(false);
		WindowManager2.centerWindow(this);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			gridBagConstraints1.gridx = 3;
			gridBagConstraints1.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints1.ipadx = 150;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.weighty = 1.0D;
			gridBagConstraints1.insets = new Insets(0, 0, 2, 10);
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.insets = new Insets(0, 10, 2, 0);
			jLabel.setText("Usuario:");
			jLabel.setDisplayedMnemonic(85);
			gridBagConstraints3.gridx = 3;
			gridBagConstraints3.ipadx = 150;
			gridBagConstraints3.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0D;
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.weighty = 1.0D;
			gridBagConstraints3.insets = new Insets(2, 0, 0, 10);
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.insets = new Insets(2, 10, 0, 0);
			jLabel1.setText("Clave:");
			jLabel1.setDisplayedMnemonic(67);
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints5.anchor = GridBagConstraints.NORTH;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.weighty = 1.0D;
			gridBagConstraints5.gridwidth = 2;
			jContentPane.setBackground(Color.white);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(jLabel, gridBagConstraints2);
			jContentPane.add(getJPasswordField(), gridBagConstraints3);
			jContentPane.add(jLabel1, gridBagConstraints4);
			jContentPane.add(getJButton(), gridBagConstraints5);
		}
		return jContentPane;
	}

	/**
	 *
	 */
	private void accesar() {
		/**
		 *
		 */
		try {
			ParqueSamanesConstantes.setInitialValues();
			ParqueSamanesConstantes.cargarPropiedades();
		} catch (Exception e) {
			e.getMessage();
		}
		String userName = getJTextField().getText().trim();
		String key = "";
		for (int i = 0; i < getJPasswordField().getPassword().length; i++) {
			key = key + String.valueOf(getJPasswordField().getPassword()[i]);
		}
		LogonToUsuariosView.usuario = userName;

		boolean autenticado = DBConnectionModel.autenticar(userName, key);
		if (!autenticado) {
			InfoView.showErrorDialog(this, "¡ Usuario o clave incorrecta !");
			getJTextField().setText("");
			getJPasswordField().setText("");
			getJTextField().requestFocus();
			return;
		}
		/**
		 *
		 */
		UsuarioABMView ventana = new UsuarioABMView();
		// ventana.setResizable(false);
		ventana.setVisible(true);

		dispose();
	}

	/**
	 *
	 */
	private void cerrarVentana() {
		if (InfoView.showConfirmDialog(this, "Desea salir del sistema?") == 0) {
			dispose();
			System.exit(0);
		}
	}

	/**
	 *
	 */
	private void mostrarEncriptador() {
		UTILefrenView ventana = new UTILefrenView(false);
		ventana.setVisible(true);
	}
} // @jve:decl-index=0:visual-constraint="10,10"