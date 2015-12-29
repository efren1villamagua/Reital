package efren.util.gui.combo;


import java.util.EventListener;


public interface ComboBoxListListener
	extends EventListener {

    public abstract void itemAdded(ComboBoxListEvent comboboxlistevent);
    public abstract void itemDeselected(ComboBoxListEvent comboboxlistevent);
    public abstract void itemRemoved(ComboBoxListEvent comboboxlistevent);
    public abstract void itemSelected(ComboBoxListEvent comboboxlistevent);
    public abstract void itemValueChanged(ComboBoxListEvent comboboxlistevent);
}
