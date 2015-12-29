package efren.util.gui.combo;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboBoxExt extends JComboBox {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2680323244064405555L;

	/**
	 * ComboBoxExt constructor comment.
	 */
	public ComboBoxExt() {
		super();
		initialize();
	}

	/**
	 * ComboBoxExt constructor comment.
	 * 
	 * @param items
	 *            java.lang.Object[]
	 */
	public ComboBoxExt(java.lang.Object[] items) {
		super(items);
	}

	/**
	 * ComboBoxExt constructor comment.
	 * 
	 * @param items
	 *            java.util.Vector
	 */
	public ComboBoxExt(java.util.Vector items) {
		super(items);
	}

	/**
	 * ComboBoxExt constructor comment.
	 * 
	 * @param aModel
	 *            ComboBoxModel
	 */
	public ComboBoxExt(ComboBoxModel aModel) {
		super(aModel);
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
			setName("ComboBoxExt");
			setSize(130, 20);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}

	public void setSelectedItem(Object anObject) {
		super.setSelectedItem(anObject);

		JTextField editor = (JTextField) this.getEditor().getEditorComponent();
		editor.setSelectionStart(0);
		editor.setSelectionEnd(0);
		// editor.requestDefaultFocus();
		editor.requestFocus();

		try {
			//if (isPopupVisible()) {
			//hidePopup();//TODO OJO ????
			//}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
