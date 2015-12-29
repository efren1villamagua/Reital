package efren.util;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Insert the type's description here. Creation date: (2002-08-27 12:05:53)
 *
 * @author: Leonor de Villamagua
 */
public class StringTools {
	public final static int DIRECCION_DERECHA = 1;

	public final static int DIRECCION_IZQUIERDA = 2;

	public static String convertIntegerTo4Chars(int number) {
		if (number <= 9)
			return "000" + String.valueOf(number).trim();
		if (number <= 99)
			return "00" + String.valueOf(number).trim();
		if (number <= 999)
			return "0" + String.valueOf(number).trim();
		return String.valueOf(number).trim();
	}

	public static String eliminarBasura(String s) {
		String s1 = eliminarEnies(s);
		s1 = eliminarTildes(s1);
		s1 = eliminarSubRayados(s1);

		return s1;
	}

	public static String eliminarDosPuntosYEspacios(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		String temp = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == ':' || c == ' ')
				temp = temp + "_";
			else
				temp = temp + String.valueOf(c);
		}
		return temp;
	}

	private static String eliminarEnies(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		String temp = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
			case 'Ñ':
				temp = temp + "NI";
				break;
			case 'ñ':
				temp = temp + "ni";
				break;
			default:
				temp = temp + String.valueOf(c);
			}
		}
		return temp;
	}

	private static String eliminarSubRayados(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		String temp = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '_')
				temp = temp + " ";
			else
				temp = temp + String.valueOf(c);
		}
		return temp;
	}

	private static String eliminarTildes(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		String temp = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
			case 'Á':
				temp = temp + "A";
				break;
			case 'É':
				temp = temp + "E";
				break;
			case 'Í':
				temp = temp + "I";
				break;
			case 'Ó':
				temp = temp + "O";
				break;
			case 'Ú':
				temp = temp + "U";
				break;
			case 'á':
				temp = temp + "a";
				break;
			case 'é':
				temp = temp + "e";
				break;
			case 'í':
				temp = temp + "i";
				break;
			case 'ó':
				temp = temp + "o";
				break;
			case 'ú':
				temp = temp + "u";
				break;
			default:
				temp = temp + String.valueOf(c);
			}
		}
		return temp;
	}

	public static String parse_SQL_CHAR_Arg(Object sqlArg) {
		if (sqlArg == null)
			return null;
		if (sqlArg.toString().trim().length() == 0)
			return "";
		String temp = parseComilla(sqlArg.toString());
		temp = temp.toString().trim().toUpperCase().replace('*', '%');
		return temp;
	}

	/**
	 * se quita todas las ' y todas las "
	 */
	/*
	 * public static String parseComilla(String s) { if (s == null ||
	 * s.trim().length() == 0) return s; StringBuffer sb = new StringBuffer("");
	 * for (int i = 0; i < s.length(); i++) if (s.charAt(i) != '\'' &&
	 * s.charAt(i) != '"') sb.append(s.charAt(i)); return sb.toString(); }
	 */
	public static String parseComilla(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '\'') {
				try {
					if (sb == null)
						throw new IOException("Solo por compatibilidad entre versiones de JDK");
					sb.append('\'').append(s.charAt(i));
				} catch (IOException e) {
					e.getMessage();
				}
			} else {
				try {
					if (sb == null)
						throw new IOException("Solo por compatibilidad entre versiones de JDK");
					sb.append(s.charAt(i));
				} catch (IOException e) {
					e.getMessage();
				}
			}
		return sb.toString();
	}

	public static String parseDateFromDMYToISO(String aDate) {

		return CalendarManager.convertir_DMYstr_ISOstr(aDate);
	}

	public static String parseDateFromISOToDMY(java.sql.Date aDate) {

		return CalendarManager.convertir_Date_DMYstr(aDate);
	}

	public static String parseFromMoneyToNumber(String s) {
		return parseOnlyNumbers(s);
	}

	public static String parseFromNumberToInteger(String arg0) {

		String arg1 = parseOnlyNumbers(arg0);

		java.math.BigDecimal arg2 = new java.math.BigDecimal(arg1.trim());

		String temp = parseFromNumberToQuantity(arg2);
		if (temp.indexOf('.') > 0)
			temp = temp.substring(0, temp.lastIndexOf('.'));

		return temp;
	}

	public static String parse_object_to_money(String arg) {
		/**
		 * SOLO POR COMPATIBILIDAD, NO USAR EN NUEVOS METODOS
		 */
		try {
			BigDecimal n = new BigDecimal(arg.trim());
			return parseFromNumberToMoney(n);
		} catch (Exception e) {
			e.getMessage();
		}
		return "";
	}

	public static String parse_object_to_decimal(String arg) {
		/**
		 * SOLO POR COMPATIBILIDAD, NO USAR EN NUEVOS METODOS
		 */
		try {
			BigDecimal n = new BigDecimal(arg.trim());
			parseFromNumberToQuantity(n);
		} catch (Exception e) {
			e.getMessage();
		}
		return "";
	}

	public static String parseFromNumberToMoney(java.math.BigDecimal aNumber) {

		return "$" + parseFromNumberToQuantity(aNumber);
	}

	public static String parseFromNumberToMoney(java.math.BigDecimal aNumber, int aScale) {

		return "$" + parseFromNumberToQuantity(aNumber, aScale);
	}

	public static String parseFromNumberToQuantity(java.math.BigDecimal arg1) {

		return parseFromNumberToQuantity(arg1, 2);
	}

	public static String parseFromNumberToQuantity(java.math.BigDecimal arg1, int aScale) {

		if (arg1 == null)
			return null;

		int dc = 0;

		if (aScale < 0)
			dc = 2;
		else
			dc = aScale;

		double aNumber = arg1.setScale(dc, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();

		boolean negativo = false;
		if (aNumber < 0)
			negativo = true;

		if (negativo)
			aNumber = aNumber * (-1.00);

		// ...parte entera
		long enteraNumber = (long) aNumber;
		String entera = String.valueOf(enteraNumber);

		if (entera.length() == 0)
			entera = "0";

		String temp = "";
		int j = 1;
		for (int i = entera.length() - 1; i >= 0; i--) {
			temp = "" + entera.charAt(i) + temp;
			if (j == 3 && entera.length() != 3)
				temp = "," + temp;
			if (j == 6 && entera.length() != 6)
				temp = "," + temp;
			if (j == 9 && entera.length() != 9)
				temp = "," + temp;
			j++;
		}

		// parte decimal
		String decimal = "0";
		// para evitar formatos extraños como 'E7'
		aNumber = new java.math.BigDecimal(aNumber - enteraNumber).setScale(dc, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if (String.valueOf(aNumber).indexOf(".") >= 0)
			decimal = String.valueOf(aNumber).substring(String.valueOf(aNumber).lastIndexOf(".") + 1).trim();
		int decimalLength = decimal.length();
		if (decimal.length() < dc) {
			for (int i = 0; i < dc - decimalLength; i++) {
				decimal = decimal + "0";
			}
		}

		// todo el número
		temp = temp + "." + decimal;

		if (negativo)
			temp = "-" + temp;

		return temp;
	}

	public static String parseFromQuantityToNumber(String s) {
		return parseFromMoneyToNumber(s);
	}

	public static String parseOnlyNumbers(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		String temp = "";
		char c;
		boolean yaHayDigito = false;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			yaHayDigito = Character.isDigit(c);

			if (Character.isDigit(c) || c == '.')
				temp = temp + c;
			if (c == '-' && !yaHayDigito)// para que el signo menos solo
											// aparezca al inicio
				temp = temp + c;
		}
		return temp;
	}

	public static String rellenar(String stringOriginal, String relleno, int vecesRelleno) {

		return rellenar(stringOriginal, relleno, vecesRelleno, DIRECCION_DERECHA);
	}

	public static String rellenar(String stringOriginal, String relleno, int vecesRelleno, int direccion) {
		if (stringOriginal == null || relleno == null || vecesRelleno < 0)
			return null;
		String resultado = "";
		for (int i = 0; i < vecesRelleno; i++) {
			resultado = resultado + relleno;
		}
		if (direccion == DIRECCION_DERECHA)
			resultado = stringOriginal + resultado;
		else
			resultado = resultado + stringOriginal;

		return resultado;
	}

	public static String replaceAll(String originalString, String oldValue, String newValue, boolean caseSensitive) {
		try {
			int index = 0;
			String newString = originalString;
			if (caseSensitive)
				index = newString.indexOf(oldValue);
			else
				index = newString.toUpperCase().indexOf(oldValue.toUpperCase());
			while (index >= 0) {
				if (index == 0) {
					// el string a reemplazar está al inicio
					newString = newValue + newString.substring(index + oldValue.length());
				} else {
					if (index == newString.length() - oldValue.length()) {
						// el string a reemplazar está al final
						newString = newString.substring(0, index) + newValue;
					} else {
						// el string a reemplazar está en medio
						newString = newString.substring(0, index) + newValue + newString.substring(index + oldValue.length());
					}
				}
				if (caseSensitive)
					index = newString.indexOf(oldValue);
				else
					index = newString.toUpperCase().indexOf(oldValue.toUpperCase());
			}
			return newString;
		} catch (Throwable t) {
			t.getMessage();
			return originalString;
		}
	}
	public static String replaceFirstOcurrence(String originalString, String oldValue, String newValue, boolean caseSensitive) {
		try {
			int index = 0;
			String newString = originalString;
			if (caseSensitive) {
				index = newString.indexOf(oldValue);
			} else {
				index = newString.toUpperCase().indexOf(oldValue.toUpperCase());
			}

			if (index == 0) {
				// el string a reemplazar está al inicio
				newString = newValue + newString.substring(index + oldValue.length());
			} else {
				if (index == newString.length() - oldValue.length()) {
					// el string a reemplazar está al final
					newString = newString.substring(0, index) + newValue;
				} else {
					// el string a reemplazar está en medio
					newString = newString.substring(0, index) + newValue + newString.substring(index + oldValue.length());
				}
			}

			return newString;

		} catch (Throwable t) {
			t.getMessage();
			return originalString;
		}
	}
}
