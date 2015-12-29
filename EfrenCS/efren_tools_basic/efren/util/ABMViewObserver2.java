package efren.util;

import efren.util.abm.estados.ABMEstado;
public class ABMViewObserver2 {
	private java.util.Vector ventanasAbiertas = new java.util.Vector();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private java.awt.Frame fieldParentFrame = new java.awt.Frame();
	private java.util.Vector keys = new java.util.Vector();
	private java.util.Vector tipos = new java.util.Vector();
/**
 * ABMViewObserver constructor comment.
 */
public ABMViewObserver2() {
	super();
}
public boolean addFrame(java.awt.Frame parentFrame, java.awt.Frame frame, int tipo) {
	// centrada, no maximizada
	return this.addFrame(parentFrame, frame, tipo, false);
}
public boolean addFrame(java.awt.Frame parentFrame, java.awt.Frame frame, int tipo, boolean maximized) {
	
	//...invocado usualmente por ventanas de control de fórmulas
	try {
		java.awt.Frame frameTmp;

		// si es la primera ventana por abrirse, se la abre
		if (ventanasAbiertas.size() < 1) {
			agregarVentana(frame, new Integer(tipo));
			if (maximized)
				WindowManager2.maximize(frame);
			else
				WindowManager2.centerWindowOnThis(parentFrame, frame);			
			frame.setVisible(true);
			return true;
		}

		// se recorre todo el vector de ventanas abiertas, para saber si ya existe una ventana abierta para el tipo dado
		for (int i = 0; i < ventanasAbiertas.size(); i++) {

			int tipoTmp = ((Integer) tipos.elementAt(i)).intValue();
			
			// si se encuentra que ya existe una ventana abierta para el objeto de negocio se la pasa al frente 
			if (tipo == tipoTmp) {
				frameTmp = (java.awt.Frame) ventanasAbiertas.elementAt(i);
				frameTmp.toFront();
				return false;
			}
		}

		// como no hay ventanas abiertas para el objeto de negocio se abre una
		agregarVentana(frame, new Integer(tipo));
		if (maximized)
			WindowManager2.maximize(frame);		
		else
			WindowManager2.centerWindowOnThis(parentFrame, frame);		
		frame.setVisible(true);
		
	} catch (Throwable t) {
		t.getMessage();
		return false;
	}
	
	return true;
}
public boolean addFrame(
    java.awt.Frame parentFrame,
    java.awt.Frame frame,
    String aKey,
    ABMEstado estado) {
    // centrada, no maximizada
    return this.addFrame(parentFrame, frame, aKey, estado, false);
}
public boolean addFrame(
    java.awt.Frame parentFrame,
    java.awt.Frame frame,
    String aKey,
    ABMEstado estado,
    WindowPool windowPool,
    int posInPool) {
    // centrada, no maximizada
    return this.addFrame(parentFrame, frame, aKey, estado, false, windowPool, posInPool);
}
public boolean addFrame(
    java.awt.Frame parentFrame,
    java.awt.Frame frame,
    String aKey,
    ABMEstado estado,
    boolean maximized) {

    //...invocado usualmente por ventanas principales de ABMs para añadir ventanas de detalle

    try {

        //...
        java.awt.Frame frameTmp;
        String keyTmp;

        // si la ventana es para un bo nuevo, solamente se la abre
        if (estado.esNuevo()) {
            agregarVentana(frame, aKey);
            if (maximized)
                WindowManager2.maximize(frame);
            else
                WindowManager2.centerWindowOnThis(parentFrame, frame);
            setABMEstadoOnFrame(frame, estado);
            frame.setTitle(estado.getTitulo());
            frame.setVisible(true);
            return false;
        }

        // si es la primera ventana por abrirse, se la abre
        if (ventanasAbiertas.size() < 1) {
            agregarVentana(frame, aKey);
            if (maximized)
                WindowManager2.maximize(frame);
            else
                WindowManager2.centerWindowOnThis(parentFrame, frame);
            setABMEstadoOnFrame(frame, estado);
            frame.setTitle(estado.getTitulo());
            frame.setVisible(true);
            return true;
        }

        // se recorre todo el vector de ventanas abiertas, para saber si el objeto de negocio tiene ya una ventana abierta
        for (int i = 0; i < ventanasAbiertas.size(); i++) {
            keyTmp = (String) keys.elementAt(i);

            // si se encuentra que ya existe una ventana abierta para el objeto de negocio se la pasa al frente
            if (aKey.trim().compareTo(keyTmp.trim()) == 0) {
                frameTmp = (java.awt.Frame) ventanasAbiertas.elementAt(i);
                frameTmp.toFront();
                return false;
            }
        }

        // como no hay ventanas abiertas para el objeto de negocio se abre una
        agregarVentana(frame, aKey);
        if (maximized)
            WindowManager2.maximize(frame);
        else
            WindowManager2.centerWindowOnThis(parentFrame, frame);
        setABMEstadoOnFrame(frame, estado);
        frame.setTitle(estado.getTitulo());
        frame.setVisible(true);

    } catch (Throwable t) {
        t.getMessage();
        //...
        return false;
    }
    return true;
}
public boolean addFrame(
    java.awt.Frame parentFrame,
    java.awt.Frame frame,
    String aKey,
    ABMEstado estado,
    boolean maximized,
    WindowPool windowPool,
    int posInPool) {

    //...invocado usualmente por ventanas principales de ABMs para añadir ventanas de detalle

    try {

        //...
        java.awt.Frame frameTmp;
        String keyTmp;

        // si la ventana es para un bo nuevo, solamente se la abre
        if (estado.esNuevo()) {
            agregarVentana(frame, aKey);
            if (maximized)
                WindowManager2.maximize(frame);
            else
                WindowManager2.centerWindowOnThis(parentFrame, frame);
            setABMEstadoOnFrame(frame, estado);
            frame.setTitle(estado.getTitulo());
            frame.setVisible(true);
            return false;
        }

        // si es la primera ventana por abrirse, se la abre
        if (ventanasAbiertas.size() < 1) {
            agregarVentana(frame, aKey);
            if (maximized)
                WindowManager2.maximize(frame);
            else
                WindowManager2.centerWindowOnThis(parentFrame, frame);
            setABMEstadoOnFrame(frame, estado);
            frame.setTitle(estado.getTitulo());
            frame.setVisible(true);
            return true;
        }

        // se recorre todo el vector de ventanas abiertas, para saber si el objeto de negocio tiene ya una ventana abierta
        for (int i = 0; i < ventanasAbiertas.size(); i++) {
            keyTmp = (String) keys.elementAt(i);

            // si se encuentra que ya existe una ventana abierta para el objeto de negocio se la pasa al frente
            if (aKey.trim().compareTo(keyTmp.trim()) == 0) {
                frameTmp = (java.awt.Frame) ventanasAbiertas.elementAt(i);
                frameTmp.toFront();
                windowPool.freeWindow(posInPool);
                return false;
            }
        }

        // como no hay ventanas abiertas para el objeto de negocio se abre una
        agregarVentana(frame, aKey);
        if (maximized)
            WindowManager2.maximize(frame);
        else
            WindowManager2.centerWindowOnThis(parentFrame, frame);
        setABMEstadoOnFrame(frame, estado);
        frame.setTitle(estado.getTitulo());
        frame.setVisible(true);

    } catch (Throwable t) {
        t.getMessage();
        //...
        return false;
    }
    return true;
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
private void agregarVentana(java.awt.Frame frame, Integer unTipo) {
	ventanasAbiertas.addElement(frame);
	tipos.addElement(unTipo);
}
private void agregarVentana(java.awt.Frame frame, String aKey) {
	ventanasAbiertas.addElement(frame);
	keys.addElement(aKey);
}
public void cerrarVentanas() {

	/**
	 * éste método cierra todas las ventanas de detalle abiertas
	 * éste método debe ser invocado cuando la ventana principal de algún AMB (o cualquier
	 * otra pantalla principal) es cerrada
	 */
	try {
		for (int i = 0; i < ventanasAbiertas.size(); i++) {
			((java.awt.Frame) ventanasAbiertas.elementAt(i)).dispose();
		}
	} catch (Throwable t) {
		t.getMessage();
	}
}
private void eliminarVentana(java.awt.Frame frame, Integer tipo) {
	if (ventanasAbiertas.contains(frame)) {
		ventanasAbiertas.removeElement(frame);
		tipos.removeElement(tipo);
	}
	frame.dispose();
}
private void eliminarVentana(java.awt.Frame frame, String aKey) {
	if (ventanasAbiertas.contains(frame)) {
		ventanasAbiertas.removeElement(frame);
		keys.removeElement(aKey);
	}
	frame.dispose();
}
private void eliminarVentana(java.awt.Frame frame, String aKey, boolean disposeWindow) {
	if (ventanasAbiertas.contains(frame)) {
		ventanasAbiertas.removeElement(frame);
		keys.removeElement(aKey);
	}
	if (disposeWindow)
		frame.dispose();
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
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
public void removeFrame(java.awt.Frame frame, int tipo) {
	//...invocado usualmente por ventanas de detalle de ABMs de control de fórmulas
	eliminarVentana(frame, new Integer(tipo));
}
public void removeFrame(java.awt.Frame frame, String aKey) {
	//...invocado usualmente por ventanas de detalle de ABMs (con objetos de negocio sin oid)
	eliminarVentana(frame, aKey);
}
public void removeFrame(java.awt.Frame frame, String aKey, boolean disposeWindow) {
	//...invocado usualmente por ventanas de detalle de ABMs (con objetos de negocio sin oid)
	eliminarVentana(frame, aKey, disposeWindow);
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
private void setABMEstadoOnFrame(java.awt.Frame frame, ABMEstado estado) {
    try {
        Object parms[] = { estado };
        Class types[] = { estado.getClass().getSuperclass()};
        MethodInvocation.performMethod("setAbmEstado", frame, parms, types);
    } catch (Throwable t) {
        //...
        t.getMessage();
    }
}
}
