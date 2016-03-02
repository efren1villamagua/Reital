package reital.parquesamanes.app.controllers;

import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.domain.repos.FranjaHorariaRepository;

//@Component
public class FranjaHorariaController {

	private FranjaHorariaRepository repository;

	public FranjaHorariaRepository getRepository() {
		return repository;
	}

	public FranjaHorariaController() {
		super();
		setRepository(new Factory().getFranjaHorariaRepository());
	}

	// @Autowired
	public void setRepository(FranjaHorariaRepository repository) {
		this.repository = repository;
	}
}
