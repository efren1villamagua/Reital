package reital.parquesamanes.rxtx.repeater.app;

import java.util.Locale;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import reital.parquesamanes.app.util.InfoHelper;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class RepeaterApp {

	public static void main(String[] args) {
		InfoHelper.systemStarted(RepeaterApp.class.getSimpleName());

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

			String mensaje = RepeaterApp.class.getName() + " " + ParqueSamanesConstantes.SISTEMA_VERSION
					+ " iniciando...";
			SystemLogManager.info(mensaje);
			System.out.println(mensaje);

		} catch (Exception e) {
			e.getMessage();
		}
		InfoHelper.logCharset();
		Locale.setDefault(new Locale("es", "ES"));

		String idPuerto_BARRERA = null;
		try {
			idPuerto_BARRERA = args[0].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		String idPuerto_SERVER = null;
		try {
			idPuerto_SERVER = args[1].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}
		String idPuerto_ARDUINO = null;
		try {
			idPuerto_ARDUINO = args[2].trim();
		} catch (Exception exc) {
			SystemLogManager.error(exc);
		}

		new RepeaterApp(idPuerto_BARRERA, idPuerto_SERVER, idPuerto_ARDUINO);
	}

	private RepeaterDelegated delegated;

	public RepeaterApp(String idPuerto_BARRERA, String idPuerto_SERVER, String idPuerto_ARDUINO) {
		super();
		initialize(idPuerto_BARRERA, idPuerto_SERVER, idPuerto_ARDUINO);
	}

	private void initialize(String idPuerto_BARRERA, String idPuerto_SERVER, String idPuerto_ARDUINO) {
		String mensaje = "Inicializacion de \"" + getClass().getSimpleName() + "\": idPuerto_BARRERA=\""
				+ idPuerto_BARRERA + "\" idPuerto_SERVER=\"" + idPuerto_SERVER + "\" idPuerto_ARDUINO=\""
				+ idPuerto_ARDUINO + "\"";
		SystemLogManager.info(mensaje);
		System.out.println(mensaje);
		idPuerto_BARRERA = idPuerto_BARRERA.equalsIgnoreCase("null") ? null : idPuerto_BARRERA;
		idPuerto_SERVER = idPuerto_SERVER.equalsIgnoreCase("null") ? null : idPuerto_SERVER;
		idPuerto_ARDUINO = idPuerto_ARDUINO.equalsIgnoreCase("null") ? null : idPuerto_ARDUINO;
		setDelegated(
				new RepeaterDelegated(getClass().getSimpleName(), idPuerto_BARRERA, idPuerto_SERVER, idPuerto_ARDUINO));
	}

	public RepeaterDelegated getDelegated() {
		return delegated;
	}

	public void setDelegated(RepeaterDelegated delegated) {
		this.delegated = delegated;
	}

}
