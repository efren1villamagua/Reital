package efren.seguridades.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.config.SystemProperties;
import efren.util.gui.LabelExt;
import efren.util.gui.bars.BarraAceptarCancelarPanel;
import efren.util.gui.bars.BarraAceptarCancelarPanelListener;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.filechooser.FileChooserPanel;
import efren.util.gui.panels.PanelExtLogin;
import efren.util.gui.text.PasswordFieldExt;
import efren.util.gui.text.TextFieldExt;

public class AccesoView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2007170588795587029L;

	/**
	 *
	 */
	protected transient java.beans.PropertyChangeSupport propertyChange;

	private TextFieldExt ivjTextFieldExtUsuario = null;

	private PasswordFieldExt passwordFieldExtClave = null;

	private JPanel ivjJPanel1 = null;

	private LabelExt ivjLabelExt2 = null;

	private LabelExt ivjLabelExt3 = null;

	private JFrame jFrameConfiguration = null;

	private JPanel jContentPane = null;

	private FileChooserPanel fileChooserPanel = null;

	private BarraAceptarCancelarPanel barraAceptarCancelarPanel = null;

	private JButton jButtonAceptar = null;

	private JWindow waitingWindowTemp = null;

	private JPanel jPanel = null;

	private AccesoController controller = null; // @jve:decl-index=0:

	/**
	 *
	 */
	public AccesoView() {
		this(true);
	}

	/**
	 *
	 */
	public AccesoView(boolean initWindow) {
		super();
		initialize();
		if (initWindow) {
			AccesoController.initializeWindow(this);
		}
	}

	/**
	 * CLASE PRINCIPAL. DE ACCESO AL SISTEMA
	 *
	 */
	public static void main(java.lang.String[] args) {
		AccesoController.mainInit(args);
	}

	/**
	 *
	 *
	 */
	private void _aceptar() {
		try {
			Thread hilo1 = new Thread(new Runnable() {
				public void run() {
					visualManageStart();
					String userName = getTextFieldExtUsuario().getValue();
					String password = getPasswordFieldExtClave().getValue();
					getController().crearSistema(userName, password);
					visualManageStop();
				}
			});
			hilo1.start();
		} catch (Throwable t) {
			t.getMessage();
			visualManageStop();
		}
	}

	/**
	 *
	 *
	 */
	private void _cerrar() {

		if (InfoView.showConfirmDialog(this, "¿ Está seguro de SALIR DEL SISTEMA ?", "Seleccione una opción", InfoView.YES_NO_OPTION) != 0) {
			return;
		}

		SystemObserver.singleton().clear();
		dispose();
		System.exit(0);
	}

	/**
	 * Return the JPanel1 property value.
	 * 
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			try {
				GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
				gridBagConstraints11.gridx = 0;
				gridBagConstraints11.weightx = 1.0D;
				gridBagConstraints11.anchor = GridBagConstraints.EAST;
				gridBagConstraints11.gridy = 4;
				ivjJPanel1 = new PanelExtLogin();
				ivjJPanel1.setName("JPanel1");
				ivjJPanel1.setLayout(new java.awt.GridBagLayout());
				ivjJPanel1.setBackground(java.awt.Color.white);

				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridheight = 2;
				gridBagConstraints.insets = new Insets(1, 1, 1, 1);
				gridBagConstraints.fill = GridBagConstraints.NONE;
				gridBagConstraints.weightx = 1.0D;
				gridBagConstraints.anchor = GridBagConstraints.WEST;
				gridBagConstraints.gridy = 3;

				ivjJPanel1.add(getJButtonAceptar(), gridBagConstraints);
				ivjJPanel1.add(getJPanel(), gridBagConstraints11);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjJPanel1;
	}

	/**
	 * Return the LabelExt2 property value.
	 * 
	 * @return LabelExt
	 */
	private LabelExt getLabelExt2() {
		if (ivjLabelExt2 == null) {
			try {
				ivjLabelExt2 = new LabelExt();
				ivjLabelExt2.setName("LabelExt2");
				ivjLabelExt2.setDisplayedMnemonic('u');
				ivjLabelExt2.setText("Usuario");
				ivjLabelExt2.setForeground(new Color(0, 78, 152));
				ivjLabelExt2.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
				ivjLabelExt2.setHorizontalAlignment(SwingConstants.RIGHT);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjLabelExt2;
	}

	/**
	 * Return the LabelExt3 property value.
	 * 
	 * @return LabelExt
	 */
	private LabelExt getLabelExt3() {
		if (ivjLabelExt3 == null) {
			try {
				ivjLabelExt3 = new LabelExt();
				ivjLabelExt3.setName("LabelExt3");
				ivjLabelExt3.setDisplayedMnemonic('c');
				ivjLabelExt3.setText("Clave");
				ivjLabelExt3.setForeground(new Color(0, 78, 152));
				ivjLabelExt3.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
				ivjLabelExt3.setHorizontalAlignment(SwingConstants.RIGHT);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjLabelExt3;
	}

	/**
	 * Return the TextFieldExtUsuario property value.
	 * 
	 * @return TextFieldExt
	 */
	private TextFieldExt getTextFieldExtUsuario() {
		if (ivjTextFieldExtUsuario == null) {
			ivjTextFieldExtUsuario = new TextFieldExt();
			ivjTextFieldExtUsuario.setName("TextFieldExtUsuario");
			ivjTextFieldExtUsuario.setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
			ivjTextFieldExtUsuario.setFocusAccelerator('u');
			ivjTextFieldExtUsuario.setMaxLength(20);
			ivjTextFieldExtUsuario.addTextFieldExtListener(new efren.util.gui.text.TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					getPasswordFieldExtClave().requestFocus();
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}
			});
		}
		return ivjTextFieldExtUsuario;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, true, this, exception);
	}

	/**
	 * Initialize the class.
	 */
	private void initialize() {
		try {
			try {
				getTextFieldExtUsuario().setVisible(false);
				getPasswordFieldExtClave().setVisible(false);
			} catch (Exception e1) {
				e1.getMessage();
			}
			this.setContentPane(getJPanel1());
			setName("AccesoView");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setTitle("Ingreso a los sistemas");
			this.setContentPane(getJPanel1());
			setResizable(false);
			this.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					try {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								try {
									Thread.sleep(1500);
								} catch (Throwable t2) {
									t2.getMessage();
								}
								getTextFieldExtUsuario().setVisible(true);
								getPasswordFieldExtClave().setVisible(true);
								try {
									getController().getSplashWindow().dispose();
								} catch (Exception e) {
									e.getMessage();
								}
								getTextFieldExtUsuario().requestFocus();
							}
						});
					} catch (Throwable t) {
						t.getMessage();
					}
				}

				public void windowClosing(WindowEvent e) {
					_cerrar();
				}
			});
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 *
	 * @return
	 */
	public JFrame getJFrameConfiguration() {
		if (jFrameConfiguration == null) {
			JFrame frameConfiguration = new JFrame();
			frameConfiguration.setTitle("Selección de un archivo de configuración");
			frameConfiguration.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/efren/resources/images/cubos.png")));
			frameConfiguration.setContentPane(getJContentPane());
			frameConfiguration.setSize(500, 170);
			frameConfiguration.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			jFrameConfiguration = frameConfiguration;
			jFrameConfiguration.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					_cerrarConfigurationFileFrame();
				}
			});
		}
		return jFrameConfiguration;
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new java.awt.GridBagLayout());
			java.awt.GridBagConstraints consGridBagConstraints2 = new java.awt.GridBagConstraints();
			consGridBagConstraints2.fill = java.awt.GridBagConstraints.NONE;
			consGridBagConstraints2.weighty = 1.0;
			consGridBagConstraints2.weightx = 1.0;
			consGridBagConstraints2.gridy = 1;
			consGridBagConstraints2.gridx = 0;
			consGridBagConstraints2.insets = new java.awt.Insets(5, 5, 5, 5);
			jContentPane.add(getBarraAceptarCancelarPanelSistemaAdministracion(), consGridBagConstraints2);
			java.awt.GridBagConstraints consGridBagConstraints5 = new java.awt.GridBagConstraints();
			consGridBagConstraints5.fill = java.awt.GridBagConstraints.BOTH;
			consGridBagConstraints5.weighty = 1.0;
			consGridBagConstraints5.weightx = 1.0;
			consGridBagConstraints5.gridy = 0;
			consGridBagConstraints5.gridx = 0;
			consGridBagConstraints5.insets = new java.awt.Insets(5, 5, 5, 5);
			jContentPane.add(getFileChooserPanel(), consGridBagConstraints5);
		}
		return jContentPane;
	}

	/**
	 * This method initializes fileChooserPanel
	 *
	 * @return FileChooserPanel
	 */
	private FileChooserPanel getFileChooserPanel() {
		if (fileChooserPanel == null) {
			fileChooserPanel = new FileChooserPanel();
			fileChooserPanel.setTitulo("Escoja un archivo de configuración");
			fileChooserPanel.setFileExtension("PROPERTIES");
			fileChooserPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("selectedFile"))) {
						if (fileChooserPanel.getSelectedFile() != null)
							getController().setInner_nombreArchivoConfiguracion(fileChooserPanel.getSelectedFile().toString());
					}
					if ((e.getPropertyName().equals("fileChanged"))) {
						if (fileChooserPanel.getSelectedFile() != null)
							getController().setInner_nombreArchivoConfiguracion(fileChooserPanel.getSelectedFile().toString());
					}
				}
			});
		}
		return fileChooserPanel;
	}

	/**
	 *
	 */
	public FileChooserPanel getFileChooser() {
		return getFileChooserPanel();
	}

	/**
	 * This method initializes barraAceptarCancelarPanel
	 *
	 * @return BarraAceptarCancelarPanel
	 */
	private BarraAceptarCancelarPanel getBarraAceptarCancelarPanelSistemaAdministracion() {
		if (barraAceptarCancelarPanel == null) {
			barraAceptarCancelarPanel = new BarraAceptarCancelarPanel();
			barraAceptarCancelarPanel.addBarraAceptarCancelarPanelListener(new BarraAceptarCancelarPanelListener() {
				public void aceptarClicked(java.util.EventObject e) {
					_aceptarConfigurationFileFrame();
				}

				public void cancelarClicked(java.util.EventObject e) {
					_cerrarConfigurationFileFrame();
				}
			});
		}
		return barraAceptarCancelarPanel;
	}

	/**
	 *
	 */
	private void visualManageStart() {
		getJButtonAceptar().setEnabled(false);
		getTextFieldExtUsuario().setEnabled(false);
		getPasswordFieldExtClave().setEnabled(false);
		this.waitingWindowTemp = WindowManager.splashScreenForWaiting(this);
	}

	/**
	 *
	 *
	 */
	private void visualManageStop() {
		getTextFieldExtUsuario().setValue("");
		getPasswordFieldExtClave().setValue("");
		getJButtonAceptar().setEnabled(true);
		getTextFieldExtUsuario().setEnabled(true);
		getPasswordFieldExtClave().setEnabled(true);
		getTextFieldExtUsuario().requestFocus();
		try {
			this.waitingWindowTemp.dispose();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/next1.png")));
			jButtonAceptar.setOpaque(false);
			jButtonAceptar.setContentAreaFilled(false);
			jButtonAceptar.setBorderPainted(false);
			jButtonAceptar.setBorder(null);
			jButtonAceptar.setMargin(new Insets(0, 0, 0, 0));
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					_aceptar();
				}
			});
			jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonAceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes passwordFieldExtClave
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	private PasswordFieldExt getPasswordFieldExtClave() {
		if (passwordFieldExtClave == null) {
			passwordFieldExtClave = new PasswordFieldExt();
			passwordFieldExtClave.setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
			passwordFieldExtClave.setFocusAccelerator('c');
			passwordFieldExtClave.setEchoChar(' ');
			passwordFieldExtClave.setMaxLength(20);
			passwordFieldExtClave.addPasswordFieldExtListener(new efren.util.gui.text.PasswordFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					_aceptar();
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void passwordFieldExtkeyReleased(java.util.EventObject e) {
				}
			});
		}
		return passwordFieldExtClave;
	}

	/**
	 *
	 */
	private void _cerrarConfigurationFileFrame() {
		if (InfoView.showConfirmDialog(getJFrameConfiguration(), "¿ Está seguro de SALIR DEL SISTEMA ?", "Seleccione una opción",
				InfoView.YES_NO_OPTION) != 0) {
			return;
		}
		getJFrameConfiguration().setVisible(false);
		System.exit(0);
	}

	private void _aceptarConfigurationFileFrame() {
		try {
			if (fileChooserPanel.getSelectedFile() == null) {
				InfoView.showErrorDialog(getJFrameConfiguration(), "Seleccione un archivo de configuración");
				return;
			} else {
				getController().setInner_nombreArchivoConfiguracion(fileChooserPanel.getSelectedFile().toString());

				new File(getController().getInner_nombreArchivoConfiguracion());
				getJFrameConfiguration().setVisible(false);

				AccesoView aAccesoView = new AccesoView(false);

				SystemProperties.initialize(getController().getInner_nombreArchivoConfiguracion());

				AccesoController.initializeWindow(aAccesoView);

				SystemProperties.SCHEMA_PRINCIPAL = SystemProperties.SCHEMA_SEGURIDADES;
				SystemProperties.RUNTIME_SISTEMA_NAME = "Sistema de Administración (Seguridades+Reporteador)";

				aAccesoView.setTitle(SystemProperties.INSTITUCION_NOMBRE + " » " + SystemProperties.SERVER_NAME + " » " + SystemProperties.RUNTIME_SISTEMA_NAME
						+ " " + SystemProperties.SISTEMA_VERSION);
				aAccesoView.setVisible(true);
				aAccesoView.toFront();
			}
		} catch (Throwable ex) {
			InfoView.showErrorDialog(getJFrameConfiguration(), ex.getMessage());
			System.exit(1);// terminación anómala
		}
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0D;
			gridBagConstraints4.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 1.0D;
			gridBagConstraints3.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 100;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.ipady = 2;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints2.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 100;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.ipady = 2;
			gridBagConstraints2.weighty = 0.0;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setOpaque(false);
			jPanel.add(getTextFieldExtUsuario(), gridBagConstraints2);
			jPanel.add(getPasswordFieldExtClave(), gridBagConstraints1);
			jPanel.add(getLabelExt2(), gridBagConstraints3);
			jPanel.add(getLabelExt3(), gridBagConstraints4);
		}
		return jPanel;
	}

	public AccesoController getController() {
		if (this.controller == null) {
			this.controller = new AccesoController(this);
		}
		return this.controller;
	}

	public void setController(AccesoController controller) {
		this.controller = controller;
	}
} // @jve:decl-index=0:visual-constraint="59,55"
