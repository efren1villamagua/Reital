package efren.util.gui.text;

import java.util.EventObject;

public interface TextFieldExtListener extends java.util.EventListener {
/**
 * 
 * @param newEvent java.util.EventObject
 */
void actionPerformed(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void actionPerformedOnTextField(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void field_keyReleased(EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void focusGained(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void focusLost(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.awt.event.KeyEvent
 */
void keyReleased(java.awt.event.KeyEvent newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void textDateMouseClicked(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void textFieldExtkeyReleased(java.util.EventObject newEvent);
}
