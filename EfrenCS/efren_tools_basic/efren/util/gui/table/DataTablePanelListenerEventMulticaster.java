package efren.util.gui.table;

public class DataTablePanelListenerEventMulticaster extends java.awt.AWTEventMulticaster implements DataTablePanelListener {
/**
 * Constructor to support multicast events.
 * @param a java.util.EventListener
 * @param b java.util.EventListener
 */
protected DataTablePanelListenerEventMulticaster(java.util.EventListener a, java.util.EventListener b) {
	super(a, b);
}
/**
 * Add new listener to support multicast events.
 * @return DataTablePanelListener
 * @param a DataTablePanelListener
 * @param b DataTablePanelListener
 */
public static DataTablePanelListener add(DataTablePanelListener a, DataTablePanelListener b) {
	return (DataTablePanelListener)addInternal(a, b);
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
	return new DataTablePanelListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void buscarPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).buscarPerformed(newEvent);
	((DataTablePanelListener)b).buscarPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void comboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).comboBoxORDERBYItemSelected(newEvent);
	((DataTablePanelListener)b).comboBoxORDERBYItemSelected(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void opcionesBarButton00ActionPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).opcionesBarButton00ActionPerformed(newEvent);
	((DataTablePanelListener)b).opcionesBarButton00ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void opcionesBarButton01ActionPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).opcionesBarButton01ActionPerformed(newEvent);
	((DataTablePanelListener)b).opcionesBarButton01ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void opcionesBarButton02ActionPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).opcionesBarButton02ActionPerformed(newEvent);
	((DataTablePanelListener)b).opcionesBarButton02ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void opcionesBarButton03ActionPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).opcionesBarButton03ActionPerformed(newEvent);
	((DataTablePanelListener)b).opcionesBarButton03ActionPerformed(newEvent);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void opcionesBarButton10ActionPerformed(java.util.EventObject newEvent) {
	((DataTablePanelListener)a).opcionesBarButton10ActionPerformed(newEvent);
	((DataTablePanelListener)b).opcionesBarButton10ActionPerformed(newEvent);
}
/**
 * 
 * @return java.util.EventListener
 * @param oldl DataTablePanelListener
 */
protected java.util.EventListener remove(DataTablePanelListener oldl) {
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
 * @return DataTablePanelListener
 * @param l DataTablePanelListener
 * @param oldl DataTablePanelListener
 */
public static DataTablePanelListener remove(DataTablePanelListener l, DataTablePanelListener oldl) {
	if (l == oldl || l == null)
		return null;
	if(l instanceof DataTablePanelListenerEventMulticaster)
		return (DataTablePanelListener)((DataTablePanelListenerEventMulticaster) l).remove(oldl);
	return l;
}
}
