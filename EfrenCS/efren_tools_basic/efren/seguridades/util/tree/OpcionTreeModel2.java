package efren.seguridades.util.tree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.tree.TreePath;

import efren.seguridades.abm.gui.OpcionABMView;
import efren.util.Conn;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecOpcion;

public class OpcionTreeModel2 extends OpcionAbstractTreeTableModel {

    public static int SISTEMA_SEGURIDADES_META_OID = -10;

    //public OpcionTreeTable unaTreeTable =null;
    public TreePath aPath = null;

    // Names of the columns.
    static protected String[] columnNames = {"Opción", "Posición", "Clase o JSP", "IconName"};

    // Types of the columns.
    static protected Class[] columnTypes = {TreeTableModel.class, String.class, String.class, String.class};

    /**
     * True if the receiver is valid, once set to false all Threads loading
     * files will stop.
     */
    protected boolean isValid;

    /**
     * Node currently being reloaded, this becomes somewhat muddy if reloading
     * is happening in multiple threads.
     */
    protected OpcionNode reloadNode;

    /** > 0 indicates reloading some nodes. */
    int reloadCount;

    /** Returns true if links are to be descended. */
    protected boolean descendLinks;

    private static SecOpcion getOpcionRoot() {
	    long tempOid = SISTEMA_SEGURIDADES_META_OID;
	    String tempNombre = "Sistemas Disponibles en Seguridades";
        SecOpcion opcionRoot = new SecOpcion();
        opcionRoot.setOid(tempOid);
        opcionRoot.setSistemaOid(tempOid);
        //opcionRoot.setClaseOid(-1);
        opcionRoot.setOpcionPadreOid(tempOid);
        opcionRoot.setNombre(tempNombre);
        opcionRoot.setNombre2(tempNombre);
        opcionRoot.setPosicion(0);
        //opcionRoot.setTimestamp(new Timestamp());
        opcionRoot.setNombreClase("");
        opcionRoot.setPosicionAbsoluta("");
        opcionRoot.setIconName("");
        opcionRoot.setEsMenu(true);

        return opcionRoot;
    }


    /**
     * Crea un SecOpcionTreeModel usando el root del SecOpcion. This does not load it, you should invoke
     * <code>reloadChildren</code> with the root to start loading.
     */
    public OpcionTreeModel2() {
        this(getOpcionRoot());
    }

    public OpcionTreeModel2(SecOpcion unaOpcion) {
        super(null);
        this.isValid = true;
        this.root = new OpcionNode(unaOpcion);
    }

    //
    // The TreeModel interface
    //
    /**
     * Returns the number of children of <code>node</code>.
     */
    public int getChildCount(Object node) {
        Object[] children = getChildren(node);
        return (children == null) ? 0 : children.length;
    }

    /**
     * Returns the child of <code>node</code> at index <code>i</code>.
     */
    public Object getChild(Object node, int i) {
        return getChildren(node)[i];
    }

    /**
     * Returns true if the passed in object represents a leaf, false otherwise.
     */
    public boolean isLeaf(Object node) {
        return ((OpcionNode) node).isLeaf();
    }

    //
    //  The TreeTableNode interface.
    //

    /**
     * Returns the number of columns.
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the name for a particular column.
     */
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Returns the class for the particular column.
     */
    public Class getColumnClass(int column) {
        return columnTypes[column];
    }

    /**
     * Returns the value of the particular column.
     */
    public Object getValueAt(Object node, int column) {
		SecOpcion unaOpcion = getOpcion(node);
		if (unaOpcion == null)
		    return null;
		switch (column) {
		case 0:
			return unaOpcion.getNombre();
		case 1:
			return unaOpcion.getPosicionAbsoluta();
		case 2:
			return unaOpcion.getNombreClase();
		case 3:
			return unaOpcion.getIconName();
		}

		return null;
	}
  public void setValueAt(Object aValue, Object node, int column) {
      try {
          if (node instanceof OpcionNode) {
              SecOpcion opcion = ((OpcionNode) node).getOpcion();
    	      if (column == 1)
    	          opcion.setPosicionAbsoluta(aValue.toString().trim());
    	      if (column == 2)
    	          opcion.setNombre(aValue.toString().trim());
    	      if (column == 3)
    	          opcion.setIconName(aValue.toString().trim());
          }
	} catch (Exception e) {
	    e.getMessage();
	}
  }


    //
    // Some convenience methods.
    //

    /**
     * Reloads the children of the specified node.
     */
    public void reloadChildren(Object node) {
        OpcionNode fn = (OpcionNode) node;

        synchronized (this) {
            reloadCount++;
        }
        new Thread(new OpcionNodeLoader((OpcionNode) node)).start();
    }

