package efren.util.gui.filechooser;

import java.util.EventListener;

public interface FileChooserSelectedFileListener extends EventListener {

	public void selectedFile(FileChooserEvent event);
}
