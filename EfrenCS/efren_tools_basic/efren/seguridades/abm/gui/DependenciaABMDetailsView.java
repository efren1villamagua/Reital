package efren.seguridades.abm.gui;

import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import java.awt.Dimension;
import efren.util.gui.MultiChoice;
import java.awt.GridBagConstraints;

public class DependenciaABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, java.awt.event.ComponentListener, javax.swing.event.InternalFrameListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -2220388603638638964L;
	private javax.swing.JPanel ivjJFrameContentPane = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjJLabelNombre = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;
	private efren.util.ABMViewObserver ivjobserver = null;
	private efren.util.abm.estados.ABMEstado abmEstado;
	//...
	public DependenciaABMView mainView;
	public efren.util.entidades.SecDependencia bo;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtCodigo = null;
	private MultiChoice multiChoiceTipo = null;
	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public DependenciaABMDetailsView() {
		super();
		initialize();
	}
	/**
	 * GradoABMDetailsView constructor comment.
	 * @param title java.lang.String
	 */
	public DependenciaABMDetailsView(String title) {
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
	 * Method to handle events for the ComponentListener interface.
	 * @param e java.awt.event.ComponentEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void componentHidden(java.awt.event.ComponentEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == this)
			connEtoM1(e);
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
	 * connEtoM1:  (DependenciaABMDetailsView.component.componentHidden(java.awt.event.ComponentEvent) --> BarraAceptarCancelarPanel.cancelarClick()V)
	 * @param arg1 java.awt.event.ComponentEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(java.awt.event.ComponentEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getBarraAceptarCancelarPanel().cancelarClick();
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
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridwidth = 3;
				gridBagConstraints.gridy = 2;
				ivjJFrameContentPane = new javax.swing.JPanel();
				ivjJFrameContentPane.setName("JFrameContentPane");
				ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsJLabelNombre = new java.awt.GridBagConstraints();
				constraintsJLabelNombre.gridx = 0;
	 	constraintsJLabelNombre.gridy = 1;
				constraintsJLabelNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsJLabelNombre.weighty = 1.0;
				constraintsJLabelNombre.insets = new java.awt.Insets(5, 10, 5, 5);
				java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
				constraintsTextFieldExtNombre.gridx = 1;
	 	constraintsTextFieldExtNombre.gridy = 1;
				constraintsTextFieldExtNombre.gridwidth = 2;
				constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtNombre.weightx = 1.0;
				constraintsTextFieldExtNombre.weighty = 1.0;
				constraintsTextFieldExtNombre.insets = new java.awt.Insets(5, 5, 5, 10);
				ivjJFrameContentPane.add(getJLabelNombre(), constraintsJLabelNombre);
				java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelarPanel.gridx = 2;
	 	constraintsBarraAceptarCancelarPanel.gridy = 3;
				constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.EAST;
				constraintsBarraAceptarCancelarPanel.weightx = 1.0;
				constraintsBarraAceptarCancelarPanel.weighty = 1.0;
				constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
				java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
				constraintsLabelExt.gridx = 0;
	 	constraintsLabelExt.gridy = 0;
				constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt.weighty = 1.0;
				constraintsLabelExt.insets = new java.awt.Insets(5, 10, 5, 5);
				java.awt.GridBagConstraints constraintsTextFieldExtCodigo = new java.awt.GridBagConstraints();
				constraintsTextFieldExtCodigo.gridx = 1;
	 	constraintsTextFieldExtCodigo.gridy = 0;
				constraintsTextFieldExtCodigo.gridwidth = 1;
				constraintsTextFieldExtCodigo.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtCodigo.weightx = 1.0;
				constraintsTextFieldExtCodigo.weighty = 1.0;
				constraintsTextFieldExtCodigo.insets = new java.awt.Insets(5, 5, 5, 10);
				ivjJFrameContentPane.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
				ivjJFrameContentPane.add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
				ivjJFrameContentPane.add(getLabelExt(), constraintsLabelExt);
				ivjJFrameContentPane.add(getTextFieldExtCodigo(), constraintsTextFieldExtCodigo);
				ivjJFrameContentPane.add(getMultiChoiceTipo(), gridBagConstraints);
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
				ivjJLabelNombre.setText("Nombre");
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
				ivjLabelExt.setText("Código");
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
	 * Return the TextFieldExtCodigo property value.
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtCodigo() {
		if (ivjTextFieldExtCodigo == null) {
			try {
				ivjTextFieldExtCodigo = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtCodigo.setName("TextFieldExtCodigo");
				ivjTextFieldExtCodigo.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtCodigo;
	}
	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}
	public void initAll() {
	    try {
	    	getTextFieldExtCodigo().setValue(bo.getCodigo().trim());
			getTextFieldExtNombre().setValue(bo.getNombre().trim());
			getMultiChoiceTipo().setValue(String.valueOf(bo.getTipo()));
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
		this.addComponentListener(this);
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
	    try {
	        // user code begin {1}
	        // user code end
	        setName("DependenciaABMDetailsView");
	        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	        setSize(493, 229);
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
				s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "DEPENDENCIA "
					+ " (OID, CODIGO, NOMBRE, TIPO, TIMESTAMP) VALUES ( " + bo.getOid()
					+ " ," + getTextFieldExtCodigo().SQLText() + " "
					+ " ," + getTextFieldExtNombre().SQLText() + " ,"+getMultiChoiceTipo().getSelectedOption()+",CURRENT TIMESTAMP ) ";
				st.executeUpdate(s);
				st.close();
				con.commit();
				return true;
			}
			if (getAbmEstado().esModificado()) {
				s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "DEPENDENCIA "
					+ " SET NOMBRE = " + getTextFieldExtNombre().SQLText() + ", "
					+ " CODIGO = " + getTextFieldExtCodigo().SQLText() + ", TIPO="+getMultiChoiceTipo().getSelectedOption()+", TIMESTAMP = CURRENT TIMESTAMP "
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
				s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "DEPENDENCIA "
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
	 * Method generated to support the promotion of the observerThis attribute.
	 * @param arg1 efren.util.ABMViewObserver
	 */
	public void setObserverThis(efren.util.ABMViewObserver arg1) {
		setobserver(arg1);
	}
	private boolean validar() throws Exception {

		/* verificación de los datos ingresados, si no está eliminando el bo */
		if (getAbmEstado().esEliminado()) {
			if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
				return true;
			else
				return false;
		} else {
			if (getTextFieldExtCodigo().isDataMissing("¡ Ingrese un código !"))
				return false;
			if (getTextFieldExtNombre().isDataMissing("¡ Ingrese un nombre !"))
				return false;
			if (getMultiChoiceTipo().isDataMissing("¡ Seleccione un tipo !"))
				return false;
		}
		return true;
	}
	/**
	 * This method initializes multiChoiceTipo
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	private MultiChoice getMultiChoiceTipo() {
		if (multiChoiceTipo == null) {
			multiChoiceTipo = new MultiChoice();
			String valueOptions [] = {"1", "2", "3"};
			multiChoiceTipo.setValueOptions(valueOptions);
			String nameOptions [] = {"Matriz", "Sucursal", "Externa"};
			multiChoiceTipo.setNameOptions(nameOptions, false, false);
			multiChoiceTipo.setValue("1");
			multiChoiceTipo.setTitle("Tipo");
			multiChoiceTipo.setSelectedIndex(0);
		}
		return multiChoiceTipo;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
