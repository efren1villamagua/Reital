package reital.parquesamanes.infra;

import java.sql.Connection;

import org.h2.tools.Server;

public class ParqueSamanesConn {

	private static Connection con = null;
	private static Server h2Server = null;

	public static void init(Connection unaConn, Server unH2Server) {
		con = unaConn;
		h2Server = unH2Server;
	}

	public static Connection getConnection() {
		return con;
	}

	public static Server getH2Server() {
		return h2Server;
	}
}