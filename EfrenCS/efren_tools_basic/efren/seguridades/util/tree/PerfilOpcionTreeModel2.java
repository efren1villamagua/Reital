package efren.seguridades.util.tree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import efren.seguridades.abm.gui.OpcionABMView;
import efren.util.Conn;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecPerfilOpcion;

public class PerfilOpcionTreeModel2 extends PerfilOpcionAbstractTreeTableModel {

    public static int SISTEMA_SEGURIDADES_META_OID = -10;

    public PerfilOpcionTreeTable unaTreeTable =null;
    public TreePath aPath = null;

    public long perfilOid = -1;

    // Names of the columns.
    static protected String[] columnNames = {"Opción", "Clase o JSP", "Todo", "Ing. mas.", "Ing. con.", "Ing.", "Mod.", "Eli.", "Con.", "OPCIONOID", "TIPOOPCION"};

    // Types of the columns.
    static protected Class[] columnTypes = {TreeTableModel.class, String.class, Boolean.class, Boolean.class,
            Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class};

    /**
     * True if the receiver is valid, once set to false all Threads loading
     * files will stop.
     */
    protected boolean isValid;

    /**
     * Node currently being reloaded, this becomes somewhat muddy if reloading
     * is happening in multiple threads.
     */
    protected PerfilOpcionNode reloadNode;

    /** > 0 indicates reloading some nodes. */
    int reloadCount;

    /** Returns true if links are to be descended. */
    protected boolean descendLinks;

    private static SecPerfilOpcion getPerfilOpcionRoot() {
	    long tempOid = SISTEMA_SEGURIDADES_META_OID;
	    String tempNombre = "Sistemas Disponibles en Seguridades";
        SecPerfilOpcion perfilOpcionRoot = new SecPerfilOpcion();
        perfilOpcionRoot.setOid(tempOid);
        perfilOpcionRoot.setOpcionOid(tempOid);
        perfilOpcionRoot.setSistemaOid(tempOid);
        //perfilOpcionRoot.setClaseOid(-1);
        perfilOpcionRoot.setOpcionPadreOid(tempOid);
        perfilOpcionRoot.setNombre(tempNombre);
        perfilOpcionRoot.setNombre2(tempNombre);
        perfilOpcionRoot.setPosicion(0);
        //perfilOpcionRoot.setTimestamp(new Timestamp());
        perfilOpcionRoot.setNombreClase("");
        perfilOpcionRoot.setPosicionAbsoluta("");
        perfilOpcionRoot.setEsMenu(true);
        perfilOpcionRoot.setOP_todo(new Boolean(false));
        perfilOpcionRoot.setOP_ingresoMasivo(new Boolean(false));
        perfilOpcionRoot.setOP_ingresoContinuo(new Boolean(false));
        perfilOpcionRoot.setOP_ingreso(new Boolean(false));
        perfilOpcionRoot.setOP_modificacion(new Boolean(false));
        perfilOpcionRoot.setOP_eliminacion(new Boolean(false));
        perfilOpcionRoot.setOP_consulta(new Boolean(false));
        perfilOpcionRoot.setTipo(1);

        return perfilOpcionRoot;
    }


    /**
     * Crea un SecOpcionTreeModel usando el root del SecOpcion. This does not load it, you should invoke
     * <code>reloadChildren</code> with the root to start loading.
     */
    public PerfilOpcionTreeModel2() {
        this(getPerfilOpcionRoot());
    }
    public PerfilOpcionTreeModel2(long unPerfilOid) {
        this(getPerfilOpcionRoot());
        this.perfilOid = unPerfilOid;
    }

