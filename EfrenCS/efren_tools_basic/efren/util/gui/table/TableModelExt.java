package efren.util.gui.table;

import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

import efren.util.MethodInvocation;

public class TableModelExt extends javax.swing.table.AbstractTableModel implements ListSelectionListener {

	//...
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private Class elementClass;
	private javax.swing.JTable table;
	private Vector selectedObjects = new Vector();
	private Vector dataObjects = new Vector();
	protected Vector dataVector;
	protected Vector columnIdentifiers;
	//...
	private Vector tableHeaderNames = new Vector();
	private Vector tableColumnWidths = new Vector();
	private Vector tableFieldNames = new Vector();
	private Vector tableEditables = new Vector();
	private Vector tableOrderByAliases = new Vector();
	//...

	private java.lang.Object actionManager;
	/**
	 *
	 */
	public TableModelExt() {
		setColumnIdentifiers(null);
		this.dataVector = new Vector();
		setNumRows(0);
	}
	/**
	 *
	 * @param data
	 * @param columnNames
	 */
	public TableModelExt(Vector data, Vector columnNames) {
		setDataVector(data, columnNames);
	}
	/**
	 *
	 * @param object
	 */
	public void add(Object object) {
		if (object == null)
			return;

		this.dataObjects.addElement(object);
		addRow(parseToVector(object));
	}
	/**
	 *
	 * @param listener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}
	/**
	 *
	 * @param rowData
	 */
	public void addRow(Vector rowData) {
		if (rowData == null) {
			rowData = new Vector(getColumnCount());
		} else {
			rowData.setSize(getColumnCount());
		}
		dataVector.addElement(rowData);

		// Generate notification
		newRowsAdded(new TableModelEvent(this, getRowCount() - 1, getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}
	/**
	 *
	 */
	public void setValueAt(Object aValue, int row, int column) {
		Vector rowVector = (Vector) dataVector.elementAt(row);
		rowVector.setElementAt(aValue, column);
	}
	/**
	 *
	 * @return
	 */
	public Vector elements() {
		return dataObjects;
	}
	/**
	 *
	 * @param propertyName
	 * @param oldValue
	 * @param newValue
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
		getTable().repaint();
	}

	public java.lang.Object getActionManager() {
		return actionManager;
	}
	/**
	 *
	 */
	public Class getColumnClass(int c) {
		if (getValueAt(0, c) == null)
			return super.getColumnClass(c);
		return getValueAt(0, c).getClass();
	}
	/**
	 *
	 */
	public int getColumnCount() {
		return columnIdentifiers.size();
	}
	/**
	 *
	 * @return
	 */
	public Class getElementClass() {
		return elementClass;
	}
	/**
	 *
	 * @return
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		return propertyChange;
	}
	/**
	 *
	 */
	public int getRowCount() {
		return dataVector.size();
	}
	/**
	 *
	 * @return
	 */
	public Object getSelectedObject() {
		int size = selectedObjects.size();
		return (size == 1) ? selectedObjects.firstElement() : null;
	}
	/**
	 *
	 * @return
	 */
	public Vector getSelectedObjects() {
		return selectedObjects;
	}
	/**
	 *
	 * @return
	 */
	public javax.swing.JTable getTable() {
		return this.table;
	}
	/**
	 *
	 */
	public Object getValueAt(int row, int column) {
		Vector rowVector = (Vector) dataVector.elementAt(row);
		return rowVector.elementAt(column);
	}
	/**
	 *
	 */
	public Object getObjectAt(int row) {
		return dataObjects.elementAt(row);
	}
	/**
	 *
	 * @param row
	 * @param object
	 */
	public void insert(int row, Object object) {
		if (object == null)
			return;
		this.dataObjects.insertElementAt(object, row);
		dataVector.insertElementAt(parseToVector(object), row);

		// generate notification
		newRowsAdded(new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}
	/**
	 * ESTE EVENTO REFRESCA LOS DATOS
	 */
	public void refreshData() {
		fireTableDataChanged();
		getTable().tableChanged(new TableModelEvent(this));
	}
	/**
	 *
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		try {
			return ((Boolean) getTableEditables().elementAt(columnIndex)).booleanValue();
		} catch (Throwable t) {
			t.getMessage();
			return false;
		}
	}
	/**
	 *
	 * @param event
	 */
	public void newRowsAdded(TableModelEvent event) {
		int start = event.getFirstRow();
		int end = event.getLastRow();
		if (start < 0)
			start = 0;
		if (end < 0)
			end = getRowCount() - 1;

		// Have to make sure all the new columns have the correct
		// number of columns
		for (int i = start; i < end; i++)
			((Vector) dataVector.elementAt(i)).setSize(getColumnCount());

		// Now we send the notification
		fireTableChanged(event);
	}
	/**
	 *
	 * @param oldObjects
	 * @param newObjects
	 */
	protected void notifySelectedObjectChanged(Vector oldObjects, Vector newObjects) {
		Object oldObject, newObject;
		oldObject = oldObjects;
		switch (oldObjects.size()) {
		case 0:
			oldObject = null;
			break;
		case 1:
			oldObject = oldObjects.firstElement();
			break;
		}
		newObject = newObjects;
		switch (newObjects.size()) {
		case 0:
			newObject = null;
			break;
		case 1:
			newObject = newObjects.firstElement();
			break;
		}
		firePropertyChange("selectedObject", oldObject, newObject);
	}
	/**
	 *
	 * @param oldObjects
	 * @param newObjects
	 */
	protected void notifySelectedObjectsChanged(Vector oldObjects, Vector newObjects) {
		firePropertyChange("selectedObjects", oldObjects, newObjects);
	}
	/**
	 *
	 * @param object
	 * @return
	 */
	private Vector parseToVector(Object object) {
		/**
		 * convierte object en un Vector (extrayendo desde object sus atributos
		 * definidos en columnIdentifiers)
		 */
		Vector v = new Vector();
		String nombreField;
		String nombreMetodo;
		for (int i = 0; i < columnIdentifiers.size(); i++) {
			nombreField = columnIdentifiers.elementAt(i).toString();
			nombreMetodo = "get" + nombreField.substring(0, 1).toUpperCase()+nombreField.substring(1);
			v.addElement(MethodInvocation.performMethod(nombreMetodo, object));
		}
		return v;
	}
	/**
	 *
	 * @param object
	 */
	public void remove(Object object) {
		int index = this.dataObjects.indexOf(object);

		this.dataObjects.removeElementAt(index);
		dataVector.removeElementAt(index);

		// Generate notification
		fireTableRowsDeleted(index, index);
	}
	/**
	 * Remove all rows from the model. Notification of the rows being removed
	 * will be sent to all the listeners.
	 */
	public void removeAll() {

		int size = getRowCount();

		this.dataObjects = new Vector(0);
		dataVector = new Vector(0);

		// Generate notification
		fireTableRowsDeleted(0, size);

	}
	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}
	/**
	 * Remove the row at <i>row </i> from the model. Notification of the row
	 * being removed will be sent to all the listeners.
	 *
	 * @param row
	 *            the row index of the row to be removed
	 * @exception ArrayIndexOutOfBoundsException
	 *                if the row was invalid.
	 */
	public void removeRow(int row) {
		dataVector.removeElementAt(row);
		this.dataObjects.removeElementAt(row);

		// Generate notification
		fireTableRowsDeleted(row, row);
	}
	/**
	 * Inserte aquí la descripción del método. Fecha de creación: (03/03/2005
	 * 11:23:36)
	 *
	 * @param newActionManager
	 *            java.lang.Object
	 */
	public void setActionManager(java.lang.Object newActionManager) {
		actionManager = newActionManager;
	}

	/**
	 * Replaces the column identifiers in the model.
	 *
	 * @param newIdentifiers
	 *            Vector of column identifiers. A null means setting the model
	 *            to zero columns
	 * @see #setNumRows()
	 */
	public void setColumnIdentifiers(Vector newIdentifiers) {
		if (newIdentifiers != null) {
			columnIdentifiers = newIdentifiers;
		} else {
			columnIdentifiers = new Vector();
		}

		// Generate notification
		fireTableStructureChanged();
	}

	/**
	 * This replaces the current dataVector instance variable with the new
	 * Vector of rows, <i>newData </i>. <i>columnNames </i> are the names of the
	 * new columns. The first name in <i>columnNames </i> is mapped to column 0
	 * in <i>newData </i>. Each row in <i>newData </i> is adjusted to match the
	 * number of columns in <i>columnNames </i> either by truncating the Vector
	 * if it is too long, or adding null values if it is too short.
	 * <p>
	 *
	 * @param newData
	 *            The new data vector
	 * @param columnNames
	 *            The names of the columns
	 * @see #newDataAvailable()
	 * @see #getDataVector()
	 */
	public void setDataVector(Vector newData, Vector columnNames) {
		if (newData == null)
			throw new IllegalArgumentException("setDataVector() - Null parameter");

		// Clear all the previous data.
		dataVector = new Vector(0);

		// Install the new column structure, this will fireTableStructureChanged
		setColumnIdentifiers(columnNames);

		// Add the new rows.
		dataVector = newData;

		// Make all the new rows the right length and generate a notification.
		newRowsAdded(new TableModelEvent(this, 0, getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @param newValue
	 *            java.lang.Class
	 */
	public void setElementClass(Class newValue) {
		this.elementClass = newValue;
	}

	/**
	 * Sets the number of rows in the model. If the new size is greater than the
	 * current size, new rows are added to the end of the model If the new size
	 * is less than the current size, all rows at index <i>newSize </i> and
	 * greater are discarded.
	 * <p>
	 *
	 * @param newSize
	 *            the new number of rows
	 * @see #setColumnIdentifiers()
	 */
	public void setNumRows(int newSize) {
		if ((newSize < 0) || (newSize == getRowCount()))
			return;
		int oldNumRows = getRowCount();
		if (newSize <= getRowCount()) {
			// newSize is smaller than our current size, so we can just
			// let Vector discard the extra rows
			dataVector.setSize(newSize);

			// Generate notification
			fireTableRowsDeleted(getRowCount(), oldNumRows - 1);
		} else {
			int columnCount = getColumnCount();
			// We are adding rows to the model
			while (getRowCount() < newSize) {
				Vector newRow = new Vector(columnCount);
				newRow.setSize(columnCount);
				dataVector.addElement(newRow);
			}

			// Generate notification
			fireTableRowsInserted(oldNumRows, getRowCount() - 1);
		}
	}

	/*
	 * Set the selectedRowObject to be the object for the selectedRow integer.
	 * Fire a property change only if the previously selectedRowObject is
	 * different than the current selectedRowObject.
	 */

	protected void setSelectedObjects() {
		int index, arrayLength;
		Vector oldObjects = (Vector) getSelectedObjects().clone();
		getSelectedObjects().removeAllElements();
		int[] intArray = table.getSelectedRows();
		arrayLength = intArray.length;
		for (int i = 0; i < arrayLength; i++) {
			index = intArray[i];
			if (index >= 0) {
				try {
					if (dataObjects.size() > 0)
						selectedObjects.addElement(dataObjects.elementAt(index));
					else
						selectedObjects.addElement(null);
				} catch (Throwable t) {
				}
			}
		}
		// Object newSingleSelection = getSelectedRowObject();
		notifySelectedObjectsChanged(oldObjects, selectedObjects);
		notifySelectedObjectChanged(oldObjects, selectedObjects);
	}

	/**
	 * Set the table. Add ourself as a list selection listener to the table's
	 * selection model so that we will be informed when a selection is made.
	 */
	public void setTable(javax.swing.JTable aTable) {
		javax.swing.JTable oldTable = table;
		if (oldTable == aTable)
			return;
		if (oldTable != null)
			oldTable.getSelectionModel().removeListSelectionListener((ListSelectionListener) this);
		this.table = aTable;
		if (aTable != null) {
			aTable.setModel(this);
			aTable.getSelectionModel().addListSelectionListener((ListSelectionListener) this);
		}
	}

	/*
	 * Listen for selection changes in the table. When a selection event is
	 * encountered, set the selectedRowObject to be the object selected in the
	 * table.
	 */

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false)
			setSelectedObjects();

		getTable().repaint();
	}
	public Vector getTableColumnWidths() {
		return tableColumnWidths;
	}
	public void setTableColumnWidths(Vector tableColumnWidths) {
		this.tableColumnWidths = tableColumnWidths;
	}
	public Vector getTableEditables() {
		return tableEditables;
	}
	public void setTableEditables(Vector tableEditables) {
		this.tableEditables = tableEditables;
	}
	public Vector getTableHeaderNames() {
		return tableHeaderNames;
	}
	public void setTableHeaderNames(Vector tableHeaderNames) {
		this.tableHeaderNames = tableHeaderNames;
	}
	public Vector getTableFieldNames() {
		return tableFieldNames;
	}
	public void setTableFieldNames(Vector tableFieldNames) {
		this.tableFieldNames = tableFieldNames;
	}
	public Vector getTableOrderByAliases() {
		return tableOrderByAliases;
	}
	public void setTableOrderByAliases(Vector tableOrderByAliases) {
		this.tableOrderByAliases = tableOrderByAliases;
	}
	/**
	 * @return the columnIdentifiers
	 */
	public Vector getColumnIdentifiers() {
		return columnIdentifiers;
	}
}