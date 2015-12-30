package reital.parquesamanes.domain.entidades;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import reital.parquesamanes._view.working.PagoHelper;

public class ActividadForPagoEntity {
	/**
	 *
	 */
	public static final int NO_SALE_TODAVIA = 0;

	public static final int PENDIENTE_DE_SALIDA = 1;

	public static final int YA_SALIO = 2;

	/**
	 *
	 */
	private int estado = NO_SALE_TODAVIA;

	private String barraId = null;

	private String codigo = null;

	private GregorianCalendar entrada = null;

	private GregorianCalendar salida = null;

	private BigDecimal valor = null;

	private BigDecimal valorHoraOFraccion = null;

	private int cantidadHoras = 0;

	private PagoHelper.TIPO_CLIENTE tipoCliente = null;

	private String observaciones = null;

	private String franjaHoraria = null;

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return the barraId
	 */
	public String getBarraId() {
		return barraId;
	}

	/**
	 * @param barraId
	 *            the barraId to set
	 */
	public void setBarraId(String barraId) {
		this.barraId = barraId;
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
	 * @return the entrada
	 */
	public GregorianCalendar getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada
	 *            the entrada to set
	 */
	public void setEntrada(GregorianCalendar entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public GregorianCalendar getSalida() {
		return salida;
	}

	/**
	 * @param salida
	 *            the salida to set
	 */
	public void setSalida(GregorianCalendar salida) {
		this.salida = salida;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the valorHoraOFraccion
	 */
	public BigDecimal getValorHoraOFraccion() {
		return valorHoraOFraccion;
	}

	/**
	 * @param valorHoraOFraccion
	 *            the valorHoraOFraccion to set
	 */
	public void setValorHoraOFraccion(BigDecimal valorHoraOFraccion) {
		this.valorHoraOFraccion = valorHoraOFraccion;
	}

	/**
	 * @return the cantidadHoras
	 */
	public int getCantidadHoras() {
		return cantidadHoras;
	}

	/**
	 * @param cantidadHoras
	 *            the cantidadHoras to set
	 */
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
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
	 * @return the franjaHoraria
	 */
	public String getFranjaHoraria() {
		return franjaHoraria;
	}

	/**
	 * @param franjaHoraria
	 *            the franjaHoraria to set
	 */
	public void setFranjaHoraria(String franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}

	/**
	 * @param tipoCliente
	 *            the tipoCliente to set
	 */
	public void setTipoCliente(PagoHelper.TIPO_CLIENTE tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * @return the tipoCliente
	 */
	public PagoHelper.TIPO_CLIENTE getTipoCliente() {
		return tipoCliente;
	}

}
