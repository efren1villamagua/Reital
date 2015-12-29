package efren.util;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.sql.Date;
import java.util.EventObject;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;

import efren.util.gui.combo.ObjectComboBox;
import efren.util.gui.text.TextDate;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListener;

public class DefaultCellEditor implements TableCellEditor, TreeCellEditor, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2515603752195950762L;

	protected EventListenerList listenerList = new EventListenerList();

	transient protected ChangeEvent changeEvent = null;

	protected JComponent editorComponent;

	protected EditorDelegate delegate;

	protected int clickCountToStart = 1;

	/**
	 * 
	 */
	protected class EditorDelegate implements ActionListener, ItemListener, Serializable, TextFieldExtListener {

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
		/**
		 * EVENTOS DEL OBJETO TexfFieldExt
		 */
		public void actionPerformed(EventObject arg0) {
			fireEditingStopped();
		}
		public void actionPerformedOnTextField(EventObject arg0) {
			fireEditingStopped();
		}
		public void field_keyReleased(EventObject arg0) {
		}
		public void focusGained(EventObject arg0) {
		}
		public void focusLost(EventObject arg0) {
			fireEditingStopped();
		}
		public void keyReleased(KeyEvent arg0) {
		}
		public void textDateMouseClicked(EventObject arg0) {
		}
		public void textFieldExtkeyReleased(EventObject arg0) {
		}
	}
	/**
	 * 
	 */
	public DefaultCellEditor(TextDate aTd) {
		
		this.editorComponent = aTd;
		this.clickCountToStart = 1;
		this.delegate = new EditorDelegate() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7907878815360736599L;

			public void setValue(Object unValor) {
				super.setValue(unValor);
				if (unValor == null) {
					((TextDate) editorComponent).setValue(null);
				} else {
					try {
						int anio = new Integer(unValor.toString().trim().substring(0, 4).trim()).intValue();
						int mes = new Integer(unValor.toString().trim().substring(5, 7).trim()).intValue() - 1;
						int dia = new Integer(unValor.toString().trim().substring(8).trim()).intValue();
						Date valueToSet = new CalendarManager(new java.util.GregorianCalendar(anio, mes, dia)).getSqlDate();
						((TextDate) editorComponent).setValue(valueToSet);
					} catch (Throwable t) {
						t.getMessage();
						try {
							((TextDate) editorComponent).setValue(new CalendarManager().getSqlDate());//fecha de hoy
						} catch (Throwable t1) {
							t1.getMessage();
						}
					}
				}
			}

			public Object getCellEditorValue() {
				return ((TextDate) editorComponent).getValue();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null)
					editorComponent.transferFocus();
				return true;
			}
		};
		((TextDate) editorComponent).addActionListener(delegate);
	}
	/**
	 * 
	 */
	public DefaultCellEditor(TextFieldExt unaCajaTexto) {
		this.editorComponent = unaCajaTexto;
		this.clickCountToStart = 1;
		this.delegate = new EditorDelegate() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6793932263827433775L;
			public void setValue(Object unValor) {
				super.setValue(unValor);
				if (unValor != null) {
					((TextFieldExt) editorComponent).setValue(unValor.toString());
				} else {
					((TextFieldExt) editorComponent).setValue("");
				}
			}

			public Object getCellEditorValue() {
				return ((TextFieldExt) editorComponent).getValue();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null) {
					editorComponent.transferFocus();
				}
				return true;
			}
		};
		((TextFieldExt) editorComponent).addActionListener(delegate);
		((TextFieldExt) editorComponent).addTextFieldExtListener(delegate);
		//((TextFieldExt) editorComponent).addFocusListener(delegate);
	}
