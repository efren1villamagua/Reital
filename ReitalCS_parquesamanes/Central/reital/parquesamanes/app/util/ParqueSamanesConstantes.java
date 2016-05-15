package reital.parquesamanes.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import efren.util.config.Constantes;
import efren.util.config.SystemProperties;

public class ParqueSamanesConstantes {

	public static final String SISTEMA_VERSION = "20160515_0222";

	public static final String ARCHIVO_CONFIGURACION = Constantes.CONFIG_DIR + File.separator
			+ "reital_parquesamanes.properties";

	public static final char ARDUINO_OPEN_CHAR = 'a';

	public static class Aplicacion {
		public static boolean TICKET_BAR_CODE_WITH_BAR_ID = true;
		public static int TICKET_BAR_CODE_LENGTH = 13;
		public static int SEGUNDOS_OFFSET = -1;
	}

	public static class LegalInfo {
		public static String SRI_NOMBRE = "_undefined_";
		public static String SRI_RUC = "_undefined_";
		public static String NOMBRE_COMERCIAL = "Parque Samanes";
	}

	public static class DataSource {
		public static String TYPE = "h2";
		public static String IP = "127.0.0.1";
		public static String PORT = "9092";
		public static String DBNAME = "ParqueSamanesDB";
		// public static String REMOTE_FILE_PATH = null;
	}

	public static class Security {
		public static final String ADMIN_USERNAME = "admin";
		public static final String ADMIN_PASSWORD = "admin";
		public static final String USUARIO_TIPO_Administrador = "A";
		public static final String USUARIO_TIPO_Usuario = "U";
		public static final String USUARIO_ESTADO_Activo = "A";
		public static final String USUARIO_ESTADO_Inactivo = "I";
	}

	public static class Volatile {
		public static String JDBC_URL = null;
	}

	/**
	 *
	 */
	public static void setInitialValues() {
		SystemProperties.REPORTER_TEMPLATES_PATH = "/reital/parquesamanes/resource/templates/";
		SystemProperties.SYSTEM_TYPE = efren.util.config.Constantes.SYSTEM_TYPE_3_LO;
		SystemProperties.SISTEMA_ICONO_PATH = "/reital/parquesamanes/resource/images/CLOCK_16_hot.png";
	}

	/**
	 *
	 */
	public static void cargarPropiedades() {
		try {
			String configurationFilePath = ParqueSamanesConstantes.ARCHIVO_CONFIGURACION;
			InputStream propertiesFileIS = new FileInputStream(new File((configurationFilePath)));
			java.util.Properties propiedades = new java.util.Properties();
			propiedades.load(propertiesFileIS);

			// Aplicacion
			try {
				String temp = propiedades.getProperty("Aplicacion.TICKET_BAR_CODE_WITH_BAR_ID").trim();
				ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_WITH_BAR_ID = temp.equalsIgnoreCase("SI");
				// if
				// (ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_WITH_BAR_ID)
				// {
				// ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_LENGTH =
				// 13;
				// } else {
				// ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_LENGTH =
				// 12;
				// }
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.Aplicacion.TICKET_BAR_CODE_LENGTH = Integer
						.parseInt(propiedades.getProperty("Aplicacion.TICKET_BAR_CODE_LENGTH").trim());
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.Aplicacion.SEGUNDOS_OFFSET = Integer
						.parseInt(propiedades.getProperty("Aplicacion.SEGUNDOS_OFFSET").trim());
			} catch (Exception exc) {
				exc.getMessage();
			}
			// LegalInfo
			try {
				ParqueSamanesConstantes.LegalInfo.SRI_NOMBRE = propiedades.getProperty("LegalInfo.SRI_NOMBRE").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.LegalInfo.SRI_RUC = propiedades.getProperty("LegalInfo.SRI_RUC").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL = propiedades
						.getProperty("LegalInfo.NOMBRE_COMERCIAL").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			// DataSource
			try {
				ParqueSamanesConstantes.DataSource.TYPE = propiedades.getProperty("DataSource.TYPE").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DataSource.IP = propiedades.getProperty("DataSource.IP").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DataSource.PORT = propiedades.getProperty("DataSource.PORT").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DataSource.DBNAME = propiedades.getProperty("DataSource.DBNAME").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			// try {
			// ParqueSamanesConstantes.DataSource.REMOTE_FILE_PATH = propiedades
			// .getProperty("DataSource.REMOTE_FILE_PATH").trim();
			// } catch (Exception exc) {
			// exc.getMessage();
			// }
			// ...
			propertiesFileIS.close();
		} catch (Throwable texc) {
			texc.getMessage();
		}
	}
}
