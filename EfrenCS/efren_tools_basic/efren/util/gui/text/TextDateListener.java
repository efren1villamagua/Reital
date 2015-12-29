package efren.util.gui.text;

import java.util.EventListener;
import java.util.EventObject;

public interface TextDateListener extends EventListener {
	
	void actionPerformedOnTextField(EventObject newEvent);
	void keyReleased(EventObject newEvent);
	void textDateActionPerformed(EventObject newEvent);
	void textDateFocusLost(EventObject newEvent);
	void textDatekeyReleased(EventObject newEvent);
	
}
