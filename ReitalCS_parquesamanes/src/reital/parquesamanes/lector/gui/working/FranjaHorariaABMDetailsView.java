package reital.parquesamanes.lector.gui.working;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import efren.util.ExceptionManager;
import efren.util.MethodInvocation;
import efren.util.StringTools;
import efren.util.gui.LabelExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListener;
import reital.parquesamanes.domain.FranjaHorariaRepository;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public class FranjaHorariaABMDetailsView extends JFrame implements efren.util.gui.bars.BarraAceptarCancelarPanelListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -2855358623223880922L;

	private efren.util.gui.bars.BarraAceptarCancelarPanel ivjBarraAceptarCancelar = null;

	private javax.swing.JPanel ivjJFrameContentPane = null;

	public efren.util.abm.estados.ABMEstado abmEstado;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	public FranjaHorariaABMView mainView;

	private efren.util.abm.estados.ABMEstado fieldAbmEstado = null;

	public FranjaHoraria bo;

	private efren.util.gui.LabelExt ivjLabelExt = null;

	private efren.util.gui.LabelExt ivjLabelExt1 = null;

	private efren.util.gui.text.TextFieldExt textFieldExtNombre = null;

	private efren.util.gui.text.TextFieldExt textFieldExtCodigo = null;

	private efren.util.ABMViewObserver2 ivjobserver = null;

	private TextFieldExt textFieldExtHoraInicio = null;

	private TextFieldExt textFieldExtHoraFin = null;

	private LabelExt ivjLabelExt2 = null;

	private LabelExt ivjLabelExt21 = null;

	private TextFieldExt textFieldExtObservaciones = null;

	private LabelExt ivjLabelExt221 = null;

	private JPanel jPanelHoras = null;

	private TextFieldExt textFieldExtTotalHoras01 = null;

	private JScrollPane jScrollPane = null;

	private TextFieldExt textFieldExtTotalHoras02 = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private TextFieldExt textFieldExtTotalHoras03 = null;

	private TextFieldExt textFieldExtTotalHoras04 = null;

	private TextFieldExt textFieldExtTotalHoras05 = null;

	private TextFieldExt textFieldExtTotalHoras06 = null;

	private TextFieldExt textFieldExtTotalHoras07 = null;

	private TextFieldExt textFieldExtTotalHoras09 = null;

	private TextFieldExt textFieldExtTotalHoras08 = null;

	private TextFieldExt textFieldExtTotalHoras10 = null;

	private TextFieldExt textFieldExtTotalHoras11 = null;

	private TextFieldExt textFieldExtTotalHoras12 = null;

	private TextFieldExt textFieldExtTotalHoras13 = null;

	private TextFieldExt textFieldExtTotalHoras14 = null;

	private TextFieldExt textFieldExtTotalHoras15 = null;

	private TextFieldExt textFieldExtTotalHoras16 = null;

	private TextFieldExt textFieldExtTotalHoras17 = null;

	private TextFieldExt textFieldExtTotalHoras18 = null;

	private TextFieldExt textFieldExtTotalHoras19 = null;

	private TextFieldExt textFieldExtTotalHoras20 = null;

	private TextFieldExt textFieldExtTotalHoras21 = null;

	private TextFieldExt textFieldExtTotalHoras22 = null;

	private TextFieldExt textFieldExtTotalHoras23 = null;

	private JLabel jLabel11 = null;

	private JLabel jLabel12 = null;

	private JLabel jLabel13 = null;

	private JLabel jLabel14 = null;

	private JLabel jLabel15 = null;

	private JLabel jLabel16 = null;

	private JLabel jLabel17 = null;

	private JLabel jLabel18 = null;

	private JLabel jLabel19 = null;

	private JLabel jLabel110 = null;

	private JLabel jLabel111 = null;

	private JLabel jLabel112 = null;

	private JLabel jLabel113 = null;

	private JLabel jLabel114 = null;

	private JLabel jLabel115 = null;

	private JLabel jLabel116 = null;

	private JLabel jLabel117 = null;

	private JLabel jLabel118 = null;

	private JLabel jLabel119 = null;

	private JLabel jLabel120 = null;

	private JLabel jLabel121 = null;

	private TextFieldExt textFieldExtTotalHoras24 = null;

	private JLabel jLabel1211 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel21 = null;

	private JLabel jLabelValorPorHora01 = null;

	private JLabel jLabelValorPorHora02 = null;

	private JLabel jLabelValorPorHora03 = null;

	private JLabel jLabelValorPorHora04 = null;

	private JLabel jLabelValorPorHora05 = null;

	private JLabel jLabelValorPorHora06 = null;

	private JLabel jLabelValorPorHora07 = null;

	private JLabel jLabelValorPorHora08 = null;

	private JLabel jLabelValorPorHora09 = null;

	private JLabel jLabelValorPorHora10 = null;

	private JLabel jLabelValorPorHora11 = null;

	private JLabel jLabelValorPorHora12 = null;

	private JLabel jLabelValorPorHora13 = null;

	private JLabel jLabelValorPorHora14 = null;

	private JLabel jLabelValorPorHora15 = null;

	private JLabel jLabelValorPorHora16 = null;

	private JLabel jLabelValorPorHora17 = null;

	private JLabel jLabelValorPorHora18 = null;

	private JLabel jLabelValorPorHora19 = null;

	private JLabel jLabelValorPorHora20 = null;

	private JLabel jLabelValorPorHora21 = null;

	private JLabel jLabelValorPorHora22 = null;

	private JLabel jLabelValorPorHora23 = null;

	private JLabel jLabelValorPorHora24 = null;

	private FranjaHorariaRepository repository = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public FranjaHorariaABMDetailsView() {
		super();
		initialize();
	}

	/**
	 * SancionABMDetailsView constructor comment.
	 *
	 * @param title
	 *            java.lang.String
	 */
	public FranjaHorariaABMDetailsView(String title) {
		super(title);
	}

	public void _cerrar() throws java.rmi.RemoteException {

		/**
		 * se elimina ésta ventana del observer controlador de ventanas para que
		 * el objeto de negocio pueda ser utilizado en otra ventana de detalle
		 */
		getobserver().removeFrame(this, String.valueOf(bo.getOid()));
	}

	private void aceptar() throws Throwable {
		try {
			if (!validar())
				return;

			if (permanentUpdateBO()) {
				getobserver().removeFrame(this, String.valueOf(bo.getOid()));
				mainView.dataFetch();
			}
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, false, this, t);
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
		if (newEvent.getSource() == getBarraAceptarCancelar())
			connEtoC1(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
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
		if (newEvent.getSource() == getBarraAceptarCancelar())
			connEtoC2(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * connEtoC1:
	 * (BarraAceptarCancelar.barraAceptarCancelarPanel.aceptarClicked(
	 * java.util.EventObject) --> SancionABMDetailsView.aceptar()V)
	 *
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.aceptar();
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
	 * (BarraAceptarCancelar.barraAceptarCancelarPanel.cancelarClicked
	 * (java.util.EventObject) --> SancionABMDetailsView.cancelar()V)
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
	 *
	 * @param propertyName
	 *            java.lang.String
	 * @param oldValue
	 *            java.lang.Object
	 * @param newValue
	 *            java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Gets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 *
	 * @return The abmEstado property value.
	 * @see #setAbmEstado
	 */
	public efren.util.abm.estados.ABMEstado getAbmEstado() {
		return fieldAbmEstado;
	}

	/**
	 * Return the BarraAceptarCancelar property value.
	 *
	 * @return efren.abm.beans.BarraAceptarCancelarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.bars.BarraAceptarCancelarPanel getBarraAceptarCancelar() {
		if (ivjBarraAceptarCancelar == null) {
			try {
				ivjBarraAceptarCancelar = new efren.util.gui.bars.BarraAceptarCancelarPanel();
				ivjBarraAceptarCancelar.setName("BarraAceptarCancelar");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjBarraAceptarCancelar;
	}

	/**
	 * Return the JFrameContentPane property value.
	 *
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			GridBagConstraints gridBagConstraints210 = new GridBagConstraints();
			gridBagConstraints210.fill = GridBagConstraints.BOTH;
			gridBagConstraints210.gridy = 3;
			gridBagConstraints210.weightx = 1.0;
			gridBagConstraints210.weighty = 1.0;
			gridBagConstraints210.gridheight = 8;
			gridBagConstraints210.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints210.ipadx = 0;
			gridBagConstraints210.gridx = 4;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.anchor = GridBagConstraints.EAST;
			gridBagConstraints8.insets = new Insets(0, 0, 0, 2);
			gridBagConstraints8.gridy = 10;
			ivjLabelExt221 = new LabelExt();
			ivjLabelExt221.setForeground(new Color(0, 64, 128));
			ivjLabelExt221.setText("Observaciones:");
			ivjLabelExt221.setName("LabelExt");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.gridwidth = 3;
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.gridy = 10;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.insets = new Insets(0, 0, 0, 2);
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridy = 8;
			ivjLabelExt21 = new LabelExt();
			ivjLabelExt21.setForeground(new Color(0, 64, 128));
			ivjLabelExt21.setText("Fin:");
			ivjLabelExt21.setName("LabelExt");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(0, 0, 0, 2);
			gridBagConstraints3.gridy = 8;
			ivjLabelExt2 = new LabelExt();
			ivjLabelExt2.setForeground(new Color(0, 64, 128));
			ivjLabelExt2.setText("Inicio:");
			ivjLabelExt2.setName("LabelExt");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 3;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.ipadx = 50;
			gridBagConstraints1.gridy = 8;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.ipadx = 50;
			gridBagConstraints.gridy = 8;
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsBarraAceptarCancelar = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelar.gridx = 1;
			constraintsBarraAceptarCancelar.gridy = 11;
			constraintsBarraAceptarCancelar.anchor = GridBagConstraints.SOUTHEAST;
			constraintsBarraAceptarCancelar.weightx = 1.0;
			constraintsBarraAceptarCancelar.weighty = 0.0;
			constraintsBarraAceptarCancelar.gridwidth = 4;
			constraintsBarraAceptarCancelar.insets = new Insets(5, 5, 5, 5);
			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0;
			constraintsLabelExt1.gridy = 3;
			constraintsLabelExt1.anchor = java.awt.GridBagConstraints.EAST;
			constraintsLabelExt1.insets = new Insets(4, 10, 4, 2);
			java.awt.GridBagConstraints constraintsTextFieldExtCodigo = new java.awt.GridBagConstraints();
			constraintsTextFieldExtCodigo.gridx = 1;
			constraintsTextFieldExtCodigo.gridy = 3;
			constraintsTextFieldExtCodigo.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtCodigo.weightx = 1.0;
			constraintsTextFieldExtCodigo.weighty = 1.0;
			constraintsTextFieldExtCodigo.insets = new Insets(2, 0, 2, 10);
			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 0;
			constraintsLabelExt.gridy = 7;
			constraintsLabelExt.anchor = java.awt.GridBagConstraints.EAST;
			constraintsLabelExt.insets = new Insets(4, 10, 4, 2);
			java.awt.GridBagConstraints constraintsTextFieldExtNombre = new java.awt.GridBagConstraints();
			constraintsTextFieldExtNombre.gridx = 1;
			constraintsTextFieldExtNombre.gridy = 7;
			constraintsTextFieldExtNombre.gridwidth = 3;
			constraintsTextFieldExtNombre.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtNombre.weightx = 1.0;
			constraintsTextFieldExtNombre.weighty = 1.0;
			constraintsTextFieldExtNombre.insets = new Insets(2, 0, 2, 10);
			ivjJFrameContentPane.add(getBarraAceptarCancelar(), constraintsBarraAceptarCancelar);
			ivjJFrameContentPane.add(getLabelExt1(), constraintsLabelExt1);
			ivjJFrameContentPane.add(getTextFieldExtCodigo(), constraintsTextFieldExtCodigo);
			ivjJFrameContentPane.add(getLabelExt(), constraintsLabelExt);
			ivjJFrameContentPane.add(getTextFieldExtNombre(), constraintsTextFieldExtNombre);
			ivjJFrameContentPane.add(getTextFieldExtHoraInicio(), gridBagConstraints);
			ivjJFrameContentPane.add(getTextFieldExtHoraFin(), gridBagConstraints1);
			ivjJFrameContentPane.add(ivjLabelExt2, gridBagConstraints3);
			ivjJFrameContentPane.add(ivjLabelExt21, gridBagConstraints4);
			ivjJFrameContentPane.add(getTextFieldExtObservaciones(), gridBagConstraints7);
			ivjJFrameContentPane.add(ivjLabelExt221, gridBagConstraints8);
			ivjJFrameContentPane.add(getJScrollPane(), gridBagConstraints210);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the observer property value.
	 *
	 * @return efren.util.ABMViewObserver2
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.ABMViewObserver2 getobserver() {
		// user code begin {1}
		// user code end
		return ivjobserver;
	}

	/**
	 * Method generated to support the promotion of the observerThis attribute.
	 *
	 * @return efren.util.ABMViewObserver2
	 */
	public efren.util.ABMViewObserver2 getObserverThis() {
		return getobserver();
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return java.beans.PropertyChangeSupport
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Return the LabelExt property value.
	 *
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			try {
				ivjLabelExt = new efren.util.gui.LabelExt();
				ivjLabelExt.setName("LabelExt");
				ivjLabelExt.setText("Nombre");
				ivjLabelExt.setForeground(new java.awt.Color(0, 64, 128));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt;
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
				ivjLabelExt1.setText("Código");
				ivjLabelExt1.setForeground(new java.awt.Color(0, 64, 128));
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
	 * Return the TextFieldExtNombre property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtNombre() {
		if (textFieldExtNombre == null) {
			try {
				textFieldExtNombre = new efren.util.gui.text.TextFieldExt();
				textFieldExtNombre.setMaxLength(50);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return textFieldExtNombre;
	}

	/**
	 * Return the TextFieldExtCodigo property value.
	 *
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtCodigo() {
		if (textFieldExtCodigo == null) {
			try {
				textFieldExtCodigo = new efren.util.gui.text.TextFieldExt();
				textFieldExtCodigo.setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
				textFieldExtCodigo.setMaxLength(10);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return textFieldExtCodigo;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	public void initAll() {
		initFields();
	}

	/**
	 * Initializes connections
	 */
	private void initConnections() {
		getBarraAceptarCancelar().addBarraAceptarCancelarPanelListener(this);
	}

	private void initFields() {
		try {
			if (getAbmEstado().esNuevo()) {
				for (int i = 1; i <= 24; i++) {
					try {
						((TextFieldExt) MethodInvocation.performMethod("getTextFieldExtTotalHoras" + (i < 10 ? "0" + i : "" + i), this)).setValue(i + ".00");
					} catch (Exception exc) {
						exc.getMessage();
					}
				}
				manageAllTextTotals();
				return;
			} else {
				getTextFieldExtCodigo().setValue(bo.getCodigo().trim());
				getTextFieldExtNombre().setValue(bo.getNombre().trim());
				getTextFieldExtObservaciones().setValue(bo.getObservaciones().trim());
				String horaInicio = bo.getHoraInicio();
				StringTokenizer stk = new StringTokenizer(horaInicio, ":");
				int horaIni = Integer.parseInt(stk.nextToken().trim());
				int minIni = Integer.parseInt(stk.nextToken().trim());
				String inicio = (horaIni < 10 ? "0" + horaIni : "" + horaIni) + ":" + (minIni < 10 ? "0" + minIni : "" + minIni);
				getTextFieldExtHoraInicio().setValue(inicio);
				String horaFinal = bo.getHoraFin();
				stk = new StringTokenizer(horaFinal, ":");
				int horaFin = Integer.parseInt(stk.nextToken().trim());
				int minFin = Integer.parseInt(stk.nextToken().trim());
				String fin = (horaFin < 10 ? "0" + horaFin : "" + horaFin) + ":" + (minFin < 10 ? "0" + minFin : "" + minFin);
				getTextFieldExtHoraFin().setValue(fin);
				String tempHV = bo.getHorasValores();
				Hashtable<Integer, BigDecimal> hvht = FranjaHorariaABMDetailsView.getHorasValores(tempHV);
				for (int i = 1; i <= 24; i++) {
					try {
						((TextFieldExt) MethodInvocation.performMethod("getTextFieldExtTotalHoras" + (i < 10 ? "0" + i : "" + i), this)).setValue(
								StringTools.parseFromNumberToQuantity(new BigDecimal(hvht.get(i).doubleValue() * i).setScale(2, BigDecimal.ROUND_HALF_UP)));
					} catch (Exception exc) {
						exc.getMessage();
					}
				}
				manageAllTextTotals();

				if (getAbmEstado().esModificado()) {
					getTextFieldExtCodigo().setEnabled(false);
				} else {
					if (getAbmEstado().esEliminado() || getAbmEstado().esConsultado()) {
						getTextFieldExtCodigo().setEnabled(false);
						getTextFieldExtNombre().setEnabled(false);
						getTextFieldExtObservaciones().setEnabled(false);
						getTextFieldExtHoraInicio().setEnabled(false);
						getTextFieldExtHoraFin().setEnabled(false);
						for (int i = 1; i <= 24; i++) {
							try {
								((TextFieldExt) MethodInvocation.performMethod("getTextFieldExtTotalHoras" + (i < 10 ? "0" + i : "" + i), this))
										.setEnabled(false);
							} catch (Exception exc) {
								exc.getMessage();
							}
						}
					}
				}
			}
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		setName("FranjaHorariaABMDetailsView");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/calendar16x16.png")));
		// setSize(576, 290);
		setSize(641, 672);
		setContentPane(getJFrameContentPane());
		initConnections();
		this.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				try {
					_cerrar();
				} catch (Throwable t) {
					t.getMessage();
				}
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}
		});
		TextFieldExt tfe;
		for (int i = 1; i <= 24; i++) {
			try {
				tfe = (TextFieldExt) MethodInvocation.performMethod("getTextFieldExtTotalHoras" + (i < 10 ? "0" + i : "" + i), this);
				tfe.setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
				tfe.setKeyMask(TextFieldExt.KeyMask.KM_Numero);
				tfe.setMaxLength(6);
			} catch (Exception exc) {
				exc.getMessage();
			}
		}
		inicializarTextsEvents();
	}

	private boolean permanentUpdateBO() {
		try {
			JLabel tfe;
			String horasValores = "";
			for (int i = 1; i <= 24; i++) {
				try {
					tfe = (JLabel) MethodInvocation.performMethod("getJLabelValorPorHora" + (i < 10 ? "0" + i : "" + i), this);
					horasValores = horasValores + i + ";" + StringTools.parseFromQuantityToNumber(tfe.getText());
					if (i < 24) {
						horasValores = horasValores + "|";
					}
				} catch (Exception exc) {
					exc.getMessage();
				}
			}
			if (getAbmEstado().esNuevo()) {
				return getRepository().create(getTextFieldExtCodigo().getValue(), getTextFieldExtNombre().getValue(), getTextFieldExtHoraInicio().getValue(),
						getTextFieldExtHoraFin().getValue(), getTextFieldExtObservaciones().getValue(), horasValores);
			}
			if (getAbmEstado().esModificado()) {
				boolean resultado = getRepository().update(getTextFieldExtCodigo().getValue(), getTextFieldExtNombre().getValue(),
						getTextFieldExtHoraInicio().getValue(), getTextFieldExtHoraFin().getValue(), getTextFieldExtObservaciones().getValue(), horasValores);
				if (resultado) {
					return true;
				} else {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
			}
			if (getAbmEstado().esEliminado()) {
				boolean resultado = getRepository().delete(getTextFieldExtCodigo().getValue());
				if (resultado) {
					return true;
				} else {
					InfoView.showErrorDialog(this, "El registro ya ha sido actualizado por otro usuario. Vuelva a intentar la operación");
					return false;
				}
			}

			return true;

		} catch (Throwable t) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "ERROR: " + t.getMessage());
			return false;
		}
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 * Sets the abmEstado property (efren.abm.estados.ABMEstado) value.
	 *
	 * @param abmEstado
	 *            The new value for the property.
	 * @see #getAbmEstado
	 */
	public void setAbmEstado(efren.util.abm.estados.ABMEstado abmEstado) {
		efren.util.abm.estados.ABMEstado oldValue = fieldAbmEstado;
		fieldAbmEstado = abmEstado;
		firePropertyChange("abmEstado", oldValue, abmEstado);
	}

	/**
	 * Set the observer to a new value.
	 *
	 * @param newValue
	 *            efren.util.ABMViewObserver2
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setobserver(efren.util.ABMViewObserver2 newValue) {
		if (ivjobserver != newValue) {
			try {
				efren.util.ABMViewObserver2 oldValue = getobserver();
				ivjobserver = newValue;
				firePropertyChange("observerThis", oldValue, newValue);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		;
		// user code begin {3}
		// user code end
	}

	/**
	 * Method generated to support the promotion of the observerThis attribute.
	 *
	 * @param arg1
	 *            efren.util.ABMViewObserver2
	 */
	public void setObserverThis(efren.util.ABMViewObserver2 arg1) {
		setobserver(arg1);
	}

	private boolean validar() {
		if (getAbmEstado().esEliminado()) {
			if (InfoView.showConfirmDialog(this, "¿ Está seguro de eliminar el registro ?", "Seleccione una opción", InfoView.YES_NO_OPTION) == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			if (getTextFieldExtCodigo().isDataMissing("Ingrese un Código !"))
				return false;
			if (getTextFieldExtNombre().isDataMissing("Ingrese un nombre !"))
				return false;
			/**
			 * OJO TODO: - FALTA VALIDAR QUE SE ESCRIBAN BIEN LAS HORAS - FALTA
			 * VALIDAR QUE NO SE CRUCEN LAS HORAS
			 */
			if (getTextFieldExtHoraInicio().isDataMissing("Ingrese una combinación de hora:minuto de inicio válida !"))
				return false;
			if (getTextFieldExtHoraFin().isDataMissing("Ingrese una combinación de hora:minuto de fin válida !"))
				return false;
			if (getTextFieldExtObservaciones().isDataMissing("Ingrese las observaciones !"))
				return false;
			TextFieldExt tfe;
			for (int i = 1; i <= 24; i++) {
				try {
					tfe = (TextFieldExt) MethodInvocation.performMethod("getTextFieldExtTotalHoras" + (i < 10 ? "0" + i : "" + i), this);
					if (tfe.isDataMissing("Ingrese el valor de la hora " + i + " !")) {
						return false;
					}
				} catch (Exception exc) {
					exc.getMessage();
				}
			}

		}
		return true;
	}

	/**
	 * This method initializes textFieldExtHoraInicio
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtHoraInicio() {
		if (textFieldExtHoraInicio == null) {
			textFieldExtHoraInicio = new TextFieldExt();
			textFieldExtHoraInicio.setMaxLength(5);
		}
		return textFieldExtHoraInicio;
	}

	/**
	 * This method initializes textFieldExtHoraFin
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtHoraFin() {
		if (textFieldExtHoraFin == null) {
			textFieldExtHoraFin = new TextFieldExt();
			textFieldExtHoraFin.setMaxLength(5);
		}
		return textFieldExtHoraFin;
	}

	/**
	 * This method initializes textFieldExtObservaciones
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtObservaciones() {
		if (textFieldExtObservaciones == null) {
			textFieldExtObservaciones = new TextFieldExt();
			textFieldExtObservaciones.setMaxLength(100);
		}
		return textFieldExtObservaciones;
	}

	/**
	 *
	 */
	public static Hashtable<Integer, BigDecimal> getHorasValores(String horasValoresString) {
		if (horasValoresString == null || horasValoresString.trim().length() == 0) {
			return null;
		}
		StringTokenizer stk = new StringTokenizer(horasValoresString, "|");
		Vector<String> temp1 = new Vector<String>();
		while (stk.hasMoreElements()) {
			temp1.addElement(stk.nextToken());
		}
		Hashtable<Integer, BigDecimal> hv = new Hashtable<Integer, BigDecimal>();
		for (int i = 0; i < temp1.size(); i++) {
			stk = new StringTokenizer(temp1.elementAt(i).trim(), ";");
			hv.put(new Integer(stk.nextToken().trim()), new BigDecimal(stk.nextToken().trim()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		return hv;
	}

	/**
	 * This method initializes jPanelHoras
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelHoras() {
		if (jPanelHoras == null) {
			GridBagConstraints gridBagConstraints80 = new GridBagConstraints();
			gridBagConstraints80.gridx = 2;
			gridBagConstraints80.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints80.ipadx = 40;
			gridBagConstraints80.weightx = 1.0;
			gridBagConstraints80.gridy = 24;
			jLabelValorPorHora24 = new JLabel();
			jLabelValorPorHora24.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora24.setText("0.00");
			jLabelValorPorHora24.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora24.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora24.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints79 = new GridBagConstraints();
			gridBagConstraints79.gridx = 2;
			gridBagConstraints79.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints79.ipadx = 40;
			gridBagConstraints79.weightx = 1.0;
			gridBagConstraints79.gridy = 23;
			jLabelValorPorHora23 = new JLabel();
			jLabelValorPorHora23.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora23.setText("0.00");
			jLabelValorPorHora23.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora23.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora23.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints78 = new GridBagConstraints();
			gridBagConstraints78.gridx = 2;
			gridBagConstraints78.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints78.ipadx = 40;
			gridBagConstraints78.weightx = 1.0;
			gridBagConstraints78.gridy = 22;
			jLabelValorPorHora22 = new JLabel();
			jLabelValorPorHora22.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora22.setText("0.00");
			jLabelValorPorHora22.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora22.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora22.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints77 = new GridBagConstraints();
			gridBagConstraints77.gridx = 2;
			gridBagConstraints77.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints77.ipadx = 40;
			gridBagConstraints77.weightx = 1.0;
			gridBagConstraints77.gridy = 21;
			jLabelValorPorHora21 = new JLabel();
			jLabelValorPorHora21.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora21.setText("0.00");
			jLabelValorPorHora21.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora21.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora21.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints76 = new GridBagConstraints();
			gridBagConstraints76.gridx = 2;
			gridBagConstraints76.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints76.ipadx = 40;
			gridBagConstraints76.weightx = 1.0;
			gridBagConstraints76.gridy = 20;
			jLabelValorPorHora20 = new JLabel();
			jLabelValorPorHora20.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora20.setText("0.00");
			jLabelValorPorHora20.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora20.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora20.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints75 = new GridBagConstraints();
			gridBagConstraints75.gridx = 2;
			gridBagConstraints75.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints75.ipadx = 40;
			gridBagConstraints75.weightx = 1.0;
			gridBagConstraints75.gridy = 19;
			jLabelValorPorHora19 = new JLabel();
			jLabelValorPorHora19.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora19.setText("0.00");
			jLabelValorPorHora19.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora19.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora19.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints74 = new GridBagConstraints();
			gridBagConstraints74.gridx = 2;
			gridBagConstraints74.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints74.ipadx = 40;
			gridBagConstraints74.weightx = 1.0;
			gridBagConstraints74.gridy = 18;
			jLabelValorPorHora18 = new JLabel();
			jLabelValorPorHora18.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora18.setText("0.00");
			jLabelValorPorHora18.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora18.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora18.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints73 = new GridBagConstraints();
			gridBagConstraints73.gridx = 2;
			gridBagConstraints73.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints73.ipadx = 40;
			gridBagConstraints73.weightx = 1.0;
			gridBagConstraints73.gridy = 17;
			jLabelValorPorHora17 = new JLabel();
			jLabelValorPorHora17.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora17.setText("0.00");
			jLabelValorPorHora17.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora17.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora17.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints72 = new GridBagConstraints();
			gridBagConstraints72.gridx = 2;
			gridBagConstraints72.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints72.ipadx = 40;
			gridBagConstraints72.weightx = 1.0;
			gridBagConstraints72.gridy = 16;
			jLabelValorPorHora16 = new JLabel();
			jLabelValorPorHora16.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora16.setText("0.00");
			jLabelValorPorHora16.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora16.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora16.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.gridx = 2;
			gridBagConstraints71.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints71.ipadx = 40;
			gridBagConstraints71.weightx = 1.0;
			gridBagConstraints71.gridy = 15;
			jLabelValorPorHora15 = new JLabel();
			jLabelValorPorHora15.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora15.setText("0.00");
			jLabelValorPorHora15.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora15.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora15.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints70 = new GridBagConstraints();
			gridBagConstraints70.gridx = 2;
			gridBagConstraints70.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints70.ipadx = 40;
			gridBagConstraints70.weightx = 1.0;
			gridBagConstraints70.gridy = 14;
			jLabelValorPorHora14 = new JLabel();
			jLabelValorPorHora14.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora14.setText("0.00");
			jLabelValorPorHora14.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora14.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora14.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints69 = new GridBagConstraints();
			gridBagConstraints69.gridx = 2;
			gridBagConstraints69.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints69.ipadx = 40;
			gridBagConstraints69.weightx = 1.0;
			gridBagConstraints69.gridy = 13;
			jLabelValorPorHora13 = new JLabel();
			jLabelValorPorHora13.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora13.setText("0.00");
			jLabelValorPorHora13.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora13.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora13.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints68 = new GridBagConstraints();
			gridBagConstraints68.gridx = 2;
			gridBagConstraints68.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints68.ipadx = 40;
			gridBagConstraints68.weightx = 1.0;
			gridBagConstraints68.gridy = 12;
			jLabelValorPorHora12 = new JLabel();
			jLabelValorPorHora12.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora12.setText("0.00");
			jLabelValorPorHora12.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora12.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora12.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints67 = new GridBagConstraints();
			gridBagConstraints67.gridx = 2;
			gridBagConstraints67.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints67.ipadx = 40;
			gridBagConstraints67.weightx = 1.0;
			gridBagConstraints67.gridy = 11;
			jLabelValorPorHora11 = new JLabel();
			jLabelValorPorHora11.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora11.setText("0.00");
			jLabelValorPorHora11.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora11.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints66 = new GridBagConstraints();
			gridBagConstraints66.gridx = 2;
			gridBagConstraints66.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints66.ipadx = 40;
			gridBagConstraints66.weightx = 1.0;
			gridBagConstraints66.gridy = 10;
			jLabelValorPorHora10 = new JLabel();
			jLabelValorPorHora10.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora10.setText("0.00");
			jLabelValorPorHora10.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora10.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora10.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints65 = new GridBagConstraints();
			gridBagConstraints65.gridx = 2;
			gridBagConstraints65.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints65.ipadx = 40;
			gridBagConstraints65.weightx = 1.0;
			gridBagConstraints65.gridy = 9;
			jLabelValorPorHora09 = new JLabel();
			jLabelValorPorHora09.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora09.setText("0.00");
			jLabelValorPorHora09.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora09.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora09.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints64 = new GridBagConstraints();
			gridBagConstraints64.gridx = 2;
			gridBagConstraints64.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints64.ipadx = 40;
			gridBagConstraints64.weightx = 1.0;
			gridBagConstraints64.gridy = 8;
			jLabelValorPorHora08 = new JLabel();
			jLabelValorPorHora08.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora08.setText("0.00");
			jLabelValorPorHora08.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora08.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora08.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints63 = new GridBagConstraints();
			gridBagConstraints63.gridx = 2;
			gridBagConstraints63.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints63.ipadx = 40;
			gridBagConstraints63.weightx = 1.0;
			gridBagConstraints63.gridy = 7;
			jLabelValorPorHora07 = new JLabel();
			jLabelValorPorHora07.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora07.setText("0.00");
			jLabelValorPorHora07.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora07.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora07.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints62 = new GridBagConstraints();
			gridBagConstraints62.gridx = 2;
			gridBagConstraints62.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints62.ipadx = 40;
			gridBagConstraints62.weightx = 1.0;
			gridBagConstraints62.gridy = 6;
			jLabelValorPorHora06 = new JLabel();
			jLabelValorPorHora06.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora06.setText("0.00");
			jLabelValorPorHora06.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora06.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora06.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 2;
			gridBagConstraints61.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints61.ipadx = 40;
			gridBagConstraints61.weightx = 1.0;
			gridBagConstraints61.gridy = 5;
			jLabelValorPorHora05 = new JLabel();
			jLabelValorPorHora05.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora05.setText("0.00");
			jLabelValorPorHora05.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora05.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora05.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints60 = new GridBagConstraints();
			gridBagConstraints60.gridx = 2;
			gridBagConstraints60.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints60.ipadx = 40;
			gridBagConstraints60.weightx = 1.0;
			gridBagConstraints60.gridy = 4;
			jLabelValorPorHora04 = new JLabel();
			jLabelValorPorHora04.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora04.setText("0.00");
			jLabelValorPorHora04.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora04.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora04.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints59 = new GridBagConstraints();
			gridBagConstraints59.gridx = 2;
			gridBagConstraints59.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints59.ipadx = 40;
			gridBagConstraints59.weightx = 1.0;
			gridBagConstraints59.gridy = 3;
			jLabelValorPorHora03 = new JLabel();
			jLabelValorPorHora03.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora03.setText("0.00");
			jLabelValorPorHora03.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora03.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora03.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints58 = new GridBagConstraints();
			gridBagConstraints58.gridx = 2;
			gridBagConstraints58.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints58.ipadx = 40;
			gridBagConstraints58.weightx = 1.0;
			gridBagConstraints58.weighty = 1.0;
			gridBagConstraints58.gridy = 2;
			jLabelValorPorHora02 = new JLabel();
			jLabelValorPorHora02.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora02.setText("0.00");
			jLabelValorPorHora02.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora02.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora02.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints57 = new GridBagConstraints();
			gridBagConstraints57.gridx = 2;
			gridBagConstraints57.ipadx = 40;
			gridBagConstraints57.insets = new Insets(1, 1, 1, 5);
			gridBagConstraints57.weightx = 1.0;
			gridBagConstraints57.weighty = 1.0;
			gridBagConstraints57.gridy = 1;
			jLabelValorPorHora01 = new JLabel();
			jLabelValorPorHora01.setText("0.00");
			jLabelValorPorHora01.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelValorPorHora01.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorPorHora01.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorPorHora01.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints56 = new GridBagConstraints();
			gridBagConstraints56.gridx = 2;
			gridBagConstraints56.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints56.ipadx = 40;
			gridBagConstraints56.gridy = 0;
			jLabel21 = new JLabel();
			jLabel21.setText("Valor por hora");
			jLabel21.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabel21.setForeground(Color.red);
			GridBagConstraints gridBagConstraints55 = new GridBagConstraints();
			gridBagConstraints55.gridx = 1;
			gridBagConstraints55.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints55.gridy = 0;
			jLabel2 = new JLabel();
			jLabel2.setText("Total");
			jLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabel2.setForeground(Color.red);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints6.gridy = 24;
			jLabel1211 = new JLabel();
			jLabel1211.setText("24 horas:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.anchor = GridBagConstraints.CENTER;
			gridBagConstraints5.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.ipadx = 30;
			gridBagConstraints5.gridy = 24;
			GridBagConstraints gridBagConstraints54 = new GridBagConstraints();
			gridBagConstraints54.gridx = 0;
			gridBagConstraints54.weighty = 1.0;
			gridBagConstraints54.weightx = 0.0;
			gridBagConstraints54.anchor = GridBagConstraints.EAST;
			gridBagConstraints54.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints54.gridy = 23;
			jLabel121 = new JLabel();
			jLabel121.setText("23 horas:");
			GridBagConstraints gridBagConstraints53 = new GridBagConstraints();
			gridBagConstraints53.gridx = 0;
			gridBagConstraints53.weighty = 1.0;
			gridBagConstraints53.weightx = 0.0;
			gridBagConstraints53.anchor = GridBagConstraints.EAST;
			gridBagConstraints53.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints53.gridy = 22;
			jLabel120 = new JLabel();
			jLabel120.setText("22 horas:");
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			gridBagConstraints52.gridx = 0;
			gridBagConstraints52.weighty = 1.0;
			gridBagConstraints52.weightx = 0.0;
			gridBagConstraints52.anchor = GridBagConstraints.EAST;
			gridBagConstraints52.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints52.gridy = 21;
			jLabel119 = new JLabel();
			jLabel119.setText("21 horas:");
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 0;
			gridBagConstraints51.weighty = 1.0;
			gridBagConstraints51.weightx = 0.0;
			gridBagConstraints51.anchor = GridBagConstraints.EAST;
			gridBagConstraints51.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints51.gridy = 20;
			jLabel118 = new JLabel();
			jLabel118.setText("20 horas:");
			GridBagConstraints gridBagConstraints50 = new GridBagConstraints();
			gridBagConstraints50.gridx = 0;
			gridBagConstraints50.weighty = 1.0;
			gridBagConstraints50.weightx = 0.0;
			gridBagConstraints50.anchor = GridBagConstraints.EAST;
			gridBagConstraints50.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints50.gridy = 19;
			jLabel117 = new JLabel();
			jLabel117.setText("19 horas:");
			GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
			gridBagConstraints49.gridx = 0;
			gridBagConstraints49.weighty = 1.0;
			gridBagConstraints49.weightx = 0.0;
			gridBagConstraints49.anchor = GridBagConstraints.EAST;
			gridBagConstraints49.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints49.gridy = 18;
			jLabel116 = new JLabel();
			jLabel116.setText("18 horas:");
			GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
			gridBagConstraints48.gridx = 0;
			gridBagConstraints48.weighty = 1.0;
			gridBagConstraints48.weightx = 0.0;
			gridBagConstraints48.anchor = GridBagConstraints.EAST;
			gridBagConstraints48.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints48.gridy = 17;
			jLabel115 = new JLabel();
			jLabel115.setText("17 horas:");
			GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
			gridBagConstraints47.gridx = 0;
			gridBagConstraints47.weighty = 1.0;
			gridBagConstraints47.weightx = 0.0;
			gridBagConstraints47.anchor = GridBagConstraints.EAST;
			gridBagConstraints47.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints47.gridy = 16;
			jLabel114 = new JLabel();
			jLabel114.setText("16 horas:");
			GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
			gridBagConstraints46.gridx = 0;
			gridBagConstraints46.weighty = 1.0;
			gridBagConstraints46.weightx = 0.0;
			gridBagConstraints46.anchor = GridBagConstraints.EAST;
			gridBagConstraints46.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints46.gridy = 15;
			jLabel113 = new JLabel();
			jLabel113.setText("15 horas:");
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.gridx = 0;
			gridBagConstraints45.weighty = 1.0;
			gridBagConstraints45.weightx = 0.0;
			gridBagConstraints45.anchor = GridBagConstraints.EAST;
			gridBagConstraints45.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints45.gridy = 14;
			jLabel112 = new JLabel();
			jLabel112.setText("14 horas:");
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.gridx = 0;
			gridBagConstraints44.weighty = 1.0;
			gridBagConstraints44.weightx = 0.0;
			gridBagConstraints44.anchor = GridBagConstraints.EAST;
			gridBagConstraints44.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints44.gridy = 13;
			jLabel111 = new JLabel();
			jLabel111.setText("13 horas:");
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.gridx = 0;
			gridBagConstraints43.weighty = 1.0;
			gridBagConstraints43.weightx = 0.0;
			gridBagConstraints43.anchor = GridBagConstraints.EAST;
			gridBagConstraints43.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints43.gridy = 12;
			jLabel110 = new JLabel();
			jLabel110.setText("12 horas:");
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.gridx = 0;
			gridBagConstraints42.weighty = 1.0;
			gridBagConstraints42.weightx = 0.0;
			gridBagConstraints42.anchor = GridBagConstraints.EAST;
			gridBagConstraints42.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints42.gridy = 11;
			jLabel19 = new JLabel();
			jLabel19.setText("11 horas:");
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.weighty = 1.0;
			gridBagConstraints41.weightx = 0.0;
			gridBagConstraints41.anchor = GridBagConstraints.EAST;
			gridBagConstraints41.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints41.gridy = 10;
			jLabel18 = new JLabel();
			jLabel18.setText("10 horas:");
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 0;
			gridBagConstraints40.weighty = 1.0;
			gridBagConstraints40.weightx = 0.0;
			gridBagConstraints40.anchor = GridBagConstraints.EAST;
			gridBagConstraints40.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints40.gridy = 9;
			jLabel17 = new JLabel();
			jLabel17.setText("9 horas:");
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.gridx = 0;
			gridBagConstraints39.weighty = 1.0;
			gridBagConstraints39.weightx = 0.0;
			gridBagConstraints39.anchor = GridBagConstraints.EAST;
			gridBagConstraints39.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints39.gridy = 8;
			jLabel16 = new JLabel();
			jLabel16.setText("8 horas:");
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 0;
			gridBagConstraints38.weighty = 1.0;
			gridBagConstraints38.weightx = 0.0;
			gridBagConstraints38.anchor = GridBagConstraints.EAST;
			gridBagConstraints38.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints38.gridy = 7;
			jLabel15 = new JLabel();
			jLabel15.setText("7 horas:");
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 0;
			gridBagConstraints37.weighty = 1.0;
			gridBagConstraints37.weightx = 0.0;
			gridBagConstraints37.anchor = GridBagConstraints.EAST;
			gridBagConstraints37.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints37.gridy = 6;
			jLabel14 = new JLabel();
			jLabel14.setText("6 horas:");
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.gridx = 0;
			gridBagConstraints36.weighty = 1.0;
			gridBagConstraints36.weightx = 0.0;
			gridBagConstraints36.anchor = GridBagConstraints.EAST;
			gridBagConstraints36.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints36.gridy = 5;
			jLabel13 = new JLabel();
			jLabel13.setText("5 horas:");
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 0;
			gridBagConstraints35.weighty = 1.0;
			gridBagConstraints35.weightx = 0.0;
			gridBagConstraints35.anchor = GridBagConstraints.EAST;
			gridBagConstraints35.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints35.gridy = 4;
			jLabel12 = new JLabel();
			jLabel12.setText("4 horas:");
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.gridx = 0;
			gridBagConstraints34.weighty = 1.0;
			gridBagConstraints34.weightx = 0.0;
			gridBagConstraints34.anchor = GridBagConstraints.EAST;
			gridBagConstraints34.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints34.gridy = 3;
			jLabel11 = new JLabel();
			jLabel11.setText("3 horas:");
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 1;
			gridBagConstraints33.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints33.weightx = 1.0;
			gridBagConstraints33.weighty = 1.0;
			gridBagConstraints33.ipadx = 30;
			gridBagConstraints33.anchor = GridBagConstraints.CENTER;
			gridBagConstraints33.gridy = 23;
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 1;
			gridBagConstraints32.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints32.weightx = 1.0;
			gridBagConstraints32.weighty = 1.0;
			gridBagConstraints32.ipadx = 30;
			gridBagConstraints32.anchor = GridBagConstraints.CENTER;
			gridBagConstraints32.gridy = 22;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints31.weightx = 1.0;
			gridBagConstraints31.weighty = 1.0;
			gridBagConstraints31.ipadx = 30;
			gridBagConstraints31.anchor = GridBagConstraints.CENTER;
			gridBagConstraints31.gridy = 21;
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.gridx = 1;
			gridBagConstraints30.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints30.weightx = 1.0;
			gridBagConstraints30.weighty = 1.0;
			gridBagConstraints30.ipadx = 30;
			gridBagConstraints30.anchor = GridBagConstraints.CENTER;
			gridBagConstraints30.gridy = 20;
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 1;
			gridBagConstraints29.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints29.weightx = 1.0;
			gridBagConstraints29.weighty = 1.0;
			gridBagConstraints29.ipadx = 30;
			gridBagConstraints29.anchor = GridBagConstraints.CENTER;
			gridBagConstraints29.gridy = 19;
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 1;
			gridBagConstraints28.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints28.weightx = 1.0;
			gridBagConstraints28.weighty = 1.0;
			gridBagConstraints28.ipadx = 30;
			gridBagConstraints28.anchor = GridBagConstraints.CENTER;
			gridBagConstraints28.gridy = 18;
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 1;
			gridBagConstraints27.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints27.weightx = 1.0;
			gridBagConstraints27.weighty = 1.0;
			gridBagConstraints27.ipadx = 30;
			gridBagConstraints27.anchor = GridBagConstraints.CENTER;
			gridBagConstraints27.gridy = 17;
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 1;
			gridBagConstraints26.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints26.weightx = 1.0;
			gridBagConstraints26.weighty = 1.0;
			gridBagConstraints26.ipadx = 30;
			gridBagConstraints26.anchor = GridBagConstraints.CENTER;
			gridBagConstraints26.gridy = 16;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 1;
			gridBagConstraints25.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints25.weightx = 1.0;
			gridBagConstraints25.weighty = 1.0;
			gridBagConstraints25.ipadx = 30;
			gridBagConstraints25.anchor = GridBagConstraints.CENTER;
			gridBagConstraints25.gridy = 15;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 1;
			gridBagConstraints24.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.weighty = 1.0;
			gridBagConstraints24.ipadx = 30;
			gridBagConstraints24.anchor = GridBagConstraints.CENTER;
			gridBagConstraints24.gridy = 14;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 1;
			gridBagConstraints23.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints23.weightx = 1.0;
			gridBagConstraints23.weighty = 1.0;
			gridBagConstraints23.ipadx = 30;
			gridBagConstraints23.anchor = GridBagConstraints.CENTER;
			gridBagConstraints23.gridy = 13;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 1;
			gridBagConstraints22.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints22.weightx = 1.0;
			gridBagConstraints22.weighty = 1.0;
			gridBagConstraints22.ipadx = 30;
			gridBagConstraints22.anchor = GridBagConstraints.CENTER;
			gridBagConstraints22.gridy = 12;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.weighty = 1.0;
			gridBagConstraints21.ipadx = 30;
			gridBagConstraints21.anchor = GridBagConstraints.CENTER;
			gridBagConstraints21.gridy = 11;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 1;
			gridBagConstraints20.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints20.weightx = 1.0;
			gridBagConstraints20.weighty = 1.0;
			gridBagConstraints20.ipadx = 30;
			gridBagConstraints20.anchor = GridBagConstraints.CENTER;
			gridBagConstraints20.gridy = 10;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 1;
			gridBagConstraints19.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints19.anchor = GridBagConstraints.CENTER;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.weighty = 1.0;
			gridBagConstraints19.ipadx = 30;
			gridBagConstraints19.gridy = 9;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.anchor = GridBagConstraints.WEST;
			gridBagConstraints17.gridx = -1;
			gridBagConstraints17.gridy = -1;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.weighty = 1.0;
			gridBagConstraints17.insets = new Insets(1, 1, 1, 1);
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 1;
			gridBagConstraints18.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.weighty = 1.0;
			gridBagConstraints18.anchor = GridBagConstraints.CENTER;
			gridBagConstraints18.ipadx = 30;
			gridBagConstraints18.gridy = 8;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 1;
			gridBagConstraints16.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints16.anchor = GridBagConstraints.CENTER;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.weighty = 1.0;
			gridBagConstraints16.ipadx = 30;
			gridBagConstraints16.gridy = 7;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 1;
			gridBagConstraints15.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.weighty = 1.0;
			gridBagConstraints15.anchor = GridBagConstraints.CENTER;
			gridBagConstraints15.ipadx = 30;
			gridBagConstraints15.gridy = 6;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.weighty = 1.0;
			gridBagConstraints14.anchor = GridBagConstraints.CENTER;
			gridBagConstraints14.ipadx = 30;
			gridBagConstraints14.gridy = 5;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 1;
			gridBagConstraints13.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.anchor = GridBagConstraints.CENTER;
			gridBagConstraints13.ipadx = 30;
			gridBagConstraints13.gridy = 4;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.weighty = 1.0;
			gridBagConstraints12.anchor = GridBagConstraints.CENTER;
			gridBagConstraints12.ipadx = 30;
			gridBagConstraints12.gridy = 3;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints11.weightx = 0.0;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("2 horas:");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.insets = new Insets(1, 5, 1, 1);
			gridBagConstraints10.weightx = 0.0;
			gridBagConstraints10.anchor = GridBagConstraints.EAST;
			gridBagConstraints10.weighty = 1.0;
			gridBagConstraints10.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("1 hora:");
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints9.ipadx = 30;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.weighty = 1.0;
			gridBagConstraints9.anchor = GridBagConstraints.CENTER;
			gridBagConstraints9.gridy = 2;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints2.ipadx = 30;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.anchor = GridBagConstraints.CENTER;
			gridBagConstraints2.gridy = 1;
			jPanelHoras = new JPanel();
			jPanelHoras.setLayout(new GridBagLayout());
			jPanelHoras.add(getTextFieldExtTotalHoras01(), gridBagConstraints2);
			jPanelHoras.add(getTextFieldExtTotalHoras02(), gridBagConstraints9);
			jPanelHoras.add(jLabel, gridBagConstraints10);
			jPanelHoras.add(jLabel1, gridBagConstraints11);
			jPanelHoras.add(getTextFieldExtTotalHoras03(), gridBagConstraints12);
			jPanelHoras.add(getTextFieldExtTotalHoras04(), gridBagConstraints13);
			jPanelHoras.add(getTextFieldExtTotalHoras05(), gridBagConstraints14);
			jPanelHoras.add(getTextFieldExtTotalHoras06(), gridBagConstraints15);
			jPanelHoras.add(getTextFieldExtTotalHoras07(), gridBagConstraints16);
			jPanelHoras.add(getTextFieldExtTotalHoras08(), gridBagConstraints18);
			jPanelHoras.add(getTextFieldExtTotalHoras09(), gridBagConstraints19);
			jPanelHoras.add(getTextFieldExtTotalHoras10(), gridBagConstraints20);
			jPanelHoras.add(getTextFieldExtTotalHoras11(), gridBagConstraints21);
			jPanelHoras.add(getTextFieldExtTotalHoras12(), gridBagConstraints22);
			jPanelHoras.add(getTextFieldExtTotalHoras13(), gridBagConstraints23);
			jPanelHoras.add(getTextFieldExtTotalHoras14(), gridBagConstraints24);
			jPanelHoras.add(getTextFieldExtTotalHoras15(), gridBagConstraints25);
			jPanelHoras.add(getTextFieldExtTotalHoras16(), gridBagConstraints26);
			jPanelHoras.add(getTextFieldExtTotalHoras17(), gridBagConstraints27);
			jPanelHoras.add(getTextFieldExtTotalHoras18(), gridBagConstraints28);
			jPanelHoras.add(getTextFieldExtTotalHoras19(), gridBagConstraints29);
			jPanelHoras.add(getTextFieldExtTotalHoras20(), gridBagConstraints30);
			jPanelHoras.add(getTextFieldExtTotalHoras21(), gridBagConstraints31);
			jPanelHoras.add(getTextFieldExtTotalHoras22(), gridBagConstraints32);
			jPanelHoras.add(getTextFieldExtTotalHoras23(), gridBagConstraints33);
			jPanelHoras.add(jLabel11, gridBagConstraints34);
			jPanelHoras.add(jLabel12, gridBagConstraints35);
			jPanelHoras.add(jLabel13, gridBagConstraints36);
			jPanelHoras.add(jLabel14, gridBagConstraints37);
			jPanelHoras.add(jLabel15, gridBagConstraints38);
			jPanelHoras.add(jLabel16, gridBagConstraints39);
			jPanelHoras.add(jLabel17, gridBagConstraints40);
			jPanelHoras.add(jLabel18, gridBagConstraints41);
			jPanelHoras.add(jLabel19, gridBagConstraints42);
			jPanelHoras.add(jLabel110, gridBagConstraints43);
			jPanelHoras.add(jLabel111, gridBagConstraints44);
			jPanelHoras.add(jLabel112, gridBagConstraints45);
			jPanelHoras.add(jLabel113, gridBagConstraints46);
			jPanelHoras.add(jLabel114, gridBagConstraints47);
			jPanelHoras.add(jLabel115, gridBagConstraints48);
			jPanelHoras.add(jLabel116, gridBagConstraints49);
			jPanelHoras.add(jLabel117, gridBagConstraints50);
			jPanelHoras.add(jLabel118, gridBagConstraints51);
			jPanelHoras.add(jLabel119, gridBagConstraints52);
			jPanelHoras.add(jLabel120, gridBagConstraints53);
			jPanelHoras.add(jLabel121, gridBagConstraints54);
			jPanelHoras.add(getTextFieldExtTotalHoras24(), gridBagConstraints5);
			jPanelHoras.add(jLabel1211, gridBagConstraints6);
			jPanelHoras.add(jLabel2, gridBagConstraints55);
			jPanelHoras.add(jLabel21,
					new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel21.setHorizontalTextPosition(SwingConstants.RIGHT);
			jPanelHoras.add(jLabelValorPorHora01, gridBagConstraints57);
			jPanelHoras.add(jLabelValorPorHora02, gridBagConstraints58);
			jPanelHoras.add(jLabelValorPorHora03, gridBagConstraints59);
			jPanelHoras.add(jLabelValorPorHora04, gridBagConstraints60);
			jPanelHoras.add(jLabelValorPorHora05, gridBagConstraints61);
			jPanelHoras.add(jLabelValorPorHora06, gridBagConstraints62);
			jPanelHoras.add(jLabelValorPorHora07, gridBagConstraints63);
			jPanelHoras.add(jLabelValorPorHora08, gridBagConstraints64);
			jPanelHoras.add(jLabelValorPorHora09, gridBagConstraints65);
			jPanelHoras.add(jLabelValorPorHora10, gridBagConstraints66);
			jPanelHoras.add(jLabelValorPorHora11, gridBagConstraints67);
			jPanelHoras.add(jLabelValorPorHora12, gridBagConstraints68);
			jPanelHoras.add(jLabelValorPorHora13, gridBagConstraints69);
			jPanelHoras.add(jLabelValorPorHora14, gridBagConstraints70);
			jPanelHoras.add(jLabelValorPorHora15, gridBagConstraints71);
			jPanelHoras.add(jLabelValorPorHora16, gridBagConstraints72);
			jPanelHoras.add(jLabelValorPorHora17, gridBagConstraints73);
			jPanelHoras.add(jLabelValorPorHora18, gridBagConstraints74);
			jPanelHoras.add(jLabelValorPorHora19, gridBagConstraints75);
			jPanelHoras.add(jLabelValorPorHora20, gridBagConstraints76);
			jPanelHoras.add(jLabelValorPorHora21, gridBagConstraints77);
			jPanelHoras.add(jLabelValorPorHora22, gridBagConstraints78);
			jPanelHoras.add(jLabelValorPorHora23, gridBagConstraints79);
			jPanelHoras.add(jLabelValorPorHora24, gridBagConstraints80);
		}
		return jPanelHoras;
	}

	/**
	 * This method initializes textFieldExtTotalHoras01
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras01() {
		if (textFieldExtTotalHoras01 == null) {
			textFieldExtTotalHoras01 = new TextFieldExt();
		}
		return textFieldExtTotalHoras01;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Tarifario",
					TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jScrollPane.setViewportView(getJPanelHoras());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes textFieldExtTotalHoras02
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras02() {
		if (textFieldExtTotalHoras02 == null) {
			textFieldExtTotalHoras02 = new TextFieldExt();
		}
		return textFieldExtTotalHoras02;
	}

	/**
	 * This method initializes textFieldExtTotalHoras03
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras03() {
		if (textFieldExtTotalHoras03 == null) {
			textFieldExtTotalHoras03 = new TextFieldExt();
		}
		return textFieldExtTotalHoras03;
	}

	/**
	 * This method initializes textFieldExtTotalHoras04
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras04() {
		if (textFieldExtTotalHoras04 == null) {
			textFieldExtTotalHoras04 = new TextFieldExt();
		}
		return textFieldExtTotalHoras04;
	}

	/**
	 * This method initializes textFieldExtTotalHoras05
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras05() {
		if (textFieldExtTotalHoras05 == null) {
			textFieldExtTotalHoras05 = new TextFieldExt();
		}
		return textFieldExtTotalHoras05;
	}

	/**
	 * This method initializes textFieldExtTotalHoras06
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras06() {
		if (textFieldExtTotalHoras06 == null) {
			textFieldExtTotalHoras06 = new TextFieldExt();
		}
		return textFieldExtTotalHoras06;
	}

	/**
	 * This method initializes textFieldExtTotalHoras07
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras07() {
		if (textFieldExtTotalHoras07 == null) {
			textFieldExtTotalHoras07 = new TextFieldExt();
		}
		return textFieldExtTotalHoras07;
	}

	/**
	 * This method initializes textFieldExtTotalHoras08
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras08() {
		if (textFieldExtTotalHoras08 == null) {
			textFieldExtTotalHoras08 = new TextFieldExt();
		}
		return textFieldExtTotalHoras08;
	}

	/**
	 * This method initializes textFieldExtTotalHoras09
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras09() {
		if (textFieldExtTotalHoras09 == null) {
			textFieldExtTotalHoras09 = new TextFieldExt();
		}
		return textFieldExtTotalHoras09;
	}

	/**
	 * This method initializes textFieldExtTotalHoras10
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras10() {
		if (textFieldExtTotalHoras10 == null) {
			textFieldExtTotalHoras10 = new TextFieldExt();
		}
		return textFieldExtTotalHoras10;
	}

	/**
	 * This method initializes textFieldExtTotalHoras11
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras11() {
		if (textFieldExtTotalHoras11 == null) {
			textFieldExtTotalHoras11 = new TextFieldExt();
		}
		return textFieldExtTotalHoras11;
	}

	/**
	 * This method initializes textFieldExtTotalHoras12
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras12() {
		if (textFieldExtTotalHoras12 == null) {
			textFieldExtTotalHoras12 = new TextFieldExt();
		}
		return textFieldExtTotalHoras12;
	}

	/**
	 * This method initializes textFieldExtTotalHoras13
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras13() {
		if (textFieldExtTotalHoras13 == null) {
			textFieldExtTotalHoras13 = new TextFieldExt();
		}
		return textFieldExtTotalHoras13;
	}

	/**
	 * This method initializes textFieldExtTotalHoras14
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras14() {
		if (textFieldExtTotalHoras14 == null) {
			textFieldExtTotalHoras14 = new TextFieldExt();
		}
		return textFieldExtTotalHoras14;
	}

	/**
	 * This method initializes textFieldExtTotalHoras15
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras15() {
		if (textFieldExtTotalHoras15 == null) {
			textFieldExtTotalHoras15 = new TextFieldExt();
		}
		return textFieldExtTotalHoras15;
	}

	/**
	 * This method initializes textFieldExtTotalHoras16
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras16() {
		if (textFieldExtTotalHoras16 == null) {
			textFieldExtTotalHoras16 = new TextFieldExt();
		}
		return textFieldExtTotalHoras16;
	}

	/**
	 * This method initializes textFieldExtTotalHoras17
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras17() {
		if (textFieldExtTotalHoras17 == null) {
			textFieldExtTotalHoras17 = new TextFieldExt();
		}
		return textFieldExtTotalHoras17;
	}

	/**
	 * This method initializes textFieldExtTotalHoras18
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras18() {
		if (textFieldExtTotalHoras18 == null) {
			textFieldExtTotalHoras18 = new TextFieldExt();
		}
		return textFieldExtTotalHoras18;
	}

	/**
	 * This method initializes textFieldExtTotalHoras19
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras19() {
		if (textFieldExtTotalHoras19 == null) {
			textFieldExtTotalHoras19 = new TextFieldExt();
		}
		return textFieldExtTotalHoras19;
	}

	/**
	 * This method initializes textFieldExtTotalHoras20
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras20() {
		if (textFieldExtTotalHoras20 == null) {
			textFieldExtTotalHoras20 = new TextFieldExt();
		}
		return textFieldExtTotalHoras20;
	}

	/**
	 * This method initializes textFieldExtTotalHoras21
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras21() {
		if (textFieldExtTotalHoras21 == null) {
			textFieldExtTotalHoras21 = new TextFieldExt();
		}
		return textFieldExtTotalHoras21;
	}

	/**
	 * This method initializes textFieldExtTotalHoras22
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras22() {
		if (textFieldExtTotalHoras22 == null) {
			textFieldExtTotalHoras22 = new TextFieldExt();
		}
		return textFieldExtTotalHoras22;
	}

	/**
	 * This method initializes textFieldExtTotalHoras23
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras23() {
		if (textFieldExtTotalHoras23 == null) {
			textFieldExtTotalHoras23 = new TextFieldExt();
		}
		return textFieldExtTotalHoras23;
	}

	/**
	 * This method initializes textFieldExtTotalHoras24
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	public TextFieldExt getTextFieldExtTotalHoras24() {
		if (textFieldExtTotalHoras24 == null) {
			textFieldExtTotalHoras24 = new TextFieldExt();
		}
		return textFieldExtTotalHoras24;
	}

	private void inicializarTextsEvents() {
		// 01
		getTextFieldExtTotalHoras01().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal01();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 02
		getTextFieldExtTotalHoras02().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal02();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 03
		getTextFieldExtTotalHoras03().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal03();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 04
		getTextFieldExtTotalHoras04().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal04();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 05
		getTextFieldExtTotalHoras05().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal05();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 06
		getTextFieldExtTotalHoras06().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal06();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 07
		getTextFieldExtTotalHoras07().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal07();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 08
		getTextFieldExtTotalHoras08().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal08();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 09
		getTextFieldExtTotalHoras09().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal09();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 10
		getTextFieldExtTotalHoras10().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal10();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 11
		getTextFieldExtTotalHoras11().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal11();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 12
		getTextFieldExtTotalHoras12().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal12();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 13
		getTextFieldExtTotalHoras13().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal13();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 14
		getTextFieldExtTotalHoras14().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal14();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 15
		getTextFieldExtTotalHoras15().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal15();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 16
		getTextFieldExtTotalHoras16().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal16();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 17
		getTextFieldExtTotalHoras17().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal17();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 18
		getTextFieldExtTotalHoras18().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal18();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 19
		getTextFieldExtTotalHoras19().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal19();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 20
		getTextFieldExtTotalHoras20().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal20();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 21
		getTextFieldExtTotalHoras21().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal21();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 22
		getTextFieldExtTotalHoras22().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal22();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 23
		getTextFieldExtTotalHoras23().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal23();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
		// 24
		getTextFieldExtTotalHoras24().addTextFieldExtListener(new TextFieldExtListener() {
			public void actionPerformed(java.util.EventObject e) {
			}

			public void actionPerformedOnTextField(java.util.EventObject e) {
			}

			public void field_keyReleased(java.util.EventObject e) {
			}

			public void focusGained(java.util.EventObject e) {
			}

			public void focusLost(java.util.EventObject e) {
				manageTextTotal24();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void textDateMouseClicked(java.util.EventObject e) {
			}

			public void textFieldExtkeyReleased(java.util.EventObject e) {
			}
		});
	}

	/**
	 *
	 * @return
	 */
	public JLabel getJLabelValorPorHora01() {
		return this.jLabelValorPorHora01;
	}

	public JLabel getJLabelValorPorHora02() {
		return this.jLabelValorPorHora02;
	}

	public JLabel getJLabelValorPorHora03() {
		return this.jLabelValorPorHora03;
	}

	public JLabel getJLabelValorPorHora04() {
		return this.jLabelValorPorHora04;
	}

	public JLabel getJLabelValorPorHora05() {
		return this.jLabelValorPorHora05;
	}

	public JLabel getJLabelValorPorHora06() {
		return this.jLabelValorPorHora06;
	}

	public JLabel getJLabelValorPorHora07() {
		return this.jLabelValorPorHora07;
	}

	public JLabel getJLabelValorPorHora08() {
		return this.jLabelValorPorHora08;
	}

	public JLabel getJLabelValorPorHora09() {
		return this.jLabelValorPorHora09;
	}

	public JLabel getJLabelValorPorHora10() {
		return this.jLabelValorPorHora10;
	}

	public JLabel getJLabelValorPorHora11() {
		return this.jLabelValorPorHora11;
	}

	public JLabel getJLabelValorPorHora12() {
		return this.jLabelValorPorHora12;
	}

	public JLabel getJLabelValorPorHora13() {
		return this.jLabelValorPorHora13;
	}

	public JLabel getJLabelValorPorHora14() {
		return this.jLabelValorPorHora14;
	}

	public JLabel getJLabelValorPorHora15() {
		return this.jLabelValorPorHora15;
	}

	public JLabel getJLabelValorPorHora16() {
		return this.jLabelValorPorHora16;
	}

	public JLabel getJLabelValorPorHora17() {
		return this.jLabelValorPorHora17;
	}

	public JLabel getJLabelValorPorHora18() {
		return this.jLabelValorPorHora18;
	}

	public JLabel getJLabelValorPorHora19() {
		return this.jLabelValorPorHora19;
	}

	public JLabel getJLabelValorPorHora20() {
		return this.jLabelValorPorHora20;
	}

	public JLabel getJLabelValorPorHora21() {
		return this.jLabelValorPorHora21;
	}

	public JLabel getJLabelValorPorHora22() {
		return this.jLabelValorPorHora22;
	}

	public JLabel getJLabelValorPorHora23() {
		return this.jLabelValorPorHora23;
	}

	public JLabel getJLabelValorPorHora24() {
		return this.jLabelValorPorHora24;
	}

	private void manageAllTextTotals() {
		manageTextTotal01();
		manageTextTotal02();
		manageTextTotal03();
		manageTextTotal04();
		manageTextTotal05();
		manageTextTotal06();
		manageTextTotal07();
		manageTextTotal08();
		manageTextTotal09();
		manageTextTotal10();
		manageTextTotal11();
		manageTextTotal12();
		manageTextTotal13();
		manageTextTotal14();
		manageTextTotal15();
		manageTextTotal16();
		manageTextTotal17();
		manageTextTotal18();
		manageTextTotal19();
		manageTextTotal20();
		manageTextTotal21();
		manageTextTotal22();
		manageTextTotal23();
		manageTextTotal24();
	}

	private void manageTextTotal01() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras01().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 01.00;
		jLabelValorPorHora01.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal02() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras02().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 02.00;
		jLabelValorPorHora02.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal03() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras03().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 03.00;
		jLabelValorPorHora03.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal04() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras04().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 04.00;
		jLabelValorPorHora04.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal05() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras05().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 05.00;
		jLabelValorPorHora05.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal06() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras06().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 06.00;
		jLabelValorPorHora06.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal07() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras07().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 07.00;
		jLabelValorPorHora07.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal08() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras08().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 08.00;
		jLabelValorPorHora08.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal09() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras09().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 09.00;
		jLabelValorPorHora09.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal10() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras10().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 10.00;
		jLabelValorPorHora10.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal11() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras11().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 11.00;
		jLabelValorPorHora11.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal12() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras12().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 12.00;
		jLabelValorPorHora12.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal13() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras13().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 13.00;
		jLabelValorPorHora13.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal14() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras14().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 14.00;
		jLabelValorPorHora14.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal15() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras15().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 15.00;
		jLabelValorPorHora15.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal16() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras16().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 16.00;
		jLabelValorPorHora16.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal17() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras17().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 17.00;
		jLabelValorPorHora17.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal18() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras18().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 18.00;
		jLabelValorPorHora18.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal19() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras19().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 19.00;
		jLabelValorPorHora19.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal20() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras20().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 20.00;
		jLabelValorPorHora20.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal21() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras21().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 21.00;
		jLabelValorPorHora21.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal22() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras22().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 22.00;
		jLabelValorPorHora22.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal23() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras23().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 23.00;
		jLabelValorPorHora23.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	private void manageTextTotal24() {
		double valorTotal = new BigDecimal(StringTools.parseFromQuantityToNumber(getTextFieldExtTotalHoras24().getValue()).trim())
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double valorXHora = valorTotal / 24.00;
		jLabelValorPorHora24.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorXHora).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	/**
	 * @return the repository
	 */
	public FranjaHorariaRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository
	 *            the repository to set
	 */
	public void setRepository(FranjaHorariaRepository repository) {
		this.repository = repository;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
