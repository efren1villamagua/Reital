package efren.util.gui.dialogs;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.plaf.OptionPaneUI;

/**
 * InfoView makes it easy to pop up a standard dialog box that prompts users for
 * a value or informs them of something. While the class may appear complex
 * because of the large number of methods, almost all uses of this class are
 * one-line calls to one of the static <code>showXxxDialog</code> methods
 * shown below: <blockquote> <table>
 * <tr align=top>
 * <td>showConfirmDialog
 * <td>Asks a confirming question, like yes/no/cancel.
 * <tr align=top>
 * <td>showInputDialog
 * <td>Prompt for some input.
 * <tr align=top>
 * <td>showMessageDialog
 * <td>Tell the user about something that has happened.
 * <tr align=top>
 * <td>showOptionDialog
 * <td>The Grand Unification of the above three. </table> </blockquote> Each of
 * these methods also comes in a <code>showInternalXXX</code> flavor, which
 * uses an internal frame to hold the dialog box (see <a
 * href=javax.swing.JInternalFrame.html>JInternalFrame</a>). Multiple
 * convenience methods have also been defined -- overloaded versions of the
 * basic methods that use different parameter lists.
 * <p>
 * All dialogs are modal. Each <code>showXxxDialog</code> method blocks the
 * current thread until the user's interaction is complete.
 * <p>
 * <table cellspacing=6 cellpadding=4 border=0 align=right>
 * <tr>
 * <td bgcolor=#FFe0d0 rowspan=2> icon
 * <td bgcolor=#FFe0d0> message
 * <tr>
 * <td bgcolor=#FFe0d0> input value
 * <tr>
 * <td bgcolor=#FFe0d0 colspan=2> option buttons </table> The basic appearance
 * of one of these dialog boxes is generally similar to the picture at the
 * right, although the various look-and-feels are ultimatly responsible for the
 * final result. <br clear=all>
 * <p>
 * <b>Parameters:</b><br>
 * The parameters to these methods follow consistent patterns: <blockquote>
 * <dl compact>
 * <dt>parentComponent
 * <dd> Defines the Component that is to be the parent of this dialog box. It is
 * used in two ways: the Frame that contains it is used as the Frame parent for
 * the dialog box, and its screen coordinates are used in the placement of the
 * dialog box. In general, the dialog box is placed just below the component.
 * This parameter may be null, in which case a default Frame is used as the
 * parent, and the dialog will be centered on the screen (depending on the L&F).
 * <dt><a name=message>message</a>
 * <dd> A descriptive message to be placed in the dialog box };<br>
 * InfoView.showOptionDialog(null, "Click OK to continue", "Warning",
 * <ul>
 * <ul>
 * DEFAULT_OPTION, WARNING_MESSAGE,
 * </ul>
 * </ul>
 * <ul>
 * <ul>
 * null, options, options[0]);
 * </ul>
 * </ul>
 * </code>
 * <p>
 * <dt>Show a dialog asking the user to type in a String:
 * <dd><code> String inputValue = InfoView.showInputDialog("Please input a
 * value"); </code>
 * <p>
 * <dt>Show a dialog asking the user to select a String:
 * <dd><code> Object[] possibleValues = { "First", "Second", "Third" };<br>
 * Object selectedValue = JOptionDialog.showInputDialog(null,
 * <ul>
 * <ul>
 * "Choose one", "Input",
 * </ul>
 * </ul>
 * <ul>
 * <ul>
 * InfoView.INFORMATION_DIALOG, null,
 * </ul>
 * </ul>
 * <ul>
 * <ul>
 * possibleValues, possibleValues[0]);
 * </ul>
 * </ul>
 * </code>
 * <p>
 * </dl>
 * <b>Direct Use:</b><br>
 * To create and use an InfoView directly, the standard pattern is roughly as
 * follows:
 * 
 * <pre>
 *     InfoView pane = new InfoView(&lt;i&gt;arguments&lt;/i&gt;);
 *     pane.set&lt;i&gt;.Xxxx(...); // Configure&lt;/i&gt;
 *     JDialog dialog = pane.createDialog(&lt;i&gt;parentComponent, title&lt;/i&gt;);
 *     dialog.show();
 *     Object selectedValue = pane.getValue();
 *     if(selectedValue == null)
 *       return CLOSED_OPTION;
 *     &lt;i&gt;//If there is &lt;b&gt;not&lt;/b&gt; an array of option buttons:&lt;/i&gt;
 *     if(options == null) {
 *       if(selectedValue instanceof Integer)
 *          return ((Integer)selectedValue).intValue();
 *       return CLOSED_OPTION;
 *     }
 *     &lt;i&gt;//If there is an array of option buttons:&lt;/i&gt;
 *     for(int counter = 0, maxCounter = options.length;
 *        counter &lt; maxCounter; counter++) {
 *        if(options[counter].equals(selectedValue))
 *        return counter;
 *     }
 *     return CLOSED_OPTION;
 * </pre>
 * 
 * <p>
 * For the keyboard keys used by this component in the standard Look and Feel
 * (L&F) renditions, see the <a
 * href="doc-files/Key-Index.html#InfoView">InfoView</a> key assignments.
 * <p>
 * Warning: serialized objects of this class will not be compatible with future
 * swing releases. The current serialization support is appropriate for short
 * term storage or RMI between Swing1.0 applications. It will not be possible to
 * load serialized Swing1.0 objects with future releases of Swing. The JDK1.2
 * release of Swing will be the compatibility baseline for the serialized form
 * of Swing objects.
 * 
 * @see JInternalFrame
 * 
 * @beaninfo attribute: isContainer true description: A component which
 *           implements standard dialog box controls.
 * 
 */

public class InfoView extends JOptionPane implements java.awt.event.MouseListener {
	/**
	 * Indicates that the user has not yet selected a value.
	 */
	public static final Object UNINITIALIZED_VALUE = "uninitializedValue";

	//
	// Option types
	//
	/**
	 * Type meaning look and feel should not supply any options -- only use the
	 * options from the InfoView.
	 */
	public static final int DEFAULT_OPTION = -1;

