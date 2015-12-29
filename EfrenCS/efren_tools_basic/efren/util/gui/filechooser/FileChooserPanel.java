package efren.util.gui.filechooser;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import efren.util.ExceptionManager;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.panels.PanelExt;
import efren.util.gui.panels.TitledPanel;
import efren.util.gui.text.TextAreaExt;

public class FileChooserPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -8293960559843567086L;

	private JButton ivjJButton1 = null;

	private File ivjaFile = null;

	private String fileExtension;

	private TitledPanel titledPanel = null; // @jve:decl-index=0:visual-constraint="10,121"

	private PanelExt panelExt = null;

	private boolean textFieldEnabled = true;

	private JFileChooser jFileChooser = null;  //  @jve:decl-index=0:visual-constraint="250,140"

	private Vector<FileChooserSelectedFileListener> escuchadores = null;  //  @jve:decl-index=0:

	private TextAreaExt textAreaExt = null;

	/**
	 *
	 */
	public FileChooserPanel() {
		super();
		initialize();
	}
	/**
	 *
	 */
	public FileChooserPanel(java.awt.LayoutManager layout) {
		super(layout);
	}
	/**
	 *
	 */
	public FileChooserPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	/**
	 *
	 */
	public FileChooserPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 *
	 */
	private java.io.File getaFile() {
		return ivjaFile;
	}

	/**
	 *
	 */
	public java.io.File getFileChanged() {
		return getaFile();
	}

	/**
	 *
	 */
	public java.lang.String getFileExtension() {
		return fileExtension;
	}

	/**
	 *
	 */
	public String getFullFilePath() {
		return getJFileChooser().getSelectedFile().getAbsolutePath();
	}

	/**
	 *
	 */
	private javax.swing.JButton getJButton1() {
		if (ivjJButton1 == null) {
			ivjJButton1 = new javax.swing.JButton();
			ivjJButton1.setName("JButton1");
			ivjJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/folder_open.png")));
			ivjJButton1.setOpaque(false);
			ivjJButton1.setContentAreaFilled(false);
			ivjJButton1.setBorderPainted(false);
			ivjJButton1.setBorder(null);
			ivjJButton1.setMargin(new Insets(0, 0, 0, 0));
			ivjJButton1.setText("");
			ivjJButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					ivjJButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					ivjJButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			final JPanel thisContainer = this;
			ivjJButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						getJFileChooser().setCurrentDirectory(getSelectedFile());
					} catch (Exception exc2) {
						exc2.getMessage();
					}
					getJFileChooser().setDialogTitle(getTitulo());
					getJFileChooser().showDialog(thisContainer, "Aceptar");
				}
			});
		}
		return ivjJButton1;
	}

	/**
	 *
	 */
	public java.io.File getSelectedFile() {
		return getJFileChooser().getSelectedFile();
	}

	/**
	 *
	 */
	public String getTitulo() {
		return getTitledPanel().getTitle();
	}

	/**
	 *
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.weightx = 1.0D;
		gridBagConstraints2.weighty = 1.0D;
		gridBagConstraints2.gridheight = 1;
		gridBagConstraints2.gridx = 1;
		setName("FileChooserPanel");
		setBorder(new javax.swing.border.EtchedBorder());
		setLayout(new java.awt.GridBagLayout());
		setSize(407, 97);
		this.add(getTitledPanel(), gridBagConstraints2);
	}

	/**
	 *
	 */
	public boolean isDataMissing() {

		if (getJFileChooser().getSelectedFile() == null) {
			InfoView.showErrorDialog(this, "¡ Seleccione un archivo !");
			this.requestFocus();
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	public boolean isDataMissing(String errorMessage) {

		if (getJFileChooser().getSelectedFile() == null) {
			InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	private void setaFile(File newValue) {
		fireSelectedFile(jFileChooser.getSelectedFile());
	}

	/**
	 *
	 */
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		if (this.textFieldEnabled) {
			getTextAreaExt().setEnabled(b);
		} else {
			getTextAreaExt().setEnabled(false);
		}
		getJButton1().setEnabled(b);
	}

	/**
	 *
	 */
	private void setExtensionToFileName() {
		if (getFileExtension() == null || getFileExtension().trim().length() == 0) {
			return;
		}
		if (getJFileChooser().getSelectedFile() == null || getJFileChooser().getSelectedFile().isDirectory()) {
			return;
		}
		String fileName = getJFileChooser().getSelectedFile().getName();
		if (!fileName.toUpperCase().endsWith("."+getFileExtension().toUpperCase())) {
			String path = getJFileChooser().getSelectedFile().getAbsoluteFile() + "." + getFileExtension().toLowerCase();
			getJFileChooser().setSelectedFile(new File(path));
			getTextAreaExt().setValue(path);
		}
	}

	/**
	 *
	 */
	public void setFileChanged(File arg1) {
		setaFile(arg1);
	}

	/**
	 *
	 */
	public void setFileExtension(String newFileExtension) {
		this.fileExtension = newFileExtension;

		if (this.fileExtension == null || this.fileExtension.trim().length() == 0) {
			getJFileChooser().resetChoosableFileFilters();
			this.updateExtension();
			return;
		}
		if (this.fileExtension.toUpperCase().compareTo("PDF") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().setFileView(new PDFFileView());
			getJFileChooser().addChoosableFileFilter(new PDFFilter());
		}
		if (this.fileExtension.toUpperCase().compareTo("RTF") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().setFileView(new RTFFileView());
			getJFileChooser().addChoosableFileFilter(new RTFFilter());
		}
		if (this.fileExtension.toUpperCase().compareTo("XLS") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().setFileView(new XLSFileView());
			getJFileChooser().addChoosableFileFilter(new XLSFilter());
		}
		if (this.fileExtension.toUpperCase().compareTo("HTML") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().setFileView(new HTMLFileView());
			getJFileChooser().addChoosableFileFilter(new HTMLFilter());
		}
		if (this.fileExtension.toUpperCase().compareTo("TXT") == 0 || this.fileExtension.toUpperCase().compareTo("PROPERTIES") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().setFileView(new TXTFileView());
			getJFileChooser().addChoosableFileFilter(new TXTFilter());
		}
		if (this.fileExtension.toUpperCase().compareTo("JPEG") == 0 || this.fileExtension.toUpperCase().compareTo("JPG") == 0
				|| this.fileExtension.toUpperCase().compareTo("TIFF") == 0 || this.fileExtension.toUpperCase().compareTo("TIF") == 0
				|| this.fileExtension.toUpperCase().compareTo("PNG") == 0 || this.fileExtension.toUpperCase().compareTo("GIF") == 0) {
			getJFileChooser().resetChoosableFileFilters();
			getJFileChooser().addChoosableFileFilter(new ImageFilter());
			getJFileChooser().setFileView(new ImageFileView());
			getJFileChooser().setAccessory(new ImagePreview(getJFileChooser()));
		}
	}

	/**
	 *
	 */
	public void setSelectedFile(File aSelectedFile) {
		getJFileChooser().setSelectedFile(aSelectedFile);
		if (aSelectedFile == null) {
			getTextAreaExt().setValue("");
		} else {
			getTextAreaExt().setValue(aSelectedFile.getAbsolutePath());
		}
		fireSelectedFile(aSelectedFile);//OJO TODO ¿NO CAUSARÁ ESTO UN DEADLOCK?
		repaint();
	}

	/**
	 *
	 */
	public void setCurrentDirectory(java.io.File arg1) {
		getJFileChooser().setCurrentDirectory(arg1);
	}

	/**
	 *
	 */
	public void setTitulo(String newText) {
		getTitledPanel().setTitle(newText);
	}

	/**
	 *
	 */
	public void updateExtension() {
		this.setExtensionToFileName();
	}

	/**
	 *
	 */
	public boolean validarFile() {
		try {
			if (getJFileChooser().getSelectedFile().exists()) {
				int op = InfoView.showConfirmDialog(this, "El archivo seleccionado ya existe. ¿Desea reemplazarlo?", "Archivo ya existe",
						InfoView.YES_NO_OPTION);
				if (op == 0) {
					return true;
				} else {
					if (op == 1) {
						getTextAreaExt().setValue("");
						return false;
					}
				}
			}
			return true;
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, false, this, t);
			return false;
		}
	}

	/**
	 * This method initializes titledPanel
	 *
	 * @return efren.util.panels.TitledPanel
	 */
	private TitledPanel getTitledPanel() {
		if (titledPanel == null) {
			titledPanel = new TitledPanel();
			titledPanel.setTitle("FileChooserPanel");
			titledPanel.setSize(new Dimension(109, 55));
			titledPanel.add(getPanelExt(), BorderLayout.CENTER);
		}
		return titledPanel;
	}

	/**
	 *
	 */
	private PanelExt getPanelExt() {
		if (panelExt == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(1, 1, 1, 1);
			gridBagConstraints1.gridx = 4;
			gridBagConstraints1.gridy = 0;
			panelExt = new PanelExt();
			panelExt.add(getJButton1(), gridBagConstraints1);
			panelExt.add(getTextAreaExt(), gridBagConstraints11);
		}
		return panelExt;
	}

	/**
	 *
	 */
	public void openFileChooser() {
		getJFileChooser().setDialogTitle(getTitulo());
		getJFileChooser().showDialog(this, "Aceptar");
	}

	/**
	 *
	 */
	public void setFileSelectionMode(int fileSelectionMode) {
		getJFileChooser().setFileSelectionMode(fileSelectionMode);
	}

	/**
	 *
	 */
	private JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new JFileChooser();
			jFileChooser.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String selectedFileTemp = "";
					if (getJFileChooser().getSelectedFile() != null) {
						selectedFileTemp = getJFileChooser().getSelectedFile().toString();
					}
					getTextAreaExt().setValue(selectedFileTemp);
					setExtensionToFileName();
					fireSelectedFile(jFileChooser.getSelectedFile());
					setExtensionToFileName();
				}
			});
		}
		return jFileChooser;
	}

	/**
	 *
	 */
	synchronized public void addFileChooserSelectedFileListener(FileChooserSelectedFileListener listener) {
		if (this.escuchadores == null) {
			this.escuchadores = new Vector<FileChooserSelectedFileListener>();
		}
		this.escuchadores.addElement(listener);
	}

	/**
	 *
	 */
	synchronized public void removeFileChooserSelectedFileListener(FileChooserSelectedFileListener listener) {
		if (this.escuchadores == null) {
			this.escuchadores = new Vector<FileChooserSelectedFileListener>();
		}
		this.escuchadores.removeElement(listener);
	}

	/**
	 *
	 */
	protected void fireSelectedFile(File aSelectedFile) {
		if (this.escuchadores != null && !this.escuchadores.isEmpty()) {
			FileChooserEvent evento = new FileChooserEvent(this, aSelectedFile);
			// se clona los listeners por si acaso alguien agrega listeners en plena ejecución
			Vector<FileChooserSelectedFileListener> targets = null;
			synchronized (this) {
				targets = (Vector<FileChooserSelectedFileListener>) this.escuchadores.clone();
			}
			Enumeration<FileChooserSelectedFileListener> e = targets.elements();
			FileChooserSelectedFileListener listener;
			while (e.hasMoreElements()) {
				listener = (FileChooserSelectedFileListener) e.nextElement();
				listener.selectedFile(evento);
			}
	    }
	}
	/**
	 * This method initializes textAreaExt
	 *
	 * @return efren.util.gui.text.TextAreaExt
	 */
	private TextAreaExt getTextAreaExt() {
		if (textAreaExt == null) {
			textAreaExt = new TextAreaExt();
			textAreaExt.setEditable(false);
		}
		return textAreaExt;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
