package efren.util.gui.filechooser;

import java.io.File;
import java.util.EventObject;

public class FileChooserEvent extends EventObject {
	/**
	 *
	 */
	private static final long serialVersionUID = -197098277348979227L;

	private File selectedFile;

	public FileChooserEvent(Object objetoFuente, File aSelectedFile) {
		super(objetoFuente);
		this.selectedFile = aSelectedFile;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

}
