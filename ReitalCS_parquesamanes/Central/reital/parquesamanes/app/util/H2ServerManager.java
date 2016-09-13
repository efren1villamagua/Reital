package reital.parquesamanes.app.util;

import java.sql.SQLException;
import java.util.Locale;

import org.h2.tools.Server;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import reital.parquesamanes.infra.ParqueSamanesConn;

public class H2ServerManager {

	private static class AddShutdownHook {
		public void attachShutDownHook() {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					String mensaje = "H2ServerManager detenido.";
					System.out.println(mensaje);
					ParqueSamanesConn.stopH2Server();
					SystemLogManager.info(mensaje);
				}
			});
		}
	}

	public static void main(String[] args) {

		AddShutdownHook shutdownHook = new AddShutdownHook();
		shutdownHook.attachShutDownHook();

		String postFix = "";
		InfoHelper.systemStarted(H2ServerManager.class.getSimpleName(), postFix);

		String baseDir = null;
		try {
			if (args.length >= 1) {
				baseDir = args[0];
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

			String mensaje = H2ServerManager.class.getName() + " " + ParqueSamanesConstantes.SISTEMA_VERSION
					+ " iniciando...";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

		} catch (Exception e) {
			e.getMessage();
		}
		InfoHelper.logCharset();
		Locale.setDefault(new Locale("es", "ES"));

		H2ServerManager.h2ServerStart();
	}

	public static void h2ServerStart() {
		if (ParqueSamanesConn.isH2ServerNull()) {
			try {

				String args[] = new String[] { "-tcpAllowOthers" };
				ParqueSamanesConn.setH2Server(Server.createTcpServer(args).start());

				String mensaje = "H2Server inicializado con valores default.";
				SystemLogManager.info(mensaje);
				System.out.println(mensaje);

				mensaje = H2ServerManager.class.getName() + " " + ParqueSamanesConstantes.SISTEMA_VERSION
						+ " trabajando...";
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
