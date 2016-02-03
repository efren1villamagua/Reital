package reital.parquesamanes.domain.entidades;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import reital.parquesamanes._view.working.PagoHelper;

public class ActividadForPagoEntity {

	private EstadoSalida estadoSalida;
	private EstadoPago estadoPago;
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
	private boolean imprimirRecibo = false;
	private boolean debePagar = false;
	private boolean enTiempoGracia = false;

	public ActividadForPagoEntity() {
		super();
		initialize();
	}

	private void initialize() {
		setEstadoSalida(EstadoSalida.NO_SALE_TODAVIA);
		setEstadoPago(EstadoPago.PENDIENTE);
	}

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
		if (this.tipoCliente != null) {
			switch (this.tipoCliente) {
			case CLIENTE:
			case NO_CLIENTE:
				setImprimirRecibo(true);
				setDebePagar(true);
				break;
			case PASE_LIBRE:
				setImprimirRecibo(false);
				setDebePagar(false);
				break;
			default:
				setImprimirRecibo(false);
				setDebePagar(false);
				break;
			}
		}
	}

	/**
	 * @return the tipoCliente
	 */
	public PagoHelper.TIPO_CLIENTE getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * @return the imprimirRecibo
	 */
	public boolean isImprimirRecibo() {
		return imprimirRecibo;
	}

	/**
	 * @param imprimirRecibo
	 *            the imprimirRecibo to set
	 */
	private void setImprimirRecibo(boolean imprimirRecibo) {
		this.imprimirRecibo = imprimirRecibo;
	}

	/**
	 * @return the estadoSalida
	 */
	public EstadoSalida getEstadoSalida() {
		return estadoSalida;
	}

	/**
	 * @param estadoSalida
	 *            the estadoSalida to set
	 */
	public void setEstadoSalida(EstadoSalida estadoSalida) {
		this.estadoSalida = estadoSalida;
	}

	/**
	 * @return the debePagar
	 */
	public boolean isDebePagar() {
		return debePagar;
	}

	/**
	 * @param debePagar
	 *            the debePagar to set
	 */
	private void setDebePagar(boolean debePagar) {
		this.debePagar = debePagar;
	}

	public static enum EstadoSalida {

		NO_SALE_TODAVIA(0), PENDIENTE_DE_SALIDA(1), YA_SALIO(2);

		EstadoSalida(int unValor) {
			setValor(unValor);
		}

		private int valor;

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

	}

	public static enum EstadoPago {

		PENDIENTE("P"), PAGADO("G"), PASE_LIBRE("L");

		EstadoPago(String unValor) {
			setValor(unValor);
		}

		private String valor;

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

	}

	/**
	 * @return the enTiempoGracia
	 */
	public boolean isEnTiempoGracia() {
		return enTiempoGracia;
	}

	/**
	 * @param enTiempoGracia
	 *            the enTiempoGracia to set
	 */
	public void setEnTiempoGracia(boolean enTiempoGracia) {
		this.enTiempoGracia = enTiempoGracia;
	}

	/**
	 * @return the estadoPago
	 */
	public EstadoPago getEstadoPago() {
		return estadoPago;
	}

	/**
	 * @param estadoPago
	 *            the estadoPago to set
	 */
	public void setEstadoPago(EstadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}
}
