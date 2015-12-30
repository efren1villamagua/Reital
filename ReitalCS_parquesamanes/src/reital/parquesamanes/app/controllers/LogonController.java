package reital.parquesamanes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reital.parquesamanes.domain.repos.LogonRepository;

@Component
public class LogonController {

	private LogonRepository repository;

	public LogonRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(LogonRepository repository) {
		this.repository = repository;
	}
}
