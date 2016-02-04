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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Locale;

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
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.util.CalendarManager;
import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import reital.parquesamanes.app.ioc.DIConfiguration;
import reital.parquesamanes.app.ioc.SpringInitializator;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.infra.BarreraTools;
import reital.parquesamanes.infra.DBConnectionModel;
import reital.parquesamanes.infra.ParqueSamanesConn;

public class ExitView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2341181340219259L;

	private JPanel jPanel4 = null;
	private JLabel labelEntradaValue = null;
	private JLabel labelSalidaValue = null;
	private JPasswordField jPasswordFieldData = null;
	private JLabel jLabelRegistroEntrada1 = null;
	private JLabel jLabelRegistroSalida1 = null;
	private JPanel jPanel1 = null;
	private JButton jButtonReiniciar = null;
	private JPanel jPanel2 = null;
	private JLabel jLabelStatus = null;
	private JLabel labelBarId;
	private JLabel labelBarIdValue;
	private InformationPanel informationPanel;
	private ActividadRepository actividadRepository;

	public static void main(String args[]) {
		try {
			LoggerManager.init(ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "_" + ExitView.class.getSimpleName());
			SystemLogManager.setLogger(LoggerManager.logger);
		} catch (Exception e) {
			e.getMessage();
		}
		Locale.setDefault(new Locale("es", "ES"));
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());

			ExitView ventana = new ExitView();

			ventana.setResizable(false);
			ventana.setVisible(true);
			ventana.toFront();

		} catch (Throwable exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace(System.out);
			System.exit(1);
		}
	}

	public ExitView() throws HeadlessException {
		super();
		initialize();
	}

	public ExitView(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public ExitView(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public ExitView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(0);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/CLOCK_16_hot.png")));
		setTitle("Reital Parking - " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "- [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		setContentPane(getJPanel4());
		setSize(637, 445);
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

		setActividadRepository(new DIConfiguration().getActividadRepository());

		try {
			ParqueSamanesConstantes.setInitialValues();
			ParqueSamanesConstantes.cargarPropiedades();
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			DBConnectionModel.setSQLConnection(false);
		} catch (Exception e1) {
			e1.printStackTrace();
			InfoView.showErrorDialog(this, "ERROR: " + e1.getMessage());
			System.exit(1);
		}

		initializarFoco();
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

	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.gridwidth = 2;
			gridBagConstraints7.anchor = GridBagConstraints.NORTH;
			gridBagConstraints7.gridy = 3;
			jLabelStatus = new JLabel();
			jLabelStatus.setText("...");
			jLabelStatus.setForeground(Color.blue);
			jLabelStatus.setFont(new Font("Arial Black", Font.BOLD, 36));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.gridy = 5;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridwidth = 2;
			gridBagConstraints13.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(2, 2, 5, 0);
			gridBagConstraints13.gridy = 4;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints2.insets = new Insets(2, 5, 5, 5);
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridy = 2;
			jLabelRegistroSalida1 = new JLabel();
			jLabelRegistroSalida1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroSalida1.setText("Salida:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints1.insets = new Insets(2, 5, 5, 5);
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridy = 1;
			jLabelRegistroEntrada1 = new JLabel();
			jLabelRegistroEntrada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jLabelRegistroEntrada1.setText("Entrada:");

			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			jPanel4 = new JPanel();
			GridBagLayout gbl_jPanel4 = new GridBagLayout();
			gbl_jPanel4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
			gbl_jPanel4.columnWeights = new double[] { 1.0, 0.0 };
			jPanel4.setLayout(gbl_jPanel4);
			jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			gridBagConstraints52.gridx = 1;
			gridBagConstraints52.gridy = 1;
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.gridy = 2;
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
			gbc_labelBarId.gridy = 0;
			jPanel4.add(getLabelBarId(), gbc_labelBarId);
			GridBagConstraints gbc_labelBarIdValue = new GridBagConstraints();
			gbc_labelBarIdValue.weighty = 1.0;
			gbc_labelBarIdValue.weightx = 1.0;
			gbc_labelBarIdValue.anchor = GridBagConstraints.WEST;
			gbc_labelBarIdValue.insets = new Insets(5, 5, 5, 0);
			gbc_labelBarIdValue.gridx = 1;
			gbc_labelBarIdValue.gridy = 0;
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
			gbc_informationPanel.gridy = 6;
			jPanel4.add(getInformationPanel(), gbc_informationPanel);
			jPanel4.add(getJPanel1(), gridBagConstraints13);
			jPanel4.add(getJPanel2(), gridBagConstraints6);
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
			try {
				dispose();
			} catch (Exception exc) {
				SystemLogManager.error(exc);
			}
			try {
				if (ParqueSamanesConn.getConnection() != null) {
					ParqueSamanesConn.getConnection().close();
				}
			} catch (Exception exc) {
				SystemLogManager.error(exc);
			}
			try {
				SpringInitializator.getSingleton().destroy();
			} catch (Exception exc) {
				SystemLogManager.error(exc);
			}
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

		jLabelStatus.setText("...");
	}

	/**
	 *
	 */
	protected JPasswordField getJPasswordFieldData() {
		if (jPasswordFieldData == null) {
			jPasswordFieldData = new JPasswordField();
			jPasswordFieldData.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					getJPanel4().setBackground(Color.GREEN);
				}

				@Override
				public void focusLost(FocusEvent e) {
					getJPanel4().setBackground(Color.RED);
				}
			});
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
		if (longitud == ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_LENGTH) {
			getJPasswordFieldData().setEnabled(false);
			getJButtonReiniciar().setEnabled(true);
			/**
			 *
			 */
			String barAndCode = null;
			int barId = 0;
			String entradaStr = null;
			String salidaStr = null;
			String salidaMessage = null;

			boolean salidaOk = false;

			try {
				String secuenciaCaracteres = "";
				for (int i = 0; i < getJPasswordFieldData().getPassword().length; i++) {
					secuenciaCaracteres = secuenciaCaracteres + String.valueOf(getJPasswordFieldData().getPassword()[i]);
				}

				ActividadForPagoEntity actividadEntity = getActividadRepository().getActividad(secuenciaCaracteres);

				if (actividadEntity == null) {
					barAndCode = "ERROR_1";
					entradaStr = "ERROR_1";
					salidaStr = "ERROR_1";
					salidaMessage = "ERROR_1";
				} else {

					barId = actividadEntity.getBarraId();

					switch (actividadEntity.getEstadoPago()) {
					case PAGADO:
					case PASE_LIBRE:
					case TIEMPO_GRACIA:
						barAndCode = actividadEntity.getCodigo();
						CalendarManager cmEntrada = new CalendarManager(actividadEntity.getEntrada());
						entradaStr = cmEntrada.getInternationalDateExpression() + "  hora: " + cmEntrada.getTimeExpression2();
						CalendarManager cmSalida = new CalendarManager(actividadEntity.getSalida());
						salidaStr = cmSalida.getInternationalDateExpression() + "  hora: " + cmSalida.getTimeExpression2();
						salidaMessage = "SALIDA OK.";

						salidaOk = true;

						break;
					default:
						barAndCode = actividadEntity.getCodigo();
						entradaStr = "ERROR_2";
						salidaStr = "ERROR_2";
						salidaMessage = "ERROR_2";
						break;
					}
				}

			} catch (Exception exc) {
				String errorMessage = exc.getMessage();
				barAndCode = "ERROR_3 " + errorMessage;
				entradaStr = "ERROR_3 " + errorMessage;
				salidaStr = "ERROR_3 " + errorMessage;
				salidaMessage = "ERROR_3 " + errorMessage;
			}

			getLabelBarIdValue().setText(barAndCode);
			getLabelEntradaValue().setText(entradaStr);
			getLabelSalidaValue().setText(salidaStr);
			jLabelStatus.setText(salidaMessage);

			SystemLogManager.debug("[" + barAndCode + "] " + salidaMessage);

			if (salidaOk) {
				try {

					new BarreraTools().abrirBarrera(barId);

				} catch (Throwable texc) {
					texc.getMessage();
				}
			}

			// esto se debe hacer de manera inmediata
			getJPasswordFieldData().setText("");
			getJPasswordFieldData().setEnabled(true);
			initializarFoco();

			if (salidaOk) {
				try {
					new Thread(new Runnable() {
						public void run() {
							// esperamos 1 segundo
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							getJButtonReiniciar().setEnabled(false);
							getLabelEntradaValue().setText("");
							getLabelSalidaValue().setText("");
							getLabelBarIdValue().setText("");
							jLabelStatus.setText("...");
						}
					}).start();
				} catch (Throwable texc) {
					texc.getMessage();
				}
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
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.insets = new Insets(2, 2, 2, 2);
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJPasswordFieldData(), gridBagConstraints);
		}
		return jPanel2;
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

	/**
	 * @return the actividadRepository
	 */
	public ActividadRepository getActividadRepository() {
		return actividadRepository;
	}

	/**
	 * @param actividadRepository
	 *            the actividadRepository to set
	 */
	public void setActividadRepository(ActividadRepository actividadRepository) {
		this.actividadRepository = actividadRepository;
	}
} // @jve:decl-index=0:visual-constraint="10,10"