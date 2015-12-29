package efren.seguridades.gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import efren.util.CoderManager;
import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.BarraAceptarCancelarPanelListener;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.PasswordFieldExt;
import efren.util.gui.text.PasswordFieldExtListenerAdapter;

public class ChangePasswordView extends DialogExt implements BarraAceptarCancelarPanelListener, ActionListener, MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 3745104705430035373L;

	// ...
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private javax.swing.JPanel ivjJPanel1 = null;

	private efren.util.gui.LabelExt ivjLabelExt2 = null;

	private efren.util.gui.LabelExt ivjLabelExt3 = null;

	private boolean primeraVez = true;

	private PasswordFieldExt ivjPasswordFieldExtClaveActual = null;

	private PasswordFieldExt ivjPasswordFieldExtClaveNueva = null;

	private PasswordFieldExt ivjPasswordFieldExtClaveNuevaOtraVez = null;

	private efren.util.gui.LabelExt ivjLabelExt1 = null;

	private static ChangePasswordView singleton = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ChangePasswordView(JFrame ventanaPrincipal) {
		super(ventanaPrincipal);
		initialize();
	}

	/**
	 *
	 */
	private void _aceptar() {
		try {
			_cambiarClave();
		} catch (Throwable t) {
			t.getMessage();
			_limpiarClaves();
			InfoView.showErrorDialog(this, t.getMessage());
		}
	}

	/**
	 *
	 */
	private void _cambiarClave() {

		String claveActual = getPasswordFieldExtClaveActual().getValue();

		if (SystemProperties.RUNTIME_USER_PASSWORD.trim().compareTo(claveActual.trim()) != 0) {
			_limpiarClaves();
			InfoView.showErrorDialog(this, "¡ La clave actual no es correcta !");
			return;
		}

		String claveNueva = getPasswordFieldExtClaveNueva().getValue();
		String claveNuevaOtraVez = getPasswordFieldExtClaveNuevaOtraVez().getValue();

		if (claveNueva == null || claveNueva.trim().length() == 0 || claveNuevaOtraVez == null || claveNuevaOtraVez.trim().length() == 0) {
			_limpiarClaves();
			InfoView.showErrorDialog(this, "¡ La clave nueva no es correcta !");
			return;
		}
		if (claveNueva.trim().compareTo(claveNuevaOtraVez.trim()) != 0) {
			_limpiarClaves();
			InfoView.showErrorDialog(this, "¡ La clave nueva no es la misma en la repetición hecha !");
			return;
		}
		if (claveNueva.trim().compareTo(claveActual.trim()) == 0) {
			_limpiarClaves();
			InfoView.showErrorDialog(this, "¡ La clave nueva es la misma que la clave actual !");
			return;
		}

		try {
			int afectados = 0;

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {// SISTEMA
																				// LOCAL
																				// (SIN
																				// SERVIDOR
																				// DE
																				// APLICACIONES)
				String sql = "UPDATE " + SystemProperties.SCHEMA_SEGURIDADES + ".USUARIO " + " SET CLAVE='" + CoderManager.encrypt(claveNueva) + "' "
						+ " WHERE USERNAME='" + SystemProperties.RUNTIME_USER_NAME + "' ";
				java.sql.Statement st = efren.util.Conn.conectar().createStatement();
				afectados = st.executeUpdate(sql);
				st.close();
			}

			if (afectados > 0) {
				SystemProperties.RUNTIME_USER_PASSWORD = claveNueva;
				_limpiarClaves();
				InfoView.showInformationDialog(this, "¡ Se ha cambiado la clave !");
				this._cerrar();
			} else {
				_limpiarClaves();
				InfoView.showErrorDialog(this, "¡ No se ha cambiado la clave !");
			}
			getPasswordFieldExtClaveActual().requestFocus();
		} catch (Throwable t) {
			this.handleException(t);
			_limpiarClaves();
		}
	}

	/**
	 *
	 */
	public void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, true, this, exception);
	}

	/**
	 *
	 *
	 */
	public void _cerrar() {
		_limpiarClaves();
		singleton().setVisible(false);
	}

	/**
	 *
	 *
	 */
	private void _limpiarClaves() {

		getPasswordFieldExtClaveActual().setValue("");
		getPasswordFieldExtClaveNueva().setValue("");
		getPasswordFieldExtClaveNuevaOtraVez().setValue("");

		getPasswordFieldExtClaveActual().requestFocus();
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
		if (newEvent.getSource() == getBarraAceptarCancelarPanel())
			connEtoC1(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPasswordFieldExtClaveNuevaOtraVez()) {
			connEtoM3(e);
		} else {
			this.showDialog();
		}
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
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
		if (newEvent.getSource() == getBarraAceptarCancelarPanel())
			connEtoC2(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * connEtoC1:
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.
	 * util.EventObject) --> LogonView.aceptar()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this._aceptar();
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
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java
	 * .util.EventObject) --> LogonView.cancelar()V)
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
	 * connEtoM3: (PasswordFieldExt.action.actionPerformed(ActionEvent) -->
	 * BarraAceptarCancelarPanel.aceptarClick()V)
	 * 
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM3(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getBarraAceptarCancelarPanel().aceptarClick();
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
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Return the BarraAceptarCancelarPanel property value.
	 * 
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
		if (ivjBarraAceptarCancelarPanel == null) {
			try {
				ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
				ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
				ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cerrar");
				ivjBarraAceptarCancelarPanel.setButtonAceptarText("Cambiar clave");
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
	 * Return the JPanel1 property value.
	 * 
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			try {
				ivjJPanel1 = new JPanel();
				ivjJPanel1.setName("JPanel1");
				ivjJPanel1.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsLabelExt3 = new java.awt.GridBagConstraints();
				constraintsLabelExt3.gridx = 0;
				constraintsLabelExt3.gridy = 2;
				constraintsLabelExt3.anchor = java.awt.GridBagConstraints.SOUTHEAST;
				constraintsLabelExt3.insets = new java.awt.Insets(5, 10, 5, 5);
				getJPanel1().add(getLabelExt3(), constraintsLabelExt3);

				java.awt.GridBagConstraints constraintsPasswordFieldExtClaveNuevaOtraVez = new java.awt.GridBagConstraints();
				constraintsPasswordFieldExtClaveNuevaOtraVez.gridx = 1;
				constraintsPasswordFieldExtClaveNuevaOtraVez.gridy = 2;
				constraintsPasswordFieldExtClaveNuevaOtraVez.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsPasswordFieldExtClaveNuevaOtraVez.weightx = 1.0;
				constraintsPasswordFieldExtClaveNuevaOtraVez.insets = new java.awt.Insets(5, 5, 5, 10);
				getJPanel1().add(getPasswordFieldExtClaveNuevaOtraVez(), constraintsPasswordFieldExtClaveNuevaOtraVez);

				java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelarPanel.gridx = 0;
				constraintsBarraAceptarCancelarPanel.gridy = 3;
				constraintsBarraAceptarCancelarPanel.gridwidth = 3;
				constraintsBarraAceptarCancelarPanel.weightx = 1.0;
				constraintsBarraAceptarCancelarPanel.weighty = 1.0;
				constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
				getJPanel1().add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);

				java.awt.GridBagConstraints constraintsPasswordFieldExtClaveNueva = new java.awt.GridBagConstraints();
				constraintsPasswordFieldExtClaveNueva.gridx = 1;
				constraintsPasswordFieldExtClaveNueva.gridy = 1;
				constraintsPasswordFieldExtClaveNueva.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsPasswordFieldExtClaveNueva.weightx = 1.0;
				constraintsPasswordFieldExtClaveNueva.insets = new java.awt.Insets(5, 5, 5, 10);
				getJPanel1().add(getPasswordFieldExtClaveNueva(), constraintsPasswordFieldExtClaveNueva);

				java.awt.GridBagConstraints constraintsPasswordFieldExtClaveActual = new java.awt.GridBagConstraints();
				constraintsPasswordFieldExtClaveActual.gridx = 1;
				constraintsPasswordFieldExtClaveActual.gridy = 0;
				constraintsPasswordFieldExtClaveActual.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsPasswordFieldExtClaveActual.weightx = 1.0;
				constraintsPasswordFieldExtClaveActual.insets = new java.awt.Insets(5, 5, 5, 10);
				getJPanel1().add(getPasswordFieldExtClaveActual(), constraintsPasswordFieldExtClaveActual);

				java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
				constraintsLabelExt1.gridx = 0;
				constraintsLabelExt1.gridy = 0;
				constraintsLabelExt1.anchor = java.awt.GridBagConstraints.SOUTHEAST;
				constraintsLabelExt1.insets = new java.awt.Insets(5, 10, 5, 5);
				getJPanel1().add(getLabelExt1(), constraintsLabelExt1);

				java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
				constraintsLabelExt2.gridx = 0;
				constraintsLabelExt2.gridy = 1;
				constraintsLabelExt2.anchor = java.awt.GridBagConstraints.SOUTHEAST;
				constraintsLabelExt2.insets = new java.awt.Insets(5, 10, 5, 5);
				getJPanel1().add(getLabelExt2(), constraintsLabelExt2);
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
	 * Return the PasswordFieldExtClaveActual property value.
	 * 
	 * @return PasswordFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private PasswordFieldExt getPasswordFieldExtClaveActual() {
		if (ivjPasswordFieldExtClaveActual == null) {
			try {
				ivjPasswordFieldExtClaveActual = new PasswordFieldExt();
				ivjPasswordFieldExtClaveActual.setName("PasswordFieldExtClaveActual");
				ivjPasswordFieldExtClaveActual.setEchoChar(' ');
				ivjPasswordFieldExtClaveActual.setMaxLength(20);
				ivjPasswordFieldExtClaveActual.setFocusAccelerator('w');
				ivjPasswordFieldExtClaveActual.addMouseListener(new MouseListener() {
					public void mouseEntered(MouseEvent e) {
						ivjPasswordFieldExtClaveActual.setCursor(new Cursor(Cursor.TEXT_CURSOR));
					}

					public void mouseClicked(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseReleased(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
						ivjPasswordFieldExtClaveActual.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				ivjPasswordFieldExtClaveActual.addPasswordFieldExtListener(new PasswordFieldExtListenerAdapter() {
					public void actionPerformed(java.util.EventObject e) {
						getPasswordFieldExtClaveNueva().requestFocus();
					}
				});
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPasswordFieldExtClaveActual;
	}

	/**
	 * Return the PasswordFieldExtClaveNueva property value.
	 * 
	 * @return PasswordFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private PasswordFieldExt getPasswordFieldExtClaveNueva() {
		if (ivjPasswordFieldExtClaveNueva == null) {
			try {
				ivjPasswordFieldExtClaveNueva = new PasswordFieldExt();
				ivjPasswordFieldExtClaveNueva.setName("PasswordFieldExtClaveNueva");
				ivjPasswordFieldExtClaveNueva.setEchoChar(' ');
				ivjPasswordFieldExtClaveNueva.setMaxLength(20);
				ivjPasswordFieldExtClaveNueva.setFocusAccelerator('w');
				ivjPasswordFieldExtClaveNueva.addMouseListener(new MouseListener() {
					public void mouseEntered(MouseEvent e) {
						ivjPasswordFieldExtClaveNueva.setCursor(new Cursor(Cursor.TEXT_CURSOR));
					}

					public void mouseClicked(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseReleased(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
						ivjPasswordFieldExtClaveNueva.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				ivjPasswordFieldExtClaveNueva.addPasswordFieldExtListener(new PasswordFieldExtListenerAdapter() {
					public void actionPerformed(java.util.EventObject e) {
						getPasswordFieldExtClaveNuevaOtraVez().requestFocus();
					}
				});
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPasswordFieldExtClaveNueva;
	}

	/**
	 * Return the JTextFieldClave property value.
	 * 
	 * @return PasswordFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private PasswordFieldExt getPasswordFieldExtClaveNuevaOtraVez() {
		if (ivjPasswordFieldExtClaveNuevaOtraVez == null) {
			try {
				ivjPasswordFieldExtClaveNuevaOtraVez = new PasswordFieldExt();
				ivjPasswordFieldExtClaveNuevaOtraVez.setName("PasswordFieldExtClaveNuevaOtraVez");
				ivjPasswordFieldExtClaveNuevaOtraVez.setEchoChar(' ');
				ivjPasswordFieldExtClaveNuevaOtraVez.setMaxLength(20);
				ivjPasswordFieldExtClaveNuevaOtraVez.setFocusAccelerator('w');
				ivjPasswordFieldExtClaveNuevaOtraVez.addMouseListener(new MouseListener() {
					public void mouseEntered(MouseEvent e) {
						ivjPasswordFieldExtClaveNuevaOtraVez.setCursor(new Cursor(Cursor.TEXT_CURSOR));
					}

					public void mouseClicked(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseReleased(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
						ivjPasswordFieldExtClaveNuevaOtraVez.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				ivjPasswordFieldExtClaveNuevaOtraVez.addPasswordFieldExtListener(new PasswordFieldExtListenerAdapter() {
					public void actionPerformed(java.util.EventObject e) {
						_aceptar();
					}
				});
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPasswordFieldExtClaveNuevaOtraVez;
	}

	/**
	 * Accessor for the propertyChange field.
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
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
				ivjLabelExt1.setDisplayedMnemonic('w');
				ivjLabelExt1.setText("Clave actual");
				ivjLabelExt1.setForeground(java.awt.Color.black);
				ivjLabelExt1.setHorizontalAlignment(SwingConstants.RIGHT);
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
				ivjLabelExt2.setDisplayedMnemonic('w');
				ivjLabelExt2.setText("Clave nueva");
				ivjLabelExt2.setForeground(java.awt.Color.black);
				ivjLabelExt2.setHorizontalAlignment(SwingConstants.RIGHT);
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
	 * 
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt3() {
		if (ivjLabelExt3 == null) {
			try {
				ivjLabelExt3 = new efren.util.gui.LabelExt();
				ivjLabelExt3.setName("LabelExt3");
				ivjLabelExt3.setDisplayedMnemonic('w');
				ivjLabelExt3.setText("Clave nueva (ingrese de nuevo)");
				ivjLabelExt3.setForeground(java.awt.Color.black);
				ivjLabelExt3.setHorizontalAlignment(SwingConstants.RIGHT);
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
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		this.addMouseListener(this);
		// user code end
		getPasswordFieldExtClaveNuevaOtraVez().addActionListener(this);
		getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
	}

	/**
	 *
	 */
	private void initialize() {
		try {
			setName("ChangePasswordView");
			setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			setTitle("Cambio de clave");
			setSize(362, 169);
			setResizable(false);
			setContentPane(getJPanel1());
			initConnections();
			setModal(true);
			WindowManager.centerWindow2(this);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if (getPasswordFieldExtClaveActual().isEnabled() && getPasswordFieldExtClaveActual().isEditable())
			getPasswordFieldExtClaveActual().setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		if (getPasswordFieldExtClaveNueva().isEnabled() && getPasswordFieldExtClaveNueva().isEditable())
			getPasswordFieldExtClaveNueva().setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		if (getPasswordFieldExtClaveNuevaOtraVez().isEnabled() && getPasswordFieldExtClaveNuevaOtraVez().isEditable())
			getPasswordFieldExtClaveNuevaOtraVez().setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		getPasswordFieldExtClaveActual().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		getPasswordFieldExtClaveNueva().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		getPasswordFieldExtClaveNuevaOtraVez().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/**
	 *
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 *
	 */
	public void showDialog() {
		singleton().setResizable(false);
		singleton().setVisible(true);
		if (this.primeraVez) {
			// SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(singleton);
			this.primeraVez = false;
		}
		singleton().toFront();
	}

	/**
	 *
	 */
	public static ChangePasswordView singleton() {
		if (singleton == null) {
			singleton = new ChangePasswordView(SystemView.singleton());
		}
		return singleton;
	}
}
