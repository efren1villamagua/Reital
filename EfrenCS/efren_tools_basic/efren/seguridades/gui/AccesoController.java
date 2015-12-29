package efren.seguridades.gui;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.seguridades.procesos.gui.MenuBuilderProcess;
import efren.util.AuditoriaManager;
import efren.util.CalendarManager;
import efren.util.ExceptionManager;
import efren.util.LoggerManager;
import efren.util.PathManager;
import efren.util.ReconnectionException;
import efren.util.StringTools;
import efren.util.SwingResourceManager;
import efren.util.SystemLogManager;
import efren.util.WindowManager;
import efren.util.abm.estados.ABMEstado;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.Bar02Panel;
import efren.util.gui.dialogs.InfoView;
import efren.util.lookandfeel.LookAndFeelManager;

public class AccesoController {
	/**
	 *
	 */
	public static final Bar02Panel classForLoadingResources = new Bar02Panel();

	public static int mainArgsCount = 0;

	/**
	 *
	 */
	private JWindow splashWindow = null;

	private String inner_nombreArchivoConfiguracion = null;

	private Statement inner_st = null;

	private boolean autorizado = false;

	private AccesoView ventanaPrincipal = null;

	/**
	 *
	 */
	public static void mainInit(String args[]) {

		AccesoController.inicializarDirectorios();

		try {

			AccesoView ventanaPrincipal = null;
			AccesoController.mainArgsCount = args.length;

			if (AccesoController.mainArgsCount == 0) {
				SystemProperties.SYSTEM_TYPE = Constantes.SYSTEM_TYPE_4_ADMIN;
				LookAndFeelManager.initLookAndFeel(null, new WindowsLookAndFeel());
			} else {
				LookAndFeelManager.initLookAndFeel();
			}

			JWindow initialSplash = WindowManager.splashScreenForWaiting(AccesoController.classForLoadingResources);

			/**
			 *
			 */

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
				try {
					LoggerManager.init("SystemAdmin");
					SystemLogManager.setLogger(LoggerManager.logger);
				} catch (Exception e) {
					e.getMessage();
				}
				ventanaPrincipal = new AccesoView();
				AccesoController.showArchivoConfigurationChooser(ventanaPrincipal);
			} else {
				// SISTEMA DE USUARIO
				String configurationFilePath = args[0].trim();
				SystemProperties.RUNTIME_CONFIGURATION_FILE_PATH = configurationFilePath;
				InputStream propertiesFileIS = AccesoController.classForLoadingResources.getClass().getResourceAsStream(configurationFilePath);
				AccesoController.initProperties(propertiesFileIS);

				try {
					LoggerManager.init(SystemProperties.INSTITUCION_NOMBRE + "--" + SystemProperties.SISTEMA_OID);
					SystemLogManager.setLogger(LoggerManager.logger);
				} catch (Exception e) {
					e.getMessage();
				}

				ventanaPrincipal = new AccesoView();
				// AccesoView.estaVentana = ventanaPrincipal;
				// ...
				initialSplash.dispose();
				ventanaPrincipal.getController().setSplashWindow(AccesoController.splashScreen(ventanaPrincipal));
				// ...
				// es la unica ocasion en la que se crea una instancia
				ventanaPrincipal.setTitle(SystemProperties.INSTITUCION_NOMBRE + " » " + SystemProperties.SERVER_NAME + " " + SystemProperties.SISTEMA_VERSION);
				ventanaPrincipal.setVisible(true);
				ventanaPrincipal.toFront();
			}

			if (AccesoController.mainArgsCount == 0) {
				LookAndFeelManager.initLookAndFeel(ventanaPrincipal, new WindowsLookAndFeel());
			} else {
				LookAndFeelManager.initLookAndFeel(ventanaPrincipal);
			}

		} catch (Throwable exc) {
			SystemLogManager.error(exc.getMessage(), exc);
			if (!(exc instanceof ReconnectionException)) {
				if (exc instanceof ConnectException) {
					InfoView.showErrorDialog(new JFrame(), "ERROR AL CONECTARSE AL SERVIDOR. VERIFIQUE SU ENLACE A LA RED.  - " + exc.getClass().getName());
				} else {
					InfoView.showErrorDialog(new JFrame(), exc.getClass().getName());
				}
			}
			System.exit(1);// terminación anómala
		}

	}

	public static void initializeWindow(JFrame window) {
		// es la unica ocasion en la que se crea una instancia
		try {
			try {
				if (SystemProperties.SISTEMA_ICONO_PATH != null) {
					ImageIcon icono = SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH);
					window.setIconImage(icono.getImage());
				}
			} catch (Exception e1) {
				e1.getMessage();
				try {
					window.setIconImage(ImageIO.read(AccesoController.classForLoadingResources.getClass().getResource("/efren/resources/images/cubos.png")));
				} catch (Exception e2) {
					e2.getMessage();
				}
				ExceptionManager.singleton().manage(null, false, AccesoController.class, e1);
			}
			try {
				try {
					String dimensiones = SystemProperties.SISTEMA_BACKGROUND_DIMENSION;
					StringTokenizer stk = new StringTokenizer(dimensiones, "x");
					String anchoSplash = stk.nextToken();
					String altoSplash = stk.nextToken();
					window.setSize(new Integer(anchoSplash).intValue(), new Integer(altoSplash).intValue());
				} catch (Exception e) {
					e.getMessage();
					window.setSize(355, 330);
				}
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.getMessage();
			}
			WindowManager.centerWindow2(window, false);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * 
	 * @param aConfigFileDirPath
	 */
	public static void initProperties(InputStream propertiesFileIS) throws Throwable {
		SystemProperties.initialize(propertiesFileIS);
	}

	/**
	 * 
	 * @param unComponente
	 * @param args
	 */
	public static JWindow splashScreen(JFrame unComponente) {

		JWindow jw = new JWindow(unComponente);
		jw.setBackground(java.awt.Color.white);
		jw.getContentPane().setBackground(java.awt.Color.white);

		try {
			String dimensiones = SystemProperties.SISTEMA_BACKGROUND_DIMENSION;
			StringTokenizer stk = new StringTokenizer(dimensiones, "x");
			String anchoSplash = stk.nextToken();
			String altoSplash = stk.nextToken();
			jw.setSize(new Integer(anchoSplash).intValue(), new Integer(altoSplash).intValue());
		} catch (Exception e) {
			ExceptionManager.singleton().manage(null, false, AccesoController.class, e);
			jw.setSize(150, 150);
		}
		JLabel pict = null;
		try {
			String rutaSplahScreenFile = SystemProperties.SISTEMA_BACKGROUND_ICONO_PATH;
			pict = new JLabel(new ImageIcon(unComponente.getClass().getResource(rutaSplahScreenFile)), JLabel.CENTER);
		} catch (Exception e) {
			e.getMessage();
			pict = new JLabel(new ImageIcon(unComponente.getClass().getResource("/efren/resources/images/_splash.gif")), JLabel.CENTER);
		}
		pict.setBackground(java.awt.Color.white);
		jw.getContentPane().add(pict, java.awt.BorderLayout.CENTER);

		efren.util.WindowManager.centerWindow2(jw);

		jw.setVisible(true);

		try {
			// Thread.sleep(1500);
		} catch (Exception e) {
			e.getMessage();
		}

		// jw.dispose();
		return jw;
	}

	/**
	 * 
	 * @param unFrame
	 */
	public static void showArchivoConfigurationChooser(AccesoView unAccesoView) {

		try {
			try {
				String ruta = unAccesoView.getClass().getResource("/efren/resources/conf/").getFile();
				ruta = PathManager.parsePath(ruta);
				unAccesoView.getFileChooser().setCurrentDirectory(new File(ruta));
			} catch (Exception e1) {
				e1.getMessage();
				try {
					unAccesoView.getFileChooser().setCurrentDirectory(new File("conf"));
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
			JFrame frameConf = unAccesoView.getJFrameConfiguration();
			efren.util.WindowManager2.centerWindow(frameConf);
			frameConf.setVisible(true);
			unAccesoView.getFileChooser().openFileChooser();
		} catch (Throwable e1) {
			e1.getMessage();
		}
	}

	/**
	 *
	 */
	public AccesoController(AccesoView ventanaPrincipal) {
		super();
		setVentanaPrincipal(ventanaPrincipal);
	}

	/**
	 *
	 */
	public JWindow getSplashWindow() {
		return splashWindow;
	}

	public void setSplashWindow(JWindow splashWindow) {
		this.splashWindow = splashWindow;
	}

	public String getInner_nombreArchivoConfiguracion() {
		return inner_nombreArchivoConfiguracion;
	}

	public void setInner_nombreArchivoConfiguracion(String inner_nombreArchivoConfiguracion) {
		this.inner_nombreArchivoConfiguracion = inner_nombreArchivoConfiguracion;
	}

	public Statement getInner_st() {
		return inner_st;
	}

	public void setInner_st(Statement inner_st) {
		this.inner_st = inner_st;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	private void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	/**
	 *
	 */
	private boolean primAutenticar(String userName, String password) {

		java.sql.Connection con = null;

		// VALIDACION VISUAL DE USUARIO Y CLAVE VIRTUALES ANTES DE CONECTARSE A
		// LA BASE
		if (userName == null || userName.trim().length() == 0) {
			InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Usuario o clave incorrecta !");
			this.setAutorizado(false);
			return false;
		}
		if (password == null || password.trim().length() == 0) {
			InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Usuario o clave incorrecta !");
			this.setAutorizado(false);
			return false;
		}

		// SE TRAE EL USUARIO Y CLAVE DE LA BASE DE DATOS PARA CONEXION.

		if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
			long usuarioOid = -1;
			Properties connProperties = new Properties();
			String dbUrl = null;
			String dbName = SystemProperties.DATA_STORE_NAME;
			try {
				if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_1_OS400) {// as400
					Class.forName("com.ibm.as400.access.AS400JDBCDriver");
					dbUrl = "jdbc:as400://" + SystemProperties.DATA_STORE_IP + ";prompt=false;transaction isolation=read uncommitted;" + "libraries="
							+ SystemProperties.SCHEMA_PRINCIPAL + ";date format=iso;time format=iso";
				} else {
					if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_2_WINDOWS_UNIX) {// windows
						if (SystemProperties.DATA_STORE_IP == null || SystemProperties.DATA_STORE_IP.trim().length() == 0) {
							Class.forName("COM.ibm.db2.jdbc.app.DB2Driver").newInstance();
							dbUrl = "jdbc:db2:" + dbName;
						} else {
							Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
							dbUrl = "jdbc:db2://" + SystemProperties.DATA_STORE_IP + ":" + SystemProperties.DATA_STORE_PORT + "/" + dbName;
						}
					}
				}
			} catch (Exception e) {
				InfoView.showErrorDialog(getVentanaPrincipal(), e.getMessage());
				this.setAutorizado(false);
				return false;
			}

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {

				try {
					String clientInformation = "SistemaAdministracion." + userName;
					connProperties.put("clientProgramName", clientInformation);
					connProperties.put("clientAccountingInformation", userName);
					connProperties.put("clientUser", userName);
					clientInformation = "S.SEGU." + userName;
					connProperties.put("user", userName);
					connProperties.put("password", password);

					con = DriverManager.getConnection(dbUrl, connProperties);

					this.setInner_st(con.createStatement());

					SystemProperties.SCHEMA_SEGURIDADES = SystemProperties.SCHEMA_PRINCIPAL;
					this.getInner_st().execute("SET SCHEMA='" + SystemProperties.SCHEMA_SEGURIDADES + "'");

					this.setAutorizado(true);

				} catch (java.sql.SQLException se) {
					se.getMessage();
					this.setAutorizado(false);
					if (se.getSQLState() == null) {
						InfoView.showErrorDialog(getVentanaPrincipal(), se.getMessage());
					} else {
						if (se.getSQLState().compareTo("08004") == 0)
							InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Nombre de usuario o clave incorrecta ! ... [" + se.getMessage() + "]");
						else
							InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Problemas de comunicación con el dataStore ! ... [" + se.getMessage() + "]");
					}
					ExceptionManager.singleton().manage(getVentanaPrincipal(), false, this, se);
					return false;
				} catch (Throwable t) {
					this.setAutorizado(false);
					InfoView.showErrorDialog(getVentanaPrincipal(), " ERROR : " + t.getMessage());
					ExceptionManager.singleton().manage(getVentanaPrincipal(), true, this, t);
					return false;
				}

			} else {

				if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {
					try {
						// SE REALIZA LA CONEXION FISICA A LA BASE DE
						// DATOS
						String clientInformation = "S." + SystemProperties.SISTEMA_OID + "." + userName;
						connProperties.put("clientProgramName", clientInformation);
						connProperties.put("clientAccountingInformation", userName);
						connProperties.put("clientUser", userName);
						connProperties.put("user", userName);
						connProperties.put("password", password);
						con = DriverManager.getConnection(dbUrl, connProperties);

						this.setInner_st(con.createStatement());

						// SE AUTENTICA EL USUARIO VIRTUAL
						usuarioOid = -1;

						String sql = "SELECT OID, RTRIM(LTRIM(CLAVE)) " + " FROM " + SystemProperties.SCHEMA_SEGURIDADES + ".USUARIO "
								+ " WHERE RTRIM(LTRIM(USERNAME))='" + userName + "'";
						String clave_sys = null;
						java.sql.ResultSet rs = this.getInner_st().executeQuery(sql);
						while (rs.next()) {
							usuarioOid = rs.getLong(1);
							clave_sys = rs.getString(2);
						}
						rs.close();
						clave_sys = efren.util.CoderManager.decrypt(clave_sys);

						// SE VALIDA EL ESTADO (ACTIVO O INACTIVO) DEL
						// SISTEMA, Y ADEMAS SE OBTIENE EL NOMBRE DEL
						// SISTEMA
						sql = " SELECT RTRIM(LTRIM(NOMBREPRINCIPAL)), ESTADO " + " FROM " + SystemProperties.SCHEMA_SEGURIDADES + ".SISTEMA " + " WHERE OID="
								+ SystemProperties.SISTEMA_OID;
						rs = this.getInner_st().executeQuery(sql);
						String unNombreSistema = null;
						int estadoSistema = efren.util.config.Constantes.SISTEMA_ESTADO_Inactivo;
						while (rs.next()) {
							unNombreSistema = rs.getString(1);
							estadoSistema = rs.getInt("ESTADO");
						}
						rs.close();
						if (estadoSistema == Constantes.SISTEMA_ESTADO_Inactivo) {
							InfoView.showErrorDialog(getVentanaPrincipal(),
									SystemProperties.RUNTIME_SISTEMA_NAME + " no esta disponible para usarlo. Contactese con el Administrador del Sistema");
							return false;
						}
						if (unNombreSistema == null) {
							InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Error creando el sistema: NO EXISTE EL SISTEMAOID !");
							return false;
						}
						SystemProperties.RUNTIME_SISTEMA_NAME = unNombreSistema.trim();

						// SE OBTIENE DATOS ADICIONALES DEL USUARIO Y EN
						// ESPECIAL EL PERFILOID PARA CONSTRUIR EL MENU
						// DE USUARIO
						sql = "SELECT p.OID, u.NOMBRE " + " FROM " + SystemProperties.SCHEMA_SEGURIDADES + ".USUARIO u, " + SystemProperties.SCHEMA_SEGURIDADES
								+ ".PERFIL p " + " WHERE " + " RTRIM(LTRIM(UCASE(u.USERNAME)))='" + userName.toUpperCase() + "' " + " AND u.PERFILOID = p.OID "
								+ " AND u.ESTADO = 0 ";
						rs = this.getInner_st().executeQuery(sql);
						long perfilOid = -1;
						String nombreUsuario = null;
						while (rs.next()) {
							perfilOid = rs.getLong(1);
							nombreUsuario = rs.getString("NOMBRE").trim();
						}
						rs.close();
						if (perfilOid < 0) {
							InfoView.showErrorDialog(getVentanaPrincipal(), "¡ EL USUARIO NO ESTA ACTIVO !");
							return false;
						}
						SystemProperties.RUNTIME_PERFILOID = perfilOid;
						SystemProperties.RUNTIME_NOMBRE_USUARIO = nombreUsuario;
						// ...

						this.getInner_st().execute("SET SCHEMA='" + SystemProperties.SCHEMA_PRINCIPAL + "'");

						this.setAutorizado(true);

					} catch (java.sql.SQLException se) {
						se.getMessage();
						this.setAutorizado(false);
						if (se.getSQLState() == null) {
							InfoView.showErrorDialog(getVentanaPrincipal(), se.getMessage());
						} else {
							if (se.getSQLState().compareTo("08004") == 0)
								InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Nombre de usuario o clave incorrecta ! ... [" + se.getMessage() + "]");
							else
								InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Problemas de comunicación con el dataStore ! ... [" + se.getMessage() + "]");
						}
						efren.util.ExceptionManager.singleton().manage(getVentanaPrincipal(), false, this, se);
						return false;
					} catch (Throwable t) {
						this.setAutorizado(false);
						InfoView.showErrorDialog(getVentanaPrincipal(), " ERROR : " + t.getMessage());
						ExceptionManager.singleton().manage(getVentanaPrincipal(), true, this, t);
						return false;
					}
				}
			}
			efren.util.Conn.setCon(con);
			// ...
			SystemProperties.RUNTIME_USER_NAME = userName;
			SystemProperties.RUNTIME_USER_PASSWORD = password;
			SystemProperties.RUNTIME_USUARIOOID = usuarioOid;
		}

		return true;
	}

	/**
	 *
	 */
	public boolean crearSistema(String userName, String password) {
		try {
			boolean autenticado = primAutenticar(userName, password);
			if (!autenticado) {
				return false;
			}

			/**
			 * FECHA ACTUAL
			 */
			CalendarManager cm = new CalendarManager();
			SystemProperties.RUNTIME_INIT_CONECTION_CALENDAR_MANAGER = cm;
			SystemProperties.RUNTIME_CALENDAR_MANAGER = cm;

			if (isAutorizado()) {

				if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {

					SystemProperties.RUNTIME_NOMBRE_USUARIO = "(Usuario B.D.)";
					SystemAdminView ventanaSistema = SystemAdminView.singleton();
					ventanaSistema.construirSistema();
					ventanaSistema.setVisible(true);

				} else {

					// sistema en si...
					SystemView ventanaSistema = SystemView.singleton();
					ventanaSistema.title = SystemProperties.RUNTIME_SISTEMA_NAME + " " + SystemProperties.SISTEMA_VERSION;

					// ...AUDITORIA DE USUARIOS CONECTADOS
					String temp = "";
					BigDecimal random = new BigDecimal(Math.random()).setScale(10, BigDecimal.ROUND_HALF_UP);
					temp = StringTools.replaceAll(random.toString(), ".", "", false);
					long randomId = 0;
					try {
						randomId = new Long(temp.trim()).longValue();
						SystemProperties.RUNTIME_CONNECTION_RANDOM_ID = randomId;
					} catch (Exception e) {
						e.getMessage();
						SystemProperties.RUNTIME_CONNECTION_RANDOM_ID = 0;
					}

					AuditoriaManager.audit(this.getInner_st(), 1, SystemProperties.RUNTIME_CONNECTION_RANDOM_ID,
							"CONEXION DEL USUARIO=>" + SystemProperties.RUNTIME_USER_NAME, SystemProperties.RUNTIME_USER_NAME, ABMEstado.CONEXION_USUARIO);

					MenuBuilderProcess mbuilder = new MenuBuilderProcess(this.getInner_st());
					ventanaSistema.construirSistemaWith(mbuilder.__buildMenuFor(SystemProperties.RUNTIME_PERFILOID, getVentanaPrincipal()));
					ventanaSistema.setVisible(true);

				}
				// ...
				getVentanaPrincipal().dispose();
				return true;
			}
		} catch (Throwable t) {
			InfoView.showErrorDialog(getVentanaPrincipal(), "¡ Error: " + t.getMessage() + " !");
		}
		return false;
	}

	public AccesoView getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(AccesoView ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	/**
	 *
	 */
	public static void inicializarDirectorios() {
		/**
		 *
		 */
		try {
			File tempDir = new File(Constantes.TEMP_DIR);
			if (tempDir.exists()) {
				if (tempDir.isFile()) {
					tempDir.delete();
					tempDir.mkdir();
				}
			} else {
				tempDir.mkdir();
			}
		} catch (Exception exc) {
			exc.getMessage();
		}
		try {
			File tempDir = new File(Constantes.TEMP_DIR);
			File[] ff = tempDir.listFiles();
			for (int i = 0; i < ff.length; i++) {
				ff[i].delete();
			}
		} catch (Throwable t22) {
			t22.getMessage();
		}
		/**
		 *
		 */
		try {
			File logsDir = new File(Constantes.LOGS_DIR);
			if (logsDir.exists()) {
				if (logsDir.isFile()) {
					logsDir.delete();
					logsDir.mkdir();
				}
			} else {
				logsDir.mkdir();
			}
		} catch (Exception exc) {
			exc.getMessage();
		}
		/**
		 *
		 */
		try {
			File configDir = new File(Constantes.CONFIG_DIR);
			if (configDir.exists()) {
				if (configDir.isFile()) {
					configDir.delete();
					configDir.mkdir();
				}
			} else {
				configDir.mkdir();
			}
		} catch (Exception exc) {
			exc.getMessage();
		}
	}
}
