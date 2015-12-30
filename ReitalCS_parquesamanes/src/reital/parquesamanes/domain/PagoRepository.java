package reital.parquesamanes.domain;

import java.math.BigDecimal;

import reital.parquesamanes.app.gui.working.PagoController.CadenaPair;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public interface PagoRepository {

	FranjaHoraria getFranjaHorariaFor(int minutos);

	BigDecimal getValorPorHoraOFraccion();

	int getMinutosGracia();

	boolean seImprimeRecibo();

	boolean yaSalio(CadenaPair cp);

	boolean registrarActividad(ActividadForPagoEntity registroActividad);

	boolean actualizarValor(String codigo, double valor);

}
