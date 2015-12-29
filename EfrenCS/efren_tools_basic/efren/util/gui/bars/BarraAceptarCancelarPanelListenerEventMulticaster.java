package efren.util.gui.bars;

/**
 * This is the event multicaster class to support the ts.abm.beans.TsBarraAceptarCancelarPanelListenerEventMulticaster interface.
 */
public class BarraAceptarCancelarPanelListenerEventMulticaster extends java.awt.AWTEventMulticaster implements BarraAceptarCancelarPanelListener {
/**
 * Constructor to support multicast events.
 * @param a ts.abm.beans.TsBarraAceptarCancelarPanelListener
 * @param b ts.abm.beans.TsBarraAceptarCancelarPanelListener
 */
protected BarraAceptarCancelarPanelListenerEventMulticaster(BarraAceptarCancelarPanelListener a, BarraAceptarCancelarPanelListener b) {
	super(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void aceptarClicked(java.util.EventObject newEvent) {
	((BarraAceptarCancelarPanelListener)a).aceptarClicked(newEvent);
	((BarraAceptarCancelarPanelListener)b).aceptarClicked(newEvent);
}
/**
 * Add new listener to support multicast events.
 * @return ts.abm.beans.TsBarraAceptarCancelarPanelListener
 * @param a ts.abm.beans.TsBarraAceptarCancelarPanelListener
 * @param b ts.abm.beans.TsBarraAceptarCancelarPanelListener
 */
public static BarraAceptarCancelarPanelListener add(BarraAceptarCancelarPanelListener a, BarraAceptarCancelarPanelListener b) {
	if (a == null)  return b;
	if (b == null)  return a;
	return new BarraAceptarCancelarPanelListenerEventMulticaster(a, b);
}
/**
 * 
 * @param newEvent java.util.EventObject
 */
public void cancelarClicked(java.util.EventObject newEvent) {
	((BarraAceptarCancelarPanelListener)a).cancelarClicked(newEvent);
	((BarraAceptarCancelarPanelListener)b).cancelarClicked(newEvent);
}
/**
 * Remove listener to support multicast events.
 * @return ts.abm.beans.TsBarraAceptarCancelarPanelListener
 * @param a ts.abm.beans.TsBarraAceptarCancelarPanelListener
 * @param b ts.abm.beans.TsBarraAceptarCancelarPanelListener
 */
public static BarraAceptarCancelarPanelListener remove(BarraAceptarCancelarPanelListener a, BarraAceptarCancelarPanelListener b) {
	return (BarraAceptarCancelarPanelListener)removeInternal(a, b);
}
}
