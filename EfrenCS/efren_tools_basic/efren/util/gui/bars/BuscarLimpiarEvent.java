package efren.util.gui.bars;

import java.util.EventObject;

public class BuscarLimpiarEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7454081213742140413L;
	
	private boolean buscar = false;
	private boolean limpiar = false;

	public BuscarLimpiarEvent(Object source) {
		super(source);
	}

	public boolean isBuscar() {
		return buscar;
	}

	public void setBuscar(boolean buscar) {
		this.buscar = buscar;
	}

	public boolean isLimpiar() {
		return limpiar;
	}

	public void setLimpiar(boolean limpiar) {
		this.limpiar = limpiar;
	}

}
