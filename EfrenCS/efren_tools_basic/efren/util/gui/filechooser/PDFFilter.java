package efren.util.gui.filechooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PDFFilter extends FileFilter {

// Accept all directories and all gif, jpg, or tiff files.
public boolean accept(File f) {
    if (f.isDirectory()) {
        return true;
    }

    String extension = Utils.getExtension(f);
    if (extension != null) {
        if (extension.equals(Utils.PDF)) {
            return true;
        } else {
            return false;
        }
    }

    return false;
}
// The description of this filter
public String getDescription() {
    return "Adobe Acrobat";
}
}
