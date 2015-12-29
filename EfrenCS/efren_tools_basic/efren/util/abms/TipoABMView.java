package efren.util.abms;

import java.util.Vector;

import efren.util.entidades.Tipo;
import efren.util.gui.table.DataTableColumn;


public class TipoABMView extends javax.swing.JInternalFrame implements efren.util.gui.table.DataTablePanelListener, java.beans.PropertyChangeListener, javax.swing.event.InternalFrameListener {
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private efren.util.ABMViewObserver ivjobserver = null;
	private efren.util.gui.table.DataTablePanel ivjDataTablePanel = null;
	private efren.util.gui.FinderSQLPanel ivjFinderSQLPanel1 = null;
	/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public TipoABMView() {
	super();
	initialize();
}
/**
 * SancionABMView constructor comment.
 * @param title java.lang.String
 */
public TipoABMView(String title) {
	super(title);
}
public void _cerrar() {
    getobserver().cerrarVentanas();
    this.dispose();
}
public void _manejoAccesos(String classArgs) {

	efren.util.menu.BarManager.manageBar(classArgs, getDataTablePanel());
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
 * connEtoC1:  (Bar02Panel2.bar02Panel.button02ActionPerformed(java.util.EventObject) --> SancionABMView.dataFetch()V)
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
 * connEtoC2:  (Bar02Panel1.bar02Panel.button00ActionPerformed(java.util.EventObject) --> SancionABMView.nuevo()V)
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
 * connEtoC3:  (Bar02Panel1.bar02Panel.button01ActionPerformed(java.util.EventObject) --> SancionABMView.modificar()V)
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
 * connEtoC4:  (Bar02Panel1.bar02Panel.button03ActionPerformed(java.util.EventObject) --> SancionABMView.eliminar()V)
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
 * connEtoC6:  (DataTablePanel.selectedObjectFromDoubleClick --> TipoABMView.modificar()V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.beans.PropertyChangeEvent arg1) {
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
 * connEtoM1:  (TipoABMView.initialize() --> FinderSQLPanel1.initAll()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1() {
	try {
		// user code begin {1}
		// user code end
		getFinderSQLPanel1().initAll();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP1SetTarget:  (DataTablePanel.this <--> FinderSQLPanel1.stContainerPanel)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP1SetTarget() {
	/* Set the target from the source */
	try {
		getFinderSQLPanel1().setDataTablePanel(getDataTablePanel());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
public void dataFetch() {

    try {
        getDataTablePanel().clearSelection();
        getDataTablePanel().removeAll();

        String where = getFinderSQLPanel1().sql();
        if (where.trim().length() > 0)
        	where = " WHERE " + where;
        else
			return;
        String s = "SELECT OID,TABLA,CAMPO,TIPO,DESCRIPCION,TIMESTAMP "
        	+ " FROM TIPO "
        	+ where
        	+ " ORDER BY TABLA, CAMPO, TIPO, DESCRIPCION";

        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        java.sql.Statement st = efren.util.Conn.conectar().createStatement();
        java.sql.ResultSet rs = st.executeQuery(s);

        efren.util.entidades.Tipo mb;
        while (rs.next()) {

            mb = new efren.util.entidades.Tipo();

            mb.setOid(rs.getLong(1));
            mb.setTabla(rs.getString(2).trim());
            mb.setCampo(rs.getString(3).trim());
            mb.setTipo(new Integer(rs.getInt(4)));
            mb.setDescripcion(rs.getString(5).trim());
            mb.setUtc(rs.getTimestamp(6));

            getDataTablePanel().add(mb);
        }
        st.close();
    } catch (Throwable t) {
        getDataTablePanel().clearSelection();
        getDataTablePanel().removeAll();
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        handleException(t);
    }

    this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
}
private void eliminar() throws Throwable {

	TipoABMDetailsView ventana = new TipoABMDetailsView();

	ventana.setObserverThis(getobserver());
	ventana.mainView = this;

	efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoEliminado("ELIMINAR Tipo");
	ventana.setAbmEstado(estado);

    efren.util.entidades.Tipo bo = (efren.util.entidades.Tipo) getDataTablePanel().getSelectedObject();
	ventana.bo = bo;
	ventana.initAll();

	getobserver().addFrame(this, ventana, String.valueOf(bo.getOid()), estado);
}
/**
 * Return the FinderSQLPanel1 property value.
 * @return efren.abm.beans.FinderSQLPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.FinderSQLPanel getFinderSQLPanel1() {
	if (ivjFinderSQLPanel1 == null) {
		try {
			ivjFinderSQLPanel1 = new efren.util.gui.FinderSQLPanel();
			ivjFinderSQLPanel1.setName("FinderSQLPanel1");
			ivjFinderSQLPanel1.setTABLE_NAME("TIPO");
			ivjFinderSQLPanel1.setCamposCount(2);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjFinderSQLPanel1;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsDataTablePanel = new java.awt.GridBagConstraints();
			constraintsDataTablePanel.gridx = 0; constraintsDataTablePanel.gridy = 1;
			constraintsDataTablePanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanel.weightx = 1.0;
			constraintsDataTablePanel.weighty = 1.0;
			constraintsDataTablePanel.ipady = -270;
			constraintsDataTablePanel.insets = new java.awt.Insets(0, 5, 5, 5);
			getJFrameContentPane().add(getDataTablePanel(), constraintsDataTablePanel);

			java.awt.GridBagConstraints constraintsFinderSQLPanel1 = new java.awt.GridBagConstraints();
			constraintsFinderSQLPanel1.gridx = 0; constraintsFinderSQLPanel1.gridy = 0;
			constraintsFinderSQLPanel1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsFinderSQLPanel1.weightx = 1.0;
			constraintsFinderSQLPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getFinderSQLPanel1(), constraintsFinderSQLPanel1);
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
		ivjDataTablePanel = new efren.util.gui.table.DataTablePanel();
		ivjDataTablePanel.setName("DataTablePanel");
		ivjDataTablePanel.setOpcionesBarButton02Visible(false);
		Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
		columnsDefinition.add(new DataTableColumn("Tabla", 150, "tabla", false, null));
		columnsDefinition.add(new DataTableColumn("Campo", 150, "campo", false, null));
		columnsDefinition.add(new DataTableColumn("Tipo", 60, "tipo", false, null));
		columnsDefinition.add(new DataTableColumn("Descripción.", 200, "Descripcion", false, null));
		ivjDataTablePanel.setColumnsDefinition(Tipo.class, columnsDefinition);
	}
	return ivjDataTablePanel;
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
	getDataTablePanel().addDataTablePanelListener(this);
	getDataTablePanel().addPropertyChangeListener(this);
	connPtoP1SetTarget();
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("TipoABMView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(727, 428);
		setTitle("Tipos de datos");
		setContentPane(getJFrameContentPane());
		initConnections();
		connEtoM1();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    efren.util.WindowManager.centerWindow(this);
    this.addInternalFrameListener(this);
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
private void modificar() throws Throwable {

    if (!(getDataTablePanel().getOpcionesBarButton01Visible() && getDataTablePanel().getOpcionesBarButton01Enabled()))
        return;//manejo de doble click

    TipoABMDetailsView ventana = new TipoABMDetailsView();

    ventana.setObserverThis(getobserver());
    ventana.mainView = this;

    efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoModificado("MODIFICAR Tipo");
    ventana.setAbmEstado(estado);

    efren.util.entidades.Tipo bo = (efren.util.entidades.Tipo) getDataTablePanel().getSelectedObject();
    ventana.bo = bo;
    ventana.initAll();

    getobserver().addFrame(this, ventana, String.valueOf(bo.getOid()), estado);
}
private void nuevo() throws Throwable {

	TipoABMDetailsView ventana = new TipoABMDetailsView();

	ventana.setObserverThis(getobserver());
	ventana.mainView = this;

	efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoNuevo("NUEVO Tipo");
	ventana.setAbmEstado(estado);

	efren.util.entidades.Tipo bo = new efren.util.entidades.Tipo();
	ventana.bo = bo;
	ventana.initAll();

	getobserver().addFrame(this, ventana, String.valueOf(bo.getOid()), estado);
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
		connEtoC6(evt);
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
}
