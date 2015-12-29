package efren.util.gui.bars;

/**
 * This is the event multicaster class to support the com.truesoft.abm.beans.Bar02PanelListenerEventMulticaster interface.
 */
public class Bar02PanelListenerEventMulticaster extends java.awt.AWTEventMulticaster implements Bar02PanelListener {
/**
 * Constructor to support multicast events.
 * @param a Bar02PanelListener
 * @param b Bar02PanelListener
 */
protected Bar02PanelListenerEventMulticaster(Bar02PanelListener a, Bar02PanelListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return Bar02PanelListener
 * @param a Bar02PanelListener
 * @param b Bar02PanelListener
 */
public static Bar02PanelListener add(Bar02PanelListener a, Bar02PanelListener b) {
	if (a == null)  return b;
	if (b == null)  return a;
	return new Bar02PanelListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void button00ActionPerformed(java.util.EventObject newEvent) {
	((Bar02PanelListener)a).button00ActionPerformed(newEvent);
	((Bar02PanelListener)b).button00ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void button01ActionPerformed(java.util.EventObject newEvent) {
	((Bar02PanelListener)a).button01ActionPerformed(newEvent);
	((Bar02PanelListener)b).button01ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void button02ActionPerformed(java.util.EventObject newEvent) {
	((Bar02PanelListener)a).button02ActionPerformed(newEvent);
	((Bar02PanelListener)b).button02ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void button03ActionPerformed(java.util.EventObject newEvent) {
	((Bar02PanelListener)a).button03ActionPerformed(newEvent);
	((Bar02PanelListener)b).button03ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void button10ActionPerformed(java.util.EventObject newEvent) {
	((Bar02PanelListener)a).button10ActionPerformed(newEvent);
	((Bar02PanelListener)b).button10ActionPerformed(newEvent);
}
/**
 * Remove listener to support multicast events.
 * @return Bar02PanelListener
 * @param a Bar02PanelListener
 * @param b Bar02PanelListener
 */
public static Bar02PanelListener remove(Bar02PanelListener a, Bar02PanelListener b) {
	return (Bar02PanelListener)removeInternal(a, b);
}
}
