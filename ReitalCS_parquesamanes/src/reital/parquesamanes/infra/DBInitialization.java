package reital.parquesamanes.infra;

import java.sql.Connection;
import java.sql.Statement;

import efren.util.SystemLogManager;
import reital.parquesamanes.infra.util.GarbageRecollector;

public class DBInitialization {

	public boolean createTables() {

		Statement st = null;

		boolean resultado = true;

		Connection con = ParqueSamanesConn.getConnection();

		try {
			st = con.createStatement();
		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		try {

			StringBuffer sql = new StringBuffer();

			sql.append("CREATE TABLE FRANJA_HORARIA (");
			sql.append(" CODIGO VARCHAR(10) PRIMARY KEY NOT NULL, ");
			sql.append(" NOMBRE VARCHAR(50) NOT NULL, ");
			sql.append(" HORA_INICIO TIMESTAMP NOT NULL, ");
			sql.append(" HORA_FIN TIMESTAMP NOT NULL, ");
			sql.append(" VALOR_POR_HORA DECIMAL(10, 2) NOT NULL,");
			sql.append(" OBSERVACIONES VARCHAR(100) NOT NULL, ");
			sql.append(" HORAS_VALORES VARCHAR(2000) NOT NULL");
			sql.append(")");

			SystemLogManager.debug(sql.toString());

			resultado = st.execute(sql.toString()) && resultado;

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		try {

			StringBuffer sql = new StringBuffer();

			sql.append("CREATE TABLE USUARIO (");
			sql.append(" USERNAME VARCHAR(100) PRIMARY KEY NOT NULL,");
			sql.append(" CLAVE VARCHAR(2000) NOT NULL,");
			sql.append(" NOMBRE VARCHAR(100) NOT NULL,");
			sql.append(" TIPO VARCHAR(20) NOT NULL,");
			sql.append(" ESTADO VARCHAR(20) NOT NULL");
			sql.append(")");

			SystemLogManager.debug(sql.toString());

			resultado = st.execute(sql.toString()) && resultado;

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		try {

			StringBuffer sql = new StringBuffer();

			sql.append("CREATE TABLE PARAMETRO (");
			sql.append(" CODIGO VARCHAR(100) PRIMARY KEY NOT NULL,");
			sql.append(" VALOR VARCHAR(200) NOT NULL");
			sql.append(")");

			SystemLogManager.debug(sql.toString());

			resultado = st.execute(sql.toString()) && resultado;

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		try {

			StringBuffer sql = new StringBuffer();

			sql.append("CREATE TABLE ACTIVIDAD (");
			sql.append(" CODIGO VARCHAR(100) PRIMARY KEY NOT NULL,");
			sql.append(" ENTRADA TIMESTAMP NOT NULL,");
			sql.append(" SALIDA TIMESTAMP NOT NULL,");
			sql.append(" VALOR DECIMAL(20, 2) NOT NULL,");
			sql.append(" VALOR_HORA_FRACCION DECIMAL(20, 2) NOT NULL,");
			sql.append(" TIPO_CLIENTE VARCHAR(20) NOT NULL,");
			sql.append(" OBSERVACIONES VARCHAR(1000) NOT NULL,");
			sql.append(" FRANJA_HORARIA VARCHAR(20) NOT NULL,");
			sql.append(" CANTIDAD_HORAS INT NOT NULL, ");
			sql.append(" ESTADO CHAR(1) NOT NULL");
			sql.append(")");

			SystemLogManager.debug(sql.toString());

			resultado = st.execute(sql.toString()) && resultado;

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		try {

			StringBuffer sql = new StringBuffer();

			sql.append("INSERT INTO PARAMETRO (CODIGO, VALOR) VALUES ('CANTIDAD_MINUTOS_GRACIA', '5')");

			SystemLogManager.debug(sql.toString());

			resultado = st.executeUpdate(sql.toString()) > 0 && resultado;

		} catch (Throwable t) {
			SystemLogManager.error(t);
		}

		GarbageRecollector.closeAndFinalize(null, st, null);

		return resultado;
	}

}
