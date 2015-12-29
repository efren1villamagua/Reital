package efren.util.gui.panels;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class PanelExt extends JPanel {

	public PanelExt() {
		super(new GridBagLayout());
	}

	public PanelExt(LayoutManager layout) {
		super(layout);
		// TODO Apéndice de constructor generado automáticamente
	}

	public PanelExt(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Apéndice de constructor generado automáticamente
	}

	public PanelExt(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Apéndice de constructor generado automáticamente
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			//SubstanceLookAndFeel.getCurrentGradientPainter().getContourBackground(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
			//g.drawImage(ImageIO.read(getClass().getResource("/efren/resources/images/gradient.jpg")),0,0,this.getWidth(), this.getHeight(), this);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
