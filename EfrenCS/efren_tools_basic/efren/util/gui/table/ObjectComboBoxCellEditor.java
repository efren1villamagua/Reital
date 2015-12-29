package efren.util.gui.table;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;

import efren.util.gui.combo.ObjectComboBox;

public class ObjectComboBoxCellEditor implements TableCellEditor, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3017636663231605087L;
	protected EventListenerList listenerList = new EventListenerList();
	transient protected ChangeEvent changeEvent = null;
	//protected ObjectComboBox editorComponent;
	//protected EditorDelegate delegate;
	protected int clickCountToStart = 1;
	
	private Vector<ObjectComboBox> editores = null;
	//private Vector<ObjectComboBox> renderers = null;
	private Vector<EditorDelegate> delegadosEditores = null;
	//private Vector<EditorDelegate> delegadosRendereres = null;
	
	private int editingRow;
	
	/**
	 * 
	 */
	protected class EditorDelegate implements ActionListener, ItemListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3004508742694378362L;
		protected Object value;

		public Object getCellEditorValue() {
			return value;
		}

		public void setValue(Object x) {
			this.value = x;
		}

		public boolean isCellEditable(EventObject anEvent) {
			return true;
		}

		public boolean startCellEditing(EventObject anEvent) {
			return true;
		}

		public boolean stopCellEditing() {
			return true;
		}

		public void cancelCellEditing() {
		}

		/**
		 * MANEJO DE EVENTOS
		 */ 
		public void actionPerformed(ActionEvent e) {
			fireEditingStopped();
		}
		public void itemStateChanged(ItemEvent e) {
			fireEditingStopped();
		}
	}
	/**
	 * 
	 */
	public ObjectComboBoxCellEditor() {
		super();
		this.editores = new Vector<ObjectComboBox>();
		//this.renderers = new Vector<ObjectComboBox>();
		this.delegadosEditores = new Vector<EditorDelegate>();
		//this.delegadosRendereres = new Vector<EditorDelegate>();
	}
	/**
	 * 
	 */
	public void addEditor(ObjectComboBox unCombo) {

		final ObjectComboBox tempCombo = unCombo;
		EditorDelegate delegado = new EditorDelegate() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3598916532662028808L;
			public void setValue(Object aValue) {
				super.setValue(aValue);
				tempCombo.setSelectedItem(aValue);//TODO OJO
			}
			public Object getCellEditorValue() {
				return tempCombo.getSelectedItem();
			}
			public boolean startCellEditing(EventObject anEvent) {
				if (tempCombo != null) {
					tempCombo.requestFocus();
				}
				return true;
			}
			public boolean stopCellEditing() {
				if (tempCombo != null) {
					tempCombo.transferFocus();
				}
				return true;
			}
		};
		unCombo.addItemListener(delegado);
		unCombo.addActionListener(delegado);
		this.editores.addElement(unCombo);
		this.delegadosEditores.addElement(delegado);
		
	}
	/**
	 * 
	 */
	public void removeEditorAt(int index) {

		this.editores.removeElementAt(index);
		this.delegadosEditores.removeElementAt(index);
	}
	/**
	 * 
	 */
/*	
	public void addRenderer(ObjectComboBox unCombo) {
		this.renderers.addElement(unCombo);
	}
*/	
	/**
	 * 
	 */
	public ObjectComboBox getEditorAt(int index) {
		return this.editores.elementAt(index);
	}
	/**
	 * 
	 */
/*	
	public ObjectComboBox getRendererAt(int index) {
		return this.renderers.elementAt(index);
	}
*/	
	/**
	 * 
	 */
	public void addCellEditorListener(CellEditorListener l) {
		listenerList.add(CellEditorListener.class, l);
	}
	/**
	 * 
	 */
	public void cancelCellEditing() {
		//delegate.cancelCellEditing();
		fireEditingCanceled();
	}
	/**
	 * 
	 */
	protected void fireEditingCanceled() {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CellEditorListener.class) {
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
			}
		}
	}
	/**
	 * 
	 */
	protected void fireEditingStopped() {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CellEditorListener.class) {
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
			}
		}
	}
	/**
	 * 
	 */
	public Object getCellEditorValue() {
		try {
			return this.editores.elementAt(this.editingRow).getSelectedItem();	
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 * 
	 */
	public int getClickCountToStart() {
		return clickCountToStart;
	}
	/**
	 * 
	 */
/*	
	public Component getComponent() {
		return editorComponent;
	}
*/	
	/**
	 * 
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		try {
			this.editingRow = row;
			this.delegadosEditores.elementAt(row).setValue(value);
			ObjectComboBox editor = this.editores.elementAt(row);
			editor.setSelectedItem(value);//TODO OJO
			return editor;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 * 
	 */
/*	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		try {
			this.editingRow = row;
			//this.delegados.elementAt(row).setValue(value);
			ObjectComboBox renderer = this.renderers.elementAt(row);
			renderer.setSelectedItem(value);//TODO OJO
			if (isSelected) {
				renderer.setBackground(table.getSelectionBackground());
			} else {
				renderer.setBackground(Color.WHITE);
			}
			if (hasFocus) {
				renderer.setFont(FontManager.currentSystemBoldFont());
			} else {
				renderer.setFont(FontManager.currentSystemPlainFont());
			}
			return renderer;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
*/	
	/**
	 * 
	 */
	public boolean isCellEditable(EventObject anEvent) {
		if (anEvent instanceof MouseEvent) {
			if (((MouseEvent) anEvent).getClickCount() < clickCountToStart)
				return false;
		}
		//return delegate.isCellEditable(anEvent);
		return true;
	}
	/**
	 * 
	 */
	public void removeCellEditorListener(CellEditorListener l) {
		listenerList.remove(CellEditorListener.class, l);
	}
	/**
	 * 
	 */
	public void setClickCountToStart(int count) {
		clickCountToStart = count;
	}
	/**
	 * 
	 */
	public boolean shouldSelectCell(EventObject anEvent) {
/*		
		boolean retValue = true;
		if (this.isCellEditable(anEvent)) {
			if (anEvent == null || ((MouseEvent) anEvent).getClickCount() >= clickCountToStart)
				retValue = delegate.startCellEditing(anEvent);
		}
		return retValue;
*/
		return true;
	}
	/**
	 * 
	 */
	public boolean stopCellEditing() {
/*		
		boolean stopped = delegate.stopCellEditing();
		if (stopped) {
			fireEditingStopped();
		}
		return stopped;
*/
		fireEditingStopped();
		return true;
	}
}
