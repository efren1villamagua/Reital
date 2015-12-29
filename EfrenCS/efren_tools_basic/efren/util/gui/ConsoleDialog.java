package efren.util.gui;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import efren.util.config.SystemProperties;
import efren.util.gui.text.TextAreaExt;
import javax.swing.BorderFactory;
import java.awt.Insets;

public class ConsoleDialog extends JInternalFrame implements java.awt.event.ActionListener, javax.swing.event.InternalFrameListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 655890050285153000L;
	private static ConsoleDialog singleton = null;
	private Throwable currentException;  //  @jve:decl-index=0:
	private JPanel ivjJInternalFrameContentPane = null;
	private TextAreaExt ivjTextAreaExt1 = null;
	private boolean primeraVez = true;
	private JButton jButtonLimpiar = null;
	private JButton jButtonCerrar = null;
	private JToolBar jToolBar = null;

	public ConsoleDialog() {
		super();
		initialize();
	}

	public void _cerrar() {
		try {
			singleton.setSelected(false);
		} catch (java.beans.PropertyVetoException e) {
			e.getMessage();
		}
		this.setVisible(false);
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {
		this.showDialog();
	}

	public void addMessage(String s) {
		String s1 = null;
		try {
			s1 = "\n" + new efren.util.CalendarManager().getAbsoluteRegionalDateExpression() + " ==> " + s;
		} catch (Throwable t3) {
			t3.getMessage();
		}

		getTextAreaExt1().append(s1);
	}

	public void addMessage(Throwable throwable) {
		/*
		 * if (suspendCB.isSelected()) return; String s =
		 * DesignEnv.getProperty("console.exception.trace", "false"); if
		 * (s.equals("false")) { addMessage(throwable.toString()); } else {
		 * StringWriter stringwriter = new StringWriter();
		 * throwable.printStackTrace(new PrintWriter(stringwriter, true));
		 * addMessage(stringwriter.toString()); } currentException = throwable;
		 */
		/*
		 * if (suspendCB.isSelected()) return;
		 */
		addMessage(throwable.toString());
		currentException = throwable;
	}

	/**
	 * connEtoC1:
	 * (BarraAceptarCancelarPanel1.barraAceptarCancelarPanel.cancelarClicked(java.util.EventObject)
	 * --> ConsoleDialog._cerrar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
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
	 * connEtoM1:
	 * (BarraAceptarCancelarPanel1.barraAceptarCancelarPanel.aceptarClicked(java.util.EventObject)
	 * --> TextAreaExt1.value)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			getTextAreaExt1().setValue("");
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Return the JInternalFrameContentPane property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJInternalFrameContentPane() {
		if (ivjJInternalFrameContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints2.gridx = 0;
			ivjJInternalFrameContentPane = new javax.swing.JPanel();
			ivjJInternalFrameContentPane.setName("JInternalFrameContentPane");
			ivjJInternalFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsTextAreaExt1 = new java.awt.GridBagConstraints();
			constraintsTextAreaExt1.gridx = 0;
			constraintsTextAreaExt1.gridy = 0;
			constraintsTextAreaExt1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextAreaExt1.weightx = 1.0;
			constraintsTextAreaExt1.weighty = 1.0;
			constraintsTextAreaExt1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJInternalFrameContentPane().add(getTextAreaExt1(), constraintsTextAreaExt1);

			ivjJInternalFrameContentPane.add(getJToolBar(), gridBagConstraints2);
		}
		return ivjJInternalFrameContentPane;
	}

	public String getMessage() {
		return getTextAreaExt1().getValue();
	}

	/**
	 * Return the TextAreaExt1 property value.
	 *
	 * @return efren.util.gui.TextAreaExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextAreaExt getTextAreaExt1() {
		if (ivjTextAreaExt1 == null) {
			try {
				ivjTextAreaExt1 = new efren.util.gui.text.TextAreaExt();
				ivjTextAreaExt1.setName("TextAreaExt1");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextAreaExt1;
	}

	/**
	 * Called whenever the part throws an exception.
	 *
	 * @param exception
	 *            java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {

		/* Uncomment the following lines to print uncaught exceptions to stdout */
		// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
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
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("ConsoleDialog");
			setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
			setSize(571, 353);
			setTitle("Consola");
			setContentPane(getJInternalFrameContentPane());
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		this.currentException = null;
		this.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/libreta1.gif")));
		// user code end
	}

	public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
		try {
			this._cerrar();
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e) {

	}

	public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameIconified(javax.swing.event.InternalFrameEvent e) {
	}

	public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
	}

	public void show(String s) {
		/*
		 * init(); String s1 = DesignEnv.getProperty("console.show.on.error",
		 * "true"); if (s1.equals("true") && !win.getMessage().endsWith(s +
		 * "\n") && s.toLowerCase().indexOf("error") >= 0) showDialog();
		 * win.addMessage(s);
		 */
		singleton.addMessage(s);
	}

	public void show(Throwable throwable) {
		/*
		 * init(); win.addMessage(throwable); String s =
		 * DesignEnv.getProperty("console.show.on.error", "true"); if
		 * (s.equals("true")) showDialog();
		 */
		singleton.addMessage(throwable);
	}

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

	public static ConsoleDialog singleton() {
		if (singleton == null) {
			singleton = new ConsoleDialog();
		}
		return singleton;
	}

	/**
	 * This method initializes jButtonLimpiar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLimpiar() {
		if (jButtonLimpiar == null) {
			jButtonLimpiar = new JButton();
			jButtonLimpiar.setText("Limpiar");
			jButtonLimpiar.setMnemonic(KeyEvent.VK_L);
			jButtonLimpiar.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
			jButtonLimpiar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/checkin.gif")));
			jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					limpiarConsola();
				}
			});
			jButtonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonLimpiar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonLimpiar;
	}

	/**
	 * This method initializes jButtonCerrar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setText("Cerrar");
			jButtonCerrar.setMnemonic(KeyEvent.VK_C);
			jButtonCerrar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jButtonCerrar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_cancel_2.gif")));
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					_cerrar();
				}
			});
			jButtonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonCerrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonCerrar;
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonLimpiar());
			jToolBar.add(getJButtonCerrar());
		}
		return jToolBar;
	}
	/**
	 *
	 */
	private void limpiarConsola() {
		getTextAreaExt1().setValue("");
	}
}
