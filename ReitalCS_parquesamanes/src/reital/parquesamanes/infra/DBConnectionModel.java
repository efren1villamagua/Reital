package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import efren.util.CoderManager;
import efren.util.Conn;
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
				url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + "/" + ParqueSamanesConstantes.DATASOURCE_DBNAME;
			}
			Connection aCon = DriverManager.getConnection(url, userName, clave);
			ParqueSamanesConn.setConnection(aCon);
			Conn.setCon(aCon);
			return true;
		} catch (SQLException exc) {
			exc.getMessage();
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
			url = "jdbc:oracle:thin:@" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + ":" + ParqueSamanesConstantes.DATASOURCE_DBNAME;
		} else {
			new DB2Driver();
			url = "jdbc:db2://" + ParqueSamanesConstantes.DATASOURCE_IP + ":" + ParqueSamanesConstantes.DATASOURCE_PORT + "/" + ParqueSamanesConstantes.DATASOURCE_DBNAME;
		}
		Connection aCon = DriverManager.getConnection(url, ParqueSamanesConstantes.DB_USUARIO, CoderManager.decrypt(ParqueSamanesConstantes.DB_KEY));
		ParqueSamanesConn.setConnection(aCon);
		efren.util.Conn.setCon(aCon);
	}

}
