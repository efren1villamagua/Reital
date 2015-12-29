package efren.util.gui.calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * JCalendar is a bean for choosing a day.
 * 
 * @author Kai Toedter
 * @version 1.1.1 06/25/02
 */
public class JDayChooser extends JPanel implements ActionListener, KeyListener, FocusListener {
	private JButton dias[];

	private JButton selectedDay;

	private int dia;

	private Color oldDayBackgroundColor;

	private Color selectedColor;

	private Color colorRed;

	private Color colorBlue;

	private String dayNames[];

	private Calendar calendar;

	private Calendar today;

	private Locale locale;

	private boolean initialized = false;

	/**
	 * Default JDayChooser constructor.
	 */
	public JDayChooser() {
		locale = Locale.getDefault();
		dias = new JButton[49];
		selectedDay = null;
		Calendar calendar = Calendar.getInstance(locale);
		today = (Calendar) calendar.clone();

		setLayout(new GridLayout(7, 7));

		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				int index = x + 7 * y;
				if (y == 0) {
					// Create a button that doesn't react on clicks or focus
					// changes
					// Thanks to Thomas Schaefer for the focus hint :)
					dias[index] = new JButton() {
						public void addMouseListener(MouseListener l) {
						}
						public boolean isFocusable() {
							return false;
						}
					};
					dias[index].setBackground(new Color(180, 180, 200));
				} else {
					dias[index] = new JButton("x");
					dias[index].addActionListener(this);
					dias[index].addKeyListener(this);
					dias[index].addFocusListener(this);
				}

				dias[index].setMargin(new Insets(0, 0, 0, 0));
				dias[index].setFocusPainted(false);
				add(dias[index]);
			}
		}
		init();
		setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		initialized = true;
	}

	/**
	 * JDayChooser is the ActionListener for all day buttons.
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String buttonText = button.getText();

		int day = new Integer(buttonText).intValue();

		setDay(day);

		firePropertyChange("cerrar", "old", "new");
		
		fireActionPerformed(e);
	}
	/**
	 * 
	 */
	private void fireActionPerformed(ActionEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i++) {
        	try {
        		((ActionListener) listeners[i]).actionPerformed(event);
			} catch (Exception e) {
				e.getMessage();
			}
        }
	}
	/**
	 * Hides and shows the day buttons.
	 */
	protected void drawDays() {
		Calendar tmpCalendar = (Calendar) calendar.clone();
		int firstDayOfWeek = tmpCalendar.getFirstDayOfWeek();
		tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);

		int firstDay = tmpCalendar.get(Calendar.DAY_OF_WEEK) - firstDayOfWeek;
		if (firstDay < 0) {
			firstDay += 7;
		}

		int i;

		for (i = 0; i < firstDay; i++) {
			dias[i + 7].setVisible(false);
			dias[i + 7].setText("");
		}

		tmpCalendar.add(Calendar.MONTH, 1);
		Date firstDayInNextMonth = tmpCalendar.getTime();
		tmpCalendar.add(Calendar.MONTH, -1);

		Date day = tmpCalendar.getTime();
		int n = 0;
		Color foregroundColor = getForeground();
		while (day.before(firstDayInNextMonth)) {
			dias[i + n + 7].setText(Integer.toString(n + 1));
			dias[i + n + 7].setVisible(true);
			if (tmpCalendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR) && tmpCalendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
				dias[i + n + 7].setForeground(colorRed);
			} else {
				dias[i + n + 7].setForeground(foregroundColor);
			}

			if (n + 1 == this.dia) {
				dias[i + n + 7].setBackground(selectedColor);
				selectedDay = dias[i + n + 7];
			} else {
				dias[i + n + 7].setBackground(oldDayBackgroundColor);
			}

			n++;
			tmpCalendar.add(Calendar.DATE, 1);
			day = tmpCalendar.getTime();
		}

		for (int k = n + i + 7; k < 49; k++) {
			dias[k].setVisible(false);
			dias[k].setText("");
		}
	}

	/**
	 * JDayChooser is the FocusListener for all day buttons. (Added by Thomas
	 * Schaefer)
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void focusGained(FocusEvent e) {
/*		
		JButton button = (JButton) e.getSource();
		String buttonText = button.getText();
		if (buttonText != null && !buttonText.equals("")) {

			// JButton button = (JButton) e.getSource();
			// String buttonText = button.getText();
			int day = new Integer(buttonText).intValue();
			setDay(day);

			// actionPerformed(new ActionEvent(e.getSource(), 0, null));
		}
*/
	}

	/**
	 * Does nothing.
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void focusLost(FocusEvent e) {
	}

	/**
	 * Returns the selected day.
	 * 
	 * @return The day value
	 * @see #setDay
	 */
	public int getDay() {
		return dia;
	}

	/**
	 * Returns the locale.
	 * 
	 * @return The locale value
	 * @see #setLocale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Returns "JDayChooser".
	 * 
	 * @return The name value
	 */
	public String getName() {
		return "JDayChooser";
	}

	/**
	 * Initilizes the locale specific names for the days of the week.
	 */
	protected void init() {
		colorRed = new Color(164, 0, 0);
		colorBlue = new Color(0, 0, 164);
		JButton testButton = new JButton();
		oldDayBackgroundColor = testButton.getBackground();
		selectedColor = new Color(160, 160, 160);

		calendar = Calendar.getInstance(locale);
		int firstDayOfWeek = calendar.getFirstDayOfWeek();
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		dayNames = dateFormatSymbols.getShortWeekdays();
		int day = firstDayOfWeek;
		for (int i = 0; i < 7; i++) {
			dias[i].setText(dayNames[day]);
			if (day == 1) {
				dias[i].setForeground(colorRed);
			} else {
				dias[i].setForeground(colorBlue);
			}

			if (day < 7) {
				day++;
			} else {
				day -= 6;
			}

		}
		drawDays();
	}

	/**
	 * JDayChooser is the KeyListener for all day buttons. (Added by Thomas
	 * Schaefer)
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void keyPressed(KeyEvent e) {
		int offset = e.getKeyCode() == KeyEvent.VK_UP ? -7 : e.getKeyCode() == KeyEvent.VK_DOWN ? +7 : e.getKeyCode() == KeyEvent.VK_LEFT ? -1
				: e.getKeyCode() == KeyEvent.VK_RIGHT ? +1 : 0;

		if (offset != 0) {
			for (int i = getComponentCount() - 1; i >= 0; --i) {
				if (getComponent(i) == selectedDay) {
					i += offset;
					if (i > 7 && i < dias.length && dias[i].isVisible()) {
						dias[i].requestFocus();
						// int day = new Integer(dias[i].getText()).intValue();
						// setDay( day );
					}
					break;
				}
			}
		}
	}

	/**
	 * Does nothing.
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Does nothing.
	 * 
	 * @param e
	 *            Description of the Parameter
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Sets a specific calendar. This is needed for correct graphical
	 * representation of the days.
	 * 
	 * @param c
	 *            the new calendar
	 */
	public void setCalendar(Calendar c) {
		calendar = c;
		drawDays();
	}

	/**
	 * Sets the day. This is a bound property.
	 * 
	 * @param d
	 *            the day
	 * @see #getDay
	 */
	public void setDay(int d) {
		//calendar.set(Calendar.DAY_OF_MONTH, d);
		if (d < 1) {
			d = 1;
		}

		Calendar tmpCalendar = (Calendar) calendar.clone();
		tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);
		tmpCalendar.add(Calendar.MONTH, 1);
		tmpCalendar.add(Calendar.DATE, -1);
		int maxDaysInMonth = tmpCalendar.get(Calendar.DATE);

		if (d > maxDaysInMonth) {
			d = maxDaysInMonth;
		}

		int oldDay = dia;
		dia = d;
		
		//System.out.println(dia);

		if (selectedDay != null) {
			selectedDay.setBackground(oldDayBackgroundColor);
			selectedDay.repaint();
			// Bug: needed for Swing 1.0.3
		}

		for (int i = 7; i < 49; i++) {
			if (dias[i].getText().equals(Integer.toString(dia))) {
				selectedDay = dias[i];
				selectedDay.setBackground(selectedColor);
				break;
			}
		}
		// firePropertyChange("day", oldDay, dia);//???efren
		firePropertyChange("day", -1, dia);
	}

	/**
	 * Sets the font property.
	 * 
	 * @param font
	 *            the new font
	 */
	public void setFont(Font font) {
		if (dias != null) {
			for (int i = 0; i < 49; i++) {
				dias[i].setFont(font);
			}
		}
	}

	/**
	 * Sets the foregroundColor color.
	 * 
	 * @param fg
	 *            the new foregroundColor
	 */
	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (dias != null) {
			for (int i = 7; i < 49; i++) {
				dias[i].setForeground(fg);
			}
			drawDays();
		}
	}

	/**
	 * Sets the locale.
	 * 
	 * @param l
	 *            The new locale value
	 * @see #getLocale
	 */
	public void setLocale(Locale l) {
		if (!initialized) {
			super.setLocale(l);
		} else {
			locale = l;
			init();
		}
	}

	/**
	 * Sets a specific month. This is needed for correct graphical
	 * representation of the days.
	 * 
	 * @param month
	 *            the new month
	 */
	public void setMonth(int month) {
		calendar.set(Calendar.MONTH, month);
		setDay(dia);
		drawDays();
	}

	/**
	 * Sets a specific year. This is needed for correct graphical representation
	 * of the days.
	 * 
	 * @param year
	 *            the new year
	 */
	public void setYear(int year) {
		calendar.set(Calendar.YEAR, year);
		drawDays();
	}
	
	/**
	 * 
	 */
    public void addActionListener(ActionListener l) {
        listenerList.add(ActionListener.class, l);
    }

}
