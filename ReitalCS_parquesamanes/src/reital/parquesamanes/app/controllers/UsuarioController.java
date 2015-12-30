package reital.parquesamanes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reital.parquesamanes.domain.repos.UsuarioRepository;

@Component
public class UsuarioController {

	private UsuarioRepository repository;

	public UsuarioRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
}
