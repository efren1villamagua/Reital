package efren.util.gui.wizard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class JWizardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The JWizardDialog parent

	JWizardDialog dialogParent;

	// The step title

	String stepTitle;

	JPanel contentPane;

	// The back and next steps

	int backStep = -1;

	int nextStep = -1;

	// Flags the first time the component is added to a window

	boolean firstNotify = true;

	// **********************************************************************
	// Constructors
	// **********************************************************************

	/**
	 * Creates a new JWizardPanel with a double buffer and a flow layout. The
	 * flow layout is assigned to the panel accessed through getContentPane().
	 */

	public JWizardPanel() {
		super();
		init(new GridBagLayout());
	}

	/**
	 * Create a new buffered JWizardPanel with the specified layout manager. The
	 * layout is assigned to the panel accessed through getContentPane().
	 * 
	 * @param layout
	 * 		The LayoutManager for the content pane.
	 */

	public JWizardPanel(LayoutManager layout) {
		super();
		init(layout);
	}

	/**
	 * Creates a new JWizardPanel a flow layout and the specified buffering
	 * strategy. If isDoubleBuffered is true, the JWizardPanel will use a double
	 * buffer. The layout is assigned to the panel accessed through
	 * getContentPane().
	 * 
	 * @param isDoubleBuffered
	 * 		True for double-buffering, which uses additional memory space to
	 * 		achieve fast, flicker-free updates.
	 */

	public JWizardPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		init(new GridBagLayout());
	}

	/**
	 * Creates a new JWizardPanel with the specified layout manager and
	 * buffering strategy. The layout is assigned to the panel accessed through
	 * getContentPane().
	 * 
	 * @param layout
	 * 		The LayoutManager for the content pane.
	 * @param isDoubleBuffered
	 * 		True for double-buffering, which uses additional memory space to
	 * 		achieve fast, flicker-free updates.
	 */

	public JWizardPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		init(layout);
	}
	/**
	 * Get the step title to use for this step.
	 * 
	 * @return The step title to use for this step.
	 */
	public String getStepTitle() {
		return stepTitle;
	}

	/**
	 * Get a JPanel to use for adding your own components to this WizardPanel.
	 * Do not add components directly to the JWizardPanel. The JPanel uses the
	 * layout given in the JWizardPanel constructor.
	 * 
	 * @return The JPanel to use for adding components for this wizard step.
	 */

	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * Get the wizard step to go to when the Back button is pressed.
	 * 
	 * @return The wizard step to go to when the Back button is pressed.
	 */

	public int getBackStep() {
		return backStep;
	}

	/**
	 * Set the wizard step to go to when the Back button is pressed. This should
	 * be set in the constructor of the JWizardPanel subclass since it
	 * determines whether the Back button is enabled or not.
	 * 
	 * @param backStep
	 * 		The wizard step to go to when the Back button is pressed.
	 */

	public void setBackStep(int backStep) {
		this.backStep = backStep;
		JWizardDialog dialog = getWizardParent();
		if (dialog != null)
			dialog.setButtonStates();
	}

	/**
	 * Get the wizard step to go to when the Next button is pressed.
	 * 
	 * @return The wizard step to go to when the Next button is pressed.
	 */

	public int getNextStep() {
		return nextStep;
	}

	/**
	 * Set the wizard step to go to when the Next button is pressed. This should
	 * be set in the constructor of the JWizardPanel subclass since it
	 * determines whether the Next and Finish buttons are enabled or not.
	 * 
	 * @param nextStep
	 * 		The wizard step to go to when the Next button is pressed.
	 */

	public void setNextStep(int nextStep) {
		this.nextStep = nextStep;
		JWizardDialog dialog = getWizardParent();
		if (dialog != null)
			dialog.setButtonStates();
	}

	/**
	 * Returns the JWizardDialog in which this JWizardPanel resides. This is
	 * valid only after the panel has been added to the dialog.
	 * 
	 * @return The JWizardDialog in which this JWizardPanel resides.
	 */

	public JWizardDialog getWizardParent() {
		return dialogParent;
	}
	// WizardPanels are equal if they are the same object, so the default
	// equals() and hashCode() methods are acceptable. I'm not using the
	// paramString() method for debugging, so the default is OK.

	// **********************************************************************
	// Package Public
	// **********************************************************************

	/**
	 * Set the JWizardDialog parent for this JWizardPanel.
	 * 
	 * @param dialogParent
	 * 		The JWizardPanel parent for this JWizardPanel.
	 */

	void setWizardParent(JWizardDialog dialogParent) {
		this.dialogParent = dialogParent;
	}

	/**
	 * Calls makingVisible(). This allows the JWizardDialog to call the
	 * protected method makingVisible().
	 * 
	 * @see #makingVisible()
	 */

	void doMakingVisible() {
		makingVisible();
	}

	/**
	 * Calls back(). This allows the JWizardDialog to call the protected method
	 * back().
	 * 
	 * @see #back()
	 */

	void doBack() {
		back();
	}

	/**
	 * Calls next(). This allows the JWizardDialog to call the protected method
	 * next().
	 * 
	 * @see #next()
	 */

	void doNext() {
		next();
	}

	/**
	 * Calls help(). This allows the JWizardDialog to call the protected method
	 * help().
	 * 
	 * @see #help()
	 */

	void doHelp() {
		help();
	}

	// **********************************************************************
	// Protected
	// **********************************************************************

	/**
	 * Called just prior to making this panel visible. This is a hook in case
	 * information in the panel needs to be created dynamically based on
	 * previous steps.
	 */

	protected void makingVisible() {
	}

	/**
	 * Called when the Back button is pressed. By default this displays the
	 * wizard step set by setBackStep().
	 * 
	 * @see #setBackStep(int)
	 */

	protected void back() {
		dialogParent.goTo(getBackStep());
	}

	/**
	 * Called when the Next button is pressed. By default this displays the
	 * wizard step set by setNextStep().
	 * 
	 * @see #setNextStep(int)
	 */

	protected void next() {
		dialogParent.goTo(getNextStep());
	}

	/**
	 * Called when the Help button is pressed. By default this does nothing.
	 */

	protected void help() {
	}

	// **********************************************************************
	// Private
	// **********************************************************************

	/**
	 * 
	 */
	private void init(LayoutManager layout) {
		// Set the layout for the JWizardPanel
		setLayout(new GridBagLayout());
		// Set the layout for the content area
		contentPane = new JPanel(layout);
		// Step title
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.gridy = 0;
		gridBagConstraints4.anchor = GridBagConstraints.CENTER;
		gridBagConstraints4.insets = new Insets(0, 0, 0, 0);
		add(contentPane, gridBagConstraints4);
	}

}
