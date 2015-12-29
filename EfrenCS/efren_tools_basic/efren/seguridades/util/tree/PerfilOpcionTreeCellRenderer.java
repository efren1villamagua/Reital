package efren.seguridades.util.tree;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import efren.util.entidades.SecPerfilOpcion;

public class PerfilOpcionTreeCellRenderer extends DefaultTreeCellRenderer {
	private boolean opcionEsMenu = false;
	private boolean opcionEsSeparador = false;
	private boolean opcionEsSistemaSeguridades = false;
	private boolean opcionEsSistema = false;
	/**
	 * 
	 */
	public PerfilOpcionTreeCellRenderer() {
		super();
	}
	//...
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
	    if (value instanceof PerfilOpcionTreeModel2.PerfilOpcionNode) {
			SecPerfilOpcion o = ((PerfilOpcionTreeModel2.PerfilOpcionNode) value).getPerfilOpcion();
		    this.opcionEsMenu = o.esMenu();
		    this.opcionEsSeparador = o.esSeparador();
		    this.opcionEsSistemaSeguridades = false;
		    this.opcionEsSistema = false;
		    if (o.getOid() == PerfilOpcionTreeModel2.SISTEMA_SEGURIDADES_META_OID)
		        this.opcionEsSistemaSeguridades = true;
		    else {
		        if (o.getOid() == o.getSistemaOid())
		            this.opcionEsSistema = true;
		    }
		}
        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    }

	public Icon getLeafIcon() {
		if (this.opcionEsMenu)
		    return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuEmpty.gif"));
		else {
		    if (this.opcionEsSeparador)
		        return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/separador.gif"));
		    else
		        return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/opcion.png"));
		}
	}
	public Icon getOpenIcon() {
	    if (this.opcionEsSistemaSeguridades)
	        return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuOpenedSistemaSeguridades.png"));
	    else {
	        if (this.opcionEsSistema)
	            return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuOpenedSistema.png"));
	        else
	            return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuOpened.gif"));
	    }
	}
	public Icon getClosedIcon() {
	    if (this.opcionEsSistemaSeguridades)
	        return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuClosedSistemaSeguridades.png"));
	    else {
	        if (this.opcionEsSistema)
	            return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuClosedSistema.png"));
	        else
	            return new javax.swing.ImageIcon(getClass().getResource("/efren/resources/images/seguridades/menuClosed.gif"));
	    }
	}
}