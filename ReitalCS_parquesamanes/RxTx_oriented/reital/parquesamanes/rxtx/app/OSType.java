package reital.parquesamanes.rxtx.app;

public enum OSType {

	WINDOWS, UNIX_LINUX, MAC_OS, SOLARIS;

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static OSType getOS() {
		if (isWindows()) {
			return OSType.WINDOWS;
		} else {
			if (isUnixLinux()) {
				return OSType.UNIX_LINUX;
			} else {
				if (isMac()) {
					return OSType.MAC_OS;
				} else {
					if (isSolaris()) {
						return OSType.SOLARIS;
					}
				}
			}
		}
		return null;
	}

	private static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	private static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	private static boolean isUnixLinux() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	private static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
}
