package reital.parquesamanes.domain.repos;

import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;

public interface ActividadRepository {

	boolean yaSalio(String codigo);

	boolean registrarActividad(ActividadForPagoEntity registroActividad);

	ActividadForPagoEntity getActividad(String codigo);

}
