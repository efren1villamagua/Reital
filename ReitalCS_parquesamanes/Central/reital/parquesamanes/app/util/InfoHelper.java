package reital.parquesamanes.app.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import efren.util.SystemLogManager;

public class InfoHelper {

	private static String VOLATILE_1 = null;
	private static String VOLATILE_2 = null;

	public static void logCharset() {
		systemStarted(VOLATILE_1, VOLATILE_2);
		SystemLogManager.info("Default Charset=" + Charset.defaultCharset());
		SystemLogManager.info("Default Charset in Use=" + getDefaultCharSet());
	}

	private static String getDefaultCharSet() {
		OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
		String enc = writer.getEncoding();
		return enc;
	}

	public static void systemStarted(String nombreSistema, String postFix) {
		SystemLogManager.info("Sistema \"" + nombreSistema + "\" iniciado");
		VOLATILE_1 = nombreSistema;
		VOLATILE_2 = postFix;
		System.setProperty("reital.parquesamanes.nombreSistema", nombreSistema + "-" + postFix);
	}

}
