package efren.util.gui;

public class LabelExt extends javax.swing.JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7697833422677355135L;
	private boolean fieldMandatory = true;
	private java.awt.Color colorTemp;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public LabelExt() {
		super();
		initialize();
	}

	/**
	 * LabelExt constructor comment.
	 * 
	 * @param text
	 *            java.lang.String
	 */
	public LabelExt(String text) {
		super(text);
	}

	/**
	 * LabelExt constructor comment.
	 * 
	 * @param text
	 *            java.lang.String
	 * @param horizontalAlignment
	 *            int
	 */
	public LabelExt(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	/**
	 * LabelExt constructor comment.
	 * 
	 * @param text
	 *            java.lang.String
	 * @param icon
	 *            javax.swing.Icon
	 * @param horizontalAlignment
	 *            int
	 */
	public LabelExt(String text, javax.swing.Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	/**
	 * LabelExt constructor comment.
	 * 
	 * @param image
	 *            javax.swing.Icon
	 */
	public LabelExt(javax.swing.Icon image) {
		super(image);
	}

	/**
	 * LabelExt constructor comment.
	 * 
	 * @param image
	 *            javax.swing.Icon
	 * @param horizontalAlignment
	 *            int
	 */
	public LabelExt(javax.swing.Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	/**
	 * Gets the mandatory property (boolean) value.
	 * 
	 * @return The mandatory property value.
	 * @see #setMandatory
	 */
	public boolean getMandatory() {
		return fieldMandatory;
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("LabelExt");
			setSize(48, 14);
			setText("LabelExt");
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		setFont(efren.util.FontManager.currentSystemPlainFont());
		// user code end
		this.setForeground(new java.awt.Color(80, 80, 80));
	}

	public void setEnabled(boolean b) {

		if (b)
			setForeground(this.colorTemp);
		else
			setForeground(java.awt.Color.darkGray);
		super.setEnabled(b);
	}

	public void setForeground(java.awt.Color c) {

		this.colorTemp = c;
		super.setForeground(c);
	}

	public void setBackground(java.awt.Color c) {

		super.setBackground(c);
	}
}
