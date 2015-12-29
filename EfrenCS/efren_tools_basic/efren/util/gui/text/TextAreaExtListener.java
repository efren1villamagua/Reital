package efren.util.gui.text;

public interface TextAreaExtListener extends java.util.EventListener {
/**
 * 
 * @param newEvent java.util.EventObject
 */
void textAreaFocusLost(java.util.EventObject newEvent);
/**
 * 
 * @param newEvent java.util.EventObject
 */
void textAreaKeyReleased(java.util.EventObject newEvent);
}
