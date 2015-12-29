package efren.util.gui.bars;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import efren.util.ExceptionManager;
import efren.util.FontManager;
import efren.util.SwingResourceManager;

/**
 * This type was created in VisualAge.
 */
public class BarraAceptarCancelarPanel extends javax.swing.JPanel implements java.awt.event.ActionListener, java.awt.event.MouseListener, java.beans.PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -8102273709208338086L;

	private javax.swing.JButton ivjJButtonAceptar = null;

	private javax.swing.JButton ivjJButtonCancelar = null;

	protected transient BarraAceptarCancelarPanelListener fieldBarraAceptarCancelarPanelListenerEventMulticaster = null;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private boolean fieldShowIcons = true;

	private int fieldIconType = 0;// default

	private JToolBar jToolBar = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public BarraAceptarCancelarPanel() {
		super();
		initialize();
	}

	/**
	 * TsBarraAceptarCancelarPanel constructor comment.
	 * 
	 * @param layout
	 * 		java.awt.LayoutManager
	 */
	public BarraAceptarCancelarPanel(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * TsBarraAceptarCancelarPanel constructor comment.
	 * 
	 * @param layout
	 * 		java.awt.LayoutManager
	 * @param isDoubleBuffered
	 * 		boolean
	 */
	public BarraAceptarCancelarPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * TsBarraAceptarCancelarPanel constructor comment.
	 * 
	 * @param isDoubleBuffered
	 * 		boolean
	 */
	public BarraAceptarCancelarPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Perform the aceptarClick method.
	 */
	public void aceptarClick() {
		/* Perform the aceptarClick method. */
		getJButtonAceptar().doClick();
		return;
	}

	/**
	 * 
	 * @param b
	 * 		boolean
	 */
	public void aceptarSetEnabled(boolean b) {
		getJButtonAceptar().setEnabled(b);
	}

	/**
	 * Method to handle events for the ActionListener interface.
	 * 
	 * @param e
	 * 		java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButtonAceptar())
			connEtoC1(e);
		if (e.getSource() == getJButtonCancelar())
			connEtoC2(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * 
	 * @param newListener
	 * 		ts.abm.beans.TsBarraAceptarCancelarPanelListener
	 */
	public void addBarraAceptarCancelarPanelListener(BarraAceptarCancelarPanelListener newListener) {
		fieldBarraAceptarCancelarPanelListenerEventMulticaster = BarraAceptarCancelarPanelListenerEventMulticaster.add(fieldBarraAceptarCancelarPanelListenerEventMulticaster,
				newListener);
		return;
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 * 
	 * @param listener
	 * 		java.beans.PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * Perform the cancelarClick method.
	 */
	public void cancelarClick() {
		/* Perform the cancelarClick method. */
		getJButtonCancelar().doClick();
		return;
	}

	/**
	 * 
	 * @param b
	 * 		boolean
	 */
	public void cancelarSetEnabled(boolean b) {
		getJButtonCancelar().setEnabled(b);
	}

	/**
	 * connEtoC1:
	 * (JButtonAceptar.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * TsBarraAceptarCancelarPanel.fireAceptarClicked(Ljava.util.EventObject;)V)
	 * 
	 * @param arg1
	 * 		java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireAceptarClicked(new java.util.EventObject(this));
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
	 * (JButtonCancelar.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * TsBarraAceptarCancelarPanel
	 * .fireCancelarClicked(Ljava.util.EventObject;)V)
	 * 
	 * @param arg1
	 * 		java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireCancelarClicked(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JButtonAceptar.text -->
	 * BarraAceptarCancelarPanel.firePropertyChange
	 * (Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 * 		java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("buttonAceptarText", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (JButtonCancelar.text -->
	 * BarraAceptarCancelarPanel.firePropertyChange
	 * (Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 * 		java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("buttonCancelarText", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 * 		java.util.EventObject
	 */
	protected void fireAceptarClicked(java.util.EventObject newEvent) {
		if (fieldBarraAceptarCancelarPanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBarraAceptarCancelarPanelListenerEventMulticaster.aceptarClicked(newEvent);
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 * 		java.util.EventObject
	 */
	protected void fireCancelarClicked(java.util.EventObject newEvent) {
		if (fieldBarraAceptarCancelarPanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBarraAceptarCancelarPanelListenerEventMulticaster.cancelarClicked(newEvent);
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 * 
	 * @param propertyName
	 * 		java.lang.String
	 * @param oldValue
	 * 		java.lang.Object
	 * @param newValue
	 * 		java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarEnabled
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getButtonAceptarEnabled() {
		return getJButtonAceptar().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarMnemonic
	 * attribute.
	 * 
	 * @return int
	 */
	public int getButtonAceptarMnemonic() {
		return getJButtonAceptar().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarText
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getButtonAceptarText() {
		return getJButtonAceptar().getText();
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarVisible
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getButtonAceptarVisible() {
		return getJButtonAceptar().isVisible();
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarEnabled
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getButtonCancelarEnabled() {
		return getJButtonCancelar().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarMnemonic
	 * attribute.
	 * 
	 * @return int
	 */
	public int getButtonCancelarMnemonic() {
		return getJButtonCancelar().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarText
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getButtonCancelarText() {
		return getJButtonCancelar().getText();
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarVisible
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getButtonCancelarVisible() {
		return getJButtonCancelar().isVisible();
	}

	/**
	 * Gets the iconType property (int) value.
	 * 
	 * @return The iconType property value.
	 * @see #setIconType
	 */
	public int getIconType() {
		return fieldIconType;
	}

	/**
	 * Return the JButtonAceptar property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonAceptar() {
		if (ivjJButtonAceptar == null) {
			try {
				ivjJButtonAceptar = new javax.swing.JButton();
				ivjJButtonAceptar.setName("JButtonAceptar");
				ivjJButtonAceptar.setMnemonic('A');
				ivjJButtonAceptar.setText("Aceptar");
				ivjJButtonAceptar.setForeground(new java.awt.Color(80, 80, 80));
				ivjJButtonAceptar.setIcon(SwingResourceManager.getIcon(BarraAceptarCancelarPanel.class, "/efren/resources/images/ok1.png"));
				ivjJButtonAceptar.setFont(new Font("Arial", Font.BOLD, 10));
				ivjJButtonAceptar.setOpaque(false);
				ivjJButtonAceptar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
				ivjJButtonAceptar.setMargin(new Insets(0, 0, 0, 0));
				// user code begin {1}
				ivjJButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent e) {
						ivjJButtonAceptar.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						ivjJButtonAceptar.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				});
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonAceptar;
	}

	public void setButtonAceptarIcon(ImageIcon anImageIcon) {
		ivjJButtonAceptar.setIcon(anImageIcon);
	}

	public void setButtonCancelarIcon(ImageIcon anImageIcon) {
		ivjJButtonCancelar.setIcon(anImageIcon);
	}

	/**
	 * Return the JButtonCancelar property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonCancelar() {
		if (ivjJButtonCancelar == null) {
			try {
				ivjJButtonCancelar = new javax.swing.JButton();
				ivjJButtonCancelar.setName("JButtonCancelar");
				ivjJButtonCancelar.setMnemonic('r');
				ivjJButtonCancelar.setText("Cancelar");
				ivjJButtonCancelar.setForeground(new java.awt.Color(80, 80, 80));
				ivjJButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
				ivjJButtonCancelar.setFont(new java.awt.Font("Arial", 1, 10));
				ivjJButtonCancelar.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
				ivjJButtonCancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
				// user code begin {1}
				ivjJButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent e) {
						ivjJButtonCancelar.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						ivjJButtonCancelar.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				});
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonCancelar;
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
	 * Gets the showIcons property (boolean) value.
	 * 
	 * @return The showIcons property value.
	 * @see #setShowIcons
	 */
	public boolean getShowIcons() {
		return fieldShowIcons;
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
		getJButtonAceptar().addMouseListener(this);
		getJButtonCancelar().addMouseListener(this);
		// user code end
		getJButtonAceptar().addPropertyChangeListener(this);
		getJButtonAceptar().addActionListener(this);
		getJButtonCancelar().addPropertyChangeListener(this);
		getJButtonCancelar().addActionListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridx = 0;
		setName("BarraAceptarCancelarPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(156, 26);
		try {
			initConnections();
		} catch (Exception e) {
			e.getMessage();
		}
		getJButtonAceptar().setFont(efren.util.FontManager.currentSystemBoldFont());
		getJButtonCancelar().setFont(efren.util.FontManager.currentSystemBoldFont());
		this.setOpaque(true);
		this.add(getJToolBar(), gridBagConstraints);
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		if (getJButtonAceptar().isEnabled())
			getJButtonAceptar().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		if (getJButtonCancelar().isEnabled())
			getJButtonCancelar().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		getJButtonAceptar().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		getJButtonCancelar().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 * 
	 * @param evt
	 * 		java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getJButtonAceptar() && (evt.getPropertyName().equals("text")))
			connEtoC3(evt);
		if (evt.getSource() == getJButtonCancelar() && (evt.getPropertyName().equals("text")))
			connEtoC4(evt);
		// user code begin {2}
		// user code end
	}

	/**
	 * 
	 * @param newListener
	 * 		ts.abm.beans.TsBarraAceptarCancelarPanelListener
	 */
	public void removeBarraAceptarCancelarPanelListener(BarraAceptarCancelarPanelListener newListener) {
		fieldBarraAceptarCancelarPanelListenerEventMulticaster = BarraAceptarCancelarPanelListenerEventMulticaster.remove(fieldBarraAceptarCancelarPanelListenerEventMulticaster,
				newListener);
		return;
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 * 
	 * @param listener
	 * 		java.beans.PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarEnabled
	 * attribute.
	 * 
	 * @param arg1
	 * 		boolean
	 */
	public void setButtonAceptarEnabled(boolean arg1) {
		getJButtonAceptar().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarMnemonic
	 * attribute.
	 * 
	 * @param arg1
	 * 		int
	 */
	public void setButtonAceptarMnemonic(int arg1) {
		getJButtonAceptar().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarText
	 * attribute.
	 * 
	 * @param arg1
	 * 		java.lang.String
	 */
	public void setButtonAceptarText(String arg1) {
		getJButtonAceptar().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonAceptarVisible
	 * attribute.
	 * 
	 * @param arg1
	 * 		boolean
	 */
	public void setButtonAceptarVisible(boolean arg1) {
		getJButtonAceptar().setVisible(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarEnabled
	 * attribute.
	 * 
	 * @param arg1
	 * 		boolean
	 */
	public void setButtonCancelarEnabled(boolean arg1) {
		getJButtonCancelar().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarMnemonic
	 * attribute.
	 * 
	 * @param arg1
	 * 		int
	 */
	public void setButtonCancelarMnemonic(int arg1) {
		getJButtonCancelar().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarText
	 * attribute.
	 * 
	 * @param arg1
	 * 		java.lang.String
	 */
	public void setButtonCancelarText(String arg1) {
		getJButtonCancelar().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the buttonCancelarVisible
	 * attribute.
	 * 
	 * @param arg1
	 * 		boolean
	 */
	public void setButtonCancelarVisible(boolean arg1) {
		getJButtonCancelar().setVisible(arg1);
	}

	/**
	 * Sets the iconType property (int) value.
	 * 
	 * @param iconType
	 * 		The new value for the property.
	 * @see #getIconType
	 */
	public void setIconTypeNoUse(int iconType) {
		int oldValue = fieldIconType;
		fieldIconType = iconType;
		firePropertyChange("iconType", new Integer(oldValue), new Integer(iconType));
		// ...
		if (iconType == 0) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/ok1.png")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
		if (iconType == 1) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_1.gif")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_cancel_1.gif")));
			return;
		}
		if (iconType == 2) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_2.gif")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
		if (iconType == 3) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_3.png")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
		if (iconType == 4) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
		if (iconType == 5) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_5.gif")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
		if (iconType == 6) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.png")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
			return;
		}
	}

	/**
	 * Sets the showIcons property (boolean) value.
	 * 
	 * @param showIcons
	 * 		The new value for the property.
	 * @see #getShowIcons
	 */
	public void setShowIcons(boolean showIcons) {
		boolean oldValue = fieldShowIcons;
		fieldShowIcons = showIcons;
		firePropertyChange("showIcons", new Boolean(oldValue), new Boolean(showIcons));
		// ...
		if (showIcons) {
			getJButtonAceptar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/ok1.png")));
			getJButtonCancelar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/cancel1.png")));
		} else {
			getJButtonAceptar().setIcon(null);
			getJButtonCancelar().setIcon(null);
		}
	}

	/**
	 * This method initializes jToolBar
	 * 
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonAceptar());
			jToolBar.add(getJButtonCancelar());
		}
		return jToolBar;
	}
} // @jve:decl-index=0:visual-constraint="45,10"
