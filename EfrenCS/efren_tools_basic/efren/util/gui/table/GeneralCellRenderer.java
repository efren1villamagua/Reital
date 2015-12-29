package efren.util.gui.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import efren.util.CalendarManager;
import efren.util.ObjectFormatter;

public class GeneralCellRenderer extends DefaultTableCellRenderer {
	/**
	 *
	 */
	private static final long serialVersionUID = -5785687673175893062L;
	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);
	private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
	private Color unselectedForeground;
	private Color unselectedBackground;
	/**
	 *
	 */
	public GeneralCellRenderer() {
		super();
	}
	/**
	 *
	 */
	private void setValue(Object value, JTable table, boolean isSelected) {
		if (value == null) {
			super.setValue(value);
			return;
		} else {
			if (value instanceof java.lang.String) {
				setText(((String) value).trim());
				if (isSelected) {
					setForeground(table.getSelectionForeground());
					setFont(table.getFont());
				} else {
					setForeground(java.awt.Color.darkGray);
					setFont(new Font("Arial", Font.PLAIN, 11));
				}
				return;
			} else {
				if (value instanceof java.math.BigDecimal) {
					try {
						setText(ObjectFormatter.format((java.math.BigDecimal) value));
					} catch (Exception e) {
						e.getMessage();
					}
					setHorizontalAlignment(javax.swing.JLabel.RIGHT);
					setHorizontalTextPosition(javax.swing.JLabel.RIGHT);
					if (isSelected) {
						setForeground(table.getSelectionForeground());
						setFont(table.getFont());
					} else {
						setFont(new Font("Arial", Font.BOLD, 11));
						setForeground(new Color(0, 168, 64));
					}
					return;
				} else {
					if (value instanceof Date) {
						try {
							setText(new efren.util.CalendarManager((java.sql.Date) value).getDMYDateExpression());
						} catch (Exception e) {
							e.getMessage();
						}
						setHorizontalAlignment(javax.swing.JLabel.RIGHT);
						setHorizontalTextPosition(javax.swing.JLabel.RIGHT);
						if (isSelected) {
							setForeground(table.getSelectionForeground());
							setFont(table.getFont());
						} else {
							setFont(new Font("Arial", Font.BOLD, 11));
							setForeground(new java.awt.Color(0, 64, 168));
						}
						return;
					} else {
						if (value instanceof Time) {
							try {
								setText(new CalendarManager(((Time) value).getTime()).getTimeExpression2());
							} catch (Exception e) {
								e.getMessage();
							}
							setHorizontalAlignment(javax.swing.JLabel.RIGHT);
							setHorizontalTextPosition(javax.swing.JLabel.RIGHT);
							if (isSelected) {
								setForeground(table.getSelectionForeground());
								setFont(table.getFont());
							} else {
								setFont(new Font("Arial", Font.BOLD, 11));
								setForeground(new Color(0, 128, 255));
							}
							return;
						} else {
							if (value instanceof Integer || value instanceof Long) {
								try {
									if (value instanceof Integer) {
										setText(ObjectFormatter.format((Integer) value));
									} else {
										if (value instanceof Long) {
											setText(ObjectFormatter.format((Long) value));
										}
									}
								} catch (Exception e) {
									e.getMessage();
								}
								setHorizontalAlignment(javax.swing.JLabel.RIGHT);
								setHorizontalTextPosition(javax.swing.JLabel.RIGHT);
								if (isSelected) {
									setForeground(table.getSelectionForeground());
									setFont(table.getFont());
								} else {
									setFont(new Font("Arial", Font.BOLD, 11));
									setForeground(new java.awt.Color(0, 168, 64));
								}
								return;
							} else {
								super.setValue(value);
								return;
							}
						}
					}
				}
			}
		}
	}
	/**
	 *
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		if (isSelected) {
			super.setForeground(table.getSelectionForeground());
			super.setBackground(table.getSelectionBackground());
		} else {
			super.setForeground((unselectedForeground != null) ? unselectedForeground : table.getForeground());
			super.setBackground((unselectedBackground != null) ? unselectedBackground : table.getBackground());
		}

		setFont(table.getFont());

		if (hasFocus) {
			Border border = null;
			if (isSelected) {
				border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder");
			}
			if (border == null) {
				border = UIManager.getBorder("Table.focusCellHighlightBorder");
			}
			setBorder(border);

			if (!isSelected && table.isCellEditable(row, column)) {
				Color col;
				col = UIManager.getColor("Table.focusCellForeground");
				if (col != null) {
					super.setForeground(col);
				}
				col = UIManager.getColor("Table.focusCellBackground");
				if (col != null) {
					super.setBackground(col);
				}
			}
		} else {
			setBorder(getNoFocusBorder());
		}

		this.setValue(value, table, isSelected);

		return this;
	}
	/**
	 *
	 */
	private static Border getNoFocusBorder() {
		if (System.getSecurityManager() != null) {
			return SAFE_NO_FOCUS_BORDER;
		} else {
			return noFocusBorder;
		}
	}
}