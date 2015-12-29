package efren.util.gui.table;

import java.awt.*;
import javax.swing.*;

public class BlankIcon implements Icon {
    private Color fillColor;
    private int size;

public BlankIcon() {
    this(null, 11);
}
public BlankIcon(Color color, int size) {
    //UIManager.getColor("control")
    //UIManager.getColor("controlShadow")
    fillColor = color;

    this.size = size;
}
public int getIconHeight() {
    return size;
}
public int getIconWidth() {
    return size;
}
public void paintIcon(Component c, Graphics g, int x, int y) {
    if (fillColor != null) {
        g.setColor(fillColor);
        g.drawRect(x, y, size - 1, size - 1);
    }
}
}
