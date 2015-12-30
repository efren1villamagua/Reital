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
		String url = null;
		if (oracle) {
			// new OracleDriver();
			url = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":"
					+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
		} else {
			// new DB2Driver();
			// url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":"
			// + ParqueSamanesConstantes.DATASOURCE_PORT + "/"
			// + ParqueSamanesConstantes.DATASOURCE_DBNAME;
			Class.forName("org.h2.Driver");
			url = "jdbc:h2:file:" + Constantes.DATA_DIR + "/" + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "_db/" + ParqueSamanesConstantes.EMPRESA_NOMBRE_01
					+ "_db";
		}
		Connection aCon = DriverManager.getConnection(url, "sa", "");

		ParqueSamanesConn.setConnection(aCon);
		Conn.setCon(aCon);

		SystemLogManager.debug("DB CONNECTION FOR: sa {" + url + "}");

		new DBInitialization().createTables();
	}

}
