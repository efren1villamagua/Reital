package efren.util.gui.dialogs;

import efren.util.ExceptionManager;

/**
 * This type was created in VisualAge.
 */
public class EsperaView extends javax.swing.JDialog {
	private javax.swing.JPanel ivjJDialogContentPane = null;
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JLabel ivjJLabel2 = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public EsperaView() {
	super();
	initialize();
}
/**
 * TsEsperaView constructor comment.
 * @param owner java.awt.Frame
 */
public EsperaView(java.awt.Frame owner) {
	super(owner);
}
/**
 * TsEsperaView constructor comment.
 * @param owner java.awt.Frame
 * @param title java.lang.String
 */
public EsperaView(java.awt.Frame owner, String title) {
	super(owner, title);
}
/**
 * TsEsperaView constructor comment.
 * @param owner java.awt.Frame
 * @param title java.lang.String
 * @param modal boolean
 */
public EsperaView(java.awt.Frame owner, String title, boolean modal) {
	super(owner, title, modal);
}
/**
 * TsEsperaView constructor comment.
 * @param owner java.awt.Frame
 * @param modal boolean
 */
public EsperaView(java.awt.Frame owner, boolean modal) {
	super(owner, modal);
}
/**
 * connEtoM1:  (TsEsperaView.initialize() --> TsEsperaView.setLocation(II)V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1() {
	try {
		// user code begin {1}
		// user code end
		this.setLocation(50, 50);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM2:  (TsEsperaView.initialize() --> TsEsperaView.setSize(II)V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM2() {
	try {
		// user code begin {1}
		// user code end
		this.setSize(335, 217);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the JDialogContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJDialogContentPane() {
	if (ivjJDialogContentPane == null) {
		try {
			ivjJDialogContentPane = new javax.swing.JPanel();
			ivjJDialogContentPane.setName("JDialogContentPane");
			ivjJDialogContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
			constraintsJLabel1.gridx = 0; constraintsJLabel1.gridy = 0;
			constraintsJLabel1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJLabel1.weightx = 1.0;
			constraintsJLabel1.weighty = 1.0;
			constraintsJLabel1.insets = new java.awt.Insets(20, 20, 0, 20);
			getJDialogContentPane().add(getJLabel1(), constraintsJLabel1);

			java.awt.GridBagConstraints constraintsJLabel2 = new java.awt.GridBagConstraints();
			constraintsJLabel2.gridx = 0; constraintsJLabel2.gridy = 0;
			constraintsJLabel2.weightx = 1.0;
			constraintsJLabel2.weighty = 1.0;
			constraintsJLabel2.insets = new java.awt.Insets(0, 20, 20, 20);
			getJDialogContentPane().add(getJLabel2(), constraintsJLabel2);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJDialogContentPane;
}
/**
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel1() {
	if (ivjJLabel1 == null) {
		try {
			ivjJLabel1 = new javax.swing.JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("");
			ivjJLabel1.setForeground(java.awt.Color.black);
			ivjJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			ivjJLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel1;
}
/**
 * Return the JLabel2 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel2() {
	if (ivjJLabel2 == null) {
		try {
			ivjJLabel2 = new javax.swing.JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setText("Espere un instante...!");
			ivjJLabel2.setForeground(java.awt.Color.black);
			ivjJLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel2;
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("TsEsperaView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Espere...");
		setVisible(true);
		setModal(true);
		setSize(335, 217);
		setResizable(false);
		setContentPane(getJDialogContentPane());
		initConnections();
		connEtoM2();
		connEtoM1();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
public static efren.util.gui.dialogs.EsperaView muestra(javax.swing.JFrame unFrame) {
	EsperaView t = new EsperaView(unFrame, true);
	t.initialize();
	t.setVisible(true);
	return t;
}
}
