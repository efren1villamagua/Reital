package efren.util.gui;

/**
 * Insert the type's description here.
 * Creation date: (22/12/2003 23:47:30)
 * @author: Efrén Villamagua
 */
public class DividerView extends javax.swing.JPanel {
	private javax.swing.JPanel ivjJPanel1 = null;
/**
 * DividerView constructor comment.
 */
public DividerView() {
	super();
	initialize();
}
/**
 * DividerView constructor comment.
 * @param layout java.awt.LayoutManager
 */
public DividerView(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * DividerView constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public DividerView(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * DividerView constructor comment.
 * @param isDoubleBuffered boolean
 */
public DividerView(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setBorder(new javax.swing.border.EtchedBorder());
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());
			ivjJPanel1.setBackground(java.awt.Color.lightGray);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel1;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("DividerView");
		setLayout(new java.awt.GridBagLayout());
		setSize(205, 5);

		java.awt.GridBagConstraints constraintsJPanel1 = new java.awt.GridBagConstraints();
		constraintsJPanel1.gridx = 0; constraintsJPanel1.gridy = 0;
		constraintsJPanel1.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJPanel1.weightx = 1.0;
		constraintsJPanel1.weighty = 1.0;
		add(getJPanel1(), constraintsJPanel1);
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
}
