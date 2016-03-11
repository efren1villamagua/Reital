package reital.parquesamanes.rxtx.app;

public class Resultado {

	public static enum Status {
		EXITO, ERROR;
	}

	private Status status;
	private StringBuffer mensaje;

	public Resultado() {
		super();
		initialize();
	}

	private void initialize() {
		setStatus(Status.ERROR);
		setMensaje(new StringBuffer());
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private StringBuffer getMensaje() {
		return mensaje;
	}

	private void setMensaje(StringBuffer mensaje) {
		this.mensaje = mensaje;
	}

	public void appendMensaje(String texto) {
		getMensaje().append(texto);
	}

	public String getMensajeString() {
		return getMensaje().toString();
	}

}
