package reital.parquesamanes.rxtx.repeater.app;

import java.util.Locale;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class RepeaterApp {

	public static void main(String[] args) {

		String baseDir = null;
		try {
			if (args.length >= 4) {
				baseDir = args[3];
			}
			System.setProperty("efren.util.config.basedir", ((baseDir == null || baseDir.trim().length() == 0)
					? System.getProperty("user.dir") : baseDir.trim()));
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		try {
			LoggerManager
					.init(ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "_" + RepeaterApp.class.getSimpleName());
			SystemLogManager.setLogger(LoggerManager.logger);
		} catch (Exception e) {
			e.getMessage();
		}
		Locale.setDefault(new Locale("es", "ES"));

		String idPuerto_IN = null;
		try {
			idPuerto_IN = args[0].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		String idPuerto_INOUT = null;
		try {
			idPuerto_INOUT = args[1].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		String osCommandToOpenBar = null;
		try {
			osCommandToOpenBar = args[2].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		new RepeaterApp(idPuerto_IN, idPuerto_INOUT, osCommandToOpenBar);
	}

	private RepeaterDelegated delegated;

	public RepeaterApp(String idPuerto_IN, String idPuerto_INOUT, String osCommandToOpenBar) {
		super();
		initialize(idPuerto_IN, idPuerto_INOUT, osCommandToOpenBar);
	}

	private void initialize(String idPuerto_IN, String idPuerto_INOUT, String osCommandToOpenBar) {
		String mensaje = "Inicializacion de \"" + getClass().getSimpleName() + "\": idPuerto_IN=\"" + idPuerto_IN
				+ "\" idPuerto_INOUT=\"" + idPuerto_INOUT + "\" osCommandToOpenBar=\"" + osCommandToOpenBar + "\"";
		SystemLogManager.info(mensaje);
		System.out.println(mensaje);
		idPuerto_IN = idPuerto_IN.equalsIgnoreCase("null") ? null : idPuerto_IN;
		idPuerto_INOUT = idPuerto_INOUT.equalsIgnoreCase("null") ? null : idPuerto_INOUT;
		setDelegated(
				new RepeaterDelegated(getClass().getSimpleName(), idPuerto_IN, idPuerto_INOUT, osCommandToOpenBar));
	}

	public RepeaterDelegated getDelegated() {
		return delegated;
	}

	public void setDelegated(RepeaterDelegated delegated) {
		this.delegated = delegated;
	}

}
