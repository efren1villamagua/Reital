package efren.util.gui;

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
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import efren.seguridades.gui.SystemView;
import efren.util.ExceptionManager;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.bars.Bar02Panel;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableColumn;
import efren.util.gui.table.DataTablePanel;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListener;

public class FindObjectsPanel extends JPanel implements MouseListener, java.beans.PropertyChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -6272859788894562715L;

	/**
	 *
	 */
	private String campo1Label = "Campo1"; // @jve:decl-index=0:

	private String campo2Label = "Campo2"; // @jve:decl-index=0:

	private boolean trimBlanksAndUcase = true;

	private int fetchSize = 500;

	private String oid = "-1"; // -1 significa que no hay ningún dato
								// seleccionado // @jve:decl-index=0:

	public static enum Tipo {
		CARACTERES, NUMERICO
	}

	private int fieldLongitudParametroCodigo = 10;

	private TextFieldExt ivjTextFieldExtCodigo = null;

	private efren.util.gui.LabelExt ivjLabelExt = null;

	private boolean nullable = false;

	private java.lang.String TABLE_NAME = "XXX_XXX";

	private String OID_FIELD = "OID"; // @jve:decl-index=0:

	private java.lang.String CODIGO_FIELD = "CODIGO";

	private java.lang.String DISPLAYING_FIELD = "DESCRIPCION";

	private java.sql.Statement statement;

	private boolean showPopupAtFeching = true;

	private boolean confirmOnFetchingAllData = true;

	private boolean editable = false;

	private Tipo tipoCODIGO = Tipo.CARACTERES; // @jve:decl-index=0:

	private boolean showMessagesDialog = true;

	private efren.util.gui.CheckBoxExt ivjJCheckBoxExtForLabel = null;

	protected transient FindObjectsPanelListener fieldFindObjectsPanelListenerEventMulticaster = null;

	private java.lang.String whereClause;

	private boolean buscandoPorOid = false;

	private boolean buscandoPorCodigo = false;

	private TextFieldExt ivjTextFieldExtDescripcion = null;

	private DialogExt ivjDialogExt = null; // @jve:decl-index=0:visual-constraint="10,45"

	private javax.swing.JPanel ivjJDialogContentPane = null;

	private DataTablePanel ivjDataTablePanel1 = null;

	private javax.swing.JButton ivjJButtonBuscar = null;

	private TextFieldExt ivjTextFieldExtCodigoBusqueda = null;

	private TextFieldExt ivjTextFieldExtDescripcionBusqueda = null;

	private JLabel jLabelCampo1 = null;

	private JLabel jLabelCampo2 = null;

	private boolean restrictWildcards = false;

	private boolean searchOnKeyReleased = false;

	private int searchOnKeyLength = 0;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public FindObjectsPanel() {
		super();
		initialize();
	}

	/**
	 * BusquedaPorPersonaPanel constructor comment.
	 * 
	 * @param layout
	 *            LayoutManager
	 */
	public FindObjectsPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * BusquedaPorPersonaPanel constructor comment.
	 * 
	 * @param layout
	 *            LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public FindObjectsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * BusquedaPorPersonaPanel constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public FindObjectsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 *
	 * @param arg
	 */
	private void _findByCodigo(String unCodigo) {
		try {

			if (!getFieldCodigoVisible()) {
				this.fireSelectedObject(new java.util.EventObject(this));
				return;
			}
			if (unCodigo == null || unCodigo.trim().length() == 0) {
				this.fireSelectedObject(new java.util.EventObject(this));
				return;
			}

			if (getLongitudParametroCodigo() > 0 && unCodigo.length() > getLongitudParametroCodigo()) {
				unCodigo = unCodigo.substring(0, getLongitudParametroCodigo()).trim();
			}

			this.buscandoPorCodigo = true;

			unCodigo = unCodigo.trim();

			if (getLongitudParametroCodigo() > 0 && unCodigo.length() > getLongitudParametroCodigo()) {
				unCodigo = unCodigo.substring(0, getLongitudParametroCodigo()).trim();
			}

			getTextFieldExtDescripcion().setValue("");
			getTextFieldExtDescripcionBusqueda().setValue("");

			boolean siHayDatos = false;

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
				String codigoQuery = " WHERE RTRIM(LTRIM(UCASE(" + this.getCODIGO_FIELD() + ")))='" + unCodigo.trim().toUpperCase() + "'";
				if (getTipoCODIGO() == Tipo.NUMERICO)
					codigoQuery = " WHERE " + this.getCODIGO_FIELD() + "=" + unCodigo.trim() + " ";
				if (this.getWhereClause() != null && this.getWhereClause().trim().length() > 0)
					codigoQuery = codigoQuery + " " + this.getWhereClause();

				String s = "SELECT " + getOID_FIELD() + " FROM " + this.getTABLE_NAME() + " " + codigoQuery + " ORDER BY " + this.getCODIGO_FIELD();
				java.sql.ResultSet rs = this.getStatement().executeQuery(s);
				while (rs.next()) {
					oid = rs.getString(1);
					siHayDatos = true;
				}
				rs.close();
			}

			if (siHayDatos) {
				this.setShowPopupAtFeching(false);

				if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
					this._findByOid(oid);
				}

				this.setShowPopupAtFeching(true);

			} else {
				getTextFieldExtCodigo().setValue(unCodigo);
				if (this.showMessagesDialog) {
					// efren.dialogs.InfoView.showInformationDialog(this, "No
					// hay datos para el criterio seleccionado !");
					this._findByOid(this.oid);// ????causará ciclado entre estos
												// métodos?
				}
			}

			this.buscandoPorCodigo = false;

			getTextFieldExtCodigo().requestFocus();
			getTextFieldExtCodigo().seleccionar();

		} catch (Throwable t) {
			t.getMessage();
			this.buscandoPorCodigo = false;
		}

		// para que se lance como evento el hecho de seleccionar un objeto
		this.fireSelectedObject(new java.util.EventObject(this));

	}

	/**
	 *
	 * @param arg
	 * @param forceShowDialog
	 */
	private void _findByName(String arg, boolean forceShowDialog) {

		if (this.buscandoPorCodigo) {
			return;
		}

		String argTemp = this.parseArgs(arg);

		if (this.isRestrictWildcards() && (argTemp.startsWith("*") || argTemp.startsWith("%"))) {
			InfoView.showErrorDialog(SystemView.singleton(), "Use un argumento que no contenga ni * ni % al inicio.");
			return;
		}

		boolean hayArgumentoBusqueda = argTemp != null;

		if (getDISPLAYING_FIELD() == null || getTABLE_NAME() == null) {
			return;
		}

		if (forceShowDialog) {
			getTextFieldExtCodigoBusqueda().setValue(getTextFieldExtCodigo().getValue());
			getTextFieldExtDescripcionBusqueda().setValue(getTextFieldExtDescripcion().getValue());
		}

		getDataTablePanel1().deselect();

		if (hayArgumentoBusqueda) {

			try {
				boolean busquedaCompletaExitosa = false;
				getDataTablePanel1().removeAllRows();
				FindObjectsRow forw;
				try {

					if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
						// SIN SERVIDOR DE APLICACIONES (LOCAL)
						String sql = "SELECT " + getOID_FIELD() + "," + getCODIGO_FIELD() + "," + this.getDISPLAYING_FIELD() + " FROM " + this.getTABLE_NAME();
						if (hayArgumentoBusqueda)
							sql = sql + " WHERE RTRIM(LTRIM(UCASE(" + this.getDISPLAYING_FIELD() + "))) " + " LIKE '"
									+ argTemp.trim().replace('*', '%').toUpperCase() + "%' ";
						if (this.getWhereClause() != null && this.getWhereClause().trim().length() > 0)
							sql = sql + " " + this.getWhereClause();
						if (getFieldCodigoVisible())
							sql = sql + " ORDER BY " + getCODIGO_FIELD();
						else
							sql = sql + " ORDER BY " + getDISPLAYING_FIELD();
						java.sql.ResultSet rs = this.getStatement().executeQuery(sql);
						while (rs.next()) {
							forw = new FindObjectsRow();
							forw.setOid(rs.getString(1).toString());
							forw.setCampo01(rs.getObject(2).toString().trim());
							forw.setCampo02(rs.getObject(3).toString().trim());
							getDataTablePanel1().addRow(forw);
						}
						rs.close();
					}

					busquedaCompletaExitosa = true;
				} catch (Throwable t2) {
					t2.getMessage();
				}

				if (!busquedaCompletaExitosa) {
					String sql = "SELECT " + getOID_FIELD() + "," + this.getDISPLAYING_FIELD() + " FROM " + this.getTABLE_NAME();
					if (hayArgumentoBusqueda)
						sql = sql + " WHERE RTRIM(LTRIM(UCASE(" + this.getDISPLAYING_FIELD() + "))) " + " LIKE '"
								+ argTemp.trim().replace('*', '%').toUpperCase() + "' ";
					if (this.getWhereClause() != null && this.getWhereClause().trim().length() > 0)
						sql = sql + " " + this.getWhereClause();
					sql = sql + " ORDER BY " + getDISPLAYING_FIELD();

					java.sql.ResultSet rs = this.getStatement().executeQuery(sql);

					getDataTablePanel1().removeAllRows();

					while (rs.next()) {
						forw = new FindObjectsRow();
						forw.setOid(rs.getString(1));
						forw.setCampo01("---");
						forw.setCampo02(rs.getObject(2).toString().trim());
						getDataTablePanel1().addRow(forw);
					}
				}
			} catch (Throwable t) {
				t.getMessage();
			}

		}

		if (forceShowDialog) {
			this.showDialog2(false);
		}
	}

	/**
	 *
	 * @param arg
	 */
	private void _findByOid(String unOid) {
		try {

			if (getTABLE_NAME() == null || (getCODIGO_FIELD() == null && getDISPLAYING_FIELD() == null))
				return;

			if (unOid == null || unOid.trim().length() == 0 || unOid.trim().compareTo("-1") == 0) {
				return;
			}

			this.buscandoPorOid = true;

			unOid = unOid.trim();

			getTextFieldExtCodigo().setValue("");
			getTextFieldExtCodigoBusqueda().setValue("");
			getTextFieldExtDescripcion().setValue("");
			getTextFieldExtDescripcionBusqueda().setValue("");

			boolean siHayDatos = false;

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
				try {
					String sql = null;
					if (getTipoCODIGO() == Tipo.NUMERICO) {
						sql = "SELECT " + this.getCODIGO_FIELD() + " FROM " + this.getTABLE_NAME() + " WHERE " + getOID_FIELD() + " = " + unOid;
					} else {
						sql = "SELECT RTRIM(LTRIM(" + this.getCODIGO_FIELD() + ")) FROM " + this.getTABLE_NAME() + " WHERE " + getOID_FIELD() + " = " + unOid;
					}
					if (this.getWhereClause() != null && this.getWhereClause().trim().length() > 0)
						sql = sql + " " + this.getWhereClause();
					ResultSet rs = this.getStatement().executeQuery(sql);
					while (rs.next()) {
						getTextFieldExtCodigo().setValue(rs.getObject(1).toString());
						siHayDatos = true;
						break;
					}
					rs.close();
				} catch (Throwable t) {
					t.getMessage();
				}
				// se busca 'la descripcion'
				try {
					String sql = null;
					sql = "SELECT RTRIM(LTRIM(" + this.getDISPLAYING_FIELD() + ")) FROM " + this.getTABLE_NAME() + " WHERE " + getOID_FIELD() + " = " + unOid;
					if (this.getWhereClause() != null && this.getWhereClause().trim().length() > 0)
						sql = sql + " " + this.getWhereClause();
					ResultSet rs = this.getStatement().executeQuery(sql);
					while (rs.next()) {
						getTextFieldExtDescripcion().setValue(rs.getObject(1).toString());
						siHayDatos = true;
					}
					rs.close();
				} catch (Throwable t) {
					t.getMessage();
				}
			}

			/*
			 * if (siHayDatos) { this.setShowPopupAtFeching(false); if
			 * (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_1_SA_SEG)
			 * { //no se hace nada } else { if (SystemProperties.SYSTEM_TYPE ==
			 * Constantes.SYSTEM_TYPE_3_LO || SystemProperties.SYSTEM_TYPE ==
			 * Constantes.SYSTEM_TYPE_4_ADMIN) { this._findByOid(oid); } }
			 * this.setShowPopupAtFeching(true);
			 * 
			 * 
			 * } else { getTextFieldExtCodigo().setValue(unCodigo); if
			 * (this.showMessagesDialog) {
			 * //efren.dialogs.InfoView.showInformationDialog(this,
			 * "No hay datos para el criterio seleccionado !");
			 * this._findByOid(this.oid);//????causará ciclado entre estos
			 * métodos? } }
			 */
			this.buscandoPorOid = false;

			if (siHayDatos) {
				this.oid = unOid;
				if (this.isNullable()) {
					getJCheckBoxExtForLabel().setSelected(true);
				}
			} else {
				// efren.dialogs.InfoView.showInformationDialog(this, "No hay
				// datos para el criterio seleccionado !");
			}

			getTextFieldExtCodigo().requestFocus();
			getTextFieldExtCodigo().seleccionar();

		} catch (Throwable t) {
			t.getMessage();
			this.buscandoPorOid = false;
		}
		// para que se lance como evento el hecho de seleccionar un objeto
		this.fireSelectedObject(new java.util.EventObject(this));

	}

	/**
	 *
	 * @param unOid
	 */
	/*
	 * private void _findByOid_OLD(String unOid) {
	 * 
	 * if (getTABLE_NAME() == null || (getCODIGO_FIELD() == null &&
	 * getDISPLAYING_FIELD() == null)) return;
	 * 
	 * if (unOid == null || unOid.trim().length() == 0 ||
	 * unOid.trim().compareTo("-1") == 0) { return; }
	 * 
	 * boolean siHayDatos = false; String sql; java.sql.ResultSet rs; //se busca
	 * 'el código' try { if (getTipoCODIGO() == NUMERICO) { sql = "SELECT "
	 * +this.getCODIGO_FIELD()+" FROM "+this.getTABLE_NAME() + " WHERE "
	 * +getOID_FIELD()+" = "+unOid; } else { sql = "SELECT RTRIM(LTRIM("
	 * +this.getCODIGO_FIELD()+")) FROM "+this.getTABLE_NAME() + " WHERE "
	 * +getOID_FIELD()+" = "+unOid; } if (this.getWhereClause() != null &&
	 * this.getWhereClause().trim().length() > 0) sql = sql + " "
	 * +this.getWhereClause(); rs = this.getStatement().executeQuery(sql); while
	 * (rs.next()) {
	 * getTextFieldExtCodigo().setValue(rs.getObject(1).toString()); siHayDatos
	 * = true; break; } rs.close(); } catch (Throwable t) { t.getMessage(); }
	 * //se busca 'la descripcion' try { sql = "SELECT RTRIM(LTRIM("
	 * +this.getDISPLAYING_FIELD()+")) FROM "+this.getTABLE_NAME() + " WHERE "
	 * +getOID_FIELD()+" = "+unOid; if (this.getWhereClause() != null &&
	 * this.getWhereClause().trim().length() > 0) sql = sql + " "
	 * +this.getWhereClause(); rs = this.getStatement().executeQuery(sql); while
	 * (rs.next()) {
	 * getTextFieldExtDescripcion().setValue(rs.getObject(1).toString());
	 * siHayDatos = true; } rs.close(); } catch (Throwable t) { t.getMessage();
	 * }
	 * 
	 * // this.deselect();
	 * 
	 * if (siHayDatos) { this.oid = unOid; if (this.isNullable()) {
	 * getJCheckBoxExtForLabel().setSelected(true); } } else {
	 * //efren.dialogs.InfoView.showInformationDialog(this,
	 * "No hay datos para el criterio seleccionado !"); } }
	 */
	/**
	 *
	 * @param newListener
	 *            efren.abm.beans.FindObjectsPanelListener
	 */
	public void addFindObjectsPanelListener(efren.util.gui.FindObjectsPanelListener newListener) {
		fieldFindObjectsPanelListenerEventMulticaster = efren.util.gui.FindObjectsPanelListenerEventMulticaster
				.add(fieldFindObjectsPanelListenerEventMulticaster, newListener);
		return;
	}

	/**
	 *
	 *
	 */
	public void clearData() {
		deselect();
	}

	/**
	 * connEtoC2: (JLabelCedula.text -->
	 * FindByObjectPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;
	 * Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("codigoCriteriaLabel", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (JCheckBoxExtForLabel.selectedOption -->
	 * FindObjectsPanel.visualManageNulls()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageNulls();
			// user code begin {2}
			// para que se lance como evento el hecho de seleccionar un objeto
			this.fireSelectedObject(new java.util.EventObject(this));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5: (LabelExt.displayedMnemonic -->
	 * FindByObjectPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;
	 * Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("labelDisplayedMnemonic", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC6: (TextFieldExtCodigo.focusAccelerator -->
	 * FindByObjectPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;
	 * Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("codigoFocusAccelerator", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 *
	 *
	 */
	public void deselect() {
		this.oid = "-1";
		getTextFieldExtCodigo().setValue("");
		getTextFieldExtCodigoBusqueda().setValue("");
		getTextFieldExtDescripcion().setValue("");
		getTextFieldExtDescripcionBusqueda().setValue("");
	}

	/**
	 *
	 * @return
	 */
	public boolean esNulo() {
		return this.isNullValue();
	}

	/**
	 * Method to support listener events.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireSelectedObject(java.util.EventObject newEvent) {
		if (fieldFindObjectsPanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldFindObjectsPanelListenerEventMulticaster.selectedObject(newEvent);
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
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:56 PM)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCODIGO_FIELD() {
		return CODIGO_FIELD;
	}

	public String getCODIGO_value() {
		return getTextFieldExtCodigo().getValue();
	}

	/**
	 * Method generated to support the promotion of the codigoCriteriaLabel
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getCodigoCriteriaLabel() {
		return getLabelExt().getText();
	}

	/**
	 * Method generated to support the promotion of the codigoFocusAccelerator
	 * attribute.
	 * 
	 * @return char
	 */
	public char getCodigoFocusAccelerator() {
		return getTextFieldExtCodigo().getFocusAccelerator();
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:56 PM)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDISPLAYING_FIELD() {
		return DISPLAYING_FIELD;
	}

	/**
	 * Method generated to support the promotion of the fieldCodigoVisible
	 * attribute.
	 * 
	 * @return boolean
	 */
	public boolean getFieldCodigoVisible() {
		return getTextFieldExtCodigo().isVisible();
	}

	/**
	 * Return the JButtonBuscar property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonBuscar() {
		if (ivjJButtonBuscar == null) {
			ivjJButtonBuscar = new javax.swing.JButton();
			ivjJButtonBuscar.setName("JButtonBuscar");
			ivjJButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_find.gif")));
			ivjJButtonBuscar.setText("");
			ivjJButtonBuscar.setMargin(new Insets(0, 0, 0, 0));
			ivjJButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_findByName(getTextFieldExtDescripcion().getValue(), true);
				}
			});
		}
		return ivjJButtonBuscar;
	}

	/**
	 * Return the JCheckBoxExtForLabel property value.
	 * 
	 * @return efren.util.gui.JCheckBoxExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.CheckBoxExt getJCheckBoxExtForLabel() {
		if (ivjJCheckBoxExtForLabel == null) {
			try {
				ivjJCheckBoxExtForLabel = new efren.util.gui.CheckBoxExt();
				ivjJCheckBoxExtForLabel.setName("JCheckBoxExtForLabel");
				ivjJCheckBoxExtForLabel.setText("aCode");
				ivjJCheckBoxExtForLabel.setHorizontalAlignment(2);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxExtForLabel;
	}

	/**
	 * Return the JDialog1 property value.
	 * 
	 * @return javax.swing.JDialog
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DialogExt getDialogExt1() {
		if (ivjDialogExt == null) {
			try {
				ivjDialogExt = new DialogExt();
				ivjDialogExt.setName("JDialog1");
				ivjDialogExt.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				ivjDialogExt.setBounds(91, 223, 590, 400);
				ivjDialogExt.setTitle("Búsqueda");
				getDialogExt1().setContentPane(getJDialogContentPane());
				try {
					jLabelCampo1.setText(this.campo1Label);
				} catch (Exception e) {
					e.getMessage();
				}
				try {
					jLabelCampo2.setText(this.campo2Label);
				} catch (Exception e) {
					e.getMessage();
				}
				try {
					getDataTablePanel1().getTable().getColumnAt(0).setHeaderValue(this.campo1Label);
					getDataTablePanel1().getTable().getColumnAt(1).setHeaderValue(this.campo2Label);
				} catch (Exception e) {
					e.getMessage();
				}
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjDialogExt;
	}

	/**
	 * Return the JDialogContentPane property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJDialogContentPane() {
		if (ivjJDialogContentPane == null) {
			try {
				jLabelCampo2 = new JLabel();
				jLabelCampo1 = new JLabel();
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
				ivjJDialogContentPane = new javax.swing.JPanel();
				ivjJDialogContentPane.setName("JDialogContentPane");
				ivjJDialogContentPane.setLayout(new GridBagLayout());

				GridBagConstraints constraintsDataTablePanel1 = new GridBagConstraints();
				constraintsDataTablePanel1.gridx = 0;
				constraintsDataTablePanel1.gridy = 2;
				constraintsDataTablePanel1.gridwidth = 2;
				constraintsDataTablePanel1.fill = GridBagConstraints.BOTH;
				constraintsDataTablePanel1.weightx = 1.0;
				constraintsDataTablePanel1.weighty = 1.0;
				constraintsDataTablePanel1.insets = new Insets(4, 4, 4, 4);
				GridBagConstraints constraintsTextFieldExtCodigoBusqueda = new GridBagConstraints();
				constraintsTextFieldExtCodigoBusqueda.gridx = 0;
				constraintsTextFieldExtCodigoBusqueda.gridy = 1;
				constraintsTextFieldExtCodigoBusqueda.fill = GridBagConstraints.BOTH;
				constraintsTextFieldExtCodigoBusqueda.weightx = 0.5;
				constraintsTextFieldExtCodigoBusqueda.insets = new Insets(0, 5, 5, 5);
				GridBagConstraints constraintsTextFieldExtDescripcionBusqueda = new GridBagConstraints();
				constraintsTextFieldExtDescripcionBusqueda.gridx = 1;
				constraintsTextFieldExtDescripcionBusqueda.gridy = 1;
				constraintsTextFieldExtDescripcionBusqueda.fill = GridBagConstraints.BOTH;
				constraintsTextFieldExtDescripcionBusqueda.weightx = 1.5;
				constraintsTextFieldExtDescripcionBusqueda.insets = new Insets(0, 5, 5, 5);
				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.gridy = 0;
				gridBagConstraints2.insets = new Insets(5, 5, 0, 5);
				jLabelCampo1.setText("Campo 1");
				jLabelCampo1.setFont(new Font("Arial", Font.PLAIN, 10));
				gridBagConstraints3.gridx = 1;
				gridBagConstraints3.gridy = 0;
				gridBagConstraints3.insets = new Insets(5, 5, 0, 5);
				jLabelCampo2.setText("Campo 2");
				jLabelCampo2.setFont(new Font("Arial", Font.PLAIN, 10));
				ivjJDialogContentPane.add(getDataTablePanel1(), constraintsDataTablePanel1);
				ivjJDialogContentPane.add(getTextFieldExtCodigoBusqueda(), constraintsTextFieldExtCodigoBusqueda);
				ivjJDialogContentPane.add(getTextFieldExtDescripcionBusqueda(), constraintsTextFieldExtDescripcionBusqueda);
				ivjJDialogContentPane.add(jLabelCampo1, gridBagConstraints2);
				ivjJDialogContentPane.add(jLabelCampo2, gridBagConstraints3);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJDialogContentPane;
	}

	/**
	 * Method generated to support the promotion of the labelDisplayedMnemonic
	 * attribute.
	 * 
	 * @return int
	 */
	public int getLabelDisplayedMnemonic() {
		return getLabelExt().getDisplayedMnemonic();
	}

	/**
	 * Gets the longitudParametroCodigo property (int) value.
	 * 
	 * @return The longitudParametroCodigo property value.
	 * @see #setLongitudParametroCodigo
	 */
	public int getLongitudParametroCodigo() {
		return fieldLongitudParametroCodigo;
	}

	private String getOid() {

		return this.oid;
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:48:12 PM)
	 * 
	 * @return java.sql.Statement
	 */
	public java.sql.Statement getStatement() {
		return statement;
	}

	/**
	 * Return the DataTablePanel1 property value.
	 * 
	 * @return efren.abm.beans.DataTablePanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DataTablePanel getDataTablePanel1() {
		if (ivjDataTablePanel1 == null) {
			ivjDataTablePanel1 = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanel1.setName("DataTablePanel1");
			ivjDataTablePanel1.setOpcionesBarButton03Visible(false);
			ivjDataTablePanel1.setOpcionesBarButton02Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("Campo 1", 135, "campo01", false, null));
			columnsDefinition.add(new DataTableColumn("Campo 2", 400, "campo02", false, null));
			ivjDataTablePanel1.setColumnsDefinition(FindObjectsRow.class, columnsDefinition);
			ivjDataTablePanel1.setOpcionesBarButton00Visible(false);
			ivjDataTablePanel1.setOpcionesBarButton01Text("Seleccionar");
			ivjDataTablePanel1.setBuscarButtonVisible(false);
			ivjDataTablePanel1.setImprimirButtonVisible(true);
			// ivjDataTablePanel1.setBarraEstadosVisible(false);
			ivjDataTablePanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("selectedObjectFromDoubleClick"))) {
						seleccionar();
					}
				}
			});
			ivjDataTablePanel1.addDataTablePanelListener(new efren.util.gui.table.DataTablePanelListener() {
				public void opcionesBarButton01ActionPerformed(java.util.EventObject e) {
					seleccionar();
				}

				public void buscarPerformed(java.util.EventObject e) {
				}

				public void comboBoxORDERBYItemSelected(java.util.EventObject e) {
				}

				public void opcionesBarButton00ActionPerformed(java.util.EventObject e) {
				}

				public void opcionesBarButton02ActionPerformed(java.util.EventObject e) {
				}

				public void opcionesBarButton03ActionPerformed(java.util.EventObject e) {
				}

				public void opcionesBarButton10ActionPerformed(java.util.EventObject e) {
				}
			});
		}
		return ivjDataTablePanel1;
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
				ivjLabelExt.setText("aCode");
				ivjLabelExt.setMaximumSize(new Dimension(55, 15));
				ivjLabelExt.setForeground(new Color(0, 64, 128));
				ivjLabelExt.setPreferredSize(new Dimension(55, 15));
				ivjLabelExt.setMinimumSize(new Dimension(55, 15));
				ivjLabelExt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:34 PM)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTABLE_NAME() {
		String temp = TABLE_NAME;
		try {
			if (TABLE_NAME != null && TABLE_NAME.trim().length() > 0) {
				if (TABLE_NAME.trim().indexOf(".") > 0 && TABLE_NAME.trim().startsWith("SEGURIDADES")) {
					temp = TABLE_NAME.trim().substring(TABLE_NAME.trim().indexOf(".") + 1);
					temp = SystemProperties.SCHEMA_SEGURIDADES + "." + temp;
				}
			}
		} catch (Throwable t) {
			t.getMessage();
		}
		return temp;
	}

	/**
	 * Return the TextFieldExtCodigo property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtCodigo() {
		if (ivjTextFieldExtCodigo == null) {
			ivjTextFieldExtCodigo = new TextFieldExt();
			ivjTextFieldExtCodigo.setName("TextFieldExtCodigo");
			ivjTextFieldExtCodigo.setToolTipText("Escriba un criterio de búsqueda y presione ENTER");
			ivjTextFieldExtCodigo.setFont(new Font("Arial", 1, 12));
			ivjTextFieldExtCodigo.setAceptarKeyLikeTabKey(false);
			ivjTextFieldExtCodigo.setForeground(new Color(44, 82, 124));
			ivjTextFieldExtCodigo.addTextFieldExtListener(new TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					_findByCodigo(ivjTextFieldExtCodigo.getValue().trim());
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
					KeyEvent ke = (KeyEvent) e;
					switch (ke.getKeyCode()) {
					case KeyEvent.VK_ENTER:
						break;
					// case KeyEvent.VK_BACK_SPACE:
					// break;
					case KeyEvent.VK_TAB:
						break;
					case KeyEvent.VK_SHIFT:
						break;
					case KeyEvent.VK_CONTROL:
						break;
					case KeyEvent.VK_ALT:
						break;
					case KeyEvent.VK_CAPS_LOCK:
						break;
					case KeyEvent.VK_END:
						break;
					case KeyEvent.VK_HOME:
						break;
					case KeyEvent.VK_LEFT:
						break;
					case KeyEvent.VK_UP:
						break;
					case KeyEvent.VK_RIGHT:
						break;
					case KeyEvent.VK_DOWN:
						break;
					// case KeyEvent.VK_DELETE:
					// break;
					case KeyEvent.VK_NUM_LOCK:
						break;
					default:
						if (isSearchOnKeyReleased()) {
							if (getSearchOnKeyLength() > 0) {
								if (ivjTextFieldExtCodigo.getValue().trim().length() == getSearchOnKeyLength()) {
									_findByCodigo(ivjTextFieldExtCodigo.getValue().trim());
								} else {
									oid = "-1";
									getTextFieldExtCodigoBusqueda().setValue("");
									getTextFieldExtDescripcion().setValue("");
									getTextFieldExtDescripcionBusqueda().setValue("");
								}
							}
						}
						break;
					}
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(EventObject e) {
				}
			});
		}
		return ivjTextFieldExtCodigo;
	}

	/**
	 * Return the TextFieldExtCodigoBusqueda property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtCodigoBusqueda() {
		if (ivjTextFieldExtCodigoBusqueda == null) {
			ivjTextFieldExtCodigoBusqueda = new TextFieldExt();
			ivjTextFieldExtCodigoBusqueda.setName("TextFieldExtCodigoBusqueda");
			ivjTextFieldExtCodigoBusqueda.setToolTipText("Escriba un criterio de búsqueda y presione ENTER");
			ivjTextFieldExtCodigoBusqueda.setFont(new Font("Arial", 1, 12));
			ivjTextFieldExtCodigoBusqueda.setAceptarKeyLikeTabKey(false);
			ivjTextFieldExtCodigoBusqueda.setForeground(new Color(44, 82, 124));
			ivjTextFieldExtCodigoBusqueda.addTextFieldExtListener(new TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					_findByCodigo(getTextFieldExtCodigoBusqueda().getValue());
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(EventObject e) {
				}
			});
		}
		return ivjTextFieldExtCodigoBusqueda;
	}

	/**
	 * Return the TextFieldExtDescripcion property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtDescripcion() {
		if (ivjTextFieldExtDescripcion == null) {
			ivjTextFieldExtDescripcion = new TextFieldExt();
			ivjTextFieldExtDescripcion.setName("TextFieldExtDescripcion");
			ivjTextFieldExtDescripcion.setToolTipText("Escriba un criterio de búsqueda y presione ENTER");
			ivjTextFieldExtDescripcion.setAceptarKeyLikeTabKey(false);
			ivjTextFieldExtDescripcion.addTextFieldExtListener(new TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					_findByName(getTextFieldExtDescripcion().getValue(), true);
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
				}
			});
		}
		return ivjTextFieldExtDescripcion;
	}

	/**
	 * Return the TextFieldExtDescripcionBusqueda property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtDescripcionBusqueda() {
		if (ivjTextFieldExtDescripcionBusqueda == null) {
			ivjTextFieldExtDescripcionBusqueda = new TextFieldExt();
			ivjTextFieldExtDescripcionBusqueda.setName("TextFieldExtDescripcionBusqueda");
			ivjTextFieldExtDescripcionBusqueda.setToolTipText("Escriba un criterio de búsqueda y presione ENTER");
			ivjTextFieldExtDescripcionBusqueda.setAceptarKeyLikeTabKey(false);
			ivjTextFieldExtDescripcionBusqueda.addTextFieldExtListener(new TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					_findByName(getTextFieldExtDescripcionBusqueda().getValue(), false);
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}

				public void field_keyReleased(java.util.EventObject e) {
				}
			});
		}
		return ivjTextFieldExtDescripcionBusqueda;
	}

	/**
	 * Insert the method's description here. Creation date: (09-Sep-2003
	 * 11:06:14 AM)
	 * 
	 * @return int
	 */
	public Tipo getTipoCODIGO() {
		return tipoCODIGO;
	}

	public String getValue() {

		return this.getOid();
	}

	public long getValueAsLong() {
		try {
			return new Long(this.getOid().trim()).longValue();
		} catch (Exception e) {
			e.getMessage();
		}
		return -1L;
	}

	public String getSelectedCampo01() {
		return getTextFieldExtCodigo().getValue().trim();
	}

	public String getSelectedCampo02() {
		return getTextFieldExtDescripcion().getValue().trim();
	}

	public String getSelectedCombinedValue() {

		String temp = "";

		if (getFieldCodigoVisible())
			temp = temp + getTextFieldExtCodigo().getValue() + " - ";

		temp = temp + getTextFieldExtDescripcion().getValue();

		return temp;
	}

	/**
	 * Insert the method's description here. Creation date: (2003-oct-27
	 * 16:02:51)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getWhereClause() {
		return whereClause;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	private void initColNames() {
		getDataTablePanel1().getTable().getColumnModel().getColumn(0).setHeaderValue(getCODIGO_FIELD());
		getDataTablePanel1().getTable().getColumnModel().getColumn(1).setHeaderValue(getDISPLAYING_FIELD());
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		getJButtonBuscar().addMouseListener(this);
		getTextFieldExtCodigo().addPropertyChangeListener(this);
		getJCheckBoxExtForLabel().addPropertyChangeListener(this);
		getLabelExt().addPropertyChangeListener(this);
		getDataTablePanel1().addPropertyChangeListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("FindByObjectPanel");
			setPreferredSize(new Dimension(320, 24));
			setLayout(new GridBagLayout());
			setSize(444, 25);
			setMinimumSize(new Dimension(320, 24));
			setMaximumSize(new Dimension(2147483647, 25));

			GridBagConstraints constraintsTextFieldExtDescripcion = new GridBagConstraints();
			constraintsTextFieldExtDescripcion.gridx = 2;
			constraintsTextFieldExtDescripcion.gridy = 0;
			constraintsTextFieldExtDescripcion.fill = GridBagConstraints.BOTH;
			constraintsTextFieldExtDescripcion.weightx = 1.5;
			constraintsTextFieldExtDescripcion.insets = new Insets(1, 0, 1, 0);
			add(getTextFieldExtDescripcion(), constraintsTextFieldExtDescripcion);

			GridBagConstraints constraintsTextFieldExtCodigo = new GridBagConstraints();
			constraintsTextFieldExtCodigo.gridx = 1;
			constraintsTextFieldExtCodigo.gridy = 0;
			constraintsTextFieldExtCodigo.fill = GridBagConstraints.BOTH;
			constraintsTextFieldExtCodigo.weightx = 0.5;
			constraintsTextFieldExtCodigo.insets = new Insets(1, 0, 1, 0);
			add(getTextFieldExtCodigo(), constraintsTextFieldExtCodigo);

			GridBagConstraints constraintsJCheckBoxExtForLabel = new GridBagConstraints();
			constraintsJCheckBoxExtForLabel.gridx = 0;
			constraintsJCheckBoxExtForLabel.gridy = 0;
			constraintsJCheckBoxExtForLabel.insets = new Insets(1, 2, 1, 0);
			add(getJCheckBoxExtForLabel(), constraintsJCheckBoxExtForLabel);

			GridBagConstraints constraintsLabelExt = new GridBagConstraints();
			constraintsLabelExt.gridx = 0;
			constraintsLabelExt.gridy = 0;
			constraintsLabelExt.insets = new Insets(1, 2, 1, 0);
			add(getLabelExt(), constraintsLabelExt);

			GridBagConstraints constraintsJButtonBuscar = new GridBagConstraints();
			constraintsJButtonBuscar.gridx = 3;
			constraintsJButtonBuscar.gridy = 0;
			constraintsJButtonBuscar.ipady = -5;
			add(getJButtonBuscar(), constraintsJButtonBuscar);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		try {
			this.setStatement(efren.util.Conn.conectar().createStatement());
		} catch (Throwable t3) {
			t3.getMessage();
		}
		this.initColNames();

		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

		getJButtonBuscar().setVisible(false);

		this.setOpaque(false);

		getOptionsBar().setButton01Mnemonic('S');
		// user code end
	}

	/**
	 * Insert the method's description here. Creation date: (06-Sep-2003
	 * 01:19:05 AM)
	 * 
	 * @return boolean
	 */
	public boolean isConfirmOnFetchingAllData() {
		return confirmOnFetchingAllData;
	}

	public boolean isDataMissing() {

		if (this.oid == null || this.oid.trim().length() == 0 || this.oid.trim().compareTo("-1") == 0) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Ingrese un texto !");
			getTextFieldExtCodigo().setToPainterERROR();
			this.getJButtonBuscar().requestFocus();
			return true;
		}
		getTextFieldExtCodigo().restorePainter();
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		if (this.oid == null || this.oid.trim().length() == 0 || this.oid.trim().compareTo("-1") == 0) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			getTextFieldExtCodigo().setToPainterERROR();
			this.getJButtonBuscar().requestFocus();
			return true;
		}
		getTextFieldExtCodigo().restorePainter();
		return false;
	}

	/**
	 * Method generated to support the promotion of the editable attribute.
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return this.editable;
	}

	/**
	 * Gets the nullable property (boolean) value.
	 * 
	 * @return The nullable property value.
	 * @see #setNullable
	 */
	public boolean isNullable() {
		return nullable;
	}

	private boolean isNullValue() {
		/*
		 * if (!isNullable()) return getOid() < 0;
		 * 
		 * return this.nullValue && getOid() < 0;
		 */
		return this.oid == null || this.oid.trim().length() == 0 || this.oid.trim().compareTo("-1") == 0;
	}

	/**
	 * Insert the method's description here. Creation date: (05-Sep-2003
	 * 23:09:58 PM)
	 * 
	 * @return boolean
	 */
	public boolean isShowPopupAtFeching() {
		return showPopupAtFeching;
	}

	/**
	 * Method to handle events for the ObjectComboBoxListener interface.
	 * 
	 * @param newEvent
	 *            KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(KeyEvent newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseClicked(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseEntered(MouseEvent e) {
		// user code begin {1}
		if (getJButtonBuscar().isEnabled())
			getJButtonBuscar().setCursor(new Cursor(Cursor.HAND_CURSOR));
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseExited(MouseEvent e) {
		// user code begin {1}
		getJButtonBuscar().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mousePressed(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseReleased(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	public void objectComboBoxKey_keyPressed(java.util.EventObject newEvent) {
	}

	public void objectComboBoxKey_keyTyped(java.util.EventObject newEvent) {
	}

	public void objectComboBoxMouse_mousePressed(java.util.EventObject newEvent) {
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
	 *
	 * @param arg
	 * @return
	 */
	private String parseArgs(String arg) {

		if (arg == null || arg.trim().length() == 0)
			return null;
		/*
		 * if (!this.fulling && isConfirmOnFetchingAllData() &&
		 * (arg.trim().compareTo("*") == 0 || arg.trim().compareTo("%") == 0)) {
		 * String mensaje =
		 * "La cantidad de datos recuperados con el argumento * ó % puede ser muy grande y demorar algunos minutos. "
		 * + "¿ Desea proceder con la operación ?"; if
		 * (efren.dialogs.InfoView.showConfirmDialog(this, mensaje,
		 * "Confirmación", efren.dialogs.InfoView.YES_NO_OPTION) != 0) return
		 * null; }
		 */
		String temp = arg;

		return (temp.trim().replace('*', '%') + "%").trim().toUpperCase();
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
		if (evt.getSource() == getTextFieldExtCodigo() && (evt.getPropertyName().equals("focusAccelerator")))
			connEtoC6(evt);
		if (evt.getSource() == getJCheckBoxExtForLabel() && (evt.getPropertyName().equals("selectedOption")))
			connEtoC4(evt);
		if (evt.getSource() == getLabelExt() && (evt.getPropertyName().equals("text")))
			connEtoC2(evt);
		if (evt.getSource() == getLabelExt() && (evt.getPropertyName().equals("displayedMnemonic")))
			connEtoC5(evt);
		// user code begin {2}
		// user code end
	}

	/**
	 *
	 * @param newListener
	 *            efren.abm.beans.FindObjectsPanelListener
	 */
	public void removeFindObjectsPanelListener(efren.util.gui.FindObjectsPanelListener newListener) {
		fieldFindObjectsPanelListenerEventMulticaster = efren.util.gui.FindObjectsPanelListenerEventMulticaster
				.remove(fieldFindObjectsPanelListenerEventMulticaster, newListener);
		return;
	}

	/**
	 *
	 *
	 */
	private void seleccionar() {
		Object o = getDataTablePanel1().getSelectedObject();
		if (o == null) {
			this.fireSelectedObject(new java.util.EventObject(this));
			return;
		}
		FindObjectsRow row = (FindObjectsRow) o;

		// this.setValue(row.getOid());
		this.oid = row.getOid();
		this.getTextFieldExtCodigo().setValue(row.getCampo01());
		this.getTextFieldExtDescripcion().setValue(row.getCampo02());

		// para que se lance como evento el hecho de seleccionar un objeto
		this.fireSelectedObject(new java.util.EventObject(this));

		// setOidWhenCombing();

		getDialogExt1().setVisible(false);
	}

	/**
	 *
	 */
	public void setBackground(Color c) {
		// no hacemos nada
		// super.setBackground(c);

		/*
		 * getJPanelCodigo().setBackground(c); getLabelExt().setBackground(c);
		 * getJCheckBoxExtForLabel().setBackground(c);
		 */
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:56 PM)
	 * 
	 * @param newCODIGO_FIELD
	 *            java.lang.String
	 */
	public void setCODIGO_FIELD(java.lang.String newCODIGO_FIELD) {
		CODIGO_FIELD = newCODIGO_FIELD;
		this.initColNames();
	}

	/**
	 * Method generated to support the promotion of the codigoCriteriaLabel
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setCodigoCriteriaLabel(String arg1) {
		getLabelExt().setText(arg1);
		getJCheckBoxExtForLabel().setText(arg1);
		if (arg1 != null && arg1.trim().length() == 0) {
			getLabelExt().setVisible(false);
			getJCheckBoxExtForLabel().setVisible(false);
			this.remove(getLabelExt());
			this.remove(getJCheckBoxExtForLabel());
		}

		this.repaint();
	}

	/**
	 * Method generated to support the promotion of the codigoFocusAccelerator
	 * attribute.
	 * 
	 * @param arg1
	 *            char
	 */
	public void setCodigoFocusAccelerator(char arg1) {
		getTextFieldExtCodigo().setFocusAccelerator(arg1);
	}

	/**
	 * Insert the method's description here. Creation date: (06-Sep-2003
	 * 01:19:05 AM)
	 * 
	 * @param newConfirmOnFetchingAllData
	 *            boolean
	 */
	public void setConfirmOnFetchingAllData(boolean newConfirmOnFetchingAllData) {
		confirmOnFetchingAllData = newConfirmOnFetchingAllData;
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:56 PM)
	 * 
	 * @param newCODIGO_FIELD
	 *            java.lang.String
	 */
	public void setDISPLAYING_FIELD(java.lang.String newDISPLAYING_FIELD) {
		DISPLAYING_FIELD = newDISPLAYING_FIELD;
		this.initColNames();
	}

	/**
	 * Method generated to support the promotion of the editable attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setEditable(boolean arg1) {
		if (!isNullable())
			getLabelExt().setEnabled(arg1);
		getTextFieldExtCodigo().setEditable(arg1);
		getTextFieldExtDescripcion().setEditable(arg1);
		getJCheckBoxExtForLabel().setEnabled(arg1);
		getJButtonBuscar().setEnabled(arg1);

		this.editable = arg1;

		repaint();
	}

	/**
	 *
	 */
	public void setEnabled(boolean aBool) {

		super.setEnabled(aBool);

		if (isNullable()) {
			getJCheckBoxExtForLabel().setVisible(aBool);
			// if (!aBool)
			// getJCheckBoxExtForLabel().setSelectedOption(getJCheckBoxExtForLabel().getFalseOption());
			getLabelExt().setVisible(!aBool);

			getTextFieldExtCodigo().setEnabled(aBool);
			getTextFieldExtDescripcion().setEnabled(aBool);
			getJButtonBuscar().setEnabled(aBool);

		} else {
			getTextFieldExtCodigo().setEnabled(aBool);
			getTextFieldExtDescripcion().setEnabled(aBool);
			getJButtonBuscar().setEnabled(aBool);
		}
	}

	/**
	 * Method generated to support the promotion of the fieldCodigoVisible
	 * attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setFieldCodigoVisible(boolean arg1) {
		getTextFieldExtCodigo().setVisible(arg1);
		// ...
		getTextFieldExtCodigoBusqueda().setVisible(arg1);
		if (arg1) {
			getDataTablePanel1().getTable().getColumnModel().getColumn(0).setPreferredWidth(150);
			getDataTablePanel1().getTable().getColumnModel().getColumn(0).setResizable(true);
			getDataTablePanel1().getTable().getColumnModel().getColumn(1).setPreferredWidth(200);
		} else {
			getDataTablePanel1().getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
			getDataTablePanel1().getTable().getColumnModel().getColumn(0).setResizable(false);
			getDataTablePanel1().getTable().getColumnModel().getColumn(1).setPreferredWidth(350);
		}
	}

	/**
	 *
	 */
	public void setForeground(Color c) {
		super.setForeground(c);
		getLabelExt().setForeground(c);
		getJCheckBoxExtForLabel().setForeground(c);
	}

	/**
	 * Method generated to support the promotion of the labelDisplayedMnemonic
	 * attribute.
	 * 
	 * @param arg1
	 *            int
	 */
	public void setLabelDisplayedMnemonic(int arg1) {
		getLabelExt().setDisplayedMnemonic(arg1);
		// ...
		getJCheckBoxExtForLabel().setMnemonic(arg1);
	}

	/**
	 * Sets the longitudParametroCodigo property (int) value.
	 * 
	 * @param longitudParametroCodigo
	 *            The new value for the property.
	 * @see #getLongitudParametroCodigo
	 */
	public void setLongitudParametroCodigo(int longitudParametroCodigo) {
		int oldValue = fieldLongitudParametroCodigo;
		fieldLongitudParametroCodigo = longitudParametroCodigo;
		firePropertyChange("longitudParametroCodigo", new Integer(oldValue), new Integer(longitudParametroCodigo));
	}

	/**
	 *
	 * @param aNullable
	 */
	public void setNullable(boolean aNullable) {

		boolean oldValue = nullable;
		nullable = aNullable;
		firePropertyChange("nullable", new Boolean(oldValue), new Boolean(nullable));
		// ...
		getLabelExt().setVisible(!aNullable);
		getJCheckBoxExtForLabel().setVisible(aNullable);

		getTextFieldExtCodigo().setEnabled(!aNullable);
		getTextFieldExtDescripcion().setEnabled(!aNullable);
		getJButtonBuscar().setEnabled(!aNullable);
	}

	/**
	 *
	 * @param unOid
	 * @return
	 */
	private boolean setOid(String unOid) {

		if (unOid == null || unOid.trim().length() == 0 || unOid.trim().compareTo("-1") == 0 || unOid.trim().toUpperCase().compareTo("NULL") == 0) {
			this.oid = unOid;
			return true;
		}

		boolean b = true;

		try {

			this._findByOid(unOid);

			// se setea el oid
			this.oid = unOid;

			return b;

		} catch (Throwable t) {
			getTextFieldExtCodigo().setValue("");
			return false;
		}
	}

	/**
	 * Insert the method's description here. Creation date: (05-Sep-2003
	 * 23:09:58 PM)
	 * 
	 * @param newShowPopupAtFeching
	 *            boolean
	 */
	public void setShowPopupAtFeching(boolean newShowPopupAtFeching) {
		showPopupAtFeching = newShowPopupAtFeching;
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:48:12 PM)
	 * 
	 * @param newStatement
	 *            java.sql.Statement
	 */
	public void setStatement(java.sql.Statement newStatement) {
		statement = newStatement;
	}

	/**
	 * Insert the method's description here. Creation date: (02-Sep-2003
	 * 23:42:34 PM)
	 * 
	 * @param newTABLE_NAME
	 *            java.lang.String
	 */
	public void setTABLE_NAME(java.lang.String newTABLE_NAME) {
		TABLE_NAME = newTABLE_NAME;
	}

	/**
	 * Insert the method's description here. Creation date: (09-Sep-2003
	 * 11:06:14 AM)
	 * 
	 * @param newTipoCODIGO
	 *            int
	 */
	public void setTipoCODIGO(Tipo newTipoCODIGO) {
		tipoCODIGO = newTipoCODIGO;
	}

	/**
	 *
	 *
	 */
	public void setToNullValue() {

		deselect();

		getTextFieldExtCodigo().setValue("");
		getTextFieldExtCodigo().setEnabled(false);
		getTextFieldExtDescripcion().setValue("");
		getTextFieldExtDescripcion().setEnabled(false);
		getJButtonBuscar().setEnabled(false);
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	public boolean setValue(String value) {

		return this.setOid(value);
	}

	public boolean setValue(long value) {

		return this.setOid(String.valueOf(value));
	}

	/**
	 * Insert the method's description here. Creation date: (2003-oct-27
	 * 16:02:51)
	 * 
	 * @param newWhereClause
	 *            java.lang.String
	 */
	public void setWhereClause(java.lang.String newWhereClause) {
		whereClause = newWhereClause;
	}

	/**
	 *
	 *
	 */
	private void showDialog2(boolean focusOnCampo1) {
		if (focusOnCampo1) {
			getTextFieldExtCodigoBusqueda().requestFocus();
		} else {
			getTextFieldExtDescripcionBusqueda().requestFocus();
		}
		efren.util.WindowManager.centerWindowOnThis2(this, getDialogExt1());
		getDialogExt1().setVisible(true);
	}

	/**
	 *
	 * @return
	 */
	public String SQLText() {

		if (this.oid == null || this.oid.trim().length() == 0 || this.oid.trim().compareTo("-1") == 0)
			return " NULL ";
		else
			return String.valueOf(getOid());
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
	 *
	 *
	 */
	private void visualManageNulls() {

		if (getJCheckBoxExtForLabel().isSelected()) {
			getTextFieldExtCodigo().setEnabled(true);
			getTextFieldExtDescripcion().setEnabled(true);
			getJButtonBuscar().setEnabled(true);
		} else {
			deselect();
			getTextFieldExtCodigo().setValue("");
			getTextFieldExtCodigo().setEnabled(false);
			getTextFieldExtDescripcion().setValue("");
			getTextFieldExtDescripcion().setEnabled(false);
			getJButtonBuscar().setEnabled(false);
			this.setOid("-1");
		}
	}

	/**
	 *
	 * @return
	 */
	public String getOID_FIELD() {
		return OID_FIELD;
	}

	/**
	 *
	 * @param identifierName
	 */
	public void setOID_FIELD(String identifierName) {
		this.OID_FIELD = identifierName;
	}

	public int getFetchSize() {
		return fetchSize;
	}

	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
		getDataTablePanel1().setPartialData(fetchSize > 0);
	}

	public boolean isTrimBlanksAndUcase() {
		return trimBlanksAndUcase;
	}

	public void setTrimBlanksAndUcase(boolean trimBlanksAndUcase) {
		this.trimBlanksAndUcase = trimBlanksAndUcase;
	}

	/**
	 *
	 * @param keyMask
	 */
	public void setKeyMask(TextFieldExt.KeyMask keyMask) {
		getTextFieldExtDescripcion().setKeyMask(keyMask);
		getTextFieldExtDescripcionBusqueda().setKeyMask(keyMask);
	}

	/**
	 *
	 */
	public void setAllowedKey(TextFieldExt.AllowedKey allowedKey) {
		getTextFieldExtDescripcion().setAllowedKey(allowedKey);
		getTextFieldExtDescripcionBusqueda().setAllowedKey(allowedKey);
	}

	/**
	 *
	 */
	public void setMaxLength(int maxLength) {
		getTextFieldExtDescripcion().setMaxLength(maxLength);
		getTextFieldExtDescripcionBusqueda().setMaxLength(maxLength);
	}

	public String getCampo1Label() {
		return campo1Label;
	}

	public void setCampo1Label(String campo1Label) {
		this.campo1Label = campo1Label;
		try {
			jLabelCampo1.setText(campo1Label);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			getDataTablePanel1().getTable().getColumn("Campo01").setHeaderValue(campo1Label);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String getCampo2Label() {
		return campo2Label;
	}

	public void setCampo2Label(String campo2Label) {
		this.campo2Label = campo2Label;
		try {
			jLabelCampo2.setText(campo2Label);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			getDataTablePanel1().getTable().getColumn("Campo02").setHeaderValue(campo2Label);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 *
	 */
	public void requestFocus() {
		if (getTextFieldExtCodigo().isVisible()) {
			getTextFieldExtCodigo().requestFocus();
		} else {
			getTextFieldExtDescripcion().requestFocus();
		}
	}

	/**
	 *
	 */
	public Bar02Panel getOptionsBar() {
		return getDataTablePanel1().getOptionsBar();
	}

	public boolean isRestrictWildcards() {
		return restrictWildcards;
	}

	public void setRestrictWildcards(boolean restrictWildcards) {
		this.restrictWildcards = restrictWildcards;
	}

	/**
	 *
	 */
	public void setDisplayingTextValue(String aValue) {
		getTextFieldExtDescripcion().setValue(aValue);
	}

	/**
	 * @return the searchOnKeyReleased
	 */
	public boolean isSearchOnKeyReleased() {
		return searchOnKeyReleased;
	}

	/**
	 * @param searchOnKeyReleased
	 *            the searchOnKeyReleased to set
	 */
	public void setSearchOnKeyReleased(boolean searchOnKeyReleased) {
		this.searchOnKeyReleased = searchOnKeyReleased;
	}

	/**
	 * @return the searchOnKeyLength
	 */
	public int getSearchOnKeyLength() {
		return searchOnKeyLength;
	}

	/**
	 * @param searchOnKeyLength
	 *            the searchOnKeyLength to set
	 */
	public void setSearchOnKeyLength(int searchOnKeyLength) {
		this.searchOnKeyLength = searchOnKeyLength;
	}
}
