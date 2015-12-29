package efren.util.gui.text;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.border.Border;

import efren.util.gui.CheckBoxExt;
import efren.util.gui.LabelExt;
import efren.util.gui.calendar.JCalendarPanel;
import efren.util.gui.dialogs.InfoView;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class TextDate extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 155826093265085553L;

	private JCalendarPanel ivjJCalendarPanel1 = null;

	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private boolean nullable;
	private CheckBoxExt ivjJCheckBoxExt = null;
	private LabelExt ivjLabelExtText = null;
	
	private Vector<TextDateListener> listeners = new Vector<TextDateListener>();

	class IvjEventHandler implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getSource() == TextDate.this.getJCalendarPanel1() && (evt.getPropertyName().equals("soloMesYAnio")))
				connEtoC3(evt);
			if (evt.getSource() == TextDate.this.getJCheckBoxExt() && (evt.getPropertyName().equals("text")))
				connEtoC4(evt);
			if (evt.getSource() == TextDate.this.getJCheckBoxExt() && (evt.getPropertyName().equals("selectedOption")))
				connEtoC2(evt);
			if (evt.getSource() == TextDate.this.getJCalendarPanel1() && (evt.getPropertyName().equals("calendar"))) {
				firePropertyChange("calendar", "oldValue", "newValue");
				try {
					/**
					 * LOS COLOCAMOS AQUI POR CONVENIENCIA
					 */
					for (int i = 0; i < listeners.size(); i++) {
						listeners.elementAt(i).textDateActionPerformed(evt);	
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}

	/**
	 * TextDate constructor comment.
	 */
	public TextDate() {
		super();
		initialize();
	}

	/**
	 * TextDate constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public TextDate(LayoutManager layout) {
		super(layout);
	}

	/**
	 * TextDate constructor comment.
	 * 
	 * @param layout
	 *            LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public TextDate(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * TextDate constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public TextDate(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public CheckBoxExt checkBox() {
		return getJCheckBoxExt();
	}

	/**
	 * connEtoC1: (TextDate.initialize() --> TextDate.initAll()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1() {
		try {
			// user code begin {1}
			// user code end
			this.initAll();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (JCheckBoxExt.selectedOption -->
	 * TextDate.manageCheckboxSelection()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageNulls();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (JCalendarPanel1.soloMesYAnio -->
	 * TextDate.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("soloMesYAnio", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (JCheckBox1.text -->
	 * TextDate.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.firePropertyChange("textForNullable", arg1.getOldValue(), arg1.getNewValue());
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public boolean esNulo() {

		return (isNullable() && !getJCheckBoxExt().isSelected()) || (!isNullable() && getCalendar() == null);
	}

	private java.util.GregorianCalendar getCalendar() {

		return (java.util.GregorianCalendar) getJCalendarPanel1().getCalendar();
	}

	public String getDMY_expression() {

		if (this.getCalendar() == null)
			return null;

		return new efren.util.CalendarManager(this.getCalendar()).getDMYDateExpression();
	}

	/**
	 * Return the JCalendarPanel1 property value.
	 * 
	 * @return efren.util.calendar.JCalendarPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private efren.util.gui.calendar.JCalendarPanel getJCalendarPanel1() {
		if (ivjJCalendarPanel1 == null) {
			try {
				ivjJCalendarPanel1 = new efren.util.gui.calendar.JCalendarPanel();
				ivjJCalendarPanel1.setName("JCalendarPanel1");
				ivjJCalendarPanel1.setBackground(Color.white);
				ivjJCalendarPanel1.setEnabled(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCalendarPanel1;
	}

	/**
	 * Return the JCheckBoxExt property value.
	 * 
	 * @return efren.util.gui.JCheckBoxExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private CheckBoxExt getJCheckBoxExt() {
		if (ivjJCheckBoxExt == null) {
			try {
				ivjJCheckBoxExt = new efren.util.gui.CheckBoxExt();
				ivjJCheckBoxExt.setName("JCheckBoxExt");
				ivjJCheckBoxExt.setText("ifNullableText");
				ivjJCheckBoxExt.setHorizontalAlignment(2);
				// user code begin {1}
				ivjJCheckBoxExt.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						ivjJCheckBoxExt.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					public void mouseExited(MouseEvent e) {
						ivjJCheckBoxExt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxExt;
	}

	/**
	 * Method generated to support the promotion of the soloMesYAnio attribute.
	 * 
	 * @return boolean
	 */
	public boolean getSoloMesYAnio() {
		return getJCalendarPanel1().getSoloMesYAnio();
	}

	/**
	 * Return the LabelExtText property value.
	 * 
	 * @return efren.util.gui.LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExtText() {
		if (ivjLabelExtText == null) {
			try {
				ivjLabelExtText = new efren.util.gui.LabelExt();
				ivjLabelExtText.setName("LabelExtText");
				ivjLabelExtText.setText("ifNullableText");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExtText;
	}

	/**
	 * Method generated to support the promotion of the textForNullable
	 * attribute.
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTextForNullable() {
		return getJCheckBoxExt().getText();
	}

	public java.sql.Date getValue() {

		if (this.getCalendar() == null)
			return null;

		return new java.sql.Date(this.getCalendar().getTime().getTime());
	}

	private String getYMD() {

		if (getJCalendarPanel1().getCalendar() == null) {
			return null;
		}

		efren.util.CalendarManager cm = new efren.util.CalendarManager((java.util.GregorianCalendar) getJCalendarPanel1().getCalendar());
		return cm.getInternationalDateExpression();
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	private void initAll() {
		try {
			getJCheckBoxExt().setVisible(isNullable());
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
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
		getJCalendarPanel1().addPropertyChangeListener(ivjEventHandler);
		getJCheckBoxExt().addPropertyChangeListener(ivjEventHandler);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("TextDate");
			setLayout(new GridBagLayout());
			setSize(292, 20);

			GridBagConstraints constraintsJCalendarPanel1 = new GridBagConstraints();
			constraintsJCalendarPanel1.gridx = 1;
			constraintsJCalendarPanel1.gridy = 0;
			constraintsJCalendarPanel1.fill = GridBagConstraints.HORIZONTAL;
			constraintsJCalendarPanel1.weightx = 1.0;
			constraintsJCalendarPanel1.weighty = 0.0D;
			constraintsJCalendarPanel1.ipadx = 45;
			constraintsJCalendarPanel1.insets = new Insets(0, 0, 0, 0);
			add(getJCalendarPanel1(), constraintsJCalendarPanel1);

			GridBagConstraints constraintsJCheckBoxExt = new GridBagConstraints();
			constraintsJCheckBoxExt.gridx = 0;
			constraintsJCheckBoxExt.gridy = 0;
			constraintsJCheckBoxExt.fill = GridBagConstraints.HORIZONTAL;
			constraintsJCheckBoxExt.anchor = GridBagConstraints.WEST;
			constraintsJCheckBoxExt.weightx = 1.0;
			constraintsJCheckBoxExt.insets = new Insets(0, 4, 0, 1);
			add(getJCheckBoxExt(), constraintsJCheckBoxExt);

			GridBagConstraints constraintsLabelExtText = new GridBagConstraints();
			constraintsLabelExtText.gridx = 0;
			constraintsLabelExtText.gridy = 0;
			constraintsLabelExtText.fill = GridBagConstraints.HORIZONTAL;
			constraintsLabelExtText.anchor = GridBagConstraints.WEST;
			constraintsLabelExtText.weightx = 1.0;
			constraintsLabelExtText.insets = new Insets(4, 4, 4, 4);
			add(getLabelExtText(), constraintsLabelExtText);

			initConnections();
			connEtoC1();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		setNullable(isNullable());
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		// user code end

		//System.out.println("TextDate: "+this.hashCode());
	}

	public void clearTextValue() {
		getJCalendarPanel1().clearTextValue();
	}

	public boolean isDataMissing() {

		if (getJCalendarPanel1().getDataText().length() == 0 || getJCalendarPanel1().getDataText().trim().startsWith("-")) {
			InfoView.showErrorDialog(this, "¡ Escoja una fecha !");
			getJCalendarPanel1().getTextFieldExtComponent().setToPainterERROR();
			this.requestFocus();
			return true;
		}
		getJCalendarPanel1().getTextFieldExtComponent().restorePainter();
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		if (getJCalendarPanel1().getDataText().length() == 0 || getJCalendarPanel1().getDataText().trim().startsWith("-")) {
			InfoView.showErrorDialog(this, errorMessage);
			getJCalendarPanel1().getTextFieldExtComponent().setToPainterERROR();
			this.requestFocus();
			return true;
		}
		getJCalendarPanel1().getTextFieldExtComponent().restorePainter();
		return false;
	}

	/**
	 * Insert the method's description here. Creation date: (2002-12-30
	 * 15:31:57)
	 * 
	 * @return boolean
	 */
	public boolean isNullable() {
		return nullable;
	}

	public void setBackground(Color c) {
		super.setBackground(c);
		getJCheckBoxExt().setBackground(c);
		getJCalendarPanel1().setBackground(c);
		getLabelExtText().setBackground(c);
	}

	public void setEnabled(boolean aFlag) {

		super.setEnabled(aFlag);

		if (isNullable()) {
			getJCheckBoxExt().setVisible(aFlag);
			getLabelExtText().setVisible(!aFlag);
			if (!aFlag) {
				getJCalendarPanel1().setEnabled(false);
				getLabelExtText().setText(getLabelExtText().getText().trim() + "     ");
			}
		} else
			getJCalendarPanel1().setEnabled(aFlag);
	}

	public void setForeground(Color c) {
		super.setForeground(c);
		if (isNullable())
			getJCheckBoxExt().setForeground(c);
	}

	/**
	 * Insert the method's description here. Creation date: (2002-12-30* 15:31:57)
	 * 
	 * @param newNullable
	 *            boolean
	 */
	public void setNullable(boolean newNullable) {
		nullable = newNullable;
		// ...
		if (newNullable) {
			getJCheckBoxExt().setText(getTextForNullable());
			getLabelExtText().setText(getTextForNullable());

			getJCalendarPanel1().setEnabled(false);
			setValue(null);
		} else
			getJCalendarPanel1().setEnabled(true);

		getJCheckBoxExt().setVisible(newNullable);
		getLabelExtText().setVisible(newNullable);
	}

	public void setSelected(boolean b) {

		if (isNullable())
			getJCheckBoxExt().setSelected(b);
	}

	/**
	 * Method generated to support the promotion of the soloMesYAnio attribute.
	 * 
	 * @param arg1
	 *            boolean
	 */
	public void setSoloMesYAnio(boolean arg1) {
		getJCalendarPanel1().setSoloMesYAnio(arg1);
	}

	/**
	 * Method generated to support the promotion of the textForNullable
	 * attribute.
	 * 
	 * @param arg1
	 *            java.lang.String
	 */
	public void setTextForNullable(java.lang.String arg1) {
		getJCheckBoxExt().setText(arg1);
		getLabelExtText().setText(arg1);
	}

	public void setValue(java.sql.Date aDate) {

		if (aDate == null) {
			getJCalendarPanel1().setCalendar(null);
			// getJCalendarPanel1().setEnabled(false);
			return;
		}

		java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		gc.setTime(aDate);
		getJCalendarPanel1().setCalendar(gc);

		if (isNullable())
			getJCheckBoxExt().setSelectedOption(getJCheckBoxExt().getTrueOption());
	}

	public String SQLText() {

		if (this.getYMD() == null)
			return " NULL ";
		else
			return " { d '" + getYMD() + "' } ";
	}

	private void visualManageNulls() {

		if (getJCheckBoxExt().isSelected()) {
			getJCalendarPanel1().setEnabled(true);
			getJCalendarPanel1().setCalendar((java.util.GregorianCalendar) getJCalendarPanel1().getCalendar());
		} else {
			getJCalendarPanel1().setEnabled(false);
			getJCalendarPanel1().setCalendar(null);
		}
	}

	/**
	 * 
	 */
	public void requestFocus() {
		if (getJCheckBoxExt().isVisible()) {
			getJCheckBoxExt().requestFocus();
		} else {
			if (getLabelExtText().isVisible()) {
				getLabelExtText().requestFocus();
			} else {
				getJCalendarPanel1().requestFocus();
			}
		}
	}

	/**
	 * 
	 */
	public void setMnemonic(char mnemonic) {
		getJCalendarPanel1().setMnemonic(mnemonic);
	}

	/**
	 * 
	 */
	public void setEditable(boolean editable) {
		getJCalendarPanel1().setEditable(editable);
		getJCheckBoxExt().setEnabled(editable);
	}
	/**
	 * 
	 */
	public void setBorder(Border unBorde) {
		try {
			getJCalendarPanel1().setBorder(unBorde);
		} catch (Exception e1) {
			e1.getMessage();
		}
		try {
			this.getJCheckBoxExt().setBorder(unBorde);
		} catch (Exception e2) {
			e2.getMessage();
		}
	}

	/**
	 * 
	 */
    public void addActionListener(ActionListener l) {
        getJCalendarPanel1().addActionListener(l);
    }

    /**
     * 
     */
	public void addTextDateListener(TextDateListener newListener) {
		this.listeners.addElement(newListener);
	}
	/**
	 * 
	 */
	public void setIcon(ImageIcon icon) {
		getJCalendarPanel1().setIcon(icon);
	}
}
