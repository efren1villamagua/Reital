package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import efren.util.CoderManager;
import efren.util.Conn;
import efren.util.SystemLogManager;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class DBConnectionModel {
	/**
	 *
	 */
	public static boolean autenticar(String userName, String clave) {
		try {
			Locale.setDefault(new Locale("es", "ES"));
			/**
			 * AUTENTICACION CONTRA LA BASE DE DATOS
			 */
			boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");
			String url = null;
			if (oracle) {
				new OracleDriver();
				url = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":"
						+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
			} else {
				new DB2Driver();
				url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + "/"
						+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
			}
			Connection aCon = DriverManager.getConnection(url, userName, clave);

			ParqueSamanesConn.setConnection(aCon);
			Conn.setCon(aCon);

			SystemLogManager.debug("DB CONNECTION FOR: " + userName + " {" + url + "}");

			SystemLogManager.info("USUARIO AUTENTICADO OK: " + userName);

			return true;
		} catch (SQLException exc) {
			SystemLogManager.error(exc);
			return false;
		}
	}

	/**
	 * @throws SQLException
	 *
	 */
	public static void setSQLConnection() throws SQLException {
		boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");
		String url = null;
		if (oracle) {
			new OracleDriver();
			url = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":"
					+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
		} else {
			new DB2Driver();
			url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + "/"
					+ ParqueSamanesConstantes.DATASOURCE_DBNAME;
		}
		Connection aCon = DriverManager.getConnection(url, ParqueSamanesConstantes.DB_USUARIO, CoderManager.decrypt(ParqueSamanesConstantes.DB_KEY));

		ParqueSamanesConn.setConnection(aCon);
		Conn.setCon(aCon);

		SystemLogManager.debug("DB CONNECTION FOR: " + ParqueSamanesConstantes.DB_USUARIO + " {" + url + "}");
	}

}
