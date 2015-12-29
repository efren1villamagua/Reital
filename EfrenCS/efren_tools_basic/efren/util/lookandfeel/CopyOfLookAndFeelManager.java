package efren.util.lookandfeel;

import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/*
import net.beeger.squareness.SquarenessLookAndFeel;
import net.infonode.gui.laf.InfoNodeLookAndFeel;
import net.java.plaf.windows.WindowsLookAndFeel;

import org.fife.plaf.Office2003.Office2003LookAndFeel;

import se.diod.hippo.plaf.HippoLookAndFeel;

import com.birosoft.liquid.LiquidLookAndFeel;
import com.digitprop.tonic.TonicLookAndFeel;
import com.incors.plaf.alloy.AlloyLookAndFeel;
import com.incors.plaf.alloy.DefaultAlloyTheme;
import com.incors.plaf.alloy.themes.acid.AcidTheme;
import com.incors.plaf.alloy.themes.bedouin.BedouinTheme;
import com.incors.plaf.alloy.themes.glass.GlassTheme;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.l2fprod.gui.plaf.skin.Skin;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import com.lipstikLF.LipstikLookAndFeel;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.pagosoft.plaf.PgsLookAndFeel;
import com.shfarr.ui.plaf.fh.FhLookAndFeel;
import com.stefankrause.xplookandfeel.XPLookAndFeel;

import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import de.muntjak.tinylookandfeel.TinyLookAndFeel;
import efren.seguridades.gui.SystemAdminView;
import efren.seguridades.gui.SystemView;
import efren.util.Constantes;
import efren.util.gui.ConsoleDialog;
*/
public class CopyOfLookAndFeelManager {
/*

	static {
		try {
			AlloyLookAndFeel.setProperty("alloy.licenseCode", "2003/12/18#efvil@hotmail.com#bme0dn#1986ew");
		} catch (Exception e) {
			e.getMessage();
		}
	}

    public static int default_lf_system = 26;
    public static int default_lf_systemAdmin = 3;

    public static Vector lf_names = new Vector();
    static {
        lf_names.add("Alloy.default");
        lf_names.add("Alloy.acid");
        lf_names.add("Alloy.bedouin");
        lf_names.add("Alloy.glass");
        lf_names.add("Tiny");
        lf_names.add("JTatoo.acryl");
        lf_names.add("JTatoo.aero");
        lf_names.add("JTatoo.aluminium");
        lf_names.add("JTatoo.bernstein");
	    lf_names.add("JTatoo.fast");
	    lf_names.add("JTatoo.HiFi");
	    lf_names.add("JTatoo.luna");
	    lf_names.add("JTatoo.McWin");
	    lf_names.add("JTatoo.mint");
	    lf_names.add("JTatoo.smart");
	    lf_names.add("Lipstik");
	    lf_names.add("Windows Classic");
	    lf_names.add("Substance");
	    lf_names.add("NimROD");
	    lf_names.add("Fh");
	    lf_names.add("Napkin");
	    lf_names.add("Office2003");
	    lf_names.add("Pgs");
	    lf_names.add("Hippo");
	    lf_names.add("InfoNode");
	    lf_names.add("Plastic.default");
	    lf_names.add("Plastic.3D");
	    lf_names.add("Plastic.XP");
	    lf_names.add("Liquid");
	    lf_names.add("Tonic");
	    lf_names.add("Synthetica");
	    lf_names.add("Squareness");
	    lf_names.add("XP");
	    lf_names.add("Skin.tigerGraphite");
	    lf_names.add("Skin.architectOlive");
	    lf_names.add("Skin.blueTurquesa");
	    lf_names.add("Skin.chaNinja-Blue");
	    lf_names.add("Skin.midnight");
	    lf_names.add("Skin.oliveGreenLunaXP");
	    lf_names.add("Skin.opusOSOlive");
	    lf_names.add("Skin.roueBlue");
	    lf_names.add("Skin.roueBrown");
	    lf_names.add("Skin.roueGreen");
	    lf_names.add("Skin.BeOS");
	    lf_names.add("Skin.coronaHt");
	    lf_names.add("Skin.cougar");
	    lf_names.add("Skin.crystal2");
	    lf_names.add("Skin.gorilla");
	    lf_names.add("Skin.mmMagra-X");
	    lf_names.add("Skin.quickSilverR");
	    lf_names.add("Skin.royalInspirat");
	    lf_names.add("Skin.solunaR");
	    lf_names.add("Windows");
	    lf_names.add("Motif");
	    lf_names.add("Metal");
    }

    public static void switchLookAndFeel(int index) {
        switchLookAndFeel(index, null);
    }

    public static void switchLookAndFeel(int index, JFrame unaVentana) {

        try {

            switch (index) {
	            case 0: {//Alloy.default
	                UIManager.setLookAndFeel(new AlloyLookAndFeel(new DefaultAlloyTheme()));
	                break;
	            }
	            case 1: {//Alloy.acid
	                UIManager.setLookAndFeel(new AlloyLookAndFeel(new AcidTheme()));
	                break;
	            }
	            case 2: {//Alloy.bedouin
	                UIManager.setLookAndFeel(new AlloyLookAndFeel(new BedouinTheme()));
	                break;
	            }
	            case 3: {//Alloy.glass
	                UIManager.setLookAndFeel(new AlloyLookAndFeel(new GlassTheme()));
	                break;
	            }
	            case 4: {//Tiny
	                UIManager.setLookAndFeel(new TinyLookAndFeel());
	                break;
	            }
	            case 5: {//JTatoo.acryl
	                UIManager.setLookAndFeel(new AcrylLookAndFeel());
	                break;
	            }
	            case 6: {//JTatoo.aero
	                UIManager.setLookAndFeel(new AeroLookAndFeel());
	                break;
	            }
	            case 7: {//JTatoo.aluminium
	                UIManager.setLookAndFeel(new AluminiumLookAndFeel());
	                break;
	            }
	            case 8: {//JTatoo.bernstein
	                UIManager.setLookAndFeel(new BernsteinLookAndFeel());
	                break;
	            }
	            case 9: {//JTatoo.fast
	                UIManager.setLookAndFeel(new FastLookAndFeel());
	                break;
	            }
	            case 10: {//JTatoo.HiFi
	                UIManager.setLookAndFeel(new HiFiLookAndFeel());
	                break;
	            }
	            case 11: {//JTatoo.luna
	                UIManager.setLookAndFeel(new LunaLookAndFeel());
	                break;
	            }
	            case 12: {//JTatoo.McWin
	                UIManager.setLookAndFeel(new McWinLookAndFeel());
	                break;
	            }
	            case 13: {//JTatoo.mint
	                UIManager.setLookAndFeel(new MintLookAndFeel());
	                break;
	            }
	            case 14: {//JTatoo.smart
	                UIManager.setLookAndFeel(new SmartLookAndFeel());
	                break;
	            }
	            case 15: {//Lipstik
	                UIManager.setLookAndFeel(new LipstikLookAndFeel());
	                break;
	            }
	            case 16: {//Windows Classic
	                UIManager.setLookAndFeel(new WindowsLookAndFeel());
	                break;
	            }
	            case 17: {//Substance
	                //UIManager.setLookAndFeel(new SubstanceLookAndFeel());
	                break;
	            }
	            case 18: {//NimROD
	                UIManager.setLookAndFeel(new NimRODLookAndFeel());
	                break;
	            }
	            case 19: {//Fh
	                UIManager.setLookAndFeel(new FhLookAndFeel());
	                break;
	            }
	            case 20: {//Napkin
	                //UIManager.setLookAndFeel(new NapkinLookAndFeel());
	                break;
	            }
	            case 21: {//Office2003
	                UIManager.setLookAndFeel(new Office2003LookAndFeel());break;
	            }
	            case 22: {//Pgs
	                UIManager.setLookAndFeel(new PgsLookAndFeel());break;
	            }
	            case 23: {//Hippo
	                UIManager.setLookAndFeel(new HippoLookAndFeel());break;
	            }
	            case 24: {//InfoNode
	                UIManager.setLookAndFeel(new InfoNodeLookAndFeel());break;
	            }
	            case 25: {//Plastic.default
	                UIManager.setLookAndFeel(new PlasticLookAndFeel());break;
	            }
	            case 26: {//Plastic.3D
	                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());break;
	            }
	            case 27: {//Plastic.XP
	                UIManager.setLookAndFeel(new PlasticXPLookAndFeel());break;
	            }
	            case 28: {//Liquid
	                UIManager.setLookAndFeel(new LiquidLookAndFeel());break;
	            }
	            case 29: {//Tonic
	                UIManager.setLookAndFeel(new TonicLookAndFeel());break;
	            }
	            case 30: {//Synthetica
	                UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
	                break;
	            }
	            case 31: {//Squareness
	                UIManager.setLookAndFeel(new SquarenessLookAndFeel());break;
	            }
	            case 32: {//XP
	                UIManager.setLookAndFeel(new XPLookAndFeel());break;
	            }
	            case 33: {//Skin.tigerGraphite
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/tigerGraphitethemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 34: {//Skin.architectOlive
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/architectOlivethemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 35: {//Skin.blueTurquesa
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/blueTurquesathemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 36: {//Skin.chaNinja-Blue
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/chaNinja-Bluethemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 37: {//Skin.midnight
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/midnightthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 38: {//Skin.oliveGreenLunaXP
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/oliveGreenLunaXPthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 39: {//Skin.opusOSOlive
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/opusOSOlivethemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 40: {//Skin.roueBlue
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/roueBluethemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 41: {//Skin.roueBrown
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/roueBrownthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 42: {//Skin.roueGreen
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/roueGreenthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 43: {//Skin.BeOS
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/BeOSthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 44: {//Skin.coronaHt
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/coronaHthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 45: {//Skin.cougar
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/cougarthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 46: {//Skin.crystal2
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/crystal2themepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 47: {//Skin.gorilla
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/gorillathemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 48: {//Skin.mmMagra-X
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/mmMagra-Xthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 49: {//Skin.quickSilverR
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/quickSilverRthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 50: {//Skin.royalInspirat
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/royalInspiratthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 51: {//Skin.solunaR
	                Skin theSkinToUse = SkinLookAndFeel.loadThemePack("lib/look_and_feel/skinlf_themes/solunaRthemepack.zip");
	                SkinLookAndFeel.setSkin(theSkinToUse);
	                UIManager.setLookAndFeel(new SkinLookAndFeel());break;
	            }
	            case 52: {
	                UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
	                break;
	            }
	            case 53: {
	                UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
	                break;
	            }
	            case 54: {
	                UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	                break;
	            }
	            default: {
	            }
            }


            try {
    	        SwingUtilities.updateComponentTreeUI(SystemView.singleton());
    	        SwingUtilities.updateComponentTreeUI(ConsoleDialog.singleton());
    	        if (unaVentana != null)
    	            SwingUtilities.updateComponentTreeUI(unaVentana);

    			JDesktopPane jdp = Constantes.MAIN_DESKTOP_PANE;
    			JInternalFrame frame = null;
    	    	for (int i = 0; i < jdp.getAllFrames().length; i++){
    		    	frame = jdp.getAllFrames()[i];
    		    	SwingUtilities.updateComponentTreeUI(frame);
    	    	}
    	    	SwingUtilities.updateComponentTreeUI(SystemView.singleton().getJMenuBar());

    	    	JMenuBar mbar = SystemView.singleton().getJMenuBar();
    		    for (int i = 0; i < mbar.getSubElements().length; i++) {
    		        SwingUtilities.updateComponentTreeUI((JMenu) mbar.getSubElements()[i]);
    		    }
            } catch (Exception e) {
                e.getMessage();
            }
            try {
    	        SwingUtilities.updateComponentTreeUI(SystemAdminView.singleton());
    	        SwingUtilities.updateComponentTreeUI(ConsoleDialog.singleton());
    	        if (unaVentana != null)
    	            SwingUtilities.updateComponentTreeUI(unaVentana);

    			JDesktopPane jdp = efren.util.Constantes.MAIN_DESKTOP_PANE;
    			JInternalFrame frame = null;
    	    	for (int i = 0; i < jdp.getAllFrames().length; i++){
    		    	frame = jdp.getAllFrames()[i];
    		    	SwingUtilities.updateComponentTreeUI(frame);
    	    	}
    	    	SwingUtilities.updateComponentTreeUI(SystemAdminView.singleton().getJMenuBar());

    	    	JMenuBar mbar = SystemAdminView.singleton().getJMenuBar();
    		    for (int i = 0; i < mbar.getSubElements().length; i++) {
    		        SwingUtilities.updateComponentTreeUI((JMenu) mbar.getSubElements()[i]);
    		    }
            } catch (Exception e) {
                e.getMessage();
            }


        } catch (Throwable t) {
            t.getMessage();
            efren.util.gui.dialogs.InfoView.showErrorDialog(unaVentana, "Su versión de JRE no soporta esta Apariencia: " + t.getMessage());
            t.printStackTrace(System.out);
        }
    }
*/
}