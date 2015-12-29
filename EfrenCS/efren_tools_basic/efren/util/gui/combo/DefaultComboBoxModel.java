package efren.util.gui.combo;


import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import java.io.Serializable;
import java.util.Vector;

class DefaultComboBoxModel extends AbstractListModel
	implements ComboBoxModel, Serializable {

	Vector objects;
	Object selectedObject;

    public DefaultComboBoxModel() {
        objects = new Vector();
    }
    public DefaultComboBoxModel(Object aobj[]) {
        objects = new Vector();
        int i = 0;
        for(int j = aobj.length; i < j; i++)
            objects.addElement(aobj[i]);

    }
    public DefaultComboBoxModel(Vector vector) {
        objects = new Vector();
        int i = 0;
        for(int j = vector.size(); i < j; i++)
            objects.addElement(vector.elementAt(i));

    }
    void addObject(Object obj) {
        objects.addElement(obj);
        fireIntervalAdded(this, objects.size() - 1, objects.size() - 1);
    }
    public Object getElementAt(int i) {
        if(i >= 0 && i < objects.size())
            return objects.elementAt(i);
        else
            return null;
    }
    public int getIndexOf(Object obj) {
        return objects.indexOf(obj);
    }
    public Object getSelectedItem() {
        return selectedObject;
    }
    public int getSize() {
        return objects.size();
    }
    void insertObjectAt(Object obj, int i) {
        objects.insertElementAt(obj, i);
        fireIntervalAdded(this, i, i);
    }
    void removeAllObjects() {
        int i = 0;
        int j = objects.size() - 1;
        objects.removeAllElements();
        fireIntervalRemoved(this, i, j);
    }
    void removeObject(Object obj) {
        int i = objects.indexOf(obj);
        if(i != -1)
            removeObjectAt(i);
    }
    void removeObjectAt(int i) {
        objects.removeElementAt(i);
        fireIntervalRemoved(this, i, i);
    }
    public void setSelectedItem(Object obj) {
        selectedObject = obj;
        fireContentsChanged(this, -1, -1);
    }
}
