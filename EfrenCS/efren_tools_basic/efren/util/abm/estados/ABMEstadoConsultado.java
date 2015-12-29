package efren.util.abm.estados;

public class ABMEstadoConsultado extends ABMEstado {
	public String titulo = null;

	public javax.swing.JFrame view = null;

	/**
	 * ABMEstadoParaModificar constructor comment.
	 */
	public ABMEstadoConsultado(String tituloVentana) {
		super(tituloVentana);
		this.setTitulo(tituloVentana);
		setActionName("CONSULTA");
		BG_COLOR = new java.awt.Color(251, 253, 219);
		setActionType(ABMEstado.ABM_CONSULTAR);
	}

	/**
	 * aceptar method comment.
	 */
	public void aceptar() {
		return;
	}

	public boolean esConsultado() {
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
