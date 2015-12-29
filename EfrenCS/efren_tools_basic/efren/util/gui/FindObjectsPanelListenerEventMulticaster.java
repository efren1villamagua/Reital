package efren.util.gui;

/**
 * This is the event multicaster class to support the efren.abm.beans.FindObjectsPanelListenerEventMulticaster interface.
 */
public class FindObjectsPanelListenerEventMulticaster extends java.awt.AWTEventMulticaster implements efren.util.gui.FindObjectsPanelListener {
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected FindObjectsPanelListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return efren.abm.beans.FindObjectsPanelListener
 * @param a efren.abm.beans.FindObjectsPanelListener
 * @param b efren.abm.beans.FindObjectsPanelListener
 */
public static efren.util.gui.FindObjectsPanelListener add(efren.util.gui.FindObjectsPanelListener a, efren.util.gui.FindObjectsPanelListener b) {
	return (efren.util.gui.FindObjectsPanelListener)addInternal(a, b);
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
	return new FindObjectsPanelListenerEventMulticaster(a, b);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl efren.abm.beans.FindObjectsPanelListener
 */
protected java.util.EventListener remove(efren.util.gui.FindObjectsPanelListener oldl) {
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
 * @return efren.abm.beans.FindObjectsPanelListener
 * @param l efren.abm.beans.FindObjectsPanelListener
 * @param oldl efren.abm.beans.FindObjectsPanelListener
 */
public static efren.util.gui.FindObjectsPanelListener remove(efren.util.gui.FindObjectsPanelListener l, efren.util.gui.FindObjectsPanelListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof FindObjectsPanelListenerEventMulticaster)
		return (efren.util.gui.FindObjectsPanelListener)((efren.util.gui.FindObjectsPanelListenerEventMulticaster) l).remove(oldl);
	return l;
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void selectedObject(java.util.EventObject newEvent) {
	((efren.util.gui.FindObjectsPanelListener)a).selectedObject(newEvent);
	((efren.util.gui.FindObjectsPanelListener)b).selectedObject(newEvent);
}
}
