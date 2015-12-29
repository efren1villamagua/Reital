package efren.util.gui;

/**
 * This type was created in VisualAge.
 */

public class ProgressBarWithThreadPanel extends javax.swing.JPanel implements Runnable {
    private Thread barraThread = null;
    private javax.swing.JProgressBar ivjJProgressBarBean = null;
    private boolean shouldRun = true;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProgressBarWithThreadPanel() {
	super();
	initialize();
}
/**
 * ProgressBarBean constructor comment.
 * @param layout java.awt.LayoutManager
 */
public ProgressBarWithThreadPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * ProgressBarBean constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public ProgressBarWithThreadPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * ProgressBarBean constructor comment.
 * @param isDoubleBuffered boolean
 */
public ProgressBarWithThreadPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * This method was created in VisualAge.
 * @return java.lang.Thread
 */
public Thread getBarraThread() {
	return barraThread;
}
/**
 * Return the JProgressBarBean property value.
 * @return javax.swing.JProgressBar
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JProgressBar getJProgressBarBean() {
	if (ivjJProgressBarBean == null) {
		try {
			ivjJProgressBarBean = new javax.swing.JProgressBar();
			ivjJProgressBarBean.setName("JProgressBarBean");
			ivjJProgressBarBean.setMinimum(0);
			ivjJProgressBarBean.setStringPainted(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJProgressBarBean;
}
private void handleException(Throwable exception) {
//    efren.util.ExceptionManager.singleton().manage(this, exception);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("ProgressBarBean");
		setLayout(new java.awt.GridBagLayout());
		setSize(377, 29);

		java.awt.GridBagConstraints constraintsJProgressBarBean = new java.awt.GridBagConstraints();
		constraintsJProgressBarBean.gridx = 0; constraintsJProgressBarBean.gridy = 0;
		constraintsJProgressBarBean.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJProgressBarBean.weightx = 1.0;
		constraintsJProgressBarBean.weighty = 1.0;
		add(getJProgressBarBean(), constraintsJProgressBarBean);
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    getJProgressBarBean().setValue(getJProgressBarBean().getMinimum());
	// user code end
}
public void run() {
    try {
        barraThread = Thread.currentThread();
        int valor = 0;
        shouldRun = true;
        while (shouldRun) {
            if (valor == 100)
                valor = 0;
            getJProgressBarBean().setValue(valor);
            valor++;
            Thread.sleep(10);
        }
    } catch (InterruptedException e) {
        // the VM doesn't want us to sleep anymore,
        // so get back to work
    }
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.Thread
 */
public void setBarraThread(Thread newValue) {
	this.barraThread = newValue;
}
public void setBarValue(int arg1) {
	getJProgressBarBean().setValue(arg1);
}
/*
public void setIndeterminateMode(boolean b) {
    try {
        Boolean b1 = new Boolean(b);
        Object[] args = new Object[] { b1 };

        java.lang.reflect.Method[] methods =
            getJProgressBarBean().getClass().getMethods();
        String methodName = null;
        for (int i = 0; i < methods.length; i++) {
            methodName = methods[i].getName();
            if (methodName.toUpperCase().indexOf("SETINDETERMINATE") >= 0) {
                try {
                    methods[i].invoke(getJProgressBarBean(), args);
                } catch (Throwable t) {
                    t.getMessage();
                }
            }
        }
    } catch (Throwable t) {
        t.getMessage();
        //efren.util.ExceptionManager.singleton().manage(this, t);
    }
}
*/
public void start() {
    getJProgressBarBean().setIndeterminate(true);
    if (barraThread == null) {
        barraThread = new Thread(this, "barraThread");
        barraThread.start();
    }
}
public void stop() {
    getJProgressBarBean().setIndeterminate(false);
    //    if (barraThread != null)
    //        barraThread.stop();
    shouldRun = false;
    barraThread = null;
    getJProgressBarBean().setMinimum(0);
    getJProgressBarBean().setValue(getJProgressBarBean().getMinimum());
    repaint();
}
}
