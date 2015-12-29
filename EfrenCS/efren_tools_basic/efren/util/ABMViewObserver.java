package efren.util;

import efren.util.abm.estados.ABMEstado;
import efren.util.config.SystemProperties;
public class ABMViewObserver {
	public static String DELEGATE_WINDOW_OPEN_MODE_FIXED_LOCATION = "fixedLocation";
	public static String DELEGATE_WINDOW_OPEN_MODE_CENTERED = "centered";
	private String DELEGATE_WINDOW_OPEN_MODE = DELEGATE_WINDOW_OPEN_MODE_CENTERED;
	private java.util.Vector ventanasAbiertas = new java.util.Vector();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	//private javax.swing.JInternalFrame parentFrame = new javax.swing.JInternalFrame();
	private java.util.Vector keys = new java.util.Vector();
	private java.util.Vector tipos = new java.util.Vector();
	/**
	 * ABMViewObserver constructor comment.
	 */
	public ABMViewObserver() {
	    super();

	    this.DELEGATE_WINDOW_OPEN_MODE = SystemProperties.DELEGATE_WINDOW_OPEN_MODE;
	}
	private void _situateWindow(javax.swing.JInternalFrame frame1, javax.swing.JInternalFrame frame2) {
	    if (this.DELEGATE_WINDOW_OPEN_MODE.compareTo(DELEGATE_WINDOW_OPEN_MODE_CENTERED) == 0) {
	        WindowManager.centerWindowOnThis(frame1, frame2);
	    } else {
	        if (this.DELEGATE_WINDOW_OPEN_MODE.compareTo(DELEGATE_WINDOW_OPEN_MODE_FIXED_LOCATION) == 0) {
	            frame2.setLocation(5,5); //ESTO ES FIJO POR AHORA, SE DEBE CAMBIAR!!!!!!!!!!!!!!!!!
	        }
	    }
	}
	public boolean addFrame(javax.swing.JInternalFrame parentFrame, javax.swing.JInternalFrame frame,
		String aKey, ABMEstado estado) {
	    // centrada, no maximizada
	    return this.addFrame(parentFrame, frame, aKey, estado, false);
	}
	public boolean addFrame(
	    javax.swing.JInternalFrame parentFrame,
	    javax.swing.JInternalFrame frame,
	    String aKey,
	    ABMEstado estado,
	    WindowPool windowPool,
	    int posInPool) {
	    // centrada, no maximizada
	    return this.addFrame(parentFrame, frame, aKey, estado, false, windowPool, posInPool);
	}
	public boolean addFrame(
	    javax.swing.JInternalFrame parentFrame,
	    javax.swing.JInternalFrame frame,
	    String aKey,
	    ABMEstado estado,
	    boolean maximized) {

	    //...invocado usualmente por ventanas principales de ABMs para añadir ventanas de detalle

		try {
			frame.setFrameIcon(parentFrame.getFrameIcon());
		} catch (Exception e2) {
			e2.getMessage();
		}

	    try {
	        /*
	        frame.getContentPane().setBackground(estado.BG_COLOR);
	        try {
	        	for (int i = 0; i < frame.getContentPane().getComponents().length; i++)
	        		frame.getContentPane().getComponents()[i].setBackground(estado.BG_COLOR);
	        } catch (Throwable t2) {
	        	t2.getMessage();
	        }
	        */
	        //...
	        javax.swing.JInternalFrame frameTmp;
	        String keyTmp;

	        // si la ventana es para un bo nuevo, solamente se la abre
	        if (estado.esNuevo()) {
	            agregarVentana(frame, aKey);
	            if (maximized)
	                WindowManager.maximize(frame);
	            else
	                this._situateWindow(parentFrame, frame);
	            setABMEstadoOnFrame(frame, estado);
	            frame.setTitle(estado.getTitulo());
	            frame.setResizable(true);
	            frame.setClosable(true);
	            frame.setMaximizable(true);
	            frame.setIconifiable(true);
	            frame.setVisible(true);
	            SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
	            InternalFrameManager.singleton().updateFramesList();
	            try {
	                frame.setSelected(true);
	            } catch (java.beans.PropertyVetoException e) {
	                e.getMessage();
	            }
	            return false;
	        }

	        // si es la primera ventana por abrirse, se la abre
	        if (ventanasAbiertas.size() < 1) {
	            agregarVentana(frame, aKey);
	            if (maximized)
	                WindowManager.maximize(frame);
	            else
	                this._situateWindow(parentFrame, frame);
	            setABMEstadoOnFrame(frame, estado);
	            frame.setTitle(estado.getTitulo());
	            frame.setResizable(true);
	            frame.setClosable(true);
	            frame.setMaximizable(true);
	            frame.setIconifiable(true);
	            frame.setVisible(true);
	            SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
	            InternalFrameManager.singleton().updateFramesList();
	            try {
	                frame.setSelected(true);
	            } catch (java.beans.PropertyVetoException e) {
	                e.getMessage();
	            }
	            return true;
	        }

	        // se recorre todo el vector de ventanas abiertas, para saber si el objeto de negocio tiene ya una ventana abierta
	        for (int i = 0; i < ventanasAbiertas.size(); i++) {
	            keyTmp = (String) keys.elementAt(i);

	            // si se encuentra que ya existe una ventana abierta para el objeto de negocio se la pasa al frente
	            if (aKey.trim().compareTo(keyTmp.trim()) == 0) {
	                frameTmp = (javax.swing.JInternalFrame) ventanasAbiertas.elementAt(i);
	                frameTmp.toFront();
	                frameTmp.setSelected(true);
	                return false;
	            }
	        }

	        // como no hay ventanas abiertas para el objeto de negocio se abre una
	        agregarVentana(frame, aKey);
	        if (maximized)
	            WindowManager.maximize(frame);
	        else
	            this._situateWindow(parentFrame, frame);
	        setABMEstadoOnFrame(frame, estado);
	        frame.setTitle(estado.getTitulo());
	        frame.setResizable(true);
	        frame.setClosable(true);
	        frame.setMaximizable(true);
	        frame.setIconifiable(true);
	        frame.setVisible(true);
	        SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
	        InternalFrameManager.singleton().updateFramesList();
	        try {
	            frame.setSelected(true);
	        } catch (java.beans.PropertyVetoException e) {
	            e.getMessage();
	        }

	    } catch (Throwable t) {
	        t.getMessage();
	        //...
	        return false;
	    }
	    return true;
	}
	public boolean addFrame(
	    javax.swing.JInternalFrame parentFrame,
	    javax.swing.JInternalFrame frame,
	    String aKey,
	    ABMEstado estado,
	    boolean maximized,
	    WindowPool windowPool,
	    int posInPool) {

	    //...invocado usualmente por ventanas principales de ABMs para añadir ventanas de detalle
		try {
			frame.setFrameIcon(parentFrame.getFrameIcon());
		} catch (Exception e2) {
			e2.getMessage();
		}


	    try {
		    /*
			frame.getContentPane().setBackground(estado.BG_COLOR);
			try {
				for (int i = 0; i < frame.getContentPane().getComponents().length; i++)
					frame.getContentPane().getComponents()[i].setBackground(estado.BG_COLOR);
			} catch (Throwable t2) {
				t2.getMessage();
			}
			*/
	        //...
	        javax.swing.JInternalFrame frameTmp;
	        String keyTmp;

	        // si la ventana es para un bo nuevo, solamente se la abre
	        if (estado.esNuevo()) {
	            agregarVentana(frame, aKey);
	            if (maximized)
	                WindowManager.maximize(frame);
	            else
	                this._situateWindow(parentFrame, frame);
	            setABMEstadoOnFrame(frame, estado);
	            frame.setTitle(estado.getTitulo());
				frame.setResizable(true);frame.setClosable(true);frame.setMaximizable(true);
				frame.setIconifiable(true);frame.setVisible(true);
				SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
				InternalFrameManager.singleton().updateFramesList();
				try {
					frame.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
					e.getMessage();
				}
	            return false;
	        }

	        // si es la primera ventana por abrirse, se la abre
	        if (ventanasAbiertas.size() < 1) {
	            agregarVentana(frame, aKey);
	            if (maximized)
	                WindowManager.maximize(frame);
	            else
	                this._situateWindow(parentFrame, frame);
	            setABMEstadoOnFrame(frame, estado);
	            frame.setTitle(estado.getTitulo());
				frame.setResizable(true);frame.setClosable(true);frame.setMaximizable(true);
				frame.setIconifiable(true);frame.setVisible(true);
				SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
				InternalFrameManager.singleton().updateFramesList();
				try {
					frame.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
					e.getMessage();
				}
	            return true;
	        }

	        // se recorre todo el vector de ventanas abiertas, para saber si el objeto de negocio tiene ya una ventana abierta
	        for (int i = 0; i < ventanasAbiertas.size(); i++) {
	            keyTmp = (String) keys.elementAt(i);

	            // si se encuentra que ya existe una ventana abierta para el objeto de negocio se la pasa al frente
	            if (aKey.trim().compareTo(keyTmp.trim()) == 0) {
	                frameTmp = (javax.swing.JInternalFrame) ventanasAbiertas.elementAt(i);
	                frameTmp.toFront();
	                frameTmp.setSelected(true);
	                windowPool.freeWindow(posInPool);
	                return false;
	            }
	        }

	        // como no hay ventanas abiertas para el objeto de negocio se abre una
	        agregarVentana(frame, aKey);
	        if (maximized)
	            WindowManager.maximize(frame);
	        else
	            this._situateWindow(parentFrame, frame);
	        setABMEstadoOnFrame(frame, estado);
	        frame.setTitle(estado.getTitulo());
			frame.setResizable(true);frame.setClosable(true);frame.setMaximizable(true);
			frame.setIconifiable(true);frame.setVisible(true);
			SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(frame);
			InternalFrameManager.singleton().updateFramesList();
			try {
				frame.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
				e.getMessage();
			}

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
	private void agregarVentana(javax.swing.JInternalFrame frame, Integer unTipo) {
	    ventanasAbiertas.addElement(frame);
	    tipos.addElement(unTipo);
	}
	private void agregarVentana(javax.swing.JInternalFrame frame, String aKey) {
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
	            ((javax.swing.JInternalFrame) ventanasAbiertas.elementAt(i)).dispose();
	        }
	        //...
	        InternalFrameManager.singleton().updateFramesList();
	    } catch (Throwable t) {
	        t.getMessage();
	    }
	}
	private void eliminarVentana(javax.swing.JInternalFrame frame, Integer tipo) {
	    if (ventanasAbiertas.contains(frame)) {
	        ventanasAbiertas.removeElement(frame);
	        tipos.removeElement(tipo);
	    }
	    frame.dispose();
	    //...
	    InternalFrameManager.singleton().updateFramesList();
	}
	private void eliminarVentana(javax.swing.JInternalFrame frame, String aKey) {
	    if (ventanasAbiertas.contains(frame)) {
	        ventanasAbiertas.removeElement(frame);
	        keys.removeElement(aKey);
	    }
	    frame.dispose();
	    //...
	    InternalFrameManager.singleton().updateFramesList();
	}
	private void eliminarVentana(javax.swing.JInternalFrame frame, String aKey, boolean disposeWindow) {
		if (ventanasAbiertas.contains(frame)) {
			ventanasAbiertas.removeElement(frame);
			keys.removeElement(aKey);
		}
		if (disposeWindow)
			frame.dispose();
		//...
		InternalFrameManager.singleton().updateFramesList();
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
	public void removeFrame(javax.swing.JInternalFrame frame, int tipo) {
		//...invocado usualmente por ventanas de detalle de ABMs de control de fórmulas
		eliminarVentana(frame, new Integer(tipo));
	}
	public void removeFrame(javax.swing.JInternalFrame frame, String aKey) {
		//...invocado usualmente por ventanas de detalle de ABMs (con objetos de negocio sin oid)
		eliminarVentana(frame, aKey);
	}
	public void removeFrame(javax.swing.JInternalFrame frame, String aKey, boolean disposeWindow) {
		//...invocado usualmente por ventanas de detalle de ABMs (con objetos de negocio sin oid)
		eliminarVentana(frame, aKey, disposeWindow);
	}
	/**
	 * The removePropertyChangeListener method was generated to support the propertyChange field.
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}
	private void setABMEstadoOnFrame(javax.swing.JInternalFrame frame, ABMEstado estado) {
		/*
	    try {
	        Object parms[] = { estado };
	        Class types[] = { estado.getClass().getSuperclass()};
	        TsMethodInvocation.performMethod("setAbmEstado", frame, parms, types);
	    } catch (Throwable t) {
	        //...
	        t.getMessage();
	    }
	    */
	}
}
