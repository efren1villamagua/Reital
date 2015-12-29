package efren.util;

/**
 * This type was created in VisualAge.
 */
public class WindowPool {
	private int MAX_WINDOW_COUNT = 10;
	private java.awt.Window[] windows = new java.awt.Window[MAX_WINDOW_COUNT];
	private boolean[] used = new boolean[MAX_WINDOW_COUNT];
	private int createdWindowCount = 0;
	private int usedWindowCount = 0;
	private java.awt.Window mainWindow;
	private String windowClassName;
/**
 * ViewPool constructor comment.
 */
public WindowPool() {
	super();
}
/**
 * ViewPool constructor comment.
 */
public WindowPool(java.awt.Window aMainWindow, String aWindowClassName) {
	super();
	mainWindow = aMainWindow;
	windowClassName = aWindowClassName;
}
/**
 * ViewPool constructor comment.
 */
public WindowPool(java.awt.Window aMainWindow, String aWindowClassName, int maxWindowCount) {
	super();
	mainWindow = aMainWindow;
	windowClassName = aWindowClassName;
	MAX_WINDOW_COUNT = maxWindowCount;
}
public void close() {
	for (int i = 0; i < createdWindowCount; i++) {
		try {
			windows[i].dispose();
		} catch (Throwable t) {
			t.getMessage();
		}
	}
}
public void fillPool() {
	for (int i = 0; i < MAX_WINDOW_COUNT; i++) {
		try {
			createdWindowCount++;
			windows[i] = (java.awt.Window) Class.forName(windowClassName).newInstance();
			used[i] = false;
		} catch (Throwable t) {
			t.getMessage();
		}
	}
}
public void freeWindow(int pos) {
	usedWindowCount--;
	used[pos] = false;
	windows[pos].setVisible(false);
}
public Object[] pickWindow() {

	try {
	
		if (createdWindowCount >= MAX_WINDOW_COUNT && usedWindowCount >= MAX_WINDOW_COUNT) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(
				mainWindow, "El número máximo de ventanas por abrir para este ABM ( " + new Integer(MAX_WINDOW_COUNT).toString() 
									+ " ) ha sido alcanzado ! Cierre algunas ventanas y podrá abrir otras para otros objetos de negocio !");
			return null;
		}

		Object[] a = new Object[2];
		java.awt.Window aWindow = null;
	
		if (createdWindowCount == 0) {
			aWindow = (java.awt.Window) Class.forName(windowClassName).newInstance();
			windows[0] = aWindow;
			used[0] = true;
			createdWindowCount++;
			usedWindowCount++;
			a[0] = aWindow;
			a[1] = new Integer(0);		
			return a;
		}
	
		for (int i = 0; i < createdWindowCount; i++) {
			if (!used[i]) {
				used[i] = true;
				usedWindowCount++;
				a[0] = windows[i];
				a[1] = new Integer(i);		
				return a;			
			}
		}

		createdWindowCount++;
		usedWindowCount++;	
		windows[createdWindowCount - 1] = (java.awt.Window) Class.forName(windowClassName).newInstance();
		used[usedWindowCount - 1] = true;
		a[0] = windows[createdWindowCount - 1];
		a[1] = new Integer(createdWindowCount - 1);
		return a;
	} catch (Throwable t) {
		t.getMessage();
	}
	return null;
}
}
