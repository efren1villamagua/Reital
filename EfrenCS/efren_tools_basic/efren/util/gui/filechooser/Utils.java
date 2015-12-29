package efren.util.gui.filechooser;

import java.io.File;

public class Utils {

	public final static String JPEG = "jpeg";
	public final static String JPG = "jpg";
	public final static String GIF = "gif";
	public final static String TIFF = "tiff";
	public final static String TIF = "tif";
	public final static String PNG = "png";
	public final static String PDF = "pdf";
	public final static String RTF = "rtf";
	public final static String XLS = "xls";
	public final static String HTML = "html";
	public final static String TXT = "txt";
	public final static String PROPERTIES = "properties";

	/*
	 * Get the extension of a file.
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}
