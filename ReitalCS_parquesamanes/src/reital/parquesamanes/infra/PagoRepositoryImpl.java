package reital.parquesamanes.infra;

import java.awt.Window;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import efren.util.StringTools;
import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;
import reital.parquesamanes.domain.PagoRepository;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;
import reital.parquesamanes.lector.gui.seguridades.LogonView;
import reital.parquesamanes.lector.gui.working.PagoController.CadenaPair;
import reital.parquesamanes.lector.util.ParqueSamanesConstantes;

public class PagoRepositoryImpl implements PagoRepository {

	public FranjaHoraria getFranjaHorariaFor(int minutos) {

		Statement st = ParqueSamanesConn.getConnection().createStatement();

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
		ResultSet rs = st.executeQuery(sql);

		FranjaHoraria franja = null;

		while (rs.next()) {

			franja = new FranjaHoraria();

			franja.setNombre(rs.getString("NOMBRE").trim());
			franja.setHorasValores(rs.getString("HORAS_VALORES").trim());
			franja.setInicioMinutos(rs.getInt("INICIO_MINUTOS"));
			/**
			 * NOS QUEDAMOS CON LA PRIMERA FRANJA HORARIA (EN EL CASO DE CRUCES
			 * DE FRANJAS)
			 */
			break;
		}
		rs.close();
		st.close();

		return franja;
	}

	public BigDecimal getValorPorHoraOFraccion() {
		BigDecimal valor = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='VALOR_HORA_FRACCION' ";
			Statement st = ParqueSamanesConn.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				valor = rs.getBigDecimal("VALOR").setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			rs.close();
			st.close();
		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return valor;
	}

	public int getMinutosGracia() {
		int minutosGracia = 0;
		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='CLFY_MG' ";
			Statement st = ParqueSamanesConn.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				minutosGracia = rs.getBigDecimal("VALOR").intValue();
			}
			rs.close();
			st.close();
		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return minutosGracia;
	}

	public boolean seImprimeRecibo() {
		boolean imprimeRecibo = false;
		try {
			String sql = "SELECT VALOR " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " WHERE CODIGO='IMPRIMIR_RECIBO' ";
			Statement st = ParqueSamanesConn.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				imprimeRecibo = rs.getInt("VALOR") == 1;// 1:si; 0:no
			}
			rs.close();
			st.close();
		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return imprimeRecibo;
	}

	public boolean yaSalio(CadenaPair cp) {
		// String barraId = cp.getBarraId();
		GregorianCalendar gc = cp.getCalendar();
		int count = 0;
		try {
			Timestamp tstamp = new Timestamp(gc.getTimeInMillis());
			String sql = "SELECT COUNT(SALIDA) AS CUANTOS_HAY " + " FROM " + SystemProperties.SCHEMA_PRINCIPAL + ".ACTIVIDAD " + " WHERE " + " ENTRADA={ ts '"
					+ tstamp.toString() + "'} ";
			Statement st = ParqueSamanesConn.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("CUANTOS_HAY");
			}
			rs.close();
			st.close();
		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return count > 0;
	}

	public boolean registrarActividad(ActividadForPagoEntity registroActividad) {
		boolean seRegistro = false;
		try {
			String sql = "INSERT INTO " + SystemProperties.SCHEMA_PRINCIPAL + ".ACTIVIDAD "
					+ " (CODIGO, ENTRADA, SALIDA, VALOR, VALOR_HORA_FRACCION, TIPO_CLIENTE, OBSERVACIONES, FRANJA_HORARIA, CANTIDAD_HORAS ) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = ParqueSamanesConn.getConnection().prepareStatement(sql);

			ps.setString(1, registroActividad.getCodigo().trim());
			ps.setTimestamp(2, new Timestamp(registroActividad.getEntrada().getTimeInMillis()));
			ps.setTimestamp(3, new Timestamp(registroActividad.getSalida().getTimeInMillis()));
			ps.setBigDecimal(4, registroActividad.getValor());
			ps.setBigDecimal(5, registroActividad.getValorHoraOFraccion());
			ps.setString(6, registroActividad.getTipoCliente().trim());

			String observaciones = registroActividad.getObservaciones().trim();
			if (observaciones.length() == 0) {
				observaciones = "---";
			}
			observaciones = (LogonView.isAdmin() ? "A" : "U")
					+ StringTools.rellenar(LogonView.getUsername().trim(), " ", (19 - LogonView.getUsername().trim().length()), StringTools.DIRECCION_DERECHA)
					+ observaciones;
			ps.setString(7, observaciones);

			ps.setString(8, registroActividad.getFranjaHoraria().trim());
			ps.setInt(9, registroActividad.getCantidadHoras());

			int insertados = ps.executeUpdate();

			ps.close();

			seRegistro = insertados > 0;
			if (seRegistro) {
				registroActividad.setEstado(ActividadForPagoEntity.PENDIENTE_DE_SALIDA);
			}
		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return seRegistro;
	}

	public boolean actualizarValor(String codigo, double valor) {
		boolean seRegistro = false;
		try {
			String sql = "UPDATE " + SystemProperties.SCHEMA_PRINCIPAL + ".PARAMETRO " + " SET VALOR=? " + " WHERE CODIGO=? ";
			PreparedStatement ps = ParqueSamanesConn.getConnection().prepareStatement(sql);

			ps.setBigDecimal(1, BigDecimal.valueOf(valor).setScale(2, BigDecimal.ROUND_HALF_UP));
			ps.setString(2, codigo);

			int actualizados = ps.executeUpdate();

			ps.close();

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

		} catch (SQLException sqlexc) {
			InfoView.showErrorDialog(this.parentWindow, "ERROR DE BASE DE DATOS: " + sqlexc.getMessage());
		} catch (Exception exc) {
			exc.getMessage();
			InfoView.showErrorDialog(this.parentWindow, "ERROR: " + exc.getMessage());
		}
		return seRegistro;
	}

}
