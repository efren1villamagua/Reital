package efren.util.gui.calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import efren.util.gui.dialogs.InfoView;

/**
 * A demonstration Applet for the JCalendar bean.
 * The demo can also be started as Java application.
 *
 * @version 1.1 02/04/02
 * @author  Kai Toedter
 */
public class JCalendarDemo extends JApplet implements PropertyChangeListener {
    /**
     * Action to show the About dialog
     */
    class AboutAction extends AbstractAction {
        AboutAction(JCalendarDemo demo) {
            super("About...");
            this.demo = demo;
        }

        public void actionPerformed(ActionEvent event) {
        	InfoView.showMessageDialog(demo, "JCalendar Demo\nVersion 1.1\n\nKai Toedter\nkai@toedter.com\nwww.toedter.com",
                    "About...", InfoView.INFORMATION_MESSAGE);
        }

        private JCalendarDemo demo;
    }

    private JPanel calendarPanel;
    private JPanel demoPanel;
    private JCalendar jcalendar1;
    private JCalendar jcalendar2;
    private JCalendar jcalendar3;
    private JTextField dateField;
    private JLocaleChooser localeChooser;
    private Calendar calendar;
//    private KunststoffLookAndFeel kunststoffLnF;
    /**
    * Creates the menu bar
    */
    public JMenuBar createMenuBar() {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout());

        // Menu for the look and feels (lnfs).
        UIManager.LookAndFeelInfo[] lnfs =
                UIManager.getInstalledLookAndFeels();

        ButtonGroup lnfGroup = new ButtonGroup();
        JMenu lnfMenu = new JMenu("Look&Feel");
        lnfMenu.setMnemonic('L');

        menuBar.add(lnfMenu);

        for (int i = 0; i < lnfs.length; i++) {
            if (!lnfs[i].getName().equals("CDE/Motif")) {
                JRadioButtonMenuItem rbmi =
                        new JRadioButtonMenuItem(lnfs[i].getName());
                lnfMenu.add(rbmi);

                // preselect the current Look & feel
                rbmi.setSelected(
                        UIManager.getLookAndFeel().getName().equals (
                        lnfs[i].getName()));

                // store lool & feel info as client property
                rbmi.putClientProperty("lnf name", lnfs[i]);

                // create and add the item listener
                rbmi.addItemListener(// inlining
                  new ItemListener() {
                      public void itemStateChanged(ItemEvent ie) {
                          JRadioButtonMenuItem rbmi2 =
                                  (JRadioButtonMenuItem) ie.getSource();
                        if (rbmi2.isSelected()) {
                              // get the stored look & feel info
                              UIManager.LookAndFeelInfo info =
                                      (UIManager.LookAndFeelInfo)
                                      rbmi2.getClientProperty("lnf name");
                            try {/*
                                  // setting the Kunststoff L&F with info.getClassName()
                                  // does not work with some Java Plugins
                                  if( info.getClassName().equals( "com.incors.plaf.kunststoff.KunststoffLookAndFeel" ) )
                                      UIManager.setLookAndFeel(kunststoffLnF);
                                  else
                                      UIManager.setLookAndFeel(info.getClassName());
                                  // update the complete application's look & feel
                                  */
                                  SwingUtilities.updateComponentTreeUI(
                                          JCalendarDemo.this);
                            } catch (Exception e) {
                                  System.err.println( "Unable to set UI " +
                                          e.getMessage());
                              }
                          }
                      }
                  }
                );
                lnfGroup.add(rbmi);
            }
        }


        // the help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');

        JMenuItem aboutItem = helpMenu.add(new AboutAction(this));
        aboutItem.setMnemonic('A');
        aboutItem.setAccelerator(
                KeyStroke.getKeyStroke('A', java.awt.Event.CTRL_MASK));

        menuBar.add(helpMenu);

        return menuBar;
    }
    /**
     * Initializes the applet.
     */
    public void init() {

        getContentPane().setLayout(new BorderLayout());
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        JLocaleChooser localeChooser = new JLocaleChooser();
        localeChooser.addPropertyChangeListener(this);
        controlPanel.add(new JLabel(" Locale:   "), BorderLayout.WEST);
        controlPanel.add(localeChooser, BorderLayout.CENTER);

        dateField = new JTextField();
        dateField.setEditable(false);
        controlPanel.add(dateField, BorderLayout.SOUTH);

        JTabbedPane tabbedPane = new JTabbedPane();

        jcalendar1 = new JCalendar();
        jcalendar1.setBorder(new EmptyBorder(10, 10, 10, 10));
        jcalendar1.addPropertyChangeListener(this);

        jcalendar2 = new JCalendar(JMonthChooser.LEFT_SPINNER);
        jcalendar2.setBorder(new EmptyBorder(10, 10, 10, 10));
        jcalendar2.addPropertyChangeListener(this);

        jcalendar3 = new JCalendar(JMonthChooser.NO_SPINNER);
        jcalendar3.setBorder(new EmptyBorder(10, 10, 10, 10));
        jcalendar3.addPropertyChangeListener(this);

        tabbedPane.addTab("Demo 1", null, jcalendar1 , "Default JCalendar");
        tabbedPane.addTab("Demo 2", null, jcalendar2 , "JCalendar with left month spinner");
        tabbedPane.addTab("Demo 3", null, jcalendar3 , "JCalendar with no month spinner");
        tabbedPane.setSelectedIndex(0);

        calendarPanel.add(controlPanel, BorderLayout.NORTH);
        calendarPanel.add(tabbedPane, BorderLayout.CENTER);
        getContentPane().add(createMenuBar(), BorderLayout.NORTH);
        getContentPane().add(calendarPanel, BorderLayout.CENTER);

        calendar = Calendar.getInstance();
        jcalendar1.setCalendar(calendar);
    }
    /**
     * Creates a JFrame with a JCalendarDemo inside and can be used for testing.
     */
    static public void main(String[] s) {
        WindowListener l = new WindowAdapter() {
                               public void windowClosing(WindowEvent e) {
                                   System.exit(0);
                               }
                           };

        JFrame frame = new JFrame("JCalendar Demo");
        frame.addWindowListener(l);
        JCalendarDemo demo = new JCalendarDemo();
        demo.init();
        frame.getContentPane().add(demo);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * The applet is a PropertyChangeListener for "locale" and "calendar".
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if (calendarPanel != null) {
            if (evt.getPropertyName().equals("locale")) {
                jcalendar1.setLocale((Locale) evt.getNewValue());
                jcalendar2.setLocale((Locale) evt.getNewValue());
                jcalendar3.setLocale((Locale) evt.getNewValue());
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,
                        jcalendar1.getLocale());
                dateField.setText(df.format(calendar.getTime()));
            } else if (evt.getPropertyName().equals("calendar")) {
                calendar = (Calendar) evt.getNewValue();
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,
                        jcalendar1.getLocale());
                dateField.setText(df.format(calendar.getTime()));
                jcalendar1.setCalendar(calendar);
                jcalendar2.setCalendar(calendar);
                jcalendar3.setCalendar(calendar);
            }
        }
    }
}
