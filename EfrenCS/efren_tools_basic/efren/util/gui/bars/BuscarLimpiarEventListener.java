package efren.util.gui.bars;

import java.util.EventListener;

public interface BuscarLimpiarEventListener extends EventListener {
	
	public void buscarPerformed(BuscarLimpiarEvent evento);
	public void limpiarPerformed(BuscarLimpiarEvent evento);
	
}
