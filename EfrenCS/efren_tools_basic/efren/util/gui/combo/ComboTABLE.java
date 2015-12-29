package efren.util.gui.combo;

import efren.util.ExceptionManager;
import efren.util.gui.CheckBoxExt;
import efren.util.gui.LabelExt;

public class ComboTABLE extends javax.swing.JPanel {
    
	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBox = null;
    private java.lang.String TABLE_NAME;
    private java.lang.String COLUMN_NAME;
	private efren.util.gui.CheckBoxExt ivjJCheckBoxExt = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
    private boolean fieldNullable = false;
	private efren.util.gui.LabelExt ivjLabelExtText = null;
	protected transient efren.util.gui.combo.ComboTABLEListener fieldComboTABLEListenerEventMulticaster = null;

class IvjEventHandler implements java.awt.event.ItemListener, java.beans.PropertyChangeListener {
		public void itemStateChanged(java.awt.event.ItemEvent e) {
			if (e.getSource() == ComboTABLE.this.getObjectComboBox()) 
				connEtoC3(e);
		};
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == ComboTABLE.this.getJCheckBoxExt() && (evt.getPropertyName().equals("selectedOption"))) 
				connEtoC2(evt);
			if (evt.getSource() == ComboTABLE.this.getJCheckBoxExt() && (evt.getPropertyName().equals("text"))) 
				connEtoC1(evt);
		};
	};
/**
 * ComboTABLE constructor comment.
 */
public ComboTABLE() {
	super();
	initialize();
}
/**
 * ComboTABLE constructor comment.
 * @param layout java.awt.LayoutManager
 */
