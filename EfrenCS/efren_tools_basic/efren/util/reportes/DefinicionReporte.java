package efren.util.reportes;

import efren.util.entidades.EntityObject;

public class DefinicionReporte extends EntityObject {
	/**
	 *
	 */
	private static final long serialVersionUID = 2521796514963135973L;

	private String nombre;

	private String sentenciaSql;

	private String titulo1;

	private String titulo2;

	private String plantilla;

	private String tableStyle;

	private String etiquetaSubtotalesQuiebre;

	private String etiquetaTotalGeneral;

	private boolean repetirDatosQuiebre;

	private String detalle;

	private int altoLinea;

	private String font;

	private boolean llevaAnexo;

	private int tipoAnexo;

	private String etiquetaAnexo;

	private String valorAnexo;

	private String sqlAnexo;

	private int tipoImpresion;

	private String archivoImpresion;

	private String tipo;

	/**
	 * SecView constructor comment.
	 */
	public DefinicionReporte() {
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

	public String getSentenciaSql() {
		return sentenciaSql;
	}

	public void setSentenciaSql(String sentenciaSql) {
		this.sentenciaSql = sentenciaSql;
	}

	public String getTitulo1() {
		return titulo1;
	}

	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}

	public String getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public String getTableStyle() {
		return tableStyle;
	}

	public void setTableStyle(String tableStyle) {
		this.tableStyle = tableStyle;
	}

	public String getEtiquetaSubtotalesQuiebre() {
		return etiquetaSubtotalesQuiebre;
	}

	public void setEtiquetaSubtotalesQuiebre(String etiquetaSubtotalesQuiebre) {
		this.etiquetaSubtotalesQuiebre = etiquetaSubtotalesQuiebre;
	}

	public String getEtiquetaTotalGeneral() {
		return etiquetaTotalGeneral;
	}

	public void setEtiquetaTotalGeneral(String etiquetaTotalGeneral) {
		this.etiquetaTotalGeneral = etiquetaTotalGeneral;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getAltoLinea() {
		return altoLinea;
	}

	public void setAltoLinea(int altoLinea) {
		this.altoLinea = altoLinea;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public int getTipoAnexo() {
		return tipoAnexo;
	}

	public void setTipoAnexo(int tipoAnexo) {
		this.tipoAnexo = tipoAnexo;
	}

	public String getEtiquetaAnexo() {
		return etiquetaAnexo;
	}

	public void setEtiquetaAnexo(String etiquetaAnexo) {
		this.etiquetaAnexo = etiquetaAnexo;
	}

	public String getValorAnexo() {
		return valorAnexo;
	}

	public void setValorAnexo(String valorAnexo) {
		this.valorAnexo = valorAnexo;
	}

	public String getSqlAnexo() {
		return sqlAnexo;
	}

	public void setSqlAnexo(String sqlAnexo) {
		this.sqlAnexo = sqlAnexo;
	}

	public int getTipoImpresion() {
		return tipoImpresion;
	}

	public void setTipoImpresion(int tipoImpresion) {
		this.tipoImpresion = tipoImpresion;
	}

	public String getArchivoImpresion() {
		return archivoImpresion;
	}

	public void setArchivoImpresion(String archivoImpresion) {
		this.archivoImpresion = archivoImpresion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isRepetirDatosQuiebre() {
		return repetirDatosQuiebre;
	}

	public void setRepetirDatosQuiebre(boolean repetirDatosQuiebre) {
		this.repetirDatosQuiebre = repetirDatosQuiebre;
	}

	public boolean isLlevaAnexo() {
		return llevaAnexo;
	}

	public void setLlevaAnexo(boolean llevaAnexo) {
		this.llevaAnexo = llevaAnexo;
	}
}
