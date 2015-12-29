package efren.util;

import efren.util.config.Constantes;
import efren.util.config.SystemProperties;

public class WindowListManager implements java.awt.event.ActionListener {
    private static WindowListManager singleton = null;
private WindowListManager() {
    super();
}
public void actionPerformed(java.awt.event.ActionEvent e) {
    try {
        javax.swing.JInternalFrame frame =
            (javax.swing.JInternalFrame) ((efren.util.menu.MenuItem) e.getSource()).getAgregado();
        this.bringWindow(frame);
    } catch (Throwable t) {
        t.getMessage();
    }
}
public void bringWindow(javax.swing.JInternalFrame aFrame) {

    javax.swing.JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
    javax.swing.JInternalFrame frame = null;
    for (int i = 0; i < jdp.getAllFrames().length; i++) {

        frame = jdp.getAllFrames()[i];

        if (frame == aFrame) {
            try {
                if (frame.isIcon())
                    frame.setIcon(false);
                frame.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
                e.getMessage();
            }
            frame.toFront();
            break;
        }
    }
}
public static WindowListManager singleton() {
    if (singleton == null)
        singleton = new WindowListManager();
    return singleton;
}
}
