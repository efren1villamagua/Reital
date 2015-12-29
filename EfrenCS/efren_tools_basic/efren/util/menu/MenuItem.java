package efren.util.menu;

/**
 * Insert the type's description here.
 * Creation date: (9/12/2003 9:15:29)
 * @author: Efrén Villamagua
 */
public class MenuItem extends javax.swing.JMenuItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8478759601609302652L;
	private java.lang.Object agregado;
/**
 * MenuItem constructor comment.
 */
public MenuItem() {
	super();
}
/**
 * MenuItem constructor comment.
 * @param text java.lang.String
 */
public MenuItem(String text) {
	super(text);
}
/**
 * MenuItem constructor comment.
 * @param text java.lang.String
 * @param mnemonic int
 */
public MenuItem(String text, int mnemonic) {
	super(text, mnemonic);
}
/**
 * MenuItem constructor comment.
 * @param text java.lang.String
 * @param icon javax.swing.Icon
 */
public MenuItem(String text, javax.swing.Icon icon) {
	super(text, icon);
}
/**
 * MenuItem constructor comment.
 * @param icon javax.swing.Icon
 */
public MenuItem(javax.swing.Icon icon) {
	super(icon);
}
/**
 * Insert the method's description here.
 * Creation date: (9/12/2003 9:16:05)
 * @return java.lang.Object
 */
public java.lang.Object getAgregado() {
	return agregado;
}
/**
 * Insert the method's description here.
 * Creation date: (9/12/2003 9:16:05)
 * @param newAgregado java.lang.Object
 */
public void setAgregado(java.lang.Object newAgregado) {
	agregado = newAgregado;
}
}
