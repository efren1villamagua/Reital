package efren.util;

/**
 * This type was created in VisualAge.
 */
public class WindowManager2 {
	private static int screenWidth;
	private static int screenHeight;
	private static java.awt.Toolkit toolkit;
public static boolean centerWindow(java.awt.Window window) {
	boolean resizable = true;
	return WindowManager2.centerWindow(window, resizable);
}
public static boolean centerWindow(java.awt.Window window, boolean resizable) {
	
	int screenWidth = getScreenWidth();
	int screenHeight = getScreenHeight();

	/* obtenemos el ancho y alto de la window */
	int windowWidth = window.getSize().width;
	int windowHeight = window.getSize().height;

	/* si la window es más ancha y más alta que la pantalla se la coloca en el origen */
	if ((windowWidth > screenWidth) || (windowHeight > screenHeight)) {
		window.setLocation(0, 0);
		return false;
	}

	/* ... */
	int xPos;
	int yPos;

	/* coordenada x */
	if (screenWidth == windowWidth)
		xPos = 0;
	else
		xPos = (screenWidth - windowWidth) / 2;
		
	/* coordenada y */
	if (screenHeight == windowHeight)
		yPos = 0;
	else
		yPos = (screenHeight - windowHeight) / 2;


	if (window instanceof java.awt.Frame){
		/* se decide si la ventana puede o no cambiar de tamaño */	
		((java.awt.Frame)window).setResizable(resizable);
	}
		
	/* se centra la window */
	window.setLocation(xPos, yPos);

	/* todo bien */
	return true;
}
public static void centerWindowOnThis(java.awt.Window parent, java.awt.Window child) {
	boolean resizable = true;
	WindowManager2.centerWindowOnThis(parent, child, resizable);
}
public static void centerWindowOnThis(java.awt.Window parent, java.awt.Window child, boolean resizable) {

	/* obtenemos el punto central de la ventana padre */
	int parentWidth = parent.getSize().width;
	int parentHeight = parent.getSize().height;
	
	int xPosParent = parent.getLocationOnScreen().x;
	int yPosParent = parent.getLocationOnScreen().y;
	
	int xCenterParent = xPosParent + (parentWidth / 2);
	int yCenterParent = yPosParent + (parentHeight / 2);

	//
	int childWidth = child.getSize().width;
	int childHeight = child.getSize().height;
	
	int xPosCenterChild = xCenterParent - (childWidth / 2);
	if (xPosCenterChild < 0) {
		xPosCenterChild = 0;
	}
	
	int yPosCenterChild = yCenterParent - (childHeight / 2);
	if (yPosCenterChild < 0) {
		yPosCenterChild = 0;
	}

	
	if (child instanceof java.awt.Frame){
		/* se decide si la ventana puede o no cambiar de tamaño */	
		((java.awt.Frame) child).setResizable(resizable);
	}

	/* se centra la ventana hija */
	child.setLocation(xPosCenterChild, yPosCenterChild);
}
/**
 * This method was created in VisualAge.
 * @return int
 */
private static int getScreenHeight() {
	screenHeight = getToolkit().getScreenSize().height;
	return screenHeight;
}
/**
 * This method was created in VisualAge.
 * @return int
 */
private static int getScreenWidth() {
	screenWidth = getToolkit().getScreenSize().width;	
	return screenWidth;
}
private static java.awt.Toolkit getToolkit() {
	if (toolkit == null)
		toolkit = ToolkitManager.getToolkit();
	return toolkit;
}
public static void maximize(java.awt.Window window) {
	boolean resizable = true;
	WindowManager2.maximize(window, resizable);
}
public static void maximize(java.awt.Window window, boolean resizable) {
	
	int screenWidth = getScreenWidth();
	int screenHeight = getScreenHeight();
	
	if (window instanceof java.awt.Frame) {
		/* se decide si la ventana puede o no cambiar de tamaño */
	 	((java.awt.Frame) window).setResizable(resizable);
	}
	
	window.setLocation(0, 0);
	window.setSize(screenWidth, screenHeight);
	
}
/**
 * This method was created in VisualAge.
 * @param newValue int
 */
private static void setScreenHeight(int newValue) {
	screenHeight = newValue;
}
/**
 * This method was created in VisualAge.
 * @param newValue int
 */
private static void setScreenWidth(int newValue) {
	screenWidth = newValue;
}
}
