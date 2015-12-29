package efren.util.gui.about;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import efren.util.gui.dialogs.InfoView;

public class SystemInfoPanel extends JPanel implements ActionListener, MouseListener {

	JScrollPane scrollPane;
	JTable table;
	DefaultTableModel model;
	JPanel memPanel;
	JLabel memLabel1;
	JLabel memLabel2;
	JLabel memLabel3;
	javax.swing.Timer timer;

	public SystemInfoPanel(Dimension dimension) {
		super(new BorderLayout());
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		scrollPane = new JScrollPane();
		model = new DefaultTableModel();
		table = new JTable(model) {

			public boolean isCellEditable(int k, int l) {
				return false;
			}

		};
		memPanel = new JPanel(new FlowLayout(0, 0, 10));
		timer = new javax.swing.Timer(1000, this);
		double d = Runtime.getRuntime().totalMemory();
		double d1 = (double) Runtime.getRuntime().totalMemory() - (double) Runtime.getRuntime().freeMemory();
		String s = String.valueOf(d / 1048576D);
		s = s.substring(0, s.indexOf(".")) + s.substring(s.indexOf("."), s.indexOf(".") + 1);
		if (s.charAt(s.length() - 1) == '.')
			s = s + "0";
		String s1 = String.valueOf(d1 / 1048576D);
		s1 = s1.substring(0, s1.indexOf(".")) + s1.substring(s1.indexOf("."), s1.indexOf(".") + 1);
		if (s1.charAt(s1.length() - 1) == '.')
			s1 = s1 + "1";
		// memLabel1 = new JLabel(Catalog.getString("Memoria") + ": ");
		memLabel1 = new JLabel("Memoria:    ");
		memLabel2 = new JLabel(s1);
		memLabel3 = new JLabel(" MB usada, " + s + " MB asignada");
		Properties properties = System.getProperties();
		Object aobj[] = new Object[properties.size()];
		Object aobj1[] = new Object[2];
		int i = 0;
		model.addColumn("Propiedad");
		model.addColumn("Valor");
		for (Enumeration enumeration = properties.propertyNames(); enumeration.hasMoreElements();) {
			aobj[i] = enumeration.nextElement();
			i++;
		}

		Arrays.sort(aobj);
		for (int j = 0; j < aobj.length; j++) {
			aobj1[0] = aobj[j];
			aobj1[1] = properties.getProperty((String) aobj[j]);
			model.addRow(aobj1);
		}

		table.setFont(new Font("Arial", 0, 12));
		table.setAutoResizeMode(0);
		table.addMouseListener(this);
		TableColumnModel tablecolumnmodel = table.getColumnModel();
		TableColumn tablecolumn = tablecolumnmodel.getColumn(0);
		TableColumn tablecolumn1 = tablecolumnmodel.getColumn(1);
		tablecolumn.setPreferredWidth(140);
		tablecolumn1.setPreferredWidth(280);
		scrollPane.getViewport().add(table, null);
		add(scrollPane, "Center");
		memPanel.add(memLabel1);
		memPanel.add(memLabel2);
		memPanel.add(memLabel3);
		add(memPanel, "South");
		timer.start();
	}

	public void actionPerformed(ActionEvent actionevent) {
		/*
		 * double d = (double) Runtime.getRuntime().totalMemory() - (double)
		 * Runtime.getRuntime().freeMemory(); String s = String.valueOf(d /
		 * 1048576D); s = s.substring(0, s.indexOf(".")) +
		 * s.substring(s.indexOf("."), s.indexOf(".") + 1); if
		 * (s.charAt(s.length() - 1) == '.') s = s + "1"; memLabel2.setText(s);
		 */
	}

	private Object formatObject(Object obj) {
		String s = (String) obj;
		String s1 = System.getProperty("path.separator", ";");
		if (s.indexOf(s1) > 0)
			return formatTable(s);
		else
			return formatString(s);
	}

	private Object formatString(String s) {
		StringBuffer stringbuffer = new StringBuffer(s);
		for (int i = 50; i < stringbuffer.length(); i += 50)
			stringbuffer.insert(i, '\n');

		return stringbuffer;
	}

	private Object formatTable(String s) {
		DefaultTableModel defaulttablemodel = new DefaultTableModel();
		final JTable table = new JTable(defaulttablemodel) {

			public boolean isCellEditable(int i, int j) {
				return false;
			}

		};
		defaulttablemodel.addColumn("");
		String s1 = System.getProperty("path.separator", ";");
		StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
		String as[] = new String[1];
		for (; stringtokenizer.hasMoreTokens(); defaulttablemodel.addRow(as))
			as[0] = stringtokenizer.nextToken();

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent mouseevent) {
				if (mouseevent.getClickCount() == 2) {
					int i = table.getSelectedRow();
					String s2 = (String) table.getValueAt(i, 0);
					InfoView.showMessageDialog(null, s2, "", 1);
				}
			}

		});
		return table;
	}

	public void mouseClicked(MouseEvent mouseevent) {
		if (mouseevent.getClickCount() == 2) {
			int i = table.getSelectedRow();
			String s = (String) table.getValueAt(i, 0);
			Object obj = table.getValueAt(i, 1);
			if (((String) obj).length() > 50)
				obj = formatObject(obj);
			InfoView.showMessageDialog(this, obj, s, 1);
		}
	}

	public void mouseEntered(MouseEvent mouseevent) {
	}

	public void mouseExited(MouseEvent mouseevent) {
	}

	public void mousePressed(MouseEvent mouseevent) {
	}

	public void mouseReleased(MouseEvent mouseevent) {
	}
}
