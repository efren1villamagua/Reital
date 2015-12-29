package efren.util.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.Icon;
import javax.swing.JInternalFrame;

import efren.seguridades.gui.SystemView;
import efren.util.InternalFrameManager;
import efren.util.MethodInvocation;
import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;

public class OpenWindowAction extends javax.swing.AbstractAction {
	/**
	 *
	 */
	private static final long serialVersionUID = 9077440553910676754L;

	private String windowClassName = null;

	private Icon icono = null;

	/**
	 *
	 */
	public OpenWindowAction() {
		super();
	}
	/**
	 *
	 */
	public OpenWindowAction(String name) {
		super(name);
	}
	/**
	 *
	 */
	public OpenWindowAction(String name, String windowName) {
		super(name);
		this.setWindowClassName(windowName);
	}
	/**
	 *
	 */
	public OpenWindowAction(String name, Icon icon) {
		super(name, icon);
	}
	/**
	 *
	 */
	public void actionPerformed(java.awt.event.ActionEvent arg1) {

		try {
			this.icono = (Icon) MethodInvocation.performMethod("getIcon", arg1.getSource());
		} catch (Exception e) {
			e.getMessage();
		}
		final ActionEvent ae = arg1;
		try {
			Thread aThread = new Thread(new Runnable() {
				public void run() {
					try {
						String wcn = getWindowClassName();
						String args = null;
						Object actionedObject = null;
						JInternalFrame window = null;
						ActionListener actionObject = null;
						if (wcn.indexOf("?") > 1) {
							args = wcn.substring(wcn.indexOf("?") + 1);
							if (args.indexOf("singleton") >= 0) {
								wcn = wcn.substring(0, wcn.indexOf("?"));
								MethodInvocation.performStaticMethod("singleton", Class.forName(wcn));
							} else {
								wcn = wcn.substring(0, wcn.indexOf("?"));
								actionedObject = Class.forName(wcn).newInstance();
								if (actionedObject instanceof ActionListener) {
									try {
										actionObject = (ActionListener) actionedObject;
										actionObject.actionPerformed(ae);
									} catch (Exception exctemp) {
										exctemp.getMessage();
									}
								} else {
									window =  (JInternalFrame) actionedObject;
								}
								if (window != null && icono != null)
									window.setFrameIcon(icono);
								try {
									Object[] argsO = new Object[] { args };
									MethodInvocation.performMethod("_manejoAccesos", window, argsO);
								} catch (Throwable t2) {
									t2.getMessage();
								}
							}
						} else {
							actionedObject = Class.forName(wcn).newInstance();
							if (actionedObject instanceof ActionListener) {
								try {
									actionObject = (ActionListener) actionedObject;
									actionObject.actionPerformed(ae);
								} catch (Exception exctemp) {
									exctemp.getMessage();
								}
							} else {
								window = (JInternalFrame) actionedObject;
							}
							if (window != null && icono != null) {
								window.setFrameIcon(icono);
							}
						}
						// ...
						if (window != null) {
							window.setResizable(true);
							window.setClosable(true);
							window.setMaximizable(true);
							window.setIconifiable(true);
							window.setVisible(true);
							SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(window);
							try {
								window.setSelected(true);
							} catch (PropertyVetoException e) {
								e.getMessage();
							}
							window.toFront();
							// ...
							InternalFrameManager.singleton().updateFramesList();
						}
					} catch (Exception ex) {
						InfoView.showErrorDialog(SystemView.singleton(), ex.getMessage());
					}
				}
			});
			aThread.start();
		} catch (Exception ex) {
			InfoView.showErrorDialog(SystemView.singleton(), ex.getMessage());
		}
	}
	/**
	 *
	 */
	private String getWindowClassName() {
		return windowClassName;
	}
	/**
	 *
	 */
	private void setWindowClassName(String newValue) {
		this.windowClassName = newValue;
	}
}
