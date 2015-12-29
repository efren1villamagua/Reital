package efren.util.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;

public class TitledPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5820446341118487842L;

	private JLabel titleLabel;

	private GradientPanel gradientPanel;

	private JPanel headerPanel;

	private boolean selected;

	private char displayedMnemonic = '\0';

	public TitledPanel() {
		this(null, "TitledPanel", null, null);
	}

	public TitledPanel(String title) {
		this(null, title, null, null);
	}

	public TitledPanel(Icon icon, String title) {
		this(icon, title, null, null);
	}

	public TitledPanel(String title, JToolBar bar, JComponent content) {
		this(null, title, bar, content);
	}

	public TitledPanel(Icon icon, String title, JToolBar bar, JComponent content) {
		super(new BorderLayout());
		selected = false;
		titleLabel = new JLabel(title, icon, 10);
		JPanel top = buildHeader(titleLabel, bar);
		add(top, "North");
		if (content != null)
			setContent(content);
		setBorder(new ShadowBorder());
		setSelected(true);
		updateHeader();
	}

	public Icon getFrameIcon() {
		return titleLabel.getIcon();
	}

	public void setFrameIcon(Icon newIcon) {
		Icon oldIcon = getFrameIcon();
		titleLabel.setIcon(newIcon);
		firePropertyChange("frameIcon", oldIcon, newIcon);
	}

	public String getTitle() {
		return titleLabel.getText();
	}

	public void setTitle(String newText) {
		String oldText = getTitle();
		titleLabel.setText(newText);
		firePropertyChange("title", oldText, newText);
	}

	public JToolBar getToolBar() {
		return headerPanel.getComponentCount() <= 1 ? null : (JToolBar) headerPanel.getComponent(1);
	}

	public void setToolBar(JToolBar newToolBar) {
		JToolBar oldToolBar = getToolBar();
		if (oldToolBar == newToolBar)
			return;
		if (oldToolBar != null)
			headerPanel.remove(oldToolBar);
		if (newToolBar != null) {
			newToolBar.setOpaque(false);
			newToolBar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			headerPanel.add(newToolBar, "East");
		}
		updateHeader();
		firePropertyChange("toolBar", oldToolBar, newToolBar);
	}

	public Component getContent() {
		return hasContent() ? getComponent(1) : null;
	}

	public void setContent(Component newContent) {
		Component oldContent = getContent();
		if (hasContent())
			remove(oldContent);
		add(newContent, "Center");
		firePropertyChange("content", oldContent, newContent);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean newValue) {
		boolean oldValue = isSelected();
		selected = newValue;
		updateHeader();
		firePropertyChange("selected", oldValue, newValue);
	}

	private JPanel buildHeader(JLabel label, JToolBar bar) {
		gradientPanel = new GradientPanel(new BorderLayout(), getHeaderBackground());
		label.setOpaque(false);
		gradientPanel.add(label, "West");
		gradientPanel.setBorder(BorderFactory.createEmptyBorder(3, 4, 3, 1));
		headerPanel = new JPanel(new BorderLayout());
		headerPanel.add(gradientPanel, "Center");
		setToolBar(bar);
		headerPanel.setBorder(new RaisedHeaderBorder());
		headerPanel.setOpaque(false);
		return headerPanel;
	}

	private void updateHeader() {
		gradientPanel.setBackground(getHeaderBackground());
		gradientPanel.setOpaque(isSelected());
		titleLabel.setForeground(getTextForeground(isSelected()));
		headerPanel.repaint();
	}

	public void updateUI() {
		super.updateUI();
		if (titleLabel != null)
			updateHeader();
	}

	private boolean hasContent() {
		return getComponentCount() > 1;
	}

	protected Color getTextForeground(boolean isSelected) {
		Color c = UIManager.getColor(isSelected ? "SimpleInternalFrame.activeTitleForeground" : "SimpleInternalFrame.inactiveTitleForeground");
		if (c != null)
			return c;
		else
			return UIManager.getColor(isSelected ? "InternalFrame.activeTitleForeground" : "Label.foreground");
	}

	protected Color getHeaderBackground() {
		Color c = UIManager.getColor("SimpleInternalFrame.activeTitleBackground");
		return c == null ? UIManager.getColor("InternalFrame.activeTitleBackground") : c;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public char getDisplayedMnemonic() {
		return displayedMnemonic;
	}

	public void setDisplayedMnemonic(char displayedMnemonic) {
		this.displayedMnemonic = displayedMnemonic;
		getTitleLabel().setDisplayedMnemonic(displayedMnemonic);
	}

	/**
	 * 
	 * @author efren
	 * 
	 */
	private static final class GradientPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (!isOpaque()) {
				return;
			} else {
				Color control = UIManager.getColor("control");
				int width = getWidth();
				int height = getHeight();
				Graphics2D g2 = (Graphics2D) g;
				java.awt.Paint storedPaint = g2.getPaint();
				g2.setPaint(new GradientPaint(0.0F, 0.0F, getBackground(), width, 0.0F, control));
				g2.fillRect(0, 0, width, height);
				g2.setPaint(storedPaint);
				return;
			}
		}

		private GradientPanel(LayoutManager lm, Color background) {
			super(lm);
			setBackground(background);
		}

	}

	/**
	 * 
	 * @author efren
	 * 
	 */
	private static class ShadowBorder extends AbstractBorder {

		public Insets getBorderInsets(Component c) {
			return INSETS;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			Color shadow = UIManager.getColor("controlShadow");
			if (shadow == null)
				shadow = Color.GRAY;
			Color lightShadow = new Color(shadow.getRed(), shadow.getGreen(), shadow.getBlue(), 170);
			Color lighterShadow = new Color(shadow.getRed(), shadow.getGreen(), shadow.getBlue(), 70);
			g.translate(x, y);
			g.setColor(shadow);
			g.fillRect(0, 0, w - 3, 1);
			g.fillRect(0, 0, 1, h - 3);
			g.fillRect(w - 3, 1, 1, h - 3);
			g.fillRect(1, h - 3, w - 3, 1);
			g.setColor(lightShadow);
			g.fillRect(w - 3, 0, 1, 1);
			g.fillRect(0, h - 3, 1, 1);
			g.fillRect(w - 2, 1, 1, h - 3);
			g.fillRect(1, h - 2, w - 3, 1);
			g.setColor(lighterShadow);
			g.fillRect(w - 2, 0, 1, 1);
			g.fillRect(0, h - 2, 1, 1);
			g.fillRect(w - 2, h - 2, 1, 1);
			g.fillRect(w - 1, 1, 1, h - 2);
			g.fillRect(1, h - 1, w - 2, 1);
			g.translate(-x, -y);
		}

		private static final Insets INSETS = new Insets(1, 1, 3, 3);

		private ShadowBorder() {
		}

	}

	/**
	 * 
	 * @author efren
	 * 
	 */
	private static class RaisedHeaderBorder extends AbstractBorder {

		public Insets getBorderInsets(Component c) {
			return INSETS;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			g.translate(x, y);
			g.setColor(UIManager.getColor("controlLtHighlight"));
			g.fillRect(0, 0, w, 1);
			g.fillRect(0, 1, 1, h - 1);
			g.setColor(UIManager.getColor("controlShadow"));
			g.fillRect(0, h - 1, w, 1);
			g.translate(-x, -y);
		}

		private static final Insets INSETS = new Insets(1, 1, 1, 0);

		private RaisedHeaderBorder() {
		}

	}
	/**
	 * 
	 */
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		getTitleLabel().setEnabled(enabled);
		gradientPanel.setEnabled(enabled);
		headerPanel.setEnabled(enabled);
	}
}
