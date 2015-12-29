package efren.seguridades.abm.gui;

import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;

public class SistemaABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, javax.swing.event.InternalFrameListener {
	private javax.swing.JPanel ivjJFrameContentPane = null;
    protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjJLabelNombre = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;
	private efren.util.ABMViewObserver ivjobserver = null;
    private efren.util.abm.estados.ABMEstado abmEstado;
    //...
    public SistemaABMView mainView;
    public efren.util.entidades.SecSistema bo;
	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBoxEstado = null;
	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBoxTipo = null;
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.LabelExt ivjLabelExt2 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombrePrincipal = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombreSecundario = null;
	private efren.util.gui.LabelExt ivjLabelExt3 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtSelector = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SistemaABMDetailsView() {
	super();
	initialize();
}
/**
 * GradoABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public SistemaABMDetailsView(String title) {
	super(title);
}
public void _cerrar() throws java.rmi.RemoteException {

	/**
	 * se elimina ésta ventana del observer controlador de ventanas para que el objeto de negocio pueda
	 * ser utilizado en otra ventana de detalle
	 */
	getobserver().removeFrame(this, String.valueOf(bo.getOid()));
}
private void aceptar() throws Throwable {
    try {
        if (!validar())
            return;

        if (permanentUpdateBO()) {
            getobserver().removeFrame(this, String.valueOf(bo.getOid()));
            mainView.setSelected(true); //para que el foco se transmita a la ventana principal del ABM
            mainView.dataFetch();
        }
    } catch (Throwable t) {
    	ExceptionManager.singleton().manage(this, false, this, t);
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
 * connEtoC1:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> PaisABMDetailsView.aceptar(Lcom.ibm.vap.Transactions.VapEJBObjectImpl;)V)
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
 * connEtoC2:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject) --> PaisABMDetailsView.cancelar(Lcom.ibm.vap.Transactions.VapEJBObjectImpl;)V)
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
 * @return efren.abm.estados.ABMEstado
 */
