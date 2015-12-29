package efren.util.gui.table;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CheckboxCellRenderer extends JCheckBox implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9027369576085355846L;
	/**
	 *
	 */
	public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}
		this.setHorizontalAlignment(JLabel.CENTER);
		try {
			setSelected((value != null && ((Boolean) value).booleanValue()));
		} catch (Throwable t2) {
			t2.getMessage();
			setSelected(value != null && new Boolean(value.toString().trim()).booleanValue());
		}
		return this;
	}
}