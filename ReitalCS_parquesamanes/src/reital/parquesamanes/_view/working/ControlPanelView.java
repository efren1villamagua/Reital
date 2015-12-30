package reital.parquesamanes._view.working;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import efren.util.WindowManager2;
import efren.util.gui.dialogs.InfoView;
import reital.parquesamanes.app.util.ParqueSamanesConstantes;

public class ControlPanelView extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2341181348290219259L;

	private JPanel jPanel4 = null;

	private JPanel jPanel1 = null;

	private JPanel jPanel2 = null;

	private JToolBar jToolBar = null;

	private JButton jButtonReportes = null;

	private JButton jButtonFranjasHorarias = null;

	private JButton jButtonMinutosGraciaClientes = null;

	public ControlPanelView() throws HeadlessException {
		super();
		initialize();
	}

	public ControlPanelView(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public ControlPanelView(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public ControlPanelView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(0);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reital/parquesamanes/resource/images/clock16x16.png")));
		setTitle("Reital Parking - " + ParqueSamanesConstantes.EMPRESA_NOMBRE_01 + "  --  Control Panel - [" + ParqueSamanesConstantes.SISTEMA_VERSION + "]");
		setContentPane(getJPanel4());
		setSize(595, 194);
		WindowManager2.centerWindow(this);
		// setResizable(false);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			}
		});
	}

	/**
	 *
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(20, 20, 20, 20);
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.gridy = 8;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridwidth = 2;
			gridBagConstraints13.gridy = 7;
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			jPanel4.add(getJPanel1(), gridBagConstraints13);
			jPanel4.add(getJPanel2(), gridBagConstraints6);
			jPanel4.add(getJToolBar(), gridBagConstraints4);
			jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jPanel4;
	}

	/**
	 *
	 */
	private void cerrarVentana() {
		if (InfoView.showConfirmDialog(this, "Desea salir del sistema?") == 0) {
			dispose();
			System.exit(0);
		}
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
		}
		return jPanel2;
	}

	/**
	 * This method initializes jToolBar
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.setFloatable(false);
			jToolBar.setOpaque(false);
			jToolBar.add(getJButtonFranjasHorarias());
			jToolBar.add(getJButtonReportes());
			jToolBar.add(getJButtonMinutosGraciaClientes());
		}
		return jToolBar;
	}

	/**
	 * This method initializes jButtonReportes
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonReportes() {
		if (jButtonReportes == null) {
			jButtonReportes = new JButton();
			jButtonReportes.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/chart_pie.png")));
			jButtonReportes.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonReportes.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonReportes.setMargin(new Insets(2, 24, 2, 24));
			jButtonReportes.setText("REPORTES");
			jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrirDialogConsultasYReportes();
				}
			});
		}
		return jButtonReportes;
	}

	/**
	 * This method initializes jButtonFranjasHorarias
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFranjasHorarias() {
		if (jButtonFranjasHorarias == null) {
			jButtonFranjasHorarias = new JButton();
			jButtonFranjasHorarias.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/calendar.png")));
			jButtonFranjasHorarias.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonFranjasHorarias.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonFranjasHorarias.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonFranjasHorarias.setMargin(new Insets(2, 24, 2, 24));
			jButtonFranjasHorarias.setText("FRANJAS HORARIAS");
			jButtonFranjasHorarias.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrirFranjasHorarias();
				}
			});
		}
		return jButtonFranjasHorarias;
	}

	private void abrirFranjasHorarias() {
		new FranjaHorariaABMView().setVisible(true);
	}

	/**
	 * This method initializes jButtonMinutosGraciaClientes
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMinutosGraciaClientes() {
		if (jButtonMinutosGraciaClientes == null) {
			jButtonMinutosGraciaClientes = new JButton();
			jButtonMinutosGraciaClientes.setFont(new Font("Arial", Font.BOLD, 14));
			jButtonMinutosGraciaClientes.setIcon(new ImageIcon(getClass().getResource("/reital/parquesamanes/resource/images/comment_48x48.png")));
			jButtonMinutosGraciaClientes.setMargin(new Insets(2, 24, 2, 24));
			jButtonMinutosGraciaClientes.setText("PARAMETROS");
			jButtonMinutosGraciaClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
			jButtonMinutosGraciaClientes.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonMinutosGraciaClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					abrirDialogCambiarParametros();
				}
			});
		}
		return jButtonMinutosGraciaClientes;
	}

	/**
	 *
	 */
	private void abrirDialogCambiarParametros() {
		ParametrosDialog vd = new ParametrosDialog(this);
		vd.setResizable(false);
		vd.setVisible(true);
		vd.toFront();
	}

	/**
	 *
	 */
	private void abrirDialogConsultasYReportes() {
		ReporterView v = new ReporterView(this, true);
		v.setVisible(true);
		v.toFront();
	}

} // @jve:decl-index=0:visual-constraint="10,10"