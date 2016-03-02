package reital.parquesamanes.rxtx.repeater.app;

import java.util.StringTokenizer;

import efren.util.ExecuteShellComand;
import efren.util.SystemLogManager;

public class BarreraManager {

	private String osCommandToOpen;

	public BarreraManager(String osCommandToOpen) {
		super();
		setOsCommandToOpen(osCommandToOpen);
	}

	public void manage(String respuestaDesdeCentral) {
		try {
			if (respuestaDesdeCentral == null) {
				return;
			}

			StringTokenizer stk = new StringTokenizer(respuestaDesdeCentral, "|");
			String codigoActividad = stk.nextToken();
			boolean abrir = Boolean.parseBoolean(stk.nextToken().trim());

			if (abrir) {
				try {
					new ExecuteShellComand().executeCommand(getOsCommandToOpen());
					SystemLogManager.info("Envio de \"apertura/salida\" ok para: " + codigoActividad);
				} catch (Throwable texc) {
					SystemLogManager.error(texc);
				}
			} else {
				SystemLogManager.info("Envio de \"apertura/salida\" negado para: " + codigoActividad);
			}

		} catch (Throwable texc) {
			SystemLogManager.error(texc);
		}
	}

	public String getOsCommandToOpen() {
		return osCommandToOpen;
	}

	public void setOsCommandToOpen(String osCommandToOpen) {
		this.osCommandToOpen = osCommandToOpen;
	}
}
