package efren.util;

/**
 * This type was created in VisualAge.
 */
public class ArgumentoSP {
	private Object valor;
	private String tipoValor;
	private String tipoAcceso;
/**
 * ArgumentoSP constructor comment.
 */
public ArgumentoSP() {
	super();
}
/**
 * This method was created in VisualAge.
 * @param unValor java.lang.Object
 * @param unTipoValor java.lang.String
 * @param unTipoAcceso java.lang.String
 */
public ArgumentoSP(java.lang.Object unValor,java.lang.String  unTipoValor,java.lang.String  unTipoAcceso) {
	this.setValor(unValor);
	this.setTipoValor(unTipoValor);
	this.setTipoAcceso(unTipoAcceso);
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.Object
 */
public boolean esIn() {
	if (getTipoAcceso().compareTo("IN") == 0) {
		return true;
	} else {
		if (getTipoAcceso().compareTo("INOUT") == 0) {
			return true;
		} else {
			return false;
		}
	}
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.Object
 */
public boolean esOut() {
	if (getTipoAcceso().compareTo("IN") == 0) {
		return false;
	} else {
		return true;
	}
}
/**
 * This method was created in VisualAge.
 * @return java.lang.String
 */
public String getTipoAcceso() {
	return tipoAcceso;
}
/**
 * This method was created in VisualAge.
 * @return java.lang.String
 */
public String getTipoValor() {
	return tipoValor;
}
/**
 * This method was created in VisualAge.
 * @return java.lang.Object
 */
public Object getValor() {
	return valor;
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.String
 */
public void setTipoAcceso(String newValue) {
	this.tipoAcceso = newValue.trim().toUpperCase();
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.String
 */
public void setTipoValor(String newValue) {
	this.tipoValor = newValue.trim().toUpperCase();
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.Object
 */
public void setValor(Object newValue) {
	this.valor = newValue;
}
}
