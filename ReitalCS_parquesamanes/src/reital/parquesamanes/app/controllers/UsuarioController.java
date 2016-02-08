package reital.parquesamanes.app.controllers;

import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.domain.repos.UsuarioRepository;

//@Component
public class UsuarioController {

	private UsuarioRepository repository;

	public UsuarioController() {
		super();
		setRepository(new Factory().getUsuarioRepository());
	}

	public UsuarioRepository getRepository() {
		return repository;
	}

	// @Autowired
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
}
