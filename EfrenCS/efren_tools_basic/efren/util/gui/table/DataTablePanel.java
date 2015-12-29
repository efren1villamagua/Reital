package efren.util.gui.table;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import efren.seguridades.gui.SystemView;
import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.Bar02Panel;
import efren.util.gui.bars.Bar02PanelListener;
import efren.util.gui.bars.BarraEstadosPanel;

public class DataTablePanel extends JPanel implements Bar02PanelListener, KeyListener, MouseListener, PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 2316353894025640117L;
	/**
	 *
	 */
	private BarraEstadosPanel ivjBarraEstadosPanel = null;
	protected transient PropertyChangeSupport propertyChange;
	private boolean enabled = true;
	private TableModelExt tableModelExt = null;
	private String fieldSelectedObjectFromDoubleClick = new String();
	private Object fieldRightClicked = new Object();
	private int fieldOffset = 0;
	protected transient DataTablePanelListener fieldDataTablePanelListenerEventMulticaster = null; // @jve:decl-index=0:
	private String orderBy_alias;
	private Bar02Panel ivjBar02Panel1 = null;
	private TableExt tableExt = null;
	private JScrollPane ivjJScrollPane = null;
	private boolean partialData = false;
	private Vector columnsDefinition = null;  //  @jve:decl-index=0:
	private JButton jButtonImprimir = null;
	private JButton jButtonBuscar = null;
	private JButton jButtonLimpiar = null;
	private JToolBar jToolBar = null;
	private JToolBar jToolBar1 = null;
	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public DataTablePanel() {
		super();
		initialize();
	}
	/**
	 *
	 *
	 */
	public void actualizarBarraEstados() {
		int elementos = 0;
		int seleccionados = 0;
		try {
			elementos = getTableModelExt().getRowCount();
			seleccionados = getTableModelExt().getSelectedObjects().size();
		} catch (Throwable t) {
			// si hay problemas en el tableModel la cantidad de elementos se
			// queda en 0
			t.getMessage();
		}
		int realElementos = elementos - getOffset();
		if (isPartialData()) {
			getBarraEstadosPanel().setText("Mostrados " + realElementos + " ::: Seleccionados " + seleccionados);
		} else {
			getBarraEstadosPanel().setText("Total " + realElementos + " ::: Seleccionados " + seleccionados);
		}
	}

	/**
	 *
	 * @param object
	 */
	public void add(Object object) {
		addRow(object);
	}

	/**
	 *
	 */
	public void add(Vector datos) {
		for (int i = 0; i < datos.size(); i++) {
			addRow(datos.elementAt(i));
		}
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 *
	 * @param object
	 */
	public void addRow(Object object) {

		if (object == null)
			return;

		getTableModelExt().add(object);

		actualizarBarraEstados();
	}

	public void refreshData() {
		getTableModelExt().refreshData();
		//getTable().repaint();
		//getTable().update(getGraphics());
	}
	/**
	 *
	 */
	public void setValueAt(Object aValue, int row, int column) {
		getTableModel().setValueAt(aValue, row, column);
	}
	/**
	 *
	 * @param newListener
	 *            DataTablePanelListener
	 */
	public void addDataTablePanelListener(DataTablePanelListener newListener) {
		fieldDataTablePanelListenerEventMulticaster = DataTablePanelListenerEventMulticaster.add(fieldDataTablePanelListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * Method to handle events for the Bar02PanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void button00ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBar02Panel1())
			connEtoC23(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the Bar02PanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void button01ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBar02Panel1())
			connEtoC24(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the Bar02PanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void button02ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBar02Panel1())
			connEtoC25(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the Bar02PanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void button03ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBar02Panel1())
			connEtoC26(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the Bar02PanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void button10ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBar02Panel1())
			connEtoC22(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void cancelarClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	public void clearData() {
		getTableModelExt().removeAll();
	}

	public void clearSelection() {
		getTableExt().clearSelection();
	}

	/**
	 * connEtoC1:
	 * (BarraAceptarCancelarPanelImprimir.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject)
	 * --> DataTablePanel.printTable()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.prePrintTable();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC10: (Bar02Panel1.totalVisible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC10(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarTotalVisible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC11: (Bar02Panel1.totalDisabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC11(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarTotalDisabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC12: (Bar02Panel1.button00Enabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC12(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton00Enabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC13: (Bar02Panel1.button10Enabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC13(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton10Enabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC14: (Bar02Panel1.button01Enabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC14(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton01Enabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC15: (Bar02Panel1.button02Enabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC15(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton02Enabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC16: (Bar02Panel1.button03Enabled -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC16(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton03Enabled", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC17: (Bar02Panel1.button00Visible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC17(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton00Visible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC18: (Bar02Panel1.button10Visible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC18(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton10Visible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC19: (Bar02Panel1.button02Visible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC19(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton02Visible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2:
	 * (Bar02Panel.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject)
	 * --> DataTablePanel.fireBuscarPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireBuscarPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC20: (Bar02Panel1.button01Visible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC20(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton01Visible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC21: (Bar02Panel1.button03Visible -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC21(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton03Visible", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC22:
	 * (Bar02Panel1.bar02Panel.button10ActionPerformed(java.util.EventObject)
	 * -->
	 * DataTablePanel.fireOpcionesBarButton10ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC22(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireOpcionesBarButton10ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC23:
	 * (Bar02Panel1.bar02Panel.button00ActionPerformed(java.util.EventObject)
	 * -->
	 * DataTablePanel.fireOpcionesBarButton00ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC23(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireOpcionesBarButton00ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC24:
	 * (Bar02Panel1.bar02Panel.button01ActionPerformed(java.util.EventObject)
	 * -->
	 * DataTablePanel.fireOpcionesBarButton01ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC24(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireOpcionesBarButton01ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC25:
	 * (Bar02Panel1.bar02Panel.button02ActionPerformed(java.util.EventObject)
	 * -->
	 * DataTablePanel.fireOpcionesBarButton02ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC25(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireOpcionesBarButton02ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC26:
	 * (Bar02Panel1.bar02Panel.button03ActionPerformed(java.util.EventObject)
	 * -->
	 * DataTablePanel.fireOpcionesBarButton03ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC26(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireOpcionesBarButton03ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC27: (BarraEstadosPanel.textFont -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* AVISO: ESTE MÉTODO SE REGENERARÁ. */
	private void connEtoC27(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("statusFont", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC29: (DataTablePanel.key.keyPressed(java.awt.event.KeyEvent) -->
	 * DataTablePanel.manageKeyPressed(Ljava.awt.event.KeyEvent;)V)
	 *
	 * @param arg1
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC29(java.awt.event.KeyEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageKeyPressed(arg1);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC30: ( (TableModelExt,selectedObject -->
	 * Bar02Panel1,habilitarDesabilitarBotones(Ljava.lang.Object;)V).normalResult
	 * --> DataTablePanel.manualyFireSelectedObject()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC30() {
		try {
			// user code begin {1}
			// user code end
			this.manualyFireSelectedObject();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC31: ( (TableModelExt,selectedObject -->
	 * Bar02Panel1,habilitarDesabilitarBotones(Ljava.lang.Object;)V).normalResult
	 * --> DataTablePanel.actualizarBarraEstados()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC31() {
		try {
			// user code begin {1}
			// user code end
			this.actualizarBarraEstados();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (Bar02Panel1.button00Text -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton00Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5: (Bar02Panel1.button01Text -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton01Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC6: (Bar02Panel1.button02Text -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton02Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC7: (Bar02Panel1.button03Text -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC7(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton03Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC8: (Bar02Panel1.button10Text -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC8(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("opcionesBarButton10Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC9: (Bar02Panel1.permitirEliminacionMasiva -->
	 * DataTablePanel.firePropertyChange(LString;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC9(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("permitirEliminacionMasiva", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM1: (TableModelExt.selectedObject -->
	 * Bar02Panel1.habilitarDesabilitarBotones(Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(java.beans.PropertyChangeEvent arg1) {
		if (getBar02Panel1().getPermitirEliminacionMasiva()) {
			if (getTableModelExt().getSelectedObjects() != null && getTableModelExt().getSelectedObjects().size() > 0)
				getBar02Panel1().habilitarDesabilitarBotones(getTableModelExt().getSelectedObjects().size(), true);
			else
				getBar02Panel1().habilitarDesabilitarBotones(0, true);
		} else {
			getBar02Panel1().habilitarDesabilitarBotones(getTableModelExt().getSelectedObjects().size(), false);
		}
		connEtoC31();
		connEtoC30();
	}

	/**
	 * connPtoP1SetTarget: (ScrollPaneTable.this <--> TableModelExt.table)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connPtoP1SetTarget() {
		/* Establecer el destino del origen */
		try {
			getTableModelExt().setTable(getTableExt());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connPtoP2SetTarget: (TableModelExt.this <--> ScrollPaneTable.model)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connPtoP2SetTarget() {
		/* Establecer el destino del origen */
		try {
			getTableExt().setModel(getTableModelExt());
			// getTableExt().createDefaultColumnsFromModel();
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public void deselect() {
		getTableExt().clearSelection();
	}

	public Vector elements() {
		return getTableModelExt().elements();
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireBuscarPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.buscarPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireComboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.comboBoxORDERBYItemSelected(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireOpcionesBarButton00ActionPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.opcionesBarButton00ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireOpcionesBarButton01ActionPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.opcionesBarButton01ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireOpcionesBarButton02ActionPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.opcionesBarButton02ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireOpcionesBarButton03ActionPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.opcionesBarButton03ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireOpcionesBarButton10ActionPerformed(java.util.EventObject newEvent) {
		if (fieldDataTablePanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldDataTablePanelListenerEventMulticaster.opcionesBarButton10ActionPerformed(newEvent);
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 *
	 * @param propertyName
	 *            String
	 * @param oldValue
	 *            java.lang.Object
	 * @param newValue
	 *            java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	public void forceFireBuscarPerformed() {
		try {
			this.fireBuscarPerformed(new java.util.EventObject(this));
		} catch (java.lang.Throwable ivjExc) {
			ivjExc.getMessage();
		}
	}

	/**
	 * Return the Bar02Panel2 property value.
	 *
	 * @return efren.abm.beans.Bar02Panel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private Bar02Panel getBar02Panel1() {
		if (ivjBar02Panel1 == null) {
			try {
				ivjBar02Panel1 = new efren.util.gui.bars.Bar02Panel();
				ivjBar02Panel1.setName("Bar02Panel1");
				ivjBar02Panel1.setButton01Enabled(false);
				ivjBar02Panel1.setButton03Enabled(false);
				ivjBar02Panel1.setButton02Enabled(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBar02Panel1;
	}
	/**
	 * Return the BarraEstadosPanel property value.
	 *
	 * @return com.truesoft.abm.beans.BarraEstadosPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private BarraEstadosPanel getBarraEstadosPanel() {
		if (ivjBarraEstadosPanel == null) {
			try {
				ivjBarraEstadosPanel = new efren.util.gui.bars.BarraEstadosPanel();
				ivjBarraEstadosPanel.setName("BarraEstadosPanel");
				ivjBarraEstadosPanel.setText("Total 0 ::: Seleccionados 0");
				ivjBarraEstadosPanel.setTextForeground(new java.awt.Color(72, 61, 139));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarraEstadosPanel;
	}

	/**
	 * Method generated to support the promotion of the buscarButtonText
	 * attribute.
	 *
	 * @return String
	 */
	public String getBuscarButtonText() {
		return getJButtonBuscar().getText();
	}

	/**
	 * Method generated to support the promotion of the buscarButtonVisible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getBuscarButtonVisible() {
		return getJButtonBuscar().isVisible();
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Method generated to support the promotion of the imprimirButtonVisible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getImprimirButtonVisible() {
		return getJButtonImprimir().isVisible();
	}

	/**
	 * Return the JScrollPane2 property value.
	 *
	 * @return javax.swing.JScrollPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JScrollPane getJScrollPane() {
		if (ivjJScrollPane == null) {
			try {
				ivjJScrollPane = new javax.swing.JScrollPane();
				ivjJScrollPane.setName("JScrollPane");
				getJScrollPane().setViewportView(getTableExt());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJScrollPane;
	}

	/**
	 * Gets the offset property (int) value.
	 *
	 * @return The offset property value.
	 * @see #setOffset
	 */
	public int getOffset() {
		return fieldOffset;
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton00Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton00Enabled() {
		return getBar02Panel1().getButton00Enabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton00Text
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarButton00Text() {
		return getBar02Panel1().getButton00Text();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton00Visible attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton00Visible() {
		return getBar02Panel1().getButton00Visible();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton01Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton01Enabled() {
		return getBar02Panel1().getButton01Enabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton01Text
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarButton01Text() {
		return getBar02Panel1().getButton01Text();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton01Visible attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton01Visible() {
		return getBar02Panel1().getButton01Visible();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton02Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton02Enabled() {
		return getBar02Panel1().getButton02Enabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton02Text
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarButton02Text() {
		return getBar02Panel1().getButton02Text();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton02Visible attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton02Visible() {
		return getBar02Panel1().getButton02Visible();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton03Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton03Enabled() {
		return getBar02Panel1().getButton03Enabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton03Text
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarButton03Text() {
		return getBar02Panel1().getButton03Text();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton03Visible attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton03Visible() {
		return getBar02Panel1().getButton03Visible();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton10Enabled attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton10Enabled() {
		return getBar02Panel1().getButton10Enabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton10Text
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarButton10Text() {
		return getBar02Panel1().getButton10Text();
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton10Visible attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarButton10Visible() {
		return getBar02Panel1().getButton10Visible();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarToolTipText
	 * attribute.
	 *
	 * @return String
	 */
	public String getOpcionesBarToolTipText() {
		return getBar02Panel1().getToolTipText();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarTotalDisabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarTotalDisabled() {
		return getBar02Panel1().getTotalDisabled();
	}

	/**
	 * Method generated to support the promotion of the opcionesBarTotalVisible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getOpcionesBarTotalVisible() {
		return getBar02Panel1().getTotalVisible();
	}

	/**
	 * Insert the method's description here. Creation date: (17/12/2003
	 * 22:32:19)
	 *
	 * @return String
	 */
	public String getOrderBy_alias() {
		return orderBy_alias;
	}

	/**
	 * Method generated to support the promotion of the
	 * permitirEliminacionMasiva attribute.
	 *
	 * @return boolean
	 */
	public boolean getPermitirEliminacionMasiva() {
		return getBar02Panel1().getPermitirEliminacionMasiva();
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return java.beans.PropertyChangeSupport
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Gets the rightClicked property (java.lang.Object) value.
	 *
	 * @return The rightClicked property value.
	 * @see #setRightClicked
	 */
	public Object getRightClicked() {
		return fieldRightClicked;
	}

	/**
	 * Method generated to support the promotion of the scrollPane attribute.
	 *
	 * @return javax.swing.JScrollPane
	 */
	public javax.swing.JScrollPane getScrollPane() {
		return getJScrollPane();
	}

	private TableExt getTableExt() {
		if (tableExt == null) {
			tableExt = new TableExt();
			tableExt.setName("TableExt");
			getJScrollPane().setColumnHeaderView(tableExt.getTableHeader());
			tableExt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableExt.setPreferredSize(new java.awt.Dimension(486, 160));
			tableExt.setBounds(0, 0, 486, 160);
//			tableExt.setFont(new Font("Arial", Font.PLAIN, 9));
			tableExt.setPreferredSize(null);
		}
		return tableExt;
	}

	public Object getSelectedObject() {
		return getTableModelExt().getSelectedObject();
	}

	/**
	 * Gets the selectedObjectFromDoubleClick property (String) value.
	 *
	 * @return The selectedObjectFromDoubleClick property value.
	 * @see #setSelectedObjectFromDoubleClick
	 */
	public String getSelectedObjectFromDoubleClick() {
		return fieldSelectedObjectFromDoubleClick;
	}

	public Vector getSelectedObjects() {
		return getTableModelExt().getSelectedObjects();
	}

	public int getSelectedRow() {
		return getTable().getSelectedRow();
	}

	public int[] getSelectedRows() {
		return getTable().getSelectedRows();
	}

	/**
	 * Método generado para soportar la promoción del atributo statusFont.
	 *
	 * @return Font
	 */
	public Font getStatusFont() {
		return getBarraEstadosPanel().getTextFont();
	}

	/**
	 * Return the TableModelExt property value.
	 *
	 * @return efren.util.TableModelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.table.TableModelExt getTableModelExt() {
		if (tableModelExt == null) {
			try {
				tableModelExt = new efren.util.gui.table.TableModelExt();
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return tableModelExt;
	}

	public TableExt getTable() {
		return getTableExt();
	}

	/**
	 * Method generated to support the promotion of the tableModel attribute.
	 *
	 * @return efren.util.StVapTableModel
	 */
	public TableModelExt getTableModel() {
		return getTableModelExt();
	}

	/**
	 * Method generated to support the promotion of the tableRowsFont attribute.
	 *
	 * @return Font
	 */
	public Font getTableRowsFont() {
		return getTableExt().getFont();
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		getTableModelExt().addPropertyChangeListener(this);
		getTableExt().addMouseListener(this);
		this.addKeyListener(this);
		getBar02Panel1().addPropertyChangeListener(this);
		getBar02Panel1().addBar02PanelListener(this);
		getTableModelExt().addPropertyChangeListener(this);
		getBarraEstadosPanel().addPropertyChangeListener(this);
		connPtoP2SetTarget();
		connPtoP1SetTarget();
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		// user code begin {1}
		// user code end
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.NONE;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.weightx = 0.0;
		gridBagConstraints2.gridx = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.NONE;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.weightx = 0.0;
		gridBagConstraints1.gridx = 4;
		setName("DataTablePanel");
		setLayout(new java.awt.GridBagLayout());
		setBackground(new java.awt.Color(181, 183, 154));
		setSize(489, 203);

		java.awt.GridBagConstraints constraintsBarraEstadosPanel = new java.awt.GridBagConstraints();
		constraintsBarraEstadosPanel.gridx = 2;
		constraintsBarraEstadosPanel.gridy = 0;
		constraintsBarraEstadosPanel.fill = GridBagConstraints.BOTH;
		constraintsBarraEstadosPanel.weighty = 0.0D;
		constraintsBarraEstadosPanel.weightx = 1.0;
		java.awt.GridBagConstraints constraintsJScrollPane = new java.awt.GridBagConstraints();
		constraintsJScrollPane.gridx = 0;
		constraintsJScrollPane.gridy = 2;
		constraintsJScrollPane.gridwidth = 5;
		constraintsJScrollPane.fill = java.awt.GridBagConstraints.BOTH;
		constraintsJScrollPane.weightx = 1.0;
		constraintsJScrollPane.weighty = 1.0;
		java.awt.GridBagConstraints constraintsBar02Panel1 = new java.awt.GridBagConstraints();
		constraintsBar02Panel1.gridx = 0;
		constraintsBar02Panel1.gridy = 3;
		constraintsBar02Panel1.gridwidth = 5;
		constraintsBar02Panel1.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsBar02Panel1.weightx = 1.0;
		getTableExt().setFont(efren.util.FontManager.currentSystemPlainFont());
		this.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
		this.add(getJScrollPane(), constraintsJScrollPane);
		this.add(getBar02Panel1(), constraintsBar02Panel1);
		this.add(getBarraEstadosPanel(), constraintsBarraEstadosPanel);
		this.add(getJToolBar(), gridBagConstraints1);
		this.add(getJToolBar1(), gridBagConstraints2);
		this.getTableExt().setContainerPanel(this);

		try {
			initConnections();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void insertRowAt(int index, Object object) {

		if (object == null)
			return;

		getTableModelExt().insert(index, object);

		actualizarBarraEstados();
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 *
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyPressed(java.awt.event.KeyEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == this)
			connEtoC29(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 *
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(java.awt.event.KeyEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the KeyListener interface.
	 *
	 * @param e
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyTyped(java.awt.event.KeyEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	private void manageKeyPressed(java.awt.event.KeyEvent arg1) {
		try {
			if (arg1.getKeyCode() == java.awt.event.KeyEvent.VK_F5 && getBuscarButtonVisible()) {
				this.fireBuscarPerformed(new java.util.EventObject(this));
			}
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	private void manualyFireSelectedObject() {

		firePropertyChange("selectedObject", "oldValue", "newValue");
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {

		if (e.getSource() instanceof TableExt) {

			if (e.getClickCount() > 1 && getSelectedObject() != null)
				firePropertyChange("selectedObjectFromDoubleClick", "oldValue", "newValue");

			if (e.getClickCount() == 1 && e.getModifiers() == java.awt.event.MouseEvent.BUTTON3_MASK)
				firePropertyChange("rightClicked", "oldValue",

				e.getX() + "_" + (e.getY() - new java.math.BigDecimal(this.getJScrollPane().getViewport().getViewRect().getY()).intValue()));
		}
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	private void prePrintTable() {
		try {
			Class.forName("inetsoft.report.StyleSheet");
			printTable();
		} catch (ClassNotFoundException ce) {
			ce.getMessage();
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "No está cargado el paquete de reportes");
		} catch (Throwable t) {
			t.getMessage();
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, t.getMessage());
		}
	}

	private void printTable() {

		if (getTableModelExt().getRowCount() == 0) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ No hay datos en la tabla para imprimir !");
			return;
		}

		DataTableReporterView window = new DataTableReporterView();
		window.setTable(getTableExt());
		try {
			if (SystemProperties.INSTITUCION_NOMBRE != null) {
				window.setTitulo1(SystemProperties.INSTITUCION_NOMBRE);
			} else {
				window.setTitulo1(window.getTitle());
			}
			window.setTitulo2(((javax.swing.JInternalFrame) this.getParent().getParent().getParent().getParent()).getTitle());
		} catch (Throwable t) {
			t.getMessage();
		}
		try {
			window.setTitle(((javax.swing.JInternalFrame) this.getParent().getParent().getParent().getParent()).getTitle() + " ::: "+window.getTitle());
		} catch (Throwable t) {
			t.getMessage();
		}
		WindowManager.centerWindowOnThis2(SystemView.singleton(), window);
		window.setVisible(true);
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 *
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button10Text")))
			connEtoC8(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button00Text")))
			connEtoC4(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button10Visible")))
			connEtoC18(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button03Text")))
			connEtoC7(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button01Enabled")))
			connEtoC14(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button00Visible")))
			connEtoC17(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button03Visible")))
			connEtoC21(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button02Text")))
			connEtoC6(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("totalVisible")))
			connEtoC10(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button10Enabled")))
			connEtoC13(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button03Enabled")))
			connEtoC16(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button01Visible")))
			connEtoC20(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button01Text")))
			connEtoC5(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("permitirEliminacionMasiva")))
			connEtoC9(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button00Enabled")))
			connEtoC12(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("totalDisabled")))
			connEtoC11(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button02Enabled")))
			connEtoC15(evt);
		if (evt.getSource() == getBar02Panel1() && (evt.getPropertyName().equals("button02Visible")))
			connEtoC19(evt);
		if (evt.getSource() == getTableModelExt() && (evt.getPropertyName().equals("selectedObject")))
			connEtoM1(evt);
		if (evt.getSource() == getBarraEstadosPanel() && (evt.getPropertyName().equals("textFont")))
			connEtoC27(evt);
	}

	public void remove(Object object) {
		removeRow(object);
	}
	public void removeAll() {
		this.removeAllRows();
	}

	public void removeAllRows() {

		// getTableModelExt().doClear();

		getTableModelExt().removeAll();
		actualizarBarraEstados();
		clearSelection();

		this.repaint();

	}

	public void removeAt(int index) {
		removeRowAt(index);
	}

	public void removeRow(Object object) {

		if (object == null)
			return;

		getTableModelExt().remove(object);

		actualizarBarraEstados();

	}

	public void removeRowAt(int index) {

		if (index < 0)
			return;

		getTableModelExt().removeRow(index);

		actualizarBarraEstados();

		this.repaint();

	}

	public void removeSelectedRows() {

		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar los registros seleccionados ?", "Seleccione una opción",
				efren.util.gui.dialogs.InfoView.YES_NO_OPTION) != 0)
			return;

		Vector selectedObjects = getSelectedObjects();

		for (int i = 0; i < selectedObjects.size(); i++) {
			removeRow(selectedObjects.elementAt(i));
		}
	}

	/**
	 *
	 * @param newListener
	 *            DataTablePanelListener
	 */
	public void removeDataTablePanelListener(DataTablePanelListener newListener) {
		fieldDataTablePanelListenerEventMulticaster = DataTablePanelListenerEventMulticaster.remove(fieldDataTablePanelListenerEventMulticaster, newListener);
		return;
	}

	public void selectAllRows() {
		getTableExt().selectAll();
	}

	public void selectRows(int fromIndex, int toIndex) {
		getTableExt().setRowSelectionInterval(fromIndex, toIndex);
	}

	public void addSelectedRows(int fromIndex, int toIndex) {
		getTableExt().addRowSelectionInterval(fromIndex, toIndex);
	}

	public void setBackground(java.awt.Color c) {
		// no hacemos nada
		// super.setBackground(c);

		// getJScrollPane().setBackground(java.awt.Color.white);
		// getTableExt().setBackground(java.awt.Color.white);
		/*
		 * getBarraEstadosPanel().setBackground(c);
		 * getJButtonImprimir().setBackground(c);
		 * getJScrollPane().setBackground(c); getTableExt().setBackground(c);
		 */
	}

	/**
	 * Method generated to support the promotion of the buscarButtonText
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setBuscarButtonText(String arg1) {
		getJButtonBuscar().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the buscarButtonVisible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setBuscarButtonVisible(boolean arg1) {
		getJButtonBuscar().setVisible(arg1);
	}

	public void setLimpiarButtonText(String arg1) {
		getJButtonLimpiar().setText(arg1);
	}
	public void setLimpiarButtonVisible(boolean arg1) {
		getJButtonLimpiar().setVisible(arg1);
	}
	/**
	 *
	 * @param columnIds
	 * @throws ClassNotFoundException
	 */
	public void setColumnsDefinition(Class entityClass, Vector columnsDefinition) {
		//...
		Vector oldValue = getColumnsDefinition();
		this.columnsDefinition = columnsDefinition;
		firePropertyChange("columnsDefinition", oldValue, this.columnsDefinition);
		//...
		try {
			//Class rowClass = (Class) columnsDefinition.elementAt(0);
			//getTableModelExt().setElementClass(rowClass);
			getTableModelExt().setElementClass(entityClass);
		} catch (Exception e) {
			e.getMessage();
		}
		// ...
		if (columnsDefinition == null || columnsDefinition.size() == 0) {
			return;
		}
		//...
		Vector<String> headerNames = new Vector<String>();
		Vector<Integer> columnWidths = new Vector<Integer>();
		Vector<String> fieldNames = new Vector<String>();
		Vector<Boolean> editables = new Vector<Boolean>();
		Vector<String> orderBy_aliases = new Vector<String>();

		DataTableColumn dtc;

		for (int i = 0; i < columnsDefinition.size(); i++) {

			dtc = (DataTableColumn) columnsDefinition.elementAt(i);

			headerNames.addElement(dtc.getHeaderName());
			columnWidths.addElement(new Integer(dtc.getWidth()));
			fieldNames.addElement(dtc.getFieldName());
			editables.addElement(new Boolean(dtc.isEditable()));
			orderBy_aliases.addElement(dtc.getOrderByAlias());
		}
		// ...
		getTableModelExt().setTableHeaderNames(headerNames);
		getTableModelExt().setTableColumnWidths(columnWidths);
		getTableModelExt().setTableFieldNames(fieldNames);
		getTableModelExt().setTableEditables(editables);
		getTableModelExt().setTableOrderByAliases(orderBy_aliases);
		getTableModelExt().setColumnIdentifiers(fieldNames);
		// ...
		try {
			getTableExt().createColumns();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		getTableExt().setEnabled(enabled);
		getJScrollPane().setEnabled(enabled);
	}

	/**
	 * Method generated to support the promotion of the imprimirButtonVisible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setImprimirButtonVisible(boolean arg1) {
		getJButtonImprimir().setVisible(arg1);
	}

	/**
	 * Sets the offset property (int) value.
	 *
	 * @param offset
	 *            The new value for the property.
	 * @see #getOffset
	 */
	public void setOffset(int offset) {
		int oldValue = fieldOffset;
		fieldOffset = offset;
		firePropertyChange("offset", new Integer(oldValue), new Integer(offset));
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton00Enabled attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton00Enabled(boolean arg1) {
		getBar02Panel1().setButton00Enabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton00Text
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarButton00Text(String arg1) {
		getBar02Panel1().setButton00Text(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton00Visible attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton00Visible(boolean arg1) {
		getBar02Panel1().setButton00Visible(arg1);
	}

	public void setOpcionesBarButton00Icon(ImageIcon unIcon) {
		getBar02Panel1().setButton00Icon(unIcon);
	}

	public void setOpcionesBarButton01Icon(ImageIcon unIcon) {
		getBar02Panel1().setButton01Icon(unIcon);
	}

	public void setOpcionesBarButton02Icon(ImageIcon unIcon) {
		getBar02Panel1().setButton02Icon(unIcon);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton01Enabled attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton01Enabled(boolean arg1) {
		getBar02Panel1().setButton01Enabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton01Text
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarButton01Text(String arg1) {
		getBar02Panel1().setButton01Text(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton01Visible attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton01Visible(boolean arg1) {
		getBar02Panel1().setButton01Visible(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton02Enabled attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton02Enabled(boolean arg1) {
		getBar02Panel1().setButton02Enabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton02Text
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarButton02Text(String arg1) {
		getBar02Panel1().setButton02Text(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton02Visible attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton02Visible(boolean arg1) {
		getBar02Panel1().setButton02Visible(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton03Enabled attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton03Enabled(boolean arg1) {
		getBar02Panel1().setButton03Enabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton03Text
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarButton03Text(String arg1) {
		getBar02Panel1().setButton03Text(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton03Visible attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton03Visible(boolean arg1) {
		getBar02Panel1().setButton03Visible(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton10Enabled attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton10Enabled(boolean arg1) {
		getBar02Panel1().setButton10Enabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarButton10Text
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarButton10Text(String arg1) {
		getBar02Panel1().setButton10Text(arg1);
	}

	/**
	 * Method generated to support the promotion of the
	 * opcionesBarButton10Visible attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarButton10Visible(boolean arg1) {
		getBar02Panel1().setButton10Visible(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarToolTipText
	 * attribute.
	 *
	 * @param arg1
	 *            String
	 */
	public void setOpcionesBarToolTipText(String arg1) {
		getBar02Panel1().setToolTipText(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarTotalDisabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarTotalDisabled(boolean arg1) {
		getBar02Panel1().setTotalDisabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the opcionesBarTotalVisible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setOpcionesBarTotalVisible(boolean arg1) {
		getBar02Panel1().setTotalVisible(arg1);
	}

	/**
	 * Insert the method's description here. Creation date: (17/12/2003
	 * 22:32:19)
	 *
	 * @param newOrderBy_alias
	 *            String
	 */
	public void setOrderBy_alias(String newOrderBy_alias) {
		orderBy_alias = newOrderBy_alias;
	}

	/**
	 * Method generated to support the promotion of the
	 * permitirEliminacionMasiva attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setPermitirEliminacionMasiva(boolean arg1) {
		getBar02Panel1().setPermitirEliminacionMasiva(arg1);
	}

	/**
	 * Sets the rightClicked property (java.lang.Object) value.
	 *
	 * @param rightClicked
	 *            The new value for the property.
	 * @see #getRightClicked
	 */
	public void setRightClicked(Object rightClicked) {
		Object oldValue = fieldRightClicked;
		fieldRightClicked = rightClicked;
		firePropertyChange("rightClicked", oldValue, rightClicked);
	}

	/**
	 * Sets the selectedObjectFromDoubleClick property (String) value.
	 *
	 * @param selectedObjectFromDoubleClick
	 *            The new value for the property.
	 * @see #getSelectedObjectFromDoubleClick
	 */
	public void setSelectedObjectFromDoubleClick(String selectedObjectFromDoubleClick) {
		String oldValue = fieldSelectedObjectFromDoubleClick;
		fieldSelectedObjectFromDoubleClick = selectedObjectFromDoubleClick;
		firePropertyChange("selectedObjectFromDoubleClick", oldValue, selectedObjectFromDoubleClick);
	}

	/**
	 * Método generado para soportar la promoción del atributo statusFont.
	 *
	 * @param arg1
	 *            Font
	 */
	public void setStatusFont(Font arg1) {
		getBarraEstadosPanel().setTextFont(arg1);
	}

	/**
	 *
	 * @param arg1
	 */
	public void setBarraEstadosVisible(boolean visible) {
		getBarraEstadosPanel().setVisible(visible);
	}

	/**
	 * Method generated to support the promotion of the tableRowsFont attribute.
	 *
	 * @param arg1
	 *            Font
	 */
	public void setTableRowsFont(Font arg1) {
		getTableExt().setFont(arg1);
	}

	/**
	 *
	 * @return
	 */
	public String SQL_ORDER_BY_text() {
		if (getOrderBy_alias() != null && getOrderBy_alias().trim().length() > 0 && getOrderBy_alias().trim().toUpperCase().compareTo("_NO_ALIAS") != 0)
			return " ORDER BY " + getOrderBy_alias();
		else
			return " ";
	}

	/**
	 *
	 * @param defaultOrderBy
	 * @return
	 */
	public String SQL_ORDER_BY_text(String defaultOrderBy) {
		if (getOrderBy_alias() != null && getOrderBy_alias().trim().length() > 0 && getOrderBy_alias().trim().toUpperCase().compareTo("_NO_ALIAS") != 0)
			return " ORDER BY " + getOrderBy_alias();
		else
			return " ORDER BY " + defaultOrderBy;
	}

	/**
	 *
	 * @return
	 */
	public boolean isPartialData() {
		return partialData;
	}

	/**
	 *
	 * @param partialData
	 */
	public void setPartialData(boolean partialData) {
		this.partialData = partialData;
	}

	/**
	 *
	 */
	public Bar02Panel getOptionsBar() {
		return getBar02Panel1();
	}

	public Vector getColumnsDefinition() {
		return columnsDefinition;
	}
	/**
	 * This method initializes jButtonImprimir
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setMargin(new Insets(0, 0, 0, 0));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.png")));
			jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					prePrintTable();
				}
			});
			jButtonImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonImprimir;
	}
	/**
	 * This method initializes jButtonBuscar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_3.png")));
			jButtonBuscar.setMargin(new Insets(0, 0, 0, 0));
			final DataTablePanel thisClass = this;
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					fireBuscarPerformed(new java.util.EventObject(thisClass));
				}
			});
			jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonBuscar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonBuscar;
	}
	/**
	 *
	 */
	public void setSelectionMode(int aSelectionMode) {
		getTableExt().setSelectionMode(aSelectionMode);
	}
	/**
	 * This method initializes jButtonLimpiar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLimpiar() {
		if (jButtonLimpiar == null) {
			jButtonLimpiar = new JButton();
			jButtonLimpiar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/trash16.png")));
			jButtonLimpiar.setMargin(new Insets(0, 0, 0, 0));
			final DataTablePanel thisClass = this;
			jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					thisClass.removeAllRows();
				}
			});
			jButtonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButtonLimpiar.setVisible(false);
		}
		return jButtonLimpiar;
	}
	/**
	 * This method initializes jToolBar
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.setMaximumSize(new Dimension(22, 22));
			jToolBar.setMinimumSize(new Dimension(22, 22));
			jToolBar.add(getJButtonBuscar());
			jToolBar.add(getJButtonLimpiar());
		}
		return jToolBar;
	}
	/**
	 * This method initializes jToolBar1
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.setFloatable(false);
			jToolBar1.setOpaque(false);
			jToolBar1.setMaximumSize(new Dimension(22, 22));
			jToolBar1.setMinimumSize(new Dimension(22, 22));
			jToolBar1.add(getJButtonImprimir());
		}
		return jToolBar1;
	}
}
