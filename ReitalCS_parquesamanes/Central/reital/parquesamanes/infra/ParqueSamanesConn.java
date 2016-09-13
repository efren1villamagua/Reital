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

	public static void setH2Server(Server h2Server) {
		ParqueSamanesConn.h2Server = h2Server;
	}

	public static boolean isH2ServerNull() {
		return ParqueSamanesConn.h2Server == null;
	}

	public static void stopH2Server() {
		ParqueSamanesConn.h2Server.stop();
	}

}