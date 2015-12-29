/*
 * Creado el 07-dic-2005
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package efren.util;

/**
 * @author efren
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class PathManager {

	/**
	 * 
	 */
	public PathManager() {
		super();
	}
	
	public static String parsePath(String unPath) {
		String ruta = unPath;
		try {
			String osName = System.getProperty("os.name").toUpperCase();
			if (osName.startsWith("WINDOWS")) {
				ruta = StringTools.replaceAll(ruta, "%20", " ", false);
			}
		} catch (Throwable t) {
			t.getMessage();
		}
		return ruta;
	}
}