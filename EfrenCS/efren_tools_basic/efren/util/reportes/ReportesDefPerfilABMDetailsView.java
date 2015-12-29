package efren.util.reportes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import efren.util.ABMViewObserver;
import efren.util.ExceptionManager;
import efren.util.SystemLogManager;
import efren.util.abm.estados.ABMEstado;
import efren.util.gui.FindObjectsPanel;
import efren.util.gui.bars.BarraAceptarCancelarPanel;
import efren.util.gui.dialogs.InfoView;

public class ReportesDefPerfilABMDetailsView extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 8184021394888300737L;

	private JPanel jContentPane = null;

	private BarraAceptarCancelarPanel barraAceptarCancelarPanel = null;

	private ReportesDefPerfilABMView ventanaPrincipal = null;

	private ABMViewObserver visualObserver = null;

	private ABMEstado estadoABM = null; // @jve:decl-index=0:

	private ReportesDefPerfil bo = null; // @jve:decl-index=0:

	private ReportesDefPerfilController controller = null; // @jve:decl-index=0:

	private FindObjectsPanel findObjectsPanelReporte = null;

	private FindObjectsPanel findObjectsPanelPerfil = null;

	/**
	 * This is the xxx default constructor
	 */
	public ReportesDefPerfilABMDetailsView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(488, 205);
		this.setContentPane(getJContentPane());
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				_cerrar();
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
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 3;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints11.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 3;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.anchor = GridBagConstraints.EAST;
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.gridy = 6;
			jContentPane = new JPanel();
			final GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.rowHeights = new int[] { 7, 0, 0, 0, 0 };
			jContentPane.setLayout(gridBagLayout);
			jContentPane.add(getBarraAceptarCancelarPanel(), gridBagConstraints1);
			jContentPane.add(getFindObjectsPanelReporte(), gridBagConstraints);
			jContentPane.add(getFindObjectsPanelPerfil(), gridBagConstraints11);
		}
		return jContentPane;
	}

	/**
	 * This method initializes barraAceptarCancelarPanel
	 *
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	private BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
		if (barraAceptarCancelarPanel == null) {
			barraAceptarCancelarPanel = new BarraAceptarCancelarPanel();
			barraAceptarCancelarPanel.addBarraAceptarCancelarPanelListener(new efren.util.gui.bars.BarraAceptarCancelarPanelListener() {
				public void aceptarClicked(java.util.EventObject e) {
					aceptar();
				}

				public void cancelarClicked(java.util.EventObject e) {
					_cerrar();
				}
			});
		}
		return barraAceptarCancelarPanel;
	}

	public ABMViewObserver getVisualObserver() {
		return visualObserver;
	}

	public void setVisualObserver(ABMViewObserver visualObserver) {
		this.visualObserver = visualObserver;
	}

	public ABMEstado getEstadoABM() {
		return estadoABM;
	}

	public void setEstadoABM(ABMEstado estadoABM) {
		this.estadoABM = estadoABM;
	}

	/**
	 *
	 */
	public void initAll() {
		initFields();
	}

	/**
	 *
	 */
	private void initFields() {
		try {
			// ...manejo de datos
			getFindObjectsPanelReporte().setValue(getBo().getReportesDefOid());
			getFindObjectsPanelPerfil().setValue(getBo().getPerfilOid());
			// ...manejo visual
			if (getEstadoABM().esEliminado() || getEstadoABM().esConsultado()) {
				getFindObjectsPanelReporte().setEnabled(false);
				getFindObjectsPanelPerfil().setEnabled(false);
			}
		} catch (Throwable t) {
			SystemLogManager.error(t.getMessage());
		}
	}

	/**
	 *
	 */
	private void aceptar() {
		try {
			if (!validar()) {
				return;
			}
			if (permanentUpdateBO()) {
				getVisualObserver().removeFrame(this, String.valueOf(bo.getOid()));
				getVentanaPrincipal().setSelected(true);
			}
			getVentanaPrincipal().dataFetch();
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, false, this, t);
		}
	}

	/**
	 * se elimina ésta ventana del observer controlador de ventanas para que el
	 * objeto de negocio pueda ser utilizado en otra ventana de detalle
	 */
	public void _cerrar() {
		getVisualObserver().removeFrame(this, String.valueOf(getBo().getOid()));
		try {
			getVentanaPrincipal().setSelected(true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 *
	 */
	private boolean permanentUpdateBO() {
		try {

			if (getEstadoABM().esNuevo()) {
				ReportesDefPerfil bo = new ReportesDefPerfil();
				bo.setReportesDefOid(getFindObjectsPanelReporte().getValueAsLong());
				bo.setPerfilOid(getFindObjectsPanelPerfil().getValueAsLong());
				int insertados = this.getController().insertBo(bo);
				return insertados > 0;
			}
			if (getEstadoABM().esModificado()) {
				ReportesDefPerfil bo = new ReportesDefPerfil();
				bo.setOid(getBo().getOid());
				bo.setReportesDefOid(getFindObjectsPanelReporte().getValueAsLong());
				bo.setPerfilOid(getFindObjectsPanelPerfil().getValueAsLong());
				bo.setUtc(getBo().getUtc());
				int actualizados = this.getController().updateBo(bo);
				if (actualizados <= 0) {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
				return actualizados > 0;
			}
			if (getEstadoABM().esEliminado()) {
				ReportesDefPerfil bo = new ReportesDefPerfil();
				bo.setOid(getBo().getOid());
				bo.setReportesDefOid(getFindObjectsPanelReporte().getValueAsLong());
				bo.setPerfilOid(getFindObjectsPanelPerfil().getValueAsLong());
				bo.setUtc(getBo().getUtc());
				int eliminados = this.getController().deleteBo(bo);
				if (eliminados <= 0) {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
				return eliminados > 0;
			}
			return true;

		} catch (Throwable t) {
			InfoView.showErrorDialog(this, "ERROR: " + t.getMessage());
			SystemLogManager.error(t.getMessage());
			return false;
		}
	}

	/**
	 *
	 */
	private boolean validar() {
		if (getEstadoABM().esEliminado()) {
			if (InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción",
					InfoView.YES_NO_OPTION) == InfoView.YES_OPTION)
				return true;
			else
				return false;
		} else {
			if (getFindObjectsPanelReporte().isDataMissing("¡ Seleccione un reporte !")) {
				return false;
			}
			if (getFindObjectsPanelPerfil().isDataMissing("¡ Seleccione un perfil !")) {
				return false;
			}
		}
		return true;
	}

	public ReportesDefPerfilABMView getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(ReportesDefPerfilABMView ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void setBo(ReportesDefPerfil bo) {
		this.bo = bo;
	}

	public void setController(ReportesDefPerfilController controller) {
		this.controller = controller;
	}

	public ReportesDefPerfil getBo() {
		return bo;
	}

	public ReportesDefPerfilController getController() {
		if (this.controller == null) {
			this.controller = new ReportesDefPerfilController(this);
		}
		return controller;
	}

	/**
	 * This method initializes findObjectsPanelReporte
	 *
	 * @return efren.util.gui.FindObjectsPanel
	 */
	private FindObjectsPanel getFindObjectsPanelReporte() {
		if (findObjectsPanelReporte == null) {
			findObjectsPanelReporte = new FindObjectsPanel();
			findObjectsPanelReporte.setName("FindObjectsPanelReporte");
			findObjectsPanelReporte.setDoubleBuffered(false);
			findObjectsPanelReporte.setRequestFocusEnabled(true);
			findObjectsPanelReporte.setCODIGO_FIELD("OID");
			findObjectsPanelReporte.setDISPLAYING_FIELD("NOMBRE");
			findObjectsPanelReporte.setLongitudParametroCodigo(5);
			findObjectsPanelReporte.setCodigoCriteriaLabel("Reporte");
			findObjectsPanelReporte.setTABLE_NAME("UTIL.REPORTESDEF");
			findObjectsPanelReporte.setTipoCODIGO(FindObjectsPanel.Tipo.NUMERICO);
			findObjectsPanelReporte.setNullable(false);
			findObjectsPanelReporte.setFieldCodigoVisible(false);
			findObjectsPanelReporte.setVisible(true);
		}
		return findObjectsPanelReporte;
	}

	/**
	 * This method initializes findObjectsPanelPerfil
	 *
	 * @return efren.util.gui.FindObjectsPanel
	 */
	private FindObjectsPanel getFindObjectsPanelPerfil() {
		if (findObjectsPanelPerfil == null) {
			findObjectsPanelPerfil = new FindObjectsPanel();
			findObjectsPanelPerfil.setName("FindObjectsPanelPerfil");
			findObjectsPanelPerfil.setDoubleBuffered(false);
			findObjectsPanelPerfil.setRequestFocusEnabled(true);
			findObjectsPanelPerfil.setCODIGO_FIELD("OID");
			findObjectsPanelPerfil.setDISPLAYING_FIELD("NOMBRE");
			findObjectsPanelPerfil.setLongitudParametroCodigo(5);
			findObjectsPanelPerfil.setCodigoCriteriaLabel("Perfil");
			findObjectsPanelPerfil.setTABLE_NAME("SEGURIDADES.PERFIL");
			findObjectsPanelPerfil.setTipoCODIGO(FindObjectsPanel.Tipo.NUMERICO);
			findObjectsPanelPerfil.setNullable(false);
			findObjectsPanelPerfil.setFieldCodigoVisible(false);
			findObjectsPanelPerfil.setVisible(true);
		}
		return findObjectsPanelPerfil;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
