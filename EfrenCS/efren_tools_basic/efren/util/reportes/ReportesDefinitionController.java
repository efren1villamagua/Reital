package efren.util.reportes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import efren.util.ABMViewObserver;
import efren.util.Conn;
import efren.util.ExceptionManager;
import efren.util.OidManager;
import efren.util.StringTools;
import efren.util.abm.estados.ABMEstado;
import efren.util.abm.estados.ABMEstadoModificado;
import efren.util.abm.estados.ABMEstadoNuevo;
import efren.util.config.SystemProperties;
import efren.util.gui.FinderSQLPanel;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTablePanel;
import efren.util.gui.text.TextFieldExt;
import inetsoft.report.StyleSheet;

public class ReportesDefinitionController {
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
	public ReportesDefinitionController(Container unComponenteVisual) {
		super();
		this.setVisualComponent(unComponenteVisual);
		this.setExceptionSource(this);
	}

	/**
	 *
	 * @param unComponenteVisual
	 */
	public ReportesDefinitionController(Container unComponenteVisual, ABMViewObserver unObservadorVisual) {
		super();
		this.setVisualComponent(unComponenteVisual);
		this.setExceptionSource(this);
		// ...
		this.setVisualObserver(unObservadorVisual);
	}

	/**
	 *
	 */
	public void buscarAll(FinderSQLPanel finderSQL, DataTablePanel dataTablePanel) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			dataTablePanel.clearSelection();
			dataTablePanel.removeAllRows();

			Vector<DefinicionReporte> data = new Vector<DefinicionReporte>();

			String schema = SystemProperties.SCHEMA_UTIL;

			String where = finderSQL.sql("");
			String orderBy = dataTablePanel.SQL_ORDER_BY_text("NOMBRE");

			String sql = "SELECT OID, NOMBRE, SENTENCIASQL, TITULO1, TITULO2, DETALLE, "
					+ "ALTOLINEAS, LLEVAANEXO, TIPOANEXO, ETIQUETAANEXO, VALORANEXO, SQLANEXO, "
					+ "TIPOIMPRESION, FONT, PLANTILLA, TABLESTYLE, ETIQUETASUBTOTALESQUIEBRE, ETIQUETATOTALGENERAL, "
					+ "REPETIRDATOSQUIEBRE, ARCHIVOIMPRESION, TIPO, TIMESTAMP " + " FROM " + schema + ".REPORTESDEF " + " WHERE 1=1 ";
			if (where.trim().length() > 0) {
				sql = sql + " AND " + where;
			}
			if (where.trim().length() == 0) {// todos los argumentos son
												// evaluados
				sql = sql + " AND 1=2 ";
			}
			// OJO TODO sql = sql + orderBy;

