package efren.seguridades.abm.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.TreePath;

import efren.seguridades.gui.SystemView;
import efren.seguridades.util.tree.OpcionTreeModel2;
import efren.seguridades.util.tree.OpcionTreeTable;
import efren.seguridades.util.tree.TreeTableModelAdapter;
import efren.util.ExceptionManager;
import efren.util.SwingResourceManager;
import efren.util.WindowManager;
import efren.util.WindowManager2;
import efren.util.abm.estados.ABMEstado;
import efren.util.abm.estados.ABMEstadoEliminado;
import efren.util.abm.estados.ABMEstadoModificado;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecOpcion;
import efren.util.gui.bars.Bar02Panel;
import efren.util.gui.bars.BarraAceptarCancelarPanel;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableReporterView;

public class OpcionABMView extends javax.swing.JInternalFrame implements javax.swing.event.InternalFrameListener, javax.swing.event.TreeSelectionListener {

	private javax.swing.JPanel ivjJFrameContentPane = null;
	private efren.util.ABMViewObserver ivjobserver = null;
	private JScrollPane jScrollPane = null;
	private OpcionTreeTable opcionTreeTable = null;
	private Bar02Panel bar02Panel = null;
	private JButton ivjJButtonRefrescarTodoElArbol = null;
	private JButton ivjJButtonRefrescarUltimoNodoAbierto = null;
	private JButton ivjJButtonImprimir2 = null;
	public TreePath parentPath = null;
	private JToolBar jToolBar = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public OpcionABMView() {
		super();
		initialize();
	}

	/**
	 * EstructuraOrganicaABMView constructor comment.
	 *
	 * @param title
	 *            java.lang.String
	 */
	public OpcionABMView(String title) {
		super(title);
	}

	public void _cerrar() {
		getobserver().cerrarVentanas();
		this.dispose();
	}

