package efren.seguridades.abm.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import efren.util.CoderManager;
import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.gui.FindObjectsPanel;
import efren.util.gui.LabelExt;
import efren.util.gui.MultiChoice;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.PasswordFieldExt;
import efren.util.gui.text.TextFieldExt;

public class UsuarioABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, javax.swing.event.InternalFrameListener {
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelar = null;
	private javax.swing.JPanel ivjJFrameContentPane = null;
    public efren.util.abm.estados.ABMEstado abmEstado;
    protected transient java.beans.PropertyChangeSupport propertyChange;
    public UsuarioABMView mainView;
	private efren.util.abm.estados.ABMEstado fieldAbmEstado = null;
    public efren.util.entidades.SecUsuario bo;
	private efren.util.gui.MultiChoice ivjMultiChoiceEstado = null;
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtUserName = null;
	private efren.util.ABMViewObserver ivjobserver = null;
	private efren.util.gui.LabelExt ivjLabelExt2 = null;
	private efren.util.gui.LabelExt ivjLabelExt4 = null;
	private PasswordFieldExt passwordFieldExtClave = null;
	private PasswordFieldExt passwordFieldExtConfirmarClave = null;
	private TextFieldExt textFieldExtCodigoAlterno = null;
	private LabelExt ivjLabelExt11 = null;
	private MultiChoice multiChoiceTipo = null;
	private FindObjectsPanel findObjectsPanelPerfil = null;
	private FindObjectsPanel findObjectsPanelDependencia = null;
	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public UsuarioABMDetailsView() {
		super();
		initialize();
	}
	/**
	 * SancionABMDetailsView constructor comment.
	 * @param title java.lang.String
	 */
	public UsuarioABMDetailsView(String title) {
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
	 * Gets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 * @return The abmEstado property value.
	 * @see #setAbmEstado
	 */
	public efren.util.abm.estados.ABMEstado getAbmEstado() {
		return fieldAbmEstado;
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
				GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
				gridBagConstraints21.gridx = 0;
				gridBagConstraints21.gridwidth = 4;
				gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
				gridBagConstraints21.insets = new Insets(2, 10, 2, 10);
				gridBagConstraints21.weighty = 1.0;
				gridBagConstraints21.gridy = 2;
				GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
				gridBagConstraints13.gridx = 0;
				gridBagConstraints13.gridwidth = 4;
				gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
				gridBagConstraints13.insets = new Insets(10, 10, 5, 10);
				gridBagConstraints13.weighty = 1.0;
				gridBagConstraints13.gridy = 1;
				GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
				gridBagConstraints12.gridx = 0;
				gridBagConstraints12.gridwidth = 4;
				gridBagConstraints12.insets = new Insets(4, 4, 4, 4);
				gridBagConstraints12.gridy = 6;
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.anchor = GridBagConstraints.EAST;
				gridBagConstraints2.insets = new Insets(4, 10, 4, 4);
				gridBagConstraints2.gridy = 8;
				ivjLabelExt11 = new LabelExt();
				ivjLabelExt11.setForeground(new Color(0, 64, 128));
				ivjLabelExt11.setText("Cód. alt. 1:");
				ivjLabelExt11.setName("LabelExt1");
				GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
				gridBagConstraints11.gridx = 1;
				gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
				gridBagConstraints11.insets = new Insets(2, 2, 2, 2);
				gridBagConstraints11.weightx = 1.0;
				gridBagConstraints11.weighty = 1.0;
				gridBagConstraints11.gridy = 8;
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				gridBagConstraints1.gridy = 5;
				gridBagConstraints1.insets = new Insets(2, 2, 2, 10);
				gridBagConstraints1.weightx = 1.0D;
				gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
				gridBagConstraints1.gridx = 3;
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.gridy = 5;
				gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
				gridBagConstraints.insets = new Insets(2, 2, 2, 2);
				gridBagConstraints.weightx = 1.0D;
				gridBagConstraints.weighty = 1.0;
				gridBagConstraints.gridx = 1;
				ivjJFrameContentPane = new javax.swing.JPanel();
				ivjJFrameContentPane.setName("JFrameContentPane");
				ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsBarraAceptarCancelar = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelar.gridx = 0;
	 	constraintsBarraAceptarCancelar.gridy = 10;
				constraintsBarraAceptarCancelar.anchor = java.awt.GridBagConstraints.EAST;
				constraintsBarraAceptarCancelar.weightx = 1.0;
				constraintsBarraAceptarCancelar.weighty = 1.0;
				constraintsBarraAceptarCancelar.gridwidth = 4;
				constraintsBarraAceptarCancelar.insets = new java.awt.Insets(5, 5, 10, 10);
	 			java.awt.GridBagConstraints constraintsMultiChoiceEstado = new java.awt.GridBagConstraints();
				constraintsMultiChoiceEstado.gridx = 0;
	 	constraintsMultiChoiceEstado.gridy = 9;
	 	constraintsMultiChoiceEstado.gridwidth = 4;
				constraintsMultiChoiceEstado.insets = new java.awt.Insets(4, 4, 4, 4);
				java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
				constraintsLabelExt1.gridx = 0;
	 	constraintsLabelExt1.gridy = 3;
				constraintsLabelExt1.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt1.insets = new Insets(4, 10, 4, 4);
				java.awt.GridBagConstraints constraintsTextFieldExtUserName = new java.awt.GridBagConstraints();
				constraintsTextFieldExtUserName.gridx = 1;
	 	constraintsTextFieldExtUserName.gridy = 3;
				constraintsTextFieldExtUserName.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtUserName.weightx = 1.0;
				constraintsTextFieldExtUserName.weighty = 1.0;
				constraintsTextFieldExtUserName.insets = new Insets(2, 2, 2, 2);
				java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
				constraintsLabelExt.gridx = 0;
	 	constraintsLabelExt.gridy = 7;
				constraintsLabelExt.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt.insets = new Insets(4, 10, 4, 4);
				java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
				constraintsTextFieldExtNombre.gridx = 1;
	 	constraintsTextFieldExtNombre.gridy = 7;
				constraintsTextFieldExtNombre.gridwidth = 3;
				constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtNombre.weightx = 1.0;
				constraintsTextFieldExtNombre.weighty = 1.0;
				constraintsTextFieldExtNombre.insets = new Insets(2, 2, 2, 10);
				java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
				constraintsLabelExt2.gridx = 0;
	 	constraintsLabelExt2.gridy = 5;
				constraintsLabelExt2.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt2.insets = new Insets(4, 10, 4, 4);
	 			java.awt.GridBagConstraints constraintsLabelExt4 = new java.awt.GridBagConstraints();
				constraintsLabelExt4.gridx = 2;
	 	constraintsLabelExt4.gridy = 5;
				constraintsLabelExt4.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt4.insets = new java.awt.Insets(4, 4, 4, 4);
				ivjJFrameContentPane.add(getBarraAceptarCancelar(), constraintsBarraAceptarCancelar);
				ivjJFrameContentPane.add(getMultiChoiceEstado(), constraintsMultiChoiceEstado);
				ivjJFrameContentPane.add(getLabelExt1(), constraintsLabelExt1);
				ivjJFrameContentPane.add(getTextFieldExtUserName(), constraintsTextFieldExtUserName);
				ivjJFrameContentPane.add(getLabelExt(), constraintsLabelExt);
				ivjJFrameContentPane.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
				ivjJFrameContentPane.add(getLabelExt2(), constraintsLabelExt2);
				ivjJFrameContentPane.add(getLabelExt4(), constraintsLabelExt4);
				ivjJFrameContentPane.add(getPasswordFieldExtClave(), gridBagConstraints);
				ivjJFrameContentPane.add(getPasswordFieldExtConfirmarClave(), gridBagConstraints1);
				ivjJFrameContentPane.add(getTextFieldExtCodigoAlterno(), gridBagConstraints11);
				ivjJFrameContentPane.add(ivjLabelExt11, gridBagConstraints2);
				ivjJFrameContentPane.add(getMultiChoiceTipo(), gridBagConstraints12);
				ivjJFrameContentPane.add(getFindObjectsPanelPerfil(), gridBagConstraints13);
				ivjJFrameContentPane.add(getFindObjectsPanelDependencia(), gridBagConstraints21);
		}
		return ivjJFrameContentPane;
	}
	/**
	 * Return the MultiChoiceEstado property value.
	 * @return efren.util.gui.MultiChoice
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.MultiChoice getMultiChoiceEstado() {
		if (ivjMultiChoiceEstado == null) {
			ivjMultiChoiceEstado = new efren.util.gui.MultiChoice();
			ivjMultiChoiceEstado.setName("MultiChoiceEstado");
			String valueOptions [] = {"0", "1"};
			ivjMultiChoiceEstado.setValueOptions(valueOptions);
			String nameOptions [] = {"Activo", "Inactivo"};
			ivjMultiChoiceEstado.setNameOptions(nameOptions, false, false);
			ivjMultiChoiceEstado.setSelectedOption("N");
			ivjMultiChoiceEstado.setTitle("Estado");
			ivjMultiChoiceEstado.setSelectedIndex(0);
		}
		return ivjMultiChoiceEstado;
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
				ivjLabelExt.setText("Nombre");
				ivjLabelExt.setForeground(new java.awt.Color(0,64,128));
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
				ivjLabelExt1.setText("UserName");
				ivjLabelExt1.setForeground(new java.awt.Color(0,64,128));
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
				ivjLabelExt2.setText("Clave");
				ivjLabelExt2.setForeground(new java.awt.Color(0,64,128));
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
	 * Return the LabelExt4 property value.
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt4() {
		if (ivjLabelExt4 == null) {
			try {
				ivjLabelExt4 = new efren.util.gui.LabelExt();
				ivjLabelExt4.setName("LabelExt4");
				ivjLabelExt4.setText("Confirmar Clave");
				ivjLabelExt4.setForeground(new java.awt.Color(0,64,128));
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
	 * Return the TextFieldExtUserName property value.
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtUserName() {
		if (ivjTextFieldExtUserName == null) {
			try {
				ivjTextFieldExtUserName = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtUserName.setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
				ivjTextFieldExtUserName.setName("TextFieldExtUserName");
				ivjTextFieldExtUserName.setMaxLength(20);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtUserName;
	}
	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}
	public void initAll() {
		initFields();
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
	private void initFields() {
	    try {
	    	getFindObjectsPanelPerfil().setValue(bo.getPerfilOid());
	    	getFindObjectsPanelDependencia().setValue(bo.getDependenciaOid());
	        getTextFieldExtUserName().setValue(bo.getUserName().trim());
	        String temp = CoderManager.decrypt(bo.getClave().trim());
	        getPasswordFieldExtClave().setValue(temp);
	        getPasswordFieldExtConfirmarClave().setValue(temp);
	        getTextFieldExtNombre().setValue(bo.getNombre().trim());
	        getMultiChoiceEstado().setSelectedIndex(bo.getEstado());
	        getTextFieldExtCodigoAlterno().setValue(bo.getCodigoAlterno().trim());
	        getMultiChoiceTipo().setValue(String.valueOf(bo.getTipo()));
	    } catch (Throwable t) {
	        t.getMessage();
	    }
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("UsuarioABMDetailsView");
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			setSize(522, 442);
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
		        String clave = getPasswordFieldExtClave().getValue().trim();
	   		    clave = CoderManager.encrypt(clave);
				s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "USUARIO "
					+ " (OID, PERFILOID, DEPENDENCIAOID, USERNAME, CLAVE, NOMBRE, ESTADO, CODIGO_ALTERNO, TIPO, TIMESTAMP) VALUES ( " + bo.getOid()
					+ " ," + getFindObjectsPanelPerfil().getValue() + "," + getFindObjectsPanelDependencia().getValue() + " "
					+ " ," + getTextFieldExtUserName().SQLText() + " "
					+ " ,'" + clave + "' "
					+ " ," + getTextFieldExtNombre().SQLText() + " "
					+ " ," + getMultiChoiceEstado().getSelectedIndex() + " ,"
					+ getTextFieldExtCodigoAlterno().SQLText()+","+getMultiChoiceTipo().getSelectedOption()+",CURRENT TIMESTAMP)";
				st.executeUpdate(s);
				st.close();
				con.commit();
				return true;
			}
			if (getAbmEstado().esModificado()) {
		        String clave = getPasswordFieldExtClave().getValue().trim();
	   		    clave = CoderManager.encrypt(clave);
				s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "USUARIO "
					+ " SET "
					+ " PERFILOID = " + getFindObjectsPanelPerfil().getValue() + ", DEPENDENCIAOID="+getFindObjectsPanelDependencia().getValue()+" "
					+ " , USERNAME = " + getTextFieldExtUserName().SQLText() + " "
					+ " , CLAVE = '" + clave + "' "
					+ " , NOMBRE = " + getTextFieldExtNombre().SQLText() + " "
					+ ",CODIGO_ALTERNO="+getTextFieldExtCodigoAlterno().SQLText()+" "
					+ ",TIPO="+getMultiChoiceTipo().getSelectedOption()+" "
					+ " , ESTADO = " + getMultiChoiceEstado().getSelectedIndex() + " "
					+ " , TIMESTAMP = CURRENT TIMESTAMP "
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
				s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "USUARIO "
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
	 * Sets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 * @param abmEstado The new value for the property.
	 * @see #getAbmEstado
	 */
	public void setAbmEstado(efren.util.abm.estados.ABMEstado abmEstado) {
		efren.util.abm.estados.ABMEstado oldValue = fieldAbmEstado;
		fieldAbmEstado = abmEstado;
		firePropertyChange("abmEstado", oldValue, abmEstado);
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
	        if (InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", InfoView.YES_NO_OPTION) == 0) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        if (getFindObjectsPanelPerfil().isDataMissing("Seleccione un perfil !"))
	            return false;
	        if (getMultiChoiceEstado().isDataMissing("¡ Seleccione un estado !"))
	            return false;
	        if (getTextFieldExtUserName().isDataMissing("Ingrese un UserName !"))
	            return false;
	        if (getTextFieldExtNombre().isDataMissing("Ingrese un nombre !"))
	            return false;
	        //validacion de clave
	        String clave = getPasswordFieldExtClave().getValue();
	        String confirmarClave = getPasswordFieldExtConfirmarClave().getValue();
	        if (clave.length() == 0) {
	        	efren.util.gui.dialogs.InfoView.showErrorDialog(this, "Ingrese una Clave !");
	            return false;
	        }
	        if (confirmarClave.length() == 0) {
	        	efren.util.gui.dialogs.InfoView.showErrorDialog(this, "Ingrese la Confirmación de la Clave !");
	            return false;
	        }
		    if (clave.trim().compareTo(confirmarClave.trim()) != 0) {
			    efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ La clave no es la misma en la repetición hecha !");
				return false;
			}
	        if (getTextFieldExtCodigoAlterno().isDataMissing("Ingrese un Código Alterno !"))
	            return false;
	        if (getMultiChoiceTipo().isDataMissing("¡ Seleccione un tipo !"))
	            return false;
	    }
	    return true;
	}
	/**
	 * This method initializes passwordFieldExtClave
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	private PasswordFieldExt getPasswordFieldExtClave() {
		if (passwordFieldExtClave == null) {
			passwordFieldExtClave = new PasswordFieldExt();
			passwordFieldExtClave.setMaxLength(20);
		}
		return passwordFieldExtClave;
	}
	/**
	 * This method initializes passwordFieldExtConfirmarClave
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	private PasswordFieldExt getPasswordFieldExtConfirmarClave() {
		if (passwordFieldExtConfirmarClave == null) {
			passwordFieldExtConfirmarClave = new PasswordFieldExt();
			passwordFieldExtConfirmarClave.setMaxLength(20);
		}
		return passwordFieldExtConfirmarClave;
	}
	/**
	 * This method initializes textFieldExtCodigoAlterno
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtCodigoAlterno() {
		if (textFieldExtCodigoAlterno == null) {
			textFieldExtCodigoAlterno = new TextFieldExt();
			textFieldExtCodigoAlterno.setName("TextFieldExtCodigoAlterno1");
			textFieldExtCodigoAlterno.setMaxLength(10);
			textFieldExtCodigoAlterno.setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
		}
		return textFieldExtCodigoAlterno;
	}
	/**
	 * This method initializes multiChoiceTipo
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	private MultiChoice getMultiChoiceTipo() {
		if (multiChoiceTipo == null) {
			multiChoiceTipo = new MultiChoice();
			String valueOptions [] = {"1", "2"};
			multiChoiceTipo.setValueOptions(valueOptions);
			String nameOptions [] = {"Administrador", "Usuario"};
			multiChoiceTipo.setNameOptions(nameOptions, false, false);
			multiChoiceTipo.setTitle("Tipo");
			multiChoiceTipo.setSelectedIndex(0);
		}
		return multiChoiceTipo;
	}
	/**
	 * This method initializes findObjectsPanelPerfil
	 *
	 * @return efren.util.gui.FindObjectsPanel
	 */
	private FindObjectsPanel getFindObjectsPanelPerfil() {
		if (findObjectsPanelPerfil == null) {
			findObjectsPanelPerfil = new FindObjectsPanel();
			findObjectsPanelPerfil.setName("FindObjectsPanelPerfil");
			findObjectsPanelPerfil.setDoubleBuffered(false);
			findObjectsPanelPerfil.setRequestFocusEnabled(true);
			findObjectsPanelPerfil.setFieldCodigoVisible(false);
			findObjectsPanelPerfil.setCodigoCriteriaLabel("Perfil");
			findObjectsPanelPerfil.setNullable(false);
			findObjectsPanelPerfil.setMaxLength(200);
			findObjectsPanelPerfil.setCampo2Label("Nombre");
			findObjectsPanelPerfil.setDISPLAYING_FIELD("NOMBRE");
			findObjectsPanelPerfil.setTABLE_NAME("SEGURIDADES.PERFIL");
			findObjectsPanelPerfil.setVisible(true);
		}
		return findObjectsPanelPerfil;
	}
	/**
	 * This method initializes findObjectsPanelDependencia
	 *
	 * @return efren.util.gui.FindObjectsPanel
	 */
	private FindObjectsPanel getFindObjectsPanelDependencia() {
		if (findObjectsPanelDependencia == null) {
			findObjectsPanelDependencia = new FindObjectsPanel();
			findObjectsPanelDependencia.setName("FindObjectsPanelDependencia");
			findObjectsPanelDependencia.setDoubleBuffered(false);
			findObjectsPanelDependencia.setRequestFocusEnabled(true);
			findObjectsPanelDependencia.setCampo1Label("Código");
			findObjectsPanelDependencia.setLongitudParametroCodigo(20);
			findObjectsPanelDependencia.setFieldCodigoVisible(true);
			findObjectsPanelDependencia.setCodigoCriteriaLabel("Dependencia");
			findObjectsPanelDependencia.setNullable(false);
			findObjectsPanelDependencia.setMaxLength(200);
			findObjectsPanelDependencia.setCODIGO_FIELD("CODIGO");
			findObjectsPanelDependencia.setCampo2Label("Nombre");
			findObjectsPanelDependencia.setDISPLAYING_FIELD("NOMBRE");
			findObjectsPanelDependencia.setTABLE_NAME("SEGURIDADES.DEPENDENCIA");
			findObjectsPanelDependencia.setVisible(true);
		}
		return findObjectsPanelDependencia;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
