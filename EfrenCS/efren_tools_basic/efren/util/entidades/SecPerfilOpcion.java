package efren.util.entidades;

import java.io.Serializable;

/**
 * Insert the type's description here.
 * Creation date: (26-June-2003 11:11:23 AM)
 * @author: Efrén Villamagua
 */
public class SecPerfilOpcion extends EntityObjectSeguridades implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8087936557830694023L;
	private long sistemaOid;
	private long claseOid;
	private long opcionPadreOid;
	private java.lang.String nombre;
	private int posicion;
	private java.lang.String posicionAbsoluta;
	private boolean esMenu;
	private java.lang.String nombreClase;
	private java.lang.String nombre2;
	private boolean tieneHijos;
	private boolean esSeparador;
    
	private long perfilOid;
	private java.lang.Boolean OP_todo;	
	private java.lang.Boolean OP_ingresoMasivo;
	private java.lang.Boolean OP_ingresoContinuo;
	private java.lang.Boolean OP_ingreso;
	private java.lang.Boolean OP_modificacion;
	private java.lang.Boolean OP_eliminacion;
	private java.lang.Boolean OP_consulta;	
	private long opcionOid;
	
	private int tipo;
/**
 * SecPerfilOpcion constructor comment.
 */
public SecPerfilOpcion() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 11:15:11 AM)
 * @return long
 */
public long getOpcionOid() {
	return opcionOid;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 11:12:20 AM)
 * @return long
 */
public long getPerfilOid() {
	return perfilOid;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 11:15:11 AM)
 * @param newOpcionOid long
 */
public void setOpcionOid(long newOpcionOid) {
	opcionOid = newOpcionOid;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 11:12:20 AM)
 * @param newPerfilOid long
 */
public void setPerfilOid(long newPerfilOid) {
	perfilOid = newPerfilOid;
}


/**
 * Insert the method's description here.
 * Creation date: (2002-08-06 12:14:02)
 * @return boolean
 */
public boolean esMenu() {
	return esMenu;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:28)
 * @return long
 */
public long getClaseOid() {
	return claseOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:45:06)
 * @return java.lang.String
 */
public java.lang.String getNombre() {
	return nombre;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-08 12:03:24)
 * @return java.lang.String
 */
public java.lang.String getNombre2() {
	return nombre2;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-07 10:12:45)
 * @return java.lang.String
 */
public java.lang.String getNombreClase() {
	return nombreClase;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:53:06 AM)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_consulta() {
	return OP_consulta;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:47 AM)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_eliminacion() {
	return OP_eliminacion;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:12 AM)
 * @return int
 */
public java.lang.Boolean getOP_ingreso() {
	return OP_ingreso;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:51:58 AM)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_ingresoContinuo() {
	return OP_ingresoContinuo;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:51:35 AM)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_ingresoMasivo() {
	return OP_ingresoMasivo;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:28 AM)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_modificacion() {
	return OP_modificacion;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-08 15:38:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOP_todo() {
	return this.OP_todo;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:52)
 * @return long
 */
public long getOpcionPadreOid() {
	return opcionPadreOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:45:24)
 * @return int
 */
public int getPosicion() {
	return posicion;
}


public int getTipo() {
	return tipo;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-06 10:38:07)
 * @return java.lang.String
 */
public java.lang.String getPosicionAbsoluta() {
	return posicionAbsoluta;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:14)
 * @return long
 */
public long getSistemaOid() {
	return sistemaOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:28)
 * @param newClaseOid long
 */
public void setClaseOid(long newClaseOid) {
	claseOid = newClaseOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-06 12:14:02)
 * @param newEsMenu boolean
 */
public void setEsMenu(boolean newEsMenu) {
	esMenu = newEsMenu;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:45:06)
 * @param newNombre java.lang.String
 */
public void setNombre(java.lang.String newNombre) {
	nombre = newNombre;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-08 12:03:24)
 * @param newNombre2 java.lang.String
 */
public void setNombre2(java.lang.String newNombre2) {
	nombre2 = newNombre2;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-07 10:12:45)
 * @param newNombreCompleto java.lang.String
 */
public void setNombreClase(java.lang.String newNombreClase) {
	nombreClase = newNombreClase;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:53:06 AM)
 * @param newOP_consulta java.lang.Boolean
 */
public void setOP_consulta(java.lang.Boolean newOP_consulta) {
	OP_consulta = newOP_consulta;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:47 AM)
 * @param newOP_eliminacion java.lang.Boolean
 */
public void setOP_eliminacion(java.lang.Boolean newOP_eliminacion) {
	OP_eliminacion = newOP_eliminacion;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:12 AM)
 * @param newOP_ingreso int
 */
public void setOP_ingreso(java.lang.Boolean newOP_ingreso) {
	OP_ingreso = newOP_ingreso;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:51:58 AM)
 * @param newOP_ingresoContinuo java.lang.Boolean
 */
public void setOP_ingresoContinuo(java.lang.Boolean newOP_ingresoContinuo) {
	OP_ingresoContinuo = newOP_ingresoContinuo;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:51:35 AM)
 * @param newOP_ingresoMasivo java.lang.Boolean
 */
public void setOP_ingresoMasivo(java.lang.Boolean newOP_ingresoMasivo) {
	OP_ingresoMasivo = newOP_ingresoMasivo;
}
/**
 * Insert the method's description here.
 * Creation date: (26-June-2003 10:52:28 AM)
 * @param newOP_modificacion java.lang.Boolean
 */
public void setOP_modificacion(java.lang.Boolean newOP_modificacion) {
	OP_modificacion = newOP_modificacion;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-08 15:38:21)
 * @param newHabilitado java.lang.Boolean
 */
public void setOP_todo(java.lang.Boolean newOP_todo) {
	this.OP_todo = newOP_todo;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:52)
 * @param newOpcionPadreOid long
 */
public void setOpcionPadreOid(long newOpcionPadreOid) {
	opcionPadreOid = newOpcionPadreOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:45:24)
 * @param newPosicion int
 */
public void setPosicion(int newPosicion) {
	posicion = newPosicion;
}
public void setTipo(int newTipo) {
	tipo = newTipo;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-06 10:38:07)
 * @param newPosicionAbsoluta java.lang.String
 */
public void setPosicionAbsoluta(java.lang.String newPosicionAbsoluta) {
	posicionAbsoluta = newPosicionAbsoluta;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-05 17:44:14)
 * @param newSistemaOid long
 */
public void setSistemaOid(long newSistemaOid) {
	sistemaOid = newSistemaOid;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-12 10:43:10)
 * @param newTieneHijos boolean
 */
public void setTieneHijos(boolean newTieneHijos) {
	tieneHijos = newTieneHijos;
}
/**
 * Insert the method's description here.
 * Creation date: (2002-08-12 10:43:10)
 * @return boolean
 */
public boolean tieneHijos() {
	return tieneHijos;
}
//...
public void setEsSeparador(boolean newEsSeparador) {
	esSeparador = newEsSeparador;
}
public boolean esSeparador() {
	return esSeparador;
}

}
