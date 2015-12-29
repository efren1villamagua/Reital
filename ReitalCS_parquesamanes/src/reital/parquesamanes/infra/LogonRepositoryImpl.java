package reital.parquesamanes.infra;

import java.sql.ResultSet;
import java.sql.Statement;

import efren.util.SystemLogManager;
import efren.util.config.SystemProperties;
import reital.parquesamanes.domain.AutenticacionRespuesta;
import reital.parquesamanes.domain.AutenticacionRespuesta.ResultadoLogon;
import reital.parquesamanes.domain.LogonRepository;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class LogonRepositoryImpl implements LogonRepository {

	public AutenticacionRespuesta autenticar(String userName, String key) {

		AutenticacionRespuesta respuesta = new AutenticacionRespuesta();

		respuesta.setResultadoLogon(ResultadoLogon.USUARIO_O_CLAVE_INCORRECTA);

		try {

			DBConnectionModel.setSQLConnection();

			StringBuffer sqlClause = new StringBuffer();
			sqlClause.append("SELECT CLAVE, NOMBRE, TIPO, ESTADO ");
			sqlClause.append(" FROM " + SystemProperties.SCHEMA_SEGURIDADES + ".USUARIO ");
			sqlClause.append(" WHERE RTRIM(LTRIM(USERNAME))='" + userName.trim() + "' ");
			String clave_sys = null;

			Statement st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sqlClause.toString());
			ResultSet rs = st.executeQuery(sqlClause.toString());

			String nombre = null;

			boolean registroEncontrado = false;

			boolean administrador = false, activo = false;

			while (rs.next()) {
				nombre = rs.getString("NOMBRE").trim();
				clave_sys = rs.getString("CLAVE");

				administrador = rs.getString("TIPO").trim().equalsIgnoreCase(ParqueSamanesConstantes.USUARIO_TIPO_Administrador);
				activo = rs.getString("ESTADO").trim().equalsIgnoreCase(ParqueSamanesConstantes.USUARIO_ESTADO_Activo);

				registroEncontrado = true;

				break;
			}
			rs.close();
			st.close();

			if (!registroEncontrado) {
				SystemLogManager.info("Usuario no encontrado");
				respuesta.setResultadoLogon(ResultadoLogon.USUARIO_O_CLAVE_INCORRECTA);
			}

			if (!activo) {
				SystemLogManager.info("Usuario inactivo");
				respuesta.setResultadoLogon(ResultadoLogon.USUARIO_INACTIVO);
			}

			clave_sys = efren.util.CoderManager.decrypt(clave_sys);

			if (!key.equals(clave_sys)) {
				SystemLogManager.info("Clave incorrecta");
				respuesta.setResultadoLogon(ResultadoLogon.USUARIO_O_CLAVE_INCORRECTA);
			}

			respuesta.setAdmin(administrador);
			respuesta.setNombreUsuario(nombre);

			SystemLogManager.info("Autenticacion OK");
			respuesta.setResultadoLogon(ResultadoLogon.AUTENTICACION_OK);

		} catch (Exception exc) {
			SystemLogManager.error(exc);
			respuesta.setResultadoLogon(ResultadoLogon.ERROR_AL_AUTENTICAR);
		}

		return respuesta;
	}

}
