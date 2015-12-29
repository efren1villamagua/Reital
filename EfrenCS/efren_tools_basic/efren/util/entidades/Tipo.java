package efren.util.entidades;

public class Tipo extends EntityObjectUtil {
    private String descripcion;
	private java.lang.String tabla;
	private java.lang.String campo;
	private java.lang.Integer tipo;
/**
 * Cargo constructor comment.
 */
public Tipo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:35:46)
 * @return java.lang.String
 */
public java.lang.String getCampo() {
	return campo;
}
/**
 * This method was created in VisualAge.
 * @return java.lang.String
 */
public String getDescripcion() {
	return this.descripcion;
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:35:31)
 * @return java.lang.String
 */
public java.lang.String getTabla() {
	return tabla;
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:37:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getTipo() {
	return tipo;
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:35:46)
 * @param newCampo java.lang.String
 */
public void setCampo(java.lang.String newCampo) {
	campo = newCampo;
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.String
 */
public void setDescripcion(String newValue) {
	this.descripcion = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:35:31)
 * @param newTabla java.lang.String
 */
public void setTabla(java.lang.String newTabla) {
	tabla = newTabla;
}
/**
 * Insert the method's description here.
 * Creation date: (28/08/2003 14:37:03)
 * @param newTipo java.lang.Integer
 */
public void setTipo(java.lang.Integer newTipo) {
	tipo = newTipo;
}
}
