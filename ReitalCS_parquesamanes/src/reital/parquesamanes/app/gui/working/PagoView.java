package reital.parquesamanes.app.gui.working;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import efren.util.CalendarManager;
import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import reital.parquesamanes.app.gui.working.PagoController.CadenaPair;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class PagoView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2341181348290219259L;

	private JPanel jPanel4 = null;

	private JLabel jLabelRegistroEntrada = null;

	private JLabel jLabelRegistroSalida = null;

	private JPasswordField jPasswordFieldData = null;

	private JLabel jLabelRegistroEntrada1 = null;

	private JLabel jLabelRegistroSalida1 = null;

	private JPanel jPanel1 = null;

	private JButton jButtonReiniciar = null;

	private PagoController pagoController = null; // @jve:decl-index=0:

	private JPanel jPanel2 = null;

	private JToolBar jToolBar = null;

	private JButton jButtonClientes = null;

	private JButton jButtonNoClientes = null;

	private JButton jButtonFuncionarios = null;

	private JToolBar jToolBar1 = null;

	private JButton jButtonAbrirBarrera = null;

	private JLabel jLabelStatus = null;

	public PagoView() throws HeadlessException {
		super();
		initialize();
	}

	public PagoView(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public PagoView(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public PagoView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(0);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/CLOCK_16_hot.png")));
		setTitle("Reital Parking - " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "- [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		setContentPane(getJPanel4());
		setSize(703, 464);
		WindowManager2.centerWindow(this);
		// setResizable(false);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				initializarFoco();
			}

			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				initializarFoco();
			}
		});
		initializarFoco();

		jLabelRegistroEntrada.setFocusable(false);
		jLabelRegistroSalida.setFocusable(false);
		jLabelRegistroEntrada1.setFocusable(false);
		jLabelRegistroSalida1.setFocusable(false);
		jPanel4.setFocusable(false);

		getJButtonReiniciar().setEnabled(false);

		initController();

		getJButtonClientes().setEnabled(false);
		getJButtonNoClientes().setEnabled(false);
		getJButtonFuncionarios().setEnabled(false);

		getJButtonAbrirBarrera().setEnabled(false);

	}

	/**
	 *
	 */
	protected JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action actionListener = new AbstractAction() {
			private static final long serialVersionUID = -779084606118335329L;

			public void actionPerformed(ActionEvent actionEvent) {
				reinicializarVisual();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", actionListener);
		return rootPane;
	}

	/**
	 *
	 */
	private void initController() {
		PagoModel pagoModel = new PagoModel();
		setPagoController(new PagoController(this, pagoModel));
		ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = pagoModel.getMinutosGracia();
	}

	/**
	 *
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.gridwidth = 7;
			gridBagConstraints7.anchor = GridBagConstraints.NORTH;
			gridBagConstraints7.gridy = 7;
			jLabelStatus = new JLabel();
			jLabelStatus.setText("...");
			jLabelStatus.setForeground(Color.blue);
			jLabelStatus.setFont(new Font("Arial Black", Font.BOLD, 36));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints5.gridy = 8;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.insets = new Insets(30, 30, 30, 30);
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(20, 20, 20, 20);
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.gridy = 10;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridwidth = 2;
			gridBagConstraints13.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(2, 2, 2, 2);
			gridBagConstraints13.gridy = 9;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints2.insets = new Insets(2, 5, 1, 1);
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridy = 6;
			jLabelRegistroSalida1 = new JLabel();
			jLabelRegistroSalida1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroSalida1.setText("Salida:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints1.insets = new Insets(2, 5, 2, 1);
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridy = 5;
			jLabelRegistroEntrada1 = new JLabel();
			jLabelRegistroEntrada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroEntrada1.setText("Entrada:");
			jLabelRegistroSalida = new JLabel();
			jLabelRegistroEntrada = new JLabel();
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			gridBagConstraints52.gridx = 1;
			gridBagConstraints52.gridy = 5;
			jLabelRegistroEntrada.setText("...");
			jLabelRegistroEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.gridy = 6;
			jLabelRegistroSalida.setText("...");
			jLabelRegistroSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
			gridBagConstraints52.anchor = 16;
			gridBagConstraints52.insets = new Insets(2, 1, 2, 5);
			gridBagConstraints52.fill = 2;
			gridBagConstraints52.weightx = 1.0D;
			gridBagConstraints52.weighty = 1.0D;
			gridBagConstraints61.insets = new Insets(2, 1, 1, 5);
			gridBagConstraints61.anchor = 18;
			gridBagConstraints61.fill = 2;
			gridBagConstraints61.weightx = 1.0D;
			gridBagConstraints61.weighty = 1.0D;
			jPanel4.add(jLabelRegistroEntrada, gridBagConstraints52);
			jPanel4.add(jLabelRegistroSalida, gridBagConstraints61);
			jPanel4.add(jLabelRegistroEntrada1, gridBagConstraints1);
			jPanel4.add(jLabelRegistroSalida1, gridBagConstraints2);
			jPanel4.add(getJPanel1(), gridBagConstraints13);
			jPanel4.add(getJPanel2(), gridBagConstraints6);
			jPanel4.add(getJToolBar(), gridBagConstraints4);
			jPanel4.add(getJToolBar1(), gridBagConstraints5);
			jPanel4.add(jLabelStatus, gridBagConstraints7);
			jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					initializarFoco();
				}
			});
		}
		return jPanel4;
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
	protected void limpiarInformacionVisual(boolean limpiarDataField) {
		jLabelRegistroEntrada.setText("");
		jLabelRegistroSalida.setText("");
		if (limpiarDataField) {
			getJPasswordFieldData().setText("");
		}
		getJPasswordFieldData().setEnabled(true);
		getJButtonReiniciar().setEnabled(false);

		getJButtonClientes().setEnabled(false);
		getJButtonNoClientes().setEnabled(false);
		getJButtonFuncionarios().setEnabled(false);

		getJButtonAbrirBarrera().setEnabled(false);

		jLabelStatus.setText("...");
	}

	/**
	 *
	 */
	protected JPasswordField getJPasswordFieldData() {
		if (jPasswordFieldData == null) {
			jPasswordFieldData = new JPasswordField();
			jPasswordFieldData.setHorizontalAlignment(JTextField.CENTER);
			jPasswordFieldData.setFocusCycleRoot(true);
			jPasswordFieldData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manageEntradaTeclado();
				}
			});
			jPasswordFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					manageEntradaTeclado();
				}
			});
		}
		return jPasswordFieldData;
	}

	/**
	 *
	 */
	protected void initializarFoco() {
		getJPasswordFieldData().setText("");
		getJPasswordFieldData().requestFocus();
	}

	/**
	 *
	 */
	protected void mostrarError(String mensaje) {
		InfoView.showErrorDialog(this, mensaje);
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridy = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJButtonReiniciar(), gridBagConstraints3);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButtonReiniciar
	 *
	 * @return javax.swing.JButton
	 */
	protected JButton getJButtonReiniciar() {
		if (jButtonReiniciar == null) {
			jButtonReiniciar = new JButton();
			jButtonReiniciar.setMnemonic(KeyEvent.VK_I);
			jButtonReiniciar.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/flechamas.gif")));
			jButtonReiniciar.setText("Reiniciar");
			jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reinicializarVisual();
				}
			});
			jButtonReiniciar.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonReiniciar;
	}

	/**
	 *
	 */
	public void reinicializarVisual() {
		limpiarInformacionVisual(true);
		initializarFoco();
	}

	/**
	 *
	 */
	private void manageEntradaTeclado() {
		int longitud = getJPasswordFieldData().getPassword().length;
		if (longitud == ParqueSamanesConstantes.TICKET_BAR_CODE_LENGTH) {
			getJPasswordFieldData().setEnabled(false);
			getJButtonClientes().setEnabled(true);
			getJButtonNoClientes().setEnabled(true);
			getJButtonFuncionarios().setEnabled(true);
			getJButtonReiniciar().setEnabled(true);
			/**
			 *
			 */
			try {
				String secuenciaCaracteres = "";
				for (int i = 0; i < getJPasswordFieldData().getPassword().length; i++) {
					secuenciaCaracteres = secuenciaCaracteres + String.valueOf(getJPasswordFieldData().getPassword()[i]);
				}
				CadenaPair cp = getPagoController().parseSecuenciaCaracteres(secuenciaCaracteres);
				GregorianCalendar gcEntrada = cp.getCalendar();
				CalendarManager cmEntrada = new CalendarManager(gcEntrada);
				jLabelRegistroEntrada.setText(cmEntrada.getInternationalDateExpression() + "  hora: " + cmEntrada.getTimeExpression2());
				jLabelStatus.setText("TICKET LEIDO");
			} catch (Exception exc) {
				exc.getMessage();
				jLabelRegistroEntrada.setText("...");
				jLabelStatus.setText("ERROR LECTURA");
			}
		}
	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.insets = new Insets(2, 1, 2, 0);
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJPasswordFieldData(), gridBagConstraints);
		}
		return jPanel2;
	}

	/**
	 * @return the pagoController
	 */
	public PagoController getPagoController() {
		return pagoController;
	}

	/**
	 * @param pagoController
	 *            the pagoController to set
	 */
	public void setPagoController(PagoController pagoController) {
		this.pagoController = pagoController;
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonClientes());
			jToolBar.add(getJButtonNoClientes());
			jToolBar.add(getJButtonFuncionarios());
		}
		return jToolBar;
	}

	private JButton getJButtonClientes() {
		if (jButtonClientes == null) {
			jButtonClientes = new JButton();
			jButtonClientes.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/clientes.png")));
			jButtonClientes.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonClientes.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonClientes.setText("CLIENTES " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "");
			jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					registrarActividadCliente();
				}
			});
			jButtonClientes.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonClientes;
	}

	private JButton getJButtonNoClientes() {
		if (jButtonNoClientes == null) {
			jButtonNoClientes = new JButton();
			jButtonNoClientes.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/no_clientes.png")));
			jButtonNoClientes.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonNoClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonNoClientes.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonNoClientes.setMargin(new Insets(2, 44, 2, 14));
			jButtonNoClientes.setText("NO CLIENTES " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "");
			jButtonNoClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					registrarActividadNoCliente();
				}
			});
			jButtonNoClientes.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonNoClientes;
	}

	private JButton getJButtonFuncionarios() {
		if (jButtonFuncionarios == null) {
			jButtonFuncionarios = new JButton();
			jButtonFuncionarios.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/funcionarios.png")));
			jButtonFuncionarios.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonFuncionarios.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonFuncionarios.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonFuncionarios.setMargin(new Insets(2, 84, 2, 14));
			jButtonFuncionarios.setText("FUNCIONARIOS " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "");
			jButtonFuncionarios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					registrarActividadFuncionario();
				}
			});
			jButtonFuncionarios.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonFuncionarios;
	}

	/**
	 * This method initializes jToolBar1
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.setOpaque(false);
			jToolBar1.setFloatable(false);
			jToolBar1.add(getJButtonAbrirBarrera());
		}
		return jToolBar1;
	}

	/**
	 * This method initializes jButtonAbrirBarrera
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAbrirBarrera() {
		if (jButtonAbrirBarrera == null) {
			jButtonAbrirBarrera = new JButton();
			jButtonAbrirBarrera.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonAbrirBarrera.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/parking_barrier2.jpg")));
			jButtonAbrirBarrera.setText("ABRIR BARRERA");
			jButtonAbrirBarrera.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonAbrirBarrera.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonAbrirBarrera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrirBarrera();
				}
			});
			jButtonAbrirBarrera.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					((JButton) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonAbrirBarrera;
	}

	/**
	 *
	 */
	public void abrirBarrera() {
		getPagoController().enviarSenialAbrirBarrera();
		/**
		 * OJO TODO: HAY QUE MARCAR EL REGISTRO DE LA TABLA ACTIVIDAD COMO
		 * PROCESADO LUEGO DE ABRIR LA BARRERA
		 */
	}

	/**
	 *
	 */
	private void registrarActividadCliente() {
		if (InfoView.showConfirmDialog(this, "Está seguro que desea registrar como CLIENTE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " ?",
				"CLIENTE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " ?", InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			return;
		}
		getPagoController().validarYCalcularPago(PagoController.TIPO_CLIENTE.CLIENTE_ParqueSamanes, "-");
	}

	/**
	 *
	 */
	private void registrarActividadNoCliente() {
		if (InfoView.showConfirmDialog(this, "Está seguro que desea registrar como NO CLIENTE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " ?",
				"NO CLIENTE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " ?", InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			return;
		}
		getPagoController().validarYCalcularPago(PagoController.TIPO_CLIENTE.NO_CLIENTE_ParqueSamanes, "-");
	}

	/**
	 *
	 */
	private void registrarActividadFuncionario() {
		String observaciones = InfoView.showInputDialog(this,
				"Ingrese los nombres del FUNCIONARIO o SUPERVISOR DE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " (De 7 a 200 caracteres)",
				"FUNCIONARIO o SUPERVISOR DE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "", InfoView.QUESTION_MESSAGE);
		if (observaciones == null || observaciones.trim().length() == 0) {
			return;
		}
		observaciones = observaciones.trim();
		if (observaciones.length() < 7) {
			InfoView.showErrorDialog(this, "ERROR: Ingrese un registro de mímino 7 caracteres !");
			return;
		}
		if (observaciones.length() > 200) {
			observaciones = observaciones.substring(0, 200);
		}
		getPagoController().validarYCalcularPago(PagoController.TIPO_CLIENTE.FUNCIONARIO_ParqueSamanes, observaciones);
	}

	/**
	 *
	 */
	protected JLabel getJLabelStatus() {
		return jLabelStatus;
	}

	protected JLabel getJLabelRegistroEntrada() {
		return jLabelRegistroEntrada;
	}

	protected JLabel getJLabelRegistroSalida() {
		return jLabelRegistroSalida;
	}

} // @jve:decl-index=0:visual-constraint="10,10"