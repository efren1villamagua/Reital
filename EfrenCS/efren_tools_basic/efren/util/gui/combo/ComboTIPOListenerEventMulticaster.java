package efren.util.gui.combo;

public class ComboTIPOListenerEventMulticaster extends java.awt.AWTEventMulticaster implements ComboTIPOListener {
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected ComboTIPOListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return ComboTIPOListener
 * @param a ComboTIPOListener
 * @param b ComboTIPOListener
 */
public static ComboTIPOListener add(ComboTIPOListener a, ComboTIPOListener b) {
	return (ComboTIPOListener)addInternal(a, b);
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
	return new ComboTIPOListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void itemSelected(java.util.EventObject newEvent) {
	((ComboTIPOListener)a).itemSelected(newEvent);
	((ComboTIPOListener)b).itemSelected(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void itemStateChanged(java.util.EventObject newEvent) {
	((ComboTIPOListener)a).itemStateChanged(newEvent);
	((ComboTIPOListener)b).itemStateChanged(newEvent);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl ComboTIPOListener
 */
protected java.util.EventListener remove(ComboTIPOListener oldl) {
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
 * @return ComboTIPOListener
 * @param l ComboTIPOListener
 * @param oldl ComboTIPOListener
 */
public static ComboTIPOListener remove(ComboTIPOListener l, ComboTIPOListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof ComboTIPOListenerEventMulticaster)
		return (ComboTIPOListener)((ComboTIPOListenerEventMulticaster) l).remove(oldl);
	return l;
}
}
