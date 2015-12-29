package efren.seguridades.abm.gui;

import java.util.Vector;

import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecOpcion;
import efren.util.gui.table.DataTableColumn;

public class Perfil2ABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, efren.util.gui.table.DataTablePanelListener, java.awt.event.ActionListener, java.beans.PropertyChangeListener, javax.swing.event.InternalFrameListener {
	private javax.swing.JPanel ivjJFrameContentPane = null;
    protected transient java.beans.PropertyChangeSupport propertyChange;
	private efren.util.gui.LabelExt ivjJLabelNombre = null;
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;
	private efren.util.ABMViewObserver ivjobserver = null;
    private efren.util.abm.estados.ABMEstado abmEstado;
    //...
    public PerfilABMView mainView;
    public efren.util.entidades.SecPerfil bo;
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtNombre = null;
	private efren.util.gui.LabelExt ivjLabelExt1 = null;
	private efren.util.gui.combo.ObjectComboBox ivjObjectComboBoxSistema = null;
	private efren.util.gui.LabelExt ivjLabelExt11 = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private efren.util.gui.table.DataTablePanel ivjDataTablePanel = null;
	private javax.swing.JPopupMenu ivjJPopupMenuHabilitar = null;
    private java.util.Vector opcionesEnLaTabla;
	private javax.swing.JMenuItem ivjJMenuItem2111 = null;
	private javax.swing.JMenuItem ivjJMenuItem2112 = null;
	private javax.swing.JMenuItem ivjJMenuItem21121 = null;
	private javax.swing.JMenuItem ivjJMenuItem211211 = null;
	private javax.swing.JMenuItem ivjJMenuItemIngresoContinuo = null;
	private javax.swing.JMenuItem ivjJMenuItemIngresoMasivo = null;
	private javax.swing.JMenuItem ivjJMenuItemTodo = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Perfil2ABMDetailsView() {
	super();
	initialize();
}
/**
 * GradoABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public Perfil2ABMDetailsView(String title) {
	super(title);
}
public void _cerrar() throws java.rmi.RemoteException {

	/**
	 * se elimina ésta ventana del observer controlador de ventanas para que el objeto de negocio pueda
	 * ser utilizado en otra ventana de detalle
	 */
	getobserver().removeFrame(this, String.valueOf(bo.getOid()));
}
private void aceptar() throws Throwable {
    try {
        if (!validar())
            return;

        if (permanentUpdateBO()) {
            getobserver().removeFrame(this, String.valueOf(bo.getOid()));
            mainView.setSelected(true); //para que el foco se transmita a la ventana principal del ABM
            mainView.dataFetch();
        }
    } catch (Throwable t) {
    	ExceptionManager.singleton().manage(this, false, this, t);
    }
}
/**
 * Method to handle events for the BarraAceptarCancelarPanelListener interface.
 * @param newEvent java.util.EventObject
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
 * Method to handle events for the ActionListener interface.
 * @param e java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformed(java.awt.event.ActionEvent e) {
	// user code begin {1}
	// user code end
	if (e.getSource() == getJMenuItemTodo())
		connEtoC5(e);
	if (e.getSource() == getJMenuItemIngresoMasivo())
		connEtoC6(e);
	if (e.getSource() == getJMenuItemIngresoContinuo())
		connEtoC9(e);
	if (e.getSource() == getJMenuItem21121())
		connEtoC10(e);
	if (e.getSource() == getJMenuItem2111())
		connEtoC11(e);
	if (e.getSource() == getJMenuItem211211())
		connEtoC12(e);
	if (e.getSource() == getJMenuItem2112())
		connEtoC13(e);
	// user code begin {2}
	// user code end
}
private void actualizarPerfil(long unPerfilOid) {

	try {
		java.sql.Connection con = efren.util.Conn.conectar();
		java.sql.Statement st = con.createStatement();

		if (getObjectComboBoxSistema().getSelectedItem() == null) {
			st.close();
			return;
		}

		this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

		String s;

		try {
			//primero borramos todas las opciones del perfil en el sistema
			s = "DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION "
				+ " WHERE "
				+ " PERFILOID = " + unPerfilOid
				+ " AND OPCIONOID IN (SELECT OID FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION "
				+ " WHERE SISTEMAOID = " + getObjectComboBoxSistema().getSelectedValueItem() + " ) ";
			st.executeUpdate(s);
		} catch (Throwable t2) {
			t2.getMessage();
		}

		//luego insertamos todas las opciones del perfil en el sistema

		s = "SELECT MAX(OID) FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION";
		java.sql.ResultSet rs = st.executeQuery(s);
		rs.next();
		long newOid = rs.getLong(1) + 1L;

		s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION "
			+ " (OID, PERFILOID, OPCIONOID, TODO, INGRESOMASIVO, INGRESOCONTINUO, INGRESO, MODIFICACION, "
			+ " ELIMINACION, CONSULTA, TIMESTAMP) VALUES ( "
			+ " ?,?,?,?,?,?,?,?,?,?, CURRENT TIMESTAMP ) ";
		java.sql.PreparedStatement ps = con.prepareStatement(s);

		java.util.Vector rows = getDataTablePanel().getTableModel().elements();
		boolean todo, ingresoMasivo, ingresoContinuo, ingreso, modificacion, eliminacion, consulta;
		for (int i = 0; i < rows.size(); i++) {
			todo = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 2).toString().trim()).booleanValue();
			ingresoMasivo = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 3).toString().trim()).booleanValue();
			ingresoContinuo = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 4).toString().trim()).booleanValue();
			ingreso = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 5).toString().trim()).booleanValue();
			modificacion = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 6).toString().trim()).booleanValue();
			eliminacion = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 7).toString().trim()).booleanValue();
			consulta = new Boolean(getDataTablePanel().getTableModel().getValueAt(i, 8).toString().trim()).booleanValue();

			if (todo || ingresoMasivo || ingresoContinuo || ingreso || modificacion || eliminacion || consulta) {

				try {
					ps.setLong(1, newOid);
					ps.setLong(2, unPerfilOid);
					ps.setLong(3, ((efren.util.entidades.SecOpcion) this.opcionesEnLaTabla.elementAt(i)).getOid());
					if (todo) ps.setInt(4, 0);
					else ps.setInt(4, 1);
					if (ingresoMasivo) ps.setInt(5, 0);
					else ps.setInt(5, 1);
					if (ingresoContinuo) ps.setInt(6, 0);
					else ps.setInt(6, 1);
					if (ingreso) ps.setInt(7, 0);
					else ps.setInt(7, 1);
					if (modificacion) ps.setInt(8, 0);
					else ps.setInt(8, 1);
					if (eliminacion) ps.setInt(9, 0);
					else ps.setInt(9, 1);
					if (consulta) ps.setInt(10, 0);
					else ps.setInt(10, 1);

					ps.execute();
					newOid++;
				} catch (Throwable t2) {
					t2.getMessage();
				}

			}

		}

		ps.close();
		con.commit();

	} catch (Throwable t) {
		t.getMessage();
		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		efren.util.gui.dialogs.InfoView.showErrorDialog(this, "ERROR: no se actualizó las opciones del perfil: ["+t.getMessage()+"]" );
	}
	this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
private void agregarLineasAlNombre(Object unaOpcion) {

    efren.util.entidades.SecOpcion so = (efren.util.entidades.SecOpcion) unaOpcion;
    java.util.StringTokenizer st =  new java.util.StringTokenizer(so.getPosicionAbsoluta(), "-");
    int nivel = st.countTokens();

    for (int i = 0; i < nivel - 1; i++)
        so.setNombre2("-----" + so.getNombre2());
}
private void buscarHijos(efren.util.entidades.SecOpcion menu,
						java.util.Vector opciones,
						java.util.Vector opcionesOrdenadas) {

	try {

		for (int i = 0; i < opciones.size(); i++) {
			if (menu.getOid() == ((efren.util.entidades.SecOpcion) opciones.elementAt(i)).getOpcionPadreOid()) {
				((efren.util.entidades.SecOpcion) opciones.elementAt(i)).setPosicionAbsoluta(
					menu.getPosicionAbsoluta() + "-"
						+ ((efren.util.entidades.SecOpcion) opciones.elementAt(i)).getPosicionAbsoluta()
					);
				menu.setNombre2(menu.getNombre2().toUpperCase());
				opcionesOrdenadas.addElement(opciones.elementAt(i));
				buscarHijos(((efren.util.entidades.SecOpcion) opciones.elementAt(i)), opciones, opcionesOrdenadas);

			}
		}
	} catch (Throwable t) {
		t.getMessage();
	}
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void buscarPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	if (newEvent.getSource() == getDataTablePanel())
		connEtoC14(newEvent);
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the BarraAceptarCancelarPanelListener interface.
 * @param newEvent java.util.EventObject
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
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void comboBoxORDERBYItemSelected(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * connEtoC1:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject) --> PaisABMDetailsView.aceptar(Lcom.ibm.vap.Transactions.VapEJBObjectImpl;)V)
 * @param arg1 java.util.EventObject
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
 * connEtoC10:  (JMenuItem21121.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarDesabilitar_ingreso()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC10(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_ingreso();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC11:  (JMenuItem2111.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarDesabilitar_modificacion()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC11(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_modificacion();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC12:  (JMenuItem211211.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarDesabilitar_eliminacion()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC12(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_eliminacion();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC13:  (JMenuItem2112.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarDesabilitar_consulta()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC13(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_consulta();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC14:  (DataTablePanel.stContainerPanel.buscarPerformed(java.util.EventObject) --> PerfilABMDetailsView.dataFetch()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC14(java.util.EventObject arg1) {
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
 * connEtoC2:  (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject) --> PaisABMDetailsView.cancelar(Lcom.ibm.vap.Transactions.VapEJBObjectImpl;)V)
 * @param arg1 java.util.EventObject
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
 * connEtoC3:  (PerfilABMDetailsView.initialize() --> PerfilABMDetailsView.initCombos()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3() {
	try {
		// user code begin {1}
		// user code end
		this.initCombos();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (JMenuItem21.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarOpcion(Z)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_todo();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (JMenuItem2.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarOpcion(Z)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_ingresoMasivo();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC7:  (DataTablePanel.rightClicked --> PerfilABMDetailsView.showPopupMenu(II)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		String xy = arg1.getNewValue().toString();
		java.util.StringTokenizer st = new java.util.StringTokenizer(xy, "_");
		int x = new Integer(st.nextToken().trim()).intValue();
		int y = new Integer(st.nextToken().trim()).intValue();
		this.showPopupMenu(x, y);
/*
		// user code end
		this.showPopupMenu(100, 100);
		// user code begin {2}
*/
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC9:  (JMenuItemIngresoContinuo.action.actionPerformed(java.awt.event.ActionEvent) --> PerfilABMDetailsView.habilitarDesabilitar_ingresoContinuo()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC9(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.habilitarDesabilitar_ingresoContinuo();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM1:  (ObjectComboBoxSistema.selectedItem --> DataTablePanel.forceFireBuscarPerformed()V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		getDataTablePanel().forceFireBuscarPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
private String convertTo4Chars(int number) {
	if (number <= 9)
		return "000" + String.valueOf(number).trim();
	if (number <= 99)
		return "00" + String.valueOf(number).trim();
	if (number <= 999)
		return "0" + String.valueOf(number).trim();
	return String.valueOf(number).trim();
}
private java.util.Vector crearOpciones(java.util.Vector menues, java.util.Vector opciones) {

	try {

		java.util.Vector opcionesOrdenadas = new java.util.Vector();

		efren.util.entidades.SecOpcion menu;
		for (int i = 0; i < menues.size(); i++) {
			menu = (efren.util.entidades.SecOpcion) menues.elementAt(i);
			opcionesOrdenadas.addElement(menu);
			buscarHijos(menu, opciones, opcionesOrdenadas);
		}
		return opcionesOrdenadas;
	} catch (Throwable t) {
		t.getMessage();
		return new java.util.Vector();
	}
}
private void dataFetch() {

	if (getObjectComboBoxSistema().getSelectedItem() == null)
		return;

	this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

	try {

		getDataTablePanel().clearSelection();
		getDataTablePanel().removeAllRows();

		java.sql.Statement st = efren.util.Conn.conectar().createStatement();

		//todas las opciones
		String s = "SELECT "
			+ " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE "
			+ " , o.POSICION, o.TIMESTAMP "
			+ " , CASE WHEN (c.NOMBRE IS NULL) THEN ' ' "
			+ " ELSE RTRIM(LTRIM(c.PAQUETE)) CONCAT '.' CONCAT RTRIM(LTRIM(c.NOMBRE)) END AS NOMBRECLASE "
			+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
			+ " LEFT OUTER JOIN " + SystemProperties.SCHEMA_SEGURIDADES+"." + "CLASE c "
			+ " ON o.CLASEOID = c.OID "
			+ " WHERE o.SISTEMAOID = " + getObjectComboBoxSistema().getSelectedValueItem() + " "
			+ " AND o.OPCIONPADREOID <> " + getObjectComboBoxSistema().getSelectedValueItem() + " "
			+ " ORDER BY o.POSICION ";
		java.sql.ResultSet rs = st.executeQuery(s);

		java.util.Vector opciones = new java.util.Vector();

		efren.util.entidades.SecOpcion mb;
		while (rs.next()) {

			mb = new efren.util.entidades.SecOpcion();

			mb.setOid(rs.getLong(1));
			mb.setSistemaOid(rs.getLong(2));
			mb.setClaseOid(rs.getLong(3));
			mb.setOpcionPadreOid(rs.getLong(4));
			mb.setNombre(rs.getString(5).trim());
			mb.setNombre2(" " + rs.getString(5).trim());
			mb.setPosicion(rs.getInt(6));
			mb.setTimestamp(rs.getTimestamp(7));
			mb.setNombreClase(rs.getString(8));

			mb.setOP_todo(new Boolean(false));
			mb.setOP_ingresoMasivo(new Boolean(false));
			mb.setOP_ingresoContinuo(new Boolean(false));
			mb.setOP_ingreso(new Boolean(false));
			mb.setOP_modificacion(new Boolean(false));
			mb.setOP_eliminacion(new Boolean(false));
			mb.setOP_consulta(new Boolean(false));

			mb.setPosicionAbsoluta(convertTo4Chars(mb.getPosicion()));

			opciones.addElement(mb);
		}

		//las opciones que son menúes topLevel
		s = "SELECT "
			+ " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE "
			+ " , o.POSICION, o.TIMESTAMP "
			+ " , ' ' "
			+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
			+ " WHERE SISTEMAOID = " + getObjectComboBoxSistema().getSelectedValueItem() + " "
			+ " AND OPCIONPADREOID = " + getObjectComboBoxSistema().getSelectedValueItem() + " "
			+ " ORDER BY o.POSICION, o.NOMBRE  ";
		rs = st.executeQuery(s);

		java.util.Vector menues = new java.util.Vector();

		while (rs.next()) {

			mb = new efren.util.entidades.SecOpcion();

			mb.setOid(rs.getLong(1));
			mb.setSistemaOid(rs.getLong(2));
			mb.setClaseOid(rs.getLong(3));
			mb.setOpcionPadreOid(rs.getLong(4));
			mb.setNombre(rs.getString(5).trim());
			mb.setNombre2(rs.getString(5).trim().toUpperCase());
			mb.setPosicion(rs.getInt(6));
			mb.setTimestamp(rs.getTimestamp(7));
			mb.setNombreClase(rs.getString(8));

			mb.setOP_todo(new Boolean(false));
			mb.setOP_ingresoMasivo(new Boolean(false));
			mb.setOP_ingresoContinuo(new Boolean(false));
			mb.setOP_ingreso(new Boolean(false));
			mb.setOP_modificacion(new Boolean(false));
			mb.setOP_eliminacion(new Boolean(false));
			mb.setOP_consulta(new Boolean(false));

			mb.setPosicionAbsoluta(convertTo4Chars(mb.getPosicion()));

			menues.addElement(mb);
		}

		//las opciones por perfil
		s = "SELECT "
			+ " po.OPCIONOID, po.TODO, po.INGRESOMASIVO, po.INGRESOCONTINUO, po.INGRESO, po.MODIFICACION, po.ELIMINACION, po.CONSULTA "
			+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
			+ " , " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION po "
			+ " WHERE "
			+ " o.SISTEMAOID = " + getObjectComboBoxSistema().getSelectedValueItem() + " "
			+ " AND po.PERFILOID = " + bo.getOid() + " "
			+ " AND o.OID = po.OPCIONOID ";
		rs = st.executeQuery(s);

		java.util.Vector opcionesPorPerfil = new java.util.Vector();
		efren.util.entidades.SecPerfilOpcion spo;
		while (rs.next()) {
			spo = new efren.util.entidades.SecPerfilOpcion();
			spo.setOpcionOid(rs.getLong(1));
			spo.setOP_todo(new Boolean(rs.getInt(2)==0));
			spo.setOP_ingresoMasivo(new Boolean(rs.getInt(3)==0));
			spo.setOP_ingresoContinuo(new Boolean(rs.getInt(4)==0));
			spo.setOP_ingreso(new Boolean(rs.getInt(5)==0));
			spo.setOP_modificacion(new Boolean(rs.getInt(6)==0));
			spo.setOP_eliminacion(new Boolean(rs.getInt(7)==0));
			spo.setOP_consulta(new Boolean(rs.getInt(8)==0));
			opcionesPorPerfil.addElement(spo);
		}

		efren.util.entidades.SecOpcion so;
		//se enlaza las opciones al perfil
		for (int i = 0; i < opcionesPorPerfil.size(); i++) {
			spo = (efren.util.entidades.SecPerfilOpcion) opcionesPorPerfil.elementAt(i);
			for (int j = 0; j < opciones.size(); j++) {
				so = (efren.util.entidades.SecOpcion) opciones.elementAt(j);
				if (spo.getOpcionOid() == so.getOid()) {
					so.setOP_todo(spo.getOP_todo());
					so.setOP_ingresoMasivo(spo.getOP_ingresoMasivo());
					so.setOP_ingresoContinuo(spo.getOP_ingresoContinuo());
					so.setOP_ingreso(spo.getOP_ingreso());
					so.setOP_modificacion(spo.getOP_modificacion());
					so.setOP_eliminacion(spo.getOP_eliminacion());
					so.setOP_consulta(spo.getOP_consulta());
				}
			}
		}
		//se enlaza los menues al perfil
		for (int i = 0; i < opcionesPorPerfil.size(); i++) {
			spo = (efren.util.entidades.SecPerfilOpcion) opcionesPorPerfil.elementAt(i);
			for (int j = 0; j < menues.size(); j++) {
				so = (efren.util.entidades.SecOpcion) menues.elementAt(j);
				if (spo.getOpcionOid() == so.getOid()) {
					so.setOP_todo(spo.getOP_todo());
					so.setOP_ingresoMasivo(spo.getOP_ingresoMasivo());
					so.setOP_ingresoContinuo(spo.getOP_ingresoContinuo());
					so.setOP_ingreso(spo.getOP_ingreso());
					so.setOP_modificacion(spo.getOP_modificacion());
					so.setOP_eliminacion(spo.getOP_eliminacion());
					so.setOP_consulta(spo.getOP_consulta());
				}
			}
		}

		//...
		java.util.Vector opcionesOrdenadas = crearOpciones(menues, opciones);

		for (int i = 0; i < opcionesOrdenadas.size(); i++) {
			agregarLineasAlNombre(opcionesOrdenadas.elementAt(i));
			getDataTablePanel().addRow(opcionesOrdenadas.elementAt(i));
		}

		this.opcionesEnLaTabla = opcionesOrdenadas;

	} catch (Throwable t) {
		t.getMessage();
		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}
	this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue java.lang.Object
 * @param newValue java.lang.Object
 */
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * This method was created in VisualAge.
 * @return efren.abm.estados.ABMEstado
 */
public efren.util.abm.estados.ABMEstado getAbmEstado() {
	return abmEstado;
}
/**
 * Return the BarraAceptarCancelarPanel property value.
 * @return efren.abm.beans.BarraAceptarCancelarPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
	if (ivjBarraAceptarCancelarPanel == null) {
		try {
			ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
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
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJLabelNombre = new java.awt.GridBagConstraints();
			constraintsJLabelNombre.gridx = 0; constraintsJLabelNombre.gridy = 0;
			constraintsJLabelNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabelNombre.insets = new java.awt.Insets(5, 10, 5, 5);
			getJFrameContentPane().add(getJLabelNombre(), constraintsJLabelNombre);

			java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombre.gridx = 1; constraintsTextFieldExtNombre.gridy = 0;
			constraintsTextFieldExtNombre.gridwidth = 2;
			constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombre.weightx = 1.0;
			constraintsTextFieldExtNombre.insets = new java.awt.Insets(5, 5, 5, 10);
			getJFrameContentPane().add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 4; constraintsBarraAceptarCancelarPanel.gridy = 2;
			constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanel.weightx = 1.0;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
			getJFrameContentPane().add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);

			java.awt.GridBagConstraints constraintsJPanel1 = new java.awt.GridBagConstraints();
			constraintsJPanel1.gridx = 0; constraintsJPanel1.gridy = 1;
			constraintsJPanel1.gridwidth = 5;
			constraintsJPanel1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJPanel1.weightx = 1.0;
			constraintsJPanel1.weighty = 1.0;
			constraintsJPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getJPanel1(), constraintsJPanel1);

			java.awt.GridBagConstraints constraintsLabelExt11 = new java.awt.GridBagConstraints();
			constraintsLabelExt11.gridx = 3; constraintsLabelExt11.gridy = 0;
			constraintsLabelExt11.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getLabelExt11(), constraintsLabelExt11);

			java.awt.GridBagConstraints constraintsObjectComboBoxSistema = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxSistema.gridx = 4; constraintsObjectComboBoxSistema.gridy = 0;
			constraintsObjectComboBoxSistema.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxSistema.weightx = 1.0;
			constraintsObjectComboBoxSistema.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getObjectComboBoxSistema(), constraintsObjectComboBoxSistema);
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
 * Return the JLabelNombre property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getJLabelNombre() {
	if (ivjJLabelNombre == null) {
		try {
			ivjJLabelNombre = new efren.util.gui.LabelExt();
			ivjJLabelNombre.setName("JLabelNombre");
			ivjJLabelNombre.setText("Nombre");
			ivjJLabelNombre.setForeground(java.awt.Color.black);
			ivjJLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabelNombre;
}
/**
 * Return the JMenuItem2111 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItem2111() {
	if (ivjJMenuItem2111 == null) {
		try {
			ivjJMenuItem2111 = new javax.swing.JMenuItem();
			ivjJMenuItem2111.setName("JMenuItem2111");
			ivjJMenuItem2111.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItem2111.setText("Modificación");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItem2111;
}
/**
 * Return the JMenuItem2112 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItem2112() {
	if (ivjJMenuItem2112 == null) {
		try {
			ivjJMenuItem2112 = new javax.swing.JMenuItem();
			ivjJMenuItem2112.setName("JMenuItem2112");
			ivjJMenuItem2112.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItem2112.setText("Consulta");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItem2112;
}
/**
 * Return the JMenuItem21121 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItem21121() {
	if (ivjJMenuItem21121 == null) {
		try {
			ivjJMenuItem21121 = new javax.swing.JMenuItem();
			ivjJMenuItem21121.setName("JMenuItem21121");
			ivjJMenuItem21121.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItem21121.setText("Ingreso");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItem21121;
}
/**
 * Return the JMenuItem211211 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItem211211() {
	if (ivjJMenuItem211211 == null) {
		try {
			ivjJMenuItem211211 = new javax.swing.JMenuItem();
			ivjJMenuItem211211.setName("JMenuItem211211");
			ivjJMenuItem211211.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItem211211.setText("Elminación");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItem211211;
}
/**
 * Return the JMenuItemIngresoContinuo property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItemIngresoContinuo() {
	if (ivjJMenuItemIngresoContinuo == null) {
		try {
			ivjJMenuItemIngresoContinuo = new javax.swing.JMenuItem();
			ivjJMenuItemIngresoContinuo.setName("JMenuItemIngresoContinuo");
			ivjJMenuItemIngresoContinuo.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItemIngresoContinuo.setText("Ingreso continuo");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItemIngresoContinuo;
}
/**
 * Return the JMenuItem2 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItemIngresoMasivo() {
	if (ivjJMenuItemIngresoMasivo == null) {
		try {
			ivjJMenuItemIngresoMasivo = new javax.swing.JMenuItem();
			ivjJMenuItemIngresoMasivo.setName("JMenuItemIngresoMasivo");
			ivjJMenuItemIngresoMasivo.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItemIngresoMasivo.setText("Ingreso masivo");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItemIngresoMasivo;
}
/**
 * Return the JMenuItem21 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JMenuItem getJMenuItemTodo() {
	if (ivjJMenuItemTodo == null) {
		try {
			ivjJMenuItemTodo = new javax.swing.JMenuItem();
			ivjJMenuItemTodo.setName("JMenuItemTodo");
			ivjJMenuItemTodo.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJMenuItemTodo.setText("Todo");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJMenuItemTodo;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setBorder(new javax.swing.border.EtchedBorder());
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0; constraintsLabelExt1.gridy = 0;
			constraintsLabelExt1.gridwidth = 3;
			constraintsLabelExt1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsDataTablePanel = new java.awt.GridBagConstraints();
			constraintsDataTablePanel.gridx = 0; constraintsDataTablePanel.gridy = 1;
			constraintsDataTablePanel.gridwidth = 3;
			constraintsDataTablePanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsDataTablePanel.weightx = 1.0;
			constraintsDataTablePanel.weighty = 1.0;
			constraintsDataTablePanel.ipady = -250;
			constraintsDataTablePanel.insets = new java.awt.Insets(0, 10, 10, 5);
			getJPanel1().add(getDataTablePanel(), constraintsDataTablePanel);
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
 * Return the JPopupMenu2 property value.
 * @return javax.swing.JPopupMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPopupMenu getJPopupMenuHabilitar() {
	if (ivjJPopupMenuHabilitar == null) {
		try {
			ivjJPopupMenuHabilitar = new javax.swing.JPopupMenu();
			ivjJPopupMenuHabilitar.setName("JPopupMenuHabilitar");
			ivjJPopupMenuHabilitar.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJPopupMenuHabilitar.add(getJMenuItemTodo());
			ivjJPopupMenuHabilitar.add(getJMenuItemIngresoMasivo());
			ivjJPopupMenuHabilitar.add(getJMenuItemIngresoContinuo());
			ivjJPopupMenuHabilitar.add(getJMenuItem21121());
			ivjJPopupMenuHabilitar.add(getJMenuItem2111());
			ivjJPopupMenuHabilitar.add(getJMenuItem211211());
			ivjJPopupMenuHabilitar.add(getJMenuItem2112());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPopupMenuHabilitar;
}
/**
 * Return the ObjectComboBoxSistema property value.
 * @return efren.util.gui.combo.ObjectComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.combo.ObjectComboBox getObjectComboBoxSistema() {
	if (ivjObjectComboBoxSistema == null) {
		try {
			ivjObjectComboBoxSistema = new efren.util.gui.combo.ObjectComboBox();
			ivjObjectComboBoxSistema.setName("ObjectComboBoxSistema");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjObjectComboBoxSistema;
}
/**
 * Return the observer property value.
 * @return efren.util.ABMViewObserver
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.ABMViewObserver getobserver() {
	// user code begin {1}
	// user code end
	return ivjobserver;
}
/**
 * Method generated to support the promotion of the observerThis attribute.
 * @return efren.util.ABMViewObserver
 */
public efren.util.ABMViewObserver getObserverThis() {
	return getobserver();
}
/**
 * Accessor for the propertyChange field.
 * @return java.beans.PropertyChangeSupport
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
/**
 * Return the DataTablePanel property value.
 * @return efren.abm.beans.DataTablePanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.table.DataTablePanel getDataTablePanel() {
	if (ivjDataTablePanel == null) {
		try {
			ivjDataTablePanel = new efren.util.gui.table.DataTablePanel();
			ivjDataTablePanel.setName("DataTablePanel");
			ivjDataTablePanel.setOpcionesBarButton03Visible(false);
			ivjDataTablePanel.setOpcionesBarButton02Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("Opción", 245, "Nombre2", false, null));
			columnsDefinition.add(new DataTableColumn("Clase", 145, "NombreClase", false, null));
			columnsDefinition.add(new DataTableColumn("Todo", 60, "OP_todo", true, null));
			columnsDefinition.add(new DataTableColumn("Ingreso", 60, "OP_ingreso", true, null));
			columnsDefinition.add(new DataTableColumn("Modificación", 60, "OP_modificacion", true, null));
			columnsDefinition.add(new DataTableColumn("Eliminación", 60, "OP_eliminacion", true, null));
			columnsDefinition.add(new DataTableColumn("Consulta", 60, "OP_consulta", true, null));
			columnsDefinition.add(new DataTableColumn("Ing. mas.", 60, "OP_ingresoMasivo", true, null));
			columnsDefinition.add(new DataTableColumn("Ing. con.", 60, "OP_ingresoContinuo", true, null));
			ivjDataTablePanel.setColumnsDefinition(SecOpcion.class, columnsDefinition);
			ivjDataTablePanel.setOpcionesBarButton00Visible(false);
			ivjDataTablePanel.setOpcionesBarButton01Visible(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjDataTablePanel;
}
/**
 * Return the LabelExt1 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt1() {
	if (ivjLabelExt1 == null) {
		try {
			ivjLabelExt1 = new efren.util.gui.LabelExt();
			ivjLabelExt1.setName("LabelExt1");
			ivjLabelExt1.setText("Opciones del perfil:");
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
 * Return the LabelExt11 property value.
 * @return efren.util.gui.LabelExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.LabelExt getLabelExt11() {
	if (ivjLabelExt11 == null) {
		try {
			ivjLabelExt11 = new efren.util.gui.LabelExt();
			ivjLabelExt11.setName("LabelExt11");
			ivjLabelExt11.setText("Sistema");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjLabelExt11;
}
/**
 * Return the TextFieldExtNombre property value.
 * @return efren.util.gui.TextFieldExt
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
	if (ivjTextFieldExtNombre == null) {
		try {
			ivjTextFieldExtNombre = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtNombre.setName("TextFieldExtNombre");
			ivjTextFieldExtNombre.setMaxLength(50);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTextFieldExtNombre;
}
private void habilitarDesabilitar_consulta() {

	int columna = 8;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_eliminacion() {

	int columna = 7;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_ingreso() {

	int columna = 5;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_ingresoContinuo() {

	int columna = 4;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_ingresoMasivo() {

	int columna = 3;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_modificacion() {

	int columna = 6;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void habilitarDesabilitar_todo() {

	int columna = 2;
	int fila = getDataTablePanel().getTable().getSelectedRow();
	boolean valor = ((Boolean) getDataTablePanel().getTableModel().getValueAt(fila, columna)).booleanValue();

    getDataTablePanel().getTableModel().setValueAt(new Boolean(!valor), fila, columna);
}
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() {
    try {
		getTextFieldExtNombre().setValue(bo.getNombre().trim());
    } catch (Throwable t) {
        t.getMessage();
    }
}
private void initCombos() {
	try {
		java.sql.Statement stmt = efren.util.Conn.conectar().createStatement();
		String s = "SELECT OID, RTRIM(LTRIM(NOMBREPRINCIPAL)) AS NOMBREPRINCIPAL "
			+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"."+"SISTEMA "
			+ " ORDER BY NOMBREPRINCIPAL";
		java.sql.ResultSet rs = stmt.executeQuery(s);
		String vfi[] = new String[30];
		int i = 0;
		while (rs.next()) {
			vfi[i] = rs.getString(1);
			getObjectComboBoxSistema().addItem(rs.getString(2));
			i++;
		}
		getObjectComboBoxSistema().setValuesForItems(vfi);
		getObjectComboBoxSistema().deselect();
	} catch (Throwable t) {
		t.getMessage();
	}
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getJMenuItemTodo().addActionListener(this);
	getJMenuItemIngresoMasivo().addActionListener(this);
	getJMenuItemIngresoContinuo().addActionListener(this);
	getJMenuItem21121().addActionListener(this);
	getJMenuItem2111().addActionListener(this);
	getJMenuItem211211().addActionListener(this);
	getJMenuItem2112().addActionListener(this);
	getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
	getDataTablePanel().addDataTablePanelListener(this);
	getDataTablePanel().addPropertyChangeListener(this);
	getObjectComboBoxSistema().addPropertyChangeListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("PerfilABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(816, 447);
		setContentPane(getJFrameContentPane());
		initConnections();
		connEtoC3();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
    this.addInternalFrameListener(this);
	// user code end
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
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
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
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton01ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the DataTablePanelListener interface.
 * @param newEvent java.util.EventObject
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
 * @param newEvent java.util.EventObject
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
 * @param newEvent java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void opcionesBarButton10ActionPerformed(java.util.EventObject newEvent) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
private boolean permanentUpdateBO() {
	try {
		String s;
		java.sql.Connection con = efren.util.Conn.conectar();
		java.sql.Statement st = con.createStatement();

		if (getAbmEstado().esNuevo()) {
			s = " INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFIL "
				+ " (OID, NOMBRE, TIMESTAMP) VALUES ( " + bo.getOid()
				+ " ," + getTextFieldExtNombre().SQLText() + " ,CURRENT TIMESTAMP ) ";
			st.executeUpdate(s);
			st.close();
			con.commit();
			actualizarPerfil(bo.getOid());
			return true;
		}
		if (getAbmEstado().esModificado()) {
			s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFIL "
				+ " SET NOMBRE = " + getTextFieldExtNombre().SQLText() + ", TIMESTAMP = CURRENT TIMESTAMP "
				+ " WHERE OID = " + bo.getOid() + " AND TIMESTAMP = {ts '" + bo.getTimestamp() + "'}  ";
			int act = st.executeUpdate(s);
			st.close();
			if (act == 0){
				efren.util.gui.dialogs.InfoView.showErrorDialog(this,
					"El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
				return false;
			}
			con.commit();
			actualizarPerfil(bo.getOid());
			return true;
		}
		if (getAbmEstado().esEliminado()) {
			s = " DELETE FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFIL "
				+ " WHERE OID = " + bo.getOid() + " AND TIMESTAMP = {ts '" + bo.getTimestamp() + "'}  ";
			int act = st.executeUpdate(s);
			st.close();
			if (act == 0){
				efren.util.gui.dialogs.InfoView.showErrorDialog(this,
					"El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
				return false;
			}
			con.commit();
			return true;
		}

		return true;

	} catch (Throwable t) {
		efren.util.gui.dialogs.InfoView.showErrorDialog(this, "ERROR: " + t.getMessage());
		return false;
	}

}
/**
 * Method to handle events for the PropertyChangeListener interface.
 * @param evt java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void propertyChange(java.beans.PropertyChangeEvent evt) {
	// user code begin {1}
	// user code end
	if (evt.getSource() == getDataTablePanel() && (evt.getPropertyName().equals("rightClicked")))
		connEtoC7(evt);
	if (evt.getSource() == getObjectComboBoxSistema() && (evt.getPropertyName().equals("selectedItem")))
		connEtoM1(evt);
	// user code begin {2}
	// user code end
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * This method was created in VisualAge.
 * @param newValue efren.abm.estados.ABMEstado
 */
public void setAbmEstado(efren.util.abm.estados.ABMEstado newValue) {
	this.abmEstado = newValue;
}
/**
 * Set the observer to a new value.
 * @param newValue efren.util.ABMViewObserver
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void setobserver(efren.util.ABMViewObserver newValue) {
	if (ivjobserver != newValue) {
		try {
			efren.util.ABMViewObserver oldValue = getobserver();
			ivjobserver = newValue;
			firePropertyChange("observerThis", oldValue, newValue);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	// user code begin {3}
	// user code end
}
/**
 * Method generated to support the promotion of the observerThis attribute.
 * @param arg1 efren.util.ABMViewObserver
 */
public void setObserverThis(efren.util.ABMViewObserver arg1) {
	setobserver(arg1);
}
private void showPopupMenu(int posX, int posY) {
    if (getDataTablePanel().getSelectedObjects().size() == 1)
        getJPopupMenuHabilitar().show(getDataTablePanel().getScrollPane(), posX, posY);
}
private boolean validar() throws Exception {

	/* verificación de los datos ingresados, si no está eliminando el bo */
	if (getAbmEstado().esEliminado()) {
		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
			return true;
		else
			return false;
	} else {
		if (getTextFieldExtNombre().isDataMissing("¡ Ingrese un nombre !"))
			return false;
	}
	return true;
}
}
