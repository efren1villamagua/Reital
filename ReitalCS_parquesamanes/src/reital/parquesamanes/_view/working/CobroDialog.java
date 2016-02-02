package reital.parquesamanes._view.working;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Controller;

import efren.util.ExceptionManager;
import efren.util.StringTools;
import efren.util.WindowManager;
import efren.util.gui.LabelExt;
import efren.util.gui.bars.BarraAceptarCancelarPanel;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.text.TextFieldExt;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.app.serialport.util.SerialPortException;
import reital.parquesamanes.app.serialport.util.SerialPortModel;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;

public class CobroDialog extends DialogExt {
	/**
	 *
	 */
	private static final long serialVersionUID = 3745104705430035373L;

	// ...
	private BarraAceptarCancelarPanel ivjBarraAceptarCancelarPanel = null;

	protected transient PropertyChangeSupport propertyChange;

	private JPanel ivjJPanel1 = null;

	private LabelExt ivjLabelExt2 = null;

	private TextFieldExt textFieldExtValorPago = null;

	private LabelExt ivjLabelExt1 = null;

	private JLabel jLabelValor = null;

	private JLabel jLabel = null;

	private JLabel jLabelValorCambio = null;

	private JLabel jLabel1 = null;

	private TextFieldExt textFieldExtObservaciones = null;

	private SerialPortModel serialModel = null;

	/**
	 *
	 */
	private RDBDataModel model = null;

	private PagoView pagoView = null;

	private ActividadForPagoEntity actividadForPago = null;

	private JLabel jLabelTarjetaDetails = null;

	/**
	 *
	 */
	private double valorPago = 0.00;

