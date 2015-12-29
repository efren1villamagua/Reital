package efren.util.abms;

import java.awt.Color;
import java.util.Vector;

import efren.util.ExceptionManager;
import efren.util.gui.filechooser.FileChooserPanel;
import efren.util.gui.text.TextFieldExt;
import efren.util.reportes.ReportesDefinitionController;

public class DataExportView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, efren.util.gui.FindObjectsPanelListener,
		javax.swing.event.InternalFrameListener {
	private javax.swing.JPanel ivjJFrameContentPane = null;

	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;

	private javax.swing.JCheckBox ivjJCheckBoxAppend = null;

	private javax.swing.JPanel ivjJPanel1 = null;

	private javax.swing.JTabbedPane ivjJTabbedPane1 = null;

	private javax.swing.JPanel ivjJFrameContentPane1 = null;

	private efren.util.gui.LabelExt ivjLabelExt = null;

	private efren.util.gui.LabelExt ivjLabelExt2 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor01 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor02 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor03 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor04 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor05 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor06 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor07 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor08 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor09 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtValor10 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable01 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable02 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable03 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable04 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable05 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable06 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable07 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable08 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable09 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtVariable10 = null;

	// ...
	private static String s, aLinea, lineaTemp, tst;

	private static java.sql.Statement st;

	private static java.sql.ResultSet rs;

	private static int cc;

	private static java.io.FileOutputStream fos;

	private static java.io.BufferedWriter bw;

	private static java.util.Vector varibales;

	private static java.util.Vector valores;

	private String classArgs;

	private efren.util.gui.FindObjectsPanel ivjFindByObjectPanelSqlSeleccion = null;

	private String SQLClause = null;

	private FileChooserPanel ivjFileChooserPanel1 = null;

	private efren.util.gui.text.TextAreaExt ivjTextAreaExtSQL = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public DataExportView() {
		super();
		initialize();
	}

	/**
	 * ExportaTablaView constructor comment.
	 *
	 * @param title
	 *            java.lang.String
	 */
	public DataExportView(String title) {
		super(title);
	}

	public void _cerrar() {
		this.dispose();
	}

	public void _manejoAccesos(String classArgs) {

		this.classArgs = classArgs;
	}

	private void aceptar() {

		try {

			if (!validar())
				return;
			setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

			// ...

			String sentenciaSQL = this.SQLClause.trim();
			Vector<TextFieldExt> varsComponentsList = new Vector<TextFieldExt>();
			Vector<TextFieldExt> valuesComponentsList = new Vector<TextFieldExt>();
			varsComponentsList.addElement(getTextFieldExtVariable01());
			valuesComponentsList.addElement(getTextFieldExtValor01());
			varsComponentsList.addElement(getTextFieldExtVariable02());
			valuesComponentsList.addElement(getTextFieldExtValor02());
			varsComponentsList.addElement(getTextFieldExtVariable03());
			valuesComponentsList.addElement(getTextFieldExtValor03());
			varsComponentsList.addElement(getTextFieldExtVariable04());
			valuesComponentsList.addElement(getTextFieldExtValor04());
			varsComponentsList.addElement(getTextFieldExtVariable05());
			valuesComponentsList.addElement(getTextFieldExtValor05());
			varsComponentsList.addElement(getTextFieldExtVariable06());
			valuesComponentsList.addElement(getTextFieldExtValor06());
			varsComponentsList.addElement(getTextFieldExtVariable07());
			valuesComponentsList.addElement(getTextFieldExtValor07());
			varsComponentsList.addElement(getTextFieldExtVariable08());
			valuesComponentsList.addElement(getTextFieldExtValor08());
			Vector resultado = ReportesDefinitionController.extractVarsAndValuesFrom(varsComponentsList, valuesComponentsList);

			String sqlFinal = ReportesDefinitionController.parse_variables_to_SQL(sentenciaSQL, (Vector) resultado.elementAt(0), (Vector) resultado.elementAt(1));
			rs = st.executeQuery(sqlFinal);

		} catch (Throwable t0) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, t0.getMessage());
			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			return;
		}

		// ...
		try {
			if (getJCheckBoxAppend().isSelected())
				fos = new java.io.FileOutputStream(getFileChooserPanel1().getSelectedFile().getAbsolutePath(), true);
			else
				fos = new java.io.FileOutputStream(getFileChooserPanel1().getSelectedFile());
			bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(fos)));
		} catch (Throwable t1) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, t1.getMessage());
			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			return;
		}

		try {

			cc = rs.getMetaData().getColumnCount();
			aLinea = "";
			while (rs.next()) {

				// se forma la linea
				for (int i = 1; i <= cc; i++) {
					try {
						aLinea = aLinea + rs.getObject(i);
					} catch (NullPointerException t88) {
						aLinea = aLinea + "NULO";
					}
				}

				lineaTemp = aLinea;
				while (lineaTemp.indexOf("&A") > 0) {
					lineaTemp = parse1(lineaTemp);
				}
				while (lineaTemp.indexOf("&B") > 0) {
					lineaTemp = parse3(lineaTemp);
				}

				bw.write(lineaTemp);

				bw.newLine();
				aLinea = "";
			}

			bw.flush();
			bw.close();

		} catch (Throwable t2) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, t2.getMessage());
			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			return;
		}

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		efren.util.gui.dialogs.InfoView.showInformationDialog(this, "¡ La exportación de datos ha concluído con éxito !");
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void aceptarClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getBarraAceptarCancelarPanel())
			connEtoC1(newEvent);
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
		if (newEvent.getSource() == getBarraAceptarCancelarPanel())
			connEtoC2(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * connEtoC1:
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject)
	 * --> DataExportView.aceptar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.aceptar();
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
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject)
	 * --> DataExportView._cerrar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this._cerrar();
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
	 * (FindByObjectPanelSqlSeleccion.findObjectsPanel.selectedObject(java.util.EventObject)
	 * --> DataExportView.showVariables()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.showVariables();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM3: (DataExportView.initialize() -->
	 * FindByObjectPanelSqlSeleccion._findAllByName()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM3() {
		try {
			// user code begin {1}
			// user code end
			//getFindByObjectPanelSqlSeleccion()._fillBy_name();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public static void crearArchivo(String sql, String filePath) {

		String s = null;
		java.sql.PreparedStatement st = null;
		java.sql.ResultSet rs = null;

		java.sql.Connection con = efren.util.Conn.conectar();

		// ...
		try {

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
		} catch (Throwable t0) {
			System.out.println(t0.getMessage());
			return;
		}

		// ...
		java.io.FileOutputStream fos = null;
		java.io.BufferedWriter bw = null;
		try {
			fos = new java.io.FileOutputStream(filePath);
			bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(fos)));
		} catch (Throwable t1) {
			System.out.println(t1.getMessage());
			return;
		}

		try {

			int cc = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= cc; i++)
					bw.write(rs.getObject(i).toString());
				bw.newLine();
			}

			bw.flush();
			bw.close();

			st.close();
			rs.close();

			con.commit();

		} catch (Throwable t2) {
			System.out.println(t2.getMessage());
		}
	}

	/**
	 * Return the BarraAceptarCancelarPanel property value.
	 *
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
		if (ivjBarraAceptarCancelarPanel == null) {
			try {
				ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
				ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
				ivjBarraAceptarCancelarPanel.setButtonCancelarVisible(true);
				ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cerrar");
				ivjBarraAceptarCancelarPanel.setButtonAceptarText("Exportar");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarraAceptarCancelarPanel;
	}

	/**
	 * Return the FileChooserPanel1 property value.
	 *
	 * @return efren.util.filechooser.FileChooserPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private FileChooserPanel getFileChooserPanel1() {
		if (ivjFileChooserPanel1 == null) {
			try {
				ivjFileChooserPanel1 = new FileChooserPanel();
				ivjFileChooserPanel1.setName("FileChooserPanel1");
				ivjFileChooserPanel1.setTitulo("Archivo destino");
				ivjFileChooserPanel1.setFileExtension("TXT");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjFileChooserPanel1;
	}

	/**
	 * Return the FindByObjectPanelSqlSeleccion property value.
	 *
	 * @return efren.abm.beans.FindObjectsPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.FindObjectsPanel getFindByObjectPanelSqlSeleccion() {
		if (ivjFindByObjectPanelSqlSeleccion == null) {
			try {
				ivjFindByObjectPanelSqlSeleccion = new efren.util.gui.FindObjectsPanel();
				ivjFindByObjectPanelSqlSeleccion.setName("FindByObjectPanelSqlSeleccion");
				ivjFindByObjectPanelSqlSeleccion.setTABLE_NAME("FILEDEFINITION");
				ivjFindByObjectPanelSqlSeleccion.setDISPLAYING_FIELD("NOMBRE");
				ivjFindByObjectPanelSqlSeleccion.setNullable(false);
				ivjFindByObjectPanelSqlSeleccion.setFieldCodigoVisible(false);
				ivjFindByObjectPanelSqlSeleccion.setCodigoCriteriaLabel("Datos a exportar");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjFindByObjectPanelSqlSeleccion;
	}

	/**
	 * Return the JCheckBoxAppend property value.
	 *
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxAppend() {
		if (ivjJCheckBoxAppend == null) {
			try {
				ivjJCheckBoxAppend = new javax.swing.JCheckBox();
				ivjJCheckBoxAppend.setName("JCheckBoxAppend");
				ivjJCheckBoxAppend.setFont(new java.awt.Font("Arial", 0, 10));
				ivjJCheckBoxAppend.setText("Agregar a archivo ya existente");
				ivjJCheckBoxAppend.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxAppend;
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
				ivjJFrameContentPane = new javax.swing.JPanel();
				ivjJFrameContentPane.setName("JFrameContentPane");
				ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsFindByObjectPanelSqlSeleccion = new java.awt.GridBagConstraints();
				constraintsFindByObjectPanelSqlSeleccion.gridx = 0;
				constraintsFindByObjectPanelSqlSeleccion.gridy = 1;
				constraintsFindByObjectPanelSqlSeleccion.gridwidth = 2;
				constraintsFindByObjectPanelSqlSeleccion.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsFindByObjectPanelSqlSeleccion.weightx = 1.0;
				constraintsFindByObjectPanelSqlSeleccion.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane().add(getFindByObjectPanelSqlSeleccion(), constraintsFindByObjectPanelSqlSeleccion);

				java.awt.GridBagConstraints constraintsFileChooserPanel1 = new java.awt.GridBagConstraints();
				constraintsFileChooserPanel1.gridx = 0;
				constraintsFileChooserPanel1.gridy = 2;
				constraintsFileChooserPanel1.gridwidth = 2;
				constraintsFileChooserPanel1.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsFileChooserPanel1.weightx = 1.0;
				constraintsFileChooserPanel1.insets = new java.awt.Insets(5, 5, 0, 5);
				getJFrameContentPane().add(getFileChooserPanel1(), constraintsFileChooserPanel1);

				java.awt.GridBagConstraints constraintsJCheckBoxAppend = new java.awt.GridBagConstraints();
				constraintsJCheckBoxAppend.gridx = 0;
				constraintsJCheckBoxAppend.gridy = 3;
				constraintsJCheckBoxAppend.insets = new java.awt.Insets(0, 5, 5, 5);
				getJFrameContentPane().add(getJCheckBoxAppend(), constraintsJCheckBoxAppend);

				java.awt.GridBagConstraints constraintsTextAreaExtSQL = new java.awt.GridBagConstraints();
				constraintsTextAreaExtSQL.gridx = 0;
				constraintsTextAreaExtSQL.gridy = 0;
				constraintsTextAreaExtSQL.fill = java.awt.GridBagConstraints.BOTH;
				constraintsTextAreaExtSQL.weightx = 1.0;
				constraintsTextAreaExtSQL.weighty = 1.0;
				constraintsTextAreaExtSQL.insets = new java.awt.Insets(4, 4, 4, 4);
				getJFrameContentPane().add(getTextAreaExtSQL(), constraintsTextAreaExtSQL);
				// user code begin {1}

				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the JFrameContentPane1 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJFrameContentPane1() {
		if (ivjJFrameContentPane1 == null) {
			try {
				ivjJFrameContentPane1 = new javax.swing.JPanel();
				ivjJFrameContentPane1.setName("JFrameContentPane1");
				ivjJFrameContentPane1.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsTextFieldExtValor01 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor01.gridx = 1;
				constraintsTextFieldExtValor01.gridy = 1;
				constraintsTextFieldExtValor01.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor01.weightx = 1.0;
				constraintsTextFieldExtValor01.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor01(), constraintsTextFieldExtValor01);

				java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
				constraintsLabelExt2.gridx = 1;
				constraintsLabelExt2.gridy = 0;
				constraintsLabelExt2.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt2.weightx = 1.0;
				constraintsLabelExt2.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getLabelExt2(), constraintsLabelExt2);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable01 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable01.gridx = 0;
				constraintsTextFieldExtVariable01.gridy = 1;
				constraintsTextFieldExtVariable01.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable01.weightx = 1.0;
				constraintsTextFieldExtVariable01.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable01(), constraintsTextFieldExtVariable01);

				java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
				constraintsLabelExt.gridx = 0;
				constraintsLabelExt.gridy = 0;
				constraintsLabelExt.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsLabelExt.weightx = 1.0;
				constraintsLabelExt.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getLabelExt(), constraintsLabelExt);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable02 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable02.gridx = 0;
				constraintsTextFieldExtVariable02.gridy = 2;
				constraintsTextFieldExtVariable02.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable02.weightx = 1.0;
				constraintsTextFieldExtVariable02.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable02(), constraintsTextFieldExtVariable02);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable03 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable03.gridx = 0;
				constraintsTextFieldExtVariable03.gridy = 3;
				constraintsTextFieldExtVariable03.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable03.weightx = 1.0;
				constraintsTextFieldExtVariable03.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable03(), constraintsTextFieldExtVariable03);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable04 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable04.gridx = 0;
				constraintsTextFieldExtVariable04.gridy = 4;
				constraintsTextFieldExtVariable04.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable04.weightx = 1.0;
				constraintsTextFieldExtVariable04.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable04(), constraintsTextFieldExtVariable04);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable05 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable05.gridx = 0;
				constraintsTextFieldExtVariable05.gridy = 5;
				constraintsTextFieldExtVariable05.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable05.weightx = 1.0;
				constraintsTextFieldExtVariable05.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable05(), constraintsTextFieldExtVariable05);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable06 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable06.gridx = 0;
				constraintsTextFieldExtVariable06.gridy = 6;
				constraintsTextFieldExtVariable06.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable06.weightx = 1.0;
				constraintsTextFieldExtVariable06.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable06(), constraintsTextFieldExtVariable06);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable07 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable07.gridx = 0;
				constraintsTextFieldExtVariable07.gridy = 7;
				constraintsTextFieldExtVariable07.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable07.weightx = 1.0;
				constraintsTextFieldExtVariable07.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable07(), constraintsTextFieldExtVariable07);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable08 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable08.gridx = 0;
				constraintsTextFieldExtVariable08.gridy = 8;
				constraintsTextFieldExtVariable08.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable08.weightx = 1.0;
				constraintsTextFieldExtVariable08.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable08(), constraintsTextFieldExtVariable08);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable09 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable09.gridx = 0;
				constraintsTextFieldExtVariable09.gridy = 9;
				constraintsTextFieldExtVariable09.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable09.weightx = 1.0;
				constraintsTextFieldExtVariable09.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable09(), constraintsTextFieldExtVariable09);

				java.awt.GridBagConstraints constraintsTextFieldExtVariable10 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtVariable10.gridx = 0;
				constraintsTextFieldExtVariable10.gridy = 10;
				constraintsTextFieldExtVariable10.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtVariable10.weightx = 1.0;
				constraintsTextFieldExtVariable10.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtVariable10(), constraintsTextFieldExtVariable10);

				java.awt.GridBagConstraints constraintsTextFieldExtValor02 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor02.gridx = 1;
				constraintsTextFieldExtValor02.gridy = 2;
				constraintsTextFieldExtValor02.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor02.weightx = 1.0;
				constraintsTextFieldExtValor02.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor02(), constraintsTextFieldExtValor02);

				java.awt.GridBagConstraints constraintsTextFieldExtValor03 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor03.gridx = 1;
				constraintsTextFieldExtValor03.gridy = 3;
				constraintsTextFieldExtValor03.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor03.weightx = 1.0;
				constraintsTextFieldExtValor03.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor03(), constraintsTextFieldExtValor03);

				java.awt.GridBagConstraints constraintsTextFieldExtValor04 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor04.gridx = 1;
				constraintsTextFieldExtValor04.gridy = 4;
				constraintsTextFieldExtValor04.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor04.weightx = 1.0;
				constraintsTextFieldExtValor04.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor04(), constraintsTextFieldExtValor04);

				java.awt.GridBagConstraints constraintsTextFieldExtValor05 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor05.gridx = 1;
				constraintsTextFieldExtValor05.gridy = 5;
				constraintsTextFieldExtValor05.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor05.weightx = 1.0;
				constraintsTextFieldExtValor05.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor05(), constraintsTextFieldExtValor05);

				java.awt.GridBagConstraints constraintsTextFieldExtValor06 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor06.gridx = 1;
				constraintsTextFieldExtValor06.gridy = 6;
				constraintsTextFieldExtValor06.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor06.weightx = 1.0;
				constraintsTextFieldExtValor06.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor06(), constraintsTextFieldExtValor06);

				java.awt.GridBagConstraints constraintsTextFieldExtValor07 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor07.gridx = 1;
				constraintsTextFieldExtValor07.gridy = 7;
				constraintsTextFieldExtValor07.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor07.weightx = 1.0;
				constraintsTextFieldExtValor07.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor07(), constraintsTextFieldExtValor07);

				java.awt.GridBagConstraints constraintsTextFieldExtValor08 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor08.gridx = 1;
				constraintsTextFieldExtValor08.gridy = 8;
				constraintsTextFieldExtValor08.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor08.weightx = 1.0;
				constraintsTextFieldExtValor08.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor08(), constraintsTextFieldExtValor08);

				java.awt.GridBagConstraints constraintsTextFieldExtValor09 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor09.gridx = 1;
				constraintsTextFieldExtValor09.gridy = 9;
				constraintsTextFieldExtValor09.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor09.weightx = 1.0;
				constraintsTextFieldExtValor09.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor09(), constraintsTextFieldExtValor09);

				java.awt.GridBagConstraints constraintsTextFieldExtValor10 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtValor10.gridx = 1;
				constraintsTextFieldExtValor10.gridy = 10;
				constraintsTextFieldExtValor10.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtValor10.weightx = 1.0;
				constraintsTextFieldExtValor10.insets = new java.awt.Insets(5, 5, 5, 5);
				getJFrameContentPane1().add(getTextFieldExtValor10(), constraintsTextFieldExtValor10);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJFrameContentPane1;
	}

	/**
	 * Return the JPanel1 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			try {
				ivjJPanel1 = new javax.swing.JPanel();
				ivjJPanel1.setName("JPanel1");
				ivjJPanel1.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsJTabbedPane1 = new java.awt.GridBagConstraints();
				constraintsJTabbedPane1.gridx = 0;
				constraintsJTabbedPane1.gridy = 0;
				constraintsJTabbedPane1.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJTabbedPane1.weightx = 1.0;
				constraintsJTabbedPane1.weighty = 1.0;
				constraintsJTabbedPane1.insets = new java.awt.Insets(5, 5, 5, 5);
				getJPanel1().add(getJTabbedPane1(), constraintsJTabbedPane1);

				java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelarPanel.gridx = 0;
				constraintsBarraAceptarCancelarPanel.gridy = 1;
				constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.SOUTHEAST;
				constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 5, 5);
				getJPanel1().add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanel1;
	}

	/**
	 * Return the JTabbedPane1 property value.
	 *
	 * @return javax.swing.JTabbedPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTabbedPane getJTabbedPane1() {
		if (ivjJTabbedPane1 == null) {
			try {
				ivjJTabbedPane1 = new javax.swing.JTabbedPane();
				ivjJTabbedPane1.setName("JTabbedPane1");
				ivjJTabbedPane1.setFont(new java.awt.Font("Arial", 0, 10));
				ivjJTabbedPane1.insertTab("Opciones", null, getJFrameContentPane(), null, 0);
				ivjJTabbedPane1.insertTab("Variables", null, getJFrameContentPane1(), null, 1);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTabbedPane1;
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
				ivjLabelExt.setText("Variables");
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
	 * Return the LabelExt2 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt2() {
		if (ivjLabelExt2 == null) {
			try {
				ivjLabelExt2 = new efren.util.gui.LabelExt();
				ivjLabelExt2.setName("LabelExt2");
				ivjLabelExt2.setText("Valores");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt2;
	}

	/**
	 * Return the TextAreaExtSQL property value.
	 *
	 * @return efren.util.gui.TextAreaExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextAreaExt getTextAreaExtSQL() {
		if (ivjTextAreaExtSQL == null) {
			try {
				ivjTextAreaExtSQL = new efren.util.gui.text.TextAreaExt();
				ivjTextAreaExtSQL.setName("TextAreaExtSQL");
				ivjTextAreaExtSQL.setMaxLength(5000);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextAreaExtSQL;
	}

	/**
	 * Return the TextFieldExtValor01 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor01() {
		if (ivjTextFieldExtValor01 == null) {
			try {
				ivjTextFieldExtValor01 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor01.setName("TextFieldExtValor01");
				ivjTextFieldExtValor01.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor01;
	}

	/**
	 * Return the TextFieldExtValor02 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor02() {
		if (ivjTextFieldExtValor02 == null) {
			try {
				ivjTextFieldExtValor02 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor02.setName("TextFieldExtValor02");
				ivjTextFieldExtValor02.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor02;
	}

	/**
	 * Return the TextFieldExtValor03 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor03() {
		if (ivjTextFieldExtValor03 == null) {
			try {
				ivjTextFieldExtValor03 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor03.setName("TextFieldExtValor03");
				ivjTextFieldExtValor03.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor03;
	}

	/**
	 * Return the TextFieldExtValor04 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor04() {
		if (ivjTextFieldExtValor04 == null) {
			try {
				ivjTextFieldExtValor04 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor04.setName("TextFieldExtValor04");
				ivjTextFieldExtValor04.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor04;
	}

	/**
	 * Return the TextFieldExtValor05 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor05() {
		if (ivjTextFieldExtValor05 == null) {
			try {
				ivjTextFieldExtValor05 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor05.setName("TextFieldExtValor05");
				ivjTextFieldExtValor05.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor05;
	}

	/**
	 * Return the TextFieldExtValor06 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor06() {
		if (ivjTextFieldExtValor06 == null) {
			try {
				ivjTextFieldExtValor06 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor06.setName("TextFieldExtValor06");
				ivjTextFieldExtValor06.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor06;
	}

	/**
	 * Return the TextFieldExtValor07 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor07() {
		if (ivjTextFieldExtValor07 == null) {
			try {
				ivjTextFieldExtValor07 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor07.setName("TextFieldExtValor07");
				ivjTextFieldExtValor07.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor07;
	}

	/**
	 * Return the TextFieldExtValor08 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor08() {
		if (ivjTextFieldExtValor08 == null) {
			try {
				ivjTextFieldExtValor08 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor08.setName("TextFieldExtValor08");
				ivjTextFieldExtValor08.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor08;
	}

	/**
	 * Return the TextFieldExtValor09 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor09() {
		if (ivjTextFieldExtValor09 == null) {
			try {
				ivjTextFieldExtValor09 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor09.setName("TextFieldExtValor09");
				ivjTextFieldExtValor09.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor09;
	}

	/**
	 * Return the TextFieldExtValor10 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor10() {
		if (ivjTextFieldExtValor10 == null) {
			try {
				ivjTextFieldExtValor10 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtValor10.setName("TextFieldExtValor10");
				ivjTextFieldExtValor10.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor10;
	}

	/**
	 * Return the TextFieldExtVariable01 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable01() {
		if (ivjTextFieldExtVariable01 == null) {
			try {
				ivjTextFieldExtVariable01 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable01.setName("TextFieldExtVariable01");
				ivjTextFieldExtVariable01.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable01;
	}

	/**
	 * Return the TextFieldExtVariable02 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable02() {
		if (ivjTextFieldExtVariable02 == null) {
			try {
				ivjTextFieldExtVariable02 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable02.setName("TextFieldExtVariable02");
				ivjTextFieldExtVariable02.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable02;
	}

	/**
	 * Return the TextFieldExtVariable03 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable03() {
		if (ivjTextFieldExtVariable03 == null) {
			try {
				ivjTextFieldExtVariable03 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable03.setName("TextFieldExtVariable03");
				ivjTextFieldExtVariable03.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable03;
	}

	/**
	 * Return the TextFieldExtVariable04 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable04() {
		if (ivjTextFieldExtVariable04 == null) {
			try {
				ivjTextFieldExtVariable04 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable04.setName("TextFieldExtVariable04");
				ivjTextFieldExtVariable04.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable04;
	}

	/**
	 * Return the TextFieldExtVariable05 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable05() {
		if (ivjTextFieldExtVariable05 == null) {
			try {
				ivjTextFieldExtVariable05 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable05.setName("TextFieldExtVariable05");
				ivjTextFieldExtVariable05.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable05;
	}

	/**
	 * Return the TextFieldExtVariable06 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable06() {
		if (ivjTextFieldExtVariable06 == null) {
			try {
				ivjTextFieldExtVariable06 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable06.setName("TextFieldExtVariable06");
				ivjTextFieldExtVariable06.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable06;
	}

	/**
	 * Return the TextFieldExtVariable07 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable07() {
		if (ivjTextFieldExtVariable07 == null) {
			try {
				ivjTextFieldExtVariable07 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable07.setName("TextFieldExtVariable07");
				ivjTextFieldExtVariable07.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable07;
	}

	/**
	 * Return the TextFieldExtVariable08 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable08() {
		if (ivjTextFieldExtVariable08 == null) {
			try {
				ivjTextFieldExtVariable08 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable08.setName("TextFieldExtVariable08");
				ivjTextFieldExtVariable08.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable08;
	}

	/**
	 * Return the TextFieldExtVariable09 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable09() {
		if (ivjTextFieldExtVariable09 == null) {
			try {
				ivjTextFieldExtVariable09 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable09.setName("TextFieldExtVariable09");
				ivjTextFieldExtVariable09.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable09;
	}

	/**
	 * Return the TextFieldExtVariable10 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtVariable10() {
		if (ivjTextFieldExtVariable10 == null) {
			try {
				ivjTextFieldExtVariable10 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtVariable10.setName("TextFieldExtVariable10");
				ivjTextFieldExtVariable10.setMaxLength(100);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable10;
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
		getFindByObjectPanelSqlSeleccion().addFindObjectsPanelListener(this);
		getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("DataExportView");
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			setSize(473, 438);
			setTitle("Exportación de datos ");
			setContentPane(getJPanel1());
			initConnections();
			connEtoM3();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		efren.util.WindowManager.centerWindow(this);
		initProperties();
		this.addInternalFrameListener(this);
		// user code end
	}

	private void initProperties() {
		try {
			st = efren.util.Conn.conectar().createStatement();
		} catch (Throwable t) {
			t.getMessage();
		}
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

	public static String parse1(String linea) {
		// parse de variables numéricas
		/**
		 * ejemplo: SELECT CODIGO, NOMBRE, '&Appd',SUELDO,'&Z' FROM PERSONAL en
		 * donde: - &A indica el inicio del valor numerico - pp representa la
		 * cantidad de posiciones totales del valor (sin contar el signo
		 * decimal). (siempre debe ir dos dígitos) - d representa que si va el
		 * signo decimal (0: no va, 1: si va) - &Z indica el fin del valor
		 * numérico
		 */
		// ...
		try {
			int inicioValor = linea.indexOf("&A");
			int finValor = linea.indexOf("&Z", inicioValor);
			int posiciones = new Integer(linea.substring(inicioValor + 2, inicioValor + 4)).intValue();
			boolean signoDecimal = linea.substring(inicioValor + 4, inicioValor + 5).compareTo("1") == 0;
			String newLine = "";
			String valor = linea.substring(inicioValor + 5, finValor);
			if (valor.length() - 1 > posiciones) {
				return linea.substring(0, inicioValor) + valor + linea.substring(finValor + 2);
			}
			String entera, decimal;
			if (valor.indexOf(".") > 0) {
				java.util.StringTokenizer st = new java.util.StringTokenizer(valor, ".");
				entera = st.nextToken().trim();
				decimal = st.nextToken().trim();
				if (decimal.length() > 2)
					decimal = decimal.substring(0, 2);
				if (decimal.trim().length() == 1) {
					decimal = decimal + "0";
				} else {
					if (decimal.trim().length() == 0)
						decimal = decimal + "00";
				}
			} else {
				entera = valor;
				decimal = "00";
			}
			int cf = posiciones - entera.trim().length() - decimal.trim().length();
			String ceros = "";
			for (int i = 0; i < cf; i++) {
				ceros = ceros + "0";
			}
			if (signoDecimal) {
				return linea.substring(0, inicioValor) + ceros + entera + "." + decimal + linea.substring(finValor + 2);
			} else {
				return linea.substring(0, inicioValor) + ceros + entera + decimal + linea.substring(finValor + 2);
			}
		} catch (Throwable t) {
			return linea;
		}
	}

	public static String parse3(String linea) {
		// parse de variables numéricas
		/**
		 * ejemplo: SELECT CODIGO, NOMBRE, '&Bpp',SUELDO,'&Z' FROM PERSONAL en
		 * donde: - &B indica el inicio del valor numerico - pp representa la
		 * cantidad de posiciones totales del valor (sin contar el signo
		 * decimal). (siempre debe ir dos dígitos) - &Z indica el fin del valor
		 * numérico
		 */
		// ...
		try {
			int inicioValor = linea.indexOf("&B");
			int finValor = linea.indexOf("&Z", inicioValor);
			int posiciones = new Integer(linea.substring(inicioValor + 2, inicioValor + 4)).intValue();

			String newLine = "";
			String valor = linea.substring(inicioValor + 4, finValor);

			if (valor.length() > posiciones)
				return linea.substring(0, inicioValor) + valor + linea.substring(finValor + 2);

			int cf = posiciones - valor.trim().length();
			String ceros = "";
			for (int i = 0; i < cf; i++) {
				ceros = ceros + "0";
			}
			return linea.substring(0, inicioValor) + ceros + valor + linea.substring(finValor + 2);
		} catch (Throwable t) {
			return linea;
		}
	}

	/**
	 * Method to handle events for the FindObjectsPanelListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void selectedObject(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getFindByObjectPanelSqlSeleccion())
			connEtoC3(newEvent);
		// user code begin {2}
		// user code end
	}

	private void showVariables() {

		try {

			s = "SELECT SENTENCIASQL FROM FILEDEFINITION WHERE OID=" + getFindByObjectPanelSqlSeleccion().getValue();
			rs = st.executeQuery(s);
			String sentencia = null;
			while (rs.next()) {
				sentencia = rs.getString(1).trim();
			}

			java.util.Hashtable variables = new java.util.Hashtable();

			int posicionInicio = 0;
			int posicionFin = 0;
			boolean hayMasVariables = sentencia.indexOf("[_") >= 0;
			String variable = null;
			while (hayMasVariables) {
				posicionInicio = sentencia.indexOf("_]", sentencia.indexOf("[_"));
				posicionFin = sentencia.indexOf("[_");
				if (posicionInicio >= 0)
					variable = sentencia.substring(posicionFin + 2, posicionInicio);
				else
					variable = sentencia.substring(posicionFin + 2);
				variables.put(variable.trim(), variable.trim());
				if (posicionInicio >= 0)
					sentencia = sentencia.substring(posicionInicio);
				else
					sentencia = sentencia.substring(posicionFin + variable.length());
				hayMasVariables = sentencia.indexOf("[_") >= 0;
			}

			// ...
			getTextFieldExtVariable01().setValue("");
			getTextFieldExtValor01().setValue("");
			getTextFieldExtVariable02().setValue("");
			getTextFieldExtValor02().setValue("");
			getTextFieldExtVariable03().setValue("");
			getTextFieldExtValor03().setValue("");
			getTextFieldExtVariable04().setValue("");
			getTextFieldExtValor04().setValue("");
			getTextFieldExtVariable05().setValue("");
			getTextFieldExtValor05().setValue("");
			getTextFieldExtVariable06().setValue("");
			getTextFieldExtValor06().setValue("");
			getTextFieldExtVariable07().setValue("");
			getTextFieldExtValor07().setValue("");
			getTextFieldExtVariable08().setValue("");
			getTextFieldExtValor08().setValue("");
			getTextFieldExtVariable09().setValue("");
			getTextFieldExtValor09().setValue("");
			getTextFieldExtVariable10().setValue("");
			getTextFieldExtValor10().setValue("");

			// ...
			String variableTemp;
			java.util.Enumeration varsTemp = variables.elements();
			int m = 0;
			boolean obligatorio;

			Vector varsFinal = new Vector();
			while (varsTemp.hasMoreElements()) {
				variableTemp = efren.util.StringTools.replaceAll(varsTemp.nextElement().toString(), "'", "", false);
				varsFinal.addElement(variableTemp);
			}

			// for (int i = 0; i < varsFinal.size(); i++) {
			for (int i = varsFinal.size() - 1; i >= 0; i--) {
				variableTemp = efren.util.StringTools.replaceAll(varsFinal.elementAt(i).toString(), "'", "", false);
				obligatorio = false;
				if (variableTemp.startsWith("*")) {
					obligatorio = true;
				}
				if (m == 0) {
					getTextFieldExtVariable01().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable01().setForeground(Color.red);
				}
				if (m == 1) {
					getTextFieldExtVariable02().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable02().setForeground(Color.red);
				}
				if (m == 2) {
					getTextFieldExtVariable03().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable03().setForeground(Color.red);
				}
				if (m == 3) {
					getTextFieldExtVariable04().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable04().setForeground(Color.red);
				}
				if (m == 4) {
					getTextFieldExtVariable05().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable05().setForeground(Color.red);
				}
				if (m == 5) {
					getTextFieldExtVariable06().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable06().setForeground(Color.red);
				}
				if (m == 6) {
					getTextFieldExtVariable07().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable07().setForeground(Color.red);
				}
				if (m == 7) {
					getTextFieldExtVariable08().setValue(variableTemp);
					if (obligatorio)
						getTextFieldExtVariable08().setForeground(Color.red);
				}
				m++;
			}

		} catch (Throwable t) {
			t.getMessage();
		}
	}

	private boolean validar() {
		try {

			if (getFileChooserPanel1().isDataMissing("¡ Seleccione un archivo destino para la exportación !"))
				return false;

			boolean porSentenciaDesdeLaBase = new Long(getFindByObjectPanelSqlSeleccion().getValue().trim()).longValue() >= 0;
			boolean porSentenciaEscrita = getTextAreaExtSQL().getValue().trim().length() > 0;

			if (!porSentenciaDesdeLaBase && !porSentenciaEscrita) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "Debe seleccionar o sentencia desde la base o " + "sentencia escrita");
				return false;
			}
			if (porSentenciaDesdeLaBase && porSentenciaEscrita) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "Solo seleccione o sentencia desde la base o " + "sentencia escrita, no ambas");
				return false;
			}

			if (porSentenciaDesdeLaBase) {
				s = "SELECT SENTENCIASQL FROM FILEDEFINITION WHERE OID=" + getFindByObjectPanelSqlSeleccion().getValue();
				rs = st.executeQuery(s);
				this.SQLClause = null;
				while (rs.next()) {
					this.SQLClause = rs.getString(1).trim();
				}
				rs.close();
			} else {
				if (porSentenciaEscrita)
					this.SQLClause = getTextAreaExtSQL().getValue().trim();
			}

			if (this.SQLClause == null || this.SQLClause.trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ La sentencia SQL no es válida !");
				return false;
			}
			if (this.SQLClause.toUpperCase().indexOf("INSERT ") >= 0 || this.SQLClause.toUpperCase().indexOf("UPDATE ") >= 0
					|| this.SQLClause.toUpperCase().indexOf("DELETE ") >= 0 || this.SQLClause.toUpperCase().indexOf("GRANT ") >= 0
					|| this.SQLClause.toUpperCase().indexOf("DROP ") >= 0 || this.SQLClause.toUpperCase().indexOf("REVOKE ") >= 0
					|| this.SQLClause.toUpperCase().indexOf("CREATE ") >= 0 || this.SQLClause.toUpperCase().indexOf("ALTER ") >= 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ La sentencia SQL no es válida debido a que contiene operaciones "
						+ "no permitidas tales como: INSERT,UPDATE,DELETE,GRANT,DROP,REVOKE,CREATE,ALTER!");
				return false;
			}

			return true;
		} catch (Throwable t) {
			t.getMessage();
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ ERROR: " + t.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param exception
	 */
	public void handleException(boolean showErrorWindow, Throwable exception) {
		ExceptionManager.singleton().manage(this, showErrorWindow, this, exception);
	}

}
