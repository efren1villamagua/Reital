package efren.util.reportes;

import java.awt.Container;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JInternalFrame;

import efren.util.ABMViewObserver;
import efren.util.Conn;
import efren.util.ExceptionManager;
import efren.util.OidManager;
import efren.util.abm.estados.ABMEstado;
import efren.util.abm.estados.ABMEstadoModificado;
import efren.util.abm.estados.ABMEstadoNuevo;
import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTablePanel;

public class ReportesDefPerfilController {
	/**
	 *
	 */
	private Container visualComponent = null;

	private ABMViewObserver visualObserver = null;

	private Object exceptionSource = null;

	/**
	 *
	 * @param unComponenteVisual
	 */
	public ReportesDefPerfilController(Container unComponenteVisual) {
		super();
		this.setVisualComponent(unComponenteVisual);
		this.setExceptionSource(this);
	}

	/**
	 *
	 * @param unComponenteVisual
	 */
	public ReportesDefPerfilController(Container unComponenteVisual, ABMViewObserver unObservadorVisual) {
		super();
		this.setVisualComponent(unComponenteVisual);
		this.setExceptionSource(this);
		// ...
		this.setVisualObserver(unObservadorVisual);
	}

	/**
	 *
	 */
	public void buscar(DataTablePanel dataTablePanel) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			dataTablePanel.clearSelection();
			dataTablePanel.removeAllRows();

			String orderBy = dataTablePanel.SQL_ORDER_BY_text("NOMBRE_REPORTE");

			Vector<ReportesDefPerfil> data = new Vector<ReportesDefPerfil>();

			Statement st = Conn.conectar().createStatement();

			String schemaUtil = SystemProperties.SCHEMA_UTIL;
			String schemaSeguridad = SystemProperties.SCHEMA_SEGURIDADES;

			String sql = "SELECT " + " rdp.OID, " + " rd.OID AS REPORTESDEFOID, RTRIM(LTRIM(rd.NOMBRE)) AS NOMBRE_REPORTE, "
					+ " p.OID AS PERFILOID, RTRIM(LTRIM(p.NOMBRE)) AS NOMBRE_PERFIL, " + " rdp.TIMESTAMP " + " FROM " + schemaUtil + ".REPORTESDEFPERFIL rdp, "
					+ schemaUtil + ".REPORTESDEF rd, " + schemaSeguridad + ".PERFIL p " + " WHERE rdp.REPORTESDEFOID=rd.OID AND rdp.PERFILOID=p.OID " + orderBy;
			ReportesDefPerfil row = null;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				row = new ReportesDefPerfil();

				row.setOid(rs.getLong("OID"));
				row.setReportesDefOid(rs.getLong("REPORTESDEFOID"));
				row.setNombreReporte(rs.getString("NOMBRE_REPORTE").trim());
				row.setPerfilOid(rs.getLong("PERFILOID"));
				row.setNombrePerfil(rs.getString("NOMBRE_PERFIL").trim());
				row.setUtc(rs.getTimestamp("TIMESTAMP"));

