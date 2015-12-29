package efren.util.gui.table;

import inetsoft.report.StyleSheet;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import efren.util.ExceptionManager;
import efren.util.gui.LabelExt;
import efren.util.gui.ProgressBarWithThreadPanel;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextFieldExt;
import efren.util.reportes.DetallesImpresionPanel;
import efren.util.reportes.DetallesPresentacionPanel;

public class DataTableReporterView extends DialogExt {
	/**
	 *
	 */
	private static final long serialVersionUID = 6626412806709886642L;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private JPanel ivjJFrameContentPane = null;

	private JTable fieldTable = new JTable();

	private DetallesImpresionPanel ivjDetallesImpresionPanel1 = null;

	private DetallesPresentacionPanel ivjDetallesPresentacionPanel1 = null;

	private JTabbedPane ivjJTabbedPane1 = null;

	private JPanel ivjPageDetalles = null;

	private JPanel ivjPageImpresion = null;

	private LabelExt ivjLabelExt11 = null;

	private LabelExt ivjLabelExt3 = null;

	private TextFieldExt ivjTextFieldExtTitulo01 = null;

	private TextFieldExt ivjTextFieldExtTitulo02 = null;

	private ProgressBarWithThreadPanel ivjBarPanel = null;

	private JToolBar jToolBar = null;

	private JButton jButtonImprimir = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public DataTableReporterView() {
		super();
		initialize();
	}
	/**
	 *
	 */
	private void buildAll() {

		try {

			// construcción del reporte
			StyleSheet reporte = getDetallesPresentacionPanel1()._buildReport(
					null, getTable(), null, null, "", null);

			// impresión del reporte
			getDetallesImpresionPanel1()._print(reporte, getDetallesPresentacionPanel1().papelSeleccionado(), getDetallesPresentacionPanel1().esOrientacionHorizontal(),
					getDetallesPresentacionPanel1().getTitulo1().trim());

			_stop();

		} catch (Throwable t33) {
			InfoView.showErrorDialog(this, t33.getMessage());
			_stop();
		}
	}

	public void _cerrar() {
		this.dispose();
	}

