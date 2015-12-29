package efren.util.abms;

import efren.util.AuditoriaManager;


public class FileDefinitionABMDetailsView
    extends javax.swing.JInternalFrame
    implements
        efren.util.gui.bars.BarraAceptarCancelarPanelListener,
        javax.swing.event.InternalFrameListener {
	        
    private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelar = null;
    private javax.swing.JPanel ivjJFrameContentPane = null;
    public efren.util.abm.estados.ABMEstado abmEstado;
    protected transient java.beans.PropertyChangeSupport propertyChange;
    private efren.util.ABMViewObserver ivjobserver = null;
    //...
    public FileDefinitionABMView mainView;
    public efren.util.entidades.FileDefinition bo;
    private efren.util.gui.LabelExt ivjLabelExt = null;
    private efren.util.gui.LabelExt ivjLabelExt2 = null;
    private efren.util.gui.text.TextAreaExt ivjTextAreaExtSentenciaSQL = null;
    private javax.swing.JScrollPane ivjJScrollPane1 = null;
    private String sqlParte1, sqlParte2, sqlParte3;
    private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public FileDefinitionABMDetailsView() {
	super();
	initialize();
}
/**
 * SancionABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public FileDefinitionABMDetailsView(String title) {
	super(title);
}
public void _cerrar() throws Throwable {

    getobserver().removeFrame(this, String.valueOf(bo.getOid()));
    mainView.setSelected(true); //para que el foco se transmita a la ventana principal del ABM
}
private void aceptar() throws Throwable {
    try {
        if (!validar())
            return;

        if (permanentUpdateBo()) {
            if (!getAbmEstado().esNuevo()) {
                getobserver().removeFrame(this, String.valueOf(bo.getOid()));
                mainView.setSelected(true); //para que el foco se transmita a la ventana principal del ABM
                mainView.dataFetch();
            }
        }
    } catch (Throwable t) {
        efren.util.ExceptionManager em = efren.util.ExceptionManager.singleton();
        em.manage(this, false, this, t);
    }
}
/**
 * Method to handle events for the BarraAceptarCancelarPanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void aceptarClicked(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getBarraAceptarCancelar()) 
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
	if (newEvent.getSource() == getBarraAceptarCancelar()) 
		connEtoC2(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * connEtoC1:  (BarraAceptarCancelar.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> SancionABMDetailsView.aceptar()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this.aceptar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (BarraAceptarCancelar.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject) --> SancionABMDetailsView.cancelar()V)
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
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue java.lang.Object
 * @param newValue java.lang.Object
 */
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * This method was created in VisualAge.
 * @return ts.abm.estados.ABMEstado
 */
public efren.util.abm.estados.ABMEstado getAbmEstado() {
	return abmEstado;
}
/**
 * Return the BarraAceptarCancelar property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelar() {
	if (ivjBarraAceptarCancelar == null) {
		try {
			ivjBarraAceptarCancelar = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelar.setName("BarraAceptarCancelar");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraAceptarCancelar;
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

			java.awt.GridBagConstraints constraintsJScrollPane1 = new java.awt.GridBagConstraints();
			constraintsJScrollPane1.gridx = 1; constraintsJScrollPane1.gridy = 1;
			constraintsJScrollPane1.gridwidth = 4;
			constraintsJScrollPane1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJScrollPane1.weightx = 1.0;
			constraintsJScrollPane1.weighty = 1.0;
			constraintsJScrollPane1.insets = new java.awt.Insets(4, 4, 4, 10);
			getJFrameContentPane().add(getJScrollPane1(), constraintsJScrollPane1);

			java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombre.gridx = 4; constraintsTextFieldExtNombre.gridy = 0;
			constraintsTextFieldExtNombre.gridwidth = 5;
			constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombre.weightx = 1.0;
			constraintsTextFieldExtNombre.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelar = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelar.gridx = 4; constraintsBarraAceptarCancelar.gridy = 2;
			constraintsBarraAceptarCancelar.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelar.insets = new java.awt.Insets(5, 5, 10, 10);
			getJFrameContentPane().add(getBarraAceptarCancelar(), constraintsBarraAceptarCancelar);

			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 0; constraintsLabelExt2.gridy = 0;
			constraintsLabelExt2.anchor = java.awt.GridBagConstraints.EAST;
			constraintsLabelExt2.insets = new java.awt.Insets(5, 10, 5, 0);
			getJFrameContentPane().add(getLabelExt2(), constraintsLabelExt2);

			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 0; constraintsLabelExt.gridy = 1;
			constraintsLabelExt.anchor = java.awt.GridBagConstraints.NORTHEAST;
			constraintsLabelExt.insets = new java.awt.Insets(5, 10, 5, 0);
			getJFrameContentPane().add(getLabelExt(), constraintsLabelExt);
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
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJScrollPane1() {
	if (ivjJScrollPane1 == null) {
		try {
			ivjJScrollPane1 = new javax.swing.JScrollPane();
			ivjJScrollPane1.setName("JScrollPane1");
			getJScrollPane1().setViewportView(getTextAreaExtSentenciaSQL());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJScrollPane1;
}
/**
 * Return the observer property value.
 * @return efren.util.ABMViewObserver
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.ABMViewObserver getobserver() {
	// user code begin {1}
	// user code end
	return ivjobserver;
}
/**
 * 
 */
public efren.util.ABMViewObserver getObserverThis() {
	return getobserver();
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
 * Return the LabelExt property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt() {
	if (ivjLabelExt == null) {
		try {
			ivjLabelExt = new efren.util.gui.LabelExt();
			ivjLabelExt.setName("LabelExt");
			ivjLabelExt.setText("Fórmula");
			ivjLabelExt.setForeground(new java.awt.Color(0,64,128));
			ivjLabelExt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			ivjLabelExt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
 * Return the LabelExt2 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt2() {
	if (ivjLabelExt2 == null) {
		try {
			ivjLabelExt2 = new efren.util.gui.LabelExt();
			ivjLabelExt2.setName("LabelExt2");
			ivjLabelExt2.setText("Observaciones");
			ivjLabelExt2.setForeground(new java.awt.Color(0,64,128));
			ivjLabelExt2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			ivjLabelExt2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
 * Return the TextAreaExtSentenciaSQL property value.
 * @return efren.util.gui.TextAreaExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextAreaExt getTextAreaExtSentenciaSQL() {
	if (ivjTextAreaExtSentenciaSQL == null) {
		try {
			ivjTextAreaExtSentenciaSQL = new efren.util.gui.text.TextAreaExt();
			ivjTextAreaExtSentenciaSQL.setName("TextAreaExtSentenciaSQL");
			ivjTextAreaExtSentenciaSQL.setBounds(0, 0, 325, 235);
			ivjTextAreaExtSentenciaSQL.setMaxLength(4000);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextAreaExtSentenciaSQL;
}
/**
 * Return the TextFieldExtNombre property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
	if (ivjTextFieldExtNombre == null) {
		try {
			ivjTextFieldExtNombre = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtNombre.setName("TextFieldExtNombre");
			ivjTextFieldExtNombre.setMaxLength(50);
			ivjTextFieldExtNombre.setValue("");
			ivjTextFieldExtNombre.setColumns(0);
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
private void handleException(Throwable exception) {
    efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() throws Throwable {

	if (getAbmEstado().esNuevo()) {
		getBarraAceptarCancelar().setButtonAceptarText("Ingresar");
		getBarraAceptarCancelar().setButtonCancelarText("Cerrar");
		return;
	}
	
	//...manejo de datos
	getTextFieldExtNombre().setValue(bo.getNombre());
	getTextAreaExtSentenciaSQL().setValue(bo.getSentenciaSQL());
	
	//...manejo visual
	if (getAbmEstado().esEliminado() || getAbmEstado().esConsultado()) {
		getTextFieldExtNombre().setEnabled(false);
		getTextAreaExtSentenciaSQL().setEnabled(false);
	}
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getBarraAceptarCancelar().addBarraAceptarCancelarPanelListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("FileDefinitionABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(548, 343);
		setContentPane(getJFrameContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    this.addInternalFrameListener(this);
    this.sqlParte1 = "UPDATE DETALLEROLPERSONAL drp SET VALOR = ( SELECT  ";
    this.sqlParte2 = " FROM ROLPAGOPERSONAL rpp, V_ROLES_DAC vrd WHERE drp.ROLPAGOPERSONALOID = rpp.OID AND rpp.PERSONALOID = vrd.PERSONALOID ) WHERE RUBROROLOID = ";
    this.sqlParte3 = "  AND ROLPAGOPERSONALOID IN (SELECT  rpp.OID FROM ROLPAGOPERSONAL rpp, V_ROLES_DAC vrd WHERE rpp.PERSONALOID = vrd.PERSONALOID AND rpp.ROLPAGOOID = ? ) ";
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
private boolean permanentUpdateBo() throws Throwable {

	if (getAbmEstado().esConsultado())
		return true;
	
	String nombreTabla = "FILEDEFINITION";
	String registroAudit=null,s;
	int afectados=-1;
	
	java.sql.Statement st = efren.util.Conn.conectar().createStatement();

	long oid = bo.getOid();
	String nombre = getTextFieldExtNombre().SQLText();
	String sentenciaSQL = getTextAreaExtSentenciaSQL().SQLText();
	java.sql.Timestamp timestamp = bo.getUtc();
	
	if (getAbmEstado().esNuevo()) {
		oid = efren.util.OidManager.newOid();
		s = "INSERT INTO "+nombreTabla+" "
			+"(OID,NOMBRE,SENTENCIASQL,UTC) VALUES ("
			+oid+","+nombre+","+sentenciaSQL+",CURRENT TIMESTAMP)";
		afectados = st.executeUpdate(s);
		if (afectados > 0)
			registroAudit = "OID=>"+oid+"_&&_NOMBRE=>"+nombre+"_&&_SENTENCIASQL=>"+sentenciaSQL;
	} else {
		if (getAbmEstado().esModificado()) {
			s = "UPDATE "+nombreTabla+" SET "
				+" NOMBRE="+nombre+",SENTENCIASQL="+sentenciaSQL
				+" ,UTC=CURRENT TIMESTAMP"
				+" WHERE OID="+bo.getOid()+" AND UTC={ ts '"+bo.getUtc()+"' }";
			afectados = st.executeUpdate(s);
			if (afectados > 0)
				registroAudit = "OID=>"+oid+"_&&_NOMBRE=>"+nombre+"_&&_SENTENCIASQL=>"+sentenciaSQL;
		} else {
			if (getAbmEstado().esEliminado()) {
				s = "DELETE FROM "+nombreTabla+" "
					+ " WHERE OID="+bo.getOid()+" AND UTC={ ts '"+bo.getUtc()+"' }";
				afectados = st.executeUpdate(s);
				if (afectados > 0)
					registroAudit = "OID=>"+oid;
			}
		}
	}
	// AUDITORIA
	AuditoriaManager.audit(st, afectados,oid,registroAudit,nombreTabla,getAbmEstado().getActionType());

	//manejo de ingreso continuo
	if (getAbmEstado().esNuevo() && afectados > 0) {
		String detalleIngreso = "***INGRESO EXITOSO***  NOMBRE=>"+nombre;
		efren.util.gui.dialogs.InfoView.showMessageDialog(this, detalleIngreso);
	}

	st.close();
	efren.util.Conn.conectar().commit();

	return true;
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * This method was created in VisualAge.
 * @param newValue efren.abm.estados.ABMEstado
 */
public void setAbmEstado(efren.util.abm.estados.ABMEstado newValue) {
	this.abmEstado = newValue;
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
 * 
 */
public void setObserverThis(efren.util.ABMViewObserver arg1) {
	setobserver(arg1);
}
private boolean validar() throws Throwable {
	if (getAbmEstado().esEliminado()) {
		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
			return true;
		else
			return false;
	} else {
		if (getTextFieldExtNombre().isDataMissing("¡ Ingrese un NOMBRE !"))
			return false;
		if (getTextAreaExtSentenciaSQL().isDataMissing("¡ Ingrese la SENTENCIA SQL !"))
			return false;
	}
	return true;
}
}
