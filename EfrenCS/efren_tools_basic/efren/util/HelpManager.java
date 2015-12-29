package efren.util;

import efren.util.config.SystemProperties;

public class HelpManager implements java.awt.event.ActionListener {
    private static HelpManager singleton = null;
private HelpManager() {
    super();
}
public void actionPerformed(java.awt.event.ActionEvent e) {
    this.help();
}
public void help() {
    javax.swing.JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
    String frameName = null;
    for (int i = 0; i < jdp.getAllFrames().length; i++) {
        if (jdp.getAllFrames()[i].isSelected())
            frameName = jdp.getAllFrames()[i].getClass().getName();
    }
    String url = "http://" + SystemProperties.HOST_NAME + "/" + SystemProperties.HELP_WEB_PATH + "/";
    if (frameName == null)
        url = url + "index.html";
    else
        url = url + frameName + ".html";
    BrowserManager.displayURL(url);
}
public static HelpManager singleton() {
    if (singleton == null)
        singleton = new HelpManager();
    return singleton;
}
}
