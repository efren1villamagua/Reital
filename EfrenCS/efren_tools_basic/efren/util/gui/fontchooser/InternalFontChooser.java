package efren.util.gui.fontchooser;

import inetsoft.report.Common;
import inetsoft.report.StyleFont;
import inetsoft.util.Catalog;
import inetsoft.util.Tool;
import inetsoft.util.internal.Common2D;
import inetsoft.util.internal.JTextField2;
import inetsoft.util.internal.NumField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InternalFontChooser extends JDialog {

	boolean ignore;

	Listener listener;

	JPanel fontPnl;

	JLabel fontL;

	JLabel styleL;

	JLabel sizeL;

	JPanel linePnl;

	JLabel underlineL;

	JLabel strikeL;

	JLabel effectsL;

	JPanel effectPnl;

	JPanel previewPnl;

	JLabel previewL;

	JPanel cmdPnl;

	JTextField fontTF;

	JTextField styleTF;

	NumField sizeTF;

	JList fontLT;

	JList styleLT;

	JList sizeLT;

	LineCombo underlineCH;

	LineCombo strikethroughCH;

	JCheckBox smallcapCK;

	JCheckBox allcapCK;

	JCheckBox subscriptCK;

	JCheckBox superscriptCK;

	JCheckBox shadowCK;

	FontPreview preview;

	JButton okB;

	JButton cancelB;

	StyleFont font;

	String styles[] = { Catalog.getString("PLAIN"), Catalog.getString("Bold"), Catalog.getString("Italic"),
			Catalog.getString("Bold-Italic") };

	int sizes[] = { 6, 7, 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72 };

	public InternalFontChooser(Frame frame, String s) {
		super(frame, true);
		ignore = false;
		listener = new Listener();
		setFont(new Font("Verdana", 0, 10));
		GridBagLayout gridbaglayout = new GridBagLayout();
		getContentPane().setLayout(gridbaglayout);
		fontPnl = new JPanel();
		gridbaglayout = new GridBagLayout();
		fontPnl.setLayout(gridbaglayout);
		GridBagConstraints gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 5, 10, 0);
		getContentPane().add(fontPnl, gridbagconstraints);
		fontL = new JLabel(Catalog.getString("Font") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.anchor = 17;
		fontPnl.add(fontL, gridbagconstraints);
		styleL = new JLabel(Catalog.getString("Font style") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.anchor = 17;
		gridbagconstraints.insets = new Insets(0, 5, 0, 0);
		fontPnl.add(styleL, gridbagconstraints);
		sizeL = new JLabel(Catalog.getString("Size") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.anchor = 17;
		gridbagconstraints.insets = new Insets(0, 5, 0, 5);
		fontPnl.add(sizeL, gridbagconstraints);
		fontTF = new JTextField2(10);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.fill = 1;
		fontPnl.add(fontTF, gridbagconstraints);
		styleTF = new JTextField2(10);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 5, 0, 0);
		fontPnl.add(styleTF, gridbagconstraints);
		sizeTF = new NumField(10, true);
		sizeTF.addActionListener(listener);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 5, 0, 5);
		fontPnl.add(sizeTF, gridbagconstraints);
		fontLT = new JList(Common.getAllFonts());
		fontLT.setName("fontLT");
		fontLT.setVisibleRowCount(5);
		fontLT.setPreferredSize(new Dimension(150, fontLT.getPreferredSize().height));
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.anchor = 12;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 10, 0, 0);
		fontPnl.add(new JScrollPane(fontLT), gridbagconstraints);
		styleLT = new JList(styles);
		styleLT.setName("styleLT");
		styleLT.setVisibleRowCount(5);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.anchor = 12;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 15, 0, 0);
		fontPnl.add(new JScrollPane(styleLT), gridbagconstraints);
		Vector vector = new Vector();
		for (int i = 0; i < sizes.length; i++)
			vector.addElement(Integer.toString(sizes[i]));

		sizeLT = new JList(vector);
		sizeLT.setName("sizeLT");
		sizeLT.setVisibleRowCount(5);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.anchor = 12;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 15, 0, 5);
		fontPnl.add(new JScrollPane(sizeLT), gridbagconstraints);
		linePnl = new JPanel();
		gridbaglayout = new GridBagLayout();
		linePnl.setLayout(gridbaglayout);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 5, 10, 0);
		getContentPane().add(linePnl, gridbagconstraints);
		underlineL = new JLabel(Catalog.getString("Underline") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		linePnl.add(underlineL, gridbagconstraints);
		strikeL = new JLabel(Catalog.getString("Strikethrough") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 20, 0, 10);
		linePnl.add(strikeL, gridbagconstraints);
		underlineCH = new LineCombo(1);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.anchor = 11;
		gridbagconstraints.fill = 1;
		linePnl.add(underlineCH, gridbagconstraints);
		strikethroughCH = new LineCombo(1);
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 20, 0, 10);
		linePnl.add(strikethroughCH, gridbagconstraints);
		effectsL = new JLabel(Catalog.getString("Effects") + ":");
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.anchor = 17;
		gridbagconstraints.insets = new Insets(0, 5, 0, 0);
		getContentPane().add(effectsL, gridbagconstraints);
		effectPnl = new JPanel();
		effectPnl.setLayout(new GridLayout(2, 3, 0, 0));
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 20, 10, 0);
		getContentPane().add(effectPnl, gridbagconstraints);
		smallcapCK = new JCheckBox(Catalog.getString("Small Caps"));
		effectPnl.add(smallcapCK);
		allcapCK = new JCheckBox(Catalog.getString("All Caps"));
		effectPnl.add(allcapCK);
		subscriptCK = new JCheckBox(Catalog.getString("Subscript"));
		effectPnl.add(subscriptCK);
		superscriptCK = new JCheckBox(Catalog.getString("Superscript"));
		effectPnl.add(superscriptCK);
		shadowCK = new JCheckBox(Catalog.getString("Shadow"));
		effectPnl.add(shadowCK);

		previewPnl = new JPanel();
		previewPnl.setLayout(new BorderLayout(0, 0));
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.weighty = 1.0D;
		gridbagconstraints.fill = 1;
		gridbagconstraints.insets = new Insets(0, 5, 0, 5);
		getContentPane().add(previewPnl, gridbagconstraints);
		previewL = new JLabel(Catalog.getString("Preview") + ":");
		previewPnl.add(previewL, "North");
		preview = new FontPreview();
		previewPnl.add(preview, "Center");

		cmdPnl = new JPanel();
		cmdPnl.setLayout(new FlowLayout(2, 20, 15));
		gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.gridwidth = 0;
		gridbagconstraints.fill = 1;
		getContentPane().add(cmdPnl, gridbagconstraints);
		okB = new JButton();
		okB.setLabel("    " + Catalog.getString("OK") + "    ");
		cmdPnl.add(okB);
		cancelB = new JButton();
		cancelB.setLabel("  " + Catalog.getString("Cancel") + "  ");
		cmdPnl.add(cancelB);
		setTitle(s);
		fontTF.setEditable(false);
		styleTF.setEditable(false);
		fontLT.addListSelectionListener(listener);
		styleLT.addListSelectionListener(listener);
		sizeLT.addListSelectionListener(listener);
		underlineCH.addItemListener(listener);
		strikethroughCH.addItemListener(listener);
		smallcapCK.addItemListener(listener);
		allcapCK.addItemListener(listener);
		subscriptCK.addItemListener(listener);
		superscriptCK.addItemListener(listener);
		shadowCK.addItemListener(listener);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowevent) {
				dispose();
			}

		});
		okB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionevent) {
				updateValue();
				dispose();
			}

		});
		cancelB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionevent) {
				font = null;
				dispose();
			}

		});
	}

	public void setSelectedFont(Font font1) {
		font = new StyleFont(font1);
		showValue();
	}

	public Font getSelectedFont() {
		return font;
	}

	public void showValue() {
		ignore = true;
		fontLT.setSelectedIndex(0);
		for (int i = 0; i < fontLT.getModel().getSize(); i++) {
			if (!font.getName().equals(fontLT.getModel().getElementAt(i)))
				continue;
			fontLT.setSelectedIndex(i);
			break;
		}

		fontTF.setText((String) fontLT.getSelectedValue());
		styleLT.setSelectedIndex(font.getStyle() & 3);
		styleTF.setText((String) styleLT.getSelectedValue());
		sizeLT.setSelectedIndex(0);
		int j;
		for (j = 0; j < sizes.length; j++) {
			if (sizes[j] != font.getSize())
				continue;
			sizeLT.setSelectedIndex(j);
			break;
		}

		if (j == sizes.length)
			sizeLT.clearSelection();
		sizeTF.setText("" + font.getSize());
		if ((font.getStyle() & 0x10) != 0)
			underlineCH.setSelectedLineStyle(font.getUnderlineStyle());
		if ((font.getStyle() & 0x20) != 0)
			strikethroughCH.setSelectedLineStyle(font.getStrikelineStyle());
		if ((font.getStyle() & 0x200) != 0)
			smallcapCK.setSelected(true);
		if ((font.getStyle() & 0x400) != 0)
			allcapCK.setSelected(true);
		if ((font.getStyle() & 0x80) != 0)
			subscriptCK.setSelected(true);
		if ((font.getStyle() & 0x40) != 0)
			superscriptCK.setSelected(true);
		if ((font.getStyle() & 0x100) != 0)
			shadowCK.setSelected(true);
		preview.setDisplayFont(font);
		ignore = false;
	}

	/**
	 *
	 *
	 */
	public void updateValue() {
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		String s = (String) fontLT.getSelectedValue();
		i |= styleLT.getSelectedIndex();
		j = sizeTF.intValue();
		if (underlineCH.getSelectedLineStyle() != 0) {
			i |= 0x10;
			k = underlineCH.getSelectedLineStyle();
		}
		if (strikethroughCH.getSelectedLineStyle() != 0) {
			i |= 0x20;
			l = strikethroughCH.getSelectedLineStyle();
		}
		if (smallcapCK.isSelected())
			i |= 0x200;
		if (allcapCK.isSelected())
			i |= 0x400;
		if (subscriptCK.isSelected())
			i |= 0x80;
		if (superscriptCK.isSelected())
			i |= 0x40;
		if (shadowCK.isSelected())
			i |= 0x100;
		font = new StyleFont(s, i, j, k, l);
	}

	/**
	 *
	 *
	 */
	public void refresh() {
		updateValue();
		preview.setDisplayFont(font);
	}

	/**
	 *
	 * @param component
	 * @param s
	 * @param font1
	 * @return
	 */
	public static Font showDialog(Component component, String s, Font font1) {
		InternalFontChooser fontchooser = new InternalFontChooser(Common2D.findFrame(component), s);
		fontchooser.setSelectedFont(font1);
		Tool.show(fontchooser);
		return fontchooser.getSelectedFont();
	}

	/**
	 *
	 */
	class Listener implements ListSelectionListener, ItemListener, ActionListener, Serializable {

		public void actionPerformed(ActionEvent actionevent) {
			valueChanged(null);
		}

		public void itemStateChanged(ItemEvent itemevent) {
			valueChanged(null);
		}

		public void valueChanged(ListSelectionEvent listselectionevent) {
			if (!ignore) {
				if (listselectionevent != null) {
					fontTF.setText((String) fontLT.getSelectedValue());
					styleTF.setText((String) styleLT.getSelectedValue());
					sizeTF.setText((String) sizeLT.getSelectedValue());
				}
				refresh();
			}
		}

		Listener() {
		}
	}

}