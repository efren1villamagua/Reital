package reital.parquesamanes.lector.gui.working;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.gui.LabelExt;
import efren.util.gui.ProgressBarWithThreadPanel;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextDate;
import efren.util.reportes.DetallesImpresionPanel;
import efren.util.reportes.DetallesPresentacionPanel;
import efren.util.reportes.tools.TableModel;
import inetsoft.report.StyleFont;
import inetsoft.report.StyleSheet;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.infra.ReporterSQLClausesFactory;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class ReporterView extends DialogExt {
	/**
	 *
	 */
	private static final long serialVersionUID = 6626412806709886642L;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private JPanel ivjJFrameContentPane = null;

	private DetallesImpresionPanel ivjDetallesImpresionPanel1 = null;

	private DetallesPresentacionPanel ivjDetallesPresentacionPanel1 = null;

	private JTabbedPane ivjJTabbedPane1 = null;

	private JPanel ivjPageDetalles = null;

	private JPanel ivjPageImpresion = null;

	private LabelExt ivjLabelExt11 = null;

	private LabelExt ivjLabelExt3 = null;

	private ProgressBarWithThreadPanel ivjBarPanel = null;

	private JToolBar jToolBar = null;

	private JButton jButtonImprimir = null;

	private TextDate textDateDesde = null;

	private TextDate textDateHasta = null;

	private JTabbedPane jTabbedPanePrincipal = null;

	private JPanel jPanelOcupacionParqueadero = null;

	private JPanel jPanel2 = null;

	private JCheckBox jCheckBoxClientes = null;

	private JPanel jPanelTipoCliente = null;

	private JCheckBox jCheckBoxNoClientes = null;

	private JCheckBox jCheckBoxFuncionarios = null;

	private JPanel jPanelFuncionarios1 = null;

	private JTabbedPane ivjJTabbedPaneFuncionarios = null;

	private JPanel ivjPageDetallesFuncionarios = null;

	private DetallesPresentacionPanel ivjDetallesPresentacionPanelFuncionarios = null;

	private JPanel ivjPageImpresionFuncionarios = null;

	private DetallesImpresionPanel ivjDetallesImpresionPanelFuncionarios = null;

	private ProgressBarWithThreadPanel ivjBarPanelFuncionarios = null;

	private JToolBar jToolBarFuncionarios = null;

	private JButton jButtonImprimirFuncionarios = null;

	private JPanel jPanel21 = null;

	private LabelExt ivjLabelExt111 = null;

	private TextDate textDateDesdeFuncionarios = null;

	private LabelExt ivjLabelExt31 = null;

	private TextDate textDateHastaFuncionarios = null;

	private JPanel jPanelCriteriosBusquedaOcupacionParqueadero = null;

	private ReporterSQLClausesFactory sqlClausesFactory = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public ReporterView() {
		super();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent e) {
				cerrar();
			}
		});
		initialize();
	}

	public ReporterView(JFrame owner, boolean modal) {
		super(owner, modal);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent e) {
				cerrar();
			}
		});
		initialize();
	}

	/**
	 *
	 */
	private void construirReporteOcupacionParqueadero() {
		try {

			Date desde = getTextDateDesde().getValue();
			if (desde == null) {
				InfoView.showErrorDialog(this, "Seleccione una fecha desde");
				return;
			}
			Date hasta = getTextDateHasta().getValue();
			if (hasta == null) {
				InfoView.showErrorDialog(this, "Seleccione una fecha hasta");
				return;
			}
			if (!getJCheckBoxClientes().isSelected() && !getJCheckBoxNoClientes().isSelected() && !getJCheckBoxFuncionarios().isSelected()) {
				InfoView.showErrorDialog(this, "Escoja al menos un tipo de cliente");
				return;
			}

			Statement st = ParqueSamanesConn.getConnection().createStatement();
			String sql = getSqlClausesFactory().getSQLClause_OcupacionParqueadero(getTextDateDesde().getValue(), getTextDateHasta().getValue(),
					getJCheckBoxClientes().isSelected(), getJCheckBoxNoClientes().isSelected(), getJCheckBoxFuncionarios().isSelected());
			ResultSet rs = st.executeQuery(sql);

			/**
			 * construcción del reporte
			 */
			StyleSheet reporte = getDetallesPresentacionPanel1()._buildReport(rs, null, null, null, "DESDE: " + desde + "   HASTA: " + hasta, null);
			/**
			 * impresión del reporte
			 */
			getDetallesImpresionPanel1()._print(reporte, getDetallesPresentacionPanel1().papelSeleccionado(),
					getDetallesPresentacionPanel1().esOrientacionHorizontal(), getDetallesPresentacionPanel1().getTitulo1().trim());

			rs.close();
			st.close();
			/**
			 *
			 */
			_stop();
		} catch (Throwable t33) {
			InfoView.showErrorDialog(this, t33.getMessage());
			_stop();
		}
	}

	/**
	 *
	 */
	private void construirReporteFuncionarios() {
		try {

			Date desde = getTextDateDesdeFuncionarios().getValue();
			if (desde == null) {
				InfoView.showErrorDialog(this, "Seleccione una fecha desde");
				return;
			}
			Date hasta = getTextDateHastaFuncionarios().getValue();
			if (hasta == null) {
				InfoView.showErrorDialog(this, "Seleccione una fecha hasta");
				return;
			}

			Statement st = ParqueSamanesConn.getConnection().createStatement();
			String sql = getSqlClausesFactory().getSQLClause_Funcionarios(getTextDateDesde().getValue(), getTextDateHasta().getValue());
			ResultSet rs = st.executeQuery(sql);

			/**
			 * construcción del reporte
			 */
			StyleSheet reporte = getIvjDetallesPresentacionPanelFuncionarios()._buildReport(rs, null, null, null, "DESDE: " + desde + "   HASTA: " + hasta,
					null);
			/**
			 * impresión del reporte
			 */
			getIvjDetallesImpresionPanelFuncionarios()._print(reporte, getIvjDetallesPresentacionPanelFuncionarios().papelSeleccionado(),
					getIvjDetallesPresentacionPanelFuncionarios().esOrientacionHorizontal(), getIvjDetallesPresentacionPanelFuncionarios().getTitulo1().trim());

			rs.close();
			st.close();
			/**
			 *
			 */
			_stop();
		} catch (Throwable t33) {
			InfoView.showErrorDialog(this, t33.getMessage());
			_stop();
		}
	}

	public void _cerrar() {
		this.dispose();
	}

	private void _prePrint() {
		if (!validar())
			return;
		getJButtonImprimir().setEnabled(false);
		getBarPanel().start();
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				construirReporteOcupacionParqueadero();
			}
		});
		hilo.start();
	}

	private void _stop() {
		getBarPanel().stop();
		getJButtonImprimir().setEnabled(true);
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void cancelarClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Return the ProgressBarWithThreadPanel property value.
	 *
	 * @return ProgressBarWithThreadPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ProgressBarWithThreadPanel getBarPanel() {
		if (ivjBarPanel == null) {
			try {
				ivjBarPanel = new ProgressBarWithThreadPanel();
				ivjBarPanel.setName("BarPanel");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarPanel;
	}

	/**
	 * Return the DetallesImpresionPanel1 property value.
	 *
	 * @return efren.reportes.DetallesImpresionPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DetallesImpresionPanel getDetallesImpresionPanel1() {
		if (ivjDetallesImpresionPanel1 == null) {
			ivjDetallesImpresionPanel1 = new DetallesImpresionPanel();
			ivjDetallesImpresionPanel1.setName("DetallesImpresionPanel1");
			ivjDetallesImpresionPanel1.setTipoImpresion(DetallesImpresionPanel.PREVIEW);
		}
		return ivjDetallesImpresionPanel1;
	}

	/**
	 *
	 */
	private DetallesPresentacionPanel getDetallesPresentacionPanel1() {
		if (ivjDetallesPresentacionPanel1 == null) {
			ivjDetallesPresentacionPanel1 = new DetallesPresentacionPanel();
			ivjDetallesPresentacionPanel1.setName("DetallesPresentacionPanel1");
			ivjDetallesPresentacionPanel1.setScrollPaneTableVisible(true);
			ivjDetallesPresentacionPanel1.setExpress(false);
			ivjDetallesPresentacionPanel1.setFuente(new StyleFont(new Font("Arial", Font.PLAIN, 8)));
			ivjDetallesPresentacionPanel1._refrescarDetallesTabla(getSqlClausesFactory().getSQLClause_OcupacionParqueadero_OnlyHeaders());
			TableModel model = ivjDetallesPresentacionPanel1.getTableModel();
			/**
			 * COLUMNAS 0: Nombre SQL || 1: Nombre || 2: Ancho || 3: Quiebre ||
			 * 4: F. quiebre || 5: F. total || 6: Unidad || 7: Negritas || 8:
			 * Color
			 */
			model.setValueAt("Tipo cliente", 0, 1);
			model.setValueAt(150, 0, 2);
			model.setValueAt(new Boolean(true), 0, 3);
			model.setValueAt("Fecha", 1, 1);
			model.setValueAt(120, 1, 2);
			model.setValueAt("Hora entrada", 2, 1);
			model.setValueAt(120, 2, 2);
			model.setValueAt("CONTEO", 2, 4);
			model.setValueAt("CONTEO", 2, 5);
			model.setValueAt("Hora salida", 3, 1);
			model.setValueAt(120, 3, 2);
			model.setValueAt("Valor", 4, 1);
			model.setValueAt(100, 4, 2);
			model.setValueAt("SUMA", 4, 4);
			model.setValueAt("SUMA", 4, 5);
			model.setValueAt("$", 4, 6);
			model.setValueAt("Usuario", 5, 1);
			model.setValueAt(110, 5, 2);
			model.setValueAt("Tipo usr.", 6, 1);
			model.setValueAt("Observaciones", 7, 1);
			ivjDetallesPresentacionPanel1.setTitulo01(ParqueSamanesConstantes.EMPRESA_NOMBRE_01);
			ivjDetallesPresentacionPanel1.setTitulo02("Ocupación de parqueadero");
		}
		return ivjDetallesPresentacionPanel1;
	}

	/**
	 * Return the JFrameContentPane property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 1;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.gridwidth = 1;
			gridBagConstraints5.insets = new Insets(2, 2, 2, 2);
			gridBagConstraints5.gridx = 0;
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());
			ivjJFrameContentPane.add(getJTabbedPanePrincipal(), gridBagConstraints5);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the JTabbedPane1 property value.
	 *
	 * @return JTabbedPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JTabbedPane getJTabbedPane1() {
		if (ivjJTabbedPane1 == null) {
			ivjJTabbedPane1 = new JTabbedPane();
			ivjJTabbedPane1.setName("JTabbedPane1");
			ivjJTabbedPane1.setToolTipText("Reportes personalizados");
			ivjJTabbedPane1.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJTabbedPane1.insertTab("(4) Detalles de presentación", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")),
					getPageDetalles(), null, 0);
			ivjJTabbedPane1.insertTab("(6) Detalles de impresión", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.gif")),
					getPageImpresion(), null, 1);
			ivjJTabbedPane1.putClientProperty("pgs.isButtonStyle", Boolean.TRUE);
		}
		return ivjJTabbedPane1;
	}

	/**
	 * Return the PageDetalles property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageDetalles() {
		if (ivjPageDetalles == null) {
			try {
				ivjPageDetalles = new JPanel();
				ivjPageDetalles.setName("PageDetalles");
				ivjPageDetalles.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageDetalles.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesPresentacionPanel1 = new java.awt.GridBagConstraints();
				constraintsDetallesPresentacionPanel1.gridx = 0;
				constraintsDetallesPresentacionPanel1.gridy = 0;
				constraintsDetallesPresentacionPanel1.gridwidth = 5;
				constraintsDetallesPresentacionPanel1.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesPresentacionPanel1.weightx = 1.0;
				constraintsDetallesPresentacionPanel1.weighty = 1.0;
				constraintsDetallesPresentacionPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageDetalles().add(getDetallesPresentacionPanel1(), constraintsDetallesPresentacionPanel1);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageDetalles;
	}

	/**
	 * Return the PageImpresion property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageImpresion() {
		if (ivjPageImpresion == null) {
			try {
				ivjPageImpresion = new JPanel();
				ivjPageImpresion.setName("PageImpresion");
				ivjPageImpresion.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesImpresionPanel1 = new java.awt.GridBagConstraints();
				constraintsDetallesImpresionPanel1.gridx = 0;
				constraintsDetallesImpresionPanel1.gridy = 0;
				constraintsDetallesImpresionPanel1.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesImpresionPanel1.weightx = 1.0;
				constraintsDetallesImpresionPanel1.weighty = 1.0;
				constraintsDetallesImpresionPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageImpresion().add(getDetallesImpresionPanel1(), constraintsDetallesImpresionPanel1);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageImpresion;
	}

	/**
	 * Accessor for the propertyChange field.
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Return the LabelExt11 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt11() {
		if (ivjLabelExt11 == null) {
			try {
				ivjLabelExt11 = new LabelExt();
				ivjLabelExt11.setName("LabelExt11");
				ivjLabelExt11.setText("Desde:");
				ivjLabelExt11.setHorizontalAlignment(SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt11;
	}

	/**
	 * Return the LabelExt3 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt3() {
		if (ivjLabelExt3 == null) {
			try {
				ivjLabelExt3 = new LabelExt();
				ivjLabelExt3.setName("LabelExt3");
				ivjLabelExt3.setText("Hasta:");
				ivjLabelExt3.setHorizontalAlignment(SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt3;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		setName("DataTableReporterView");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(713, 614);
		setTitle("Reportes Parking - " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + " - [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		setContentPane(getJFrameContentPane());
		setResizable(true);
		setModal(true);
		WindowManager.centerWindow2(this);
		setSqlClausesFactory(new ReporterSQLClausesFactory());
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 *
	 */
	private boolean validar() {

		if (getTextDateDesde().isDataMissing("Seleccione una fecha de inicio !"))
			return false;
		if (getTextDateHasta().isDataMissing("Seleccione una fecha de fin !"))
			return false;
		if (!validarBasico())
			return false;
		return true;
	}

	private boolean validarBasico() {

		if (!getDetallesImpresionPanel1().validar())
			return false;

		return getDetallesPresentacionPanel1().validar();
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonImprimir());
		}
		return jToolBar;
	}

	/**
	 * This method initializes jButtonImprimir
	 *
	 * @return JButton
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/print.png")));
			jButtonImprimir.setText("Imprimir");
			jButtonImprimir.setMnemonic(KeyEvent.VK_I);
			jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					_prePrint();
				}
			});
			jButtonImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonImprimir;
	}

	/**
	 * This method initializes textDateDesde
	 *
	 * @return efren.util.gui.text.TextDate
	 */
	private TextDate getTextDateDesde() {
		if (textDateDesde == null) {
			textDateDesde = new TextDate();
		}
		return textDateDesde;
	}

	/**
	 * This method initializes textDateHasta
	 *
	 * @return efren.util.gui.text.TextDate
	 */
	private TextDate getTextDateHasta() {
		if (textDateHasta == null) {
			textDateHasta = new TextDate();
		}
		return textDateHasta;
	}

	/**
	 * This method initializes jTabbedPanePrincipal
	 *
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPanePrincipal() {
		if (jTabbedPanePrincipal == null) {
			jTabbedPanePrincipal = new JTabbedPane();
			jTabbedPanePrincipal.addTab("Ocupación de parqueadero", null, getJPanelOcupacionParqueadero(), null);
			jTabbedPanePrincipal.addTab("Funcionarios", null, getJPanelFuncionarios1(), null);
		}
		return jTabbedPanePrincipal;
	}

	/**
	 * This method initializes jPanelOcupacionParqueadero
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelOcupacionParqueadero() {
		if (jPanelOcupacionParqueadero == null) {
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints13.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 3;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints1.gridx = 0;
			jPanelOcupacionParqueadero = new JPanel();
			jPanelOcupacionParqueadero.setLayout(new GridBagLayout());
			final GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(1, 1, 1, 0);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 4;
			gridBagConstraints.gridx = 0;
			final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
			gridBagConstraints_1.gridy = 5;
			gridBagConstraints_1.gridx = 0;
			jPanelOcupacionParqueadero.add(getJTabbedPane1(), gridBagConstraints1);
			jPanelOcupacionParqueadero.add(getBarPanel(), gridBagConstraints);
			jPanelOcupacionParqueadero.add(getJToolBar(), gridBagConstraints_1);
			jPanelOcupacionParqueadero.add(getJPanelCriteriosBusquedaOcupacionParqueadero(), gridBagConstraints13);
		}
		return jPanelOcupacionParqueadero;
	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridx = 3;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.insets = new Insets(5, 0, 5, 5);
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.anchor = GridBagConstraints.EAST;
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.insets = new Insets(5, 5, 5, 0);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.insets = new Insets(5, 0, 5, 5);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.insets = new Insets(5, 5, 5, 0);
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getLabelExt11(), gridBagConstraints6);
			jPanel2.add(getTextDateDesde(), gridBagConstraints3);
			jPanel2.add(getLabelExt3(), gridBagConstraints7);
			jPanel2.add(getTextDateHasta(), gridBagConstraints4);
		}
		return jPanel2;
	}

	/**
	 *
	 */
	private void cerrar() {
		try {
			((PagoView) getOwner()).reinicializarVisual();
		} catch (Exception e) {
			e.getMessage();
		}
		dispose();
	}

	private JCheckBox getJCheckBoxClientes() {
		if (jCheckBoxClientes == null) {
			jCheckBoxClientes = new JCheckBox();
			jCheckBoxClientes.setText("Clientes");
			jCheckBoxClientes.setSelected(true);
		}
		return jCheckBoxClientes;
	}

	/**
	 * This method initializes jPanelTipoCliente
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelTipoCliente() {
		if (jPanelTipoCliente == null) {
			GridBagConstraints gbc_jCheckBoxFuncionarios = new GridBagConstraints();
			gbc_jCheckBoxFuncionarios.gridx = 2;
			gbc_jCheckBoxFuncionarios.gridy = 0;
			GridBagConstraints gbc_jCheckBoxNoClientes = new GridBagConstraints();
			gbc_jCheckBoxNoClientes.gridx = 1;
			gbc_jCheckBoxNoClientes.gridy = 0;
			GridBagConstraints gbc_jCheckBoxClientes = new GridBagConstraints();
			gbc_jCheckBoxClientes.gridx = 0;
			gbc_jCheckBoxClientes.gridy = 0;
			jPanelTipoCliente = new JPanel();
			jPanelTipoCliente.setLayout(new GridBagLayout());
			jPanelTipoCliente.add(getJCheckBoxClientes(), gbc_jCheckBoxClientes);
			jPanelTipoCliente.add(getJCheckBoxNoClientes(), gbc_jCheckBoxNoClientes);
			jPanelTipoCliente.add(getJCheckBoxFuncionarios(), gbc_jCheckBoxFuncionarios);
		}
		return jPanelTipoCliente;
	}

	private JCheckBox getJCheckBoxNoClientes() {
		if (jCheckBoxNoClientes == null) {
			jCheckBoxNoClientes = new JCheckBox();
			jCheckBoxNoClientes.setText("No Clientes");
			jCheckBoxNoClientes.setSelected(true);
		}
		return jCheckBoxNoClientes;
	}

	private JCheckBox getJCheckBoxFuncionarios() {
		if (jCheckBoxFuncionarios == null) {
			jCheckBoxFuncionarios = new JCheckBox();
			jCheckBoxFuncionarios.setText("Funcionarios");
			jCheckBoxFuncionarios.setSelected(true);
		}
		return jCheckBoxFuncionarios;
	}

	/**
	 * This method initializes jPanelFuncionarios1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelFuncionarios1() {
		if (jPanelFuncionarios1 == null) {
			GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
			gridBagConstraints111.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints111.gridy = 0;
			gridBagConstraints111.weightx = 1.0;
			gridBagConstraints111.gridx = 0;
			GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
			gridBagConstraints_11.gridx = 0;
			gridBagConstraints_11.gridy = 4;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridy = 3;
			gridBagConstraints10.insets = new Insets(1, 1, 1, 0);
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridy = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.weighty = 1.0;
			gridBagConstraints12.insets = new Insets(1, 1, 1, 1);
			jPanelFuncionarios1 = new JPanel();
			jPanelFuncionarios1.setLayout(new GridBagLayout());
			jPanelFuncionarios1.add(getIvjJTabbedPaneFuncionarios(), gridBagConstraints12);
			jPanelFuncionarios1.add(getIvjBarPanelFuncionarios(), gridBagConstraints10);
			jPanelFuncionarios1.add(getJToolBarFuncionarios(), gridBagConstraints_11);
			jPanelFuncionarios1.add(getJPanel21(), gridBagConstraints111);
		}
		return jPanelFuncionarios1;
	}

	/**
	 * This method initializes ivjJTabbedPaneFuncionarios
	 *
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getIvjJTabbedPaneFuncionarios() {
		if (ivjJTabbedPaneFuncionarios == null) {
			ivjJTabbedPaneFuncionarios = new JTabbedPane();
			ivjJTabbedPaneFuncionarios.setFont(new Font("Arial", 0, 10));
			ivjJTabbedPaneFuncionarios.setToolTipText("Reportes personalizados");
			ivjJTabbedPaneFuncionarios.setName("JTabbedPane1");
			ivjJTabbedPaneFuncionarios.addTab("(4) Detalles de presentación", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")),
					getIvjPageDetallesFuncionarios(), null);
			ivjJTabbedPaneFuncionarios.addTab("(6) Detalles de impresión", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.gif")),
					getIvjPageImpresionFuncionarios(), null);
		}
		return ivjJTabbedPaneFuncionarios;
	}

	/**
	 * This method initializes ivjPageDetallesFuncionarios
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getIvjPageDetallesFuncionarios() {
		if (ivjPageDetallesFuncionarios == null) {
			GridBagConstraints constraintsDetallesPresentacionPanelFuncionarios = new GridBagConstraints();
			constraintsDetallesPresentacionPanelFuncionarios.fill = GridBagConstraints.BOTH;
			constraintsDetallesPresentacionPanelFuncionarios.gridwidth = 5;
			constraintsDetallesPresentacionPanelFuncionarios.gridx = 0;
			constraintsDetallesPresentacionPanelFuncionarios.gridy = 0;
			constraintsDetallesPresentacionPanelFuncionarios.weightx = 1.0;
			constraintsDetallesPresentacionPanelFuncionarios.weighty = 1.0;
			constraintsDetallesPresentacionPanelFuncionarios.insets = new Insets(4, 4, 4, 4);
			ivjPageDetallesFuncionarios = new JPanel();
			ivjPageDetallesFuncionarios.setLayout(new GridBagLayout());
			ivjPageDetallesFuncionarios.setFont(new Font("Arial", 0, 10));
			ivjPageDetallesFuncionarios.setName("PageDetalles");
			ivjPageDetallesFuncionarios.add(getIvjDetallesPresentacionPanelFuncionarios(), constraintsDetallesPresentacionPanelFuncionarios);
		}
		return ivjPageDetallesFuncionarios;
	}

	/**
	 * This method initializes ivjDetallesPresentacionPanelFuncionarios
	 *
	 * @return efren.util.reportes.DetallesPresentacionPanel
	 */
	private DetallesPresentacionPanel getIvjDetallesPresentacionPanelFuncionarios() {
		if (ivjDetallesPresentacionPanelFuncionarios == null) {
			ivjDetallesPresentacionPanelFuncionarios = new DetallesPresentacionPanel();
			ivjDetallesPresentacionPanelFuncionarios.setName("DetallesPresentacionPanel1");
			ivjDetallesPresentacionPanelFuncionarios.setExpress(false);
			ivjDetallesPresentacionPanelFuncionarios.setFuente(new StyleFont(new Font("Arial", Font.PLAIN, 8)));
			ivjDetallesPresentacionPanelFuncionarios.setScrollPaneTableVisible(true);

			ivjDetallesPresentacionPanelFuncionarios._refrescarDetallesTabla(getSqlClausesFactory().getSQLClause_Funcionarios_OnlyHeaders());
			TableModel model = ivjDetallesPresentacionPanelFuncionarios.getTableModel();
			/**
			 * COLUMNAS 0: Nombre SQL || 1: Nombre || 2: Ancho || 3: Quiebre ||
			 * 4: F. quiebre || 5: F. total || 6: Unidad || 7: Negritas || 8:
			 * Color
			 */
			model.setValueAt("Fecha", 0, 1);
			model.setValueAt(120, 0, 2);
			model.setValueAt("Hora entrada", 1, 1);
			model.setValueAt(120, 1, 2);
			model.setValueAt("CONTEO", 1, 4);
			model.setValueAt("CONTEO", 1, 5);
			model.setValueAt("Hora salida", 2, 1);
			model.setValueAt(120, 2, 2);
			model.setValueAt("Usuario", 3, 1);
			model.setValueAt(110, 3, 2);
			model.setValueAt("Tipo usr.", 4, 1);
			model.setValueAt("Observaciones", 5, 1);
			ivjDetallesPresentacionPanelFuncionarios.setTitulo01(ParqueSamanesConstantes.EMPRESA_NOMBRE_01);
			ivjDetallesPresentacionPanelFuncionarios.setTitulo02("Funcionarios");

		}
		return ivjDetallesPresentacionPanelFuncionarios;
	}

	/**
	 * This method initializes ivjPageImpresionFuncionarios
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getIvjPageImpresionFuncionarios() {
		if (ivjPageImpresionFuncionarios == null) {
			GridBagConstraints constraintsDetallesImpresionPanelFuncionarios = new GridBagConstraints();
			constraintsDetallesImpresionPanelFuncionarios.fill = GridBagConstraints.BOTH;
			constraintsDetallesImpresionPanelFuncionarios.gridx = 0;
			constraintsDetallesImpresionPanelFuncionarios.gridy = 0;
			constraintsDetallesImpresionPanelFuncionarios.weightx = 1.0;
			constraintsDetallesImpresionPanelFuncionarios.weighty = 1.0;
			constraintsDetallesImpresionPanelFuncionarios.insets = new Insets(4, 4, 4, 4);
			ivjPageImpresionFuncionarios = new JPanel();
			ivjPageImpresionFuncionarios.setLayout(new GridBagLayout());
			ivjPageImpresionFuncionarios.setName("PageImpresion");
			ivjPageImpresionFuncionarios.add(getIvjDetallesImpresionPanelFuncionarios(), constraintsDetallesImpresionPanelFuncionarios);
		}
		return ivjPageImpresionFuncionarios;
	}

	/**
	 * This method initializes ivjDetallesImpresionPanelFuncionarios
	 *
	 * @return efren.util.reportes.DetallesImpresionPanel
	 */
	private DetallesImpresionPanel getIvjDetallesImpresionPanelFuncionarios() {
		if (ivjDetallesImpresionPanelFuncionarios == null) {
			ivjDetallesImpresionPanelFuncionarios = new DetallesImpresionPanel();
			ivjDetallesImpresionPanelFuncionarios.setName("DetallesImpresionPanel1");
			ivjDetallesImpresionPanelFuncionarios.setTipoImpresion(DetallesImpresionPanel.PREVIEW);
		}
		return ivjDetallesImpresionPanelFuncionarios;
	}

	/**
	 * This method initializes ivjBarPanelFuncionarios
	 *
	 * @return efren.util.gui.ProgressBarWithThreadPanel
	 */
	private ProgressBarWithThreadPanel getIvjBarPanelFuncionarios() {
		if (ivjBarPanelFuncionarios == null) {
			ivjBarPanelFuncionarios = new ProgressBarWithThreadPanel();
			ivjBarPanelFuncionarios.setName("BarPanel");
		}
		return ivjBarPanelFuncionarios;
	}

	/**
	 * This method initializes jToolBarFuncionarios
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBarFuncionarios() {
		if (jToolBarFuncionarios == null) {
			jToolBarFuncionarios = new JToolBar();
			jToolBarFuncionarios.setOpaque(false);
			jToolBarFuncionarios.setFloatable(false);
			jToolBarFuncionarios.add(getJButtonImprimirFuncionarios());
		}
		return jToolBarFuncionarios;
	}

	/**
	 * This method initializes jButtonImprimirFuncionarios
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonImprimirFuncionarios() {
		if (jButtonImprimirFuncionarios == null) {
			jButtonImprimirFuncionarios = new JButton();
			jButtonImprimirFuncionarios.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
			jButtonImprimirFuncionarios.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/print.png")));
			jButtonImprimirFuncionarios.setText("Imprimir");
			jButtonImprimirFuncionarios.setMnemonic(KeyEvent.VK_I);
			jButtonImprimirFuncionarios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					construirReporteFuncionarios();
				}
			});
		}
		return jButtonImprimirFuncionarios;
	}

	/**
	 * This method initializes jPanel21
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black), "Criterios de selección",
					TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213));
			titledBorder1.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.gridx = 3;
			gridBagConstraints41.gridy = 0;
			gridBagConstraints41.insets = new Insets(5, 0, 5, 5);
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.anchor = GridBagConstraints.EAST;
			gridBagConstraints71.gridx = 2;
			gridBagConstraints71.gridy = 0;
			gridBagConstraints71.insets = new Insets(5, 5, 5, 0);
			ivjLabelExt31 = new LabelExt();
			ivjLabelExt31.setName("LabelExt3");
			ivjLabelExt31.setText("Hasta:");
			ivjLabelExt31.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.gridy = 0;
			gridBagConstraints31.insets = new Insets(5, 0, 5, 5);
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.anchor = GridBagConstraints.EAST;
			gridBagConstraints61.gridx = 0;
			gridBagConstraints61.gridy = 0;
			gridBagConstraints61.insets = new Insets(5, 5, 5, 0);
			ivjLabelExt111 = new LabelExt();
			ivjLabelExt111.setName("LabelExt11");
			ivjLabelExt111.setText("Desde:");
			ivjLabelExt111.setHorizontalAlignment(SwingConstants.RIGHT);
			jPanel21 = new JPanel();
			jPanel21.setLayout(new GridBagLayout());
			jPanel21.setBorder(titledBorder1);
			jPanel21.add(ivjLabelExt111, gridBagConstraints61);
			jPanel21.add(getTextDateDesdeFuncionarios(), gridBagConstraints31);
			jPanel21.add(ivjLabelExt31, gridBagConstraints71);
			jPanel21.add(getTextDateHastaFuncionarios(), gridBagConstraints41);
		}
		return jPanel21;
	}

	/**
	 * This method initializes textDateDesdeFuncionarios
	 *
	 * @return efren.util.gui.text.TextDate
	 */
	private TextDate getTextDateDesdeFuncionarios() {
		if (textDateDesdeFuncionarios == null) {
			textDateDesdeFuncionarios = new TextDate();
		}
		return textDateDesdeFuncionarios;
	}

	/**
	 * This method initializes textDateHastaFuncionarios
	 *
	 * @return efren.util.gui.text.TextDate
	 */
	private TextDate getTextDateHastaFuncionarios() {
		if (textDateHastaFuncionarios == null) {
			textDateHastaFuncionarios = new TextDate();
		}
		return textDateHastaFuncionarios;
	}

	/**
	 * This method initializes jPanelCriteriosBusquedaOcupacionParqueadero
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelCriteriosBusquedaOcupacionParqueadero() {
		if (jPanelCriteriosBusquedaOcupacionParqueadero == null) {
			TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 5), "Criterios de selección",
					TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 70, 213));
			titledBorder.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.gridy = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 0;
			jPanelCriteriosBusquedaOcupacionParqueadero = new JPanel();
			jPanelCriteriosBusquedaOcupacionParqueadero.setLayout(new GridBagLayout());
			jPanelCriteriosBusquedaOcupacionParqueadero.setBorder(titledBorder);
			jPanelCriteriosBusquedaOcupacionParqueadero.add(getJPanel2(), gridBagConstraints11);
			jPanelCriteriosBusquedaOcupacionParqueadero.add(getJPanelTipoCliente(), gridBagConstraints14);
		}
		return jPanelCriteriosBusquedaOcupacionParqueadero;
	}

	/**
	 * @return the sqlClausesFactory
	 */
	public ReporterSQLClausesFactory getSqlClausesFactory() {
		return sqlClausesFactory;
	}

	/**
	 * @param sqlClausesFactory
	 *            the sqlClausesFactory to set
	 */
	public void setSqlClausesFactory(ReporterSQLClausesFactory sqlClausesFactory) {
		this.sqlClausesFactory = sqlClausesFactory;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
