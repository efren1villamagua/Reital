package reital.parquesamanes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reital.parquesamanes.domain.FranjaHorariaRepository;

@Component
public class FranjaHorariaController {

	private FranjaHorariaRepository repository;

	public FranjaHorariaRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(FranjaHorariaRepository repository) {
		this.repository = repository;
	}
}
