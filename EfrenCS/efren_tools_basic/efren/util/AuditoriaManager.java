package efren.util;

import java.net.InetAddress;
import java.sql.Statement;

import efren.util.config.Constantes;
import efren.util.config.SystemProperties;

public class AuditoriaManager {
	/**
	 *
	 */
	public static int audit(Statement aSt, int afectados, long unRegistroOid, String unRegistroAudit, String unNombreTabla, int unActionType) throws Throwable {
		if (afectados > 0) {

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {// SISTEMA
																				// LOCAL
																				// (SIN
																				// SERVIDOR
																				// DE
																				// APLICACIONES)
				try {
					String registro = StringTools.parseComilla(unRegistroAudit);
					String sql = "INSERT INTO " + SystemProperties.SCHEMA_UTIL
							+ ".AUDITORIA (REGISTROOID,USUARIO,NOMBREUSUARIO,USUARIOHOST,TABLA,TIPOTRANSACCION," + "REGISTROACTUAL,UTC) VALUES ("
							+ unRegistroOid + ",'" + SystemProperties.RUNTIME_USER_NAME + "','" + SystemProperties.RUNTIME_NOMBRE_USUARIO + "','"
							+ InetAddress.getLocalHost().getHostAddress() + "','" + unNombreTabla + "'," + unActionType + ",'" + registro
							+ "',CURRENT TIMESTAMP)";
					int afectadosAudit = aSt.executeUpdate(sql);
					return afectadosAudit;
				} catch (Throwable t) {
					t.getMessage();
					return 0;
				}
			} else {
				return 0;
			}

		} else {
			throw new Throwable("¡ Otro usuario o aplicación actualizó el registro antes que Ud., " + "o el registro ya no existe !");
		}
	}
}