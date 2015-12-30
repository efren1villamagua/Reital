package reital.parquesamanes.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import reital.parquesamanes.domain.AutenticacionRespuesta;
import reital.parquesamanes.domain.FranjaHorariaRepository;
import reital.parquesamanes.domain.LogonRepository;
import reital.parquesamanes.domain.PagoRepository;
import reital.parquesamanes.domain.UsuarioRepository;
import reital.parquesamanes.infra.FranjaHorariaRepositoryImpl;
import reital.parquesamanes.infra.LogonRepositoryImpl;
import reital.parquesamanes.infra.PagoRepositoryImpl;
import reital.parquesamanes.infra.UsuarioRepositoryImpl;

@Configuration
@ComponentScan(value = { "reital.parquesamanes.app.gui.seguridades", "reital.parquesamanes.app.gui.working" })
public class DIConfiguration {

	@Bean
	public AutenticacionRespuesta getAutenticacionRespuesta() {
		return new AutenticacionRespuesta();
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
	public PagoRepository getPagoRepository() {
		return new PagoRepositoryImpl();
	}

	@Bean
	public UsuarioRepository getUsuarioRepository() {
		return new UsuarioRepositoryImpl();
	}
}
