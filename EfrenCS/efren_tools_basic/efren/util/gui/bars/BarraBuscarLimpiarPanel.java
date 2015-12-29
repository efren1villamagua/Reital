package efren.util.gui.bars;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraBuscarLimpiarPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3053908728163178315L;
	private JButton jButtonBuscar = null;
	private JButton jButtonLimpiar = null;
	private JToolBar jToolBar = null;
	private Vector<BuscarLimpiarEventListener> listeners = new Vector<BuscarLimpiarEventListener>();  //  @jve:decl-index=0:
	/**
	 * 
	 */
	public BarraBuscarLimpiarPanel() {
		super();
		initialize();
	}
	/**
	 * 
	 */
	public BarraBuscarLimpiarPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * TsBarraAceptarCancelarPanel constructor comment.
	 * 
	 * @param layout
	 * 		java.awt.LayoutManager
	 * @param isDoubleBuffered
	 * 		boolean
	 */
	public BarraBuscarLimpiarPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * TsBarraAceptarCancelarPanel constructor comment.
	 * 
	 * @param isDoubleBuffered
	 * 		boolean
	 */
	public BarraBuscarLimpiarPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * 
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setName("JButtonBuscar");
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setForeground(new Color(80, 80, 80));
			jButtonBuscar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/buscar24x24.png")));
			jButtonBuscar.setFont(new Font("Arial", Font.BOLD, 10));
			jButtonBuscar.setOpaque(false);
			jButtonBuscar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
			jButtonBuscar.setMargin(new Insets(0, 0, 0, 0));
			jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonBuscar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					fireBuscarLimpiarPerformed(true);
				}
			});
		}
		return jButtonBuscar;
	}
	/**
	 * 
	 */
	private JButton getJButtonLimpiar() {
		if (jButtonLimpiar == null) {
			jButtonLimpiar = new JButton();
			jButtonLimpiar.setName("JButtonLimpiar");
			jButtonLimpiar.setMnemonic(KeyEvent.VK_L);
			jButtonLimpiar.setText("Limpiar");
			jButtonLimpiar.setForeground(new Color(80, 80, 80));
			jButtonLimpiar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/limpiar24x24.png")));
			jButtonLimpiar.setFont(new Font("Arial", 1, 10));
			jButtonLimpiar.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
			jButtonLimpiar.setMargin(new Insets(0, 0, 0, 0));
			jButtonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					fireBuscarLimpiarPerformed(false);
				}
			});
		}
		return jButtonLimpiar;
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridx = 0;
		setName("BarraAceptarCancelarPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(156, 32);
		this.add(getJToolBar(), gridBagConstraints);
	}
	/**
	 * 
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonBuscar());
			jToolBar.add(getJButtonLimpiar());
		}
		return jToolBar;
	}
	/** 
	 * 
	 */
	synchronized public void addBuscarLimpiarListener(BuscarLimpiarEventListener l) {
		if (listeners == null) {
			listeners = new Vector<BuscarLimpiarEventListener>();
	    }
	    listeners.addElement(l);
	}  
	/** 
	 * 
	 */
	synchronized public void removeBuscarLimpiarListener(BuscarLimpiarEventListener l) {
		if (listeners == null) {
			listeners = new Vector<BuscarLimpiarEventListener>();
	    }
	    listeners.removeElement(l);
	}
	/**
	 * 
	 */
	protected void fireBuscarLimpiarPerformed(boolean buscar) {
	    if (listeners != null && !listeners.isEmpty()) {
	    	BuscarLimpiarEvent evento = new BuscarLimpiarEvent(this);
	    	evento.setBuscar(buscar);
	    	evento.setLimpiar(!buscar);
	    	Vector<BuscarLimpiarEventListener> targets;
	    	synchronized (this) {
	    		targets = (Vector<BuscarLimpiarEventListener>) listeners.clone();
	    	}
	    	Enumeration<BuscarLimpiarEventListener> e = targets.elements();
	    	while (e.hasMoreElements()) {
	    		BuscarLimpiarEventListener l = (BuscarLimpiarEventListener) e.nextElement();
	    		if (buscar) {
	    			l.buscarPerformed(evento);
	    		} else {
	    			l.limpiarPerformed(evento);
	    		}
	      }
	    }
	}
} // @jve:decl-index=0:visual-constraint="45,10"
