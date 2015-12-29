package efren.util.gui.filechooser;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageFileView extends FileView {
    ImageIcon jpgIcon = new ImageIcon(getClass().getResource("/efren/resources/images/_file_JPEG.gif"));
    ImageIcon gifIcon = new ImageIcon(getClass().getResource("/efren/resources/images/_file_GIF.gif"));
    ImageIcon tiffIcon = new ImageIcon(getClass().getResource("/efren/resources/images/_file_TIFF.gif"));

public String getDescription(File f) {
    return null; // let the L&F FileView figure this out
}
public Icon getIcon(File f) {
    String extension = Utils.getExtension(f);
    Icon icon = null;

    if (extension != null) {
        if (extension.equals(Utils.JPEG) || extension.equals(Utils.JPG)) {
            icon = jpgIcon;
        } else
            if (extension.equals(Utils.GIF)) {
                icon = gifIcon;
            } else
                if (extension.equals(Utils.TIFF) || extension.equals(Utils.TIF) || extension.equals(Utils.PNG)) {
                    icon = tiffIcon;
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
        if (extension.equals(Utils.JPEG) || extension.equals(Utils.JPG)) {
            type = "Imagen JPEG";
        } else
            if (extension.equals(Utils.GIF)) {
                type = "Imagen GIF";
            } else
                if (extension.equals(Utils.TIFF) || extension.equals(Utils.TIF) || extension.equals(Utils.PNG)) {
                    type = "Imagen TIFF";
                }
    }
    return type;
}
public Boolean isTraversable(File f) {
    return null; // let the L&F FileView figure this out
}
}
