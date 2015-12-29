package efren.seguridades.abm.gui;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import efren.util.ABMViewObserver;
import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableColumn;
import efren.util.gui.table.DataTablePanel;
import efren.util.menu.BarManager;

public class ConnectedUsersView extends JInternalFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -6975272042058535466L;

	/**
	 *
	 */
	private JPanel jContentPane = null;

	private DataTablePanel dataTablePanel = null;

	private ABMViewObserver observer = null;

	private JButton jButton1 = null;

	/**
	 * This is the xxx default constructor
	 */
	public ConnectedUsersView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(877, 384);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setTitle("Usuarios conectados al servidor de aplicaciones");
		this.setContentPane(getJContentPane());
		this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
			public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
				cerrar();
			}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
				inicializarRecursos();
			}
		});
		this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
			public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
				dataFetch();
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
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.insets = new Insets(1, 2, 2, 2);
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.weighty = 1.0D;
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getDataTablePanel(), gridBagConstraints1);
			jContentPane.add(getJButton1(), gridBagConstraints2);
		}
		return jContentPane;
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
			dataTablePanel.setOpcionesBarButton01Visible(false);
			dataTablePanel.setOpcionesBarButton03Text("Desconectar");
			dataTablePanel.setPermitirEliminacionMasiva(true);
			dataTablePanel.setOpcionesBarButton00Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("ID", 160, "Id", false, null));
			columnsDefinition.add(new DataTableColumn("UserName", 110, "UserName", false, null));
			columnsDefinition.add(new DataTableColumn("Usuario", 140, "NombreUsuario", false, null));
			columnsDefinition.add(new DataTableColumn("Sistema", 140, "SistemaName", false, null));
			columnsDefinition.add(new DataTableColumn("IP", 110, "Ip", false, null));
			columnsDefinition.add(new DataTableColumn("Desde", 150, "ConnectionTimestamp", false, null));
			// TAREA_PENDIENTE:
			// dataTablePanel.setColumnsDefinition(UserSession.class,
			// columnsDefinition);
			dataTablePanel.addDataTablePanelListener(new efren.util.gui.table.DataTablePanelListener() {
				public void opcionesBarButton00ActionPerformed(java.util.EventObject e) {
				}

				public void buscarPerformed(java.util.EventObject e) {
					dataFetch();
				}

				public void comboBoxORDERBYItemSelected(java.util.EventObject e) {
				}

				public void opcionesBarButton01ActionPerformed(java.util.EventObject e) {
				}

				public void opcionesBarButton02ActionPerformed(java.util.EventObject e) {
				}

				public void opcionesBarButton03ActionPerformed(java.util.EventObject e) {
					cerrarSesiones();
				}

				public void opcionesBarButton10ActionPerformed(java.util.EventObject e) {
				}
			});
			dataTablePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("selectedObjectFromDoubleClick"))) {
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
		try {
			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			getDataTablePanel().clearSelection();
			getDataTablePanel().removeAll();
			// ...
			Vector respuesta = null;// TAREA_PENDIENTE:
									// ServiceInvoker.invoke(ConnectedUsersServlet.class.getSimpleName(),
									// null);
			Vector datos = respuesta;
			getDataTablePanel().add(datos);
		} catch (Throwable t) {
			getDataTablePanel().clearSelection();
			getDataTablePanel().removeAll();
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			this.handleException(true, t);
		}
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 *
	 *
	 */
	private void inicializarRecursos() {
		try {
			this.observer = new ABMViewObserver();
			WindowManager.centerWindow(this);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void cerrar() {
		this.observer.cerrarVentanas();
		this.dispose();
	}

	public void _manejoAccesos(String classArgs) {
		BarManager.manageBar(classArgs, getDataTablePanel());
	}

	/**
	 *
	 * @param exception
	 */
	public void handleException(boolean showErrorWindow, Throwable exception) {
		ExceptionManager.singleton().manage(this, showErrorWindow, this, exception);
	}

	/**
	 *
	 */
	private void cerrarSesiones() {

		Vector selectedObjects = getDataTablePanel().getSelectedObjects();

		if (InfoView.showConfirmDialog(this, "¿ Está seguro de cerrar las " + selectedObjects.size() + " sesiones seleccionadas ?", "Seleccione una opción",
				InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			dataFetch();
			return;
		}

		dataFetch();
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/checkin.gif")));
			jButton1.setOpaque(false);
			jButton1.setContentAreaFilled(false);
			jButton1.setBorderPainted(false);
			jButton1.setBorder(null);
			jButton1.setMargin(new Insets(0, 0, 0, 0));
			jButton1.setToolTipText("Seleccionar todos");
			jButton1.setMnemonic('A');
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDataTablePanel().selectAllRows();
				}
			});
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButton1;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
