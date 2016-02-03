package reital.parquesamanes.infra;

import javax.swing.JFrame;

import efren.util.gui.dialogs.InfoView;

public class BarreraTools {

	public boolean abrirBarrera(String barId) {
		try {

			InfoView.showInformationDialog(new JFrame(), "SALIDA POR LA BARRERA: " + barId);

		} catch (Throwable texc) {
			texc.printStackTrace();
		}
		return false;
	}
}
