package efren.util.reportes.tools;

public class ColorRenderer extends javax.swing.JLabel implements javax.swing.table.TableCellRenderer {
	javax.swing.border.Border unselectedBorder = null;

	javax.swing.border.Border selectedBorder = null;

	boolean isBordered = true;

	public ColorRenderer(boolean isBordered) {
		super();
		this.isBordered = isBordered;
		setOpaque(true); // MUST do this for background to show up.
	}

	public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
		setBackground((java.awt.Color) color);
		if (isBordered) {
			if (isSelected) {
				if (selectedBorder == null) {
					selectedBorder = javax.swing.BorderFactory.createMatteBorder(2, 5, 2, 5, table.getSelectionBackground());
				}
				setBorder(selectedBorder);
			} else {
				if (unselectedBorder == null) {
					unselectedBorder = javax.swing.BorderFactory.createMatteBorder(2, 5, 2, 5, table.getBackground());
				}
				setBorder(unselectedBorder);
			}
		}
		return this;
	}
}
