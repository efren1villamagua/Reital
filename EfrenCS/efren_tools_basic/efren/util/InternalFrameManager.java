package efren.util;

import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;

import efren.seguridades.gui.ChangePasswordView;
import efren.seguridades.gui.SystemView;
import efren.seguridades.procesos.gui.MenuBuilderProcess;
import efren.util.config.SystemProperties;
import efren.util.gui.ConsoleDialog;
import efren.util.gui.LookAndFeelDialog;
import efren.util.gui.dialogs.InfoView;
import efren.util.menu.MenuItem;

public class InternalFrameManager implements java.awt.event.ActionListener {

	private static InternalFrameManager singleton = null;
	/**
	 *
	 */
	private InternalFrameManager() {
	    super();
	}
	/**
	 *
	 */
	public void actionPerformed(java.awt.event.ActionEvent e) {
	    this.closeAll();
	}
	/**
	 *
	 */
	public void closeAll() {

		JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;

		int validFramesCount = 0;
	    JInternalFrame frameTemp = null;
	    for (int i = 0; i < jdp.getAllFrames().length; i++) {
	    	frameTemp = (JInternalFrame) jdp.getAllFrames()[i];
	    	if (frameTemp instanceof ConsoleDialog || frameTemp instanceof LookAndFeelDialog) {
	    		if (frameTemp.isVisible() || frameTemp.isIcon()) {
	    			validFramesCount++;
	    		} else {
	    			continue;
	    		}
	    	} else {
	    		validFramesCount++;
	    	}
	    }

		if (validFramesCount == 0) {
			return;
		}

	    if (InfoView.showConfirmDialog(
	    		SystemView.singleton(), "¿ Desea cerrar todas las ventanas ?", "Cerrar todas las ventanas",
	    		InfoView.YES_NO_OPTION) != 0) {
	        return;
	    }


	    Vector<JInternalFrame> allFrames = new Vector<JInternalFrame>();
	    for (int i = 0; i < jdp.getAllFrames().length; i++) {
	    	allFrames.add(jdp.getAllFrames()[i]);
	    }

	    for (int i = 0; i < allFrames.size(); i++) {

	        frameTemp = (JInternalFrame) allFrames.elementAt(i);

	        if (frameTemp instanceof ConsoleDialog || frameTemp instanceof LookAndFeelDialog) {
	        	try {
	                frameTemp.setSelected(false);
	            } catch (java.beans.PropertyVetoException e) {
	                e.getMessage();
	            }
	            frameTemp.setVisible(false);
	        } else {

		        if (frameTemp.isIcon()) {
		            try {
		                frameTemp.setIcon(false);
		                frameTemp.setSelected(true);
		            } catch (java.beans.PropertyVetoException e) {
		                e.getMessage();
		            }
		            frameTemp.toFront();
		        }

		        //jdp.getDesktopManager().closeFrame(frameTemp);

		        frameTemp.dispose();

	        }

	    }
	    //...
	    this.updateFramesList();
	}
	/**
	 *
	 */
	public void updateFramesList() {
		this.updateFramesListForAMenu(SystemProperties.RUNTIME_MENU_VENTANAS_DEL_SISTEMA);
		this.updateFramesListForAMenu(SystemProperties.RUNTIME_MENU_POPUP_VENTANAS_DEL_SISTEMA);
	}
	/**
	 *
	 */
	private void updateFramesListForAMenu(JMenu unMenu) {

		unMenu.removeAll();

		MenuBuilderProcess.crearMenuVentanas(this.getClass(), false, unMenu);

		//...
	    JDesktopPane jdp = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE;
	    int count = 0;
	    JInternalFrame frameTemp = null;
	    for (int i = 0; i < jdp.getAllFrames().length; i++){
		    frameTemp = jdp.getAllFrames()[i];
	    	if (frameTemp.isVisible())
	    		count++;
	    }

	    if (count > 0) {
	    	unMenu.addSeparator();
	    }

	    MenuItem mit = null;

	    int windowCount = 1;
	    for (int i = (jdp.getAllFrames().length - 1); i >= 0; i--) {
	        frameTemp = jdp.getAllFrames()[i];
	        if (!frameTemp.isVisible())
	            continue;
	        mit = new MenuItem();
	        try {
				mit.setIcon(frameTemp.getFrameIcon());
			} catch (Exception e) {
				e.getMessage();
			}
	        mit.setText(windowCount + " " + frameTemp.getTitle());
	        mit.setMnemonic(new Integer(windowCount).toString().trim().charAt(0));
	        mit.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
	        mit.setForeground(java.awt.Color.darkGray);
	        mit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	        mit.addActionListener(WindowListManager.singleton());
	        mit.setAgregado(frameTemp);

	        unMenu.add(mit);

	        windowCount++;
	    }
	}
	/**
	 *
	 * @return
	 */
	public static InternalFrameManager singleton() {
	    if (singleton == null)
	        singleton = new InternalFrameManager();
	    return singleton;
	}
}
