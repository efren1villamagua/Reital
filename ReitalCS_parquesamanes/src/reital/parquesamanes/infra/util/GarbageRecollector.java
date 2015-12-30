package reital.parquesamanes.infra.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import efren.util.SystemLogManager;

public class GarbageRecollector {

	public static void closeAndFinalize(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception exc0) {
					exc0.getMessage();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception exc0) {
					exc0.getMessage();
				}
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
	}
}
