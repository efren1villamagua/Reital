package efren.util.menu;

import efren.util.MethodInvocation;

public class GeneralAction extends javax.swing.AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 289985245779620500L;
	public Object arguments[] = {};
	public Class targetClass;
	public Object targetObject;	
	public String methodName;
	public boolean byStatic = false;
	private java.awt.Component parentComponent;
/**
 * GeneralAction constructor comment.
 */
public GeneralAction() {
	super();
}
/**
 * GeneralAction constructor comment.
 * @param name java.lang.String
 */
public GeneralAction(String name) {
	super(name);
}
/**
 * GeneralAction constructor comment.
 * @param name java.lang.String
 * @param icon javax.swing.Icon
 */
public GeneralAction(String name, javax.swing.Icon icon) {
	super(name, icon);
}
/**
 * GeneralAction constructor comment.
 * @param name java.lang.String
 * @param icon javax.swing.Icon
 */
public GeneralAction(String name, javax.swing.Icon icon, boolean aBool) {
	super(name, icon);
	setByStatic(aBool);	
}
/**
 * GeneralAction constructor comment.
 * @param name java.lang.String
 */
public GeneralAction(String name, boolean aBool) {
	super(name);
	setByStatic(aBool);	
}
/**
 * GeneralAction constructor comment.
 */
public GeneralAction(boolean aBool) {
	super();
	setByStatic(aBool);
}
public void actionPerformed(java.awt.event.ActionEvent arg1) {
	try {
		if (getByStatic())
			MethodInvocation.performStaticMethod(getMethodName(), getTargetClass(), getArguments());
		else
			MethodInvocation.performMethod(getMethodName(), getTargetObject(), getArguments());
	} catch (Throwable t) {
		efren.util.gui.dialogs.InfoView.showErrorDialog(getParentComponent(), t.getMessage());
	}
}
public Object[] getArguments() {
	return this.arguments;
}
/**
 * This method was created in VisualAge.
 * @return boolean
 */
public boolean getByStatic() {
	return byStatic;
}
/**
 * This method was created in VisualAge.
 * @return java.lang.String
 */
public String getMethodName() {
	return methodName;
}
/**
 * This method was created in VisualAge.
 * @return java.awt.Component
 */
public java.awt.Component getParentComponent() {
	if (parentComponent == null)
		parentComponent = new java.awt.Frame();
	return parentComponent;
}
public Class getTargetClass() {
	return targetClass;
}
/**
 * This method was created in VisualAge.
 * @return java.lang.Object
 */
public Object getTargetObject() {
	return targetObject;
}
public void setArguments(Object args[]) {
	this.arguments = args;
}
/**
 * This method was created in VisualAge.
 * @param newValue boolean
 */
public void setByStatic(boolean newValue) {
	this.byStatic = newValue;
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.String
 */
public void setMethodName(String newValue) {
	this.methodName = newValue;
}
/**
 * This method was created in VisualAge.
 * @param newValue java.awt.Component
 */
public void setParentComponent(java.awt.Component newValue) {
	this.parentComponent = newValue;
}
public void setTargetClass(Class newValue) {
	this.targetClass = newValue;
}
/**
 * This method was created in VisualAge.
 * @param newValue java.lang.Object
 */
public void setTargetObject(Object newValue) {
	this.targetObject = newValue;
}
}
