package reital.parquesamanes.app.util;

import java.sql.SQLException;

import org.h2.tools.Server;

import efren.util.SystemLogManager;
import reital.parquesamanes.infra.ParqueSamanesConn;

public class H2ServerManager {

	public static void h2ServerStart() {
		if (ParqueSamanesConn.getH2Server() == null) {
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
