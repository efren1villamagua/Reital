package efren.util.reportes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTable;

import efren.util.CalendarManager;
import efren.util.DefaultCellEditor;
import efren.util.config.SystemProperties;
import efren.util.gui.MultiChoice;
import efren.util.gui.ReportTableStyleChooser;
import efren.util.gui.dialogs.InfoView;
import efren.util.reportes.tools.ColorEditor;
import efren.util.reportes.tools.ColorRenderer;
import efren.util.reportes.tools.TableModel;
import inetsoft.report.ReportEnv;
import inetsoft.report.StyleConstants;
import inetsoft.report.StyleFont;
import inetsoft.report.StyleSheet;
import inetsoft.report.TableFilter;
import inetsoft.report.TableLens;
import inetsoft.report.filter.CountFormula;
import inetsoft.report.filter.DefaultSortedTable;
import inetsoft.report.filter.Formula;
import inetsoft.report.filter.GroupFilter;
import inetsoft.report.filter.SumFormula;
import inetsoft.report.filter.TableSummaryFilter;
import inetsoft.report.filter.style.LeadingBreak;
import inetsoft.report.io.Builder;
import inetsoft.report.lens.DefaultTableLens;
import inetsoft.report.lens.JDBCTableLens;
import inetsoft.report.lens.swing.JTableLens;
import inetsoft.report.style.Simple4;
import inetsoft.report.style.TableStyle;

