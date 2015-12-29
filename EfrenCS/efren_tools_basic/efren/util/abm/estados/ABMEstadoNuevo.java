package efren.util.abm.estados;

public class ABMEstadoNuevo extends ABMEstado {
	public String titulo = null;

	public javax.swing.JFrame view = null;

	/**
	 * ABMEstadoNuevo constructor comment.
	 */
	public ABMEstadoNuevo(String tituloVentana) {
		super(tituloVentana);
		this.setTitulo(tituloVentana);
		setActionName("INSERCION");
		BG_COLOR = new java.awt.Color(215, 252, 205);
		setActionType(ABMEstado.ABM_NUEVO);
	}

	/**
	 * aceptar method comment.
	 */
	public void aceptar() {
		return;
	}

	public boolean esNuevo() {
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
