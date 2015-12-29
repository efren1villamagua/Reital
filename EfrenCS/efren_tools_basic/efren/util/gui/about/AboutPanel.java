package efren.util.gui.about;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import efren.util.BrowserManager;
import efren.util.config.SystemProperties;

public class AboutPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9068396927863743961L;
	JLabel sistema_logo = null;
	JLabel java_logo = null;

	public AboutPanel() {
		super(new GridBagLayout());

		sistema_logo = new JLabel();
		try {
			URL logoIconoPath = this.getClass().getResource(SystemProperties.SISTEMA_ABOUT_ICONO_PATH);
			sistema_logo.setIcon(new ImageIcon(logoIconoPath));
		} catch (Exception e) {
			e.getMessage();
			URL logoIconoPath = this.getClass().getResource("/efren/resources/images/cubos.png");
			sistema_logo.setIcon(new ImageIcon(logoIconoPath));
		}
		sistema_logo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				sistema_logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				sistema_logo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(java.awt.event.MouseEvent e) {
				BrowserManager.displayURL("http://"+SystemProperties.INSTITUCION_WEB);
			}
		});
		JLabel line1 = new JLabel(SystemProperties.ABOUT_DIALOG_Line01);
		JLabel line2 = new JLabel(SystemProperties.RUNTIME_SISTEMA_NAME + " - Version " + SystemProperties.SISTEMA_VERSION);
		JLabel line3 = new JLabel("Copyright © ::: " + SystemProperties.INSTITUCION_NOMBRE);
		JLabel divider1 = new JLabel(new ImageIcon(getClass().getResource("/efren/resources/images/_about_div.gif")));
		JLabel line4 = new JLabel("Servidor: "+SystemProperties.WEB_SERVER_IP+":"+SystemProperties.WEB_SERVER_PORT);
		//JLabel divider2 = new JLabel(new ImageIcon(getClass().getResource("/efren/resources/images/_about_div.gif")));
		//JLabel line5 = new JLabel("Powered by: Ing. Efrén Villamagua");
		//JLabel line6 = new JLabel("efren.villamagua@gmail.com");
		java_logo = new JLabel(new ImageIcon(getClass().getResource("/efren/resources/images/get_java_sm_2.gif")));
		java_logo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				java_logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				java_logo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(java.awt.event.MouseEvent e) {
				BrowserManager.displayURL("http://www.java.com");
			}
		});


		Font font1 = new Font("Arial", Font.BOLD, 12);
//		Font font2 = new Font("Arial", Font.PLAIN, 12);
		Color color1 = Color.BLACK;

		line1.setFont(font1);
		line1.setForeground(color1);
		line2.setFont(font1);
		line2.setForeground(color1);
		line3.setFont(font1);
		line3.setForeground(color1);
		line4.setFont(font1);
		line4.setForeground(color1);
/*		
		line5.setFont(font2);
		line5.setForeground(color1);
		line6.setFont(font2);
		line6.setForeground(color1);
*/
		add(sistema_logo, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(1, 0, 25, 0), 0, 0));
		add(line1, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
		add(line2, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
		add(line3, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
		add(divider1, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.1D, 17, 0, new Insets(25, 95, 0, 25), 0, 0));
		add(line4, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.1D, 17, 0, new Insets(5, 95, 0, 25), 0, 0));
/*		
		add(divider2, new GridBagConstraints(0, 6, 1, 1, 0.0D, 0.1D, 17, 0, new Insets(25, 95, 0, 25), 0, 0));
		add(line5, new GridBagConstraints(0, 7, 1, 1, 0.0D, 0.1D, 17, 0, new Insets(5, 95, 0, 25), 0, 0));
		add(line6, new GridBagConstraints(0, 8, 1, 1, 0.0D, 0.1D, 17, 0, new Insets(5, 95, 0, 25), 0, 0));
*/		
		add(java_logo, new GridBagConstraints(0, 9, 1, 1, 0.0D, 0.1D, GridBagConstraints.EAST, 0, new Insets(5, 95, 0, 25), 0, 0));
	}
}