	/** Type used for showConfirmDialog. */
	public static final int YES_NO_OPTION = 0;

	/** Type used for showConfirmDialog. */
	public static final int YES_NO_CANCEL_OPTION = 1;

	/** Type used for showConfirmDialog. */
	public static final int OK_CANCEL_OPTION = 2;

	//
	// Return values.
	//
	/** Return value from class method if YES is chosen. */
	public static final int YES_OPTION = 0;

	/** Return value from class method if NO is chosen. */
	public static final int NO_OPTION = 1;

	/** Return value from class method if CANCEL is chosen. */
	public static final int CANCEL_OPTION = 2;

	/** Return value form class method if OK is chosen. */
	public static final int OK_OPTION = 0;

	/**
	 * Return value from class method if user closes window without selecting
	 * anything, more than likely this should be treated as either a
	 * CANCEL_OPTION or NO_OPTION.
	 */
	public static final int CLOSED_OPTION = -1;

	//
	// Message types. Used by the UI to determine what icon to display,
	// and possibly what behavior to give based on the type.
	//
	/** Used for error messages. */
	public static final int ERROR_MESSAGE = 0;

	/** Used for information messages. */
	public static final int INFORMATION_MESSAGE = 1;

	/** Used for warning messages. */
	public static final int WARNING_MESSAGE = 2;

	/** Used for questions. */
	public static final int QUESTION_MESSAGE = 3;

	/** No icon is used. */
	public static final int PLAIN_MESSAGE = -1;

	/** Bound property name for icon. */
	public static final String ICON_PROPERTY = "icon";

	/** Bound property name for message. */
	public static final String MESSAGE_PROPERTY = "message";

	/** Bounds property name for value. */
	public static final String VALUE_PROPERTY = "value";

	/** Bounds property namer for option. */
	public static final String OPTIONS_PROPERTY = "options";

	/** Bounds property name for initialValue. */
	public static final String INITIAL_VALUE_PROPERTY = "initialValue";

	/** Bounds property name for type. */
	public static final String MESSAGE_TYPE_PROPERTY = "messageType";

	/** Bound property name for optionType. */
	public static final String OPTION_TYPE_PROPERTY = "optionType";

	/** Bound property name for selectionValues. */
	public static final String SELECTION_VALUES_PROPERTY = "selectionValues";

	/** Bound property name for initialSelectionValue. */
	public static final String INITIAL_SELECTION_VALUE_PROPERTY = "initialSelectionValue";

	/** Bound property name for inputValue. */
	public static final String INPUT_VALUE_PROPERTY = "inputValue";

	/** Bound property name for wantsInput. */
	public static final String WANTS_INPUT_PROPERTY = "wantsInput";

	/** Icon used in pane. */
	transient protected Icon icon;

	/** Message to display. */
	transient protected Object message;

	/** Options to display to the user. */
	transient protected Object[] options;

	/** Value that should be initialy selected in options. */
	transient protected Object initialValue;

	/** Message type. */
	protected int messageType;

	/**
	 * Option type, one of DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION
	 * or OK_CANCEL_OPTION.
	 */
	protected int optionType;

	/**
	 * Currently selected value, will be a valid option, or UNINITIALIZED_VALUE
	 * or null.
	 */
	transient protected Object value;

	/**
	 * Array of values the user can choose from. Look and feel will provide the
	 * UI component to choose this from.
	 */
	protected transient Object[] selectionValues;

	/** Value the user has input. */
	protected transient Object inputValue;

	/** Initial value to select in selectionValues. */
	protected transient Object initialSelectionValue;

	/** If true, a UI widget will be provided to the user to get input. */
	protected boolean wantsInput;

	//private static final Object sharedFrameKey = InfoView.class;

	private java.util.Vector<JButton> buttons1 = new java.util.Vector<JButton>();

	/**
	 * Creates a InfoView with a test message.
	 */
	public InfoView() {
		this("Mensaje de prueba desde InfoView");
	}

	/**
	 * Creates a instance of InfoView to display a message using the
	 * plain-message message type and the default options delivered by the UI.
	 * 
	 * @param message
	 *            the Object to display
	 */
	public InfoView(Object message) {
		this(message, PLAIN_MESSAGE);
	}

	/**
	 * Creates an instance of InfoView to display a message with the specified
	 * message type and the default options,
	 * 
	 * @param message
	 *            the Object to display
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public InfoView(Object message, int messageType) {
		this(message, messageType, DEFAULT_OPTION);
	}

	/**
	 * Creates an instance of InfoView to display a message with the specified
	 * message type and options.
	 * 
	 * @param message
	 *            the Object to display
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param optionType
	 *            the options to display in the pane: DEFAULT_OPTION,
	 *            YES_NO_OPTION, YES_NO_CANCEL_OPTION OK_CANCEL_OPTION
	 */
	public InfoView(Object message, int messageType, int optionType) {
		this(message, messageType, optionType, null);
	}

	/**
	 * Creates an instance of InfoView to display a message with the specified
	 * message type, options, and icon.
	 * 
	 * @param message
	 *            the Object to display
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param optionType
	 *            the options to display in the pane: DEFAULT_OPTION,
	 *            YES_NO_OPTION, YES_NO_CANCEL_OPTION OK_CANCEL_OPTION
	 * @param icon
	 *            the Icon image to display
	 */
	public InfoView(Object message, int messageType, int optionType, Icon icon) {
		this(message, messageType, optionType, icon, null);
	}

	/**
	 * Creates an instance of InfoView to display a message with the specified
	 * message type, icon, and options. None of the options is initially
	 * selected.
	 * <p>
	 * The options objects should contain either instances of Components, (which
	 * are added directly) or Strings (which are wrapped in a JButton). If you
	 * provide Components, you must ensure that when the Component is clicked it
	 * messages <code>setValue</code> in the created InfoView.
	 * 
	 * @param message
	 *            the Object to display
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param optionType
	 *            the options to display in the pane: DEFAULT_OPTION,
	 *            YES_NO_OPTION, YES_NO_CANCEL_OPTION OK_CANCEL_OPTION. Only
	 *            meaningful if the <code>options</code> parameter is null.
	 * @param icon
	 *            the Icon image to display
	 * @param options
	 *            the choices the user can select
	 */
	public InfoView(Object message, int messageType, int optionType, Icon icon, Object[] options) {
		this(message, messageType, optionType, icon, options, null);
	}

