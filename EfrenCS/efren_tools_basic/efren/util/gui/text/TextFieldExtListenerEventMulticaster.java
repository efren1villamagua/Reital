package efren.util.gui.text;

import java.util.EventObject;

/**
 * This is the event multicaster class to support the ts.util.date.TextFieldExtListenerEventMulticaster interface.
 */
public class TextFieldExtListenerEventMulticaster
    extends java.awt.AWTEventMulticaster
    implements TextFieldExtListener {
/**
 * Constructor to support multicast evenefren.
 * @param a TextFieldExtListener
 * @param b TextFieldExtListener
 */
protected TextFieldExtListenerEventMulticaster(
    TextFieldExtListener a,
    TextFieldExtListener b) {
    super(a, b);
}
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected TextFieldExtListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void actionPerformed(java.util.EventObject newEvent) {
	((TextFieldExtListener)a).actionPerformed(newEvent);
	((TextFieldExtListener)b).actionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void actionPerformedOnTextField(java.util.EventObject newEvent) {
    ((TextFieldExtListener) a).actionPerformedOnTextField(newEvent);
    ((TextFieldExtListener) b).actionPerformedOnTextField(newEvent);
}
/**
 * Add new listener to support multicast events.
 * @return efren.util.gui.TextFieldExtListener
 * @param a efren.util.gui.TextFieldExtListener
 * @param b efren.util.gui.TextFieldExtListener
 */
public static efren.util.gui.text.TextFieldExtListener add(efren.util.gui.text.TextFieldExtListener a, efren.util.gui.text.TextFieldExtListener b) {
	return (efren.util.gui.text.TextFieldExtListener)addInternal(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return java.util.EventListener
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected static java.util.EventListener addInternal(java.util.EventListener a, java.util.EventListener b) {
	if (a == null)  return b;
	if (b == null)  return a;
	return new TextFieldExtListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void field_keyReleased(EventObject newEvent) {
	((TextFieldExtListener)a).field_keyReleased(newEvent);
	((TextFieldExtListener)b).field_keyReleased(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void focusGained(java.util.EventObject newEvent) {
	((TextFieldExtListener)a).focusGained(newEvent);
	((TextFieldExtListener)b).focusGained(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void focusLost(java.util.EventObject newEvent) {
	((TextFieldExtListener)a).focusLost(newEvent);
	((TextFieldExtListener)b).focusLost(newEvent);
}
/**
 * 
 * @param newEvent java.awt.event.KeyEvent
 */
public void keyReleased(java.awt.event.KeyEvent newEvent) {
	((TextFieldExtListener)a).keyReleased(newEvent);
	((TextFieldExtListener)b).keyReleased(newEvent);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl efren.util.gui.TextFieldExtListener
 */
protected java.util.EventListener remove(efren.util.gui.text.TextFieldExtListener oldl) {
	if (oldl == a)  return b;
	if (oldl == b)  return a;
	java.util.EventListener a2 = removeInternal(a, oldl);
	java.util.EventListener b2 = removeInternal(b, oldl);
	if (a2 == a && b2 == b)
		return this;
	return addInternal(a2, b2);
}
/**
 * Remove listener to support multicast events.
 * @return efren.util.gui.TextFieldExtListener
 * @param l efren.util.gui.TextFieldExtListener
 * @param oldl efren.util.gui.TextFieldExtListener
 */
public static efren.util.gui.text.TextFieldExtListener remove(efren.util.gui.text.TextFieldExtListener l, efren.util.gui.text.TextFieldExtListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof TextFieldExtListenerEventMulticaster)
		return (efren.util.gui.text.TextFieldExtListener)((efren.util.gui.text.TextFieldExtListenerEventMulticaster) l).remove(oldl);
	return l;
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void textDateMouseClicked(java.util.EventObject newEvent) {
	((efren.util.gui.text.TextFieldExtListener)a).textDateMouseClicked(newEvent);
	((efren.util.gui.text.TextFieldExtListener)b).textDateMouseClicked(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void textFieldExtkeyReleased(java.util.EventObject newEvent) {
    ((TextFieldExtListener) a).textFieldExtkeyReleased(newEvent);
    ((TextFieldExtListener) b).textFieldExtkeyReleased(newEvent);
}
}
