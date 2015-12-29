package reital.parquesamanes.domain.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import efren.util.entidades.EntityObjectUtil;

public class ActividadEntity extends EntityObjectUtil {
	private Date entradaFecha;

	/**
	 * @return the entradaFecha
	 */
	public Date getEntradaFecha() {
		return entradaFecha;
	}

	/**
	 * @param entradaFecha
	 *            the entradaFecha to set
	 */
	public void setEntradaFecha(Date entradaFecha) {
		this.entradaFecha = entradaFecha;
	}

	/**
	 * @return the entradaHora
	 */
	public Time getEntradaHora() {
		return entradaHora;
	}

	/**
	 * @param entradaHora
	 *            the entradaHora to set
	 */
	public void setEntradaHora(Time entradaHora) {
		this.entradaHora = entradaHora;
	}

	/**
	 * @return the salidaFecha
	 */
	public Date getSalidaFecha() {
		return salidaFecha;
	}

	/**
	 * @param salidaFecha
	 *            the salidaFecha to set
	 */
	public void setSalidaFecha(Date salidaFecha) {
		this.salidaFecha = salidaFecha;
	}

	/**
	 * @return the salidaHora
	 */
	public Time getSalidaHora() {
		return salidaHora;
	}

	/**
	 * @param salidaHora
	 *            the salidaHora to set
	 */
	public void setSalidaHora(Time salidaHora) {
		this.salidaHora = salidaHora;
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

	private String barraId;
	private Time entradaHora;

	private Date salidaFecha;

	private Time salidaHora;

	private BigDecimal valor;

	private BigDecimal valorHoraOFraccion;

	private String observaciones;

	/**
	 * @return the barraId
	 */
	public String getBarraId() {
		return barraId;
	}

	/**
	 * @param barraId the barraId to set
	 */
	public void setBarraId(String barraId) {
		this.barraId = barraId;
	}
}
