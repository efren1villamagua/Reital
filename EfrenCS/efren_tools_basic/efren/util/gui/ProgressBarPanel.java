package efren.util.gui;

public class ProgressBarPanel extends javax.swing.JPanel implements java.beans.PropertyChangeListener {
	private javax.swing.JProgressBar ivjJProgressBar = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProgressBarPanel() {
	super();
	initialize();
}
/**
 * ProgressBarBean constructor comment.
 * @param layout java.awt.LayoutManager
 */
public ProgressBarPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * ProgressBarBean constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public ProgressBarPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * ProgressBarBean constructor comment.
 * @param isDoubleBuffered boolean
 */
public ProgressBarPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
public void barSetValue(int n) {
	getJProgressBar().setValue(n);
}
/**
 * connEtoC1:  (JProgressBar.value --> ProgressBarPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("barValue", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
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
 * Method generated to support the promotion of the barMaximum attribute.
 * @return int
 */
public int getBarMaximum() {
	return getJProgressBar().getMaximum();
}
/**
 * Method generated to support the promotion of the barMinimum attribute.
 * @return int
 */
public int getBarMinimum() {
	return getJProgressBar().getMinimum();
}
/**
 * Method generated to support the promotion of the barValue attribute.
 * @return int
 */
public int getBarValue() {
	return getJProgressBar().getValue();
}
/**
 * Return the JProgressBar property value.
 * @return javax.swing.JProgressBar
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JProgressBar getJProgressBar() {
	if (ivjJProgressBar == null) {
		try {
			ivjJProgressBar = new javax.swing.JProgressBar();
			ivjJProgressBar.setName("JProgressBar");
			ivjJProgressBar.setToolTipText("Proceso en avance");
			ivjJProgressBar.setMinimum(0);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJProgressBar;
}
/**
 * Accessor for the propertyChange field.
 * @return java.beans.PropertyChangeSupport
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
private void handleException(Throwable exception) {
	efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
}
/**
 * Perform the incrementBarValue method.
 * @param incrementValue int
 */
public void incrementBarValue(int incrementValue) {
	/* Perform the incrementBarValue method. */
	getJProgressBar().setValue(getJProgressBar().getValue() + incrementValue);
	return;
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getJProgressBar().addPropertyChangeListener(this);
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
		setSize(377, 13);

		java.awt.GridBagConstraints constraintsJProgressBar = new java.awt.GridBagConstraints();
		constraintsJProgressBar.gridx = 0; constraintsJProgressBar.gridy = 0;
		constraintsJProgressBar.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJProgressBar.weightx = 1.0;
		constraintsJProgressBar.weighty = 1.0;
		constraintsJProgressBar.insets = new java.awt.Insets(3, 3, 3, 3);
		add(getJProgressBar(), constraintsJProgressBar);
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the PropertyChangeListener interface.
 * @param evt java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void propertyChange(java.beans.PropertyChangeEvent evt) {
	// user code begin {1}
	// user code end
	if (evt.getSource() == getJProgressBar() && (evt.getPropertyName().equals("value")))
		connEtoC1(evt);
	// user code begin {2}
	// user code end
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * Method generated to support the promotion of the barMaximum attribute.
 * @param arg1 int
 */
public void setBarMaximum(int arg1) {
	getJProgressBar().setMaximum(arg1);
}
/**
 * Method generated to support the promotion of the barMinimum attribute.
 * @param arg1 int
 */
public void setBarMinimum(int arg1) {
	getJProgressBar().setMinimum(arg1);
}
/**
 * Method generated to support the promotion of the barValue attribute.
 * @param arg1 int
 */
public void setBarValue(int arg1) {
	getJProgressBar().setValue(arg1);
}
public void setIndeterminateMode(boolean b) {
    try {
        Boolean b1 = new Boolean(b);
        Object[] args = new Object[] { b1 };

        java.lang.reflect.Method[] methods =
            getJProgressBar().getClass().getMethods();
        String methodName = null;
        for (int i = 0; i < methods.length; i++) {
            methodName = methods[i].getName();
            if (methodName.toUpperCase().indexOf("SETINDETERMINATE") >= 0) {
                try {
                    methods[i].invoke(getJProgressBar(), args);
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
}
