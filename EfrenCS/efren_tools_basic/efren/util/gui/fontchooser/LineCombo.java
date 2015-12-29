package efren.util.gui.fontchooser;

import inetsoft.report.Common;
import inetsoft.util.Catalog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class LineCombo extends JComboBox {
	class LineRenderer extends Component implements ListCellRenderer {

		public Component getListCellRendererComponent(JList jlist, Object obj, int i, boolean flag, boolean flag1) {
			style = obj != null ? ((Integer) obj).intValue() : 0;
			sel = flag;
			return this;
		}

		public void paint(Graphics g) {
			Dimension dimension = getSize();
			g.setColor(Color.black);
			g.setFont(LineCombo.itemfont);
			FontMetrics fontmetrics = g.getFontMetrics();
			if (style == 0x81000)
				g.drawString("(" + Catalog.getString("thin thin line") + ")", 4, (dimension.height - fontmetrics.getHeight()) / 2
						+ fontmetrics.getAscent());
			else if (style == 0x41000)
				g.drawString("(" + Catalog.getString("ulra thin line") + ")", 4, (dimension.height - fontmetrics.getHeight()) / 2
						+ fontmetrics.getAscent());
			else if (style == 0)
				g.drawString("(" + Catalog.getString("none") + ")", 4, (dimension.height - fontmetrics.getHeight()) / 2
						+ fontmetrics.getAscent());
			else if (style > 0)
				Common.drawHLine(g, ((float) dimension.height - Common.getLineWidth(style)) / 2.0F, 4F, dimension.width - 8, style, 0, 0);
			else if (style < 0)
				g.drawString("" + Catalog.getString("default") + "", 4, (dimension.height - fontmetrics.getHeight()) / 2
						+ fontmetrics.getAscent());
			if (sel)
				g.drawRect(0, 0, dimension.width - 1, dimension.height - 1);
		}

		public Dimension getPreferredSize() {
			return new Dimension(60, 16);
		}

		public Dimension getMinimumSize() {
			return getPreferredSize();
		}

		int style;

		boolean sel;

		LineRenderer() {
		}
	}

	public LineCombo() {
		this(2);
	}

	public LineCombo(int i) {
		this(i, 4097);
	}

	public LineCombo(int i, int j) {
		super(i != 1 ? ((Object[]) (i != 2 ? ((Object[]) (i != 4 ? ((Object[]) (all_line_styles)) : ((Object[]) (curve_line_styles))))
				: ((Object[]) (op_line_styles)))) : ((Object[]) (fn_line_styles)));
		defaultStyle = -1;
		setRenderer(new LineRenderer());
		setLightWeightPopupEnabled(false);
		defaultStyle = j;
	}

	public int getSelectedLineStyle() {
		Object obj = getSelectedItem();
		if (obj == null) {
			return 0;
		} else {
			int i = ((Integer) obj).intValue();
			return i >= 0 ? i : defaultStyle;
		}
	}

	public void setSelectedLineStyle(int i) {
		setSelectedItem(new Integer(i));
	}

	public static final int FONT_LINES = 1;

	public static final int OPTION_LINES = 2;

	public static final int ALL_LINES = 3;

	public static final int CURVE_LINES = 4;

	static Font itemfont = new Font("Dialog", 0, 10);

	static Integer op_line_styles[] = { new Integer(-1), new Integer(0), new Integer(4097), new Integer(4098), new Integer(4099),
			new Integer(8195), new Integer(4113), new Integer(4145), new Integer(0x81000), new Integer(0x41000), new Integer(4193),
			new Integer(4241), new Integer(24578), new Integer(40962), new Integer(24579), new Integer(40963) };

	static Integer all_line_styles[] = { new Integer(4097), new Integer(4098), new Integer(4099), new Integer(8195), new Integer(4113),
			new Integer(4145), new Integer(0x81000), new Integer(0x41000), new Integer(4193), new Integer(4241), new Integer(24578),
			new Integer(40962), new Integer(24579), new Integer(40963) };

	static Integer fn_line_styles[] = { new Integer(0), new Integer(4097), new Integer(0x81000), new Integer(0x41000), new Integer(4098),
			new Integer(4099), new Integer(8195), new Integer(4113), new Integer(4145), new Integer(4193), new Integer(4241) };

	static Integer curve_line_styles[] = { new Integer(0), new Integer(4097), new Integer(0x81000), new Integer(0x41000),
			new Integer(4098), new Integer(4099), new Integer(4113), new Integer(4145), new Integer(4193), new Integer(4241) };

	int defaultStyle;

}