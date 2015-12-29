package efren.util.gui.filechooser;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class HTMLFileView extends FileView {
    ImageIcon htmlIcon = new ImageIcon(getClass().getResource("/efren/resources/images/_file_HTML.gif"));
public String getDescription(File f) {
    return null; // let the L&F FileView figure this out
}
public Icon getIcon(File f) {
    String extension = Utils.getExtension(f);
    Icon icon = null;

    if (extension != null) {
        if (extension.equals(Utils.HTML)) {
            icon = this.htmlIcon;
        }
    }
    return icon;
}
public String getName(File f) {
    return null; // let the L&F FileView figure this out
}
public String getTypeDescription(File f) {
    String extension = Utils.getExtension(f);
    String type = null;

    if (extension != null) {
        if (extension.equals(Utils.HTML)) {
            type = "Archivo del Web HTML";
        }
    }
    return type;
}
public Boolean isTraversable(File f) {
    return null; // let the L&F FileView figure this out
}
}
