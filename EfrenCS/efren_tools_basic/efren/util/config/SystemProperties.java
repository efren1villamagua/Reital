package efren.util.config;

import java.io.InputStream;
import java.util.Properties;

import efren.seguridades.gui.AccesoController;
import efren.util.CalendarManager;
import efren.util.MethodInvocation;
import efren.util.gui.bars.BarraEstadosPanel;

public class SystemProperties {
	/**
	 * VARIABLES QUE SE LEEN DESDE EL ARCHIVO DE CONFIGURACION
	 */
	public static int SYSTEM_TYPE = Constantes.SYSTEM_TYPE_3_LO;

	public static int SERVER_TYPE = Constantes.SERVER_TYPE_2_WINDOWS_UNIX;

	public static String WEB_SERVER_IP = null;

	public static String WEB_SERVER_PORT = null;

	public static String WEB_CONTEXT_PATH = null;

	public static String SERVICING_SEGURIDADES_POOL_NAME = null;

	public static String SERVICING_POOL_NAME = null;

	public static String SCHEMA_SEGURIDADES = "SEGURIDADES";

	public static String SCHEMA_UTIL = null;

	public static String SISTEMA_OID = null;

	public static String SISTEMA_VERSION = null;

	public static String SISTEMA_ICONO_PATH = null;

	public static String SISTEMA_ABOUT_ICONO_PATH = null;

	public static String SISTEMA_BACKGROUND_ICONO_PATH = null;

	public static String SISTEMA_BACKGROUND_DIMENSION = null;

	public static String SISTEMA_DESKTOP_BACKGROUND_ICONO_PATH = null;

	public static String REPORTER_TEMPLATES_PATH = null;

	public static String DELEGATE_WINDOW_OPEN_MODE = "fixedLocation";

	public static String ABOUT_DIALOG_Line01 = "Sistema Empresarial";

	public static String INSTITUCION_NOMBRE = "Sistema Empresarial";

	public static String INSTITUCION_WEB = "www.java.com";

	public static String SERVER_NAME = "Servidor Central";

	public static String FONTS_PATH = "C:/WINDOWS/Fonts";

	public static String FINDER_VIEW_ALL = "false";

	public static String HOST_NAME = "127.0.0.1:8080";

	public static String HELP_WEB_PATH = "sistemaName/help";

	public static String DATA_STORE_NAME = null;

	public static String DATA_STORE_IP = null;

	public static String DATA_STORE_PORT = null;

	public static String SCHEMA_PRINCIPAL = null;

	public static String EXTRA_OPTION_CLASS_NAME = null;

	public static String EXTRA_PROPERTIES_01_CLASSNAME = null;

	public static String EXTRA_PROPERTIES_01_FILENAME = null;

	/**
	 * VARIABLES QUE SON CONFIGURADAS EN TIEMPO DE EJECUCION DEL SISTEMA
	 */
	public static String RUNTIME_SISTEMA_NAME = null;

	public static long RUNTIME_PERFILOID = -1;

	public static long RUNTIME_USUARIOOID = -1;

	public static String RUNTIME_USER_NAME = null;

	public static String RUNTIME_USER_PASSWORD = null;

	public static String RUNTIME_NOMBRE_USUARIO = null;

	public static String RUNTIME_USUARIO_CODIGO_ALTERNO = null;

	public static int RUNTIME_USUARIO_TIPO = -1;

	public static String RUNTIME_DEPENDENCIA_CODIGO = null;

	public static String RUNTIME_DEPENDENCIA_NOMBRE = null;

	public static int RUNTIME_DEPENDENCIA_TIPO = -1;

	public static String RUNTIME_SESSION_ID = null;

	public static long RUNTIME_SECRET_ID = -1;

	// ...
	public static String RUNTIME_CONFIGURATION_FILE_PATH = null;

	// ...
	public static CalendarManager RUNTIME_CALENDAR_MANAGER = null;

	public static javax.swing.JDesktopPane RUNTIME_MAIN_DESKTOP_PANE;

	// ...
	public static CalendarManager RUNTIME_INIT_CONECTION_CALENDAR_MANAGER = null;

	// ...
	public static javax.swing.JMenu RUNTIME_MENU_VENTANAS_DEL_SISTEMA = null;

	public static javax.swing.JMenu RUNTIME_MENU_POPUP_VENTANAS_DEL_SISTEMA = null;

	public static BarraEstadosPanel RUNTIME_BARRA_STATUS = null;

	public static String RUNTIME_BARRA_STATUS_MENSAJE = null;

	public static long RUNTIME_CONNECTION_RANDOM_ID = -1;

	/**
	 *
	 *
	 */
	public SystemProperties() {
		super();
	}

	/**
	 *
	 * @param is
	 * @throws Throwable
	 */
	public static void initialize(InputStream is) throws Throwable {
		java.util.Properties propiedades = new java.util.Properties();
		propiedades.load(is);
		primInit(propiedades);
		is.close();
	}

	/**
	 *
	 * @param aPathFile
	 * @throws Throwable
	 */
	public static void initialize(String aPathFile) throws Throwable {
		java.util.Properties propiedades = new java.util.Properties();
		java.io.FileInputStream in = new java.io.FileInputStream(aPathFile);
		propiedades.load(in);
		primInit(propiedades);
		in.close();
	}

