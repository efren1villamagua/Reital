package efren.util;

import java.awt.Color;
import java.awt.Font;

public class FontManager {

	public static final Color BUTTON_COLOR_NORMAL = new Color(80, 80, 80);
	public static final Color BUTTON_COLOR_RESALTADO = new Color(102, 102, 255);

	public FontManager() {
		super();
	}

	private static String currentFontName() {
		return "Arial";
	}

	private static int currentFontSize() {
		return 10;
	}

	public static Font currentSystemBoldFont() {
		return new Font(currentFontName(), Font.BOLD, currentFontSize());
	}

	public static Font currentSystemItalicFont() {
		return new Font(currentFontName(), Font.ITALIC, currentFontSize());
	}

	public static Font currentSystemPlainFont() {
		return new Font(currentFontName(), Font.PLAIN, currentFontSize());
	}
}
