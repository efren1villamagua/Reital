package efren.util.entidades;

public class SecDependencia extends EntityObjectSeguridades {
	/**
	 *
	 */
	private static final long serialVersionUID = 3363763893048661221L;

	private String codigo;
	private String nombre;
	private int tipo;
	private String tipoStr;

	/**
	 * SecView constructor comment.
	 */
	public SecDependencia() {
		super();
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
	 * This method was created in VisualAge.
	 *
	 * @param newValue
	 *            java.lang.String
	 */
	public void setNombre(String newValue) {
		this.nombre = newValue;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
