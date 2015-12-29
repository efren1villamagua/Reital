package efren.util.gui.bars;

import efren.util.ExceptionManager;
import efren.util.gui.LabelExt;
import efren.util.gui.LoweredPanel;

/**
 * This type was created in VisualAge.
 */
public class BarraEstadosPanel2 extends efren.util.gui.LoweredPanel implements java.beans.PropertyChangeListener {
	private LabelExt ivjLabelExtEstado = null;

	private LabelExt ivjLabelExt = null;

	private efren.util.abm.estados.ABMEstado ABMEstado;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public BarraEstadosPanel2() {
		super();
		initialize();
	}

	/**
	 * BarraEstadosPanel constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public BarraEstadosPanel2(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * BarraEstadosPanel constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public BarraEstadosPanel2(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * BarraEstadosPanel constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public BarraEstadosPanel2(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * connEtoC1: (TextFieldExtEstado.value -->
	 * BarraEstadosPanel2.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("mensaje01", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (TextFieldExt.value -->
	 * BarraEstadosPanel2.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("mensaje02", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public efren.util.abm.estados.ABMEstado getABMEstado() {
		return ABMEstado;
	}

	/**
	 * Method generated to support the promotion of the mensaje01 attribute.
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMensaje01() {
		return getLabelExtEstado().getText();
	}

	/**
	 * Method generated to support the promotion of the mensaje02 attribute.
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMensaje02() {
		return getLabelExt().getText();
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @return java.lang.String
	 */
	public String getText() {
		return getLabelExtEstado().getText();
	}

	/**
	 * Return the TextFieldExt property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			ivjLabelExt = new LabelExt();
			ivjLabelExt.setName("LabelExt");
			ivjLabelExt.setBackground(java.awt.Color.white);
			ivjLabelExt.setForeground(new java.awt.Color(57, 106, 41));
			ivjLabelExt.setText("message");
			ivjLabelExt.setFont(new java.awt.Font("Arial", 0, 10));
		}
		return ivjLabelExt;
	}

	/**
	 * Return the TextFieldExtEstado property value.
	 * 
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExtEstado() {
		if (ivjLabelExtEstado == null) {
			ivjLabelExtEstado = new LabelExt();
			ivjLabelExtEstado.setName("TextFieldExtEstado");
			ivjLabelExtEstado.setBackground(java.awt.Color.white);
			ivjLabelExtEstado.setForeground(new java.awt.Color(160, 31, 79));
			ivjLabelExtEstado.setText("title:");
			ivjLabelExtEstado.setFont(new java.awt.Font("Arial", 1, 10));
		}
		return ivjLabelExtEstado;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 * 
	 * @exception java.lang.Exception
	 *                The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getLabelExtEstado().addPropertyChangeListener(this);
		getLabelExt().addPropertyChangeListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("BarraEstadosPanel");
			setLayout(new java.awt.GridBagLayout());
			setSize(395, 28);

			java.awt.GridBagConstraints constraintsTextFieldExtEstado = new java.awt.GridBagConstraints();
			constraintsTextFieldExtEstado.gridx = 0;
			constraintsTextFieldExtEstado.gridy = 0;
			constraintsTextFieldExtEstado.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextFieldExtEstado.weighty = 1.0;
			constraintsTextFieldExtEstado.ipadx = 60;
			add(getLabelExtEstado(), constraintsTextFieldExtEstado);

			java.awt.GridBagConstraints constraintsTextFieldExt = new java.awt.GridBagConstraints();
			constraintsTextFieldExt.gridx = 1;
			constraintsTextFieldExt.gridy = 0;
			constraintsTextFieldExt.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextFieldExt.weightx = 1.0;
			constraintsTextFieldExt.weighty = 1.0;
			add(getLabelExt(), constraintsTextFieldExt);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		getLabelExtEstado().setFont(efren.util.FontManager.currentSystemBoldFont());
		getLabelExtEstado().setForeground(new java.awt.Color(128, 64, 0));
		getLabelExt().setBorder(javax.swing.BorderFactory.createEmptyBorder());
		getLabelExtEstado().setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// user code end
	}
	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 * 
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getLabelExtEstado() && (evt.getPropertyName().equals("value")))
			connEtoC1(evt);
		if (evt.getSource() == getLabelExt() && (evt.getPropertyName().equals("value")))
			connEtoC2(evt);
		// user code begin {2}
		// user code end
	}

	public void setABMEstado(efren.util.abm.estados.ABMEstado newABMEstado) {
		ABMEstado = newABMEstado;
		// ...
		if (newABMEstado == null || !newABMEstado.esNuevo())
			this.setVisible(false);
	}

	public void setBackground(java.awt.Color c) {
		// no hacemos nada
		// super.setBackground(c);
		// getLabelExtEstado().setBackground(c);
	}

	/**
	 * Method generated to support the promotion of the mensaje01 attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setMensaje01(java.lang.String arg1) {
		getLabelExtEstado().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the mensaje02 attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setMensaje02(java.lang.String arg1) {
		getLabelExt().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setText(String arg1) {
		getLabelExtEstado().setText(arg1);
	}
}
