package efren.util;

/**
 * This type was created in VisualAge.
 */
public class LabelsParser {
/**
 * LabelsParser constructor comment.
 */
public LabelsParser() {
	super();
}
public static String parseClasificacion(String clasificacion) {
	if (clasificacion.trim().compareTo("L") == 0)
		return "Ley";
	if (clasificacion.trim().compareTo("V") == 0)
		return "Varios";
	if (clasificacion.trim().compareTo("D") == 0)
		return "D�cimo";
	if (clasificacion.trim().compareTo("B") == 0)
		return "Bonificaci�n";
	return "No definido";
}
}
