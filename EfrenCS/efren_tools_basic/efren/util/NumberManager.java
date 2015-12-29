package efren.util;

/**
 * This type was created in VisualAge.
 */
public class NumberManager {
/**
 * NumberManager constructor comment.
 */
public NumberManager() {
	super();
}
public static String formatNumber(double valorFinal) {
	valorFinal = truncateFloat(valorFinal, 3);
	java.text.DecimalFormatSymbols unusualSymbols = new java.text.DecimalFormatSymbols();
	unusualSymbols.setDecimalSeparator('.');
	unusualSymbols.setGroupingSeparator(',');
	String strange = "#,##0.000";
	java.text.DecimalFormat weirdFormatter = new java.text.DecimalFormat(strange, unusualSymbols);
	return weirdFormatter.format(valorFinal);
}
public static String formatNumber(double valorFinal, int posicionDecimal) {
	valorFinal = truncateFloat(valorFinal, posicionDecimal);
	java.text.DecimalFormatSymbols unusualSymbols = new java.text.DecimalFormatSymbols();
	unusualSymbols.setDecimalSeparator('.');
	unusualSymbols.setGroupingSeparator(',');
	String strange = "#,##0.000";
	java.text.DecimalFormat weirdFormatter = new java.text.DecimalFormat(strange, unusualSymbols);
	return weirdFormatter.format(valorFinal);
}
public static double formatNumberDouble(double valorFinal) {
	valorFinal = truncateFloat(valorFinal, 3);
	java.text.DecimalFormatSymbols unusualSymbols = new java.text.DecimalFormatSymbols();
	unusualSymbols.setDecimalSeparator('.');
	unusualSymbols.setGroupingSeparator(',');
	String strange = "#,##0.000";
	java.text.DecimalFormat weirdFormatter = new java.text.DecimalFormat(strange, unusualSymbols);
	return (new Double(weirdFormatter.format(valorFinal))).doubleValue();
}
public static double truncateFloat(double f, int i) {
	/*	double d = Math.pow(10D, i);
	f = ((double) Math.floor((double) f * d) / d);
	return f;*/
	String unString = String.valueOf(f);
	int longitudString = unString.length();
	int posicionPunto = unString.indexOf(".");
	if (longitudString > (posicionPunto + i + 1)) {
		unString=unString.substring(0, posicionPunto + i + 1);
	}
	return (new Double(unString)).doubleValue();
}
public static float truncateFloat(float f, int i) {
	/*		double d = Math.pow(10D, i);
	f = (float)((double)Math.floor((double)f * d) / d);
	return f;*/
	String unString = String.valueOf(f);
	int longitudString = unString.length();
	int posicionPunto = unString.indexOf(".");
	if (longitudString > (posicionPunto + i + 1)) {
		unString=unString.substring(0, posicionPunto + i + 1);
	}
	return (new Float(unString)).floatValue();
}
}
