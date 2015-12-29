package efren.util.lookandfeel;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import efren.seguridades.gui.SystemAdminView;
import efren.seguridades.gui.SystemView;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.ConsoleDialog;

public class LookAndFeelManager {
	/**
	 *
	 */
	public static void initLookAndFeel() {
		LookAndFeelManager.initLookAndFeel(null, null);
	}
	/**
	 *
	 */
	public static void initLookAndFeel(JFrame unaVentana) {
		LookAndFeelManager.initLookAndFeel(unaVentana, null);
	}
	/**
	 *
	 */
	public static void initLookAndFeel(JFrame unaVentana, LookAndFeel laf) {
		if (laf != null) {
			try {
				UIManager.setLookAndFeel(laf);
				if (unaVentana != null) {
					LookAndFeelManager.primUpdateLAF(unaVentana);
				}
			} catch (Exception exc0) {
				exc0.getMessage();
			}
			return;
		}
		/*
		 * try { NimRODTheme nt = new NimRODTheme(); nt.setPrimary1(new
		 * Color(10, 10, 10)); nt.setPrimary2(new Color(20, 20, 20));
		 * nt.setPrimary3(new Color(30, 30, 30));
		 * 
		 * NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
		 * NimRODLookAndFeel.setCurrentTheme(nt);
		 * UIManager.setLookAndFeel(NimRODLF); if (unaVentana != null) {
		 * LookAndFeelManager.primUpdateLAF(unaVentana); } } catch (Exception
		 * exc0) { exc0.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); if
		 * (unaVentana != null) { LookAndFeelManager.primUpdateLAF(unaVentana);
		 * } } catch (Exception exc0) { exc0.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
		 * if (unaVentana != null) {
		 * LookAndFeelManager.primUpdateLAF(unaVentana); } } catch (Exception
		 * exc0) { exc0.getMessage(); }
		 */
		/*
		 * if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
		 * try { UIManager.setLookAndFeel(new WindowsLookAndFeel()); if
		 * (unaVentana != null) { LookAndFeelManager.primUpdateLAF(unaVentana);
		 * } return; } catch (Exception exc0) { exc0.getMessage(); return; } }
		 */
		/*
		 * try { PlafOptions.setAsLookAndFeel(); PlafOptions.setCurrentTheme(new
		 * VistaTheme()); PlafOptions.setStyle(PlafOptions.MENUBARMENU,
		 * PlafOptions.GRADIENT_STYLE);
		 * PlafOptions.setStyle(PlafOptions.MENUBAR,
		 * PlafOptions.GRADIENT_STYLE);
		 * PlafOptions.setStyle(PlafOptions.MENU_ITEM,
		 * PlafOptions.GRADIENT_STYLE);
		 * PlafOptions.setStyle(PlafOptions.TOOLBAR,
		 * PlafOptions.GRADIENT_STYLE);
		 * PlafOptions.setStyle(PlafOptions.TOOLBARBUTTON,
		 * PlafOptions.GRADIENT_STYLE); PlafOptions.useBoldFonts(false);
		 * PlafOptions.setClearBorderEnabled(true);
		 * PlafOptions.setDefaultStyle(PlafOptions.GRADIENT_STYLE);
		 * PlafOptions.setPaintRolloverButtonBorder(true);
		 * PlafOptions.setTabbedPaneRightClickSelectionEnabled(true);
		 * PlafOptions.setTabReorderingEnabled(true);
		 * PlafOptions.setWheelTabbedPaneEnabled(true);
		 * PlafOptions.updateAllUIs(); if (unaVentana != null) {
		 * LookAndFeelManager.primUpdateLAF(unaVentana); } } catch (Exception e)
		 * { e.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new LipstikLookAndFeel());
		 * //UIManager.setLookAndFeel(new OyoahaLookAndFeel()); if (unaVentana
		 * != null) { LookAndFeelManager.primUpdateLAF(unaVentana); } } catch
		 * (Exception e) { e.getMessage(); }
		 */
		/*
		 * try { Properties props = new Properties(); props.put("logoString",
		 * "SIGE"); props.put("licenseKey", "LICENSE_NUMBER");
		 * AeroLookAndFeel.setCurrentTheme(props); UIManager.setLookAndFeel(new
		 * AeroLookAndFeel()); if (unaVentana != null) {
		 * LookAndFeelManager.primUpdateLAF(unaVentana); } } catch (Exception
		 * exc0) { exc0.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new WindowsLookAndFeel()); if
		 * (unaVentana != null) { LookAndFeelManager.primUpdateLAF(unaVentana);
		 * } } catch (Exception exc0) { exc0.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new Office2003LookAndFeel()); if
		 * (unaVentana != null) { LookAndFeelManager.primUpdateLAF(unaVentana);
		 * } } catch (Exception exc0) { exc0.getMessage(); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());
		 * SubstanceLookAndFeel.setCurrentButtonShaper(new
		 * ClassicButtonShaper());
		 * SubstanceLookAndFeel.setCurrentGradientPainter(new
		 * StandardGradientPainter()); try {
		 * UIManager.put(SubstanceLookAndFeel.NO_EXTRA_ELEMENTS, Boolean.TRUE);
		 * UIManager.put(SubstanceLookAndFeel.PASSWORD_ECHO_PER_CHAR, 6);
		 * UIManager.put(SubstanceLookAndFeel.FOCUS_KIND, FocusKind.UNDERLINE);
		 * UIManager.put(SubstanceLookAndFeel.CORNER_RADIUS,
		 * Float.valueOf(0.0f));
		 * UIManager.put(SubstanceLookAndFeel.FLAT_PROPERTY, Boolean.TRUE);
		 * UIManager.put(SubstanceLookAndFeel.GRADIENT_PAINTER_PROPERTY,
		 * "org.jvnet.substance.painter.SpecularGradientPainter");
		 * UIManager.put(
		 * SubstanceLookAndFeel.TABBED_PANE_VERTICAL_ORIENTATION_ROTATE_ICONS,
		 * Boolean.TRUE);
		 * UIManager.put(SubstanceLookAndFeel.SCROLL_PANE_BUTTONS_POLICY,
		 * ScrollPaneButtonPolicyKind.MULTIPLE); } catch (Exception exc1) {
		 * exc1.getMessage(); ExceptionManager.singleton().manage(null, false,
		 * AccesoController.class, exc1); } try { SubstanceWatermark watermark =
		 * new
		 * SubstanceImageWatermark(AccesoController.classForLoadingResources.
		 * getClass().getResourceAsStream(
		 * SystemProperties.SISTEMA_ABOUT_ICONO_PATH));
		 * SubstanceImageWatermark.setOpacity(0.03F);
		 * SubstanceImageWatermark.setKind(ImageWatermarkKind.SCREEN_TILE);
		 * watermark.updateWatermarkImage();
		 * SubstanceLookAndFeel.setCurrentWatermark(watermark); } catch
		 * (Exception exc2) { exc2.getMessage();
		 * ExceptionManager.singleton().manage(null, false,
		 * AccesoController.class, exc2); }
		 * JFrame.setDefaultLookAndFeelDecorated(true);
		 * JDialog.setDefaultLookAndFeelDecorated(true); if (unaVentana != null)
		 * { LookAndFeelManager.primUpdateLAF(unaVentana); } } catch (Exception
		 * exc0) { exc0.getMessage(); ExceptionManager.singleton().manage(null,
		 * false, AccesoController.class, exc0); }
		 */
		/*
		 * try { UIManager.setLookAndFeel(new WindowsLookAndFeel()); if
		 * (unaVentana != null) { LookAndFeelManager.primUpdateLAF(unaVentana);
		 * } } catch (Exception exc0) { exc0.getMessage(); }
		 */
		try {
			//InfoNodeLookAndFeelTheme theme = InfoNodeLookAndFeelThemes.getBlueIceTheme();
			//UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			if (unaVentana != null) {
				LookAndFeelManager.primUpdateLAF(unaVentana);
			}
		} catch (Exception exc0) {
			exc0.getMessage();
		}

	}

	/**
	 *
	 */
	public static void primUpdateLAF(JFrame unaVentana) {

		try {
			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
				SwingUtilities.updateComponentTreeUI(SystemAdminView.singleton());
			} else {
				SwingUtilities.updateComponentTreeUI(SystemView.singleton());
			}
			SwingUtilities.updateComponentTreeUI(ConsoleDialog.singleton());
			if (unaVentana != null)
				SwingUtilities.updateComponentTreeUI(unaVentana);

			JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
			JInternalFrame frame = null;
			for (int i = 0; i < jdp.getAllFrames().length; i++) {
				frame = jdp.getAllFrames()[i];
				SwingUtilities.updateComponentTreeUI(frame);
			}
			SwingUtilities.updateComponentTreeUI(SystemView.singleton().getJMenuBar());

			JMenuBar mbar = SystemView.singleton().getJMenuBar();
			for (int i = 0; i < mbar.getSubElements().length; i++) {
				SwingUtilities.updateComponentTreeUI((JMenu) mbar.getSubElements()[i]);
			}
		} catch (Throwable t) {
			t.getMessage();
			// efren.util.gui.dialogs.InfoView.showErrorDialog(unaVentana,
			// "Su versión de JRE no soporta esta Apariencia: " + t.getMessage()
			// );
			// t.printStackTrace(System.out);
		}
	}

}