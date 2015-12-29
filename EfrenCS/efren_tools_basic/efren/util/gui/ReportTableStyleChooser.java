package efren.util.gui;

import efren.seguridades.gui.SystemView;
import efren.util.ExceptionManager;

import inetsoft.report.design.StyleViewer;
import inetsoft.report.style.TableStyle;

import java.awt.GridBagConstraints;

public class ReportTableStyleChooser extends RaisedPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 827052776280857854L;

	private javax.swing.JButton ivjJButton1 = null;

	private efren.util.gui.text.TextFieldExt ivjTextFieldExt1 = null;

	private inetsoft.report.style.TableStyle int_tableStyle;

	IvjEventHandler ivjEventHandler = new IvjEventHandler();

	class IvjEventHandler implements java.awt.event.ActionListener, java.awt.event.MouseListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == ReportTableStyleChooser.this.getJButton1())
				connEtoC1(e);
		};

		public void mouseClicked(java.awt.event.MouseEvent e) {
		};

		public void mouseEntered(java.awt.event.MouseEvent e) {
			if (e.getSource() == ReportTableStyleChooser.this.getJButton1())
				connEtoC2(e);
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			if (e.getSource() == ReportTableStyleChooser.this.getJButton1())
				connEtoC3(e);
		};

		public void mousePressed(java.awt.event.MouseEvent e) {
		};

		public void mouseReleased(java.awt.event.MouseEvent e) {
		};
	};

	/**
	 * FontChooser constructor comment.
	 */
	public ReportTableStyleChooser() {
		super();
		initialize();
	}

	/**
	 * FontChooser constructor comment.
	 *
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public ReportTableStyleChooser(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * FontChooser constructor comment.
	 *
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ReportTableStyleChooser(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * FontChooser constructor comment.
	 *
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ReportTableStyleChooser(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * connEtoC1: (JButton1.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> FontChooser.showFontChooser()V)
	 *
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.showTableStyleChooser();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (JButton1.mouse.mouseEntered(java.awt.event.MouseEvent) -->
	 * FontChooser.visualManageCursor(Ljava.lang.String;)V)
	 *
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageCursor("in");
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JButton1.mouse.mouseExited(java.awt.event.MouseEvent) -->
	 * FontChooser.visualManageCursor(Ljava.lang.String;)V)
	 *
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageCursor("out");
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Return the JButton1 property value.
	 *
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButton1() {
		if (ivjJButton1 == null) {
			try {
				ivjJButton1 = new javax.swing.JButton();
				ivjJButton1.setName("JButton1");
				ivjJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_tableStyle.gif")));
				ivjJButton1.setText("");
				ivjJButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButton1;
	}

	/**
	 * Insert the method's description here. Creation date: (10/10/2003
	 * 15:10:00)
	 *
	 * @return java.awt.Font
	 */
	public inetsoft.report.style.TableStyle getTableStyle() {
		return int_tableStyle;
	}

	/**
	 * Return the TextFieldExt1 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExt1() {
		if (ivjTextFieldExt1 == null) {
			try {
				ivjTextFieldExt1 = new efren.util.gui.text.TextFieldExt();
				ivjTextFieldExt1.setName("TextFieldExt1");
				ivjTextFieldExt1.setEnabled(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExt1;
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
		getJButton1().addActionListener(ivjEventHandler);
		getJButton1().addMouseListener(ivjEventHandler);
	}

	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			setName("FontChooser");
			setLayout(new java.awt.GridBagLayout());
			setSize(187, 26);

			java.awt.GridBagConstraints constraintsTextFieldExt1 = new java.awt.GridBagConstraints();
			constraintsTextFieldExt1.gridx = 0;
			constraintsTextFieldExt1.gridy = 0;
			constraintsTextFieldExt1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsTextFieldExt1.weightx = 1.0;
			constraintsTextFieldExt1.weighty = 1.0D;
			this.add(getTextFieldExt1(), constraintsTextFieldExt1);

			java.awt.GridBagConstraints constraintsJButton1 = new java.awt.GridBagConstraints();
			constraintsJButton1.gridx = 1;
			constraintsJButton1.gridy = 0;
			constraintsJButton1.fill = java.awt.GridBagConstraints.VERTICAL;
			this.add(getJButton1(), constraintsJButton1);

			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		this.setTableStyle(new inetsoft.report.style.Grid7());
		// this.add(getTextFieldExt1(), constraintsTextFieldExt1);
		// gridBagConstraints1.gridx = 0;
		// gridBagConstraints1.gridy = 0;
		// gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
		// gridBagConstraints1.weightx = 1.0D;
		// gridBagConstraints1.weighty = 1.0D;
		// this.add(getTextFieldExt1(), gridBagConstraints1);
		this.getTextFieldExt1().setEditable(false);
		// user code end
	}

	public boolean isDataMissing() {

		if (getTableStyle() == null) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Seleccione un estilo de tabla !");
			this.requestFocus();
			return true;
		}
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		if (getTableStyle() == null) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}

	public void setEnabled(boolean b) {
		getTextFieldExt1().setEnabled(b);
		getJButton1().setEnabled(b);
	}

	/**
	 * Insert the method's description here. Creation date: (10/10/2003
	 * 15:10:00)
	 *
	 * @param newFuente
	 *            java.awt.Font
	 */
	public void setTableStyle(inetsoft.report.style.TableStyle aTableStyle) {
		int_tableStyle = aTableStyle;
		// ...
		this.showTableStyleResume();
	}

	private void showTableStyleChooser() {
		TableStyle ts = StyleViewer.show(SystemView.singleton(), getTableStyle());
		this.setTableStyle(ts);
	}

	private void showTableStyleResume() {

		if (this.getTableStyle() == null) {
			getTextFieldExt1().setValue("");
			return;
		}

		String resume = this.getTableStyle().getClass().getName();

		resume = resume.substring(resume.lastIndexOf(".") + 1);

		getTextFieldExt1().setValue(resume);
	}

	private void visualManageCursor(String in_out) {
		if (in_out.compareTo("in") == 0 && getJButton1().isEnabled())
			getJButton1().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		else {
			if (in_out.compareTo("out") == 0)
				getJButton1().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		}
	}
}
