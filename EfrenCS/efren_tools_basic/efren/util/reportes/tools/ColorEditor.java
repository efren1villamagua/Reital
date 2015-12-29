package efren.util.reportes.tools;

public class ColorEditor extends javax.swing.DefaultCellEditor {
    public java.awt.Color currentColor = null;
public ColorEditor(javax.swing.JButton b) {
    super(new javax.swing.JCheckBox()); //Unfortunately, the constructor
    //expects a check box, combo box,
    //or text field.
    editorComponent = b;
    setClickCountToStart(1); //This is usually 1 or 2.

    //Must do this so that editing stops when appropriate.
    b.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            fireEditingStopped();
        }
    });
}
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
    public Object getCellEditorValue() {
        return currentColor;
    }
public java.awt.Component getTableCellEditorComponent(
    javax.swing.JTable table,
    Object value,
    boolean isSelected,
    int row,
    int column) {
    ((javax.swing.JButton) editorComponent).setText(value.toString());
    currentColor = (java.awt.Color) value;
    return editorComponent;
}
}
