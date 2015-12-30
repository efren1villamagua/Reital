package reital.parquesamanes.domain.repos;

import reital.parquesamanes._view.working.PagoHelper.CadenaPair;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;

public interface ActividadRepository {

	boolean yaSalio(CadenaPair cp);

	boolean registrarActividad(ActividadForPagoEntity registroActividad);

}
