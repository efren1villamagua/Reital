package efren.util.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import efren.util.SystemLogManager;
import efren.util.config.SystemProperties;
import efren.util.gui.panels.PanelExt;
import efren.util.gui.panels.TitledPanel;

public class LookAndFeelDialog extends JInternalFrame implements java.awt.event.ActionListener, javax.swing.event.InternalFrameListener {
    private static LookAndFeelDialog singleton = null;  //  @jve:decl-index=0:visual-constraint="656,19"
	private JPanel ivjJInternalFrameContentPane = null;
	private boolean primeraVez = true;
	private MultiChoice multiChoiceSkin = null;
	private TitledPanel titledPanelSkins = null;
	private PanelExt panelExt = null;
	private TitledPanel titledPanelThemes = null;
	private PanelExt panelExt1 = null;
	private MultiChoice multiChoiceThemes = null;
	private JScrollPane jScrollPaneThemes = null;
	private JScrollPane jScrollPaneSkins = null;
	public LookAndFeelDialog() {
	super();
	initialize();
}
public void _cerrar() {
    try {
        singleton.setSelected(false);
    } catch (java.beans.PropertyVetoException e) {
        e.getMessage();
    }
    this.setVisible(false);
}
/**
 *
 *
 */
private void _changeLookAndFeel() {

    if (!this.isVisible())
        return;

    try {

        int index = getMultiChoiceSkin().getSelectedIndex();
/*
        if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
        	LookAndFeelManager.switchLookAndFeel(index, SystemAdminView.singleton());
        } else {
        	LookAndFeelManager.switchLookAndFeel(index, SystemView.singleton());
        }
*/
    } catch (Throwable t) {
        SystemLogManager.error(t.getMessage(), t);
    }
}
/**
 *
 *
 */
private void _changeTheme() {

    if (!this.isVisible()) {
        return;
    }

    try {

        int index = getMultiChoiceThemes().getSelectedIndex();
/*
        if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
        	LookAndFeelManager.switchTheme(index, SystemAdminView.singleton());
        } else {
        	LookAndFeelManager.switchTheme(index, SystemView.singleton());
        }
*/
    } catch (Throwable t) {
        SystemLogManager.error(t.getMessage(), t);
       }
}

public void actionPerformed(java.awt.event.ActionEvent e) {
    this.showDialog();
}

private void connEtoC1(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this._cerrar();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (MultiChoice1.multiChoice.selectedOptionChanged(java.util.EventObject) --> LookAndFeelDialog.changeLookAndFeel()V)
 * @param arg1 java.util.EventObject
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.util.EventObject arg1) {
	try {
		// user code begin {1}
		// user code end
		this._changeLookAndFeel();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the JInternalFrameContentPane property value.
 * @return JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JPanel getJInternalFrameContentPane() {
	if (ivjJInternalFrameContentPane == null) {
		try {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(0,0,0,0);


			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.insets = new Insets(0,0,0,0);

			ivjJInternalFrameContentPane = new JPanel();
			ivjJInternalFrameContentPane.setName("JInternalFrameContentPane");
			ivjJInternalFrameContentPane.setLayout(new java.awt.GridBagLayout());

			ivjJInternalFrameContentPane.add(getJScrollPaneSkins(), gridBagConstraints1);
			ivjJInternalFrameContentPane.add(getJScrollPaneThemes(), gridBagConstraints2);
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJInternalFrameContentPane;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	SystemLogManager.error(exception.getMessage(), exception);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("LookAndFeelDialog");
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setSize(549, 328);
		setTitle("Apariencia del Sistema");
		setContentPane(getJInternalFrameContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}

    this.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/carita_con_gafas2.gif")));
    //...
/*    
    getMultiChoiceSkin().setNameOptions(LookAndFeelManager.lfs_names_array, false, true);
    getMultiChoiceSkin().setValueOptions(LookAndFeelManager.lfs_names_array);
    getMultiChoiceThemes().setNameOptions(LookAndFeelManager.lft_names_array, false, true);
    getMultiChoiceThemes().setValueOptions(LookAndFeelManager.lft_names_array);
*/    
	// user code end
}
public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
    try {
        this._cerrar();
    } catch (Throwable t) {
        t.getMessage();
    }
}
public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e) {

}
public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameIconified(javax.swing.event.InternalFrameEvent e) {
}
public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
}
public void showDialog() {
    singleton.setResizable(true);
    singleton.setClosable(true);
    singleton.setMaximizable(true);
    singleton.setIconifiable(true);
    singleton.setVisible(true);
    if (this.primeraVez) {
        SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.add(singleton);
        this.primeraVez = false;
    }
    try {
        singleton.setSelected(true);
    } catch (java.beans.PropertyVetoException e) {
        e.getMessage();
    }
    singleton.toFront();
}
public static LookAndFeelDialog singleton() {
    if (singleton == null)
        singleton = new LookAndFeelDialog();
    return singleton;
}
	/**
	 * This method initializes multiChoiceSkin
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	private MultiChoice getMultiChoiceSkin() {
		if (multiChoiceSkin == null) {
			multiChoiceSkin = new MultiChoice();
			multiChoiceSkin.addMultiChoiceListener(new efren.util.gui.MultiChoiceListener() {
				public void selectedOptionChanged(java.util.EventObject e) {
					_changeLookAndFeel();
				}
				public void selectedOptionChanged1(java.util.EventObject e) {
				}
				public void selectedOptionChanged2(java.util.EventObject e) {
				}
				public void selectedOptionChanged3(java.util.EventObject e) {
				}
			});
		}
		return multiChoiceSkin;
	}
	/**
	 * This method initializes titledPanelSkins
	 *
	 * @return efren.util.panels.TitledPanel
	 */
	private TitledPanel getTitledPanelSkins() {
		if (titledPanelSkins == null) {
			titledPanelSkins = new TitledPanel();
			titledPanelSkins.setTitle("Skins");
			titledPanelSkins.add(getPanelExt(), BorderLayout.EAST);
		}
		return titledPanelSkins;
	}
	/**
	 * This method initializes panelExt
	 *
	 * @return efren.util.panels.PanelExt
	 */
	private PanelExt getPanelExt() {
		if (panelExt == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			panelExt = new PanelExt();
			panelExt.add(getMultiChoiceSkin(), gridBagConstraints);
		}
		return panelExt;
	}
	/**
	 * This method initializes titledPanelThemes
	 *
	 * @return efren.util.panels.TitledPanel
	 */
	private TitledPanel getTitledPanelThemes() {
		if (titledPanelThemes == null) {
			titledPanelThemes = new TitledPanel();
			titledPanelThemes.setTitle("Themes");
			titledPanelThemes.add(getPanelExt1(), BorderLayout.CENTER);
		}
		return titledPanelThemes;
	}
	/**
	 * This method initializes panelExt1
	 *
	 * @return efren.util.panels.PanelExt
	 */
	private PanelExt getPanelExt1() {
		if (panelExt1 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			panelExt1 = new PanelExt();
			panelExt1.add(getMultiChoiceThemes(), gridBagConstraints3);
		}
		return panelExt1;
	}
	/**
	 * This method initializes multiChoiceThemes
	 *
	 * @return efren.util.gui.MultiChoice
	 */
	private MultiChoice getMultiChoiceThemes() {
		if (multiChoiceThemes == null) {
			multiChoiceThemes = new MultiChoice();
			multiChoiceThemes.addMultiChoiceListener(new efren.util.gui.MultiChoiceListener() {
				public void selectedOptionChanged(java.util.EventObject e) {
					_changeTheme();
				}
				public void selectedOptionChanged1(java.util.EventObject e) {
				}
				public void selectedOptionChanged2(java.util.EventObject e) {
				}
				public void selectedOptionChanged3(java.util.EventObject e) {
				}
			});
		}
		return multiChoiceThemes;
	}
	/**
	 * This method initializes jScrollPaneThemes
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneThemes() {
		if (jScrollPaneThemes == null) {
			jScrollPaneThemes = new JScrollPane();
			jScrollPaneThemes.setViewportView(getTitledPanelThemes());
		}
		return jScrollPaneThemes;
	}
	/**
	 * This method initializes jScrollPaneSkins
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneSkins() {
		if (jScrollPaneSkins == null) {
			jScrollPaneSkins = new JScrollPane();
			jScrollPaneSkins.setViewportView(getTitledPanelSkins());
		}
		return jScrollPaneSkins;
	}
 }  //  @jve:decl-index=0:visual-constraint="10,10"
