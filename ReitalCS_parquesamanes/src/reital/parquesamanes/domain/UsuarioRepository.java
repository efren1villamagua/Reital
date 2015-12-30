package reital.parquesamanes.domain;

import java.util.List;

import reital.parquesamanes.domain.entidades.Usuario;

public interface UsuarioRepository {

	List<Usuario> getAll(String orderBy);

	boolean create(String userName, String clave, String nombre, String tipo, String estado);

	boolean update(String userName, String clave, String nombre, String tipo, String estado);

	boolean delete(String userName);

}
