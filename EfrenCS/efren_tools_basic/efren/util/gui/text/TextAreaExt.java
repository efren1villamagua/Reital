package efren.util.gui.text;

import efren.util.gui.LoweredPanel;

/**
 * This type was created in VisualAge.
 */
public class TextAreaExt extends LoweredPanel implements java.awt.event.FocusListener, java.awt.event.KeyListener, java.awt.event.MouseListener, java.beans.PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4354197133325282741L;

	private javax.swing.JScrollPane ivjJScrollPane1 = null;

	private javax.swing.JTextArea ivjJTextArea1 = null;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private boolean fieldWordWrap = true;

	private int fieldMaxLength = 0;

	protected transient TextAreaExtListener fieldTextAreaExtListenerEventMulticaster = null;

	private boolean seleccionarAlRecibirElFoco = false;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public TextAreaExt() {
		super();
		initialize();
	}

	/**
	 * TextAreaExt constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public TextAreaExt(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * TextAreaExt constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public TextAreaExt(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * TextAreaExt constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public TextAreaExt(boolean isDoubleBuffered) {
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
	 * 
	 * @param newListener
	 *            TextAreaExtListener
	 */
	public void addTextAreaExtListener(TextAreaExtListener newListener) {
		fieldTextAreaExtListenerEventMulticaster = TextAreaExtListenerEventMulticaster.add(fieldTextAreaExtListenerEventMulticaster, newListener);
		return;
	}

	public void append(String str) {
		getJTextArea1().append(str);
	}

	/**
	 * connEtoC1: (JTextArea1.lineWrap -->
	 * TextAreaExt.firePropertyChange(Ljava.lang
	 * .String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("lineWrap", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (JTextArea1.focus.focusLost(java.awt.event.FocusEvent) -->
	 * TextAreaExt.fireTextAreaFocusLost(Ljava.util.EventObject;)V)
	 * 
	 * @param arg1
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.awt.event.FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireTextAreaFocusLost(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JTextArea1.key.keyReleased(java.awt.event.KeyEvent) -->
	 * TextAreaExt.fireTextAreaKeyReleased(Ljava.util.EventObject;)V)
	 * 
	 * @param arg1
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.awt.event.KeyEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireTextAreaKeyReleased(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (JTextArea1.focus.focusGained(java.awt.event.FocusEvent) -->
	 * TextAreaExt.manageTextSelectionOnFocusGained()V)
	 * 
	 * @param arg1
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.awt.event.FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageTextSelectionOnFocusGained();
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
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireTextAreaFocusLost(java.util.EventObject newEvent) {
		if (fieldTextAreaExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextAreaExtListenerEventMulticaster.textAreaFocusLost(newEvent);
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireTextAreaKeyReleased(java.util.EventObject newEvent) {
		if (fieldTextAreaExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextAreaExtListenerEventMulticaster.textAreaKeyReleased(newEvent);
	}

	/**
	 * Method to handle events for the FocusListener interface.
	 * 
	 * @param e
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusGained(java.awt.event.FocusEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJTextArea1())
			connEtoC4(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the FocusListener interface.
	 * 
	 * @param e
	 *            java.awt.event.FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusLost(java.awt.event.FocusEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJTextArea1())
			connEtoC2(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Return the JScrollPane1 property value.
	 * 
	 * @return javax.swing.JScrollPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JScrollPane getJScrollPane1() {
		if (ivjJScrollPane1 == null) {
			try {
				ivjJScrollPane1 = new javax.swing.JScrollPane();
				ivjJScrollPane1.setName("JScrollPane1");
				ivjJScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				ivjJScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getJScrollPane1().setViewportView(getJTextArea1());
				// user code begin {1}
				ivjJScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray, 1));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJScrollPane1;
	}

	/**
	 * Return the JTextArea1 property value.
	 * 
	 * @return javax.swing.JTextArea
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextArea getJTextArea1() {
		if (ivjJTextArea1 == null) {
			try {
				ivjJTextArea1 = new javax.swing.JTextArea();
				ivjJTextArea1.setName("JTextArea1");
				ivjJTextArea1.setLineWrap(true);
				ivjJTextArea1.setDisabledTextColor(java.awt.Color.darkGray);
				ivjJTextArea1.setWrapStyleWord(true);
				ivjJTextArea1.setBackground(java.awt.Color.white);
				ivjJTextArea1.setBounds(0, 0, 15, 19);
				// user code begin {1}
				ivjJTextArea1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextArea1;
	}

	/**
	 * Method generated to support the promotion of the lineWrap attribute.
	 * 
	 * @return boolean
	 */
	public boolean getLineWrap() {
		return getJTextArea1().getLineWrap();
	}

	/**
	 * Gets the maxLength property (int) value.
	 * 
	 * @return The maxLength property value.
	 * @see #setMaxLength
	 */
	public int getMaxLength() {
		return fieldMaxLength;
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
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @return java.lang.String
	 */
	private String getText() {
		return getJTextArea1().getText();
	}

	public String getValue() {
		return this.getText();
	}

	/**
	 * Gets the wordWrap property (boolean) value.
	 * 
	 * @return The wordWrap property value.
	 * @see #setWordWrap
	 */
	public boolean getWordWrap() {
		return fieldWordWrap;
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
		getJTextArea1().addMouseListener(this);
		// user code end
		getJTextArea1().addPropertyChangeListener(this);
		getJTextArea1().addFocusListener(this);
		getJTextArea1().addKeyListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("TextAreaExt");
			setLayout(new java.awt.GridBagLayout());
			setSize(119, 78);

			java.awt.GridBagConstraints constraintsJScrollPane1 = new java.awt.GridBagConstraints();
			constraintsJScrollPane1.gridx = 0;
			constraintsJScrollPane1.gridy = 0;
			constraintsJScrollPane1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJScrollPane1.weightx = 1.0;
			constraintsJScrollPane1.weighty = 1.0;
			add(getJScrollPane1(), constraintsJScrollPane1);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		//getJTextArea1().setBorder(javax.swing.BorderFactory.createEmptyBorder(
		// ));
		// getJTextArea1().setBorder(null);
		// getJScrollPane1().setBorder(null);
		this.setBorder(null);
		// user code end
	}

	public void insertAtCursorPosition(String s) {
		getJTextArea1().insert(s, getJTextArea1().getSelectionStart());
	}

	public boolean isDataMissing() {
		if ((getText() == null) || (getText().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Ingrese datos en el campo de texto !");
			this.requestFocus();
			return true;
		}
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		if ((getText() == null) || (getText().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}

	/**
	 * Method generated to support the promotion of the editable attribute.
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return getJTextArea1().isEditable();
	}

	public boolean isEnabled() {

		return getJTextArea1().isEnabled();
	}

	/**
	 * Insert the method's description here. Creation date: (2005-05-29 20:35:25
	 * PM)
	 * 
	 * @return boolean
	 */
	public boolean isSeleccionarAlRecibirElFoco() {
		return seleccionarAlRecibirElFoco;
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 * 
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyPressed(java.awt.event.KeyEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 * 
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(java.awt.event.KeyEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJTextArea1())
			connEtoC3(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 * 
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyTyped(java.awt.event.KeyEvent e) {
		// user code begin {1}
		switch (e.getKeyCode()) {
		case java.awt.event.KeyEvent.VK_ENTER:
			break;
		case java.awt.event.KeyEvent.VK_BACK_SPACE:
			break;
		case java.awt.event.KeyEvent.VK_TAB:
			break;
		case java.awt.event.KeyEvent.VK_SHIFT:
			break;
		case java.awt.event.KeyEvent.VK_CONTROL:
			break;
		case java.awt.event.KeyEvent.VK_ALT:
			break;
		case java.awt.event.KeyEvent.VK_CAPS_LOCK:
			break;
		case java.awt.event.KeyEvent.VK_END:
			break;
		case java.awt.event.KeyEvent.VK_HOME:
			break;
		case java.awt.event.KeyEvent.VK_LEFT:
			break;
		case java.awt.event.KeyEvent.VK_UP:
			break;
		case java.awt.event.KeyEvent.VK_RIGHT:
			break;
		case java.awt.event.KeyEvent.VK_DOWN:
			break;
		case java.awt.event.KeyEvent.VK_DELETE:
			break;
		case java.awt.event.KeyEvent.VK_NUM_LOCK:
			break;
		default:
			if (getJTextArea1().getText().length() >= getMaxLength()) {
				e.setKeyChar('\0');
				e.setKeyCode(0);
			}
			break;
		}
		// user code end
		// user code begin {2}
		// user code end
	}

	private void manageTextSelectionOnFocusGained() {
		if (isSeleccionarAlRecibirElFoco())
			this.seleccionar();
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		if (isEnabled())
			getJTextArea1().setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		getJTextArea1().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
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
		if (evt.getSource() == getJTextArea1() && (evt.getPropertyName().equals("lineWrap")))
			connEtoC1(evt);
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

	/**
	 * 
	 * @param newListener
	 *            TextAreaExtListener
	 */
	public void removeTextAreaExtListener(TextAreaExtListener newListener) {
		fieldTextAreaExtListenerEventMulticaster = TextAreaExtListenerEventMulticaster.remove(fieldTextAreaExtListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * Comment
	 */
	public void seleccionar() {
		getJTextArea1().setSelectionStart(0);
		getJTextArea1().setSelectionEnd(getText().length());
	}

	public void setBackground(java.awt.Color bg) {
		// no hacemos nada
		// getJTextArea1().setBackground(bg);
		// super.setBackground(bg);
	}

	/**
	 * Method generated to support the promotion of the editable attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setEditable(boolean arg1) {
		getJTextArea1().setEditable(arg1);
	}

	public void setEnabled(boolean aBool) {
		getJTextArea1().setEnabled(aBool);
		if (aBool)
			getJTextArea1().setBackground(java.awt.Color.white);
		else
			getJTextArea1().setBackground(new java.awt.Color(231, 231, 231));
	}

	public void setFont(java.awt.Font font) {
		getJTextArea1().setFont(font);
		super.setFont(font);
	}

	public void setForeground(java.awt.Color fg) {
		getJTextArea1().setForeground(fg);
		super.setForeground(fg);
	}

	/**
	 * Method generated to support the promotion of the lineWrap attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setLineWrap(boolean arg1) {
		getJTextArea1().setLineWrap(arg1);
	}

	/**
	 * Sets the maxLength property (int) value.
	 * 
	 * @param maxLength
	 *            The new value for the property.
	 * @see #getMaxLength
	 */
	public void setMaxLength(int maxLength) {
		int oldValue = fieldMaxLength;
		fieldMaxLength = maxLength;
		firePropertyChange("maxLength", new Integer(oldValue), new Integer(maxLength));
	}

	/**
	 * Insert the method's description here. Creation date: (2005-05-29 20:35:25
	 * PM)
	 * 
	 * @param newSeleccionarAlRecibirElFoco
	 *            boolean
	 */
	public void setSeleccionarAlRecibirElFoco(boolean newSeleccionarAlRecibirElFoco) {
		seleccionarAlRecibirElFoco = newSeleccionarAlRecibirElFoco;
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	private void setText(String arg1) {

		if (arg1 == null || arg1.trim().compareTo("null") == 0)
			getJTextArea1().setText("");
		else
			getJTextArea1().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setValue(String arg1) {
		this.setText(arg1);
	}

	/**
	 * Sets the wordWrap property (boolean) value.
	 * 
	 * @param wordWrap
	 *            The new value for the property.
	 * @see #getWordWrap
	 */
	public void setWordWrap(boolean wordWrap) {
		boolean oldValue = fieldWordWrap;
		fieldWordWrap = wordWrap;
		firePropertyChange("wordWrap", new Boolean(oldValue), new Boolean(wordWrap));
		// ...
		getJTextArea1().setWrapStyleWord(wordWrap);
	}

	public String SQLFullText() {

		return " '" + getText().trim().replace('*', '%').toUpperCase() + "%' ";
	}

	public String SQLText() {
		if (getText() == null || getText().trim().length() == 0)
			return " NULL ";
		else {
			return " '" + efren.util.StringTools.parseComilla(getText().trim()) + "' ";
		}
	}

	/**
	 *
	 */
	public void requestFocus() {
		getJTextArea1().requestFocus();
	}

}
