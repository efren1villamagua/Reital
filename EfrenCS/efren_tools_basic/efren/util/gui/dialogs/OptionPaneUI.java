package efren.util.gui.dialogs;

public class OptionPaneUI extends javax.swing.plaf.basic.BasicOptionPaneUI {

	/** Option names for YES_NO_OPTION. */
	public static final String[] yesNoOptions = { "Si", "No" };

	/** Options names for YES_NO_CANCEL_OPTION. */
	public static final String[] yesNoCancelOptions = { "Si", "No", "Cancelar" };

	/** Default option names, when none are supplied. */
	public static final String[] defaultOptions = { "Aceptar" };

	/** Option names for OK_CANCEL_OPTION. */
	public static final String[] okCancelOptions = { "Aceptar", "Cancelar" };

	/**
	 * TsOptionpaneUI constructor comment.
	 */
	public OptionPaneUI() {
		super();
	}

	/**
	 *
	 */
	public Object[] getButtons() {
		if (optionPane != null) {
			Object[] suppliedOptions = optionPane.getOptions();
			if (suppliedOptions == null) {
				int type = optionPane.getOptionType();
				if (type == InfoView.YES_NO_OPTION)
					return OptionPaneUI.yesNoOptions;
				else if (type == InfoView.YES_NO_CANCEL_OPTION)
					return OptionPaneUI.yesNoCancelOptions;
				else if (type == InfoView.OK_CANCEL_OPTION)
					return OptionPaneUI.okCancelOptions;
				return OptionPaneUI.defaultOptions;
			}
			return suppliedOptions;
		}
		return null;
	}

	/**
	 * Returns the maximum number of characters to place on a line. Default is
	 * to return Integer.MAX_VALUE. Concrete implementations may want to return
	 * a value that means something.
	 */
	public int getMaxCharactersPerLineCount() {
		int cantidadMaximaCaracteresPorLinea = 50;
		try {
			int anchoPantallaMonitor = efren.util.ToolkitManager.getToolkit().getScreenSize().width;
			if ((anchoPantallaMonitor > 640) && (anchoPantallaMonitor <= 800))
				cantidadMaximaCaracteresPorLinea = 100;
			else
				cantidadMaximaCaracteresPorLinea = 150;
		} catch (Throwable t) {
			t.getMessage();
		}
		return cantidadMaximaCaracteresPorLinea;
	}
}