	/**
	 * Creates an instance of InfoView to display a message with the specified
	 * message type, icon, and options, with the inititially-selected option
	 * specified.
	 * 
	 * @param message
	 *            the Object to display
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param optionType
	 *            the options to display in the pane: DEFAULT_OPTION,
	 *            YES_NO_OPTION, YES_NO_CANCEL_OPTION OK_CANCEL_OPTION. Only
	 *            meaningful if the <code>options</code> parameter is null.
	 * @param icon
	 *            the Icon image to display
	 * @param options
	 *            the choices the user can select
	 * @param initialValue
	 *            the choice that is initially selected
	 */
	public InfoView(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue) {
		this.message = message;
		this.options = options;
		this.initialValue = initialValue;
		this.icon = icon;
		setMessageType(messageType);
		setOptionType(optionType);
		value = UNINITIALIZED_VALUE;
		inputValue = UNINITIALIZED_VALUE;
		updateUI();
	}

	private void addMouseListenerForButtons() {
		try {

			Object[] botones = ((efren.util.gui.dialogs.OptionPaneUI) getUI()).getButtons();
			for (int i = 0; i < botones.length; i++) {
				if (botones[i] instanceof JButton) {
					JButton button0 = (JButton) botones[i];
					button0.addMouseListener(this);
					buttons1.addElement(button0);
				}
			}

		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 * Creates and returns a new JDialog wrapping <code>this</code> centered
	 * on the <code>parentComponent</code> in the <code>parentComponent</code>'s
	 * frame. <code>title</code> is the title of the returned dialog. The
	 * returned JDialog will be set up such that once it is closed, or the user
	 * clicks on the OK button, the dialog will be disposed and closed. Re if
	 * the parentComponent has no Frame, a default Frame is used.
	 * 
	 * @param title
	 *            the title string for the dialog
	 * @return a new JDialog containing this instance
	 */
	public JDialog createDialog(Component parentComponent, String title) {
		return super.createDialog(parentComponent, title);
	}

	/**
	 * Creates and returns an instance of JInternalFrame. The internal frame is
	 * created with the specified title, and wrapping the InfoView. The returned
	 * JInternalFrame is added to the JDesktopPane ancestor of parentComponent,
	 * or components parent if one its ancestors isn't a JDesktopPane, or if
	 * parentComponent doesn't have a parent then a
	 * <code>RuntimeException</code> is thrown.
	 * 
	 * @param parentComponent
	 *            the parent Component for the internal frame
	 * @param title
	 *            the String to display in the frame's title bar
	 * @return a JInternalFrame containing a InfoView
	 */
	public JInternalFrame createInternalFrame(Component parentComponent, String title) {
		return super.createInternalFrame(parentComponent, title);
	}

	/**
	 * Returns the specified component's desktop pane.
	 * 
	 * @param parentComponent
	 *            the Component to check for a desktop
	 * @return the JDesktopPane that contains the component, or null if the
	 *         component is null or does not have an ancestor that is a
	 *         JInternalFrame
	 */
	public static JDesktopPane getDesktopPaneForComponent(Component parentComponent) {
		if (parentComponent == null)
			return null;
		if (parentComponent instanceof JDesktopPane)
			return (JDesktopPane) parentComponent;
		return getDesktopPaneForComponent(parentComponent.getParent());
	}

	/**
	 * Returns the specified component's Frame.
	 * 
	 * @param parentComponent
	 *            the Component to check for a Frame
	 * @return the Frame that contains the component, or the default frame if
	 *         the component is null, or does not have a valid Frame parent
	 */
	public static Frame getFrameForComponent(Component parentComponent) {
		if (parentComponent == null)
			return getRootFrame();
		if (parentComponent instanceof Frame)
			return (Frame) parentComponent;
		return InfoView.getFrameForComponent(parentComponent.getParent());
	}

	/**
	 * Returns the icon this pane displays.
	 * 
	 * @return the Icon that is displayed
	 * 
	 * @see #setIcon
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * Returns the initial-selection value..
	 * 
	 * @return the initially selected value
	 * @see #setInitialSelectionValue
	 * @see #setSelectionValues
	 */
	public Object getInitialSelectionValue() {
		return initialSelectionValue;
	}

	/**
	 * Returns the initial value.
	 * 
	 * @return the Object that gets the initial keyboard focus
	 * 
	 * @see #setInitialValue
	 */
	public Object getInitialValue() {
		return initialValue;
	}

	/**
	 * Returns the value the user has input, if <code>wantsInput</code> is
	 * true.
	 * 
	 * @return the Object the user specified, if it was one of the objects, or a
	 *         String if it was a value typed into a field.
	 * @see #setSelectionValues
	 * @see #setWantsInput
	 * @see #setInputValue
	 */
	public Object getInputValue() {
		return inputValue;
	}

	/**
	 * Returns the maximum number of characters to place on a line in a message.
	 * Default is to return Integer.MAX_VALUE. The value can be changed by
	 * overriding this method in a subclasse.
	 * 
	 * @return an int giving the maximum number of characters on a line
	 */
	public int getMaxCharactersPerLineCount() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the message-object this pane displays.
	 * 
	 * @see #setMessage
	 * 
	 * @return the Object that is displayed
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * Returns the message type.
	 * 
	 * @return an int specifying the message type
	 * 
	 * @see #setMessageType
	 */
	public int getMessageType() {
		return messageType;
	}

	/**
	 * Returns the choices the user can make.
	 * 
	 * @param the
	 *            array of Objects that give the user's choices
	 * 
	 * @see #setOptions
	 */
	public Object[] getOptions() {
		if (options != null) {
			int optionCount = options.length;
			Object[] retOptions = new Object[optionCount];

			System.arraycopy(options, 0, retOptions, 0, optionCount);
			return retOptions;
		}
		return options;
	}

	/**
	 * Returns the type of options that are displayed.
	 * 
	 * @return an int specifying the user-selectable options
	 * 
	 * @see #setOptionType
	 */
	public int getOptionType() {
		return optionType;
	}

	/**
	 * Returns the Frame to use for the class methods in which a frame is not
	 * provided.
	 * 
	 * @return the default Frame to use
	 */
	// tsModified
	public static Frame getRootFrame() {
		return JOptionPane.getRootFrame();
	}

	/**
	 * Returns the selection values.
	 * 
	 * @param return
	 *            the array of Objects the user can select
	 * @see #setSelectionValues
	 */
	public Object[] getSelectionValues() {
		return selectionValues;
	}

	/**
	 * Returns the UI object which implements the L&F for this component.
	 * 
	 * @return the OptionPaneUI object
	 */
	public OptionPaneUI getUI() {
		return (OptionPaneUI) ui;
	}

	/**
	 * Returns the name of the UI class that implements the L&F for this
	 * component.
	 * 
	 * @return "OptionPaneUI"
	 * @see JComponent#getUIClassID
	 * @see UIDefaults#getUI
	 */
	public String getUIClassID() {
		return "OptionPaneUI";
	}

	/**
	 * Returns the value the user has selected. UNINITIALIZED_VALUE implies the
	 * user has not yet made a choice, null means the user closed the window
	 * with out chosing anything. Otherwise the returned value will be one of
	 * the options defined in this object.
	 * 
	 * @return the Object chosen by the user, UNINITIALIZED_VALUE if the user
	 *         has not yet made a choice, or null if the user closed the window
	 *         without making a choice.
	 * 
	 * @see #setValue
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Returns true if a parentComponent will be provided for the user to input.
	 * 
	 * @return true if a parentComponent will be provided
	 * @see #setWantsInput
	 */
	public boolean getWantsInput() {
		return wantsInput;
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		for (int i = 0; i < buttons1.size(); i++) {
			((javax.swing.JButton) buttons1.elementAt(i)).setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			repaint();
		}
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		for (int i = 0; i < buttons1.size(); i++) {
			((javax.swing.JButton) buttons1.elementAt(i)).setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			repaint();
		}
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		Vector values = (Vector) s.readObject();
		int indexCounter = 0;
		int maxCounter = values.size();

		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("icon")) {
			icon = (Icon) values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("message")) {
			message = values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("options")) {
			options = (Object[]) values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("initialValue")) {
			initialValue = values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("value")) {
			value = values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("selectionValues")) {
			selectionValues = (Object[]) values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("inputValue")) {
			inputValue = values.elementAt(++indexCounter);
			indexCounter++;
		}
		if (indexCounter < maxCounter && values.elementAt(indexCounter).equals("initialSelectionValue")) {
			initialSelectionValue = values.elementAt(++indexCounter);
			indexCounter++;
		}
	}

	/**
	 * Requests that the initial value be selected, which will set focus to the
	 * initial value. This method should be invoked after the window containing
	 * the option pane is made visible.
	 */
	public void selectInitialValue() {
		OptionPaneUI ui = getUI();

		if (ui != null)
			ui.selectInitialValue(this);
	}

	/**
	 * Sets the icon to display. If non-null, the look and feel does not provide
	 * an icon.
	 * 
	 * @param icon
	 *            the Icon to display
	 * 
	 * @see #getIcon
	 * @beaninfo preferred: true bound: true description: The option pane's type
	 *           icon.
	 */
	public void setIcon(Icon newIcon) {
		Object oldIcon = icon;

		icon = newIcon;
		firePropertyChange(ICON_PROPERTY, oldIcon, icon);
	}

	/**
	 * Sets the initial selection value. Only used if <code>wantsInput</code>
	 * is true.
	 * 
	 * @param newValue
	 *            the initially selected value
	 * @see #setSelectionValues
	 * @see #getInitialSelectionValue
	 * @beaninfo bound: true description: The option pane's initial selection
	 *           value object.
	 */
	public void setInitialSelectionValue(Object newValue) {
		Object oldValue = initialSelectionValue;

		initialSelectionValue = newValue;
		firePropertyChange(INITIAL_SELECTION_VALUE_PROPERTY, oldValue, newValue);
	}

	/**
	 * Sets the initial value that is to be enabled -- the Component that has
	 * the focus when the pane is initially displayed.
	 * 
	 * @param newInitialValue
	 *            the Object that gets the initial keyboard focus
	 * 
	 * @see #getInitialValue
	 * @beaninfo preferred: true bound: true description: The option pane's
	 *           initial value object.
	 */
	public void setInitialValue(Object newInitialValue) {
		Object oldIV = initialValue;

		initialValue = newInitialValue;
		firePropertyChange(INITIAL_VALUE_PROPERTY, oldIV, initialValue);
	}

	/**
	 * Sets the user's input-value.
	 * 
	 * @param newValue
	 *            the Object used to initialized the value that the user
	 *            specified (usually in a text field)
	 * @see #setSelectionValues
	 * @see #setWantsInput
	 * @see #getInputValue
	 * @beaninfo preferred: true bound: true description: The option pane's
	 *           input value object.
	 */
	public void setInputValue(Object newValue) {
		Object oldValue = inputValue;

		inputValue = newValue;
		firePropertyChange(INPUT_VALUE_PROPERTY, oldValue, newValue);
	}

	/**
	 * Sets the option pane's message-object.
	 * 
	 * @param newMessage
	 *            the Object to display
	 * @see #getMessage
	 * 
	 * @beaninfo preferred: true bound: true description: The optionpane's
	 *           message object.
	 */
	public void setMessage(Object newMessage) {
		Object oldMessage = message;

		message = newMessage;
		firePropertyChange(MESSAGE_PROPERTY, oldMessage, message);
	}

	/**
	 * Sets the option pane's message type. The message type is used by the look
	 * and feel to determine the icon to display (if not supplied) as well as
	 * potentially how to lay out the parentComponent.
	 * 
	 * @param newType
	 *            an int specifying the kind of message to display:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE. Otherwise, a
	 *            RuntimeEception is thrown.
	 * 
	 * @see #getMessageType
	 * @beaninfo preferred: true bound: true description: The option pane's
	 *           message type.
	 */
	public void setMessageType(int newType) {
		if (newType != ERROR_MESSAGE && newType != INFORMATION_MESSAGE && newType != WARNING_MESSAGE && newType != QUESTION_MESSAGE && newType != PLAIN_MESSAGE)
			throw new RuntimeException(
					"InfoView: type must be one of InfoView.ERROR_MESSAGE, InfoView.INFORMATION_MESSAGE, InfoView.WARNING_MESSAGE, InfoView.QUESTION_MESSAGE or InfoView.PLAIN_MESSAGE");

		int oldType = messageType;

		messageType = newType;
		firePropertyChange(MESSAGE_TYPE_PROPERTY, oldType, messageType);
	}

	/**
	 * Sets the options this pane displays. If an element in newOptions is a
	 * Comonent it is added directly to the pane, Otherwise a button is created
	 * for the element.
	 * 
	 * @param newOptions
	 *            an array of Objects that create the buttons the user can click
	 *            on, or arbitrary Components to add to the pane
	 * 
	 * @see #getOptions
	 * @beaninfo bound: true description: The option pane's options objects.
	 */
	public void setOptions(Object[] newOptions) {
		Object[] oldOptions = options;

		options = newOptions;
		firePropertyChange(OPTIONS_PROPERTY, oldOptions, options);
	}

	/**
	 * Sets the options to display. The option type is used by the look and feel
	 * to determine what buttons to show (unless options are supplied).
	 * 
	 * @param newType
	 *            an int specifying the options the L&F is to display:
	 *            DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, or
	 *            OK_CANCEL_OPTION. Otherwise, a RuntimeException is thrown.
	 * 
	 * @see #getOptionType
	 * @see #setOptions
	 * @beaninfo preferred: true bound: true description: The option pane's
	 *           option type.
	 */
	public void setOptionType(int newType) {
		if (newType != DEFAULT_OPTION && newType != YES_NO_OPTION && newType != YES_NO_CANCEL_OPTION && newType != OK_CANCEL_OPTION)
			throw new RuntimeException(
					"InfoView: option type must be one of InfoView.DEFAULT_OPTION, InfoView.YES_NO_OPTION, InfoView.YES_NO_CANCEL_OPTION or InfoView.OK_CANCEL_OPTION");

		int oldType = optionType;

		optionType = newType;
		firePropertyChange(OPTION_TYPE_PROPERTY, oldType, optionType);
	}

	/**
	 * Sets the frame to use for class methods in which a frame is not provided.
	 * 
	 * @param newRootFrame
	 *            the default Frame to use
	 */
	// tsModified
	public static void setRootFrame(Frame newRootFrame) {
		JOptionPane.setRootFrame(newRootFrame);
	}

	/**
	 * Sets the selection values for a pane that provides the user with a list
	 * of items to choose from. (The UI provides a widget for choosing one of
	 * the values.)
	 * <p>
	 * Sets <code>wantsInput</code> to true. Use
	 * <code>setInitialSelectionValue</code> to specify the initially-chosen
	 * value. After the pane as been enabled, inputValue is set to the value the
	 * user has selected.
	 * 
	 * @param newValues
	 *            an array of Objects the user to be displayed (usually in a
	 *            list or combo-box) from which the user can make a selection
	 * @see #setWantsInput
	 * @see #setInitialSelectionValue
	 * @see #getSelectionValues
	 * @beaninfo bound: true description: The option pane's selection values.
	 */
	public void setSelectionValues(Object[] newValues) {
		Object[] oldValues = selectionValues;

		selectionValues = newValues;
		firePropertyChange(SELECTION_VALUES_PROPERTY, oldValues, newValues);
		if (selectionValues != null)
			setWantsInput(true);
	}

	/**
	 * Sets the UI object which implements the L&F for this component.
	 * 
	 * @param ui
	 *            the OptionPaneUI L&F object
	 * @see UIDefaults#getUI
	 * @beaninfo bound: true hidden: true description: The UI object that
	 *           implements the optionpane's LookAndFeel
	 */
	public void setUI(OptionPaneUI ui) {
		if ((OptionPaneUI) this.ui != ui) {
			super.setUI(ui);
			invalidate();
		}
	}

	/**
	 * Sets the value the user has chosen.
	 * 
	 * @param newValue
	 *            the chosen value
	 * 
	 * @see #getValue
	 * @beaninfo preferred: true bound: true description: The option pane's
	 *           value object.
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;

		value = newValue;
		firePropertyChange(VALUE_PROPERTY, oldValue, value);
	}

	/**
	 * If <code>newValue</code> is true, a parentComponent is provided to
	 * allow the user to input a value. If <code>getSelectionValues</code>
	 * returns a non-null the input value is one of the objects in that array.
	 * Otherwise the input value is whatever the user inputs.
	 * <p>
	 * This is a bound property.
	 * 
	 * @see #setSelectionValues
	 * @see #setInputValue
	 */
	public void setWantsInput(boolean newValue) {
		boolean oldValue = wantsInput;

		wantsInput = newValue;
		firePropertyChange(WANTS_INPUT_PROPERTY, oldValue, newValue);
	}

	/**
	 * Brings up a modal dialog with the options Yes, No and Cancel; with the
	 * title, "Select an Option".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @return an int indicating the option selected by the user
	 */
	public static int showConfirmDialog(Component parentComponent, Object message) {
		return showConfirmDialog(parentComponent, message, "Seleccione una opción", YES_NO_CANCEL_OPTION);
	}

	/**
	 * Brings up a modal dialog where the number of choices is determined by the
	 * <code>optionType</code> parameter.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @return an int indicating the option selected by the user
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType) {
		return showConfirmDialog(parentComponent, message, title, optionType, QUESTION_MESSAGE);
	}

	/**
	 * Brings up a modal dialog where the number of choices is determined by the
	 * <code>optionType</code> parameter, where the <code>messageType</code>
	 * parameter determines the icon to display. The <code>messageType</code>
	 * parameter is primarily used to supply a default icon from the look and
	 * feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @return an int indicating the option selected by the user
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType) {
		return showConfirmDialog(parentComponent, message, title, optionType, messageType, null);
	}

	/**
	 * Brings up a modal dialog with a specified icon, where the number of
	 * choices is determined by the <code>optionType</code> parameter. The
	 * <code>messageType</code> parameter is primarily used to supply a
	 * default icon from the look and feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @param icon
	 *            the icon to display in the dialog
	 * @return an int indicating the option selected by the user
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon) {
		return showOptionDialog(parentComponent, message, title, optionType, messageType, icon, null, null);
	}

	/**
	 * Brings up a confirmation dialog -- a modal information-message dialog
	 * titled "Confirm".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 */
	public static void showErrorDialog(Component parentComponent, Object message) {
		//message = message + "\n\n[Origen:  " + InvokerFinder.getInvoker("efren.util.gui.dialogs.InfoView") + "  ]";
		showMessageDialog(parentComponent, message, "Error", ERROR_MESSAGE);
	}

	/**
	 * Brings up a dialog that displays a message using a default icon
	 * determined by the messageType parameter.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public static void showErrorDialog(Component parentComponent, Object message, String title) {
		//message = message + "\n\n[Origen:  " + InvokerFinder.getInvoker("efren.util.gui.dialogs.InfoView") + "  ]";
		showMessageDialog(parentComponent, message, title, ERROR_MESSAGE, null);
	}

	/**
	 * Brings up a dialog displaying a message, specifying all parameters.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            an icon to display in the dialog that helps the user identify
	 *            the kind of message that is being displayed.
	 */
	public static void showErrorDialog(Component parentComponent, Object message, String title, int messageType, Icon icon) {
		//message = message + "\n\n[Origen:  " + InvokerFinder.getInvoker("efren.util.gui.dialogs.InfoView") + "  ]";
		showOptionDialog(parentComponent, message, title, DEFAULT_OPTION, messageType, icon, null, null);
	}

	/**
	 * Brings up a dialog displaying a message, specifying all parameters.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            an icon to display in the dialog that helps the user identify
	 *            the kind of message that is being displayed.
	 */
	public static void showErrorDialog(Component parentComponent, Object message, String title, Icon icon) {
		//message = message + "\n\n[Origen:  " + InvokerFinder.getInvoker("efren.util.gui.dialogs.InfoView") + "  ]";
		showOptionDialog(parentComponent, message, title, DEFAULT_OPTION, ERROR_MESSAGE, icon, null, null);
	}

	/**
	 * Brings up a confirmation dialog -- a modal information-message dialog
	 * titled "Confirm".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 */
	public static void showInformationDialog(Component parentComponent, Object message) {
		showMessageDialog(parentComponent, message, "Información", INFORMATION_MESSAGE);
	}

	/**
	 * Shows a question-message dialog requesting input from the user parented
	 * to <code>parentComponent</code>. The dialog is displayed in the
	 * Component's frame, and is usually positioned below the Component.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 */
	public static String showInputDialog(Component parentComponent, Object message) {
		return showInputDialog(parentComponent, message, "Ingreso de información", QUESTION_MESSAGE);
	}

	/**
	 * Shows a dialog requesting input from the user parented to
	 * <code>parentComponent</code> with the dialog having the title
	 * <code>title</code> and message type <code>messageType</code>.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 * @param title
	 *            the String to display in the dialog title bar
	 * @param messageType
	 *            the type of message that is to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public static String showInputDialog(Component parentComponent, Object message, String title, int messageType) {
		return (String) showInputDialog(parentComponent, message, title, messageType, null, null, null);
	}

	/**
	 * Prompts the user for input in a blocking dialog where the initial
	 * selection, possible selections, and all other options can be specified.
	 * The user will able to choose from <code>selectionValues</code>, where
	 * null implies the user can input whatever they wish, usually by means of a
	 * JTextField. <code>initialSelectionValue</code> is the initial value to
	 * prompt the user with. It is up to the UI to decide how best to represent
	 * the <code>selectionValues</code>, but usually a JComboBox, JList, or
	 * JTextField will be used.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 * @param title
	 *            the String to display in the dialog title bar
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            the Icon image to display
	 * @param selectionValues
	 *            an array of Objects that gives the possible selections
	 * @param initialSelectionValue
	 *            the value used to initialize the input field
	 * @return users input, or null meaning the user canceled the input
	 */
	public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue) {
		InfoView pane = new InfoView(message, messageType, OK_CANCEL_OPTION, icon, null, null);

		pane.setWantsInput(true);
		pane.setSelectionValues(selectionValues);
		pane.setInitialSelectionValue(initialSelectionValue);

		JDialog dialog = pane.createDialog(parentComponent, title);

		pane.selectInitialValue();
		dialog.setVisible(true);

		Object value = pane.getInputValue();

		if (value == UNINITIALIZED_VALUE)
			return null;
		return value;
	}