/*
	public DefaultCellEditor(Object x) {

		// Try my best to do the right thing with x
		if (x instanceof JCheckBox) {
			this.editorComponent = (JCheckBox) x;
			this.delegate = new EditorDelegate() {
				public void setValue(Object x) {
					super.setValue(x);

					// Try my best to do the right thing with x
					if (x instanceof Boolean) {
						((JCheckBox) editorComponent).setSelected(((Boolean) x).booleanValue());
					} else if (x instanceof String) {
						Boolean b = new Boolean((String) x);
						((JCheckBox) editorComponent).setSelected(b.booleanValue());
					} else {
						((JCheckBox) editorComponent).setSelected(false);
					}
				}

				public Object getCellEditorValue() {
					return new Boolean(((JCheckBox) editorComponent).isSelected());
				}

				public boolean startCellEditing(EventObject anEvent) {
					// PENDING(alan)
					if (anEvent instanceof AWTEvent) {
						return true;
					}
					return false;
				}

				public boolean stopCellEditing() {
					if (editorComponent != null)
						editorComponent.transferFocus();
					return true;
				}
			};
			((JCheckBox) editorComponent).addActionListener(delegate);
		}
		if (x instanceof JComboBox) {
			this.editorComponent = (JComboBox) x;
			this.delegate = new EditorDelegate() {
				public void setValue(Object x) {
					super.setValue(x);
					((JComboBox) editorComponent).setSelectedItem(x);
				}

				public Object getCellEditorValue() {
					return ((JComboBox) editorComponent).getSelectedItem();
				}

				public boolean startCellEditing(EventObject anEvent) {
					if (anEvent instanceof AWTEvent) {
						return true;
					}
					return false;
				}

				public boolean stopCellEditing() {
					if (editorComponent != null)
						editorComponent.transferFocus();
					return true;
				}
			};
			((JComboBox) editorComponent).addItemListener(delegate);
		}
		if (x instanceof JLabel) {
			this.editorComponent = (JLabel) x;
			this.clickCountToStart = 2;
			this.delegate = new EditorDelegate() {
				public void setValue(Object x) {
					super.setValue(x);
					if (x != null)
						((JLabel) editorComponent).setText(x.toString());
					else
						((JLabel) editorComponent).setText("");
				}

				public Object getCellEditorValue() {
					return ((JLabel) editorComponent).getText();
				}

				public boolean startCellEditing(EventObject anEvent) {
					if (anEvent == null)
						editorComponent.requestFocus();
					return true;
				}

				public boolean stopCellEditing() {
					if (editorComponent != null)
						editorComponent.transferFocus();
					return true;
				}
			};
		}
		if (x instanceof JTextField) {
			this.editorComponent = (JTextField) x;
			this.clickCountToStart = 2;
			this.delegate = new EditorDelegate() {
				public void setValue(Object x) {
					super.setValue(x);
					if (x != null)
						((JTextField) editorComponent).setText(x.toString());
					else
						((JTextField) editorComponent).setText("");
				}

				public Object getCellEditorValue() {
					return ((JTextField) editorComponent).getText();
				}

				public boolean startCellEditing(EventObject anEvent) {
					if (anEvent == null)
						editorComponent.requestFocus();
					return true;
				}

				public boolean stopCellEditing() {
					if (editorComponent != null)
						editorComponent.transferFocus();
					return true;
				}
			};
			((JTextField) editorComponent).addActionListener(delegate);
		}
		if (x instanceof TextFieldExt) {
			this.editorComponent = (TextFieldExt) x;
			this.clickCountToStart = 2;
			this.delegate = new EditorDelegate() {
				public void setValue(Object x) {
					super.setValue(x);
					if (x != null)
						((TextFieldExt) editorComponent).setValue(x.toString());
					else
						((TextFieldExt) editorComponent).setValue("");
				}

				public Object getCellEditorValue() {
					return ((TextFieldExt) editorComponent).getValue();
				}

				public boolean startCellEditing(EventObject anEvent) {
					if (anEvent == null)
						editorComponent.requestFocus();
					return true;
				}

				public boolean stopCellEditing() {
					if (editorComponent != null)
						editorComponent.transferFocus();
					return true;
				}
			};
		}
	}
*/
	public DefaultCellEditor(JCheckBox x) {
		this.editorComponent = x;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);

				// Try my best to do the right thing with x
				if (x instanceof Boolean) {
					((JCheckBox) editorComponent).setSelected(((Boolean) x).booleanValue());
				} else if (x instanceof String) {
					Boolean b = new Boolean((String) x);
					((JCheckBox) editorComponent).setSelected(b.booleanValue());
				} else {
					((JCheckBox) editorComponent).setSelected(false);
				}
			}

			public Object getCellEditorValue() {
				return new Boolean(((JCheckBox) editorComponent).isSelected());
			}

			public boolean startCellEditing(EventObject anEvent) {
				// PENDING(alan)
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				return true;
			}
		};
		((JCheckBox) editorComponent).addActionListener(delegate);
	}
	public DefaultCellEditor(JRadioButton x) {
		this.editorComponent = x;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);

				// Try my best to do the right thing with x
				if (x instanceof Boolean) {
					((JRadioButton) editorComponent).setSelected(((Boolean) x).booleanValue());
				} else if (x instanceof String) {
					Boolean b = new Boolean((String) x);
					((JRadioButton) editorComponent).setSelected(b.booleanValue());
				} else {
					((JRadioButton) editorComponent).setSelected(false);
				}
			}

			public Object getCellEditorValue() {
				return new Boolean(((JRadioButton) editorComponent).isSelected());
			}

			public boolean startCellEditing(EventObject anEvent) {
				// PENDING(alan)
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				return true;
			}
		};
		((JRadioButton) editorComponent).addActionListener(delegate);
	}
	/**
	 * 
	 * @param x
	 */
	public DefaultCellEditor(JComboBox x) {
		this.editorComponent = x;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);
				((JComboBox) editorComponent).setSelectedItem(x);
			}

			public Object getCellEditorValue() {
				return ((JComboBox) editorComponent).getSelectedItem();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null)
					editorComponent.transferFocus();

				return true;
			}
		};
		((JComboBox) editorComponent).addItemListener(delegate);
	}
	/**
	 * 
	 * @param x
	 */
	public DefaultCellEditor(ObjectComboBox unCombo) {
		this.editorComponent = unCombo;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);
				((ObjectComboBox) editorComponent).setSelectedItem(x);
			}

			public Object getCellEditorValue() {
				return ((ObjectComboBox) editorComponent).getSelectedItem();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent instanceof AWTEvent) {
					return true;
				}
				return false;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null)
					editorComponent.transferFocus();
				return true;
			}
		};
		((ObjectComboBox) editorComponent).addItemListener(delegate);
		((ObjectComboBox) editorComponent).addActionListener(delegate);
	}
	/**
	 * 
	 */
	public DefaultCellEditor(JLabel x) {
		this.editorComponent = x;
		this.clickCountToStart = 1;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);
				if (x != null)
					((JLabel) editorComponent).setText(x.toString());
				else
					((JLabel) editorComponent).setText("");
			}

			public Object getCellEditorValue() {
				return ((JLabel) editorComponent).getText();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent == null) {
					editorComponent.requestFocus();
				}
				return true;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null)
					editorComponent.transferFocus();

				return true;
			}
		};
		// ((JLabel)editorComponent).addActionListener(delegate);
	}

	//
	// Constructors
	//
