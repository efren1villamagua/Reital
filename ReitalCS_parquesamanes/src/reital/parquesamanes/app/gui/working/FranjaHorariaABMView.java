package reital.parquesamanes.app.gui.working;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import efren.util.ExceptionManager;
import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableColumn;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.FranjaHorariaRepository;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public class FranjaHorariaABMView extends JFrame
		implements efren.util.gui.table.DataTablePanelListener, efren.util.gui.text.TextFieldExtListener, java.beans.PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -5780397798467503358L;

	private javax.swing.JPanel ivjJFrameContentPane = null;

	private efren.util.ABMViewObserver2 ivjobserver = null;

	private efren.util.gui.table.DataTablePanel ivjDataTablePanel = null;

	private FranjaHorariaRepository repository = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public FranjaHorariaABMView() {
		super();
		initialize();
	}

	/**
	 * GradoABMView constructor comment.
	 *
	 * @param title
	 *            java.lang.String
	 */
	public FranjaHorariaABMView(String title) {
		super(title);
	}

	public void _cerrar() {
		if (InfoView.showConfirmDialog(this, "Desea salir de esta opción ?") == 0) {
			getobserver().cerrarVentanas();
			this.dispose();
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
	 * FranjaHorariaABMView.modificar()V)
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

		List<FranjaHoraria> bos = getRepository().getAll();

		for (FranjaHoraria franjaHoraria : bos) {
			getDataTablePanel().add(franjaHoraria);
		}

		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void eliminar() throws Exception {

		/**
		 * según el pattern de State, se crea una clase de estado y se la asigna
		 * a la ventana de detalles, y además se setea el título que se quiere
		 * que aparezca en dicha ventana
		 */

		FranjaHorariaABMDetailsView view = new FranjaHorariaABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoEliminado("ELIMINAR franja horaria");
		view.setAbmEstado(estado);

		FranjaHoraria bo = (FranjaHoraria) getDataTablePanel().getSelectedObject();

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
			constraintsDataTablePanel.gridy = 1;
			constraintsDataTablePanel.gridwidth = 2;
			constraintsDataTablePanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanel.weightx = 1.0;
			constraintsDataTablePanel.weighty = 1.0;
			constraintsDataTablePanel.ipady = -250;
			constraintsDataTablePanel.insets = new Insets(5, 5, 5, 5);
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
			columnsDefinition.add(new DataTableColumn("Código", 90, "codigo", false, null));
			columnsDefinition.add(new DataTableColumn("Nombre", 150, "nombre", false, null));
			columnsDefinition.add(new DataTableColumn("Inicio", 90, "horaInicio", false, null));
			columnsDefinition.add(new DataTableColumn("Fin", 90, "horaFin", false, null));
			ivjDataTablePanel.setColumnsDefinition(FranjaHoraria.class, columnsDefinition);
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
			setName("FranjaHorariaABMView");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/calendar16x16.png")));
			setSize(604, 390);
			setTitle("Franjas Horarias - [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
			setContentPane(getJFrameContentPane());
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		WindowManager2.centerWindow(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					_cerrar();
				} catch (Throwable t) {
					t.getMessage();
				}
			}
		});
		this.dataFetch();
	}

	public void keyReleased(java.awt.event.KeyEvent newEvent) {
	}

	private void modificar() throws Exception {

		if (!(getDataTablePanel().getOpcionesBarButton01Visible() && getDataTablePanel().getOpcionesBarButton01Enabled()))
			return;

		FranjaHorariaABMDetailsView view = new FranjaHorariaABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoModificado("MODIFICAR franja horaria");
		view.setAbmEstado(estado);

		FranjaHoraria bo = (FranjaHoraria) getDataTablePanel().getSelectedObject();

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

		FranjaHorariaABMDetailsView view = new FranjaHorariaABMDetailsView();

		view.setObserverThis(getobserver());
		view.mainView = this;

		efren.util.abm.estados.ABMEstado estado = new efren.util.abm.estados.ABMEstadoNuevo("NUEVA franja horaria");
		view.setAbmEstado(estado);

		FranjaHoraria bo = new FranjaHoraria();
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

	/**
	 * @return the repository
	 */
	public FranjaHorariaRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository
	 *            the repository to set
	 */
	public void setRepository(FranjaHorariaRepository repository) {
		this.repository = repository;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
