package efren.util.gui.filechooser;

import java.io.File;
import javax.swing.filechooser.*;

public class HTMLFilter extends FileFilter {

// Accept all directories and all gif, jpg, or tiff files.
public boolean accept(File f) {
    if (f.isDirectory()) {
        return true;
    }

    String extension = Utils.getExtension(f);
    if (extension != null) {
        if (extension.equals(Utils.HTML)) {
            return true;
        } else {
            return false;
        }
    }

    return false;
}
// The description of this filter
public String getDescription() {
    return "Archivo del Web HTML";
}
}
