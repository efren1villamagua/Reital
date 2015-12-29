package efren.util.reportes;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import efren.seguridades.gui.AccesoController;
import efren.seguridades.gui.SystemView;
import efren.util.SwingResourceManager;
import efren.util.WindowManager;
import efren.util.config.SystemProperties;
import efren.util.gui.about.AboutDialog;
import efren.util.gui.dialogs.InfoView;
import efren.util.gui.filechooser.FileChooserPanel;
import efren.util.gui.filechooser.HTMLFileView;
import efren.util.gui.filechooser.HTMLFilter;
import efren.util.gui.filechooser.ImageFileView;
import efren.util.gui.filechooser.ImageFilter;
import efren.util.gui.filechooser.ImagePreview;
import efren.util.gui.filechooser.PDFFileView;
import efren.util.gui.filechooser.PDFFilter;
import efren.util.gui.filechooser.RTFFileView;
import efren.util.gui.filechooser.RTFFilter;
import efren.util.gui.filechooser.TXTFileView;
import efren.util.gui.filechooser.TXTFilter;
import efren.util.gui.filechooser.XLSFileView;
import efren.util.gui.filechooser.XLSFilter;
import inetsoft.report.ReportEnv;
import inetsoft.report.Size;
import inetsoft.report.StyleConstants;
import inetsoft.report.StyleSheet;
import inetsoft.report.io.Builder;
import inetsoft.report.io.ExcelGenerator;
import inetsoft.report.j2d.Previewer2D;
import inetsoft.report.j2d.StyleBook;
import inetsoft.report.j2d.StylePrinter;
import inetsoft.report.pdf.PDF3Printer;

/**
 *
 */
