package reital.parquesamanes.app.controllers;

import reital.parquesamanes.app.ioc.DIConfiguration;
import reital.parquesamanes.domain.repos.LogonRepository;

//@Component
public class LogonController {

	private LogonRepository repository;

	public LogonController() {
		super();
		setRepository(new DIConfiguration().getLogonRepository());
	}

	public LogonRepository getRepository() {
		return repository;
	}

	// @Autowired
	public void setRepository(LogonRepository repository) {
		this.repository = repository;
	}
}
