package efren.util;

import java.io.IOException;

public class BrowserManager
{

    private static final String WIN_ID = "Windows";
    private static final String WIN_PATH = "rundll32";
    private static final String WIN_FLAG = "url.dll,FileProtocolHandler";
    private static final String UNIX_PATH = "netscape";
    private static final String UNIX_FLAG = "-remote openURL";
    public BrowserManager()
    {
    }
    public static void displayURL(String s)
    {
        boolean flag = isWindowsPlatform();
        String s1 = null;
        try
        {
            if(flag)
            {
                s1 = getWinCommand() + " /c start " + s;
                Process process = Runtime.getRuntime().exec(s1);
            } else
            {
                s1 = "netscape -remote openURL(" + s + ")";
                Process process1 = Runtime.getRuntime().exec(s1);
                try
                {
                    int i = process1.waitFor();
                    if(i != 0)
                    {
                        s1 = "netscape " + s;
                        Process process2 = Runtime.getRuntime().exec(s1);
                    }
                }
                catch(InterruptedException interruptedexception)
                {
                    System.err.println("Error bringing up browser, cmd='" + s1 + "'");
                }
            }
        }
        catch(IOException ioexception)
        {
            System.err.println("Could not invoke browser, command=" + s1);
        }
    }
    public static String getWinCommand()
    {
        if(!isWindowsPlatform())
            return null;
        String s = System.getProperty("os.name").toLowerCase();
        if(s.indexOf("nt") >= 0 || s.indexOf("2000") >= 0 || s.indexOf("xp") >= 0)
            return "cmd.exe";
        else
            return "command.com";
    }
    public static boolean isWindowsPlatform()
    {
        String s = System.getProperty("os.name");
        return s != null && s.startsWith("Windows");
    }
}
