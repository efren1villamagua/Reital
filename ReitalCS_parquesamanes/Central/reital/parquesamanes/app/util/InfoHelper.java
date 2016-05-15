package reital.parquesamanes.app.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import efren.util.SystemLogManager;

public class InfoHelper {

	private static String VOLATILE_1 = null;

	public static void logCharset() {
		systemStarted(VOLATILE_1);
		SystemLogManager.info("Default Charset=" + Charset.defaultCharset());
		SystemLogManager.info("Default Charset in Use=" + getDefaultCharSet());
	}

	private static String getDefaultCharSet() {
		OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
		String enc = writer.getEncoding();
		return enc;
	}

	public static void systemStarted(String nombreSistema) {
		SystemLogManager.info("Sistema \"" + nombreSistema + "\" iniciado");
		VOLATILE_1 = nombreSistema;
	}

}
