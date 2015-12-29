package efren.util.gui;

public class RaisedPanel extends javax.swing.JPanel {
/**
 * TitledPanel constructor comment.
 */
public RaisedPanel() {
	super();
	this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public RaisedPanel(java.awt.LayoutManager layout) {
    super(layout);
    this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public RaisedPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
    this.createBorder();
}
/**
 * TitledPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public RaisedPanel(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
    this.createBorder();
}
private void createBorder() {
    this.setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    this.setOpaque(false);
}
}
