package efren.util;

import efren.util.config.SystemProperties;

public class ABMViewManager implements java.awt.event.ActionListener {
    private static ABMViewManager singleton = null;
private ABMViewManager() {
    super();
}
public void actionPerformed(java.awt.event.ActionEvent e) {
    this.cerrarVentanaActiva();
}
public void cerrarVentanaActiva() {
    javax.swing.JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
    for (int i = 0; i < jdp.getAllFrames().length; i++) {
        if (jdp.getAllFrames()[i].isSelected()) {
        	try {
                MethodInvocation.performMethod("_cerrar", jdp.getAllFrames()[i]);
                break;
			} catch (Throwable t) {
				t.getMessage();
				MethodInvocation.performMethod("dispose", jdp.getAllFrames()[i]);
			}
        }
    }
}
public static ABMViewManager singleton() {
    if (singleton == null)
        singleton = new ABMViewManager();
    return singleton;
}
}
