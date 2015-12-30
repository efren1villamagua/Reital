package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import efren.util.SystemLogManager;
import reital.parquesamanes.domain.UsuarioRepository;
import reital.parquesamanes.domain.entidades.Usuario;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class UsuarioRepositoryImpl implements UsuarioRepository {

	public List<Usuario> getAll(String orderBy) {

		Statement st = null;

		ArrayList<Usuario> bos = new ArrayList<Usuario>();

		try {

			st = ParqueSamanesConn.getConnection().createStatement();

			String sql = " SELECT " + " u.USERNAME, u.CLAVE, u.NOMBRE, u.TIPO, u.ESTADO " + " FROM  " + "USUARIO u ";
			if (orderBy == null) {
				sql = sql + " ORDER BY u.NOMBRE";
			} else {
				sql = sql + orderBy;
			}

			SystemLogManager.debug(sql.toString());

			ResultSet rs = st.executeQuery(sql.toString());

			Usuario bo;

			while (rs.next()) {

				bo = new Usuario();

				bo.setNombre(rs.getString("NOMBRE").trim());
				bo.setUserName(rs.getString("USERNAME").trim());
				bo.setEstado(rs.getString("ESTADO"));
				bo.setClave(rs.getString("CLAVE").trim());
				bo.setTipo(rs.getString("TIPO"));

				bos.add(bo);
			}

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return bos;

	}

	public boolean create(String userName, String clave, String nombre, String tipo, String estado) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" INSERT INTO  " + "USUARIO " + " (USERNAME, CLAVE, NOMBRE, TIPO, ESTADO) VALUES ( '" + userName + "', '" + clave + "', '" + nombre
					+ "', '" + tipo + "', '" + estado + "') ");

			SystemLogManager.debug(sql.toString());

			afectados = st.executeUpdate(sql.toString());

			st.close();

		} catch (Throwable t) {
			SystemLogManager.error(t);
			GarbageRecollector.closeAndFinalize(null, st, null);
			return false;
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return afectados > 0;
	}

	public boolean update(String userName, String clave, String nombre, String tipo, String estado) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" UPDATE  " + "USUARIO " + " SET " + " CLAVE='" + clave + "', NOMBRE='" + nombre + "', TIPO='" + tipo + "', ESTADO='" + estado + "' "
					+ " WHERE USERNAME='" + userName + "' ");
			SystemLogManager.debug(sql.toString());

			afectados = st.executeUpdate(sql.toString());

			st.close();
			con.commit();

		} catch (Throwable t) {
			SystemLogManager.error(t);
			GarbageRecollector.closeAndFinalize(null, st, null);
			return false;
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return afectados > 0;
	}

	public boolean delete(String userName) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" DELETE FROM  " + "USUARIO WHERE USERNAME='" + userName + "' ");
			SystemLogManager.debug(sql.toString());

			afectados = st.executeUpdate(sql.toString());

			st.close();
			con.commit();

		} catch (Throwable t) {
			SystemLogManager.error(t);
			GarbageRecollector.closeAndFinalize(null, st, null);
			return false;
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return afectados > 0;
	}

}
