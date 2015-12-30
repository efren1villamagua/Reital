package reital.parquesamanes.app.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reital.parquesamanes._view.working.PagoHelper.CadenaPair;
import reital.parquesamanes.domain.PagoRepository;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

@Component
public class PagoController {

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

	@Autowired
	public void setRepository(PagoRepository repository) {
		this.repository = repository;
	}

}
