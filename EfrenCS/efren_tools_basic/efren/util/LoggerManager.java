package efren.util;

import java.io.File;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import efren.util.config.Constantes;

public class LoggerManager {

	public static final Logger logger = Logger.getLogger("System logs manager");

	public static void init(String name) {
		if (name != null) {
			name = name.replaceAll(" ", "_");
		}
		// La configuración del logger debe ser por medio de un archivo de
		// configuración
		// para de esta manera configurar en runtime la forma en que saldrá el
		// log.

		// se crea un logger con un período de rotación fijo
		DailyRollingFileAppender appender = new DailyRollingFileAppender();
		// se imprime todos los niveles de logs
		appender.setThreshold(Level.ALL);
		// se forza la actualización automática del logger
		appender.setImmediateFlush(true);

		PatternLayout layout = new PatternLayout();
		// definición del formato del log
		boolean timestamp = true;
		boolean claseJava = true;
		boolean metodoJava = true;

		String patternStr = "%-5p ";
		if (timestamp) {
			patternStr = patternStr + "%d{yyyy-MM-dd::HH:mm:ss.SSS} ";
		}
		if (claseJava) {// esta opción podría hacer un poco más lenta
			patternStr = patternStr + "%C";
		}
		if (metodoJava) {
			if (claseJava) {
				patternStr = patternStr + "..";
			}
			patternStr = patternStr + "%M ";
		}
		patternStr = patternStr + ">> %m%n";

		layout.setConversionPattern(patternStr);
		// Only after caling the activateOptions method do the
		// conversion rule and conversion pattern have an effect.
		// layout.activateOptions();

		// SimpleLayout layout = new SimpleLayout();
		appender.setLayout(layout);

		// archivo en donde se crea el Log
		File logsDirectory = new File(Constantes.LOGS_DIR);

		appender.setFile(logsDirectory.getAbsolutePath() + "/" + name + ".log");
		// se define que el archivo se renueve de nombre cada media noche
		appender.setDatePattern("'.'yyyy-MM-dd");
		appender.setAppend(true);
		appender.activateOptions();

		logger.addAppender(appender);
		logger.setLevel((Level) Level.ALL);
	}
}