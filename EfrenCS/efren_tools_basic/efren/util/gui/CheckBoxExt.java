package efren.util.gui;

import javax.swing.border.Border;

/**
 * This type was created in VisualAge.
 */
public class CheckBoxExt extends javax.swing.JPanel implements java.awt.event.ItemListener, java.beans.PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1204790505197942274L;
	private javax.swing.JCheckBox ivjJCheckBoxOption = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private String trueOption = "S";
	private String falseOption = "N";
	private String ivjSelectedString = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public CheckBoxExt() {
		super();
		initialize();
	}

	/**
	 * JCheckBoxExt constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public CheckBoxExt(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * JCheckBoxExt constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public CheckBoxExt(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * JCheckBoxExt constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public CheckBoxExt(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
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
	 * connEtoC1:
	 * (JCheckBoxOption.item.itemStateChanged(java.awt.event.ItemEvent) -->
	 * JCheckBoxExt.SetValueSelectString()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ItemEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.awt.event.ItemEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.setValueSelectString();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (SelectedString.this --> JCheckBoxExt.setValueJCheckBox()V)
	 * 
	 * @param value
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.lang.String value) {
		try {
			// user code begin {1}
			// user code end
			this.setValueJCheckBox();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JCheckBoxOption.horizontalAlignment -->
	 * JCheckBoxExt.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("horizontalAlignment", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public void deselect() {
		getJCheckBoxOption().setSelected(false);
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
	 * This method was created in VisualAge.
	 * 
	 * @return java.lang.String
	 */
	public String getFalseOption() {
		return this.falseOption;
	}

	/**
	 * Method generated to support the promotion of the horizontalAlignment
	 * attribute.
	 * 
	 * @return int
	 */
	public int getHorizontalAlignment() {
		return getJCheckBoxOption().getHorizontalAlignment();
	}

	/**
	 * Return the JCheckBoxOption property value.
	 * 
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxOption() {
		if (ivjJCheckBoxOption == null) {
			try {
				ivjJCheckBoxOption = new javax.swing.JCheckBox();
				ivjJCheckBoxOption.setName("JCheckBoxOption");
				ivjJCheckBoxOption.setText("JCheckBoxExt1");
				ivjJCheckBoxOption.setForeground(new java.awt.Color(0, 64, 128));
				ivjJCheckBoxOption.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/checkBox_disabled.gif")));
				ivjJCheckBoxOption.setFont(new java.awt.Font("Arial", 0, 10));
				ivjJCheckBoxOption.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/checkBox_disabledSelected.gif")));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxOption;
	}

	/**
	 * Method generated to support the promotion of the JCheckBoxOptionEnabled
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getJCheckBoxOptionEnabled() {
		return getJCheckBoxOption().isEnabled();
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
	 * Method generated to support the promotion of the selectedOption
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getSelectedOption() {
		if (getJCheckBoxOption().isSelected())
			setSelectedOption(getTrueOption());
		else
			setSelectedOption(getFalseOption());
		return getSelectedString();
	}

	/**
	 * Return the selectedOption property value.
	 * 
	 * @return java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String getSelectedString() {
		// user code begin {1}
		// user code end
		return ivjSelectedString;
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getText() {
		return getJCheckBoxOption().getText();
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @return java.lang.String
	 */
	public String getTrueOption() {
		return trueOption;
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
		getJCheckBoxOption().addItemListener(this);
		getJCheckBoxOption().addPropertyChangeListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("JCheckBoxExt");
			setLayout(new java.awt.GridBagLayout());
			setSize(139, 27);

			java.awt.GridBagConstraints constraintsJCheckBoxOption = new java.awt.GridBagConstraints();
			constraintsJCheckBoxOption.gridx = 0;
			constraintsJCheckBoxOption.gridy = 1;
			constraintsJCheckBoxOption.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJCheckBoxOption.weightx = 0.1;
			add(getJCheckBoxOption(), constraintsJCheckBoxOption);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		getJCheckBoxOption().setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		setOpaque(false);
		// user code end
	}

	public boolean isEnabled() {

		return getJCheckBoxOption().isEnabled();
	}

	public boolean isSelected() {
		return getJCheckBoxOption().isSelected();
	}

	/**
	 * Method to handle events for the ItemListener interface.
	 * 
	 * @param e
	 *            java.awt.event.ItemEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void itemStateChanged(java.awt.event.ItemEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJCheckBoxOption())
			connEtoC1(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * 
	 * @param b
	 *            boolean
	 */
	public void JCheckBoxOptionSetEnabled(boolean b) {
		getJCheckBoxOption().setEnabled(b);
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 * 
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getJCheckBoxOption() && (evt.getPropertyName().equals("horizontalAlignment")))
			connEtoC3(evt);
		// user code begin {2}
		// user code end
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

	public void setBackground(java.awt.Color c) {
		// no hacemos nada
		// super.setBackground(c);

		// getJCheckBoxOption().setBackground(c);
	}

	public void setEnabled(boolean b) {

		super.setEnabled(b);

		getJCheckBoxOption().setEnabled(b);
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @param newValue
	 *            java.lang.String
	 */
	public void setFalseOption(String newValue) {
		this.falseOption = newValue;
	}

	public void setForeground(java.awt.Color c) {
		super.setForeground(c);
		getJCheckBoxOption().setForeground(c);
	}

	/**
	 * Method generated to support the promotion of the horizontalAlignment
	 * attribute.
	 * 
	 * @param arg1
	 *            int
	 */
	public void setHorizontalAlignment(int arg1) {
		getJCheckBoxOption().setHorizontalAlignment(arg1);
	}

	/**
	 * Method generated to support the promotion of the JCheckBoxOptionEnabled
	 * attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setJCheckBoxOptionEnabled(boolean arg1) {
		getJCheckBoxOption().setEnabled(arg1);
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @param newValue
	 *            java.lang.String
	 */
	public void setMnemonic(int m) {
		getJCheckBoxOption().setMnemonic(m);
	}

	/**
	 * 
	 * @param b
	 *            boolean
	 */
	public void setSelected(boolean b) {
		getJCheckBoxOption().setSelected(b);
	}

	/**
	 * Method generated to support the promotion of the selectedOption
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setSelectedOption(String arg1) {
		setSelectedString(arg1);
	}

	/**
	 * Set the SelectedString to a new value.
	 * 
	 * @param newValue
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setSelectedString(java.lang.String newValue) {
		if (ivjSelectedString != newValue) {
			try {
				String oldValue = getSelectedString();
				ivjSelectedString = newValue;
				connEtoC2(ivjSelectedString);
				firePropertyChange("trueOption", oldValue, newValue);
				// user code begin {1}
				firePropertyChange("falseOption", oldValue, newValue);
				firePropertyChange("selectedOption", oldValue, newValue);
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
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setText(String arg1) {
		getJCheckBoxOption().setText(arg1);
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @param newValue
	 *            java.lang.String
	 */
	public void setTrueOption(String newValue) {
		this.trueOption = newValue;
	}

	/**
	 * Este método se encarga de setear en JCheckBox el Boolean correspondiente
	 * al Estado en que se encuentra el SelectString
	 */
	public void setValueJCheckBox() {

		if ((getSelectedString().trim().compareTo(getTrueOption().trim())) == 0) {
			getJCheckBoxOption().setSelected(true);
		} else {
			getJCheckBoxOption().setSelected(false);
		}
		return;
	}

	/**
	 * Este método se encarga de setear en SelectString el string
	 * correspondiente al Estado en que se encuentra el CheckBox
	 */
	public void setValueSelectString() {
		if (getJCheckBoxOption().isSelected()) {
			setSelectedString(getTrueOption());
		} else {
			setSelectedString(getFalseOption());
		}
		return;
	}
	/**
	 * 
	 */
	public void setBorder(Border unBorde) {
		try {
			getJCheckBoxOption().setBorder(unBorde);
		} catch (Exception e1) {
			e1.getMessage();
		}
	}

}
