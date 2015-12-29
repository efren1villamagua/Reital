package efren.util.abms;

import efren.util.AuditoriaManager;


public class TipoABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, javax.swing.event.InternalFrameListener {
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelar = null;
	private javax.swing.JPanel ivjJFrameContentPane = null;
    public efren.util.abm.estados.ABMEstado abmEstado;
    protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjJLabel = null;
	private efren.util.gui.LabelExt ivjJLabel1 = null;
	private efren.util.ABMViewObserver ivjobserver = null;
    //...
    public TipoABMView mainView;
    public efren.util.entidades.Tipo bo;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtDescripcion = null;
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtCampo = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtTabla = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtTipo = null;
	private efren.util.gui.bars.BarraEstadosPanel2 ivjBarraEstadosPanel2 = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public TipoABMDetailsView() {
	super();
	initialize();
}
/**
 * SancionABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public TipoABMDetailsView(String title) {
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
 * Return the BarraEstadosPanel2 property value.
 * @return efren.abm.beans.BarraEstadosPanel2
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraEstadosPanel2 getBarraEstadosPanel2() {
	if (ivjBarraEstadosPanel2 == null) {
		try {
			ivjBarraEstadosPanel2 = new efren.util.gui.bars.BarraEstadosPanel2();
			ivjBarraEstadosPanel2.setName("BarraEstadosPanel2");
			ivjBarraEstadosPanel2.setMensaje01("Ult. ingresado:");
			ivjBarraEstadosPanel2.setMensaje02("(Ninguno todavía)");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraEstadosPanel2;
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

			java.awt.GridBagConstraints constraintsTextFieldExtTabla = new java.awt.GridBagConstraints();
			constraintsTextFieldExtTabla.gridx = 1; constraintsTextFieldExtTabla.gridy = 0;
			constraintsTextFieldExtTabla.gridwidth = 2;
			constraintsTextFieldExtTabla.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTabla.weightx = 1.0;
			constraintsTextFieldExtTabla.weighty = 1.0;
			constraintsTextFieldExtTabla.insets = new java.awt.Insets(10, 5, 5, 150);
			getJFrameContentPane().add(getTextFieldExtTabla(), constraintsTextFieldExtTabla);

			java.awt.GridBagConstraints constraintsTextFieldExtDescripcion = new java.awt.GridBagConstraints();
			constraintsTextFieldExtDescripcion.gridx = 1; constraintsTextFieldExtDescripcion.gridy = 3;
			constraintsTextFieldExtDescripcion.gridwidth = 2;
			constraintsTextFieldExtDescripcion.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtDescripcion.weightx = 1.0;
			constraintsTextFieldExtDescripcion.weighty = 1.0;
			constraintsTextFieldExtDescripcion.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtDescripcion(), constraintsTextFieldExtDescripcion);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelar = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelar.gridx = 2; constraintsBarraAceptarCancelar.gridy = 5;
			constraintsBarraAceptarCancelar.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelar.weightx = 1.0;
			constraintsBarraAceptarCancelar.weighty = 1.0;
			constraintsBarraAceptarCancelar.insets = new java.awt.Insets(5, 5, 10, 10);
			getJFrameContentPane().add(getBarraAceptarCancelar(), constraintsBarraAceptarCancelar);

			java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
			constraintsJLabel1.gridx = 0; constraintsJLabel1.gridy = 0;
			constraintsJLabel1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabel1.weightx = 1.0;
			constraintsJLabel1.weighty = 1.0;
			constraintsJLabel1.insets = new java.awt.Insets(10, 10, 5, 5);
			getJFrameContentPane().add(getJLabel1(), constraintsJLabel1);

			java.awt.GridBagConstraints constraintsJLabel = new java.awt.GridBagConstraints();
			constraintsJLabel.gridx = 0; constraintsJLabel.gridy = 3;
			constraintsJLabel.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabel.weightx = 1.0;
			constraintsJLabel.weighty = 1.0;
			constraintsJLabel.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getJLabel(), constraintsJLabel);

			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 0; constraintsLabelExt.gridy = 1;
			constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt.weightx = 1.0;
			constraintsLabelExt.weighty = 1.0;
			constraintsLabelExt.insets = new java.awt.Insets(10, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt(), constraintsLabelExt);

			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0; constraintsLabelExt1.gridy = 2;
			constraintsLabelExt1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt1.weightx = 1.0;
			constraintsLabelExt1.weighty = 1.0;
			constraintsLabelExt1.insets = new java.awt.Insets(10, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsTextFieldExtCampo = new java.awt.GridBagConstraints();
			constraintsTextFieldExtCampo.gridx = 1; constraintsTextFieldExtCampo.gridy = 1;
			constraintsTextFieldExtCampo.gridwidth = 2;
			constraintsTextFieldExtCampo.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtCampo.weightx = 1.0;
			constraintsTextFieldExtCampo.weighty = 1.0;
			constraintsTextFieldExtCampo.insets = new java.awt.Insets(10, 5, 5, 150);
			getJFrameContentPane().add(getTextFieldExtCampo(), constraintsTextFieldExtCampo);

			java.awt.GridBagConstraints constraintsTextFieldExtTipo = new java.awt.GridBagConstraints();
			constraintsTextFieldExtTipo.gridx = 1; constraintsTextFieldExtTipo.gridy = 2;
			constraintsTextFieldExtTipo.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTipo.weightx = 1.0;
			constraintsTextFieldExtTipo.weighty = 1.0;
			constraintsTextFieldExtTipo.insets = new java.awt.Insets(10, 5, 5, 5);
			getJFrameContentPane().add(getTextFieldExtTipo(), constraintsTextFieldExtTipo);

			java.awt.GridBagConstraints constraintsBarraEstadosPanel2 = new java.awt.GridBagConstraints();
			constraintsBarraEstadosPanel2.gridx = 0; constraintsBarraEstadosPanel2.gridy = 4;
			constraintsBarraEstadosPanel2.gridwidth = 3;
			constraintsBarraEstadosPanel2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsBarraEstadosPanel2.weightx = 1.0;
			constraintsBarraEstadosPanel2.weighty = 1.0;
			constraintsBarraEstadosPanel2.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getBarraEstadosPanel2(), constraintsBarraEstadosPanel2);
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
 * Return the JLabel property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabel() {
	if (ivjJLabel == null) {
		try {
			ivjJLabel = new efren.util.gui.LabelExt();
			ivjJLabel.setName("JLabel");
			ivjJLabel.setText("Descripción");
			ivjJLabel.setForeground(java.awt.Color.black);
			ivjJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			ivjJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel;
}
/**
 * Return the JLabel1 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabel1() {
	if (ivjJLabel1 == null) {
		try {
			ivjJLabel1 = new efren.util.gui.LabelExt();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Tabla");
			ivjJLabel1.setForeground(java.awt.Color.black);
			ivjJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			ivjJLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel1;
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
 * Method generated to support the promotion of the observerThis attribute.
 * @return efren.util.ABMViewObserver
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
			ivjLabelExt.setText("Campo");
			ivjLabelExt.setForeground(java.awt.Color.black);
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
 * Return the LabelExt1 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt1() {
	if (ivjLabelExt1 == null) {
		try {
			ivjLabelExt1 = new efren.util.gui.LabelExt();
			ivjLabelExt1.setName("LabelExt1");
			ivjLabelExt1.setText("Tipo");
			ivjLabelExt1.setForeground(java.awt.Color.black);
			ivjLabelExt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			ivjLabelExt1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
 * Return the TextFieldExtCampo property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtCampo() {
	if (ivjTextFieldExtCampo == null) {
		try {
			ivjTextFieldExtCampo = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtCampo.setName("TextFieldExtCampo");
			ivjTextFieldExtCampo.setMaxLength(26);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtCampo;
}
/**
 * Return the TextFieldExtDescripcion property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtDescripcion() {
	if (ivjTextFieldExtDescripcion == null) {
		try {
			ivjTextFieldExtDescripcion = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtDescripcion.setName("TextFieldExtDescripcion");
			ivjTextFieldExtDescripcion.setMaxLength(150);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtDescripcion;
}
/**
 * Return the TextFieldExtTabla property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtTabla() {
	if (ivjTextFieldExtTabla == null) {
		try {
			ivjTextFieldExtTabla = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtTabla.setName("TextFieldExtTabla");
			ivjTextFieldExtTabla.setMaxLength(26);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtTabla;
}
/**
 * Return the TextFieldExtTipo property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtTipo() {
	if (ivjTextFieldExtTipo == null) {
		try {
			ivjTextFieldExtTipo = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtTipo.setName("TextFieldExtTipo");
			ivjTextFieldExtTipo.setAllowedKey(efren.util.gui.text.TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
			ivjTextFieldExtTipo.setMaxLength(3);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtTipo;
}
private void handleException(Throwable exception) {
    efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() throws Throwable {

	getBarraEstadosPanel2().setABMEstado(getAbmEstado());

	if (getAbmEstado().esNuevo()) {
		getBarraAceptarCancelar().setButtonAceptarText("Ingresar");
		getBarraAceptarCancelar().setButtonCancelarText("Cerrar");
		return;
	}

	//...manejo de datos
	getTextFieldExtTabla().setValue(bo.getTabla());
	getTextFieldExtCampo().setValue(bo.getCampo());
	getTextFieldExtTipo().setValue(bo.getTipo().toString());
	getTextFieldExtDescripcion().setValue(bo.getDescripcion());
	//...manejo visual
	if (getAbmEstado().esEliminado() || getAbmEstado().esConsultado()) {
		getTextFieldExtTabla().setEnabled(false);
		getTextFieldExtCampo().setEnabled(false);
		getTextFieldExtTipo().setEnabled(false);
		getTextFieldExtDescripcion().setEnabled(false);
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
		setName("TipoABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(455, 250);
		setContentPane(getJFrameContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
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
private boolean permanentUpdateBo() throws Throwable {

	if (getAbmEstado().esConsultado())
		return true;

	String nombreTabla = "TIPO";
	String registroAudit=null,s;
	int afectados=-1;

	java.sql.Statement st = efren.util.Conn.conectar().createStatement();

	long oid = bo.getOid();
	String tabla = getTextFieldExtTabla().SQLText();
	String campo = getTextFieldExtCampo().SQLText();
	String tipo = getTextFieldExtTipo().SQLText();
	String descripcion = getTextFieldExtDescripcion().SQLText();
	java.sql.Timestamp timestamp = bo.getUtc();

	if (getAbmEstado().esNuevo()) {
		oid = efren.util.OidManager.newOid("TIPO");
		s = "INSERT INTO TIPO "
			+"(OID,TABLA, CAMPO, TIPO,DESCRIPCION,TIMESTAMP) VALUES ("
			+oid+","+tabla+","+campo+","+tipo+","+descripcion+",CURRENT TIMESTAMP)";
		afectados = st.executeUpdate(s);
		if (afectados > 0)
			registroAudit = "OID=>"+oid+"_&&_TABLA=>"+tabla+"_&&_CAMPO=>"+campo+"_&&_TIPO=>"+tipo
							+"_&&_DESCRIPCION=>"+descripcion;
	} else {
		if (getAbmEstado().esModificado()) {
			s = "UPDATE TIPO SET "
				+" TABLA="+tabla+", "
				+" CAMPO="+campo+", "
				+" TIPO="+tipo+", "
				+" DESCRIPCION="+descripcion+","
				+" TIMESTAMP=CURRENT TIMESTAMP "
				+" WHERE OID="+bo.getOid()+" AND TIMESTAMP={ ts '"+bo.getUtc()+"' }";
			afectados = st.executeUpdate(s);
			if (afectados > 0)
			registroAudit = "OID=>"+oid+"_&&_TABLA=>"+tabla+"_&&_CAMPO=>"+campo+"_&&_TIPO=>"+tipo
							+"_&&_DESCRIPCION=>"+descripcion;
		} else {
			if (getAbmEstado().esEliminado()) {
				s = "DELETE FROM TIPO "
					+ " WHERE OID="+bo.getOid()+" AND TIMESTAMP={ ts '"+bo.getUtc()+"' }";
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
		String detalleIngreso = "TABLA=>"+tabla+", CAMPO=>"+campo+", TIPO=>"+tipo;
		getBarraEstadosPanel2().setMensaje02(detalleIngreso);
		efren.util.gui.dialogs.InfoView.showMessageDialog(this, "***INGRESO EXITOSO***  " + detalleIngreso);
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
 * @param newValue ts.abm.estados.ABMEstado
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
			efren.util.ABMViewObserver oldValue = getobserver();
			ivjobserver = newValue;
			firePropertyChange("observerThis", oldValue, newValue);
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
 * Method generated to support the promotion of the observerThis attribute.
 * @param arg1 efren.util.ABMViewObserver
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
		if (getTextFieldExtTabla().isDataMissing("¡ Ingrese una tabla !"))
			return false;
		if (getTextFieldExtCampo().isDataMissing("¡ Ingrese un campo !"))
			return false;
		if (getTextFieldExtTipo().isDataMissing("¡ Ingrese un tipo !"))
			return false;
		if (getTextFieldExtDescripcion().isDataMissing("¡ Ingrese una descripción !"))
			return false;
	}
	return true;
}
}