public efren.util.abm.estados.ABMEstado getAbmEstado() {
	return abmEstado;
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

			java.awt.GridBagConstraints constraintsJLabelNombre = new java.awt.GridBagConstraints();
			constraintsJLabelNombre.gridx = 0; constraintsJLabelNombre.gridy = 0;
			constraintsJLabelNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabelNombre.weighty = 1.0;
			constraintsJLabelNombre.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getJLabelNombre(), constraintsJLabelNombre);

			java.awt.GridBagConstraints constraintsTextFieldExtNombrePrincipal = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombrePrincipal.gridx = 1; constraintsTextFieldExtNombrePrincipal.gridy = 0;
			constraintsTextFieldExtNombrePrincipal.gridwidth = 3;
			constraintsTextFieldExtNombrePrincipal.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombrePrincipal.weightx = 1.0;
			constraintsTextFieldExtNombrePrincipal.weighty = 1.0;
			constraintsTextFieldExtNombrePrincipal.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtNombrePrincipal(), constraintsTextFieldExtNombrePrincipal);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 0; constraintsBarraAceptarCancelarPanel.gridy = 4;
			constraintsBarraAceptarCancelarPanel.gridwidth = 4;
			constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanel.weightx = 1.0;
			constraintsBarraAceptarCancelarPanel.weighty = 1.0;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
			getJFrameContentPane().add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);

			java.awt.GridBagConstraints constraintsObjectComboBoxTipo = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxTipo.gridx = 1; constraintsObjectComboBoxTipo.gridy = 3;
			constraintsObjectComboBoxTipo.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxTipo.weightx = 1.0;
			constraintsObjectComboBoxTipo.weighty = 1.0;
			constraintsObjectComboBoxTipo.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getObjectComboBoxTipo(), constraintsObjectComboBoxTipo);

			java.awt.GridBagConstraints constraintsObjectComboBoxEstado = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxEstado.gridx = 3; constraintsObjectComboBoxEstado.gridy = 3;
			constraintsObjectComboBoxEstado.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxEstado.weightx = 1.0;
			constraintsObjectComboBoxEstado.weighty = 1.0;
			constraintsObjectComboBoxEstado.insets = new java.awt.Insets(4, 4, 4, 10);
			getJFrameContentPane().add(getObjectComboBoxEstado(), constraintsObjectComboBoxEstado);

			java.awt.GridBagConstraints constraintsTextFieldExtNombreSecundario = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombreSecundario.gridx = 1; constraintsTextFieldExtNombreSecundario.gridy = 1;
			constraintsTextFieldExtNombreSecundario.gridwidth = 3;
			constraintsTextFieldExtNombreSecundario.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombreSecundario.weightx = 1.0;
			constraintsTextFieldExtNombreSecundario.weighty = 1.0;
			constraintsTextFieldExtNombreSecundario.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtNombreSecundario(), constraintsTextFieldExtNombreSecundario);

			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 0; constraintsLabelExt.gridy = 1;
			constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt.weighty = 1.0;
			constraintsLabelExt.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt(), constraintsLabelExt);

			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0; constraintsLabelExt1.gridy = 3;
			constraintsLabelExt1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt1.weighty = 1.0;
			constraintsLabelExt1.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 2; constraintsLabelExt2.gridy = 3;
			constraintsLabelExt2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt2.weighty = 1.0;
			constraintsLabelExt2.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt2(), constraintsLabelExt2);

			java.awt.GridBagConstraints constraintsTextFieldExtSelector = new java.awt.GridBagConstraints();
			constraintsTextFieldExtSelector.gridx = 1; constraintsTextFieldExtSelector.gridy = 2;
			constraintsTextFieldExtSelector.gridwidth = 2;
			constraintsTextFieldExtSelector.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtSelector.weightx = 1.0;
			constraintsTextFieldExtSelector.weighty = 1.0;
			constraintsTextFieldExtSelector.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtSelector(), constraintsTextFieldExtSelector);

			java.awt.GridBagConstraints constraintsLabelExt3 = new java.awt.GridBagConstraints();
			constraintsLabelExt3.gridx = 0; constraintsLabelExt3.gridy = 2;
			constraintsLabelExt3.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt3.weighty = 1.0;
			constraintsLabelExt3.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getLabelExt3(), constraintsLabelExt3);
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
 * Return the JLabelNombre property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabelNombre() {
	if (ivjJLabelNombre == null) {
		try {
			ivjJLabelNombre = new efren.util.gui.LabelExt();
			ivjJLabelNombre.setName("JLabelNombre");
			ivjJLabelNombre.setText("Nombre principal");
			ivjJLabelNombre.setForeground(java.awt.Color.black);
			ivjJLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabelNombre;
}
/**
 * Return the ObjectComboBoxEstado property value.
 * @return efren.util.gui.combo.ObjectComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.combo.ObjectComboBox getObjectComboBoxEstado() {
	if (ivjObjectComboBoxEstado == null) {
		ivjObjectComboBoxEstado = new efren.util.gui.combo.ObjectComboBox();
		ivjObjectComboBoxEstado.setName("ObjectComboBoxEstado");
		String ivjLocal50valuesForItems [] = {"1", "2"};
		ivjObjectComboBoxEstado.setValuesForItems(ivjLocal50valuesForItems);
		Object ivjLocal50items [] = {"Activo", "Inactivo"};
		ivjObjectComboBoxEstado.setItems(ivjLocal50items);
		ivjObjectComboBoxEstado.setSelectedIndex(0);
		ivjObjectComboBoxEstado.setSelectedValueItem("1");
	}
	return ivjObjectComboBoxEstado;
}
/**
 * Return the ObjectComboBoxTipo property value.
 * @return efren.util.gui.combo.ObjectComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.combo.ObjectComboBox getObjectComboBoxTipo() {
	if (ivjObjectComboBoxTipo == null) {
		ivjObjectComboBoxTipo = new efren.util.gui.combo.ObjectComboBox();
		ivjObjectComboBoxTipo.setName("ObjectComboBoxTipo");
		String ivjLocal48valuesForItems [] = {"1", "2"};
		ivjObjectComboBoxTipo.setValuesForItems(ivjLocal48valuesForItems);
		Object ivjLocal48items [] = {"Mostrable", "No mostrable"};
		ivjObjectComboBoxTipo.setItems(ivjLocal48items);
		ivjObjectComboBoxTipo.setSelectedValueItem("1");
		ivjObjectComboBoxTipo.setSelectedIndex(0);
	}
	return ivjObjectComboBoxTipo;
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
			ivjLabelExt.setText("Nombre secundario");
			ivjLabelExt.setForeground(java.awt.Color.black);
			ivjLabelExt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
			ivjLabelExt2.setText("Estado");
			ivjLabelExt2.setForeground(java.awt.Color.black);
			ivjLabelExt2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
 * Return the LabelExt3 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt3() {
	if (ivjLabelExt3 == null) {
		try {
			ivjLabelExt3 = new efren.util.gui.LabelExt();
			ivjLabelExt3.setName("LabelExt3");
			ivjLabelExt3.setText("Selector");
			ivjLabelExt3.setForeground(java.awt.Color.black);
			ivjLabelExt3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
			ivjTextFieldExtNombrePrincipal.setMaxLength(100);
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
/**
 * Return the TextFieldExtNombreSecundario property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtNombreSecundario() {
	if (ivjTextFieldExtNombreSecundario == null) {
		try {
			ivjTextFieldExtNombreSecundario = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtNombreSecundario.setName("TextFieldExtNombreSecundario");
			ivjTextFieldExtNombreSecundario.setMaxLength(100);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtNombreSecundario;
}
/**
 * Return the TextFieldExtSelector property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtSelector() {
	if (ivjTextFieldExtSelector == null) {
		try {
			ivjTextFieldExtSelector = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtSelector.setName("TextFieldExtSelector");
			ivjTextFieldExtSelector.setMaxLength(50);
			ivjTextFieldExtSelector.setValue("_no_aplicable");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtSelector;
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() {
    try {
		getTextFieldExtNombrePrincipal().setValue(bo.getNombrePrincipal().trim());
		getTextFieldExtNombreSecundario().setValue(bo.getNombreSecundario().trim());
		getTextFieldExtSelector().setValue(bo.getSelector().trim());
		getObjectComboBoxTipo().setSelectedValueItem(String.valueOf(bo.getTipo()));
		getObjectComboBoxEstado().setSelectedValueItem(String.valueOf(bo.getEstado()));
    } catch (Throwable t) {
        t.getMessage();
    }
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
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
		setName("SistemaABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(506, 247);
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
private boolean permanentUpdateBO() {
	try {
		String s;
		java.sql.Connection con = efren.util.Conn.conectar();
		java.sql.Statement st = con.createStatement();

		if (getAbmEstado().esNuevo()) {
			s = "INSERT INTO "+SystemProperties.SCHEMA_SEGURIDADES+"."+"SISTEMA "
				+"(OID,NOMBREPRINCIPAL,NOMBRESECUNDARIO,SELECTOR,TIPO,ESTADO,TIMESTAMP) VALUES ("
				+bo.getOid()+","+getTextFieldExtNombrePrincipal().SQLText()
				+","+getTextFieldExtNombreSecundario().SQLText()+","+getTextFieldExtSelector().SQLText()
				+","+getObjectComboBoxTipo().getSelectedValueItem()+","+getObjectComboBoxEstado().getSelectedValueItem()
				+",CURRENT TIMESTAMP)";
			st.executeUpdate(s);
			st.close();
			con.commit();
			return true;
		}
		if (getAbmEstado().esModificado()) {
			s = "UPDATE "+SystemProperties.SCHEMA_SEGURIDADES+"."+"SISTEMA "
				+" SET NOMBREPRINCIPAL="+getTextFieldExtNombrePrincipal().SQLText()+","
				+"NOMBRESECUNDARIO="+getTextFieldExtNombreSecundario().SQLText()+","
				+"SELECTOR="+getTextFieldExtSelector().SQLText()+","
				+"TIPO="+getObjectComboBoxTipo().getSelectedValueItem()+","
				+"ESTADO="+getObjectComboBoxEstado().getSelectedValueItem()+",TIMESTAMP=CURRENT TIMESTAMP"
				+" WHERE OID="+bo.getOid()+" AND TIMESTAMP = {ts '" + bo.getTimestamp() + "'}";
			int act = st.executeUpdate(s);
			st.close();
			if (act < 1){
				efren.util.gui.dialogs.InfoView.showErrorDialog(this,
					"El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
				return false;
			}
			con.commit();
			return true;
		}
		if (getAbmEstado().esEliminado()) {
			s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "SISTEMA "
				+ " WHERE OID = " + bo.getOid() + " AND TIMESTAMP = {ts '" + bo.getTimestamp() + "'}  ";
			int act = st.executeUpdate(s);
			st.close();
			if (act == 0){
				efren.util.gui.dialogs.InfoView.showErrorDialog(this,
					"El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
				return false;
			}
			con.commit();
			return true;
		}

		return true;

	} catch (Throwable t) {
		efren.util.gui.dialogs.InfoView.showErrorDialog(this, "ERROR: " + t.getMessage());
		return false;
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
private boolean validar() {

	/* verificación de los datos ingresados, si no está eliminando el bo */
	if (getAbmEstado().esEliminado()) {
		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
			return true;
		else
			return false;
	} else {
		if (getTextFieldExtNombrePrincipal().isDataMissing("¡ Ingrese un nombre principal !"))
			return false;
		if (getTextFieldExtNombreSecundario().isDataMissing("¡ Ingrese un nombre secundario !"))
			return false;
		if (getTextFieldExtSelector().isDataMissing("¡ Ingrese un selector !"))
			return false;
		if (getObjectComboBoxTipo().isDataMissing("¡ Seleccione un tipo !"))
			return false;
		if (getObjectComboBoxEstado().isDataMissing("¡ Seleccione un estado !"))
			return false;
	}
	return true;
}
}
