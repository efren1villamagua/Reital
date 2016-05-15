package reital.parquesamanes.rxtx.validator.app;

import java.util.Locale;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import reital.parquesamanes.app.util.H2ServerManager;
import reital.parquesamanes.app.util.InfoHelper;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class ValidatorApp {

	public static void main(String[] args) {
		InfoHelper.systemStarted(ValidatorApp.class.getSimpleName());

		String baseDir = null;
		try {
			if (args.length >= 2) {
				baseDir = args[1];
			}
			System.setProperty("efren.util.config.basedir", ((baseDir == null || baseDir.trim().length() == 0)
					? System.getProperty("user.dir") : baseDir.trim()));
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		try {
			LoggerManager.init(
					ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "_" + ValidatorApp.class.getSimpleName());
			SystemLogManager.setLogger(LoggerManager.logger);

			String mensaje = ValidatorApp.class.getName() + " " + ParqueSamanesConstantes.SISTEMA_VERSION
					+ " iniciando...";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

		} catch (Exception e) {
			e.getMessage();
		}
		InfoHelper.logCharset();
		Locale.setDefault(new Locale("es", "ES"));

		String idPuerto_INOUT = null;
		try {
			idPuerto_INOUT = args[0].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		H2ServerManager.h2ServerStart();

		new ValidatorApp(idPuerto_INOUT);
	}

	private ValidatorDelegated delegated;

	public ValidatorApp(String idPuerto_INOUT) {
		super();
		initialize(idPuerto_INOUT);
	}

	private void initialize(String idPuerto_INOUT) {
		String mensaje = "Inicializacion de \"" + getClass().getSimpleName() + "\": idPuerto_INOUT=\"" + idPuerto_INOUT
				+ "\"";
		SystemLogManager.info(mensaje);
		System.out.println(mensaje);
		idPuerto_INOUT = idPuerto_INOUT.equalsIgnoreCase("null") ? null : idPuerto_INOUT;
		setDelegated(new ValidatorDelegated(getClass().getSimpleName(), idPuerto_INOUT));
	}

	public ValidatorDelegated getDelegated() {
		return delegated;
	}

	public void setDelegated(ValidatorDelegated delegated) {
		this.delegated = delegated;
	}

}
