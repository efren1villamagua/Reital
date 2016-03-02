package reital.parquesamanes.infra;

import efren.util.ExecuteShellComand;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class BarreraTools {

	public boolean abrirBarrera(int barId) {
		try {
			String command = null;
			switch (barId) {
			case 1:
				command = ParqueSamanesConstantes.System.BARRA_1_COMMAND;
				break;
			case 2:
				command = ParqueSamanesConstantes.System.BARRA_2_COMMAND;
				break;
			case 3:
				command = ParqueSamanesConstantes.System.BARRA_3_COMMAND;
				break;
			default:
				break;
			}

			new ExecuteShellComand().executeCommand(command);

		} catch (Throwable texc) {
			texc.printStackTrace();
		}
		return false;
	}
}
