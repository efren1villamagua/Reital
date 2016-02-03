package reital.parquesamanes._view.working;

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
import reital.parquesamanes._view.working.PagoHelper.CadenaPair;
import reital.parquesamanes.app.ioc.SpringInitializator;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class PagoView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2341181348290219259L;

	private JPanel jPanel4 = null;

	private JLabel labelEntradaValue = null;

	private JLabel labelSalidaValue = null;

	private JPasswordField jPasswordFieldData = null;

	private JLabel jLabelRegistroEntrada1 = null;

	private JLabel jLabelRegistroSalida1 = null;

	private JPanel jPanel1 = null;

	private JButton jButtonReiniciar = null;

	private PagoHelper pagoHelper = null; // @jve:decl-index=0:

	private JPanel jPanel2 = null;

	private JToolBar jToolBar = null;

	private JButton jButtonClientes = null;

	private JButton jButtonNoClientes = null;

	private JButton jButtonFuncionarios = null;

	private JLabel jLabelStatus = null;

	private JLabel labelBarId;

	private JLabel labelBarIdValue;
	private InformationPanel informationPanel;

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
		setTitle("Reital Parking - " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "- [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		setContentPane(getJPanel4());
		setSize(703, 494);
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

		getLabelEntradaValue().setFocusable(false);
		getLabelSalidaValue().setFocusable(false);
		getLabelBarIdValue().setFocusable(false);
		jLabelRegistroEntrada1.setFocusable(false);
		jLabelRegistroSalida1.setFocusable(false);
		jPanel4.setFocusable(false);

		getJButtonReiniciar().setEnabled(false);

		initHelper();

		getJButtonClientes().setEnabled(false);
		getJButtonNoClientes().setEnabled(false);
		getJButtonFuncionarios().setEnabled(false);

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
	private void initHelper() {
		setPagoHelper(new PagoHelper(this));
		ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = SpringInitializator.getSingleton().getPagoControllerBean()
				.getCantidadMinutosGracia();
	}

	/**
	 *
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.insets = new Insets(1, 5, 5, 0);
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.gridwidth = 2;
			gridBagConstraints7.anchor = GridBagConstraints.NORTH;
			gridBagConstraints7.gridy = 4;
			jLabelStatus = new JLabel();
			jLabelStatus.setText("...");
			jLabelStatus.setForeground(Color.blue);
			jLabelStatus.setFont(new Font("Arial Black", Font.BOLD, 36));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 0;
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
			gridBagConstraints6.gridy = 7;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridwidth = 2;
			gridBagConstraints13.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(2, 2, 5, 0);
			gridBagConstraints13.gridy = 6;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints2.insets = new Insets(2, 5, 5, 5);
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridy = 3;
			jLabelRegistroSalida1 = new JLabel();
			jLabelRegistroSalida1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroSalida1.setText("Salida:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints1.insets = new Insets(2, 5, 5, 5);
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridy = 2;
			jLabelRegistroEntrada1 = new JLabel();
			jLabelRegistroEntrada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroEntrada1.setText("Entrada:");

			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			jPanel4 = new JPanel();
			GridBagLayout gbl_jPanel4 = new GridBagLayout();
			gbl_jPanel4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 };
			gbl_jPanel4.columnWeights = new double[] { 1.0, 0.0 };
			jPanel4.setLayout(gbl_jPanel4);
			jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			gridBagConstraints52.gridx = 1;
			gridBagConstraints52.gridy = 2;
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.gridy = 3;
			gridBagConstraints52.anchor = 16;
			gridBagConstraints52.insets = new Insets(2, 1, 5, 0);
			gridBagConstraints52.fill = 2;
			gridBagConstraints52.weightx = 1.0D;
			gridBagConstraints52.weighty = 1.0D;
			gridBagConstraints61.insets = new Insets(2, 1, 5, 0);
			gridBagConstraints61.anchor = 18;
			gridBagConstraints61.fill = 2;
			gridBagConstraints61.weightx = 1.0D;
			gridBagConstraints61.weighty = 1.0D;
			GridBagConstraints gbc_labelBarId = new GridBagConstraints();
			gbc_labelBarId.weightx = 1.0;
			gbc_labelBarId.anchor = GridBagConstraints.EAST;
			gbc_labelBarId.insets = new Insets(5, 5, 5, 5);
			gbc_labelBarId.gridx = 0;
			gbc_labelBarId.gridy = 1;
			jPanel4.add(getLabelBarId(), gbc_labelBarId);
			GridBagConstraints gbc_labelBarIdValue = new GridBagConstraints();
			gbc_labelBarIdValue.weighty = 1.0;
			gbc_labelBarIdValue.weightx = 1.0;
			gbc_labelBarIdValue.anchor = GridBagConstraints.WEST;
			gbc_labelBarIdValue.insets = new Insets(5, 5, 5, 0);
			gbc_labelBarIdValue.gridx = 1;
			gbc_labelBarIdValue.gridy = 1;
			jPanel4.add(getLabelBarIdValue(), gbc_labelBarIdValue);
			jPanel4.add(getLabelEntradaValue(), gridBagConstraints52);
			jPanel4.add(getLabelSalidaValue(), gridBagConstraints61);
			jPanel4.add(jLabelRegistroEntrada1, gridBagConstraints1);
			jPanel4.add(jLabelRegistroSalida1, gridBagConstraints2);
			GridBagConstraints gbc_informationPanel = new GridBagConstraints();
			gbc_informationPanel.weightx = 1.0;
			gbc_informationPanel.gridwidth = 2;
			gbc_informationPanel.insets = new Insets(2, 2, 2, 2);
			gbc_informationPanel.fill = GridBagConstraints.BOTH;
			gbc_informationPanel.gridx = 0;
			gbc_informationPanel.gridy = 8;
			jPanel4.add(getInformationPanel(), gbc_informationPanel);
			jPanel4.add(getJPanel1(), gridBagConstraints13);
			jPanel4.add(getJPanel2(), gridBagConstraints6);
			jPanel4.add(getJToolBar(), gridBagConstraints4);
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
		getLabelEntradaValue().setText("");
		getLabelSalidaValue().setText("");
		getLabelBarIdValue().setText("");
		if (limpiarDataField) {
			getJPasswordFieldData().setText("");
		}
		getJPasswordFieldData().setEnabled(true);
		getJButtonReiniciar().setEnabled(false);

		getJButtonClientes().setEnabled(false);
		getJButtonNoClientes().setEnabled(false);
		getJButtonFuncionarios().setEnabled(false);

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
				CadenaPair cp = getPagoHelper().parseSecuenciaCaracteres(secuenciaCaracteres);
				getLabelBarIdValue().setText(cp.getBarraId());
				GregorianCalendar gcEntrada = cp.getCalendar();
				CalendarManager cmEntrada = new CalendarManager(gcEntrada);
				getLabelEntradaValue().setText(cmEntrada.getInternationalDateExpression() + "  hora: " + cmEntrada.getTimeExpression2());
				jLabelStatus.setText("TICKET LEIDO");
			} catch (Exception exc) {
				exc.getMessage();
				getLabelBarIdValue().setText("...");
				getLabelEntradaValue().setText("...");
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
	 * @return the pagoHelper
	 */
	public PagoHelper getPagoHelper() {
		return pagoHelper;
	}

	/**
	 * @param pagoHelper
	 *            the pagoHelper to set
	 */
	public void setPagoHelper(PagoHelper pagoHelper) {
		this.pagoHelper = pagoHelper;
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
			jButtonClientes.setText("CLIENTES");
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
			jButtonNoClientes.setText("NO CLIENTES");
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
			jButtonFuncionarios.setText("FUNCIONARIOS");
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
	 *
	 */
	private void registrarActividadCliente() {
		if (InfoView.showConfirmDialog(this, "Está seguro que desea registrar como CLIENTE " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + " ?",
				"CLIENTE " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + " ?", InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			return;
		}
		getPagoHelper().validarYCalcularPago(PagoHelper.TIPO_CLIENTE.CLIENTE, "-");
	}

	/**
	 *
	 */
	private void registrarActividadNoCliente() {
		if (InfoView.showConfirmDialog(this, "Está seguro que desea registrar como NO CLIENTE " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + " ?",
				"NO CLIENTE " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + " ?", InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			return;
		}
		getPagoHelper().validarYCalcularPago(PagoHelper.TIPO_CLIENTE.NO_CLIENTE, "-");
	}

	/**
	 *
	 */
	private void registrarActividadFuncionario() {
		String observaciones = InfoView.showInputDialog(this, "Ingrese los nombres del \"Pase libre\" (De 7 a 200 caracteres)", "\"Pase libre\"",
				InfoView.QUESTION_MESSAGE);
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
		getPagoHelper().validarYCalcularPago(PagoHelper.TIPO_CLIENTE.PASE_LIBRE, observaciones);
	}

	/**
	 *
	 */
	protected JLabel getJLabelStatus() {
		return jLabelStatus;
	}

	protected JLabel getLabelEntradaValue() {
		if (labelEntradaValue == null) {
			labelEntradaValue = new JLabel();
			labelEntradaValue.setText("...");
			labelEntradaValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return labelEntradaValue;
	}

	protected JLabel getLabelSalidaValue() {
		if (labelSalidaValue == null) {
			labelSalidaValue = new JLabel();
			labelSalidaValue.setText("...");
			labelSalidaValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return labelSalidaValue;
	}

	private JLabel getLabelBarId() {
		if (labelBarId == null) {
			labelBarId = new JLabel();
			labelBarId.setText("Barrera:");
			labelBarId.setFont(new Font("Tahoma", Font.PLAIN, 18));
			labelBarId.setFocusable(false);
		}
		return labelBarId;
	}

	protected JLabel getLabelBarIdValue() {
		if (labelBarIdValue == null) {
			labelBarIdValue = new JLabel();
			labelBarIdValue.setText("...");
			labelBarIdValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
			labelBarIdValue.setFocusable(false);
		}
		return labelBarIdValue;
	}

	private InformationPanel getInformationPanel() {
		if (informationPanel == null) {
			informationPanel = new InformationPanel();
		}
		return informationPanel;
	}
} // @jve:decl-index=0:visual-constraint="10,10"