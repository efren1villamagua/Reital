package efren.seguridades.util.tree;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.Graphics;

import java.awt.event.MouseEvent;

import java.util.EventObject;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import efren.util.DefaultCellEditor;

public class PerfilOpcionTreeTable extends JTable {
    
    public long perfilOid;

    public PerfilOpcionTreeModel2 perfilOpcionModel = null;

    /** A subclass of JTree. */
    protected TreeTableCellRenderer cellRenderer;

    public PerfilOpcionTreeTable() {
        this(new PerfilOpcionTreeModel2());
    }
    public PerfilOpcionTreeTable(long unPerfilOid) {
        this(new PerfilOpcionTreeModel2(unPerfilOid));
    }

    public PerfilOpcionTreeTable(TreeTableModel treeTableModel) {
        super();

        if (treeTableModel instanceof PerfilOpcionTreeModel2)
            this.perfilOpcionModel = (PerfilOpcionTreeModel2) treeTableModel;

        // Create the tree. It will be used as a renderer and editor.
        cellRenderer = new TreeTableCellRenderer(treeTableModel);

        // Install the tree editor renderer and editor.
        setDefaultRenderer(TreeTableModel.class, cellRenderer);
        setDefaultEditor(TreeTableModel.class, new TreeTableCellEditor());
        JCheckBox jc2 = new JCheckBox();
        jc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setDefaultEditor(Boolean.class, new DefaultCellEditor(jc2));

        PerfilOpcionTreeCellRenderer opcionRenderer = new PerfilOpcionTreeCellRenderer();
        cellRenderer.setCellRenderer(opcionRenderer);

        // Install a tableModel representing the visible rows in the tree.
        super.setModel(new TreeTableModelAdapter(treeTableModel, cellRenderer));

        // Force the JTable and JTree to share their row selection models.
        ListToTreeSelectionModelWrapper selectionWrapper = new ListToTreeSelectionModelWrapper();
        cellRenderer.setSelectionModel(selectionWrapper);
        setSelectionModel(selectionWrapper.getListSelectionModel());

        // No grid.
        //setShowGrid(false);

        // No intercell spacing
        setIntercellSpacing(new Dimension(1, 1));
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //SE COLOCA EL ANCHO DE LAS COLUMNAS
        this.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.getColumnModel().getColumn(9).setPreferredWidth(100);

        // And update the height of the trees row to match that of
        // the table.
        if (cellRenderer.getRowHeight() < 1) {
            // Metal looks better like this.
            setRowHeight(18);
        }
    }

    /**
     * Overridden to message super and forward the method to the tree. Since the
     * tree is not actually in the component hieachy it will never receive this
     * unless we forward it in this manner.
     */
    public void updateUI() {
        super.updateUI();
        if (cellRenderer != null) {
            cellRenderer.updateUI();
        }
        // Use the tree's default foreground and background colors in the
        // table.
        LookAndFeel.installColorsAndFont(this, "Tree.background", "Tree.foreground", "Tree.font");
    }

    /*
     * Workaround for BasicTableUI anomaly. Make sure the UI never tries to
     * paint the editor. The UI currently uses different techniques to paint the
     * renderers and editors and overriding setBounds() below is not the right
     * thing to do for an editor. Returning -1 for the editing row in this case,
     * ensures the editor is never painted.
     */
    public int getEditingRow() {
        return (getColumnClass(editingColumn) == TreeTableModel.class) ? -1 : editingRow;
    }

    /**
     * Overridden to pass the new rowHeight to the tree.
     */
    public void setRowHeight(int rowHeight) {
        super.setRowHeight(rowHeight);
        if (cellRenderer != null && cellRenderer.getRowHeight() != rowHeight) {
            cellRenderer.setRowHeight(getRowHeight());
        }
    }

    /**
     * Returns the tree that is being shared between the model.
     */
    public JTree getTree() {
        return cellRenderer;
    }

    /**
     * A TreeCellRenderer that displays a JTree.
     */
    public class TreeTableCellRenderer extends JTree implements TableCellRenderer {
        /** Last table/tree row asked to renderer. */
        protected int visibleRow;

        public TreeTableCellRenderer(TreeModel model) {
            super(model);
        }

        /**
         * updateUI is overridden to set the colors of the Tree's renderer to
         * match that of the table.
         */
        public void updateUI() {
            super.updateUI();
            // Make the tree's cell renderer use the table's cell selection
            // colors.
            TreeCellRenderer tcr = getCellRenderer();
            if (tcr instanceof DefaultTreeCellRenderer) {
                DefaultTreeCellRenderer dtcr = ((DefaultTreeCellRenderer) tcr);
                // For 1.1 uncomment this, 1.2 has a bug that will cause an
                // exception to be thrown if the border selection color is
                // null.
                // dtcr.setBorderSelectionColor(null);
//              CAMBIO_EFREN 2006-08-31 dtcr.setTextSelectionColor(UIManager.getColor("Table.selectionForeground"));
//              CAMBIO_EFREN 2006-08-31 dtcr.setBackgroundSelectionColor(UIManager.getColor("Table.selectionBackground"));
            }
        }

        /**
         * Sets the row height of the tree, and forwards the row height to the
         * table.
         */
        public void setRowHeight(int rowHeight) {
            if (rowHeight > 0) {
                super.setRowHeight(rowHeight);
                if (PerfilOpcionTreeTable.this != null && PerfilOpcionTreeTable.this.getRowHeight() != rowHeight) {
                    PerfilOpcionTreeTable.this.setRowHeight(getRowHeight());
                }
            }
        }

