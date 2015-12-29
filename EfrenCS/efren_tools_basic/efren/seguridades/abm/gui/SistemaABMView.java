package efren.seguridades.abm.gui;

import java.util.Vector;

import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecSistema;
import efren.util.gui.table.DataTableColumn;

public class SistemaABMView extends javax.swing.JInternalFrame implements efren.util.gui.table.DataTablePanelListener, efren.util.gui.text.TextFieldExtListener, java.beans.PropertyChangeListener, javax.swing.event.InternalFrameListener {
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private efren.util.ABMViewObserver ivjobserver = null;
	private efren.util.gui.table.DataTablePanel ivjDataTablePanel = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombrePrincipal = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SistemaABMView() {
	super();
	initialize();
}
/**
 * GradoABMView constructor comment.
 * @param title java.lang.String
 */
public SistemaABMView(String title) {
	super(title);
}
public void _cerrar() {
    getobserver().cerrarVentanas();
    this.dispose();
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getTextFieldExtNombrePrincipal())
		connEtoM1(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformedOnTextField(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void buscarPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getDataTablePanel())
		connEtoC1(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void comboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * connEtoC1:  (Bar02Panel.bar02Panel.button02ActionPerformed(java.util.EventObject) --> SystemABMView.dataFetch()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.dataFetch();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (Bar02Panel1.bar02Panel.button00ActionPerformed(java.util.EventObject) --> SystemABMView.nuevo()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.nuevo();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (Bar02Panel1.bar02Panel.button01ActionPerformed(java.util.EventObject) --> SystemABMView.modificar()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.modificar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (Bar02Panel1.bar02Panel.button03ActionPerformed(java.util.EventObject) --> SystemABMView.eliminar()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.eliminar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (DataTablePanel.selectedObjectFromDoubleClick --> SistemaABMView.modificar()V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.modificar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM1:  (TextFieldExtNombre.textFieldExt.actionPerformed(java.util.EventObject) --> DataTablePanel.doBuscarClick()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		getDataTablePanel().forceFireBuscarPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
public void dataFetch() {

	boolean porNombrePrincipal = !getTextFieldExtNombrePrincipal().esNulo();

	if (!porNombrePrincipal)
		return;

	this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

	try {

		java.sql.Statement st = efren.util.Conn.conectar().createStatement();
		String s =
		     "SELECT OID,RTRIM(LTRIM(NOMBREPRINCIPAL)) AS NOMBREPRINCIPAL,"
			+"RTRIM(LTRIM(NOMBRESECUNDARIO)) AS NOMBRESECUNDARIO,"
			+"RTRIM(LTRIM(SELECTOR)) AS SELECTOR, TIPO, ESTADO, TIMESTAMP "
			+" FROM "+SystemProperties.SCHEMA_SEGURIDADES+"."+"SISTEMA ";
		if (porNombrePrincipal)
			s = s + " WHERE RTRIM(LTRIM(UCASE(NOMBREPRINCIPAL))) LIKE "+getTextFieldExtNombrePrincipal().SQLFullText()+" ";
		s = s + " ORDER BY NOMBREPRINCIPAL ";
		java.sql.ResultSet rs = st.executeQuery(s);

		getDataTablePanel().clearSelection();
		getDataTablePanel().removeAll();

		efren.util.entidades.SecSistema mb;
		while (rs.next()) {

			mb = new efren.util.entidades.SecSistema();

			mb.setOid(rs.getLong(1));
			mb.setOid_str(String.valueOf(mb.getOid()));
			mb.setNombrePrincipal(rs.getString(2).trim());
			mb.setNombreSecundario(rs.getString(3).trim());
			mb.setSelector(rs.getString(4).trim());
			mb.setTipo(rs.getInt("TIPO"));
			mb.setEstado(rs.getInt("ESTADO"));
			mb.setTimestamp(rs.getTimestamp("TIMESTAMP"));

			getDataTablePanel().add(mb);
		}

		st.close();

	} catch (Throwable t) {
		getDataTablePanel().clearSelection();
		getDataTablePanel().removeAll();
		t.getMessage();
		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
}
private void eliminar()
    throws Exception {

    /**
     * según el pattern de State, se crea una clase de estado
     * y se la asigna a la ventana de detalles, y además se setea el título que se quiere que
     * aparezca en dicha ventana
     */

    SistemaABMDetailsView view = new SistemaABMDetailsView();

    view.setObserverThis(getobserver());
    view.mainView = this;

    efren.util.abm.estados.ABMEstado estado =
        new efren.util.abm.estados.ABMEstadoEliminado("ELIMINAR sistema en SEGURIDADES");
    view.setAbmEstado(estado);

    efren.util.entidades.SecSistema bo =
        (efren.util.entidades.SecSistema) getDataTablePanel().getSelectedObject();

    view.bo = bo;

    view.initAll();

    getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void field_keyReleased(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void focusGained(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void focusLost(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsDataTablePanel = new java.awt.GridBagConstraints();
			constraintsDataTablePanel.gridx = 0; constraintsDataTablePanel.gridy = 1;
			constraintsDataTablePanel.gridwidth = 2;
			constraintsDataTablePanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanel.weightx = 1.0;
			constraintsDataTablePanel.weighty = 1.0;
			constraintsDataTablePanel.ipady = -250;
			constraintsDataTablePanel.insets = new java.awt.Insets(0, 10, 10, 5);
			getJFrameContentPane().add(getDataTablePanel(), constraintsDataTablePanel);

			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0; constraintsLabelExt1.gridy = 0;
			constraintsLabelExt1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsTextFieldExtNombrePrincipal = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombrePrincipal.gridx = 1; constraintsTextFieldExtNombrePrincipal.gridy = 0;
			constraintsTextFieldExtNombrePrincipal.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombrePrincipal.weightx = 1.0;
			constraintsTextFieldExtNombrePrincipal.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getTextFieldExtNombrePrincipal(), constraintsTextFieldExtNombrePrincipal);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJFrameContentPane;
}
/**
 * Return the observer property value.
 * @return efren.util.ABMViewObserver
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.ABMViewObserver getobserver() {
    // user code begin {1}
    if (ivjobserver == null)
        ivjobserver = new efren.util.ABMViewObserver();
    // user code end
    return ivjobserver;
}
/**
 * Return the DataTablePanel property value.
 * @return efren.abm.beans.DataTablePanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.table.DataTablePanel getDataTablePanel() {
	if (ivjDataTablePanel == null) {
		try {
			ivjDataTablePanel = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanel.setName("DataTablePanel");
			ivjDataTablePanel.setOpcionesBarButton02Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("OID", 90, "Oid_str", false, null));
			columnsDefinition.add(new DataTableColumn("Nombre principal", 300, "NombrePrincipal", false, null));
			ivjDataTablePanel.setColumnsDefinition(SecSistema.class, columnsDefinition);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjDataTablePanel;
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
			ivjLabelExt1.setAlignmentX(java.awt.Component.RIGHT_ALIGNMENT);
			ivjLabelExt1.setText("Nombre");
			ivjLabelExt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
 * Return the TextFieldExtNombre property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtNombrePrincipal() {
	if (ivjTextFieldExtNombrePrincipal == null) {
		try {
			ivjTextFieldExtNombrePrincipal = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtNombrePrincipal.setName("TextFieldExtNombrePrincipal");
			ivjTextFieldExtNombrePrincipal.setMaxLength(50);
			ivjTextFieldExtNombrePrincipal.setValue("*");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtNombrePrincipal;
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getDataTablePanel().addDataTablePanelListener(this);
	getDataTablePanel().addPropertyChangeListener(this);
	getTextFieldExtNombrePrincipal().addTextFieldExtListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("SistemaABMView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(526, 356);
		setTitle("Sistemas en SEGURIDADES");
		setContentPane(getJFrameContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    efren.util.WindowManager.centerWindow(this);
    this.addInternalFrameListener(this);
    this.dataFetch();
	// user code end
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
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.awt.event.KeyEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void keyReleased(java.awt.event.KeyEvent newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
private void modificar() throws Exception {

    if (!(getDataTablePanel().getOpcionesBarButton01Visible() && getDataTablePanel().getOpcionesBarButton01Enabled()))
        return;
    //manejo de doble click

    SistemaABMDetailsView view = new SistemaABMDetailsView();

    view.setObserverThis(getobserver());
    view.mainView = this;

    efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoModificado("MODIFICAR sistema en SEGURIDADES");
    view.setAbmEstado(estado);

    efren.util.entidades.SecSistema bo = (efren.util.entidades.SecSistema) getDataTablePanel().getSelectedObject();

    view.bo = bo;

    view.initAll();

    getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
}
private void nuevo() throws Throwable {

	/**
	 * según el pattern de State, se crea una clase de estado
	 * y se la asigna a la ventana de detalles, y además se setea el título que se quiere que
	 * aparezca en dicha ventana
	 */

	SistemaABMDetailsView view = new SistemaABMDetailsView();

	view.setObserverThis(getobserver());
	view.mainView = this;

	efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoNuevo("NUEVO sistema en SEGURIDADES");
    view.setAbmEstado(estado);

	efren.util.entidades.SecSistema bo = new efren.util.entidades.SecSistema();
	bo.setOid(efren.util.OidManager.newOid());

	view.bo = bo;

	getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton00ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getDataTablePanel())
		connEtoC2(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton01ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getDataTablePanel())
		connEtoC3(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton02ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton03ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getDataTablePanel())
		connEtoC4(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton10ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the PropertyChangeListener interface.
 * @param evt java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void propertyChange(java.beans.PropertyChangeEvent evt) {
	// user code begin {1}
	// user code end
	if (evt.getSource() == getDataTablePanel() && (evt.getPropertyName().equals("selectedObjectFromDoubleClick")))
		connEtoC5(evt);
	// user code begin {2}
	// user code end
}
/**
 * Set the observer to a new value.
 * @param newValue efren.util.ABMViewObserver
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void setobserver(efren.util.ABMViewObserver newValue) {
	if (ivjobserver != newValue) {
		try {
			ivjobserver = newValue;
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	// user code begin {3}
	// user code end
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void textDateMouseClicked(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the TextFieldExtListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void textFieldExtkeyReleased(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
}
