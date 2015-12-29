package efren.util.gui.combo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.PopupMenuListener;

import efren.util.gui.dialogs.InfoView;
import java.awt.Dimension;

public class ObjectComboBox extends JPanel implements ActionListener, FocusListener, ItemListener, KeyListener, ItemSelectable {
	/**
	 *
	 */
	private static final long serialVersionUID = 3733781858945534320L;
	/**
	 *
	 */
	private Vector actionListeners;
	private Vector itemListeners;
	private String aboutThisBean;
	private boolean autoMatch;
	private boolean caseSensitive;
	private boolean autoIncreasing;
	private boolean editable;
	private boolean enabled;
	private String actionCommand;  //  @jve:decl-index=0:
	private Vector ComboBoxListeners;
	private int maximumRowCount;
	private Color foregroundTrue;
	private Color backgroundTrue;
	private Color foregroundFalse;
	private Color backgroundFalse;
	private Font font;
	private transient JTextField editor;
	private int oldSelectedIndex;
	private Object oldSelectedItem;
	private String oldSelectedDisplayName;
	protected transient ObjectComboBoxListener fieldObjectComboBoxListenerEventMulticaster = null;
	private boolean fieldAutoSelectFirst = false;
	private boolean fieldDuplicatePermitted = true;
	//...
	private DefaultComboBoxModel tsDefaultComboBoxModel;
	private Vector internalValuesForItems = new Vector();
	private Object ivjselectedValue = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private boolean combing = false;
	private boolean indexing = false;
	private char fieldFocusAccelerator = '0';
	private String[] fieldValuesForItems = null;
	private ComboBoxExt ivjComboBox = null;
	private Vector datosAdicionales01 = new Vector();
	//...
	private boolean enableActions = true;
	/**
	 * Constructor
	 */
	public ObjectComboBox() {
		super();
		initialize();
	}
	/**
	 *
	 * @param aobj
	 */
	public ObjectComboBox(Object aobj[]) {
		super();
		initialize();
		this.setItems(aobj);
	}
	/**
	 *
	 * @param vector
	 */
	public ObjectComboBox(Vector vector) {
		super();
		initialize();
		this.setItems(vector);
	}
	/**
	 *
	 */
	public void actionPerformed(ActionEvent actionevent) {
		Vector vector = new Vector();
		synchronized (vector) {
			vector = (Vector) actionListeners.clone();
		}
		for (int i = 0; i < vector.size(); i++) {
			ActionListener actionlistener = (ActionListener) vector.elementAt(i);
			actionlistener.actionPerformed(new ActionEvent(this, actionevent.getID(), actionevent.getActionCommand()));
		}
		try {
			if (getComboBox().isPopupVisible()) {
				getComboBox().hidePopup();//TODO OJO ????
			}
			//updateUI();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 *
	 * @param actionlistener
	 */
	public void addActionListener(ActionListener actionlistener) {
		if (actionlistener != null) {
			actionListeners.addElement(actionlistener);
			return;
		} else {
			throw new NullPointerException("addActionListener:  the listener is null.");
		}
	}
	/**
	 *
	 * @param comboboxlistlistener
	 */
	public void addComboBoxListListener(ComboBoxListListener comboboxlistlistener) {
		if (comboboxlistlistener != null) {
			ComboBoxListeners.addElement(comboboxlistlistener);
			return;
		} else {
			throw new NullPointerException("addComboBoxListListener: listener is null.");
		}
	}
	/**
	 *
	 * @param item
	 */
	public void addItem(Object item) {
		this.addItem(item, null);
	}
	/**
	 * - item: objeto para añadir al combo - toDisplay: string a mostrarse en el combo para el item a añadirse
	 */
	private void addItem(Object item, String toDisplay) {

		// validaciones
		if (item == null) {
			// throw new NullPointerException("addItem : the item is null.");
			return;
		}
		if (toDisplay == null) {
			toDisplay = item.toString();
		}
		for (int i = 0; i < getItemCount(); i++) {
			if (getModel().getElementAt(i) == item) {
				// throw new IllegalArgumentException("addItem : the item is existed.");
				return;
			}
		}
		if (isDuplicateName(toDisplay)) {
			// throw new IllegalArgumentException("addItem : the name is already existed or empty.");
			return;
		}
		// ...

		int j = this.getItemCount();
		Object aobj[] = this.getItems();
		String as[] = getDisplayNames();

		getComboBox().addItem(toDisplay.trim());

		getModel().addObject(item);

		firePropertyChange("itemCount", j, getItemCount());

		if ((getItemCount() >= 1) && isAutoSelectFirst()) {
			this.getComboBox().setSelectedItem(this.getModel().getElementAt(0));
			this.getComboBox().setSelectedIndex(0);
			firePropertyChange("selectedDisplayName", oldSelectedDisplayName, toDisplay);
			oldSelectedDisplayName = (String) this.getComboBox().getItemAt(0);
		}

		fireComboBoxListEvent(0, this.getItemIndex(item));
		Object aobj1[] = this.getItems();
		String as1[] = this.getDisplayNames();
		firePropertyChange("items", ((Object) (aobj)), ((Object) (aobj1)));
		firePropertyChange("displayNames", as, as1);

	}

	public void addItemListener(ItemListener itemlistener) {
		if (itemlistener != null) {
			itemListeners.addElement(itemlistener);
			return;
		} else {
			throw new NullPointerException("addItemListener:  the listener is null.");
		}
	}

	public void addObjectComboBoxListener(ObjectComboBoxListener newListener) {
		fieldObjectComboBoxListenerEventMulticaster = ObjectComboBoxListenerEventMulticaster.add(fieldObjectComboBoxListenerEventMulticaster, newListener);
		return;
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

	public void addValueForItem(String aStringValueForItem) {
		this.internalValuesForItems.addElement(aStringValueForItem);
	}

	public void addValueForItem(Long aLongValueForItem) {
		this.internalValuesForItems.addElement(aLongValueForItem);
	}

	/**
	 * connEtoM1: (ObjectComboBox.focus.focusGained(java.awt.event.FocusEvent)
	 * --> ComboBox.transferFocus()V)
	 *
	 * @param arg1
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(java.awt.event.FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getComboBox().requestFocus();
			// user code begin {2}
			// user code end
		} catch (Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM2: (ObjectComboBox.focus.focusLost(java.awt.event.FocusEvent) -->
	 * ComboBox.hidePopup()V)
	 *
	 * @param arg1
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM2(java.awt.event.FocusEvent arg1) {
		try {
			if (getComboBox().isPopupVisible()) {
				getComboBox().hidePopup();
			}
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	public void deselect() {
		editor.setText("");
		this.getComboBox().setSelectedIndex(-1);
	}
	/**
	 *
	 * @param i
	 * @param j
	 */
	private void fireComboBoxListEvent(int i, int j) {
		Vector vector = new Vector();
		synchronized (vector) {
			vector = (Vector) ComboBoxListeners.clone();
		}
		ComboBoxListEvent comboboxlistevent = new ComboBoxListEvent(this, i, j);
		switch (i) {
		case 0:
			for (int k = 0; k < vector.size(); k++) {
				((ComboBoxListListener) vector.elementAt(k)).itemAdded(comboboxlistevent);
			}
			return;
		case 1:
			for (int l = 0; l < vector.size(); l++) {
				((ComboBoxListListener) vector.elementAt(l)).itemRemoved(comboboxlistevent);
			}
			return;
		case 2:
			for (int i1 = 0; i1 < vector.size(); i1++) {
				((ComboBoxListListener) vector.elementAt(i1)).itemSelected(comboboxlistevent);
			}
			return;
		case 3:
			for (int j1 = 0; j1 < vector.size(); j1++) {
				((ComboBoxListListener) vector.elementAt(j1)).itemDeselected(comboboxlistevent);
			}
			return;
		case 4:
			for (int k1 = 0; k1 < vector.size(); k1++) {
				((ComboBoxListListener) vector.elementAt(k1)).itemValueChanged(comboboxlistevent);
			}
			return;
		}
	}

	/**
	 * Method to support listener events. Aumentado Para el KeyReleased
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void firekeyReleased(java.awt.event.KeyEvent newEvent) {
		if (fieldObjectComboBoxListenerEventMulticaster == null) {
			return;
		}
		fieldObjectComboBoxListenerEventMulticaster.keyReleased(new java.awt.event.KeyEvent(
				this, newEvent.getID(), newEvent.getWhen(), newEvent.getModifiers(), newEvent	.getKeyCode(), newEvent.getKeyChar()));
	}

	protected void fireFocusGained(FocusEvent newEvent) {
		if (fieldObjectComboBoxListenerEventMulticaster == null) {
			return;
		}
		fieldObjectComboBoxListenerEventMulticaster.focusGained(new FocusEvent(this, newEvent.getID()));
	}
	/**
	 * 
	 */
	private void fireKeyReleasedPromoted(java.awt.event.KeyEvent arg1) {
		try {
			this.firekeyReleased(arg1);
		} catch (Throwable ivjExc) {
			ivjExc.getMessage();
		}
	}
	/**
	 * 
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}
	/**
	 *
	 */
	public void focusGained(java.awt.event.FocusEvent e) {
		try {
			if (this.editor != null && this.editor.isEnabled() && this.editor.isEditable()) {
				this.editor.selectAll();
			}
			if (e.getSource() == this) {
				connEtoM1(e);
			}
			if (this.editor != null && this.editor.isEnabled() && this.editor.isEditable()) {
				this.editor.selectAll();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		try {
			fireFocusGained(e);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	/**
	 *
	 */
	public void focusLost(java.awt.event.FocusEvent e) {
		try {
			if (getComboBox().isPopupVisible()) {
				getComboBox().hidePopup();
			}
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
/*
		if (e.getSource() == this) {
			connEtoM2(e);
		}
	}
*/
	}
	/**
	 *
	 */
	public String getAboutThisBean() {
		return getClass().getName()
				+ "^ObjectComboBox^1.0^ObjectComboBox_About_bean.gif^ObjectComboBox_Other_Features.gif^ObjectComboBox_Other_Features2.gif^ObjectComboBox_Other_Features3.gif^ObjectComboBox_Wiring_Example.gif^/ObjectComboBox/docs/index.html";
	}
	/**
	 *
	 */
	public String getActionCommand() {
		return actionCommand;
	}
	/**
	 *
	 */
	public Color getBackground() {
		if (this.enabled)
			return backgroundTrue;
		else
			return backgroundFalse;
	}
	/**
	 * 
	 */
	private ComboBoxExt getComboBox() {
		if (ivjComboBox == null) {
			ivjComboBox = new ComboBoxExt();
			ivjComboBox.setName("ComboBox");
			ivjComboBox.setPreferredSize(new Dimension(130, 20));
			ivjComboBox.setFont(new java.awt.Font("Arial", 0, 10));
			ivjComboBox.setLightWeightPopupEnabled(false);
			ivjComboBox.setMinimumSize(new Dimension(126, 20));
/*
			try {
				ivjComboBox.putClientProperty(SubstanceLookAndFeel.FLAT_PROPERTY, Boolean.FALSE);
			} catch (Exception e) {
				e.getMessage();
			}
*/
		}
		return ivjComboBox;
	}
	/**
	 *
	 */
	private String getDisplayName(Object item) {

		if (item == null)
			throw new NullPointerException("getDisplayName: item is null.");

		int index = getModel().getIndexOf(item);

		if (index == -1) {
			throw new IllegalArgumentException("item is not existed.");
		}

		for (int i = 0; i < this.getItemCount(); i++) {
			if (this.getModel().getElementAt(i) == item) {
				return (String) getComboBox().getItemAt(i);
			}
		}
		return null;
	}
	/**
	 *
	 */
	private String getDisplayNameAt(int index) {

		if (index >= getComboBox().getItemCount() || index < 0)
			throw new IllegalArgumentException("getDisplayNameAt: " + index + " out of bounds.");
		else
			return (String) getComboBox().getItemAt(index);
	}
	/**
	 *
	 */
	private String[] getDisplayNames() {

		int index = this.getItemCount();

		if (index <= 0)
			return null;

		String as[] = new String[index];
		for (int j = 0; j < index; j++)
			as[j] = (String) getComboBox().getItemAt(j);

		return as;
	}
	/**
	 * 
	 */
	public char getFocusAccelerator() {
		return fieldFocusAccelerator;
	}
	/**
	 *
	 */
	public Font getFont() {
		return font;
	}
	/**
	 *
	 */
	public Color getForeground() {
		if (this.enabled)
			return foregroundTrue;
		else
			return foregroundFalse;
	}
	/**
	 *
	 */
	public Object getItemAt(int index) {
		return this.getModel().getElementAt(index);
	}
	/**
	 *
	 */
	public int getItemCount() {
		return this.getModel().getSize();
	}
	/**
	 *
	 */
	public int getItemIndex(Object item) {
		for (int i = 0; i < this.getItemCount(); i++)
			if (this.getModel().getElementAt(i) == item)
				return i;
		return -1;
	}
	/**
	 *
	 */
	public Object[] getItems() {

		if (this.getModel().getSize() == 0)
			return null;

		Object aobj[] = new Object[this.getModel().getSize()];

		for (int i = 0; i < getItemCount(); i++)
			aobj[i] = this.getModel().getElementAt(i);

		return aobj;
	}
	/**
	 *
	 * @return
	 */
	public int getMaximumRowCount() {
		return maximumRowCount;
	}
	/**
	 *
	 * @return
	 */
	private DefaultComboBoxModel getModel() {
		if (this.tsDefaultComboBoxModel == null)
			this.tsDefaultComboBoxModel = new DefaultComboBoxModel();
		return this.tsDefaultComboBoxModel;
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

	public String getSelectedDisplayName() {

		if (this.getComboBox().getSelectedIndex() == -1)
			return null;

		return (String) getComboBox().getSelectedItem();
	}

	public int getSelectedIndex() {
		return this.getComboBox().getSelectedIndex();
	}

	public Object getSelectedItem() {

		int index = this.getComboBox().getSelectedIndex();

		return this.getModel().getElementAt(index);
	}

	public Object[] getSelectedObjects() {
		Object obj = getSelectedItem();
		if (obj == null) {
			return new Object[0];
		} else {
			Object aobj[] = new Object[1];
			aobj[0] = obj;
			return aobj;
		}
	}

	/**
	 * Return the selectedValue property value.
	 *
	 * @return Object
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private Object getselectedValue() {
		// user code begin {1}
		if (this.internalValuesForItems != null && this.internalValuesForItems.size() > 0 && getSelectedIndex() >= 0)
			ivjselectedValue = this.internalValuesForItems.elementAt(getSelectedIndex());
		else
			ivjselectedValue = null;
		// user code end
		return ivjselectedValue;
	}

	/**
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 *
	 * @return Object
	 */
	public Object getSelectedValueItem() {
		return getselectedValue();
	}

	public String getText() {
		return editor.getText();
	}

	/**
	 * Gets the valuesForItems property (String[]) value.
	 *
	 * @return The valuesForItems property value.
	 * @see #setValuesForItems
	 */
	public String[] getValuesForItems() {

		String vi[] = new String[this.internalValuesForItems.size()];
		for (int i = 0; i < this.internalValuesForItems.size(); i++) {
			vi[i] = this.internalValuesForItems.elementAt(i).toString();
		}
		this.fieldValuesForItems = vi;
		return fieldValuesForItems;
	}

	/**
	 * 
	 */
	public String getValuesForItems(int index) {
		return getValuesForItems()[index];
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	public void hidePopup() {
		this.getComboBox().hidePopup();
	}

	private void initComboBox() {

		backgroundFalse = this.getComboBox().getBackground();
		foregroundFalse = this.getComboBox().getForeground();

		this.getComboBox().setEditable(true);

		editor = (JTextField) this.getComboBox().getEditor().getEditorComponent();

		editor.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
		editor.setDisabledTextColor(java.awt.Color.darkGray);

		ivjComboBox.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));

		backgroundTrue = editor.getBackground();
		foregroundTrue = editor.getForeground();

		editor.addKeyListener(this);

		this.setLayout(new BorderLayout());

		this.add(this.getComboBox());

		this.setEditable(true);

		this.setBackground(backgroundTrue);
		this.setForeground(foregroundTrue);

		this.getComboBox().addItemListener(this);
		this.getComboBox().addActionListener(this);
		this.getComboBox().addFocusListener(this);

		this.addFocusListener(this);
		this.editor.addFocusListener(this);

		this.getComboBox().setFocusable(false);
		this.editor.setFocusable(true);
	}

	/**
	 * 
	 */
	private void initConnections() throws Exception {
		this.addFocusListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("ObjectComboBox");
			setLayout(new java.awt.GridBagLayout());
			setSize(169, 30);

			java.awt.GridBagConstraints constraintsComboBox = new java.awt.GridBagConstraints();
			constraintsComboBox.gridx = 0;
			constraintsComboBox.gridy = 0;
			constraintsComboBox.fill = java.awt.GridBagConstraints.BOTH;
			constraintsComboBox.weightx = 1.0;
			constraintsComboBox.ipady = 0;
			constraintsComboBox.weighty = 1.0;
			this.add(getComboBox(), constraintsComboBox);
			initConnections();
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		actionListeners = new Vector();
		itemListeners = new Vector();
		autoMatch = true;
		caseSensitive = false;
		autoIncreasing = false;
		editable = true;
		enabled = true;
		actionCommand = "actionCommand";
		ComboBoxListeners = new Vector();
		maximumRowCount = 8;
		oldSelectedIndex = -1;
		initComboBox();
		// setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray));
		// getComboBox().setLightWeightPopupEnabled(true);
		// user code end
		//System.out.println("ObjectComboBox: "+this.hashCode());
	}

	public void insertItemAt(Object item, int index) {
		this.insertItemAt(item, null, index);
	}

	public void insertItemAt(Object item, String toDisplay, int index) {

		// validaciones
		if (index > this.getModel().getSize() || index < 0)
			throw new IllegalArgumentException("insertItemAt: " + index + " out of bounds.");
		if (item == null)
			throw new NullPointerException("insertItemAt : the item is null.");
		if (toDisplay == null)
			toDisplay = item.toString();
		for (int j = 0; j < this.getItemCount(); j++)
			if (this.getModel().getElementAt(j) == item)
				throw new IllegalArgumentException("insertItemAt : the item is existed.");
		if (this.isDuplicateName(toDisplay))
			throw new IllegalArgumentException("insertItemAt(): the name is already existed or empty.");
		// ...

		Object aobj[] = getItems();
		String as[] = getDisplayNames();
		int k = getItemCount();

		this.getComboBox().insertItemAt(toDisplay.trim(), index);

		this.getModel().insertObjectAt(item, index);

		firePropertyChange("itemCount", k, getItemCount());
		fireComboBoxListEvent(0, index);
		Object aobj1[] = getItems();
		String as1[] = getDisplayNames();
		firePropertyChange("items", ((Object) (aobj)), ((Object) (aobj1)));
		firePropertyChange("displayNames", as, as1);
	}

	public boolean isAutoIncreasing() {
		return autoIncreasing;
	}

	public boolean isAutoMatch() {
		return autoMatch;
	}

	/**
	 * Gets the autoSelectFirst property (boolean) value.
	 *
	 * @return The autoSelectFirst property value.
	 * @see #setAutoSelectFirst
	 */
	public boolean isAutoSelectFirst() {
		return fieldAutoSelectFirst;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public boolean esNulo() {
		return this.getSelectedItem() == null;
	}

	public boolean isDataMissing() {

		if (this.getSelectedItem() == null) {
			InfoView.showErrorDialog(this, "¡ Seleccione un ítem !");
			this.requestFocus();
			return true;
		}
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		if (this.getSelectedItem() == null) {
			InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}

	private boolean isDuplicateName(String toDisplay) {

		String s1 = toDisplay.trim();

		if (s1.length() == 0)
			return true;

		if (isDuplicatePermitted())
			return false;

		for (int i = 0; i < this.getItemCount(); i++) {
			String s2 = (String) this.getComboBox().getItemAt(i);
			if (s1.equalsIgnoreCase(s2))
				return true;
		}

		return false;
	}

	/**
	 * Gets the duplicatePermitted property (boolean) value.
	 *
	 * @return The duplicatePermitted property value.
	 * @see #setDuplicatePermitted
	 */
	public boolean isDuplicatePermitted() {
		return fieldDuplicatePermitted;
	}

	public boolean isEditable() {
		return editable;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isValueHere(String aValue) {
		try {
			for (int i = 0; i < this.internalValuesForItems.size(); i++) {
				if (aValue.trim().toUpperCase().compareTo(this.internalValuesForItems.elementAt(i).toString().trim().toUpperCase()) == 0)
					return true;
			}
		} catch (Throwable t) {
			t.getMessage();
			return false;
		}
		return false;
	}

	public void itemStateChanged(ItemEvent itemevent) {

		if (itemevent.getStateChange() == ItemEvent.SELECTED) {
			int index = this.getComboBox().getSelectedIndex();
			Object obj = this.getModel().getElementAt(index);
			String s = getSelectedDisplayName();
			if (obj != null) {
				//setSelectedIndex(index);

				// se lanza el evento para avisar que el valueForItem ha
				// cambiado
				this.combing = true;
				try {

					if (!indexing) {

						Object selectedValue0 = this.internalValuesForItems.elementAt(index);
						this.setselectedValue(selectedValue0);
						/*
						 * this.ivjselectedValue =
						 * selectedValue0;//TODO,TAREA_PENDIENTE,OJO: AGREGADA
						 * EL 16-MARZO-2006????
						 */

					}

				} catch (Throwable t) {
					this.setselectedValue(null);
					t.getMessage();
				}
				this.combing = false;

				firePropertyChange("selectedIndex", oldSelectedIndex, index);
				firePropertyChange("selectedItem", oldSelectedItem, obj);
				firePropertyChange("selectedValueItem", "old", "new");
				firePropertyChange("selectedDisplayName", oldSelectedDisplayName, s);
				if (index != -1)
					fireComboBoxListEvent(2, index);

			}
			oldSelectedIndex = index;
			oldSelectedDisplayName = s;
			oldSelectedItem = obj;

		}

		if (itemevent.getStateChange() == ItemEvent.DESELECTED) {
			int j = this.getComboBox().getSelectedIndex();
			if (oldSelectedIndex != j && oldSelectedIndex != -1)
				fireComboBoxListEvent(3, oldSelectedIndex);
			if (j == -1 && oldSelectedIndex != j) {
				firePropertyChange("selectedIndex", oldSelectedIndex, -1);
				firePropertyChange("selectedItem", oldSelectedItem, null);
				firePropertyChange("selectedDisplayName", oldSelectedDisplayName, null);
				oldSelectedIndex = j;
				oldSelectedItem = null;
				oldSelectedDisplayName = null;
			}
		}

		Vector vector = new Vector();
		synchronized (vector) {
			vector = (Vector) itemListeners.clone();
		}

		for (int k = 0; k < vector.size(); k++) {
			ItemListener itemlistener = (ItemListener) vector.elementAt(k);
			itemlistener.itemStateChanged(new ItemEvent(this, itemevent.getID(), itemevent.getItem(), itemevent.getStateChange()));
		}
	}

	public void keyPressed(KeyEvent keyevent) {
	}

	public void keyReleased(KeyEvent keyEvent) {
		if (editable && !keyEvent.isActionKey()) {
			int i = keyEvent.getKeyCode();
			this.processKeyRelease(i);
		}
		fireKeyReleasedPromoted(keyEvent);
	}

	public void keyTyped(KeyEvent keyevent) {
	}

	private void processKeyRelease(int keyCode) {
		switch (keyCode) {
		//case KeyEvent.VK_BACK_SPACE:
			//break;
		case 16: // '\020'
			break;
		case 18: // '\022'
			break;
		//case KeyEvent.VK_DELETE:
			//break;
		case KeyEvent.VK_ENTER:
			if (editable && autoIncreasing) {
				try {
					String textoEscrito = editor.getText();
					addItem(textoEscrito);
					setSelectedIndex(getSelectedIndex());
					setSelectedItem(textoEscrito);
					String item = getSelectedDisplayName();
					firePropertyChange("selectedDisplayName", oldSelectedDisplayName, item);
					firePropertyChange("setSelectedItem", oldSelectedItem, getSelectedItem());
					firePropertyChange("setSelectedIndex", oldSelectedIndex, getSelectedIndex());
					fireComboBoxListEvent(2, getSelectedIndex());
					oldSelectedDisplayName = item;
					oldSelectedItem = textoEscrito;
					oldSelectedIndex = getSelectedIndex();
					return;
				} catch (IllegalArgumentException exc) {
					exc.getMessage();
					return;
				}
			}
			break;
		default:
			String textoEscrito = editor.getText();
			int tamanioTexto = textoEscrito.length();
			int caretPosition = editor.getCaretPosition();
			if (tamanioTexto <= 0 || caretPosition != tamanioTexto || !autoMatch) {
				break;
			}
			String item;
			boolean matched = false;
			for (int i = 0; i < getItemCount(); i++) {
				item = this.getComboBox().getItemAt(i).toString();
				if (caseSensitive && item.startsWith(textoEscrito)) {
					editor.setText(item);
					this.getComboBox().setSelectedIndex(i);
					editor.select(item.length(), caretPosition);
					editor.moveCaretPosition(caretPosition);
					getSelectedDisplayName();
					matched = true;
					break;
				}
				if (!caseSensitive && item.toUpperCase().startsWith(textoEscrito.toUpperCase())) {
					editor.setText(item);
					this.getComboBox().setSelectedIndex(i);
					editor.select(item.length(), caretPosition);
					editor.moveCaretPosition(caretPosition);
					getSelectedDisplayName();
					matched = true;
					break;
				}
			}
			if (!matched) {
				deselect();
				editor.setText(textoEscrito);
			}
			break;
		}
	}

	public void putItems(Vector items) {

		Vector theItems = new Vector();
		Vector theValuesForItems = new Vector();
		String anItem;
		for (int i = 0; i < items.size(); i++) {
			anItem = items.elementAt(i).toString();
			theValuesForItems.addElement(anItem.substring(0, anItem.indexOf("&&")));
			theItems.addElement(anItem.substring(anItem.indexOf("&&") + 2));
		}

		// colocación de items
		this.setItems(theItems);

		// colocación de valores de los items
		this.internalValuesForItems = theValuesForItems;
	}

	public void removeActionListener(ActionListener actionlistener) {
		if (actionlistener != null) {
			actionListeners.removeElement(actionlistener);
			return;
		} else {
			throw new NullPointerException("removeActionListener:  the listener is null.");
		}
	}

	public void removeAllItems() {
		try {
			//for (; this.getModel().getSize() > 0; removeItemAt(this.getModel().getSize() - 1));
			while(this.getModel().getSize() > 0) {
				this.removeItemAt(this.getModel().getSize() - 1);
			}
			this.internalValuesForItems = new Vector();
			//this.getComboBox().removeAllItems();
			//this.getModel().removeAllObjects();

		} catch (Exception exc1) {
			exc1.getMessage();
		}

		try {
			deselect();
		} catch (Exception exc2) {
			exc2.getMessage();
		}
	}

	public void removeComboBoxListListener(ComboBoxListListener comboboxlistlistener) {
		if (comboboxlistlistener != null) {
			ComboBoxListeners.removeElement(comboboxlistlistener);
			return;
		} else {
			throw new NullPointerException("addComboBoxListListener:  the listener is null.");
		}
	}

	public void removeItem(Object obj) {

		if (obj == null)
			throw new IllegalArgumentException("item is null!");

		int i = this.getModel().getIndexOf(obj);

		if (i == -1)
			throw new IllegalArgumentException("The object is not existed!");

		for (int j = 0; j < getItemCount(); j++)
			if (this.getModel().getElementAt(j) == obj) {
				removeItemAt(j);
				return;
			}
	}

	public void removeItemAt(int i) {

		if (i >= this.getModel().getSize() || i < 0)
			throw new IllegalArgumentException("removeItemAt: " + i + " out of bounds.");

		Object aobj[] = getItems();
		String as[] = getDisplayNames();
		int j = getItemCount();
		this.getComboBox().removeItemAt(i);
		this.getModel().removeObjectAt(i);
		firePropertyChange("itemCount", j, getItemCount());
		fireComboBoxListEvent(1, i);
		Object aobj1[] = getItems();
		String as1[] = getDisplayNames();
		firePropertyChange("items", ((Object) (aobj)), ((Object) (aobj1)));
		firePropertyChange("displayNames", as, as1);
	}

	public void removeItemListener(ItemListener itemlistener) {
		if (itemlistener != null) {
			itemListeners.removeElement(itemlistener);
			return;
		} else {
			throw new NullPointerException("removeItemListener:  the listener is null.");
		}
	}

	public void removeObjectComboBoxListener(ObjectComboBoxListener newListener) {
		fieldObjectComboBoxListenerEventMulticaster = ObjectComboBoxListenerEventMulticaster.remove(fieldObjectComboBoxListenerEventMulticaster, newListener);
		return;
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

	public void replaceItemAt(Object obj, int i) {
		replaceItemAt(obj, null, i);
	}

	public void replaceItemAt(Object obj, String s, int i) {

		if (i > this.getModel().getSize() || i < 0)
			throw new IllegalArgumentException("replaceItemAt(): " + i + " out of bounds.");

		if (obj == null)
			throw new NullPointerException("replaceItemAt :the item is null.");

		if (s == null)
			s = obj.toString();

		if (isDuplicateName(s) && s.trim().equals(this.getComboBox().getItemAt(i))) {
			removeItemAt(i);
			insertItemAt(obj, s, i);
			fireComboBoxListEvent(4, i);
			return;
		}

		if (!isDuplicateName(s)) {
			removeItemAt(i);
			insertItemAt(obj, s, i);
			fireComboBoxListEvent(4, i);
			return;
		} else {
			throw new IllegalArgumentException("replaceItemAt : " + s + " is already existed or empty.");
		}
	}

	public void setAboutThisBean(String s) {
		aboutThisBean = s;
	}

	public void setActionCommand(String s) {
		actionCommand = s;
		this.getComboBox().setActionCommand(s);
	}

	public void setAutoIncreasing(boolean flag) {
		boolean flag1 = autoIncreasing;
		autoIncreasing = flag;
		firePropertyChange("autoIncreasing", flag1, flag);
	}

	public void setAutoMatch(boolean flag) {
		boolean flag1 = autoMatch;
		autoMatch = flag;
		firePropertyChange("autoMatch", flag1, flag);
	}

	/**
	 * Sets the autoSelectFirst property (boolean) value.
	 *
	 * @param autoSelectFirst
	 *            The new value for the property.
	 * @see #getAutoSelectFirst
	 */
	public void setAutoSelectFirst(boolean autoSelectFirst) {
		fieldAutoSelectFirst = autoSelectFirst;
	}

	public void setBackground(Color color) {
		 super.setBackground(color);

		 Color color1 = null;

		 if (this.getComboBox() != null && !enabled) {
			 color1 = backgroundFalse;
			 backgroundFalse = color;
			 this.getComboBox().setBackground(color);
		 }

		 if (editor != null && enabled) {
			 color1 = backgroundTrue;
			 backgroundTrue = color;
			 editor.setBackground(color);
		 }

		 firePropertyChange("background", color1, color);

	}

	public void setCaseSensitive(boolean flag) {
		boolean flag1 = caseSensitive;
		caseSensitive = flag;
		firePropertyChange("caseSensitive", flag1, flag);
	}

	public void setDisplayName(Object obj, String s) {

		if (obj == null || s == null)
			throw new NullPointerException("item or name is null.");
		if (this.getModel().getIndexOf(obj) == -1)
			throw new IllegalArgumentException("item is not existed.");
		if (isDuplicateName(s))
			if (!s.trim().equals(getDisplayName(obj)))
				throw new IllegalArgumentException("setDisplayName:  the name is already existed or empty.");
			else
				return;

		for (int i = 0; i < this.getComboBox().getItemCount(); i++)
			if (obj == this.getModel().getElementAt(i)) {
				this.getComboBox().removeItemAt(i);
				this.getComboBox().insertItemAt(s, i);
				return;
			}
	}

	public void setDisplayNameAt(String s, int i) {

		if (i >= this.getComboBox().getItemCount() || i < 0)
			throw new IllegalArgumentException("setDisplayNameAt: " + i + " out of bounds.");
		if (s == null)
			throw new NullPointerException("setDisplayNameAt:the name is null.");
		if (isDuplicateName(s)) {
			if (!s.trim().equals(this.getComboBox().getItemAt(i)))
				throw new IllegalArgumentException("setDisplayName: " + s + " is already existed or empty.");
			else
				return;
		} else {
			this.getComboBox().removeItemAt(i);
			this.getComboBox().insertItemAt(s, i);
			return;
		}
	}

	/**
	 * Sets the duplicatePermitted property (boolean) value.
	 *
	 * @param duplicatePermitted
	 *            The new value for the property.
	 * @see #getDuplicatePermitted
	 */
	public void setDuplicatePermitted(boolean duplicatePermitted) {
		fieldDuplicatePermitted = duplicatePermitted;
	}

	public void setEditable(boolean flag) {

		//boolean flag1 = editable;
		this.editable = flag;

		this.getComboBox().setEditable(flag);
		//this.setEnabled(flag);
/*
		if (!flag) {
			setBackground(backgroundFalse);
			setForeground(foregroundFalse);
		} else {
			setBackground(backgroundTrue);
			setForeground(foregroundTrue);
		}
*/
		//firePropertyChange("editable", flag1, flag);
	}

	public void setEnabled(boolean flag) {

		boolean flag1 = enabled;
		enabled = flag;
		this.getComboBox().setEnabled(flag);

		firePropertyChange("enabled", flag1, flag);

		if (flag) {
			this.getComboBox().setBackground(Color.white);
			editor.setBackground(Color.white);
		} else {
			this.getComboBox().setBackground(new java.awt.Color(231, 231, 231));
			editor.setBackground(new java.awt.Color(231, 231, 231));
		}
	}

	/**
	 * Sets the focusAccelerator property (char) value.
	 *
	 * @param focusAccelerator
	 *            The new value for the property.
	 * @see #getFocusAccelerator
	 */
	public void setFocusAccelerator(char focusAccelerator) {
		char oldValue = fieldFocusAccelerator;
		fieldFocusAccelerator = focusAccelerator;
		firePropertyChange("focusAccelerator", new Character(oldValue), new Character(focusAccelerator));
		// ...
		editor.setFocusAccelerator(focusAccelerator);
	}

	public void setFont(Font font1) {

		Font font2 = font;
		font = font1;

		if (this.getComboBox() != null && !enabled)
			this.getComboBox().setFont(font1);

		if (editor != null && enabled) {
			editor.setFont(font1);
			ivjComboBox.setFont(font1);
		}

		firePropertyChange("font", font2, font1);
	}

	public void setForeground(Color color) {

		Color color1 = null;

		if (this.getComboBox() != null && !enabled) {
			color1 = foregroundFalse;
			foregroundFalse = color;
			this.getComboBox().setForeground(color);
		}

		if (editor != null && enabled) {
			color1 = foregroundTrue;
			foregroundTrue = color;
			editor.setForeground(color);
		}

		firePropertyChange("foreground", color1, color);
	}

	public void setItems(Object aobj[]) {

		if (aobj == null)
			throw new NullPointerException("setItems : the items is null.");

		for (int i = 0; i < aobj.length; i++)
			if (aobj[i] == null)
				throw new NullPointerException("setItems : items[" + i + "] is null.)");

		for (int j = 0; j < aobj.length - 1; j++) {
			for (int k = j + 1; k < aobj.length; k++)
				if (aobj[j].toString().equals(aobj[k].toString()))
					throw new IllegalArgumentException("setItems : the names of two items are identical.");
		}

		if (this.getComboBox().getItemCount() > 0)
			for (; this.getModel().getSize() > 0; removeItemAt(this.getModel().getSize() - 1))
				;

		for (int l = 0; l < aobj.length; l++)
			addItem(aobj[l], aobj[l].toString());
/*
		Object sv = ivjselectedValue;
		setSelectedValueItem("");
		setSelectedValueItem(sv);
*/
	}

	public void setItems(Vector vector) {

		// validaciones
		if (vector == null)
			throw new NullPointerException("ObjectComboBox : items is null.");

		for (int i = 0; i < vector.size(); i++)
			if (vector.elementAt(i) == null)
				throw new NullPointerException("ObjectComboBox : items[" + i + "] is null.");

		for (int j = 0; j < vector.size() - 1; j++) {
			for (int k = j + 1; k < vector.size(); k++)
				if (vector.elementAt(j).toString().equals(vector.elementAt(k).toString()))
					throw new IllegalArgumentException("ObjectComboBox : the names of two items are identical.");
		}

		for (int l = 0; l < vector.size(); l++) {
			addItem(vector.elementAt(l), vector.elementAt(l).toString());
		}
/*
		Object sv = ivjselectedValue;
		setSelectedValueItem("");
		setSelectedValueItem(sv);
*/
	}

	public void setMaximumRowCount(int i) {
		int j = maximumRowCount;
		maximumRowCount = i;
		this.getComboBox().setMaximumRowCount(i);
		firePropertyChange("maximumRowCount", j, maximumRowCount);
	}

	private void setModel(DefaultComboBoxModel newModel) {
		this.tsDefaultComboBoxModel = newModel;
	}

	public void setSelectedIndex(int i) {
		try {
			if (oldSelectedIndex != i) {
				if (i < 0)
					this.getComboBox().setSelectedItem(null);
				else
					this.getComboBox().setSelectedIndex(i);
				firePropertyChange("selectedIndex", oldSelectedIndex, i);
				oldSelectedIndex = i;
				return;
			}
		} catch (IllegalArgumentException _ex) {
			throw new IllegalArgumentException("setSelectedIndex : " + i + " out of bounds");
		}
	}

	public void setSelectedItem(Object obj) {
		if (oldSelectedItem != obj) {
			int i = -1;
			for (int j = 0; j < getItemCount(); j++) {
				if (obj != null && this.getModel().getElementAt(j).toString().trim().compareTo(obj.toString().trim()) != 0) {
					continue;
				}
				i = j;
				break;
			}
			if (i == -1) {
				this.getComboBox().setSelectedItem(null);
				oldSelectedIndex = i;
			} else if (oldSelectedIndex != i) {
				// this.getComboBox().setSelectedItem(this.getComboBox().getItemAt(i));
				this.setSelectedIndex(i);
				oldSelectedIndex = i;
			}
			firePropertyChange("selectedItem", oldSelectedItem, obj);
			oldSelectedItem = obj;
		}

		getComboBox().hidePopup();
	}

	/**
	 * Set the selectedValue to a new value.
	 *
	 * @param newValue
	 *            Object
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setselectedValue(Object newValue) {
		if (ivjselectedValue != newValue) {
			try {
				ivjselectedValue = newValue;
				// user code begin {1}

				if (!combing) {

					this.indexing = true;

					if (newValue == null)
						this.setSelectedIndex(-1);
					else
						for (int i = 0; i < this.internalValuesForItems.size(); i++) {
							if (this.internalValuesForItems.elementAt(i).toString().trim().compareTo(newValue.toString().trim()) == 0)
								this.setSelectedItem(this.getItems()[i]);
						}

					this.indexing = false;
					// this.editor.setScrollOffset(0);
					repaint();
				}

				// user code end
			} catch (Throwable ivjExc) {
				// user code begin {2}
				this.indexing = false;
				// user code end
				handleException(ivjExc);
			}
		}
		;
		// user code begin {3}
		// user code end
	}

	/**
	 * Method generated to support the promotion of the selectedValueItem
	 * attribute.
	 *
	 * @param arg1
	 *            Object
	 */
	public void setSelectedValueItem(Object arg1) {
		setselectedValue(arg1);
	}

	public void setText(String s) {
		this.editor.setText(s);
		// this.editor.setScrollOffset(0);
	}

	/**
	 * Sets the valuesForItems property (String[]) value.
	 *
	 * @param valuesForItems
	 *            The new value for the property.
	 * @see #getValuesForItems
	 */
	public void setValuesForItems(String[] valuesForItems) {

		Vector avi = new Vector();
		for (int i = 0; i < valuesForItems.length; i++) {
			avi.addElement(valuesForItems[i]);
		}
		this.internalValuesForItems = avi;

		String[] oldValue = fieldValuesForItems;
		fieldValuesForItems = valuesForItems;
		firePropertyChange("valuesForItems", oldValue, valuesForItems);
	}

	/**
	 * Sets the valuesForItems property (String[]) value.
	 *
	 * @param valuesForItems
	 *            The new value for the property.
	 * @see #getValuesForItems
	 */
	public void setValuesForItems(Vector valuesForItems) {

		Vector avi = valuesForItems;

		this.internalValuesForItems = avi;

		String[] oldValue = fieldValuesForItems;
		String[] vfi = new String[valuesForItems.size()];
		for (int i = 0; i < valuesForItems.size(); i++) {
			vfi[i] = valuesForItems.elementAt(i).toString();
		}
		fieldValuesForItems = vfi;
		firePropertyChange("valuesForItems", oldValue, valuesForItems);
	}

	/**
	 * Sets the valuesForItems index property (String[]) value.
	 *
	 * @param index
	 *            The index value into the property array.
	 * @param valuesForItems
	 *            The new value for the property.
	 * @see #getValuesForItems
	 */
	public void setValuesForItems(int index, String valuesForItems) {
		String oldValue = fieldValuesForItems[index];
		fieldValuesForItems[index] = valuesForItems;
		if (oldValue != null && !oldValue.equals(valuesForItems)) {
			firePropertyChange("valuesForItems", null, fieldValuesForItems);
		}
	}

	public void setValueToNull() {
		this.setselectedValue(null);
	}

	public void showPopup() {
		this.getComboBox().showPopup();
	}

	/**
	 * @return the datosAdicionales01
	 */
	public Vector getDatosAdicionales01() {
		return datosAdicionales01;
	}

	/**
	 * @param datosAdicionales01 the datosAdicionales01 to set
	 */
	public void setDatosAdicionales01(Vector datosAdicionales01) {
		this.datosAdicionales01 = datosAdicionales01;
	}

	/**
	 * @return the enableActions
	 */
	public boolean isEnableActions() {
		return enableActions;
	}

	/**
	 * @param enableActions the enableActions to set
	 */
	public void setEnableActions(boolean enableActions) {
		this.enableActions = enableActions;
	}
	/**
	 *
	 */
	public void setBorder(Border unBorde) {
		try {
			getComboBox().setBorder(unBorde);
		} catch (Exception e1) {
			e1.getMessage();
		}
		try {
			if (this.editor != null) {
				this.editor.setBorder(unBorde);
			}
		} catch (Exception e2) {
			e2.getMessage();
		}
	}
	/**
	 *
	 */
    public void addPopupMenuListener(PopupMenuListener l) {
        getComboBox().addPopupMenuListener(l);
    }

    /**
     *
     */
    public String toString() {
    	return hashCode() + " ::: items: " + getItems() + "  valueItems: "+getValuesForItems();
    }
}
