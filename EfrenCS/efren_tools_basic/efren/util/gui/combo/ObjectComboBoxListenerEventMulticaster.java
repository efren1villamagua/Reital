package efren.util.gui.combo;

import java.awt.AWTEventMulticaster;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ObjectComboBoxListenerEventMulticaster extends AWTEventMulticaster implements ObjectComboBoxListener {
	protected ObjectComboBoxListenerEventMulticaster(ObjectComboBoxListener a, ObjectComboBoxListener b) {
		super(a, b);
	}

	public static ObjectComboBoxListener add(ObjectComboBoxListener a, ObjectComboBoxListener b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		return new ObjectComboBoxListenerEventMulticaster(a, b);
	}

	public void keyReleased(KeyEvent newEvent) {
		((ObjectComboBoxListener) a).keyReleased(newEvent);
		((ObjectComboBoxListener) b).keyReleased(newEvent);
	}

	public void focusGained(FocusEvent newEvent) {
		((ObjectComboBoxListener) a).focusGained(newEvent);
		((ObjectComboBoxListener) b).focusGained(newEvent);
	}

	public void focusGained(MouseEvent newEvent) {
		((ObjectComboBoxListener) a).mouseClicked(newEvent);
		((ObjectComboBoxListener) b).mouseClicked(newEvent);
	}

	public static ObjectComboBoxListener remove(ObjectComboBoxListener a, ObjectComboBoxListener b) {
		return (ObjectComboBoxListener) removeInternal(a, b);
	}
}