	private void _prePrint() {
		if (!validar())
			return;
		getJButtonImprimir().setEnabled(false);
		getBarPanel().start();
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				buildAll();
			}
		});
		hilo.start();
	}

	private void _stop() {
		getBarPanel().stop();
		getJButtonImprimir().setEnabled(true);
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
	 * Return the ProgressBarWithThreadPanel property value.
	 *
	 * @return ProgressBarWithThreadPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ProgressBarWithThreadPanel getBarPanel() {
		if (ivjBarPanel == null) {
			try {
				ivjBarPanel = new ProgressBarWithThreadPanel();
				ivjBarPanel.setName("BarPanel");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarPanel;
	}

	/**
	 * Return the DetallesImpresionPanel1 property value.
	 *
	 * @return efren.reportes.DetallesImpresionPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DetallesImpresionPanel getDetallesImpresionPanel1() {
		if (ivjDetallesImpresionPanel1 == null) {
			try {
				ivjDetallesImpresionPanel1 = new DetallesImpresionPanel();
				ivjDetallesImpresionPanel1.setName("DetallesImpresionPanel1");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjDetallesImpresionPanel1;
	}

	/**
	 * Return the DetallesPresentacionPanel1 property value.
	 *
	 * @return efren.reportes.DetallesPresentacionPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DetallesPresentacionPanel getDetallesPresentacionPanel1() {
		if (ivjDetallesPresentacionPanel1 == null) {
			try {
				ivjDetallesPresentacionPanel1 = new DetallesPresentacionPanel();
				ivjDetallesPresentacionPanel1.setName("DetallesPresentacionPanel1");
				ivjDetallesPresentacionPanel1.setScrollPaneTableVisible(false);
				ivjDetallesPresentacionPanel1.setExpress(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjDetallesPresentacionPanel1;
	}

	/**
	 * Return the JFrameContentPane property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = 4;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridx = 0;
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJTabbedPane1 = new java.awt.GridBagConstraints();
			constraintsJTabbedPane1.gridx = 0;
			constraintsJTabbedPane1.gridy = 2;
			constraintsJTabbedPane1.gridwidth = 2;
			constraintsJTabbedPane1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTabbedPane1.weightx = 1.0;
			constraintsJTabbedPane1.weighty = 1.0;
			constraintsJTabbedPane1.insets = new java.awt.Insets(4, 4, 2, 4);
			getJFrameContentPane().add(getJTabbedPane1(), constraintsJTabbedPane1);

			java.awt.GridBagConstraints constraintsTextFieldExtTitulo01 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtTitulo01.gridx = 1;
			constraintsTextFieldExtTitulo01.gridy = 0;
			constraintsTextFieldExtTitulo01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTitulo01.weightx = 1.0;
			constraintsTextFieldExtTitulo01.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getTextFieldExtTitulo01(), constraintsTextFieldExtTitulo01);

			java.awt.GridBagConstraints constraintsLabelExt11 = new java.awt.GridBagConstraints();
			constraintsLabelExt11.gridx = 0;
			constraintsLabelExt11.gridy = 0;
			constraintsLabelExt11.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getLabelExt11(), constraintsLabelExt11);

			java.awt.GridBagConstraints constraintsTextFieldExtTitulo02 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtTitulo02.gridx = 1;
			constraintsTextFieldExtTitulo02.gridy = 1;
			constraintsTextFieldExtTitulo02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtTitulo02.weightx = 1.0;
			constraintsTextFieldExtTitulo02.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getTextFieldExtTitulo02(), constraintsTextFieldExtTitulo02);

			java.awt.GridBagConstraints constraintsLabelExt3 = new java.awt.GridBagConstraints();
			constraintsLabelExt3.gridx = 0;
			constraintsLabelExt3.gridy = 1;
			constraintsLabelExt3.insets = new java.awt.Insets(4, 4, 4, 4);
			getJFrameContentPane().add(getLabelExt3(), constraintsLabelExt3);

			java.awt.GridBagConstraints constraintsBarPanel = new java.awt.GridBagConstraints();
			constraintsBarPanel.gridx = 0;
			constraintsBarPanel.gridy = 3;
			constraintsBarPanel.gridwidth = 2;
			constraintsBarPanel.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsBarPanel.weightx = 1.0;
			constraintsBarPanel.insets = new java.awt.Insets(0, 5, 0, 5);
			getJFrameContentPane().add(getBarPanel(), constraintsBarPanel);

			ivjJFrameContentPane.add(getJToolBar(), gridBagConstraints);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the JTabbedPane1 property value.
	 *
	 * @return JTabbedPane
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JTabbedPane getJTabbedPane1() {
		if (ivjJTabbedPane1 == null) {
			ivjJTabbedPane1 = new JTabbedPane();
			ivjJTabbedPane1.setName("JTabbedPane1");
			ivjJTabbedPane1.setToolTipText("Reportes personalizados");
			ivjJTabbedPane1.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJTabbedPane1.insertTab("(4) Detalles de presentación", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_4.gif")),
					getPageDetalles(), null, 0);
			ivjJTabbedPane1.insertTab("(6) Detalles de impresión", new ImageIcon(getClass().getResource("/efren/resources/images/bar_ok_6.gif")),
					getPageImpresion(), null, 1);
			ivjJTabbedPane1.putClientProperty("pgs.isButtonStyle", Boolean.TRUE);
		}
		return ivjJTabbedPane1;
	}

	/**
	 * Return the PageDetalles property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageDetalles() {
		if (ivjPageDetalles == null) {
			try {
				ivjPageDetalles = new JPanel();
				ivjPageDetalles.setName("PageDetalles");
				ivjPageDetalles.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageDetalles.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesPresentacionPanel1 = new java.awt.GridBagConstraints();
				constraintsDetallesPresentacionPanel1.gridx = 0;
				constraintsDetallesPresentacionPanel1.gridy = 0;
				constraintsDetallesPresentacionPanel1.gridwidth = 5;
				constraintsDetallesPresentacionPanel1.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesPresentacionPanel1.weightx = 1.0;
				constraintsDetallesPresentacionPanel1.weighty = 1.0;
				constraintsDetallesPresentacionPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageDetalles().add(getDetallesPresentacionPanel1(), constraintsDetallesPresentacionPanel1);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageDetalles;
	}

	/**
	 * Return the PageImpresion property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageImpresion() {
		if (ivjPageImpresion == null) {
			try {
				ivjPageImpresion = new JPanel();
				ivjPageImpresion.setName("PageImpresion");
				ivjPageImpresion.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsDetallesImpresionPanel1 = new java.awt.GridBagConstraints();
				constraintsDetallesImpresionPanel1.gridx = 0;
				constraintsDetallesImpresionPanel1.gridy = 0;
				constraintsDetallesImpresionPanel1.fill = java.awt.GridBagConstraints.BOTH;
				constraintsDetallesImpresionPanel1.weightx = 1.0;
				constraintsDetallesImpresionPanel1.weighty = 1.0;
				constraintsDetallesImpresionPanel1.insets = new java.awt.Insets(4, 4, 4, 4);
				getPageImpresion().add(getDetallesImpresionPanel1(), constraintsDetallesImpresionPanel1);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageImpresion;
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
	 * Return the LabelExt11 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt11() {
		if (ivjLabelExt11 == null) {
			try {
				ivjLabelExt11 = new LabelExt();
				ivjLabelExt11.setName("LabelExt11");
				ivjLabelExt11.setText("Título01");
				ivjLabelExt11.setHorizontalAlignment(SwingConstants.RIGHT);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt11;
	}

	/**
	 * Return the LabelExt3 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt3() {
		if (ivjLabelExt3 == null) {
			try {
				ivjLabelExt3 = new LabelExt();
				ivjLabelExt3.setName("LabelExt3");
				ivjLabelExt3.setText("Título02");
				ivjLabelExt3.setHorizontalAlignment(SwingConstants.RIGHT);
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
	 * Gets the table property (JTable) value.
	 *
	 * @return The table property value.
	 * @see #setTable
	 */
	public JTable getTable() {
		return fieldTable;
	}

	/**
	 * Return the TextFieldExtTitulo11 property value.
	 *
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtTitulo01() {
		if (ivjTextFieldExtTitulo01 == null) {
			try {
				ivjTextFieldExtTitulo01 = new TextFieldExt();
				ivjTextFieldExtTitulo01.setName("TextFieldExtTitulo01");
				ivjTextFieldExtTitulo01.setFocusAccelerator('d');
				ivjTextFieldExtTitulo01.setMaxLength(200);
				ivjTextFieldExtTitulo01.setValue("");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo01;
	}

	/**
	 * Return the TextFieldExtTitulo21 property value.
	 *
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtTitulo02() {
		if (ivjTextFieldExtTitulo02 == null) {
			try {
				ivjTextFieldExtTitulo02 = new TextFieldExt();
				ivjTextFieldExtTitulo02.setName("TextFieldExtTitulo02");
				ivjTextFieldExtTitulo02.setFocusAccelerator('t');
				ivjTextFieldExtTitulo02.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo02;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		setName("DataTableReporterView");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(536, 453);
		setTitle("Reporte del contenido de la tabla");
		setContentPane(getJFrameContentPane());
	}
	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}
	/**
	 * Sets the table property (JTable) value.
	 *
	 * @param table
	 *            The new value for the property.
	 * @see #getTable
	 */
	public void setTable(JTable table) {
		JTable oldValue = fieldTable;
		fieldTable = table;
		firePropertyChange("table", oldValue, table);
	}

	public void setTitulo1(String s) {
		getTextFieldExtTitulo01().setValue(s);
		getDetallesPresentacionPanel1().setTitulo01(s);
	}

	public void setTitulo2(String s) {
		getTextFieldExtTitulo02().setValue(s);
		getDetallesPresentacionPanel1().setTitulo02(s);
	}

	private boolean validar() {

		getDetallesPresentacionPanel1().setTitulo01(getTextFieldExtTitulo01().getValue());
		getDetallesPresentacionPanel1().setTitulo02(getTextFieldExtTitulo02().getValue());

		if (getTextFieldExtTitulo01().isDataMissing("Ingrese un Título 1"))
			return false;
		if (getTextFieldExtTitulo02().isDataMissing("Ingrese un Título 2"))
			return false;
		if (!validarBasico())
			return false;
		return true;
	}

	private boolean validarBasico() {

		if (!getDetallesImpresionPanel1().validar())
			return false;

		return getDetallesPresentacionPanel1().validar();
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonImprimir());
		}
		return jToolBar;
	}

	/**
	 * This method initializes jButtonImprimir
	 *
	 * @return JButton
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/print.png")));
			jButtonImprimir.setText("Imprimir");
			jButtonImprimir.setMnemonic(KeyEvent.VK_I);
			jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					_prePrint();
				}
			});
			jButtonImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
					jButtonImprimir.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}
		return jButtonImprimir;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
