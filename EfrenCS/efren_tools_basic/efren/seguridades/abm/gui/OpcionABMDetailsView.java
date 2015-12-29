package efren.seguridades.abm.gui;

import java.awt.GridBagConstraints;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import efren.seguridades.util.tree.OpcionTreeModel2;
import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.gui.FindObjectsPanel;
import efren.util.gui.LabelExt;
import efren.util.gui.text.TextFieldExt;
public class OpcionABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, java.awt.event.ComponentListener, javax.swing.event.InternalFrameListener {
	private efren.util.ABMViewObserver ivjobserver = null;
    protected transient java.beans.PropertyChangeSupport propertyChange;
    private efren.util.abm.estados.ABMEstado abmEstado;
	private efren.util.gui.LabelExt ivjJLabelMenuName = null;
	private efren.util.gui.LabelExt ivjJLabel2 = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel2 = null;
    public OpcionABMView mainView;
	private javax.swing.JPanel ivjPage = null;
	private javax.swing.JPanel ivjPageOpcion = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtPosicion = null;
    //...
    public efren.util.entidades.SecOpcion bo;
	private efren.util.gui.FindObjectsPanel ivjFindObjectsPanelClaseJava = null;

	public OpcionTreeModel2.OpcionNode parentNode = null;
	public OpcionTreeModel2 opcionTreeModel = null;
	public OpcionTreeModel2.OpcionNode selectedNode = null;
	public JTree tree = null;
	public TreePath parentPath = null;
	public int selectedRow = -1;

	private boolean datosAfectados = false;

