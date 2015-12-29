package reital.parquesamanes.infra;

import java.sql.Connection;

public class ParqueSamanesConn {

	public ParqueSamanesConn() {
	}

	private static Connection con = null;

	public static void setConnection(Connection unaConn) {
		con = unaConn;
	}
	public static Connection getConnection() {
		return con;
	}
}