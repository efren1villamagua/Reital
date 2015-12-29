package efren.util.abm.estados;

/**
 * This type was created in VisualAge.
 */
public abstract class ABMEstado {

	public static final int ABM_NUEVO = 1;

	public static final int ABM_MODIFICAR = 2;

	public static final int ABM_CONSULTAR = 3;

	public static final int ABM_ELIMINAR = 4;

	public static final int CONEXION_USUARIO = 11;

	public static final int DESCONEXION_USUARIO = 12;

	public String titulo = null;

	public javax.swing.JFrame view = null;

	private java.lang.String actionName = "NO_DEFINIDA";

	public static java.awt.Color BG_COLOR = null;

	private int actionType = -1;

	public ABMEstado(String tituloVentana) {
		super();
		this.setTitulo(tituloVentana);
	}

	public void aceptar() {
		return;
	}

	public boolean esConsultado() {
		return false;
	}

	public boolean esEliminado() {
		return false;
	}

	public boolean esModificado() {
		return false;
	}

	public boolean esNuevo() {
		return false;
	}

	public java.lang.String getActionName() {
		return actionName;
	}

	public String getTitulo() {
		return titulo;
	}

	public javax.swing.JFrame getView() {
		return view;
	}

	public void setActionName(java.lang.String newActionName) {
		actionName = newActionName;
	}

	public void setTitulo(String unTitulo) {
		titulo = unTitulo;
	}

	public void setView(javax.swing.JFrame aView) {
		view = aView;
	}

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}
}
