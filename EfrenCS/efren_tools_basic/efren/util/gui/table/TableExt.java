package efren.util.gui.table;

import java.lang.reflect.Method;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableExt extends JTable {
	/**
	 *
	 */
	private static final long serialVersionUID = -3364449596599352652L;
	//...
	private JTableHeader aTableHeader;
	private SortButtonRenderer headerRenderer;
	private DataTablePanel containerPanel;
	/**
	 *
	 *
	 */
	public TableExt() {
		super();
		init();
	}
	/**
	 *
	 */
	private void init() {
		try {
			setAutoCreateColumnsFromModel(false);
			SortButtonRenderer headerRenderer = new SortButtonRenderer();
			headerRenderer.setFont(efren.util.FontManager.currentSystemBoldFont());
			headerRenderer.setForeground(new java.awt.Color(128, 64, 0));
			this.headerRenderer = headerRenderer;
			this.aTableHeader.addMouseListener(new HeaderListener(this.aTableHeader, headerRenderer));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 *
	 */
	public void createColumns() {
		TableModelExt model = null;
		try {
			model = (TableModelExt) this.getModel();
		} catch (Throwable t) {
			t.getMessage();
//			super.createDefaultColumnsFromModel();
			return;
		}
		if (model != null) {
			// Remove any current columns
			javax.swing.table.TableColumnModel cm = getColumnModel();
			cm.removeColumnModelListener(this);
			while (cm.getColumnCount() > 0) {
				cm.removeColumn(cm.getColumn(0));
			}
			// Create new columns from the data model info
			String headerName;
			int columnWidth;
			javax.swing.table.TableColumn newColumn;

			for (int i = 0; i < model.getColumnCount(); i++) {
				headerName = model.getTableHeaderNames().elementAt(i).toString();
				columnWidth = ((Integer) model.getTableColumnWidths().elementAt(i)).intValue();

				newColumn = new TableColumn(i, columnWidth);
				newColumn.setHeaderValue(headerName);
				newColumn.setCellRenderer(this.getRendererPorColumna(i));

				newColumn.setHeaderRenderer(this.headerRenderer);
				addColumn(newColumn);
			}
			cm.addColumnModelListener(this);
		}
	}
	/*
	 * overrided by Efren Villamagua to provide custom renderer to the table
	 * cells
	 */
	protected void createDefaultRenderers() {

		super.createDefaultRenderers();
/*
		setDefaultRenderer(java.lang.String.class, new GeneralCellRenderer());
		setDefaultRenderer(java.math.BigDecimal.class, new GeneralCellRenderer());
		setDefaultRenderer(java.lang.Integer.class, new GeneralCellRenderer());
		setDefaultRenderer(Long.class, new GeneralCellRenderer());
		setDefaultRenderer(java.sql.Date.class, new GeneralCellRenderer());
		setDefaultRenderer(Boolean.class, new CheckboxCellRenderer());
		//setDefaultRenderer(null, new GeneralCellRenderer());
*/
	}
	/**
	 * Returns the default table header object which is a JTableHeader.
	 * overrided by Efren Villamagua to provide custom font anf foreground to
	 * the table header
	 *
	 * @return the default table header object
	 */
	protected javax.swing.table.JTableHeader createDefaultTableHeader() {
		javax.swing.table.JTableHeader aTableHeader = new javax.swing.table.JTableHeader(columnModel);
		aTableHeader.setFont(efren.util.FontManager.currentSystemBoldFont());
		aTableHeader.setForeground(new java.awt.Color(128, 64, 0));
		this.aTableHeader = aTableHeader;

		return aTableHeader;
	}
	/**
	 * Returns the name of the column at the specified view position.
	 *
	 * @return the name of the column at position <I>column</I> in the view
	 *         where the first column is column 0.
	 */
	public String getColumnName(int column) {
		try {
			return ((TableModelExt) getModel()).getTable().getColumnModel().getColumn(column).getHeaderValue().toString();
		} catch (Throwable t) {
			t.getMessage();
		}
		return super.getColumnName(column);
	}

	/**
	 * Insert the method's description here. Creation date: (17/12/2003
	 * 22:33:57)
	 *
	 * @return efren.abm.beans.DataTablePanel
	 */
	public DataTablePanel getContainerPanel() {
		return containerPanel;
	}
	/**
	 *
	 */
	public Object getValueAt(int row, int column) {
		return ((TableModelExt) getModel()).getValueAt(row, convertColumnIndexToModel(column));
	}

	/**
	 *
	 */
	public void setValueAt(Object aValue, int row, int column) {
		((TableModelExt) getModel()).setValueAt(aValue, row, convertColumnIndexToModel(column));
	}

	/**
	 * Insert the method's description here. Creation date: (17/12/2003 22:33:57)
	 *
	 * @param newContainerPanel
	 *            efren.abm.beans.DataTablePanel
	 */
	public void setContainerPanel(DataTablePanel newContainerPanel) {
		containerPanel = newContainerPanel;
	}
	/**
	 *
	 * @param column
	 * @return
	 */
	public TableColumn getColumnAt(int column) {
		try {
			return ((TableModelExt) getModel()).getTable().getColumnModel().getColumn(column);
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}
	/**
	 *
	 */
	class HeaderListener extends java.awt.event.MouseAdapter {

		javax.swing.table.JTableHeader header;
		SortButtonRenderer renderer;

		HeaderListener(javax.swing.table.JTableHeader header, SortButtonRenderer renderer) {
			this.header = header;
			this.renderer = renderer;
		}

		public void mousePressed(java.awt.event.MouseEvent e) {
			try {

				if (header.getResizingColumn() != null)
					return;

				int col = header.columnAtPoint(e.getPoint());

				String anOrderBy_alias = ((TableModelExt) header.getTable().getModel()).getTableOrderByAliases().elementAt(col).toString();

				if (anOrderBy_alias == null || anOrderBy_alias.trim().length() == 0 || anOrderBy_alias.trim().toUpperCase().compareTo("_NO_ALIAS") == 0) {
					return;
				}

				int sortCol = header.getTable().convertColumnIndexToModel(col);
				renderer.setPressedColumn(col);
				renderer.setSelectedColumn(col, getModel().getColumnCount());
				header.repaint();

				if (header.getTable().isEditing()) {
					header.getTable().getCellEditor().stopCellEditing();
				}

				boolean isAscent;
				if (renderer.getState(col) == SortButtonRenderer.UP) {
					isAscent = true;
				} else {
					isAscent = false;
				}

				String ascending_str = "";
				if (!isAscent) {
					ascending_str = " DESC ";
				}
				getContainerPanel().setOrderBy_alias(anOrderBy_alias + ascending_str);
				getContainerPanel().forceFireBuscarPerformed();

			} catch (Exception ex) {
				ex.getMessage();
			}

		}

		public void mouseReleased(java.awt.event.MouseEvent e) {

			int col = header.columnAtPoint(e.getPoint());
			renderer.setPressedColumn(-1); // clear
			header.repaint();
		}
	}
	/**
	 *
	 */
/*
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
    	/*
        Object value = getValueAt(row, column);

        if (value == null) {
        	return new GeneralCellRenderer();
        } else {
        	return super.prepareRenderer(renderer, row, column);
        }
        */
/*
    	try {
    		return (Component) this.getRendererPorColumna(column);
    	} catch (Throwable tex) {
			tex.getMessage();
			return super.prepareRenderer(renderer, row, column);
		}
    }
*/
    /**
     *
     */
    private TableCellRenderer getRendererPorColumna(int unaColumna) {
    	try {
        	TableModelExt modelo = (TableModelExt) getModel();
        	Vector columnIdentifiers = modelo.getColumnIdentifiers();
        	Class dataClass = modelo.getElementClass();
        	String fieldName = (String) columnIdentifiers.elementAt(unaColumna);
        	Method metodos[] = dataClass.getMethods();
        	//DataTableColumn columnData = (DataTableColumn) columnIdentifiers.elementAt(unaColumna + 1);
        	String columnMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        	Method metodo;
        	Class columnClass = null;
			for (int k = 0; k < metodos.length; k++) {
				metodo = metodos[k];
				if (metodo.getName().compareTo(columnMethodName) == 0) {
					columnClass = metodo.getReturnType();
				}
			}
			//...
			if (columnClass.getName().compareTo("java.lang.String") == 0 || columnClass.getName().compareTo("java.math.BigDecimal") == 0
					|| columnClass.getName().compareTo("java.lang.Integer") == 0 || columnClass.getName().compareTo("java.lang.Long") == 0
					|| columnClass.getName().compareTo("java.sql.Date") == 0) {
				return new GeneralCellRenderer();
			} else {
				if (columnClass.getName().compareTo("java.lang.Boolean") == 0) {
					return new CheckboxCellRenderer();
				}
			}

			return new GeneralCellRenderer();
		} catch (Throwable tex) {
			tex.getMessage();
			return new GeneralCellRenderer();
		}

    }
}
