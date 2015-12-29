package efren.util.gui;

import efren.util.ExceptionManager;
import efren.util.gui.text.TextFieldExt;

/**
 * This type was created in VisualAge.
 */
public class TwoFieldsPanel extends javax.swing.JPanel implements java.beans.PropertyChangeListener {
	private efren.util.gui.LabelExt ivjLabelExt = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.LabelExt ivjLabelExt2 = null;
	private efren.util.gui.LabelExt ivjLabelExtField01 = null;
	private efren.util.gui.LabelExt ivjLabelExtField02 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExt01 = null;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExt02 = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjLabelExt4 = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public TwoFieldsPanel() {
	super();
	initialize();
}
/**
 * TwoFieldsPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public TwoFieldsPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * TwoFieldsPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public TwoFieldsPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * TwoFieldsPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public TwoFieldsPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
/**
 * connEtoC1:  (TextFieldExt01.allowedKey --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field01AllowedKey", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC10:  (TextFieldExt01.focusAccelerator --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC10(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field01FocusAccelerator", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC11:  (TextFieldExt02.focusAccelerator --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC11(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field02FocusAccelerator", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (TextFieldExt01.keyMask --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field01KeyMask", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (TextFieldExt02.allowedKey --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field02AllowedKey", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (TextFieldExt02.keyMask --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("field02KeyMask", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (LabelExtField01.text --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("labelField01Text", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (LabelExtField02.text --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("labelField02Text", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC7:  (LabelExtField01.displayedMnemonic --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("filed01LabelDisplayedMnemonic", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC8:  (LabelExtField01.displayedMnemonic --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC8(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("label01DisplayedMnemonic", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC9:  (LabelExtField02.displayedMnemonic --> TwoFieldsPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC9(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("label02DisplayedMnemonic", arg1.getOldValue(), arg1.getNewValue());
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
 * Method generated to support the promotion of the field01FocusAccelerator attribute.
 * @return char
 */
public char getField01FocusAccelerator() {
	return getTextFieldExt01().getFocusAccelerator();
}
/**
 * Method generated to support the promotion of the field01KeyMask attribute.
 * @return int
 */
public TextFieldExt.KeyMask getField01KeyMask() {
	return getTextFieldExt01().getKeyMask();
}
/**
 * Method generated to support the promotion of the field01MaxLength attribute.
 * @return int
 */
public int getField01MaxLength() {
	return getTextFieldExt01().getMaxLength();
}
/**
 * Method generated to support the promotion of the field01Text attribute.
 * @return java.lang.String
 */
public String getField01Text() {
	return getTextFieldExt01().getValue();
}
/**
 * Method generated to support the promotion of the field01AllowedKey attribute.
 * @return int
 */
public TextFieldExt.AllowedKey getField01AllowedKey() {
	return getTextFieldExt01().getAllowedKey();
}
/**
 * Method generated to support the promotion of the field02FocusAccelerator attribute.
 * @return char
 */
public char getField02FocusAccelerator() {
	return getTextFieldExt02().getFocusAccelerator();
}
/**
 * Method generated to support the promotion of the field02KeyMask attribute.
 * @return int
 */
public TextFieldExt.KeyMask getField02KeyMask() {
	return getTextFieldExt02().getKeyMask();
}
/**
 * Method generated to support the promotion of the field02MaxLength attribute.
 * @return int
 */
public int getField02MaxLength() {
	return getTextFieldExt02().getMaxLength();
}
/**
 * Method generated to support the promotion of the field02Text attribute.
 * @return java.lang.String
 */
public String getField02Text() {
	return getTextFieldExt02().getValue();
}
/**
 * Method generated to support the promotion of the field02AllowedKey attribute.
 * @return int
 */
public TextFieldExt.AllowedKey getField02AllowedKey() {
	return getTextFieldExt02().getAllowedKey();
}
/**
 * Method generated to support the promotion of the label01DisplayedMnemonic attribute.
 * @return int
 */
public int getLabel01DisplayedMnemonic() {
	return getLabelExtField01().getDisplayedMnemonic();
}
/**
 * Method generated to support the promotion of the label02DisplayedMnemonic attribute.
 * @return int
 */
public int getLabel02DisplayedMnemonic() {
	return getLabelExtField02().getDisplayedMnemonic();
}
/**
 * Method generated to support the promotion of the labelField01Text attribute.
 * @return java.lang.String
 */
public String getLabelField01Text() {
	return getLabelExtField01().getText();
}
/**
 * Method generated to support the promotion of the labelField02Text attribute.
 * @return java.lang.String
 */
public String getLabelField02Text() {
	return getLabelExtField02().getText();
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
			ivjLabelExt.setText("            ");
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
			ivjLabelExt1.setText("             ");
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
			ivjLabelExt2.setText("             ");
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
			ivjLabelExt4.setText("            ");
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
 * Return the LabelExtField01 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExtField01() {
	if (ivjLabelExtField01 == null) {
		try {
			ivjLabelExtField01 = new efren.util.gui.LabelExt();
			ivjLabelExtField01.setName("LabelExtField01");
			ivjLabelExtField01.setText("Código");
			ivjLabelExtField01.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExtField01;
}
/**
 * Return the LabelExtField02 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExtField02() {
	if (ivjLabelExtField02 == null) {
		try {
			ivjLabelExtField02 = new efren.util.gui.LabelExt();
			ivjLabelExtField02.setName("LabelExtField02");
			ivjLabelExtField02.setText("Nombre");
			ivjLabelExtField02.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExtField02;
}
/**
 * Return the TextFieldExt01 property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExt01() {
	if (ivjTextFieldExt01 == null) {
		try {
			ivjTextFieldExt01 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExt01.setName("TextFieldExt01");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExt01;
}
/**
 * Return the TextFieldExt02 property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExt02() {
	if (ivjTextFieldExt02 == null) {
		try {
			ivjTextFieldExt02 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExt02.setName("TextFieldExt02");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExt02;
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
	// user code end
	getLabelExtField01().addPropertyChangeListener(this);
	getLabelExtField02().addPropertyChangeListener(this);
	getTextFieldExt01().addPropertyChangeListener(this);
	getTextFieldExt02().addPropertyChangeListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("TwoFieldsPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(369, 60);

		java.awt.GridBagConstraints constraintsLabelExtField01 = new java.awt.GridBagConstraints();
		constraintsLabelExtField01.gridx = 0; constraintsLabelExtField01.gridy = 0;
		constraintsLabelExtField01.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExtField01.weightx = 1.0;
		constraintsLabelExtField01.weighty = 1.0;
		constraintsLabelExtField01.insets = new java.awt.Insets(5, 10, 5, 5);
		add(getLabelExtField01(), constraintsLabelExtField01);

		java.awt.GridBagConstraints constraintsLabelExtField02 = new java.awt.GridBagConstraints();
		constraintsLabelExtField02.gridx = 0; constraintsLabelExtField02.gridy = 1;
		constraintsLabelExtField02.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExtField02.weightx = 1.0;
		constraintsLabelExtField02.weighty = 1.0;
		constraintsLabelExtField02.insets = new java.awt.Insets(0, 10, 5, 5);
		add(getLabelExtField02(), constraintsLabelExtField02);

		java.awt.GridBagConstraints constraintsTextFieldExt01 = new java.awt.GridBagConstraints();
		constraintsTextFieldExt01.gridx = 1; constraintsTextFieldExt01.gridy = 0;
		constraintsTextFieldExt01.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsTextFieldExt01.weightx = 1.0;
		constraintsTextFieldExt01.weighty = 1.0;
		constraintsTextFieldExt01.insets = new java.awt.Insets(5, 0, 5, 5);
		add(getTextFieldExt01(), constraintsTextFieldExt01);

		java.awt.GridBagConstraints constraintsTextFieldExt02 = new java.awt.GridBagConstraints();
		constraintsTextFieldExt02.gridx = 1; constraintsTextFieldExt02.gridy = 1;
		constraintsTextFieldExt02.gridwidth = 6;
		constraintsTextFieldExt02.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsTextFieldExt02.weightx = 1.0;
		constraintsTextFieldExt02.weighty = 1.0;
		constraintsTextFieldExt02.insets = new java.awt.Insets(0, 0, 5, 10);
		add(getTextFieldExt02(), constraintsTextFieldExt02);

		java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
		constraintsLabelExt.gridx = 2; constraintsLabelExt.gridy = 0;
		constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExt.weightx = 1.0;
		constraintsLabelExt.weighty = 1.0;
		constraintsLabelExt.insets = new java.awt.Insets(5, 10, 5, 5);
		add(getLabelExt(), constraintsLabelExt);

		java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
		constraintsLabelExt1.gridx = 4; constraintsLabelExt1.gridy = 0;
		constraintsLabelExt1.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExt1.weightx = 1.0;
		constraintsLabelExt1.weighty = 1.0;
		constraintsLabelExt1.insets = new java.awt.Insets(5, 10, 5, 5);
		add(getLabelExt1(), constraintsLabelExt1);

		java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
		constraintsLabelExt2.gridx = 5; constraintsLabelExt2.gridy = 0;
		constraintsLabelExt2.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExt2.weightx = 1.0;
		constraintsLabelExt2.weighty = 1.0;
		constraintsLabelExt2.insets = new java.awt.Insets(5, 10, 5, 5);
		add(getLabelExt2(), constraintsLabelExt2);

		java.awt.GridBagConstraints constraintsLabelExt4 = new java.awt.GridBagConstraints();
		constraintsLabelExt4.gridx = 3; constraintsLabelExt4.gridy = 0;
		constraintsLabelExt4.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExt4.weightx = 1.0;
		constraintsLabelExt4.weighty = 1.0;
		constraintsLabelExt4.insets = new java.awt.Insets(5, 10, 5, 5);
		add(getLabelExt4(), constraintsLabelExt4);
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the PropertyChangeListener interface.
 * @param evt java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void propertyChange(java.beans.PropertyChangeEvent evt) {
	// user code begin {1}
	// user code end
	if (evt.getSource() == getLabelExtField01() && (evt.getPropertyName().equals("displayedMnemonic")))
		connEtoC7(evt);
	if (evt.getSource() == getLabelExtField01() && (evt.getPropertyName().equals("text")))
		connEtoC5(evt);
	if (evt.getSource() == getLabelExtField01() && (evt.getPropertyName().equals("displayedMnemonic")))
		connEtoC8(evt);
	if (evt.getSource() == getLabelExtField02() && (evt.getPropertyName().equals("displayedMnemonic")))
		connEtoC9(evt);
	if (evt.getSource() == getLabelExtField02() && (evt.getPropertyName().equals("text")))
		connEtoC6(evt);
	if (evt.getSource() == getTextFieldExt01() && (evt.getPropertyName().equals("focusAccelerator")))
		connEtoC10(evt);
	if (evt.getSource() == getTextFieldExt01() && (evt.getPropertyName().equals("keyMask")))
		connEtoC2(evt);
	if (evt.getSource() == getTextFieldExt01() && (evt.getPropertyName().equals("allowedKey")))
		connEtoC1(evt);
	if (evt.getSource() == getTextFieldExt02() && (evt.getPropertyName().equals("focusAccelerator")))
		connEtoC11(evt);
	if (evt.getSource() == getTextFieldExt02() && (evt.getPropertyName().equals("allowedKey")))
		connEtoC3(evt);
	if (evt.getSource() == getTextFieldExt02() && (evt.getPropertyName().equals("keyMask")))
		connEtoC4(evt);
	// user code begin {2}
	// user code end
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * Method generated to support the promotion of the field01FocusAccelerator attribute.
 * @param arg1 char
 */
public void setField01FocusAccelerator(char arg1) {
	getTextFieldExt01().setFocusAccelerator(arg1);
}
/**
 * Method generated to support the promotion of the field01KeyMask attribute.
 * @param arg1 int
 */
public void setField01KeyMask(TextFieldExt.KeyMask arg1) {
	getTextFieldExt01().setKeyMask(arg1);
}
/**
 * Method generated to support the promotion of the field01MaxLength attribute.
 * @param arg1 int
 */
public void setField01MaxLength(int arg1) {
	getTextFieldExt01().setMaxLength(arg1);
}
/**
 * Method generated to support the promotion of the field01Text attribute.
 * @param arg1 java.lang.String
 */
public void setField01Text(String arg1) {
	getTextFieldExt01().setValue(arg1);
}
/**
 * Method generated to support the promotion of the field01AllowedKey attribute.
 * @param arg1 int
 */
public void setField01AllowedKey(TextFieldExt.AllowedKey arg1) {
	getTextFieldExt01().setAllowedKey(arg1);
}
/**
 * Method generated to support the promotion of the field02FocusAccelerator attribute.
 * @param arg1 char
 */
public void setField02FocusAccelerator(char arg1) {
	getTextFieldExt02().setFocusAccelerator(arg1);
}
/**
 * Method generated to support the promotion of the field02KeyMask attribute.
 * @param arg1 int
 */
public void setField02KeyMask(TextFieldExt.KeyMask arg1) {
	getTextFieldExt02().setKeyMask(arg1);
}
/**
 * Method generated to support the promotion of the field02MaxLength attribute.
 * @param arg1 int
 */
public void setField02MaxLength(int arg1) {
	getTextFieldExt02().setMaxLength(arg1);
}
/**
 * Method generated to support the promotion of the field02Text attribute.
 * @param arg1 java.lang.String
 */
public void setField02Text(String arg1) {
	getTextFieldExt02().setValue(arg1);
}
/**
 * Method generated to support the promotion of the field02AllowedKey attribute.
 * @param arg1 int
 */
public void setField02AllowedKey(TextFieldExt.AllowedKey arg1) {
	getTextFieldExt02().setAllowedKey(arg1);
}
/**
 * Method generated to support the promotion of the label01DisplayedMnemonic attribute.
 * @param arg1 int
 */
public void setLabel01DisplayedMnemonic(int arg1) {
	getLabelExtField01().setDisplayedMnemonic(arg1);
}
/**
 * Method generated to support the promotion of the label02DisplayedMnemonic attribute.
 * @param arg1 int
 */
public void setLabel02DisplayedMnemonic(int arg1) {
	getLabelExtField02().setDisplayedMnemonic(arg1);
}
/**
 * Method generated to support the promotion of the labelField01Text attribute.
 * @param arg1 java.lang.String
 */
public void setLabelField01Text(String arg1) {
	getLabelExtField01().setText(arg1);
}
/**
 * Method generated to support the promotion of the labelField02Text attribute.
 * @param arg1 java.lang.String
 */
public void setLabelField02Text(String arg1) {
	getLabelExtField02().setText(arg1);
}
}
