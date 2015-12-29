package efren.seguridades.gui;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import efren.seguridades.procesos.gui.MenuBuilderProcess;
import efren.util.WindowObserver;
import efren.util.config.SystemProperties;
import efren.util.gui.panels.DesktopPaneExt;

public class SystemAdminView extends javax.swing.JFrame implements java.awt.event.WindowListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7355879761806117933L;
	private efren.util.WindowObserver ivjwindowObserver = null;  //  @jve:decl-index=0:
    private javax.swing.JMenuBar ivjSystemAdminViewJMenuBar = null;
    private javax.swing.JPopupMenu jpm;
    private static SystemAdminView singleton = null;
	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public SystemAdminView() {
		super();
		initialize();
	}
	private void closeSystem() {

		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this,
			"¿ Está seguro de SALIR DEL SISTEMA ?", "Seleccione una opción",
			efren.util.gui.dialogs.InfoView.YES_NO_OPTION) != 0)
			return;

	    getwindowObserver().closeWindows();
	    WindowObserver.clear();
	    SystemObserver.singleton().clear();
	    dispose();

	    try {
	        efren.util.Conn.conectar().commit();
	        efren.util.Conn.conectar().close();
	    } catch (Throwable t) {
	        t.getMessage();
	    }
/*
	    try {
	        // logging stoped
	        efren.util.SystemLogManager.singleton().stopLogging();
	    } catch (java.io.IOException ioe) {
	        efren.dialogs.InfoView.showErrorDialog(
	            new javax.swing.JFrame(),
	            "No se pudo cerrar el archivo de log ...");
	    }
*/
	    System.exit(0);
	}
	/**
	 * connEtoC1:  (MenuView.window.windowClosing(java.awt.event.WindowEvent) --> SystemView.closeSystem()V)
	 * @param arg1 java.awt.event.WindowEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.awt.event.WindowEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.closeSystem();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	public void construirSistema() {

		String tituloArriba = null;
		String mensajeAbajo = null;

	    try {
		    tituloArriba = SystemProperties.INSTITUCION_NOMBRE+" » "+"Sistema de Administración (Seguridades+Reporteador)";

			    mensajeAbajo = SystemProperties.DATA_STORE_NAME+"»"+SystemProperties.SERVER_NAME+"»"+SystemProperties.RUNTIME_USER_NAME
                +"»(JDK"+System.getProperty("java.version")+"»"+System.getProperty("os.name")
                +"»"+System.getProperty("os.arch")+"»"+System.getProperty("os.version")
                +"»"+java.net.InetAddress.getLocalHost()+")»"
                +"Conectado desde: "+SystemProperties.RUNTIME_INIT_CONECTION_CALENDAR_MANAGER.getAbsoluteRegionalDateExpression();

	        this.setTitle(tituloArriba);

	    } catch (java.lang.Throwable ivjExc) {
	        efren.util.gui.dialogs.InfoView.showErrorDialog(this, ivjExc.toString());
	        handleException(ivjExc);
	        System.exit(0);
	    }

	    //...
	    javax.swing.JDesktopPane desktop = new DesktopPaneExt();
	    //desktop.putClientProperty("JDesktopPane.dragMode", "outline"); //Make dragging faster
	    desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
	    desktop.setBackground(java.awt.Color.gray);

	    javax.swing.JPanel contentPane = new javax.swing.JPanel();
	    contentPane.setName("JInternalFrameContentPane");
	    contentPane.setLayout(new java.awt.GridBagLayout());
		contentPane.setBackground(java.awt.Color.gray);

	    java.awt.GridBagConstraints constraints0 = new java.awt.GridBagConstraints();
	    constraints0.gridx = 0;
	    constraints0.gridy = 0;
	    constraints0.fill = java.awt.GridBagConstraints.BOTH;
	    constraints0.weightx = 1.0;
	    constraints0.weighty = 1.0;
	    constraints0.insets = new java.awt.Insets(1, 1, 1, 1);
	    contentPane.add(desktop, constraints0);

	   	java.awt.GridBagConstraints constraints1 = new java.awt.GridBagConstraints();
	   	constraints1.gridx = 0;
	   	constraints1.gridy = 1;
	   	constraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
	   	constraints1.weightx = 1.0;
	   	constraints1.weighty = 0.0;
	   	constraints1.ipady = 5;
	   	constraints1.insets = new java.awt.Insets(1, 1, 1, 1);
		efren.util.gui.bars.BarraEstadosPanel bep = new efren.util.gui.bars.BarraEstadosPanel();
		bep.setName("BarraEstadosPanel");
		bep.setText(mensajeAbajo);
		bep.setBackground(new Color(0, 64, 128));
		bep.setTextForeground(Color.WHITE);
		//bep.setTextForeground(new java.awt.Color(72,61,139));
		SystemProperties.RUNTIME_BARRA_STATUS = bep;
	   	contentPane.add(bep, constraints1);

	    this.setContentPane(contentPane);

	    desktop.setBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 3));
	    SystemProperties.RUNTIME_MAIN_DESKTOP_PANE = desktop;

	    //...construimos el menu de click derecho
	    this.jpm = new javax.swing.JPopupMenu();
	    jpm.setName("Menu General");
	    jpm.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));

		JMenu menuVentanas = (JMenu) jpm.add(MenuBuilderProcess.crearMenuVentanas(this.getClass(), true));
		SystemProperties.RUNTIME_MENU_POPUP_VENTANAS_DEL_SISTEMA = menuVentanas;
		jpm.add(MenuBuilderProcess.crearMenuExtras(this.getClass(), false, true));
		//jpm.add(MenuBuilderProcess.crearMenuItemJava(this.getClass()));
		jpm.add(MenuBuilderProcess.crearMenuItemAbout(this.getClass()));
		jpm.add(MenuBuilderProcess.crearMenuItemSalir(this.getClass(), true));

	    desktop.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mousePressed(java.awt.event.MouseEvent e) {
	        }
	        public void mouseReleased(java.awt.event.MouseEvent e) {
	        }
	        public void mouseEntered(java.awt.event.MouseEvent e) {
	        }
	        public void mouseExited(java.awt.event.MouseEvent e) {
	        }
	        public void mouseClicked(java.awt.event.MouseEvent e) {
	            if (e.getClickCount() == 1 && e.getModifiers() == java.awt.event.MouseEvent.BUTTON3_MASK)
	                jpm.show(SystemProperties.RUNTIME_MAIN_DESKTOP_PANE, e.getX(), e.getY());
	        }
	    });
	}
	/**
	 * Return the SystemAdminViewJMenuBar property value.
	 * @return javax.swing.JMenuBar
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuBar getSystemAdminViewJMenuBar() {
		if (ivjSystemAdminViewJMenuBar == null) {
			try {
				ivjSystemAdminViewJMenuBar = new JMenuBar();
				ivjSystemAdminViewJMenuBar.setName("SystemAdminViewJMenuBar");
				//ivjSystemAdminViewJMenuBar.setLayout(new FlowLayout());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSystemAdminViewJMenuBar;
	}
	/**
	 * Return the windowObserver property value.
	 * @return efren.util.WindowObserver
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.WindowObserver getwindowObserver() {
		if (ivjwindowObserver == null) {
			try {
				ivjwindowObserver = efren.util.WindowObserver.singleton();
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjwindowObserver;
	}
	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}
	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		this.addWindowListener(this);
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
			// user code end
			setName("SystemAdminView");
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			setJMenuBar(getSystemAdminViewJMenuBar());
			setSize(509, 151);
			setTitle("Sistema de Administración");
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
	    //...
	    this.construirMenues();
		this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/efren/resources/images/cubos.png")));
		efren.util.WindowManager2.maximize(this);
		SystemProperties.SCHEMA_PRINCIPAL = SystemProperties.SCHEMA_SEGURIDADES;
		try {
	        this.setExtendedState(Frame.MAXIMIZED_BOTH);
	    } catch (Exception e) {
	        e.getMessage();
	    }
		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		// user code end
	}
	public static SystemAdminView singleton() {
	    if (singleton == null)
	        singleton = new SystemAdminView();
	    return singleton;
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowActivated(java.awt.event.WindowEvent e) {
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowClosed(java.awt.event.WindowEvent e) {
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowClosing(java.awt.event.WindowEvent e) {
		if (e.getSource() == this)
			connEtoC1(e);
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowDeactivated(java.awt.event.WindowEvent e) {
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowDeiconified(java.awt.event.WindowEvent e) {
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowIconified(java.awt.event.WindowEvent e) {
	}
	/**
	 * Method to handle events for the WindowListener interface.
	 * @param e java.awt.event.WindowEvent
	 */
	public void windowOpened(java.awt.event.WindowEvent e) {
	}

	private void construirMenues() {
	    JMenuBar menuBar = getSystemAdminViewJMenuBar();
	    //menuBar.setLayout(MenuBuilderProcess.layoutForMenus);
	    menuBar.setBorderPainted(true);
		menuBar.add(MenuBuilderProcess.crearMenuSeguridades(this.getClass()));
		menuBar.add(MenuBuilderProcess.crearMenuUtil(this.getClass()));
		menuBar.add(Box.createHorizontalGlue());
		JMenu menuVentanas = menuBar.add(MenuBuilderProcess.crearMenuVentanas(this.getClass(), false));
		SystemProperties.RUNTIME_MENU_VENTANAS_DEL_SISTEMA = menuVentanas;
		menuBar.add(MenuBuilderProcess.crearMenuExtras(this.getClass(), false, false));
		//menuBar.add(MenuBuilderProcess.crearMenuItemJava(this.getClass()));
		//menuBar.add(MenuBuilderProcess.crearMenuItemAbout(this.getClass()));
		//menuBar.add(MenuBuilderProcess.crearMenuItemSalir(this.getClass(), false));
	}
}
