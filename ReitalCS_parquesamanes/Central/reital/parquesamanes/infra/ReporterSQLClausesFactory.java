package reital.parquesamanes.infra;

import java.sql.Date;

import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class ReporterSQLClausesFactory {

	public String getSQLClause_OcupacionParqueadero_OnlyHeaders() {

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT ");
		sql.append(" TIPO_CLIENTE, FECHA, HORA_ENTRADA, HORA_SALIDA, ");
		sql.append(" VALOR, USUARIO, TIPO_USR, OBSERVACIONES ");
		sql.append(" FROM  ACTIVIDAD ");
		return sql.toString();
	}

	public String getSQLClause_OcupacionParqueadero(Date desde, Date hasta, boolean clientes, boolean noClientes,
			boolean funcionarios) {

		boolean oracle = ParqueSamanesConstantes.DataSource.TYPE.equalsIgnoreCase("oracle");

		StringBuffer sql = new StringBuffer();

		if (oracle) {
			sql.append("SELECT ");
			sql.append(" CASE WHEN a.TIPO_CLIENTE = 'A' THEN 'CLIENTE' WHEN a.TIPO_CLIENTE = 'B' THEN 'NO CLIENTE' ");
			sql.append(" WHEN a.TIPO_CLIENTE = 'C' THEN 'FUNCIONARIO' ELSE '' END AS TIPO_CLIENTE, ");
			sql.append(" to_char(ENTRADA, 'yyyy-mm-dd') AS FECHA, to_char(ENTRADA, 'hh24:mi') AS HORA_ENTRADA,  ");
			sql.append(" to_char(SALIDA, 'hh24:mi') AS HORA_SALIDA, ");
			sql.append(" VALOR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 2, 19)) AS USUARIO, ");
			sql.append(
					" CASE WHEN SUBSTR(OBSERVACIONES, 1, 1) = 'A' THEN 'Administrador' ELSE 'Usuario' END AS TIPO_USR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 20)) AS OBSERVACIONES ");
			sql.append(" FROM  ACTIVIDAD a ");
			sql.append(" WHERE to_char(ENTRADA, 'yyyy-mm-dd')>='" + desde + "' AND to_char(SALIDA, 'yyyy-mm-dd')<='"
					+ hasta + "' " + " AND (1=2 ");
			if (clientes) {
				sql.append(" OR a.TIPO_CLIENTE='A' ");
			}
			if (noClientes) {
				sql.append(" OR a.TIPO_CLIENTE='B' ");
			}
			if (funcionarios) {
				sql.append(" OR a.TIPO_CLIENTE='C' ");
			}
			sql.append(" ) ");
			sql.append(" ORDER BY TIPO_CLIENTE, FECHA, HORA_ENTRADA");
		} else {
			sql.append("SELECT ");
			sql.append(" CASE WHEN a.TIPO_CLIENTE = 'C' THEN 'CLIENTE' WHEN a.TIPO_CLIENTE = 'L' THEN 'PASE LIBRE' ");
			sql.append("  ELSE '' END AS TIPO_CLIENTE, ");
			sql.append(" FORMATDATETIME(ENTRADA, 'yyyy-MM-dd') AS FECHA, ");
			sql.append(" FORMATDATETIME(ENTRADA, 'HH:mm:ss') AS HORA_ENTRADA, ");
			sql.append(" FORMATDATETIME(SALIDA, 'HH:mm:ss') AS HORA_SALIDA, ");
			sql.append(" VALOR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 2, 19)) AS USUARIO, ");
			sql.append(
					" CASE WHEN SUBSTR(OBSERVACIONES, 1, 1) = 'A' THEN 'Administrador' ELSE 'Usuario' END AS TIPO_USR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 20)) AS OBSERVACIONES ");
			sql.append(" FROM  ACTIVIDAD a ");
			sql.append(" WHERE FORMATDATETIME(ENTRADA, 'yyyy-MM-dd')>={ d '" + desde + "'} ");
			sql.append(" AND FORMATDATETIME(SALIDA, 'yyyy-MM-dd')<={ d '" + hasta + "'} ");
			sql.append(" AND (1=2 ");
			// if (clientes) {
			// sql.append(" OR a.TIPO_CLIENTE='C' ");
			// }
			// if (noClientes) {
			// sql.append(" OR a.TIPO_CLIENTE='L' ");
			// }
			// if (funcionarios) {
			// sql.append(" OR a.TIPO_CLIENTE='C' ");
			// }
			sql.append(" OR a.TIPO_CLIENTE='C' ");
			sql.append(" OR a.TIPO_CLIENTE='L' ");
			sql.append(" ) ");
			sql.append(" ORDER BY TIPO_CLIENTE, FECHA, HORA_ENTRADA");
		}
		return sql.toString();
	}

	/**
	 *
	 */
	public String getSQLClause_Funcionarios_OnlyHeaders() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append(" FECHA, HORA_ENTRADA, HORA_SALIDA, ");
		sql.append(" USUARIO, TIPO_USR, OBSERVACIONES ");
		sql.append(" FROM  ACTIVIDAD ");
		return sql.toString();
	}

	/**
	 *
	 */
	public String getSQLClause_Funcionarios(Date desde, Date hasta) {

		boolean oracle = ParqueSamanesConstantes.DataSource.TYPE.equalsIgnoreCase("oracle");

		StringBuffer sql = new StringBuffer();

		if (oracle) {
			sql.append("SELECT ");
			sql.append(
					" to_char(ENTRADA, 'yyyy-mm-dd') AS FECHA, to_char(ENTRADA, 'hh24:mi') AS HORA_ENTRADA, to_char(SALIDA, 'hh24:mi') AS HORA_SALIDA, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 2, 19)) AS USUARIO, ");
			sql.append(
					" CASE WHEN SUBSTR(OBSERVACIONES, 1, 1) = 'A' THEN 'Administrador' ELSE 'Usuario' END AS TIPO_USR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 20)) AS OBSERVACIONES ");
			sql.append(" FROM  ACTIVIDAD a ");
			sql.append(" WHERE to_char(ENTRADA, 'yyyy-mm-dd')>='" + desde + "' AND to_char(SALIDA, 'yyyy-mm-dd')<='"
					+ hasta + "' " + " AND a.TIPO_CLIENTE='C' ");
			sql.append(" ORDER BY FECHA, HORA_ENTRADA");
		} else {
			sql.append("SELECT "
					+ " DATE(ENTRADA) AS FECHA, TIME(ENTRADA) AS HORA_ENTRADA, TIME(SALIDA) AS HORA_SALIDA, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 2, 19)) AS USUARIO, ");
			sql.append(
					" CASE WHEN SUBSTR(OBSERVACIONES, 1, 1) = 'A' THEN 'Administrador' ELSE 'Usuario' END AS TIPO_USR, ");
			sql.append(" RTRIM(SUBSTR(OBSERVACIONES, 20)) AS OBSERVACIONES ");
			sql.append(" FROM  ACTIVIDAD a ");
			sql.append(" WHERE DATE(ENTRADA)>={ d '" + desde + "'} AND DATE(SALIDA)<={ d '" + hasta + "'} "
					+ " AND a.TIPO_CLIENTE='C' ");
			sql.append(" ORDER BY FECHA, HORA_ENTRADA");
		}
		return sql.toString();
	}

}
