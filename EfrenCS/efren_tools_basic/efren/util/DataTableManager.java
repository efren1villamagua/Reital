package efren.util;

import efren.util.config.SystemProperties;

public class DataTableManager implements java.awt.event.ActionListener {
    private static DataTableManager singleton = null;
private DataTableManager() {
    super();
}
public void actionPerformed(java.awt.event.ActionEvent e) {
    this.dataUpdate();
}
public void dataUpdate() {
    javax.swing.JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
    javax.swing.JInternalFrame jif = null;
    for (int i = 0; i < jdp.getAllFrames().length; i++) {
        if (jdp.getAllFrames()[i].isSelected()) {
            jif = jdp.getAllFrames()[i];
            break;
        }
    }

    try {
        for (int i = 0; i < jif.getContentPane().getComponents().length; i++) {
            if (jif.getContentPane().getComponents()[i] instanceof efren.util.gui.table.DataTablePanel) {
                MethodInvocation.performMethod("forceFireBuscarPerformed", jif.getContentPane().getComponents()[i]);
            }
        }
    } catch (Throwable t2) {
        t2.getMessage();
    }

}
public static DataTableManager singleton() {
    if (singleton == null)
        singleton = new DataTableManager();
    return singleton;
}
}
