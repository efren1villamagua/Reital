package efren.util.gui.calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JCalendar is a bean for entering a date by choosing the year, month and day.
 * 
 * @version 1.1 02/14/02
 * @author Kai Toedter
 */
public class JCalendar extends JPanel implements PropertyChangeListener {
	
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JDayChooser dayChooser;
	private Calendar calendar;
	private Locale locale;
	private boolean initialized = false;
	private boolean fieldDayChooserVisible = true;

	/**
	 * Default JCalendar constructor.
	 */
	public JCalendar() {
		this(JMonthChooser.LEFT_SPINNER);
	}

	/**
	 * JCalendar constructor with month spinner parameter.
	 * 
	 * @param monthSpinner
	 *            Possible values are JMonthChooser.RIGHT_SPINNER,
	 *            JMonthChooser.LEFT_SPINNER, JMonthChooser.NO_SPINNER
	 */
	public JCalendar(int monthSpinner) {
		// needed for setFont() etc.
		dayChooser = null;
		monthChooser = null;
		yearChooser = null;

		locale = Locale.getDefault();
		calendar = Calendar.getInstance();

		// setLayout(new BorderLayout());
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(1, 3));
		monthChooser = new JMonthChooser(monthSpinner);
		yearChooser = new JYearChooser();
		monthChooser.setYearChooser(yearChooser);
		myPanel.add(monthChooser);
		myPanel.add(yearChooser);
		dayChooser = new JDayChooser();
		dayChooser.addPropertyChangeListener(this);
		monthChooser.setDayChooser(dayChooser);
		monthChooser.addPropertyChangeListener(this);
		yearChooser.setDayChooser(dayChooser);
		yearChooser.addPropertyChangeListener(this);

		this.setLayout(new java.awt.GridBagLayout());

		java.awt.GridBagConstraints constraintsMyPanel = new java.awt.GridBagConstraints();
		constraintsMyPanel.gridx = 0;
		constraintsMyPanel.gridy = 0;
		constraintsMyPanel.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsMyPanel.weightx = 1.0;
		constraintsMyPanel.weighty = 0.0;
		constraintsMyPanel.ipady = 12;
		constraintsMyPanel.insets = new java.awt.Insets(2, 1, 1, 1);
		add(myPanel, constraintsMyPanel);

		java.awt.GridBagConstraints constraintsDayChooser = new java.awt.GridBagConstraints();
		constraintsDayChooser.gridx = 0;
		constraintsDayChooser.gridy = 1;
		constraintsDayChooser.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsDayChooser.weightx = 1.0;
		constraintsDayChooser.weighty = 0.0;
		constraintsMyPanel.ipady = -12;
		constraintsDayChooser.insets = new java.awt.Insets(1, 1, 1, 1);
		add(dayChooser, constraintsDayChooser);

		initialized = true;

		// ...
		setLocale(new Locale("es", "ec"));
	}

	/**
	 * Returns the calendar property.
	 * 
	 * @return the value of the calendar property.
	 * @see #setCalendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	/**
	 * Gets the dayChooserVisible property (boolean) value.
	 * 
	 * @return The dayChooserVisible property value.
	 * @see #setDayChooserVisible
	 */
	public boolean getDayChooserVisible() {
		return fieldDayChooserVisible;
	}

	/**
	 * Returns the locale.
	 * 
	 * @return the value of the locale property.
	 * @see #setLocale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Returns "JCalendar".
	 */
	public String getName() {
		return "JCalendar";
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}

	/**
	 * Creates a JFrame with a JCalendar inside and can be used for testing.
	 */
	static public void main(String[] s) {
		JFrame frame = new JFrame("JCalendar");
		frame.getContentPane().add(new JCalendar());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * JCalendar is a PropertyChangeListener, for its day, month and year
	 * chooser.
	 */
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("cerrar")) {
			firePropertyChange("cerrar", "old", "new");
		}

		GregorianCalendar cTemp = null;
		if (this.calendar == null) {
			if (evt.getPropertyName().equals("day") || evt.getPropertyName().equals("month") || evt.getPropertyName().equals("year")) {
				cTemp = new GregorianCalendar();
			}
		} else {
			cTemp = (GregorianCalendar) this.calendar.clone();
		}

		if (cTemp != null) {
			if (evt.getPropertyName().equals("day")) {
				cTemp.set(Calendar.DAY_OF_MONTH, ((Integer) evt.getNewValue()).intValue());
				setCalendar(cTemp, false);
			} else if (evt.getPropertyName().equals("month")) {
				cTemp.set(Calendar.MONTH, ((Integer) evt.getNewValue()).intValue());
				setCalendar(cTemp, false);
			} else if (evt.getPropertyName().equals("year")) {
				cTemp.set(Calendar.YEAR, ((Integer) evt.getNewValue()).intValue());
				setCalendar(cTemp, false);
			}
		}

	}

	/**
	 * Sets the background color.
	 * 
	 * @param bg
	 *            the new background
	 */
	public void setBackground(Color bg) {
		// no hacemos nada
		// super.setBackground(bg);

		/*
		 * if (dayChooser != null) dayChooser.setBackground(bg);
		 */
	}

	/**
	 * Sets the calendar property. This is a bound property.
	 * 
	 * @see #getCalendar
	 * @param c
	 *            the new calendar
	 */
	public void setCalendar(Calendar c) {
		setCalendar(c, true);
	}

	public void set2Calendar(Calendar c) {
		this.calendar = c;
	}

	private void setCalendar(Calendar c, boolean update) {
		Calendar oldCalendar = calendar;
		calendar = c;
		if (update && c != null) {
			// Thanks to Jeff Ulmer for correcting a bug in the sequence :)
			dayChooser.setDay(c.get(Calendar.DATE));
			monthChooser.setMonth(c.get(Calendar.MONTH));
			yearChooser.setYear(c.get(Calendar.YEAR));
		}
		firePropertyChange("calendar", oldCalendar, calendar);
	}

	/**
	 * Sets the dayChooserVisible property (boolean) value.
	 * 
	 * @param dayChooserVisible
	 *            The new value for the property.
	 * @see #getDayChooserVisible
	 */
	public void setDayChooserVisible(boolean dayChooserVisible) {
		boolean oldValue = fieldDayChooserVisible;
		fieldDayChooserVisible = dayChooserVisible;
		firePropertyChange("dayChooserVisible", new Boolean(oldValue), new Boolean(dayChooserVisible));
		// ...
		dayChooser.setVisible(dayChooserVisible);
	}

	/**
	 * Sets the font property.
	 * 
	 * @param font
	 *            the new font
	 */
	public void setFont(Font font) {
		super.setFont(font);
		if (dayChooser != null) {
			dayChooser.setFont(font);
			monthChooser.setFont(font);
			yearChooser.setFont(font);
		}
	}

	/**
	 * Sets the foreground color.
	 * 
	 * @param fg
	 *            the new foreground
	 */
	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (dayChooser != null) {
			dayChooser.setForeground(fg);
			monthChooser.setForeground(fg);
			yearChooser.setForeground(fg);
		}
	}

	/**
	 * Sets the locale property. This is a bound property.
	 * 
	 * @see #getLocale
	 */
	public void setLocale(Locale l) {
		if (!initialized)
			super.setLocale(l);
		else {
			Locale oldLocale = locale;
			locale = l;
			dayChooser.setLocale(locale);
			monthChooser.setLocale(locale);
			firePropertyChange("locale", oldLocale, locale);
		}
	}
	/**
	 * 
	 */
    public void addActionListener(ActionListener l) {
        dayChooser.addActionListener(l);
    }

}