	/**
	 *
	 */
	public CobroDialog(PagoView pagoView, RDBDataModel dm) {
		super(pagoView);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent e) {
				cerrar();
			}
		});
		this.pagoView = pagoView;
		this.model = dm;
		initialize();
	}

	/**
	 *
	 */
	private void registrarPago() {
		try {
			if (this.valorPago < getActividadForPago().getValor().doubleValue()) {
				InfoView.showErrorDialog(this.pagoView, "ERROR: El pago no puede ser menor que el valor del parqueo.");
				// getTextFieldExtValorPago().requestFocus();
				getTextFieldExtValorPago().seleccionar();
				return;
			}

			if (!getPago().debePagar() || !getPago().getImprimirRecibo()) {
				getActividadForPago().setObservaciones("");
			} else {
				String observacionesGenerales = getTextFieldExtObservaciones().getValue().trim();
				if (observacionesGenerales == null) {
					observacionesGenerales = "";
				}
				getActividadForPago().setObservaciones(observacionesGenerales.trim());
			}

			boolean resultado = this.model.guardarPago(this.pago);
			this.dispose();

			if (getPago().getImprimirRecibo() && !getPago().isTiempoGracia()) {
				Controller controlador = new Controller(this.pagoView);
				controlador.imprimirRecibo(pago);
			}

			if (resultado) {
				if (getPago().debePagar()) {
					if (!getPago().getImprimirRecibo()) {
						InfoView.showMessageDialog(this.pagoView, "Tarjeta con pago CERO");
						this.serialModel.abrirSalida1();
					} else {
						InfoView.showMessageDialog(this.pagoView,
								"Pago: " + StringTools.parseFromNumberToQuantity(getPago().getValor().setScale(2, 4)) + " registrado con éxito");
						this.serialModel.abrirSalida1();
					}
				} else {
					InfoView.showMessageDialog(this.pagoView, "Tarjeta de CORTESIA");
					this.serialModel.abrirSalida1();
				}
			}

		} catch (Throwable t) {
			t.getMessage();
			InfoView.showErrorDialog(this.pagoView, t.getMessage());
		}
	}

	/**
	 *
	 */
	public void initializeValores(Pago unPago) {
		setPago(unPago);
		if (unPago == null) {
			jLabelTarjetaDetails.setText("");
			jLabelValor.setText("0.00");
			getTextFieldExtObservaciones().setValue("");
			getTextFieldExtValorPago().setEditable(false);
		} else {
			jLabelTarjetaDetails
					.setText("<html><B>Tarjeta:</B> " + getPago().getEventoEntrada().getCodigoTarjetaDecimal() + "   "
							+ getPago().getEventoEntrada().getNombres() + " " + getPago().getEventoEntrada().getApellidos() + "<BR>Entrada: "
							+ StringTools.parseDateFromISOToDMY(getPago().getEventoEntrada().getFecha()) + "  hora: "
							+ getPago().getEventoEntrada().getHora().toString() + "<BR>Salida: "
							+ StringTools.parseDateFromISOToDMY(getPago().getEventoSalida().getFecha()) + "  hora: "
							+ getPago().getEventoSalida().getHora().toString()
							+ (getPago().isTiempoGracia()
									? "<BR><CENTER><FONT COLOR=red><B>GRATIS (hasta " + ApplicationConstantes.MINUTOS_GRACIA + " min.)</B></FONT></CENTER>"
									: ""));
			jLabelValor.setText(StringTools.parseFromNumberToQuantity(this.getPago().getValor()));
			getTextFieldExtObservaciones().setValue(getPago().isTiempoGracia() ? "GRATIS (hasta " + ApplicationConstantes.MINUTOS_GRACIA + " min.)" : "");
			getTextFieldExtValorPago().setEditable(!getPago().isTiempoGracia());
		}
		getTextFieldExtValorPago().setValue("0.00");
		jLabelValorCambio.setText("0.00");
		this.valorPago = 0.00;
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
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
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
			ivjBarraAceptarCancelarPanel = new efren.util.gui.bars.BarraAceptarCancelarPanel();
			ivjBarraAceptarCancelarPanel.setName("BarraAceptarCancelarPanel");
			ivjBarraAceptarCancelarPanel.setButtonCancelarText("Cancelar");
			ivjBarraAceptarCancelarPanel.setButtonAceptarText("Registrar pago");
			ivjBarraAceptarCancelarPanel.setButtonAceptarMnemonic(KeyEvent.VK_P);
			ivjBarraAceptarCancelarPanel.setButtonCancelarMnemonic(KeyEvent.VK_C);
			ivjBarraAceptarCancelarPanel.addBarraAceptarCancelarPanelListener(new efren.util.gui.bars.BarraAceptarCancelarPanelListener() {
				public void aceptarClicked(java.util.EventObject e) {
					registrarPago();
				}

				public void cancelarClicked(java.util.EventObject e) {
					cerrar();
				}
			});
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
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.insets = new Insets(5, 5, 10, 5);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridy = 0;
			jLabelTarjetaDetails = new JLabel();
			jLabelTarjetaDetails.setText("Tarjeta:");
			jLabelTarjetaDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.gridy = 8;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.insets = new Insets(20, 5, 0, 0);
			gridBagConstraints4.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints4.gridy = 7;
			jLabel1 = new JLabel();
			jLabel1.setText("Observaciones");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 6;
			jLabelValorCambio = new JLabel();
			jLabelValorCambio.setFont(new Font("Tahoma", Font.BOLD, 60));
			jLabelValorCambio.setText("0.00");
			jLabelValorCambio.setForeground(new Color(12, 108, 12));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints2.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints2.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("Valor");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.anchor = GridBagConstraints.NORTH;
			gridBagConstraints1.gridy = 2;
			jLabelValor = new JLabel();
			jLabelValor.setText("0.00");
			jLabelValor.setForeground(Color.blue);
			jLabelValor.setFont(new Font("Tahoma", Font.BOLD, 60));
			ivjJPanel1 = new JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsBarraAceptarCancelarPanel = new java.awt.GridBagConstraints();
			constraintsBarraAceptarCancelarPanel.gridx = 0;
			constraintsBarraAceptarCancelarPanel.gridy = 11;
			constraintsBarraAceptarCancelarPanel.gridwidth = 3;
			constraintsBarraAceptarCancelarPanel.weightx = 1.0;
			constraintsBarraAceptarCancelarPanel.weighty = 1.0;
			constraintsBarraAceptarCancelarPanel.insets = new java.awt.Insets(5, 5, 10, 10);
			java.awt.GridBagConstraints constraintsTextFieldExtValorHoraOFraccion = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValorHoraOFraccion.ipady = 35;
			constraintsTextFieldExtValorHoraOFraccion.gridx = 1;
			constraintsTextFieldExtValorHoraOFraccion.gridy = 4;
			constraintsTextFieldExtValorHoraOFraccion.fill = GridBagConstraints.BOTH;
			constraintsTextFieldExtValorHoraOFraccion.weightx = 1.0;
			constraintsTextFieldExtValorHoraOFraccion.anchor = GridBagConstraints.NORTHWEST;
			constraintsTextFieldExtValorHoraOFraccion.weighty = 0.0;
			constraintsTextFieldExtValorHoraOFraccion.insets = new Insets(0, 5, 5, 5);
			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 1;
			constraintsLabelExt1.gridy = 3;
			constraintsLabelExt1.anchor = GridBagConstraints.SOUTHWEST;
			constraintsLabelExt1.insets = new Insets(5, 5, 0, 5);
			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 1;
			constraintsLabelExt2.gridy = 5;
			constraintsLabelExt2.anchor = GridBagConstraints.SOUTHWEST;
			constraintsLabelExt2.insets = new Insets(5, 5, 0, 5);
			ivjJPanel1.add(getBarraAceptarCancelarPanel(), constraintsBarraAceptarCancelarPanel);
			ivjJPanel1.add(getTextFieldExtValorPago(), constraintsTextFieldExtValorHoraOFraccion);
			ivjJPanel1.add(getLabelExt1(), constraintsLabelExt1);
			ivjJPanel1.add(getLabelExt2(), constraintsLabelExt2);
			ivjJPanel1.add(jLabelValor, gridBagConstraints1);
			ivjJPanel1.add(jLabel, gridBagConstraints2);
			ivjJPanel1.add(jLabelValorCambio, gridBagConstraints3);
			ivjJPanel1.add(jLabel1, gridBagConstraints4);
			ivjJPanel1.add(getTextFieldExtObservaciones(), gridBagConstraints6);
			ivjJPanel1.add(jLabelTarjetaDetails, gridBagConstraints);
		}
		return ivjJPanel1;
	}

	/**
	 *
	 */
	private TextFieldExt getTextFieldExtValorPago() {
		if (textFieldExtValorPago == null) {
			textFieldExtValorPago = new TextFieldExt();
			textFieldExtValorPago.setFont(new Font("Arial", Font.PLAIN, 55));
			textFieldExtValorPago.setMaxLength(11);
			textFieldExtValorPago.setKeyMask(TextFieldExt.KeyMask.KM_Numero);
			textFieldExtValorPago.setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
			textFieldExtValorPago.addTextFieldExtListener(new efren.util.gui.text.TextFieldExtListener() {
				public void actionPerformedOnTextField(java.util.EventObject e) {
					getTextFieldExtObservaciones().requestFocus();
				}

				public void actionPerformed(java.util.EventObject e) {
					getTextFieldExtObservaciones().requestFocus();
				}

				public void field_keyReleased(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
					calcularCambio();
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}
			});
			textFieldExtValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					calcularCambio();
				}
			});
		}
		return textFieldExtValorPago;
	}

	/**
	 *
	 */
	private void calcularCambio() {
		double valor = this.getPago().getValor().doubleValue();
		this.valorPago = new BigDecimal(StringTools.parseFromMoneyToNumber(getTextFieldExtValorPago().getValue().trim())).setScale(2, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		double valorCambio = this.valorPago - valor;
		if (valorCambio < 0.00) {
			valorCambio = 0.00;
		}
		jLabelValorCambio.setText(StringTools.parseFromNumberToQuantity(new BigDecimal(valorCambio).setScale(2, BigDecimal.ROUND_HALF_UP)));
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
				ivjLabelExt1.setText("Pago");
				ivjLabelExt1.setForeground(java.awt.Color.black);
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
				ivjLabelExt2.setText("Cambio:");
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
	 *
	 */
	private void initialize() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setTitle("Pago");
			setSize(441, 530);
			setResizable(false);
			setContentPane(getJPanel1());
			setModal(true);
			WindowManager.centerWindow2(this);
			initializeValores(null);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		try {
			initSerialPortModel();
		} catch (Exception exc) {
			exc.getMessage();
		}
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
		dispose();
	}

	/**
	 * This method initializes textFieldExtObservaciones
	 *
	 * @return efren.util.gui.text.TextFieldExt
	 */
	private TextFieldExt getTextFieldExtObservaciones() {
		if (textFieldExtObservaciones == null) {
			textFieldExtObservaciones = new TextFieldExt();
			textFieldExtObservaciones.setMaxLength(200);
			textFieldExtObservaciones.addTextFieldExtListener(new efren.util.gui.text.TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					registrarPago();
				}

				public void actionPerformedOnTextField(java.util.EventObject e) {
					registrarPago();
				}

				public void field_keyReleased(java.util.EventObject e) {
				}

				public void focusGained(java.util.EventObject e) {
				}

				public void focusLost(java.util.EventObject e) {
				}

				public void keyReleased(KeyEvent e) {
				}

				public void textDateMouseClicked(java.util.EventObject e) {
				}

				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}
			});
		}
		return textFieldExtObservaciones;
	}

	/**
	 *
	 */
	private void initSerialPortModel() {
		this.serialModel = new SerialPortModel();
		try {
			this.serialModel.initializePortModel();
		} catch (SerialPortException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR AL INICIALIZAR EL PUERTO " + ApplicationConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
		} catch (PortInUseException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR: EL PUERTO " + ApplicationConstantes.PUERTO_SERIAL + " ESTA OCUPADO [" + e1.getMessage() + "]");
			// System.exit(-1);
		} catch (UnsupportedCommOperationException e1) {
			InfoView.showErrorDialog(this.pagoView,
					"ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + ApplicationConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
		} catch (IOException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR DE ESCRITURA EN EL PUERTO " + ApplicationConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
		} catch (Exception e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR DE APERTURA EN EL PUERTO " + ApplicationConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
		}
	}

	/**
	 * @return the actividadForPago
	 */
	public ActividadForPagoEntity getActividadForPago() {
		return actividadForPago;
	}

	/**
	 * @param actividadForPago the actividadForPago to set
	 */
	public void setActividadForPago(ActividadForPagoEntity actividadForPago) {
		this.actividadForPago = actividadForPago;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
