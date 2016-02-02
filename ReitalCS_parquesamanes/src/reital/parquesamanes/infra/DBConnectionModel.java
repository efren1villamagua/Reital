package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import efren.util.Conn;
import efren.util.SystemLogManager;
import efren.util.config.Constantes;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class DBConnectionModel {

	private static String URL_INFO = "";

	/**
	 *
	 */
	public static boolean autenticar(String userName, String clave) {
		try {
			Locale.setDefault(new Locale("es", "ES"));

			if (userName.equalsIgnoreCase(ParqueSamanesConstantes.ADMIN_USERNAME) && clave.equalsIgnoreCase(ParqueSamanesConstantes.ADMIN_PASSWORD)) {

				/**
				 * AUTENTICACION CONTRA LA BASE DE DATOS
				 */
				boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");
				String url = null;
				if (oracle) {
					// new OracleDriver();
					url = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":"
							+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
				} else {
					// new DB2Driver();
					// url = "jdbc:db2://" +
					// ParqueSamanesConstantes.DATASOURCE_IP +
					// ":" + ParqueSamanesConstantes.DATASOURCE_PORT + "/"
					// + ParqueSamanesConstantes.DATASOURCE_DBNAME;
					Class.forName("org.h2.Driver");
					url = "jdbc:h2:file:" + Constantes.DATA_DIR + "/" + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "_db/"
							+ ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "_db";
				}
				Connection aCon = DriverManager.getConnection(url, "sa", "");

				ParqueSamanesConn.setConnection(aCon);
				Conn.setCon(aCon);

				SystemLogManager.debug("DB CONNECTION FOR: " + userName + " {" + url + "}");

				new DBInitialization().createTables();

				SystemLogManager.info("USUARIO AUTENTICADO OK: " + userName);

				return true;

			} else {

				return false;
			}

		} catch (SQLException exc) {
			SystemLogManager.error(exc);
			return false;
		} catch (ClassNotFoundException exc) {
			SystemLogManager.error(exc);
			return false;
		}
	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	public static void setSQLConnection() throws SQLException, ClassNotFoundException {
		boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");
		String urlTemp = null;
		if (oracle) {
			// new OracleDriver();
			urlTemp = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":"
					+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
		} else {
			// new DB2Driver();
			// url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":"
			// + ParqueSamanesConstantes.DATASOURCE_PORT + "/"
			// + ParqueSamanesConstantes.DATASOURCE_DBNAME;
			Class.forName("org.h2.Driver");
			urlTemp = "jdbc:h2:file:" + Constantes.DATA_DIR + "/" + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "_db/"
					+ ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "_db";
		}

		setURL_INFO(urlTemp);

		Connection aCon = DriverManager.getConnection(getURL_INFO(), "sa", "");

		ParqueSamanesConn.setConnection(aCon);
		Conn.setCon(aCon);

		SystemLogManager.debug("DB CONNECTION FOR: sa {" + getURL_INFO() + "}");

		new DBInitialization().createTables();
	}

	/**
	 * @return the uRL_INFO
	 */
	public static String getURL_INFO() {
		return URL_INFO;
	}

	/**
	 * @param uRL_INFO
	 *            the uRL_INFO to set
	 */
	private static void setURL_INFO(String uRL_INFO) {
		URL_INFO = uRL_INFO;
	}

}
