package efren.util.gui.panels;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import efren.util.config.SystemProperties;

public class PanelExtLogin extends JPanel {

	public PanelExtLogin() {
		super(new GridBagLayout());
	}

	public PanelExtLogin(LayoutManager layout) {
		super(layout);
		// TODO Apéndice de constructor generado automáticamente
	}

	public PanelExtLogin(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Apéndice de constructor generado automáticamente
	}

	public PanelExtLogin(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Apéndice de constructor generado automáticamente
	}
	/**
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(ImageIO.read(getClass().getResource(SystemProperties.SISTEMA_BACKGROUND_ICONO_PATH)),0,0,this.getWidth(), this.getHeight(), this);
		} catch (Exception e1) {
			e1.getMessage();
			try {
				g.drawImage(ImageIO.read(getClass().getResource("/efren/resources/images/login2.jpg")),0,0,this.getWidth(), this.getHeight(), this);
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
	}

}
