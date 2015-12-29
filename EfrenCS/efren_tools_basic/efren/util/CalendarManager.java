package efren.util;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 * clase utilitaria para manejo de fecha y tiempo definidos por un Calendar
 */
public class CalendarManager {
	/**
	 *
	 */
	private GregorianCalendar calendar;

	private String dateSeparator = "-";

	private String timeSeparator = ":";

	public CalendarManager() throws Throwable {
		this(_server_currentCalendar());
	}

	/**
	 * CalendarManager constructor comment.
	 */
	public CalendarManager(Date date) {
		super();

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		setCalendar(gc);
	}

	/**
	 * CalendarManager constructor comment.
	 */
	public CalendarManager(GregorianCalendar aCalendar) {
		super();
		setCalendar(aCalendar);
	}

	/**
	 *
	 */
	public CalendarManager(long millis) {
		super();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(millis);
		setCalendar(gc);
	}

	/**
	 *
	 * @return
	 * @throws Throwable
	 */
	private static GregorianCalendar _server_currentCalendar() throws Throwable {
		return _SQL_server_currentCalendar();
	}

	/**
	 *
	 * @return
	 * @throws Throwable
	 */
	private static GregorianCalendar _SQL_server_currentCalendar() throws Throwable {
		return new GregorianCalendar();
		/*
		 * try { Connection con = Conn.conectar(); Statement st =
		 * con.createStatement(); int anio = -1, mes = -1, dia = -1, hora = -1,
		 * minuto = -1, segundo = -1; if (SystemProperties.SERVER_TYPE ==
		 * Constantes.SERVER_TYPE_1_OS400) { String sql =
		 * "SELECT CURRENT TIMESTAMP FROM " +
		 * SystemProperties.SCHEMA_SEGURIDADES + ".SISTEMA"; ResultSet rs =
		 * st.executeQuery(sql); Timestamp t = null; while (rs.next()) { t =
		 * rs.getTimestamp(1); break; } rs.close(); Date d = new
		 * Date(t.getTime()); st.close(); GregorianCalendar gc = new
		 * GregorianCalendar(); gc.setTime(d); return gc; } else { if
		 * (SystemProperties.SERVER_TYPE ==
		 * Constantes.SERVER_TYPE_2_WINDOWS_UNIX) { String sql =
		 * "VALUES YEAR(CURRENT DATE)"; ResultSet rs = st.executeQuery(sql);
		 * while (rs.next()) anio = rs.getInt(1); rs.close(); sql =
		 * "VALUES MONTH(CURRENT DATE)"; rs = st.executeQuery(sql); while
		 * (rs.next()) mes = rs.getInt(1); rs.close(); sql =
		 * "VALUES DAY(CURRENT DATE)"; rs = st.executeQuery(sql); while
		 * (rs.next()) dia = rs.getInt(1); rs.close(); sql =
		 * "VALUES HOUR(CURRENT TIME)"; rs = st.executeQuery(sql); while
		 * (rs.next()) hora = rs.getInt(1); rs.close(); sql =
		 * "VALUES MINUTE(CURRENT TIME)"; rs = st.executeQuery(sql); while
		 * (rs.next()) minuto = rs.getInt(1); rs.close(); sql =
		 * "VALUES SECOND(CURRENT TIME)"; rs = st.executeQuery(sql); while
		 * (rs.next()) segundo = rs.getInt(1); rs.close(); return new
		 * GregorianCalendar(anio, mes - 1, dia, hora, minuto, segundo); } }
		 * st.close(); } catch (Throwable t) { t.getMessage(); } return null;
		 */
	}

	public void add(int field, int amount) {
		// pedido al calendar
		if (getCalendar() != null) {
			getCalendar().add(field, amount);
		}
	}

	/**
	 * after method comment.
	 */
	public boolean after(Object when) {
		// when es de tipo Calendar, no CalendarManager
		// pedido al calendar
		if (getCalendar() != null) {
			return getCalendar().after(when);
		}
		return false;
	}

