package efren.util.gui.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

import efren.util.config.SystemProperties;

public class DesktopPaneExt extends JDesktopPane {

	public DesktopPaneExt() {
		super();
	}
	/**
	 *
	 */
/*
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			BufferedImage image = ImageIO.read(getClass().getResource(SystemProperties.SISTEMA_DESKTOP_BACKGROUND_ICONO_PATH));
			int anchoContainer = this.getWidth();
			int anchoImagen = image.getWidth();
			int altoContainer = this.getHeight();
			int altoImagen = image.getHeight();
			g.drawImage(image, (anchoContainer - anchoImagen)/2, (altoContainer - altoImagen)/2, anchoImagen, altoImagen, this);
		} catch (Exception e1) {
			e1.getMessage();
			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/efren/resources/images/login2_desktop.jpg"));
				int anchoContainer = this.getWidth();
				int anchoImagen = image.getWidth();
				int altoContainer = this.getHeight();
				int altoImagen = image.getHeight();
				g.drawImage(image, (anchoContainer - anchoImagen)/2, (altoContainer - altoImagen)/2, anchoImagen, altoImagen, this);
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
	}
*/
}
