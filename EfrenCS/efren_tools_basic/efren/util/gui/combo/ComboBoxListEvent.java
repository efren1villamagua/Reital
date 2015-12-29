package efren.util.gui.combo;

import java.util.EventObject;

public class ComboBoxListEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6476462632353587446L;

	public static enum EventType {
		ALL_ITEMS, 
		ADD_ITEM,
		REMOVE_ITEM,
		SELECT_ITEM,
		DESELECT_ITEM,
		VALUE_CHANGE
	}

	
	private int type;
	private int index;

    public ComboBoxListEvent(Object obj, int i, int j) {
        super(obj);
        type = i;
        index = j;
    }
    public int getIndex() {
        return index;
    }
    public int getType() {
        return type;
    }
}
