package efren.util;

/**
 * This type was created in VisualAge.
 */
public class ObjectFormatter {
	/**
	 * TsObjectFormatter constructor comment.
	 */
	public ObjectFormatter() {
		super();
	}

	/**
	 * retorna la representaci�n en cadena de caracteres del n�mero par�metro.
	 */
	public static String format(Integer number) {
		if (number == null)
			return "";

		return StringTools.parseFromNumberToInteger(number.toString());
	}

	/**
	 * retorna la representaci�n en cadena de caracteres del n�mero par�metro.
	 */
	public static String format(Long number) {
		if (number == null)
			return "";

		return StringTools.parseFromNumberToInteger(number.toString());
	}

	public static String format(Object o) {
		if (o == null)
			return "";
		if (o instanceof java.math.BigDecimal)
			return format((java.math.BigDecimal) o);

		if (o instanceof Integer)
			return format((Integer) o);
		return o.toString();
	}

	/**
	 * retorna la representaci�n en cadena de caracteres del n�mero par�metro.
	 */
	public static String format(java.math.BigDecimal bd) {
		if (bd == null)
			return "";

		return StringTools.parseFromNumberToQuantity(bd);
	}
}
