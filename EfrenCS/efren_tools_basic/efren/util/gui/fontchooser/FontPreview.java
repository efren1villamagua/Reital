package efren.util.gui.fontchooser;

import inetsoft.report.Common;
import inetsoft.report.StyleFont;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class FontPreview extends Component {

	public FontPreview() {
		psize = new Dimension(150, 100);
	}

	public void setPreferredSize(Dimension dimension) {
		psize = dimension;
	}

	public Dimension getPreferredSize() {
		return psize;
	}

	public Dimension getMinimumSize() {
		return psize;
	}

	public void setDisplayFont(Font font1) {
		font = font1;
		repaint(100L);
	}

	public void paint(Graphics g) {
		Dimension dimension = getSize();
		if (font == null)
			font = g.getFont();
		else
			g.setFont(font);
		g.setColor(Color.black);
		g.drawRect(0, 0, dimension.width - 1, dimension.height - 1);
		String s = StyleFont.toString(font);
		FontMetrics fontmetrics = g.getFontMetrics(font);
		float f = Common.stringWidth(s, font);
		float f1 = Common.getHeight(font, fontmetrics);
		Common.drawString(g, s, ((float) dimension.width - f) / 2.0F, ((float) dimension.height - f1) / 2.0F
				+ (float) fontmetrics.getAscent());
	}

	Font font;

	Dimension psize;
}