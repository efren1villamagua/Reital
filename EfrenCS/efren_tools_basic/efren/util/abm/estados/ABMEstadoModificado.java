package efren.util.abm.estados;

public class ABMEstadoModificado extends ABMEstado {
	public String titulo = null;

	public javax.swing.JFrame view = null;

	/**
	 * ABMEstadoParaModificar constructor comment.
	 */
	public ABMEstadoModificado(String tituloVentana) {
		super(tituloVentana);
		this.setTitulo(tituloVentana);
		setActionName("MODIFICACION");
		BG_COLOR = new java.awt.Color(209, 216, 252);
		setActionType(ABMEstado.ABM_MODIFICAR);
	}

	/**
	 * aceptar method comment.
	 */
	public void aceptar() {
		return;
	}

	public boolean esModificado() {
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
