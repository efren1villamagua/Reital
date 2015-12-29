package efren.util.gui.table;

import java.awt.Component;
import java.awt.Insets;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SortButtonRenderer extends JButton implements TableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3527604586151406494L;

	public static final int NONE = 0;

    public static final int DOWN = 1;

    public static final int UP = 2;

    int pushedColumn;

    Hashtable<String, Integer> state;

    JButton downButton, upButton;

    //private int columnCount = 0;

    //private int tempColumnCount = 0;

    public SortButtonRenderer() {
        pushedColumn = -1;
        state = new Hashtable<String, Integer>();

        setMargin(new Insets(0, 0, 0, 0));
        setHorizontalTextPosition(LEFT);
        setIcon(new BlankIcon());
        setFont(efren.util.FontManager.currentSystemBoldFont());
        setForeground(new java.awt.Color(128, 64, 0));

        // perplexed
        // ArrowIcon(SwingConstants.SOUTH, true)
        // BevelArrowIcon (int direction, boolean isRaisedView, boolean
        // isPressedView)

        downButton = new JButton();
        downButton.setMargin(new Insets(0, 0, 0, 0));
        downButton.setHorizontalTextPosition(LEFT);
        downButton.setIcon(new BevelArrowIcon(BevelArrowIcon.UP, false, false));
        downButton.setPressedIcon(new BevelArrowIcon(BevelArrowIcon.UP, false, true));
        downButton.setFont(efren.util.FontManager.currentSystemBoldFont());
        downButton.setForeground(new java.awt.Color(128, 64, 0));

        upButton = new JButton();
        upButton.setMargin(new Insets(0, 0, 0, 0));
        upButton.setHorizontalTextPosition(LEFT);
        upButton.setIcon(new BevelArrowIcon(BevelArrowIcon.DOWN, false, false));
        upButton.setPressedIcon(new BevelArrowIcon(BevelArrowIcon.DOWN, false, true));
        upButton.setFont(efren.util.FontManager.currentSystemBoldFont());
        upButton.setForeground(new java.awt.Color(128, 64, 0));
    }

    public int getState(int col) {
        int retValue;
        Object obj = state.get(String.valueOf(col));
        if (obj == null) {
            retValue = NONE;
        } else {
            if (((Integer) obj).intValue() == UP) {
                retValue = UP;
            } else {
                retValue = DOWN;
            }
        }
        return retValue;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        //this.columnCount = table.getModel().getColumnCount();

        JButton button = this;
        Object obj = state.get(String.valueOf(column));
        if (obj != null) {
            if (((Integer) obj).intValue() == UP) {
                button = downButton;
            } else {
            	if (((Integer) obj).intValue() == DOWN) {
            		button = upButton;
            	} else {
            		button = this;
            	}
            }
        }
        button.setText((value == null) ? "" : value.toString());
        boolean isPressed = (column == pushedColumn);
        button.getModel().setPressed(isPressed);
        button.getModel().setArmed(isPressed);
        return button;
    }

    public void setPressedColumn(int col) {
        pushedColumn = col;
    }

    public void setSelectedColumn(int col, int columnSize) {
        if (col < 0)
            return;
        Integer value = null;
        Object obj = state.get(String.valueOf(col));
        if (obj == null) {
            value = new Integer(UP);
        } else {
            if (((Integer) obj).intValue() == UP) {
                value = new Integer(DOWN);
            } else {
                value = new Integer(UP);
            }
        }
        state.clear();
        state.put(String.valueOf(col), value);

        for (int i = 0; i < columnSize; i++) {
			if (i != col) {
				state.put(String.valueOf(i), new Integer(NONE));
			}
		}
    }

}