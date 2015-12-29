package efren.util;

public class WindowObserver {
	private java.util.Vector openWindows;
	protected transient java.beans.PropertyChangeSupport propertyChange;
//	private java.awt.Frame fieldParentFrame = new java.awt.Frame();
	private java.util.Vector codes;	
	private boolean fieldObserverOnly = false;
	private static WindowObserver singleton;
/**
 * ABMViewObserver constructor comment.
 */
private WindowObserver() {
	super();
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
public boolean addWindow(javax.swing.JInternalFrame parentWindow, javax.swing.JInternalFrame window, String code) {
	try {
		javax.swing.JInternalFrame windowTmp;

		updateWindowList();		
		
		/* si es la primera ventana por abrirse, se la abre */
		if (getOpenWindows().size() < 1) {
			agregarWindow(window, code);
			if (parentWindow != null)
				WindowManager.centerWindowOnThis(parentWindow, window);
			window.show();
			//updateWindowList();			
			return true;
		}

		/* se recorre todo el vector de ventanas abiertas, para saber si ya existe una ventana abierta para el codigo dado */
		for (int i = 0; i < getOpenWindows().size(); i++) {
			String aCode = (String) getCodes().elementAt(i);

			/* si se encuentra que ya existe una ventana abierta para el código dado se la pasa al frente */
			if (code.trim().compareTo(aCode.trim()) == 0) {
				windowTmp = (javax.swing.JInternalFrame) getOpenWindows().elementAt(i);
				windowTmp.toFront();
				//updateWindowList();
				return false;
			}
		}

		/* como no hay ventanas abiertas para el código dado, se abre una */
		agregarWindow(window, code);
		if (parentWindow != null)
			WindowManager.centerWindowOnThis(parentWindow, window);
		window.show();
		//updateWindowList();		
	} catch (Throwable t) {
		t.getMessage();
		//...
		return false;
	}
	return true;
}
public boolean addWindow(javax.swing.JInternalFrame parentWindow, javax.swing.JInternalFrame window, String code, boolean maximized) {
	
	if (!maximized)
		return this.addWindow(parentWindow, window, code);
		
	updateWindowList();
	 
	try {
		javax.swing.JInternalFrame windowTmp;

		/* si es la primera ventana por abrirse, se la abre */
		if (getOpenWindows().size() < 1) {
			agregarWindow(window, code);
			WindowManager.maximize(window);
			window.show();
			//updateWindowList();
			return true;
		}

		/* se recorre todo el vector de ventanas abiertas, para saber si ya existe una ventana abierta para el código dado */
		for (int i = 0; i < getOpenWindows().size(); i++) {
			String aCode = (String) getCodes().elementAt(i);

			/* si se encuentra que ya existe una ventana abierta para el código dado se la pasa al frente */
			if (code.trim().compareTo(aCode.trim()) == 0) {
				windowTmp = (javax.swing.JInternalFrame) getOpenWindows().elementAt(i);
				windowTmp.toFront();
				//updateWindowList();				
				return false;
			}
		}

		/* como no hay ventanas abiertas para el código dado se abre una */
		agregarWindow(window, code);
		WindowManager.maximize(window);
		window.show();
		//updateWindowList();		
	} catch (Throwable t) {
		t.getMessage();
		//...
		return false;
	}
	return true;
}
private void agregarWindow(javax.swing.JInternalFrame window, String code) {
	getOpenWindows().addElement(window);
	getCodes().addElement(code);
}
public static void clear() {
	singleton = null;
}
public void closeWindows() {
	javax.swing.JInternalFrame window = null;

	/**
	 * éste método cierra todas las ventanas abiertas
	 */
	for (int i = 0; i < getOpenWindows().size(); i++) {
		try {
			window = ((javax.swing.JInternalFrame) getOpenWindows().elementAt(i));
			forceCloseChildWindowsFor(window);
			window.dispose();
		} catch (Throwable t) {
			t.getMessage();
			window.dispose();
		}
	}
}
private void eliminarWindow(javax.swing.JInternalFrame window, String code) {
	if (getOpenWindows().contains(window)) {
		getOpenWindows().removeElement(window);
		getCodes().removeElement(code);
	}
	window.dispose();
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
private void forceCloseChildWindowsFor(javax.swing.JInternalFrame window) throws Throwable {
	java.lang.reflect.Method methods[] = window.getClass().getDeclaredMethods();
	Class aClass = null;
	for (int i = 0; i < methods.length; i++) {
		aClass = (Class) methods[i].getReturnType();
		if (aClass.getName().compareTo("efren.util.ABMViewObserver") == 0) {
			Object args[] = {};
			ABMViewObserver observer = (ABMViewObserver) ((java.lang.reflect.Method) methods[i]).invoke(window, args);
			observer.cerrarVentanas();
		}
	}
}

private java.util.Vector getCodes() {
	if (codes == null)
		codes = new java.util.Vector();
	return codes;
}

private java.util.Vector getOpenWindows() {
	if (openWindows == null)
		openWindows = new java.util.Vector();
	return openWindows;
}
/**
 * Accessor for the propertyChange field.
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
public void removeWindow(javax.swing.JInternalFrame window, String code) {
	eliminarWindow(window, code);
}

private void setCodes(java.util.Vector newValue) {
	this.codes = newValue;
}

private void setOpenWindows(java.util.Vector newValue) {
	this.openWindows = newValue;
}
public static WindowObserver singleton() {
	if (singleton == null)
		singleton = new WindowObserver();
	return singleton;
}
/**
 * Este método revisa la lista de ventanas:
 * - si una ventana de la lista tiene el atributo isShowing en false se la elimina de la lista
 */
private void updateWindowList() {
	javax.swing.JInternalFrame window = null;
	for (int i = 0; i < getOpenWindows().size(); i++) {
		window = (javax.swing.JInternalFrame) getOpenWindows().elementAt(i);
		if (!window.isShowing())
			eliminarWindow(window, window.getName());
	}
}
}
