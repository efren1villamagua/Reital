package efren.util;

import java.sql.ResultSet;
import java.sql.Statement;

import efren.util.config.SystemProperties;

public class OidManager {

	/**
	 *
	 * @param aTableId
	 * @return
	 * @throws Throwable
	 */
	private static long fetchOid(String aTableId) throws Throwable {

		long aLastOid = 0;

		String sql = "SELECT ULTIMOOID FROM "+SystemProperties.SCHEMA_UTIL+".OIDS "
			+" WHERE RTRIM(LTRIM(UCASE(NOMBRE)))='"+aTableId+"' ";
		java.sql.Statement st = efren.util.Conn.conectar().createStatement();
		java.sql.ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			aLastOid = rs.getLong(1);
		}
		rs.close();

		long aNewOid = aLastOid + 1;

		sql = "UPDATE "+SystemProperties.SCHEMA_UTIL+".OIDS "
			+" SET ULTIMOOID=ULTIMOOID+1 WHERE RTRIM(LTRIM(UCASE(NOMBRE)))='"+aTableId+"' ";
		st.executeUpdate(sql);

		st.close();
		efren.util.Conn.conectar().commit();

		return aNewOid;
	}
	/**
	 *
	 * @return
	 * @throws Throwable
	 */
	public static long newOid() throws Throwable {

	    return fetchOid(SystemProperties.SCHEMA_PRINCIPAL+"._GLOBAL");
	}
	/**
	 *
	 * @param aTableId
	 * @return
	 * @throws Throwable
	 */
	public static long newOid(String aTableId) throws Throwable {

	    return fetchOid(SystemProperties.SCHEMA_PRINCIPAL+"."+aTableId.trim());
	}
	/**
	 * Obtención del OID desde la tabla OIDS
	 */
	public static long getOid(String unTableID, Statement unSt) throws Throwable {

			long unUltimoOid = 0;

			String sqlTemp =
			      "SELECT ULTIMOOID "
			    +" FROM "+SystemProperties.SCHEMA_UTIL+".OIDS "
				+" WHERE RTRIM(LTRIM(UCASE(NOMBRE)))='"+unTableID+"' ";
			ResultSet rsTemp = unSt.executeQuery(sqlTemp);
			while(rsTemp.next()) {
			    unUltimoOid = rsTemp.getLong(1);
			}
			rsTemp.close();

			long unNuevoOid = unUltimoOid + 1;

			return unNuevoOid;
	}
	/**
	 * SE ACTUALIZA LA TABLA OIDS
	 */
	public static void setOid(String unTableID, long unUltimoOid, Statement unSt) throws Throwable {
	    String sqlTemp =
	          "UPDATE "+SystemProperties.SCHEMA_UTIL+".OIDS "
	        +" SET ULTIMOOID="+unUltimoOid
	        +" WHERE RTRIM(LTRIM(UCASE(NOMBRE)))='"+unTableID+"' ";
	    unSt.executeUpdate(sqlTemp);
	}
}