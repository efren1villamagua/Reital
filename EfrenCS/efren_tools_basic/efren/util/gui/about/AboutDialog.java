package efren.util.gui.about;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import efren.seguridades.gui.SystemView;
import efren.util.WindowManager;
import efren.util.gui.dialogs.DialogExt;

public class AboutDialog extends DialogExt implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 4293006061515761969L;
	SystemInfoPanel sysPanel;

	public AboutDialog(JFrame parent) {

		super(parent, "Acerca de", true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		JButton okButton = new JButton("Aceptar");
		okButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				((JComponent) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				((JComponent) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				sysPanel.timer.stop();
				dispose();
			}
		});
		JTabbedPane tabbedPane = new JTabbedPane();
		AboutPanel aboutPanel = new AboutPanel();
		Dimension dimension = aboutPanel.getSize(null);
		this.sysPanel = new SystemInfoPanel(dimension);
		tabbedPane.add(aboutPanel, "Acerca de");
		tabbedPane.addTab("Java - Máquina virtual", sysPanel);
		UserPanel userPanel = new UserPanel();
		tabbedPane.addTab("Usuario", userPanel);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(okButton);
		getContentPane().add(tabbedPane, "Center");
		getContentPane().add(buttonPanel, "South");
		pack();
		WindowManager.centerWindow2(this);
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent actionevent) {
		new AboutDialog(SystemView.singleton()).setVisible(true);
	}
}