	/**
	 * Shows a question-message dialog requesting input from the user. The
	 * dialog uses the default frame, which usually means it is centered on the
	 * screen.
	 * 
	 * @param message
	 *            the Object to display
	 */
	public static String showInputDialog(Object message) {
		return showInputDialog(null, message);
	}

	/**
	 * Brings up an internal dialog panel with the options Yes, No and Cancel;
	 * with the title, "Select an Option".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @return an int indicating the option selected by the user
	 */
	public static int showInternalConfirmDialog(Component parentComponent, Object message) {
		return showInternalConfirmDialog(parentComponent, message, "Seleccione una opción", YES_NO_CANCEL_OPTION);
	}

	/**
	 * Brings up a internal dialog panel where the number of choices is
	 * determined by the <code>optionType</code> parameter.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The object to display in the dialog. A Component object is
	 *            rendered as a Component. A String object is rendered as a
	 *            string. Other objects are converted to a String using the
	 *            <code>toString</code> method.
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @return an int indicating the option selected by the user
	 */
	public static int showInternalConfirmDialog(Component parentComponent, Object message, String title, int optionType) {
		return showInternalConfirmDialog(parentComponent, message, title, optionType, QUESTION_MESSAGE);
	}

	/**
	 * Brings up an internal dialog panel where the number of choices is
	 * determined by the <code>optionType</code> parameter, where the
	 * <code>messageType</code> parameter determines the icon to display. The
	 * <code>messageType</code> parameter is primarily used to supply a
	 * default icon from the look and feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The object to display in the dialog. A Component object is
	 *            rendered as a Component. A String object is rendered as a
	 *            string. Other objects are converted to a String using the
	 *            <code>toString</code> method.
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @return an int indicating the option selected by the user
	 */
	public static int showInternalConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType) {
		return showInternalConfirmDialog(parentComponent, message, title, optionType, messageType, null);
	}

	/**
	 * Brings up an internal dialog panel with a specified icon, where the
	 * number of choices is determined by the <code>optionType</code>
	 * parameter. The <code>messageType</code> parameter is primarily used to
	 * supply a default icon from the look and feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The object to display in the dialog. A Component object is
	 *            rendered as a Component. A String object is rendered as a
	 *            string. Other objects are converted to a String using the
	 *            <code>toString</code> method.
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @param icon
	 *            the icon to display in the dialog
	 * @return an int indicating the option selected by the user
	 */
	public static int showInternalConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon) {
		return showInternalOptionDialog(parentComponent, message, title, optionType, messageType, icon, null, null);
	}

	/**
	 * Shows an internal question-message dialog requesting input from the user
	 * parented to <code>parentComponent</code>. The dialog is displayed in
	 * the Component's frame, and is usually positioned below the Component.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 */
	public static String showInternalInputDialog(Component parentComponent, Object message) {
		return showInternalInputDialog(parentComponent, message, "Ingreso de información", QUESTION_MESSAGE);
	}

	/**
	 * Shows an internal dialog requesting input from the user parented to
	 * <code>parentComponent</code> with the dialog having the title
	 * <code>title</code> and message type <code>messageType</code>.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 * @param title
	 *            the String to display in the dialog title bar
	 * @param messageType
	 *            the type of message that is to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public static String showInternalInputDialog(Component parentComponent, Object message, String title, int messageType) {
		return (String) showInternalInputDialog(parentComponent, message, title, messageType, null, null, null);
	}

	/**
	 * Prompts the user for input in a blocking internal dialog where the
	 * initial selection, possible selections, and all other options can be
	 * specified. The user will able to choose from <code>selectionValues</code>,
	 * where null implies the user can input whatever they wish, usually by
	 * means of a JTextField. <code>initialSelectionValue</code> is the
	 * initial value to prompt the user with. It is up to the UI to decide how
	 * best to represent the <code>selectionValues</code>, but usually a
	 * JComboBox, JList, or JTextField will be used.
	 * 
	 * @param parentComponent
	 *            the parent Component for the dialog
	 * @param message
	 *            the Object to display
	 * @param title
	 *            the String to display in the dialog title bar
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            the Icon image to display
	 * @param selectionValues
	 *            an array of Objects that gives the possible selections
	 * @param initialSelectionValue
	 *            the value used to initialize the input field
	 * @return users input, or null meaning the user canceled the input
	 */
	public static Object showInternalInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues,
			Object initialSelectionValue) {

		return JOptionPane.showInternalInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue);

	}

	/**
	 * Brings up an internal confirmation dialog panel. The dialog is a modal
	 * information-message dialog titled "Message".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The object to display
	 */
	public static void showInternalMessageDialog(Component parentComponent, Object message) {
		showInternalMessageDialog(parentComponent, message, "Mensaje", INFORMATION_MESSAGE);
	}

	/**
	 * Brings up an internal dialog panel that displays a message using a
	 * default icon determined by the messageType parameter.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public static void showInternalMessageDialog(Component parentComponent, Object message, String title, int messageType) {
		showInternalMessageDialog(parentComponent, message, title, messageType, null);
	}

	/**
	 * Brings up an internal dialog panel displaying a message, specifying all
	 * parameters.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            an icon to display in the dialog that helps the user identify
	 *            the kind of message that is being displayed.
	 */
	public static void showInternalMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon) {
		showInternalOptionDialog(parentComponent, message, title, DEFAULT_OPTION, messageType, icon, null, null);
	}

	/**
	 * Brings up an internal dialog panel with a specified icon, where the
	 * initial choice is dermined by the <code>initialValue</code> parameter
	 * and the number of choices is determined by the <code>optionType</code>
	 * parameter.
	 * <p>
	 * If <code>optionType</code> is YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * and the <code>options</code> parameter is null, then the options are
	 * supplied by the look and feel.
	 * <p>
	 * The <code>messageType</code> parameter is primarily used to supply a
	 * default icon from the look and feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The object to display in the dialog. A Component object is
	 *            rendered as a Component. A String object is rendered as a
	 *            string. Other objects are converted to a String using the
	 *            <code>toString</code> method.
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @param icon
	 *            the icon to display in the dialog
	 * @param options
	 *            an array of objects indicating the possible choices the user
	 *            can make. If the objects are components, they are rendered
	 *            properly. Non-String objects are rendered using their
	 *            <code>toString</code> methods. If this parameter is null,
	 *            the options are determined by the look and feel.
	 * @param initialValue
	 *            the object that represents the default selection for the
	 *            dialog
	 * @return an int indicating the option chosen by the user, or CLOSED_OPTION
	 *         if the user closed the Dialog
	 */
	public static int showInternalOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options,
			Object initialValue) {

		return JOptionPane.showInternalOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue);

	}

	/**
	 * Brings up a confirmation dialog -- a modal information-message dialog
	 * titled "Confirm".
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 */
	public static void showMessageDialog(Component parentComponent, Object message) {
		showMessageDialog(parentComponent, message, "Mensaje", INFORMATION_MESSAGE);
	}

	/**
	 * Brings up a dialog that displays a message using a default icon
	 * determined by the messageType parameter.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 */
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType) {
		showMessageDialog(parentComponent, message, title, messageType, null);
	}

	/**
	 * Brings up a dialog displaying a message, specifying all parameters.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param messageType
	 *            the type of message to be displayed: ERROR_MESSAGE,
	 *            INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or
	 *            PLAIN_MESSAGE.
	 * @param icon
	 *            an icon to display in the dialog that helps the user identify
	 *            the kind of message that is being displayed.
	 */
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon) {
		showOptionDialog(parentComponent, message, title, DEFAULT_OPTION, messageType, icon, null, null);
	}

	/**
	 * Brings up a modal dialog with a specified icon, where the initial choice
	 * is dermined by the <code>initialValue</code> parameter and the number
	 * of choices is determined by the <code>optionType</code> parameter.
	 * <p>
	 * If <code>optionType</code> is YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * and the <code>options</code> parameter is null, then the options are
	 * supplied by the look and feel.
	 * <p>
	 * The <code>messageType</code> parameter is primarily used to supply a
	 * default icon from the look and feel.
	 * 
	 * @param parentComponent
	 *            Determines the Frame in which the dialog is displayed. If
	 *            null, or if the parentComponent has no Frame, a default Frame
	 *            is used.
	 * @param message
	 *            The Object to display
	 * @param title
	 *            the title string for the dialog
	 * @param optionType
	 *            an int designating the options available on the dialog:
	 *            YES_NO_OPTION, or YES_NO_CANCEL_OPTION
	 * @param messageType
	 *            an int designating the kind of message this is, primarily used
	 *            to determine the icon from the pluggable look and feel:
	 *            ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
	 *            QUESTION_MESSAGE, or PLAIN_MESSAGE.
	 * @param icon
	 *            the icon to display in the dialog
	 * @param options
	 *            an array of objects indicating the possible choices the user
	 *            can make. If the objects are components, they are rendered
	 *            properly. Non-String objects are rendered using their
	 *            <code>toString</code> methods. If this parameter is null,
	 *            the options are determined by the look and feel.
	 * @param initialValue
	 *            the object that represents the default selection for the
	 *            dialog
	 * @return an int indicating the option chosen by the user, or CLOSED_OPTION
	 *         if the user closed the Dialog
	 */
	public static int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue) {
		InfoView pane = new InfoView(message, messageType, optionType, icon, options, initialValue);

		pane.setInitialValue(initialValue);

		JDialog dialog = pane.createDialog(parentComponent, title);

		pane.selectInitialValue();
		dialog.setVisible(true);

		Object selectedValue = pane.getValue();

		if (selectedValue == null)
			return CLOSED_OPTION;
		if (options == null) {
			if (selectedValue instanceof Integer)
				return ((Integer) selectedValue).intValue();
			return CLOSED_OPTION;
		}
		for (int counter = 0, maxCounter = options.length; counter < maxCounter; counter++) {
			if (options[counter].equals(selectedValue))
				return counter;
		}
		return CLOSED_OPTION;
	}

	/**
	 * Notification from the UIManager that the L&F has changed. Replaces the
	 * current UI object with the latest version from the UIManager.
	 * 
	 * @see JComponent#updateUI
	 */
	public void updateUI() {
		setUI(new efren.util.gui.dialogs.OptionPaneUI());
		addMouseListenerForButtons();
	}

	// Serialization support.
	private void writeObject(ObjectOutputStream s) throws IOException {
		Vector values = new Vector();

		s.defaultWriteObject();
		// Save the icon, if its Serializable.
		if (icon != null && icon instanceof Serializable) {
			values.addElement("icon");
			values.addElement(icon);
		}
		// Save the message, if its Serializable.
		if (message != null && message instanceof Serializable) {
			values.addElement("message");
			values.addElement(message);
		}
		// Save the treeModel, if its Serializable.
		if (options != null) {
			Vector serOptions = new Vector();

			for (int counter = 0, maxCounter = options.length; counter < maxCounter; counter++)
				if (options[counter] instanceof Serializable)
					serOptions.addElement(options[counter]);
			if (serOptions.size() > 0) {
				int optionCount = serOptions.size();
				Object[] arrayOptions = new Object[optionCount];

				serOptions.copyInto(arrayOptions);
				values.addElement("options");
				values.addElement(arrayOptions);
			}
		}
		// Save the initialValue, if its Serializable.
		if (initialValue != null && initialValue instanceof Serializable) {
			values.addElement("initialValue");
			values.addElement(initialValue);
		}
		// Save the value, if its Serializable.
		if (value != null && value instanceof Serializable) {
			values.addElement("value");
			values.addElement(value);
		}
		// Save the selectionValues, if its Serializable.
		if (selectionValues != null) {
			boolean serialize = true;

			for (int counter = 0, maxCounter = selectionValues.length; counter < maxCounter; counter++) {
				if (selectionValues[counter] != null && !(selectionValues[counter] instanceof Serializable)) {
					serialize = false;
					break;
				}
			}
			if (serialize) {
				values.addElement("selectionValues");
				values.addElement(selectionValues);
			}
		}
		// Save the inputValue, if its Serializable.
		if (inputValue != null && inputValue instanceof Serializable) {
			values.addElement("inputValue");
			values.addElement(inputValue);
		}
		// Save the initialSelectionValue, if its Serializable.
		if (initialSelectionValue != null && initialSelectionValue instanceof Serializable) {
			values.addElement("initialSelectionValue");
			values.addElement(initialSelectionValue);
		}
		s.writeObject(values);
	}
}
