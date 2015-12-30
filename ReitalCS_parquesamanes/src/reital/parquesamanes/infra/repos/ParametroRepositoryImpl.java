package reital.parquesamanes.infra.repos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import efren.util.SystemLogManager;
import reital.parquesamanes.domain.repos.ParametroRepository;
import reital.parquesamanes.infra.ParqueSamanesConn;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class ParametroRepositoryImpl implements ParametroRepository {

	public static String CANTIDAD_MINUTOS_GRACIA = "CANTIDAD_MINUTOS_GRACIA";

	public static String VALOR_HORA_FRACCION = "VALOR_HORA_FRACCION";

	public static String IMPRIMIR_RECIBO = "IMPRIMIR_RECIBO";

	public BigDecimal getValorPorHoraOFraccion() {

		Statement st = null;

		BigDecimal valor = null;

		try {
			String sql = "SELECT VALOR FROM PARAMETRO WHERE CODIGO='" + VALOR_HORA_FRACCION + "' ";
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

	public int getCantidadMinutosGracia() {

		Statement st = null;

		int minutosGracia = -1;
		try {
			String sql = "SELECT VALOR FROM PARAMETRO WHERE CODIGO='" + CANTIDAD_MINUTOS_GRACIA + "' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				minutosGracia = rs.getInt("VALOR");
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
			String sql = "SELECT VALOR FROM PARAMETRO WHERE CODIGO='" + IMPRIMIR_RECIBO + "' ";
			st = ParqueSamanesConn.getConnection().createStatement();

			SystemLogManager.debug(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				imprimeRecibo = rs.getString("VALOR").equalsIgnoreCase("S");
			}
			rs.close();

		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return imprimeRecibo;
	}

	public boolean actualizarCantidadMinutosGracia(int valor) {

		PreparedStatement ps = null;

		boolean seRegistro = false;
		try {
			String sql = "UPDATE PARAMETRO SET VALOR=? WHERE CODIGO=? ";
			ps = ParqueSamanesConn.getConnection().prepareStatement(sql);

			StringBuffer paramMetaClause = new StringBuffer();
			paramMetaClause.append(" PARAMS{");

			ps.setString(1, String.valueOf(valor));
			paramMetaClause.append("[1-> " + String.valueOf(valor) + "]");

			ps.setString(2, CANTIDAD_MINUTOS_GRACIA);
			paramMetaClause.append("[2-> " + CANTIDAD_MINUTOS_GRACIA + "]");

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
