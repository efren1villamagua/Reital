package efren.util.gui;

/**
 * This is the event multicaster class to support the com.truesoft.util.gui.MultiChoiceListenerEventMulticaster interface.
 */
public class MultiChoiceListenerEventMulticaster extends java.awt.AWTEventMulticaster implements MultiChoiceListener {
/**
 * Constructor to support multicast events.
 * @param a MultiChoiceListener
 * @param b MultiChoiceListener
 */
protected MultiChoiceListenerEventMulticaster(MultiChoiceListener a, MultiChoiceListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return MultiChoiceListener
 * @param a MultiChoiceListener
 * @param b MultiChoiceListener
 */
public static MultiChoiceListener add(MultiChoiceListener a, MultiChoiceListener b) {
	if (a == null)  return b;
	if (b == null)  return a;
	return new MultiChoiceListenerEventMulticaster(a, b);
}
/**
 * Remove listener to support multicast events.
 * @return MultiChoiceListener
 * @param a MultiChoiceListener
 * @param b MultiChoiceListener
 */
public static MultiChoiceListener remove(MultiChoiceListener a, MultiChoiceListener b) {
	return (MultiChoiceListener)removeInternal(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void selectedOptionChanged(java.util.EventObject newEvent) {
	((MultiChoiceListener)a).selectedOptionChanged(newEvent);
	((MultiChoiceListener)b).selectedOptionChanged(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void selectedOptionChanged1(java.util.EventObject newEvent) {
	((MultiChoiceListener)a).selectedOptionChanged1(newEvent);
	((MultiChoiceListener)b).selectedOptionChanged1(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void selectedOptionChanged2(java.util.EventObject newEvent) {
	((MultiChoiceListener)a).selectedOptionChanged2(newEvent);
	((MultiChoiceListener)b).selectedOptionChanged2(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void selectedOptionChanged3(java.util.EventObject newEvent) {
	((MultiChoiceListener)a).selectedOptionChanged3(newEvent);
	((MultiChoiceListener)b).selectedOptionChanged3(newEvent);
}
}
