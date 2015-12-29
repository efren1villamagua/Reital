package efren.seguridades.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.UnknownHostException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import efren.seguridades.procesos.gui.MenuBuilderProcess;
import efren.util.AuditoriaManager;
import efren.util.Conn;
import efren.util.ExceptionManager;
import efren.util.SwingResourceManager;
import efren.util.WindowManager2;
import efren.util.abm.estados.ABMEstado;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.BarraEstadosPanel;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.panels.DesktopPaneExt;

public class SystemView extends JFrame implements ActionListener, WindowListener {

	/**
	 *
	 */
	private static final long serialVersionUID = -7256488946662771286L;

	private static SystemView singleton = null;

	public String title = "...";

	private JPopupMenu jpm;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public SystemView() {
		super();
		initialize();
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		this._cerrar();
	}

	/**
	 *
	 *
	 */
	private void _cerrar() {

		if (InfoView.showConfirmDialog(this, "¿ Está seguro de SALIR DEL SISTEMA ?", "Seleccione una opción", InfoView.YES_NO_OPTION) != 0)
			return;

		try {
			Statement st = null;
			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {// SISTEMA
																				// LOCAL
																				// (SIN
																				// SERVIDOR
																				// DE
																				// APLICACIONES)
				st = Conn.conectar().createStatement();
			}
			AuditoriaManager.audit(st, 1, SystemProperties.RUNTIME_CONNECTION_RANDOM_ID, "DESCONEXION DEL USUARIO=>" + SystemProperties.RUNTIME_USER_NAME,
					SystemProperties.RUNTIME_USER_NAME, ABMEstado.DESCONEXION_USUARIO);
			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {// SISTEMA
																				// LOCAL
																				// (SIN
																				// SERVIDOR
																				// DE
																				// APLICACIONES)
				st.close();
			}
		} catch (Throwable t) {
			t.getMessage();
		}

		SystemObserver.singleton().clear();
		dispose();
		try {
			Conn.conectar().commit();
			Conn.conectar().close();
		} catch (Throwable t) {
			t.getMessage();
		}
		/*
		 * try { SystemLogManager.singleton().stopLogging(); } catch
		 * (java.io.IOException ioe) {
		 * efren.dialogs.InfoView.showErrorDialog(new JFrame(),
		 * "No se pudo cerrar el archivo de log ..."); }
		 */
		// FINALMENTE SE CIERRA TODA LA APLICACION
		System.exit(0);
	}

	/**
	 * connEtoC1: (MenuView.window.windowClosing(WindowEvent) -->
	 * SystemView.closeSystem()V)
	 * 
	 * @param arg1
	 *            WindowEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(WindowEvent arg1) {
		try {
			this._cerrar();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 *
	 */
	public String getMensajeAbajo() throws UnknownHostException {
		String mensajeAbajo = null;

		mensajeAbajo = SystemProperties.DATA_STORE_NAME + "»" + SystemProperties.SERVER_NAME + "»" + SystemProperties.RUNTIME_USER_NAME + "»"
				+ SystemProperties.RUNTIME_NOMBRE_USUARIO + "»(JDK" + System.getProperty("java.version") + "»" + System.getProperty("os.name") + "»"
				+ System.getProperty("os.arch") + "»" + System.getProperty("os.version") + "»" + java.net.InetAddress.getLocalHost() + ")»"
				+ "Conectado desde: " + SystemProperties.RUNTIME_INIT_CONECTION_CALENDAR_MANAGER.getAbsoluteRegionalDateExpression();

		return mensajeAbajo;
	}

