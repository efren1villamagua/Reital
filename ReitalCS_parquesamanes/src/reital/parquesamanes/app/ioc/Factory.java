package reital.parquesamanes.app.ioc;

import efren.util.SystemLogManager;
import reital.parquesamanes.app.controllers.FranjaHorariaController;
import reital.parquesamanes.app.controllers.LogonController;
import reital.parquesamanes.app.controllers.PagoController;
import reital.parquesamanes.app.controllers.UsuarioController;
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

public class Factory {

	public ActividadRepository getActividadRepository() {
		return new ActividadRepositoryImpl();
	}

	public FranjaHorariaRepository getFranjaHorariaRepository() {
		return new FranjaHorariaRepositoryImpl();
	}

	public LogonRepository getLogonRepository() {
		return new LogonRepositoryImpl();
	}

	public ParametroRepository getParametroRepository() {
		return new ParametroRepositoryImpl();
	}

	public UsuarioRepository getUsuarioRepository() {
		return new UsuarioRepositoryImpl();
	}
	
	public LogonController getLogonControllerBean() {
		try {
			return new LogonController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public FranjaHorariaController getFranjaHorariaControllerBean() {
		try {
			return new FranjaHorariaController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public UsuarioController getUsuarioControllerBean() {
		try {
			return new UsuarioController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public PagoController getPagoControllerBean() {
		try {
			return new PagoController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}
}
