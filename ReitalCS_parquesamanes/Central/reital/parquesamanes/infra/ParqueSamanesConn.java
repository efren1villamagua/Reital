package reital.parquesamanes.infra;

import java.sql.Connection;

import org.h2.tools.Server;

public class ParqueSamanesConn {

	private static Connection con = null;
	private static Server h2Server = null;

	public static void setDBConnection(Connection unaConn) {
		con = unaConn;
	}

	public static Connection getDBConnection() {
		return con;
	}

	public static Server getH2Server() {
		return h2Server;
	}

	public static void setH2Server(Server h2Server) {
		ParqueSamanesConn.h2Server = h2Server;
	}
}