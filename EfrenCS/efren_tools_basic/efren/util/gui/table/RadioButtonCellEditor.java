package efren.util.gui.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class RadioButtonCellEditor extends DefaultCellEditor implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884411931179785197L;
	private JRadioButton button;
	/**
	 * 
	 */
	public RadioButtonCellEditor(JCheckBox checkBox) {
		super(checkBox);
	}
	/**
	 * 
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value == null) {
			return null;
		}
		button = (JRadioButton) value;
		button.addItemListener(this);
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setFont(table.getFont());
		} else {
			button.setFont(new Font("Arial", Font.BOLD, 11));
			button.setForeground(new Color(0, 168, 64));
		}
		return (Component) value;
	}
	/**
	 * 
	 */
	public Object getCellEditorValue() {
		button.removeItemListener(this);
		return button;
	}
	/**
	 * 
	 */
	public void itemStateChanged(ItemEvent e) {
		super.fireEditingStopped();
	}
}