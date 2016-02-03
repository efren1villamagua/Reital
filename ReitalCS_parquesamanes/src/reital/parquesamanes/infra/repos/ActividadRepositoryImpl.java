package reital.parquesamanes.infra.repos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import efren.util.CalendarManager;
import efren.util.SystemLogManager;
import reital.parquesamanes._view.seguridades.LogonView;
import reital.parquesamanes._view.working.PagoHelper;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity.EstadoSalida;
import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class ActividadRepositoryImpl implements ActividadRepository {

	public boolean yaSalio(String codigo) {

		Statement st = null;

		int count = 0;
		try {
			String sql = "SELECT COUNT(CODIGO) AS CUANTOS_HAY FROM  ACTIVIDAD WHERE CODIGO='" + codigo + "' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("CUANTOS_HAY");
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return count > 0;
	}

	public boolean registrarActividad(ActividadForPagoEntity registroActividad) {

		PreparedStatement ps = null;

		boolean seRegistro = false;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO  ACTIVIDAD ");
			sql.append(" (CODIGO, ENTRADA, SALIDA, VALOR, VALOR_HORA_FRACCION, TIPO_CLIENTE, ");
			sql.append(" OBSERVACIONES, FRANJA_HORARIA, CANTIDAD_HORAS, ESTADO ) ");
			sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps = ParqueSamanesConn.getConnection().prepareStatement(sql.toString());

			StringBuffer paramMetaClause = new StringBuffer();
			paramMetaClause.append(" PARAMS{");

			ps.setString(1, registroActividad.getCodigo().trim());
			paramMetaClause.append("[1-> " + registroActividad.getCodigo().trim() + "]");

			ps.setTimestamp(2, new Timestamp(registroActividad.getEntrada().getTimeInMillis()));
			paramMetaClause.append("[2-> " + registroActividad.getEntrada().getTimeInMillis() + "]");

			ps.setTimestamp(3, new Timestamp(registroActividad.getSalida().getTimeInMillis()));
			paramMetaClause.append("[3-> " + registroActividad.getSalida().getTimeInMillis() + "]");

			ps.setBigDecimal(4, registroActividad.getValor());
			paramMetaClause.append("[4-> " + registroActividad.getValor() + "]");

			ps.setBigDecimal(5, registroActividad.getValorHoraOFraccion());
			paramMetaClause.append("[5-> " + registroActividad.getValorHoraOFraccion() + "]");

			ps.setString(6, registroActividad.getTipoCliente().getValor());
			paramMetaClause.append("[6-> " + registroActividad.getTipoCliente().getValor() + "]");

			String observaciones = registroActividad.getObservaciones().trim();
			if (observaciones.length() == 0) {
				observaciones = "---";
			}
			observaciones = (LogonView.isAdmin() ? "[A-" : "[U-") + LogonView.getUsername().trim() + "] " + observaciones;
			ps.setString(7, observaciones);
			paramMetaClause.append("[7-> " + observaciones + "]");

			ps.setString(8, registroActividad.getFranjaHoraria().trim());
			paramMetaClause.append("[8-> " + registroActividad.getFranjaHoraria() + "]");

			ps.setInt(9, registroActividad.getCantidadHoras());
			paramMetaClause.append("[9-> " + registroActividad.getCantidadHoras() + "]");

			ps.setString(10, registroActividad.getEstadoPago().getValor());
			paramMetaClause.append("[10-> " + registroActividad.getEstadoPago().getValor() + "]");

			paramMetaClause.append("} ");
			SystemLogManager.debug(sql.toString() + paramMetaClause);

			int insertados = ps.executeUpdate();

			seRegistro = insertados > 0;
			if (seRegistro) {
				registroActividad.setEstadoSalida(EstadoSalida.PENDIENTE_DE_SALIDA);
			}

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, ps, null);

		return seRegistro;
	}

	public ActividadForPagoEntity getActividad(String codigo) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		ActividadForPagoEntity entidad = null;

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(" CODIGO, ENTRADA, SALIDA, VALOR, VALOR_HORA_FRACCION, TIPO_CLIENTE, ");
			sql.append(" OBSERVACIONES, FRANJA_HORARIA, CANTIDAD_HORAS, ESTADO ");
			sql.append(" FROM ACTIVIDAD ");
			sql.append(" WHERE CODIGO=? ");
			ps = ParqueSamanesConn.getConnection().prepareStatement(sql.toString());

			StringBuffer paramMetaClause = new StringBuffer();
			paramMetaClause.append(" PARAMS{");

			ps.setString(1, codigo.trim());
			paramMetaClause.append("[1-> " + codigo.trim() + "]");

			paramMetaClause.append("} ");
			SystemLogManager.debug(sql.toString() + paramMetaClause);

			rs = ps.executeQuery();

			while (rs.next()) {

				entidad = new ActividadForPagoEntity();

				entidad.setCodigo(rs.getString("CODIGO").trim());
				if (entidad.getCodigo() != null) {
					entidad.setBarraId(entidad.getCodigo().substring(0, 1));
				}
				CalendarManager cmTemp = new CalendarManager(rs.getTimestamp("ENTRADA").getTime());
				entidad.setEntrada(cmTemp.getCalendar());
				cmTemp = new CalendarManager(rs.getTimestamp("SALIDA").getTime());
				entidad.setSalida(cmTemp.getCalendar());
				entidad.setValor(rs.getBigDecimal("VALOR").setScale(2, BigDecimal.ROUND_HALF_UP));
				entidad.setValorHoraOFraccion(rs.getBigDecimal("VALOR_HORA_FRACCION").setScale(2, BigDecimal.ROUND_HALF_UP));
				entidad.setObservaciones(rs.getString("OBSERVACIONES").trim());
				entidad.setFranjaHoraria(rs.getString("FRANJA_HORARIA").trim());
				entidad.setCantidadHoras(rs.getInt("CANTIDAD_HORAS"));
				entidad.setTipoCliente(PagoHelper.getTIPO_CLIENTE_from(rs.getString("TIPO_CLIENTE").trim()));
				entidad.setEstadoPago(ActividadForPagoEntity.getEstadoPago_from(rs.getString("ESTADO").trim()));
				// ...
				break;
			}

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(rs, ps, null);

		return entidad;
	}

}
