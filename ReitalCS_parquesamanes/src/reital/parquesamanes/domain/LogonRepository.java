package reital.parquesamanes.domain;

public interface LogonRepository {

	AutenticacionRespuesta autenticar(String userName, String key);
}
