package efren.util;

public class WindowObserver2 {
	private java.util.Vector openWindows;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private java.awt.Frame fieldParentFrame = new java.awt.Frame();
	private java.util.Vector codes;	
	private boolean fieldObserverOnly = false;
	private static WindowObserver2 singleton;
/**
 * ABMViewObserver constructor comment.
 */
private WindowObserver2() {
	super();
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
public boolean addWindow(java.awt.Window parentWindow, java.awt.Window window, String code) {
	try {
		java.awt.Window windowTmp;

		updateWindowList();		
		
		/* si es la primera ventana por abrirse, se la abre */
		if (getOpenWindows().size() < 1) {
			agregarWindow(window, code);
			if (parentWindow != null)
				WindowManager2.centerWindowOnThis(parentWindow, window);
			window.setVisible(true);
			//updateWindowList();			
			return true;
		}

		/* se recorre todo el vector de ventanas abiertas, para saber si ya existe una ventana abierta para el codigo dado */
		for (int i = 0; i < getOpenWindows().size(); i++) {
			String aCode = (String) getCodes().elementAt(i);

			/* si se encuentra que ya existe una ventana abierta para el código dado se la pasa al frente */
			if (code.trim().compareTo(aCode.trim()) == 0) {
				windowTmp = (java.awt.Window) getOpenWindows().elementAt(i);
				windowTmp.toFront();
				//updateWindowList();
				return false;
			}
		}

		/* como no hay ventanas abiertas para el código dado, se abre una */
		agregarWindow(window, code);
		if (parentWindow != null)
			WindowManager2.centerWindowOnThis(parentWindow, window);
		window.setVisible(true);
		//updateWindowList();		
	} catch (Throwable t) {
		t.getMessage();
		//...
		return false;
	}
	return true;
}
public boolean addWindow(java.awt.Window parentWindow, java.awt.Window window, String code, boolean maximized) {
	
	if (!maximized)
		return this.addWindow(parentWindow, window, code);
		
	updateWindowList();
	 
	try {
		java.awt.Window windowTmp;

		/* si es la primera ventana por abrirse, se la abre */
		if (getOpenWindows().size() < 1) {
			agregarWindow(window, code);
			WindowManager2.maximize(window);
			window.setVisible(true);
			//updateWindowList();
			return true;
		}

		/* se recorre todo el vector de ventanas abiertas, para saber si ya existe una ventana abierta para el código dado */
		for (int i = 0; i < getOpenWindows().size(); i++) {
			String aCode = (String) getCodes().elementAt(i);

			/* si se encuentra que ya existe una ventana abierta para el código dado se la pasa al frente */
			if (code.trim().compareTo(aCode.trim()) == 0) {
				windowTmp = (java.awt.Window) getOpenWindows().elementAt(i);
				windowTmp.toFront();
				//updateWindowList();				
				return false;
			}
		}

		/* como no hay ventanas abiertas para el código dado se abre una */
		agregarWindow(window, code);
		WindowManager2.maximize(window);
		window.setVisible(true);
		//updateWindowList();		
	} catch (Throwable t) {
		t.getMessage();
		//...
		return false;
	}
	return true;
}
private void agregarWindow(java.awt.Window window, String code) {
	getOpenWindows().addElement(window);
	getCodes().addElement(code);
}
public static void clear() {
	singleton = null;
}
public void closeWindows() {
	java.awt.Window window = null;

	/**
	 * éste método cierra todas las ventanas abiertas
	 */
	for (int i = 0; i < getOpenWindows().size(); i++) {
		try {
			window = ((java.awt.Window) getOpenWindows().elementAt(i));
			forceCloseChildWindowsFor(window);
			window.dispose();
		} catch (Throwable t) {
			t.getMessage();
			window.dispose();
		}
	}
}
private void eliminarWindow(java.awt.Window window, String code) {
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
private void forceCloseChildWindowsFor(java.awt.Window window) throws Throwable {
	java.lang.reflect.Method methods[] = window.getClass().getDeclaredMethods();
	Class aClass = null;
	for (int i = 0; i < methods.length; i++) {
		aClass = (Class) methods[i].getReturnType();
		if (aClass.getName().compareTo("com.truesoft.util.ABMViewObserver") == 0) {
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
public void removeWindow(java.awt.Window window, String code) {
	eliminarWindow(window, code);
}

private void setCodes(java.util.Vector newValue) {
	this.codes = newValue;
}

private void setOpenWindows(java.util.Vector newValue) {
	this.openWindows = newValue;
}
public static WindowObserver2 singleton() {
	if (singleton == null)
		singleton = new WindowObserver2();
	return singleton;
}
/**
 * Este método revisa la lista de ventanas:
 * - si una ventana de la lista tiene el atributo isShowing en false se la elimina de la lista
 */
private void updateWindowList() {
	java.awt.Window window = null;
	for (int i = 0; i < getOpenWindows().size(); i++) {
		window = (java.awt.Window) getOpenWindows().elementAt(i);
		if (!window.isShowing())
			eliminarWindow(window, window.getName());
	}
}
}
