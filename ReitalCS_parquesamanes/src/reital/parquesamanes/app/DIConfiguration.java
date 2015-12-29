package reital.parquesamanes.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import reital.parquesamanes.domain.LogonRepository;
import reital.parquesamanes.infra.LogonRepositoryImpl;

@Configuration
@ComponentScan(value = { "reital.parquesamanes.lector.gui.seguridades" })
public class DIConfiguration {

	@Bean
	public LogonRepository getLogonRepository() {
		return new LogonRepositoryImpl();
	}
}
