package reital.parquesamanes.app.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import efren.util.SystemLogManager;
import reital.parquesamanes.app.controllers.FranjaHorariaController;
import reital.parquesamanes.app.controllers.LogonController;
import reital.parquesamanes.app.controllers.PagoController;
import reital.parquesamanes.app.controllers.UsuarioController;

public class SpringInitializator {

	private static SpringInitializator singleton;

	private AnnotationConfigApplicationContext context;

	private SpringInitializator() {
		super();
		init();
	}

	private void init() {
		setContext(new AnnotationConfigApplicationContext(DIConfiguration.class));
	}

	public void destroy() {
		try {
			if (getContext() != null) {
				getContext().close();
			}
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
	}

	public static SpringInitializator getSingleton() {
		if (singleton == null) {
			setSingleton(new SpringInitializator());
		}
		return singleton;
	}

	private static void setSingleton(SpringInitializator singleton) {
		SpringInitializator.singleton = singleton;
	}

	public AnnotationConfigApplicationContext getContext() {
		return context;
	}

	private void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

	public LogonController getLogonControllerBean() {
		try {
			// return
			// SpringInitializator.getSingleton().getContext().getBean(LogonController.class);
			return new LogonController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public FranjaHorariaController getFranjaHorariaControllerBean() {
		try {
			// return
			// SpringInitializator.getSingleton().getContext().getBean(FranjaHorariaController.class);
			return new FranjaHorariaController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public UsuarioController getUsuarioControllerBean() {
		try {
			// return
			// SpringInitializator.getSingleton().getContext().getBean(UsuarioController.class);
			return new UsuarioController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public PagoController getPagoControllerBean() {
		try {
			// return
			// SpringInitializator.getSingleton().getContext().getBean(PagoController.class);
			return new PagoController();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}
}