	private LabelExt stLabel = null;
	private LabelExt stLabelPadre = null;
	private LabelExt stLabel1 = null;
	private TextFieldExt textFieldExtIconName = null;
	private LabelExt labelExt = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OpcionABMDetailsView() {
	super();
	initialize();
}
/**
 * EstructuraOrganicaABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public OpcionABMDetailsView(String title) {
	super(title);
}
//getobserver().removeFrame(this, String.valueOf(bo.getOid()));
public void _cerrar() throws Throwable {

    getobserver().removeFrame(this, String.valueOf(bo.getOid()));
    mainView.setSelected(true);//para que el foco se transmita a la ventana principal del ABM
}

private void aceptar() throws Throwable {
    try {
        if (!validar())
            return;

        if (permanentUpdateBO()) {
            this.datosAfectados = true;
            try {
                this.opcionTreeModel.aPath = this.parentPath;
                this.opcionTreeModel.reloadChildren(this.parentNode);
            } catch (Exception e2) {
                e2.getMessage();
                this.opcionTreeModel.reloadChildren(opcionTreeModel.getRoot());
            }

            getobserver().removeFrame(this, String.valueOf(bo.getOid()));
            mainView.setSelected(true); //para que el foco se transmita a la ventana principal del ABM

            mainView.parentPath = parentPath;
            mainView.doRefreshLastPath();
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
	if (newEvent.getSource() == getBarraAceptarCancelarPanel2())
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
	if (newEvent.getSource() == getBarraAceptarCancelarPanel2())
		connEtoC2(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the ComponentListener interface.
 * @param e java.awt.event.ComponentEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void componentHidden(java.awt.event.ComponentEvent e) {
	// user code begin {1}
	// user code end
	if (e.getSource() == this)
		connEtoM2(e);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the ComponentListener interface.
 * @param e java.awt.event.ComponentEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void componentMoved(java.awt.event.ComponentEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the ComponentListener interface.
 * @param e java.awt.event.ComponentEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void componentResized(java.awt.event.ComponentEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the ComponentListener interface.
 * @param e java.awt.event.ComponentEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void componentShown(java.awt.event.ComponentEvent e) {
	// user code begin {1}
	// user code end
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
 * connEtoC2:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject) --> EstructuraOrganicaABMDetailsView.cancelar()V)
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
 * connEtoM2:  (OpcionABMDetailsView.component.componentHidden(java.awt.event.ComponentEvent) --> BarraAceptarCancelarPanel2.cancelarClick()V)
 * @param arg1 java.awt.event.ComponentEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM2(java.awt.event.ComponentEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		getBarraAceptarCancelarPanel2().cancelarClick();
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
 * Return the BarraAceptarCancelarPanel2 property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel2() {
	if (ivjBarraAceptarCancelarPanel2 == null) {
		try {
			ivjBarraAceptarCancelarPanel2 = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanel2.setName("BarraAceptarCancelarPanel2");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBarraAceptarCancelarPanel2;
}
/**
 * Return the FindObjectsPanel property value.
 * @return efren.abm.beans.FindObjectsPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.FindObjectsPanel getFindObjectsPanelClaseJava() {
	if (ivjFindObjectsPanelClaseJava == null) {
		try {
			ivjFindObjectsPanelClaseJava = new efren.util.gui.FindObjectsPanel();
			ivjFindObjectsPanelClaseJava.setName("FindObjectsPanelClaseJava");
			ivjFindObjectsPanelClaseJava.setCODIGO_FIELD("PAQUETE");
			ivjFindObjectsPanelClaseJava.setDoubleBuffered(false);
			ivjFindObjectsPanelClaseJava.setTipoCODIGO(FindObjectsPanel.Tipo.CARACTERES);
			ivjFindObjectsPanelClaseJava.setRequestFocusEnabled(true);
			ivjFindObjectsPanelClaseJava.setLongitudParametroCodigo(5);
			ivjFindObjectsPanelClaseJava.setTABLE_NAME("SEGURIDADES.CLASE");
			ivjFindObjectsPanelClaseJava.setDISPLAYING_FIELD("NOMBRE");
			ivjFindObjectsPanelClaseJava.setVisible(true);
			ivjFindObjectsPanelClaseJava.setNullable(true);
			ivjFindObjectsPanelClaseJava.setFieldCodigoVisible(true);
			ivjFindObjectsPanelClaseJava.setCodigoCriteriaLabel("Clase Java (o JSP)");
			ivjFindObjectsPanelClaseJava.setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
			ivjFindObjectsPanelClaseJava.setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
			ivjFindObjectsPanelClaseJava.setMaxLength(200);
			ivjFindObjectsPanelClaseJava.setCampo1Label("Package");
			ivjFindObjectsPanelClaseJava.setCampo2Label("Nombre de clase");

			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjFindObjectsPanelClaseJava;
}
/**
 * Return the JLabel2 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabel2() {
	if (ivjJLabel2 == null) {
		try {
			ivjJLabel2 = new efren.util.gui.LabelExt();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setText("Posición (Hasta 4 dígitos)");
			ivjJLabel2.setForeground(java.awt.Color.black);
			ivjJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel2;
}
/**
 * Return the JLabelMenuName property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabelMenuName() {
	if (ivjJLabelMenuName == null) {
		try {
			ivjJLabelMenuName = new efren.util.gui.LabelExt();
			ivjJLabelMenuName.setName("JLabelMenuName");
			ivjJLabelMenuName.setText("Nombre de la Opción o Menú");
			ivjJLabelMenuName.setForeground(java.awt.Color.black);
			ivjJLabelMenuName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabelMenuName;
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
 * Return the Page property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPage() {
	if (ivjPage == null) {
		try {
			ivjPage = new javax.swing.JPanel();
			ivjPage.setName("Page");
			ivjPage.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel2 = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel2.gridx = 0; constraintsBarraAceptarCancelarPanel2.gridy = 1;
			constraintsBarraAceptarCancelarPanel2.anchor = java.awt.GridBagConstraints.SOUTHEAST;
			constraintsBarraAceptarCancelarPanel2.insets = new java.awt.Insets(5, 5, 10, 10);
			getPage().add(getBarraAceptarCancelarPanel2(), constraintsBarraAceptarCancelarPanel2);

			java.awt.GridBagConstraints constraintsPageOpcion = new java.awt.GridBagConstraints();
			constraintsPageOpcion.gridx = 0; constraintsPageOpcion.gridy = 0;
			constraintsPageOpcion.fill = java.awt.GridBagConstraints.BOTH;
			constraintsPageOpcion.weightx = 1.0;
			constraintsPageOpcion.weighty = 1.0;
			constraintsPageOpcion.insets = new java.awt.Insets(4, 4, 4, 4);
			getPage().add(getPageOpcion(), constraintsPageOpcion);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPage;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getPageOpcion() {
	if (ivjPageOpcion == null) {
		try {
			labelExt = new LabelExt();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			stLabel1 = new LabelExt();
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			stLabelPadre = new LabelExt();
			stLabel = new LabelExt();
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			ivjPageOpcion = new javax.swing.JPanel();
			ivjPageOpcion.setName("PageOpcion");
			ivjPageOpcion.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJLabelMenuName = new java.awt.GridBagConstraints();
			constraintsJLabelMenuName.gridx = 0; constraintsJLabelMenuName.gridy = 3;
			constraintsJLabelMenuName.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabelMenuName.weighty = 1.0;
			constraintsJLabelMenuName.insets = new java.awt.Insets(5, 10, 5, 5);
			java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombre.gridx = 1; constraintsTextFieldExtNombre.gridy = 3;
			constraintsTextFieldExtNombre.gridwidth = 2;
			constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombre.weightx = 1.0;
			constraintsTextFieldExtNombre.weighty = 1.0;
			constraintsTextFieldExtNombre.insets = new java.awt.Insets(10,5,5,10);
			java.awt.GridBagConstraints constraintsJLabel2 = new java.awt.GridBagConstraints();
			constraintsJLabel2.gridx = 0; constraintsJLabel2.gridy = 5;
			constraintsJLabel2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabel2.weighty = 1.0;
			constraintsJLabel2.insets = new java.awt.Insets(5, 10, 5, 5);
			java.awt.GridBagConstraints constraintsTextFieldExtPosicion = new java.awt.GridBagConstraints();
			constraintsTextFieldExtPosicion.gridx = 1; constraintsTextFieldExtPosicion.gridy = 5;
			constraintsTextFieldExtPosicion.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtPosicion.weighty = 1.0;
			constraintsTextFieldExtPosicion.insets = new java.awt.Insets(5,5,5,5);
			java.awt.GridBagConstraints constraintsFindObjectsPanelClaseJava = new java.awt.GridBagConstraints();
			constraintsFindObjectsPanelClaseJava.gridx = 0; constraintsFindObjectsPanelClaseJava.gridy = 2;
			constraintsFindObjectsPanelClaseJava.gridwidth = 4;
			constraintsFindObjectsPanelClaseJava.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsFindObjectsPanelClaseJava.weightx = 1.0;
			constraintsFindObjectsPanelClaseJava.insets = new java.awt.Insets(0,10,4,10);
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.insets = new java.awt.Insets(10,4,10,4);
			gridBagConstraints2.anchor = java.awt.GridBagConstraints.EAST;
			stLabel.setText("Padre:");
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.insets = new java.awt.Insets(10,4,10,10);
			gridBagConstraints3.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints3.gridwidth = 2;
			stLabelPadre.setText("...");
			stLabelPadre.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			stLabelPadre.setForeground(new java.awt.Color(102,102,0));
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints21.insets = new java.awt.Insets(4,10,0,0);
			gridBagConstraints21.gridwidth = 2;
			stLabel1.setText("IMPORTANTE: Seleccione una Clase Java (o JSP) solamente cuando sea un Menú");
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 4;
			gridBagConstraints1.insets = new java.awt.Insets(5,5,5,10);
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints22.gridx = 0;
			gridBagConstraints22.gridy = 4;
			gridBagConstraints22.anchor = java.awt.GridBagConstraints.EAST;
			gridBagConstraints22.insets = new java.awt.Insets(5,5,5,5);
			labelExt.setText("IconName");
			ivjPageOpcion.add(getJLabelMenuName(), constraintsJLabelMenuName);
			ivjPageOpcion.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
			ivjPageOpcion.add(getJLabel2(), constraintsJLabel2);
			ivjPageOpcion.add(getTextFieldExtPosicion(), constraintsTextFieldExtPosicion);
			ivjPageOpcion.add(getFindObjectsPanelClaseJava(), constraintsFindObjectsPanelClaseJava);
			ivjPageOpcion.add(stLabel, gridBagConstraints2);
			ivjPageOpcion.add(stLabelPadre, gridBagConstraints3);
			ivjPageOpcion.add(stLabel1, gridBagConstraints21);
			ivjPageOpcion.add(getTextFieldExtIconName(), gridBagConstraints1);
			ivjPageOpcion.add(labelExt, gridBagConstraints22);
			this.setBounds(this.getBounds().x,this.getBounds().y,this.getBounds().width+1,this.getBounds().height+1);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPageOpcion;
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
 * Return the TextFieldExtNombre property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
	if (ivjTextFieldExtNombre == null) {
		try {
			ivjTextFieldExtNombre = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtNombre.setName("TextFieldExtNombre");
			ivjTextFieldExtNombre.setKeyMask(efren.util.gui.text.TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
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
 * Return the TextFieldExtPosicion property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtPosicion() {
	if (ivjTextFieldExtPosicion == null) {
		try {
			ivjTextFieldExtPosicion = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtPosicion.setName("TextFieldExtPosicion");
			ivjTextFieldExtPosicion.setAllowedKey(efren.util.gui.text.TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
			ivjTextFieldExtPosicion.setKeyMask(efren.util.gui.text.TextFieldExt.KeyMask.KM_Numero);
			ivjTextFieldExtPosicion.setMaxLength(4);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtPosicion;
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() {
    try {
		getTextFieldExtNombre().setValue(bo.getNombre().trim());
		getTextFieldExtPosicion().setValue(String.valueOf(bo.getPosicion()));
		getFindObjectsPanelClaseJava().setValue(String.valueOf(bo.getClaseOid()));
		getTextFieldExtIconName().setValue(bo.getIconName());

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
	this.addComponentListener(this);
	getBarraAceptarCancelarPanel2().addBarraAceptarCancelarPanelListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("OpcionABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(544, 355);
		setContentPane(getPage());
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
    stLabelPadre.setText(this.parentNode.getOpcion().getPosicionAbsoluta() + " " + this.parentNode.getOpcion().getNombre());
}
private boolean permanentUpdateBO() {
	try {
		String s;
		java.sql.Connection con = efren.util.Conn.conectar();
		java.sql.Statement st = con.createStatement();

		if (getAbmEstado().esNuevo()) {
			s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION "
				+ " (OID, SISTEMAOID, CLASEOID, OPCIONPADREOID, NOMBRE, POSICION, TIMESTAMP, ICONNAME) VALUES ( "
				+ bo.getOid() + " ," + bo.getSistemaOid();
			if (getFindObjectsPanelClaseJava().getValue() != null && getFindObjectsPanelClaseJava().getValue().compareTo("-1") != 0)
				s = s + " ," + getFindObjectsPanelClaseJava().getValue();
			else
				s = s + " ,NULL ";
			s = s + " ," + bo.getOpcionPadreOid()
				+ " ," + getTextFieldExtNombre().SQLText() + " "
				+ " ," + getTextFieldExtPosicion().getValue() + ", CURRENT TIMESTAMP, " + getTextFieldExtIconName().SQLText() + " ) ";
			st.executeUpdate(s);
			st.close();
			con.commit();
			return true;
		}
		if (getAbmEstado().esModificado()) {
			s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION "
				+ " SET ";
			if (getFindObjectsPanelClaseJava().getValue() != null && getFindObjectsPanelClaseJava().getValue().compareTo("-1") != 0)
				s = s + " CLASEOID = " + getFindObjectsPanelClaseJava().getValue();
			else
				s = s + " CLASEOID = NULL ";
			s = s + " ,NOMBRE = " + getTextFieldExtNombre().SQLText() + " "
				+ " , POSICION = " + getTextFieldExtPosicion().getValue() + " ,TIMESTAMP = CURRENT TIMESTAMP "
				+ " ,ICONNAME = " + getTextFieldExtIconName().SQLText()
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
		if (getAbmEstado().esEliminado()) {
			//validar si tiene o no hijos
			java.sql.ResultSet rs1 = con.createStatement().executeQuery(
					"SELECT COUNT(OID) FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION "
						+ " WHERE OPCIONPADREOID = " + bo.getOid());
			rs1.next();
			if (rs1.getInt(1) > 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this,
					"No se puede eliminar debido a que tiene opciones hijas");
				return false;
			}
			//...
			s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION "
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
    if (getAbmEstado().esEliminado()) {
        if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción",
	        efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
            return true;
        else
            return false;
    } else {
        if (getTextFieldExtNombre().isDataMissing("¡ Ingrese un nombre !"))
            return false;
        if (getTextFieldExtPosicion().isDataMissing("¡ Ingrese una posición !"))
            return false;
    }
    return true;
}

	/**
	 * This method initializes textFieldExtIconName
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtIconName() {
		if (textFieldExtIconName == null) {
			textFieldExtIconName = new TextFieldExt();
			textFieldExtIconName.setMaxLength(150);
		}
		return textFieldExtIconName;
	}
 }  //  @jve:decl-index=0:visual-constraint="10,10"
