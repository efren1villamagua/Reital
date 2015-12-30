package reital.parquesamanes.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import efren.util.config.SystemProperties;

public class ParqueSamanesConstantes {
	/**
	 *
	 */
	public static final String SISTEMA_VERSION = "20151228_1014";

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
	public static String DATASOURCE_TYPE = "h2";

	public static String DATASOURCE_IP = "127.0.0.1";

	public static String DATASOURCE_PORT = "50000";

	public static String DATASOURCE_DBNAME = "ANY_DB";

	public static String PUERTO_SERIAL = "COM6";

	public static String PUERTA_1_OPEN = "A";

	public static String PUERTA_1_CLOSE = "B";

	public static String PUERTA_2_OPEN = "2";

	public static String PUERTA_2_CLOSE = "3";

	public static boolean TICKET_BAR_CODE_WITH_BAR_ID = true;

	public static int TICKET_BAR_CODE_LENGTH = 13;

	public static int MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = 60;

	public static String ADMIN_USERNAME = "admin";

	public static String ADMIN_PASSWORD = "admin";

	public static String EMPRESA_NOMBRE_01 = "ParqueSamanes";

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
				ParqueSamanesConstantes.DATASOURCE_TYPE = propiedades.getProperty("DATASOURCE_TYPE").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DATASOURCE_IP = propiedades.getProperty("DATASOURCE_IP").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DATASOURCE_PORT = propiedades.getProperty("DATASOURCE_PORT").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			try {
				ParqueSamanesConstantes.DATASOURCE_DBNAME = propiedades.getProperty("DATASOURCE_DBNAME").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
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
				ParqueSamanesConstantes.EMPRESA_NOMBRE_01 = propiedades.getProperty("EMPRESA_NOMBRE_01").trim();
			} catch (Exception exc) {
				exc.getMessage();
			}
			/*
			 * try { ParqueSamanesConstantes.EMPRESA_NOMBRE_02 =
			 * propiedades.getProperty("EMPRESA_NOMBRE_02").trim(); } catch
			 * (Exception exc) { exc.getMessage(); } try {
			 * ParqueSamanesConstantes.EMPRESA_RUC =
			 * propiedades.getProperty("EMPRESA_RUC").trim(); } catch (Exception
			 * exc) { exc.getMessage(); } try {
			 * ParqueSamanesConstantes.EMPRESA_DIRECCION =
			 * propiedades.getProperty("EMPRESA_DIRECCION").trim(); } catch
			 * (Exception exc) { exc.getMessage(); } try {
			 * ParqueSamanesConstantes.EMPRESA_TELEFONOS =
			 * propiedades.getProperty("EMPRESA_TELEFONOS").trim(); } catch
			 * (Exception exc) { exc.getMessage(); }
			 */
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
			// ...
			propertiesFileIS.close();
		} catch (Throwable texc) {
			texc.getMessage();
		}
	}
}
