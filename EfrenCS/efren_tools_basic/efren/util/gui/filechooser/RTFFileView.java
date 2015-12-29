package efren.util.gui.filechooser;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

public class RTFFileView extends FileView {
    ImageIcon rtfIcon = new ImageIcon(getClass().getResource("/efren/resources/images/_file_RTF.gif"));
public String getDescription(File f) {
    return null; // let the L&F FileView figure this out
}
public Icon getIcon(File f) {
    String extension = Utils.getExtension(f);
    Icon icon = null;

    if (extension != null) {
        if (extension.equals(Utils.RTF)) {
            icon = this.rtfIcon;
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
        if (extension.equals(Utils.RTF)) {
            type = "Rich Text Format";
        }
    }
    return type;
}
public Boolean isTraversable(File f) {
    return null; // let the L&F FileView figure this out
}
}
