package efren.util.gui.text;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class PasswordFieldExt extends JPanel implements ActionListener, FocusListener, KeyListener, MouseListener, PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4404919038661210010L;
	//...
	private TextFieldExt.KeyMask fieldKeyMask = TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas;  //  @jve:decl-index=0:
	private TextFieldExt.AllowedKey fieldAllowedKey = TextFieldExt.AllowedKey.AK_ALFANUMERICOS;
	private JPasswordField ivjJPasswordField = null;
	private Boolean fieldError = new Boolean(false);
	private String fieldErrorDescription = new String();
	protected transient efren.util.gui.text.PasswordFieldExtListener fieldPasswordFieldExtListenerEventMulticaster = null;
	private int fieldMaxLength = 0;
	private boolean fieldAceptarKeyLikeTabKey = true;
	private boolean fieldDataValidateOnFocusLost = false;
	private boolean fieldNullsSupported = false;
	protected transient PropertyChangeSupport propertyChange;
	private boolean seleccionarAlRecibirElFoco = false;
	private int decimales = 2;//solo para numeros con decimales. por default=2
	private char echoChar;
	/**
	 * Constructor
	 */
	public PasswordFieldExt() {
		super();
		initialize();
	}
	/**
	 * PasswordFieldExt constructor comment.
	 * @param layout java.awt.LayoutManager
	 */
	public PasswordFieldExt(LayoutManager layout) {
		super(layout);
	}
	/**
	 * PasswordFieldExt constructor comment.
	 * @param layout LayoutManager
	 * @param isDoubleBuffered boolean
	 */
	public PasswordFieldExt(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	/**
	 * PasswordFieldExt constructor comment.
	 * @param isDoubleBuffered boolean
	 */
	public PasswordFieldExt(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}
	/**
	 * Method to handle events for the ActionListener interface.
	 * @param e ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(ActionEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJPasswordField())
			connEtoC1(e);
		// user code begin {2}
		// user code end
	}
		/**
		 * Adds the specified action listener to receive
		 * action events from this textfield.
		 *
		 * @param l the action listener
		 */
		public synchronized void addActionListener(ActionListener l) {
			listenerList.add(ActionListener.class, l);
		}
	public synchronized void addMouseListener(MouseListener l) {
		listenerList.add(MouseListener.class, l);
	}
	/**
	 * The addPropertyChangeListener method was generated to support the propertyChange field.
	 * @param listener PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}
	/**
	 *
	 * @param newListener PasswordFieldExtListener
	 */
	public void addPasswordFieldExtListener(PasswordFieldExtListener newListener) {
		fieldPasswordFieldExtListenerEventMulticaster = PasswordFieldExtListenerEventMulticaster.add(fieldPasswordFieldExtListenerEventMulticaster, newListener);
		return;
	}
	/**
	 * connEtoC1:  (JTextField.action.actionPerformed(ActionEvent) --> PasswordFieldExt.fireActionPerformed(Ljava.util.EventObject;)V)
	 * @param arg1 ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC10:  (JTextField.focus.focusGained(FocusEvent) --> PasswordFieldExt.fireFocusGained(Ljava.util.EventObject;)V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC10(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireFocusGained(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC11:  (JTextField.mouse.mouseClicked(MouseEvent) --> PasswordFieldExt.fireTextDateMouseClicked(Ljava.util.EventObject;)V)
	 * @param arg1 MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC11(MouseEvent arg1) {
		try {
			// user code begin {1}
			this.fireTextDateMouseClicked(arg1);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC2:  (JTextField.key.keyReleased(KeyEvent) --> PasswordFieldExt.fireField_keyReleased(Ljava.util.EventObject;)V)
	 * @param arg1 KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(KeyEvent arg1) {
	    try {
	        // user code begin {1}
	        /*
	        // user code end
	        this.fireField_keyReleased(new java.util.EventObject(this));
	        // user code begin {2}
	        */
	        KeyEvent ke =
	            new KeyEvent(
	                this,
	                arg1.getID(),
	                arg1.getWhen(),
	                arg1.getModifiers(),
	                arg1.getKeyCode(),
	                arg1.getKeyChar());
	        this.fireField_keyReleased(ke);
	        // user code end
	    } catch (java.lang.Throwable ivjExc) {
	        // user code begin {3}
	        // user code end
	        handleException(ivjExc);
	    }
	}
	/**
	 * connEtoC3:  (JTextField.horizontalAlignment --> PasswordFieldExt.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * @param arg1 PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(PropertyChangeEvent arg1) {
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
	/**
	 * connEtoC4:  (JTextField.focusAccelerator --> PasswordFieldExt.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * @param arg1 PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("focusAccelerator", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC5:  (JTextField.focus.focusGained(FocusEvent) --> PasswordFieldExt.manageTextSelectionOnFocusGained()V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(FocusEvent arg1) {
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
	 * connEtoC6:  (JTextField.focus.focusLost(FocusEvent) --> PasswordFieldExt.parseValue()V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.parseValue();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC7:  (JTextField.focus.focusLost(FocusEvent) --> PasswordFieldExt.fireFocusLost(Ljava.util.EventObject;)V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC7(FocusEvent arg1) {
		try {
			// user code begin {1}
			/*
			// user code end
			this.fireFocusLost(new java.util.EventObject(this));
			// user code begin {2}
			*/
			FocusEvent fe =
	            new FocusEvent(
	                this,
	                arg1.getID(),
	                arg1.isTemporary());
	        this.fireFocusLost(fe);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC8:  (JTextField.key.keyReleased(KeyEvent) --> PasswordFieldExt.parseValue()V)
	 * @param arg1 KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC8(KeyEvent arg1) {
		try {
			// user code begin {1}
			/*
			// user code end
			this.parseValue();
			// user code begin {2}
			*/
			if (arg1.getKeyCode() == KeyEvent.VK_ENTER)
				this.parseValue();
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC9:  (JTextField.focus.focusGained(FocusEvent) --> PasswordFieldExt.refreshValue()V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC9(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.refreshValue();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoM1:  (PasswordFieldExt.focus.focusGained(FocusEvent) --> JTextField.transferFocus()V)
	 * @param arg1 FocusEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPasswordField().requestFocus();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	private boolean dotCountValidate() {
		if (getText() == null)
			return true;
		if (getText().trim().compareTo("") == 0) {
			setValue("0");
			return true;
		}
		if (getText().indexOf(".") == -1)
			return true;
		return false;
	}
	public boolean esNulo() {
	    return getText().trim().length() == 0;
	}
	/**
	 * Method to support listener events.
	 * @param newEvent java.util.EventObject
	 */
	protected void fireActionPerformed(java.util.EventObject newEvent) {
		if (fieldPasswordFieldExtListenerEventMulticaster == null) {
			return;
		};
		fieldPasswordFieldExtListenerEventMulticaster.actionPerformed(newEvent);
	}
	/**
	 * Method to support listener events.
	 * @param newEvent java.util.EventObject
	 */
	protected void fireField_keyReleased(KeyEvent newEvent) {
		if (fieldPasswordFieldExtListenerEventMulticaster == null) {
			return;
		};
		fieldPasswordFieldExtListenerEventMulticaster.field_keyReleased(newEvent);
	}
	/**
	 * Method to support listener events.
	 * @param newEvent java.util.EventObject
	 */
	protected void fireFocusGained(java.util.EventObject newEvent) {
		if (fieldPasswordFieldExtListenerEventMulticaster == null) {
			return;
		};
		fieldPasswordFieldExtListenerEventMulticaster.focusGained(newEvent);
	}
	/**
	 * Method to support listener events.
	 * @param newEvent java.util.EventObject
	 */
	protected void fireFocusLost(java.util.EventObject newEvent) {
		if (fieldPasswordFieldExtListenerEventMulticaster == null) {
			return;
		};
		fieldPasswordFieldExtListenerEventMulticaster.focusLost(newEvent);
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
	 * Method to support listener events.
	 * @param newEvent java.util.EventObject
	 */
	protected void fireTextDateMouseClicked(java.util.EventObject newEvent) {
		if (fieldPasswordFieldExtListenerEventMulticaster == null) {
			return;
		};
		fieldPasswordFieldExtListenerEventMulticaster.textDateMouseClicked(newEvent);
	}
	public void focusGained(FocusEvent e) {
	    // user code begin {1}
	    if (getJPasswordField().isEditable() && getJPasswordField().isEnabled())
	        getJPasswordField().selectAll();
	    // user code end
	    if (e.getSource() == this)
	        connEtoM1(e);
	    if (e.getSource() == getJPasswordField())
	        connEtoC5(e);
	    if (e.getSource() == getJPasswordField())
	        connEtoC9(e);
	    if (e.getSource() == getJPasswordField())
	        connEtoC10(e);
	    // user code begin {2}
	    if (getJPasswordField().isEditable() && getJPasswordField().isEnabled())
	        getJPasswordField().selectAll();
	    // user code end
	}
	public void focusLost(FocusEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJPasswordField())
			connEtoC7(e);
		if (e.getSource() == getJPasswordField())
			connEtoC6(e);
		// user code begin {2}
		// user code end
	}
	/**
	 * Gets the aceptarKeyLikeTabKey property (boolean) value.
	 * @return The aceptarKeyLikeTabKey property value.
	 * @see #setAceptarKeyLikeTabKey
	 */
	public boolean getAceptarKeyLikeTabKey() {
		return fieldAceptarKeyLikeTabKey;
	}
	/**
	 * Method generated to support the promotion of the caretPosition attribute.
	 * @return int
	 */
	public int getCaretPosition() {
		return getJPasswordField().getCaretPosition();
	}
	/**
	 * Method generated to support the promotion of the columns attribute.
	 * @return int
	 */
	public int getColumns() {
		return getJPasswordField().getColumns();
	}
	/**
	 * Gets the dataValidateOnFocusLost property (boolean) value.
	 * @return The dataValidateOnFocusLost property value.
	 * @see #setDataValidateOnFocusLost
	 */
	public boolean getDataValidateOnFocusLost() {
		return fieldDataValidateOnFocusLost;
	}
	/**
	 * Inserte aquí la descripción del método.
	 * Fecha de creación: (08/03/2005 14:20:03)
	 * @return int
	 */
	public int getDecimales() {
		return decimales;
	}
	/**
	 * Method generated to support the promotion of the disabledTextColor attribute.
	 * @return Color
	 */
	public Color getDisabledTextColor() {
		return getJPasswordField().getDisabledTextColor();
	}
	/**
	 * Gets the error property (java.lang.Boolean) value.
	 * @return The error property value.
	 * @see #setError
	 */
	public Boolean getError() {
		return fieldError;
	}
	/**
	 * Gets the errorDescription property (java.lang.String) value.
	 * @return The errorDescription property value.
	 * @see #setErrorDescription
	 */
	public String getErrorDescription() {
		return fieldErrorDescription;
	}
	/**
	 * Method generated to support the promotion of the focusAccelerator attribute.
	 * @return char
	 */
	public char getFocusAccelerator() {
		return getJPasswordField().getFocusAccelerator();
	}
		/**
		 * Returns the horizontal alignment of the text.
		 * Valid keys: JTextField.LEFT (the default), JTextField.CENTER,
		 * JTextField.RIGHT.
		 *
		 * @return the alignment
		 */
		public int getHorizontalAlignment() {
			return getJPasswordField().getHorizontalAlignment();
		}
	/**
	 * Method generated to support the promotion of the horizontalTextAlignment attribute.
	 * @return int
	 */
	public int getHorizontalTextAlignment() {
		return getJPasswordField().getHorizontalAlignment();
	}
	/**
	 * Return the JTextField property value.
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPasswordField getJPasswordField() {
		if (ivjJPasswordField == null) {
			try {
				ivjJPasswordField = new JPasswordField();
				ivjJPasswordField.setName("JPasswordField");
				ivjJPasswordField.setVisible(true);
				ivjJPasswordField.setDisabledTextColor(Color.darkGray);
				ivjJPasswordField.setPreferredSize(new Dimension(4, 20));
				ivjJPasswordField.setFont(new Font("Arial", 0, 10));
				ivjJPasswordField.setMinimumSize(new Dimension(4, 20));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPasswordField;
	}
	/**
	 * Gets the keyMask property (int) value.
	 * @return The keyMask property value.
	 * @see #setKeyMask
	 */
	public TextFieldExt.KeyMask getKeyMask() {
		return fieldKeyMask;
	}
	/**
	 * Gets the maxLength property (int) value.
	 * @return The maxLength property value.
	 * @see #setMaxLength
	 */
	public int getMaxLength() {
		return fieldMaxLength;
	}
	/**
	 * Gets the nullsSupported property (boolean) value.
	 * @return The nullsSupported property value.
	 * @see #setNullsSupported
	 */
	public boolean getNullsSupported() {
		return fieldNullsSupported;
	}
	/**
	 * Accessor for the propertyChange field.
	 * @return PropertyChangeSupport
	 */
	protected PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new PropertyChangeSupport(this);
		};
		return propertyChange;
	}
	/**
	 * This method was created in VisualAge.
	 * @return int
	 */
	public int getSelectionEnd() {
		return getJPasswordField().getSelectionEnd();
	}
	/**
	 * Method generated to support the promotion of the textFieldExtText attribute.
	 * @return java.lang.String
	 */
	private String getText() {
		return getPasswordText();
	}
	/**
	 * Method generated to support the promotion of the textFont attribute.
	 * @return Font
	 */
	public Font getTextFont() {
		return getJPasswordField().getFont();
	}
	/**
	 * Gets the allowedKey property (int) value.
	 * @return The allowedKey property value.
	 * @see #setAllowedKey
	 */
	public TextFieldExt.AllowedKey getAllowedKey() {
		return fieldAllowedKey;
	}
	/**
	 * Method generated to support the promotion of the textFieldExtText attribute.
	 * @return java.lang.String
	 */
	public String getValue() {
		TextFieldExt.AllowedKey tp = this.getAllowedKey();
	    TextFieldExt.KeyMask km = this.getKeyMask();

	    if (tp == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
	        if (km == TextFieldExt.KeyMask.KM_Moneda)
	            return efren.util.StringTools.parseFromQuantityToNumber(this.getText().trim());
	        else {
	            if (km == TextFieldExt.KeyMask.KM_Numero)
	                return efren.util.StringTools.parseFromQuantityToNumber(this.getText().trim());
	            else
	                return this.getText().trim();
	        }
	    } else {
	        if (tp == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
	            if (km == TextFieldExt.KeyMask.KM_Moneda)
	                return efren.util.StringTools.parseFromQuantityToNumber(this.getText().trim());
	            else {
	                if (km == TextFieldExt.KeyMask.KM_Numero)
	                    return efren.util.StringTools.parseFromQuantityToNumber(this.getText().trim());
	                else
	                    return this.getText().trim();
	            }
	        } else
	            return this.getText().trim();
	    }
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
		getJPasswordField().addMouseListener(this);
		getJPasswordField().addFocusListener(this);
		// user code end
		getJPasswordField().addPropertyChangeListener(this);
		this.addFocusListener(this);
		getJPasswordField().addActionListener(this);
		getJPasswordField().addFocusListener(this);
		getJPasswordField().addKeyListener(this);
		getJPasswordField().addMouseListener(this);
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			setName("PasswordFieldExt");
			setPreferredSize(new Dimension(44, 20));
			setLayout(new GridBagLayout());
			setSize(118, 21);
			setMinimumSize(new Dimension(44, 20));

			GridBagConstraints constraintsJTextField = new GridBagConstraints();
			constraintsJTextField.gridx = 0; constraintsJTextField.gridy = 0;
			constraintsJTextField.fill = GridBagConstraints.BOTH;
			constraintsJTextField.weightx = 1.0;
			constraintsJTextField.weighty = 1.0;
			add(getJPasswordField(), constraintsJTextField);
			initConnections();

			this.setEchoChar(getJPasswordField().getEchoChar());

		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 * This method was created in VisualAge.
	 * @return boolean
	 * @param unChar char
	 */
	private boolean isAlfabetico( char unChar)  {
				switch(unChar){
					case 'A': return true;
					case 'B': return true;
					case 'C': return true;
					case 'D': return true;
					case 'E': return true;
					case 'F': return true;
					case 'G': return true;
					case 'H': return true;
					case 'I': return true;
					case 'J': return true;
					case 'K': return true;
					case 'L': return true;
					case 'M': return true;
					case 'N': return true;
					case 'Ñ': return true;
					case 'O': return true;
					case 'P': return true;
					case 'Q': return true;
					case 'R': return true;
					case 'S': return true;
					case 'T': return true;
					case 'U': return true;
					case 'V': return true;
					case 'W': return true;
					case 'X': return true;
					case 'Y': return true;
					case 'Z': return true;
					case 'a': return true;
					case 'b': return true;
					case 'c': return true;
					case 'd': return true;
					case 'e': return true;
					case 'f': return true;
					case 'g': return true;
					case 'h': return true;
					case 'i': return true;
					case 'j': return true;
					case 'k': return true;
					case 'l': return true;
					case 'm': return true;
					case 'n': return true;
					case 'ñ': return true;
					case 'o': return true;
					case 'p': return true;
					case 'q': return true;
					case 'r': return true;
					case 's': return true;
					case 't': return true;
					case 'u': return true;
					case 'v': return true;
					case 'w': return true;
					case 'x': return true;
					case 'y': return true;
					case 'z': return true;
					case ' ': return true;
					case '*': return true;//debido a búsquedas
					default:
						return false;
				}
	}
	/**
	 *
	 * @return
	 */
	public boolean isDataMissing() {
		if ((getText() == null) || (getText().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Ingrese un texto !");
			this.requestFocus();
			return true;
		}
		return false;
	}
	/**
	 *
	 * @param errorMessage
	 * @return
	 */
	public boolean isDataMissing(String errorMessage) {
		if ((getText() == null) || (getText().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}
	public boolean isEditable() {
	    return getJPasswordField().isEditable();
	}
	/**
	 * Method generated to support the promotion of the Enabled attribute.
	 * @return boolean
	 */
	public boolean isEnabled() {
		return getJPasswordField().isEnabled();
	}
	/**
	 * This method was created in VisualAge.
	 * @return boolean
	 * @param unChar char
	 */
	private boolean isNumerico(char unChar) {
		switch (unChar) {
			case '0' :
				return true;
			case '1' :
				return true;
			case '2' :
				return true;
			case '3' :
				return true;
			case '4' :
				return true;
			case '5' :
				return true;
			case '6' :
				return true;
			case '7' :
				return true;
			case '8' :
				return true;
			case '9' :
				return true;
			default :
				return false;
		}
	}
	/**
	 * This method was created in VisualAge.
	 * @return boolean
	 * @param unChar char
	 */
	private boolean isNumericoConFraccion(char unChar) {
		switch (unChar) {
			case '0' :
				return true;
			case '1' :
				return true;
			case '2' :
				return true;
			case '3' :
				return true;
			case '4' :
				return true;
			case '5' :
				return true;
			case '6' :
				return true;
			case '7' :
				return true;
			case '8' :
				return true;
			case '9' :
				return true;
			case '.' :
				return dotCountValidate();
			default :
				return false;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25-Sep-2003 12:28:52 PM)
	 * @return boolean
	 */
	public boolean isSeleccionarAlRecibirElFoco() {
		return seleccionarAlRecibirElFoco;
	}
	/**
	 * Method to handle events for the KeyListener interface.
	 * @param e KeyEvent
	 */
	public void keyPressed(KeyEvent e) {

	    if (getAceptarKeyLikeTabKey()) {
	        int key = e.getKeyCode();
	        if (key == KeyEvent.VK_ENTER) {
	            transferFocus();
	        }
	    }
	}
	/**
	 * Method to handle events for the KeyListener interface.
	 * @param e KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(KeyEvent e) {
		// user code begin {1}
	    boolean numerico = false;
	    if (((getText() == null) || (getText().trim().compareTo("") == 0)) && (!getNullsSupported())) {
	        if ((getAllowedKey() == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) || (getAllowedKey() == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION)) {
	            //AK_SOLO_NUMEROS o AK_NUMEROS_CON_FRACCION
	            numerico = true;
	            //setValue(new Integer(0).toString());
	        }
	    }
		// user code end
		if (e.getSource() == getJPasswordField())
			connEtoC8(e);
		if (e.getSource() == getJPasswordField())
			connEtoC2(e);
		// user code begin {2}
	    if (numerico)
	        setValue("");
		// user code end
	}
	/**
	 * Method to handle events for the KeyListener interface.
	 * @param e KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyTyped(KeyEvent e) {
		String passwordText = getPasswordText();
	    // user code begin {1}
	    switch (e.getKeyChar()) {
	        case KeyEvent.VK_ENTER :
	            break;
	        case KeyEvent.VK_BACK_SPACE :
	            break;
	        case KeyEvent.VK_TAB :
	            break;
	        case KeyEvent.VK_SHIFT :
	            break;
	        case KeyEvent.VK_CONTROL :
	            break;
	        case KeyEvent.VK_ALT :
	            break;
	        case KeyEvent.VK_CAPS_LOCK :
	            break;
	        case KeyEvent.VK_END :
	            break;
	        case KeyEvent.VK_HOME :
	            break;
	        case KeyEvent.VK_LEFT :
	            break;
	        case KeyEvent.VK_UP :
	            break;
	        case KeyEvent.VK_RIGHT :
	            break;
	        case KeyEvent.VK_DOWN :
	            break;
	        case KeyEvent.VK_DELETE :
	            break;
	        case KeyEvent.VK_NUM_LOCK :
	            break;
	        default :
	            if (getAllowedKey() == TextFieldExt.AllowedKey.AK_ALFANUMERICOS) {
	                if (getMaxLength() == 0) {
	                    validaKeyMask(e);
	                } else {
	                    if (getJPasswordField().getSelectedText() != null || passwordText.length() < getMaxLength()) {
	                        validaKeyMask(e);
	                    } else {
	                        e.setKeyChar('\0');
	                        e.setKeyCode(0);
	                    }
	                }
	            } else {
	                validaAllowedKey(e);
	                if (getMaxLength() == 0) {
	                    e.setKeyChar('\0');
	                    e.setKeyCode(0);
	                } else {
	                    if (getJPasswordField().getSelectedText() != null || passwordText.length() < getMaxLength()) {
	                        validaKeyMask(e);
	                    } else {
	                        e.setKeyChar('\0');
	                        e.setKeyCode(0);
	                    }
	                }
	            }
	            break;
	    }
	}
	private void manageTextSelectionOnFocusGained() {
		if (isSeleccionarAlRecibirElFoco())
			this.seleccionar();
	}
	public void mouseClicked(MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJPasswordField())
			connEtoC11(e);
		// user code begin {2}
		// user code end
	}
	public void mouseEntered(MouseEvent e) {
		if (isEnabled() && isEditable())
			getJPasswordField().setCursor(new Cursor(Cursor.TEXT_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
		getJPasswordField().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void mousePressed(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}
	public void mouseReleased(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}
	/**
	 *
	 * @param pos int
	 */
	public void moveCaretPosition(int pos) {
			getJPasswordField().moveCaretPosition(pos);
	}
	/**
	 * 
	 */
	private void parseValue() {
		String passwordText = getPasswordText();

	    if (passwordText.trim().length() == 0)
	        return;

	    TextFieldExt.AllowedKey tp = this.getAllowedKey();
	    TextFieldExt.KeyMask km = this.getKeyMask();

	    if (tp == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
	        if (km == TextFieldExt.KeyMask.KM_Moneda)
	           this.getJPasswordField().setText("$"+efren.util.StringTools.parseFromNumberToInteger(passwordText.trim()));
	        else {
	            if (km == TextFieldExt.KeyMask.KM_Numero)
	                this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToInteger(passwordText.trim()));
	        }
	    } else {
	        if (tp == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
	            if (km == TextFieldExt.KeyMask.KM_Moneda)
	                this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToMoney(
		                new java.math.BigDecimal(efren.util.StringTools.parseOnlyNumbers(passwordText.trim())), getDecimales()));
	            else {
	                if (km == TextFieldExt.KeyMask.KM_Numero)
	                    this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToQuantity(
		                    new java.math.BigDecimal(efren.util.StringTools.parseOnlyNumbers(passwordText.trim())), getDecimales()));
	            }
	        }
	    }
	}
	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 * @param evt PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getJPasswordField() && (evt.getPropertyName().equals("horizontalAlignment")))
			connEtoC3(evt);
		if (evt.getSource() == getJPasswordField() && (evt.getPropertyName().equals("focusAccelerator")))
			connEtoC4(evt);
		// user code begin {2}
		// user code end
	}
	private void refreshValue() {

	    this.setValue(this.getValue());
	}
	/**
	 * The removePropertyChangeListener method was generated to support the propertyChange field.
	 * @param listener PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}
	/**
	 *
	 * @param newListener PasswordFieldExtListener
	 */
	public void removePasswordFieldExtListener(PasswordFieldExtListener newListener) {
		fieldPasswordFieldExtListenerEventMulticaster = PasswordFieldExtListenerEventMulticaster.remove(fieldPasswordFieldExtListenerEventMulticaster, newListener);
		return;
	}
	/**
	 * Comment
	 */
	public void seleccionar() {
	    getJPasswordField().setSelectionStart(0);
	    getJPasswordField().setSelectionEnd(getText().length());
	}
	/**
	 *
	 * @param selectionStart int
	 * @param selectionEnd int
	 */
	public void select(int selectionStart, int selectionEnd) {
			getJPasswordField().select(selectionStart, selectionEnd);
	}
	/**
	 * Sets the aceptarKeyLikeTabKey property (boolean) value.
	 * @param aceptarKeyLikeTabKey The new value for the property.
	 * @see #getAceptarKeyLikeTabKey
	 */
	public void setAceptarKeyLikeTabKey(boolean aceptarKeyLikeTabKey) {
		boolean oldValue = fieldAceptarKeyLikeTabKey;
		fieldAceptarKeyLikeTabKey = aceptarKeyLikeTabKey;
		firePropertyChange("aceptarKeyLikeTabKey", new Boolean(oldValue), new Boolean(aceptarKeyLikeTabKey));
	}
	public void setBGColor(Color c) {
	    getJPasswordField().setBackground(c);
	}
	/**
	 * Method generated to support the promotion of the caretPosition attribute.
	 * @param arg1 int
	 */
	public void setCaretPosition(int arg1) {
		getJPasswordField().setCaretPosition(arg1);
	}
	/**
	 * Method generated to support the promotion of the columns attribute.
	 * @param arg1 int
	 */
	public void setColumns(int arg1) {
		getJPasswordField().setColumns(arg1);
	}
	/**
	 * Sets the dataValidateOnFocusLost property (boolean) value.
	 * @param dataValidateOnFocusLost The new value for the property.
	 * @see #getDataValidateOnFocusLost
	 */
	public void setDataValidateOnFocusLost(boolean dataValidateOnFocusLost) {
		boolean oldValue = fieldDataValidateOnFocusLost;
		fieldDataValidateOnFocusLost = dataValidateOnFocusLost;
		firePropertyChange("dataValidateOnFocusLost", new Boolean(oldValue), new Boolean(dataValidateOnFocusLost));
	}
	/**
	 * Inserte aquí la descripción del método.
	 * Fecha de creación: (08/03/2005 14:20:03)
	 * @param newDecimales int
	 */
	public void setDecimales(int newDecimales) {
		decimales = newDecimales;
	}
	/**
	 * Method generated to support the promotion of the disabledTextColor attribute.
	 * @param arg1 Color
	 */
	public void setDisabledTextColor(Color arg1) {
		getJPasswordField().setDisabledTextColor(arg1);
	}
	public void setEditable(boolean aBool) {
		getJPasswordField().setEditable(aBool);
	}
	public void setEnabled(boolean aBool) {
	    getJPasswordField().setEnabled(aBool);
	    //	getJPasswordField().setOpaque(!aBool);
	    if (aBool)
	        getJPasswordField().setBackground(Color.white);
	    else
	        getJPasswordField().setBackground(new Color(231,231,231));
	}
	/**
	 * Sets the error property (java.lang.Boolean) value.
	 * @param error The new value for the property.
	 * @see #getError
	 */
	public void setError(Boolean error) {
		Boolean oldValue = fieldError;
		fieldError = error;
		firePropertyChange("error", oldValue, error);
	}
	/**
	 * Sets the errorDescription property (java.lang.String) value.
	 * @param errorDescription The new value for the property.
	 * @see #getErrorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		fieldErrorDescription = errorDescription;
	}
	/**
	 * Method generated to support the promotion of the focusAccelerator attribute.
	 * @param arg1 char
	 */
	public void setFocusAccelerator(char arg1) {
		getJPasswordField().setFocusAccelerator(arg1);
	}
	public void setFont(Font aFont) {
	    super.setFont(aFont);

	    getJPasswordField().setFont(aFont);
	}
	public void setForeground(Color c) {
	    super.setForeground(c);
	    getJPasswordField().setForeground(c);
	}
		/**
		 * Sets the horizontal alignment of the text.
		 * Valid keys: JTextField.LEFT (the default), JTextField.CENTER,
		 * JTextField.RIGHT.  invalidate() and repaint() are called when the
		 * alignment is set, and a PropertyChange event ("horizontalAlignment")
		 * is fired.
		 *
		 * @param alignment the alignment
		 * @exception IllegalArgumentException if the alignment
		 *  specified is not a valid key.
		 * @beaninfo
		 *   preferred: true
		 *       bound: true
		 * description: Set the field alignment to LEFT (the default), CENTER, RIGHT
		 *        enum: LEFT JTextField.LEFT CENTER JTextField.CENTER RIGHT JTextField.RIGHT
		 */
		public void setHorizontalAlignment(int alignment) {
			getJPasswordField().setHorizontalAlignment(alignment);
		}
	/**
	 * Method generated to support the promotion of the horizontalTextAlignment attribute.
	 * @param arg1 int
	 */
	public void setHorizontalTextAlignment(int arg1) {
		getJPasswordField().setHorizontalAlignment(arg1);
	}
	/**
	 * Sets the keyMask property (int) value.
	 * @param keyMask The new value for the property.
	 * @see #getKeyMask
	 */
	public void setKeyMask(TextFieldExt.KeyMask keyMask) {
		TextFieldExt.KeyMask oldValue = fieldKeyMask;
	    fieldKeyMask = keyMask;
	    firePropertyChange("keyMask", oldValue, keyMask);
	    //...
	    this.setValue(this.getValue());
	    if (keyMask == TextFieldExt.KeyMask.KM_Moneda || keyMask == TextFieldExt.KeyMask.KM_Numero) {
	        this.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	        this.setMaxLength(this.getMaxLength() + 20);
	    } else
	        this.setHorizontalAlignment(javax.swing.JTextField.LEFT);
	}
	/**
	 * Sets the maxLength property (int) value.
	 * @param maxLength The new value for the property.
	 * @see #getMaxLength
	 */
	public void setMaxLength(int maxLength) {
	    fieldMaxLength = maxLength;

	    if (getAllowedKey() == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS || getAllowedKey() == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
	        if (getKeyMask() == TextFieldExt.KeyMask.KM_Moneda || getKeyMask() == TextFieldExt.KeyMask.KM_Numero) {
	            this.fieldMaxLength = maxLength + 20;
	        }
	    }
	}
	/**
	 * Sets the nullsSupported property (boolean) value.
	 * @param nullsSupported The new value for the property.
	 * @see #getNullsSupported
	 */
	public void setNullsSupported(boolean nullsSupported) {
		boolean oldValue = fieldNullsSupported;
		fieldNullsSupported = nullsSupported;
		firePropertyChange("nullsSupported", new Boolean(oldValue), new Boolean(nullsSupported));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25-Sep-2003 12:28:52 PM)
	 * @param newSeleccionarAlRecibirElFoco boolean
	 */
	public void setSeleccionarAlRecibirElFoco(boolean newSeleccionarAlRecibirElFoco) {
		seleccionarAlRecibirElFoco = newSeleccionarAlRecibirElFoco;
	}
	/**
	 *
	 * @param selectionEnd int
	 */
	public void setSelectionEnd(int selectionEnd) {
			getJPasswordField().setSelectionEnd(selectionEnd);
	}
	/**
	 *
	 * @param selectionStart int
	 */
	public void setSelectionStart(int selectionStart) {
	    getJPasswordField().setSelectionStart(selectionStart);
	}
	/**
	 * Method generated to support the promotion of the textFont attribute.
	 * @param arg1 Font
	 */
	public void setTextFont(Font arg1) {
		getJPasswordField().setFont(arg1);
	}
	/**
	 * @param   allowedKey            One of 4 legal values: AK_SOLO_NUMEROS,
	 *                          AK_NUMEROS_CON_FRACCION, AK_AK_SOLO_LETRAS, AK_AK_ALFANUMERICOS
	 *
	 * @beaninfo
	 *   preferred: true
	 *        enum: 	AK_SOLO_NUMEROS TextFieldExt.AllowedKey.AK_SOLO_NUMEROS
	 *              		AK_NUMEROS_CON_FRACCION TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION
	 *						AK_AK_SOLO_LETRAS TextFieldExt.AllowedKey.AK_AK_SOLO_LETRAS
	 *              		AK_AK_ALFANUMERICOS TextFieldExt.AllowedKey.AK_AK_ALFANUMERICOS
	 * description: The frame's default close operation.
	 */
	public void setAllowedKey(TextFieldExt.AllowedKey allowedKey) {
		TextFieldExt.AllowedKey oldValue = fieldAllowedKey;
	    fieldAllowedKey = allowedKey;
	    firePropertyChange("allowedKey", oldValue, allowedKey);
	    //...
	    this.setValue(this.getValue());
	    if (allowedKey == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS || allowedKey == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
	        this.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	        this.setMaxLength(this.getMaxLength() + 20);
	    } else
	        this.setHorizontalAlignment(javax.swing.JTextField.LEFT);
	}
	/**
	 * 
	 * @param arg1
	 */
	public void setValue(String arg1) {
		String passwordText = getPasswordText();
	    if (arg1 == null || arg1.trim().compareTo("null") == 0) {
	        getJPasswordField().setText("");
	        return;
	    }

	    TextFieldExt.AllowedKey tp = this.getAllowedKey();
	    TextFieldExt.KeyMask km = this.getKeyMask();

	    if (tp == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
	        if (km == TextFieldExt.KeyMask.KM_Moneda) {
		        if (passwordText.trim().length() == 0)
	                 this.getJPasswordField().setText("");
	            else
	                 this.getJPasswordField().setText("$"+efren.util.StringTools.parseFromNumberToInteger(passwordText.trim()));
	        } else {
	            if (km == TextFieldExt.KeyMask.KM_Numero) {
		            if (arg1.trim().length() == 0)
	                	this.getJPasswordField().setText("");
	                else
	                	this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToInteger(arg1.trim()));
	            } else
	                getJPasswordField().setText(arg1);
	        }
	    } else {
	        if (tp == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
	            if (km == TextFieldExt.KeyMask.KM_Moneda) {
		            if (arg1.trim().length() == 0)
	                	this.getJPasswordField().setText("");
	                else
	                	this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToMoney(
		                		new java.math.BigDecimal(arg1.trim()), getDecimales()));
	            } else {
	                if (km == TextFieldExt.KeyMask.KM_Numero) {
		                if (arg1.trim().length() == 0)
	                    	this.getJPasswordField().setText("");
	                    else
	                    	this.getJPasswordField().setText(efren.util.StringTools.parseFromNumberToQuantity(
		                    		new java.math.BigDecimal(efren.util.StringTools.parseFromMoneyToNumber(arg1.trim())), getDecimales()));
	                } else
	                    getJPasswordField().setText(arg1);
	            }
	        } else
	            getJPasswordField().setText(arg1);
	    }
	}
	public String SQLFullText() {

		return " '" +getText().trim().replace('*', '%').toUpperCase()+"%' ";
	}
	public String SQLText() {
	    if (getText() == null || getText().trim().length() == 0)
	        return " NULL ";
	    else {
	        if (getAllowedKey() == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS || getAllowedKey() == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION)
	            return " " + efren.util.StringTools.parseComilla(getValue().trim()) + " ";
	        else
	            return " '" + efren.util.StringTools.parseComilla(getValue().trim()) + "' ";
	    }
	}
	/**
	 * Agarra la tecla presionada le coloca la mascara elegida "U" Mayusculas, "L" Minusculas, "N" Normal
	 */
	private void validaKeyMask(KeyEvent e) {
		if (isAlfabetico(e.getKeyChar())) {
			switch (getKeyMask()) {
			case KM_MAYUSCULAS:
		        char unChar[] = {e.getKeyChar()};
		        java.lang.String unString = new java.lang.String(unChar);
		        unString = unString.toUpperCase();
		        e.setKeyChar(unString.charAt(0));
				break;
			case KM_minusculas:
		        char chars[] = {e.getKeyChar()};
		        unString = new java.lang.String(chars);
		        unString = unString.toLowerCase();
		        e.setKeyChar(unString.charAt(0));
				break;
			default:
		        e.setKeyChar(e.getKeyChar());
				break;
			}
		}
	}
	/**
	 * This method was created in VisualAge.
	 * @param e KeyEvent
	 */
	private void validaAllowedKey(KeyEvent e) {
		switch (getAllowedKey()) {
		case AK_SOLO_NUMEROS:
			if (!(isNumerico(e.getKeyChar()))) {
				e.setKeyChar( '\0');
				return;
			}
			break;
		case AK_NUMEROS_CON_FRACCION:
			if (!(isNumericoConFraccion(e.getKeyChar()))) {
				e.setKeyChar( '\0');
				return;
			}
			break;
		case AK_SOLO_LETRAS:
			if (!(isAlfabetico(e.getKeyChar()))) {
				e.setKeyChar('\0');
				return;
			}
			break;
		default:
			break;
		}
	}
	/**
	 *
	 */
	public void setBackground(Color unColor) {
	    super.setBackground(unColor);
	    getJPasswordField().setBackground(unColor);
	}
	/**
	 *
	 */
	public void setBorder(Border border) {
		super.setBorder(border);
		getJPasswordField().setBorder(border);
	}
	/**
	 *
	 */
	public void requestFocus() {
		getJPasswordField().requestFocus();
	}
	public char getEchoChar() {
		return echoChar;
	}
	public void setEchoChar(char echoChar) {
		this.echoChar = echoChar;
		getJPasswordField().setEchoChar(echoChar);
	}
	/**
	 * 
	 */
	private String getPasswordText() {
		String passwordText = "";
		char passChars[] = getJPasswordField().getPassword();
		for (int i = 0; i < passChars.length; i++) {
			passwordText = passwordText + passChars[i];
		}
		return passwordText;
	}
}
