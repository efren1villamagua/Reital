package reital.parquesamanes.app.controllers;

import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.domain.repos.LogonRepository;

//@Component
public class LogonController {

	private LogonRepository repository;

	public LogonController() {
		super();
		setRepository(new Factory().getLogonRepository());
	}

	public LogonRepository getRepository() {
		return repository;
	}

	// @Autowired
	public void setRepository(LogonRepository repository) {
		this.repository = repository;
	}
}
