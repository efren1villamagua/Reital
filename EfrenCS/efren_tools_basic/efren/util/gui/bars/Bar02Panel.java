package efren.util.gui.bars;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import efren.util.ExceptionManager;
import efren.util.FontManager;

public class Bar02Panel extends javax.swing.JPanel implements ActionListener, MouseListener, java.beans.PropertyChangeListener {

	/**
	 *
	 */
	private static final long serialVersionUID = -739754556837353904L;

	protected transient java.beans.PropertyChangeSupport propertyChange;

	private JButton ivjJButton01 = null;

	private JButton ivjJButton02 = null;

	private JButton ivjJButton03 = null;

	protected transient Bar02PanelListener fieldBar02PanelListenerEventMulticaster = null; // @jve:decl-index=0:

	private boolean fieldTotalDisabled = false;

	private boolean fieldPermitirEliminacionMasiva = false;

	private boolean fieldTotalVisible = true;

	private boolean fieldShowIcons = true;

	private JButton ivjJButton10 = null;

	private JButton ivjJButton00 = null;

	private JToolBar jToolBar = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public Bar02Panel() {
		super();
		initialize();
	}

	/**
	 * TsBarraNuevoModificarEliminarPanel constructor comment.
	 *
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public Bar02Panel(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * TsBarraNuevoModificarEliminarPanel constructor comment.
	 *
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public Bar02Panel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * TsBarraNuevoModificarEliminarPanel constructor comment.
	 *
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public Bar02Panel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Method to handle events for the ActionListener interface.
	 *
	 * @param e
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(ActionEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButton00())
			connEtoC5(e);
		if (e.getSource() == getJButton01())
			connEtoC6(e);
		if (e.getSource() == getJButton03())
			connEtoC8(e);
		if (e.getSource() == getJButton02())
			connEtoC7(e);
		if (e.getSource() == getJButton10())
			connEtoC10(e);
		// user code begin {2}
		// user code end
	}

	/**
	 *
	 * @param newListener
	 *            Bar02PanelListener
	 */
	public void addBar02PanelListener(Bar02PanelListener newListener) {
		fieldBar02PanelListenerEventMulticaster = Bar02PanelListenerEventMulticaster.add(fieldBar02PanelListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * connEtoC1: (JButton00.text -->
	 * Bar02Panel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("button00Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC10: (JButton10.action.actionPerformed(ActionEvent)
	 * --> Bar02Panel.fireButton10ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC10(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireButton10ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC11: (JButton10.mouse.mouseEntered(MouseEvent) -->
	 * Bar02Panel.manageMouseOver00(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC11(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver00(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC12: (JButton10.mouse.mouseExited(MouseEvent) -->
	 * Bar02Panel.manageMouseOver01(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC12(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver00(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC13: (JButton10.mouse.mouseEntered(MouseEvent) -->
	 * Bar02Panel.manageMouseOver10(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC13(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver10(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC14: (JButton10.mouse.mouseExited(MouseEvent) -->
	 * Bar02Panel.manageMouseOver10(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC14(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver10(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC15: (JButton01.mouse.mouseEntered(MouseEvent) -->
	 * Bar02Panel.manageMouseOver01(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC15(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver01(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC16: (JButton01.mouse.mouseExited(MouseEvent) -->
	 * Bar02Panel.manageMouseOver01(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC16(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver01(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC17: (JButton02.mouse.mouseEntered(MouseEvent) -->
	 * Bar02Panel.manageMouseOver02(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC17(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver02(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC18: (JButton02.mouse.mouseExited(MouseEvent) -->
	 * Bar02Panel.manageMouseOver02(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC18(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver02(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC19: (JButton03.mouse.mouseEntered(MouseEvent) -->
	 * Bar02Panel.manageMouseOver03(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC19(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver03(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (JButton01.text -->
	 * Bar02Panel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("button01Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC20: (JButton03.mouse.mouseExited(MouseEvent) -->
	 * Bar02Panel.manageMouseOver03(Z)V)
	 *
	 * @param arg1
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC20(MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver03(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JButton02.text -->
	 * Bar02Panel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("button02Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (JButton03.text -->
	 * Bar02Panel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("button03Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5: (JButton00.action.actionPerformed(ActionEvent)
	 * --> Bar02Panel.fireButton00ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireButton00ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC6: (JButton01.action.actionPerformed(ActionEvent)
	 * --> Bar02Panel.fireButton01ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireButton01ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC7: (JButton02.action.actionPerformed(ActionEvent)
	 * --> Bar02Panel.fireButton02ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC7(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireButton02ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC8: (JButton03.action.actionPerformed(ActionEvent)
	 * --> Bar02Panel.fireButton03ActionPerformed(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC8(ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireButton03ActionPerformed(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC9: (JButton10.text -->
	 * Bar02Panel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 *
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC9(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("button10Text", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireButton00ActionPerformed(java.util.EventObject newEvent) {
		if (fieldBar02PanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBar02PanelListenerEventMulticaster.button00ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireButton01ActionPerformed(java.util.EventObject newEvent) {
		if (fieldBar02PanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBar02PanelListenerEventMulticaster.button01ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireButton02ActionPerformed(java.util.EventObject newEvent) {
		if (fieldBar02PanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBar02PanelListenerEventMulticaster.button02ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireButton03ActionPerformed(java.util.EventObject newEvent) {
		if (fieldBar02PanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBar02PanelListenerEventMulticaster.button03ActionPerformed(newEvent);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireButton10ActionPerformed(java.util.EventObject newEvent) {
		if (fieldBar02PanelListenerEventMulticaster == null) {
			return;
		}
		;
		fieldBar02PanelListenerEventMulticaster.button10ActionPerformed(newEvent);
	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 *
	 * @param propertyName
	 *            java.lang.String
	 * @param oldValue
	 *            java.lang.Object
	 * @param newValue
	 *            java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Method generated to support the promotion of the button00Enabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton00Enabled() {
		return getJButton00().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the button00Mnemonic
	 * attribute.
	 *
	 * @return int
	 */
	public int getButton00Mnemonic() {
		return getJButton00().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the button00Text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getButton00Text() {
		return getJButton00().getText();
	}

	/**
	 * Method generated to support the promotion of the button00Visible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton00Visible() {
		return getJButton00().isVisible();
	}

	/**
	 * Method generated to support the promotion of the button01Enabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton01Enabled() {
		return getJButton01().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the button01Mnemonic
	 * attribute.
	 *
	 * @return int
	 */
	public int getButton01Mnemonic() {
		return getJButton01().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the button01Text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getButton01Text() {
		return getJButton01().getText();
	}

	/**
	 * Method generated to support the promotion of the button01Visible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton01Visible() {
		return getJButton01().isVisible();
	}

	/**
	 * Method generated to support the promotion of the button02Enabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton02Enabled() {
		return getJButton02().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the button02Mnemonic
	 * attribute.
	 *
	 * @return int
	 */
	public int getButton02Mnemonic() {
		return getJButton02().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the button02Text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getButton02Text() {
		return getJButton02().getText();
	}

	/**
	 * Method generated to support the promotion of the button02Visible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton02Visible() {
		return getJButton02().isVisible();
	}

	/**
	 * Method generated to support the promotion of the button03Enabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton03Enabled() {
		return getJButton03().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the button03Mnemonic
	 * attribute.
	 *
	 * @return int
	 */
	public int getButton03Mnemonic() {
		return getJButton03().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the button03Text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getButton03Text() {
		return getJButton03().getText();
	}

	/**
	 * Method generated to support the promotion of the button03Visible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton03Visible() {
		return getJButton03().isVisible();
	}

	/**
	 * Method generated to support the promotion of the button10Enabled
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton10Enabled() {
		return getJButton10().isEnabled();
	}

	/**
	 * Method generated to support the promotion of the button10Mnemonic
	 * attribute.
	 *
	 * @return int
	 */
	public int getButton10Mnemonic() {
		return getJButton10().getMnemonic();
	}

	/**
	 * Method generated to support the promotion of the button10Text attribute.
	 *
	 * @return java.lang.String
	 */
	public String getButton10Text() {
		return getJButton10().getText();
	}

	/**
	 * Method generated to support the promotion of the button10Visible
	 * attribute.
	 *
	 * @return boolean
	 */
	public boolean getButton10Visible() {
		return getJButton10().isVisible();
	}

	/**
	 * 
	 */
	private JButton getJButton00() {
		if (ivjJButton00 == null) {
			ivjJButton00 = new JButton();
			ivjJButton00.setName("JButton00");
			ivjJButton00.setMnemonic('N');
			ivjJButton00.setText("Nuevo...");
			ivjJButton00.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButton00.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button00.gif")));
			ivjJButton00.setFont(new Font("Arial", Font.PLAIN, 10));
			ivjJButton00.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButton00.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
			ivjJButton00.setHorizontalAlignment(SwingConstants.LEFT);
			ivjJButton00.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (ivjJButton00.isVisible() && ivjJButton00.isEnabled()) {
						ivjJButton00.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}
				}
				public void mouseExited(MouseEvent e) {
					if (ivjJButton00.isVisible() && ivjJButton00.isEnabled()) {
						ivjJButton00.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				}
			});
		}
		return ivjJButton00;
	}

	/**
	 * 
	 */
	private JButton getJButton01() {
		if (ivjJButton01 == null) {
			ivjJButton01 = new JButton();
			ivjJButton01.setName("JButton01");
			ivjJButton01.setMnemonic('M');
			ivjJButton01.setText("Modificar...");
			ivjJButton01.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButton01.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button01.gif")));
			ivjJButton01.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJButton01.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButton01.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
			ivjJButton01.setHorizontalAlignment(SwingConstants.LEFT);
			ivjJButton01.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (ivjJButton01.isVisible() && ivjJButton01.isEnabled()) {
						ivjJButton01.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}
				}
				public void mouseExited(MouseEvent e) {
					if (ivjJButton01.isVisible() && ivjJButton01.isEnabled()) {
						ivjJButton01.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				}
			});
		}
		return ivjJButton01;
	}

	/**
	 * 
	 */
	private JButton getJButton02() {
		if (ivjJButton02 == null) {
			ivjJButton02 = new JButton();
			ivjJButton02.setName("JButton02");
			ivjJButton02.setMnemonic('C');
			ivjJButton02.setText("Consultar...");
			ivjJButton02.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButton02.setActionCommand("Consultar...");
			ivjJButton02.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button02.gif")));
			ivjJButton02.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJButton02.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButton02.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
			ivjJButton02.setHorizontalAlignment(SwingConstants.LEFT);
			ivjJButton02.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (ivjJButton02.isVisible() && ivjJButton02.isEnabled()) {
						ivjJButton02.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}
				}
				public void mouseExited(MouseEvent e) {
					if (ivjJButton02.isVisible() && ivjJButton02.isEnabled()) {
						ivjJButton02.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				}
			});
		}
		return ivjJButton02;
	}

	/**
	 * 
	 */
	private JButton getJButton03() {
		if (ivjJButton03 == null) {
			ivjJButton03 = new JButton();
			ivjJButton03.setName("JButton03");
			ivjJButton03.setMnemonic('E');
			ivjJButton03.setText("Eliminar...");
			ivjJButton03.setForeground(new java.awt.Color(80, 80, 80));
			ivjJButton03.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button03.gif")));
			ivjJButton03.setFont(new java.awt.Font("Arial", 0, 10));
			ivjJButton03.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjJButton03.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			ivjJButton03.setHorizontalAlignment(SwingConstants.LEFT);
			ivjJButton03.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (ivjJButton03.isVisible() && ivjJButton03.isEnabled()) {
						ivjJButton03.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
					}
				}
				public void mouseExited(MouseEvent e) {
					if (ivjJButton03.isVisible() && ivjJButton03.isEnabled()) {
						ivjJButton03.setForeground(FontManager.BUTTON_COLOR_NORMAL);
					}
				}
			});
		}
		return ivjJButton03;
	}

	/**
	 * 
	 */
	private JButton getJButton10() {
		if (ivjJButton10 == null) {
				ivjJButton10 = new JButton();
				ivjJButton10.setName("JButton10");
				ivjJButton10.setMnemonic('I');
				ivjJButton10.setText("Ingreso masivo...");
				ivjJButton10.setForeground(java.awt.Color.black);
				ivjJButton10.setVerticalTextPosition(SwingConstants.CENTER);
				ivjJButton10.setSelected(false);
				ivjJButton10.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button10.gif")));
				ivjJButton10.setFont(new java.awt.Font("Arial", 0, 10));
				ivjJButton10.setVerticalAlignment(SwingConstants.CENTER);
				ivjJButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
				ivjJButton10.setHorizontalAlignment(SwingConstants.LEFT);
				ivjJButton10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
				ivjJButton10.setVisible(false);
				ivjJButton10.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						if (ivjJButton10.isVisible() && ivjJButton10.isEnabled()) {
							ivjJButton10.setForeground(FontManager.BUTTON_COLOR_RESALTADO);
						}
					}
					public void mouseExited(MouseEvent e) {
						if (ivjJButton10.isVisible() && ivjJButton10.isEnabled()) {
							ivjJButton10.setForeground(FontManager.BUTTON_COLOR_NORMAL);
						}
					}
				});
		}
		return ivjJButton10;
	}

	/**
	 * Gets the permitirEliminacionMasiva property (boolean) value.
	 *
	 * @return The permitirEliminacionMasiva property value.
	 * @see #setPermitirEliminacionMasiva
	 */
	public boolean getPermitirEliminacionMasiva() {
		return fieldPermitirEliminacionMasiva;
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return java.beans.PropertyChangeSupport
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Gets the totalDisabled property (boolean) value.
	 *
	 * @return The totalDisabled property value.
	 * @see #setTotalDisabled
	 */
	public boolean getTotalDisabled() {
		return fieldTotalDisabled;
	}

	/**
	 * Gets the totalVisible property (boolean) value.
	 *
	 * @return The totalVisible property value.
	 * @see #setTotalVisible
	 */
	public boolean getTotalVisible() {
		return fieldTotalVisible;
	}

	public void habilitarDesabilitar00Button(Object elementoSeleccionado) {

		boolean flag = false;

		if (elementoSeleccionado != null)
			flag = true;

		setButton00Enabled(flag);

		this.repaint();
	}

	public void habilitarDesabilitar01Button(Object elementoSeleccionado) {

		boolean flag = false;

		if (elementoSeleccionado != null)
			flag = true;

		setButton01Enabled(flag);

		this.repaint();
	}

	public void habilitarDesabilitar02Button(Object elementoSeleccionado) {

		boolean flag = false;

		if (elementoSeleccionado != null)
			flag = true;

		setButton02Enabled(flag);

		this.repaint();
	}

	public void habilitarDesabilitar03Button(Object elementoSeleccionado) {

		boolean flag = false;

		if (elementoSeleccionado != null)
			flag = true;

		setButton03Enabled(flag);

		this.repaint();
	}

	public void habilitarDesabilitarBotones(int seleccionados, boolean eliminacionMasiva) {

		if (eliminacionMasiva) {
			setButton01Enabled(seleccionados == 1);
			setButton02Enabled(seleccionados == 1);
			setButton03Enabled(seleccionados > 0 && eliminacionMasiva);
		} else {
			boolean flag = seleccionados == 1;
			setButton01Enabled(flag);
			setButton02Enabled(flag);
			setButton03Enabled(flag);
		}

		this.repaint();
	}

	public void habilitarDesabilitarNuevo(Object elementoSeleccionado) {

		boolean flag = false;

		if (elementoSeleccionado != null)
			flag = true;

		setButton00Enabled(flag);

		this.repaint();
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Initializes connections
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getJButton00().addPropertyChangeListener(this);
		getJButton00().addActionListener(this);
		getJButton01().addActionListener(this);
		getJButton01().addPropertyChangeListener(this);
		getJButton03().addPropertyChangeListener(this);
		getJButton03().addActionListener(this);
		getJButton02().addActionListener(this);
		getJButton02().addPropertyChangeListener(this);
		getJButton10().addActionListener(this);
		getJButton10().addPropertyChangeListener(this);
		getJButton00().addMouseListener(this);
		getJButton10().addMouseListener(this);
		getJButton01().addMouseListener(this);
		getJButton02().addMouseListener(this);
		getJButton03().addMouseListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridx = 0;
			setName("BarraNuevoModificarConsultarEliminarPanel");
			setLayout(new java.awt.GridBagLayout());
			setSize(476, 20);

			this.setOpaque(false);
			this.add(getJToolBar(), gridBagConstraints);
			initConnections();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		getJButton00().setFont(efren.util.FontManager.currentSystemBoldFont());
		getJButton01().setFont(efren.util.FontManager.currentSystemBoldFont());
		getJButton02().setFont(efren.util.FontManager.currentSystemBoldFont());
		getJButton03().setFont(efren.util.FontManager.currentSystemBoldFont());
		getJButton10().setFont(efren.util.FontManager.currentSystemBoldFont());
		this.repaint();
		// user code end
	}

	private void manageMouseOver00(boolean over) {
		if (over) {
			if (getJButton00().isEnabled())
				getJButton00().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else
			getJButton00().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void manageMouseOver01(boolean over) {
		if (over) {
			if (getJButton01().isEnabled())
				getJButton01().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else
			getJButton01().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void manageMouseOver02(boolean over) {
		if (over) {
			if (getJButton02().isEnabled())
				getJButton02().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else
			getJButton02().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void manageMouseOver03(boolean over) {
		if (over) {
			if (getJButton03().isEnabled())
				getJButton03().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else
			getJButton03().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	private void manageMouseOver10(boolean over) {
		if (over) {
			if (getJButton10().isEnabled())
				getJButton10().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else
			getJButton10().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 *
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseClicked(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 *
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseEntered(MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButton00())
			connEtoC11(e);
		if (e.getSource() == getJButton10())
			connEtoC13(e);
		if (e.getSource() == getJButton01())
			connEtoC15(e);
		if (e.getSource() == getJButton02())
			connEtoC17(e);
		if (e.getSource() == getJButton03())
			connEtoC19(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 *
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseExited(MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButton00())
			connEtoC12(e);
		if (e.getSource() == getJButton10())
			connEtoC14(e);
		if (e.getSource() == getJButton01())
			connEtoC16(e);
		if (e.getSource() == getJButton02())
			connEtoC18(e);
		if (e.getSource() == getJButton03())
			connEtoC20(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 *
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mousePressed(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 *
	 * @param e
	 *            MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseReleased(MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 *
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getJButton00() && (evt.getPropertyName().equals("text")))
			connEtoC1(evt);
		if (evt.getSource() == getJButton01() && (evt.getPropertyName().equals("text")))
			connEtoC2(evt);
		if (evt.getSource() == getJButton03() && (evt.getPropertyName().equals("text")))
			connEtoC4(evt);
		if (evt.getSource() == getJButton02() && (evt.getPropertyName().equals("text")))
			connEtoC3(evt);
		if (evt.getSource() == getJButton10() && (evt.getPropertyName().equals("text")))
			connEtoC9(evt);
		// user code begin {2}
		// user code end
	}

	/**
	 *
	 * @param newListener
	 *            Bar02PanelListener
	 */
	public void removeBar02PanelListener(Bar02PanelListener newListener) {
		fieldBar02PanelListenerEventMulticaster = Bar02PanelListenerEventMulticaster.remove(fieldBar02PanelListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 * Method generated to support the promotion of the button00Enabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton00Enabled(boolean arg1) {
		if (getTotalDisabled()) {
			getJButton00().setEnabled(false);
			return;
		}
		getJButton00().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the button00Mnemonic
	 * attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setButton00Mnemonic(int arg1) {
		getJButton00().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the button00Text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setButton00Text(String arg1) {
		getJButton00().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the button00Visible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton00Visible(boolean arg1) {
		getJButton00().setVisible(arg1);
		visualUpdateButtonsVisibility();
	}

	public void setButton00Icon(ImageIcon unIcon) {
		getJButton00().setIcon(unIcon);
		getJButton00().setRolloverIcon(unIcon);
	}

	public void setButton01Icon(ImageIcon unIcon) {
		getJButton01().setIcon(unIcon);
		getJButton01().setRolloverIcon(unIcon);
	}

	public void setButton02Icon(ImageIcon unIcon) {
		getJButton02().setIcon(unIcon);
		getJButton02().setRolloverIcon(unIcon);
	}

	/**
	 * Method generated to support the promotion of the button01Enabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton01Enabled(boolean arg1) {
		if (getTotalDisabled()) {
			getJButton01().setEnabled(false);
			return;
		}
		getJButton01().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the button01Mnemonic
	 * attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setButton01Mnemonic(int arg1) {
		getJButton01().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the button01Text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setButton01Text(String arg1) {
		getJButton01().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the button01Visible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton01Visible(boolean arg1) {
		getJButton01().setVisible(arg1);
		visualUpdateButtonsVisibility();
	}

	/**
	 * Method generated to support the promotion of the button02Enabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton02Enabled(boolean arg1) {
		if (getTotalDisabled()) {
			getJButton02().setEnabled(false);
			return;
		}
		getJButton02().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the button02Mnemonic
	 * attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setButton02Mnemonic(int arg1) {
		getJButton02().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the button02Text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setButton02Text(String arg1) {
		getJButton02().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the button02Visible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton02Visible(boolean arg1) {
		getJButton02().setVisible(arg1);
		visualUpdateButtonsVisibility();
	}

	/**
	 * Method generated to support the promotion of the button03Enabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton03Enabled(boolean arg1) {
		if (getTotalDisabled()) {
			getJButton03().setEnabled(false);
			return;
		}
		getJButton03().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the button03Mnemonic
	 * attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setButton03Mnemonic(int arg1) {
		getJButton03().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the button03Text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setButton03Text(String arg1) {
		getJButton03().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the button03Visible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton03Visible(boolean arg1) {
		getJButton03().setVisible(arg1);
		visualUpdateButtonsVisibility();
	}

	/**
	 * Method generated to support the promotion of the button10Enabled
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton10Enabled(boolean arg1) {
		if (getTotalDisabled()) {
			getJButton10().setEnabled(false);
			return;
		}
		getJButton10().setEnabled(arg1);
	}

	/**
	 * Method generated to support the promotion of the button10Mnemonic
	 * attribute.
	 *
	 * @param arg1
	 *            int
	 */
	public void setButton10Mnemonic(int arg1) {
		getJButton10().setMnemonic(arg1);
	}

	/**
	 * Method generated to support the promotion of the button10Text attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setButton10Text(String arg1) {
		getJButton10().setText(arg1);
	}

	/**
	 * Method generated to support the promotion of the button10Visible
	 * attribute.
	 *
	 * @param arg1
	 *            boolean
	 */
	public void setButton10Visible(boolean arg1) {
		getJButton10().setVisible(arg1);
		visualUpdateButtonsVisibility();
	}

	/**
	 * Sets the permitirEliminacionMasiva property (boolean) value.
	 *
	 * @param permitirEliminacionMasiva
	 *            The new value for the property.
	 * @see #getPermitirEliminacionMasiva
	 */
	public void setPermitirEliminacionMasiva(boolean permitirEliminacionMasiva) {
		boolean oldValue = fieldPermitirEliminacionMasiva;
		fieldPermitirEliminacionMasiva = permitirEliminacionMasiva;
		firePropertyChange("permitirEliminacionMasiva", new Boolean(oldValue), new Boolean(permitirEliminacionMasiva));
	}

	/**
	 * Sets the totalDisabled property (boolean) value.
	 *
	 * @param totalDisabled
	 *            The new value for the property.
	 * @see #getTotalDisabled
	 */
	public void setTotalDisabled(boolean totalDisabled) {
		boolean oldValue = fieldTotalDisabled;
		fieldTotalDisabled = totalDisabled;
		firePropertyChange("totalDisabled", new Boolean(oldValue), new Boolean(totalDisabled));
		// ...
		setButton10Enabled(!totalDisabled);
		setButton00Enabled(!totalDisabled);
		setButton01Enabled(!totalDisabled);
		setButton02Enabled(!totalDisabled);
		setButton03Enabled(!totalDisabled);

		this.repaint();
	}

	/**
	 * Sets the totalVisible property (boolean) value.
	 *
	 * @param totalVisible
	 *            The new value for the property.
	 * @see #getTotalVisible
	 */
	public void setTotalVisible(boolean totalVisible) {
		boolean oldValue = fieldTotalVisible;
		fieldTotalVisible = totalVisible;
		firePropertyChange("totalVisible", new Boolean(oldValue), new Boolean(totalVisible));
		// ...
		this.setVisible(totalVisible);
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButton10());
			jToolBar.add(getJButton00());
			jToolBar.add(getJButton01());
			jToolBar.add(getJButton02());
			jToolBar.add(getJButton03());
		}
		return jToolBar;
	}

	/**
	 *
	 */
	public void setOrientation(int anOrientation) {
		getJToolBar().setOrientation(anOrientation);
	}

	public int getOrientation() {
		return getJToolBar().getOrientation();
	}

	/**
	 *
	 */
	/**
	 * Sets the showIcons property (boolean) value.
	 *
	 * @param showIcons
	 *            The new value for the property.
	 * @see #getShowIcons
	 */
	public void setShowIcons(boolean showIcons) {
		boolean oldValue = fieldShowIcons;
		fieldShowIcons = showIcons;
		firePropertyChange("showIcons", new Boolean(oldValue), new Boolean(showIcons));
		// ...
		if (showIcons) {
			getJButton00().setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button00.gif")));
			getJButton01().setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button01.gif")));
			getJButton02().setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button02.gif")));
			getJButton03().setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button03.gif")));
			getJButton10().setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/bar_button10.gif")));
		} else {
			getJButton00().setIcon(null);
			getJButton01().setIcon(null);
			getJButton02().setIcon(null);
			getJButton03().setIcon(null);
			getJButton10().setIcon(null);
		}
	}
	/**
	 *
	 */
	private void visualUpdateButtonsVisibility() {
		if (getJButton00().isVisible() || getJButton01().isVisible() || getJButton02().isVisible() || getJButton03().isVisible() || getJButton10().isVisible()) {
			getJToolBar().setVisible(true);
		} else {
			getJToolBar().setVisible(false);
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
