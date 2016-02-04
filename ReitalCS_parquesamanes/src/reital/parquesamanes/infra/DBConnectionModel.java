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

	public static boolean autenticar(String userName, String clave) {
		try {
			Locale.setDefault(new Locale("es", "ES"));

			if (userName.equalsIgnoreCase(ParqueSamanesConstantes.Security.ADMIN_USERNAME)
					&& clave.equalsIgnoreCase(ParqueSamanesConstantes.Security.ADMIN_PASSWORD)) {

				connect(false, userName);

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

	public static void dbConnect(boolean remote) throws SQLException, ClassNotFoundException {

		connect(remote, null);
	}

	private static void connect(boolean remote, String appUserName) throws SQLException, ClassNotFoundException {

		DBProperties dbProp = buildDBProperties(
				remote ? ParqueSamanesConstantes.DataSource.REMOTE_FILE_PATH : Constantes.DATA_DIR, "sa", "");

		Connection aCon = DriverManager.getConnection(dbProp.getUrl(), dbProp.getUserName(), dbProp.getPassword());

		ParqueSamanesConn.setDBConnection(aCon);
		Conn.setCon(aCon);

		if (!remote) {
			SystemLogManager.info(
					"Ruta a utilizarse en conexiones remotas [DataSource.REMOTE_FILE_PATH]: " + Constantes.DATA_DIR);
		}
		SystemLogManager.debug(
				"DB CONNECTION FOR: " + (appUserName == null ? "sa" : appUserName) + " {" + dbProp.getUrl() + "}");

		new DBInitialization().createTables(remote);
	}

	private static DBProperties buildDBProperties(String remoteFilePath, String userName, String password)
			throws ClassNotFoundException {
		String urlTemp = null;
		Class.forName("org.h2.Driver");
		urlTemp = "jdbc:h2:tcp://" + ParqueSamanesConstantes.DataSource.IP + ":"
				+ ParqueSamanesConstantes.DataSource.PORT + "/" + remoteFilePath + "/"
				+ ParqueSamanesConstantes.DataSource.DBNAME + "/" + ParqueSamanesConstantes.DataSource.DBNAME;
		ParqueSamanesConstantes.Volatile.JDBC_URL = urlTemp;
		return new DBProperties(urlTemp, userName, password);
	}

	private static class DBProperties {

		private String url;
		private String userName;
		private String password;

		public DBProperties(String url, String userName, String password) {
			super();
			this.url = url;
			this.userName = userName;
			this.password = password;
		}

		public String getUrl() {
			return url;
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}
	}
}
