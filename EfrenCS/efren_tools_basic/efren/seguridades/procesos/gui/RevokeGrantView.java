package efren.seguridades.procesos.gui;

import java.util.Vector;

import efren.util.SystemLogManager;
import efren.util.config.SystemProperties;
import efren.util.gui.table.DataTableColumn;

public class RevokeGrantView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, efren.util.gui.MultiChoiceListener, javax.swing.event.InternalFrameListener {
    protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private javax.swing.JPanel ivjJPanel = null;
	private efren.util.gui.table.DataTablePanel ivjDataTablePanelUsuarios = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;
    private java.sql.Statement st;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JTabbedPane ivjJTabbedPane = null;
	private javax.swing.JPanel ivjPage111 = null;
	private efren.util.gui.text.TextAreaExt ivjTextAreaExtLog = null;
	private efren.util.gui.ProgressBarWithThreadPanel ivjBarPanel = null;
    boolean processing = false;
	private efren.util.gui.table.DataTablePanel ivjDataTablePanelTablas = null;
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBoxPermiso = null;
	private efren.util.gui.LabelExt ivjLabelExt2 = null;
	private efren.util.gui.MultiChoice ivjMultiChoiceTipoTablas = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanelSelectAllTables = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanelSelectAllUsers = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RevokeGrantView() {
	super();
	initialize();
}
/**
 * EstructuraOrganicaABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public RevokeGrantView(String title) {
	super(title);
}
public void _cerrar() {
	if (processing)
		return;
	this.dispose();
}
/**
 * Method to handle events for the BarraAceptarCancelarPanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void aceptarClicked(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getBarraAceptarCancelarPanelSelectAllTables())
		connEtoM1(newEvent);
	if (newEvent.getSource() == getBarraAceptarCancelarPanelSelectAllUsers())
		connEtoM2(newEvent);
	if (newEvent.getSource() == getBarraAceptarCancelarPanel())
		connEtoC1(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
/**
 * Method to handle events for the BarraAceptarCancelarPanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void cancelarClicked(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getBarraAceptarCancelarPanel())
		connEtoC2(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * connEtoC1:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> EstructuraOrganicaABMDetailsView.aceptar()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.generar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject) --> RevokeGrantView.cancelar()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this._cerrar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (MultiChoiceTipoTablas.multiChoice.selectedOptionChanged(java.util.EventObject) --> RevokeGrantView.llenarListaTablas()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.llenarListaTablas();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  ( (OptionABMDetailsView,window.windowOpened(java.awt.event.WindowEvent) --> bo,this).normalResult --> OptionABMDetailsView.initManageAttributes()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4() {
	try {
		// user code begin {1}
		// user code end
		this.initManageAttributes();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM1:  (BarraAceptarCancelarPanelSelectAllTables.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> DataTablePanelTablas.selectAllRows()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		getDataTablePanelTablas().selectAllRows();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM2:  (BarraAceptarCancelarPanelSelectAllUsers.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> DataTablePanelUsuarios.selectAllRows()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM2(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		getDataTablePanelUsuarios().selectAllRows();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
private void crearPermisos() throws Throwable {
	efren.util.CalendarManager cm = new efren.util.CalendarManager();
	getTextAreaExtLog().append("-- INICIO: " + cm.getAbsoluteRegionalDateExpression() + "\n");
	// con sentencias SQL
	String sql = "";
	String nombreUsuario = "", nombreTabla = "", nombreSchema = "";
	java.util.Vector usuarios = getDataTablePanelUsuarios().getSelectedObjects();
	java.util.Vector tablas = getDataTablePanelTablas().getSelectedObjects();
	for (int u = 0; u < tablas.size(); u++) {
		nombreTabla = ((SecPermiso) tablas.elementAt(u)).getNombreUsuario();
		nombreSchema = SystemProperties.SCHEMA_PRINCIPAL;
		if (getMultiChoiceTipoTablas().getSelectedIndex() == 1)
			nombreSchema = SystemProperties.SCHEMA_SEGURIDADES;
		getTextAreaExtLog().append("--- " + nombreTabla + "\n");
		for (int i = 0; i < usuarios.size(); i++) {
			try {
				nombreUsuario = ((SecPermiso) usuarios.elementAt(i)).getUserName();
				sql = getObjectComboBoxPermiso().getSelectedItem()+" ON " + nombreSchema + "." + nombreTabla + " TO " + nombreUsuario + " ";
				st.execute(sql);
				efren.util.Conn.conectar().commit();
			} catch (Throwable t) {
				//efren.dialogs.InfoView.showErrorDialog(this, t.getMessage());
				cm = new efren.util.CalendarManager();
				getTextAreaExtLog().append("- ERROR: " + t.getMessage() + " " + cm.getAbsoluteRegionalDateExpression() + "\n");
			}
		}
	}
	try {
		efren.util.Conn.conectar().commit();
	} catch (Throwable t) {
		cm = new efren.util.CalendarManager();
		getTextAreaExtLog().append("- ERROR: " + t.getMessage() + " " + cm.getAbsoluteRegionalDateExpression() + "\n");
	}
	cm = new efren.util.CalendarManager();
	getTextAreaExtLog().append("-- FIN: " + cm.getAbsoluteRegionalDateExpression() + "\n");
	//se detiene todo
	getBarPanel().stop();
	getBarraAceptarCancelarPanel().setButtonAceptarEnabled(true);
	getBarraAceptarCancelarPanel().setButtonCancelarEnabled(true);
	processing = false;
	efren.util.gui.dialogs.InfoView.showInformationDialog(this, "¡ El proceso ha terminado bien !");
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue java.lang.Object
 * @param newValue java.lang.Object
 */
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
private void generar() throws Throwable {
	if (!validar())
		return;
	getBarraAceptarCancelarPanel().setButtonAceptarEnabled(false);
	getBarraAceptarCancelarPanel().setButtonCancelarEnabled(false);
	processing = true;
	getBarPanel().start();
	Thread aThread = new Thread(new Runnable() {
		public void run() {
			try {
				crearPermisos();
			} catch (Throwable t3) {
				t3.getMessage();
			}
		}
	});
	aThread.start();
}
/**
 * Return the BarPanel property value.
 * @return efren.util.gui.ProgressBarWithThreadPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.ProgressBarWithThreadPanel getBarPanel() {
	if (ivjBarPanel == null) {
		try {
			ivjBarPanel = new efren.util.gui.ProgressBarWithThreadPanel();
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
 * Return the BarraAceptarCancelarPanel property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
	if (ivjBarraAceptarCancelarPanel == null) {
		try {
			ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
			ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cerrar");
			ivjBarraAceptarCancelarPanel.setButtonAceptarMnemonic('G');
			ivjBarraAceptarCancelarPanel.setButtonAceptarText("Generar permisos");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraAceptarCancelarPanel;
}
/**
 * Return the BarraAceptarCancelarPanelSelectAllTables property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanelSelectAllTables() {
	if (ivjBarraAceptarCancelarPanelSelectAllTables == null) {
		try {
			ivjBarraAceptarCancelarPanelSelectAllTables = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanelSelectAllTables.setName("BarraAceptarCancelarPanelSelectAllTables");
			ivjBarraAceptarCancelarPanelSelectAllTables.setButtonCancelarVisible(false);
			//ivjBarraAceptarCancelarPanelSelectAllTables.setIconType(2);
			ivjBarraAceptarCancelarPanelSelectAllTables.setButtonAceptarMnemonic('S');
			ivjBarraAceptarCancelarPanelSelectAllTables.setButtonAceptarText("Seleccionar todo");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraAceptarCancelarPanelSelectAllTables;
}
/**
 * Return the BarraAceptarCancelarPanelSelectAllUsers property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanelSelectAllUsers() {
	if (ivjBarraAceptarCancelarPanelSelectAllUsers == null) {
		try {
			ivjBarraAceptarCancelarPanelSelectAllUsers = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanelSelectAllUsers.setName("BarraAceptarCancelarPanelSelectAllUsers");
			ivjBarraAceptarCancelarPanelSelectAllUsers.setButtonCancelarVisible(false);
			//ivjBarraAceptarCancelarPanelSelectAllUsers.setIconType(2);
			ivjBarraAceptarCancelarPanelSelectAllUsers.setButtonAceptarMnemonic('e');
			ivjBarraAceptarCancelarPanelSelectAllUsers.setButtonAceptarText("Seleccionar todo");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraAceptarCancelarPanelSelectAllUsers;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel() {
	if (ivjJPanel == null) {
		try {
			ivjJPanel = new javax.swing.JPanel();
			ivjJPanel.setName("JPanel");
			ivjJPanel.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsDataTablePanelUsuarios = new java.awt.GridBagConstraints();
			constraintsDataTablePanelUsuarios.gridx = 1; constraintsDataTablePanelUsuarios.gridy = 1;
constraintsDataTablePanelUsuarios.gridheight = 2;
			constraintsDataTablePanelUsuarios.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanelUsuarios.weightx = 1.0;
			constraintsDataTablePanelUsuarios.weighty = 1.0;
			constraintsDataTablePanelUsuarios.insets = new java.awt.Insets(0, 10, 0, 5);
			getJPanel().add(getDataTablePanelUsuarios(), constraintsDataTablePanelUsuarios);

			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 1; constraintsLabelExt1.gridy = 0;
			constraintsLabelExt1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt1.weightx = 1.0;
			constraintsLabelExt1.insets = new java.awt.Insets(5, 15, 0, 5);
			getJPanel().add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsDataTablePanelTablas = new java.awt.GridBagConstraints();
			constraintsDataTablePanelTablas.gridx = 0; constraintsDataTablePanelTablas.gridy = 2;
			constraintsDataTablePanelTablas.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanelTablas.weightx = 1.0;
			constraintsDataTablePanelTablas.weighty = 1.0;
			constraintsDataTablePanelTablas.insets = new java.awt.Insets(0, 10, 0, 5);
			getJPanel().add(getDataTablePanelTablas(), constraintsDataTablePanelTablas);

			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 0; constraintsLabelExt.gridy = 0;
			constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt.weightx = 1.0;
			constraintsLabelExt.insets = new java.awt.Insets(5, 15, 0, 5);
			getJPanel().add(getLabelExt(), constraintsLabelExt);

			java.awt.GridBagConstraints constraintsObjectComboBoxPermiso = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxPermiso.gridx = 1; constraintsObjectComboBoxPermiso.gridy = 4;
			constraintsObjectComboBoxPermiso.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxPermiso.weightx = 1.0;
			constraintsObjectComboBoxPermiso.insets = new java.awt.Insets(10, 10, 10, 10);
			getJPanel().add(getObjectComboBoxPermiso(), constraintsObjectComboBoxPermiso);

			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 0; constraintsLabelExt2.gridy = 4;
			constraintsLabelExt2.anchor = java.awt.GridBagConstraints.EAST;
			constraintsLabelExt2.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel().add(getLabelExt2(), constraintsLabelExt2);

			java.awt.GridBagConstraints constraintsMultiChoiceTipoTablas = new java.awt.GridBagConstraints();
			constraintsMultiChoiceTipoTablas.gridx = 0; constraintsMultiChoiceTipoTablas.gridy = 1;
			constraintsMultiChoiceTipoTablas.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel().add(getMultiChoiceTipoTablas(), constraintsMultiChoiceTipoTablas);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanelSelectAllTables = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanelSelectAllTables.gridx = 0; constraintsBarraAceptarCancelarPanelSelectAllTables.gridy = 3;
			constraintsBarraAceptarCancelarPanelSelectAllTables.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanelSelectAllTables.weightx = 1.0;
			constraintsBarraAceptarCancelarPanelSelectAllTables.insets = new java.awt.Insets(0, 0, 0, 5);
			getJPanel().add(getBarraAceptarCancelarPanelSelectAllTables(), constraintsBarraAceptarCancelarPanelSelectAllTables);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanelSelectAllUsers = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanelSelectAllUsers.gridx = 1; constraintsBarraAceptarCancelarPanelSelectAllUsers.gridy = 3;
			constraintsBarraAceptarCancelarPanelSelectAllUsers.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanelSelectAllUsers.weightx = 1.0;
			constraintsBarraAceptarCancelarPanelSelectAllUsers.insets = new java.awt.Insets(0, 0, 0, 5);
			getJPanel().add(getBarraAceptarCancelarPanelSelectAllUsers(), constraintsBarraAceptarCancelarPanelSelectAllUsers);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJTabbedPane = new java.awt.GridBagConstraints();
			constraintsJTabbedPane.gridx = 0; constraintsJTabbedPane.gridy = 0;
			constraintsJTabbedPane.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTabbedPane.weightx = 1.0;
			constraintsJTabbedPane.weighty = 1.0;
			constraintsJTabbedPane.insets = new java.awt.Insets(0, 0, 5, 0);
			getJPanel1().add(getJTabbedPane(), constraintsJTabbedPane);

			java.awt.GridBagConstraints constraintsBarPanel = new java.awt.GridBagConstraints();
			constraintsBarPanel.gridx = 0; constraintsBarPanel.gridy = 2;
			constraintsBarPanel.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsBarPanel.weightx = 1.0;
			constraintsBarPanel.ipady = 10;
			constraintsBarPanel.insets = new java.awt.Insets(5, 5, 5, 5);
			getJPanel1().add(getBarPanel(), constraintsBarPanel);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 0; constraintsBarraAceptarCancelarPanel.gridy = 1;
			constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 5, 5);
			getJPanel1().add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel1;
}
/**
 * Return the JTabbedPane property value.
 * @return javax.swing.JTabbedPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTabbedPane getJTabbedPane() {
	if (ivjJTabbedPane == null) {
		try {
			ivjJTabbedPane = new javax.swing.JTabbedPane();
			ivjJTabbedPane.setName("JTabbedPane");
			ivjJTabbedPane.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJTabbedPane.insertTab("Opciones", null, getJPanel(), null, 0);
			ivjJTabbedPane.insertTab("Log del proceso", null, getPage111(), null, 1);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTabbedPane;
}
/**
 * Return the MultiChoiceTipoTablas property value.
 * @return efren.util.gui.MultiChoice
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.MultiChoice getMultiChoiceTipoTablas() {
	if (ivjMultiChoiceTipoTablas == null) {
		try {
			ivjMultiChoiceTipoTablas = new efren.util.gui.MultiChoice();
			ivjMultiChoiceTipoTablas.setName("MultiChoiceTipoTablas");
			String ivjLocal51valueOptions [] = {
				"0",
				"1"};
			ivjMultiChoiceTipoTablas.setValueOptions(ivjLocal51valueOptions);
			String ivjLocal51nameOptions [] = {
				"Sistema",
				"Seguridades"};
			ivjMultiChoiceTipoTablas.setNameOptions(ivjLocal51nameOptions);
			ivjMultiChoiceTipoTablas.setSelectedIndex(0);
			ivjMultiChoiceTipoTablas.setTitle("Tipo de tablas");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMultiChoiceTipoTablas;
}
/**
 * Return the ObjectComboBoxPermiso property value.
 * @return efren.util.gui.combo.ObjectComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.combo.ObjectComboBox getObjectComboBoxPermiso() {
	if (ivjObjectComboBoxPermiso == null) {
		try {
			ivjObjectComboBoxPermiso = new efren.util.gui.combo.ObjectComboBox();
			ivjObjectComboBoxPermiso.setName("ObjectComboBoxPermiso");
			Object ivjLocal51items [] = {
				"GRANT SELECT,INSERT,UPDATE,DELETE,EXECUTE",
				"GRANT SELECT",
				"GRANT INSERT",
				"GRANT UPDATE",
				"GRANT DELETE",
				"GRANT EXECUTE",
				"GRANT ALL",
				"REVOKE SELECT,INSERT,UPDATE,DELETE,EXECUTE",
				"REVOKE SELECT",
				"REVOKE INSERT",
				"REVOKE UPDATE",
				"REVOKE DELETE",
				"REVOKE EXECUTE",
				"REVOKE ALL"};
			ivjObjectComboBoxPermiso.setItems(ivjLocal51items);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjObjectComboBoxPermiso;
}
/**
 * Return the Page111 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPage111() {
	if (ivjPage111 == null) {
		try {
			ivjPage111 = new javax.swing.JPanel();
			ivjPage111.setName("Page111");
			ivjPage111.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsTextAreaExtLog = new java.awt.GridBagConstraints();
			constraintsTextAreaExtLog.gridx = 0; constraintsTextAreaExtLog.gridy = 0;
			constraintsTextAreaExtLog.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextAreaExtLog.weightx = 1.0;
			constraintsTextAreaExtLog.weighty = 1.0;
			constraintsTextAreaExtLog.ipadx = -150;
			constraintsTextAreaExtLog.ipady = -200;
			constraintsTextAreaExtLog.insets = new java.awt.Insets(5, 5, 5, 5);
			getPage111().add(getTextAreaExtLog(), constraintsTextAreaExtLog);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPage111;
}
/**
 * Accessor for the propertyChange field.
 * @return java.beans.PropertyChangeSupport
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
/**
 * Return the DataTablePanelTablas property value.
 * @return efren.abm.beans.DataTablePanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.table.DataTablePanel getDataTablePanelTablas() {
	if (ivjDataTablePanelTablas == null) {
		try {
			ivjDataTablePanelTablas = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanelTablas.setName("DataTablePanelTablas");
			ivjDataTablePanelTablas.setToolTipText("Todas las tablas");
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("Nombre", 300, "NombreUsuario", false, null));
			ivjDataTablePanelTablas.setColumnsDefinition(SecPermiso.class, columnsDefinition);
			ivjDataTablePanelTablas.setOpcionesBarTotalVisible(false);
			ivjDataTablePanelTablas.setBuscarButtonVisible(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjDataTablePanelTablas;
}
/**
 * Return the DataTablePanelUsuarios property value.
 * @return efren.abm.beans.DataTablePanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.table.DataTablePanel getDataTablePanelUsuarios() {
	if (ivjDataTablePanelUsuarios == null) {
		try {
			ivjDataTablePanelUsuarios = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanelUsuarios.setName("DataTablePanelUsuarios");
			ivjDataTablePanelUsuarios.setToolTipText("Todos los usuarios");
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("user name", 90, "UserName", false, null));
			columnsDefinition.add(new DataTableColumn("Nombre de usuario", 220, "NombreUsuario", false, null));
			ivjDataTablePanelUsuarios.setColumnsDefinition(SecPermiso.class, columnsDefinition);
			ivjDataTablePanelUsuarios.setOpcionesBarTotalVisible(false);
			ivjDataTablePanelUsuarios.setBuscarButtonVisible(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjDataTablePanelUsuarios;
}
/**
 * Return the LabelExt property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt() {
	if (ivjLabelExt == null) {
		try {
			ivjLabelExt = new efren.util.gui.LabelExt();
			ivjLabelExt.setName("LabelExt");
			ivjLabelExt.setText("Tablas");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExt;
}
/**
 * Return the LabelExt1 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt1() {
	if (ivjLabelExt1 == null) {
		try {
			ivjLabelExt1 = new efren.util.gui.LabelExt();
			ivjLabelExt1.setName("LabelExt1");
			ivjLabelExt1.setText("Usuarios");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExt1;
}
/**
 * Return the LabelExt2 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt2() {
	if (ivjLabelExt2 == null) {
		try {
			ivjLabelExt2 = new efren.util.gui.LabelExt();
			ivjLabelExt2.setName("LabelExt2");
			ivjLabelExt2.setText("Permiso");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExt2;
}
/**
 * Return the TextAreaExtLog property value.
 * @return efren.util.gui.TextAreaExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextAreaExt getTextAreaExtLog() {
	if (ivjTextAreaExtLog == null) {
		try {
			ivjTextAreaExtLog = new efren.util.gui.text.TextAreaExt();
			ivjTextAreaExtLog.setName("TextAreaExtLog");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextAreaExtLog;
}
private void handleException(Throwable exception) {
	efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getMultiChoiceTipoTablas().addMultiChoiceListener(this);
	getBarraAceptarCancelarPanelSelectAllTables().addBarraAceptarCancelarPanelListener(this);
	getBarraAceptarCancelarPanelSelectAllUsers().addBarraAceptarCancelarPanelListener(this);
	getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("RevokeGrantView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(693, 511);
		setTitle("Generación de permisos");
		setContentPane(getJPanel1());
		initConnections();
		connEtoC4();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    efren.util.WindowManager.centerWindow(this);
    try {
        st = efren.util.Conn.conectar().createStatement();
    } catch (Throwable t) {
        t.getMessage();
    }
    this.addInternalFrameListener(this);
	// user code end
}
private void initManageAttributes() {
	llenarListaUsuarios();
	llenarListaTablas();
}
public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
    try {
        this._cerrar();
    } catch (Throwable t) {
        t.getMessage();
    }
}
public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e) {

}
public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameIconified(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
}
private void llenarListaTablas() {
    if (getMultiChoiceTipoTablas().getSelectedIndex() == 0)
        this.llenarListaTablasSistema();
    else
        this.llenarListaTablasSeguridades();
}
private void llenarListaTablasSeguridades() {
	try {
		java.sql.Connection con = efren.util.Conn.conectar();
		String s = " SELECT DISTINCT LTRIM(RTRIM(NAME)) AS NAME"
			+ " FROM SYSIBM.SYSTABLES "
			+ " WHERE CREATOR = '"+SystemProperties.SCHEMA_SEGURIDADES+"'"
			+ " ORDER BY NAME";
		java.sql.Statement st1 = con.createStatement();
		java.sql.ResultSet rs1 = st1.executeQuery(s);
		SecPermiso sp = null;
		getDataTablePanelTablas().removeAllRows();
		while (rs1.next()) {
			sp = new SecPermiso();
			sp.setNombreUsuario(rs1.getString(1));
			getDataTablePanelTablas().add(sp);
		}
		st1.close();
	} catch (Throwable t) {
		SystemLogManager.error(t.getMessage());
	}
}
private void llenarListaTablasSistema() {
	try {
		java.sql.Connection con = efren.util.Conn.conectar();
		String s = " SELECT DISTINCT LTRIM(RTRIM(NAME)) AS NAME"
			+ " FROM SYSIBM.SYSTABLES "
			+ " WHERE CREATOR = '"+SystemProperties.SCHEMA_PRINCIPAL+"'"
			+ " ORDER BY NAME";
		java.sql.Statement st1 = con.createStatement();
		java.sql.ResultSet rs1 = st1.executeQuery(s);
		SecPermiso sp = null;
		getDataTablePanelTablas().removeAllRows();
		while (rs1.next()) {
			sp = new SecPermiso();
			sp.setNombreUsuario(rs1.getString(1));
			getDataTablePanelTablas().add(sp);
		}
		st1.close();
	} catch (Throwable t) {
		System.out.println(t);
	}
}
private void llenarListaUsuarios() {
	try {
		java.sql.Connection con = efren.util.Conn.conectar();
		String s = " SELECT RTRIM(LTRIM(NOMBRE)), RTRIM(LTRIM(USERNAME)) AS UN "
					+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES + ".USUARIO "
					+ " ORDER BY UN ";
		java.sql.Statement st2 = con.createStatement();
		java.sql.ResultSet rs2 = st2.executeQuery(s);
		SecPermiso sp = null;
		while (rs2.next()) {
			sp = new SecPermiso();
			sp.setNombreUsuario(rs2.getString(1));
			sp.setUserName(rs2.getString(2));
			getDataTablePanelUsuarios().add(sp);
		}
		st2.close();
	} catch (Throwable t) {
		SystemLogManager.error(t.getMessage());
	}
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * Method to handle events for the MultiChoiceListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void selectedOptionChanged(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getMultiChoiceTipoTablas())
		connEtoC3(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the MultiChoiceListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void selectedOptionChanged1(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the MultiChoiceListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void selectedOptionChanged2(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the MultiChoiceListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void selectedOptionChanged3(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
private boolean validar() {
    try {
        java.util.Vector v = getDataTablePanelUsuarios().getSelectedObjects();
        if (v.size() == 0) {
            efren.util.gui.dialogs.InfoView.showErrorDialog(this, "Seleccione algunos usuarios o seleccione todos los usuarios !");
            return false;
        }
        if (getObjectComboBoxPermiso().isDataMissing("Seleccione el tipo de permiso !"))
            return false;
    } catch (Throwable t) {
        return false;
    }
    return true;
}
}
