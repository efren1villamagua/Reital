package efren.seguridades.abm.gui;

import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import efren.seguridades.util.tree.PerfilOpcionTreeTable;
import efren.util.ExceptionManager;
import efren.util.config.SystemProperties;
import efren.util.gui.LabelExt;
import efren.util.gui.text.TextAreaExt;
public class PerfilABMDetailsView extends javax.swing.JInternalFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener,
		java.awt.event.ActionListener, java.beans.PropertyChangeListener, javax.swing.event.InternalFrameListener {
    public long perfilOid;
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
    private java.util.Vector opcionesEnLaTabla;
	private JScrollPane jScrollPane = null;
	private PerfilOpcionTreeTable perfilOpcionTreeTable = null;
	private TextAreaExt textAreaExtDescripcion = null;
	private LabelExt labelExt = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public PerfilABMDetailsView() {
		super();
		initialize();
	}
	public PerfilABMDetailsView(long unPerfilOid) {
		super();
		this.perfilOid = unPerfilOid;
		initialize();
	}
/**
 * GradoABMDetailsView constructor comment.
 * @param title java.lang.String
 */
public PerfilABMDetailsView(String title) {
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
	// user code begin {2}
	// user code end
}
private void actualizarPerfil(long unPerfilOid) {

//	if (InfoView.showConfirmDialog(this, "Está seguro de actualizar el Perfil?" ) != InfoView.YES_OPTION) {
//		return;
//	}

    java.sql.Connection con = null;
	try {
		con = efren.util.Conn.conectar();
		con.setAutoCommit(false);

		java.sql.Statement st = con.createStatement();

		this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

/*
		try {
			//primero borramos todas las opciones del perfil en el sistema
			s = "DELETE FROM " + efren.util.Constantes.SCHEMA_SEGURIDADES+"." + "PERFILOPCION "
				+ " WHERE "
				+ " PERFILOID = " + unPerfilOid;
			st.executeUpdate(s);
		} catch (Throwable t2) {
			t2.getMessage();
		}
*/
		//luego insertamos todas las opciones del perfil en el sistema
		String sql = "SELECT MAX(OID) FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION";
		java.sql.ResultSet rs = st.executeQuery(sql);
		long newOid = -1;
		while (rs.next()) {
		    newOid = rs.getLong(1) + 1L;
        }
		rs.close();

		String sql_INSERT = "INSERT INTO " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION "
			+ " (OID, PERFILOID, OPCIONOID, TODO, INGRESOMASIVO, INGRESOCONTINUO, INGRESO, MODIFICACION, "
			+ " ELIMINACION, CONSULTA, TIMESTAMP) VALUES ( "
			+ " ?,?,?,?,?,?,?,?,?,?, CURRENT TIMESTAMP ) ";
		java.sql.PreparedStatement ps_INSERT = con.prepareStatement(sql_INSERT);
		String sql_UPDATE = "UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION "
			+ " SET TODO=?, INGRESOMASIVO=?, INGRESOCONTINUO=?, INGRESO=?, MODIFICACION=?, ELIMINACION=?, CONSULTA=? "
			+ " WHERE OID=?";
		java.sql.PreparedStatement ps_UPDATE = con.prepareStatement(sql_UPDATE);

		TableModel tableModel = getPerfilOpcionTreeTable().getModel();
		int rowCount = tableModel.getRowCount();
		boolean todo, ingresoMasivo, ingresoContinuo, ingreso, modificacion, eliminacion, consulta;
		long opcionOid, perfilOpcionOid;
		int tipoOpcion;
		for (int i = 0; i < rowCount; i++) {

		    tipoOpcion = new Integer(tableModel.getValueAt(i, 10).toString().trim()).intValue();//1:SistemaSeguridades; 2: Sistema; 3 Menu; 4: Opcion
		    if (tipoOpcion == 4) {

			    opcionOid = new Long(tableModel.getValueAt(i, 9).toString().trim()).longValue();

			    sql = "SELECT OID FROM PERFILOPCION WHERE PERFILOID="+perfilOid+" AND OPCIONOID="+opcionOid;
			    rs = st.executeQuery(sql);
			    perfilOpcionOid = -1;
			    while (rs.next()) {
	                perfilOpcionOid = rs.getLong(1);
	            }
			    rs.close();

			    if (perfilOpcionOid == -1) {//INSERT

					todo = new Boolean(tableModel.getValueAt(i, 2).toString().trim()).booleanValue();
					ingresoMasivo = new Boolean(tableModel.getValueAt(i, 3).toString().trim()).booleanValue();
					ingresoContinuo = new Boolean(tableModel.getValueAt(i, 4).toString().trim()).booleanValue();
					ingreso = new Boolean(tableModel.getValueAt(i, 5).toString().trim()).booleanValue();
					modificacion = new Boolean(tableModel.getValueAt(i, 6).toString().trim()).booleanValue();
					eliminacion = new Boolean(tableModel.getValueAt(i, 7).toString().trim()).booleanValue();
					consulta = new Boolean(tableModel.getValueAt(i, 8).toString().trim()).booleanValue();

					try {
						ps_INSERT.setLong(1, newOid);
						ps_INSERT.setLong(2, unPerfilOid);
						ps_INSERT.setLong(3, new Long(tableModel.getValueAt(i, 9).toString().trim()).longValue());
						if (todo)
						    ps_INSERT.setInt(4, 0);
						else
						    ps_INSERT.setInt(4, 1);
						if (ingresoMasivo)
						    ps_INSERT.setInt(5, 0);
						else
						    ps_INSERT.setInt(5, 1);
						if (ingresoContinuo)
						    ps_INSERT.setInt(6, 0);
						else
						    ps_INSERT.setInt(6, 1);
						if (ingreso)
						    ps_INSERT.setInt(7, 0);
						else
						    ps_INSERT.setInt(7, 1);
						if (modificacion)
						    ps_INSERT.setInt(8, 0);
						else
						    ps_INSERT.setInt(8, 1);
						if (eliminacion)
						    ps_INSERT.setInt(9, 0);
						else
						    ps_INSERT.setInt(9, 1);
						if (consulta)
						    ps_INSERT.setInt(10, 0);
						else
						    ps_INSERT.setInt(10, 1);

						ps_INSERT.execute();
						newOid++;
					} catch (Throwable t2) {
						t2.getMessage();
					}

			    } else {//UPDATE

					todo = new Boolean(tableModel.getValueAt(i, 2).toString().trim()).booleanValue();
					ingresoMasivo = new Boolean(tableModel.getValueAt(i, 3).toString().trim()).booleanValue();
					ingresoContinuo = new Boolean(tableModel.getValueAt(i, 4).toString().trim()).booleanValue();
					ingreso = new Boolean(tableModel.getValueAt(i, 5).toString().trim()).booleanValue();
					modificacion = new Boolean(tableModel.getValueAt(i, 6).toString().trim()).booleanValue();
					eliminacion = new Boolean(tableModel.getValueAt(i, 7).toString().trim()).booleanValue();
					consulta = new Boolean(tableModel.getValueAt(i, 8).toString().trim()).booleanValue();

					try {
						ps_UPDATE.setLong(8, perfilOpcionOid);
						if (todo)
						    ps_UPDATE.setInt(1, 0);
						else
						    ps_UPDATE.setInt(1, 1);
						if (ingresoMasivo)
						    ps_UPDATE.setInt(2, 0);
						else
						    ps_UPDATE.setInt(2, 1);
						if (ingresoContinuo)
						    ps_UPDATE.setInt(3, 0);
						else
						    ps_UPDATE.setInt(3, 1);
						if (ingreso)
						    ps_UPDATE.setInt(4, 0);
						else
						    ps_UPDATE.setInt(4, 1);
						if (modificacion)
						    ps_UPDATE.setInt(5, 0);
						else
						    ps_UPDATE.setInt(5, 1);
						if (eliminacion)
						    ps_UPDATE.setInt(6, 0);
						else
						    ps_UPDATE.setInt(6, 1);
						if (consulta)
						    ps_UPDATE.setInt(7, 0);
						else
						    ps_UPDATE.setInt(7, 1);

						ps_UPDATE.execute();

					} catch (Throwable t2) {
						t2.getMessage();
					}
			    }

			}

		}
		ps_INSERT.close();
		ps_UPDATE.close();
		con.commit();

	} catch (Throwable t) {
	    try {
            con.rollback();
        } catch (Exception e) {
            e.getMessage();
        }
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
			labelExt = new LabelExt();
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJLabelNombre = new java.awt.GridBagConstraints();
			constraintsJLabelNombre.gridx = 0; constraintsJLabelNombre.gridy = 0;
			constraintsJLabelNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJLabelNombre.insets = new java.awt.Insets(5, 10, 5, 5);
			java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombre.gridx = 1; constraintsTextFieldExtNombre.gridy = 0;
			constraintsTextFieldExtNombre.gridwidth = 2;
			constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombre.weightx = 1.0;
			constraintsTextFieldExtNombre.insets = new java.awt.Insets(5, 5, 5, 10);
			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 3; constraintsBarraAceptarCancelarPanel.gridy = 3;
			constraintsBarraAceptarCancelarPanel.anchor = java.awt.GridBagConstraints.EAST;
			constraintsBarraAceptarCancelarPanel.weightx = 0.0D;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
   			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints1.gridwidth = 5;
			gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.insets = new java.awt.Insets(5,5,5,10);
			gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.weightx = 1.0D;
			gridBagConstraints2.ipady = 20;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.anchor = java.awt.GridBagConstraints.EAST;
			gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
			labelExt.setText("Descripción");
			constraintsJLabelNombre.anchor = java.awt.GridBagConstraints.EAST;
			ivjJFrameContentPane.add(getJLabelNombre(), constraintsJLabelNombre);
			ivjJFrameContentPane.add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
			ivjJFrameContentPane.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
			ivjJFrameContentPane.add(getJScrollPane(), gridBagConstraints1);
			ivjJFrameContentPane.add(getTextAreaExtDescripcion(), gridBagConstraints2);
			ivjJFrameContentPane.add(labelExt, gridBagConstraints3);
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
private void handleException(Throwable exception) {
	ExceptionManager.singleton().manage(this, false, this, exception);
}
public void initAll() {
    try {
		getTextFieldExtNombre().setValue(bo.getNombre().trim());
		getTextAreaExtDescripcion().setValue(bo.getDescripcion().trim());
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
		setName("PerfilABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(816, 447);
		setContentPane(getJFrameContentPane());
		initConnections();
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
				+ " (OID, NOMBRE, NOMBRE2, TIMESTAMP) VALUES ( " + bo.getOid()
				+ " ," + getTextFieldExtNombre().SQLText() + " ," + getTextAreaExtDescripcion().SQLText() + " ,CURRENT TIMESTAMP ) ";
			st.executeUpdate(s);
			st.close();
			con.commit();
			actualizarPerfil(bo.getOid());
			return true;
		}
		if (getAbmEstado().esModificado()) {
			s = " UPDATE " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFIL "
				+ " SET NOMBRE = " + getTextFieldExtNombre().SQLText() + ", NOMBRE2 = " + getTextAreaExtDescripcion().SQLText() + ", TIMESTAMP = CURRENT TIMESTAMP "
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

private boolean validar() throws Exception {

	/* verificación de los datos ingresados, si no está eliminando el bo */
	if (getAbmEstado().esEliminado()) {
		if (efren.util.gui.dialogs.InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", efren.util.gui.dialogs.InfoView.YES_NO_OPTION) == 0)
			return true;
		else
			return false;
	} else {
		if (getTextFieldExtNombre().isDataMissing("¡ Ingrese un NOMBRE !"))
			return false;
		if (getTextAreaExtDescripcion().isDataMissing("¡ Ingrese una DESCRIPCION !"))
			return false;
	}
	return true;
}
	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getPerfilOpcionTreeTable());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes perfilOpcionTreeTable
	 *
	 * @return efren.seguridades.util.tree.PerfilOpcionTreeTable
	 */
	private PerfilOpcionTreeTable getPerfilOpcionTreeTable() {
		if (perfilOpcionTreeTable == null) {
			perfilOpcionTreeTable = new PerfilOpcionTreeTable(this.perfilOid);
		}
		return perfilOpcionTreeTable;
	}
	/**
	 * This method initializes textAreaExtDescripcion
	 *
	 * @return efren.util.gui.TextAreaExt
	 */
	private TextAreaExt getTextAreaExtDescripcion() {
		if (textAreaExtDescripcion == null) {
			textAreaExtDescripcion = new TextAreaExt();
			textAreaExtDescripcion.setMaxLength(400);
		}
		return textAreaExtDescripcion;
	}
 }
