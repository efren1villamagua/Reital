package efren.util;

import org.apache.log4j.Logger;

import efren.util.gui.ConsoleDialog;

public class SystemLogManager {

	private static Logger loggerObject = null;

	/**
	 * debug
	 */
	public static void debug(String outString) {
		debug(outString, null);
	}

	public static void debug(String outString, Throwable t) {
		debug(outString, t, SystemLogManager.loggerObject);
	}

	public static void debug(String outString, Throwable t, Logger unLogger) {
		Logger loggerTemp = SystemLogManager.loggerObject;
		if (unLogger != null) {
			loggerTemp = unLogger;
		}
		try {
			if (t == null) {
				loggerTemp.debug(outString);
			} else {
				loggerTemp.debug(outString, t);
			}
		} catch (Exception e) {
			System.out.println(outString + " [LOGGER ERROR: " + e.getMessage() + "]");
		}
		try {
			ConsoleDialog.singleton().addMessage(outString);
		} catch (Exception e) {
			System.out.println(outString + " [" + e.getMessage() + "]");
		}
	}

	/**
	 * info
	 */
	public static void info(String outString) {
		info(outString, null);
	}

	public static void info(String outString, Throwable t) {
		info(outString, t, SystemLogManager.loggerObject);
	}

	public static void info(String outString, Throwable t, Logger unLogger) {
		Logger loggerTemp = SystemLogManager.loggerObject;
		if (unLogger != null) {
			loggerTemp = unLogger;
		}
		try {
			if (t == null) {
				loggerTemp.info(outString);
			} else {
				loggerTemp.info(outString, t);
			}
		} catch (Exception e) {
			System.out.println(outString + " [LOGGER ERROR: " + e.getMessage() + "]");
		}
		try {
			ConsoleDialog.singleton().addMessage(outString);
		} catch (Exception e) {
			System.out.println(outString + " [" + e.getMessage() + "]");
		}
	}

	/**
	 * warn
	 */
	public static void warn(String outString) {
		warn(outString, null);
	}

	public static void warn(String outString, Throwable t) {
		warn(outString, t, SystemLogManager.loggerObject);
	}

	public static void warn(String outString, Throwable t, Logger unLogger) {
		Logger loggerTemp = SystemLogManager.loggerObject;
		if (unLogger != null) {
			loggerTemp = unLogger;
		}
		try {
			if (t == null) {
				loggerTemp.warn(outString);
			} else {
				loggerTemp.warn(outString, t);
			}
		} catch (Exception e) {
			System.out.println(outString + " [LOGGER ERROR: " + e.getMessage() + "]");
		}
		try {
			ConsoleDialog.singleton().addMessage(outString);
		} catch (Exception e) {
			System.out.println(outString + " [" + e.getMessage() + "]");
		}
	}

	/**
	 * error
	 */
	public static void error(String outString) {
		error(outString, null);
	}

	public static void error(String outString, Throwable t) {
		error(outString, t, SystemLogManager.loggerObject);
	}

	public static void error(Throwable t) {
		error(t == null ? "" : t.getMessage(), t, SystemLogManager.loggerObject);
	}

	public static void error(String outString, Throwable t, Logger unLogger) {
		Logger loggerTemp = SystemLogManager.loggerObject;
		if (unLogger != null) {
			loggerTemp = unLogger;
		}
		try {
			if (t == null) {
				loggerTemp.error(outString);
			} else {
				loggerTemp.error(outString, t);
			}
		} catch (Exception e) {
			System.out.println(outString + " [LOGGER ERROR: " + e.getMessage() + "]");
		}
		try {
			ConsoleDialog.singleton().addMessage(outString);
		} catch (Exception e) {
			System.out.println(outString + " [" + e.getMessage() + "]");
		}
	}

	/**
	 * fatal
	 */
	public static void fatal(String outString) {
		fatal(outString, null);
	}

	public static void fatal(String outString, Throwable t) {
		fatal(outString, t, SystemLogManager.loggerObject);
	}

	public static void fatal(String outString, Throwable t, Logger unLogger) {
		Logger loggerTemp = SystemLogManager.loggerObject;
		if (unLogger != null) {
			loggerTemp = unLogger;
		}
		try {
			if (t == null) {
				loggerTemp.fatal(outString);
			} else {
				loggerTemp.fatal(outString, t);
			}
		} catch (Exception e) {
			System.out.println(outString + " [LOGGER ERROR: " + e.getMessage() + "]");
		}
		try {
			ConsoleDialog.singleton().addMessage(outString);
		} catch (Exception e) {
			System.out.println(outString + " [" + e.getMessage() + "]");
		}
	}

	/**
	 *
	 */
	public static Logger getLogger() {
		return loggerObject;
	}

	public static void setLogger(Logger unLogger) {
		loggerObject = unLogger;
	}
}