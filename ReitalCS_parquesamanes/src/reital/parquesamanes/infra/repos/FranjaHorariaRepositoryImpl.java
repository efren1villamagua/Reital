package reital.parquesamanes.infra.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import efren.util.SystemLogManager;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.FranjaHoraria;
import reital.parquesamanes.domain.repos.FranjaHorariaRepository;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class FranjaHorariaRepositoryImpl implements FranjaHorariaRepository {

	@SuppressWarnings("deprecation")
	public List<FranjaHoraria> getAll() {

		Statement st = null;

		ArrayList<FranjaHoraria> bos = new ArrayList<FranjaHoraria>();

		try {

			st = ParqueSamanesConn.getConnection().createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT fh.CODIGO, fh.NOMBRE, fh.HORA_INICIO, fh.HORA_FIN, fh.OBSERVACIONES, fh.HORAS_VALORES ");
			sql.append(" FROM  FRANJA_HORARIA fh ");
			sql.append(" ORDER BY fh.HORA_INICIO");

			SystemLogManager.debug(sql.toString());

			ResultSet rs = st.executeQuery(sql.toString());

			FranjaHoraria bo;

			while (rs.next()) {

				bo = new FranjaHoraria();

				bo.setCodigo(rs.getString("CODIGO").trim());
				bo.setNombre(rs.getString("NOMBRE").trim());

				bo.setHoraInicio(rs.getTimestamp("HORA_INICIO").getHours() + ":" + rs.getTimestamp("HORA_INICIO").getMinutes());
				bo.setHoraFin(rs.getTimestamp("HORA_FIN").getHours() + ":" + rs.getTimestamp("HORA_FIN").getMinutes());

				// bo.setValorPorHora(rs.getBigDecimal("VALOR_POR_HORA").setScale(2,
				// BigDecimal.ROUND_HALF_UP));

				bo.setObservaciones(rs.getString("OBSERVACIONES").trim());
				bo.setHorasValores(rs.getString("HORAS_VALORES").trim());

				bos.add(bo);
			}

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return bos;

	}

	public boolean create(String codigo, String nombre, String horaInicio, String horaFin, String observaciones, String horasValores) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" INSERT INTO  FRANJA_HORARIA ");
			sql.append(" (CODIGO, NOMBRE, HORA_INICIO, HORA_FIN, VALOR_POR_HORA, OBSERVACIONES, HORAS_VALORES) VALUES ( ");
			sql.append(" '" + codigo + "', '" + nombre + "', ");
			sql.append(" { ts '2000-01-01 " + horaInicio + ":00' }, { ts '2000-01-01 " + horaFin + ":00' }, ");
			sql.append(" 0, '" + observaciones + "', '" + horasValores + "' )");

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

	public boolean update(String codigo, String nombre, String horaInicio, String horaFin, String observaciones, String horasValores) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" UPDATE  FRANJA_HORARIA ");
			sql.append(" SET ");
			sql.append(" NOMBRE='" + nombre + "',");
			sql.append(" HORA_INICIO={ ts '2000-01-01 " + horaInicio + ":00' },");
			sql.append(" HORA_FIN={ ts '2000-01-01 " + horaFin + ":00' },");
			sql.append(" OBSERVACIONES='" + observaciones + "', ");
			sql.append(" HORAS_VALORES='" + horasValores + "' ");
			sql.append(" WHERE CODIGO='" + codigo + "' ");
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

	public boolean delete(String codigo) {

		Statement st = null;

		int afectados = 0;
		try {

			Connection con = ParqueSamanesConn.getConnection();
			st = con.createStatement();

			StringBuffer sql = new StringBuffer();

			sql.append(" DELETE FROM  FRANJA_HORARIA ");
			sql.append(" WHERE CODIGO='" + codigo + "' ");
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

	public FranjaHoraria getFranjaHorariaFor(int minutos) {

		FranjaHoraria franja = null;
		Statement st = null;

		try {

			st = ParqueSamanesConn.getConnection().createStatement();

			boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");

			String sql = null;

			if (oracle) {
				sql = "SELECT " + " to_number(to_char(fh.HORA_INICIO, 'hh24'))*60+to_number(to_char(fh.HORA_INICIO, 'mi')) AS INICIO_MINUTOS, " + " fh.NOMBRE, "
						+ " fh.HORAS_VALORES " + " FROM  FRANJA_HORARIA fh " + " WHERE "
						+ "          to_number(to_char(fh.HORA_INICIO, 'hh24'))*60+to_number(to_char(fh.HORA_INICIO, 'mi')) <= " + minutos + " "
						+ "  AND to_number(to_char(fh.HORA_FIN, 'hh24'))*60+to_number(to_char(fh.HORA_FIN, 'mi')) >= " + minutos + " "
						+ " ORDER BY fh.HORA_INICIO ";
			} else {
				sql = "SELECT " + " HOUR(fh.HORA_INICIO)*60+MINUTE(fh.HORA_INICIO) AS INICIO_MINUTOS, " + " fh.NOMBRE, " + " fh.HORAS_VALORES "
						+ " FROM  FRANJA_HORARIA fh " + " WHERE " + "          HOUR(fh.HORA_INICIO)*60+MINUTE(fh.HORA_INICIO) <= " + minutos + " "
						+ "  AND HOUR(fh.HORA_FIN)*60+MINUTE(fh.HORA_FIN) >= " + minutos + " " + " ORDER BY fh.HORA_INICIO ";
			}

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				franja = new FranjaHoraria();

				franja.setNombre(rs.getString("NOMBRE").trim());
				franja.setHorasValores(rs.getString("HORAS_VALORES").trim());
				franja.setInicioMinutos(rs.getInt("INICIO_MINUTOS"));
				/**
				 * NOS QUEDAMOS CON LA PRIMERA FRANJA HORARIA (EN EL CASO DE
				 * CRUCES DE FRANJAS)
				 */
				break;
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return franja;
	}
}
