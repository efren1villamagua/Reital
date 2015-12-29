package efren.util.reportes.tools;

/**
 * Insert the type's description here. Creation date: (11/07/2002 9:50:06)
 * 
 * @author: Efrén Villamagua
 */
public class TableModel extends javax.swing.table.DefaultTableModel {
	private java.util.Vector editableColumns = new java.util.Vector();

	/**
	 * TableModel constructor comment.
	 */
	public TableModel() {
		super();
	}

	/**
	 * TableModel constructor comment.
	 * 
	 * @param data
	 *            java.lang.Object[][]
	 * @param columnNames
	 *            java.lang.Object[]
	 */
	public TableModel(java.lang.Object[][] data, java.lang.Object[] columnNames) {
		super(data, columnNames);
	}

	/**
	 * TableModel constructor comment.
	 * 
	 * @param columnNames
	 *            java.lang.Object[]
	 * @param numRows
	 *            int
	 */
	public TableModel(java.lang.Object[] columnNames, int numRows) {
		super(columnNames, numRows);
	}

	/**
	 * TableModel constructor comment.
	 * 
	 * @param numRows
	 *            int
	 * @param numColumns
	 *            int
	 */
	public TableModel(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	/**
	 * TableModel constructor comment.
	 * 
	 * @param columnNames
	 *            java.util.Vector
	 * @param numRows
	 *            int
	 */
	public TableModel(java.util.Vector columnNames, int numRows) {
		super(columnNames, numRows);
	}

	/**
	 * TableModel constructor comment.
	 * 
	 * @param data
	 *            java.util.Vector
	 * @param columnNames
	 *            java.util.Vector
	 */
	public TableModel(java.util.Vector data, java.util.Vector columnNames) {
		super(data, columnNames);
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/**
	 * Returns true if the cell at <I>row</I> and <I>column</I> is editable.
	 * Otherwise, the setValueAt() on the cell will not change the value of that
	 * cell.
	 * 
	 * @param row
	 *            the row whose value is to be looked up
	 * @param column
	 *            the column whose value is to be looked up
	 * @return true if the cell is editable.
	 * @see #setValueAt
	 */
	public boolean isCellEditable(int row, int column) {
		for (int i = 0; i < editableColumns.size(); i++)
			if (column == new Integer(editableColumns.elementAt(i).toString().trim()).intValue())
				return true;
		return false;
	}

	public void removeAllRows() {
		while (getDataVector().size() > 0)
			removeRow(0);
	}

	public void setEditableColumns(java.util.Vector newEditableColumns) {
		// newEditableColumns debe contener Strings
		this.editableColumns = newEditableColumns;
	}
}
