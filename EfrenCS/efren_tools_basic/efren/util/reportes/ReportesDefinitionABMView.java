package efren.util.reportes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import efren.util.ABMViewObserver;
import efren.util.SystemLogManager;
import efren.util.WindowManager;
import efren.util.gui.FinderSQLPanel;
import efren.util.gui.table.DataTableColumn;
import efren.util.gui.table.DataTablePanel;
import efren.util.menu.BarManager;

public class ReportesDefinitionABMView extends JInternalFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 8068302485334826326L;

	/**
	 *
	 */
	private JPanel jContentPane = null;

	private FinderSQLPanel finderSQLPanel = null;

	private DataTablePanel dataTablePanel = null;

	private ABMViewObserver observer = null;

	private ReportesDefinitionController controller = null;

	/**
	 * This is the xxx default constructor
	 */
	public ReportesDefinitionABMView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(631, 384);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setTitle("Definiciones de Reportes");
		this.setContentPane(getJContentPane());
		this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
			public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
				cerrar();
			}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
				inicializarRecursos();
				getFinderSQLPanel().requestFocus();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.insets = new Insets(1, 2, 2, 2);
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.weighty = 1.0D;
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(2, 2, 1, 2);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getFinderSQLPanel(), gridBagConstraints);
			jContentPane.add(getDataTablePanel(), gridBagConstraints1);
		}
		return jContentPane;
	}

	/**
	 * This method initializes finderSQLPanel
	 *
	 * @return efren.abm.beans.FinderSQLPanel
	 */
	private FinderSQLPanel getFinderSQLPanel() {
		if (finderSQLPanel == null) {
			finderSQLPanel = new FinderSQLPanel();
			finderSQLPanel.setTABLE_NAME("REPORTESDEF");
			finderSQLPanel.setSCHEMA_NAME("UTIL");
			finderSQLPanel.setSelectedCampo01("NOMBRE");
			finderSQLPanel.setSelectedCampo02("TITULO2");
			finderSQLPanel.setCamposCount(2);
		}
		return finderSQLPanel;
	}

	/**
	 * This method initializes dataTablePanel
	 *
	 * @return efren.abm.beans.DataTablePanel
	 */
	private DataTablePanel getDataTablePanel() {
		if (dataTablePanel == null) {
			dataTablePanel = new DataTablePanel();
			dataTablePanel.setOpcionesBarButton02Visible(false);
			dataTablePanel.setPermitirEliminacionMasiva(true);
			dataTablePanel.setOpcionesBarButton10Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("Nombre", 180, "nombre", false, "NOMBRE"));
			columnsDefinition.add(new DataTableColumn("Título 1", 180, "titulo1", false, "TITULO1"));
			columnsDefinition.add(new DataTableColumn("Título 2", 180, "titulo2", false, "TITULO2"));
			dataTablePanel.setColumnsDefinition(DefinicionReporte.class, columnsDefinition);
			dataTablePanel.addDataTablePanelListener(new efren.util.gui.table.DataTablePanelListener() {
				public void opcionesBarButton00ActionPerformed(java.util.EventObject e) {
					try {
						nuevo();
					} catch (Throwable t1) {
						SystemLogManager.error(t1.getMessage());
					}
				}

				public void buscarPerformed(java.util.EventObject e) {
					dataFetch();
				}

				public void comboBoxORDERBYItemSelected(java.util.EventObject e) {
				}

				public void opcionesBarButton01ActionPerformed(java.util.EventObject e) {
					try {
						modificar();
					} catch (Throwable t1) {
						SystemLogManager.error(t1.getMessage());
					}
				}

				public void opcionesBarButton02ActionPerformed(java.util.EventObject e) {
					try {
						consultar();
					} catch (Throwable t1) {
						SystemLogManager.error(t1.getMessage());
					}
				}

				public void opcionesBarButton03ActionPerformed(java.util.EventObject e) {
					try {
						eliminar();
					} catch (Throwable t1) {
						SystemLogManager.error(t1.getMessage());
					}
				}

				public void opcionesBarButton10ActionPerformed(java.util.EventObject e) {
				}
			});
			dataTablePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("selectedObjectFromDoubleClick"))) {
						try {
							modificar();
						} catch (Throwable t1) {
							SystemLogManager.error(t1.getMessage());
						}
					}
				}
			});
		}
		return dataTablePanel;
	}

	/**
	 *
	 *
	 */
	public void dataFetch() {
		this.controller.buscarAll(getFinderSQLPanel(), getDataTablePanel());
	}

	/**
	 *
	 *
	 */
	private void inicializarRecursos() {
		try {
			this.observer = new ABMViewObserver();
			getFinderSQLPanel().initAll();
			getFinderSQLPanel().setDataTablePanel(getDataTablePanel());
			WindowManager.centerWindow(this);
			this.controller = new ReportesDefinitionController(this, this.observer);
		} catch (Exception e) {
			SystemLogManager.error(e.getMessage());
		}
	}

	/**
	 *
	 * @throws Throwable
	 */
	private void nuevo() throws Throwable {
		this.controller.nuevo();
	}

	/**
	 *
	 * @throws Throwable
	 */
	private void modificar() throws Throwable {
		this.controller.modificar(getDataTablePanel());
	}

	private void consultar() throws Throwable {
		this.controller.consultar(getDataTablePanel());
	}

	/**
	 *
	 * @throws Throwable
	 */
	private void eliminar() throws Throwable {
		this.controller.eliminar(getDataTablePanel());
	}

	/**
	 *
	 *
	 */
	public void cerrar() {
		this.observer.cerrarVentanas();
		this.dispose();
	}

	/**
	 *
	 * @param classArgs
	 */
	public void _manejoAccesos(String classArgs) {
		BarManager.manageBar(classArgs, getDataTablePanel());
	}
} // @jve:decl-index=0:visual-constraint="10,10"
