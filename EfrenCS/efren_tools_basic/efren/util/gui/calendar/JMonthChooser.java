package efren.util.gui.calendar;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import javax.swing.*;

/**
 *  JMonthChooser is a bean for choosing a month.
 *
 *@author     Kai Toedter
 *@version    1.1.3 06/27/02
 */
public class JMonthChooser extends JPanel implements ItemListener,
		AdjustmentListener {

	/**
	 *  Displays a JSpinField on the right
	 */
	public final static int RIGHT_SPINNER = 0;
	/**
	 *  Displays a JSpinField on the left
	 */
	public final static int LEFT_SPINNER = 1;
	/**
	 *  Displays no JSpinField
	 */
	public final static int NO_SPINNER = 2;


	private Locale locale;
	private int month;
	private int oldScrollBarValue = 0;
	// needed for comparison
	private JDayChooser dayChooser = null;
	private JYearChooser yearChooser = null;
	private efren.util.gui.combo.ObjectComboBox objectComboBox;
	private boolean initialized = false;
	private boolean localInitialize = false;
	/**
	 *  Default JMonthChooser constructor.
	 */
	public JMonthChooser() {
		this(RIGHT_SPINNER);
	}
/**
 *  JMonthChooser constructor with month spinner parameter.
 *
 *@param  spinner  Possible values are RIGHT_SPINNER, LEFT_SPINNER, NO_SPINNER
 */
public JMonthChooser(int spinner) {
    super();

    this.setLayout(new java.awt.GridBagLayout());

    this.objectComboBox = new efren.util.gui.combo.ObjectComboBox();
    this.objectComboBox.addItemListener(this);
    dayChooser = null;
    locale = Locale.getDefault();
    initNames();

	java.awt.GridBagConstraints constraintsCombo = new java.awt.GridBagConstraints();
    constraintsCombo.fill = java.awt.GridBagConstraints.HORIZONTAL;
    constraintsCombo.weightx = 1.0;
    constraintsCombo.weighty = 0.0;
    constraintsCombo.ipady = 0;
    constraintsCombo.insets = new java.awt.Insets(0, 0, 0, 0);
    constraintsCombo.gridy = 0;
    if (spinner == NO_SPINNER)
	    constraintsCombo.gridx = 0;
	else {
	    if (spinner == LEFT_SPINNER)
		    constraintsCombo.gridx = 1;
	    else {
		    if (spinner == RIGHT_SPINNER)
			    constraintsCombo.gridx = 0;
	    }
	}
    add(this.objectComboBox, constraintsCombo);

    if (spinner != NO_SPINNER) {
        // 10000 possible clicks in both directions should be enough :)
        JScrollBar scrollBar = new JScrollBar(Adjustable.VERTICAL, 0, 0, -10000, 10000);
        scrollBar.setPreferredSize(new Dimension(scrollBar.getPreferredSize().width, this.getPreferredSize().height));
        scrollBar.setVisibleAmount(0);
        scrollBar.addAdjustmentListener(this);

		java.awt.GridBagConstraints constraintsScrollBar = new java.awt.GridBagConstraints();
		constraintsScrollBar.gridy = 0;
		constraintsScrollBar.fill = java.awt.GridBagConstraints.VERTICAL;
		constraintsScrollBar.weightx = 0.0;
		constraintsScrollBar.weighty = 1.0;
		constraintsScrollBar.ipady = 0;
		constraintsScrollBar.insets = new java.awt.Insets(0, 0, 0, 0);
        if (spinner == LEFT_SPINNER)
			constraintsScrollBar.gridx = 0;
		else {
        	if (spinner == RIGHT_SPINNER)
				constraintsScrollBar.gridx = 1;
        }
		add(scrollBar, constraintsScrollBar);
    }

    initialized = true;
    setMonth(Calendar.getInstance().get(Calendar.MONTH));
}
	/**
	 *  The 2 buttons are implemented with a JScrollBar.
	 *
	 *@param  e  Description of the Parameter
	 */
	public void adjustmentValueChanged(AdjustmentEvent e) {
		boolean increase = true;
		int newScrollBarValue = e.getValue();
		if (newScrollBarValue > oldScrollBarValue) {
			increase = false;
		}
		oldScrollBarValue = newScrollBarValue;
		int month = getMonth();
		if (increase) {
			month += 1;
			if (month == 12) {
				month = 0;
				if (yearChooser != null) {
					int year = yearChooser.getYear();
					year += 1;
					yearChooser.setYear(year);
				}
			}
		} else {
			month -= 1;
			if (month == -1) {
				month = 11;
				if (yearChooser != null) {
					int year = yearChooser.getYear();
					year -= 1;
					yearChooser.setYear(year);
				}
			}
		}
		setMonth(month);
	}
	/**
	 *  Returns the locale.
	 *
	 *@return    The locale value
	 *@see       #setLocale
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 *  Returns the month.
	 *
	 *@return    The month value
	 *@see       #setMonth
	 */
	public int getMonth() {
		return month;
	}
	/**
	 *  Initializes the locale specific month names.
	 */
	public void initNames() {
		localInitialize = true;

		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		String[] monthNames = dateFormatSymbols.getMonths();

		if (this.objectComboBox.getItemCount() == 12) {
			this.objectComboBox.removeAllItems();
		}
		for (int i = 0; i < 12; i++) {
			this.objectComboBox.addItem(monthNames[i]);
		}

		localInitialize = false;
		this.objectComboBox.setSelectedIndex(month);
	}
	/**
	 *  The ItemListener for the months.
	 *
	 *@param  iEvt  Description of the Parameter
	 */
	public void itemStateChanged(ItemEvent iEvt) {
		int index = this.objectComboBox.getSelectedIndex();
		if (index >= 0) {
			setMonth(index, false);
		}
	}
	/**
	 *  Convenience method set a day chooser.
	 *
	 *@param  dayChooser  the day chooser
	 */
	public void setDayChooser(JDayChooser dayChooser) {
		this.dayChooser = dayChooser;
	}
	/**
	 *  Set the locale and initializes the new month names.
	 *
	 *@param  l  The new locale value
	 *@see       #getLocale
	 */
	public void setLocale(Locale l) {
		if (!initialized) {
			super.setLocale(l);
		} else {
			locale = l;
			initNames();
		}
	}
	/**
	 *  Sets the month. This is a bound property.
	 *
	 *@param  newMonth  The new month value
	 *@see              #getMonth
	 */
	public void setMonth(int newMonth) {
		setMonth(newMonth, true);
	}
	/**
	 *  Sets the month attribute of the JMonthChooser object
	 *
	 *@param  newMonth  The new month value
	 *@param  select    The new month value
	 */
	private void setMonth(int newMonth, boolean select) {
		if (!initialized || localInitialize) {
			return;
		}

		int oldMonth = month;
		month = newMonth;
		if (select) {
			this.objectComboBox.setSelectedIndex(month);
		}
		if (dayChooser != null) {
			dayChooser.setMonth(month);
		}
		firePropertyChange("month", oldMonth, month);
	}
	/**
	 *  Convenience method set a year chooser. If set, the spin buttons will spin
	 *  the year as well
	 *
	 *@param  yearChooser  The new yearChooser value
	 */
	public void setYearChooser(JYearChooser yearChooser) {
		this.yearChooser = yearChooser;
	}
}
