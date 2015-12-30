package reital.parquesamanes.app.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import reital.parquesamanes.domain.repos.ActividadRepository;
import reital.parquesamanes.domain.repos.FranjaHorariaRepository;
import reital.parquesamanes.domain.repos.LogonRepository;
import reital.parquesamanes.domain.repos.ParametroRepository;
import reital.parquesamanes.domain.repos.UsuarioRepository;
import reital.parquesamanes.infra.repos.ActividadRepositoryImpl;
import reital.parquesamanes.infra.repos.FranjaHorariaRepositoryImpl;
import reital.parquesamanes.infra.repos.LogonRepositoryImpl;
import reital.parquesamanes.infra.repos.ParametroRepositoryImpl;
import reital.parquesamanes.infra.repos.UsuarioRepositoryImpl;

@Configuration
@ComponentScan(value = { "reital.parquesamanes.app.controllers" })
public class DIConfiguration {

	@Bean
	public ActividadRepository getActividadRepository() {
		return new ActividadRepositoryImpl();
	}

	@Bean
	public FranjaHorariaRepository getFranjaHorariaRepository() {
		return new FranjaHorariaRepositoryImpl();
	}

	@Bean
	public LogonRepository getLogonRepository() {
		return new LogonRepositoryImpl();
	}

	@Bean
	public ParametroRepository getParametroRepository() {
		return new ParametroRepositoryImpl();
	}

	@Bean
	public UsuarioRepository getUsuarioRepository() {
		return new UsuarioRepositoryImpl();
	}
}
