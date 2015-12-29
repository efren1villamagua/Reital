package efren.util.gui.combo;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface ObjectComboBoxListener extends java.util.EventListener {
	/**
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	void keyReleased(KeyEvent newEvent);

	void focusGained(FocusEvent newEvent);

	void mouseClicked(MouseEvent newEvent);
}
