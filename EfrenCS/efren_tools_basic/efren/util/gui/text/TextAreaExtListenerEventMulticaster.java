package efren.util.gui.text;

public class TextAreaExtListenerEventMulticaster extends java.awt.AWTEventMulticaster implements TextAreaExtListener {
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected TextAreaExtListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return TextAreaExtListener
 * @param a TextAreaExtListener
 * @param b TextAreaExtListener
 */
public static TextAreaExtListener add(TextAreaExtListener a, TextAreaExtListener b) {
	return (TextAreaExtListener)addInternal(a, b);
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
	return new TextAreaExtListenerEventMulticaster(a, b);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl TextAreaExtListener
 */
protected java.util.EventListener remove(TextAreaExtListener oldl) {
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
 * @return TextAreaExtListener
 * @param l TextAreaExtListener
 * @param oldl TextAreaExtListener
 */
public static TextAreaExtListener remove(TextAreaExtListener l, TextAreaExtListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof TextAreaExtListenerEventMulticaster)
		return (TextAreaExtListener)((TextAreaExtListenerEventMulticaster) l).remove(oldl);
	return l;
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void textAreaFocusLost(java.util.EventObject newEvent) {
	((TextAreaExtListener)a).textAreaFocusLost(newEvent);
	((TextAreaExtListener)b).textAreaFocusLost(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void textAreaKeyReleased(java.util.EventObject newEvent) {
	((TextAreaExtListener)a).textAreaKeyReleased(newEvent);
	((TextAreaExtListener)b).textAreaKeyReleased(newEvent);
}
}
