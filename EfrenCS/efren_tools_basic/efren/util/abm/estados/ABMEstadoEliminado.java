package efren.util.abm.estados;

public class ABMEstadoEliminado extends ABMEstado {
	public String titulo = null;

	public javax.swing.JFrame view = null;

	/**
	 * ABMEstadoParaEliminar constructor comment.
	 */
	public ABMEstadoEliminado(String tituloVentana) {
		super(tituloVentana);
		this.setTitulo(tituloVentana);
		setActionName("ELIMINACION");
		BG_COLOR = new java.awt.Color(254, 207, 215);
		setActionType(ABMEstado.ABM_ELIMINAR);
	}

	/**
	 * aceptar method comment.
	 */
	public void aceptar() {
		return;
	}

	public boolean esEliminado() {
		return true;
	}

	/**
	 * getTitulo method comment.
	 */
	public String getTitulo() {
		return titulo;
	}

	public javax.swing.JFrame getView() {
		return view;
	}

	/**
	 * setTitulo method comment.
	 */
	public void setTitulo(String unTitulo) {
		titulo = unTitulo;
	}

	public void setView(javax.swing.JFrame aView) {
		view = aView;
	}
}