	/**
	 *
	 * @param unasPropiedades
	 */
	private static void primInit(Properties unasPropiedades) {
		try {
			if (AccesoController.mainArgsCount == 0) {
				SYSTEM_TYPE = Constantes.SYSTEM_TYPE_4_ADMIN;
			} else {
				SYSTEM_TYPE = new Integer(unasPropiedades.getProperty("SYSTEM_TYPE").trim()).intValue();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			SERVER_TYPE = new Integer(unasPropiedades.getProperty("SERVER_TYPE").trim()).intValue();
		} catch (Exception e) {
			e.getMessage();
		}
		WEB_SERVER_IP = unasPropiedades.getProperty("WEB_SERVER_IP");
		WEB_SERVER_PORT = unasPropiedades.getProperty("WEB_SERVER_PORT");
		WEB_CONTEXT_PATH = unasPropiedades.getProperty("WEB_CONTEXT_PATH");
		SERVICING_SEGURIDADES_POOL_NAME = unasPropiedades.getProperty("SERVICING_SEGURIDADES_POOL_NAME");
		SERVICING_POOL_NAME = unasPropiedades.getProperty("SERVICING_POOL_NAME");
		SCHEMA_SEGURIDADES = unasPropiedades.getProperty("SCHEMA_SEGURIDADES", "SEGURIDADES");
		SCHEMA_UTIL = unasPropiedades.getProperty("SCHEMA_UTIL", null);
		SISTEMA_OID = unasPropiedades.getProperty("SISTEMA_OID", null);
		SISTEMA_VERSION = unasPropiedades.getProperty("SISTEMA_VERSION", null);
		SISTEMA_ICONO_PATH = unasPropiedades.getProperty("SISTEMA_ICONO_PATH", null);
		SISTEMA_ABOUT_ICONO_PATH = unasPropiedades.getProperty("SISTEMA_ABOUT_ICONO_PATH", null);
		SISTEMA_BACKGROUND_ICONO_PATH = unasPropiedades.getProperty("SISTEMA_BACKGROUND_ICONO_PATH", null);
		SISTEMA_BACKGROUND_DIMENSION = unasPropiedades.getProperty("SISTEMA_BACKGROUND_DIMENSION", null);
		SISTEMA_DESKTOP_BACKGROUND_ICONO_PATH = unasPropiedades.getProperty("SISTEMA_DESKTOP_BACKGROUND_ICONO_PATH", null);
		HOST_NAME = unasPropiedades.getProperty("HOST_NAME", "127.0.0.1:8080");
		HELP_WEB_PATH = unasPropiedades.getProperty("HELP_WEB_PATH", "sistemaName/help");
		FONTS_PATH = unasPropiedades.getProperty("FONTS_PATH", "C:/WINDOWS/Fonts");
		FINDER_VIEW_ALL = unasPropiedades.getProperty("FINDER_VIEW_ALL", "false");
		REPORTER_TEMPLATES_PATH = unasPropiedades.getProperty("REPORTER_TEMPLATES_PATH", "/efren/resources/report_templates/");
		DELEGATE_WINDOW_OPEN_MODE = unasPropiedades.getProperty("DELEGATE_WINDOW_OPEN_MODE", "fixedLocation");
		INSTITUCION_NOMBRE = unasPropiedades.getProperty("INSTITUCION_NOMBRE", "Sistema Empresarial");
		INSTITUCION_WEB = unasPropiedades.getProperty("INSTITUCION_WEB", "www.java.com");
		SERVER_NAME = unasPropiedades.getProperty("SERVER_NAME", "Servidor Central");
		ABOUT_DIALOG_Line01 = unasPropiedades.getProperty("ABOUT_DIALOG_Line01", "Sistema Empresarial");
		DATA_STORE_NAME = unasPropiedades.getProperty("DATA_STORE_NAME");
		DATA_STORE_IP = unasPropiedades.getProperty("DATA_STORE_IP");
		DATA_STORE_PORT = unasPropiedades.getProperty("DATA_STORE_PORT");
		SCHEMA_PRINCIPAL = unasPropiedades.getProperty("SCHEMA_PRINCIPAL");
		EXTRA_OPTION_CLASS_NAME = unasPropiedades.getProperty("EXTRA_OPTION_CLASS_NAME");
		EXTRA_PROPERTIES_01_CLASSNAME = unasPropiedades.getProperty("EXTRA_PROPERTIES_01_CLASSNAME");
		EXTRA_PROPERTIES_01_FILENAME = unasPropiedades.getProperty("EXTRA_PROPERTIES_01_FILENAME");

		if (EXTRA_PROPERTIES_01_CLASSNAME != null && EXTRA_PROPERTIES_01_CLASSNAME.trim().length() > 0) {
			try {
				Object args[] = new Object[] { EXTRA_PROPERTIES_01_FILENAME };
				MethodInvocation.performStaticMethod("initialize", Class.forName(EXTRA_PROPERTIES_01_CLASSNAME.trim()), args);
			} catch (Throwable tex2) {
				tex2.getMessage();
			}
		}

	}
}