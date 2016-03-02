package reital.parquesamanes.domain.entidades;

import efren.util.entidades.EntityObjectUtil;

/**
 * This type was created in VisualAge.
 */
public class FranjaHoraria extends EntityObjectUtil {

	private String codigo;

	private String nombre;

	private String horaInicio;

	private String horaFin;

	private String observaciones;

	private String horasValores;

	private transient int inicioMinutos;

	public FranjaHoraria() {
		super();
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio
	 *            the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public String getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin
	 *            the horaFin to set
	 */
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the horasValores
	 */
	public String getHorasValores() {
		return horasValores;
	}

	/**
	 * @param horasValores
	 *            the horasValores to set
	 */
	public void setHorasValores(String horasValores) {
		this.horasValores = horasValores;
	}

	/**
	 * @return the inicioMinutos
	 */
	public int getInicioMinutos() {
		return inicioMinutos;
	}

	/**
	 * @param inicioMinutos
	 *            the inicioMinutos to set
	 */
	public void setInicioMinutos(int inicioMinutos) {
		this.inicioMinutos = inicioMinutos;
	}

}
