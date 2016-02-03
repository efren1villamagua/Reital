package reital.parquesamanes.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import efren.util.config.SystemProperties;

public class ParqueSamanesConstantes {
	/**
	 *
	 */
	public static final String SISTEMA_VERSION = "20160203_0220";

	/**
	 *
	 */
	public static final String USUARIO_TIPO_Administrador = "A";

	public static final String USUARIO_TIPO_Usuario = "U";

	public static final String USUARIO_ESTADO_Activo = "A";

	public static final String USUARIO_ESTADO_Inactivo = "I";

	/**
	 *
	 */
	public static final String ARCHIVO_CONFIGURACION = "c:/reital_parquesamanes.properties";

	/**
	 *
	 */

	public static String PUERTO_SERIAL = "COM6";

	public static String PUERTA_1_OPEN = "A";

	public static String PUERTA_1_CLOSE = "B";

	public static String PUERTA_2_OPEN = "2";

	public static String PUERTA_2_CLOSE = "3";

	public static boolean TICKET_BAR_CODE_WITH_BAR_ID = true;

	public static int TICKET_BAR_CODE_LENGTH = 13;

	public static int MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = 10;

	public static String ADMIN_USERNAME = "admin";

	public static String ADMIN_PASSWORD = "admin";

	public static class LegalInfo {

		public static String SRI_NOMBRE = "_undefined_";
		public static String SRI_RUC = "_undefined_";
		public static String NOMBRE_COMERCIAL = "ParqueSamanes";

	}

	public static class DataSource {

		public static String TYPE = "h2";
		public static String IP = "127.0.0.1";
		public static String PORT = "50000";
		public static String DBNAME = "ParqueSamanesDB";

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

			try {
				String temp = propiedades.getProperty("TICKET_BAR_CODE_WITH_BAR_ID").trim();
				ParqueSamanesConstantes.TICKET_BAR_CODE_WITH_BAR_ID = temp.equalsIgnoreCase("SI");
				if (ParqueSamanesConstantes.TICKET_BAR_CODE_WITH_BAR_ID) {
					ParqueSamanesConstantes.TICKET_BAR_CODE_LENGTH = 13;
				} else {
					ParqueSamanesConstantes.TICKET_BAR_CODE_LENGTH = 12;
				}
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.PUERTO_SERIAL = propiedades.getProperty("PUERTO_SERIAL").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.PUERTA_1_OPEN = propiedades.getProperty("PUERTA_1_OPEN").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.PUERTA_1_CLOSE = propiedades.getProperty("PUERTA_1_CLOSE").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.PUERTA_2_OPEN = propiedades.getProperty("PUERTA_2_OPEN").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.PUERTA_2_CLOSE = propiedades.getProperty("PUERTA_2_CLOSE").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			/*
			 * try { ParqueSamanesConstantes.
			 * MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = new
			 * Integer(propiedades.getProperty(
			 * "MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes").trim()).intValue();
			 * } catch (Exception exc) { exc.getMessage(); }
			 */
			try {
				ParqueSamanesConstantes.ADMIN_USERNAME = propiedades.getProperty("ADMIN_USERNAME").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.ADMIN_PASSWORD = propiedades.getProperty("ADMIN_PASSWORD").trim();
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
				ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL = propiedades.getProperty("LegalInfo.NOMBRE_COMERCIAL").trim();
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

			// ...
			propertiesFileIS.close();
		} catch (Throwable texc) {
			texc.getMessage();
		}
	}
}