public class DetallesImpresionPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -3595111827718650432L;

	/**
	 *
	 */
	public static final int PRINT = 1;

	public static final int PREVIEW = 2;

	public static final int PDF = 3;

	public static final int RTF = 4;

	public static final int EXCEL = 5;

	public static final int HTML = 6;

	// ...
	private FileChooserPanel ivjFileChooserPanel = null;

	private javax.swing.JPanel ivjJPanel = null;

	private efren.util.gui.MultiChoice ivjMultiChoiceTipoImpresion = null;

	private IvjEventHandler ivjEventHandler = new IvjEventHandler();

	private Previewer2D previewer = null;

	private int innerPapel;

	private boolean innerEsOrientacionHorizontal;

	/**
	 * DetallesPresentacionPanel constructor comment.
	 */
	public DetallesImpresionPanel() {
		super();
		initialize();
	}

	/**
	 *
	 */
	public DetallesImpresionPanel(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 *
	 */
	public DetallesImpresionPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 *
	 */
	public DetallesImpresionPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public void _DEFINICION_cargar(DefinicionReporte definicionReporte) {
		try {
			getMultiChoiceTipoImpresion().setSelectedIndex(definicionReporte.getTipoImpresion());
			if (definicionReporte.getArchivoImpresion().trim().startsWith("_NO_PATH_FILE")) {
				getFileChooserPanel().setSelectedFile(null);
			} else {
				getFileChooserPanel().setSelectedFile(new java.io.File(definicionReporte.getArchivoImpresion().trim()));
			}
			visualManageTipoImpresion();
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 *
	 */
	public void _fillData(DefinicionReporte definicionReporte) {

		definicionReporte.setTipoImpresion(getMultiChoiceTipoImpresion().getSelectedIndex());

		String temp = "_NO_PATH_FILE";
		if (getFileChooserPanel().getSelectedFile() != null) {
			temp = getFileChooserPanel().getSelectedFile().getAbsolutePath();
		}
		definicionReporte.setArchivoImpresion(temp);
	}

	public void _limpiarTodosLosCampos() {

		getMultiChoiceTipoImpresion().setSelectedIndex(0);
		getFileChooserPanel().setSelectedFile(null);
	}

	public String _UPDATE_MetaSQL() {
		String metaSQL = "TIPOIMPRESION=" + getMultiChoiceTipoImpresion().getSelectedIndex() + ",";

		String temp = "_NO_PATH_FILE";
		if (getFileChooserPanel().getSelectedFile() != null)
			temp = getFileChooserPanel().getSelectedFile().getAbsolutePath();
		metaSQL = metaSQL + "ARCHIVOIMPRESION='" + temp + "'";

		return metaSQL;
	}

	/**
	 *
	 */
	private void connEtoC1(java.util.EventObject arg1) {
		try {
			this.visualManageTipoImpresion();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 *
	 */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			this.firePropertyChange("selectedTipoImpresion", arg1.getOldValue(), arg1.getNewValue());
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 *
	 */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			this.firePropertyChange("selectedFile", arg1.getOldValue(), arg1.getNewValue());
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	/**
	 *
	 */
	private FileChooserPanel getFileChooserPanel() {
		if (ivjFileChooserPanel == null) {
			ivjFileChooserPanel = new FileChooserPanel();
			ivjFileChooserPanel.setName("FileChooserPanel");
			ivjFileChooserPanel.setTitulo("Archivo destino (en el caso de impresión a archivo)");
			ivjFileChooserPanel.setFileExtension("GIF");
			ivjFileChooserPanel.setEnabled(false);
		}
		return ivjFileChooserPanel;
	}

	/**
	 *
	 */
	private javax.swing.JPanel getJPanel() {
		if (ivjJPanel == null) {
			try {
				ivjJPanel = new javax.swing.JPanel();
				ivjJPanel.setName("JPanel");
				ivjJPanel.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsFileChooserPanel = new java.awt.GridBagConstraints();
				constraintsFileChooserPanel.gridx = 0;
				constraintsFileChooserPanel.gridy = 1;
				constraintsFileChooserPanel.gridwidth = 1;
				constraintsFileChooserPanel.fill = GridBagConstraints.HORIZONTAL;
				constraintsFileChooserPanel.anchor = java.awt.GridBagConstraints.SOUTH;
				constraintsFileChooserPanel.weighty = 1.0;
				constraintsFileChooserPanel.ipady = 20;
				constraintsFileChooserPanel.insets = new java.awt.Insets(5, 5, 5, 5);
				java.awt.GridBagConstraints constraintsMultiChoiceTipoImpresion = new java.awt.GridBagConstraints();
				constraintsMultiChoiceTipoImpresion.gridx = 0;
				constraintsMultiChoiceTipoImpresion.gridy = 0;
				constraintsMultiChoiceTipoImpresion.weightx = 1.0;
				constraintsMultiChoiceTipoImpresion.weighty = 1.0;
				constraintsMultiChoiceTipoImpresion.insets = new java.awt.Insets(4, 4, 4, 4);
				ivjJPanel.add(getFileChooserPanel(), constraintsFileChooserPanel);
				getJPanel().add(getMultiChoiceTipoImpresion(), constraintsMultiChoiceTipoImpresion);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanel;
	}

	/**
	 * Return the MultiChoiceTipoImpresion property value.
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.MultiChoice getMultiChoiceTipoImpresion() {
		if (ivjMultiChoiceTipoImpresion == null) {
			try {
				ivjMultiChoiceTipoImpresion = new efren.util.gui.MultiChoice();
				ivjMultiChoiceTipoImpresion.setName("MultiChoiceTipoImpresion");
				javax.swing.Icon ivjLocal54icons[] = { new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/printer1.png")),
						new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/bar_preview.gif")),
						new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_file_PDF.gif")),
						new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_file_RTF.gif")),
						new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_file_XLS.gif")),
						new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/_file_HTML.gif")) };
				ivjMultiChoiceTipoImpresion.setIcons(ivjLocal54icons);
				String ivjLocal54valueOptions[] = { String.valueOf(PRINT), String.valueOf(PREVIEW), String.valueOf(PDF), String.valueOf(RTF),
						String.valueOf(EXCEL), String.valueOf(HTML) };
				ivjMultiChoiceTipoImpresion.setValueOptions(ivjLocal54valueOptions);
				ivjMultiChoiceTipoImpresion.setSelectedIndex(-1);
				String ivjLocal54nameOptions[] = { "Imprimir", "Preliminar en pantalla", "A archivo PDF", "A archivo RTF", "A archivo Excel",
						"A archivo HTML" };
				ivjMultiChoiceTipoImpresion.setNameOptions(ivjLocal54nameOptions);
				ivjMultiChoiceTipoImpresion.setSelectedIndex(0);
				ivjMultiChoiceTipoImpresion.setSelectedOption(String.valueOf(PRINT));
				ivjMultiChoiceTipoImpresion.setTitle("Tipo de impresión");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjMultiChoiceTipoImpresion;
	}

	/**
	 * Called whenever the part throws an exception.
	 *
	 * @param exception
	 *            java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {

	}

	/**
	 * Initializes connections
	 *
	 * @exception java.lang.Exception
	 *                The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getFileChooserPanel().addPropertyChangeListener(ivjEventHandler);
		getMultiChoiceTipoImpresion().addMultiChoiceListener(ivjEventHandler);
		getMultiChoiceTipoImpresion().addPropertyChangeListener(ivjEventHandler);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("DetallesImpresionPanel");
			setLayout(new java.awt.GridBagLayout());
			setSize(558, 308);

			java.awt.GridBagConstraints constraintsJPanel = new java.awt.GridBagConstraints();
			constraintsJPanel.gridx = 0;
			constraintsJPanel.gridy = 0;
			constraintsJPanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJPanel.weightx = 1.0;
			constraintsJPanel.weighty = 1.0;
			add(getJPanel(), constraintsJPanel);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}

	public boolean validar() {
		if (getMultiChoiceTipoImpresion().isDataMissing("Seleccion dónde imprimir"))
			return false;
		if (getMultiChoiceTipoImpresion().getSelectedIndex() > 1) {
			if (getFileChooserPanel().isDataMissing("Seleccione un archivo destino para la impresión"))
				return false;
		}
		return true;
	}

	private void visualManageTipoImpresion() {
		String extension = null;
		if (getMultiChoiceTipoImpresion().getSelectedIndex() < 2) {
			getFileChooserPanel().setEnabled(false);
			extension = null;
		} else {
			extension = getMultiChoiceTipoImpresion().getSelectedOption();
			getFileChooserPanel().setEnabled(true);
		}
		if (extension != null && extension.trim().length() > 0) {
			if (new Integer(extension.trim()).intValue() == PDF) {
				getFileChooserPanel().setFileExtension("PDF");
			}
			if (new Integer(extension.trim()).intValue() == RTF) {
				getFileChooserPanel().setFileExtension("RTF");
			}
			if (new Integer(extension.trim()).intValue() == EXCEL) {
				getFileChooserPanel().setFileExtension("XLS");
			}
			if (new Integer(extension.trim()).intValue() == HTML) {
				getFileChooserPanel().setFileExtension("HTML");
			}
		}

	}

	/**
	 *
	 * @author efren
	 *
	 */
	class IvjEventHandler implements efren.util.gui.MultiChoiceListener, java.beans.PropertyChangeListener {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == DetallesImpresionPanel.this.getFileChooserPanel() && (evt.getPropertyName().equals("selectedFile")))
				connEtoC3(evt);
			if (evt.getSource() == DetallesImpresionPanel.this.getMultiChoiceTipoImpresion() && (evt.getPropertyName().equals("selectedIndex")))
				connEtoC2(evt);
		};

		public void selectedOptionChanged(java.util.EventObject newEvent) {
			if (newEvent.getSource() == DetallesImpresionPanel.this.getMultiChoiceTipoImpresion())
				connEtoC1(newEvent);
		};

		public void selectedOptionChanged1(java.util.EventObject newEvent) {
		};

		public void selectedOptionChanged2(java.util.EventObject newEvent) {
		};

		public void selectedOptionChanged3(java.util.EventObject newEvent) {
		};
	};

	/**
	 *
	 * @param sheet
	 * @param tituloPreviewer
	 */
	public void _print(StyleSheet reporte, int papel, boolean esOrientacionHorizontal, String tituloPreviewer) {
		int selectedTipoImpresion = new Integer(getMultiChoiceTipoImpresion().getSelectedOption().trim()).intValue();
		File outputFile = getFileChooserPanel().getSelectedFile();
		switch (selectedTipoImpresion) {
		case PRINT:
			imprimirPRINT(reporte, papel, esOrientacionHorizontal, tituloPreviewer);
			break;
		case PREVIEW:
			imprimirPREVIEW(reporte, papel, esOrientacionHorizontal, tituloPreviewer);
			break;
		case PDF:
			imprimirPDF(SystemView.singleton(), reporte, papel, esOrientacionHorizontal, outputFile);
			break;
		case RTF:
			imprimirRTF(SystemView.singleton(), reporte, outputFile);
			break;
		case EXCEL:
			imprimirEXCEL(SystemView.singleton(), reporte, outputFile);
			break;
		case HTML:
			imprimirHTML(SystemView.singleton(), reporte, outputFile);
			break;
		default:
			break;
		}
	}

	/**
	 *
	 */
	private void imprimirPRINT(StyleSheet reporte, int papel, boolean esOrientacionHorizontal, String printJobName) {
		if (reporte == null) {
			InfoView.showErrorDialog(this, "ERROR: El Reporte no se ha construído");
			return;
		}
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		switch (papel) {
		case DetallesPresentacionPanel.A4:
			aset.add(MediaSizeName.ISO_A4);
			break;
		case DetallesPresentacionPanel.CARTA:
			aset.add(MediaSizeName.ISO_C6);
			break;
		case DetallesPresentacionPanel.OFICIO:
			aset.add(MediaSizeName.NA_LEGAL);
			break;
		default:
			break;
		}
		if (esOrientacionHorizontal) {
			aset.add(OrientationRequested.LANDSCAPE);
		} else {
			aset.add(OrientationRequested.PORTRAIT);
		}
		aset.add(Chromaticity.COLOR);
		aset.add(new JobName(printJobName, null));
		PrinterJob pj = StylePrinter.getPrinterJob();
		PageFormat pf = new PageFormat();
		Paper paper = new Paper();
		switch (papel) {
		case DetallesPresentacionPanel.A4:
			if (esOrientacionHorizontal) {
				paper.setSize(841, 595);
			} else {
				paper.setSize(595, 841);
			}
			break;
		case DetallesPresentacionPanel.CARTA:
			if (esOrientacionHorizontal) {
				paper.setSize(790, 609);
			} else {
				paper.setSize(609, 790);
			}
			break;
		case DetallesPresentacionPanel.OFICIO:
			if (esOrientacionHorizontal) {
				paper.setSize(1008, 612);
			} else {
				paper.setSize(612, 1008);
			}
			break;
		default:
			break;
		}
		pf.setPaper(paper);
		StyleBook book = new StyleBook(reporte, pf);
		pj.setPageable(book);
		if (pj.printDialog(aset)) {
			try {
				pj.print(aset);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 *
	 */
	private void imprimirPREVIEW(StyleSheet reporte, int papel, boolean esOrientacionHorizontal, String previewerTitle) {
		try {
			this.innerPapel = papel;
			this.innerEsOrientacionHorizontal = esOrientacionHorizontal;
			if (reporte == null) {
				InfoView.showErrorDialog(this, "ERROR: El Reporte no se ha construído");
				return;
			}
			this.previewer = new Previewer2D();
			Container parent = null;
			try {
				parent = WindowManager.getParent(this);
				if (parent instanceof Dialog || parent instanceof JDialog) {
					((Dialog) parent).dispose();
				}
			} catch (Exception exc1) {
				exc1.getMessage();
			}
			// this.previewer.setAlwaysOnTop(true);
			ImageIcon icono = SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH);
			previewer.setIconImage(icono.getImage());
			JButton botonImprimir = new JButton();
			botonImprimir = new JButton();
			botonImprimir.setText("Imprimir");
			botonImprimir.setMnemonic(KeyEvent.VK_I);
			botonImprimir.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/printer1.png")));
			botonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					imprimirPRINT((StyleSheet) previewer.getReport(), innerPapel, innerEsOrientacionHorizontal, ((JFrame) previewer).getTitle());
				}
			});
			botonImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonPDF = new JButton();
			botonPDF = new JButton();
			botonPDF.setText("PDF");
			botonPDF.setMnemonic(KeyEvent.VK_D);
			botonPDF.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/_file_PDF.gif")));
			botonPDF.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File selectedFile = selectFile(previewer, ((JFrame) previewer).getTitle() + " -- PDF", "PDF");
					imprimirPDF(previewer, (StyleSheet) previewer.getReport(), innerPapel, innerEsOrientacionHorizontal, selectedFile);
				}
			});
			botonPDF.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonRTF = new JButton();
			botonRTF = new JButton();
			botonRTF.setText("RTF");
			botonRTF.setMnemonic(KeyEvent.VK_F);
			botonRTF.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/_file_RTF.gif")));
			botonRTF.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File selectedFile = selectFile(previewer, ((JFrame) previewer).getTitle() + " -- RTF", "RTF");
					imprimirRTF(previewer, (StyleSheet) previewer.getReport(), selectedFile);
				}
			});
			botonRTF.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonEXCEL = new JButton();
			botonEXCEL = new JButton();
			botonEXCEL.setText("EXCEL");
			botonEXCEL.setMnemonic(KeyEvent.VK_E);
			botonEXCEL.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/_file_XLS.gif")));
			botonEXCEL.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File selectedFile = selectFile(previewer, ((JFrame) previewer).getTitle() + " -- EXCEL", "XLS");
					imprimirEXCEL(previewer, (StyleSheet) previewer.getReport(), selectedFile);
				}
			});
			botonEXCEL.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonHTML = new JButton();
			botonHTML = new JButton();
			botonHTML.setText("HTML");
			botonHTML.setMnemonic(KeyEvent.VK_H);
			botonHTML.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/_file_HTML.gif")));
			botonHTML.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File selectedFile = selectFile(previewer, ((JFrame) previewer).getTitle() + " -- HTML", "HTML");
					imprimirHTML(previewer, (StyleSheet) previewer.getReport(), selectedFile);
				}
			});
			botonHTML.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonCerrar = new JButton();
			botonCerrar = new JButton();
			botonCerrar.setText("Cerrar");
			botonCerrar.setMnemonic(KeyEvent.VK_C);
			botonCerrar.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/exit.png")));
			botonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					previewer.dispose();
				}
			});
			botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			JButton botonAbout = new JButton();
			botonAbout.setMnemonic(KeyEvent.VK_T);
			botonAbout.setIcon(SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH));
			botonAbout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new AboutDialog(previewer).setVisible(true);
				}
			});
			botonAbout.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
			previewer.addToolbarComponent(botonImprimir);
			previewer.addToolbarComponent(botonPDF);
			previewer.addToolbarComponent(botonRTF);
			previewer.addToolbarComponent(botonEXCEL);
			previewer.addToolbarComponent(botonHTML);
			previewer.addToolbarComponent(botonCerrar);
			previewer.addToolbarComponent(botonAbout);
			previewer.setToolbarButtons(30);

			previewer.setTitle(previewerTitle);

			switch (papel) {
			case DetallesPresentacionPanel.A4:
				if (esOrientacionHorizontal) {
					previewer.setPageWidth(11.69);
					previewer.setPageHeight(8.27);
				} else {
					previewer.setPageWidth(8.27);
					previewer.setPageHeight(11.69);
				}
				break;
			case DetallesPresentacionPanel.CARTA:
				if (esOrientacionHorizontal) {
					previewer.setPageWidth(11.00);
					previewer.setPageHeight(8.50);
				} else {
					previewer.setPageWidth(8.50);
					previewer.setPageHeight(11.00);
				}
				break;
			case DetallesPresentacionPanel.OFICIO:
				if (esOrientacionHorizontal) {
					previewer.setPageWidth(14.00);
					previewer.setPageHeight(8.50);
				} else {
					previewer.setPageWidth(8.50);
					previewer.setPageHeight(14.00);
				}
				break;
			default:
				break;
			}
			previewer.zoom(1.5);
			previewer.pack();
			previewer.setExtendedState(Frame.MAXIMIZED_BOTH);
			previewer.setExitOnClose(false);
			previewer.setVisible(true);
			previewer.print(reporte);

		} catch (Exception e) {
			InfoView.showErrorDialog(this, "ERROR: " + e.getMessage());
		}
	}

	/**
	 *
	 */
	private void imprimirPDF(JFrame parent, StyleSheet reporte, int papel, boolean esOrientacionHorizontal, File outputFile) {
		try {
			if (outputFile == null) {
				return;
			}
			String nombreActualizadoArchivo = updateExtensionArchivo(outputFile.getAbsolutePath(), "pdf");
			if (new File(nombreActualizadoArchivo).exists()) {
				if (InfoView.showConfirmDialog(parent, "El archivo " + nombreActualizadoArchivo + " ya existe. ¿ Desea reemplazarlo?") != InfoView.YES_OPTION) {
					return;
				}
			}
			if (reporte == null) {
				InfoView.showErrorDialog(parent, "ERROR: El Reporte no se ha construído");
				return;
			}
			ReportEnv.setProperty("font.truetype.path", SystemProperties.FONTS_PATH);
			FileOutputStream output = new FileOutputStream(new File(nombreActualizadoArchivo));
			PDF3Printer pdf = new PDF3Printer(output);
			pdf.setEmbedFont(true);
			switch (papel) {
			case DetallesPresentacionPanel.A4:
				if (esOrientacionHorizontal) {
					pdf.setPageSize(StyleConstants.PAPER_A4_TRANSVERSE);
				} else {
					pdf.setPageSize(StyleConstants.PAPER_A4);
				}
				break;
			case DetallesPresentacionPanel.CARTA:
				if (esOrientacionHorizontal) {
					pdf.setPageSize(StyleConstants.PAPER_LETTER_TRANSVERSE);
				} else {
					pdf.setPageSize(StyleConstants.PAPER_LETTER);
				}
				break;
			case DetallesPresentacionPanel.OFICIO:
				if (esOrientacionHorizontal) {
					pdf.setPageSize(new Size(14, 8.50));
				} else {
					pdf.setPageSize(StyleConstants.PAPER_LEGAL);
				}
				break;
			default:
				break;
			}
			reporte.print(pdf.getPrintJob());
			pdf.close();
			InfoView.showInformationDialog(parent, "La generación del reporte ha concluído !");
		} catch (Exception e) {
			InfoView.showErrorDialog(parent, "ERROR: " + e.getMessage());
		}
	}

	/**
	 *
	 */
	private void imprimirRTF(JFrame parent, StyleSheet reporte, File outputFile) {
		try {
			if (outputFile == null) {
				return;
			}
			String nombreActualizadoArchivo = updateExtensionArchivo(outputFile.getAbsolutePath(), "rtf");
			if (new File(nombreActualizadoArchivo).exists()) {
				if (InfoView.showConfirmDialog(parent, "El archivo " + nombreActualizadoArchivo + " ya existe. ¿ Desea reemplazarlo?") != InfoView.YES_OPTION) {
					return;
				}
			}
			if (reporte == null) {
				InfoView.showErrorDialog(parent, "ERROR: El Reporte no se ha construído");
				return;
			}
			FileOutputStream os = new FileOutputStream(new File(nombreActualizadoArchivo));
			Builder builder = Builder.getBuilder(Builder.RTF, os);
			builder.write(reporte);
			os.close();
			InfoView.showInformationDialog(parent, "La generación del reporte ha concluído !");
		} catch (Exception e) {
			InfoView.showErrorDialog(parent, "ERROR: " + e.getMessage());
		}
	}

	/**
	 *
	 */
	private void imprimirEXCEL(JFrame parent, StyleSheet reporte, File outputFile) {
		try {
			if (outputFile == null) {
				return;
			}
			String nombreActualizadoArchivo = updateExtensionArchivo(outputFile.getAbsolutePath(), "xls");
			if (new File(nombreActualizadoArchivo).exists()) {
				if (InfoView.showConfirmDialog(parent, "El archivo " + nombreActualizadoArchivo + " ya existe. ¿ Desea reemplazarlo?") != InfoView.YES_OPTION) {
					return;
				}
			}
			if (reporte == null) {
				InfoView.showErrorDialog(parent, "ERROR: El Reporte no se ha construído");
				return;
			}
			ExcelGenerator gen = new ExcelGenerator(new FileOutputStream(new File(nombreActualizadoArchivo)), ExcelGenerator.EXCEL_SHEET);
			gen.generate(reporte);
			InfoView.showInformationDialog(parent, "La generación del reporte ha concluído !");
		} catch (Exception e) {
			InfoView.showErrorDialog(parent, "ERROR: " + e.getMessage());
		}
	}

	/**
	 *
	 */
	private void imprimirHTML(JFrame parent, StyleSheet reporte, File outputFile) {
		try {
			if (outputFile == null) {
				return;
			}
			String nombreActualizadoArchivo = updateExtensionArchivo(outputFile.getAbsolutePath(), "html");
			if (new File(nombreActualizadoArchivo).exists()) {
				if (InfoView.showConfirmDialog(parent, "El archivo " + nombreActualizadoArchivo + " ya existe. ¿ Desea reemplazarlo?") != InfoView.YES_OPTION) {
					return;
				}
			}
			if (reporte == null) {
				InfoView.showErrorDialog(parent, "ERROR: El Reporte no se ha construído");
				return;
			}
			FileOutputStream os = new FileOutputStream(new File(nombreActualizadoArchivo));
			Builder builder = Builder.getBuilder(Builder.HTML, os, outputFile.getParent());
			builder.write(reporte);
			InfoView.showInformationDialog(parent, "La generación del reporte ha concluído !");
			os.close();
		} catch (Exception e) {
			InfoView.showErrorDialog(parent, "ERROR: " + e.getMessage());
		}
	}

	/**
	 *
	 */
	private File selectFile(JFrame parent, String title, String fileExtension) {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle(title);
		jfc.setDialogType(JFileChooser.OPEN_DIALOG);
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fileExtension.toUpperCase().compareTo("PDF") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.setFileView(new PDFFileView());
			jfc.addChoosableFileFilter(new PDFFilter());
		}
		if (fileExtension.toUpperCase().compareTo("RTF") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.setFileView(new RTFFileView());
			jfc.addChoosableFileFilter(new RTFFilter());
		}
		if (fileExtension.toUpperCase().compareTo("XLS") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.setFileView(new XLSFileView());
			jfc.addChoosableFileFilter(new XLSFilter());
		}
		if (fileExtension.toUpperCase().compareTo("HTML") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.setFileView(new HTMLFileView());
			jfc.addChoosableFileFilter(new HTMLFilter());
		}
		if (fileExtension.toUpperCase().compareTo("TXT") == 0 || fileExtension.toUpperCase().compareTo("PROPERTIES") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.setFileView(new TXTFileView());
			jfc.addChoosableFileFilter(new TXTFilter());
		}
		if (fileExtension.toUpperCase().compareTo("JPEG") == 0 || fileExtension.toUpperCase().compareTo("JPG") == 0
				|| fileExtension.toUpperCase().compareTo("TIFF") == 0 || fileExtension.toUpperCase().compareTo("TIF") == 0
				|| fileExtension.toUpperCase().compareTo("PNG") == 0 || fileExtension.toUpperCase().compareTo("GIF") == 0) {
			jfc.resetChoosableFileFilters();
			jfc.addChoosableFileFilter(new ImageFilter());
			jfc.setFileView(new ImageFileView());
			jfc.setAccessory(new ImagePreview(jfc));
		}
		int userOption = jfc.showSaveDialog(parent);
		if (userOption == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		} else {
			return null;
		}
	}

	/**
	 *
	 */
	private String updateExtensionArchivo(String rutaArchivo, String extension) {
		if (!rutaArchivo.trim().toUpperCase().endsWith("." + extension.trim().toUpperCase())) {
			return rutaArchivo + "." + extension;
		}
		return rutaArchivo;
	}

	public void setTipoImpresion(int tipoImpresion) {
		getMultiChoiceTipoImpresion().setSelectedOption(String.valueOf(tipoImpresion));
	}
}
