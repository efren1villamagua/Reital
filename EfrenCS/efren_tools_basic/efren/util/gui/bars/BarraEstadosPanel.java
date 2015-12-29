package efren.util.gui.bars;

import java.awt.Font;

import efren.util.ExceptionManager;
import efren.util.gui.LabelExt;

/**
 * This type was created in VisualAge.
 */
public class BarraEstadosPanel extends javax.swing.JPanel implements java.beans.PropertyChangeListener {
	private LabelExt ivjLabelExtEstado = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public BarraEstadosPanel() {
		super();
		initialize();
	}

	/**
	 * BarraEstadosPanel constructor comment.
	 *
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public BarraEstadosPanel(java.awt.LayoutManager layout) {
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
	public BarraEstadosPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * BarraEstadosPanel constructor comment.
	 *
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public BarraEstadosPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * connEtoC1: (TextFieldExtEstado.foreground -->
	 * BarraEstadosPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("textForeground", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (TextFieldExtEstado.font -->
	 * BarraEstadosPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* AVISO: ESTE MÉTODO SE REGENERARÁ. */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("textFont", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getText() {
		return getTextFieldExtEstado().getText();
	}

	/**
	 * Return the TextFieldExtEstado property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getTextFieldExtEstado() {
		if (ivjLabelExtEstado == null) {
			ivjLabelExtEstado = new LabelExt();
			ivjLabelExtEstado.setName("LabelExtEstado");
			//ivjLabelExtEstado.setBorder(new javax.swing.border.CompoundBorder());
			//ivjLabelExtEstado.setBackground(java.awt.Color.white);
			//ivjLabelExtEstado.setForeground(new java.awt.Color(160, 31, 79));
			ivjLabelExtEstado.setText("Mensaje de estado");
			ivjLabelExtEstado.setFont(new Font("Arial", Font.PLAIN, 11));
		}
		return ivjLabelExtEstado;
	}

	/**
	 * Método generado para soportar la promoción del atributo textFont.
	 *
	 * @return java.awt.Font
	 */
	public java.awt.Font getTextFont() {
		return getTextFieldExtEstado().getFont();
	}

	/**
	 * Method generated to support the promotion of the textForeground
	 * attribute.
	 *
	 * @return java.awt.Color
	 */
	public java.awt.Color getTextForeground() {
		return getTextFieldExtEstado().getForeground();
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
		getTextFieldExtEstado().addPropertyChangeListener(this);
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
			setSize(395, 37);

			java.awt.GridBagConstraints constraintsTextFieldExtEstado = new java.awt.GridBagConstraints();
			constraintsTextFieldExtEstado.gridx = 0;
			constraintsTextFieldExtEstado.gridy = 0;
			constraintsTextFieldExtEstado.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextFieldExtEstado.weightx = 1.0;
			constraintsTextFieldExtEstado.weighty = 1.0;
			add(getTextFieldExtEstado(), constraintsTextFieldExtEstado);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		//getTextFieldExtEstado().setFont(efren.util.FontManager.currentSystemBoldFont());
		//getTextFieldExtEstado().setForeground(new java.awt.Color(128, 64, 0));
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
		if (evt.getSource() == getTextFieldExtEstado() && (evt.getPropertyName().equals("foreground")))
			connEtoC1(evt);
		if (evt.getSource() == getTextFieldExtEstado() && (evt.getPropertyName().equals("font")))
			connEtoC2(evt);
		// user code begin {2}
		// user code end
	}

	public void setBackground(java.awt.Color c) {
		// no hacemos nada
		super.setBackground(c);
		getTextFieldExtEstado().setBackground(c);
	}

	/**
	 * Method generated to support the promotion of the text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setText(String arg1) {
		getTextFieldExtEstado().setText(arg1);
	}

	/**
	 * Método generado para soportar la promoción del atributo textFont.
	 *
	 * @param arg1
	 *            java.awt.Font
	 */
	public void setTextFont(java.awt.Font arg1) {
		getTextFieldExtEstado().setFont(arg1);
	}

	/**
	 * Method generated to support the promotion of the textForeground
	 * attribute.
	 *
	 * @param arg1
	 *            java.awt.Color
	 */
	public void setTextForeground(java.awt.Color arg1) {
		getTextFieldExtEstado().setForeground(arg1);
	}
}
