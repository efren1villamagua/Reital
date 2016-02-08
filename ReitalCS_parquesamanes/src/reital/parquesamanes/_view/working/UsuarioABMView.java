package reital.parquesamanes._view.working;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import efren.util.ExceptionManager;
import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableColumn;
import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.Usuario;

public class UsuarioABMView extends JFrame implements efren.util.gui.table.DataTablePanelListener,
		efren.util.gui.text.TextFieldExtListener, java.beans.PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -5780397798467503358L;

	private javax.swing.JPanel ivjJFrameContentPane = null;

	private efren.util.ABMViewObserver2 ivjobserver = null;

	private efren.util.gui.table.DataTablePanel ivjDataTablePanel = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public UsuarioABMView() {
		super();
		initialize();
	}

	/**
	 * GradoABMView constructor comment.
	 *
	 * @param title
	 *            java.lang.String
	 */
	public UsuarioABMView(String title) {
		super(title);
	}

	public void _cerrar() {
		if (InfoView.showConfirmDialog(this, "Desea salir ?") == 0) {
			getobserver().cerrarVentanas();
			this.dispose();
			System.exit(0);
		}
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(java.util.EventObject newEvent) {
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformedOnTextField(java.util.EventObject newEvent) {
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
	public void buscarPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getDataTablePanel())
			connEtoC1(newEvent);
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
	public void comboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * connEtoC1:
	 * (Bar02Panel.bar02Panel.button02ActionPerformed(java.util.EventObject) -->
	 * SystemABMView.dataFetch()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.dataFetch();
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
	 * (Bar02Panel1.bar02Panel.button00ActionPerformed(java.util.EventObject)
	 * --> SystemABMView.nuevo()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.util.EventObject arg1) {
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
	 * (Bar02Panel1.bar02Panel.button01ActionPerformed(java.util.EventObject)
	 * --> SystemABMView.modificar()V)
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
	 * connEtoC4:
	 * (Bar02Panel1.bar02Panel.button03ActionPerformed(java.util.EventObject)
	 * --> SystemABMView.eliminar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.util.EventObject arg1) {
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

	/**
	 * connEtoC5: (DataTablePanel.selectedObjectFromDoubleClick -->
	 * UsuarioABMView.modificar()V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
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

	public void dataFetch() {

		this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

		getDataTablePanel().clearSelection();
		getDataTablePanel().removeAll();

		String orderBy = null;
		if (getDataTablePanel().SQL_ORDER_BY_text().length() == 0) {
			orderBy = null;
		} else {
			orderBy = getDataTablePanel().SQL_ORDER_BY_text();
		}

		List<Usuario> bos = new Factory().getUsuarioControllerBean().getRepository().getAll(orderBy);

		for (Usuario usuario : bos) {
			getDataTablePanel().add(usuario);
		}

		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void eliminar() throws Exception {

		/**
		 * según el pattern de State, se crea una clase de estado y se la asigna
		 * a la ventana de detalles, y además se setea el título que se quiere
		 * que aparezca en dicha ventana
		 */

		UsuarioABMDetailsView view = new UsuarioABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoEliminado("ELIMINAR usuario");
		view.setAbmEstado(estado);

		Usuario bo = (Usuario) getDataTablePanel().getSelectedObject();

		view.bo = bo;
		view.setAbmEstado(estado);
		view.initAll();

		getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void field_keyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusGained(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusLost(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Return the JFrameContentPane property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsDataTablePanel = new java.awt.GridBagConstraints();
			constraintsDataTablePanel.gridx = 0;
			constraintsDataTablePanel.gridy = 0;
			constraintsDataTablePanel.gridwidth = 2;
			constraintsDataTablePanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanel.weightx = 1.0;
			constraintsDataTablePanel.weighty = 1.0;
			constraintsDataTablePanel.ipady = -250;
			constraintsDataTablePanel.insets = new Insets(5, 5, 0, 0);
			ivjJFrameContentPane.add(getDataTablePanel(), constraintsDataTablePanel);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the observer property value.
	 *
	 * @return efren.util.ABMViewObserver2
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.ABMViewObserver2 getobserver() {
		// user code begin {1}
		if (ivjobserver == null)
			ivjobserver = new efren.util.ABMViewObserver2();
		// user code end
		return ivjobserver;
	}

	/**
	 * Return the DataTablePanel property value.
	 *
	 * @return efren.abm.beans.DataTablePanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.table.DataTablePanel getDataTablePanel() {
		if (ivjDataTablePanel == null) {
			ivjDataTablePanel = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanel.setName("DataTablePanel");
			ivjDataTablePanel.setOpcionesBarButton02Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("User Name", 90, "userName", false, "USERNAME"));
			columnsDefinition.add(new DataTableColumn("Nombre", 150, "nombre", false, "NOMBRE"));
			columnsDefinition.add(new DataTableColumn("Administrador", 130, "administrador", false, null));
			columnsDefinition.add(new DataTableColumn("Activo", 70, "activo", false, null));
			ivjDataTablePanel.setColumnsDefinition(Usuario.class, columnsDefinition);
		}
		return ivjDataTablePanel;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getDataTablePanel().addDataTablePanelListener(this);
		getDataTablePanel().addPropertyChangeListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("UsuarioABMView");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setIconImage(Toolkit.getDefaultToolkit()
					.getImage(getClass().getResource("/reital/parquesamanes/resource/images/users16x16.png")));
			setSize(629, 506);
			setTitle("Reital - " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + " - USUARIOS - ["
					+ ParqueSamanesConstantes.SISTEMA_VERSION + "]");
			setContentPane(getJFrameContentPane());
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		WindowManager2.centerWindow(this);
		this.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				try {
					_cerrar();
				} catch (Throwable t) {
					t.getMessage();
				}

			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}
		});
		this.dataFetch();
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(java.awt.event.KeyEvent newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	private void modificar() throws Exception {

		if (!(getDataTablePanel().getOpcionesBarButton01Visible()
				&& getDataTablePanel().getOpcionesBarButton01Enabled()))
			return;
		// manejo de doble click

		UsuarioABMDetailsView view = new UsuarioABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoModificado("MODIFICAR usuario");
		view.setAbmEstado(estado);

		Usuario bo = (Usuario) getDataTablePanel().getSelectedObject();

		view.bo = bo;
		view.setAbmEstado(estado);
		view.initAll();

		getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
	}

	private void nuevo() throws Throwable {

		/**
		 * según el pattern de State, se crea una clase de estado y se la asigna
		 * a la ventana de detalles, y además se setea el título que se quiere
		 * que aparezca en dicha ventana
		 */

		UsuarioABMDetailsView view = new UsuarioABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoNuevo("NUEVO usuario");
		view.setAbmEstado(estado);

		Usuario bo = new Usuario();
		// bo.setOid(efren.util.OidManager.newOid());

		view.bo = bo;
		view.setAbmEstado(estado);
		view.initAll();

		getobserver().addFrame(this, view, String.valueOf(bo.getOid()), estado);
	}

	/**
	 * Method to handle events for the DataTablePanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void opcionesBarButton00ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getDataTablePanel())
			connEtoC2(newEvent);
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
	public void opcionesBarButton01ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getDataTablePanel())
			connEtoC3(newEvent);
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
	public void opcionesBarButton03ActionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getDataTablePanel())
			connEtoC4(newEvent);
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
	 * Method to handle events for the PropertyChangeListener interface.
	 *
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getDataTablePanel() && (evt.getPropertyName().equals("selectedObjectFromDoubleClick")))
			connEtoC5(evt);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textDateMouseClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textFieldExtkeyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

} // @jve:decl-index=0:visual-constraint="10,10"
