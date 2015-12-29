package efren.util.entidades;

/**
 * This type was created in VisualAge.
 */
public class SecSistema extends EntityObjectSeguridades {
	private java.lang.String nombrePrincipal;
	private java.lang.String oid_str;
	private java.lang.String nombreSecundario;
	private int tipo;
	private int estado;
	private java.lang.String selector;
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:52:30 PM)
 * @return int
 */
public int getEstado() {
	return estado;
}
/**
 * Insert the method's description here.
 * Creation date: (07-Sep-2003 23:45:41 PM)
 * @return java.lang.String
 */
public java.lang.String getNombrePrincipal() {
	return nombrePrincipal;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:50:26 PM)
 * @return java.lang.String
 */
public java.lang.String getNombreSecundario() {
	return nombreSecundario;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-03-01 10:14:06 AM)
 * @return java.lang.String
 */
public java.lang.String getOid_str() {
	return oid_str;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 22:00:07 PM)
 * @return java.lang.String
 */
public java.lang.String getSelector() {
	return selector;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:52:18 PM)
 * @return int
 */
public int getTipo() {
	return tipo;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:52:30 PM)
 * @param newEstado int
 */
public void setEstado(int newEstado) {
	estado = newEstado;
}
/**
 * Insert the method's description here.
 * Creation date: (07-Sep-2003 23:45:41 PM)
 * @param newNombre java.lang.String
 */
public void setNombrePrincipal(java.lang.String newNombrePrincipal) {
	nombrePrincipal = newNombrePrincipal;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:50:26 PM)
 * @param newNombreSecundario java.lang.String
 */
public void setNombreSecundario(java.lang.String newNombreSecundario) {
	nombreSecundario = newNombreSecundario;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-03-01 10:14:06 AM)
 * @param newOid_str java.lang.String
 */
public void setOid_str(java.lang.String newOid_str) {
	oid_str = newOid_str;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 22:00:07 PM)
 * @param newSelector java.lang.String
 */
public void setSelector(java.lang.String newSelector) {
	selector = newSelector;
}
/**
 * Insert the method's description here.
 * Creation date: (2005-05-21 21:52:18 PM)
 * @param newTipo int
 */
public void setTipo(int newTipo) {
	tipo = newTipo;
}
}
