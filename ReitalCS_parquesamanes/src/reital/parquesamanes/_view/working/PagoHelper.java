package reital.parquesamanes._view.working;

import java.awt.Font;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import efren.util.CalendarManager;
import efren.util.StringTools;
import efren.util.gui.dialogs.InfoView;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import inetsoft.report.StyleSheet;
import inetsoft.report.io.Builder;
import inetsoft.report.j2d.StyleBook;
import inetsoft.report.j2d.StylePrinter;
import reital.parquesamanes.app.ioc.SpringInitializator;
import reital.parquesamanes.app.serialport.util.SerialPortException;
import reital.parquesamanes.app.serialport.util.SerialPortModel;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity;
import reital.parquesamanes.domain.entidades.ActividadForPagoEntity.EstadoPago;
import reital.parquesamanes.domain.entidades.FranjaHoraria;

public class PagoHelper {
	/**
	 *
	 */
	public static enum TIPO_CLIENTE {

		CLIENTE("C"), PASE_LIBRE("L");

		TIPO_CLIENTE(String unValor) {
			setValor(unValor);
		}

		private String valor;

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}
	}

	public static TIPO_CLIENTE getTIPO_CLIENTE_from(String unTipoCliente) {
		if (unTipoCliente == null) {
			return null;
		} else {
			if (unTipoCliente.equalsIgnoreCase(TIPO_CLIENTE.CLIENTE.getValor())) {
				return TIPO_CLIENTE.CLIENTE;
			} else {
				if (unTipoCliente.equalsIgnoreCase(TIPO_CLIENTE.PASE_LIBRE.getValor())) {
					return TIPO_CLIENTE.PASE_LIBRE;
				}
			}
		}
		return null;
	}

	/**
	 *
	 */
	private ActividadForPagoEntity actividad = null;
	private PagoView pagoView = null;
	private SerialPortModel serialModel = null;

	/**
	 *
	 */
	public PagoHelper(PagoView pagoView) {
		super();
		setPagoView(pagoView);
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
			getActividad().setObservaciones(observaciones.toUpperCase());
			getActividad().setTipoCliente(tipoCliente);

			return getActividad();

		} catch (Throwable t11) {
			return null;
		}
	}

	public boolean yaSalio(String secuenciaCaracteres) {

		return SpringInitializator.getSingleton().getPagoControllerBean().yaSalio(secuenciaCaracteres);
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
			InfoView.showErrorDialog(getPagoView(), "ERROR AL INICIALIZAR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (PortInUseException e1) {
			InfoView.showErrorDialog(getPagoView(), "ERROR: EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " ESTA OCUPADO [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (UnsupportedCommOperationException e1) {
			InfoView.showErrorDialog(getPagoView(),
					"ERROR: OPERACION NO SOPORTADA POR EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
			// System.exit(-1);
			e1.printStackTrace(System.out);
		} catch (IOException e1) {
			InfoView.showErrorDialog(getPagoView(), "ERROR DE ESCRITURA EN EL PUERTO " + ParqueSamanesConstantes.PUERTO_SERIAL + " [" + e1.getMessage() + "]");
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

			getPagoView().limpiarInformacionVisual(false);

			String secuenciaCaracteres = "";
			for (int i = 0; i < getPagoView().getJPasswordFieldData().getPassword().length; i++) {
				secuenciaCaracteres = secuenciaCaracteres + String.valueOf(getPagoView().getJPasswordFieldData().getPassword()[i]);
			}

			if (secuenciaCaracteres.trim().length() == 0) {
				getPagoView().limpiarInformacionVisual(true);
				getPagoView().initializarFoco();
				return;
			}

			if (secuenciaCaracteres.trim().length() != ParqueSamanesConstantes.TICKET_BAR_CODE_LENGTH) {
				getPagoView().mostrarError(error1);
				getPagoView().limpiarInformacionVisual(true);
				getPagoView().initializarFoco();
				return;
			}

			if (yaSalio(secuenciaCaracteres)) {
				getPagoView().mostrarError("ERROR: este ticket ya fue usado para otro vehículo !");
				getPagoView().limpiarInformacionVisual(true);
				getPagoView().initializarFoco();
				return;
			}

			ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = SpringInitializator.getSingleton().getPagoControllerBean()
					.getCantidadMinutosGracia();

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
				getPagoView().mostrarError("ERROR: el ticket fue emitido hace más de 48 horas !");
				getPagoView().limpiarInformacionVisual(true);
				getPagoView().initializarFoco();
				return;
			}
			if (Math.abs(milisSalida - milisEntrada) < 0) {
				getPagoView().mostrarError("ERROR: el ticket no es válido !");
				getPagoView().limpiarInformacionVisual(true);
				getPagoView().initializarFoco();
				return;
			}

			/**
			 *
			 */
			fillActividadForPagoEntity(registroActividad);

			/**
			 *
			 */
			getPagoView().getJPasswordFieldData().setText("");
			getPagoView().getJPasswordFieldData().setEnabled(false);

			getPagoView().getJButtonReiniciar().setEnabled(true);

			getPagoView().getJButtonReiniciar().setFocusable(false);

			getPagoView().getLabelBarIdValue().setText(registroActividad.getBarraId());

			CalendarManager cmSalidaAbsoluta = new CalendarManager(registroActividad.getSalida());
			CalendarManager cmEntradaAbsoluta = new CalendarManager(registroActividad.getEntrada());

			getPagoView().getLabelEntradaValue()
					.setText(cmEntradaAbsoluta.getInternationalDateExpression() + "  hora: " + cmEntradaAbsoluta.getTimeExpression2());
			getPagoView().getLabelSalidaValue().setText(cmSalidaAbsoluta.getInternationalDateExpression() + "  hora: " + cmSalidaAbsoluta.getTimeExpression2());

			switch (tipoCliente) {
			case CLIENTE:
				getPagoView().getJLabelStatus().setText("CLIENTE: $ " + StringTools.parseFromNumberToQuantity(registroActividad.getValor()));
				break;
			case PASE_LIBRE:
				getPagoView().getJLabelStatus().setText("PASE LIBRE: $ " + StringTools.parseFromNumberToQuantity(registroActividad.getValor()));
				break;
			default:
				break;
			}

			if (registroActividad.getTipoCliente() == TIPO_CLIENTE.PASE_LIBRE) {

				registroActividad.setEstadoPago(EstadoPago.PASE_LIBRE);

				boolean actividadPersistida = SpringInitializator.getSingleton().getPagoControllerBean().registrarActividad(registroActividad);

				getPagoView().reinicializarVisual();

				if (actividadPersistida) {
					InfoView.showMessageDialog(getPagoView(), "Pase libre");
				}

			} else {

				if (registroActividad.isEnTiempoGracia()) {

					registroActividad.setEstadoPago(EstadoPago.TIEMPO_GRACIA);

					boolean actividadPersistida = SpringInitializator.getSingleton().getPagoControllerBean().registrarActividad(registroActividad);

					getPagoView().reinicializarVisual();

					if (actividadPersistida) {
						InfoView.showMessageDialog(getPagoView(), "Tiempo de gracia");
					}

				} else {

					try {

						CobroDialog cv = new CobroDialog(this);
						cv.initializeValores(registroActividad);
						cv.setVisible(true);

					} catch (Exception e) {
						e.getMessage();
					}

				}
			}

		} catch (Throwable t11) {
			getPagoView().mostrarError("ERROR: " + t11.getMessage() + " - " + error1);
			getPagoView().limpiarInformacionVisual(true);
			System.out.println("ERROR: " + t11.getMessage());
			getPagoView().getJLabelStatus().setText("ERROR " + t11.getMessage());
			getPagoView().initializarFoco();
		}
	}

	private void fillActividadForPagoEntity(ActividadForPagoEntity actividad) throws Exception {

		ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes = SpringInitializator.getSingleton().getPagoControllerBean()
				.getCantidadMinutosGracia();

		CalendarManager cmEntradaAbsoluta = new CalendarManager(actividad.getEntrada());
		CalendarManager cmSalidaAbsoluta = new CalendarManager(actividad.getSalida());

		int minutosEntradaGlobal = (cmEntradaAbsoluta.getHoraDelDia() * 60) + cmEntradaAbsoluta.getMinutos();
		int minutosSalidaGlobal = (cmSalidaAbsoluta.getHoraDelDia() * 60) + cmSalidaAbsoluta.getMinutos();

		if (minutosSalidaGlobal - minutosEntradaGlobal <= ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes) {
			actividad.setValor(BigDecimal.ZERO);
			actividad.setEnTiempoGracia(true);
		} else {

			int diaEntrada = cmEntradaAbsoluta.getDayOfMonth();
			int diaSalida = cmSalidaAbsoluta.getDayOfMonth();

			Vector<Dia> dias = new Vector<Dia>();
			if (diaSalida == diaEntrada) {
				Dia dia = new Dia();
				dia.setEntrada(cmEntradaAbsoluta);
				dia.setSalida(cmSalidaAbsoluta);
				dias.addElement(dia);
			} else {
				if (diaSalida > diaEntrada) {
					// por ahora solo esta considerado un dia despues
					CalendarManager cmSalidaIntermedia = new CalendarManager(new GregorianCalendar(cmEntradaAbsoluta.getYear(),
							(cmEntradaAbsoluta.getMonth() - 1), cmEntradaAbsoluta.getDayOfMonth(), 23, 59, 59));
					Dia dia = new Dia();
					dia.setEntrada(cmEntradaAbsoluta);
					dia.setSalida(cmSalidaIntermedia);
					dias.addElement(dia);
					// ...CALCULAMOS EL OFFSET DE MINUTOS A NO TOMARSE EN CUENTA
					// EN EL PERIODO DEL SIGUIENTE DIA
					int minutosSalidaIntermediaTemp = (cmSalidaIntermedia.getHoraDelDia() * 60) + cmSalidaIntermedia.getMinutos();
					int minutosEntradaAbsolutosTemp = (cmEntradaAbsoluta.getHoraDelDia() * 60) + cmEntradaAbsoluta.getMinutos();
					int minutosOffset = (minutosSalidaIntermediaTemp - minutosEntradaAbsolutosTemp) % 60;
					// ...
					CalendarManager cmEntradaIntermedia = new CalendarManager(new GregorianCalendar(cmSalidaAbsoluta.getYear(),
							(cmSalidaAbsoluta.getMonth() - 1), cmSalidaAbsoluta.getDayOfMonth(), 0, (minutosOffset + 1), 0));
					dia = new Dia();
					dia.setEntrada(cmEntradaIntermedia);
					dia.setSalida(cmSalidaAbsoluta);
					dias.addElement(dia);
				}
			}

			// ...
			boolean minutosGraciaYaConsiderados = false;
			double valorTotal = 0.00;

			Dia diaTemp;
			for (int i = 0; i < dias.size(); i++) {

				diaTemp = dias.elementAt(i);

				int minutosSalidaAbsolutosTemp = (diaTemp.getSalida().getHoraDelDia() * 60) + diaTemp.getSalida().getMinutos();
				int minutosEntradaAbsolutosTemp = (diaTemp.getEntrada().getHoraDelDia() * 60) + diaTemp.getEntrada().getMinutos();

				/**
				 * SE RECORRE EL TIEMPO Y POR CADA HORA SE CALCULA SU VALOR
				 */
				int minutosTemp = minutosEntradaAbsolutosTemp;
				switch (actividad.getTipoCliente()) {
				case CLIENTE:
					/**
					 * LOS CLIENTES DE ParqueSamanes TIENEN MINUTOS DE GRACIA
					 * POR LO QUE 'AUMENTAMOS' LOS MINUTOS DE ENTRADA PARA QUE
					 * SE 'SALTE' DICHO TIEMPO
					 */
					if (!minutosGraciaYaConsiderados) {
						minutosEntradaAbsolutosTemp = minutosEntradaAbsolutosTemp + ParqueSamanesConstantes.MINUTOS_GRACIA_PARA_CLIENTES_ParqueSamanes;
						minutosTemp = minutosEntradaAbsolutosTemp;
						minutosGraciaYaConsiderados = true;
					}
					break;
				case PASE_LIBRE:
					/**
					 * LOS FUNCIONARIOS DE ParqueSamanes NO PAGAN POR LO QUE LA
					 * VARIABLE MINUTOS DEBE YA ESTAR EN EL LIMITE SUPERIOR ES
					 * DECIR NO ENTRAR AL LAZO WHILE
					 */
					// AUMENTAMOS 1 SOLAMENTE PARA QUE NO SE CUMPLA LA CONDICION
					// DE MAS ABAJO
					minutosTemp = minutosSalidaAbsolutosTemp + 1;
					break;
				default:
					break;
				}

				switch (actividad.getTipoCliente()) {
				case CLIENTE:

					Hashtable<Integer, BigDecimal> hv = null;

					Vector<FranjaHoraria> franjasPorCobrar = new Vector<FranjaHoraria>();
					FranjaHoraria franjaAnterior = SpringInitializator.getSingleton().getPagoControllerBean().getFranjaHorariaFor(minutosTemp);
					if (franjaAnterior == null) {
						throw new Exception("Error al recuperar información de las franjas horarias");
					}
					FranjaHoraria franjaNueva = null;
					int horasCount = 0;

					boolean cambioFranja = false;

					int remanente = -1;

					while (minutosTemp < minutosSalidaAbsolutosTemp) {

						franjaNueva = SpringInitializator.getSingleton().getPagoControllerBean().getFranjaHorariaFor(minutosTemp);
						if (franjaNueva == null) {
							throw new Exception("Error al recuperar información de las franjas horarias");
						}

						try {

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

						remanente = minutosTemp - minutosSalidaAbsolutosTemp;
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

					break;
				case PASE_LIBRE:
					valorTotal = 0.00;
					break;
				default:
					valorTotal = 0.00;
					break;
				}

			}

			actividad.setValor(new BigDecimal(valorTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
		}

		/**
		 * VALORES NO NECESARIOS
		 */
		actividad.setFranjaHoraria("-");
		actividad.setValorHoraOFraccion(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP));
		actividad.setCantidadHoras(0);
	}

	private class Dia {

		private CalendarManager entrada = null;
		private CalendarManager salida = null;

		public CalendarManager getEntrada() {
			return entrada;
		}

		public void setEntrada(CalendarManager entrada) {
			this.entrada = entrada;
		}

		public CalendarManager getSalida() {
			return salida;
		}

		public void setSalida(CalendarManager salida) {
			this.salida = salida;
		}
	}

	public void imprimirRecibo(ActividadForPagoEntity afpe) {
		try {
			if (afpe == null || afpe.getEntrada() == null || afpe.getSalida() == null) {
				InfoView.showErrorDialog(getPagoView(), "No se ha impreso ningún recibo todavía");
				return;
			}

			InputStream plantilla = getClass().getResourceAsStream("/reital/parquesamanes/resource/templates/TIRA01.srt");
			Builder builder = Builder.getBuilder(Builder.TEMPLATE, plantilla);

			StyleSheet report = null;
			report = (StyleSheet) builder.read(".");
			Font font1 = new Font("Ms sans serif", 0, 9);
			report.setCurrentFont(font1);
			report.setCurrentAlignment(2);
			report.addText(ParqueSamanesConstantes.LegalInfo.SRI_NOMBRE);
			report.addNewline(1);
			report.addText("RUC: " + ParqueSamanesConstantes.LegalInfo.SRI_RUC);
			report.addNewline(2);
			report.addText(ParqueSamanesConstantes.LegalInfo.NOMBRE_COMERCIAL);
			report.addNewline(2);
			report.setCurrentAlignment(1);
			report.addText("Código: " + afpe.getCodigo());
			report.addNewline(1);

			CalendarManager cmTemp = new CalendarManager(afpe.getEntrada());
			report.addText("Entrada: " + cmTemp.getDMYDateExpression() + "  hora: " + cmTemp.getTimeExpression2());
			report.addNewline(1);

			cmTemp = new CalendarManager(afpe.getSalida());
			report.addText("Salida: " + cmTemp.getDMYDateExpression() + "  hora: " + cmTemp.getTimeExpression2());
			report.addNewline(1);

			Font font2 = new Font("Ms sans serif", 0, 11);
			report.setCurrentFont(font2);
			report.addText("Valor: " + StringTools.parseFromNumberToQuantity(afpe.getValor()));

			report.addNewline(2);
			report.setCurrentFont(font1);
			report.setCurrentAlignment(2);
			report.addText("GRACIAS POR SU VISITA");

			PrinterJob job = StylePrinter.getPrinterJob();
			StyleBook book = new StyleBook(report, job.defaultPage());
			job.setPageable(book);
			job.print();

		} catch (Throwable t) {
			t.getMessage();
			InfoView.showErrorDialog(getPagoView(), "ERROR: " + t.getMessage());
		}
	}

	/**
	 * @return the pagoView
	 */
	public PagoView getPagoView() {
		return pagoView;
	}

	/**
	 * @param pagoView
	 *            the pagoView to set
	 */
	public void setPagoView(PagoView pagoView) {
		this.pagoView = pagoView;
	}

}