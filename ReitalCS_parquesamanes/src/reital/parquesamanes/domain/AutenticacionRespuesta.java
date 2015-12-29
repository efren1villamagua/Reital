package reital.parquesamanes.domain;

public class AutenticacionRespuesta {

	public static enum ResultadoLogon {
		USUARIO_O_CLAVE_INCORRECTA, USUARIO_INACTIVO, AUTENTICACION_OK, ERROR_AL_AUTENTICAR;
	}

	private ResultadoLogon resultadoLogon;

	private String nombreUsuario;

	private boolean admin;

	public AutenticacionRespuesta() {
		super();
	}

	public AutenticacionRespuesta(ResultadoLogon resultadoLogon, String nombreUsuario, boolean admin) {
		super();
		this.resultadoLogon = resultadoLogon;
		this.nombreUsuario = nombreUsuario;
		this.admin = admin;
	}

	/**
	 * @return the resultadoLogon
	 */
	public ResultadoLogon getResultadoLogon() {
		return resultadoLogon;
	}

	/**
	 * @param resultadoLogon
	 *            the resultadoLogon to set
	 */
	public void setResultadoLogon(ResultadoLogon resultadoLogon) {
		this.resultadoLogon = resultadoLogon;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *            the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
