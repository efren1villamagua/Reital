package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import efren.util.SystemLogManager;
import efren.util.config.SystemProperties;
import reital.parquesamanes.domain.FranjaHorariaRepository;
import reital.parquesamanes.domain.entidades.FranjaHoraria;
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
			sql.append(" FROM " + SystemProperties.SCHEMA_PRINCIPAL + "." + "FRANJA_HORARIA fh ");
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

			sql.append(" INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES + "." + "FRANJA_HORARIA ");
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

			sql.append(" UPDATE " + SystemProperties.SCHEMA_SEGURIDADES + "." + "FRANJA_HORARIA ");
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

			sql.append(" DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES + "." + "FRANJA_HORARIA ");
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
}