			Statement st = Conn.conectar().createStatement();
			ResultSet rs = st.executeQuery(sql);
			DefinicionReporte definicion;
			while (rs.next()) {
				definicion = new DefinicionReporte();
				definicion.setOid(rs.getLong("OID"));

				definicion.setNombre(rs.getString("NOMBRE").trim());
				definicion.setSentenciaSql(rs.getString("SENTENCIASQL").trim());
				definicion.setTitulo1(rs.getString("TITULO1").trim());
				definicion.setTitulo2(rs.getString("TITULO2").trim());
				definicion.setDetalle(rs.getString("DETALLE").trim());
				definicion.setAltoLinea(rs.getInt("ALTOLINEAS"));
				definicion.setLlevaAnexo(rs.getInt("LLEVAANEXO") == 1);
				definicion.setTipoAnexo(rs.getInt("TIPOANEXO"));
				definicion.setEtiquetaAnexo(rs.getString("ETIQUETAANEXO").trim());
				definicion.setValorAnexo(rs.getString("VALORANEXO").trim());
				definicion.setSqlAnexo(rs.getString("SQLANEXO").trim());
				definicion.setTipoImpresion(rs.getInt("TIPOIMPRESION"));
				definicion.setFont(rs.getString("FONT").trim());
				definicion.setPlantilla(rs.getString("PLANTILLA").trim());
				definicion.setTableStyle(rs.getString("TABLESTYLE").trim());
				definicion.setEtiquetaSubtotalesQuiebre(rs.getString("ETIQUETASUBTOTALESQUIEBRE").trim());
				definicion.setEtiquetaTotalGeneral(rs.getString("ETIQUETATOTALGENERAL").trim());
				definicion.setRepetirDatosQuiebre(rs.getInt("REPETIRDATOSQUIEBRE") == 1);
				definicion.setArchivoImpresion(rs.getString("ARCHIVOIMPRESION").trim());
				definicion.setTipo(rs.getString("TIPO").trim());
				definicion.setUtc(rs.getTimestamp("TIMESTAMP"));
				data.addElement(definicion);
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
	 */
	public void buscarForPerfil(long perfilOid, DataTablePanel dataTablePanel) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			dataTablePanel.clearSelection();
			dataTablePanel.removeAllRows();

			Vector<DefinicionReporte> data = new Vector<DefinicionReporte>();

			String schema = SystemProperties.SCHEMA_UTIL;

			String orderBy = dataTablePanel.SQL_ORDER_BY_text("NOMBRE");

			String sql = "SELECT rd.OID, rd.NOMBRE, rd.SENTENCIASQL, rd.TITULO1, rd.TITULO2, rd.DETALLE, "
					+ "rd.ALTOLINEAS, rd.LLEVAANEXO, rd.TIPOANEXO, rd.ETIQUETAANEXO, rd.VALORANEXO, rd.SQLANEXO, "
					+ "rd.TIPOIMPRESION, rd.FONT, rd.PLANTILLA, rd.TABLESTYLE, rd.ETIQUETASUBTOTALESQUIEBRE, rd.ETIQUETATOTALGENERAL, "
					+ "rd.REPETIRDATOSQUIEBRE, rd.ARCHIVOIMPRESION, rd.TIPO, rd.TIMESTAMP " + " FROM " + schema + ".REPORTESDEF rd, " + schema
					+ ".REPORTESDEFPERFIL rdp  " + " WHERE rdp.REPORTESDEFOID=rd.OID AND rdp.PERFILOID=" + perfilOid;
			// OJO TODO sql = sql + orderBy;

			Statement st = Conn.conectar().createStatement();
			ResultSet rs = st.executeQuery(sql);
			DefinicionReporte definicion;
			while (rs.next()) {
				definicion = new DefinicionReporte();
				definicion.setOid(rs.getLong("OID"));

				definicion.setNombre(rs.getString("NOMBRE").trim());
				definicion.setSentenciaSql(rs.getString("SENTENCIASQL").trim());
				definicion.setTitulo1(rs.getString("TITULO1").trim());
				definicion.setTitulo2(rs.getString("TITULO2").trim());
				definicion.setDetalle(rs.getString("DETALLE").trim());
				definicion.setAltoLinea(rs.getInt("ALTOLINEAS"));
				definicion.setLlevaAnexo(rs.getInt("LLEVAANEXO") == 1);
				definicion.setTipoAnexo(rs.getInt("TIPOANEXO"));
				definicion.setEtiquetaAnexo(rs.getString("ETIQUETAANEXO").trim());
				definicion.setValorAnexo(rs.getString("VALORANEXO").trim());
				definicion.setSqlAnexo(rs.getString("SQLANEXO").trim());
				definicion.setTipoImpresion(rs.getInt("TIPOIMPRESION"));
				definicion.setFont(rs.getString("FONT").trim());
				definicion.setPlantilla(rs.getString("PLANTILLA").trim());
				definicion.setTableStyle(rs.getString("TABLESTYLE").trim());
				definicion.setEtiquetaSubtotalesQuiebre(rs.getString("ETIQUETASUBTOTALESQUIEBRE").trim());
				definicion.setEtiquetaTotalGeneral(rs.getString("ETIQUETATOTALGENERAL").trim());
				definicion.setRepetirDatosQuiebre(rs.getInt("REPETIRDATOSQUIEBRE") == 1);
				definicion.setArchivoImpresion(rs.getString("ARCHIVOIMPRESION").trim());
				definicion.setTipo(rs.getString("TIPO").trim());
				definicion.setUtc(rs.getTimestamp("TIMESTAMP"));
				data.addElement(definicion);
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

		ReportesDefinitionABMDetailsView ventanaDetalle = new ReportesDefinitionABMDetailsView();

		ventanaDetalle.setVisualObserver(this.getVisualObserver());
		ventanaDetalle.setVentanaPrincipal((ReportesDefinitionABMView) this.getVisualComponent());

		ABMEstado estado = new ABMEstadoNuevo("NUEVA definición de reporte");
		ventanaDetalle.setEstadoABM(estado);

		DefinicionReporte bo = new DefinicionReporte();

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

		ReportesDefinitionABMDetailsView ventanaDetalle = new ReportesDefinitionABMDetailsView();

		ventanaDetalle.setVisualObserver(this.getVisualObserver());
		ventanaDetalle.setVentanaPrincipal((ReportesDefinitionABMView) this.getVisualComponent());

		ABMEstado estado = new ABMEstadoModificado("MODIFICAR definición de reporte");
		ventanaDetalle.setEstadoABM(estado);

		DefinicionReporte bo = (DefinicionReporte) dataGrid.getSelectedObject();

		ventanaDetalle.setBo(bo);
		ventanaDetalle.initAll();

		this.getVisualObserver().addFrame((JInternalFrame) this.getVisualComponent(), ventanaDetalle, String.valueOf(bo.getOid()), estado);
	}

	/**
	 *
	 */
	public void consultar(DataTablePanel dataGrid) throws Throwable {
		/*
		 * ReportesDefinitionABMDetailsView ventanaDetalle = new
		 * ReportesDefinitionABMDetailsView();
		 * 
		 * ventanaDetalle.setVisualObserver(this.getVisualObserver());
		 * ventanaDetalle.setVentanaPrincipal((ReportesDefinitionABMView)
		 * this.getVisualComponent());
		 * 
		 * ABMEstado estado = new ABMEstadoModificado(
		 * "CONSULTAR definición de reporte");
		 * ventanaDetalle.setEstadoABM(estado);
		 * 
		 * DefinicionReporte bo = (DefinicionReporte)
		 * dataGrid.getSelectedObject();
		 * 
		 * ventanaDetalle.setBo(bo); ventanaDetalle.initAll();
		 * 
		 * this.getVisualObserver().addFrame((JInternalFrame)
		 * this.getVisualComponent(), ventanaDetalle,
		 * String.valueOf(bo.getOid()), estado);
		 */
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

		Vector<DefinicionReporte> bos = dataGrid.getSelectedObjects();
		for (int i = 0; i < bos.size(); i++) {
			deleteBo(bos.elementAt(i));
		}

		((ReportesDefinitionABMView) this.getVisualComponent()).dataFetch();
	}

	/**
	 *
	 */
	public int insertBo(DefinicionReporte bo) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			String nombre = bo.getNombre().trim();
			String sentenciaSql = StringTools.parseComilla(bo.getSentenciaSql());
			String titulo1 = bo.getTitulo1();
			String titulo2 = bo.getTitulo2();
			String plantilla = bo.getPlantilla();
			String tableStyle = bo.getTableStyle();
			String etiquetaSubtotalesQuiebre = bo.getEtiquetaSubtotalesQuiebre();
			String etiquetaTotalGeneral = bo.getEtiquetaTotalGeneral();
			int repetirDatosQuiebre = 0;
			if (bo.isRepetirDatosQuiebre()) {
				repetirDatosQuiebre = 1;
			}
			String detalle = bo.getDetalle();
			int altoLinea = bo.getAltoLinea();
			String font = bo.getFont();
			int llevaAnexo = 0;
			if (bo.isLlevaAnexo()) {
				llevaAnexo = 1;
			}
			int tipoAnexo = bo.getTipoAnexo();
			String etiquetaAnexo = bo.getEtiquetaAnexo();
			String valorAnexo = bo.getValorAnexo();
			String sqlAnexo = StringTools.parseComilla(bo.getSqlAnexo());
			int tipoImpresion = bo.getTipoImpresion();
			String archivoImpresion = bo.getArchivoImpresion();
			String tipo = bo.getTipo();

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schema = SystemProperties.SCHEMA_UTIL;

			long newOid = OidManager.newOid("REPORTESDEF");
			String sql = " INSERT INTO " + schema + ".REPORTESDEF ("
					+ "OID, NOMBRE, SENTENCIASQL, TITULO1,TITULO2,PLANTILLA,TABLESTYLE,ETIQUETASUBTOTALESQUIEBRE,"
					+ "ETIQUETATOTALGENERAL,REPETIRDATOSQUIEBRE,DETALLE,ALTOLINEAS,FONT," + "LLEVAANEXO, TIPOANEXO, ETIQUETAANEXO, VALORANEXO, SQLANEXO, "
					+ "TIPOIMPRESION,ARCHIVOIMPRESION, TIPO, TIMESTAMP ) VALUES( " + newOid + ",'" + nombre + "','" + sentenciaSql + "','" + titulo1 + "','"
					+ titulo2 + "','" + plantilla + "','" + tableStyle + "','" + etiquetaSubtotalesQuiebre + "'," + "'" + etiquetaTotalGeneral + "',"
					+ repetirDatosQuiebre + ",'" + detalle + "'," + altoLinea + ",'" + font + "'," + llevaAnexo + "," + tipoAnexo + ",'" + etiquetaAnexo + "','"
					+ valorAnexo + "','" + sqlAnexo + "'," + tipoImpresion + ",'" + archivoImpresion + "','" + tipo + "',CURRENT TIMESTAMP)";
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
	public int updateBo(DefinicionReporte bo) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			String nombre = bo.getNombre().trim();
			String sentenciaSql = StringTools.parseComilla(bo.getSentenciaSql());
			String titulo1 = bo.getTitulo1();
			String titulo2 = bo.getTitulo2();
			String plantilla = bo.getPlantilla();
			String tableStyle = bo.getTableStyle();
			String etiquetaSubtotalesQuiebre = bo.getEtiquetaSubtotalesQuiebre();
			String etiquetaTotalGeneral = bo.getEtiquetaTotalGeneral();
			int repetirDatosQuiebre = 0;
			if (bo.isRepetirDatosQuiebre()) {
				repetirDatosQuiebre = 1;
			}
			String detalle = bo.getDetalle();
			int altoLinea = bo.getAltoLinea();
			String font = bo.getFont();
			int llevaAnexo = 0;
			if (bo.isLlevaAnexo()) {
				llevaAnexo = 1;
			}
			int tipoAnexo = bo.getTipoAnexo();
			String etiquetaAnexo = bo.getEtiquetaAnexo();
			String valorAnexo = bo.getValorAnexo();
			String sqlAnexo = StringTools.parseComilla(bo.getSqlAnexo());
			int tipoImpresion = bo.getTipoImpresion();
			String archivoImpresion = bo.getArchivoImpresion();
			String tipo = bo.getTipo();

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schema = SystemProperties.SCHEMA_UTIL;

			long oid = bo.getOid();
			String sql = "UPDATE " + schema + ".REPORTESDEF SET " + "NOMBRE='" + nombre + "'," + "SENTENCIASQL='" + sentenciaSql + "', TITULO1='" + titulo1
					+ "', TITULO2='" + titulo2 + "', PLANTILLA='" + plantilla + "'," + "TABLESTYLE='" + tableStyle + "',ETIQUETASUBTOTALESQUIEBRE='"
					+ etiquetaSubtotalesQuiebre + "'," + "ETIQUETATOTALGENERAL='" + etiquetaTotalGeneral + "', REPETIRDATOSQUIEBRE=" + repetirDatosQuiebre + ","
					+ "DETALLE='" + detalle + "', ALTOLINEAS=" + altoLinea + ", FONT='" + font + "'," + "LLEVAANEXO=" + llevaAnexo + ",TIPOANEXO=" + tipoAnexo
					+ ", ETIQUETAANEXO='" + etiquetaAnexo + "'," + "VALORANEXO='" + valorAnexo + "', SQLANEXO='" + sqlAnexo + "', TIPOIMPRESION="
					+ tipoImpresion + "," + "ARCHIVOIMPRESION='" + archivoImpresion + "', TIPO='" + tipo + "', TIMESTAMP=CURRENT TIMESTAMP " + " WHERE OID="
					+ oid;
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
	public int deleteBo(DefinicionReporte bo) {
		try {
			this.getVisualComponent().setCursor(new Cursor(Cursor.WAIT_CURSOR));

			Connection con = Conn.conectar();
			Statement st = con.createStatement();

			String schema = SystemProperties.SCHEMA_UTIL;

			long oid = bo.getOid();
			String sql = "DELETE FROM " + schema + ".REPORTESDEF " + " WHERE OID=" + oid;
			int afectados = st.executeUpdate(sql);

			st.close();
			con.close();

			this.getVisualComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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

	/**
	 *
	 */
	public static String parse_variables_to_SQL(String sql, Vector<TextFieldExt> unaListaCamposVariables, Vector<TextFieldExt> unaListaCamposValores) {
		try {
			/**
			 * PARSE DE VARIABLES DE SISTEMA
			 */
			sql = StringTools.replaceAll(sql, "&&USUARIOOID", String.valueOf(SystemProperties.RUNTIME_USUARIOOID), false);
			sql = StringTools.replaceAll(sql, "&&RUNTIME_USUARIO_CODIGO_ALTERNO", String.valueOf(SystemProperties.RUNTIME_USUARIO_CODIGO_ALTERNO), false);
			sql = StringTools.replaceAll(sql, "&&RUNTIME_DEPENDENCIA_CODIGO", String.valueOf(SystemProperties.RUNTIME_DEPENDENCIA_CODIGO), false);

			/**
			 *
			 */
			String name, valor, nameInSQL;
			Hashtable<String, String> tablaValores = new Hashtable<String, String>();
			for (int i = 0; i < unaListaCamposVariables.size(); i++) {
				name = ((TextFieldExt) unaListaCamposVariables.elementAt(i)).getValue().trim();
				nameInSQL = "[_" + name + "_]";
				valor = ((TextFieldExt) unaListaCamposValores.elementAt(i)).getValue().trim().replace('*', '%');
				if (sql != null && sql.toUpperCase().indexOf(nameInSQL.toUpperCase()) > 0) {
					/**
					 * se encuentra la variable en la sentencia
					 */
					tablaValores.put(name, valor);
				}
			}
			Enumeration<String> enumTemp = tablaValores.keys();
			String variable;
			while (enumTemp.hasMoreElements()) {
				variable = enumTemp.nextElement().toString();
				valor = tablaValores.get(variable).toString();
				nameInSQL = "[_" + variable + "_]";
				sql = StringTools.replaceAll(sql, nameInSQL, valor, false);
			}
			// se quita los caracteres separadores y las variables no usadas
			String temp1, temp2;
			int indice;
			while (sql.indexOf("[_") >= 0) {
				indice = sql.indexOf("[_");
				if (sql.indexOf("[_") >= 0) {
					// ...cadena antes del separador inicial de variable
					temp1 = sql.substring(0, indice);
					if (temp1.lastIndexOf("{_") >= 0) {
						temp1 = temp1.substring(0, temp1.lastIndexOf("{_"));
						// ...cadena despues del separador final de variable
						temp2 = sql.substring(sql.indexOf("_}", indice) + 2);
						// ...la cadena
						sql = temp1 + " " + temp2;
					}
				}
			}
			sql = StringTools.replaceAll(sql, "{_", "", false);
			sql = StringTools.replaceAll(sql, "_}", "", false);

			return sql;

		} catch (Throwable t) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(new JFrame(), t.getMessage());
			return sql;
		}
	}

	/**
	 *
	 */
	public static Vector<Vector<TextFieldExt>> extractVarsAndValuesFrom(Vector<TextFieldExt> unaListaVariablesTFExt,
			Vector<TextFieldExt> unaListaValoresTFExt) {
		try {
			TextFieldExt campoVariable, campoValor;
			Vector<TextFieldExt> lista1 = new Vector<TextFieldExt>(), lista2 = new Vector<TextFieldExt>();
			for (int i = 0; i < unaListaVariablesTFExt.size(); i++) {
				campoVariable = (TextFieldExt) unaListaVariablesTFExt.elementAt(i);
				campoValor = (TextFieldExt) unaListaValoresTFExt.elementAt(i);
				if (campoVariable.getValue() != null && campoVariable.getValue().trim().length() > 0 && campoValor.getValue() != null
						&& campoValor.getValue().trim().length() > 0) {
					lista1.addElement(campoVariable);
					lista2.addElement(campoValor);
				}
			}
			Vector<Vector<TextFieldExt>> resultado = new Vector<Vector<TextFieldExt>>();
			resultado.addElement(lista1);
			resultado.addElement(lista2);
			return resultado;
		} catch (Throwable t) {
			return null;
		}
	}

	/**
	 *
	 */
	public boolean _buildAll(DefinicionReporte definicionReporte, DetallesPresentacionPanel dpp, DetallesImpresionPanel dip,
			Vector<TextFieldExt> textFieldsVariables, Vector<TextFieldExt> textFieldsValores) {

		try {

			/**
			 * CONSTRUCCION DEL SQL
			 */
			String sqlFinal = null;
			Vector<Vector<TextFieldExt>> listasCampos = null;
			try {
				String sentenciaSQL = definicionReporte.getSentenciaSql().trim();
				listasCampos = ReportesDefinitionController.extractVarsAndValuesFrom(textFieldsVariables, textFieldsValores);

				sqlFinal = ReportesDefinitionController.parse_variables_to_SQL(sentenciaSQL, (Vector<TextFieldExt>) listasCampos.elementAt(0),
						(Vector<TextFieldExt>) listasCampos.elementAt(1));

			} catch (Throwable t66) {
				InfoView.showErrorDialog(getVisualComponent(), t66.getMessage());
				return false;
			}
			/**
			 *
			 */
			String titulo03 = "";
			if (listasCampos != null) {// CONSTRUCCION DEL TITULO03
				try {
					Vector<TextFieldExt> nombresVariables = (Vector<TextFieldExt>) listasCampos.elementAt(0);
					Vector<TextFieldExt> valoresVariables = (Vector<TextFieldExt>) listasCampos.elementAt(1);
					for (int i = 0; i < nombresVariables.size(); i++) {
						try {
							titulo03 = titulo03 + ((TextFieldExt) nombresVariables.elementAt(i)).getValue().trim().replace('*', ' ') + ": "
									+ ((TextFieldExt) valoresVariables.elementAt(i)).getValue().trim();
							if (i < nombresVariables.size() - 1)
								titulo03 = titulo03 + "  ";
						} catch (Exception ex1) {
							ex1.getMessage();
						}
					}
				} catch (Exception ex2) {
					ex2.getMessage();
				}
			}
			String unExtraCode = null;
			if (definicionReporte.getNombre() != null && definicionReporte.getNombre().trim().length() > 0
					&& definicionReporte.getNombre().trim().indexOf("[&PBAQ]") >= 0) {
				unExtraCode = "[&PBAQ]";
			}

			/**
			 * DATOS
			 */
			StyleSheet reporte = null;

			Statement st = Conn.conectar().createStatement();
			ResultSet rs = st.executeQuery(sqlFinal);

			reporte = dpp._buildReport(rs, null, null, null, titulo03, unExtraCode);

			st.close();

			/**
			 * anexo
			 */
			try {
				/*
				 * if (definicionReporte.isLlevaAnexo()) {
				 * reporte.addNewline(2);
				 * reporte.setCurrentFont(dpp.getFont1());
				 * 
				 * if (definicionReporte.getTipoAnexo() == 1) {
				 * reporte.addText(definicionReporte.getEtiquetaAnexo().trim() +
				 * " " + definicionReporte.getValorAnexo().trim()); } else {
				 * String sentenciaSQL = definicionReporte.getSqlAnexo().trim();
				 * listasCampos =
				 * ReportesDefinitionController.extractVarsAndValuesFrom(
				 * textFieldsVariables, textFieldsValores);
				 * 
				 * sqlFinal =
				 * ReportesDefinitionController.parse_variables_to_SQL(
				 * sentenciaSQL, (Vector<TextFieldExt>)
				 * listasCampos.elementAt(0), (Vector<TextFieldExt>)
				 * listasCampos.elementAt(1)); rs = st.executeQuery(sqlFinal);
				 * 
				 * reporte.addPageBreak();
				 * reporte.setCurrentAlignment(StyleConstants.LEFT);
				 * 
				 * reporte.addText(definicionReporte.getEtiquetaAnexo().trim());
				 * reporte.addNewline(1);
				 * 
				 * Vector<Integer> columnTypesAnexo = new Vector<Integer>(); for
				 * (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				 * columnTypesAnexo.addElement(new
				 * Integer(rs.getMetaData().getColumnType(i))); } JDBCTableLens
				 * jdbcTableAnexo = new JDBCTableLens(rs); Grid7 tsAnexo = new
				 * Grid7(jdbcTableAnexo); // tsAnexo.setApplyColWidth(true);
				 * tsAnexo.setColAutoSize(true); for (int i = 0; i <
				 * columnTypesAnexo.size(); i++) { try { if (((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.DATE) {
				 * tsAnexo.setColAlignment(i, StyleSheet.RIGHT); // fechas
				 * alineadas a la derecha tsAnexo.setFormat(i, new
				 * java.text.SimpleDateFormat("dd-MMM-yyyy"));
				 * tsAnexo.setColWidth(i, 120); } else { if (((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.BIGINT ||
				 * ((Integer) columnTypesAnexo.elementAt(i)).intValue() ==
				 * Types.INTEGER || ((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.SMALLINT)
				 * { tsAnexo.setColAlignment(i, StyleConstants.RIGHT);
				 * tsAnexo.setFormat(i, new java.text.DecimalFormat("###,###"));
				 * tsAnexo.setColWidth(i, 130); } else { if (((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.DECIMAL ||
				 * ((Integer) columnTypesAnexo.elementAt(i)).intValue() ==
				 * Types.DOUBLE || ((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.FLOAT ||
				 * ((Integer) columnTypesAnexo.elementAt(i)).intValue() ==
				 * Types.NUMERIC || ((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.REAL) {
				 * tsAnexo.setColAlignment(i, StyleConstants.RIGHT);
				 * tsAnexo.setFormat(i, new
				 * java.text.DecimalFormat("###,##0.00"));
				 * tsAnexo.setColWidth(i, 160); } else { if (((Integer)
				 * columnTypesAnexo.elementAt(i)).intValue() == Types.TIME ||
				 * ((Integer) columnTypesAnexo.elementAt(i)).intValue() ==
				 * Types.TIMESTAMP) { tsAnexo.setColAlignment(i,
				 * StyleConstants.RIGHT); tsAnexo.setColWidth(i, 160); } } } } }
				 * catch (Exception e) { e.getMessage(); } }
				 * reporte.setCurrentTableLayout(ReportSheet.TABLE_FIT_CONTENT);
				 * tsAnexo.setRowFont(0, new Font("Arial", Font.PLAIN, 10));
				 * reporte.addTable(tsAnexo); } }
				 */
			} catch (Throwable t) {
				t.getMessage();
				InfoView.showErrorDialog(getVisualComponent(), "Error en el anexo: " + t.getMessage());
			}

			dip._print(reporte, dpp.papelSeleccionado(), dpp.esOrientacionHorizontal(), definicionReporte.getNombre().trim());

			return true;

		} catch (Throwable texc1) {
			handleException(true, texc1);
		}

		return false;

	}

	/**
	 *
	 */
	public void _showVariables(DefinicionReporte definicionReporte, Vector<TextFieldExt> textFieldsVariables, Vector<TextFieldExt> textFieldsValores) {

		try {
			// SQL DEL REPORTE
			String sentencia = definicionReporte.getSentenciaSql().trim();

			Hashtable<String, String> hashVariables = new Hashtable<String, String>();
			Vector<String> vectorVariables = new Vector<String>();

			int posicionEspacio = 0;
			int posicionPorcentaje = 0;
			boolean hayMasVariables = sentencia.indexOf("[_") >= 0;
			String variable = null;
			while (hayMasVariables) {
				posicionEspacio = sentencia.indexOf("_]", sentencia.indexOf("[_"));
				posicionPorcentaje = sentencia.indexOf("[_");
				if (posicionEspacio >= 0)
					variable = sentencia.substring(posicionPorcentaje + 2, posicionEspacio);
				else
					variable = sentencia.substring(posicionPorcentaje);
				if (!hashVariables.contains(variable.trim())) {
					vectorVariables.addElement(variable.trim());
				}
				hashVariables.put(variable.trim(), variable.trim());
				if (posicionEspacio >= 0)
					sentencia = sentencia.substring(posicionEspacio);
				else
					sentencia = sentencia.substring(posicionPorcentaje + variable.length());
				hayMasVariables = sentencia.indexOf("[_") >= 0;
			}

			// SQL DEL ANEXO
			if (definicionReporte.getSqlAnexo() != null) {
				try {

					sentencia = definicionReporte.getSqlAnexo().trim();

					posicionEspacio = 0;
					posicionPorcentaje = 0;
					hayMasVariables = sentencia.indexOf("[_") >= 0;
					variable = null;
					while (hayMasVariables) {
						posicionEspacio = sentencia.indexOf("_]", sentencia.indexOf("[_"));
						posicionPorcentaje = sentencia.indexOf("[_");
						if (posicionEspacio >= 0)
							variable = sentencia.substring(posicionPorcentaje + 2, posicionEspacio);
						else
							variable = sentencia.substring(posicionPorcentaje);
						if (!hashVariables.contains(variable.trim())) {
							vectorVariables.addElement(variable.trim());
						}
						hashVariables.put(variable.trim(), variable.trim());
						if (posicionEspacio >= 0)
							sentencia = sentencia.substring(posicionEspacio);
						else
							sentencia = sentencia.substring(posicionPorcentaje + variable.length());
						hayMasVariables = sentencia.indexOf("[_") >= 0;
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			}

			// ...
			textFieldsVariables.elementAt(0).setForeground(Color.black);
			textFieldsVariables.elementAt(1).setForeground(Color.black);
			textFieldsVariables.elementAt(2).setForeground(Color.black);
			textFieldsVariables.elementAt(3).setForeground(Color.black);
			textFieldsVariables.elementAt(4).setForeground(Color.black);
			textFieldsVariables.elementAt(5).setForeground(Color.black);
			textFieldsVariables.elementAt(6).setForeground(Color.black);
			textFieldsVariables.elementAt(7).setForeground(Color.black);

			textFieldsVariables.elementAt(0).setValue("");
			textFieldsVariables.elementAt(1).setValue("");
			textFieldsVariables.elementAt(2).setValue("");
			textFieldsVariables.elementAt(3).setValue("");
			textFieldsVariables.elementAt(4).setValue("");
			textFieldsVariables.elementAt(5).setValue("");
			textFieldsVariables.elementAt(6).setValue("");
			textFieldsVariables.elementAt(7).setValue("");

			textFieldsValores.elementAt(0).setValue("");
			textFieldsValores.elementAt(1).setValue("");
			textFieldsValores.elementAt(2).setValue("");
			textFieldsValores.elementAt(3).setValue("");
			textFieldsValores.elementAt(4).setValue("");
			textFieldsValores.elementAt(5).setValue("");
			textFieldsValores.elementAt(6).setValue("");
			textFieldsValores.elementAt(7).setValue("");

			// ...
			String variableTemp;
			int m = 0;
			boolean obligatorio;

			for (int i = 0; i < vectorVariables.size(); i++) {
				variableTemp = efren.util.StringTools.replaceAll(vectorVariables.elementAt(i).toString(), "'", "", false);
				obligatorio = false;
				if (variableTemp.startsWith("*")) {
					obligatorio = true;
				}
				if (m == 0) {
					textFieldsVariables.elementAt(0).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(0).setForeground(Color.red);
					}
				}
				if (m == 1) {
					textFieldsVariables.elementAt(1).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(1).setForeground(Color.red);
					}
				}
				if (m == 2) {
					textFieldsVariables.elementAt(2).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(2).setForeground(Color.red);
					}
				}
				if (m == 3) {
					textFieldsVariables.elementAt(3).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(3).setForeground(Color.red);
					}
				}
				if (m == 4) {
					textFieldsVariables.elementAt(4).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(4).setForeground(Color.red);
					}
				}
				if (m == 5) {
					textFieldsVariables.elementAt(5).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(5).setForeground(Color.red);
					}
				}
				if (m == 6) {
					textFieldsVariables.elementAt(6).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(6).setForeground(Color.red);
					}
				}
				if (m == 7) {
					textFieldsVariables.elementAt(7).setValue(variableTemp);
					if (obligatorio) {
						textFieldsVariables.elementAt(7).setForeground(Color.red);
					}
				}
				m++;
			}

		} catch (Throwable t) {
			t.getMessage();
		}
	}

}