/*
	public DefaultCellEditor(JTextField x) {
		this.editorComponent = x;
		this.clickCountToStart = 1;
		this.delegate = new EditorDelegate() {
			public void setValue(Object x) {
				super.setValue(x);
				if (x != null)
					((JTextField) editorComponent).setText(x.toString());
				else
					((JTextField) editorComponent).setText("");
			}

			public Object getCellEditorValue() {
				return ((JTextField) editorComponent).getText();
			}

			public boolean startCellEditing(EventObject anEvent) {
				if (anEvent == null)
					editorComponent.requestFocus();
				return true;
			}

			public boolean stopCellEditing() {
				if (editorComponent != null)
					editorComponent.transferFocus();
				return true;
			}
		};
		((JTextField) editorComponent).addActionListener(delegate);
	}
*/
	//
	// Handle the event listener bookkeeping
	//
	public void addCellEditorListener(CellEditorListener l) {
		listenerList.add(CellEditorListener.class, l);
	}

	public void cancelCellEditing() {
		delegate.cancelCellEditing();
		fireEditingCanceled();
	}

	/*
	 * Notify all listeners that have registered interest for notification on
	 * this event type. The event instance is lazily created using the
	 * parameters passed into the fire method.
	 * 
	 * @see EventListenerList
	 */
	protected void fireEditingCanceled() {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CellEditorListener.class) {
				// Lazily create the event:
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
			}
		}
	}

	/*
	 * Notify all listeners that have registered interest for notification on
	 * this event type. The event instance is lazily created using the
	 * parameters passed into the fire method.
	 * 
	 * @see EventListenerList
	 */
	protected void fireEditingStopped() {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CellEditorListener.class) {
				// Lazily create the event:
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
			}
		}
	}

	//
	// Implementing the CellEditor Interface
	//

	public Object getCellEditorValue() {
		return delegate.getCellEditorValue();
	}

	/**
	 * clickCountToStart controls the number of clicks required to start editing
	 * if the event passed to isCellEditable() or startCellEditing() is a
	 * MouseEvent. For example, by default the clickCountToStart for a
	 * JTextField is set to 2, so in a JTable the user will need to double click
	 * to begin editing a cell.
	 */
	public int getClickCountToStart() {
		return clickCountToStart;
	}

	public Component getComponent() {
		return editorComponent;
	}

	//
	// Implementing the CellEditor Interface
	//

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		// Modify component colors to reflect selection state
		// PENDING(alan)
		/*
		 * if (isSelected) { component.setBackground(selectedBackgroundColor);
		 * component.setForeground(selectedForegroundColor); } else {
		 * component.setBackground(backgroundColor);
		 * component.setForeground(foregroundColor); }
		 */

		delegate.setValue(value);
		return editorComponent;
	}

	//
	// Implementing the TreeCellEditor Interface
	//

	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
		String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, false);

		delegate.setValue(stringValue);
		return editorComponent;
	}

	public boolean isCellEditable(EventObject anEvent) {
		if (anEvent instanceof MouseEvent) {
			if (((MouseEvent) anEvent).getClickCount() < clickCountToStart)
				return false;
		}
		return delegate.isCellEditable(anEvent);
	}

	public void removeCellEditorListener(CellEditorListener l) {
		listenerList.remove(CellEditorListener.class, l);
	}

	//
	// Modifying
	//

	public void setClickCountToStart(int count) {
		clickCountToStart = count;
	}

	public boolean shouldSelectCell(EventObject anEvent) {
		boolean retValue = true;

		if (this.isCellEditable(anEvent)) {
			if (anEvent == null || ((MouseEvent) anEvent).getClickCount() >= clickCountToStart)
				retValue = delegate.startCellEditing(anEvent);
		}

		// By default we want the cell the be selected so
		// we return true
		return retValue;
	}

	public boolean stopCellEditing() {
		boolean stopped = delegate.stopCellEditing();

		if (stopped) {
			fireEditingStopped();
		}

		return stopped;
	}
}
