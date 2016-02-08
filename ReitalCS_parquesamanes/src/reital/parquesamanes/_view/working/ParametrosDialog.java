package reital.parquesamanes._view.working;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import efren.util.ExceptionManager;
import efren.util.WindowManager;
import efren.util.gui.bars.BarraAceptarCancelarPanelListener;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextFieldExt;
import reital.parquesamanes.app.controllers.PagoController.Valores;
import reital.parquesamanes.app.ioc.Factory;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class ParametrosDialog extends DialogExt implements BarraAceptarCancelarPanelListener, MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 3745104705430035373L;

	// ...
	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private javax.swing.JPanel ivjJPanel1 = null;

	private efren.util.gui.LabelExt ivjLabelExt2 = null;

	private TextFieldExt textFieldExtMinutosGracia = null;

	private Valores valoresIniciales = null;

	@SuppressWarnings("unused")
	private ControlPanelView parentView = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public ParametrosDialog(ControlPanelView view) {
		super(view);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent e) {
				cerrar();
			}
		});
		this.parentView = view;
		initialize();
	}

	/**
	 *
	 */
	private void _aceptar() {
		try {
			guardarValores();
		} catch (Throwable t) {
			t.getMessage();
			InfoView.showErrorDialog(this, t.getMessage());
		}
	}

	/**
	 *
	 */
	private void initializeValores() {
		this.valoresIniciales = new Factory().getPagoControllerBean().getValores();
		// getTextFieldExtValorHoraOFraccion().setValue(StringTools.parseFromNumberToQuantity(this.valoresIniciales.valorHoraOFraccion));
		getTextFieldExtMinutosGracia().setValue(String.valueOf(this.valoresIniciales.minutosGracia));
		// getJCheckBoxImprimirRecibo().setSelected(this.valoresIniciales.imprimeRecibo);
	}

	/**
	 *
	 */
	private void guardarValores() {

		// BigDecimal valorHoraOFraccion = new
		// BigDecimal(getTextFieldExtValorHoraOFraccion().getValue().trim()).setScale(2,
		// BigDecimal.ROUND_HALF_UP);
		int minutosGracia = Integer.valueOf(getTextFieldExtMinutosGracia().getValue().trim());
		// boolean imprimirRecibo = getJCheckBoxImprimirRecibo().isSelected();
		/*
		 * if (valorHoraOFraccion.doubleValue() !=
		 * this.valoresIniciales.valorHoraOFraccion.doubleValue()) {
		 * this.pagoModel.actualizarValor("VALOR_HORA_FRACCION",
		 * valorHoraOFraccion.doubleValue()); }
		 */
		if (minutosGracia != this.valoresIniciales.minutosGracia) {
			new Factory().getPagoControllerBean().actualizarParametro_MinutosGracia(minutosGracia);
		}
		/*
		 * if (imprimirRecibo != this.valoresIniciales.imprimeRecibo) { int temp
		 * = 0; if (imprimirRecibo) { temp = 1; }
		 * this.pagoModel.actualizarValor("IMPRIMIR_RECIBO", temp); }
		 */
		// this.parentView.reinicializarVisual();
		dispose();
	}

	/**
	 *
	 */
	public void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, true, this, exception);
	}

	/**
	 *
	 *
	 */
	public void _cerrar() {
		dispose();
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
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
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * Method to handle events for the BarraAceptarCancelarPanelListener
	 * interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
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
	 * connEtoC1:
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.aceptarClicked(java.
	 * util.EventObject) --> LogonView.aceptar()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this._aceptar();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2:
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java
	 * .util.EventObject) --> LogonView.cancelar()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
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
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Return the BarraAceptarCancelarPanel property value.
	 * 
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel() {
		if (ivjBarraAceptarCancelarPanel == null) {
			try {
				ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
				ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
				ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cerrar");
				ivjBarraAceptarCancelarPanel.setButtonAceptarText("Cambiar valor");
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
	 * Return the JPanel1 property value.
	 * 
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			ivjJPanel1 = new JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 0;
			constraintsBarraAceptarCancelarPanel.gridy = 3;
			constraintsBarraAceptarCancelarPanel.gridwidth = 3;
			constraintsBarraAceptarCancelarPanel.weightx = 1.0;
			constraintsBarraAceptarCancelarPanel.weighty = 1.0;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
			java.awt.GridBagConstraints constraintsTextFieldExtMinutosGracia = new java.awt.GridBagConstraints();
			constraintsTextFieldExtMinutosGracia.ipady = 15;
			constraintsTextFieldExtMinutosGracia.gridx = 1;
			constraintsTextFieldExtMinutosGracia.gridy = 1;
			constraintsTextFieldExtMinutosGracia.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtMinutosGracia.weightx = 1.0;
			constraintsTextFieldExtMinutosGracia.anchor = GridBagConstraints.NORTHWEST;
			constraintsTextFieldExtMinutosGracia.insets = new Insets(0, 5, 5, 5);
			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 1;
			constraintsLabelExt2.gridy = 0;
			constraintsLabelExt2.anchor = GridBagConstraints.SOUTHWEST;
			constraintsLabelExt2.insets = new Insets(5, 5, 5, 5);
			ivjJPanel1.add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
			ivjJPanel1.add(getTextFieldExtMinutosGracia(), constraintsTextFieldExtMinutosGracia);
			ivjJPanel1.add(getLabelExt2(), constraintsLabelExt2);
		}
		return ivjJPanel1;
	}

	/**
	 *
	 */
	private TextFieldExt getTextFieldExtMinutosGracia() {
		if (textFieldExtMinutosGracia == null) {
			textFieldExtMinutosGracia = new TextFieldExt();
			textFieldExtMinutosGracia.setFont(new Font("", Font.BOLD, 22));
			textFieldExtMinutosGracia.setMaxLength(2);
			textFieldExtMinutosGracia.setKeyMask(TextFieldExt.KeyMask.KM_Numero);
			textFieldExtMinutosGracia.setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
		}
		return textFieldExtMinutosGracia;
	}

	/**
	 * Accessor for the propertyChange field.
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Return the LabelExt2 property value.
	 * 
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt2() {
		if (ivjLabelExt2 == null) {
			try {
				ivjLabelExt2 = new efren.util.gui.LabelExt();
				ivjLabelExt2.setName("LabelExt2");
				ivjLabelExt2.setDisplayedMnemonic('w');
				ivjLabelExt2.setText(
						"Minutos gracia para CLIENTES " + ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL + "");
				ivjLabelExt2.setForeground(java.awt.Color.black);
				ivjLabelExt2.setHorizontalAlignment(SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt2;
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		this.addMouseListener(this);
		getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
	}

	/**
	 *
	 */
	private void initialize() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setTitle("Cambio de parámetros");
			setSize(328, 265);
			setResizable(false);
			setContentPane(getJPanel1());
			initConnections();
			setModal(true);
			WindowManager.centerWindow2(this);
			initializeValores();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/**
	 *
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 *
	 */
	private void cerrar() {
		try {
			// ((ControlPanelView) getOwner()).reinicializarVisual();
		} catch (Exception e) {
			e.getMessage();
		}
		dispose();
	}
} // @jve:decl-index=0:visual-constraint="10,10"
