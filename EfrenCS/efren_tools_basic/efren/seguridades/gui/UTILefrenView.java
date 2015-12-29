package efren.seguridades.gui;

import java.awt.GridBagConstraints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.util.gui.LabelExt;

public class UTILefrenView extends javax.swing.JFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener, efren.util.gui.text.TextFieldExtListener,
		java.awt.event.MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -861063630525553038L;

	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private javax.swing.JPanel ivjJPanel1 = null;

	private efren.util.gui.LabelExt ivjLabelExt3 = null;

	//private boolean primeraVez = true;

	private efren.util.gui.LabelExt ivjLabelExt1 = null;

	//private static ChangePasswordView singleton = null;

	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel1 = null;

	private efren.util.gui.text.TextAreaExt ivjTextAreaExtConverted = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExtWord = null;

	private LabelExt stLabel = null;

	private boolean independiente = true;

	/**
	 * Constructor
	 */
	public UTILefrenView() {
		super();
		initialize();
	}
	public UTILefrenView(boolean independiente) {
		super();
		initialize();
		setIndependiente(independiente);
	}

	public void _cerrar() {
		if (isIndependiente()) {
			System.exit(0);
		} else {
			dispose();
		}
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
		if (newEvent.getSource() == getBarraAceptarCancelarPanel1())
			connEtoC3(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getTextFieldExtWord())
			connEtoC1(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformedOnTextField(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
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
	 * (TextFieldExtWord.textFieldExt.actionPerformedOnTextField(java.util.EventObject)
	 * --> UTILefrenView.convert()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.convert();
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
	 * (BarraAceptarCancelarPanel.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject)
	 * --> LogonView.cancelar()V)
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
	 * connEtoC3:
	 * (BarraAceptarCancelarPanel1.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject)
	 * --> UTILefrenView.convert()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.convert();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	private void convert() {
		String word = getTextFieldExtWord().getValue().trim();
		String wordConverted = efren.util.CoderManager.encrypt(word).trim();
		getTextAreaExtConverted().setValue(wordConverted);
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void field_keyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusGained(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusLost(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
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
				ivjBarraAceptarCancelarPanel.setButtonCancelarVisible(true);
				ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cerrar");
				ivjBarraAceptarCancelarPanel.setButtonAceptarVisible(false);
				ivjBarraAceptarCancelarPanel.setButtonAceptarText("Cambiar clave");
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
	 * Return the BarraAceptarCancelarPanel1 property value.
	 *
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelarPanel1() {
		if (ivjBarraAceptarCancelarPanel1 == null) {
			try {
				ivjBarraAceptarCancelarPanel1 = new efren.util.gui.bars.BarraAceptarCancelarPanel();
				ivjBarraAceptarCancelarPanel1.setName("BarraAceptarCancelarPanel1");
				ivjBarraAceptarCancelarPanel1.setButtonCancelarVisible(false);
				ivjBarraAceptarCancelarPanel1.setButtonAceptarVisible(true);
				ivjBarraAceptarCancelarPanel1.setButtonAceptarMnemonic(99);
				ivjBarraAceptarCancelarPanel1.setButtonAceptarText("Convert");
				ivjBarraAceptarCancelarPanel1.setButtonCancelarText("Cerrar");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarraAceptarCancelarPanel1;
	}

	/**
	 * Return the JPanel1 property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			try {
				stLabel = new LabelExt();
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				ivjJPanel1 = new javax.swing.JPanel();
				ivjJPanel1.setName("JPanel1");
				ivjJPanel1.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsLabelExt3 = new java.awt.GridBagConstraints();
				constraintsLabelExt3.gridx = 0;
				constraintsLabelExt3.gridy = 2;
				constraintsLabelExt3.anchor = java.awt.GridBagConstraints.NORTHEAST;
				constraintsLabelExt3.insets = new java.awt.Insets(5, 10, 5, 5);
				java.awt.GridBagConstraints constraintsTextFieldExtWord = new java.awt.GridBagConstraints();
				constraintsTextFieldExtWord.gridx = 1;
				constraintsTextFieldExtWord.gridy = 0;
				constraintsTextFieldExtWord.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtWord.weightx = 1.0;
				constraintsTextFieldExtWord.insets = new java.awt.Insets(5, 5, 0, 10);
				java.awt.GridBagConstraints constraintsTextAreaExtConverted = new java.awt.GridBagConstraints();
				constraintsTextAreaExtConverted.gridx = 1;
				constraintsTextAreaExtConverted.gridy = 2;
				constraintsTextAreaExtConverted.gridwidth = 4;
				constraintsTextAreaExtConverted.fill = java.awt.GridBagConstraints.BOTH;
				constraintsTextAreaExtConverted.weightx = 1.0;
				constraintsTextAreaExtConverted.weighty = 1.0;
				constraintsTextAreaExtConverted.insets = new java.awt.Insets(5, 5, 5, 10);
				java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel1 = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelarPanel1.gridx = 2;
				constraintsBarraAceptarCancelarPanel1.gridy = 0;
				constraintsBarraAceptarCancelarPanel1.insets = new java.awt.Insets(5, 5, 0, 10);
				java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
				constraintsBarraAceptarCancelarPanel.gridx = 2;
				constraintsBarraAceptarCancelarPanel.gridy = 3;
				constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
				java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
				constraintsLabelExt1.gridx = 0;
				constraintsLabelExt1.gridy = 0;
				constraintsLabelExt1.anchor = java.awt.GridBagConstraints.EAST;
				constraintsLabelExt1.insets = new java.awt.Insets(5, 10, 0, 5);
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 1;
				gridBagConstraints1.insets = new java.awt.Insets(0, 4, 10, 4);
				stLabel.setText("(word: Máximo 50 caracteres)");
				ivjJPanel1.add(getLabelExt3(), constraintsLabelExt3);
				ivjJPanel1.add(getTextFieldExtWord(), constraintsTextFieldExtWord);
				ivjJPanel1.add(getTextAreaExtConverted(), constraintsTextAreaExtConverted);
				ivjJPanel1.add(getBarraAceptarCancelarPanel1(), constraintsBarraAceptarCancelarPanel1);
				ivjJPanel1.add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
				ivjJPanel1.add(getLabelExt1(), constraintsLabelExt1);
				ivjJPanel1.add(stLabel, gridBagConstraints1);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanel1;
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
	 * Return the LabelExt1 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt1() {
		if (ivjLabelExt1 == null) {
			try {
				ivjLabelExt1 = new efren.util.gui.LabelExt();
				ivjLabelExt1.setName("LabelExt1");
				ivjLabelExt1.setDisplayedMnemonic('w');
				ivjLabelExt1.setText("word");
				ivjLabelExt1.setForeground(java.awt.Color.black);
				ivjLabelExt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt1;
	}

	/**
	 * Return the LabelExt3 property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt3() {
		if (ivjLabelExt3 == null) {
			try {
				ivjLabelExt3 = new efren.util.gui.LabelExt();
				ivjLabelExt3.setName("LabelExt3");
				ivjLabelExt3.setDisplayedMnemonic('w');
				ivjLabelExt3.setText("word converted");
				ivjLabelExt3.setForeground(java.awt.Color.black);
				ivjLabelExt3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt3;
	}

	/**
	 *
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextAreaExt getTextAreaExtConverted() {
		if (ivjTextAreaExtConverted == null) {
			try {
				ivjTextAreaExtConverted = new efren.util.gui.text.TextAreaExt();
				ivjTextAreaExtConverted.setName("TextAreaExtConverted");
				ivjTextAreaExtConverted.setSeleccionarAlRecibirElFoco(true);
				// user code begin {1}
				ivjTextAreaExtConverted.setMaxLength(5000);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextAreaExtConverted;
	}

	/**
	 * Return the TextFieldExtWord property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtWord() {
		if (ivjTextFieldExtWord == null) {
			try {
				ivjTextFieldExtWord = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExtWord.setName("TextFieldExtWord");
				ivjTextFieldExtWord.setSeleccionarAlRecibirElFoco(true);
				ivjTextFieldExtWord.setFocusAccelerator('w');
				ivjTextFieldExtWord.setMaxLength(50);
				ivjTextFieldExtWord.setAceptarKeyLikeTabKey(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtWord;
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		this.addMouseListener(this);
		// user code end
		getBarraAceptarCancelarPanel().addBarraAceptarCancelarPanelListener(this);
		getBarraAceptarCancelarPanel1().addBarraAceptarCancelarPanelListener(this);
		getTextFieldExtWord().addTextFieldExtListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			initLF();
			// user code end
			setName("UTILefrenView");
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
			setTitle("UTIL.efren");
			setSize(418, 223);
			setResizable(false);
			setContentPane(getJPanel1());
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		efren.util.WindowManager.centerWindow2(this);
		// user code end
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				_cerrar();
			}
		});
	}

	public void initLF() {
		// efren.util.lookandfeel.LookAndFeelManager.switchLookAndFeel(LookAndFeelManager.default_lf,
		// this);
	}

	public void keyReleased(java.awt.event.KeyEvent newEvent) {
	}

	/**
	 * main entrypoint - starts the part when it is run as an application
	 *
	 * @param args
	 *            java.lang.String[]
	 */
	public static void main(java.lang.String[] args) {
		try {
			try {
				UIManager.setLookAndFeel(new WindowsLookAndFeel());
			} catch (Exception e) {
				e.getMessage();
			}
			UTILefrenView aUTILefrenView;
			aUTILefrenView = new UTILefrenView();
			aUTILefrenView.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
				};
			});
			aUTILefrenView.setVisible(true);
			java.awt.Insets insets = aUTILefrenView.getInsets();
			aUTILefrenView.setSize(aUTILefrenView.getWidth() + insets.left + insets.right, aUTILefrenView.getHeight() + insets.top + insets.bottom);
			aUTILefrenView.setVisible(true);
		} catch (Throwable exception) {
			System.err.println("Exception occurred in main() of javax.swing.JFrame");
			exception.printStackTrace(System.out);
		}
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}
/*
	public void showDialog() {
		singleton.setResizable(true);
		singleton.setClosable(true);
		singleton.setMaximizable(true);
		singleton.setIconifiable(true);
		singleton.setVisible(true);
		if (this.primeraVez) {
			SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(singleton);
			this.primeraVez = false;
		}
		try {
			singleton.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
			e.getMessage();
		}
		singleton.toFront();
	}
*/
	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textDateMouseClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textFieldExtkeyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * @return the independiente
	 */
	public boolean isIndependiente() {
		return independiente;
	}

	/**
	 * @param independiente the independiente to set
	 */
	public void setIndependiente(boolean independiente) {
		this.independiente = independiente;
	}
} // @jve:decl-index=0:visual-constraint="53,40"
