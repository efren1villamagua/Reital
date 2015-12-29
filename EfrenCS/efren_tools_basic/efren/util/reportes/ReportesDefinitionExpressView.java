package efren.util.reportes;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import efren.util.SystemLogManager;
import efren.util.WindowManager;
import efren.util.config.SystemProperties;
import efren.util.gui.LabelExt;
import efren.util.gui.ProgressBarWithThreadPanel;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.table.DataTableColumn;
import efren.util.gui.table.DataTablePanel;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListenerAdapter;

public class ReportesDefinitionExpressView extends JInternalFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 4025607319224240762L;

	private JPanel ivjJFrameContentPane = null;

	private ProgressBarWithThreadPanel ivjBarPanel = null;

	private LabelExt ivjLabelExt21 = null;

	private LabelExt ivjLabelExt6 = null;

	private TextFieldExt ivjTextFieldExtValor01 = null;

	private TextFieldExt ivjTextFieldExtValor02 = null;

	private TextFieldExt ivjTextFieldExtValor03 = null;

	private TextFieldExt ivjTextFieldExtValor04 = null;

	private TextFieldExt ivjTextFieldExtValor05 = null;

	private TextFieldExt ivjTextFieldExtValor06 = null;

	private TextFieldExt ivjTextFieldExtValor07 = null;

	private TextFieldExt ivjTextFieldExtValor08 = null;

	private TextFieldExt ivjTextFieldExtVariable01 = null;

	private TextFieldExt ivjTextFieldExtVariable02 = null;

	private TextFieldExt ivjTextFieldExtVariable03 = null;

	private TextFieldExt ivjTextFieldExtVariable04 = null;

	private TextFieldExt ivjTextFieldExtVariable05 = null;

	private TextFieldExt ivjTextFieldExtVariable06 = null;

	private TextFieldExt ivjTextFieldExtVariable07 = null;

	private TextFieldExt ivjTextFieldExtVariable08 = null;

	private JPanel ivjPageDefiniciones = null;

	private JPanel ivjPageVariables = null;

	private DetallesImpresionPanel ivjDetallesImpresionPanel1 = null;

	private DetallesPresentacionPanel ivjDetallesPresentacionPanel1 = null;

	private LabelExt ivjLabelExt = null;

	private LabelExt ivjLabelExt1 = null;

	private TextFieldExt ivjTextFieldExtTitulo1 = null;

	private TextFieldExt ivjTextFieldExtTitulo2 = null;

	private JButton jButtonImprimir = null;

	private DataTablePanel dataTablePanel = null;

	private ReportesDefinitionController controller = null;

	private JToolBar jToolBar = null;

	private Vector<ValorVariable> vavas = new Vector<ValorVariable>();

	/**
	 *
	 */
	public ReportesDefinitionExpressView() {
		super();
		initialize();
	}

	/**
	 *
	 */
	public ReportesDefinitionExpressView(String title) {
		super(title);
	}

	/**
	 *
	 */
	public void _cerrar() {
		if (InfoView.showConfirmDialog(this, "¿ Realmente desea cerrar esta ventana ?") == 0) {
			dispose();
		}
	}

	/**
	 *
	 */
	private void _buildAll() {

		Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
		Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
		textFieldsVariables.addElement(getTextFieldExtVariable01());
		textFieldsValores.addElement(getTextFieldExtValor01());
		textFieldsVariables.addElement(getTextFieldExtVariable02());
		textFieldsValores.addElement(getTextFieldExtValor02());
		textFieldsVariables.addElement(getTextFieldExtVariable03());
		textFieldsValores.addElement(getTextFieldExtValor03());
		textFieldsVariables.addElement(getTextFieldExtVariable04());
		textFieldsValores.addElement(getTextFieldExtValor04());
		textFieldsVariables.addElement(getTextFieldExtVariable05());
		textFieldsValores.addElement(getTextFieldExtValor05());
		textFieldsVariables.addElement(getTextFieldExtVariable06());
		textFieldsValores.addElement(getTextFieldExtValor06());
		textFieldsVariables.addElement(getTextFieldExtVariable07());
		textFieldsValores.addElement(getTextFieldExtValor07());
		textFieldsVariables.addElement(getTextFieldExtVariable08());
		textFieldsValores.addElement(getTextFieldExtValor08());

		DefinicionReporte definicionReporte = (DefinicionReporte) getDataTablePanel().getSelectedObject();
		/**
		 * SE COLOCA LOS VALORES QUE ACTUALMENTE ESTÁN PRESENTES EN LA PARTE
		 * VISUAL
		 */
		getDetallesPresentacionPanel1().setTitulo1(getTextFieldExtTitulo1().getValue().trim());
		getDetallesPresentacionPanel1().setTitulo2(getTextFieldExtTitulo2().getValue().trim());

		getController()._buildAll(definicionReporte, getDetallesPresentacionPanel1(), getDetallesImpresionPanel1(), textFieldsVariables, textFieldsValores);

		_stop();
	}

	/**
	 *
	 */
	private void _prePrint() {
		if (!validarParaImpresion()) {
			return;
		}
		getJButtonImprimir().setEnabled(false);
		getBarPanel().start();
		Thread aThread = new Thread(new Runnable() {
			public void run() {
				_buildAll();
			}
		});
		aThread.start();
	}

	private void _stop() {
		getBarPanel().stop();
		getJButtonImprimir().setEnabled(true);
	}

	/*
	 * public void _manejoAccesos(String unasClassArgs) { String argumentos =
	 * unasClassArgs; if (argumentos != null && argumentos.trim().indexOf("?")
	 * >= 0) { argumentos = argumentos.substring(0, argumentos.indexOf("?")); }
	 * this.subtotal_type = 1; if (argumentos != null &&
	 * argumentos.trim().length() > 0) { if (argumentos.indexOf("&") >= 0) {
	 * StringTokenizer stk1 = new StringTokenizer(argumentos.trim(), "&");
	 * this.codigoReportePorDefault = stk1.nextToken(); this.subtotal_type = new
	 * Integer(stk1.nextToken().trim()).intValue(); } else {
	 * this.codigoReportePorDefault = argumentos; } } // SE INICIALIZA EL
	 * REPORTE SELECCIONADO try { Object items[] =
	 * getObjectComboBoxDefinicion().getItems(); String item; for (int i = 0; i
	 * < items.length; i++) { item = items[i].toString(); if
	 * (item.startsWith(this.codigoReportePorDefault)) {
	 * getObjectComboBoxDefinicion().setSelectedItem(item); } }
	 * this._DEFINICION_cargar(); } catch (Exception e) { e.getMessage(); }
	 * 
	 * // ETIQUETA DE SUBTOTALES
	 * getDetallesPresentacionPanel1().setSubtotalType(this.subtotal_type); }
	 */
	/**
	 *
	 */
	private ProgressBarWithThreadPanel getBarPanel() {
		if (ivjBarPanel == null) {
			ivjBarPanel = new ProgressBarWithThreadPanel();
			ivjBarPanel.setName("BarPanel");
		}
		return ivjBarPanel;
	}

	/**
	 *
	 */
	private DetallesImpresionPanel getDetallesImpresionPanel1() {
		if (ivjDetallesImpresionPanel1 == null) {
			ivjDetallesImpresionPanel1 = new efren.util.reportes.DetallesImpresionPanel();
			ivjDetallesImpresionPanel1.setName("DetallesImpresionPanel1");
		}
		return ivjDetallesImpresionPanel1;
	}

	/**
	 *
	 */
	private DetallesPresentacionPanel getDetallesPresentacionPanel1() {
		if (ivjDetallesPresentacionPanel1 == null) {
			ivjDetallesPresentacionPanel1 = new efren.util.reportes.DetallesPresentacionPanel();
			ivjDetallesPresentacionPanel1.setName("DetallesPresentacionPanel1");
			ivjDetallesPresentacionPanel1.setExpress(true);
		}
		return ivjDetallesPresentacionPanel1;
	}

	/**
	 *
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints41.gridy = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridy = 3;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridheight = 2;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.ipadx = 100;
			gridBagConstraints.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 0.0;
			gridBagConstraints2.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints2.gridy = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints11.gridy = 0;
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			ivjJFrameContentPane.add(getDetallesPresentacionPanel1(), gridBagConstraints11);
			ivjJFrameContentPane.add(getPageDefiniciones(), gridBagConstraints);
			ivjJFrameContentPane.add(getBarPanel(), gridBagConstraints3);
			ivjJFrameContentPane.add(getJToolBar(), gridBagConstraints4);
			ivjJFrameContentPane.add(getDetallesImpresionPanel1(), gridBagConstraints41);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the Page11 property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageDefiniciones() {
		if (ivjPageDefiniciones == null) {
			try {
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				gridBagConstraints1.fill = GridBagConstraints.BOTH;
				gridBagConstraints1.gridwidth = 2;
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 5;
				gridBagConstraints1.weightx = 1.0;
				gridBagConstraints1.weighty = 1.0;
				gridBagConstraints1.gridheight = 1;
				gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
				ivjPageDefiniciones = new JPanel();
				ivjPageDefiniciones.setName("PageDefiniciones");
				ivjPageDefiniciones.setFont(new java.awt.Font("Arial", 0, 10));
				ivjPageDefiniciones.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
				constraintsLabelExt1.gridx = 1;
				constraintsLabelExt1.gridy = 7;
				constraintsLabelExt1.insets = new Insets(4, 4, 4, 0);
				java.awt.GridBagConstraints constraintsTextFieldExtTitulo1 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtTitulo1.gridx = 2;
				constraintsTextFieldExtTitulo1.gridy = 7;
				constraintsTextFieldExtTitulo1.gridwidth = 4;
				constraintsTextFieldExtTitulo1.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtTitulo1.weightx = 1.0;
				constraintsTextFieldExtTitulo1.insets = new Insets(0, 1, 0, 4);
				java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
				constraintsLabelExt.gridx = 1;
				constraintsLabelExt.gridy = 8;
				constraintsLabelExt.insets = new Insets(4, 4, 4, 0);
				java.awt.GridBagConstraints constraintsTextFieldExtTitulo2 = new java.awt.GridBagConstraints();
				constraintsTextFieldExtTitulo2.gridx = 2;
				constraintsTextFieldExtTitulo2.gridy = 8;
				constraintsTextFieldExtTitulo2.gridwidth = 4;
				constraintsTextFieldExtTitulo2.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTextFieldExtTitulo2.weightx = 1.0;
				constraintsTextFieldExtTitulo2.insets = new Insets(0, 1, 0, 4);
				java.awt.GridBagConstraints constraintsPageVariables = new java.awt.GridBagConstraints();
				constraintsPageVariables.gridx = 1;
				constraintsPageVariables.gridy = 6;
				constraintsPageVariables.gridwidth = 5;
				constraintsPageVariables.fill = java.awt.GridBagConstraints.BOTH;
				constraintsPageVariables.weightx = 1.0;
				constraintsPageVariables.weighty = 0.0;
				constraintsPageVariables.insets = new java.awt.Insets(4, 4, 4, 4);
				ivjPageDefiniciones.add(getLabelExt1(), constraintsLabelExt1);
				ivjPageDefiniciones.add(getTextFieldExtTitulo1(), constraintsTextFieldExtTitulo1);
				ivjPageDefiniciones.add(getLabelExt(), constraintsLabelExt);
				ivjPageDefiniciones.add(getTextFieldExtTitulo2(), constraintsTextFieldExtTitulo2);
				ivjPageDefiniciones.add(getPageVariables(), constraintsPageVariables);
				ivjPageDefiniciones.add(getDataTablePanel(), gridBagConstraints1);
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjPageDefiniciones;
	}

	/**
	 * Return the JFrameContentPane11 property value.
	 *
	 * @return JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JPanel getPageVariables() {
		if (ivjPageVariables == null) {
			ivjPageVariables = new JPanel();
			ivjPageVariables.setName("PageVariables");
			ivjPageVariables.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsLabelExt21 = new java.awt.GridBagConstraints();
			constraintsLabelExt21.gridx = 1;
			constraintsLabelExt21.gridy = 0;
			constraintsLabelExt21.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt21.weightx = 1.0;
			constraintsLabelExt21.weighty = 0.0;
			constraintsLabelExt21.insets = new java.awt.Insets(2, 5, 2, 5);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable01 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable01.gridx = 0;
			constraintsTextFieldExtVariable01.gridy = 1;
			constraintsTextFieldExtVariable01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable01.weightx = 1.0;
			constraintsTextFieldExtVariable01.weighty = 0.0;
			constraintsTextFieldExtVariable01.insets = new Insets(1, 5, 1, 0);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable02 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable02.gridx = 0;
			constraintsTextFieldExtVariable02.gridy = 2;
			constraintsTextFieldExtVariable02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable02.weightx = 1.0;
			constraintsTextFieldExtVariable02.weighty = 0.0;
			constraintsTextFieldExtVariable02.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getLabelExt21(), constraintsLabelExt21);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable03 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable03.gridx = 0;
			constraintsTextFieldExtVariable03.gridy = 3;
			constraintsTextFieldExtVariable03.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable03.weightx = 1.0;
			constraintsTextFieldExtVariable03.weighty = 0.0;
			constraintsTextFieldExtVariable03.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable01(), constraintsTextFieldExtVariable01);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable04 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable04.gridx = 0;
			constraintsTextFieldExtVariable04.gridy = 4;
			constraintsTextFieldExtVariable04.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable04.weightx = 1.0;
			constraintsTextFieldExtVariable04.weighty = 0.0;
			constraintsTextFieldExtVariable04.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable02(), constraintsTextFieldExtVariable02);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable05 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable05.gridx = 0;
			constraintsTextFieldExtVariable05.gridy = 5;
			constraintsTextFieldExtVariable05.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable05.weightx = 1.0;
			constraintsTextFieldExtVariable05.weighty = 0.0;
			constraintsTextFieldExtVariable05.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable03(), constraintsTextFieldExtVariable03);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable06 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable06.gridx = 0;
			constraintsTextFieldExtVariable06.gridy = 6;
			constraintsTextFieldExtVariable06.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable06.weightx = 1.0;
			constraintsTextFieldExtVariable06.weighty = 0.0;
			constraintsTextFieldExtVariable06.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable04(), constraintsTextFieldExtVariable04);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable07 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable07.gridx = 0;
			constraintsTextFieldExtVariable07.gridy = 7;
			constraintsTextFieldExtVariable07.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable07.weightx = 1.0;
			constraintsTextFieldExtVariable07.weighty = 0.0;
			constraintsTextFieldExtVariable07.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable05(), constraintsTextFieldExtVariable05);
			java.awt.GridBagConstraints constraintsTextFieldExtVariable08 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtVariable08.gridx = 0;
			constraintsTextFieldExtVariable08.gridy = 8;
			constraintsTextFieldExtVariable08.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtVariable08.weightx = 1.0;
			constraintsTextFieldExtVariable08.weighty = 0.0;
			constraintsTextFieldExtVariable08.insets = new Insets(1, 5, 1, 0);
			ivjPageVariables.add(getTextFieldExtVariable06(), constraintsTextFieldExtVariable06);
			java.awt.GridBagConstraints constraintsTextFieldExtValor01 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor01.gridx = 1;
			constraintsTextFieldExtValor01.gridy = 1;
			constraintsTextFieldExtValor01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor01.weightx = 1.0;
			constraintsTextFieldExtValor01.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtVariable07(), constraintsTextFieldExtVariable07);
			java.awt.GridBagConstraints constraintsLabelExt6 = new java.awt.GridBagConstraints();
			constraintsLabelExt6.gridx = 0;
			constraintsLabelExt6.gridy = 0;
			constraintsLabelExt6.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsLabelExt6.weightx = 1.0;
			constraintsLabelExt6.weighty = 0.0;
			constraintsLabelExt6.insets = new Insets(1, 5, 1, 5);
			ivjPageVariables.add(getTextFieldExtVariable08(), constraintsTextFieldExtVariable08);
			ivjPageVariables.add(getTextFieldExtValor01(), constraintsTextFieldExtValor01);
			java.awt.GridBagConstraints constraintsTextFieldExtValor02 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor02.gridx = 1;
			constraintsTextFieldExtValor02.gridy = 2;
			constraintsTextFieldExtValor02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor02.weightx = 1.0;
			constraintsTextFieldExtValor02.insets = new Insets(1, 0, 1, 5);
			java.awt.GridBagConstraints constraintsTextFieldExtValor03 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor03.gridx = 1;
			constraintsTextFieldExtValor03.gridy = 3;
			constraintsTextFieldExtValor03.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor03.weightx = 1.0;
			constraintsTextFieldExtValor03.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getLabelExt6(), constraintsLabelExt6);
			ivjPageVariables.add(getTextFieldExtValor02(), constraintsTextFieldExtValor02);
			java.awt.GridBagConstraints constraintsTextFieldExtValor04 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor04.gridx = 1;
			constraintsTextFieldExtValor04.gridy = 4;
			constraintsTextFieldExtValor04.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor04.weightx = 1.0;
			constraintsTextFieldExtValor04.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtValor03(), constraintsTextFieldExtValor03);
			java.awt.GridBagConstraints constraintsTextFieldExtValor05 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor05.gridx = 1;
			constraintsTextFieldExtValor05.gridy = 5;
			constraintsTextFieldExtValor05.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor05.weightx = 1.0;
			constraintsTextFieldExtValor05.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtValor04(), constraintsTextFieldExtValor04);
			java.awt.GridBagConstraints constraintsTextFieldExtValor06 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor06.gridx = 1;
			constraintsTextFieldExtValor06.gridy = 6;
			constraintsTextFieldExtValor06.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor06.weightx = 1.0;
			constraintsTextFieldExtValor06.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtValor05(), constraintsTextFieldExtValor05);
			java.awt.GridBagConstraints constraintsTextFieldExtValor07 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor07.gridx = 1;
			constraintsTextFieldExtValor07.gridy = 7;
			constraintsTextFieldExtValor07.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor07.weightx = 1.0;
			constraintsTextFieldExtValor07.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtValor06(), constraintsTextFieldExtValor06);
			java.awt.GridBagConstraints constraintsTextFieldExtValor08 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor08.gridx = 1;
			constraintsTextFieldExtValor08.gridy = 8;
			constraintsTextFieldExtValor08.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor08.weightx = 1.0;
			constraintsTextFieldExtValor08.insets = new Insets(1, 0, 1, 5);
			ivjPageVariables.add(getTextFieldExtValor07(), constraintsTextFieldExtValor07);
			ivjPageVariables.add(getTextFieldExtValor08(), constraintsTextFieldExtValor08);
		}
		return ivjPageVariables;
	}

	/**
	 * Return the LabelExt property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			ivjLabelExt = new LabelExt();
			ivjLabelExt.setName("LabelExt");
			ivjLabelExt.setText("Título02");
			ivjLabelExt.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return ivjLabelExt;
	}

	/**
	 * Return the LabelExt1 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt1() {
		if (ivjLabelExt1 == null) {
			try {
				ivjLabelExt1 = new LabelExt();
				ivjLabelExt1.setName("LabelExt1");
				ivjLabelExt1.setText("Título01");
				ivjLabelExt1.setHorizontalAlignment(SwingConstants.RIGHT);
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
	 * Return the LabelExt21 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt21() {
		if (ivjLabelExt21 == null) {
			try {
				ivjLabelExt21 = new LabelExt();
				ivjLabelExt21.setName("LabelExt21");
				ivjLabelExt21.setText("Valores");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt21;
	}

	/**
	 * Return the LabelExt6 property value.
	 *
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt6() {
		if (ivjLabelExt6 == null) {
			try {
				ivjLabelExt6 = new LabelExt();
				ivjLabelExt6.setName("LabelExt6");
				ivjLabelExt6.setText("Variables");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt6;
	}

	/**
	 * Return the TextFieldExtTitulo1 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtTitulo1() {
		if (ivjTextFieldExtTitulo1 == null) {
			try {
				ivjTextFieldExtTitulo1 = new TextFieldExt();
				ivjTextFieldExtTitulo1.setName("TextFieldExtTitulo1");
				ivjTextFieldExtTitulo1.setFocusAccelerator('d');
				ivjTextFieldExtTitulo1.setMaxLength(200);
				ivjTextFieldExtTitulo1.setValue("");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo1;
	}

	/**
	 * Return the TextFieldExtTitulo2 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtTitulo2() {
		if (ivjTextFieldExtTitulo2 == null) {
			try {
				ivjTextFieldExtTitulo2 = new TextFieldExt();
				ivjTextFieldExtTitulo2.setName("TextFieldExtTitulo2");
				ivjTextFieldExtTitulo2.setFocusAccelerator('t');
				ivjTextFieldExtTitulo2.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtTitulo2;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor01() {
		if (ivjTextFieldExtValor01 == null) {
			ivjTextFieldExtValor01 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor01.setName("TextFieldExtValor01");
			ivjTextFieldExtValor01.setMaxLength(100);
			ivjTextFieldExtValor01.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor01;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor02() {
		if (ivjTextFieldExtValor02 == null) {
			ivjTextFieldExtValor02 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor02.setName("TextFieldExtValor02");
			ivjTextFieldExtValor02.setMaxLength(100);
			ivjTextFieldExtValor02.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor02;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor03() {
		if (ivjTextFieldExtValor03 == null) {
			ivjTextFieldExtValor03 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor03.setName("TextFieldExtValor03");
			ivjTextFieldExtValor03.setMaxLength(100);
			ivjTextFieldExtValor03.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor03;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor04() {
		if (ivjTextFieldExtValor04 == null) {
			ivjTextFieldExtValor04 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor04.setName("TextFieldExtValor04");
			ivjTextFieldExtValor04.setMaxLength(100);
			ivjTextFieldExtValor04.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor04;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor05() {
		if (ivjTextFieldExtValor05 == null) {
			ivjTextFieldExtValor05 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor05.setName("TextFieldExtValor05");
			ivjTextFieldExtValor05.setMaxLength(100);
			ivjTextFieldExtValor05.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor05;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor06() {
		if (ivjTextFieldExtValor06 == null) {
			ivjTextFieldExtValor06 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor06.setName("TextFieldExtValor06");
			ivjTextFieldExtValor06.setMaxLength(100);
			ivjTextFieldExtValor06.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor06;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor07() {
		if (ivjTextFieldExtValor07 == null) {
			ivjTextFieldExtValor07 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor07.setName("TextFieldExtValor07");
			ivjTextFieldExtValor07.setMaxLength(100);
			ivjTextFieldExtValor07.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor07;
	}

	/**
	 *
	 */
	private efren.util.gui.text.TextFieldExt getTextFieldExtValor08() {
		if (ivjTextFieldExtValor08 == null) {
			ivjTextFieldExtValor08 = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtValor08.setName("TextFieldExtValor08");
			ivjTextFieldExtValor08.setMaxLength(100);
			ivjTextFieldExtValor08.addTextFieldExtListener(new TextFieldExtListenerAdapter() {
				public void actionPerformed(java.util.EventObject e) {
					saveValoresVariables();
					_prePrint();
				}

				public void focusLost(java.util.EventObject newEvent) {
					saveValoresVariables();
				}
			});
		}
		return ivjTextFieldExtValor08;
	}

	/**
	 *
	 */
	private TextFieldExt getTextFieldExtVariable01() {
		if (ivjTextFieldExtVariable01 == null) {
			ivjTextFieldExtVariable01 = new TextFieldExt();
			ivjTextFieldExtVariable01.setName("TextFieldExtVariable01");
			ivjTextFieldExtVariable01.setMaxLength(100);
			ivjTextFieldExtVariable01.setEditable(false);
			ivjTextFieldExtVariable01.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
		}
		return ivjTextFieldExtVariable01;
	}

	/**
	 * Return the TextFieldExtVariable02 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable02() {
		if (ivjTextFieldExtVariable02 == null) {
			try {
				ivjTextFieldExtVariable02 = new TextFieldExt();
				ivjTextFieldExtVariable02.setName("TextFieldExtVariable02");
				ivjTextFieldExtVariable02.setMaxLength(100);
				ivjTextFieldExtVariable02.setEditable(false);
				ivjTextFieldExtVariable02.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable02;
	}

	/**
	 * Return the TextFieldExtVariable03 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable03() {
		if (ivjTextFieldExtVariable03 == null) {
			try {
				ivjTextFieldExtVariable03 = new TextFieldExt();
				ivjTextFieldExtVariable03.setName("TextFieldExtVariable03");
				ivjTextFieldExtVariable03.setMaxLength(100);
				ivjTextFieldExtVariable03.setEditable(false);
				ivjTextFieldExtVariable03.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable03;
	}

	/**
	 * Return the TextFieldExtVariable04 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable04() {
		if (ivjTextFieldExtVariable04 == null) {
			try {
				ivjTextFieldExtVariable04 = new TextFieldExt();
				ivjTextFieldExtVariable04.setName("TextFieldExtVariable04");
				ivjTextFieldExtVariable04.setMaxLength(100);
				ivjTextFieldExtVariable04.setEditable(false);
				ivjTextFieldExtVariable04.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable04;
	}

	/**
	 * Return the TextFieldExtVariable05 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable05() {
		if (ivjTextFieldExtVariable05 == null) {
			try {
				ivjTextFieldExtVariable05 = new TextFieldExt();
				ivjTextFieldExtVariable05.setName("TextFieldExtVariable05");
				ivjTextFieldExtVariable05.setMaxLength(100);
				ivjTextFieldExtVariable05.setEditable(false);
				ivjTextFieldExtVariable05.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable05;
	}

	/**
	 * Return the TextFieldExtVariable06 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable06() {
		if (ivjTextFieldExtVariable06 == null) {
			try {
				ivjTextFieldExtVariable06 = new TextFieldExt();
				ivjTextFieldExtVariable06.setName("TextFieldExtVariable06");
				ivjTextFieldExtVariable06.setMaxLength(100);
				ivjTextFieldExtVariable06.setEditable(false);
				ivjTextFieldExtVariable06.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable06;
	}

	/**
	 * Return the TextFieldExtVariable07 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable07() {
		if (ivjTextFieldExtVariable07 == null) {
			try {
				ivjTextFieldExtVariable07 = new TextFieldExt();
				ivjTextFieldExtVariable07.setName("TextFieldExtVariable07");
				ivjTextFieldExtVariable07.setMaxLength(100);
				ivjTextFieldExtVariable07.setEditable(false);
				ivjTextFieldExtVariable07.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable07;
	}

	/**
	 * Return the TextFieldExtVariable08 property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtVariable08() {
		if (ivjTextFieldExtVariable08 == null) {
			try {
				ivjTextFieldExtVariable08 = new TextFieldExt();
				ivjTextFieldExtVariable08.setName("TextFieldExtVariable08");
				ivjTextFieldExtVariable08.setMaxLength(100);
				ivjTextFieldExtVariable08.setEditable(false);
				ivjTextFieldExtVariable08.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtVariable08;
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 *
	 */
	private void initialize() {
		setName("ReportesDefinitionExpressView");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setSize(849, 603);
		this.setTitle("Reportes tipo listado");
		setContentPane(getJFrameContentPane());
		this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
			public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
				_cerrar();
			}
		});
		initAll();
		WindowManager.centerWindow(this);
	}

	/**
	 *
	 */
	private void initAll() {
		getController().buscarForPerfil(SystemProperties.RUNTIME_PERFILOID, getDataTablePanel());
		/**
		 * SE AGREGA UNA ENTIDAD POR CADA FILA DE LA TABLA
		 */
		for (int i = 0; i < getDataTablePanel().getTableModel().getRowCount(); i++) {
			this.vavas.addElement(new ValorVariable());
		}
	}

	/**
	 *
	 */
	private boolean validarBasico() {

		if (!getDetallesImpresionPanel1().validar())
			return false;

		return getDetallesPresentacionPanel1().validar();
	}

	private boolean validarParaImpresion() {

		if (!validarBasico()) {
			return false;
		}

		return validarVariables();
	}

	private boolean validarVariables() {

		if (getTextFieldExtVariable01().getValue() != null && getTextFieldExtVariable01().getValue().trim().length() > 0
				&& getTextFieldExtVariable01().getValue().startsWith("*")) {
			if (getTextFieldExtValor01().getValue() == null || getTextFieldExtValor01().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable01().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable02().getValue() != null && getTextFieldExtVariable02().getValue().trim().length() > 0
				&& getTextFieldExtVariable02().getValue().startsWith("*")) {
			if (getTextFieldExtValor02().getValue() == null || getTextFieldExtValor02().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable02().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable03().getValue() != null && getTextFieldExtVariable03().getValue().trim().length() > 0
				&& getTextFieldExtVariable03().getValue().startsWith("*")) {
			if (getTextFieldExtValor03().getValue() == null || getTextFieldExtValor03().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable03().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable04().getValue() != null && getTextFieldExtVariable04().getValue().trim().length() > 0
				&& getTextFieldExtVariable04().getValue().startsWith("*")) {
			if (getTextFieldExtValor04().getValue() == null || getTextFieldExtValor04().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable04().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable05().getValue() != null && getTextFieldExtVariable05().getValue().trim().length() > 0
				&& getTextFieldExtVariable05().getValue().startsWith("*")) {
			if (getTextFieldExtValor05().getValue() == null || getTextFieldExtValor05().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable05().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable06().getValue() != null && getTextFieldExtVariable06().getValue().trim().length() > 0
				&& getTextFieldExtVariable06().getValue().startsWith("*")) {
			if (getTextFieldExtValor06().getValue() == null || getTextFieldExtValor06().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable06().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable07().getValue() != null && getTextFieldExtVariable07().getValue().trim().length() > 0
				&& getTextFieldExtVariable07().getValue().startsWith("*")) {
			if (getTextFieldExtValor07().getValue() == null || getTextFieldExtValor07().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable07().getValue() + " no tiene valor!");
				return false;
			}
		}
		if (getTextFieldExtVariable08().getValue() != null && getTextFieldExtVariable08().getValue().trim().length() > 0
				&& getTextFieldExtVariable08().getValue().startsWith("*")) {
			if (getTextFieldExtValor08().getValue() == null || getTextFieldExtValor08().getValue().trim().length() == 0) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡La variable " + getTextFieldExtVariable08().getValue() + " no tiene valor!");
				return false;
			}
		}
		return true;
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
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/Printer32x32.png")));
			jButtonImprimir.setText("");
			jButtonImprimir.setToolTipText("Imprimir");
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

	/**
	 * This method initializes dataTablePanel
	 *
	 * @return efren.util.gui.table.DataTablePanel
	 */
	private DataTablePanel getDataTablePanel() {
		if (dataTablePanel == null) {
			dataTablePanel = new DataTablePanel();
			dataTablePanel.setOpcionesBarButton00Visible(false);
			dataTablePanel.setOpcionesBarButton01Visible(false);
			dataTablePanel.setOpcionesBarButton02Visible(false);
			dataTablePanel.setOpcionesBarButton03Visible(false);
			dataTablePanel.setOpcionesBarButton10Visible(false);
			Vector<DataTableColumn> columnsDefinition = new Vector<DataTableColumn>();
			columnsDefinition.add(new DataTableColumn("Nombre", 260, "nombre", false, "NOMBRE"));
			columnsDefinition.add(new DataTableColumn("Título 1", 180, "titulo1", false, "TITULO1"));
			columnsDefinition.add(new DataTableColumn("Título 2", 180, "titulo2", false, "TITULO2"));
			dataTablePanel.setColumnsDefinition(DefinicionReporte.class, columnsDefinition);
			dataTablePanel.setBuscarButtonVisible(false);
			dataTablePanel.setLimpiarButtonVisible(false);
			dataTablePanel.setImprimirButtonVisible(false);
			dataTablePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("selectedObject"))) {
						loadDefinicion();
						loadValoresVariables();
					}
				}
			});
		}
		return dataTablePanel;
	}

	/**
	 *
	 */
	private void loadDefinicion() {
		try {

			DefinicionReporte definicionReporte = (DefinicionReporte) getDataTablePanel().getSelectedObject();

			getTextFieldExtTitulo1().setValue(definicionReporte.getTitulo1());
			getTextFieldExtTitulo2().setValue(definicionReporte.getTitulo2());

			Vector<TextFieldExt> textFieldsVariables = new Vector<TextFieldExt>();
			Vector<TextFieldExt> textFieldsValores = new Vector<TextFieldExt>();
			textFieldsVariables.addElement(getTextFieldExtVariable01());
			textFieldsValores.addElement(getTextFieldExtValor01());
			textFieldsVariables.addElement(getTextFieldExtVariable02());
			textFieldsValores.addElement(getTextFieldExtValor02());
			textFieldsVariables.addElement(getTextFieldExtVariable03());
			textFieldsValores.addElement(getTextFieldExtValor03());
			textFieldsVariables.addElement(getTextFieldExtVariable04());
			textFieldsValores.addElement(getTextFieldExtValor04());
			textFieldsVariables.addElement(getTextFieldExtVariable05());
			textFieldsValores.addElement(getTextFieldExtValor05());
			textFieldsVariables.addElement(getTextFieldExtVariable06());
			textFieldsValores.addElement(getTextFieldExtValor06());
			textFieldsVariables.addElement(getTextFieldExtVariable07());
			textFieldsValores.addElement(getTextFieldExtValor07());
			textFieldsVariables.addElement(getTextFieldExtVariable08());
			textFieldsValores.addElement(getTextFieldExtValor08());

			getController()._showVariables(definicionReporte, textFieldsVariables, textFieldsValores);

			getDetallesPresentacionPanel1().DEFINICION_cargarVisualmente(definicionReporte);
			getDetallesImpresionPanel1()._DEFINICION_cargar(definicionReporte);

			Vector<String> nombresColumnas = DetallesPresentacionPanel._nombresSQLColumnas(definicionReporte.getSentenciaSql());
			DetallesPresentacionPanel._construirFilasDetalle_fromSQL(getDetallesPresentacionPanel1().getTableModel(), nombresColumnas,
					definicionReporte.getDetalle());

		} catch (Throwable t) {
			SystemLogManager.error(t.getMessage());
		}
	}

	public ReportesDefinitionController getController() {
		if (this.controller == null) {
			this.controller = new ReportesDefinitionController(this, null);
		}
		return controller;
	}

	public void setController(ReportesDefinitionController controller) {
		this.controller = controller;
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
			jToolBar.add(getJButtonImprimir());
		}
		return jToolBar;
	}

	private void saveValoresVariables() {
		int index = getDataTablePanel().getSelectedRow();
		ValorVariable vava = this.vavas.elementAt(index);
		vava.variable01 = getTextFieldExtVariable01().getValue().trim();
		vava.variable02 = getTextFieldExtVariable02().getValue().trim();
		vava.variable03 = getTextFieldExtVariable03().getValue().trim();
		vava.variable04 = getTextFieldExtVariable04().getValue().trim();
		vava.variable05 = getTextFieldExtVariable05().getValue().trim();
		vava.variable06 = getTextFieldExtVariable06().getValue().trim();
		vava.variable07 = getTextFieldExtVariable07().getValue().trim();
		vava.variable08 = getTextFieldExtVariable08().getValue().trim();
		vava.valor01 = getTextFieldExtValor01().getValue().trim();
		vava.valor02 = getTextFieldExtValor02().getValue().trim();
		vava.valor03 = getTextFieldExtValor03().getValue().trim();
		vava.valor04 = getTextFieldExtValor04().getValue().trim();
		vava.valor05 = getTextFieldExtValor05().getValue().trim();
		vava.valor06 = getTextFieldExtValor06().getValue().trim();
		vava.valor07 = getTextFieldExtValor07().getValue().trim();
		vava.valor08 = getTextFieldExtValor08().getValue().trim();
	}

	private void loadValoresVariables() {
		getTextFieldExtValor01().setValue("");
		getTextFieldExtValor02().setValue("");
		getTextFieldExtValor03().setValue("");
		getTextFieldExtValor04().setValue("");
		getTextFieldExtValor05().setValue("");
		getTextFieldExtValor06().setValue("");
		getTextFieldExtValor07().setValue("");
		getTextFieldExtValor08().setValue("");
		int index = getDataTablePanel().getSelectedRow();
		ValorVariable vava = this.vavas.elementAt(index);
		getTextFieldExtValor01().setValue(vava.valor01);
		getTextFieldExtValor02().setValue(vava.valor02);
		getTextFieldExtValor03().setValue(vava.valor03);
		getTextFieldExtValor04().setValue(vava.valor04);
		getTextFieldExtValor05().setValue(vava.valor05);
		getTextFieldExtValor06().setValue(vava.valor06);
		getTextFieldExtValor07().setValue(vava.valor07);
		getTextFieldExtValor08().setValue(vava.valor08);
	}

	/**
	 *
	 */
	private class ValorVariable {
		public String variable01;

		public String variable02;

		public String variable03;

		public String variable04;

		public String variable05;

		public String variable06;

		public String variable07;

		public String variable08;

		public String valor01;

		public String valor02;

		public String valor03;

		public String valor04;

		public String valor05;

		public String valor06;

		public String valor07;

		public String valor08;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
