package reital.parquesamanes.domain.repos;

import java.math.BigDecimal;

public interface ParametroRepository {

	BigDecimal getValorPorHoraOFraccion();

	int getCantidadMinutosGracia();

	boolean seImprimeRecibo();

	boolean actualizarCantidadMinutosGracia(int valor);
}
