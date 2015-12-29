package efren.util;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ToolkitManager {
	/**
	 * 
	 * @return
	 */
	public static Toolkit getToolkit() {
		Toolkit toolkit = null;
		try {
			/**
			 * Se obtiene el toolkit default de la plataforma
			 */
			toolkit = Toolkit.getDefaultToolkit();
			
		} catch (Throwable t) {
			/**
			 *  En caso de error se instancia anónimamente un Frame para obtener su toolkit 
			 */
			toolkit = (new JFrame()).getToolkit();
		}
		return toolkit;
	}
}