public ComboTABLE(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * ComboTABLE constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public ComboTABLE(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * ComboTABLE constructor comment.
 * @param isDoubleBuffered boolean
 */
public ComboTABLE(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * 
 * @param newListener ComboTABLEListener
 */
public void addComboTABLEListener(ComboTABLEListener newListener) {
	fieldComboTABLEListenerEventMulticaster = ComboTABLEListenerEventMulticaster.add(fieldComboTABLEListenerEventMulticaster, newListener);
	return;
}
public void addItem(Object item) {
	getObjectComboBox().addItem(item);
}
public void addValueForItem(String aValueForItem) {
	getObjectComboBox().addValueForItem(aValueForItem);
}
/**
 * connEtoC1:  (JCheckBoxExt.text --> ComboTABLE.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("textForNullable", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (JCheckBoxExt.selectedOption --> ComboTABLE.visualManageNulls()V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.visualManageNulls();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (ObjectComboBox.item.itemStateChanged(java.awt.event.ItemEvent) --> ComboTABLE.fireItemStateChanged(Ljava.util.EventObject;)V)
 * @param arg1 java.awt.event.ItemEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.awt.event.ItemEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.fireItemStateChanged(new java.util.EventObject(this));
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
public void deselect() {
    getObjectComboBox().deselect();
}
public boolean esNulo() {
    if (!getNullable())
        return getValue() < 0;

    return getNullable() && (getValue() < 0);
}
/**
 * Method to support listener events.
 * @param newEvent java.util.EventObject
 */
protected void fireItemSelected(java.util.EventObject newEvent) {
	if (fieldComboTABLEListenerEventMulticaster == null) {
		return;
	};
	fieldComboTABLEListenerEventMulticaster.itemSelected(newEvent);
}
/**
 * Method to support listener events.
 * @param newEvent java.util.EventObject
 */
protected void fireItemStateChanged(java.util.EventObject newEvent) {
	if (fieldComboTABLEListenerEventMulticaster == null) {
		return;
	};
	fieldComboTABLEListenerEventMulticaster.itemStateChanged(newEvent);
}
/**
 * Insert the method's description here.
 * Creation date: (28-Aug-2003 14:34:38 PM)
 * @return java.lang.String
 */
public java.lang.String getCOLUMN_NAME() {
	return COLUMN_NAME;
}
/**
 * Return the JCheckBoxExt property value.
 * @return efren.util.gui.JCheckBoxExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.CheckBoxExt getJCheckBoxExt() {
	if (ivjJCheckBoxExt == null) {
		try {
			ivjJCheckBoxExt = new efren.util.gui.CheckBoxExt();
			ivjJCheckBoxExt.setName("JCheckBoxExt");
			ivjJCheckBoxExt.setText("ifNullableText");
			ivjJCheckBoxExt.setHorizontalAlignment(2);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJCheckBoxExt;
}
/**
 * Gets the nullable property (boolean) value.
 * @return The nullable property value.
 * @see #setNullable
 */
public boolean getNullable() {
	return fieldNullable;
}
/**
 * Return the ObjectComboBox property value.
 * @return efren.util.gui.combo.ObjectComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.combo.ObjectComboBox getObjectComboBox() {
	if (ivjObjectComboBox == null) {
		try {
			ivjObjectComboBox = new efren.util.gui.combo.ObjectComboBox();
			ivjObjectComboBox.setName("ObjectComboBox");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjObjectComboBox;
}
public int getSelectedIndex() {
    return getObjectComboBox().getSelectedIndex();
}
public Object getSelectedItem() {

    return getObjectComboBox().getSelectedItem();
}
/**
 * Method generated to support the promotion of the selectedValueItem attribute.
 * @return java.lang.Object
 */
private Object getSelectedValueItem() {
    return getObjectComboBox().getSelectedValueItem();
}
/**
 * Return the LabelExtText property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExtText() {
	if (ivjLabelExtText == null) {
		try {
			ivjLabelExtText = new efren.util.gui.LabelExt();
			ivjLabelExtText.setName("LabelExtText");
			ivjLabelExtText.setText("ifNullableText");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExtText;
}
/**
 * Insert the method's description here.
 * Creation date: (28-Aug-2003 14:32:56 PM)
 * @return java.lang.String
 */
public java.lang.String getTABLE_NAME() {
	return TABLE_NAME;
}
/**
 * Method generated to support the promotion of the textForNullable attribute.
 * @return java.lang.String
 */
public java.lang.String getTextForNullable() {
	return getJCheckBoxExt().getText();
}
/**
 * Method generated to support the promotion of the selectedValueItem attribute.
 * @return java.lang.Object
 */
public long getValue() {
	if (getSelectedValueItem() == null)
		return -1;
	else
		return new Long(getObjectComboBox().getSelectedValueItem().toString()).longValue();
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
public boolean initCombo() throws Throwable {

	if (getTABLE_NAME() == null || getTABLE_NAME().trim().length() == 0 ||
		getCOLUMN_NAME() == null || getCOLUMN_NAME().trim().length() == 0)
		return false;

	java.sql.Statement st = efren.util.Conn.conectar().createStatement();
	String s = "SELECT OID, RTRIM(LTRIM("+getCOLUMN_NAME().trim()+")) AS "+getCOLUMN_NAME().trim()
		+ " FROM "+getTABLE_NAME().trim()
//		+ " WHERE UCASE(RTRIM(LTRIM(TABLA)))=UCASE('"+getTABLE_NAME().trim()+"') "
//		+ " AND UCASE(RTRIM(LTRIM(CAMPO)))=UCASE('"+getCOLUMN_NAME().trim()+"') "
		+ " ORDER BY "+getCOLUMN_NAME().trim();
	java.sql.ResultSet rs = st.executeQuery(s);
	getObjectComboBox().removeAllItems();
	boolean siHayDatos = false;
	while (rs.next()) {
		getObjectComboBox().addValueForItem(new Long(rs.getLong(1)));
		getObjectComboBox().addItem(rs.getString(2));
		siHayDatos = true;
	}
	deselect();
	st.close();
	
	return siHayDatos;
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getObjectComboBox().addItemListener(ivjEventHandler);
	getJCheckBoxExt().addPropertyChangeListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("ComboTABLE");
		setLayout(new java.awt.GridBagLayout());
		setSize(271, 24);

		java.awt.GridBagConstraints constraintsObjectComboBox = new java.awt.GridBagConstraints();
		constraintsObjectComboBox.gridx = 1; constraintsObjectComboBox.gridy = 0;
		constraintsObjectComboBox.fill = java.awt.GridBagConstraints.BOTH;
		constraintsObjectComboBox.weightx = 1.0;
		constraintsObjectComboBox.weighty = 1.0;
		constraintsObjectComboBox.insets = new java.awt.Insets(0, 1, 0, 0);
		add(getObjectComboBox(), constraintsObjectComboBox);

		java.awt.GridBagConstraints constraintsJCheckBoxExt = new java.awt.GridBagConstraints();
		constraintsJCheckBoxExt.gridx = 0; constraintsJCheckBoxExt.gridy = 0;
		constraintsJCheckBoxExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsJCheckBoxExt.anchor = java.awt.GridBagConstraints.WEST;
		constraintsJCheckBoxExt.weightx = 1.0;
		constraintsJCheckBoxExt.insets = new java.awt.Insets(0, 4, 0, 1);
		add(getJCheckBoxExt(), constraintsJCheckBoxExt);

		java.awt.GridBagConstraints constraintsLabelExtText = new java.awt.GridBagConstraints();
		constraintsLabelExtText.gridx = 0; constraintsLabelExtText.gridy = 0;
		constraintsLabelExtText.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsLabelExtText.anchor = java.awt.GridBagConstraints.WEST;
		constraintsLabelExtText.weightx = 1.0;
		constraintsLabelExtText.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getLabelExtText(), constraintsLabelExtText);
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	setNullable(getNullable());
	// user code end
}
public boolean isDataMissing() {

    return getObjectComboBox().isDataMissing();
}
public boolean isDataMissing(String errorMessage) {

    return getObjectComboBox().isDataMissing(errorMessage);
}
public boolean isEditable() {
    return getObjectComboBox().isEditable();
}
public boolean isEnabled() {
    return getObjectComboBox().isEnabled();
}

public void removeComboTABLEListener(ComboTABLEListener newListener) {
	fieldComboTABLEListenerEventMulticaster = ComboTABLEListenerEventMulticaster.remove(fieldComboTABLEListenerEventMulticaster, newListener);
	return;
}

public void setBackground(java.awt.Color c) {
    //no hacemos nada
    //super.setBackground(c);

    //	getJCheckBoxExt().setBackground(c);
}
/**
 * Insert the method's description here.
 * Creation date: (28-Aug-2003 14:34:38 PM)
 * @param newCOLUMN_NAME java.lang.String
 */
public void setCOLUMN_NAME(java.lang.String newCOLUMN_NAME) {
	COLUMN_NAME = newCOLUMN_NAME;
}
public void setEditable(boolean flag) {

    getObjectComboBox().setEditable(flag);
}
public void setEnabled(boolean aFlag) {

    super.setEnabled(aFlag);

    if (getNullable()) {
        getJCheckBoxExt().setVisible(aFlag);
        getLabelExtText().setVisible(!aFlag);
        if (!aFlag)
            getObjectComboBox().setEnabled(false);
    } else
        getObjectComboBox().setEnabled(aFlag);
}
public void setFont(java.awt.Font font1) {

    getObjectComboBox().setFont(font1);
}
public void setForeground(java.awt.Color c) {
    super.setForeground(c);

    getJCheckBoxExt().setForeground(c);
}
/**
 * Sets the nullable property (boolean) value.
 * @param nullable The new value for the property.
 * @see #getNullable
 */
public void setNullable(boolean nullable) {
    boolean oldValue = fieldNullable;
    fieldNullable = nullable;
    firePropertyChange("nullable", new Boolean(oldValue), new Boolean(nullable));

    if (nullable) {
        getJCheckBoxExt().setText(getTextForNullable());
        getLabelExtText().setText(getTextForNullable());

        getObjectComboBox().setEnabled(false);
        getObjectComboBox().deselect();
    } else
        getObjectComboBox().setEnabled(true);

    getJCheckBoxExt().setVisible(nullable);
    getLabelExtText().setVisible(nullable);
}
/**
 * Method generated to support the promotion of the selectedValueItem attribute.
 * @param arg1 java.lang.Object
 */
private void setSelectedValueItem(Object arg1) {
    getObjectComboBox().setSelectedValueItem(arg1);

    if (arg1 != null) {
        if (getNullable()) {
            if (getObjectComboBox().getSelectedIndex() >= 0)
                getJCheckBoxExt().setSelectedOption(getJCheckBoxExt().getTrueOption());
            else
                getJCheckBoxExt().setSelectedOption(getJCheckBoxExt().getFalseOption());
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28-Aug-2003 14:32:56 PM)
 * @param newTABLE_NAME java.lang.String
 */
public void setTABLE_NAME(java.lang.String newTABLE_NAME) {
	TABLE_NAME = newTABLE_NAME;
}
/**
 * Method generated to support the promotion of the textForNullable attribute.
 * @param arg1 java.lang.String
 */
public void setTextForNullable(java.lang.String arg1) {
    getJCheckBoxExt().setText(arg1);
    getLabelExtText().setText(arg1);
}
/**
 * Method generated to support the promotion of the selectedValueItem attribute.
 * @param arg1 java.lang.Object
 */
public void setValue(long aValue) {

    if (aValue < 0)
        setSelectedValueItem(null);
    else
        setSelectedValueItem(String.valueOf(aValue));
}
public String SQLText() {

    if (this.getValue() < 0)
        return " NULL ";
    else
        return String.valueOf(this.getValue());
}
private void visualManageNulls() {

    if (getJCheckBoxExt().isSelected()) {
        getObjectComboBox().setEnabled(true);
    } else {
        getObjectComboBox().setEnabled(false);
        getObjectComboBox().deselect();
    }
}
}
