package reital.parquesamanes.app.controllers;

import java.math.BigDecimal;

import reital.parquesamanes.app.ioc.DIConfiguration;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;
import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.domain.repos.FranjaHorariaRepository;
import reital.parquesamanes.domain.repos.ParametroRepository;

//@Component
public class PagoController {

	public PagoController() {
		super();
		setParametroRepository(new DIConfiguration().getParametroRepository());
		setFranjaHorariaRepository(new DIConfiguration().getFranjaHorariaRepository());
		setActividadRepository(new DIConfiguration().getActividadRepository());
	}

	private ParametroRepository parametroRepository = null;

	private FranjaHorariaRepository franjaHorariaRepository = null;

	private ActividadRepository actividadRepository = null;

	public Valores getValores() {
		Valores valores = new Valores();
		// valores.valorHoraOFraccion = getValorPorHoraOFraccion();
		valores.minutosGracia = getCantidadMinutosGracia();
		// valores.imprimeRecibo = seImprimeRecibo();
		return valores;
	}

	public FranjaHoraria getFranjaHorariaFor(int minutos) {

		return getFranjaHorariaRepository().getFranjaHorariaFor(minutos);
	}

	public BigDecimal getValorPorHoraOFraccion() {

		return getParametroRepository().getValorPorHoraOFraccion();
	}

	public int getCantidadMinutosGracia() {

		return getParametroRepository().getCantidadMinutosGracia();
	}

	public boolean seImprimeRecibo() {

		return getParametroRepository().seImprimeRecibo();
	}

	public boolean yaSalio(String codigo) {

		return getActividadRepository().yaSalio(codigo);
	}

	public boolean registrarActividad(ActividadForPagoEntity registroActividad) {

		return getActividadRepository().registrarActividad(registroActividad);
	}

	public boolean actualizarParametro_MinutosGracia(int valor) {
		return getParametroRepository().actualizarCantidadMinutosGracia(valor);
	}

	public class Valores {
		// public BigDecimal valorHoraOFraccion = null;
		public int minutosGracia = 0;
		// public boolean imprimeRecibo = false;
	}

	/**
	 * @return the parametroRepository
	 */
	public ParametroRepository getParametroRepository() {
		return parametroRepository;
	}

	/**
	 * @param parametroRepository
	 *            the parametroRepository to set
	 */
	// @Autowired
	public void setParametroRepository(ParametroRepository parametroRepository) {
		this.parametroRepository = parametroRepository;
	}

	/**
	 * @return the franjaHorariaRepository
	 */
	public FranjaHorariaRepository getFranjaHorariaRepository() {
		return franjaHorariaRepository;
	}

	/**
	 * @param franjaHorariaRepository
	 *            the franjaHorariaRepository to set
	 */
	// @Autowired
	public void setFranjaHorariaRepository(FranjaHorariaRepository franjaHorariaRepository) {
		this.franjaHorariaRepository = franjaHorariaRepository;
	}

	/**
	 * @return the actividadRepository
	 */
	public ActividadRepository getActividadRepository() {
		return actividadRepository;
	}

	/**
	 * @param actividadRepository
	 *            the actividadRepository to set
	 */
	// @Autowired
	public void setActividadRepository(ActividadRepository actividadRepository) {
		this.actividadRepository = actividadRepository;
	}

}
