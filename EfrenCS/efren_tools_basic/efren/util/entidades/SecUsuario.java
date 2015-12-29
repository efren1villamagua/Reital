package efren.util.entidades;

/**
 * This type was created in VisualAge.
 */
public class SecUsuario extends EntityObjectSeguridades {
	/**
	 *
	 */
	private static final long serialVersionUID = 8266620550957055896L;

	private String nombre;
	private long perfilOid;
	private long dependenciaOid;
	private String dependenciaNombre;
	private java.lang.String nombrePerfil;
	private java.lang.String descripcionPerfil;
	private java.lang.String userName;
	private int estado;
	private java.lang.Boolean estado1;
	private java.lang.String clave;
	private java.lang.String codigoAlterno;
	private int tipo;
	private String tipoStr;
	/**
	 * SecUsuario constructor comment.
	 */
	public SecUsuario() {
		super();
	}

	/**
	 * Insert the method's description here. Creation date: (15/12/2003
	 * 23:59:48)
	 *
	 * @return java.lang.String
	 */
	public java.lang.String getClave() {
		return clave;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-12 9:36:50)
	 *
	 * @return int
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-12 9:38:22)
	 *
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getEstado1() {
		return estado1;
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return java.lang.String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-05
	 * 16:22:56)
	 *
	 * @return java.lang.String
	 */
	public java.lang.String getNombrePerfil() {
		return nombrePerfil;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-05
	 * 16:24:58)
	 *
	 * @return java.lang.String
	 */
	public java.lang.String getUserName() {
		return userName;
	}

	/**
	 * Insert the method's description here. Creation date: (15/12/2003
	 * 23:59:48)
	 *
	 * @param newClave
	 *            java.lang.String
	 */
	public void setClave(java.lang.String newClave) {
		clave = newClave;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-12 9:36:50)
	 *
	 * @param newEstado
	 *            int
	 */
	public void setEstado(int newEstado) {
		estado = newEstado;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-12 9:38:22)
	 *
	 * @param newEstado1
	 *            java.lang.Boolean
	 */
	public void setEstado1(java.lang.Boolean newEstado1) {
		estado1 = newEstado1;
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @param newValue
	 *            java.lang.String
	 */
	public void setNombre(String newValue) {
		this.nombre = newValue;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-05
	 * 16:22:56)
	 *
	 * @param newNombrePerfil
	 *            java.lang.String
	 */
	public void setNombrePerfil(java.lang.String newNombrePerfil) {
		nombrePerfil = newNombrePerfil;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-08-05
	 * 16:24:58)
	 *
	 * @param newUserName
	 *            java.lang.String
	 */
	public void setUserName(java.lang.String newUserName) {
		userName = newUserName;
	}

	public java.lang.String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(java.lang.String newDescripcionPerfil) {
		descripcionPerfil = newDescripcionPerfil;
	}

	public long getPerfilOid() {
		return perfilOid;
	}

	public void setPerfilOid(long perfilOid) {
		this.perfilOid = perfilOid;
	}

	public long getDependenciaOid() {
		return dependenciaOid;
	}

	public void setDependenciaOid(long dependenciaOid) {
		this.dependenciaOid = dependenciaOid;
	}

	public String getDependenciaNombre() {
		return dependenciaNombre;
	}

	public void setDependenciaNombre(String dependenciaNombre) {
		this.dependenciaNombre = dependenciaNombre;
	}

	public java.lang.String getCodigoAlterno() {
		return codigoAlterno;
	}

	public void setCodigoAlterno(java.lang.String codigoAlterno) {
		this.codigoAlterno = codigoAlterno;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTipoStr() {
		return tipoStr;
	}

	public void setTipoStr(String tipoStr) {
		this.tipoStr = tipoStr;
	}

}
