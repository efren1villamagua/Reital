package efren.util.gui.about;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import efren.util.config.SystemProperties;

public class UserPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 7316282302715817262L;
	JLabel line1;
	JLabel line2, line21, line22;
	JLabel line3;
	JLabel line4;

	public UserPanel() {
		super(new GridBagLayout());
		try {
			line1 = new JLabel("Nombre: " + SystemProperties.RUNTIME_NOMBRE_USUARIO);
			line2 = new JLabel("userName: " + SystemProperties.RUNTIME_USER_NAME);
			line21 = new JLabel("CODIGO ALTERNO : " + SystemProperties.RUNTIME_USUARIO_CODIGO_ALTERNO);
			line22 = new JLabel("DEPENDENCIA : " + SystemProperties.RUNTIME_DEPENDENCIA_CODIGO + " " + SystemProperties.RUNTIME_DEPENDENCIA_NOMBRE);
			if (SystemProperties.RUNTIME_INIT_CONECTION_CALENDAR_MANAGER != null)
				line3 = new JLabel("Conectado desde: " + SystemProperties.RUNTIME_INIT_CONECTION_CALENDAR_MANAGER.getAbsoluteRegionalDateExpression());
			else
				line3 = new JLabel("");
			line4 = new JLabel("Cliente: " + java.net.InetAddress.getLocalHost());
			line1.setFont(new Font("Arial", 0, 12));
			line1.setForeground(Color.black);
			line2.setFont(new Font("Arial", 0, 12));
			line2.setForeground(Color.black);
			line21.setFont(new Font("Arial", 0, 12));
			line21.setForeground(Color.black);
			line22.setFont(new Font("Arial", 0, 12));
			line22.setForeground(Color.black);
			line3.setFont(new Font("Arial", 0, 12));
			line3.setForeground(Color.black);
			line4.setFont(new Font("Arial", 0, 12));
			line4.setForeground(Color.black);
			add(line1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
			add(line2, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
			add(line21, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
			add(line22, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
			add(line3, new GridBagConstraints(0, 4, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
			add(line4, new GridBagConstraints(0, 5, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 95, 0, 25), 0, 0));
		} catch (Throwable t) {
			t.getMessage();
		}
	}
}
