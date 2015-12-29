package efren.util.config;

import java.io.File;

public class Constantes {
	/**
	 *
	 */
	public static final String TEMP_DIR = System.getProperty("user.dir") + File.separator + "temp";

	public static final String LOGS_DIR = System.getProperty("user.dir") + File.separator + "logs";

	public static final String CONFIG_DIR = System.getProperty("user.dir") + File.separator + "config";

	/**
	 *
	 */
	public static final int SYSTEM_TYPE_3_LO = 3;

	public static final int SYSTEM_TYPE_4_ADMIN = 4;

	/**
	 *
	 */
	public static final int SERVER_TYPE_1_OS400 = 1;

	public static final int SERVER_TYPE_2_WINDOWS_UNIX = 2;

	/**
	 *
	 */
	public static final int SEGURIDADES_USUARIO_TIPO_Administrador = 1;

	public static final int SEGURIDADES_USUARIO_TIPO_Usuario = 2;

	/**
	 *
	 */
	public static final int SEGURIDADES_DEPENDENCIA_TIPO_Matriz = 1;

	public static final int SEGURIDADES_DEPENDENCIA_TIPO_Sucursal = 2;

	public static final int SEGURIDADES_DEPENDENCIA_TIPO_Externa = 3;

	/**
	 *
	 */
	public static final int SISTEMA_ESTADO_Activo = 1;

	public static final int SISTEMA_ESTADO_Inactivo = 2;

	/**
	 *
	 */
	public static final String TEMPNOUSE1 = "Sistema Empresarial con Java 2nd Enterprise Edition";
}