				data.add(row);
			}
			rs.close();
			st.close();

			dataTablePanel.add(data);
			dataTablePanel.deselect();

		} catch (Throwable t) {
			dataTablePanel.clearSelection();
			dataTablePanel.removeAll();
			this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			this.handleException(true, t);
		}
		this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 *
	 * @throws Throwable
	 */
	public void nuevo() throws Throwable {

		ReportesDefPerfilABMDetailsView ventanaDetalle = new ReportesDefPerfilABMDetailsView();

		ventanaDetalle.setVisualObserver(this.getVisualObserver());
		ventanaDetalle.setVentanaPrincipal((ReportesDefPerfilABMView) this.getVisualComponent());

		ABMEstado estado = new ABMEstadoNuevo("NUEVA definición de reporte por perfil");
		ventanaDetalle.setEstadoABM(estado);

		ReportesDefPerfil bo = new ReportesDefPerfil();

		ventanaDetalle.setBo(bo);
		ventanaDetalle.initAll();

		this.getVisualObserver().addFrame((JInternalFrame) this.getVisualComponent(), ventanaDetalle, String.valueOf(bo.getOid()), estado);
	}

	/**
	 *
	 */
	public void modificar(DataTablePanel dataGrid) throws Throwable {

		if (!(dataGrid.getOpcionesBarButton01Visible() && dataGrid.getOpcionesBarButton01Enabled())) {
			return;// manejo de doble click
		}

		ReportesDefPerfilABMDetailsView ventanaDetalle = new ReportesDefPerfilABMDetailsView();

		ventanaDetalle.setVisualObserver(this.getVisualObserver());
		ventanaDetalle.setVentanaPrincipal((ReportesDefPerfilABMView) this.getVisualComponent());

		ABMEstado estado = new ABMEstadoModificado("MODIFICAR definición de reporte por perfil");
		ventanaDetalle.setEstadoABM(estado);

		ReportesDefPerfil bo = (ReportesDefPerfil) dataGrid.getSelectedObject();

		ventanaDetalle.setBo(bo);
		ventanaDetalle.initAll();

		this.getVisualObserver().addFrame((JInternalFrame) this.getVisualComponent(), ventanaDetalle, String.valueOf(bo.getOid()), estado);
	}

	/**
	 *
	 * @throws Throwable
	 */
	public void eliminar(DataTablePanel dataGrid) throws Throwable {

		if (InfoView.showConfirmDialog(getVisualComponent(), "¿ Está seguro de eliminar el registro ?", "Seleccione una opción",
				InfoView.YES_NO_OPTION) != InfoView.YES_OPTION) {
			return;
		}

		@SuppressWarnings("unchecked")
		Vector<ReportesDefPerfil> bos = dataGrid.getSelectedObjects();
		for (int i = 0; i < bos.size(); i++) {
			deleteBo(bos.elementAt(i));
		}

		((ReportesDefPerfilABMView) this.getVisualComponent()).dataFetch();
	}

	/**
	 *
	 */
	public int insertBo(ReportesDefPerfil bo) {
		try {

			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			long reportesDefPerfilOid = bo.getReportesDefOid();
			long perfilOid = bo.getPerfilOid();

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schemaUtil = SystemProperties.SCHEMA_UTIL;

			long newOid = OidManager.newOid("REPORTESDEFPERFIL");
			String sql = " INSERT INTO " + schemaUtil + ".REPORTESDEFPERFIL (" + "OID, REPORTESDEFOID, PERFILOID, TIMESTAMP ) VALUES( " + newOid + ","
					+ reportesDefPerfilOid + "," + perfilOid + ",CURRENT TIMESTAMP)";
			int afectados = st.executeUpdate(sql);

			st.close();
			con.close();

			return afectados;

		} catch (Throwable t) {
			this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			this.handleException(true, t);
			return 0;
		}

	}

	/**
	 *
	 */
	public int updateBo(ReportesDefPerfil bo) {
		try {

			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			long reportesDefPerfilOid = bo.getReportesDefOid();
			long perfilOid = bo.getPerfilOid();

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schemaUtil = SystemProperties.SCHEMA_UTIL;

			String sql = "UPDATE " + schemaUtil + ".REPORTESDEFPERFIL SET " + " REPORTESDEFOID=" + reportesDefPerfilOid + ", PERFILOID=" + perfilOid
					+ ", TIMESTAMP=CURRENT TIMESTAMP" + " WHERE OID=" + bo.getOid();
			int afectados = st.executeUpdate(sql);

			st.close();
			con.close();

			return afectados;

		} catch (Throwable t) {
			this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			this.handleException(true, t);
			return 0;
		}

	}

	/**
	 *
	 */
	public int deleteBo(ReportesDefPerfil bo) {
		try {

			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schemaUtil = SystemProperties.SCHEMA_UTIL;

			String sql = "DELETE FROM " + schemaUtil + ".REPORTESDEFPERFIL " + " WHERE OID=" + bo.getOid();
			int afectados = st.executeUpdate(sql);

			st.close();
			con.close();

			return afectados;

		} catch (Throwable t) {
			this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			this.handleException(true, t);
			return 0;
		}

	}

	public Container getVisualComponent() {
		return visualComponent;
	}

	public void setVisualComponent(Container visualComponent) {
		this.visualComponent = visualComponent;
	}

	public ABMViewObserver getVisualObserver() {
		return visualObserver;
	}

	public void setVisualObserver(ABMViewObserver visualObserver) {
		this.visualObserver = visualObserver;
	}

	public Object getExceptionSource() {
		return exceptionSource;
	}

	public void setExceptionSource(Object exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

	/**
	 *
	 * @param exception
	 */
	public void handleException(boolean showErrorWindow, Throwable exception) {
		ExceptionManager.singleton().manage(getVisualComponent(), showErrorWindow, getExceptionSource(), exception);
	}

}
