package reital.parquesamanes.rxtx.repeater.app;

import java.util.Locale;

import efren.util.LoggerManager;
import efren.util.SystemLogManager;
import efren.util.lookandfeel.LookAndFeelManager;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class RepeaterApp {

	public static void main(String[] args) {

		LookAndFeelManager.simpleSetLookAndFeel();

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

		new RepeaterApp(idPuerto_IN, idPuerto_INOUT);
	}

	private RepeaterDelegated delegated;

	public RepeaterApp(String idPuerto_IN, String idPuerto_INOUT) {
		super();
		setDelegated(new RepeaterDelegated(getClass().getSimpleName(), idPuerto_IN, idPuerto_INOUT));
	}

	public RepeaterDelegated getDelegated() {
		return delegated;
	}

	public void setDelegated(RepeaterDelegated delegated) {
		this.delegated = delegated;
	}

}