        /**
         * This is overridden to set the height to match that of the JTable.
         */
        public void setBounds(int x, int y, int w, int h) {
            super.setBounds(x, 0, w, PerfilOpcionTreeTable.this.getHeight());
        }

        /**
         * Sublcassed to translate the graphics such that the last visible row
         * will be drawn at 0,0.
         */
        public void paint(Graphics g) {
            g.translate(0, -visibleRow * getRowHeight());
            super.paint(g);
        }

        /**
         * TreeCellRenderer method. Overridden to update the visible row.
         */
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected)
                setBackground(table.getSelectionBackground());
            else
                setBackground(table.getBackground());

            visibleRow = row;
            return this;
        }
    }

    /**
     * TreeTableCellEditor implementation. Component returned is the JTree.
     */
    public class TreeTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int r, int c) {
            return cellRenderer;
        }

        /**
         * Overridden to return false, and if the event is a mouse event it is
         * forwarded to the tree.
         * <p>
         * The behavior for this is debatable, and should really be offered as a
         * property. By returning false, all keyboard actions are implemented in
         * terms of the table. By returning true, the tree would get a chance to
         * do something with the keyboard events. For the most part this is ok.
         * But for certain keys, such as left/right, the tree will
         * expand/collapse where as the table focus should really move to a
         * different column. Page up/down should also be implemented in terms of
         * the table. By returning false this also has the added benefit that
         * clicking outside of the bounds of the tree node, but still in the
         * tree column will select the row, whereas if this returned true that
         * wouldn't be the case.
         * <p>
         * By returning false we are also enforcing the policy that the tree
         * will never be editable (at least by a key sequence).
         */
        public boolean isCellEditable(EventObject e) {
            if (e instanceof MouseEvent) {
                MouseEvent me;
                MouseEvent newME;
                for (int counter = getColumnCount() - 1; counter >= 0; counter--) {
                    if (getColumnClass(counter) == TreeTableModel.class) {
                        me = (MouseEvent) e;
                        newME = new MouseEvent(cellRenderer, me.getID(), me.getWhen(), me.getModifiers(), me.getX() - getCellRect(0, counter, true).x, me.getY(), me.getClickCount(), me.isPopupTrigger());
                        cellRenderer.dispatchEvent(newME);
                        break;
                    }
                }
            }
            return false;
        }

    }
    public class TreeTableStringCellEditor extends AbstractCellEditor implements TableCellEditor {
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int r, int c) {
            return new JTextField();
        }
        public boolean isCellEditable(EventObject e) {
            return true;
        }

    }

    /**
     * ListToTreeSelectionModelWrapper extends DefaultTreeSelectionModel to
     * listen for changes in the ListSelectionModel it maintains. Once a change
     * in the ListSelectionModel happens, the paths are updated in the
     * DefaultTreeSelectionModel.
     */
    class ListToTreeSelectionModelWrapper extends DefaultTreeSelectionModel {
        /** Set to true when we are updating the ListSelectionModel. */
        protected boolean updatingListSelectionModel;

        public ListToTreeSelectionModelWrapper() {
            super();
            getListSelectionModel().addListSelectionListener(createListSelectionListener());
        }

        /**
         * Returns the list selection model. ListToTreeSelectionModelWrapper
         * listens for changes to this model and updates the selected paths
         * accordingly.
         */
        ListSelectionModel getListSelectionModel() {
            return listSelectionModel;
        }

        /**
         * This is overridden to set <code>updatingListSelectionModel</code>
         * and message super. This is the only place DefaultTreeSelectionModel
         * alters the ListSelectionModel.
         */
        public void resetRowSelection() {
            if (!updatingListSelectionModel) {
                updatingListSelectionModel = true;
                try {
                    super.resetRowSelection();
                } finally {
                    updatingListSelectionModel = false;
                }
            }
            // Notice how we don't message super if
            // updatingListSelectionModel is true. If
            // updatingListSelectionModel is true, it implies the
            // ListSelectionModel has already been updated and the
            // paths are the only thing that needs to be updated.
        }

        /**
         * Creates and returns an instance of ListSelectionHandler.
         */
        protected ListSelectionListener createListSelectionListener() {
            return new ListSelectionHandler();
        }

        /**
         * If <code>updatingListSelectionModel</code> is false, this will
         * reset the selected paths from the selected rows in the list selection
         * model.
         */
        protected void updateSelectedPathsFromSelectedRows() {
            if (!updatingListSelectionModel) {
                updatingListSelectionModel = true;
                try {
                    // This is way expensive, ListSelectionModel needs an
                    // enumerator for iterating.
                    int min = listSelectionModel.getMinSelectionIndex();
                    int max = listSelectionModel.getMaxSelectionIndex();

                    clearSelection();
                    if (min != -1 && max != -1) {
                        for (int counter = min; counter <= max; counter++) {
                            if (listSelectionModel.isSelectedIndex(counter)) {
                                TreePath selPath = cellRenderer.getPathForRow(counter);

                                if (selPath != null) {
                                    addSelectionPath(selPath);
                                }
                            }
                        }
                    }
                } finally {
                    updatingListSelectionModel = false;
                }
            }
        }

        /**
         * Class responsible for calling updateSelectedPathsFromSelectedRows
         * when the selection of the list changse.
         */
        class ListSelectionHandler implements ListSelectionListener {
            public void valueChanged(ListSelectionEvent e) {
                updateSelectedPathsFromSelectedRows();
            }
        }
    }
}