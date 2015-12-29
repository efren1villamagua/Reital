package efren.seguridades.gui;

/**
 * This type was created in VisualAge.
 */
public class SystemObserver {
	private static SystemObserver singleton = null;
	private boolean isAnySystemOpen = false;
/**
 * SystemObserver constructor comment.
 */
private SystemObserver() {
	super();
}
public void clear() {
	setIsAnySystemOpen(false);
}
public void fill() {
	setIsAnySystemOpen(true);
}
/**
 * This method was created in VisualAge.
 * @return boolean
 */
public boolean getIsAnySystemOpen() {
	return isAnySystemOpen;
}
/**
 * This method was created in VisualAge.
 * @param newValue boolean
 */
public void setIsAnySystemOpen(boolean newValue) {
	this.isAnySystemOpen = newValue;
}
public static SystemObserver singleton() {
	if (singleton == null)
		singleton = new SystemObserver();
	return singleton;
}
}
