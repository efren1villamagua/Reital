package efren.util.gui.combo;

public class ComboTABLEListenerEventMulticaster extends java.awt.AWTEventMulticaster implements ComboTABLEListener {
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected ComboTABLEListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return ComboTABLEListener
 * @param a ComboTABLEListener
 * @param b ComboTABLEListener
 */
public static ComboTABLEListener add(ComboTABLEListener a, ComboTABLEListener b) {
	return (ComboTABLEListener)addInternal(a, b);
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
	return new ComboTABLEListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void itemSelected(java.util.EventObject newEvent) {
	((ComboTABLEListener)a).itemSelected(newEvent);
	((ComboTABLEListener)b).itemSelected(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void itemStateChanged(java.util.EventObject newEvent) {
	((ComboTABLEListener)a).itemStateChanged(newEvent);
	((ComboTABLEListener)b).itemStateChanged(newEvent);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl ComboTABLEListener
 */
protected java.util.EventListener remove(ComboTABLEListener oldl) {
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
 * @return ComboTABLEListener
 * @param l ComboTABLEListener
 * @param oldl ComboTABLEListener
 */
public static ComboTABLEListener remove(ComboTABLEListener l, ComboTABLEListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof ComboTABLEListenerEventMulticaster)
		return (ComboTABLEListener)((ComboTABLEListenerEventMulticaster) l).remove(oldl);
	return l;
}
}
