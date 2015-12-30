package reital.parquesamanes.infra.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import efren.util.StringTools;
import efren.util.SystemLogManager;
import reital.parquesamanes._view.seguridades.LogonView;
import reital.parquesamanes._view.working.PagoHelper.CadenaPair;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class ActividadRepositoryImpl implements ActividadRepository {

	public boolean yaSalio(CadenaPair cp) {

		Statement st = null;

		// String barraId = cp.getBarraId();
		GregorianCalendar gc = cp.getCalendar();
		int count = 0;
		try {
			Timestamp tstamp = new Timestamp(gc.getTimeInMillis());
			String sql = "SELECT COUNT(SALIDA) AS CUANTOS_HAY " + " FROM  ACTIVIDAD " + " WHERE " + " ENTRADA={ ts '" + tstamp.toString() + "'} ";
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
			sql.append(" (CODIGO, ENTRADA, SALIDA, VALOR, VALOR_HORA_FRACCION, TIPO_CLIENTE, OBSERVACIONES, FRANJA_HORARIA, CANTIDAD_HORAS ) ");
			sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
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
			observaciones = (LogonView.isAdmin() ? "A" : "U")
					+ StringTools.rellenar(LogonView.getUsername().trim(), " ", (19 - LogonView.getUsername().trim().length()), StringTools.DIRECCION_DERECHA)
					+ observaciones;
			ps.setString(7, observaciones);
			paramMetaClause.append("[7-> " + observaciones + "]");

			ps.setString(8, registroActividad.getFranjaHoraria().trim());
			paramMetaClause.append("[8-> " + registroActividad.getFranjaHoraria() + "]");

			ps.setInt(9, registroActividad.getCantidadHoras());
			paramMetaClause.append("[9-> " + registroActividad.getCantidadHoras() + "]");

			paramMetaClause.append("} ");
			SystemLogManager.debug(sql.toString() + paramMetaClause);

			int insertados = ps.executeUpdate();

			seRegistro = insertados > 0;
			if (seRegistro) {
				registroActividad.setEstado(ActividadForPagoEntity.PENDIENTE_DE_SALIDA);
			}

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, ps, null);

		return seRegistro;
	}

}
