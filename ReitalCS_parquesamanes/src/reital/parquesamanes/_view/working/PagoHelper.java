package reital.parquesamanes._view.working;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import efren.util.CalendarManager;
import efren.util.StringTools;
import efren.util.gui.dialogs.InfoView;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import reital.parquesamanes.app.ioc.SpringInitializator;
import reital.parquesamanes.app.serialport.util.SerialPortException;
import reital.parquesamanes.app.serialport.util.SerialPortModel;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public class PagoHelper {
	/**
	 *
	 */
	public static enum TIPO_CLIENTE {
		CLIENTE_ParqueSamanes, NO_CLIENTE_ParqueSamanes, FUNCIONARIO_ParqueSamanes
	}

	/**
	 *
	 */
	private ActividadForPagoEntity actividad = null;

	/**
	 *
	 */
	private PagoView pagoView = null;

	private SerialPortModel serialModel = null;

	/**
	 *
	 */
	public PagoHelper(PagoView pagoView) {
		super();
		this.pagoView = pagoView;
		/**
		 *
		 */
		initSerialPortModel();
	}

	/**
	 *
	 */
	public ActividadForPagoEntity createActividadEntity(String secuenciaCaracteres, PagoHelper.TIPO_CLIENTE tipoCliente, String observaciones) {
		try {
			CadenaPair cp = parseSecuenciaCaracteres(secuenciaCaracteres);

			String barraId = cp.getBarraId();
			GregorianCalendar gcEntrada = cp.getCalendar();
			/**
			 * PARA LA SALIDA SE TOMA EL TIMESTAMP DE LA BASE DE DATOS
			 */
			GregorianCalendar gcSalida = new CalendarManager().getCalendar();

			setActividad(new ActividadForPagoEntity());
			getActividad().setCodigo(secuenciaCaracteres);
			getActividad().setBarraId(barraId);
			getActividad().setEntrada(gcEntrada);
			getActividad().setSalida(gcSalida);
			getActividad().setEstado(ActividadForPagoEntity.NO_SALE_TODAVIA);// a
																				// cambiarse
																				// en
																				// el
																				// instante
																				// del
																				// pago
			getActividad().setObservaciones(observaciones.toUpperCase());// a
																			// llenarse
																			// en
																			// el
																			// instante
																			// del
																			// pago

			String tipoClienteStr = "";
			switch (tipoCliente) {
			case CLIENTE_ParqueSamanes:
				tipoClienteStr = "A";
				break;
			case NO_CLIENTE_ParqueSamanes:
				tipoClienteStr = "B";
				break;
			case FUNCIONARIO_ParqueSamanes:
				tipoClienteStr = "C";
				break;
			default:
				break;
			}
			getActividad().setTipoCliente(tipoClienteStr);

			return getActividad();

		} catch (Throwable t11) {
			return null;
		}
	}

	/**
	 *
	 */
	public void registrarActividad() {

		SpringInitializator.getSingleton().getPagoControllerBean().registrarActividad(getActividad());

		this.pagoView.reinicializarVisual();
	}

	/**
	 *
	 */
	public void enviarSenialAbrirBarrera() {
		try {
			this.serialModel.abrirSalida1();
			InfoView.showMessageDialog(this.pagoView, "BARRERA ABIERTA !");
		} catch (Exception e) {
			e.getMessage();
			InfoView.showErrorDialog(this.pagoView, "ERROR AL ABRIR LA BARRERA !");
		}
		this.pagoView.reinicializarVisual();
	}

	/**
	 *
	 */
	public boolean yaSalio(String secuenciaCaracteres) {

		return SpringInitializator.getSingleton().getPagoControllerBean().yaSalio(parseSecuenciaCaracteres(secuenciaCaracteres));
	}

	/**
	 *
	 */
	public CadenaPair parseSecuenciaCaracteres(String secuenciaCaracteres) {
		String barraId = null;
		int dia = 0;
		int mes = 0;
		int anio = 0;
		int hora = 0;
		int minuto = 0;
		int segundo = 0;
		if (ParqueSamanesConstantes.TICKET_BAR_CODE_WITH_BAR_ID) {
			// longitud 13
			barraId = secuenciaCaracteres.substring(0, 1).trim();
			dia = new Integer(secuenciaCaracteres.substring(1, 3).trim()).intValue();
			mes = new Integer(secuenciaCaracteres.substring(3, 5).trim()).intValue() - 1;
			anio = new Integer(secuenciaCaracteres.substring(5, 7).trim()).intValue() + 2000;
			hora = new Integer(secuenciaCaracteres.substring(7, 9).trim()).intValue();
			minuto = new Integer(secuenciaCaracteres.substring(9, 11).trim()).intValue();
			segundo = new Integer(secuenciaCaracteres.substring(11).trim()).intValue();
		} else {
			// longitud 12
			barraId = "0";
			dia = new Integer(secuenciaCaracteres.substring(0, 2).trim()).intValue();
			mes = new Integer(secuenciaCaracteres.substring(2, 4).trim()).intValue() - 1;
			anio = new Integer(secuenciaCaracteres.substring(4, 6).trim()).intValue() + 2000;
			hora = new Integer(secuenciaCaracteres.substring(6, 8).trim()).intValue();
			minuto = new Integer(secuenciaCaracteres.substring(8, 10).trim()).intValue();
			segundo = new Integer(secuenciaCaracteres.substring(10).trim()).intValue();
		}
		GregorianCalendar gc = new GregorianCalendar(anio, mes, dia, hora, minuto, segundo);

		CadenaPair cp = new CadenaPair();
		cp.setBarraId(barraId);
		cp.setCalendar(gc);

		return cp;
	}

	/**
	 *
	 */
	private void initSerialPortModel() {
		this.serialModel = new SerialPortModel();
		try {
			this.serialModel.initializePortModel();
		} catch (SerialPortException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR AL INICIALIZAR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (PortInUseException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR: EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " ESTA OCUPADO [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (UnsupportedCommOperationException e1) {
			InfoView.showErrorDialog(this.pagoView,
					"ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (IOException e1) {
			InfoView.showErrorDialog(this.pagoView, "ERROR DE ESCRITURA EN EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		}
	}

	public class CadenaPair {
		private String barraId = null;

		private GregorianCalendar calendar = null;

		/**
		 * @return the barraId
		 */
		public String getBarraId() {
			return barraId;
		}

		/**
		 * @param barraId
		 *            the barraId to set
		 */
		public void setBarraId(String barraId) {
			this.barraId = barraId;
		}

		/**
		 * @return the calendar
		 */
		public GregorianCalendar getCalendar() {
			return calendar;
		}

		/**
		 * @param calendar
		 *            the calendar to set
		 */
		public void setCalendar(GregorianCalendar calendar) {
			this.calendar = calendar;
		}

	}

	/**
	 * @return the actividad
	 */
	public ActividadForPagoEntity getActividad() {
		return actividad;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(ActividadForPagoEntity actividad) {
		this.actividad = actividad;
	}

	/**
	 *
	 */
	public void validarYCalcularPago(PagoHelper.TIPO_CLIENTE tipoCliente, String observaciones) {
		String error1 = "Error en la lectura del ticket. Vuelva a intentar la operación !";
		try {

			pagoView.limpiarInformacionVisual(false);

			String secuenciaCaracteres = "";
			for (int i = 0; i < pagoView.getJPasswordFieldData().getPassword().length; i++) {
				secuenciaCaracteres = secuenciaCaracteres + String.valueOf(pagoView.getJPasswordFieldData().getPassword()[i]);
			}

			if (secuenciaCaracteres.trim().length() == 0) {
				pagoView.limpiarInformacionVisual(true);
				pagoView.initializarFoco();
				return;
			}

			if (secuenciaCaracteres.trim().length() != ParqueSamanesConstantes.TICKET_BAR_CODE_LENGTH) {
				pagoView.mostrarError(error1);
				pagoView.limpiarInformacionVisual(true);
				pagoView.initializarFoco();
				return;
			}

			if (yaSalio(secuenciaCaracteres)) {
				pagoView.mostrarError("ERROR: este ticket ya fue usado para otro vehículo !");
				pagoView.limpiarInformacionVisual(true);
				pagoView.initializarFoco();
				return;
			}

			ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = SpringInitializator.getSingleton().getPagoControllerBean().getMinutosGracia();

			/**
			 *
			 */
			ActividadForPagoEntity registroActividad = createActividadEntity(secuenciaCaracteres, tipoCliente, observaciones);

			long milisEntrada = registroActividad.getEntrada().getTimeInMillis();
			long milisSalida = registroActividad.getSalida().getTimeInMillis();
			/**
			 * DIFERENCIAS DE MAS DE 48 HORAS NO SE ACEPTA 48 HORAS EQUIVALE A
			 * 172800000 milisegundos
			 */
			if (Math.abs(milisSalida - milisEntrada) > 172800000) {
				pagoView.mostrarError("ERROR: el ticket fue emitido hace más de 48 horas !");
				pagoView.limpiarInformacionVisual(true);
				pagoView.initializarFoco();
				return;
			}
			if (Math.abs(milisSalida - milisEntrada) < 0) {
				pagoView.mostrarError("ERROR: el ticket no es válido !");
				pagoView.limpiarInformacionVisual(true);
				pagoView.initializarFoco();
				return;
			}

			CalendarManager cmSalidaAbsoluta = new CalendarManager(registroActividad.getSalida());
			int diaSalida = cmSalidaAbsoluta.getDayOfMonth();

			CalendarManager cmEntradaAbsoluta = new CalendarManager(registroActividad.getEntrada());
			int diaEntrada = cmEntradaAbsoluta.getDayOfMonth();

			Vector<CMEntradaSalida> cmes_vec = new Vector<CMEntradaSalida>();
			if (diaSalida == diaEntrada) {
				CMEntradaSalida cmes = new CMEntradaSalida();
				cmes.setEntrada(cmEntradaAbsoluta);
				cmes.setSalida(cmSalidaAbsoluta);
				cmes_vec.addElement(cmes);
			} else {
				if (diaSalida > diaEntrada) {
					// por ahora solo esta considerado un dia despues
					CalendarManager cmSalidaIntermedia = new CalendarManager(new GregorianCalendar(cmEntradaAbsoluta.getYear(),
							(cmEntradaAbsoluta.getMonth() - 1), cmEntradaAbsoluta.getDayOfMonth(), 23, 59, 59));
					CMEntradaSalida cmes = new CMEntradaSalida();
					cmes.setEntrada(cmEntradaAbsoluta);
					cmes.setSalida(cmSalidaIntermedia);
					cmes_vec.addElement(cmes);
					// ...CALCULAMOS EL OFFSET DE MINUTOS A NO TOMARSE EN CUENTA
					// EN EL PERIODO DEL SIGUIENTE DIA
					int minutosSalidaIntermedia = (cmSalidaIntermedia.getHoraDelDia() * 60) + cmSalidaIntermedia.getMinutos();
					int minutosEntradaAbsolutos = (cmEntradaAbsoluta.getHoraDelDia() * 60) + cmEntradaAbsoluta.getMinutos();
					int minutosOffset = (minutosSalidaIntermedia - minutosEntradaAbsolutos) % 60;
					// ...
					CalendarManager cmEntradaIntermedia = new CalendarManager(new GregorianCalendar(cmSalidaAbsoluta.getYear(),
							(cmSalidaAbsoluta.getMonth() - 1), cmSalidaAbsoluta.getDayOfMonth(), 0, (minutosOffset + 1), 0));
					cmes = new CMEntradaSalida();
					cmes.setEntrada(cmEntradaIntermedia);
					cmes.setSalida(cmSalidaAbsoluta);
					cmes_vec.addElement(cmes);
				}
			}

			// ...
			CMEntradaSalida cmesTemp;
			boolean minutosGraciaYaConsiderados = false;
			double valorTotal = 0.00;

			for (int i = 0; i < cmes_vec.size(); i++) {

				cmesTemp = cmes_vec.elementAt(i);

				int minutosSalidaAbsolutos = (cmesTemp.getSalida().getHoraDelDia() * 60) + cmesTemp.getSalida().getMinutos();
				int minutosEntradaAbsolutos = (cmesTemp.getEntrada().getHoraDelDia() * 60) + cmesTemp.getEntrada().getMinutos();

				/**
				 * SE RECORRE EL TIEMPO Y POR CADA HORA SE CALCULA SU VALOR
				 */
				int minutosTemp = minutosEntradaAbsolutos;
				switch (tipoCliente) {
				case CLIENTE_ParqueSamanes:
					/**
					 * LOS CLIENTES DE ParqueSamanes TIENEN MINUTOS DE GRACIA
					 * POR LO QUE 'AUMENTAMOS' LOS MINUTOS DE ENTRADA PARA QUE
					 * SE 'SALTE' DICHO TIEMPO
					 */
					if (!minutosGraciaYaConsiderados) {
						minutosEntradaAbsolutos = minutosEntradaAbsolutos + ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes;
						minutosTemp = minutosEntradaAbsolutos;
						minutosGraciaYaConsiderados = true;
					}
					break;
				case NO_CLIENTE_ParqueSamanes:
					break;
				case FUNCIONARIO_ParqueSamanes:
					/**
					 * LOS FUNCIONARIOS DE ParqueSamanes NO PAGAN POR LO QUE LA
					 * VARIABLE MINUTOS DEBE YA ESTAR EN EL LIMITE SUPERIOR ES
					 * DECIR NO ENTRAR AL LAZO WHILE
					 */
					minutosTemp = minutosSalidaAbsolutos + 1;// AUMENTAMOS 1
																// SOLAMENTE
																// PARA QUE NO
																// SE CUMPLA LA
																// CONDICION DE
																// MAS ABAJO
					break;
				default:
					break;
				}

				if (tipoCliente != TIPO_CLIENTE.FUNCIONARIO_ParqueSamanes) {
					Hashtable<Integer, BigDecimal> hv = null;

					Vector<FranjaHoraria> franjasPorCobrar = new Vector<FranjaHoraria>();
					FranjaHoraria franjaAnterior = SpringInitializator.getSingleton().getPagoControllerBean().getFranjaHorariaFor(minutosTemp);
					FranjaHoraria franjaNueva = null;
					int horasCount = 0;

					boolean cambioFranja = false;

					int remanente = -1;

					while (minutosTemp < minutosSalidaAbsolutos) {
						try {
							franjaNueva = SpringInitializator.getSingleton().getPagoControllerBean().getFranjaHorariaFor(minutosTemp);
							cambioFranja = !franjaNueva.getNombre().equalsIgnoreCase(franjaAnterior.getNombre());
							if (cambioFranja) {
								/**
								 * realizamos los calculos en el cambio de hora
								 */
								BigDecimal valorXHora = null;
								if (horasCount <= 0) {
									valorXHora = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
								} else {
									hv = FranjaHorariaABMDetailsView.getHorasValores(franjaAnterior.getHorasValores());
									valorXHora = hv.get(horasCount) == null ? new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)
											: hv.get(horasCount).setScale(2, BigDecimal.ROUND_HALF_UP);
								}
								franjasPorCobrar.addElement(franjaAnterior);
								valorTotal = valorTotal + (valorXHora.doubleValue() * (1.00 * horasCount));
								// ...
								franjaAnterior = franjaNueva;
								minutosTemp = minutosTemp + 60;
								horasCount = 1;// debido a que ya nos vamos 60
												// minutos en el tiempo entonces
												// colocamos 1 hora en
												// horasCount
								continue;
							}
						} catch (Exception exc) {
							exc.getMessage();
						}
						franjaAnterior = franjaNueva;
						minutosTemp = minutosTemp + 60;
						horasCount++;

						remanente = minutosTemp - minutosSalidaAbsolutos;
					}
					// ...
					if (remanente != 0) {
						BigDecimal valorXHora = null;
						if (horasCount <= 0) {
							valorXHora = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
						} else {
							hv = FranjaHorariaABMDetailsView.getHorasValores(franjaAnterior.getHorasValores());
							valorXHora = hv.get(horasCount) == null ? new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)
									: hv.get(horasCount).setScale(2, BigDecimal.ROUND_HALF_UP);
						}
						franjasPorCobrar.addElement(franjaAnterior);
						valorTotal = valorTotal + (valorXHora.doubleValue() * (1.00 * horasCount));
					}
				}

			}

			BigDecimal valorTotalBD = new BigDecimal(valorTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
			registroActividad.setValor(valorTotalBD);

			/**
			 * VALORES NO NECESARIOS
			 */
			registroActividad.setFranjaHoraria("-");
			registroActividad.setValorHoraOFraccion(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP));
			registroActividad.setCantidadHoras(0);

			/**
			 *
			 */
			pagoView.getJPasswordFieldData().setText("");
			pagoView.getJPasswordFieldData().setEnabled(false);

			pagoView.getJButtonReiniciar().setEnabled(true);

			pagoView.getJButtonReiniciar().setFocusable(false);

			registrarActividad();

			pagoView.getJLabelRegistroEntrada()
					.setText(cmEntradaAbsoluta.getInternationalDateExpression() + "  hora: " + cmEntradaAbsoluta.getTimeExpression2());
			pagoView.getJLabelRegistroSalida().setText(cmSalidaAbsoluta.getInternationalDateExpression() + "  hora: " + cmSalidaAbsoluta.getTimeExpression2());

			switch (tipoCliente) {
			case CLIENTE_ParqueSamanes:
				pagoView.getJLabelStatus()
						.setText("CLIENTE " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + ": $ " + StringTools.parseFromNumberToQuantity(valorTotalBD));
				break;
			case NO_CLIENTE_ParqueSamanes:
				pagoView.getJLabelStatus().setText("NO CLIENTE: $ " + StringTools.parseFromNumberToQuantity(valorTotalBD));
				break;
			case FUNCIONARIO_ParqueSamanes:
				pagoView.getJLabelStatus().setText("FUNCIONARIO: $ " + StringTools.parseFromNumberToQuantity(valorTotalBD));
				break;
			default:
				break;
			}

			pagoView.getJButtonAbrirBarrera().setEnabled(true);

			if (tipoCliente == TIPO_CLIENTE.FUNCIONARIO_ParqueSamanes) {
				pagoView.abrirBarrera();
			}

		} catch (Throwable t11) {
			pagoView.mostrarError("ERROR: " + t11.getMessage() + " - " + error1);
			pagoView.limpiarInformacionVisual(true);
			System.out.println("ERROR: " + t11.getMessage());
			pagoView.getJLabelStatus().setText("ERROR");
			pagoView.initializarFoco();
		}
	}

	public class CMEntradaSalida {
		private CalendarManager entrada = null;

		private CalendarManager salida = null;

		/**
		 * @return the entrada
		 */
		public CalendarManager getEntrada() {
			return entrada;
		}

		/**
		 * @param entrada
		 *            the entrada to set
		 */
		public void setEntrada(CalendarManager entrada) {
			this.entrada = entrada;
		}

		/**
		 * @return the salida
		 */
		public CalendarManager getSalida() {
			return salida;
		}

		/**
		 * @param salida
		 *            the salida to set
		 */
		public void setSalida(CalendarManager salida) {
			this.salida = salida;
		}
	}
}