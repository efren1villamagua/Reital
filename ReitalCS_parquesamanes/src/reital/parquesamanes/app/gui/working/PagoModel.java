package reital.parquesamanes.app.gui.working;

import java.math.BigDecimal;

import reital.parquesamanes.app.gui.working.PagoController.CadenaPair;
import reital.parquesamanes.domain.PagoRepository;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public class PagoModel {

	private PagoRepository repository = null;

	public Valores getValores() {
		Valores valores = new Valores();
		// valores.valorHoraOFraccion = getValorPorHoraOFraccion();
		valores.minutosGracia = getMinutosGracia();
		// valores.imprimeRecibo = seImprimeRecibo();
		return valores;
	}

	public FranjaHoraria getFranjaHorariaFor(int minutos) {

		return getRepository().getFranjaHorariaFor(minutos);
	}

	public BigDecimal getValorPorHoraOFraccion() {

		return getRepository().getValorPorHoraOFraccion();
	}

	public int getMinutosGracia() {

		return getRepository().getMinutosGracia();
	}

	public boolean seImprimeRecibo() {

		return getRepository().seImprimeRecibo();
	}

	public boolean yaSalio(CadenaPair cp) {

		return getRepository().yaSalio(cp);
	}

	public boolean registrarActividad(ActividadForPagoEntity registroActividad) {

		return getRepository().registrarActividad(registroActividad);
	}

	public boolean actualizarValor(String codigo, double valor) {
		return getRepository().actualizarValor(codigo, valor);
	}

	public class Valores {
		// public BigDecimal valorHoraOFraccion = null;
		public int minutosGracia = 0;
		// public boolean imprimeRecibo = false;
	}

	public PagoRepository getRepository() {
		return repository;
	}

	public void setRepository(PagoRepository repository) {
		this.repository = repository;
	}

}
