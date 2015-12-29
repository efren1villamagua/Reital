package reital.parquesamanes.lector.gui.working;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import efren.util.CoderManager;
import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.PasswordFieldExt;
import efren.util.gui.text.TextFieldExt;
import reital.parquesamanes.domain.entidades.Usuario;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class UsuarioABMDetailsView extends JFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -2855358623223880922L;

	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelar = null;

	private javax.swing.JPanel ivjJFrameContentPane = null;

	public efren.util.abm.estados.ABMEstado abmEstado;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	public UsuarioABMView mainView;

	private efren.util.abm.estados.ABMEstado fieldAbmEstado = null;

	public Usuario bo;

	private efren.util.gui.LabelExt ivjLabelExt = null;

	private efren.util.gui.LabelExt ivjLabelExt1 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtUserName = null;

	private efren.util.ABMViewObserver2 ivjobserver = null;

	private efren.util.gui.LabelExt ivjLabelExt2 = null;

	private efren.util.gui.LabelExt ivjLabelExt4 = null;

	private PasswordFieldExt passwordFieldExtClave = null;

	private PasswordFieldExt passwordFieldExtConfirmarClave = null;

	private JCheckBox jCheckBoxAdministrador = null;

	private JCheckBox jCheckBoxActivo = null;

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
	 *
	 * @param title
	 *            java.lang.String
	 */
	public UsuarioABMDetailsView(String title) {
		super(title);
	}

	public void _cerrar() throws java.rmi.RemoteException {

		/**
		 * se elimina ésta ventana del observer controlador de ventanas para que
		 * el objeto de negocio pueda ser utilizado en otra ventana de detalle
		 */
		getobserver().removeFrame(this, String.valueOf(bo.getOid()));
	}

	private void aceptar() throws Throwable {
		try {
			if (!validar())
				return;

			if (permanentUpdateBO()) {
				getobserver().removeFrame(this, String.valueOf(bo.getOid()));
				mainView.dataFetch();
			}
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, false, this, t);
		}
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
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
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
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
	 * connEtoC1:
	 * (BarraAceptarCancelar.barraAceptarCancelarPanel.aceptarClicked(
	 * java.util.EventObject) --> SancionABMDetailsView.aceptar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
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
	 * connEtoC2:
	 * (BarraAceptarCancelar.barraAceptarCancelarPanel.cancelarClicked
	 * (java.util.EventObject) --> SancionABMDetailsView.cancelar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
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
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 *
	 * @param propertyName
	 *            java.lang.String
	 * @param oldValue
	 *            java.lang.Object
	 * @param newValue
	 *            java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Gets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 *
	 * @return The abmEstado property value.
	 * @see #setAbmEstado
	 */
	public efren.util.abm.estados.ABMEstado getAbmEstado() {
		return fieldAbmEstado;
	}

	/**
	 * Return the BarraAceptarCancelar property value.
	 *
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
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 3;
			gridBagConstraints2.gridy = 8;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
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
			ivjJFrameContentPane.add(getLabelExt1(), constraintsLabelExt1);
			ivjJFrameContentPane.add(getTextFieldExtUserName(), constraintsTextFieldExtUserName);
			ivjJFrameContentPane.add(getLabelExt(), constraintsLabelExt);
			ivjJFrameContentPane.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
			ivjJFrameContentPane.add(getLabelExt2(), constraintsLabelExt2);
			ivjJFrameContentPane.add(getLabelExt4(), constraintsLabelExt4);
			ivjJFrameContentPane.add(getPasswordFieldExtClave(), gridBagConstraints);
			ivjJFrameContentPane.add(getPasswordFieldExtConfirmarClave(), gridBagConstraints1);
			ivjJFrameContentPane.add(getJCheckBoxAdministrador(), gridBagConstraints11);
			ivjJFrameContentPane.add(getJCheckBoxActivo(), gridBagConstraints2);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the observer property value.
	 *
	 * @return efren.util.ABMViewObserver2
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.ABMViewObserver2 getobserver() {
		// user code begin {1}
		// user code end
		return ivjobserver;
	}

	/**
	 * Method generated to support the promotion of the observerThis attribute.
	 *
	 * @return efren.util.ABMViewObserver2
	 */
	public efren.util.ABMViewObserver2 getObserverThis() {
		return getobserver();
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return java.beans.PropertyChangeSupport
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Return the LabelExt property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			try {
				ivjLabelExt = new efren.util.gui.LabelExt();
				ivjLabelExt.setName("LabelExt");
				ivjLabelExt.setText("Nombre");
				ivjLabelExt.setForeground(new java.awt.Color(0, 64, 128));
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
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt1() {
		if (ivjLabelExt1 == null) {
			try {
				ivjLabelExt1 = new efren.util.gui.LabelExt();
				ivjLabelExt1.setName("LabelExt1");
				ivjLabelExt1.setText("UserName");
				ivjLabelExt1.setForeground(new java.awt.Color(0, 64, 128));
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
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt2() {
		if (ivjLabelExt2 == null) {
			try {
				ivjLabelExt2 = new efren.util.gui.LabelExt();
				ivjLabelExt2.setName("LabelExt2");
				ivjLabelExt2.setText("Clave");
				ivjLabelExt2.setForeground(new java.awt.Color(0, 64, 128));
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
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt4() {
		if (ivjLabelExt4 == null) {
			try {
				ivjLabelExt4 = new efren.util.gui.LabelExt();
				ivjLabelExt4.setName("LabelExt4");
				ivjLabelExt4.setText("Confirmar Clave");
				ivjLabelExt4.setForeground(new java.awt.Color(0, 64, 128));
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
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
		if (ivjTextFieldExtNombre == null) {
			try {
				ivjTextFieldExtNombre = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtNombre.setName("TextFieldExtNombre");
				ivjTextFieldExtNombre.setMaxLength(100);
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
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtUserName() {
		if (ivjTextFieldExtUserName == null) {
			try {
				ivjTextFieldExtUserName = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtUserName.setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
				ivjTextFieldExtUserName.setName("TextFieldExtUserName");
				ivjTextFieldExtUserName.setMaxLength(10);
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
			if (getAbmEstado().esNuevo()) {
				return;
			} else {
				getTextFieldExtUserName().setValue(bo.getUserName().trim());
				String temp = CoderManager.decrypt(bo.getClave().trim());
				getPasswordFieldExtClave().setValue(temp);
				getPasswordFieldExtConfirmarClave().setValue(temp);
				getTextFieldExtNombre().setValue(bo.getNombre().trim());
				getJCheckBoxAdministrador().setSelected(bo.getAdministrador());
				getJCheckBoxActivo().setSelected(bo.getActivo());
				// ...
				getTextFieldExtUserName().setEnabled(false);
			}
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/users16x16.png")));
			setSize(522, 442);
			setContentPane(getJFrameContentPane());
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		this.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					_cerrar();
				} catch (Throwable t) {
					t.getMessage();
				}
			}

			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// user code end
	}

	private boolean permanentUpdateBO() {
		try {
			/**
			 * OJO TODO FALTA MANEJAR AUDITORIA
			 */
			String s;
			java.sql.Connection con = ParqueSamanesConn.getConnection();
			java.sql.Statement st = con.createStatement();

			if (getAbmEstado().esNuevo()) {
				String clave = getPasswordFieldExtClave().getValue().trim();
				clave = CoderManager.encrypt(clave);
				s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES + "." + "USUARIO " + " (USERNAME, CLAVE, NOMBRE, TIPO, ESTADO) VALUES ( " + " "
						+ getTextFieldExtUserName().SQLText() + " " + " ,'" + clave + "' " + " ," + getTextFieldExtNombre().SQLText() + " " + " ,"
						+ (getJCheckBoxAdministrador().isSelected() ? " '" + ParqueSamanesConstantes.USUARIO_TIPO_Administrador + "', "
								: " '" + ParqueSamanesConstantes.USUARIO_TIPO_Usuario + "', ")
						+ (getJCheckBoxActivo().isSelected() ? " '" + ParqueSamanesConstantes.USUARIO_ESTADO_Activo + "' "
								: " '" + ParqueSamanesConstantes.USUARIO_ESTADO_Inactivo + "' ")
						+ ")";
				st.executeUpdate(s);
				st.close();
				con.commit();
				return true;
			}
			if (getAbmEstado().esModificado()) {
				String clave = getPasswordFieldExtClave().getValue().trim();
				clave = CoderManager.encrypt(clave);
				s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES + "." + "USUARIO " + " SET " + " CLAVE='" + clave + "' " + " ,NOMBRE=" + getTextFieldExtNombre().SQLText()
						+ " " + " ," + " TIPO="
						+ (getJCheckBoxAdministrador().isSelected() ? " '" + ParqueSamanesConstantes.USUARIO_TIPO_Administrador + "', "
								: " '" + ParqueSamanesConstantes.USUARIO_TIPO_Usuario + "', ")
						+ " ESTADO=" + (getJCheckBoxActivo().isSelected() ? " '" + ParqueSamanesConstantes.USUARIO_ESTADO_Activo + "' "
								: " '" + ParqueSamanesConstantes.USUARIO_ESTADO_Inactivo + "' ")
						+ " WHERE USERNAME='" + getTextFieldExtUserName().getValue().trim() + "' ";
				int act = st.executeUpdate(s);
				st.close();
				if (act == 0) {
					efren.util.gui.dialogs.InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
				con.commit();
				return true;
			}
			if (getAbmEstado().esEliminado()) {
				s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES + "." + "USUARIO " + " WHERE USERNAME=" + getTextFieldExtUserName().SQLText() + " ";
				int act = st.executeUpdate(s);
				st.close();
				if (act == 0) {
					efren.util.gui.dialogs.InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
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
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 * Sets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 *
	 * @param abmEstado
	 *            The new value for the property.
	 * @see #getAbmEstado
	 */
	public void setAbmEstado(efren.util.abm.estados.ABMEstado abmEstado) {
		efren.util.abm.estados.ABMEstado oldValue = fieldAbmEstado;
		fieldAbmEstado = abmEstado;
		firePropertyChange("abmEstado", oldValue, abmEstado);
	}

	/**
	 * Set the observer to a new value.
	 *
	 * @param newValue
	 *            efren.util.ABMViewObserver2
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setobserver(efren.util.ABMViewObserver2 newValue) {
		if (ivjobserver != newValue) {
			try {
				efren.util.ABMViewObserver2 oldValue = getobserver();
				ivjobserver = newValue;
				firePropertyChange("observerThis", oldValue, newValue);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		;
		// user code begin {3}
		// user code end
	}

	/**
	 * Method generated to support the promotion of the observerThis attribute.
	 *
	 * @param arg1
	 *            efren.util.ABMViewObserver2
	 */
	public void setObserverThis(efren.util.ABMViewObserver2 arg1) {
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
			if (getTextFieldExtUserName().isDataMissing("Ingrese un UserName !"))
				return false;
			if (getTextFieldExtNombre().isDataMissing("Ingrese un nombre !"))
				return false;
			// validacion de clave
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
			passwordFieldExtClave.setMaxLength(10);
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
			passwordFieldExtConfirmarClave.setMaxLength(10);
		}
		return passwordFieldExtConfirmarClave;
	}

	/**
	 * This method initializes jCheckBoxAdministrador
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxAdministrador() {
		if (jCheckBoxAdministrador == null) {
			jCheckBoxAdministrador = new JCheckBox();
			jCheckBoxAdministrador.setText("Administrador");
		}
		return jCheckBoxAdministrador;
	}

	/**
	 * This method initializes jCheckBoxActivo
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxActivo() {
		if (jCheckBoxActivo == null) {
			jCheckBoxActivo = new JCheckBox();
			jCheckBoxActivo.setText("Activo");
			jCheckBoxActivo.setSelected(true);
		}
		return jCheckBoxActivo;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