	/**
	 *
	 * @param menuBar
	 */
	public void construirSistemaWith(JMenuBar menuBar) {

		String tituloArriba = null;
		String mensajeAbajo = null;

		try {
			tituloArriba = SystemProperties.INSTITUCION_NOMBRE + " » " + SystemProperties.RUNTIME_SISTEMA_NAME + " " + SystemProperties.SISTEMA_VERSION;

			mensajeAbajo = getMensajeAbajo();

			this.setTitle(tituloArriba);

		} catch (java.lang.Throwable ivjExc) {
			InfoView.showErrorDialog(this, ivjExc.toString());
			handleException(ivjExc);
			System.exit(0);
		}

		JDesktopPane desktop = new DesktopPaneExt();
		// desktop.putClientProperty("JDesktopPane.dragMode", "outline"); //Make
		// dragging faster
		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
		desktop.setBackground(Color.gray);

		JPanel contentPane = new JPanel();
		contentPane.setName("JInternalFrameContentPane");
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(Color.gray);

		GridBagConstraints constraints0 = new GridBagConstraints();
		constraints0.gridx = 0;
		constraints0.gridy = 0;
		constraints0.fill = GridBagConstraints.BOTH;
		constraints0.weightx = 1.0;
		constraints0.weighty = 1.0;
		constraints0.insets = new Insets(1, 1, 1, 1);
		contentPane.add(desktop, constraints0);

		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.gridx = 0;
		constraints1.gridy = 1;
		constraints1.fill = GridBagConstraints.HORIZONTAL;
		constraints1.weightx = 1.0;
		constraints1.weighty = 0.0;
		constraints1.ipady = 5;
		constraints1.insets = new Insets(1, 1, 1, 1);
		BarraEstadosPanel bep = new BarraEstadosPanel();
		bep.setName("BarraEstadosPanel");
		bep.setText(mensajeAbajo);
		// bep.setBackground(new Color(64, 64, 64));
		// bep.setTextForeground(Color.WHITE);
		// bep.setTextForeground(new Color(72,61,139));
		SystemProperties.RUNTIME_BARRA_STATUS = bep;
		contentPane.add(bep, constraints1);

		this.setContentPane(contentPane);

		desktop.setBorder(new LineBorder(Color.lightGray, 3));
		SystemProperties.RUNTIME_MAIN_DESKTOP_PANE = desktop;

		this.setJMenuBar(menuBar);
		try {
			// ...construimos el menu de click derecho
			this.jpm = new JPopupMenu();
			jpm.setName("Menu General");
			jpm.setFont(new Font("Arial", Font.PLAIN, 10));

			JMenu menuVentanas = (JMenu) jpm.add(MenuBuilderProcess.crearMenuVentanas(this.getClass(), true));
			SystemProperties.RUNTIME_MENU_POPUP_VENTANAS_DEL_SISTEMA = menuVentanas;
			boolean showCambiarClave = false;// SystemProperties.SYSTEM_TYPE ==
												// Constantes.SYSTEM_TYPE_1_SA_SEG;
			jpm.add(MenuBuilderProcess.crearMenuExtras(this.getClass(), showCambiarClave, true));
			// jpm.add(MenuBuilderProcess.crearMenuItemJava(this.getClass()));
			jpm.add(MenuBuilderProcess.crearMenuItemAbout(this.getClass()));
			jpm.add(MenuBuilderProcess.crearMenuItemSalir(this.getClass(), true));

			desktop.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
				}

				public void mouseReleased(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1 && e.getModifiers() == MouseEvent.BUTTON3_MASK)
						jpm.show(SystemProperties.RUNTIME_MAIN_DESKTOP_PANE, e.getX(), e.getY());
				}
			});

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 *
	 */
	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 *
	 */
	private void initConnections() throws java.lang.Exception {
		this.addWindowListener(this);
	}

	/**
	 *
	 */
	private void initialize() {
		try {
			// URL iconoPath =
			// getClass().getResource(SystemProperties.SISTEMA_ICONO_PATH);
			ImageIcon icono = SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH);
			this.setIconImage(icono.getImage());
			/*
			 * if (new File(iconoPath.getFile()).exists()) {
			 * this.setIconImage(Toolkit.getDefaultToolkit().getImage(iconoPath)
			 * ); } else {
			 * this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
			 * .getResource("/efren/resources/images/cubos.png"))); }
			 */
		} catch (Exception e) {
			e.getMessage();
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/efren/resources/images/cubos.png")));
		}
		try {
			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			setName("MenuView");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setSize(680, 151);
			setTitle("aSystemTitle");
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		WindowManager2.maximize(this);
		try {
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
		} catch (Exception e) {
			e.getMessage();
		}
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 *
	 * @return
	 */
	public static SystemView singleton() {
		if (singleton == null) {
			try {
				singleton = new SystemView();
			} catch (Exception e) {
				singleton = (SystemView) new JFrame();
			}

		}
		return singleton;
	}

	/**
	 *
	 */
	public void windowActivated(WindowEvent e) {
	}

	/**
	 *
	 */
	public void windowClosed(WindowEvent e) {
	}

	/**
	 *
	 */
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this)
			connEtoC1(e);
	}

	/**
	 *
	 */
	public void windowDeactivated(WindowEvent e) {
	}

	/**
	 *
	 */
	public void windowDeiconified(WindowEvent e) {
	}

	/**
	 *
	 */
	public void windowIconified(WindowEvent e) {
	}

	/**
	 *
	 */
	public void windowOpened(WindowEvent e) {
	}
}
