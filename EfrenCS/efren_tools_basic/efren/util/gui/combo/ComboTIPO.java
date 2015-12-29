package efren.util.gui.combo;

import efren.util.ExceptionManager;

/**
 * Insert the type's description here. Creation date: (28-Aug-2003 14:09:55 PM)
 * 
 * @author: Efrén Villamagua
 */
public class ComboTIPO extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3652328047250892970L;

	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBox = null;

	private java.lang.String TABLE_NAME;

	private java.lang.String COLUMN_NAME;

	private efren.util.gui.CheckBoxExt ivjJCheckBoxExt = null;

	IvjEventHandler ivjEventHandler = new IvjEventHandler();

	private boolean fieldNullable = false;

	private efren.util.gui.LabelExt ivjLabelExtText = null;

	protected transient efren.util.gui.combo.ComboTIPOListener fieldComboTIPOListenerEventMulticaster = null;

	class IvjEventHandler implements java.awt.event.ItemListener, java.beans.PropertyChangeListener {
		public void itemStateChanged(java.awt.event.ItemEvent e) {
			if (e.getSource() == ComboTIPO.this.getObjectComboBox())
				connEtoC3(e);
		};

		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == ComboTIPO.this.getJCheckBoxExt() && (evt.getPropertyName().equals("selectedOption")))
				connEtoC2(evt);
			if (evt.getSource() == ComboTIPO.this.getJCheckBoxExt() && (evt.getPropertyName().equals("text")))
				connEtoC1(evt);
		};
	};

	/**
	 * ComboTIPO constructor comment.
	 */
	public ComboTIPO() {
		super();
		initialize();
	}

	/**
	 * ComboTIPO constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public ComboTIPO(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * ComboTIPO constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ComboTIPO(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * ComboTIPO constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ComboTIPO(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 *
	 * @param newListener
	 *            ComboTIPOListener
	 */
	public void addComboTIPOListener(ComboTIPOListener newListener) {
		fieldComboTIPOListenerEventMulticaster = ComboTIPOListenerEventMulticaster.add(fieldComboTIPOListenerEventMulticaster, newListener);
		return;
	}

	public void addItem(Object item) {
		getObjectComboBox().addItem(item);
	}

	public void addValueForItem(String aValueForItem) {
		getObjectComboBox().addValueForItem(aValueForItem);
	}

	/**
	 * connEtoC1: (JCheckBoxExt.text -->
	 * ComboTIPO.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.
	 * lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
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
	 * connEtoC2: (JCheckBoxExt.selectedOption -->
	 * ComboTIPO.visualManageNulls()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
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
	 * connEtoC3:
	 * (ObjectComboBox.item.itemStateChanged(java.awt.event.ItemEvent) -->
	 * ComboTIPO.fireItemStateChanged(Ljava.util.EventObject;)V)
	 * 
	 * @param arg1
	 *            java.awt.event.ItemEvent
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

	public void selectFirst() {
		getObjectComboBox().setSelectedIndex(0);
	}

	public boolean esNulo() {
		if (!getNullable())
			return getValue() < 0;

		return getNullable() && (getValue() < 0);
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireItemSelected(java.util.EventObject newEvent) {
		if (fieldComboTIPOListenerEventMulticaster == null) {
			return;
		}
		;
		fieldComboTIPOListenerEventMulticaster.itemSelected(newEvent);
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireItemStateChanged(java.util.EventObject newEvent) {
		if (fieldComboTIPOListenerEventMulticaster == null) {
			return;
		}
		;
		fieldComboTIPOListenerEventMulticaster.itemStateChanged(newEvent);
	}

	/**
	 * Insert the method's description here. Creation date: (28-Aug-2003
	 * 14:34:38 PM)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}

	/**
	 * Return the JCheckBoxExt property value.
	 * 
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
	 * 
	 * @return The nullable property value.
	 * @see #setNullable
	 */
	public boolean getNullable() {
		return fieldNullable;
	}

	/**
	 * Return the ObjectComboBox property value.
	 * 
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
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 * 
	 * @return java.lang.Object
	 */
	private Object getSelectedValueItem() {
		return getObjectComboBox().getSelectedValueItem();
	}

	/**
	 * Return the LabelExtText property value.
	 * 
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
	 * Insert the method's description here. Creation date: (28-Aug-2003
	 * 14:32:56 PM)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTABLE_NAME() {
		return TABLE_NAME;
	}

	/**
	 * Method generated to support the promotion of the textForNullable
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTextForNullable() {
		return getJCheckBoxExt().getText();
	}

	/**
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 * 
	 * @return java.lang.Object
	 */
	public int getValue() {
		if (getSelectedValueItem() == null)
			return -1;
		else
			return new Integer(getObjectComboBox().getSelectedValueItem().toString()).intValue();
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	public boolean initCombo() throws Throwable {

		if (getTABLE_NAME() == null || getTABLE_NAME().trim().length() == 0 || getCOLUMN_NAME() == null || getCOLUMN_NAME().trim().length() == 0)
			return false;

		boolean siHayDatos = false;

		java.sql.Statement st = efren.util.Conn.conectar().createStatement();
		String s = "SELECT TIPO, RTRIM(LTRIM(DESCRIPCION)) " + " FROM TIPO " + " WHERE UCASE(RTRIM(LTRIM(TABLA)))=UCASE('" + getTABLE_NAME().trim() + "') "
				+ " AND UCASE(RTRIM(LTRIM(CAMPO)))=UCASE('" + getCOLUMN_NAME().trim() + "') " + " ORDER BY TIPO";
		java.sql.ResultSet rs = st.executeQuery(s);
		getObjectComboBox().removeAllItems();
		while (rs.next()) {
			getObjectComboBox().addValueForItem(rs.getString(1));
			getObjectComboBox().addItem(rs.getString(2));
			siHayDatos = true;
		}
		st.close();

		deselect();

		return siHayDatos;
	}

	/**
	 * Initializes connections
	 * 
	 * @exception java.lang.Exception
	 *                The exception description.
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
			setName("ComboTIPO");
			setLayout(new java.awt.GridBagLayout());
			setSize(271, 24);

			java.awt.GridBagConstraints constraintsObjectComboBox = new java.awt.GridBagConstraints();
			constraintsObjectComboBox.gridx = 1;
			constraintsObjectComboBox.gridy = 0;
			constraintsObjectComboBox.fill = java.awt.GridBagConstraints.BOTH;
			constraintsObjectComboBox.weightx = 1.0;
			constraintsObjectComboBox.weighty = 1.0;
			constraintsObjectComboBox.insets = new java.awt.Insets(0, 1, 0, 0);
			add(getObjectComboBox(), constraintsObjectComboBox);

			java.awt.GridBagConstraints constraintsJCheckBoxExt = new java.awt.GridBagConstraints();
			constraintsJCheckBoxExt.gridx = 0;
			constraintsJCheckBoxExt.gridy = 0;
			constraintsJCheckBoxExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJCheckBoxExt.anchor = java.awt.GridBagConstraints.WEST;
			constraintsJCheckBoxExt.weightx = 1.0;
			constraintsJCheckBoxExt.insets = new java.awt.Insets(0, 4, 0, 1);
			add(getJCheckBoxExt(), constraintsJCheckBoxExt);

			java.awt.GridBagConstraints constraintsLabelExtText = new java.awt.GridBagConstraints();
			constraintsLabelExtText.gridx = 0;
			constraintsLabelExtText.gridy = 0;
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

	/**
	 *
	 * @param newListener
	 *            ComboTIPOListener
	 */
	public void removeComboTIPOListener(ComboTIPOListener newListener) {
		fieldComboTIPOListenerEventMulticaster = ComboTIPOListenerEventMulticaster.remove(fieldComboTIPOListenerEventMulticaster, newListener);
		return;
	}

	public void setBackground(java.awt.Color c) {
		// no hacemos nada
		// super.setBackground(c);

		// getJCheckBoxExt().setBackground(c);
	}

	/**
	 * Insert the method's description here. Creation date: (28-Aug-2003
	 * 14:34:38 PM)
	 * 
	 * @param newCOLUMN_NAME
	 *            java.lang.String
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
	 * 
	 * @param nullable
	 *            The new value for the property.
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
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.Object
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
	 * Insert the method's description here. Creation date: (28-Aug-2003
	 * 14:32:56 PM)
	 * 
	 * @param newTABLE_NAME
	 *            java.lang.String
	 */
	public void setTABLE_NAME(java.lang.String newTABLE_NAME) {
		TABLE_NAME = newTABLE_NAME;
	}

	/**
	 * Method generated to support the promotion of the textForNullable
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setTextForNullable(java.lang.String arg1) {
		getJCheckBoxExt().setText(arg1);
		getLabelExtText().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.Object
	 */
	public void setValue(int value) {

		if (value < 0)
			setSelectedValueItem(null);
		else
			setSelectedValueItem(String.valueOf(value));
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
