package efren.util.gui.bars;

import efren.util.ExceptionManager;

/**
 * This type was created in VisualAge.
 */
public class BarraExceptionsPanel extends javax.swing.JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 8763561698676153672L;
	private javax.swing.JScrollPane ivjJScrollPane1 = null;
	private efren.util.gui.text.TextAreaExt ivjTextAreaExt1 = null;
	private java.lang.String fieldText = new String();
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BarraExceptionsPanel() {
	super();
	initialize();
}
/**
 * BarraEstadosPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public BarraExceptionsPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * BarraEstadosPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public BarraExceptionsPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * BarraEstadosPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public BarraExceptionsPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
public void clear() {
    setText("NO HAY ERROR");
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJScrollPane1() {
	if (ivjJScrollPane1 == null) {
		try {
			ivjJScrollPane1 = new javax.swing.JScrollPane();
			ivjJScrollPane1.setName("JScrollPane1");
			getJScrollPane1().setViewportView(getTextAreaExt1());
			// user code begin {1}
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
 * Gets the text property (java.lang.String) value.
 * @return The text property value.
 * @see #setText
 */
public java.lang.String getText() {
	return fieldText;
}
/**
 * Return the TextAreaExt1 property value.
 * @return efren.util.gui.TextAreaExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextAreaExt getTextAreaExt1() {
	if (ivjTextAreaExt1 == null) {
		try {
			ivjTextAreaExt1 = new efren.util.gui.text.TextAreaExt();
			ivjTextAreaExt1.setName("TextAreaExt1");
			ivjTextAreaExt1.setBackground(java.awt.Color.white);
			ivjTextAreaExt1.setForeground(java.awt.Color.black);
			ivjTextAreaExt1.setValue("NO HAY ERROR");
			ivjTextAreaExt1.setFont(new java.awt.Font("Arial", 1, 12));
			ivjTextAreaExt1.setLocation(0, 0);
			ivjTextAreaExt1.setEditable(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextAreaExt1;
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("BarraEstadosPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(395, 57);

		java.awt.GridBagConstraints constraintsJScrollPane1 = new java.awt.GridBagConstraints();
		constraintsJScrollPane1.gridx = 0; constraintsJScrollPane1.gridy = 0;
		constraintsJScrollPane1.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJScrollPane1.weightx = 1.0;
		constraintsJScrollPane1.weighty = 1.0;
		constraintsJScrollPane1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJScrollPane1(), constraintsJScrollPane1);
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Sets the text property (java.lang.String) value.
 * @param text The new value for the property.
 * @see #getText
 */
public void setText(java.lang.String text) {
	String oldValue = fieldText;
	fieldText = text;
	firePropertyChange("text", oldValue, text);
	getTextAreaExt1().setValue(text);
}
}