	public void reloadPath() {
		try {
			// Thread.sleep(5000);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					TreeTableModelAdapter treeModel = (TreeTableModelAdapter) getOpcionTreeTable().getModel();

					treeModel.getTree().expandPath(parentPath);

					// tree.expandRow(selectedRow);

					// this.tree.makeVisible(this.parentPath);
					// this.tree.fireTreeExpanded(this.parentPath);

					// this.tree.updateUI();

					// this.tree.expandPath(this.opcionTreeModel.getPathLoading());
					/*
					 * int row = 0; while (row < tree.getRowCount()) {
					 * tree.expandRow(row); row++; }
					 */

				}
			});
			// while(this.opcionTreeModel.isLoadingNodes)
			// a = 1;//solo para hacer esperar

		} catch (Exception e2) {
			e2.getMessage();
		}
	}

	/**
	 * Method to handle events for the DataTablePanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void comboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * connEtoC1:
	 * (Bar02Panel.bar02Panel.button00ActionPerformed(java.util.EventObject) -->
	 * OptionABMView.nuevo()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.nuevo();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3:
	 * (Bar02Panel.bar02Panel.button01ActionPerformed(java.util.EventObject) -->
	 * OptionABMView.modificar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.modificar();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (DataTablePanel.selectedObjectFromDoubleClick -->
	 * OpcionABMView.modificar()V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.modificar();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5:
	 * (Bar02Panel.bar02Panel.button03ActionPerformed(java.util.EventObject) -->
	 * OptionABMView.eliminar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.eliminar();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public static String convertTo4Chars(int number) {
		if (number <= 9)
			return "000" + String.valueOf(number).trim();
		if (number <= 99)
			return "00" + String.valueOf(number).trim();
		if (number <= 999)
			return "0" + String.valueOf(number).trim();
		return String.valueOf(number).trim();
	}

	private void eliminar() throws Throwable {

		OpcionABMDetailsView ventana = new OpcionABMDetailsView();

		ventana.setObserverThis(getobserver());
		ventana.mainView = this;

		ABMEstado estado = new ABMEstadoEliminado("ELIMINAR opción en Seguridades");
		ventana.setAbmEstado(estado);

		int selectedIndex = getOpcionTreeTable().getSelectedRow();
		TreeTableModelAdapter treeModel = (TreeTableModelAdapter) getOpcionTreeTable().getModel();
		OpcionTreeModel2.OpcionNode selectedNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getLastPathComponent();

		SecOpcion bo = selectedNode.getOpcion();
		ventana.bo = bo;
		ventana.initAll();

		ventana.tree = treeModel.getTree();
		ventana.selectedRow = selectedIndex;
		ventana.parentPath = treeModel.getTree().getPathForRow(selectedIndex).getParentPath();
		ventana.parentNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getParentPath().getLastPathComponent();
		ventana.opcionTreeModel = getOpcionTreeTable().opcionModel;
		// ventana.selectedIndex = selectedIndex;
		// ventana.nodePath = treeModel.getTree().getPathForRow(selectedIndex);

		getobserver().addFrame(this, ventana, String.valueOf(bo.getOid()), estado);
	}

	/**
	 * Return the JFrameContentPane property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			try {
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.fill = GridBagConstraints.VERTICAL;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.weightx = 1.0;
				gridBagConstraints.gridx = 1;
				GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				ivjJFrameContentPane = new javax.swing.JPanel();
				ivjJFrameContentPane.setName("JFrameContentPane");
				ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.gridy = 1;
				gridBagConstraints2.weightx = 1.0;
				gridBagConstraints2.weighty = 1.0;
				gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
				gridBagConstraints2.insets = new java.awt.Insets(0, 4, 0, 4);
				gridBagConstraints2.gridwidth = 3;
				gridBagConstraints4.gridx = 0;
				gridBagConstraints4.gridy = 2;
				gridBagConstraints4.insets = new java.awt.Insets(2, 4, 4, 4);
				gridBagConstraints4.weightx = 1.0D;
				gridBagConstraints4.gridwidth = 2;
				gridBagConstraints21.gridx = 2;
				gridBagConstraints21.gridy = 0;
				gridBagConstraints21.insets = new java.awt.Insets(0, 0, 0, 2);
				ivjJFrameContentPane.add(getJScrollPane(), gridBagConstraints2);
				ivjJFrameContentPane.add(getBar02Panel(), gridBagConstraints4);
				ivjJFrameContentPane.add(getJButtonImprimir2(), gridBagConstraints21);
				ivjJFrameContentPane.add(getJToolBar(), gridBagConstraints);
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the observer property value.
	 *
	 * @return efren.util.ABMViewObserver
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.ABMViewObserver getobserver() {
		// user code begin {1}
		if (ivjobserver == null)
			ivjobserver = new efren.util.ABMViewObserver();
		// user code end
		return ivjobserver;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// st = efren.util.Conn.conectar().createStatement();
			// user code end
			setName("OpcionABMView");
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			setSize(720, 414);
			setTitle("Opciones de sistema en SEGURIDADES");
			setContentPane(getJFrameContentPane());
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		efren.util.WindowManager.centerWindow(this);
		this.addInternalFrameListener(this);
		// user code end
	}

	public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
		try {
			this._cerrar();
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e) {

	}

	public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameIconified(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
	}

	private void modificar() throws Throwable {

		OpcionABMDetailsView ventana = new OpcionABMDetailsView();

		ventana.setObserverThis(getobserver());
		ventana.mainView = this;

		ABMEstado estado = new ABMEstadoModificado("MODIFICAR opción en Seguridades");
		ventana.setAbmEstado(estado);

		int selectedIndex = getOpcionTreeTable().getSelectedRow();
		TreeTableModelAdapter treeModel = (TreeTableModelAdapter) getOpcionTreeTable().getModel();
		OpcionTreeModel2.OpcionNode selectedNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getLastPathComponent();

		SecOpcion bo = selectedNode.getOpcion();
		ventana.bo = bo;
		ventana.initAll();

		ventana.tree = treeModel.getTree();
		ventana.selectedRow = selectedIndex;
		ventana.parentPath = treeModel.getTree().getPathForRow(selectedIndex).getParentPath();
		ventana.parentNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getParentPath().getLastPathComponent();
		ventana.opcionTreeModel = getOpcionTreeTable().opcionModel;
		// ventana.selectedIndex = selectedIndex;
		// ventana.nodePath = treeModel.getTree().getPathForRow(selectedIndex);

		getobserver().addFrame(this, ventana, String.valueOf(bo.getOid()), estado);
	}

	private void nuevo() throws java.rmi.RemoteException {
		/**
		 * según el pattern de State, se crea una clase de estado y se la asigna
		 * a la ventana de detalles, y además se setea el título que se quiere
		 * que aparezca en dicha ventana
		 */
		try {
			int selectedIndex = getOpcionTreeTable().getSelectedRow();// -1 si
																		// ninguna
																		// opcion
																		// ha
																		// sido
																		// seleccionada
			if (selectedIndex < 0) {
				InfoView.showErrorDialog(this, "Seleccione un Menú");
				return;
			}

			SecOpcion selectedBo = null;
			OpcionTreeModel2.OpcionNode selectedNode = null;
			if (selectedIndex >= 0) {
				TreeTableModelAdapter treeModel = (TreeTableModelAdapter) getOpcionTreeTable().getModel();
				selectedNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getLastPathComponent();
				selectedBo = selectedNode.getOpcion();
			}

			SecOpcion opcionPadre = null;
			if (selectedIndex >= 0) {
				opcionPadre = selectedBo;
				if (opcionPadre.getClaseOid() >= 0 || opcionPadre.getOid() == OpcionTreeModel2.SISTEMA_SEGURIDADES_META_OID) {
					InfoView.showErrorDialog(this, "Solamente un Menú puede ser seleccionado Padre de otra Opción");
					return;
				}
			}

			OpcionABMDetailsView view = new OpcionABMDetailsView();

			view.setObserverThis(getobserver());
			view.mainView = this;

			efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoNuevo("NUEVA opción en SEGURIDADES");
			view.setAbmEstado(estado);

			efren.util.entidades.SecOpcion bo = new efren.util.entidades.SecOpcion();
			bo.setOid(efren.util.OidManager.newOid());
			bo.setSistemaOid(selectedBo.getSistemaOid());

			if (selectedIndex >= 0) {
				bo.setOpcionPadreOid(opcionPadre.getOid());
				view.parentNode = selectedNode;
			} else {
				bo.setOpcionPadreOid(selectedBo.getSistemaOid());
			}

			TreeTableModelAdapter treeModel = (TreeTableModelAdapter) getOpcionTreeTable().getModel();

			view.tree = treeModel.getTree();
			view.selectedRow = selectedIndex;
			view.parentPath = treeModel.getTree().getPathForRow(selectedIndex).getParentPath();
			view.opcionTreeModel = getOpcionTreeTable().opcionModel;

			view.bo = bo;
			view.initAll();
			getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 * Method to handle events for the DataTablePanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void opcionesBarButton02ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the DataTablePanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void opcionesBarButton10ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Set the observer to a new value.
	 *
	 * @param newValue
	 *            efren.util.ABMViewObserver
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setobserver(efren.util.ABMViewObserver newValue) {
		if (ivjobserver != newValue) {
			try {
				ivjobserver = newValue;
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		;
		// user code begin {3}
		// user code end
	}

	/**
	 * Method to handle events for the TreeExpansionListener interface.
	 *
	 * @param event
	 *            javax.swing.event.TreeExpansionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void valueChanged(javax.swing.event.TreeSelectionEvent event) {
		// user code begin {1}
		// user code end
		event.getClass();
		// user code begin {2}
		// user code end
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getOpcionTreeTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes opcionTreeTable
	 *
	 * @return efren.seguridades.util.tree.OpcionTreeTable
	 */
	private OpcionTreeTable getOpcionTreeTable() {
		if (opcionTreeTable == null) {
			opcionTreeTable = new OpcionTreeTable();
		}
		// ...eventos
		ListSelectionModel rsm = opcionTreeTable.getSelectionModel();
		rsm.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (opcionTreeTable.getSelectedRowCount() == 1) {
					try {
						int selectedIndex = opcionTreeTable.getSelectedRow();
						TreeTableModelAdapter treeModel = (TreeTableModelAdapter) opcionTreeTable.getModel();
						OpcionTreeModel2.OpcionNode selectedNode = (OpcionTreeModel2.OpcionNode) treeModel.getTree().getPathForRow(selectedIndex).getLastPathComponent();
						SecOpcion bo = selectedNode.getOpcion();
						if (bo.getOid() == bo.getSistemaOid())
							getBar02Panel().habilitarDesabilitarBotones(0, false);
						else
							getBar02Panel().habilitarDesabilitarBotones(1, false);
					} catch (Exception exc) {
						exc.getMessage();
					}
				} else {
					// int selectedRow = lsm.getMinSelectionIndex();
					getBar02Panel().habilitarDesabilitarBotones(0, false);
				}
			}
		});

		return opcionTreeTable;
	}

	/**
	 * This method initializes bar02Panel
	 *
	 * @return efren.abm.beans.Bar02Panel
	 */
	private Bar02Panel getBar02Panel() {
		if (bar02Panel == null) {
			bar02Panel = new Bar02Panel();
			bar02Panel.setButton02Visible(false);
			bar02Panel.setButton03Enabled(false);
			bar02Panel.setButton01Enabled(false);
			bar02Panel.addBar02PanelListener(new efren.util.gui.bars.Bar02PanelListener() {
				public void button00ActionPerformed(java.util.EventObject e) {
					try {
						nuevo();
					} catch (Throwable t) {
						t.getMessage();
					}
				}

				public void button01ActionPerformed(java.util.EventObject e) {
					try {
						modificar();
					} catch (Throwable t) {
						t.getMessage();
					}
				}

				public void button02ActionPerformed(java.util.EventObject e) {
				}

				public void button03ActionPerformed(java.util.EventObject e) {
					try {
						eliminar();
					} catch (Throwable t) {
						t.getMessage();
					}
				}

				public void button10ActionPerformed(java.util.EventObject e) {
				}
			});

		}
		return bar02Panel;
	}

	private void refrescarArbol() {
		this.getOpcionTreeTable().opcionModel.reloadChildren(this.getOpcionTreeTable().opcionModel.getRoot());
	}

	/**
	 *
	 */
	private JButton getJButtonRefrescarTodoElArbol() {
		if (ivjJButtonRefrescarTodoElArbol == null) {
			ivjJButtonRefrescarTodoElArbol = new javax.swing.JButton();
			ivjJButtonRefrescarTodoElArbol.setName("JButtonRefrescarTodoElArbol");
			ivjJButtonRefrescarTodoElArbol.setText("Refrescar todo el árbol");
			ivjJButtonRefrescarTodoElArbol.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButtonRefrescarTodoElArbol.setIcon(SwingResourceManager.getIcon(BarraAceptarCancelarPanel.class, "/efren/resources/images/bar_ok_2.gif"));
			ivjJButtonRefrescarTodoElArbol.setFont(new Font("Arial", Font.BOLD, 10));
			ivjJButtonRefrescarTodoElArbol.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 2));
			ivjJButtonRefrescarTodoElArbol.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButtonRefrescarTodoElArbol.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					refrescarArbol();
				}
			});
			ivjJButtonRefrescarTodoElArbol.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					ivjJButtonRefrescarTodoElArbol.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					ivjJButtonRefrescarTodoElArbol.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return ivjJButtonRefrescarTodoElArbol;
	}
	/**
	 *
	 */
	private JButton getJButtonRefrescarUltimoNodoAbierto() {
		if (ivjJButtonRefrescarUltimoNodoAbierto == null) {
			ivjJButtonRefrescarUltimoNodoAbierto = new javax.swing.JButton();
			ivjJButtonRefrescarUltimoNodoAbierto.setName("JButtonRefrescarUltimoNodoAbierto");
			ivjJButtonRefrescarUltimoNodoAbierto.setText("Refrescar ultimo nodo abierto");
			ivjJButtonRefrescarUltimoNodoAbierto.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButtonRefrescarUltimoNodoAbierto.setIcon(SwingResourceManager.getIcon(BarraAceptarCancelarPanel.class, "/efren/resources/images/bar_ok_1.gif"));
			ivjJButtonRefrescarUltimoNodoAbierto.setFont(new Font("Arial", Font.BOLD, 10));
			ivjJButtonRefrescarUltimoNodoAbierto.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			ivjJButtonRefrescarUltimoNodoAbierto.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButtonRefrescarUltimoNodoAbierto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reloadPath();
				}
			});
			ivjJButtonRefrescarUltimoNodoAbierto.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					ivjJButtonRefrescarUltimoNodoAbierto.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					ivjJButtonRefrescarUltimoNodoAbierto.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return ivjJButtonRefrescarUltimoNodoAbierto;
	}
	/**
	 *
	 */
	public void doRefreshLastPath() {
		getJButtonRefrescarUltimoNodoAbierto().doClick();
	}
	/**
	 *
	 */
	private JButton getJButtonImprimir2() {
		if (ivjJButtonImprimir2 == null) {
			ivjJButtonImprimir2 = new javax.swing.JButton();
			ivjJButtonImprimir2.setName("JButtonImprimir2");
			ivjJButtonImprimir2.setText("");
			ivjJButtonImprimir2.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButtonImprimir2.setIcon(SwingResourceManager.getIcon(BarraAceptarCancelarPanel.class, "/efren/resources/images/bar_ok_6.png"));
			ivjJButtonImprimir2.setFont(new Font("Arial", Font.BOLD, 10));
			ivjJButtonImprimir2.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButtonImprimir2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					prePrintTable();
				}
			});
			ivjJButtonImprimir2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					ivjJButtonImprimir2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					ivjJButtonImprimir2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return ivjJButtonImprimir2;
	}
	/**
	 *
	 */
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

		// if (getTableModelExt().getRowCount() == 0) {
		// efren.dialogs.InfoView.showErrorDialog(this, "¡ No hay datos en la
		// tabla para imprimir !");
		// return;
		// }

		DataTableReporterView window = new DataTableReporterView();
		window.setTable(getOpcionTreeTable());
		try {
			window.setTitulo1("");
			window.setTitulo2(((javax.swing.JInternalFrame) this.getParent().getParent().getParent().getParent()).getTitle());
		} catch (Throwable t) {
			t.getMessage();
		}
		WindowManager.centerWindowOnThis2(SystemView.singleton(), window);
		window.setResizable(true);
		window.setVisible(true);
		window.toFront();
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
			jToolBar.add(getJButtonRefrescarTodoElArbol());
			jToolBar.add(getJButtonRefrescarUltimoNodoAbierto());
		}
		return jToolBar;
	}

}
