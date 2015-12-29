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
import java.math.BigDecimal;
import java.util.EventObject;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import efren.util.ExceptionManager;
import efren.util.StringTools;
import efren.util.gui.dialogs.InfoView;

public class TextFieldExt extends JPanel implements ActionListener, FocusListener, KeyListener, MouseListener, PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -3391185708529284746L;
	// ...
	public static enum PainterType {
		PAINTER_DEFAULT, 
		PAINTER_ERROR
	}
	public static enum AllowedKey {
		AK_SOLO_NUMEROS,
		AK_NUMEROS_CON_FRACCION,
		AK_SOLO_LETRAS,
		AK_ALFANUMERICOS
	}
	public static enum KeyMask {
		KM_MAYUSCULAS,
		KM_minusculas,
		KM_Mayusculas_Y_Minusculas,
		KM_Moneda,
		KM_Numero
	}
	// ...
	private KeyMask fieldKeyMask = KeyMask.KM_Mayusculas_Y_Minusculas;  //  @jve:decl-index=0:
	private AllowedKey fieldAllowedKey = AllowedKey.AK_ALFANUMERICOS;
	private JTextField ivjJTextField = null;
	private Boolean fieldError = new Boolean(false);
	private String fieldErrorDescription = new String();
	protected transient TextFieldExtListener fieldTextFieldExtListenerEventMulticaster = null;
	private int fieldMaxLength = 0;
	private boolean fieldAceptarKeyLikeTabKey = true;
	private boolean fieldDataValidateOnFocusLost = false;
	private boolean fieldNullsSupported = false;
	protected transient PropertyChangeSupport propertyChange;
	private boolean seleccionarAlRecibirElFoco = true;
	private int decimales = 2;// solo para numeros con decimales. por default=2
	//private int tipoPainter = PAINTER_DEFAULT;
	//private int tipoPainter_original = PAINTER_DEFAULT;

	/**
	 * Constructor
	 */
	public TextFieldExt() {
		super();
		initialize();
	}
	/**
	 *
	 */
	public TextFieldExt(LayoutManager layout) {
		super(layout);
	}
	/**
	 *
	 */
	public TextFieldExt(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	/**
	 *
	 */
	public TextFieldExt(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}
	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getJTextField()) {
			connEtoC1(e);
		}
	}
	/**
	 *
	 */
	public synchronized void addActionListener(ActionListener l) {
		listenerList.add(ActionListener.class, l);
	}
	/**
	 *
	 */
	public synchronized void addMouseListener(MouseListener l) {
		listenerList.add(MouseListener.class, l);
	}
	/**
	 *
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}
	/**
	 *
	 */
	public void addTextFieldExtListener(TextFieldExtListener newListener) {
		fieldTextFieldExtListenerEventMulticaster =
			TextFieldExtListenerEventMulticaster.add(fieldTextFieldExtListenerEventMulticaster, newListener);
		return;
	}
	/**
	 *
	 */
	private void connEtoC1(ActionEvent arg1) {
		try {
			this.fireActionPerformed(new EventObject(this));
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC10(FocusEvent arg1) {
		try {
			this.fireFocusGained(new EventObject(this));
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC11(MouseEvent arg1) {
		try {
			this.fireTextDateMouseClicked(arg1);
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC2(KeyEvent arg1) {
		try {
			/*
			 * this.fireField_keyReleased(new EventObject(this));
			 */
			KeyEvent ke = new KeyEvent(this, arg1.getID(), arg1.getWhen(), arg1.getModifiers(), arg1.getKeyCode(), arg1.getKeyChar());
			this.fireField_keyReleased(ke);
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC3(PropertyChangeEvent arg1) {
		try {
			this.firePropertyChange("horizontalAlignment", arg1.getOldValue(), arg1.getNewValue());
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC4(PropertyChangeEvent arg1) {
		try {
			this.firePropertyChange("focusAccelerator", arg1.getOldValue(), arg1.getNewValue());
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC5(FocusEvent arg1) {
		try {
			this.manageTextSelectionOnFocusGained();
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC6(FocusEvent arg1) {
		try {
			this.parseValue();
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoC7(FocusEvent arg1) {
		FocusEvent fe = new FocusEvent(this, arg1.getID(), arg1.isTemporary());
		this.fireFocusLost(fe);
	}
	/**
	 *
	 */
	private void connEtoC8(KeyEvent arg1) {
		if (arg1.getKeyCode() == KeyEvent.VK_ENTER) {
			this.parseValue();
		}
	}
	/**
	 *
	 */
	private void connEtoC9(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.refreshValue();
			// user code begin {2}
			// user code end
		} catch (Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
	private void connEtoM1(FocusEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJTextField().requestFocus();
			// user code begin {2}
			// user code end
		} catch (Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 *
	 */
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
	 *
	 * @param newEvent
	 *            EventObject
	 */
	protected void fireActionPerformed(EventObject newEvent) {
		if (fieldTextFieldExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextFieldExtListenerEventMulticaster.actionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            EventObject
	 */
	protected void fireField_keyReleased(KeyEvent newEvent) {
		if (fieldTextFieldExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextFieldExtListenerEventMulticaster.field_keyReleased(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            EventObject
	 */
	protected void fireFocusGained(EventObject newEvent) {
		if (fieldTextFieldExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextFieldExtListenerEventMulticaster.focusGained(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            EventObject
	 */
	protected void fireFocusLost(EventObject newEvent) {
		if (fieldTextFieldExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextFieldExtListenerEventMulticaster.focusLost(newEvent);
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 *
	 * @param propertyName
	 *            String
	 * @param oldValue
	 *            Object
	 * @param newValue
	 *            Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            EventObject
	 */
	protected void fireTextDateMouseClicked(EventObject newEvent) {
		if (fieldTextFieldExtListenerEventMulticaster == null) {
			return;
		}
		;
		fieldTextFieldExtListenerEventMulticaster.textDateMouseClicked(newEvent);
	}

	public void focusGained(FocusEvent e) {
		try {
			// user code begin {1}
			if (getJTextField().isEditable() && getJTextField().isEnabled()) {
				getJTextField().selectAll();
			}
			// user code end
			if (e.getSource() == this)
				connEtoM1(e);
			if (e.getSource() == getJTextField())
				connEtoC5(e);
			if (e.getSource() == getJTextField())
				connEtoC9(e);
			if (e.getSource() == getJTextField())
				connEtoC10(e);
			// user code begin {2}
			if (getJTextField().isEditable() && getJTextField().isEnabled()) {
				getJTextField().selectAll();
			}
			// user code end
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	public void focusLost(FocusEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJTextField())
			connEtoC7(e);
		if (e.getSource() == getJTextField())
			connEtoC6(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Gets the aceptarKeyLikeTabKey property (boolean) value.
	 *
	 * @return The aceptarKeyLikeTabKey property value.
	 * @see #setAceptarKeyLikeTabKey
	 */
	public boolean getAceptarKeyLikeTabKey() {
		return fieldAceptarKeyLikeTabKey;
	}

	/**
	 * Method generated to support the promotion of the caretPosition attribute.
	 *
	 * @return int
	 */
	public int getCaretPosition() {
		return getJTextField().getCaretPosition();
	}

	/**
	 * Method generated to support the promotion of the columns attribute.
	 *
	 * @return int
	 */
	public int getColumns() {
		return getJTextField().getColumns();
	}

	/**
	 * Gets the dataValidateOnFocusLost property (boolean) value.
	 *
	 * @return The dataValidateOnFocusLost property value.
	 * @see #setDataValidateOnFocusLost
	 */
	public boolean getDataValidateOnFocusLost() {
		return fieldDataValidateOnFocusLost;
	}

	/**
	 * Inserte aquí la descripción del método. Fecha de creación: (08/03/2005
	 * 14:20:03)
	 *
	 * @return int
	 */
	public int getDecimales() {
		return decimales;
	}

	/**
	 * Method generated to support the promotion of the disabledTextColor
	 * attribute.
	 *
	 * @return Color
	 */
	public Color getDisabledTextColor() {
		return getJTextField().getDisabledTextColor();
	}

	/**
	 * Gets the error property (Boolean) value.
	 *
	 * @return The error property value.
	 * @see #setError
	 */
	public Boolean getError() {
		return fieldError;
	}

	/**
	 * Gets the errorDescription property (String) value.
	 *
	 * @return The errorDescription property value.
	 * @see #setErrorDescription
	 */
	public String getErrorDescription() {
		return fieldErrorDescription;
	}

	/**
	 * Method generated to support the promotion of the focusAccelerator
	 * attribute.
	 *
	 * @return char
	 */
	public char getFocusAccelerator() {
		return getJTextField().getFocusAccelerator();
	}

	/**
	 * Returns the horizontal alignment of the text. Valid keys: JTextField.LEFT
	 * (the default), JTextField.CENTER, JTextField.RIGHT.
	 *
	 * @return the alignment
	 */
	public int getHorizontalAlignment() {
		return getJTextField().getHorizontalAlignment();
	}

	/**
	 * Method generated to support the promotion of the horizontalTextAlignment
	 * attribute.
	 *
	 * @return int
	 */
	public int getHorizontalTextAlignment() {
		return getJTextField().getHorizontalAlignment();
	}

	/**
	 * Return the JTextField property value.
	 *
	 * @return JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JTextField getJTextField() {
		if (ivjJTextField == null) {
			ivjJTextField = new JTextField();
/*
				ivjJTextField = new JTextField() {
					private static final long serialVersionUID = 3585686964708385919L;

					public void paintComponent(Graphics g2) {
						try {
							super.paintComponent(g2);
							switch (tipoPainter) {
							case PAINTER_ERROR:
								// Error (símbolo de error en la esquina
								// superior izquierda)
								g2.setColor(Color.RED);
								g2.fillRect(2, 2, 12, 9);
								g2.setColor(Color.WHITE);
								g2.drawLine(4, 4, 8, 8);
								g2.drawLine(4, 8, 8, 4);
								break;
							default:
								break;
							}
						} catch (Throwable t) {
							t.getMessage();
						}
					}
				};
*/
			ivjJTextField.setName("JTextField");
			ivjJTextField.setVisible(true);
			ivjJTextField.setDisabledTextColor(Color.darkGray);
			ivjJTextField.setPreferredSize(new Dimension(4, 20));
			ivjJTextField.setFont(new Font("Arial", Font.PLAIN, 12));
			ivjJTextField.setMinimumSize(new Dimension(4, 20));
		}
		return ivjJTextField;
	}

	/**
	 * Gets the keyMask property (int) value.
	 *
	 * @return The keyMask property value.
	 * @see #setKeyMask
	 */
	public KeyMask getKeyMask() {
		return fieldKeyMask;
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
	 * Gets the nullsSupported property (boolean) value.
	 *
	 * @return The nullsSupported property value.
	 * @see #setNullsSupported
	 */
	public boolean getNullsSupported() {
		return fieldNullsSupported;
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return PropertyChangeSupport
	 */
	protected PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return int
	 */
	public int getSelectionEnd() {
		return getJTextField().getSelectionEnd();
	}

	/**
	 * Method generated to support the promotion of the textFieldExtText
	 * attribute.
	 *
	 * @return String
	 */
	private String getText() {
		return getJTextField().getText();
	}

	/**
	 * Method generated to support the promotion of the textFont attribute.
	 *
	 * @return Font
	 */
	public Font getTextFont() {
		return getJTextField().getFont();
	}

	/**
	 * Gets the allowedKey property (int) value.
	 *
	 * @return The allowedKey property value.
	 * @see #setAllowedKey
	 */
	public AllowedKey getAllowedKey() {
		return fieldAllowedKey;
	}

	/**
	 * Method generated to support the promotion of the textFieldExtText
	 * attribute.
	 *
	 * @return String
	 */
	public String getValue() {
		AllowedKey tp = this.getAllowedKey();
		KeyMask km = this.getKeyMask();

		if (tp == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
			if (km == TextFieldExt.KeyMask.KM_Moneda)
				return StringTools.parseFromQuantityToNumber(this.getText().trim());
			else {
				if (km == TextFieldExt.KeyMask.KM_Numero)
					return StringTools.parseFromQuantityToNumber(this.getText().trim());
				else
					return this.getText().trim();
			}
		} else {
			if (tp == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
				if (km == TextFieldExt.KeyMask.KM_Moneda)
					return StringTools.parseFromQuantityToNumber(this.getText().trim());
				else {
					if (km == TextFieldExt.KeyMask.KM_Numero)
						return StringTools.parseFromQuantityToNumber(this.getText().trim());
					else
						return this.getText().trim();
				}
			} else
				return this.getText().trim();
		}
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws Exception {
		// user code begin {1}
		getJTextField().addMouseListener(this);
		getJTextField().addFocusListener(this);
		// user code end
		getJTextField().addPropertyChangeListener(this);
		this.addFocusListener(this);
		getJTextField().addActionListener(this);
		getJTextField().addFocusListener(this);
		getJTextField().addKeyListener(this);
		getJTextField().addMouseListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			setName("TextFieldExt");
			setPreferredSize(new Dimension(44, 20));
			setLayout(new GridBagLayout());
			setSize(118, 21);
			setMinimumSize(new Dimension(44, 20));
			GridBagConstraints constraintsJTextField = new GridBagConstraints();
			constraintsJTextField.gridx = 0;
			constraintsJTextField.gridy = 0;
			constraintsJTextField.fill = GridBagConstraints.BOTH;
			constraintsJTextField.weightx = 1.0;
			constraintsJTextField.weighty = 1.0;
			add(getJTextField(), constraintsJTextField);
			initConnections();
		} catch (Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return boolean
	 * @param unChar
	 *            char
	 */
	private boolean isAlfabetico(char unChar) {
		switch (unChar) {
		case 'A':
			return true;
		case 'B':
			return true;
		case 'C':
			return true;
		case 'D':
			return true;
		case 'E':
			return true;
		case 'F':
			return true;
		case 'G':
			return true;
		case 'H':
			return true;
		case 'I':
			return true;
		case 'J':
			return true;
		case 'K':
			return true;
		case 'L':
			return true;
		case 'M':
			return true;
		case 'N':
			return true;
		case 'Ñ':
			return true;
		case 'O':
			return true;
		case 'P':
			return true;
		case 'Q':
			return true;
		case 'R':
			return true;
		case 'S':
			return true;
		case 'T':
			return true;
		case 'U':
			return true;
		case 'V':
			return true;
		case 'W':
			return true;
		case 'X':
			return true;
		case 'Y':
			return true;
		case 'Z':
			return true;
		case 'a':
			return true;
		case 'b':
			return true;
		case 'c':
			return true;
		case 'd':
			return true;
		case 'e':
			return true;
		case 'f':
			return true;
		case 'g':
			return true;
		case 'h':
			return true;
		case 'i':
			return true;
		case 'j':
			return true;
		case 'k':
			return true;
		case 'l':
			return true;
		case 'm':
			return true;
		case 'n':
			return true;
		case 'ñ':
			return true;
		case 'o':
			return true;
		case 'p':
			return true;
		case 'q':
			return true;
		case 'r':
			return true;
		case 's':
			return true;
		case 't':
			return true;
		case 'u':
			return true;
		case 'v':
			return true;
		case 'w':
			return true;
		case 'x':
			return true;
		case 'y':
			return true;
		case 'z':
			return true;
		case ' ':
			return true;
		case '*':
			return true;// debido a búsquedas
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
			InfoView.showErrorDialog(this, "¡ Ingrese un texto !");
			//this.tipoPainter = PAINTER_ERROR;
			this.requestFocus();
			return true;
		}
		restorePainter();
		return false;
	}

	/**
	 *
	 * @param errorMessage
	 * @return
	 */
	public boolean isDataMissing(String errorMessage) {
		if ((getText() == null) || (getText().trim().compareTo("") == 0)) {
			InfoView.showErrorDialog(this, errorMessage);
			//this.tipoPainter = PAINTER_ERROR;
			this.requestFocus();
			return true;
		}
		restorePainter();
		return false;
	}

	public boolean isEditable() {
		return getJTextField().isEditable();
	}

	/**
	 * Method generated to support the promotion of the Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean isEnabled() {
		return getJTextField().isEnabled();
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return boolean
	 * @param unChar
	 *            char
	 */
	private boolean isNumerico(char unChar) {
		switch (unChar) {
		case '0':
			return true;
		case '1':
			return true;
		case '2':
			return true;
		case '3':
			return true;
		case '4':
			return true;
		case '5':
			return true;
		case '6':
			return true;
		case '7':
			return true;
		case '8':
			return true;
		case '9':
			return true;
		default:
			return false;
		}
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return boolean
	 * @param unChar
	 *            char
	 */
	private boolean isNumericoConFraccion(char unChar) {
		switch (unChar) {
		case '0':
			return true;
		case '1':
			return true;
		case '2':
			return true;
		case '3':
			return true;
		case '4':
			return true;
		case '5':
			return true;
		case '6':
			return true;
		case '7':
			return true;
		case '8':
			return true;
		case '9':
			return true;
		case '.':
			return dotCountValidate();
		default:
			return false;
		}
	}

	/**
	 * Insert the method's description here. Creation date: (25-Sep-2003
	 * 12:28:52 PM)
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
	 *            KeyEvent
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
	 *
	 * @param e
	 *            KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(KeyEvent e) {
		// user code begin {1}
		boolean numerico = false;
		if (((getText() == null) || (getText().trim().compareTo("") == 0)) && (!getNullsSupported())) {
			if ((getAllowedKey() == AllowedKey.AK_SOLO_NUMEROS) || (getAllowedKey() == AllowedKey.AK_NUMEROS_CON_FRACCION)) {
				// AK_SOLO_NUMEROS o AK_NUMEROS_CON_FRACCION
				numerico = true;
				// setValue(new Integer(0).toString());
			}
		}
		// user code end
		if (e.getSource() == getJTextField())
			connEtoC8(e);
		if (e.getSource() == getJTextField())
			connEtoC2(e);
		// user code begin {2}
		if (numerico)
			setValue("");
		// user code end
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 *
	 * @param e
	 *            KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyTyped(KeyEvent e) {
		// user code begin {1}
		switch (e.getKeyChar()) {
		case KeyEvent.VK_ENTER:
			break;
		case KeyEvent.VK_BACK_SPACE:
			break;
		case KeyEvent.VK_TAB:
			break;
		case KeyEvent.VK_SHIFT:
			break;
		case KeyEvent.VK_CONTROL:
			break;
		case KeyEvent.VK_ALT:
			break;
		case KeyEvent.VK_CAPS_LOCK:
			break;
		case KeyEvent.VK_END:
			break;
		case KeyEvent.VK_HOME:
			break;
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_DOWN:
			break;
		case KeyEvent.VK_DELETE:
			break;
		case KeyEvent.VK_NUM_LOCK:
			break;
		default:
			if (getAllowedKey() == TextFieldExt.AllowedKey.AK_ALFANUMERICOS) {
				if (getMaxLength() == 0) {
					validaKeyMask(e);
				} else {
					if (getJTextField().getSelectedText() != null || getJTextField().getText().length() < getMaxLength()) {
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
					if (getJTextField().getSelectedText() != null || getJTextField().getText().length() < getMaxLength()) {
						validaKeyMask(e);
					} else {
						e.setKeyChar('\0');
						e.setKeyCode(0);
					}
				}
			}
			break;
		}
		restorePainter();
	}

	private void manageTextSelectionOnFocusGained() {
		if (isSeleccionarAlRecibirElFoco())
			this.seleccionar();
	}

	public void mouseClicked(MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJTextField())
			connEtoC11(e);
		// user code begin {2}
		// user code end
	}

	public void mouseEntered(MouseEvent e) {
		if (isEnabled() && isEditable())
			getJTextField().setCursor(new Cursor(Cursor.TEXT_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		getJTextField().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
	 * @param pos
	 *            int
	 */
	public void moveCaretPosition(int pos) {
		getJTextField().moveCaretPosition(pos);
	}

	private void parseValue() {

		if (this.getJTextField().getText().trim().length() == 0)
			return;

		AllowedKey ak = this.getAllowedKey();
		KeyMask km = this.getKeyMask();

		if (ak == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
			if (km == TextFieldExt.KeyMask.KM_Moneda) {
				this.getJTextField().setText("$" + StringTools.parseFromNumberToInteger(this.getJTextField().getText().trim()));
			} else {
				if (km == TextFieldExt.KeyMask.KM_Numero) {
					this.getJTextField().setText(StringTools.parseFromNumberToInteger(this.getJTextField().getText().trim()));
				}
			}
		} else {
			if (ak == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
				if (km == TextFieldExt.KeyMask.KM_Moneda) {
					this.getJTextField().setText(
							StringTools.parseFromNumberToMoney(
									new BigDecimal(StringTools.parseOnlyNumbers(this.getJTextField().getText().trim())), getDecimales()));
				} else {
					if (km == TextFieldExt.KeyMask.KM_Numero) {
						this.getJTextField().setText(
								StringTools.parseFromNumberToQuantity(
										new BigDecimal(StringTools.parseOnlyNumbers(this.getJTextField().getText().trim())), getDecimales()));
					}
				}
			}
		}
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 *
	 * @param evt
	 *            PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getJTextField() && (evt.getPropertyName().equals("horizontalAlignment")))
			connEtoC3(evt);
		if (evt.getSource() == getJTextField() && (evt.getPropertyName().equals("focusAccelerator")))
			connEtoC4(evt);
		// user code begin {2}
		// user code end
	}

	private void refreshValue() {

		this.setValue(this.getValue());
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 *
	 * @param newListener
	 *            TextFieldExtListener
	 */
	public void removeTextFieldExtListener(TextFieldExtListener newListener) {
		fieldTextFieldExtListenerEventMulticaster =
			TextFieldExtListenerEventMulticaster.remove(fieldTextFieldExtListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * Comment
	 */
	public void seleccionar() {
		getJTextField().setSelectionStart(0);
		getJTextField().setSelectionEnd(getText().length());
	}

	/**
	 *
	 * @param selectionStart
	 *            int
	 * @param selectionEnd
	 *            int
	 */
	public void select(int selectionStart, int selectionEnd) {
		getJTextField().select(selectionStart, selectionEnd);
	}

	/**
	 * Sets the aceptarKeyLikeTabKey property (boolean) value.
	 *
	 * @param aceptarKeyLikeTabKey
	 *            The new value for the property.
	 * @see #getAceptarKeyLikeTabKey
	 */
	public void setAceptarKeyLikeTabKey(boolean aceptarKeyLikeTabKey) {
		boolean oldValue = fieldAceptarKeyLikeTabKey;
		fieldAceptarKeyLikeTabKey = aceptarKeyLikeTabKey;
		firePropertyChange("aceptarKeyLikeTabKey", new Boolean(oldValue), new Boolean(aceptarKeyLikeTabKey));
	}

	public void setBGColor(Color c) {
		getJTextField().setBackground(c);
	}

	/**
	 * Method generated to support the promotion of the caretPosition attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setCaretPosition(int arg1) {
		getJTextField().setCaretPosition(arg1);
	}

	/**
	 * Method generated to support the promotion of the columns attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setColumns(int arg1) {
		getJTextField().setColumns(arg1);
	}

	/**
	 * Sets the dataValidateOnFocusLost property (boolean) value.
	 *
	 * @param dataValidateOnFocusLost
	 *            The new value for the property.
	 * @see #getDataValidateOnFocusLost
	 */
	public void setDataValidateOnFocusLost(boolean dataValidateOnFocusLost) {
		boolean oldValue = fieldDataValidateOnFocusLost;
		fieldDataValidateOnFocusLost = dataValidateOnFocusLost;
		firePropertyChange("dataValidateOnFocusLost", new Boolean(oldValue), new Boolean(dataValidateOnFocusLost));
	}

	/**
	 * Inserte aquí la descripción del método. Fecha de creación: (08/03/2005
	 * 14:20:03)
	 *
	 * @param newDecimales
	 *            int
	 */
	public void setDecimales(int newDecimales) {
		decimales = newDecimales;
	}

	/**
	 * Method generated to support the promotion of the disabledTextColor
	 * attribute.
	 *
	 * @param arg1
	 *            Color
	 */
	public void setDisabledTextColor(Color arg1) {
		getJTextField().setDisabledTextColor(arg1);
	}

	public void setEditable(boolean aBool) {
		getJTextField().setEditable(aBool);
	}

	public void setEnabled(boolean aBool) {
		getJTextField().setEnabled(aBool);
		// getJTextField().setOpaque(!aBool);
		if (aBool)
			getJTextField().setBackground(Color.white);
		else
			getJTextField().setBackground(new Color(231, 231, 231));
	}

	/**
	 * Sets the error property (Boolean) value.
	 *
	 * @param error
	 *            The new value for the property.
	 * @see #getError
	 */
	public void setError(Boolean error) {
		Boolean oldValue = fieldError;
		fieldError = error;
		firePropertyChange("error", oldValue, error);
	}

	/**
	 * Sets the errorDescription property (String) value.
	 *
	 * @param errorDescription
	 *            The new value for the property.
	 * @see #getErrorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		fieldErrorDescription = errorDescription;
	}

	/**
	 * Method generated to support the promotion of the focusAccelerator
	 * attribute.
	 *
	 * @param arg1
	 *            char
	 */
	public void setFocusAccelerator(char arg1) {
		getJTextField().setFocusAccelerator(arg1);
	}

	public void setFont(Font aFont) {
		super.setFont(aFont);

		getJTextField().setFont(aFont);
	}

	public void setForeground(Color c) {
		super.setForeground(c);
		getJTextField().setForeground(c);
	}

	/**
	 *
	 */
	public void setHorizontalAlignment(int alignment) {
		getJTextField().setHorizontalAlignment(alignment);
	}

	/**
	 *
	 */
	public void setHorizontalTextAlignment(int arg1) {
		getJTextField().setHorizontalAlignment(arg1);
	}

	/**
	 *
	 */
	public void setKeyMask(KeyMask keyMask) {
		KeyMask oldValue = fieldKeyMask;
		fieldKeyMask = keyMask;
		firePropertyChange("keyMask", oldValue, keyMask);
		// ...
		this.setValue(this.getValue());
		if (keyMask == TextFieldExt.KeyMask.KM_Moneda || keyMask == TextFieldExt.KeyMask.KM_Numero) {
			this.setHorizontalAlignment(JTextField.RIGHT);
			this.setMaxLength(this.getMaxLength() + 20);
		} else
			this.setHorizontalAlignment(JTextField.LEFT);
	}

	/**
	 *
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
	 *
	 */
	public void setNullsSupported(boolean nullsSupported) {
		boolean oldValue = fieldNullsSupported;
		fieldNullsSupported = nullsSupported;
		firePropertyChange("nullsSupported", new Boolean(oldValue), new Boolean(nullsSupported));
	}

	/**
	 *
	 */
	public void setSeleccionarAlRecibirElFoco(boolean newSeleccionarAlRecibirElFoco) {
		seleccionarAlRecibirElFoco = newSeleccionarAlRecibirElFoco;
	}

	/**
	 *
	 */
	public void setSelectionEnd(int selectionEnd) {
		getJTextField().setSelectionEnd(selectionEnd);
	}

	/**
	 *
	 */
	public void setSelectionStart(int selectionStart) {
		getJTextField().setSelectionStart(selectionStart);
	}

	/**
	 *
	 */
	public void setTextFont(Font arg1) {
		getJTextField().setFont(arg1);
	}
	/**
	 *
	 */
	public void setAllowedKey(AllowedKey allowedKey) {
		AllowedKey oldValue = fieldAllowedKey;
		fieldAllowedKey = allowedKey;
		firePropertyChange("allowedKey", oldValue, allowedKey);
		// ...
		this.setValue(this.getValue());
		if (allowedKey == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS || allowedKey == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
			this.setHorizontalAlignment(JTextField.RIGHT);
			this.setMaxLength(this.getMaxLength() + 20);
		} else
			this.setHorizontalAlignment(JTextField.LEFT);
	}
	/**
	 *
	 */
	public void setValue(String arg1) {

		if (arg1 == null || arg1.trim().compareTo("null") == 0) {
			getJTextField().setText("");
			return;
		}

		AllowedKey tp = this.getAllowedKey();
		KeyMask km = this.getKeyMask();

		if (tp == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS) {
			if (km == TextFieldExt.KeyMask.KM_Moneda) {
				if (this.getJTextField().getText().trim().length() == 0)
					this.getJTextField().setText("");
				else
					this.getJTextField().setText("$" + StringTools.parseFromNumberToInteger(this.getJTextField().getText().trim()));
			} else {
				if (km == TextFieldExt.KeyMask.KM_Numero) {
					if (arg1.trim().length() == 0)
						this.getJTextField().setText("");
					else
						this.getJTextField().setText(StringTools.parseFromNumberToInteger(arg1.trim()));
				} else
					getJTextField().setText(arg1);
			}
		} else {
			if (tp == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION) {
				if (km == TextFieldExt.KeyMask.KM_Moneda) {
					if (arg1.trim().length() == 0)
						this.getJTextField().setText("");
					else
						this.getJTextField().setText(StringTools.parseFromNumberToMoney(new BigDecimal(arg1.trim()), getDecimales()));
				} else {
					if (km == TextFieldExt.KeyMask.KM_Numero) {
						if (arg1.trim().length() == 0)
							this.getJTextField().setText("");
						else
							this.getJTextField().setText(
									StringTools.parseFromNumberToQuantity(new BigDecimal(StringTools.parseFromMoneyToNumber(arg1.trim())),
											getDecimales()));
					} else
						getJTextField().setText(arg1);
				}
			} else
				getJTextField().setText(arg1);
		}
		// restorePainter();
	}
	/**
	 *
	 */
	public String SQLFullText() {

		return " '" + getText().trim().replace('*', '%').toUpperCase() + "%' ";
	}
	/**
	 *
	 */
	public String SQLText() {
		if (getText() == null || getText().trim().length() == 0)
			return " NULL ";
		else {
			if (getAllowedKey() == TextFieldExt.AllowedKey.AK_SOLO_NUMEROS || getAllowedKey() == TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION)
				return " " + StringTools.parseComilla(getValue().trim()) + " ";
			else
				return " '" + StringTools.parseComilla(getValue().trim()) + "' ";
		}
	}
	/**
	 *
	 */
	private void validaKeyMask(KeyEvent e) {
		if (isAlfabetico(e.getKeyChar())) {
			switch (getKeyMask()) {
			case KM_MAYUSCULAS:
				char unChar[] = { e.getKeyChar() };
				String unString = new String(unChar);
				unString = unString.toUpperCase();
				e.setKeyChar(unString.charAt(0));
				break;
			case KM_minusculas:
				char chars[] = { e.getKeyChar() };
				unString = new String(chars);
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
	 *
	 */
	private void validaAllowedKey(KeyEvent e) {
		switch (getAllowedKey()) {
		case AK_SOLO_NUMEROS:
			if (!(isNumerico(e.getKeyChar()))) {
				e.setKeyChar('\0');
				return;
			}
			break;
		case AK_NUMEROS_CON_FRACCION:
			if (!(isNumericoConFraccion(e.getKeyChar()))) {
				e.setKeyChar('\0');
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
		getJTextField().setBackground(unColor);
	}
	/**
	 *
	 */
	public void setBorder(Border border) {
		//super.setBorder(border);
		getJTextField().setBorder(border);
	}
	/**
	 *
	 */
/*
 	public int getTipoPainter() { return tipoPainter; } public void
	setTipoPainter(int tipoPaint) { this.tipoPainter = tipoPaint; }
*/
	/**
	 *
	 */
	public void requestFocus() {
		getJTextField().requestFocus();
	}

	/**
	 *
	 */
	public void setToPainterDEFAULT() {
		//this.tipoPainter_original = PAINTER_DEFAULT;
	}

	public void setToPainterERROR() {
		//this.tipoPainter_original = PAINTER_ERROR;
	}

	/**
	 *
	 */
	public void restorePainter() {
		//this.tipoPainter = this.tipoPainter_original;
	}
}
