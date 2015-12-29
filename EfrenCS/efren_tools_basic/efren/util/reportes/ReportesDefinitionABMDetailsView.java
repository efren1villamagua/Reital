package efren.util.reportes;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import efren.util.ABMViewObserver;
import efren.util.ExceptionManager;
import efren.util.StringTools;
import efren.util.SystemLogManager;
import efren.util.abm.estados.ABMEstado;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.BarraAceptarCancelarPanel;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListenerAdapter;

public class ReportesDefinitionABMDetailsView extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 8184021394888300737L;

	private JPanel jContentPane = null;

	private BarraAceptarCancelarPanel barraAceptarCancelarPanel = null;

	private ReportesDefinitionABMView ventanaPrincipal = null;

	private ABMViewObserver visualObserver = null;

	private ABMEstado estadoABM = null; // @jve:decl-index=0:

	private DefinicionReporte bo = null; // @jve:decl-index=0:

	private ReportesDefinitionController controller = null; // @jve:decl-index=0:

	private efren.util.gui.text.TextAreaExt ivjTextAreaExtSQL = null;

	private javax.swing.JTabbedPane ivjJTabbedPane1 = null;

	private javax.swing.JCheckBox ivjJCheckBoxAnexo = null; // @jve:decl-index=0:

	private efren.util.gui.MultiChoice ivjMultiChoiceTipoAnexo = null;

	private efren.util.gui.LabelExt ivjLabelExt11 = null;

	private efren.util.gui.LabelExt ivjLabelExt4 = null;

	private efren.util.gui.text.TextAreaExt ivjTextAreaExtSQLAnexo = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtEtiquetaAnexo = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValorAnexo = null;

	private efren.util.gui.ProgressBarWithThreadPanel ivjBarPanel = null;

	private efren.util.gui.LabelExt ivjLabelExt21 = null;

	private efren.util.gui.LabelExt ivjLabelExt6 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor01 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor02 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor03 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor04 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor05 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor06 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor07 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor08 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable01 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable02 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable03 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable04 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable05 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable06 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable07 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable08 = null;

	private javax.swing.JPanel ivjPageDetalles = null;

	private javax.swing.JPanel ivjPageSQL = null;

	private javax.swing.JPanel ivjPageVariables = null;

	private javax.swing.JPanel ivjPageAnexo = null;

	private javax.swing.JPanel ivjPageImpresion = null;

	private efren.util.gui.LabelExt ivjLabelExt8 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;

	private DetallesImpresionPanel ivjDetallesImpresionPanel = null;

	private DetallesPresentacionPanel ivjDetallesPresentacionPanel = null;

	private int paletaSeleccionada = 0;

	private JToolBar jToolBar = null;

	private JButton jButtonBack = null;

	private JButton jButtonNext = null;

	private JToolBar jToolBar1 = null;

	private JButton jButtonImprimir = null;

	/**
	 * This is the xxx default constructor
	 */
	public ReportesDefinitionABMDetailsView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(650, 553);
		this.setContentPane(getJContentPane());
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				_cerrar();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints6.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.insets = new Insets(1, 5, 1, 5);
			gridBagConstraints5.gridy = 5;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 0.0;
			gridBagConstraints3.gridx = 3;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 4;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.insets = new Insets(1, 5, 1, 5);
			gridBagConstraints11.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.anchor = GridBagConstraints.EAST;
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.gridy = 6;
			jContentPane = new JPanel();
			final GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.rowHeights = new int[] { 7, 0, 0, 0, 0 };
			jContentPane.setLayout(gridBagLayout);
			jContentPane.add(getBarraAceptarCancelarPanel(), gridBagConstraints1);
			jContentPane.add(getJTabbedPane1(), gridBagConstraints11);
			jContentPane.add(getJToolBar(), gridBagConstraints2);
			jContentPane.add(getJToolBar1(), gridBagConstraints3);
			jContentPane.add(getBarPanel(), gridBagConstraints5);
			jContentPane.add(getTextFieldExtNombre(), gridBagConstraints6);
		}
		return jContentPane;
	}

	/**
	 * This method initializes barraAceptarCancelarPanel
	 *
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	private BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
		if (barraAceptarCancelarPanel == null) {
			barraAceptarCancelarPanel = new BarraAceptarCancelarPanel();
			barraAceptarCancelarPanel.addBarraAceptarCancelarPanelListener(new efren.util.gui.bars.BarraAceptarCancelarPanelListener() {
				public void aceptarClicked(java.util.EventObject e) {
					aceptar();
				}

				public void cancelarClicked(java.util.EventObject e) {
					_cerrar();
				}
			});
		}
		return barraAceptarCancelarPanel;
	}

	public ReportesDefinitionABMView getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(ReportesDefinitionABMView ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public ABMViewObserver getVisualObserver() {
		return visualObserver;
	}

	public void setVisualObserver(ABMViewObserver visualObserver) {
		this.visualObserver = visualObserver;
	}

	public ABMEstado getEstadoABM() {
		return estadoABM;
	}

	public void setEstadoABM(ABMEstado estadoABM) {
		this.estadoABM = estadoABM;
	}

	public DefinicionReporte getBo() {
		return bo;
	}

	public void setBo(DefinicionReporte bo) {
		this.bo = bo;
	}

	/**
	 *
	 */
	public void initAll() {
		initFields();
	}

	/**
	 *
	 */
	private void initFields() {
		try {
			// ...manejo de datos
			getTextAreaExtSQL().setValue(getBo().getSentenciaSql());

			Vector<String> nombresColumnas = DetallesPresentacionPanel._nombresSQLColumnas(getTextAreaExtSQL().getValue());

			DetallesPresentacionPanel._construirFilasDetalle_fromSQL(getDetallesPresentacionPanel().getTableModel(), nombresColumnas, getBo().getDetalle());

			Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
			Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
			textFieldsVariables.addElement(getTextFieldExtVariable01());
			textFieldsValores.addElement(getTextFieldExtValor01());
			textFieldsVariables.addElement(getTextFieldExtVariable02());
			textFieldsValores.addElement(getTextFieldExtValor02());
			textFieldsVariables.addElement(getTextFieldExtVariable03());
			textFieldsValores.addElement(getTextFieldExtValor03());
			textFieldsVariables.addElement(getTextFieldExtVariable04());
			textFieldsValores.addElement(getTextFieldExtValor04());
			textFieldsVariables.addElement(getTextFieldExtVariable05());
			textFieldsValores.addElement(getTextFieldExtValor05());
			textFieldsVariables.addElement(getTextFieldExtVariable06());
			textFieldsValores.addElement(getTextFieldExtValor06());
			textFieldsVariables.addElement(getTextFieldExtVariable07());
			textFieldsValores.addElement(getTextFieldExtValor07());
			textFieldsVariables.addElement(getTextFieldExtVariable08());
			textFieldsValores.addElement(getTextFieldExtValor08());

			getController()._showVariables(getBo(), textFieldsVariables, textFieldsValores);

			getJCheckBoxAnexo().setSelected(getBo().isLlevaAnexo());
			getMultiChoiceTipoAnexo().setSelectedIndex(getBo().getTipoAnexo());
			getTextFieldExtEtiquetaAnexo().setValue(getBo().getEtiquetaAnexo());
			getTextFieldExtValorAnexo().setValue(getBo().getValorAnexo());
			getTextAreaExtSQLAnexo().setValue(getBo().getSqlAnexo());
			getTextFieldExtNombre().setValue(getBo().getNombre());
			getDetallesPresentacionPanel().DEFINICION_cargarVisualmente(getBo());
			getDetallesImpresionPanel()._DEFINICION_cargar(getBo());
			// ...manejo visual
			if (getEstadoABM().esEliminado() || getEstadoABM().esConsultado()) {
				getTextAreaExtSQL().setEnabled(false);
				getJCheckBoxAnexo().setEnabled(false);
				getMultiChoiceTipoAnexo().setEnabled(false);
				getTextFieldExtEtiquetaAnexo().setEnabled(false);
				getTextFieldExtValorAnexo().setEnabled(false);
				getTextAreaExtSQLAnexo().setEnabled(false);
				getTextFieldExtNombre().setEnabled(false);
				getDetallesPresentacionPanel().setEnabled(false);
				getDetallesImpresionPanel().setEnabled(false);
			}
		} catch (Throwable t) {
			SystemLogManager.error(t.getMessage());
		}
	}

	/**
	 *
	 */
	private void aceptar() {
		try {
			if (!validar()) {
				return;
			}
			if (permanentUpdateBO()) {
				getVisualObserver().removeFrame(this, String.valueOf(bo.getOid()));
				getVentanaPrincipal().setSelected(true);
			}
			getVentanaPrincipal().dataFetch();
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, false, this, t);
		}
	}

	/**
	 * se elimina ésta ventana del observer controlador de ventanas para que el
	 * objeto de negocio pueda ser utilizado en otra ventana de detalle
	 */
	public void _cerrar() {
		getVisualObserver().removeFrame(this, String.valueOf(getBo().getOid()));
	}

	/**
	 *
	 */
	private boolean permanentUpdateBO() {
		try {

			if (getEstadoABM().esNuevo()) {
				DefinicionReporte bo = new DefinicionReporte();
				this.llenarDefinicionReporte(bo);
				int insertados = this.getController().insertBo(bo);
				return insertados > 0;
			}
			if (getEstadoABM().esModificado()) {
				DefinicionReporte bo = new DefinicionReporte();
				this.llenarDefinicionReporte(bo);
				bo.setOid(getBo().getOid());
				bo.setUtc(getBo().getUtc());
				int actualizados = this.getController().updateBo(bo);
				if (actualizados <= 0) {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
				return actualizados > 0;
			}
			if (getEstadoABM().esEliminado()) {
				DefinicionReporte bo = new DefinicionReporte();
				this.llenarDefinicionReporte(bo);
				bo.setOid(getBo().getOid());
				bo.setUtc(getBo().getUtc());
				int eliminados = this.getController().deleteBo(bo);
				if (eliminados <= 0) {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
				return eliminados > 0;
			}
			return true;

		} catch (Throwable t) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "ERROR: " + t.getMessage());
			SystemLogManager.error(t.getMessage());
			return false;
		}
	}

	public ReportesDefinitionController getController() {
		if (this.controller == null) {
			this.controller = new ReportesDefinitionController(this);
		}
		return controller;
	}

	public void setController(ReportesDefinitionController controller) {
		this.controller = controller;
	}

	/**
	 *
	 */
	private efren.util.gui.ProgressBarWithThreadPanel getBarPanel() {
		if (ivjBarPanel == null) {
			ivjBarPanel = new efren.util.gui.ProgressBarWithThreadPanel();
			ivjBarPanel.setName("BarPanel");
		}
		return ivjBarPanel;
	}

	/**
	 *
	 */
	private DetallesImpresionPanel getDetallesImpresionPanel() {
		if (ivjDetallesImpresionPanel == null) {
			ivjDetallesImpresionPanel = new efren.util.reportes.DetallesImpresionPanel();
			ivjDetallesImpresionPanel.setName("DetallesImpresionPanel");
		}
		return ivjDetallesImpresionPanel;
	}

	/**
	 *
	 */
	private DetallesPresentacionPanel getDetallesPresentacionPanel() {
		if (ivjDetallesPresentacionPanel == null) {
			ivjDetallesPresentacionPanel = new efren.util.reportes.DetallesPresentacionPanel();
			ivjDetallesPresentacionPanel.setName("DetallesPresentacionPanel");
		}
		return ivjDetallesPresentacionPanel;
	}

	/**
	 *
	 */
	private javax.swing.JCheckBox getJCheckBoxAnexo() {
		if (ivjJCheckBoxAnexo == null) {
			try {
				ivjJCheckBoxAnexo = new javax.swing.JCheckBox();
				ivjJCheckBoxAnexo.setName("JCheckBoxAnexo");
				ivjJCheckBoxAnexo.setFont(new java.awt.Font("Arial", 0, 10));
				ivjJCheckBoxAnexo.setText("Anexo");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxAnexo;
	}

	/**
	 *
	 */
	private javax.swing.JTabbedPane getJTabbedPane1() {
		if (ivjJTabbedPane1 == null) {
			ivjJTabbedPane1 = new javax.swing.JTabbedPane();
			ivjJTabbedPane1.setName("JTabbedPane1");
			ivjJTabbedPane1.setToolTipText("Reportes personalizados");
			ivjJTabbedPane1.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJTabbedPane1.insertTab("(1) Sentencia SQL", new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")),
					getPageSQL(), null, 0);
			ivjJTabbedPane1.insertTab("(2) Variables para sentencia SQL",
					new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")), getPageVariables(), null, 1);
			ivjJTabbedPane1.insertTab("(3) Detalles de presentación", new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")),
					getPageDetalles(), null, 2);
			ivjJTabbedPane1.insertTab("(4) Anexo al final del reporte",
					new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")), getPageAnexo(), null, 3);
			ivjJTabbedPane1.insertTab("(5) Detalles de impresión", new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.gif")),
					getPageImpresion(), null, 4);
			ivjJTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.TOP);
			ivjJTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray, 1));
			ivjJTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					paletaSeleccionada = ivjJTabbedPane1.getSelectedIndex();
				}
			});
			ivjJTabbedPane1.putClientProperty("pgs.isButtonStyle", Boolean.TRUE);
		}
		return ivjJTabbedPane1;
	}

	/**
	 *
	 */
	private efren.util.gui.MultiChoice getMultiChoiceTipoAnexo() {
		if (ivjMultiChoiceTipoAnexo == null) {
			ivjMultiChoiceTipoAnexo = new efren.util.gui.MultiChoice();
			ivjMultiChoiceTipoAnexo.setName("MultiChoiceTipoAnexo");
			String ivjLocal50valueOptions[] = { "1", "2" };
			ivjMultiChoiceTipoAnexo.setValueOptions(ivjLocal50valueOptions);
			ivjMultiChoiceTipoAnexo.setSelectedIndex(1);
			String ivjLocal50nameOptions[] = { "Valor fijo", "SQL" };
			ivjMultiChoiceTipoAnexo.setNameOptions(ivjLocal50nameOptions, false, false);
			ivjMultiChoiceTipoAnexo.setSelectedOption("2");
			ivjMultiChoiceTipoAnexo.setTitle("Tipo de anexo");
			ivjMultiChoiceTipoAnexo.addMultiChoiceListener(new efren.util.gui.MultiChoiceListener() {
				public void selectedOptionChanged(java.util.EventObject e) {
					visualManageValorAnexo();
				}

				public void selectedOptionChanged1(java.util.EventObject e) {
				}

				public void selectedOptionChanged2(java.util.EventObject e) {
				}

				public void selectedOptionChanged3(java.util.EventObject e) {
				}
			});
		}
		return ivjMultiChoiceTipoAnexo;
	}

	/**
	 *
	 */
	private javax.swing.JPanel getPageAnexo() {
		if (ivjPageAnexo == null) {
			try {
				ivjPageAnexo = new javax.swing.JPanel();
				ivjPageAnexo.setName("PageAnexo");
				ivjPageAnexo.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageAnexo.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsTextFieldExtEtiquetaAnexo = new java.awt.GridBagConstraints();
				constraintsTextFieldExtEtiquetaAnexo.gridx = 1;
				constraintsTextFieldExtEtiquetaAnexo.gridy = 1;
				constraintsTextFieldExtEtiquetaAnexo.gridwidth = 3;
				constraintsTextFieldExtEtiquetaAnexo.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtEtiquetaAnexo.weightx = 1.0;
				constraintsTextFieldExtEtiquetaAnexo.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageAnexo().add(getTextFieldExtEtiquetaAnexo(), constraintsTextFieldExtEtiquetaAnexo);

				java.awt.GridBagConstraints constraintsLabelExt11 = new java.awt.GridBagConstraints();
				constraintsLabelExt11.gridx = 0;
				constraintsLabelExt11.gridy = 1;
				constraintsLabelExt11.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt11.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageAnexo().add(getLabelExt11(), constraintsLabelExt11);

				java.awt.GridBagConstraints constraintsMultiChoiceTipoAnexo = new java.awt.GridBagConstraints();
				constraintsMultiChoiceTipoAnexo.gridx = 1;
				constraintsMultiChoiceTipoAnexo.gridy = 2;
				constraintsMultiChoiceTipoAnexo.gridwidth = 4;
				constraintsMultiChoiceTipoAnexo.weightx = 1.0;
				constraintsMultiChoiceTipoAnexo.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageAnexo().add(getMultiChoiceTipoAnexo(), constraintsMultiChoiceTipoAnexo);

				java.awt.GridBagConstraints constraintsTextAreaExtSQLAnexo = new java.awt.GridBagConstraints();
				constraintsTextAreaExtSQLAnexo.gridx = 1;
				constraintsTextAreaExtSQLAnexo.gridy = 4;
				constraintsTextAreaExtSQLAnexo.fill = java.awt.GridBagConstraints.BOTH;
				constraintsTextAreaExtSQLAnexo.weightx = 1.0;
				constraintsTextAreaExtSQLAnexo.weighty = 1.0;
				constraintsTextAreaExtSQLAnexo.insets = new java.awt.Insets(0, 5, 5, 5);
				getPageAnexo().add(getTextAreaExtSQLAnexo(), constraintsTextAreaExtSQLAnexo);

				java.awt.GridBagConstraints constraintsLabelExt4 = new java.awt.GridBagConstraints();
				constraintsLabelExt4.gridx = 0;
				constraintsLabelExt4.gridy = 3;
				constraintsLabelExt4.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt4.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt4.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageAnexo().add(getLabelExt4(), constraintsLabelExt4);

				java.awt.GridBagConstraints constraintsTextFieldExtValorAnexo = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValorAnexo.gridx = 1;
				constraintsTextFieldExtValorAnexo.gridy = 3;
				constraintsTextFieldExtValorAnexo.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValorAnexo.weightx = 1.0;
				constraintsTextFieldExtValorAnexo.insets = new java.awt.Insets(0, 5, 5, 5);
				getPageAnexo().add(getTextFieldExtValorAnexo(), constraintsTextFieldExtValorAnexo);

				java.awt.GridBagConstraints constraintsJCheckBoxAnexo = new java.awt.GridBagConstraints();
				constraintsJCheckBoxAnexo.gridx = 0;
				constraintsJCheckBoxAnexo.gridy = 0;
				constraintsJCheckBoxAnexo.anchor = java.awt.GridBagConstraints.WEST;
				constraintsJCheckBoxAnexo.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageAnexo().add(getJCheckBoxAnexo(), constraintsJCheckBoxAnexo);

				java.awt.GridBagConstraints constraintsLabelExt8 = new java.awt.GridBagConstraints();
				constraintsLabelExt8.gridx = 0;
				constraintsLabelExt8.gridy = 4;
				constraintsLabelExt8.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt8.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt8.insets = new java.awt.Insets(5, 5, 0, 5);
				getPageAnexo().add(getLabelExt8(), constraintsLabelExt8);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageAnexo;
	}

	/**
	 * Return the Page property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getPageDetalles() {
		if (ivjPageDetalles == null) {
			try {
				ivjPageDetalles = new javax.swing.JPanel();
				ivjPageDetalles.setName("PageDetalles");
				ivjPageDetalles.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageDetalles.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesPresentacionPanel = new java.awt.GridBagConstraints();
				constraintsDetallesPresentacionPanel.gridx = 0;
				constraintsDetallesPresentacionPanel.gridy = 0;
				constraintsDetallesPresentacionPanel.gridwidth = 4;
				constraintsDetallesPresentacionPanel.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesPresentacionPanel.weightx = 1.0;
				constraintsDetallesPresentacionPanel.weighty = 1.0;
				constraintsDetallesPresentacionPanel.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageDetalles().add(getDetallesPresentacionPanel(), constraintsDetallesPresentacionPanel);
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
	 * Return the JFrameContentPane1 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getPageImpresion() {
		if (ivjPageImpresion == null) {
			try {
				ivjPageImpresion = new javax.swing.JPanel();
				ivjPageImpresion.setName("PageImpresion");
				ivjPageImpresion.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesImpresionPanel = new java.awt.GridBagConstraints();
				constraintsDetallesImpresionPanel.gridx = 0;
				constraintsDetallesImpresionPanel.gridy = 0;
				constraintsDetallesImpresionPanel.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesImpresionPanel.weightx = 1.0;
				constraintsDetallesImpresionPanel.weighty = 1.0;
				constraintsDetallesImpresionPanel.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageImpresion().add(getDetallesImpresionPanel(), constraintsDetallesImpresionPanel);
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
	 * Return the Page1 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getPageSQL() {
		if (ivjPageSQL == null) {
			try {
				ivjPageSQL = new javax.swing.JPanel();
				ivjPageSQL.setName("PageSQL");
				ivjPageSQL.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageSQL.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsTextAreaExtSQL = new java.awt.GridBagConstraints();
				constraintsTextAreaExtSQL.gridx = 0;
				constraintsTextAreaExtSQL.gridy = 0;
				constraintsTextAreaExtSQL.fill = java.awt.GridBagConstraints.BOTH;
				constraintsTextAreaExtSQL.weightx = 1.0;
				constraintsTextAreaExtSQL.weighty = 1.0;
				constraintsTextAreaExtSQL.insets = new java.awt.Insets(5, 5, 0, 5);
				getPageSQL().add(getTextAreaExtSQL(), constraintsTextAreaExtSQL);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageSQL;
	}

	/**
	 * Return the JFrameContentPane11 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getPageVariables() {
		if (ivjPageVariables == null) {
			try {
				ivjPageVariables = new javax.swing.JPanel();
				ivjPageVariables.setName("PageVariables");
				ivjPageVariables.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsLabelExt21 = new java.awt.GridBagConstraints();
				constraintsLabelExt21.gridx = 1;
				constraintsLabelExt21.gridy = 0;
				constraintsLabelExt21.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt21.weightx = 1.0;
				constraintsLabelExt21.weighty = 1.0;
				constraintsLabelExt21.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getLabelExt21(), constraintsLabelExt21);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable01 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable01.gridx = 0;
				constraintsTextFieldExtVariable01.gridy = 1;
				constraintsTextFieldExtVariable01.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable01.weightx = 1.0;
				constraintsTextFieldExtVariable01.weighty = 1.0;
				constraintsTextFieldExtVariable01.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable01(), constraintsTextFieldExtVariable01);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable02 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable02.gridx = 0;
				constraintsTextFieldExtVariable02.gridy = 2;
				constraintsTextFieldExtVariable02.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable02.weightx = 1.0;
				constraintsTextFieldExtVariable02.weighty = 1.0;
				constraintsTextFieldExtVariable02.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable02(), constraintsTextFieldExtVariable02);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable03 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable03.gridx = 0;
				constraintsTextFieldExtVariable03.gridy = 3;
				constraintsTextFieldExtVariable03.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable03.weightx = 1.0;
				constraintsTextFieldExtVariable03.weighty = 1.0;
				constraintsTextFieldExtVariable03.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable03(), constraintsTextFieldExtVariable03);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable04 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable04.gridx = 0;
				constraintsTextFieldExtVariable04.gridy = 4;
				constraintsTextFieldExtVariable04.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable04.weightx = 1.0;
				constraintsTextFieldExtVariable04.weighty = 1.0;
				constraintsTextFieldExtVariable04.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable04(), constraintsTextFieldExtVariable04);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable05 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable05.gridx = 0;
				constraintsTextFieldExtVariable05.gridy = 5;
				constraintsTextFieldExtVariable05.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable05.weightx = 1.0;
				constraintsTextFieldExtVariable05.weighty = 1.0;
				constraintsTextFieldExtVariable05.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable05(), constraintsTextFieldExtVariable05);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable06 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable06.gridx = 0;
				constraintsTextFieldExtVariable06.gridy = 6;
				constraintsTextFieldExtVariable06.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable06.weightx = 1.0;
				constraintsTextFieldExtVariable06.weighty = 1.0;
				constraintsTextFieldExtVariable06.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable06(), constraintsTextFieldExtVariable06);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable07 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable07.gridx = 0;
				constraintsTextFieldExtVariable07.gridy = 7;
				constraintsTextFieldExtVariable07.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable07.weightx = 1.0;
				constraintsTextFieldExtVariable07.weighty = 1.0;
				constraintsTextFieldExtVariable07.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable07(), constraintsTextFieldExtVariable07);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable08 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable08.gridx = 0;
				constraintsTextFieldExtVariable08.gridy = 8;
				constraintsTextFieldExtVariable08.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable08.weightx = 1.0;
				constraintsTextFieldExtVariable08.weighty = 1.0;
				constraintsTextFieldExtVariable08.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtVariable08(), constraintsTextFieldExtVariable08);

				java.awt.GridBagConstraints constraintsTextFieldExtValor01 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor01.gridx = 1;
				constraintsTextFieldExtValor01.gridy = 1;
				constraintsTextFieldExtValor01.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor01.weightx = 1.0;
				constraintsTextFieldExtValor01.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor01(), constraintsTextFieldExtValor01);

				java.awt.GridBagConstraints constraintsLabelExt6 = new java.awt.GridBagConstraints();
				constraintsLabelExt6.gridx = 0;
				constraintsLabelExt6.gridy = 0;
				constraintsLabelExt6.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt6.weightx = 1.0;
				constraintsLabelExt6.weighty = 1.0;
				constraintsLabelExt6.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getLabelExt6(), constraintsLabelExt6);

				java.awt.GridBagConstraints constraintsTextFieldExtValor02 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor02.gridx = 1;
				constraintsTextFieldExtValor02.gridy = 2;
				constraintsTextFieldExtValor02.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor02.weightx = 1.0;
				constraintsTextFieldExtValor02.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor02(), constraintsTextFieldExtValor02);

				java.awt.GridBagConstraints constraintsTextFieldExtValor03 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor03.gridx = 1;
				constraintsTextFieldExtValor03.gridy = 3;
				constraintsTextFieldExtValor03.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor03.weightx = 1.0;
				constraintsTextFieldExtValor03.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor03(), constraintsTextFieldExtValor03);

				java.awt.GridBagConstraints constraintsTextFieldExtValor04 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor04.gridx = 1;
				constraintsTextFieldExtValor04.gridy = 4;
				constraintsTextFieldExtValor04.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor04.weightx = 1.0;
				constraintsTextFieldExtValor04.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor04(), constraintsTextFieldExtValor04);

				java.awt.GridBagConstraints constraintsTextFieldExtValor05 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor05.gridx = 1;
				constraintsTextFieldExtValor05.gridy = 5;
				constraintsTextFieldExtValor05.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor05.weightx = 1.0;
				constraintsTextFieldExtValor05.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor05(), constraintsTextFieldExtValor05);

				java.awt.GridBagConstraints constraintsTextFieldExtValor06 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor06.gridx = 1;
				constraintsTextFieldExtValor06.gridy = 6;
				constraintsTextFieldExtValor06.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor06.weightx = 1.0;
				constraintsTextFieldExtValor06.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor06(), constraintsTextFieldExtValor06);

				java.awt.GridBagConstraints constraintsTextFieldExtValor07 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor07.gridx = 1;
				constraintsTextFieldExtValor07.gridy = 7;
				constraintsTextFieldExtValor07.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor07.weightx = 1.0;
				constraintsTextFieldExtValor07.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor07(), constraintsTextFieldExtValor07);

				java.awt.GridBagConstraints constraintsTextFieldExtValor08 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor08.gridx = 1;
				constraintsTextFieldExtValor08.gridy = 8;
				constraintsTextFieldExtValor08.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor08.weightx = 1.0;
				constraintsTextFieldExtValor08.insets = new java.awt.Insets(5, 5, 5, 5);
				getPageVariables().add(getTextFieldExtValor08(), constraintsTextFieldExtValor08);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageVariables;
	}

	/**
	 * Return the LabelExt11 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt11() {
		if (ivjLabelExt11 == null) {
			try {
				ivjLabelExt11 = new efren.util.gui.LabelExt();
				ivjLabelExt11.setName("LabelExt11");
				ivjLabelExt11.setText("Etiqueta");
				ivjLabelExt11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
	 * Return the LabelExt21 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt21() {
		if (ivjLabelExt21 == null) {
			try {
				ivjLabelExt21 = new efren.util.gui.LabelExt();
				ivjLabelExt21.setName("LabelExt21");
				ivjLabelExt21.setText("Valores");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt21;
	}

	/**
	 * Return the LabelExt4 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt4() {
		if (ivjLabelExt4 == null) {
			try {
				ivjLabelExt4 = new efren.util.gui.LabelExt();
				ivjLabelExt4.setName("LabelExt4");
				ivjLabelExt4.setText("Valor fijo");
				ivjLabelExt4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt4;
	}

	/**
	 * Return the LabelExt6 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt6() {
		if (ivjLabelExt6 == null) {
			try {
				ivjLabelExt6 = new efren.util.gui.LabelExt();
				ivjLabelExt6.setName("LabelExt6");
				ivjLabelExt6.setText("Variables");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt6;
	}

	/**
	 * Return the LabelExt8 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt8() {
		if (ivjLabelExt8 == null) {
			try {
				ivjLabelExt8 = new efren.util.gui.LabelExt();
				ivjLabelExt8.setName("LabelExt8");
				ivjLabelExt8.setText("SQL");
				ivjLabelExt8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt8;
	}

	/**
	 * Return the TextAreaExtSQL property value.
	 *
	 * @return efren.util.gui.TextAreaExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextAreaExt getTextAreaExtSQL() {
		if (ivjTextAreaExtSQL == null) {
			ivjTextAreaExtSQL = new efren.util.gui.text.TextAreaExt();
			ivjTextAreaExtSQL.setName("TextAreaExtSQL");
			ivjTextAreaExtSQL.setMaxLength(4000);
			ivjTextAreaExtSQL.addTextAreaExtListener(new efren.util.gui.text.TextAreaExtListener() {
				public void textAreaKeyReleased(java.util.EventObject e) {
					_refrescarDetallesTabla();
				}

				public void textAreaFocusLost(java.util.EventObject e) {
				}
			});
		}
		return ivjTextAreaExtSQL;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextAreaExt getTextAreaExtSQLAnexo() {
		if (ivjTextAreaExtSQLAnexo == null) {
			ivjTextAreaExtSQLAnexo = new efren.util.gui.text.TextAreaExt();
			ivjTextAreaExtSQLAnexo.setName("TextAreaExtSQLAnexo");
			ivjTextAreaExtSQLAnexo.setMaxLength(4000);
			ivjTextAreaExtSQLAnexo.addTextAreaExtListener(new efren.util.gui.text.TextAreaExtListener() {
				public void textAreaKeyReleased(java.util.EventObject e) {
					Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
					Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
					textFieldsVariables.addElement(getTextFieldExtVariable01());
					textFieldsValores.addElement(getTextFieldExtValor01());
					textFieldsVariables.addElement(getTextFieldExtVariable02());
					textFieldsValores.addElement(getTextFieldExtValor02());
					textFieldsVariables.addElement(getTextFieldExtVariable03());
					textFieldsValores.addElement(getTextFieldExtValor03());
					textFieldsVariables.addElement(getTextFieldExtVariable04());
					textFieldsValores.addElement(getTextFieldExtValor04());
					textFieldsVariables.addElement(getTextFieldExtVariable05());
					textFieldsValores.addElement(getTextFieldExtValor05());
					textFieldsVariables.addElement(getTextFieldExtVariable06());
					textFieldsValores.addElement(getTextFieldExtValor06());
					textFieldsVariables.addElement(getTextFieldExtVariable07());
					textFieldsValores.addElement(getTextFieldExtValor07());
					textFieldsVariables.addElement(getTextFieldExtVariable08());
					textFieldsValores.addElement(getTextFieldExtValor08());

					getController()._showVariables(getBo(), textFieldsVariables, textFieldsValores);
				}

				public void textAreaFocusLost(java.util.EventObject e) {
				}
			});
		}
		return ivjTextAreaExtSQLAnexo;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtEtiquetaAnexo() {
		if (ivjTextFieldExtEtiquetaAnexo == null) {
			ivjTextFieldExtEtiquetaAnexo = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtEtiquetaAnexo.setName("TextFieldExtEtiquetaAnexo");
			ivjTextFieldExtEtiquetaAnexo.setFocusAccelerator('d');
			ivjTextFieldExtEtiquetaAnexo.setMaxLength(50);
		}
		return ivjTextFieldExtEtiquetaAnexo;
	}

	/**
	 * Return the TextFieldExtNombre property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
		if (ivjTextFieldExtNombre == null) {
			try {
				ivjTextFieldExtNombre = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtNombre.setName("TextFieldExtNombre");
				ivjTextFieldExtNombre.setEnabled(true);
				ivjTextFieldExtNombre.setMaxLength(50);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtNombre;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor01() {
		if (ivjTextFieldExtValor01 == null) {
			ivjTextFieldExtValor01 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor01.setName("TextFieldExtValor01");
			ivjTextFieldExtValor01.setMaxLength(100);
			ivjTextFieldExtValor01.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor01;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor02() {
		if (ivjTextFieldExtValor02 == null) {
			ivjTextFieldExtValor02 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor02.setName("TextFieldExtValor02");
			ivjTextFieldExtValor02.setMaxLength(100);
			ivjTextFieldExtValor02.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor02;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor03() {
		if (ivjTextFieldExtValor03 == null) {
			ivjTextFieldExtValor03 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor03.setName("TextFieldExtValor03");
			ivjTextFieldExtValor03.setMaxLength(100);
			ivjTextFieldExtValor03.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor03;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor04() {
		if (ivjTextFieldExtValor04 == null) {
			ivjTextFieldExtValor04 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor04.setName("TextFieldExtValor04");
			ivjTextFieldExtValor04.setMaxLength(100);
			ivjTextFieldExtValor04.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor04;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor05() {
		if (ivjTextFieldExtValor05 == null) {
			ivjTextFieldExtValor05 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor05.setName("TextFieldExtValor05");
			ivjTextFieldExtValor05.setMaxLength(100);
			ivjTextFieldExtValor05.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});

		}
		return ivjTextFieldExtValor05;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor06() {
		if (ivjTextFieldExtValor06 == null) {
			ivjTextFieldExtValor06 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor06.setName("TextFieldExtValor06");
			ivjTextFieldExtValor06.setMaxLength(100);
			ivjTextFieldExtValor06.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor06;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor07() {
		if (ivjTextFieldExtValor07 == null) {
			ivjTextFieldExtValor07 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor07.setName("TextFieldExtValor07");
			ivjTextFieldExtValor07.setMaxLength(100);
			ivjTextFieldExtValor07.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor07;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor08() {
		if (ivjTextFieldExtValor08 == null) {
			ivjTextFieldExtValor08 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor08.setName("TextFieldExtValor08");
			ivjTextFieldExtValor08.setMaxLength(100);
			ivjTextFieldExtValor08.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					_prePrint();
				}
			});
		}
		return ivjTextFieldExtValor08;
	}

	/**
	 * Return the TextFieldExtValorAnexo property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValorAnexo() {
		if (ivjTextFieldExtValorAnexo == null) {
			try {
				ivjTextFieldExtValorAnexo = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValorAnexo.setName("TextFieldExtValorAnexo");
				ivjTextFieldExtValorAnexo.setFocusAccelerator('d');
				ivjTextFieldExtValorAnexo.setMaxLength(250);
				ivjTextFieldExtValorAnexo.setEnabled(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValorAnexo;
	}

	/**
	 * Return the TextFieldExtVariable01 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable01() {
		if (ivjTextFieldExtVariable01 == null) {
			try {
				ivjTextFieldExtVariable01 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable01.setName("TextFieldExtVariable01");
				ivjTextFieldExtVariable01.setMaxLength(100);
				ivjTextFieldExtVariable01.setEditable(false);
				// user code begin {1}
				ivjTextFieldExtVariable01.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable01;
	}

	/**
	 * Return the TextFieldExtVariable02 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable02() {
		if (ivjTextFieldExtVariable02 == null) {
			try {
				ivjTextFieldExtVariable02 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable02.setName("TextFieldExtVariable02");
				ivjTextFieldExtVariable02.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable02.setEditable(false);
				ivjTextFieldExtVariable02.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable02;
	}

	/**
	 * Return the TextFieldExtVariable03 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable03() {
		if (ivjTextFieldExtVariable03 == null) {
			try {
				ivjTextFieldExtVariable03 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable03.setName("TextFieldExtVariable03");
				ivjTextFieldExtVariable03.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable03.setEditable(false);
				ivjTextFieldExtVariable03.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable03;
	}

	/**
	 * Return the TextFieldExtVariable04 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable04() {
		if (ivjTextFieldExtVariable04 == null) {
			try {
				ivjTextFieldExtVariable04 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable04.setName("TextFieldExtVariable04");
				ivjTextFieldExtVariable04.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable04.setEditable(false);
				ivjTextFieldExtVariable04.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable04;
	}

	/**
	 * Return the TextFieldExtVariable05 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable05() {
		if (ivjTextFieldExtVariable05 == null) {
			try {
				ivjTextFieldExtVariable05 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable05.setName("TextFieldExtVariable05");
				ivjTextFieldExtVariable05.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable05.setEditable(false);
				ivjTextFieldExtVariable05.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable05;
	}

	/**
	 * Return the TextFieldExtVariable06 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable06() {
		if (ivjTextFieldExtVariable06 == null) {
			try {
				ivjTextFieldExtVariable06 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable06.setName("TextFieldExtVariable06");
				ivjTextFieldExtVariable06.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable06.setEditable(false);
				ivjTextFieldExtVariable06.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable06;
	}

	/**
	 * Return the TextFieldExtVariable07 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable07() {
		if (ivjTextFieldExtVariable07 == null) {
			try {
				ivjTextFieldExtVariable07 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable07.setName("TextFieldExtVariable07");
				ivjTextFieldExtVariable07.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable07.setEditable(false);
				ivjTextFieldExtVariable07.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable07;
	}

	/**
	 * Return the TextFieldExtVariable08 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable08() {
		if (ivjTextFieldExtVariable08 == null) {
			try {
				ivjTextFieldExtVariable08 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable08.setName("TextFieldExtVariable08");
				ivjTextFieldExtVariable08.setMaxLength(100);
				// user code begin {1}
				ivjTextFieldExtVariable08.setEditable(false);
				ivjTextFieldExtVariable08.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable08;
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setOpaque(false);
			jToolBar.setFloatable(false);
			jToolBar.add(getJButtonBack());
			jToolBar.add(getJButtonNext());
		}
		return jToolBar;
	}

	/**
	 * This method initializes jButtonBack
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBack() {
		if (jButtonBack == null) {
			jButtonBack = new javax.swing.JButton();
			jButtonBack.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/previous.png")));
			jButtonBack.setContentAreaFilled(true);
			jButtonBack.setMargin(new java.awt.Insets(0, 0, 0, 0));
			jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonBack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButtonBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					switch (paletaSeleccionada) {
					case 0:
						ivjJTabbedPane1.setSelectedIndex(4);
						break;
					case 1:
						ivjJTabbedPane1.setSelectedIndex(0);
						break;
					case 2:
						ivjJTabbedPane1.setSelectedIndex(1);
						break;
					case 3:
						ivjJTabbedPane1.setSelectedIndex(2);
						break;
					case 4:
						ivjJTabbedPane1.setSelectedIndex(3);
						break;
					default:
						break;
					}
				}
			});
		}
		return jButtonBack;
	}

	/**
	 * This method initializes jButtonNext
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNext() {
		if (jButtonNext == null) {
			jButtonNext = new javax.swing.JButton();
			jButtonNext.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/next.png")));
			jButtonNext.setMargin(new java.awt.Insets(0, 0, 0, 0));
			jButtonNext.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonNext.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButtonNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					switch (paletaSeleccionada) {
					case 0:
						ivjJTabbedPane1.setSelectedIndex(1);
						break;
					case 1:
						ivjJTabbedPane1.setSelectedIndex(2);
						break;
					case 2:
						ivjJTabbedPane1.setSelectedIndex(3);
						break;
					case 3:
						ivjJTabbedPane1.setSelectedIndex(4);
						break;
					case 4:
						ivjJTabbedPane1.setSelectedIndex(0);
						break;
					default:
						break;
					}
				}
			});
		}
		return jButtonNext;
	}

	/**
	 * This method initializes jToolBar1
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.setFloatable(false);
			jToolBar1.setOpaque(false);
			jToolBar1.add(getJButtonImprimir());
		}
		return jToolBar1;
	}

	/**
	 * This method initializes jButtonImprimir
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/Printer32x32.png")));
			jButtonImprimir.setText("");
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
	 *
	 */
	private boolean validar() {
		if (getEstadoABM().esEliminado()) {
			if (InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción",
					InfoView.YES_NO_OPTION) == InfoView.YES_OPTION)
				return true;
			else
				return false;
		} else {
			if (!validarBasico()) {
				return false;
			}
			if (getTextFieldExtNombre().isDataMissing("Escriba un nombre !"))
				return false;
		}
		return true;
	}

	/**
	 *
	 */
	private boolean validarBasico() {

		if (getTextAreaExtSQL().isDataMissing("Escriba una sentencia SQL !"))
			return false;
		if (getJCheckBoxAnexo().isSelected()) {
			if (getTextFieldExtEtiquetaAnexo().isDataMissing("Ingrese una etiqueta para el anexo"))
				return false;
			if (getMultiChoiceTipoAnexo().isDataMissing("Seleccione un tipo de anexo"))
				return false;
			if (getMultiChoiceTipoAnexo().getSelectedOption().compareTo("1") == 0) {
				if (getTextFieldExtValorAnexo().isDataMissing("Ingrese un valor para el anexo"))
					return false;
			} else {
				if (getTextAreaExtSQLAnexo().isDataMissing("Ingrese un SQL para el anexo"))
					return false;
			}
		}
		if (!getDetallesImpresionPanel().validar())
			return false;

		return getDetallesPresentacionPanel().validar();
	}

	/**
	 *
	 */
	private boolean validarParaImpresion() {

		if (!validarBasico())
			return false;

		return validarVariables();
	}

	/**
	 *
	 */
	private boolean validarVariables() {

		if (getTextFieldExtVariable01().getValue() != null && getTextFieldExtVariable01().getValue().trim().length() > 0
				&& getTextFieldExtVariable01().getValue().startsWith("*")) {
			if (getTextFieldExtValor01().getValue() == null || getTextFieldExtValor01().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable01().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable02().getValue() != null && getTextFieldExtVariable02().getValue().trim().length() > 0
				&& getTextFieldExtVariable02().getValue().startsWith("*")) {
			if (getTextFieldExtValor02().getValue() == null || getTextFieldExtValor02().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable02().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable03().getValue() != null && getTextFieldExtVariable03().getValue().trim().length() > 0
				&& getTextFieldExtVariable03().getValue().startsWith("*")) {
			if (getTextFieldExtValor03().getValue() == null || getTextFieldExtValor03().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable03().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable04().getValue() != null && getTextFieldExtVariable04().getValue().trim().length() > 0
				&& getTextFieldExtVariable04().getValue().startsWith("*")) {
			if (getTextFieldExtValor04().getValue() == null || getTextFieldExtValor04().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable04().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable05().getValue() != null && getTextFieldExtVariable05().getValue().trim().length() > 0
				&& getTextFieldExtVariable05().getValue().startsWith("*")) {
			if (getTextFieldExtValor05().getValue() == null || getTextFieldExtValor05().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable05().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable06().getValue() != null && getTextFieldExtVariable06().getValue().trim().length() > 0
				&& getTextFieldExtVariable06().getValue().startsWith("*")) {
			if (getTextFieldExtValor06().getValue() == null || getTextFieldExtValor06().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable06().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable07().getValue() != null && getTextFieldExtVariable07().getValue().trim().length() > 0
				&& getTextFieldExtVariable07().getValue().startsWith("*")) {
			if (getTextFieldExtValor07().getValue() == null || getTextFieldExtValor07().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable07().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable08().getValue() != null && getTextFieldExtVariable08().getValue().trim().length() > 0
				&& getTextFieldExtVariable08().getValue().startsWith("*")) {
			if (getTextFieldExtValor08().getValue() == null || getTextFieldExtValor08().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable08().getValue() + " no tiene valor!");
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 */
	private void visualManageValorAnexo() {
		if (getMultiChoiceTipoAnexo().getSelectedIndex() == 0) {
			getTextFieldExtValorAnexo().setEnabled(true);
			getTextAreaExtSQLAnexo().setEnabled(false);
		} else {
			getTextFieldExtValorAnexo().setEnabled(false);
			getTextAreaExtSQLAnexo().setEnabled(true);
		}
	}

	/**
	 *
	 */
	private void _buildAll() {

		Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
		Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
		textFieldsVariables.addElement(getTextFieldExtVariable01());
		textFieldsValores.addElement(getTextFieldExtValor01());
		textFieldsVariables.addElement(getTextFieldExtVariable02());
		textFieldsValores.addElement(getTextFieldExtValor02());
		textFieldsVariables.addElement(getTextFieldExtVariable03());
		textFieldsValores.addElement(getTextFieldExtValor03());
		textFieldsVariables.addElement(getTextFieldExtVariable04());
		textFieldsValores.addElement(getTextFieldExtValor04());
		textFieldsVariables.addElement(getTextFieldExtVariable05());
		textFieldsValores.addElement(getTextFieldExtValor05());
		textFieldsVariables.addElement(getTextFieldExtVariable06());
		textFieldsValores.addElement(getTextFieldExtValor06());
		textFieldsVariables.addElement(getTextFieldExtVariable07());
		textFieldsValores.addElement(getTextFieldExtValor07());
		textFieldsVariables.addElement(getTextFieldExtVariable08());
		textFieldsValores.addElement(getTextFieldExtValor08());

		DefinicionReporte definicionReporte = new DefinicionReporte();
		this.llenarDefinicionReporte(definicionReporte);

		getController()._buildAll(definicionReporte, getDetallesPresentacionPanel(), getDetallesImpresionPanel(), textFieldsVariables, textFieldsValores);

		_stop();
	}

	/**
	 *
	 */
	private void _stop() {
		getBarPanel().stop();
		getJButtonImprimir().setEnabled(true);
	}

	/**
	 *
	 */
	private void llenarDefinicionReporte(DefinicionReporte definicionReporte) {

		definicionReporte.setNombre(getTextFieldExtNombre().getValue().trim());
		definicionReporte.setSentenciaSql(getTextAreaExtSQL().getValue().trim());

		getDetallesPresentacionPanel()._fillData(definicionReporte);

		definicionReporte.setLlevaAnexo(getJCheckBoxAnexo().isSelected());

		int temp1 = 1;
		if (getMultiChoiceTipoAnexo().getSelectedOption() != null && getMultiChoiceTipoAnexo().getSelectedOption().trim().length() > 0) {
			temp1 = Integer.valueOf(getMultiChoiceTipoAnexo().getSelectedOption()).intValue();
		}
		definicionReporte.setTipoAnexo(temp1);

		definicionReporte.setEtiquetaAnexo(getTextFieldExtEtiquetaAnexo().getValue().trim());
		definicionReporte.setValorAnexo(getTextFieldExtValorAnexo().getValue().trim());
		definicionReporte.setSqlAnexo(StringTools.parseComilla(getTextAreaExtSQLAnexo().getValue().trim()));

		getDetallesImpresionPanel()._fillData(definicionReporte);

		definicionReporte.setTipo(SystemProperties.RUNTIME_SISTEMA_NAME);
	}

	/**
	 *
	 */
	private void _refrescarDetallesTabla() {
		// hacer que se guarden los valores de variables anteriores
		String variableAnterior01 = getTextFieldExtValor01().getValue();
		String variableAnterior02 = getTextFieldExtValor02().getValue();
		String variableAnterior03 = getTextFieldExtValor03().getValue();
		String variableAnterior04 = getTextFieldExtValor04().getValue();
		String variableAnterior05 = getTextFieldExtValor05().getValue();
		String variableAnterior06 = getTextFieldExtValor06().getValue();
		String variableAnterior07 = getTextFieldExtValor07().getValue();
		String variableAnterior08 = getTextFieldExtValor08().getValue();
		// ...variables
		Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
		Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
		textFieldsVariables.addElement(getTextFieldExtVariable01());
		textFieldsValores.addElement(getTextFieldExtValor01());
		textFieldsVariables.addElement(getTextFieldExtVariable02());
		textFieldsValores.addElement(getTextFieldExtValor02());
		textFieldsVariables.addElement(getTextFieldExtVariable03());
		textFieldsValores.addElement(getTextFieldExtValor03());
		textFieldsVariables.addElement(getTextFieldExtVariable04());
		textFieldsValores.addElement(getTextFieldExtValor04());
		textFieldsVariables.addElement(getTextFieldExtVariable05());
		textFieldsValores.addElement(getTextFieldExtValor05());
		textFieldsVariables.addElement(getTextFieldExtVariable06());
		textFieldsValores.addElement(getTextFieldExtValor06());
		textFieldsVariables.addElement(getTextFieldExtVariable07());
		textFieldsValores.addElement(getTextFieldExtValor07());
		textFieldsVariables.addElement(getTextFieldExtVariable08());
		textFieldsValores.addElement(getTextFieldExtValor08());

		getController()._showVariables(getBo(), textFieldsVariables, textFieldsValores);
		// ...
		String sql = getTextAreaExtSQL().getValue().trim();
		getDetallesPresentacionPanel()._refrescarDetallesTabla(sql);
		// se recolocan los valores de las variables
		getTextFieldExtValor01().setValue(variableAnterior01);
		getTextFieldExtValor02().setValue(variableAnterior02);
		getTextFieldExtValor03().setValue(variableAnterior03);
		getTextFieldExtValor04().setValue(variableAnterior04);
		getTextFieldExtValor05().setValue(variableAnterior05);
		getTextFieldExtValor06().setValue(variableAnterior06);
		getTextFieldExtValor07().setValue(variableAnterior07);
		getTextFieldExtValor08().setValue(variableAnterior08);
	}

	/**
	 *
	 */
	private void _prePrint() {
		if (!validarParaImpresion()) {
			return;
		}
		getJButtonImprimir().setEnabled(false);
		getBarPanel().start();
		Thread aThread = new Thread(new Runnable() {
			public void run() {
				_buildAll();
			}
		});
		aThread.start();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
