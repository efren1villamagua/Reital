package efren.util.entidades;

/**
 * Insert the type's description here.
 * Creation date: (2005-02-16 10:57:20 AM)
 * @author: Efrén Villamagua
 */
public class ReportesDefPerfil extends EntityObjectUtil {
	private java.lang.String nombreReporte;
	private java.lang.String nombrePerfil;
	private long reporteDefOid;
	private long perfilOid;
/**
 * ReportesDefPerfil constructor comment.
 */
public ReportesDefPerfil() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-16 10:58:21 AM)
 * @return java.lang.String
 */
public java.lang.String getNombrePerfil() {
	return nombrePerfil;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-16 10:58:06 AM)
 * @return java.lang.String
 */
public java.lang.String getNombreReporte() {
	return nombreReporte;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-17 11:20:23 AM)
 * @return long
 */
public long getPerfilOid() {
	return perfilOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-17 11:20:08 AM)
 * @return long
 */
public long getReporteDefOid() {
	return reporteDefOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-16 10:58:21 AM)
 * @param newNombrePerfil java.lang.String
 */
public void setNombrePerfil(java.lang.String newNombrePerfil) {
	nombrePerfil = newNombrePerfil;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-16 10:58:06 AM)
 * @param newNombreReporte java.lang.String
 */
public void setNombreReporte(java.lang.String newNombreReporte) {
	nombreReporte = newNombreReporte;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-17 11:20:23 AM)
 * @param newPerfilOid long
 */
public void setPerfilOid(long newPerfilOid) {
	perfilOid = newPerfilOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-02-17 11:20:08 AM)
 * @param newReporteDefOid long
 */
public void setReporteDefOid(long newReporteDefOid) {
	reporteDefOid = newReporteDefOid;
}
}