    /**
     * Stops and waits for all threads to finish loading.
     */
    public void stopLoading() {
        isValid = false;
        synchronized (this) {
            while (reloadCount > 0) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                }
            }
        }
        isValid = true;
    }

    /**
     * If <code>newValue</code> is true, links are descended. Odd results may
     * happen if you set this while other threads are loading.
     */
    public void setDescendsLinks(boolean newValue) {
        descendLinks = newValue;
    }

    /**
     * Returns true if links are to be automatically descended.
     */
    public boolean getDescendsLinks() {
        return descendLinks;
    }

    /**
     * Returns true if the receiver is loading any children.
     */
    public boolean isReloading() {
        return (reloadCount > 0);
    }

    /**
     * Returns the path to the node that is being loaded.
     */
    public TreePath getPathLoading() {
        OpcionNode rn = reloadNode;

        if (rn != null) {
            return new TreePath(rn.getPath());
        }
        return null;
    }

    /**
     * Returns the node being loaded.
     */
    public Object getNodeLoading() {
        return reloadNode;
    }

    protected SecOpcion getOpcion(Object node) {
        OpcionNode opcionNode = ((OpcionNode) node);
        if (opcionNode != null)
            return opcionNode.getOpcion();
        else
            return null;
    }

    protected Object[] getChildren(Object node) {
        OpcionNode opcionNode = ((OpcionNode) node);
        return opcionNode.getChildren();
    }

    protected static OpcionNode[] EMPTY_CHILDREN = new OpcionNode[0];

    /**
     * A OpcionNode is a derivative of the File class - though we delegate to the
     * File object rather than subclassing it. It is used to maintain a cache of
     * a directory's children and therefore avoid repeated access to the
     * underlying file system during rendering.
     */
    public class OpcionNode {
        /** java.io.File the receiver represents. */
        protected SecOpcion opcion;

        /** Parent OpcionNode of the receiver. */
        private OpcionNode parent;

        /** Children of the receiver. */
        protected OpcionNode[] children;

        /** Size of the receiver and all its children. */
        protected long totalSize;

        /** Valid if the totalSize has finished being calced. */
        protected boolean totalSizeValid;

        /** Path of the receiver. */
        //protected String canonicalPath;

        /**
         * True if the canonicalPath of this instance does not start with the
         * canonical path of the parent.
         */
        protected boolean isLink;

        protected OpcionNode(SecOpcion unaOpcion) {
            this(null, unaOpcion);
        }

        protected OpcionNode(OpcionNode parent, SecOpcion unaOpcion) {
            this.parent = parent;
            this.opcion = unaOpcion;
            if (parent != null) {
                //this.isLink = !canonicalPath.startsWith(parent.getCanonicalPath());
                this.isLink = true;
            } else {
                this.isLink = false;
            }
        }

        /**
         * Returns the the string to be used to display this leaf in the JTree.
         */
        public String toString() {
            return opcion.getNombre();
        }

        public SecOpcion getOpcion() {
            return opcion;
        }

        /**
         * Returns the parent of the receiver.
         */
        public OpcionNode getParent() {
            return parent;
        }

        /**
         * Returns true if the receiver represents a leaf, that is it is isn't a
         * directory.
         */
        public boolean isLeaf() {
            if (opcion.getOid() == SISTEMA_SEGURIDADES_META_OID)
                return false;
            int childCount = 0;
    		try {
    			long oid = opcion.getOid();
    			String sql = "SELECT COUNT(OID) FROM "+SystemProperties.SCHEMA_SEGURIDADES+".OPCION WHERE OPCIONPADREOID="+oid;
    			Connection con = Conn.conectar();
    			Statement st = con.createStatement();
    	        java.sql.ResultSet rs = st.executeQuery(sql);
    	        while (rs.next()) {
    	        	childCount = rs.getInt(1);
    	        }
    	        rs.close();
    	        st.close();
    		} catch (Throwable t) {
    			t.getMessage();
    		}
    		return childCount <= 0;
    	}

        /**
         * Loads the children, caching the results in the children instance
         * variable.
         */
        protected OpcionNode[] getChildren() {
    		return this.createChildren();
    	}

        /**
         * Recursively loads all the children of the receiver.
         */
        protected void loadChildren() {
            children = createChildren();
            for (int counter = children.length - 1; counter >= 0; counter--) {
                Thread.yield(); // Give the GUI CPU time to draw itself.
                if (!children[counter].isLeaf() && (descendLinks || !children[counter].isLink())) {
                    children[counter].loadChildren();
                }
                if (!isValid) {
                    counter = 0;
                }
            }
        }

        /**
         * Cea hijos del nodo actual
         */
        protected OpcionNode[] createChildren() {
            if (this.children == null || this.children.length == 0)
                return this.createChildren(this.opcion);
            return this.children;
        }

        protected OpcionNode[] reloadChildren() {
            return this.createChildren(this.opcion);

            //aTreeTable.getTree().expandPath(aPath);
        }

        /**
         * Loads the children of of the receiver.
         */
        protected OpcionNode[] createChildren(SecOpcion unaOpcion) {

            OpcionNode[] hijos = null;
			try {
			    if (unaOpcion.getOid() == SISTEMA_SEGURIDADES_META_OID) {
					String sql = "SELECT "
						+" si.OID, RTRIM(LTRIM(si.NOMBREPRINCIPAL)) AS NOMBREPRINCIPAL "
						+" FROM "+SystemProperties.SCHEMA_SEGURIDADES+".SISTEMA si "
						+" ORDER BY NOMBREPRINCIPAL";
					java.util.Vector opcionesHijas = new java.util.Vector();
					efren.util.entidades.SecOpcion mb;
					Connection con = Conn.conectar();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					long sistemaOid;
					String nombreSistema;
					int sistemaPos = 1;
					while (rs.next()) {
						mb = new efren.util.entidades.SecOpcion();
						sistemaOid = rs.getLong(1);
						nombreSistema = rs.getString(2);
						mb.setOid(sistemaOid);
						mb.setSistemaOid(sistemaOid);
						    mb.setClaseOid(-1);
						    mb.setEsMenu(true);
						mb.setOpcionPadreOid(sistemaOid);
						mb.setNombre(nombreSistema);
						mb.setNombre2(" " + nombreSistema);
						mb.setPosicion(sistemaPos);
						//mb.setTimestamp(rs.getTimestamp(7));
						mb.setNombreClase(null);
							mb.setEsSeparador(false);
						mb.setPosicionAbsoluta(OpcionABMView.convertTo4Chars(mb.getPosicion()));
						mb.setIconName("");
						opcionesHijas.addElement(mb);
						sistemaPos++;
					}
					rs.close();
					st.close();

			        hijos = new OpcionNode[opcionesHijas.size()];
			        OpcionNode otn;
			        for (int i = 0; i < opcionesHijas.size(); i++) {
			        	otn = new OpcionNode((SecOpcion) opcionesHijas.elementAt(i));
			        	//otn.
			        	hijos[i] = otn;
					}
			    } else {
					long oid = unaOpcion.getOid();
					String sql = "SELECT "
						+ " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE, o.POSICION, o.TIMESTAMP "
						+ " , CASE WHEN (c.NOMBRE IS NULL) THEN ' ' ELSE RTRIM(LTRIM(c.PAQUETE)) CONCAT '.' CONCAT RTRIM(LTRIM(c.NOMBRE)) END AS NOMBRECLASE "
						+ " , RTRIM(LTRIM(o.ICONNAME)) AS ICONNAME "
						+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
						+ " LEFT OUTER JOIN " + SystemProperties.SCHEMA_SEGURIDADES+"." + "CLASE c "
						+ " ON o.CLASEOID = c.OID "
						+ " WHERE o.OPCIONPADREOID="+oid
						+ " ORDER BY o.POSICION ";
					java.util.Vector opcionesHijas = new java.util.Vector();
					efren.util.entidades.SecOpcion mb;
					Connection con = Conn.conectar();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					Object tempClaseOid = null;
					while (rs.next()) {
						mb = new efren.util.entidades.SecOpcion();
						mb.setOid(rs.getLong(1));
						mb.setSistemaOid(rs.getLong(2));
						tempClaseOid = rs.getObject(3);
						if (tempClaseOid == null || new Long(tempClaseOid.toString().trim()).longValue() <= 0) {
						    mb.setClaseOid(-1);
						    mb.setEsMenu(true);
						} else {
						    mb.setClaseOid(new Long(tempClaseOid.toString().trim()).longValue());
						    mb.setEsMenu(false);
						}
						mb.setOpcionPadreOid(rs.getLong(4));
						mb.setNombre(rs.getString(5).trim());
						mb.setNombre2(" " + rs.getString(5).trim());
						mb.setPosicion(rs.getInt(6));
						mb.setTimestamp(rs.getTimestamp(7));
						mb.setNombreClase(rs.getString(8));
						if (mb.getNombreClase() != null && mb.getNombreClase().toUpperCase().indexOf("&SEPARADOR") >= 0)
						    mb.setEsSeparador(true);
						else
						    mb.setEsSeparador(false);
						mb.setPosicionAbsoluta(unaOpcion.getPosicionAbsoluta()+"-"+OpcionABMView.convertTo4Chars(mb.getPosicion()));
						mb.setIconName(rs.getString("ICONNAME"));
						opcionesHijas.addElement(mb);
					}
					rs.close();
					st.close();

			        hijos = new OpcionNode[opcionesHijas.size()];
			        OpcionNode otn;
			        for (int i = 0; i < opcionesHijas.size(); i++) {
			        	otn = new OpcionNode((SecOpcion) opcionesHijas.elementAt(i));
			        	//otn.
			        	hijos[i] = otn;
					}
			    }
			} catch (Throwable t) {
				t.getMessage();
			}
			this.children = hijos;
			return hijos;
        }

        /**
         * Returns true if the children have been loaded.
         */
        protected boolean loadedChildren() {
            return this.children != null;
        }

        /**
         * Gets the path from the root to the receiver.
         */
        public OpcionNode[] getPath() {
            return getPathToRoot(this, 0);
        }

        /**
         * Returns true if the receiver's path does not begin with the parent's
         * canonical path.
         */
        public boolean isLink() {
            return isLink;
        }

        protected OpcionNode[] getPathToRoot(OpcionNode aNode, int depth) {
            OpcionNode[] retNodes;

            if (aNode == null) {
                if (depth == 0)
                    return null;
                else
                    retNodes = new OpcionNode[depth];
            } else {
                depth++;
                retNodes = getPathToRoot(aNode.getParent(), depth);
                retNodes[retNodes.length - depth] = aNode;
            }
            return retNodes;
        }

        /**
         * If generateEvent is true a tree structure changed event is created.
         */
        protected void setChildren(OpcionNode[] newChildren, boolean generateEvent) {
            if (generateEvent) {
                OpcionNode[] path = getPath();

                fireTreeStructureChanged(OpcionTreeModel2.this, path, null, null);

                OpcionNode parent = getParent();
                //this.
            }
        }

        /**
         * Can be invoked when a node has changed, will create the appropriate
         * event.
         */
        protected void nodeChanged() {
            OpcionNode parent = getParent();

            if (parent != null) {
                OpcionNode[] path = parent.getPath();
                int[] index = { getIndexOfChild(parent, this) };
                Object[] children = { this };

                fireTreeNodesChanged(OpcionTreeModel2.this, path, index, children);
            }
        }
    }

    /**
     * OpcionNodeLoader can be used to reload all the children of a particular
     * node. It first resets the children of the OpcionNode it is created with,
     * and in its run method will reload all of that nodes children.
     * OpcionNodeLoader may not be running in the event dispatching thread. As
     * swing is not thread safe it is important that we don't generate events in
     * this thread. SwingUtilities.invokeLater is used so that events are
     * generated in the event dispatching thread.
     */
    class OpcionNodeLoader implements Runnable {
        /** Node creating children for. */
        OpcionNode node;

        OpcionNodeLoader(OpcionNode node) {
            this.node = node;
            node.setChildren(node.createChildren(), true);
        }

        public void run() {
            OpcionNode[] hijos = node.reloadChildren();

            for (int counter = hijos.length - 1; counter >= 0; counter--) {
                if (!hijos[counter].isLeaf()) {
                    reloadNode = hijos[counter];
                    loadChildren(hijos[counter]);
                    reloadNode = null;
                }
                if (!isValid) {
                    counter = 0;
                }
            }
            if (isValid) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
                        node.setChildren(node.getChildren(), true);
                        synchronized (OpcionTreeModel2.this) {
                            reloadCount--;
                            OpcionTreeModel2.this.notifyAll();
                        }
//                    }
//                });
            } else {
                synchronized (OpcionTreeModel2.this) {
                    reloadCount--;
                    OpcionTreeModel2.this.notifyAll();
                }
            }

            try {
                if (aPath != null) {
	                OpcionNode[] path = new OpcionNode[aPath.getPath().length];
	                for (int i = 0; i < path.length; i++) {
	                    path[i] = (OpcionNode) aPath.getPath()[i];
	                }
	                fireTreeStructureChanged(OpcionTreeModel2.this, path, null, null);
                }
            } catch (Exception e) {
                e.getMessage();
            }
            try {
                //unaTreeTable.getTree().expandPath(aPath);
            } catch (Exception e) {
                e.getMessage();
            }
        }

        protected void loadChildren(OpcionNode node) {
            if (!node.isLeaf()) {
                final OpcionNode[] children = node.createChildren();

                for (int counter = children.length - 1; counter >= 0; counter--) {
                    if (!children[counter].isLeaf()) {
                        if (descendLinks || !children[counter].isLink()) {
                            children[counter].loadChildren();
                        }
                    }
                    if (!isValid) {
                        counter = 0;
                    }
                }
                if (isValid) {
                    final OpcionNode fn = node;

                    // Reset the children
//                    SwingUtilities.invokeLater(new Runnable() {
//                        public void run() {
                            fn.setChildren(children, true);
                            fn.nodeChanged();
//                        }
//                    });

                }
            }
        }
    }

}