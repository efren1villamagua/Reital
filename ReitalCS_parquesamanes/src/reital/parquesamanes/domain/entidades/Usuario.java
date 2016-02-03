package reital.parquesamanes.domain.entidades;

import efren.util.entidades.EntityObjectUtil;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

/**
 * This type was created in VisualAge.
 */
public class Usuario extends EntityObjectUtil {

	private String userName;

	private String nombre;

	private String clave;

	private String estado;

	private String tipo;

	public Usuario() {
		super();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getActivo() {
		return getEstado() != null && getEstado().trim().equalsIgnoreCase(ParqueSamanesConstantes.Security.USUARIO_ESTADO_Activo);
	}

	public void setActivo(Boolean b) {

	}

	public Boolean getAdministrador() {
		return getTipo() != null && getTipo().trim().equalsIgnoreCase(ParqueSamanesConstantes.Security.USUARIO_TIPO_Administrador);
	}

	public void setAdministrador(Boolean b) {

	}

}
