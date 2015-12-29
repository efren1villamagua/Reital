package reital.parquesamanes.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import efren.util.SystemLogManager;
import reital.parquesamanes.lector.gui.seguridades.LogonView;

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

	public LogonView getLogonViewBean() {
		try {
			return SpringInitializator.getSingleton().getContext().getBean(LogonView.class);
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		return null;
	}

	public AnnotationConfigApplicationContext getContext() {
		return context;
	}

	private void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}
}