    public PerfilOpcionTreeModel2(SecPerfilOpcion unaPerfilOpcion) {
        super(null);
        this.isValid = true;
        this.root = new PerfilOpcionNode(unaPerfilOpcion);
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
        return ((PerfilOpcionNode) node).isLeaf();
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
		SecPerfilOpcion unaPerfilOpcion = getPerfilOpcion(node);
		switch (column) {
		case 0:
			return unaPerfilOpcion.getNombre();
		case 1:
			return unaPerfilOpcion.getNombreClase();
		case 2:
			return unaPerfilOpcion.getOP_todo();
		case 3:
			return unaPerfilOpcion.getOP_ingresoMasivo();
		case 4:
			return unaPerfilOpcion.getOP_ingresoContinuo();
		case 5:
			return unaPerfilOpcion.getOP_ingreso();
		case 6:
			return unaPerfilOpcion.getOP_modificacion();
		case 7:
			return unaPerfilOpcion.getOP_eliminacion();
		case 8:
			return unaPerfilOpcion.getOP_consulta();
		case 9:
			return String.valueOf(unaPerfilOpcion.getOpcionOid());
		case 10:
			return String.valueOf(unaPerfilOpcion.getTipo());
		}

		return null;
	}
  public void setValueAt(Object aValue, Object node, int column) {
      try {
          if (node instanceof PerfilOpcionNode) {
              SecPerfilOpcion perfilOpcion = ((PerfilOpcionNode) node).getPerfilOpcion();
              if (!perfilOpcion.esMenu()) {
		      		switch (column) {
		    		case 2:
		    		    perfilOpcion.setOP_todo((Boolean) aValue);
		    		    break;
		    		case 3:
		    		    perfilOpcion.setOP_ingresoMasivo((Boolean) aValue);
		    		    break;
		    		case 4:
		    		    perfilOpcion.setOP_ingresoContinuo((Boolean) aValue);
		    		    break;
		    		case 5:
		    		    perfilOpcion.setOP_ingreso((Boolean) aValue);
		    		    break;
		    		case 6:
		    		    perfilOpcion.setOP_modificacion((Boolean) aValue);
		    		    break;
		    		case 7:
		    		    perfilOpcion.setOP_eliminacion((Boolean) aValue);
		    		    break;
		    		case 8:
		    		    perfilOpcion.setOP_consulta((Boolean) aValue);
		    		    break;
		    		}
              }
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
        PerfilOpcionNode fn = (PerfilOpcionNode) node;

        synchronized (this) {
            reloadCount++;
        }
        new Thread(new PerfilOpcionNodeLoader((PerfilOpcionNode) node)).start();
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
        PerfilOpcionNode rn = reloadNode;

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

    protected SecPerfilOpcion getPerfilOpcion(Object node) {
        PerfilOpcionNode perfilOpcionNode = ((PerfilOpcionNode) node);
        return perfilOpcionNode.getPerfilOpcion();
    }

    protected Object[] getChildren(Object node) {
        PerfilOpcionNode perfilOpcionNode = ((PerfilOpcionNode) node);
        return perfilOpcionNode.getChildren();
    }

    protected static PerfilOpcionNode[] EMPTY_CHILDREN = new PerfilOpcionNode[0];

    /**
     * A PerfilOpcionNode is a derivative of the File class - though we delegate to the
     * File object rather than subclassing it. It is used to maintain a cache of
     * a directory's children and therefore avoid repeated access to the
     * underlying file system during rendering.
     */
    public class PerfilOpcionNode {
        /** java.io.File the receiver represents. */
        protected SecPerfilOpcion perfilOpcion;

        /** Parent PerfilOpcionNode of the receiver. */
        private PerfilOpcionNode parent;

        /** Children of the receiver. */
        protected PerfilOpcionNode[] children;

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

        protected PerfilOpcionNode(SecPerfilOpcion unaPerfilOpcion) {
            this(null, unaPerfilOpcion);
        }

        protected PerfilOpcionNode(PerfilOpcionNode parent, SecPerfilOpcion unaPerfilOpcion) {
            this.parent = parent;
            this.perfilOpcion = unaPerfilOpcion;
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
            return perfilOpcion.getNombre();
        }

        public SecPerfilOpcion getPerfilOpcion() {
            return perfilOpcion;
        }

        /**
         * Returns the parent of the receiver.
         */
        public PerfilOpcionNode getParent() {
            return parent;
        }

        /**
         * Returns true if the receiver represents a leaf, that is it is isn't a
         * directory.
         */
        public boolean isLeaf() {
            if (perfilOpcion.getOid() == SISTEMA_SEGURIDADES_META_OID)
                return false;
            int childCount = 0;
    		try {
    			long oid = perfilOpcion.getOid();
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
        protected PerfilOpcionNode[] getChildren() {
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
        protected PerfilOpcionNode[] createChildren() {
            if (this.children == null || this.children.length == 0)
                return this.createChildren(this.perfilOpcion);
            return this.children;
        }

        protected PerfilOpcionNode[] reloadChildren() {
            return this.createChildren(this.perfilOpcion);

            //aTreeTable.getTree().expandPath(aPath);
        }

        /**
         * Loads the children of of the receiver.
         */
        protected PerfilOpcionNode[] createChildren(SecPerfilOpcion unPerfilOpcion) {

            PerfilOpcionNode[] hijos = null;
			try {
			    if (unPerfilOpcion.getOpcionOid() == SISTEMA_SEGURIDADES_META_OID) {
					String sql = "SELECT "
						+" si.OID, RTRIM(LTRIM(si.NOMBREPRINCIPAL)) AS NOMBREPRINCIPAL "
						+" FROM "+SystemProperties.SCHEMA_SEGURIDADES+".SISTEMA si "
						+" ORDER BY NOMBREPRINCIPAL";
					java.util.Vector perfilOpcionesHijas = new java.util.Vector();
					efren.util.entidades.SecPerfilOpcion mb;
					Connection con = Conn.conectar();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					long sistemaOid;
					String nombreSistema;
					int sistemaPos = 1;
					while (rs.next()) {
						mb = new efren.util.entidades.SecPerfilOpcion();
						sistemaOid = rs.getLong(1);
						nombreSistema = rs.getString(2);

						mb.setOid(sistemaOid);
						mb.setSistemaOid(sistemaOid);
						    mb.setClaseOid(-1);
						    mb.setEsMenu(true);
						mb.setOpcionPadreOid(sistemaOid);
						mb.setOpcionOid(sistemaOid);
						mb.setNombre(nombreSistema);
						mb.setNombre2(" " + nombreSistema);
						mb.setPosicion(sistemaPos);
						//mb.setTimestamp(rs.getTimestamp(7));
						mb.setNombreClase(null);
							mb.setEsSeparador(false);
						mb.setPosicionAbsoluta(OpcionABMView.convertTo4Chars(mb.getPosicion()));
						mb.setOP_todo(new Boolean(false));
						mb.setOP_ingresoMasivo(new Boolean(false));
						mb.setOP_ingresoContinuo(new Boolean(false));
						mb.setOP_ingreso(new Boolean(false));
						mb.setOP_modificacion(new Boolean(false));
						mb.setOP_eliminacion(new Boolean(false));
						mb.setOP_consulta(new Boolean(false));
						mb.setTipo(2);

						perfilOpcionesHijas.addElement(mb);
						sistemaPos++;
					}
					rs.close();
					st.close();

			        hijos = new PerfilOpcionNode[perfilOpcionesHijas.size()];
			        PerfilOpcionNode otn;
			        for (int i = 0; i < perfilOpcionesHijas.size(); i++) {
			        	otn = new PerfilOpcionNode((SecPerfilOpcion) perfilOpcionesHijas.elementAt(i));
			        	//otn.
			        	hijos[i] = otn;
					}
			    } else {
					long oid = unPerfilOpcion.getOid();
					String sql = null;
					if (perfilOid >= 0) {
						sql = "SELECT "
							+ " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE, o.POSICION, o.TIMESTAMP "
							+ " , CASE WHEN (c.NOMBRE IS NULL) THEN ' ' ELSE RTRIM(LTRIM(c.PAQUETE)) CONCAT '.' CONCAT RTRIM(LTRIM(c.NOMBRE)) END AS NOMBRECLASE "
							+",CASE WHEN po.TODO IS NULL THEN 1 ELSE po.TODO END "
							+",CASE WHEN po.INGRESOMASIVO IS NULL THEN 1 ELSE po.INGRESOMASIVO END "
							+",CASE WHEN po.INGRESOCONTINUO IS NULL THEN 1 ELSE po.INGRESOCONTINUO END "
							+",CASE WHEN po.INGRESO IS NULL THEN 1 ELSE po.INGRESO END "
							+",CASE WHEN po.MODIFICACION IS NULL THEN 1 ELSE po.MODIFICACION END "
							+",CASE WHEN po.ELIMINACION IS NULL THEN 1 ELSE po.ELIMINACION END "
							+",CASE WHEN po.CONSULTA IS NULL THEN 1 ELSE po.CONSULTA END "
							+ " FROM (" + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
							+ " LEFT OUTER JOIN " + SystemProperties.SCHEMA_SEGURIDADES+"." + "CLASE c "
							+ " ON o.CLASEOID = c.OID) "
							+"  LEFT OUTER JOIN " + SystemProperties.SCHEMA_SEGURIDADES+"." + "PERFILOPCION po ON (po.OPCIONOID=o.OID AND po.PERFILOID="+perfilOid+") "
							+ " WHERE o.OPCIONPADREOID="+oid
							+ " ORDER BY o.POSICION ";
					} else {
						sql = "SELECT "
							+ " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE, o.POSICION, o.TIMESTAMP "
							+ " , CASE WHEN (c.NOMBRE IS NULL) THEN ' ' ELSE RTRIM(LTRIM(c.PAQUETE)) CONCAT '.' CONCAT RTRIM(LTRIM(c.NOMBRE)) END AS NOMBRECLASE "
							+",1, 1, 1, 1, 1, 1, 1 "
							+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES+"." + "OPCION o "
							+ " LEFT OUTER JOIN " + SystemProperties.SCHEMA_SEGURIDADES+"." + "CLASE c "
							+ " ON o.CLASEOID = c.OID "
							+ " WHERE o.OPCIONPADREOID="+oid
							+ " ORDER BY o.POSICION ";
					}
					java.util.Vector perfilOpcionesHijas = new java.util.Vector();
					efren.util.entidades.SecPerfilOpcion mb;
					Connection con = Conn.conectar();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					Object tempClaseOid = null;
					long tempOid;
					while (rs.next()) {
						mb = new efren.util.entidades.SecPerfilOpcion();
						tempOid = rs.getLong(1);
						mb.setOid(tempOid);
						mb.setOpcionOid(tempOid);
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
						mb.setPosicionAbsoluta(unPerfilOpcion.getPosicionAbsoluta()+"-"+OpcionABMView.convertTo4Chars(mb.getPosicion()));
						mb.setOP_todo(new Boolean(rs.getInt(9)==0));
						mb.setOP_ingresoMasivo(new Boolean(rs.getInt(10)==0));
						mb.setOP_ingresoContinuo(new Boolean(rs.getInt(11)==0));
						mb.setOP_ingreso(new Boolean(rs.getInt(12)==0));
						mb.setOP_modificacion(new Boolean(rs.getInt(13)==0));
						mb.setOP_eliminacion(new Boolean(rs.getInt(14)==0));
						mb.setOP_consulta(new Boolean(rs.getInt(15)==0));
						if (mb.esMenu())
						    mb.setTipo(3);
						else
						    mb.setTipo(4);

						perfilOpcionesHijas.addElement(mb);
					}
					rs.close();
					st.close();

			        hijos = new PerfilOpcionNode[perfilOpcionesHijas.size()];
			        PerfilOpcionNode otn;
			        for (int i = 0; i < perfilOpcionesHijas.size(); i++) {
			        	otn = new PerfilOpcionNode((SecPerfilOpcion) perfilOpcionesHijas.elementAt(i));
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
        public PerfilOpcionNode[] getPath() {
            return getPathToRoot(this, 0);
        }

        /**
         * Returns true if the receiver's path does not begin with the parent's
         * canonical path.
         */
        public boolean isLink() {
            return isLink;
        }

        protected PerfilOpcionNode[] getPathToRoot(PerfilOpcionNode aNode, int depth) {
            PerfilOpcionNode[] retNodes;

            if (aNode == null) {
                if (depth == 0)
                    return null;
                else
                    retNodes = new PerfilOpcionNode[depth];
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
        protected void setChildren(PerfilOpcionNode[] newChildren, boolean generateEvent) {
            if (generateEvent) {
                PerfilOpcionNode[] path = getPath();

                fireTreeStructureChanged(PerfilOpcionTreeModel2.this, path, null, null);

                PerfilOpcionNode parent = getParent();
            }
        }

        /**
         * Can be invoked when a node has changed, will create the appropriate
         * event.
         */
        protected void nodeChanged() {
            PerfilOpcionNode parent = getParent();

            if (parent != null) {
                PerfilOpcionNode[] path = parent.getPath();
                int[] index = { getIndexOfChild(parent, this) };
                Object[] children = { this };

                fireTreeNodesChanged(PerfilOpcionTreeModel2.this, path, index, children);
            }
        }
    }

    /**
     * PerfilOpcionNodeLoader can be used to reload all the children of a particular
     * node. It first resets the children of the PerfilOpcionNode it is created with,
     * and in its run method will reload all of that nodes children.
     * PerfilOpcionNodeLoader may not be running in the event dispatching thread. As
     * swing is not thread safe it is important that we don't generate events in
     * this thread. SwingUtilities.invokeLater is used so that events are
     * generated in the event dispatching thread.
     */
    class PerfilOpcionNodeLoader implements Runnable {
        /** Node creating children for. */
        PerfilOpcionNode node;

        PerfilOpcionNodeLoader(PerfilOpcionNode node) {
            this.node = node;
            node.setChildren(node.createChildren(), true);
        }

        public void run() {
            PerfilOpcionNode[] hijos = node.reloadChildren();

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
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        node.setChildren(node.getChildren(), true);
                        synchronized (PerfilOpcionTreeModel2.this) {
                            reloadCount--;
                            PerfilOpcionTreeModel2.this.notifyAll();
                        }
                    }
                });
            } else {
                synchronized (PerfilOpcionTreeModel2.this) {
                    reloadCount--;
                    PerfilOpcionTreeModel2.this.notifyAll();
                }
            }
            try {
                PerfilOpcionNode[] path = new PerfilOpcionNode[aPath.getPath().length];
                for (int i = 0; i < path.length; i++) {
                    path[i] = (PerfilOpcionNode) aPath.getPath()[i];
                }
                fireTreeStructureChanged(PerfilOpcionTreeModel2.this, path, null, null);
            } catch (Exception e) {
                e.getMessage();
            }
            try {
                unaTreeTable.getTree().expandPath(aPath);
            } catch (Exception e) {
                e.getMessage();
            }
        }

        protected void loadChildren(PerfilOpcionNode node) {
            if (!node.isLeaf()) {
                final PerfilOpcionNode[] children = node.createChildren();

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
                    final PerfilOpcionNode fn = node;

                    // Reset the children
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            fn.setChildren(children, true);
                            fn.nodeChanged();
                        }
                    });
                }
            }
        }
    }

}