	/**
	 * before method comment.
	 */
	public boolean before(Object when) {
		// pedido al calendar
		if (getCalendar() != null) {
			return getCalendar().before(when);
		}
		return false;
	}

	/**
	 * before method comment.
	 */
	public boolean esElMismoDia(Calendar otherCalendar) {
		if (getCalendar() != null && otherCalendar != null) {
			try {
				int anioEsteCalendar = getCalendar().get(Calendar.YEAR);
				int mesEsteCalendar = getCalendar().get(Calendar.MONTH);
				int diaEsteCalendar = getCalendar().get(Calendar.DAY_OF_MONTH);
				int anioOtherCalendar = otherCalendar.get(Calendar.YEAR);
				int mesOtherCalendar = otherCalendar.get(Calendar.MONTH);
				int diaOtherCalendar = otherCalendar.get(Calendar.DAY_OF_MONTH);
				if ((anioEsteCalendar == anioOtherCalendar) && (mesEsteCalendar == mesOtherCalendar) && (diaEsteCalendar == diaOtherCalendar)) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return false;
	}

	/**
	 *
	 * @param unaFecha
	 * @return
	 */
	public static String convertir_Date_DMYstr(Date unaFecha) {
		if (unaFecha == null) {
			return "";
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(unaFecha);

		int dia = gc.get(Calendar.DAY_OF_MONTH);
		int month = gc.get(Calendar.MONTH) + 1;
		String mes = null;
		switch (month) {
		case 1:
			mes = "ENE";
			break;
		case 2:
			mes = "FEB";
			break;
		case 3:
			mes = "MAR";
			break;
		case 4:
			mes = "ABR";
			break;
		case 5:
			mes = "MAY";
			break;
		case 6:
			mes = "JUN";
			break;
		case 7:
			mes = "JUL";
			break;
		case 8:
			mes = "AGO";
			break;
		case 9:
			mes = "SEP";
			break;
		case 10:
			mes = "OCT";
			break;
		case 11:
			mes = "NOV";
			break;
		case 12:
			mes = "DIC";
			break;
		default:
			mes = "___";
		}
		int anio = gc.get(Calendar.YEAR);

		if (dia < 10)
			return "0" + dia + "-" + mes + "-" + anio;
		else
			return "" + dia + "-" + mes + "-" + anio;
	}

	/**
	 * CONVIERTE UN STRING DE FECHA EN EL FORMATO YYYYMMDD A UN OBJETO DE TIPO
	 * Date
	 */
	public static Date convertir_YMDstr_Date(String unYMD) {
		int anio = new Integer(unYMD.substring(0, 4)).intValue();
		int mes = new Integer(unYMD.substring(4, 6)).intValue();
		int dia = new Integer(unYMD.substring(6)).intValue();
		GregorianCalendar gc = new GregorianCalendar(anio, mes - 1, dia);
		CalendarManager cm = new CalendarManager(gc);
		return cm.getSqlDate();
	}

	/**
	 * CONVIERTE UN STRING DE FECHA EN EL FORMATO YYYYMMDD A UN OBJETO DE TIPO
	 * Date
	 */
	public static Date convertir_AAAAMMDD_Date(String unAAAAMMDD) {
		int anio = new Integer(unAAAAMMDD.substring(0, 4)).intValue();
		int mes = new Integer(unAAAAMMDD.substring(4, 6)).intValue();
		int dia = new Integer(unAAAAMMDD.substring(6)).intValue();
		GregorianCalendar gc = new GregorianCalendar(anio, mes - 1, dia);
		CalendarManager cm = new CalendarManager(gc);
		return cm.getSqlDate();
	}

	/**
	 * CONVIERTE UN STRING DE FECHA EN EL FORMATO YYYY-MM-DD A UN OBJETO DE TIPO
	 * Date
	 */
	public static Date convertir_Y_M_Dstr_Date(String unY_M_D) {
		int anio = new Integer(unY_M_D.substring(0, 4)).intValue();
		int mes = new Integer(unY_M_D.substring(5, 7)).intValue();
		int dia = new Integer(unY_M_D.substring(8)).intValue();
		GregorianCalendar gc = new GregorianCalendar(anio, mes - 1, dia);
		CalendarManager cm = new CalendarManager(gc);
		return cm.getSqlDate();
	}

	/**
	 *
	 * @param unDMY
	 * @return
	 */
	public static String convertir_DMYstr_ISOstr(String unDMY) {

		if (unDMY == null || unDMY.trim().length() == 0)
			return "";

		try {
			StringTokenizer stk = new StringTokenizer(unDMY, "-");
			String dia = stk.nextToken();
			String month = stk.nextToken();
			String mes = null;

			if (month.compareTo("ENE") == 0)
				mes = "01";
			else {
				if (month.compareTo("FEB") == 0)
					mes = "02";
				else {
					if (month.compareTo("MAR") == 0)
						mes = "03";
					else {
						if (month.compareTo("ABR") == 0)
							mes = "04";
						else {
							if (month.compareTo("MAY") == 0)
								mes = "05";
							else {
								if (month.compareTo("JUN") == 0)
									mes = "06";
								else {
									if (month.compareTo("JUL") == 0)
										mes = "07";
									else {
										if (month.compareTo("AGO") == 0)
											mes = "08";
										else {
											if (month.compareTo("SEP") == 0)
												mes = "09";
											else {
												if (month.compareTo("OCT") == 0)
													mes = "10";
												else {
													if (month.compareTo("NOV") == 0)
														mes = "11";
													else {
														if (month.compareTo("DIC") == 0)
															mes = "12";
														else
															mes = "__";
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			String anio = stk.nextToken();

			return anio + "-" + mes + "-" + dia;
		} catch (Throwable t) {
			t.getMessage();
			return "";
		}
	}

	public static String convertir_MesInt_MesStr(int unMes) {
		if (unMes < 0 || unMes > 12)
			return "NO DEFINIDO";

		String mes = null;
		switch (unMes) {
		case 1:
			mes = "ENERO";
			break;
		case 2:
			mes = "FEBRERO";
			break;
		case 3:
			mes = "MARZO";
			break;
		case 4:
			mes = "ABRIL";
			break;
		case 5:
			mes = "MAYO";
			break;
		case 6:
			mes = "JUNIO";
			break;
		case 7:
			mes = "JULIO";
			break;
		case 8:
			mes = "AGOSTO";
			break;
		case 9:
			mes = "SEPTIEMBRE";
			break;
		case 10:
			mes = "OCTUBRE";
			break;
		case 11:
			mes = "NOVIEMBRE";
			break;
		default:
			mes = "DICIEMBRE";
			break;
		}

		return mes;
	}

	public static String convertir_MesInt_MesStrCorto(int unMes) {
		try {
			if (unMes == 1)
				return "ENE";
			if (unMes == 2)
				return "FEB";
			if (unMes == 3)
				return "MAR";
			if (unMes == 4)
				return "ABR";
			if (unMes == 5)
				return "MAY";
			if (unMes == 6)
				return "JUN";
			if (unMes == 7)
				return "JUL";
			if (unMes == 8)
				return "AGO";
			if (unMes == 9)
				return "SEP";
			if (unMes == 10)
				return "OCT";
			if (unMes == 11)
				return "NOV";
			if (unMes == 12)
				return "DIC";
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	public static String convertir_MesStr_MesNumeroStr(String unMes) {
		try {
			if (unMes.trim().toUpperCase().compareTo("ENERO") == 0)
				return "01";
			if (unMes.trim().toUpperCase().compareTo("FEBRERO") == 0)
				return "02";
			if (unMes.trim().toUpperCase().compareTo("MARZO") == 0)
				return "03";
			if (unMes.trim().toUpperCase().compareTo("ABRIL") == 0)
				return "04";
			if (unMes.trim().toUpperCase().compareTo("MAYO") == 0)
				return "05";
			if (unMes.trim().toUpperCase().compareTo("JUNIO") == 0)
				return "06";
			if (unMes.trim().toUpperCase().compareTo("JULIO") == 0)
				return "07";
			if (unMes.trim().toUpperCase().compareTo("AGOSTO") == 0)
				return "08";
			if (unMes.trim().toUpperCase().compareTo("SEPTIEMBRE") == 0)
				return "09";
			if (unMes.trim().toUpperCase().compareTo("OCTUBRE") == 0)
				return "10";
			if (unMes.trim().toUpperCase().compareTo("NOVIEMBRE") == 0)
				return "11";
			if (unMes.trim().toUpperCase().compareTo("DICIEMBRE") == 0)
				return "12";

			return null;

		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	public static int daysInMonthCount(int year, int month) {

		if (month == 1)
			return 31; // enero

		if (month == 2) {
			if (esBisciesto(year))
				return 29;
			else
				return 28; // febrero
		}

		if (month == 3)
			return 31; // marzo

		if (month == 4)
			return 30; // abril

		if (month == 5)
			return 31; // mayo

		if (month == 6)
			return 30; // junio

		if (month == 7)
			return 31; // julio

		if (month == 8)
			return 31; // agosto

		if (month == 9)
			return 30; // septiembre

		if (month == 10)
			return 31; // octubre

		if (month == 11)
			return 30; // noviembre

		if (month == 12)
			return 31; // diciembre

		return 0;
	}

	public long diffInDays(Calendar otherCalendar) {

		/* retorna la diferencia en días con otherCalendar */
		return (new Double((this.getCalendar().getTime().getTime() - otherCalendar.getTime().getTime()) / (3600 * 1000 * 24))).longValue();
	}

	public long diffInHours(Calendar otherCalendar) {

		/* retorna la diferencia en horas con otherCalendar */
		return (new Double((this.getCalendar().getTime().getTime() - otherCalendar.getTime().getTime()) / (3600 * 1000))).longValue();
	}

	public long diffInSeconds(Calendar otherCalendar) {

		/* retorna la diferencia en segundos con otherCalendar */
		return (this.getCalendar().getTime().getTime() - otherCalendar.getTime().getTime()) / 1000;
	}

	/**
	 * equals method comment.
	 */
	public boolean equals(Object obj) {
		// pedido al calendar
		if (getCalendar() != null)
			return getCalendar().equals(obj);
		return false;
	}

	public static boolean esBisciesto(int year) {
		if (Math.IEEEremainder(year, 4) == 0)
			return true;
		return false;
	}

	public String getAbsoluteInternationalDateExpression() {
		return getInternationalDateExpression() + "::" + getCalendar().get(Calendar.HOUR_OF_DAY) + "h:" + getCalendar().get(Calendar.MINUTE) + "m:"
				+ getCalendar().get(Calendar.SECOND) + "s";
	}

	public String getAbsoluteRegionalDateExpression() {
		return getDMYDateExpression() + "::" + getCalendar().get(Calendar.HOUR_OF_DAY) + "h:" + getCalendar().get(Calendar.MINUTE) + "m:"
				+ getCalendar().get(Calendar.SECOND) + "s";
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public String getDayInWords() {
		int numberOfDay = getWeekDayNumber();
		if (numberOfDay == 0)
			return "Domingo";
		if (numberOfDay == 1)
			return "Lunes";
		if (numberOfDay == 2)
			return "Martes";
		if (numberOfDay == 3)
			return "Miércoles";
		if (numberOfDay == 4)
			return "Jueves";
		if (numberOfDay == 5)
			return "Viernes";
		if (numberOfDay == 6)
			return "Sábado";
		return "noDay";
	}

	public static String getDayInWordsFor(int numberOfDay) {

		/**
		 * el número del día debe estar entre 0 y 6
		 */

		if (numberOfDay == 0)
			return "Domingo";
		if (numberOfDay == 1)
			return "Lunes";
		if (numberOfDay == 2)
			return "Martes";
		if (numberOfDay == 3)
			return "Miércoles";
		if (numberOfDay == 4)
			return "Jueves";
		if (numberOfDay == 5)
			return "Viernes";
		if (numberOfDay == 6)
			return "Sábado";
		return "noDay";
	}

	public int getDayOfMonth() {

		/* retorna el número de día del mes: 1-31 */
		return getCalendar().get(Calendar.DAY_OF_MONTH);
	}

	public Hashtable<String, Integer> getDiff(CalendarManager aCm) {

		int anios = this.getYear() - aCm.getYear();
		int meses = this.getMonth() - aCm.getMonth();
		int dias = this.getDayOfMonth() - aCm.getDayOfMonth();

		Hashtable<String, Integer> ht = new Hashtable<String, Integer>(3);

		ht.put("anios", new Integer(anios));
		ht.put("meses", new Integer(meses));
		ht.put("dias", new Integer(dias));

		return ht;
	}

	/**
	 * Este método imprime la representación regional (día mes año) de una fecha
	 * definida por Calendar
	 */
	public String getDMYDateExpression() {

		String diaStr = "";
		int dia = getCalendar().get(Calendar.DAY_OF_MONTH);
		if (dia < 10)
			diaStr = "0";
		diaStr = diaStr + dia;

		String mesStr = "";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		switch (mes) {
		case 1:
			mesStr = "ENE";
			break;
		case 2:
			mesStr = "FEB";
			break;
		case 3:
			mesStr = "MAR";
			break;
		case 4:
			mesStr = "ABR";
			break;
		case 5:
			mesStr = "MAY";
			break;
		case 6:
			mesStr = "JUN";
			break;
		case 7:
			mesStr = "JUL";
			break;
		case 8:
			mesStr = "AGO";
			break;
		case 9:
			mesStr = "SEP";
			break;
		case 10:
			mesStr = "OCT";
			break;
		case 11:
			mesStr = "NOV";
			break;
		case 12:
			mesStr = "DIC";
			break;
		default:
			mesStr = "___";
		}

		return diaStr + this.dateSeparator + mesStr + this.dateSeparator + new Integer((getCalendar().get(Calendar.YEAR))).toString().trim();
	}

	/**
	 * getGreatestMinimum method comment.
	 */
	public int getGreatestMinimum(int field) {
		// pedido al calendar
		if (getCalendar() != null)
			return getCalendar().getGreatestMinimum(field);
		return 0;
	}

	/**
	 * Este método imprime la representación internacional (año mes día) de una
	 * fecha definida por Calendar
	 */
	public String getInternationalDateExpression() {
		String diaStr = "";
		String mesStr = "";
		int dia = getCalendar().get(Calendar.DAY_OF_MONTH);
		if (dia < 10)
			diaStr = "0";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		if (mes < 10)
			mesStr = "0";
		return new Integer((getCalendar().get(Calendar.YEAR))).toString().trim() + this.dateSeparator + mesStr + new Integer(mes).toString().trim()
				+ this.dateSeparator + diaStr + new Integer(dia).toString().trim();
	}

	/**
	 * Este método imprime la representación 2 dígitos del mes y 2 dígitos del
	 * año
	 */
	public String getShortMonthYear() {
		String mesStr = "";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		if (mes < 10) {
			mesStr = "0" + mes;
		} else {
			mesStr = String.valueOf(mes);
		}
		int anio = getCalendar().get(Calendar.YEAR);
		String anioStr = String.valueOf(anio).substring(2);
		return mesStr + anioStr;
	}

	/**
	 * getLeastMaximum method comment.
	 */
	public int getLeastMaximum(int field) {
		// pedido al calendar
		if (getCalendar() != null)
			return getCalendar().getLeastMaximum(field);
		return 0;
	}

	/**
	 * Este método imprime la representación regional (día mes año) de una fecha
	 * definida por Calendar
	 */
	public String getLongDMYDateExpression() {

		String diaStr = "";
		int dia = getCalendar().get(Calendar.DAY_OF_MONTH);
		if (dia < 10)
			diaStr = "0";
		diaStr = diaStr + dia;

		String mesStr = "";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		switch (mes) {
		case 1:
			mesStr = "ENERO";
			break;
		case 2:
			mesStr = "FEBRERO";
			break;
		case 3:
			mesStr = "MARZO";
			break;
		case 4:
			mesStr = "ABRIL";
			break;
		case 5:
			mesStr = "MAYO";
			break;
		case 6:
			mesStr = "JUNIO";
			break;
		case 7:
			mesStr = "JULIO";
			break;
		case 8:
			mesStr = "AGOSTO";
			break;
		case 9:
			mesStr = "SEPTIEMBRE";
			break;
		case 10:
			mesStr = "OCTUBRE";
			break;
		case 11:
			mesStr = "NOVIEMBRE";
			break;
		case 12:
			mesStr = "DICIEMBRE";
			break;
		default:
			mesStr = "___";
		}

		return diaStr + " de " + mesStr + " del " + new Integer((getCalendar().get(Calendar.YEAR))).toString().trim();
	}

	/**
	 * getMaximum method comment.
	 */
	public int getMaximum(int field) {
		// pedido al calendar
		if (getCalendar() != null)
			return getCalendar().getMaximum(field);
		return 0;
	}

	/**
	 * getMinimum method comment.
	 */
	public int getMinimum(int field) {
		// pedido al calendar
		if (getCalendar() != null)
			return getCalendar().getMinimum(field);
		return 0;
	}

	public int getMonth() {
		/* retorna el número de mes del año: 1-12 */
		return (getCalendar().get(Calendar.MONTH)) + 1;
	}

	public String getMonthAndYearExpression() {

		String mesStr = "";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		switch (mes) {
		case 1:
			mesStr = "ENERO";
			break;
		case 2:
			mesStr = "FEBRERO";
			break;
		case 3:
			mesStr = "MARZO";
			break;
		case 4:
			mesStr = "ABRIL";
			break;
		case 5:
			mesStr = "MAYO";
			break;
		case 6:
			mesStr = "JUNIO";
			break;
		case 7:
			mesStr = "JULIO";
			break;
		case 8:
			mesStr = "AGOSTO";
			break;
		case 9:
			mesStr = "SEPTIEMBRE";
			break;
		case 10:
			mesStr = "OCTUBRE";
			break;
		case 11:
			mesStr = "NOVIEMBRE";
			break;
		case 12:
			mesStr = "DICIEMBRE";
			break;
		default:
			mesStr = "___";
		}

		return mesStr + "-" + new Integer((getCalendar().get(Calendar.YEAR))).toString().trim();
	}

	/**
	 * Este método imprime la representación regional (día mes año) de una fecha
	 * definida por Calendar
	 */
	public String getRegionalDateExpression() {

		String diaStr = "";
		String mesStr = "";
		int dia = getCalendar().get(Calendar.DAY_OF_MONTH);
		if (dia < 10)
			diaStr = "0";
		int mes = (getCalendar().get(Calendar.MONTH)) + 1;
		if (mes < 10)
			mesStr = "0";

		return diaStr + new Integer(dia).toString().trim() + this.dateSeparator + mesStr + new Integer(mes).toString().trim() + this.dateSeparator
				+ new Integer((getCalendar().get(Calendar.YEAR))).toString().trim();

	}

	/**
	 * Este método devuelve una instancia de Date para soporte a persistencia
	 */
	public Date getSqlDate() {
		return new Date(getCalendar().getTime().getTime());
	}

	/**
	 *
	 */
	public Time getSqlTime() {
		return new Time(getCalendar().getTime().getTime());
	}

	/**
	 *
	 */
	private int getWeekDayNumber() {

		/**
		 * retorna el número de día en la semana - Domingo: 0 ... - Sábado: 6
		 */

		return getCalendar().get(Calendar.DAY_OF_WEEK) - 1;
	}

	public int getYear() {

		/* retorna el año en formato de 4 dígitos */

		return getCalendar().get(Calendar.YEAR);
	}

	/**
	 * roll method comment.
	 */
	public void roll(int field, boolean up) {
		// pedido al calendar
		if (getCalendar() != null) {
			getCalendar().roll(field, up);
		}
	}

	/**
	 * roll method comment.
	 */
	public void roll(int field, int amount) {
		// pedido al calendar
		if (getCalendar() != null) {
			getCalendar().roll(field, amount);
		}
	}

	/**
	 * This method was created in VisualAge.
	 *
	 * @param newValue
	 *            GregorianCalendar
	 */
	public void setCalendar(GregorianCalendar newValue) {

		/**
		 * seteo del calendario encapsulado en este manager (wrapper)
		 */

		this.calendar = newValue;
	}

	public int getHoraDelDia() {
		return this.getCalendar().get(Calendar.HOUR_OF_DAY);
	}

	public int getMinutos() {
		return this.getCalendar().get(Calendar.MINUTE);
	}

	/**
	 *
	 */
	public String getTimeExpression() {

		return this.getCalendar().get(Calendar.HOUR_OF_DAY) + getTimeSeparator() + this.getCalendar().get(Calendar.MINUTE) + getTimeSeparator()
				+ this.getCalendar().get(Calendar.SECOND);
	}

	/**
	 *
	 */
	public String getTimeExpression2() {

		int horas = this.getCalendar().get(Calendar.HOUR_OF_DAY);
		int minutos = this.getCalendar().get(Calendar.MINUTE);
		int segundos = this.getCalendar().get(Calendar.SECOND);

		String temp = "";

		if (horas < 10)
			temp = temp + "0" + horas + getTimeSeparator();
		else
			temp = temp + horas + getTimeSeparator();

		if (minutos < 10)
			temp = temp + "0" + minutos + getTimeSeparator();
		else
			temp = temp + minutos + getTimeSeparator();

		if (segundos < 10)
			temp = temp + "0" + segundos;
		else
			temp = temp + segundos;

		return temp;
	}

	/**
	 *
	 */
	public String getTimeExpression3() {
		int hora = this.getCalendar().get(Calendar.HOUR_OF_DAY);
		String horaStr = String.valueOf(hora);
		if (hora < 10) {
			horaStr = "0" + hora;
		}
		int minuto = this.getCalendar().get(Calendar.MINUTE);
		String minutoStr = String.valueOf(minuto);
		if (minuto < 10) {
			minutoStr = "0" + minuto;
		}
		String temp = horaStr + getTimeSeparator() + minutoStr;
		return temp;
	}

	/**
	 *
	 */
	public String toString() {
		return "" + getCalendar().get(Calendar.YEAR) + "-" + (getCalendar().get(Calendar.MONTH) + 1) + "-" + getCalendar().get(Calendar.DAY_OF_MONTH) + "_"
				+ getCalendar().get(Calendar.HOUR_OF_DAY) + ":" + getCalendar().get(Calendar.MINUTE) + ":" + getCalendar().get(Calendar.SECOND);
	}

	/**
	 * @return the dateSeparator
	 */
	public String getDateSeparator() {
		return dateSeparator;
	}

	/**
	 * @param dateSeparator
	 *            the dateSeparator to set
	 */
	public void setDateSeparator(String dateSeparator) {
		this.dateSeparator = dateSeparator;
	}

	/**
	 * @return the timeSeparator
	 */
	public String getTimeSeparator() {
		return timeSeparator;
	}

	/**
	 * @param timeSeparator
	 *            the timeSeparator to set
	 */
	public void setTimeSeparator(String timeSeparator) {
		this.timeSeparator = timeSeparator;
	}
}
