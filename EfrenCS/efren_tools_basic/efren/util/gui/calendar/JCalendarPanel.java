package efren.util.gui.calendar;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.DialogExt;
import efren.util.gui.text.TextFieldExt;

public class JCalendarPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5554601065627932716L;
	private JCalendar ivjJCalendarFecha = null;
	private javax.swing.JPanel ivjJDialogContentPane = null;
	private DialogExt ivjDialogExtFecha = null;
    private boolean fieldSoloMesYAnio = false;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private efren.util.gui.text.TextFieldExt ivjTextFieldExtDate = null;
    private boolean focusIn = false;
	private JButton jButtonIcono = null;

	class IvjEventHandler implements efren.util.gui.text.TextFieldExtListener, java.awt.event.KeyListener, java.awt.event.MouseListener, java.beans.PropertyChangeListener {
			public void actionPerformed(java.util.EventObject newEvent) {};
			public void actionPerformedOnTextField(java.util.EventObject newEvent) {};
			public void field_keyReleased(java.util.EventObject newEvent) {};
			public void focusGained(java.util.EventObject newEvent) {};
			public void focusLost(java.util.EventObject newEvent) {
				if (newEvent.getSource() == JCalendarPanel.this.getTextFieldExtDate())
					connEtoC6(newEvent);
			};
			public void keyPressed(java.awt.event.KeyEvent e) {};
			public void keyReleased(java.awt.event.KeyEvent e) {
				if (e.getSource() == JCalendarPanel.this.getJDialogFecha())
					connEtoC5(e);
			};
			public void keyTyped(java.awt.event.KeyEvent e) {};
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getSource() == JCalendarPanel.this.getJButtonIcono())
					connEtoC2(e);
			};
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (e.getSource() == JCalendarPanel.this.getJButtonIcono())
					connEtoC9(e);
			};
			public void mouseExited(java.awt.event.MouseEvent e) {
				if (e.getSource() == JCalendarPanel.this.getJButtonIcono())
					connEtoC10(e);
			};
			public void mousePressed(java.awt.event.MouseEvent e) {};
			public void mouseReleased(java.awt.event.MouseEvent e) {};
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				if (evt.getSource() == JCalendarPanel.this.getTextFieldExtDate() && (evt.getPropertyName().equals("value")))
					connEtoC8(evt);
				if (evt.getSource() == JCalendarPanel.this.getJCalendarFecha() && (evt.getPropertyName().equals("calendar")))
					connEtoC3(evt);
				if (evt.getSource() == JCalendarPanel.this.getJCalendarFecha())
					connEtoC1(evt);
			};
			public void textDateMouseClicked(java.util.EventObject newEvent) {
		//		if (newEvent.getSource() == JCalendarPanel.this.getTextFieldExtDate())
					connEtoC7(newEvent);
			};
			public void textFieldExtkeyReleased(java.util.EventObject newEvent) {};
		};
	/**
	 * JCalendarPanel constructor comment.
	 */
	public JCalendarPanel() {
		super();
		initialize();
	}
	/**
	 * JCalendarPanel constructor comment.
	 * @param layout java.awt.LayoutManager
	 */
	public JCalendarPanel(java.awt.LayoutManager layout) {
		super(layout);
	}
	/**
	 * JCalendarPanel constructor comment.
	 * @param layout java.awt.LayoutManager
	 * @param isDoubleBuffered boolean
	 */
	public JCalendarPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	/**
	 * JCalendarPanel constructor comment.
	 * @param isDoubleBuffered boolean
	 */
	public JCalendarPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}
	private void cerrarWithKeyEvent(java.awt.event.KeyEvent event) {
	    if (event.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
	        getJDialogFecha().dispose();
	        //this.dialogShowing = false;
	    }
	}
	/**
	 * connEtoC1:  (JCalendarFecha.propertyChange.propertyChange(java.beans.PropertyChangeEvent) --> JCalendarPanel.visualManageFecha()V)
	 * @param arg1 java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageFecha(arg1);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC10:  (LabelExtIcono.mouse.mouseExited(java.awt.event.MouseEvent) --> JCalendarPanel.visualManageCursor(Ljava.lang.String;)V)
	 * @param arg1 java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC10(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageCursor("out");
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC2:  (LabelExtIcono.mouse.mouseClicked(java.awt.event.MouseEvent) --> JCalendarPanel.showCalendar()V)
	 * @param arg1 java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.showCalendar();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC3:  (JCalendarFecha.calendar --> JCalendarPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * @param arg1 java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("calendar", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC4:  (JCalendarPanel.initialize() --> JCalendarPanel.initFecha()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4() {
		try {
			// user code begin {1}
			// user code end
			this.initFecha();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC5:  (JDialogFecha.key.keyReleased(java.awt.event.KeyEvent) --> JCalendarPanel.cerrarWithKeyEvent(Ljava.awt.event.KeyEvent;)V)
	 * @param arg1 java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.awt.event.KeyEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.cerrarWithKeyEvent(arg1);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC6:  (TextFieldExtDate.textFieldExt.focusLost(java.util.EventObject) --> JCalendarPanel.manageFechaOnLosingFocus()V)
	 * @param arg1 java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageFechaOnLosingFocus();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC7:  (TextFieldExtDate.textFieldExt.focusGained(java.util.EventObject) --> JCalendarPanel.manageFechaOnGainingFocus()V)
	 * @param arg1 java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC7(java.util.EventObject arg1) {
		try {
			// user code begin {1}
	        if (((java.awt.event.MouseEvent) arg1).getClickCount() == 2)
	            this.manageFechaOnGainingFocus();
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC8:  (TextFieldExtDate.value --> JCalendarPanel.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * @param arg1 java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC8(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("dataText", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * connEtoC9:  (LabelExtIcono.mouse.mouseEntered(java.awt.event.MouseEvent) --> JCalendarPanel.visualManageCursor(Ljava.lang.String;)V)
	 * @param arg1 java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC9(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageCursor("in");
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}
	/**
	 * Method generated to support the promotion of the calendar attribute.
	 * @return java.util.Calendar
	 */
	public java.util.Calendar getCalendar() {
		return getJCalendarFecha().getCalendar();
	}
	/**
	 * Method generated to support the promotion of the dataText attribute.
	 * @return java.lang.String
	 */
	public java.lang.String getDataText() {
		return getTextFieldExtDate().getValue();
	}
	public void clearTextValue() {
		getTextFieldExtDate().setValue("-- --- ----");
		getJCalendarFecha().set2Calendar(null);
	}
	/**
	 * Return the JCalendarFecha property value.
	 * @return com.toedter.calendar.JCalendar
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private JCalendar getJCalendarFecha() {
		if (ivjJCalendarFecha == null) {
			try {
				ivjJCalendarFecha = new efren.util.gui.calendar.JCalendar();
				ivjJCalendarFecha.setName("JCalendarFecha");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCalendarFecha;
	}
	/**
	 * Return the JDialogContentPane property value.
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJDialogContentPane() {
		if (ivjJDialogContentPane == null) {
			try {
				ivjJDialogContentPane = new javax.swing.JPanel();
				ivjJDialogContentPane.setName("JDialogContentPane");
				ivjJDialogContentPane.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsJCalendarFecha = new java.awt.GridBagConstraints();
				constraintsJCalendarFecha.gridx = 0; constraintsJCalendarFecha.gridy = 0;
	constraintsJCalendarFecha.gridheight = 3;
				constraintsJCalendarFecha.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJCalendarFecha.weightx = 1.0;
				constraintsJCalendarFecha.weighty = 1.0;
				constraintsJCalendarFecha.insets = new java.awt.Insets(1, 1, 1, 1);
				getJDialogContentPane().add(getJCalendarFecha(), constraintsJCalendarFecha);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJDialogContentPane;
	}
	/**
	 * Return the JDialogFecha property value.
	 * @return javax.swing.JDialog
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private DialogExt getJDialogFecha() {
		if (ivjDialogExtFecha == null) {
				ivjDialogExtFecha = new DialogExt();
				ivjDialogExtFecha.setName("JDialogFecha");
				ivjDialogExtFecha.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				ivjDialogExtFecha.setTitle("Seleccionar fecha");
				ivjDialogExtFecha.setBounds(501, 199, 240, 230);
				ivjDialogExtFecha.setModal(true);
				ivjDialogExtFecha.setResizable(false);
				getJDialogFecha().setContentPane(getJDialogContentPane());
		}
		return ivjDialogExtFecha;
	}
	/**
	 * Gets the soloMesYAnio property (boolean) value.
	 * @return The soloMesYAnio property value.
	 * @see #setSoloMesYAnio
	 */
	public boolean getSoloMesYAnio() {
		return fieldSoloMesYAnio;
	}
	/**
	 * Return the TextFieldExtDate property value.
	 * @return efren.util.gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.text.TextFieldExt getTextFieldExtDate() {
		if (ivjTextFieldExtDate == null) {
			ivjTextFieldExtDate = new efren.util.gui.text.TextFieldExt();
			ivjTextFieldExtDate.setName("TextFieldExtDate");
			ivjTextFieldExtDate.setBackground(java.awt.Color.white);
			ivjTextFieldExtDate.setValue("-- --- ----");
			ivjTextFieldExtDate.setSeleccionarAlRecibirElFoco(true);
			ivjTextFieldExtDate.setEditable(true);
			ivjTextFieldExtDate.setEnabled(true);
			ivjTextFieldExtDate.setFocusable(false);
			ivjTextFieldExtDate.addTextFieldExtListener(new efren.util.gui.text.TextFieldExtListener() {
				public void actionPerformed(java.util.EventObject e) {
					manageFechaOnLosingFocus();
				}
				public void actionPerformedOnTextField(java.util.EventObject e) {
				}
				public void field_keyReleased(java.util.EventObject e) {
				}
				public void focusGained(java.util.EventObject e) {
				}
				public void focusLost(java.util.EventObject e) {
				}
				public void keyReleased(KeyEvent e) {
				}
				public void textDateMouseClicked(java.util.EventObject e) {
				}
				public void textFieldExtkeyReleased(java.util.EventObject e) {
				}
			});
		}
		return ivjTextFieldExtDate;
	}
	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}
	/**
	 * Initializes connections
	 * @exception java.lang.Exception The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getJDialogFecha().addKeyListener(ivjEventHandler);
		getJButtonIcono().addMouseListener(ivjEventHandler);
		getTextFieldExtDate().addTextFieldExtListener(ivjEventHandler);
		getTextFieldExtDate().addPropertyChangeListener(ivjEventHandler);
		getJCalendarFecha().addPropertyChangeListener(ivjEventHandler);
	}
	private void initFecha() {

	    try {

	        efren.util.CalendarManager cm = SystemProperties.RUNTIME_CALENDAR_MANAGER;

	        getJCalendarFecha().setCalendar(cm.getCalendar());

	        if (getSoloMesYAnio())
	            getTextFieldExtDate().setValue(cm.getMonthAndYearExpression());
	        else
	            getTextFieldExtDate().setValue(cm.getDMYDateExpression());
	    } catch (Throwable t) {
	        t.getMessage();
	        getTextFieldExtDate().setValue("-- --- ----");
	    }
	}
	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("JCalendarPanel");
			setLayout(new java.awt.GridBagLayout());
			setSize(127, 25);

			java.awt.GridBagConstraints constraintsJButtonIcono = new java.awt.GridBagConstraints();
			constraintsJButtonIcono.gridx = 1; constraintsJButtonIcono.gridy = 0;
			constraintsJButtonIcono.anchor = java.awt.GridBagConstraints.EAST;
			add(getJButtonIcono(), constraintsJButtonIcono);

			java.awt.GridBagConstraints constraintsTextFieldExtDate = new java.awt.GridBagConstraints();
			constraintsTextFieldExtDate.gridx = 0; constraintsTextFieldExtDate.gridy = 0;
			constraintsTextFieldExtDate.fill = GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtDate.weightx = 1.0;
			constraintsTextFieldExtDate.weighty = 0.0D;
			add(getTextFieldExtDate(), constraintsTextFieldExtDate);

			initConnections();
			connEtoC4();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		visualManageFecha(null);
		setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray));
		getTextFieldExtDate().setEditable(false);
		this.setOpaque(false);
		this.setBorder(null);
		// user code end
	}
	/**
	 *
	 *
	 */
	private void manageFechaOnGainingFocus() {
	    try {
		    if (!getTextFieldExtDate().getValue().startsWith("-")) {
	        	String fecha =
	        	    new efren.util.CalendarManager(
		       	     (java.util.GregorianCalendar) this.getCalendar()).getRegionalDateExpression();
		    	fecha = efren.util.StringTools.replaceAll(fecha, "-", "", false);
	     	   getTextFieldExtDate().setValue(fecha);
		    }
		    getTextFieldExtDate().setEditable(true);
	        getTextFieldExtDate().seleccionar();
	        this.focusIn = true;
	    } catch (Throwable t) {
	        t.getMessage();
	        getTextFieldExtDate().setValue("-- --- ----");
	    }
	}
	private void manageFechaOnLosingFocus() {
	    try {
	        if (!this.focusIn)
	            return;
	        getTextFieldExtDate().setEditable(false);
	        //if (dialogShowing)
	        //	return;
	        String fecha = getTextFieldExtDate().getValue();
	        if (fecha.length() != 8)
	            throw new Throwable();
	        int dia = Integer.valueOf(fecha.substring(0, 2)).intValue();
	        int mes = Integer.valueOf(fecha.substring(2, 4)).intValue();
	        int anio = Integer.valueOf(fecha.substring(4)).intValue();
	        java.util.GregorianCalendar gc = new java.util.GregorianCalendar(anio, mes - 1, dia);
	        this.setCalendar(gc);
	        this.visualManageFecha(null);

	        this.focusIn = false;
	    } catch (Throwable t) {
	        t.getMessage();
	        //this.setCalendar(null);
	        this.visualManageFecha(null);
	        this.getTextFieldExtDate().setValue("-- --- ----");
	    }
	}
	public void setBackground(java.awt.Color c) {
		super.setBackground(c);
		getJButtonIcono().setBackground(c);
	    getTextFieldExtDate().setBackground(c);
	}
	/**
	 * Method generated to support the promotion of the calendar attribute.
	 * @param arg1 java.util.Calendar
	 */
	public void setCalendar(java.util.Calendar arg1) {
		if (arg1 == null) {
			getTextFieldExtDate().setValue("-- --- ----");
			getJCalendarFecha().setCalendar(null);
			this.repaint();
			return;
		}
		getJCalendarFecha().setCalendar(arg1);
		this.repaint();
	}
	/**
	 * Method generated to support the promotion of the dataText attribute.
	 * @param arg1 java.lang.String
	 */
	public void setDataText(java.lang.String arg1) {
		getTextFieldExtDate().setValue(arg1);
	}
	public void setEnabled(boolean aFlag) {

	    super.setEnabled(aFlag);

	    getJCalendarFecha().setEnabled(aFlag);
	    //	getTextFieldExtDate().setOpaque(!aFlag);
	    if (aFlag)
	        getTextFieldExtDate().setBGColor(java.awt.Color.white);
	    else
	        getTextFieldExtDate().setBGColor(new java.awt.Color(231, 231, 231));
	    getTextFieldExtDate().setEnabled(aFlag);
	    getJButtonIcono().setEnabled(aFlag);
	}
	/**
	 * Sets the soloMesYAnio property (boolean) value.
	 * @param soloMesYAnio The new value for the property.
	 * @see #getSoloMesYAnio
	 */
	public void setSoloMesYAnio(boolean soloMesYAnio) {
		boolean oldValue = fieldSoloMesYAnio;
		fieldSoloMesYAnio = soloMesYAnio;
		firePropertyChange("soloMesYAnio", new Boolean(oldValue), new Boolean(soloMesYAnio));
		//...
		getJCalendarFecha().setDayChooserVisible(!soloMesYAnio);
		if (soloMesYAnio) {
			getJDialogFecha().setSize(276, 90);
			getJDialogFecha().setTitle("Seleccionar mes");
			efren.util.CalendarManager cm = new efren.util.CalendarManager((java.util.GregorianCalendar) getJCalendarFecha().getCalendar());
			getTextFieldExtDate().setValue(cm.getMonthAndYearExpression());
		} else {
			getJDialogFecha().setSize(276, 221);
			getJDialogFecha().setTitle("Seleccionar fecha");
		}
	}
	private void showCalendar() {

	    if (isEnabled()) {

	        int x = (int) getJButtonIcono().getLocationOnScreen().getX() + 10;
	        int y = (int) getJButtonIcono().getLocationOnScreen().getY() + 10;

	        int xPos = x, yPos = y;
	        if (efren.util.ToolkitManager.getToolkit().getScreenSize().getWidth() - x < getJDialogFecha().getWidth()) {
	        	xPos = x - getJDialogFecha().getWidth();
	        }
	        if (efren.util.ToolkitManager.getToolkit().getScreenSize().getHeight() - y < getJDialogFecha().getHeight()) {
	        	yPos = y - getJDialogFecha().getHeight();
	        }


	        if (getJCalendarFecha().getCalendar() == null) {
				this.initFecha();
	        }

	        getJDialogFecha().setLocation(xPos, yPos);
	        getJDialogFecha().setVisible(true);
	    }
	}
	private void visualManageCursor(String in_out) {
	    if (in_out.compareTo("in") == 0) {
	        if (isEnabled())
	        	getJButtonIcono().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    } else {
	        if (in_out.compareTo("out") == 0)
	        	getJButtonIcono().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	    }
	}
	private void visualManageFecha(java.beans.PropertyChangeEvent e) {
	    /*
	        if (e != null && e.getPropertyName().compareTo("abierta") == 0) {
	            getJCalendarFecha().setAbierta(false);
	            getJDialogFecha().setVisible(false);
	            return;
	        }
	    */
	    if (e != null && e.getPropertyName().compareTo("cerrar") == 0) {
	        getJDialogFecha().setVisible(false);
	        return;
	    }

	    if (e != null && (e.getPropertyName().compareTo("calendar") != 0))
	        return;

	    java.util.GregorianCalendar c = (java.util.GregorianCalendar) getJCalendarFecha().getCalendar();
	    if (c == null)
	        return;
	    efren.util.CalendarManager cm = new efren.util.CalendarManager(c);

	    if (getSoloMesYAnio())
	        getTextFieldExtDate().setValue(cm.getMonthAndYearExpression());
	    else
	        getTextFieldExtDate().setValue(cm.getDMYDateExpression());

	}
	/**
	 *
	 */
	public void requestFocus() {
		if (getJDialogFecha().isVisible()) {
			getJDialogFecha().requestFocus();
		} else {
			getJButtonIcono().requestFocus();
		}
	}
	/**
	 * This method initializes jButtonIcono
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonIcono() {
		if (jButtonIcono == null) {
			jButtonIcono = new JButton();
			jButtonIcono.setText("");
			jButtonIcono.setToolTipText("Ir a escoger fecha");
			jButtonIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/date.png")));
			jButtonIcono.setPreferredSize(new Dimension(16, 16));
			jButtonIcono.setOpaque(false);
			jButtonIcono.setContentAreaFilled(false);
			jButtonIcono.setBorderPainted(false);
			jButtonIcono.setBorder(null);
			jButtonIcono.setMargin(new Insets(0,0,0,0));
			jButtonIcono.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					showCalendar();
				}
			});
		}
		return jButtonIcono;
	}
	/**
	 *
	 */
	public void setMnemonic(char mnemonic) {
		getJButtonIcono().setMnemonic(mnemonic);
	}
	/**
	 *
	 */
	public void setEditable(boolean editable) {
		getJButtonIcono().setVisible(editable);
	}
	/**
	 *
	 */
	public TextFieldExt getTextFieldExtComponent() {
		return getTextFieldExtDate();
	}
	/**
	 * 
	 */
	public void setBorder(Border unBorde) {
		try {
			getTextFieldExtDate().setBorder(unBorde);
		} catch (Exception e1) {
			e1.getMessage();
		}
	}
	/**
	 * 
	 */
    public void addActionListener(ActionListener l) {
    	getJCalendarFecha().addActionListener(l);
    }

	/**
	 * 
	 */
	public void setIcon(ImageIcon icon) {
		getJButtonIcono().setIcon(icon);
	}

}