public class DetallesPresentacionPanel extends javax.swing.JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -6303318635175158909L;

	/**
	 *
	 */
	public static final int A4 = 1;

	public static final int CARTA = 2;

	public static final int OFICIO = 3;

	// ...
	public static final int VERTICAL = 1;

	public static final int HORIZONTAL = 2;

	public static final int TIPO_TABLA_RESULTSET = 1;

	public static final int TIPO_TABLA_JTABLE = 2;

	public static final int TIPO_TABLA_TABLELENS = 3;

	// ...
	private efren.util.gui.fontchooser.FontChooser ivjFontChooser = null;

	private javax.swing.JCheckBox ivjJCheckBoxAplicarEstilo = null;

	private javax.swing.JCheckBox ivjJCheckBoxMostrarEtiquetasSubtotales = null;

	private javax.swing.JCheckBox ivjJCheckBoxRepetirDatosQuiebre = null;

	private javax.swing.JPanel ivjJPanel = null;

	private javax.swing.JScrollPane ivjJScrollPane1 = null;

	private javax.swing.JTable ivjJTableDetalles = null;

	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBoxPapel = null;

	private efren.util.gui.LabelExt ivjLabelExt = null;

	private efren.util.gui.LabelExt ivjLabelExt1 = null;

	private efren.util.gui.LabelExt ivjLabelExt10 = null;

	private efren.util.gui.LabelExt ivjLabelExt12 = null;

	private efren.util.gui.LabelExt ivjLabelExt5 = null;

	private efren.util.gui.LabelExt ivjLabelExt7 = null;

	private javax.swing.table.TableColumn ivjTableColumn_00_NombreSQL = null;

	private javax.swing.table.TableColumn ivjTableColumn_01_Nombre = null;

	private javax.swing.table.TableColumn ivjTableColumn_02_Ancho = null;

	private javax.swing.table.TableColumn ivjTableColumn_03_Tiene_Quiebre = null;

	private javax.swing.table.TableColumn ivjTableColumn_04_Formula_Quiebre = null;

	private javax.swing.table.TableColumn ivjTableColumn_05_Formula_Total = null;

	private javax.swing.table.TableColumn ivjTableColumn_06_Unidad_de_medida = null;

	private javax.swing.table.TableColumn ivjTableColumn_07_Es_Negritas = null;

	private javax.swing.table.TableColumn ivjTableColumn_08_Color = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtAltoFila = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtEtiquetaSubTotales = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtEtiquetaTotal = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtTitulo1 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtTitulo2 = null;

	IvjEventHandler ivjEventHandler = new IvjEventHandler();

	private Font font0;

	private Font font1;

	private efren.util.gui.ReportTableStyleChooser ivjReportTableStyleChooser = null;

	private efren.util.gui.LabelExt ivjLabelExt13 = null;

	private boolean express;

	public String REPORT_TEMPLATES_PATH = null;

	private MultiChoice multiChoiceOrientacion = null;

	class IvjEventHandler implements ItemListener, java.beans.PropertyChangeListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == DetallesPresentacionPanel.this.getJCheckBoxMostrarEtiquetasSubtotales())
				connEtoC1(e);
			if (e.getSource() == DetallesPresentacionPanel.this.getJCheckBoxAplicarEstilo())
				connEtoC2(e);
		};

		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == DetallesPresentacionPanel.this.getTextFieldExtTitulo1() && (evt.getPropertyName().equals("value")))
				connEtoC4(evt);
			if (evt.getSource() == DetallesPresentacionPanel.this.getTextFieldExtTitulo2() && (evt.getPropertyName().equals("value")))
				connEtoC5(evt);
		};
	};

	/**
	 *
	 */
	private static void setTitles(StyleSheet reporte, String unTitulo01, String unTitulo02, String unTitulo03) throws Throwable {
		// ALGUNOS DATOS DENTRO DEL REPORTE
		if (reporte.getElement("TextBox_TITULO1") != null) {
			if (unTitulo01 != null && unTitulo01.trim().length() > 0)
				reporte.setElement("TextBox_TITULO1", unTitulo01.trim());
			else
				reporte.setElement("TextBox_TITULO1", "");
		}

		if (reporte.getElement("TextBox_TITULO2") != null) {
			if (unTitulo02 != null && unTitulo02.trim().length() > 0)
				reporte.setElement("TextBox_TITULO2", unTitulo02.trim());
			else
				reporte.setElement("TextBox_TITULO2", "");
		}

		if (reporte.getElement("TextBox_TITULO3") != null) {
			if (unTitulo03 != null && unTitulo03.trim().length() > 0)
				reporte.setElement("TextBox_TITULO3", unTitulo03.trim());
			else
				reporte.setElement("TextBox_TITULO3", " ");
		}

		if (reporte.getElement("TextBox_TIMESTAMP") != null) {
			CalendarManager cm = new CalendarManager();
			reporte.setElement("TextBox_TIMESTAMP", "Impreso: " + cm.getAbsoluteRegionalDateExpression());
		}
		if (reporte.getElement("TextBox_ELABORADO_POR") != null) {
			reporte.setElement("TextBox_ELABORADO_POR", SystemProperties.RUNTIME_USER_NAME + " - " + SystemProperties.RUNTIME_NOMBRE_USUARIO);
		}
	}

	/**
	 *
	 */
	public static String _construirDetalle_forSQL(JTable jTableDetalles) {

		TableModel detallesModel = (TableModel) jTableDetalles.getModel();
		try {
			TableModel model = detallesModel;
			String detalle = "", nombre, ancho, quiebre, formulaQuiebre, formulaTotal, unidadMedida, negritas, color;
			for (int i = 0; i < detallesModel.getRowCount(); i++) {
				nombre = model.getValueAt(i, 1).toString().trim();
				if (nombre.trim().length() == 0)
					nombre = " ";
				ancho = model.getValueAt(i, 2).toString().trim();
				if (ancho.trim().length() == 0)
					ancho = " ";
				quiebre = model.getValueAt(i, 3).toString().trim();
				formulaQuiebre = model.getValueAt(i, 4).toString().trim();
				if (formulaQuiebre == null || formulaQuiebre.trim().length() == 0)
					formulaQuiebre = "NINGUNA";
				formulaTotal = model.getValueAt(i, 5).toString().trim();
				if (formulaTotal == null || formulaTotal.trim().length() == 0)
					formulaTotal = "NINGUNA";
				unidadMedida = model.getValueAt(i, 6).toString().trim();
				if (unidadMedida.trim().length() == 0)
					unidadMedida = " ";
				negritas = model.getValueAt(i, 7).toString().trim();
				color = String.valueOf(((Color) model.getValueAt(i, 8)).getRGB());

				detalle = detalle + nombre + ";" + ancho + ";" + quiebre + ";" + formulaQuiebre + ";" + formulaTotal + ";" + unidadMedida + ";" + negritas + ";"
						+ color;

				if (i < detallesModel.getRowCount() - 1)
					detalle = detalle + "&&";
			}
			return detalle;
		} catch (Throwable t) {
			return "";
		}
	}

	/**
	 *
	 */
	public static void _construirFilasDetalle_fromSQL(TableModel detallesModel, Vector<String> nombresColumnasSQL, String detalles) {
		try {
			if (nombresColumnasSQL == null || nombresColumnasSQL.size() == 0) {
				detallesModel.removeAllRows();
				return;
			}

			// ...se recoge para las demás columnas lo que está definido en los
			// detalles
			java.util.StringTokenizer stk2 = new java.util.StringTokenizer(detalles, "&&");
			java.util.StringTokenizer stk3;
			Vector<Object> filasDetalle = new Vector<Object>();
			while (stk2.hasMoreElements()) {
				filasDetalle.addElement(stk2.nextElement());
			}
			// ...primero se elimina las filas existentes
			detallesModel.removeAllRows();

			for (int j = 0; j < nombresColumnasSQL.size(); j++) {

				Vector<Object> fila = new Vector<Object>();
				fila.addElement(nombresColumnasSQL.elementAt(j).trim());
				stk3 = new java.util.StringTokenizer(filasDetalle.elementAt(j).toString(), ";");

				fila.addElement(stk3.nextToken().toString().trim());
				fila.addElement(stk3.nextToken().toString().trim());
				fila.addElement(new Boolean(stk3.nextToken().toString().trim()));
				fila.addElement(stk3.nextToken().toString().trim());
				fila.addElement(stk3.nextToken().toString().trim());
				fila.addElement(stk3.nextToken().toString().trim());
				fila.addElement(new Boolean(stk3.nextToken().toString().trim()));
				if (stk3.hasMoreElements()) {
					fila.addElement(new Color(new Integer(stk3.nextToken().toString().trim()).intValue()));
				} else {
					fila.addElement(Color.black);
				}

				detallesModel.addRow(fila);

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 *
	 */
	public static Vector<String> _nombresSQLColumnas(String unSQL) {

		if (unSQL == null || unSQL.trim().length() == 0)
			return new Vector<String>();

		int indexOfSELECT = unSQL.toUpperCase().indexOf("SELECT");
		int indexOfFROM = unSQL.toUpperCase().indexOf("FROM");
		String columnasStr = unSQL.substring(indexOfSELECT + 1 + 6, indexOfFROM);

		Vector<String> columnasSQL = new Vector<String>();
		// se separa las columnas por medio de ','
		java.util.StringTokenizer stk1 = new java.util.StringTokenizer(columnasStr, ",");
		while (stk1.hasMoreElements())
			columnasSQL.addElement(stk1.nextToken());

		String columnaSQL;
		Vector<String> cols = new Vector<String>();
		for (int i = 0; i < columnasSQL.size(); i++) {
			columnaSQL = columnasSQL.elementAt(i).toString().trim();
			if (columnaSQL.indexOf(" ") > 0) {
				cols.addElement(columnaSQL.substring(columnaSQL.lastIndexOf(" ") + 1));
			} else
				cols.addElement(columnaSQL);
		}

		return cols;
	}

	/**
	 *
	 */
	public static void _formatearColumnasPorTipoSQL(TableStyle tableStyle, Vector<Integer> tiposColumnasFromJDBC, TableModel detallesModel) {

		int tipoColumna;
		String unidadDeMedida;

		for (int i = 0; i < tiposColumnasFromJDBC.size(); i++) {

			tipoColumna = tiposColumnasFromJDBC.elementAt(i).intValue();

			try {

				unidadDeMedida = "";
				if (detallesModel.getValueAt(i, 6) != null) {
					unidadDeMedida = detallesModel.getValueAt(i, 6).toString().replace('.', ' ').replace(',', ' ');
				}

				switch (tipoColumna) {
				case Types.DATE:
					tableStyle.setColAlignment(i, StyleSheet.RIGHT);
					tableStyle.setFormat(i, new SimpleDateFormat("dd-MMM-yyyy"));
					break;
				case Types.TIME:
				case Types.TIMESTAMP:
					tableStyle.setColAlignment(i, StyleSheet.RIGHT);
					break;
				case Types.SMALLINT:
				case Types.INTEGER:
				case Types.BIGINT:
					tableStyle.setColAlignment(i, StyleConstants.RIGHT);
					if (unidadDeMedida != null && unidadDeMedida.trim().length() > 0) {
						tableStyle.setFormat(i, new DecimalFormat(unidadDeMedida.trim() + " ###,###"));
					} else {
						tableStyle.setFormat(i, new DecimalFormat("###,###"));
					}
					break;
				case Types.DECIMAL:
				case Types.DOUBLE:
				case Types.FLOAT:
				case Types.NUMERIC:
				case Types.REAL:
					tableStyle.setColAlignment(i, StyleConstants.RIGHT);
					if (unidadDeMedida != null && unidadDeMedida.trim().length() > 0) {
						tableStyle.setFormat(i, new DecimalFormat(unidadDeMedida.trim() + " ###,##0.00"));
					} else {
						tableStyle.setFormat(i, new DecimalFormat("###,##0.00"));
					}
					break;
				default:
					break;
				}

			} catch (Throwable t22) {
				t22.getMessage();
			}
		}
	}

	/**
	 * DetallesPresentacionPanel constructor comment.
	 */
	public DetallesPresentacionPanel() {
		super();
		initialize();
	}

	/**
	 * DetallesPresentacionPanel constructor comment.
	 *
	 * @param layout
	 *            LayoutManager
	 */
	public DetallesPresentacionPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * DetallesPresentacionPanel constructor comment.
	 *
	 * @param layout
	 *            LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public DetallesPresentacionPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * DetallesPresentacionPanel constructor comment.
	 *
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public DetallesPresentacionPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 *
	 */
	public StyleSheet _buildReport(ResultSet unRs, JTable unaJTable, DefaultTableLens unaTableLens, Vector<Integer> tiposDatosFromJDBC, String unTitulo03,
			String unExtraCode) throws Throwable {

		/**
		 * CONSTRUCCION DEL sheet (REPORTE)
		 */
		StyleSheet reporte = null;
		try {
			ReportEnv.setProperty("font.truetype.path", SystemProperties.FONTS_PATH);

			StyleFont baseFont = getFontChooser().getFuente();
			setFont0(baseFont.deriveFont(baseFont.getStyle())); // para
																// contenido
			setFont1(baseFont.deriveFont(Font.BOLD)); // para headers y títulos

			String nombrePapel = getObjectComboBoxPapel().getSelectedItem().toString();

			if (esOrientacionHorizontal()) {
				nombrePapel = nombrePapel + "_HORIZONTAL";
			}

			String plantillasDirectoryPath = SystemProperties.REPORTER_TEMPLATES_PATH + nombrePapel + ".srt";
			if (REPORT_TEMPLATES_PATH != null)
				plantillasDirectoryPath = REPORT_TEMPLATES_PATH + nombrePapel + ".srt";
			InputStream plantilla = getClass().getResourceAsStream(plantillasDirectoryPath);

			Builder builder = Builder.getBuilder(Builder.TEMPLATE, plantilla);

			reporte = (StyleSheet) builder.read(".");

		} catch (Throwable t) {
			InfoView.showErrorDialog(this, "No se ha construído bien el reporte: " + t.getMessage());
			return null;
		}

		/**
		 * LLENADO DE DATOS
		 */

		boolean porJTable = unaJTable != null;
		boolean porRs = unRs != null;
		boolean porTableLens = unaTableLens != null;

		String unTitulo01 = getTextFieldExtTitulo1().getValue().trim();
		String unTitulo02 = getTextFieldExtTitulo2().getValue().trim();

		if (!porRs && !porJTable) {
			DetallesPresentacionPanel.setTitles(reporte, unTitulo01, unTitulo02, unTitulo03);
		}

		TableLens reportTable = null;
		if (porJTable) {
			reportTable = _buildTable(null, unaJTable, null, tiposDatosFromJDBC, unExtraCode, null);
			reporte.addTable(reportTable);
		} else {
			if (porTableLens) {
				reportTable = _buildTable(null, null, unaTableLens, tiposDatosFromJDBC, unExtraCode, null);
				reporte.addTable(reportTable);
			} else {
				if (porRs) {
					reportTable = _buildTable(unRs, null, null, tiposDatosFromJDBC, unExtraCode, null);
					reporte.addTable(reportTable);
				}
			}
		}

		DetallesPresentacionPanel.setTitles(reporte, unTitulo01, unTitulo02, unTitulo03);

		reporte.setPageNumberingStart(0); // empieza desde la pagina 0 (primera
											// página)

		return reporte;
	}

	/**
	 *
	 */
	public StyleSheet _buildSheet(String unTitulo01, String unTitulo02, String unTitulo03) throws Throwable {
		/**
		 * CONSTRUCCION DEL sheet (REPORTE)
		 */
		StyleSheet reporte = null;
		try {
			ReportEnv.setProperty("font.truetype.path", SystemProperties.FONTS_PATH);

			StyleFont f = getFontChooser().getFuente();
			setFont0(f.deriveFont(f.getStyle())); // para contenido
			setFont1(f.deriveFont(Font.BOLD)); // para headers y
												// títulos

			String nombrePapel = getObjectComboBoxPapel().getSelectedItem().toString();

			if (esOrientacionHorizontal()) {
				nombrePapel = nombrePapel + "_HORIZONTAL";
			}

			String plantillasDirectoryPath = SystemProperties.REPORTER_TEMPLATES_PATH + nombrePapel + ".srt";
			if (REPORT_TEMPLATES_PATH != null)
				plantillasDirectoryPath = REPORT_TEMPLATES_PATH + nombrePapel + ".srt";
			InputStream plantilla = getClass().getResourceAsStream(plantillasDirectoryPath);

			Builder builder = Builder.getBuilder(Builder.TEMPLATE, plantilla);

			reporte = (StyleSheet) builder.read(".");

		} catch (Throwable t) {
			t.getMessage();
			InfoView.showErrorDialog(this, "No se ha construído bien el reporte: " + t.getMessage());
			return null;
		}

		DetallesPresentacionPanel.setTitles(reporte, unTitulo01, unTitulo02, unTitulo03);

		return reporte;
	}

	/**
	 *
	 */
	public TableLens _buildTable(ResultSet aRs, JTable unaJTable, DefaultTableLens unaTableLens, Vector<Integer> tiposDatosFromJDBC, String unExtraCode,
			String unSQL) throws Throwable {

		/**
		 *
		 */
		boolean byJTable = unaJTable != null;
		boolean byTableLens = unaTableLens != null;
		boolean byRs = aRs != null;
		int tipoTabla = 0;
		if (byRs) {
			tipoTabla = TIPO_TABLA_RESULTSET;
		} else {
			if (byJTable) {
				tipoTabla = TIPO_TABLA_JTABLE;
			} else {
				if (byTableLens) {
					tipoTabla = TIPO_TABLA_TABLELENS;
				}
			}
		}

		/**
		 *
		 */
		TableModel detallesModel = (TableModel) getJTableDetalles().getModel();

		/**
		 * CONSTRUCCION DE LA TABLA INICIAL
		 */
		TableStyle initialTableStyle = null;
		switch (tipoTabla) {
		case TIPO_TABLA_RESULTSET:
			tiposDatosFromJDBC = new Vector<Integer>();
			for (int i = 1; i <= aRs.getMetaData().getColumnCount(); i++) {
				tiposDatosFromJDBC.addElement(new Integer(aRs.getMetaData().getColumnType(i)));
			}
			initialTableStyle = new TableStyle(new JDBCTableLens(aRs));
			break;
		case TIPO_TABLA_JTABLE:
			initialTableStyle = new TableStyle(new JTableLens(unaJTable));
			break;
		case TIPO_TABLA_TABLELENS:
			initialTableStyle = new TableStyle(unaTableLens);
			break;
		default:
			break;
		}

		/**
		 * MAPEO DE LOS NOMBRES DE COLUMNAS
		 */
		switch (tipoTabla) {
		case TIPO_TABLA_RESULTSET:
		case TIPO_TABLA_TABLELENS:
			Vector<String> nuevosNombresColumnas = new Vector<String>();
			for (int i = 0; i < detallesModel.getRowCount(); i++) {
				nuevosNombresColumnas.addElement(detallesModel.getValueAt(i, 1).toString());
			}
			DetallesPresentacionPanel._mapTableLens(initialTableStyle, nuevosNombresColumnas);
			break;
		case TIPO_TABLA_JTABLE:
			break;
		default:
			break;
		}

		/**
		 * personalización del reporte (breaks, grouping, etc.)
		 */
		boolean b;
		/**
		 * quiebres
		 */
		Vector<String> quiebresIndexTemp = new Vector<String>();
		for (int i = 0; i < detallesModel.getRowCount(); i++) {
			try {
				b = ((Boolean) detallesModel.getValueAt(i, 3)).booleanValue();
				if (b) {
					quiebresIndexTemp.addElement(String.valueOf(i));
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		int[] quiebresIndex = new int[quiebresIndexTemp.size()];
		for (int i = 0; i < quiebresIndexTemp.size(); i++) {
			quiebresIndex[i] = new Integer(quiebresIndexTemp.elementAt(i).toString().trim()).intValue();
		}
		/**
		 * formulas
		 */
		Vector<Formula> formulasQuiebresTemp = new Vector<Formula>();
		Vector<Formula> formulasTotalTemp = new Vector<Formula>();
		String formulaQuiebreName, formulaTotalName;
		Vector<Integer> formulasIndexTemp = new Vector<Integer>();
		/**
		 * la columna de formula de quiebre determina cuantas columnas tienen
		 * total y en el caso de que una formula no este especificada en formula
		 * del total se toma la del quiebre. y si una formula esta especificada
		 * en el total y no en los quebres no se toma en cuenta
		 */
		for (int i = 0; i < detallesModel.getRowCount(); i++) {
			try {
				b = false;
				for (int j = 0; j < quiebresIndex.length; j++) {
					if (i == quiebresIndex[j]) {
						b = true;
					}
				}
				if (b) {
					continue;
				}
				formulaQuiebreName = detallesModel.getValueAt(i, 4).toString();
				formulaTotalName = detallesModel.getValueAt(i, 5).toString();
				if (formulaQuiebreName != null && formulaQuiebreName.trim().length() > 0
						&& (formulaQuiebreName.startsWith("SUMA") || formulaQuiebreName.startsWith("CONTEO"))) {
					if (formulaQuiebreName.startsWith("SUMA")) {
						formulasQuiebresTemp.addElement(new SumFormula());
					} else {
						if (formulaQuiebreName.startsWith("CONTEO")) {
							formulasQuiebresTemp.addElement(new CountFormula());
						}
					}
					if (formulaTotalName.startsWith("SUMA")) {
						formulasTotalTemp.addElement(new SumFormula());
					} else {
						if (formulaTotalName.startsWith("CONTEO")) {
							formulasTotalTemp.addElement(new CountFormula());
						}
					}
					formulasIndexTemp.addElement(new Integer(i));
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		Vector<Boolean> summarizesTemp = new Vector<Boolean>();
		if (detallesModel.getRowCount() > 0) {
			for (int i = 0; i < quiebresIndex.length; i++) {
				try {
					b = false;
					formulaQuiebreName = detallesModel.getValueAt(i, 4).toString();
					if (formulaQuiebreName != null && formulaQuiebreName.trim().length() > 0
							&& (formulaQuiebreName.startsWith("SUMA") || formulaQuiebreName.startsWith("CONTEO"))) {
						summarizesTemp.addElement(new Boolean(true));
					} else {
						summarizesTemp.addElement(new Boolean(false));
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
		Formula[] formulasQuiebres = new Formula[formulasQuiebresTemp.size()];
		for (int i = 0; i < formulasQuiebresTemp.size(); i++)
			formulasQuiebres[i] = (Formula) formulasQuiebresTemp.elementAt(i);
		Formula[] formulasTotal = new Formula[formulasTotalTemp.size()];
		for (int i = 0; i < formulasTotalTemp.size(); i++)
			formulasTotal[i] = (Formula) formulasTotalTemp.elementAt(i);

		int[] formulasIndex = new int[formulasIndexTemp.size()];
		for (int i = 0; i < formulasIndexTemp.size(); i++) {
			formulasIndex[i] = ((Integer) formulasIndexTemp.elementAt(i)).intValue();
		}
		/**
		 *
		 */
		TableStyle tableStyle2 = null;
		/**
		 *
		 */
		if (quiebresIndex.length == 0) {
			/**
			 * TABLAS SIN QUIEBRES
			 */
			formulasTotalTemp = new Vector<Formula>();
			formulasIndexTemp = new Vector<Integer>();
			for (int i = 0; i < detallesModel.getRowCount(); i++) {
				try {
					formulaTotalName = detallesModel.getValueAt(i, 5).toString();
					if (formulaTotalName != null && formulaTotalName.trim().length() > 0
							&& (formulaTotalName.startsWith("SUMA") || formulaTotalName.startsWith("CONTEO"))) {
						if (formulaTotalName.startsWith("SUMA")) {
							formulasTotalTemp.addElement(new SumFormula());
						} else {
							if (formulaTotalName.startsWith("CONTEO")) {
								formulasTotalTemp.addElement(new CountFormula());
							}
						}
						formulasIndexTemp.addElement(new Integer(i));
					}
				} catch (Exception e) {
					e.getMessage();
				}

			}
			formulasIndex = new int[formulasIndexTemp.size()];
			for (int i = 0; i < formulasIndexTemp.size(); i++) {
				formulasIndex[i] = ((Integer) formulasIndexTemp.elementAt(i)).intValue();
			}
			formulasTotal = new Formula[formulasTotalTemp.size()];
			for (int i = 0; i < formulasTotalTemp.size(); i++) {
				formulasTotal[i] = (Formula) formulasTotalTemp.elementAt(i);
			}
			/**
			 * CONSTRUCCION DE LA TABLA
			 */
			TableFilter tf = null;
			switch (tipoTabla) {
			case TIPO_TABLA_JTABLE:
				int columnsCount = initialTableStyle.getColCount();
				int countFormulaColumnIndex = 1;
				if (columnsCount == 1) {
					countFormulaColumnIndex = 0;
				}
				tf = new TableSummaryFilter(initialTableStyle, getTextFieldExtEtiquetaTotal().getValue().trim(), new int[] { countFormulaColumnIndex },
						new Formula[] { new CountFormula() });
				break;
			case TIPO_TABLA_RESULTSET:
			case TIPO_TABLA_TABLELENS:
				columnsCount = initialTableStyle.getColCount();
				countFormulaColumnIndex = 1;
				if (columnsCount == 1) {
					countFormulaColumnIndex = 0;
					tf = new TableSummaryFilter(initialTableStyle, getTextFieldExtEtiquetaTotal().getValue().trim(), 0, new CountFormula());
				} else {
					tf = new TableSummaryFilter(initialTableStyle, getTextFieldExtEtiquetaTotal().getValue().trim(), formulasIndex, formulasTotal);
				}
				break;
			default:
				break;
			}

			tableStyle2 = new Simple4(tf);

		} else {

			/**
			 * TABLAS CON QUIEBRES
			 */
			// tablas con quiebres
			if (formulasTotal.length == 0) {
				formulasTotal = null;
			}

			DefaultSortedTable sortedTable = new DefaultSortedTable(initialTableStyle, quiebresIndex);

			GroupFilter gf = new GroupFilter(sortedTable, formulasIndex, formulasQuiebres, formulasTotal);
			// OJO TODO CAMBIAR ESTO A UN CAMPO EN LA TABLA
			boolean pageBreakAfterQuiebre = false;
			if (unExtraCode != null && unExtraCode.trim().length() > 0 && unExtraCode.indexOf("[&PBAQ]") >= 0) {
				pageBreakAfterQuiebre = true;
			}
			gf.setBreakAfterSection(pageBreakAfterQuiebre);

			// label para el total general al final del reporte
			if (formulasIndex.length > 0) {
				gf.setGrandLabel(getTextFieldExtEtiquetaTotal().getValue().trim());
			}

			// se añade una row para el título de cada bloque del grouping
			gf.setAddGroupHeader(true);

			// se oculta los datos de la columna de grouping
			gf.setShowGroupColumns(getJCheckBoxRepetirDatosQuiebre().isSelected());

			gf.setGroupHeaderStyle(GroupFilter.GROUP_HEADER_IN_PLACE);

			int summIndex = 0;
			for (int i = 0; i < quiebresIndex.length; i++) {
				if (new Boolean(summarizesTemp.elementAt(i).toString()).booleanValue()) {
					gf.setSummarize(summIndex, true);
				} else {
					gf.setSummarize(summIndex, false);
				}
				summIndex++;
			}
			if (!getJCheckBoxMostrarEtiquetasSubtotales().isSelected()) {
				gf.setSummaryLabel(getTextFieldExtEtiquetaSubTotales().getValue().trim());
			}

			tableStyle2 = new LeadingBreak(gf);

			((LeadingBreak) tableStyle2).setHeaderFont(getFont0());
			((LeadingBreak) tableStyle2).setHeaderBackground(new Color(245, 245, 245));
			((LeadingBreak) tableStyle2).setSummaryBackground(new Color(245, 245, 245));
			((LeadingBreak) tableStyle2).setSummaryFont(getFont1());
			((LeadingBreak) tableStyle2).setSummaryAlignment(new Integer(StyleConstants.RIGHT));
		}

		tableStyle2.setColAutoSize(false);

		/**
		 * se formatea las columnas de la tabla
		 */
		switch (tipoTabla) {
		case TIPO_TABLA_JTABLE:
			String columnClassName;
			for (int i = 0; i < unaJTable.getModel().getColumnCount(); i++) {
				columnClassName = unaJTable.getModel().getColumnClass(i).getName();
				try {
					if (columnClassName.compareTo("java.sql.Date") == 0) {
						tableStyle2.setColAlignment(i, StyleConstants.RIGHT); // fechas
																				// alineadas
																				// a
																				// la
																				// derecha
						tableStyle2.setFormat(i, new SimpleDateFormat("dd-MMM-yyyy"));
					}
					if (columnClassName.compareTo("java.math.BigDecimal") == 0) {
						tableStyle2.setColAlignment(i, StyleConstants.RIGHT); // alineado
																				// a
																				// la
																				// derecha
						tableStyle2.setFormat(i, new DecimalFormat("###,##0.00"));
					}
					if (columnClassName.compareTo("java.lang.Integer") == 0) {
						tableStyle2.setColAlignment(i, StyleConstants.RIGHT); // alineado
																				// a
																				// la
																				// derecha
						tableStyle2.setFormat(i, new DecimalFormat("###,###"));
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
			break;
		case TIPO_TABLA_RESULTSET:
		case TIPO_TABLA_TABLELENS:
			DetallesPresentacionPanel._formatearColumnasPorTipoSQL(tableStyle2, tiposDatosFromJDBC, detallesModel);
			break;
		default:
			break;
		}

		/**
		 * OTROS FORMATEOS ADICIONALES
		 */
		// anchos de las columnas
		Vector<String> anchos = new Vector<String>();
		String anchoTemp;
		for (int j = 0; j < detallesModel.getRowCount(); j++) {
			try {
				anchoTemp = detallesModel.getValueAt(j, 2).toString().trim();
				if (anchoTemp.compareTo("") != 0) {
					anchos.addElement(String.valueOf(j) + ";" + String.valueOf(anchoTemp));
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		if (anchos != null && anchos.size() > 0) {
			// se coloca anchos a las columnas
			try {
				StringTokenizer stk;
				int indiceColumna, ancho;
				for (int k = 0; k < anchos.size(); k++) {
					try {
						stk = new StringTokenizer(anchos.elementAt(k).toString(), ";");
						indiceColumna = new Integer(stk.nextToken().trim()).intValue();
						ancho = new Integer(stk.nextToken().trim()).intValue();
						tableStyle2.setColWidth(indiceColumna, ancho);
						if (ancho == 0) {
							// tableStyle.setColBorder(columna,
							// StyleConstants.NO_BORDER);
							tableStyle2.setColForeground(indiceColumna, Color.white);
							tableStyle2.setColInsets(indiceColumna, new Insets(0, 5, 0, 5));
						}
					} catch (Throwable t33) {
						t33.getMessage();
					}
				}
			} catch (Throwable t1) {
				t1.getMessage();
			}
		}
		// 07_ negritas en las columnas
		for (int m = 0; m < detallesModel.getRowCount(); m++) {
			try {
				b = ((Boolean) detallesModel.getValueAt(m, 7)).booleanValue();
				if (b) {
					tableStyle2.setColFont(m, getFont1());
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		// _08_ color en las columnas
		for (int n = 0; n < detallesModel.getRowCount(); n++) {
			try {
				Color c = (Color) detallesModel.getValueAt(n, 8);
				tableStyle2.setColForeground(n, c);
			} catch (Exception e) {
				e.getMessage();
			}
		}
		// wrapping
		for (int n = 0; n < detallesModel.getRowCount(); n++) {
			tableStyle2.setColLineWrap(n, true);
		}
		tableStyle2.setLineWrap(true);
		// ...
		if (new Integer(getTextFieldExtAltoFila().getValue().trim()).intValue() > 0) {
			tableStyle2.setRowHeight(new Integer(getTextFieldExtAltoFila().getValue().trim()).intValue());
		} else {
			tableStyle2.setRowAutoSize(true);
		}
		// ...
		tableStyle2.setFont(getFont0());

		/**
		 * APLICACION DE ESTILO DE TABLA
		 */
		TableStyle finalTableStyle = null;
		if (getJCheckBoxAplicarEstilo().isSelected()) {
			try {
				finalTableStyle = getReportTableStyleChooser().getTableStyle();
				finalTableStyle.setTable(tableStyle2);
				// _08_ color en las columnas(se lo debe repetir debido a que se
				// cambia de estilo)
				for (int n = 0; n < detallesModel.getRowCount(); n++) {
					try {
						Color c = (Color) detallesModel.getValueAt(n, 8);
						finalTableStyle.setColForeground(n, c);
					} catch (Exception e) {
						e.getMessage();
					}
				}
				finalTableStyle.setLineWrap(true);
			} catch (Throwable t44) {
				t44.getMessage();
			}
		} else {
			finalTableStyle = new Simple4();
			finalTableStyle.setLineWrap(true);
			finalTableStyle.setTable(tableStyle2);
		}

		// ...
		return finalTableStyle;
	}

	/**
	 *
	 */
	public void DEFINICION_cargarVisualmente(DefinicionReporte definicionReporte) {
		try {
			getTextFieldExtTitulo1().setValue(definicionReporte.getTitulo1());
			getTextFieldExtTitulo2().setValue(definicionReporte.getTitulo2());
			getObjectComboBoxPapel().setSelectedItem(definicionReporte.getPlantilla());
			if (definicionReporte.getTableStyle().trim().startsWith("_NO_HAY_ESTILO"))
				getJCheckBoxAplicarEstilo().setSelected(false);
			else {
				getJCheckBoxAplicarEstilo().setSelected(true);
				getReportTableStyleChooser().setTableStyle((TableStyle) Class.forName(definicionReporte.getTableStyle().trim()).newInstance());
			}
			if (definicionReporte.getEtiquetaSubtotalesQuiebre().trim().startsWith("_MOSTRAR_ETIQUETA_QUIEBRE"))
				getJCheckBoxMostrarEtiquetasSubtotales().setSelected(true);
			else {
				getJCheckBoxMostrarEtiquetasSubtotales().setSelected(false);
				getTextFieldExtEtiquetaSubTotales().setValue(definicionReporte.getEtiquetaSubtotalesQuiebre().trim());
			}
			getTextFieldExtEtiquetaTotal().setValue(definicionReporte.getEtiquetaTotalGeneral().trim());
			getJCheckBoxRepetirDatosQuiebre().setSelected(definicionReporte.isRepetirDatosQuiebre());

			getTextFieldExtAltoFila().setValue(String.valueOf(definicionReporte.getAltoLinea()));
			getFontChooser().setFuente(_parse_String_to_Font(definicionReporte.getFont().trim()));
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 *
	 */
	public void _fillData(DefinicionReporte definicionReporte) {

		definicionReporte.setTitulo1(getTextFieldExtTitulo1().getValue().trim());
		definicionReporte.setTitulo2(getTextFieldExtTitulo2().getValue().trim());
		definicionReporte.setPlantilla(getObjectComboBoxPapel().getSelectedItem().toString().trim());

		String temp1 = "_NO_HAY_ESTILO"; // default por si no esta seleccionado
											// ningun estilo
		if (getJCheckBoxAplicarEstilo().isSelected() && getReportTableStyleChooser().getTableStyle() != null) {
			temp1 = getReportTableStyleChooser().getTableStyle().getClass().getName();
		}
		definicionReporte.setTableStyle(temp1);

		temp1 = "_MOSTRAR_ETIQUETA_QUIEBRE"; // default para cuando se muestra
												// la etiqueta del quiebre
		if (getJCheckBoxMostrarEtiquetasSubtotales().isSelected() && getTextFieldExtEtiquetaSubTotales().getValue().trim().length() > 0) {
			temp1 = getTextFieldExtEtiquetaSubTotales().getValue().trim();
		}
		definicionReporte.setEtiquetaSubtotalesQuiebre(temp1);

		definicionReporte.setEtiquetaTotalGeneral(getTextFieldExtEtiquetaTotal().getValue().trim());

		definicionReporte.setRepetirDatosQuiebre(getJCheckBoxRepetirDatosQuiebre().isSelected());

		definicionReporte.setDetalle(DetallesPresentacionPanel._construirDetalle_forSQL(getJTableDetalles()));
		definicionReporte.setAltoLinea(Integer.valueOf(getTextFieldExtAltoFila().getValue().trim()).intValue());
		definicionReporte.setFont(DetallesPresentacionPanel._parse_Font_to_String(getFontChooser().getFuente()));

	}

	public void _limpiarTodosLosCampos() {

		_refrescarDetallesTabla("");

		getTextFieldExtTitulo1().setValue("");
		getTextFieldExtTitulo2().setValue("");
		getObjectComboBoxPapel().deselect();
		getReportTableStyleChooser().setTableStyle(null);
		getJCheckBoxRepetirDatosQuiebre().setSelected(false);
		getJCheckBoxAplicarEstilo().setSelected(false);
		getTextFieldExtAltoFila().setValue("0");
	}

	/**
	 * mapea los nombres de columnas de una tabla DefaultTableLens
	 */
	public static void _mapTableLens(TableStyle aTableLens, Vector<String> nuevosNombresColumnas) {

		String nombreColumna;
		for (int i = 0; i < nuevosNombresColumnas.size(); i++) {
			nombreColumna = nuevosNombresColumnas.elementAt(i);
			if (nombreColumna != null && nombreColumna.trim().length() > 0) {
				aTableLens.setObject(0, i, nombreColumna.trim());
			}
		}
	}

	/**
	 *
	 */
	public static String _parse_Font_to_String(Font f) {

		if (f == null)
			return "";

		return f.getName() + "&&" + f.getStyle() + "&&" + f.getSize();
	}

	public static StyleFont _parse_String_to_Font(String fontArgs) {

		if (fontArgs == null || fontArgs.trim().length() == 0)
			return null;

		try {
			StringTokenizer stk = new StringTokenizer(fontArgs, "&&");

			return new StyleFont(stk.nextToken(), new Integer(stk.nextToken().trim()).intValue(), new Integer(stk.nextToken().trim()).intValue());
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void _refrescarDetallesTabla(String unSQL) {

		TableModel detallesModel = (TableModel) getJTableDetalles().getModel();

		// hacer que se guarden los detalles anteriores
		Vector detallesAnteriores = new Vector();
		Vector unDetalleAnterior;
		for (int i = 0; i < detallesModel.getRowCount(); i++) {
			unDetalleAnterior = new Vector();
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 1));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 2));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 3));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 4));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 5));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 6));
			unDetalleAnterior.addElement(detallesModel.getValueAt(i, 7));
			unDetalleAnterior.addElement(new Integer(((Color) detallesModel.getValueAt(i, 8)).getRGB()));
			detallesAnteriores.addElement(unDetalleAnterior);
		}
		// sentencia escrita
		String sql = unSQL.trim();
		if (sql.length() == 0) {
			detallesModel.removeAllRows();
			return;
		}

		Vector columnasSQL = _nombresSQLColumnas(sql);

		// ...primero se elimina las filas existentes
		detallesModel.removeAllRows();
		Vector fila, detallesTemp;
		for (int i = 0; i < columnasSQL.size(); i++) {
			fila = new Vector();
			fila.addElement(columnasSQL.elementAt(i).toString().trim());
			if (detallesAnteriores.size() < i + 1) {
				fila.addElement("");
				fila.addElement("");
				fila.addElement(new Boolean(false));
				fila.addElement("");
				fila.addElement("");
				fila.addElement("");
				fila.addElement(new Boolean(false));
				fila.addElement(Color.black);
			} else {
				detallesTemp = (Vector) detallesAnteriores.elementAt(i);
				fila.addElement(detallesTemp.elementAt(0));
				fila.addElement(detallesTemp.elementAt(1));
				fila.addElement(new Boolean(detallesTemp.elementAt(2).toString().trim()));
				fila.addElement(detallesTemp.elementAt(3));
				fila.addElement(detallesTemp.elementAt(4));
				fila.addElement(detallesTemp.elementAt(5));
				fila.addElement(new Boolean(detallesTemp.elementAt(6).toString().trim()));
				fila.addElement(new Color(((Integer) detallesTemp.elementAt(7)).intValue()));
			}
			detallesModel.addRow(fila);
		}
	}

	/**
	 * connEtoC1:
	 * (JCheckBoxMostrarEtiquetasSubtotales.item.itemStateChanged(ItemEvent) -->
	 * DetallesPresentacionPanel.visualManageSubTotales()V)
	 *
	 * @param arg1
	 *            ItemEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(ItemEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageSubTotales();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (JCheckBoxAplicarEstilo.item.itemStateChanged(ItemEvent) -->
	 * DetallesPresentacionPanel.visualManageTableStyleChooser()V)
	 *
	 * @param arg1
	 *            ItemEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(ItemEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageTableStyleChooser();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (TextFieldExtTitulo1.value -->
	 * DetallesPresentacionPanel.firePropertyChange(Ljava.lang.String;Ljava.lang
	 * .Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("titulo1", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5: (TextFieldExtTitulo2.value -->
	 * DetallesPresentacionPanel.firePropertyChange(Ljava.lang.String;Ljava.lang
	 * .Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("titulo2", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Insert the method's description here. Creation date: (19/12/2003
	 * 12:22:27)
	 *
	 * @return Font
	 */
	public Font getFont0() {
		return font0;
	}

	/**
	 * Insert the method's description here. Creation date: (19/12/2003
	 * 12:24:21)
	 *
	 * @return Font
	 */
	public Font getFont1() {
		return font1;
	}

	/**
	 * Return the FontChooser property value.
	 *
	 * @return efren.abm.beans.FontChooser
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.fontchooser.FontChooser getFontChooser() {
		if (ivjFontChooser == null) {
			try {
				ivjFontChooser = new efren.util.gui.fontchooser.FontChooser();
				ivjFontChooser.setName("FontChooser");
				ivjFontChooser.setTitulo("Escoja el tipo de letra");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjFontChooser;
	}

	public void setFuente(StyleFont aNewFont) {
		getFontChooser().setFuente(aNewFont);
	}

	/**
	 * Return the JCheckBoxAplicarEstilo property value.
	 *
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxAplicarEstilo() {
		if (ivjJCheckBoxAplicarEstilo == null) {
			try {
				ivjJCheckBoxAplicarEstilo = new javax.swing.JCheckBox();
				ivjJCheckBoxAplicarEstilo.setName("JCheckBoxAplicarEstilo");
				ivjJCheckBoxAplicarEstilo.setMnemonic('M');
				ivjJCheckBoxAplicarEstilo.setText("Estilo");
				ivjJCheckBoxAplicarEstilo.setSelected(true);
				ivjJCheckBoxAplicarEstilo.setFont(new Font("Arial", 0, 10));
				ivjJCheckBoxAplicarEstilo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxAplicarEstilo;
	}

	/**
	 * Return the JCheckBoxMostrarEtiquetasSubtotales property value.
	 *
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxMostrarEtiquetasSubtotales() {
		if (ivjJCheckBoxMostrarEtiquetasSubtotales == null) {
			try {
				ivjJCheckBoxMostrarEtiquetasSubtotales = new javax.swing.JCheckBox();
				ivjJCheckBoxMostrarEtiquetasSubtotales.setName("JCheckBoxMostrarEtiquetasSubtotales");
				ivjJCheckBoxMostrarEtiquetasSubtotales.setMnemonic('M');
				ivjJCheckBoxMostrarEtiquetasSubtotales.setText("Mostrar etiqueta del quiebre en SUBTOTALES");
				ivjJCheckBoxMostrarEtiquetasSubtotales.setSelected(true);
				ivjJCheckBoxMostrarEtiquetasSubtotales.setFont(new Font("Arial", 0, 10));
				ivjJCheckBoxMostrarEtiquetasSubtotales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxMostrarEtiquetasSubtotales;
	}

	/**
	 * Return the JCheckBoxRepetirDatosQuiebre property value.
	 *
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxRepetirDatosQuiebre() {
		if (ivjJCheckBoxRepetirDatosQuiebre == null) {
			try {
				ivjJCheckBoxRepetirDatosQuiebre = new javax.swing.JCheckBox();
				ivjJCheckBoxRepetirDatosQuiebre.setName("JCheckBoxRepetirDatosQuiebre");
				ivjJCheckBoxRepetirDatosQuiebre.setSelected(false);
				ivjJCheckBoxRepetirDatosQuiebre.setFont(new Font("Arial", 0, 10));
				ivjJCheckBoxRepetirDatosQuiebre.setMnemonic('M');
				ivjJCheckBoxRepetirDatosQuiebre.setText("Repetir datos del quiebre");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxRepetirDatosQuiebre;
	}

	/**
	 * Return the JPanel property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanel() {
		if (ivjJPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.insets = new Insets(2, 2, 2, 2);
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 2;
			ivjJPanel = new javax.swing.JPanel();
			ivjJPanel.setName("JPanel");
			ivjJPanel.setFont(new Font("Arial", 0, 10));
			ivjJPanel.setLayout(new GridBagLayout());

			GridBagConstraints constraintsTextFieldExtTitulo1 = new GridBagConstraints();
			constraintsTextFieldExtTitulo1.gridx = 1;
			constraintsTextFieldExtTitulo1.gridy = 0;
			constraintsTextFieldExtTitulo1.gridwidth = 3;
			constraintsTextFieldExtTitulo1.fill = GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTitulo1.weightx = 1.0;
			constraintsTextFieldExtTitulo1.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsLabelExt1 = new GridBagConstraints();
			constraintsLabelExt1.gridx = 0;
			constraintsLabelExt1.gridy = 0;
			constraintsLabelExt1.fill = GridBagConstraints.HORIZONTAL;
			constraintsLabelExt1.insets = new Insets(10, 10, 5, 5);
			ivjJPanel.add(getTextFieldExtTitulo1(), constraintsTextFieldExtTitulo1);
			getJPanel().add(getLabelExt1(), constraintsLabelExt1);

			GridBagConstraints constraintsLabelExt = new GridBagConstraints();
			constraintsLabelExt.gridx = 0;
			constraintsLabelExt.gridy = 1;
			constraintsLabelExt.fill = GridBagConstraints.HORIZONTAL;
			constraintsLabelExt.insets = new Insets(5, 10, 5, 5);
			getJPanel().add(getLabelExt(), constraintsLabelExt);

			GridBagConstraints constraintsTextFieldExtTitulo2 = new GridBagConstraints();
			constraintsTextFieldExtTitulo2.gridx = 1;
			constraintsTextFieldExtTitulo2.gridy = 1;
			constraintsTextFieldExtTitulo2.gridwidth = 3;
			constraintsTextFieldExtTitulo2.fill = GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTitulo2.weightx = 1.0;
			constraintsTextFieldExtTitulo2.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsTextFieldExtAltoFila = new GridBagConstraints();
			constraintsTextFieldExtAltoFila.gridx = 1;
			constraintsTextFieldExtAltoFila.gridy = 4;
			constraintsTextFieldExtAltoFila.anchor = GridBagConstraints.WEST;
			constraintsTextFieldExtAltoFila.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsJScrollPane1 = new GridBagConstraints();
			constraintsJScrollPane1.gridx = 0;
			constraintsJScrollPane1.gridy = 8;
			constraintsJScrollPane1.gridwidth = 4;
			constraintsJScrollPane1.fill = GridBagConstraints.BOTH;
			constraintsJScrollPane1.weightx = 1.0;
			constraintsJScrollPane1.weighty = 1.0;
			constraintsJScrollPane1.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsJCheckBoxRepetirDatosQuiebre = new GridBagConstraints();
			constraintsJCheckBoxRepetirDatosQuiebre.gridx = 2;
			constraintsJCheckBoxRepetirDatosQuiebre.gridy = 7;
			constraintsJCheckBoxRepetirDatosQuiebre.gridwidth = 2;
			constraintsJCheckBoxRepetirDatosQuiebre.anchor = GridBagConstraints.WEST;
			constraintsJCheckBoxRepetirDatosQuiebre.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsJCheckBoxMostrarEtiquetasSubtotales = new GridBagConstraints();
			constraintsJCheckBoxMostrarEtiquetasSubtotales.gridx = 2;
			constraintsJCheckBoxMostrarEtiquetasSubtotales.gridy = 6;
			constraintsJCheckBoxMostrarEtiquetasSubtotales.gridwidth = 2;
			constraintsJCheckBoxMostrarEtiquetasSubtotales.anchor = GridBagConstraints.WEST;
			constraintsJCheckBoxMostrarEtiquetasSubtotales.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsJCheckBoxAplicarEstilo = new GridBagConstraints();
			constraintsJCheckBoxAplicarEstilo.gridx = 0;
			constraintsJCheckBoxAplicarEstilo.gridy = 5;
			constraintsJCheckBoxAplicarEstilo.anchor = GridBagConstraints.EAST;
			constraintsJCheckBoxAplicarEstilo.insets = new Insets(2, 2, 2, 2);
			ivjJPanel.add(getTextFieldExtTitulo2(), constraintsTextFieldExtTitulo2);
			ivjJPanel.add(getTextFieldExtAltoFila(), constraintsTextFieldExtAltoFila);
			GridBagConstraints constraintsFontChooser = new GridBagConstraints();
			constraintsFontChooser.gridx = 3;
			constraintsFontChooser.gridy = 4;
			constraintsFontChooser.fill = GridBagConstraints.BOTH;
			constraintsFontChooser.weightx = 1.0;
			constraintsFontChooser.ipady = 15;
			constraintsFontChooser.gridwidth = 1;
			constraintsFontChooser.gridheight = 2;
			constraintsFontChooser.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsLabelExt5 = new GridBagConstraints();
			constraintsLabelExt5.gridx = 0;
			constraintsLabelExt5.gridy = 6;
			constraintsLabelExt5.anchor = GridBagConstraints.EAST;
			constraintsLabelExt5.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsLabelExt7 = new GridBagConstraints();
			constraintsLabelExt7.gridx = 0;
			constraintsLabelExt7.gridy = 2;
			constraintsLabelExt7.anchor = GridBagConstraints.EAST;
			constraintsLabelExt7.insets = new Insets(2, 2, 2, 2);
			ivjJPanel.add(getJScrollPane1(), constraintsJScrollPane1);
			ivjJPanel.add(getJCheckBoxRepetirDatosQuiebre(), constraintsJCheckBoxRepetirDatosQuiebre);
			ivjJPanel.add(getJCheckBoxMostrarEtiquetasSubtotales(), constraintsJCheckBoxMostrarEtiquetasSubtotales);
			ivjJPanel.add(getJCheckBoxAplicarEstilo(), constraintsJCheckBoxAplicarEstilo);
			GridBagConstraints constraintsLabelExt10 = new GridBagConstraints();
			constraintsLabelExt10.gridx = 0;
			constraintsLabelExt10.gridy = 7;
			constraintsLabelExt10.insets = new Insets(2, 2, 2, 2);
			constraintsLabelExt10.anchor = GridBagConstraints.EAST;
			GridBagConstraints constraintsTextFieldExtEtiquetaSubTotales = new GridBagConstraints();
			constraintsTextFieldExtEtiquetaSubTotales.gridx = 1;
			constraintsTextFieldExtEtiquetaSubTotales.gridy = 6;
			constraintsTextFieldExtEtiquetaSubTotales.fill = GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtEtiquetaSubTotales.weightx = 1.0;
			constraintsTextFieldExtEtiquetaSubTotales.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsTextFieldExtEtiquetaTotal = new GridBagConstraints();
			constraintsTextFieldExtEtiquetaTotal.gridx = 1;
			constraintsTextFieldExtEtiquetaTotal.gridy = 7;
			constraintsTextFieldExtEtiquetaTotal.fill = GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtEtiquetaTotal.weightx = 1.0;
			constraintsTextFieldExtEtiquetaTotal.insets = new Insets(2, 2, 2, 2);
			ivjJPanel.add(getFontChooser(), constraintsFontChooser);
			ivjJPanel.add(getLabelExt5(), constraintsLabelExt5);
			ivjJPanel.add(getLabelExt7(), constraintsLabelExt7);
			GridBagConstraints constraintsLabelExt12 = new GridBagConstraints();
			constraintsLabelExt12.gridx = 0;
			constraintsLabelExt12.gridy = 4;
			constraintsLabelExt12.anchor = GridBagConstraints.EAST;
			constraintsLabelExt12.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsObjectComboBoxPapel = new GridBagConstraints();
			constraintsObjectComboBoxPapel.gridx = 1;
			constraintsObjectComboBoxPapel.gridy = 2;
			constraintsObjectComboBoxPapel.fill = GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxPapel.weightx = 1.0;
			constraintsObjectComboBoxPapel.insets = new Insets(2, 2, 2, 2);
			ivjJPanel.add(getLabelExt10(), constraintsLabelExt10);
			ivjJPanel.add(getTextFieldExtEtiquetaSubTotales(), constraintsTextFieldExtEtiquetaSubTotales);
			ivjJPanel.add(getTextFieldExtEtiquetaTotal(), constraintsTextFieldExtEtiquetaTotal);
			GridBagConstraints constraintsLabelExt13 = new GridBagConstraints();
			constraintsLabelExt13.gridx = 2;
			constraintsLabelExt13.gridy = 4;
			constraintsLabelExt13.anchor = GridBagConstraints.EAST;
			constraintsLabelExt13.gridheight = 2;
			constraintsLabelExt13.insets = new Insets(2, 2, 2, 2);
			GridBagConstraints constraintsReportTableStyleChooser = new GridBagConstraints();
			constraintsReportTableStyleChooser.gridx = 1;
			constraintsReportTableStyleChooser.gridy = 5;
			constraintsReportTableStyleChooser.fill = GridBagConstraints.HORIZONTAL;
			constraintsReportTableStyleChooser.weightx = 1.0;
			constraintsReportTableStyleChooser.insets = new Insets(2, 2, 2, 2);
			ivjJPanel.add(getLabelExt12(), constraintsLabelExt12);
			ivjJPanel.add(getObjectComboBoxPapel(), constraintsObjectComboBoxPapel);
			ivjJPanel.add(getLabelExt13(), constraintsLabelExt13);
			ivjJPanel.add(getReportTableStyleChooser(), constraintsReportTableStyleChooser);
			ivjJPanel.add(getMultiChoiceOrientacion(), gridBagConstraints);
		}
		return ivjJPanel;
	}

	/**
	 * Return the JScrollPane1 property value.
	 *
	 * @return javax.swing.JScrollPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JScrollPane getJScrollPane1() {
		if (ivjJScrollPane1 == null) {
			try {
				ivjJScrollPane1 = new javax.swing.JScrollPane();
				ivjJScrollPane1.setName("JScrollPane1");
				ivjJScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				ivjJScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getJScrollPane1().setViewportView(getJTableDetalles());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJScrollPane1;
	}

	/**
	 * Return the JTableDetalles property value.
	 *
	 * @return javax.swing.JTable
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTable getJTableDetalles() {
		if (ivjJTableDetalles == null) {
			try {
				ivjJTableDetalles = new javax.swing.JTable();
				ivjJTableDetalles.setName("JTableDetalles");
				getJScrollPane1().setColumnHeaderView(ivjJTableDetalles.getTableHeader());
				// getJScrollPane1().getViewport().setBackingStoreEnabled(true);
				ivjJTableDetalles.setAutoResizeMode(0);
				ivjJTableDetalles.setPreferredScrollableViewportSize(new Dimension(600, 250));
				ivjJTableDetalles.setAutoCreateColumnsFromModel(false);
				ivjJTableDetalles.setPreferredSize(new Dimension(678, 123));
				ivjJTableDetalles.setBounds(0, 0, 678, 123);
				ivjJTableDetalles.setCursor(new Cursor(Cursor.HAND_CURSOR));
				ivjJTableDetalles.addColumn(getTableColumn_00_NombreSQL());
				ivjJTableDetalles.addColumn(getTableColumn_01_Nombre());
				ivjJTableDetalles.addColumn(getTableColumn_02_Ancho());
				ivjJTableDetalles.addColumn(getTableColumn_03_Tiene_Quiebre());
				ivjJTableDetalles.addColumn(getTableColumn_04_Formula_Quiebre());
				ivjJTableDetalles.addColumn(getTableColumn_05_Formula_Total());
				ivjJTableDetalles.addColumn(getTableColumn_06_Unidad_de_medida());
				ivjJTableDetalles.addColumn(getTableColumn_07_Es_Negritas());
				ivjJTableDetalles.addColumn(getTableColumn_08_Color());
				// user code begin {1}
				ivjJTableDetalles.setModel(new TableModel());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_00_NombreSQL());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_01_Nombre());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_02_Ancho());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_03_Tiene_Quiebre());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_04_Formula_Quiebre());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_05_Formula_Total());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_06_Unidad_de_medida());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_07_Es_Negritas());
				((TableModel) ivjJTableDetalles.getModel()).addColumn(getTableColumn_08_Color());
				Vector<String> columnasEditables = new Vector<String>();
				columnasEditables.addElement("1");
				columnasEditables.addElement("2");
				columnasEditables.addElement("3");
				columnasEditables.addElement("4");
				columnasEditables.addElement("5");
				columnasEditables.addElement("6");
				columnasEditables.addElement("7");
				columnasEditables.addElement("8");
				((TableModel) ivjJTableDetalles.getModel()).setEditableColumns(columnasEditables);
				// ...header
				javax.swing.table.JTableHeader aTableHeader = new javax.swing.table.JTableHeader(ivjJTableDetalles.getColumnModel());
				aTableHeader.setFont(efren.util.FontManager.currentSystemBoldFont());
				aTableHeader.setForeground(new Color(0, 64, 168));
				ivjJTableDetalles.setTableHeader(aTableHeader);
				ivjJTableDetalles.setPreferredSize(null);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTableDetalles;
	}

	/**
	 * Method generated to support the promotion of the nombrePapel attribute.
	 *
	 * @return java.lang.Object
	 */
	public java.lang.Object getNombrePapel() {
		return getObjectComboBoxPapel().getSelectedItem();
	}

	/**
	 * Return the ObjectComboBoxPapel property value.
	 *
	 * @return efren.util.gui.combo.ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.combo.ObjectComboBox getObjectComboBoxPapel() {
		if (ivjObjectComboBoxPapel == null) {
			try {
				ivjObjectComboBoxPapel = new efren.util.gui.combo.ObjectComboBox();
				ivjObjectComboBoxPapel.setName("ObjectComboBoxPapel");
				Object ivjLocal53items[] = { "A4", "CARTA", "OFICIO" };
				ivjObjectComboBoxPapel.setItems(ivjLocal53items);
				String ivjLocal53values[] = { String.valueOf(A4), String.valueOf(CARTA), String.valueOf(OFICIO) };
				ivjObjectComboBoxPapel.setValuesForItems(ivjLocal53values);
				ivjObjectComboBoxPapel.setSelectedIndex(0);
				ivjObjectComboBoxPapel.setSelectedValueItem(String.valueOf(A4));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxPapel;
	}

	/**
	 *
	 */
	private efren.util.gui.ReportTableStyleChooser getReportTableStyleChooser() {
		if (ivjReportTableStyleChooser == null) {
			ivjReportTableStyleChooser = new ReportTableStyleChooser();
			ivjReportTableStyleChooser.setName("ReportTableStyleChooser");
			ivjReportTableStyleChooser.setEnabled(true);
		}
		return ivjReportTableStyleChooser;
	}

	/**
	 * Return the LabelExt property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			try {
				ivjLabelExt = new efren.util.gui.LabelExt();
				ivjLabelExt.setName("LabelExt");
				ivjLabelExt.setText("Título02");
				ivjLabelExt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt;
	}

	/**
	 * Return the LabelExt1 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt1() {
		if (ivjLabelExt1 == null) {
			try {
				ivjLabelExt1 = new efren.util.gui.LabelExt();
				ivjLabelExt1.setName("LabelExt1");
				ivjLabelExt1.setText("Título01");
				ivjLabelExt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt1;
	}

	/**
	 * Return the LabelExt10 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt10() {
		if (ivjLabelExt10 == null) {
			try {
				ivjLabelExt10 = new efren.util.gui.LabelExt();
				ivjLabelExt10.setName("LabelExt10");
				ivjLabelExt10.setText("Etiqueta Totales");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt10;
	}

	/**
	 * Return the LabelExt12 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt12() {
		if (ivjLabelExt12 == null) {
			try {
				ivjLabelExt12 = new efren.util.gui.LabelExt();
				ivjLabelExt12.setName("LabelExt12");
				ivjLabelExt12.setText("Alto fila");
				ivjLabelExt12.setMaximumSize(new Dimension(14, 14));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt12;
	}

	/**
	 * Return the LabelExt2 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt13() {
		if (ivjLabelExt13 == null) {
			try {
				ivjLabelExt13 = new efren.util.gui.LabelExt();
				ivjLabelExt13.setName("LabelExt13");
				ivjLabelExt13.setText("Tipo Letra");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt13;
	}

	/**
	 * Return the LabelExt5 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt5() {
		if (ivjLabelExt5 == null) {
			try {
				ivjLabelExt5 = new efren.util.gui.LabelExt();
				ivjLabelExt5.setName("LabelExt5");
				ivjLabelExt5.setText("Etiqueta Subtotales");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt5;
	}

	/**
	 * Return the LabelExt7 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt7() {
		if (ivjLabelExt7 == null) {
			try {
				ivjLabelExt7 = new efren.util.gui.LabelExt();
				ivjLabelExt7.setName("LabelExt7");
				ivjLabelExt7.setText("Papel");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt7;
	}

	/**
	 * Return the TableColumn112 property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_00_NombreSQL() {
		if (ivjTableColumn_00_NombreSQL == null) {
			try {
				ivjTableColumn_00_NombreSQL = new javax.swing.table.TableColumn();
				ivjTableColumn_00_NombreSQL.setWidth(100);
				ivjTableColumn_00_NombreSQL.setHeaderValue("Nombre SQL");
				ivjTableColumn_00_NombreSQL.setMinWidth(50);
				// user code begin {1}
				ivjTableColumn_00_NombreSQL.setPreferredWidth(170);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_00_NombreSQL;
	}

	/**
	 * Return the TableColumnNombre property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_01_Nombre() {
		if (ivjTableColumn_01_Nombre == null) {
			try {
				ivjTableColumn_01_Nombre = new javax.swing.table.TableColumn();
				ivjTableColumn_01_Nombre.setModelIndex(1);
				ivjTableColumn_01_Nombre.setWidth(100);
				ivjTableColumn_01_Nombre.setHeaderValue("Nombre");
				ivjTableColumn_01_Nombre.setMinWidth(50);
				// user code begin {1}
				ivjTableColumn_01_Nombre.setPreferredWidth(170);
				efren.util.gui.text.TextFieldExt t = new efren.util.gui.text.TextFieldExt();
				t.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				t.setMaxLength(30);
				ivjTableColumn_01_Nombre.setCellEditor(new DefaultCellEditor(t));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_01_Nombre;
	}

	/**
	 * Return the TableColumnAncho property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_02_Ancho() {
		if (ivjTableColumn_02_Ancho == null) {
			try {
				ivjTableColumn_02_Ancho = new javax.swing.table.TableColumn();
				ivjTableColumn_02_Ancho.setModelIndex(2);
				ivjTableColumn_02_Ancho.setWidth(50);
				ivjTableColumn_02_Ancho.setHeaderValue("Ancho");
				ivjTableColumn_02_Ancho.setMinWidth(40);
				// user code begin {1}
				ivjTableColumn_02_Ancho.setPreferredWidth(55);
				efren.util.gui.text.TextFieldExt t = new efren.util.gui.text.TextFieldExt();
				t.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				t.setAllowedKey(efren.util.gui.text.TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
				t.setMaxLength(4);
				ivjTableColumn_02_Ancho.setCellEditor(new DefaultCellEditor(t));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_02_Ancho;
	}

	/**
	 * Return the TableColumnQuiebre property value.
	 *
	 * @return javax.swing.table.TableColumn /* WARNING: THIS METHOD WILL BE
	 *         REGENERATED.
	 */
	private javax.swing.table.TableColumn getTableColumn_03_Tiene_Quiebre() {
		if (ivjTableColumn_03_Tiene_Quiebre == null) {
			try {
				ivjTableColumn_03_Tiene_Quiebre = new javax.swing.table.TableColumn();
				ivjTableColumn_03_Tiene_Quiebre.setModelIndex(3);
				ivjTableColumn_03_Tiene_Quiebre.setWidth(80);
				ivjTableColumn_03_Tiene_Quiebre.setHeaderValue("Quiebre");
				ivjTableColumn_03_Tiene_Quiebre.setMinWidth(40);
				// user code begin {1}
				ivjTableColumn_03_Tiene_Quiebre.setPreferredWidth(55);
				javax.swing.JCheckBox jc = new javax.swing.JCheckBox();
				jc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				jc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
				ivjTableColumn_03_Tiene_Quiebre.setCellEditor(new DefaultCellEditor(jc));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_03_Tiene_Quiebre;
	}

	/**
	 * Return the TableColumn_04_Formula property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_04_Formula_Quiebre() {
		if (ivjTableColumn_04_Formula_Quiebre == null) {
			try {
				ivjTableColumn_04_Formula_Quiebre = new javax.swing.table.TableColumn();
				ivjTableColumn_04_Formula_Quiebre.setModelIndex(4);
				ivjTableColumn_04_Formula_Quiebre.setHeaderValue("F. quiebre");
				// user code begin {1}
				ivjTableColumn_04_Formula_Quiebre.setPreferredWidth(55);
				javax.swing.JComboBox jcb = new javax.swing.JComboBox();
				jcb.addItem("NINGUNA");
				jcb.addItem("SUMA");
				jcb.addItem("CONTEO");
				ivjTableColumn_04_Formula_Quiebre.setCellEditor(new DefaultCellEditor(jcb));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_04_Formula_Quiebre;
	}

	/**
	 * Return the TableColumn_05_Formula_Total property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_05_Formula_Total() {
		if (ivjTableColumn_05_Formula_Total == null) {
			try {
				ivjTableColumn_05_Formula_Total = new javax.swing.table.TableColumn();
				ivjTableColumn_05_Formula_Total.setModelIndex(5);
				ivjTableColumn_05_Formula_Total.setHeaderValue("F. total");
				// user code begin {1}
				ivjTableColumn_05_Formula_Total.setPreferredWidth(55);
				javax.swing.JComboBox jcb = new javax.swing.JComboBox();
				jcb.addItem("NINGUNA");
				jcb.addItem("SUMA");
				jcb.addItem("CONTEO");
				ivjTableColumn_05_Formula_Total.setCellEditor(new DefaultCellEditor(jcb));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_05_Formula_Total;
	}

	/**
	 * Return the TableColumn_05_Unidad_de_medida property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_06_Unidad_de_medida() {
		if (ivjTableColumn_06_Unidad_de_medida == null) {
			try {
				ivjTableColumn_06_Unidad_de_medida = new javax.swing.table.TableColumn();
				ivjTableColumn_06_Unidad_de_medida.setModelIndex(6);
				ivjTableColumn_06_Unidad_de_medida.setWidth(100);
				ivjTableColumn_06_Unidad_de_medida.setHeaderValue("Unidad de medida");
				// user code begin {1}
				ivjTableColumn_06_Unidad_de_medida.setPreferredWidth(55);
				efren.util.gui.text.TextFieldExt t = new efren.util.gui.text.TextFieldExt();
				t.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				t.setAllowedKey(efren.util.gui.text.TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
				t.setMaxLength(8);
				ivjTableColumn_06_Unidad_de_medida.setCellEditor(new DefaultCellEditor(t));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_06_Unidad_de_medida;
	}

	/**
	 * Return the TableColumn_07_Es_Negritas property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_07_Es_Negritas() {
		if (ivjTableColumn_07_Es_Negritas == null) {
			try {
				ivjTableColumn_07_Es_Negritas = new javax.swing.table.TableColumn();
				ivjTableColumn_07_Es_Negritas.setModelIndex(7);
				ivjTableColumn_07_Es_Negritas.setWidth(50);
				ivjTableColumn_07_Es_Negritas.setHeaderValue("Negritas");
				// user code begin {1}
				ivjTableColumn_07_Es_Negritas.setPreferredWidth(55);
				javax.swing.JCheckBox jc = new javax.swing.JCheckBox();
				jc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				jc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
				ivjTableColumn_07_Es_Negritas.setCellEditor(new DefaultCellEditor(jc));
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTableColumn_07_Es_Negritas;
	}

	/**
	 * Return the TableColumn_07_Es_Negritas property value.
	 *
	 * @return javax.swing.table.TableColumn
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.table.TableColumn getTableColumn_08_Color() {
		if (ivjTableColumn_08_Color == null) {
			ivjTableColumn_08_Color = new javax.swing.table.TableColumn();
			ivjTableColumn_08_Color.setModelIndex(8);
			ivjTableColumn_08_Color.setWidth(40);
			ivjTableColumn_08_Color.setHeaderValue("Color");
			ivjTableColumn_08_Color.setPreferredWidth(40);
			// ...
			// First, set up the button that brings up the dialog.
			final javax.swing.JButton button = new javax.swing.JButton("") {
				private static final long serialVersionUID = 1986630395204119306L;

				public void setText(String s) {
				}
			};
			button.setBackground(Color.white);
			button.setBorderPainted(false);
			button.setMargin(new Insets(0, 0, 0, 0));

			// Now create an editor to encapsulate the button, and
			// set it up as the editor for all Color cells.
			final ColorEditor colorEditor = new ColorEditor(button);
			// ivjTableColumn_08_Color.setCellEditor(colorEditor);
			getJTableDetalles().setDefaultEditor(Color.class, colorEditor);

			// Set up the dialog that the button brings up.
			final javax.swing.JColorChooser colorChooser = new javax.swing.JColorChooser();
			ActionListener okListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorEditor.currentColor = colorChooser.getColor();
				}
			};
			final javax.swing.JDialog dialog = javax.swing.JColorChooser.createDialog(button, "Escoja un Color", true, colorChooser, okListener, null);
			// XXXDoublecheck this is OK

			// Here's the code that brings up the dialog.
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					button.setBackground(colorEditor.currentColor);
					colorChooser.setColor(colorEditor.currentColor);
					// Without the following line, the dialog comes up
					// in the middle of the screen.
					// dialog.setLocationRelativeTo(button);
					dialog.setVisible(true);
				}
			});
			// ...renderer
			// ivjTableColumn_08_Color.setCellRenderer(new
			// ColorRenderer(true));
			getJTableDetalles().setDefaultRenderer(Color.class, new ColorRenderer(true));
			// user code end
		}
		return ivjTableColumn_08_Color;
	}

	/**
	 * Return the TextFieldExtAltoFila property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtAltoFila() {
		if (ivjTextFieldExtAltoFila == null) {
			try {
				ivjTextFieldExtAltoFila = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtAltoFila.setName("TextFieldExtAltoFila");
				ivjTextFieldExtAltoFila.setToolTipText("Si se deja el alto de fila en 0 las filas de las tablas del reporte tendrán alto automático");
				ivjTextFieldExtAltoFila.setValue("0");
				ivjTextFieldExtAltoFila.setAllowedKey(efren.util.gui.text.TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
				ivjTextFieldExtAltoFila.setKeyMask(efren.util.gui.text.TextFieldExt.KeyMask.KM_Numero);
				ivjTextFieldExtAltoFila.setMaxLength(4);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtAltoFila;
	}

	/**
	 * Return the TextFieldExtEtiquetaSubTotales property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtEtiquetaSubTotales() {
		if (ivjTextFieldExtEtiquetaSubTotales == null) {
			try {
				ivjTextFieldExtEtiquetaSubTotales = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtEtiquetaSubTotales.setName("TextFieldExtEtiquetaSubTotales");
				ivjTextFieldExtEtiquetaSubTotales.setFocusAccelerator('t');
				ivjTextFieldExtEtiquetaSubTotales.setMaxLength(100);
				ivjTextFieldExtEtiquetaSubTotales.setEnabled(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtEtiquetaSubTotales;
	}

	public void setSubtotalType(int unTipoSubtotal) {
		if (unTipoSubtotal == 1) {// 1: SUBTOTAL CON ETIQUETA DEL QUIEBRE
			getJCheckBoxMostrarEtiquetasSubtotales().setSelected(true);
			getTextFieldExtEtiquetaSubTotales().setValue("");
		} else {
			if (unTipoSubtotal == 2) {// 2: SUBTOTAL CON TEXTO LIBRE
				getJCheckBoxMostrarEtiquetasSubtotales().setSelected(false);
				getTextFieldExtEtiquetaSubTotales().setValue("SUBTOTAL:");
			}
		}
	}

	/**
	 * Return the TextFieldExtEtiquetaTotal property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtEtiquetaTotal() {
		if (ivjTextFieldExtEtiquetaTotal == null) {
			try {
				ivjTextFieldExtEtiquetaTotal = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtEtiquetaTotal.setName("TextFieldExtEtiquetaTotal");
				ivjTextFieldExtEtiquetaTotal.setFocusAccelerator('t');
				ivjTextFieldExtEtiquetaTotal.setMaxLength(100);
				ivjTextFieldExtEtiquetaTotal.setValue("TOTAL:");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtEtiquetaTotal;
	}

	/**
	 * Return the TextFieldExtTitulo1 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtTitulo1() {
		if (ivjTextFieldExtTitulo1 == null) {
			try {
				ivjTextFieldExtTitulo1 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtTitulo1.setName("TextFieldExtTitulo1");
				ivjTextFieldExtTitulo1.setFocusAccelerator('d');
				ivjTextFieldExtTitulo1.setMaxLength(200);
				ivjTextFieldExtTitulo1.setValue("");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo1;
	}

	/**
	 * Return the TextFieldExtTitulo2 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtTitulo2() {
		if (ivjTextFieldExtTitulo2 == null) {
			try {
				ivjTextFieldExtTitulo2 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtTitulo2.setName("TextFieldExtTitulo2");
				ivjTextFieldExtTitulo2.setFocusAccelerator('t');
				ivjTextFieldExtTitulo2.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo2;
	}

	/**
	 * Method generated to support the promotion of the titulo1 attribute.
	 *
	 * @return java.lang.String
	 */
	public java.lang.String getTitulo1() {
		return getTextFieldExtTitulo1().getValue();
	}

	/**
	 * Method generated to support the promotion of the titulo2 attribute.
	 *
	 * @return java.lang.String
	 */
	public java.lang.String getTitulo2() {
		return getTextFieldExtTitulo2().getValue();
	}

	/**
	 * Called whenever the part throws an exception.
	 *
	 * @param exception
	 *            java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {

		/*
		 * Uncomment the following lines to print uncaught exceptions to stdout
		 */
		// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
	}

	/**
	 * Initializes connections
	 *
	 * @exception java.lang.Exception
	 *                The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getJCheckBoxMostrarEtiquetasSubtotales().addItemListener(ivjEventHandler);
		getJCheckBoxAplicarEstilo().addItemListener(ivjEventHandler);
		getTextFieldExtTitulo1().addPropertyChangeListener(ivjEventHandler);
		getTextFieldExtTitulo2().addPropertyChangeListener(ivjEventHandler);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("DetallesPresentacionPanel");
			setLayout(new GridBagLayout());
			setSize(702, 367);

			GridBagConstraints constraintsJPanel = new GridBagConstraints();
			constraintsJPanel.gridx = 0;
			constraintsJPanel.gridy = 0;
			constraintsJPanel.gridwidth = 2;
			constraintsJPanel.gridheight = 2;
			constraintsJPanel.fill = GridBagConstraints.BOTH;
			constraintsJPanel.weightx = 1.0;
			constraintsJPanel.weighty = 1.0;
			add(getJPanel(), constraintsJPanel);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}

	/**
	 * Insert the method's description here. Creation date: (2005-01-05 17:33:43
	 * PM)
	 *
	 * @return boolean
	 */
	public boolean isExpress() {
		return express;
	}

	/**
	 * Insert the method's description here. Creation date: (2005-01-05 17:33:43
	 * PM)
	 *
	 * @param newExpress
	 *            boolean
	 */
	public void setExpress(boolean newExpress) {
		express = newExpress;
		// ...
		getLabelExt().setVisible(!express);
		getLabelExt1().setVisible(!express);
		getTextFieldExtTitulo1().setVisible(!express);
		getTextFieldExtTitulo2().setVisible(!express);
	}

	/**
	 * Insert the method's description here. Creation date: (19/12/2003
	 * 12:22:27)
	 *
	 * @param newFont0
	 *            Font
	 */
	public void setFont0(Font newFont0) {
		font0 = newFont0;
	}

	/**
	 * Insert the method's description here. Creation date: (19/12/2003
	 * 12:24:21)
	 *
	 * @param newFont1
	 *            Font
	 */
	public void setFont1(Font newFont1) {
		font1 = newFont1;
	}

	/**
	 * Method generated to support the promotion of the nombrePapel attribute.
	 *
	 * @param arg1
	 *            java.lang.Object
	 */
	public void setNombrePapel(java.lang.Object arg1) {
		getObjectComboBoxPapel().setSelectedItem(arg1);
	}

	public void setTitulo01(String arg) {
		getTextFieldExtTitulo1().setValue(arg);
	}

	public void setTitulo02(String arg) {
		getTextFieldExtTitulo2().setValue(arg);
	}

	/**
	 * Method generated to support the promotion of the titulo1 attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setTitulo1(java.lang.String arg1) {
		getTextFieldExtTitulo1().setValue(arg1);
	}

	/**
	 * Method generated to support the promotion of the titulo2 attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setTitulo2(java.lang.String arg1) {
		getTextFieldExtTitulo2().setValue(arg1);
	}

	public boolean validar() {

		if (getTextFieldExtTitulo1().isDataMissing("Ingrese un TITULO1 !"))
			return false;
		if (getTextFieldExtTitulo2().isDataMissing("Ingrese un TITULO2 !"))
			return false;
		if (getObjectComboBoxPapel().isDataMissing("Seleccione un tamaño de papel !"))
			return false;
		if (getFontChooser().isDataMissing())
			return false;
		if (!getJCheckBoxMostrarEtiquetasSubtotales().isSelected()) {
			if (getTextFieldExtEtiquetaSubTotales().isDataMissing("Ingrese la etiqueta de los SUBTOTALES !"))
				return false;
		}
		if (getTextFieldExtEtiquetaTotal().isDataMissing("Ingrese la etiqueta del TOTAL GENERAL !"))
			return false;
		if (getTextFieldExtAltoFila().isDataMissing("Ingrese un alto de fila !"))
			return false;

		return true;
	}

	private void visualManageSubTotales() {

		if (getJCheckBoxMostrarEtiquetasSubtotales().isSelected())
			getTextFieldExtEtiquetaSubTotales().setEnabled(false);
		else
			getTextFieldExtEtiquetaSubTotales().setEnabled(true);
	}

	private void visualManageTableStyleChooser() {

		if (getJCheckBoxAplicarEstilo().isSelected()) {
			getReportTableStyleChooser().setEnabled(true);
		} else {
			getReportTableStyleChooser().setEnabled(false);
		}
	}

	public TableModel getTableModel() {
		TableModel detallesModel = (TableModel) getJTableDetalles().getModel();
		return detallesModel;
	}

	public void setTableStyle(TableStyle anStyle) {
		getReportTableStyleChooser().setTableStyle(anStyle);
	}

	public void setAltoFila(String unAltoFila) {
		getTextFieldExtAltoFila().setValue(unAltoFila);
	}

	public boolean isScrollPaneTableVisible() {
		return getJScrollPane1().isVisible();
	}

	public void setScrollPaneTableVisible(boolean visible) {
		getJScrollPane1().setVisible(visible);
	}

	/**
	 * This method initializes multiChoiceOrientacion
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	private MultiChoice getMultiChoiceOrientacion() {
		if (multiChoiceOrientacion == null) {
			multiChoiceOrientacion = new MultiChoice();
			String items[] = { "Vertical", "Horizontal" };
			multiChoiceOrientacion.setNameOptions(items, false, false);
			String values[] = { String.valueOf(VERTICAL), String.valueOf(HORIZONTAL) };
			multiChoiceOrientacion.setValueOptions(values);
			multiChoiceOrientacion.setSelectedIndex(0);
		}
		return multiChoiceOrientacion;
	}

	/**
	 *
	 */
	public boolean esOrientacionHorizontal() {
		return getMultiChoiceOrientacion().getSelectedIndex() == 1;
	}

	/**
	 *
	 */
	public int papelSeleccionado() {
		return new Integer(getObjectComboBoxPapel().getSelectedValueItem().toString().trim()).intValue();
	}
}
