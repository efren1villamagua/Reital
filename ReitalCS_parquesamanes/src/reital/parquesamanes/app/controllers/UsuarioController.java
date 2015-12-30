package reital.parquesamanes.app.controllers;

import reital.parquesamanes.app.ioc.DIConfiguration;
import reital.parquesamanes.domain.repos.UsuarioRepository;

//@Component
public class UsuarioController {

	private UsuarioRepository repository;

	public UsuarioController() {
		super();
		setRepository(new DIConfiguration().getUsuarioRepository());
	}

	public UsuarioRepository getRepository() {
		return repository;
	}

	// @Autowired
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
}
