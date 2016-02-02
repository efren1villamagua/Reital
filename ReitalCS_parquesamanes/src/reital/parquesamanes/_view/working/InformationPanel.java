package reital.parquesamanes._view.working;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class InformationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4795415167998735431L;

	private JLabel lblValor;

	/**
	 * Create the panel.
	 */
	public InformationPanel() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValor.weighty = 1.0;
		gbc_lblValor.weightx = 1.0;
		gbc_lblValor.insets = new Insets(2, 2, 2, 2);
		gbc_lblValor.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor.gridx = 0;
		gbc_lblValor.gridy = 0;
		add(getLblValor(), gbc_lblValor);

	}

	private JLabel getLblValor() {
		if (lblValor == null) {
			lblValor = new JLabel("...");
			lblValor.setVerticalAlignment(SwingConstants.TOP);
			lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblValor;
	}

	public void setValor(String unTexto) {
		getLblValor().setText(unTexto);
	}
}
