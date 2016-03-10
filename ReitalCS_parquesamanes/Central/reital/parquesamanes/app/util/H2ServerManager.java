package reital.parquesamanes.app.util;

import java.sql.SQLException;
import java.util.Locale;

import org.h2.tools.Server;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import reital.parquesamanes.infra.ParqueSamanesConn;

public class H2ServerManager {

	public static void main(String[] args1) {

		String baseDir = null;
		try {
			if (args1.length >= 1) {
				baseDir = args1[0];
			}
			System.setProperty("efren.util.config.basedir", ((baseDir == null || baseDir.trim().length() == 0)
					? System.getProperty("user.dir") : baseDir.trim()));
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		try {
			LoggerManager.init(
					ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "_" + H2ServerManager.class.getSimpleName());
			SystemLogManager.setLogger(LoggerManager.logger);
		} catch (Exception e) {
			e.getMessage();
		}
		Locale.setDefault(new Locale("es", "ES"));

		H2ServerManager.h2ServerStart();
	}

	private static void h2ServerStart() {
		if (ParqueSamanesConn.getH2Server() == null) {
			try {

				String args[] = new String[] { "-tcpAllowOthers" };
				ParqueSamanesConn.setH2Server(Server.createTcpServer(args).start());

				String mensaje = "H2Server inicializado con valores default.";
				SystemLogManager.info(mensaje);
				System.out.println(mensaje);

			} catch (SQLException e) {
				e.printStackTrace();
				String mensaje = "ERROR: (" + e.getClass().getSimpleName() + "): " + e.getMessage();
				SystemLogManager.error(mensaje);
				System.out.println(mensaje);
			} catch (Exception e) {
				e.printStackTrace();
				String mensaje = "ERROR: (" + e.getClass().getSimpleName() + "): " + e.getMessage();
				SystemLogManager.error(mensaje);
				System.out.println(mensaje);
			}
		}
	}
}
