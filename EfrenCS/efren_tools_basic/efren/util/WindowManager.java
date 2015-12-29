package efren.util;

import java.awt.Color;
import java.awt.Container;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;

/**
 * This type was created in VisualAge.
 */
public class WindowManager {
	private static int screenWidth;

	private static int screenHeight;

	private static java.awt.Toolkit toolkit;

	public static boolean centerWindow(javax.swing.JInternalFrame window) {
		boolean resizable = true;
		return WindowManager.centerWindow(window, resizable);
	}

	public static boolean centerWindow(javax.swing.JInternalFrame window, boolean resizable) {

		int screenWidth = getScreenWidth();
		int screenHeight = getScreenHeight();
		if (SystemProperties.RUNTIME_MAIN_DESKTOP_PANE != null) {
			screenWidth = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.getWidth();
			screenHeight = SystemProperties.RUNTIME_MAIN_DESKTOP_PANE.getHeight();
		}

		/* obtenemos el ancho y alto de la window */
		int windowWidth = window.getSize().width;
		int windowHeight = window.getSize().height;

		/*
		 * si la window es más ancha y más alta que la pantalla se la coloca en
		 * el origen
		 */
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

		if (window instanceof javax.swing.JInternalFrame) {
			/* se decide si la ventana puede o no cambiar de tamaño */
			((javax.swing.JInternalFrame) window).setResizable(resizable);
		}

		/* se centra la window */
		window.setLocation(xPos, yPos);

		/* todo bien */
		return true;
	}

	public static boolean centerWindow2(java.awt.Window window) {
		boolean resizable = true;
		return WindowManager.centerWindow2(window, resizable);
	}

	public static boolean centerWindow2(java.awt.Window window, boolean resizable) {

		int screenWidth = getScreenWidth();
		int screenHeight = getScreenHeight();

		/* obtenemos el ancho y alto de la window */
		int windowWidth = window.getSize().width;
		int windowHeight = window.getSize().height;

		/*
		 * si la window es más ancha y más alta que la pantalla se la coloca en
		 * el origen
		 */
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

		if (window instanceof java.awt.Frame) {
			/* se decide si la ventana puede o no cambiar de tamaño */
			((java.awt.Frame) window).setResizable(resizable);
		}

		/* se centra la window */
		window.setLocation(xPos, yPos);

		/* todo bien */
		return true;
	}

	public static void centerWindowOnThis(javax.swing.JInternalFrame parent, javax.swing.JInternalFrame child) {
		boolean resizable = true;
		WindowManager.centerWindowOnThis(parent, child, resizable);
	}

	public static void centerWindowOnThis(javax.swing.JInternalFrame parent, javax.swing.JInternalFrame child, boolean resizable) {

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

		if (child instanceof javax.swing.JInternalFrame) {
			/* se decide si la ventana puede o no cambiar de tamaño */
			((javax.swing.JInternalFrame) child).setResizable(resizable);
		}

		/* se centra la ventana hija */
		child.setLocation(xPosCenterChild, yPosCenterChild);
	}

	public static void centerWindowOnThis2(java.awt.Component parent, javax.swing.JDialog child) {

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

		if (child instanceof javax.swing.JDialog) {
			/* se decide si la ventana puede o no cambiar de tamaño */
			((javax.swing.JDialog) child).setResizable(true);
		}

		/* se centra la ventana hija */
		child.setLocation(xPosCenterChild, yPosCenterChild);
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @return int
	 */
	private static int getScreenHeight() {
		screenHeight = getToolkit().getScreenSize().height;
		return screenHeight;
	}

	/**
	 * This method was created in VisualAge.
	 * 
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

	public static void maximize(javax.swing.JInternalFrame window) {
		boolean resizable = true;
		WindowManager.maximize(window, resizable);
	}

	public static void maximize(javax.swing.JInternalFrame window, boolean resizable) {

		int screenWidth = getScreenWidth();
		int screenHeight = getScreenHeight();

		if (window instanceof javax.swing.JInternalFrame) {
			/* se decide si la ventana puede o no cambiar de tamaño */
			((javax.swing.JInternalFrame) window).setResizable(resizable);
		}

		window.setLocation(0, 0);
		window.setSize(screenWidth, screenHeight);
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @param newValue
	 *            int
	 */
	private static void setScreenHeight(int newValue) {
		screenHeight = newValue;
	}

	/**
	 * This method was created in VisualAge.
	 * 
	 * @param newValue
	 *            int
	 */
	private static void setScreenWidth(int newValue) {
		screenWidth = newValue;
	}

	/**
	 * 
	 * @param unComponente
	 * @param args
	 */
	public static JWindow splashScreenForWaiting(Container unComponente) {

		JWindow jw = null;
		try {
			jw = new JWindow((JFrame) unComponente);
		} catch (Exception e) {
			e.getMessage();
			jw = new JWindow(new JFrame());
		}
		jw.setBackground(java.awt.Color.white);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		jw.setContentPane(contentPane);
		jw.getContentPane().setBackground(java.awt.Color.white);
		try {
			String dimensiones = "110x80";
			StringTokenizer stk = new StringTokenizer(dimensiones, "x");
			String anchoSplash = stk.nextToken();
			String altoSplash = stk.nextToken();
			jw.setSize(new Integer(anchoSplash).intValue(), new Integer(altoSplash).intValue());
		} catch (Exception e) {
			e.getMessage();
			jw.setSize(100, 100);
		}
		JLabel pict = null;
		try {
			pict = new JLabel(new ImageIcon(unComponente.getClass().getResource("/efren/resources/images/wait2.gif")), JLabel.CENTER);
		} catch (Exception e) {
			e.getMessage();
		}
		JLabel mensaje = null;
		try {
			mensaje = new JLabel("Espere por favor...", JLabel.CENTER);
		} catch (Exception e) {
			e.getMessage();
		}
		pict.setBackground(java.awt.Color.white);
		jw.getContentPane().add(pict, java.awt.BorderLayout.CENTER);
		jw.getContentPane().add(mensaje, java.awt.BorderLayout.SOUTH);

		WindowManager.centerWindow2(jw);

		jw.setVisible(true);

		return jw;
	}
	/**
	 * 
	 */
	public static Container getParent(Container element) {
		if (element.getParent() == null) {
			return null;
		} else {
			if (element.getParent() instanceof JInternalFrame || element.getParent() instanceof JFrame 
					|| element.getParent() instanceof JDialog || element.getParent() instanceof JWindow) {
				return element.getParent();
			} else {
				return WindowManager.getParent(element.getParent());
			}
		}
	}

}
