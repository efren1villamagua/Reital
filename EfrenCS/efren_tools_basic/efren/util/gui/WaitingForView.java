package efren.util.gui;

/**
 * This type was created in VisualAge.
 */
public class WaitingForView extends javax.swing.JFrame {
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private ProgressBarWithThreadPanel ivjProgressBarWithThreadPanel1 = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public WaitingForView() {
	super();
	initialize();
}
/**
 * WaitingForView constructor comment.
 * @param title java.lang.String
 */
public WaitingForView(String title) {
	super(title);
}
/**
 * Method generated to support the promotion of the barPanel attribute.
 * @return com.truesoft.util.gui.ProgressBarWithThreadPanel
 */
public ProgressBarWithThreadPanel getBarPanel() {
	return getProgressBarWithThreadPanel1();
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());
			ivjJFrameContentPane.setBackground(java.awt.Color.black);

			java.awt.GridBagConstraints constraintsProgressBarWithThreadPanel1 = new java.awt.GridBagConstraints();
			constraintsProgressBarWithThreadPanel1.gridx = 0; constraintsProgressBarWithThreadPanel1.gridy = 0;
			constraintsProgressBarWithThreadPanel1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsProgressBarWithThreadPanel1.weightx = 1.0;
			constraintsProgressBarWithThreadPanel1.weighty = 1.0;
			constraintsProgressBarWithThreadPanel1.insets = new java.awt.Insets(5, 5, 5, 5);
			getJFrameContentPane().add(getProgressBarWithThreadPanel1(), constraintsProgressBarWithThreadPanel1);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJFrameContentPane;
}
/**
 * Return the ProgressBarWithThreadPanel1 property value.
 * @return efren.util.gui.ProgressBarWithThreadPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private ProgressBarWithThreadPanel getProgressBarWithThreadPanel1() {
	if (ivjProgressBarWithThreadPanel1 == null) {
		try {
			ivjProgressBarWithThreadPanel1 = new efren.util.gui.ProgressBarWithThreadPanel();
			ivjProgressBarWithThreadPanel1.setName("ProgressBarWithThreadPanel1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjProgressBarWithThreadPanel1;
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
		setName("WaitingForView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setFont(new java.awt.Font("Arial", 0, 12));
		setSize(370, 82);
		setTitle("¡ Espere por favor !");
		setContentPane(getJFrameContentPane());
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	efren.util.WindowManager.centerWindow2(this);
	setResizable(false);
	// user code end
}
}
