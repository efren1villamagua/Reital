package efren.util.gui;

public class LoweredPanel extends javax.swing.JPanel {
/**
 * TitledPanel constructor comment.
 */
public LoweredPanel() {
	super();
	this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public LoweredPanel(java.awt.LayoutManager layout) {
    super(layout);
    this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public LoweredPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
    this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public LoweredPanel(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
    this.createBorder();
}
private void createBorder() {
    this.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
}
}
