package efren.util.gui.dialogs;

import java.awt.Dialog;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import efren.seguridades.gui.SystemView;

public class DialogExt extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5722751821167687755L;

	public DialogExt() {
		super(SystemView.singleton(), true);
		//super();
	}

	public DialogExt(JFrame owner) {
		super(owner);
	}

	public DialogExt(Dialog owner) {
		super(owner);
	}

	public DialogExt(JFrame owner, boolean modal) {
		super(owner, modal);
	}

	public DialogExt(JFrame owner, String title) {
		super(owner, title);
	}

	public DialogExt(Dialog owner, boolean modal) {
		super(owner, modal);
	}

	public DialogExt(Dialog owner, String title) {
		super(owner, title);
	}

	public DialogExt(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
	}

	public DialogExt(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
	}

	public DialogExt(JFrame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}

	public DialogExt(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}

	/**
	 * 
	 */
	protected JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action actionListener = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7790846063448335329L;

			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", actionListener);

		return rootPane;
	}
}
