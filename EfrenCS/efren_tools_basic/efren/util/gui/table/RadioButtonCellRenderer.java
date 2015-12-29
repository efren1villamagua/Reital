package efren.util.gui.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RadioButtonCellRenderer implements TableCellRenderer {
	/**
	 * 
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JRadioButton componente = (JRadioButton) value;
		if (isSelected) {
			componente.setForeground(table.getSelectionForeground());
			componente.setBackground(table.getSelectionBackground());
		} else {
			componente.setForeground(table.getForeground());
			componente.setBackground(table.getBackground());
		}
		componente.setHorizontalAlignment(JLabel.CENTER);
		componente.setHorizontalAlignment(JLabel.RIGHT);
		componente.setHorizontalTextPosition(JLabel.RIGHT);
		if (isSelected) {
			componente.setForeground(table.getSelectionForeground());
			componente.setFont(table.getFont());
		} else {
			componente.setFont(new Font("Arial", Font.BOLD, 11));
			componente.setForeground(new Color(0, 168, 64));
		}
		return componente;
	}
}
