package efren.util.gui.text;

import java.util.EventObject;

/**
 * This is the event multicaster class to support the ts.util.date.PasswordFieldExtListenerEventMulticaster interface.
 */
public class PasswordFieldExtListenerEventMulticaster
    extends java.awt.AWTEventMulticaster
    implements PasswordFieldExtListener {
/**
 * Constructor to support multicast evenefren.
 * @param a PasswordFieldExtListener
 * @param b PasswordFieldExtListener
 */
protected PasswordFieldExtListenerEventMulticaster(
    PasswordFieldExtListener a,
    PasswordFieldExtListener b) {
    super(a, b);
}
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected PasswordFieldExtListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void actionPerformed(java.util.EventObject newEvent) {
	((PasswordFieldExtListener)a).actionPerformed(newEvent);
	((PasswordFieldExtListener)b).actionPerformed(newEvent);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void actionPerformedOnTextField(java.util.EventObject newEvent) {
    ((PasswordFieldExtListener) a).actionPerformedOnTextField(newEvent);
    ((PasswordFieldExtListener) b).actionPerformedOnTextField(newEvent);
}
/**
 * Add new listener to support multicast events.
 * @return efren.util.gui.PasswordFieldExtListener
 * @param a efren.util.gui.PasswordFieldExtListener
 * @param b efren.util.gui.PasswordFieldExtListener
 */
public static efren.util.gui.text.PasswordFieldExtListener add(efren.util.gui.text.PasswordFieldExtListener a, efren.util.gui.text.PasswordFieldExtListener b) {
	return (efren.util.gui.text.PasswordFieldExtListener)addInternal(a, b);
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
	return new PasswordFieldExtListenerEventMulticaster(a, b);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void field_keyReleased(EventObject newEvent) {
	((PasswordFieldExtListener)a).field_keyReleased(newEvent);
	((PasswordFieldExtListener)b).field_keyReleased(newEvent);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void focusGained(java.util.EventObject newEvent) {
	((PasswordFieldExtListener)a).focusGained(newEvent);
	((PasswordFieldExtListener)b).focusGained(newEvent);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void focusLost(java.util.EventObject newEvent) {
	((PasswordFieldExtListener)a).focusLost(newEvent);
	((PasswordFieldExtListener)b).focusLost(newEvent);
}
/**
 *
 * @param newEvent java.awt.event.KeyEvent
 */
public void keyReleased(java.awt.event.KeyEvent newEvent) {
	((PasswordFieldExtListener)a).keyReleased(newEvent);
	((PasswordFieldExtListener)b).keyReleased(newEvent);
}
/**
 *
 * @return java.util.EventListener
 * @param oldl efren.util.gui.PasswordFieldExtListener
 */
protected java.util.EventListener remove(efren.util.gui.text.PasswordFieldExtListener oldl) {
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
 * @return efren.util.gui.PasswordFieldExtListener
 * @param l efren.util.gui.PasswordFieldExtListener
 * @param oldl efren.util.gui.PasswordFieldExtListener
 */
public static efren.util.gui.text.PasswordFieldExtListener remove(efren.util.gui.text.PasswordFieldExtListener l, efren.util.gui.text.PasswordFieldExtListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof PasswordFieldExtListenerEventMulticaster)
		return (efren.util.gui.text.PasswordFieldExtListener)((efren.util.gui.text.PasswordFieldExtListenerEventMulticaster) l).remove(oldl);
	return l;
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void textDateMouseClicked(java.util.EventObject newEvent) {
	((efren.util.gui.text.PasswordFieldExtListener)a).textDateMouseClicked(newEvent);
	((efren.util.gui.text.PasswordFieldExtListener)b).textDateMouseClicked(newEvent);
}
/**
 *
 * @param newEvent java.util.EventObject
 */
public void passwordFieldExtkeyReleased(java.util.EventObject newEvent) {
    ((PasswordFieldExtListener) a).passwordFieldExtkeyReleased(newEvent);
    ((PasswordFieldExtListener) b).passwordFieldExtkeyReleased(newEvent);
}
}
