package reital.parquesamanes.domain.repos;

import reital.parquesamanes.domain.AutenticacionRespuesta;

public interface LogonRepository {

	AutenticacionRespuesta autenticar(String userName, String key);
}
