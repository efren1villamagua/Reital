package efren.util.entidades;

public class FileDefinition extends EntityObjectUtil {

	private java.lang.String sentenciaSQL;
	private java.lang.String nombre;
/**
 * Cargo constructor comment.
 */
public FileDefinition() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (2003-nov-13 8:55:41)
 * @return java.lang.String
 */
public java.lang.String getNombre() {
	return nombre;
}
/**
 * Insert the method's description here.
 * Creation date: (27/09/2003 6:33:17)
 * @return java.lang.String
 */
public java.lang.String getSentenciaSQL() {
	return sentenciaSQL;
}
/**
 * Insert the method's description here.
 * Creation date: (2003-nov-13 8:55:41)
 * @param newNombre java.lang.String
 */
public void setNombre(java.lang.String newNombre) {
	nombre = newNombre;
}
/**
 * Insert the method's description here.
 * Creation date: (27/09/2003 6:33:17)
 * @param newSentenciaSQL java.lang.String
 */
public void setSentenciaSQL(java.lang.String newSentenciaSQL) {
	sentenciaSQL = newSentenciaSQL;
}
}
