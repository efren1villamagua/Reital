package reital.parquesamanes.infra;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import efren.util.StringTools;
import efren.util.SystemLogManager;
import efren.util.config.SystemProperties;
import reital.parquesamanes._view.seguridades.LogonView;
import reital.parquesamanes._view.working.PagoHelper.CadenaPair;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.PagoRepository;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class PagoRepositoryImpl implements PagoRepository {

	public FranjaHoraria getFranjaHorariaFor(int minutos) {

		FranjaHoraria franja = null;
		Statement st = null;

		try {

			st = ParqueSamanesConn.getConnection().createStatement();

			boolean oracle = ParqueSamanesConstantes.DATASOURCE_TYPE.equalsIgnoreCase("oracle");

			String sql = null;

			if (oracle) {
				sql = "SELECT " + " to_number(to_char(fh.HORA_INICIO, 'hh24'))*60+to_number(to_char(fh.HORA_INICIO, 'mi')) AS INICIO_MINUTOS, " + " fh.NOMBRE, "
						+ " fh.HORAS_VALORES " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + "." + "FRANJA_HORARIA fh " + " WHERE "
						+ "          to_number(to_char(fh.HORA_INICIO, 'hh24'))*60+to_number(to_char(fh.HORA_INICIO, 'mi')) <= " + minutos + " "
						+ "  AND to_number(to_char(fh.HORA_FIN, 'hh24'))*60+to_number(to_char(fh.HORA_FIN, 'mi')) >= " + minutos + " "
						+ " ORDER BY fh.HORA_INICIO ";
			} else {
				sql = "SELECT " + " HOUR(fh.HORA_INICIO)*60+MINUTE(fh.HORA_INICIO) AS INICIO_MINUTOS, " + " fh.NOMBRE, " + " fh.HORAS_VALORES " + " FROM "
						+ SystemProperties.SCHEMA_PRINCIPAL + "." + "FRANJA_HORARIA fh " + " WHERE "
						+ "          HOUR(fh.HORA_INICIO)*60+MINUTE(fh.HORA_INICIO) <= " + minutos + " " + "  AND HOUR(fh.HORA_FIN)*60+MINUTE(fh.HORA_FIN) >= "
						+ minutos + " " + " ORDER BY fh.HORA_INICIO ";
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

	public BigDecimal getValorPorHoraOFraccion() {

		Statement st = null;

		BigDecimal valor = null;

		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='VALOR_HORA_FRACCION' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				valor = rs.getBigDecimal("VALOR").setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return valor;
	}

	public int getMinutosGracia() {

		Statement st = null;

		int minutosGracia = -1;
		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='CLFY_MG' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				minutosGracia = rs.getBigDecimal("VALOR").intValue();
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return minutosGracia;
	}

	public boolean seImprimeRecibo() {

		Statement st = null;

		boolean imprimeRecibo = false;
		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='IMPRIMIR_RECIBO' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				imprimeRecibo = rs.getInt("VALOR") == 1;// 1:si; 0:no
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return imprimeRecibo;
	}

	public boolean yaSalio(CadenaPair cp) {

		Statement st = null;

		// String barraId = cp.getBarraId();
		GregorianCalendar gc = cp.getCalendar();
		int count = 0;
		try {
			Timestamp tstamp = new Timestamp(gc.getTimeInMillis());
			String sql = "SELECT COUNT(SALIDA) AS CUANTOS_HAY " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".ACTIVIDAD " + " WHERE " + " ENTRADA={ ts '"
					+ tstamp.toString() + "'} ";
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
			sql.append("INSERT INTO " + SystemProperties.SCHEMA_PRINCIPAL + ".ACTIVIDAD ");
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

			ps.setString(6, registroActividad.getTipoCliente().trim());
			paramMetaClause.append("[6-> " + registroActividad.getTipoCliente() + "]");

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

	public boolean actualizarValor(String codigo, double valor) {

		PreparedStatement ps = null;

		boolean seRegistro = false;
		try {
			String sql = "UPDATE " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " SET VALOR=? " + " WHERE CODIGO=? ";
			ps = ParqueSamanesConn.getConnection().prepareStatement(sql);

			StringBuffer paramMetaClause = new StringBuffer();
			paramMetaClause.append(" PARAMS{");

			ps.setBigDecimal(1, BigDecimal.valueOf(valor).setScale(2, BigDecimal.ROUND_HALF_UP));
			paramMetaClause.append("[1-> " + BigDecimal.valueOf(valor).setScale(2, BigDecimal.ROUND_HALF_UP) + "]");

			ps.setString(2, codigo);
			paramMetaClause.append("[2-> " + codigo + "]");

			paramMetaClause.append("} ");
			SystemLogManager.debug(sql.toString() + paramMetaClause);

			int actualizados = ps.executeUpdate();

			/*
			 * //historico sql = "INSERT INTO "
			 * +SystemProperties.SCHEMA_PRINCIPAL+
			 * ".PARAMETRO_AUDIT (TIMESTAMP, CODIGO, VALOR, OBSERVACIONES) VALUES( "
			 * +" CURRENT TIMESTAMP,?,?,? )"; ps =
			 * ParqueSamanesConn.con.prepareStatement(sql);
			 * 
			 * String observaciones = ""; ps.setString(1, codigo);
			 * ps.setBigDecimal(2, BigDecimal.valueOf(valor).setScale(2,
			 * BigDecimal.ROUND_HALF_UP)); ps.setString(3, observaciones);
			 * 
			 * actualizados = actualizados + ps.executeUpdate();
			 * 
			 * ps.close();
			 */

			// seRegistro = actualizados >= 2;
			seRegistro = actualizados >= 1;

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, ps, null);

		return seRegistro;
	}

}
