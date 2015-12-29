package efren.util.gui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import efren.util.FontManager;

public class MultiChoice extends JPanel implements java.awt.event.ActionListener, java.awt.event.MouseListener, javax.swing.event.ChangeListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -4130981950167152989L;
	private int fieldSelectedIndex = -1;
	private javax.swing.JRadioButton ivjeventClaimerButton = null;
	protected transient MultiChoiceListener fieldMultiChoiceListenerEventMulticaster = null;
	private java.lang.String[] fieldNameOptions = new String[1];
	private java.lang.String[] fieldValueOptions = new String[1];
	private javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
	private javax.swing.JLabel titleLabel = new javax.swing.JLabel("aTitle");
	private String fieldTitle = null;
	private boolean fieldEnabled = true;
	private JPanel radioPanel = new javax.swing.JPanel();
	private Vector<JRadioButton> buttonsCollection = new Vector<JRadioButton>();  //  @jve:decl-index=0:
	private String ivjselectedStringOption = null; // @jve:decl-index=0:
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private boolean optioning = false;
	private boolean indexing = false;
	private javax.swing.Icon[] icons;
	private LabelExt labelIcon = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public MultiChoice() {
		super();
		initialize();
	}
	/**
	 *
	 */
	public void actionPerformed(java.awt.event.ActionEvent e) {

		// ...
		if (e.getSource() instanceof javax.swing.JRadioButton) {

			// ...el nombre del radioButton es el index de él mismo
			String index = ((javax.swing.JRadioButton) e.getSource()).getName();
			int index0 = new Integer(index).intValue();

			String stringIndex = null;
			try {
				stringIndex = getValueOptions()[index0];
			} catch (Throwable t) {
				t.getMessage();
				stringIndex = ((javax.swing.JRadioButton) e.getSource()).getText();
			}

			setSelectedIndex(index0); // el índice seleccionado
			setselectedStringOption(stringIndex); // el índice (string)
													// seleccionado

			// se avisa que se seleccionó otra opción
			boolean b = geteventClaimerButton().isSelected();
			geteventClaimerButton().setSelected(!b);
			this.fireSelectedOptionChanged(new java.util.EventObject(this));
		}
	}

	/**
	 *
	 * @param newListener
	 *            MultiChoiceListener
	 */
	public void addMultiChoiceListener(MultiChoiceListener newListener) {
		fieldMultiChoiceListenerEventMulticaster = MultiChoiceListenerEventMulticaster.add(fieldMultiChoiceListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * The addPropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().addPropertyChangeListener(listener);
	}

	/**
	 * connEtoC1:
	 * (eventClaimerButton.change.stateChanged(javax.swing.event.ChangeEvent)
	 * --> MultiChoice.fireSelectedOptionChanged(Ljava.util.EventObject;)V)
	 *
	 * @param arg1
	 *            javax.swing.event.ChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(javax.swing.event.ChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.fireSelectedOptionChanged(new java.util.EventObject(this));
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	public void deselect() {

		// se setea en nulo la selección
		this.setSelectedIndex(-1);

	}

	/**
	 * The firePropertyChange method was generated to support the propertyChange
	 * field.
	 *
	 * @param propertyName
	 *            java.lang.String
	 * @param oldValue
	 *            java.lang.Object
	 * @param newValue
	 *            java.lang.Object
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Method to support listener events.
	 *
	 * @param newEvent
	 *            java.util.EventObject
	 */
	protected void fireSelectedOptionChanged(java.util.EventObject newEvent) {
		if (fieldMultiChoiceListenerEventMulticaster == null) {
			return;
		}
		;
		fieldMultiChoiceListenerEventMulticaster.selectedOptionChanged(newEvent);
	}

	/**
	 * Gets the enabled property (boolean) value.
	 *
	 * @return The enabled property value.
	 * @see #setEnabled
	 */
	public boolean getEnabled() {
		return fieldEnabled;
	}

	/**
	 * Return the eventClaimerButton property value.
	 *
	 * @return javax.swing.JRadioButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JRadioButton geteventClaimerButton() {
		// user code begin {1}
		if (ivjeventClaimerButton == null)
			ivjeventClaimerButton = new javax.swing.JRadioButton("eventClaimerButton");
		// user code end
		return ivjeventClaimerButton;
	}

	/**
	 * Insert the method's description here. Creation date: (2003-nov-16
	 * 11:03:59)
	 *
	 * @return javax.swing.Icon[]
	 */
	public javax.swing.Icon[] getIcons() {
		return icons;
	}

	/**
	 * Gets the nameOptions property (java.lang.String[]) value.
	 *
	 * @return The nameOptions property value.
	 * @see #setNameOptions
	 */
	public java.lang.String[] getNameOptions() {
		return fieldNameOptions;
	}

	/**
	 * Accessor for the propertyChange field.
	 *
	 * @return java.beans.PropertyChangeSupport
	 */
	protected java.beans.PropertyChangeSupport getPropertyChange() {
		if (propertyChange == null) {
			propertyChange = new java.beans.PropertyChangeSupport(this);
		}
		;
		return propertyChange;
	}

	/**
	 * Gets the selectedIndex property (int) value.
	 *
	 * @return The selectedIndex property value.
	 * @see #setSelectedIndex
	 */
	public int getSelectedIndex() {
		return fieldSelectedIndex;
	}

	/**
	 * Method generated to support the promotion of the selectedOption
	 * attribute.
	 *
	 * @return java.lang.String
	 */
	public String getSelectedNameOption() {
		return fieldNameOptions[getSelectedIndex()];
	}

	/**
	 * Method generated to support the promotion of the selectedOption
	 * attribute.
	 *
	 * @return java.lang.String
	 */
	public String getSelectedOption() {
		return getselectedStringOption();
	}

	/**
	 * Return the selectedStringOption property value.
	 *
	 * @return java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String getselectedStringOption() {
		// user code begin {1}
		// user code end
		return ivjselectedStringOption;
	}

	/**
	 * Gets the title property (java.lang.String) value.
	 *
	 * @return The title property value.
	 * @see #setTitle
	 */
	public String getTitle() {
		if (fieldTitle == null)
			fieldTitle = "aTitle";
		return fieldTitle;
	}

	/**
	 * Gets the valueOptions property (java.lang.String[]) value.
	 *
	 * @return The valueOptions property value.
	 * @see #setValueOptions
	 */
	public java.lang.String[] getValueOptions() {
		return fieldValueOptions;
	}

	private void handleException(Throwable exception) {
		efren.util.ExceptionManager.singleton().manage(this, false, this, exception);
	}
	private void initialize() {
		try {
			setName("MultiChoice");
			setFont(new java.awt.Font("Arial", 0, 10));
			setLayout(null);
			setSize(160, 120);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		try {
			setFont(new java.awt.Font("Arial", 0, 10));
			String[] initValues = { "0" };
			setValueOptions(initValues);
			String[] initNames = { "options..." };
			setNameOptions(initNames);
			titleLabel.setFont(new java.awt.Font("Arial", 0, 10));
			this.setOpaque(false);
			for (int i = 0; i < buttonsCollection.size(); i++) {
				buttonsCollection.elementAt(i).setSelected(false);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean isDataMissing() {

		int options = fieldValueOptions.length;

		if (getSelectedIndex() < 0 || getSelectedIndex() >= options) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Seleccione una opción !");
			this.requestFocus();
			return true;
		}

		if ((getSelectedOption() == null) || (getSelectedOption().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, "¡ Seleccione una opción !");
			this.requestFocus();
			return true;
		}
		return false;
	}

	public boolean isDataMissing(String errorMessage) {

		int options = fieldValueOptions.length;

		if (getSelectedIndex() < 0 || getSelectedIndex() >= options) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}

		if ((getSelectedOption() == null) || (getSelectedOption().trim().compareTo("") == 0)) {
			efren.util.gui.dialogs.InfoView.showErrorDialog(this, errorMessage);
			this.requestFocus();
			return true;
		}
		return false;
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		if (getEnabled())
			if (e.getSource() instanceof javax.swing.JRadioButton) {
				((javax.swing.JRadioButton) e.getSource()).setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				((javax.swing.JRadioButton) e.getSource()).setForeground(FontManager.BUTTON_COLOR_RESALTADO);
			}
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		if (getEnabled())
			if (e.getSource() instanceof javax.swing.JRadioButton) {
				((javax.swing.JRadioButton) e.getSource()).setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
				((javax.swing.JRadioButton) e.getSource()).setForeground(FontManager.BUTTON_COLOR_NORMAL);
			}
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	/**
	 *
	 * @param newListener
	 *            MultiChoiceListener
	 */
	public void removeMultiChoiceListener(MultiChoiceListener newListener) {
		fieldMultiChoiceListenerEventMulticaster = MultiChoiceListenerEventMulticaster.remove(fieldMultiChoiceListenerEventMulticaster, newListener);
		return;
	}

	/**
	 * The removePropertyChangeListener method was generated to support the
	 * propertyChange field.
	 *
	 * @param listener
	 *            java.beans.PropertyChangeListener
	 */
	public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		getPropertyChange().removePropertyChangeListener(listener);
	}

	/**
	 * Sets the enabled property (boolean) value.
	 *
	 * @param enabled
	 *            The new value for the property.
	 * @see #getEnabled
	 */
	public void setEnabled(boolean enabled) {
		boolean oldValue = fieldEnabled;
		fieldEnabled = enabled;
		firePropertyChange("enabled", new Boolean(oldValue), new Boolean(enabled));
		// ...
		radioPanel.setEnabled(enabled);
		titleLabel.setEnabled(enabled);
		for (int i = 0; i < buttonsCollection.size(); i++)
			((javax.swing.JRadioButton) buttonsCollection.elementAt(i)).setEnabled(enabled);
		repaint();
	}

	/**
	 * Insert the method's description here. Creation date: (2003-nov-16
	 * 11:03:59)
	 *
	 * @param newIcons
	 *            javax.swing.Icon[]
	 */
	public void setIcons(javax.swing.Icon[] newIcons) {
		icons = newIcons;
	}

	/**
	 * Sets the nameOptions property (java.lang.String[]) value.
	 *
	 * @param nameOptions
	 *            The new value for the property.
	 * @see #getNameOptions
	 */
	public void setNameOptions(java.lang.String[] nameOptions) {
		this.setNameOptions(nameOptions, true, true);
	}

	/**
	 * Sets the nameOptions property (java.lang.String[]) value.
	 *
	 * @param nameOptions
	 *            The new value for the property.
	 * @see #getNameOptions
	 */
	public void setNameOptions(java.lang.String[] nameOptions, boolean withTitles, boolean vertical) {
		java.lang.String[] oldValue = fieldNameOptions;
		fieldNameOptions = nameOptions;
		firePropertyChange("nameOptions", oldValue, nameOptions);

		// ...creación de los botones
		_buildItems(withTitles, vertical);
	}

	/**
	 *
	 *
	 */
	public void _buildItems(boolean whithTitle, boolean vertical) {

		if ((getNameOptions() != null) && (getNameOptions().length > 0)) {
			// se elimina todos los botones que existían
			java.util.Enumeration<javax.swing.AbstractButton> buttons0 = group.getElements();
			while (buttons0.hasMoreElements()) {
				group.remove((javax.swing.AbstractButton) buttons0.nextElement());
			}
			radioPanel.removeAll();
			radioPanel.setOpaque(false);
			radioPanel.setLayout(new java.awt.GridBagLayout());

			buttonsCollection.removeAllElements();
			javax.swing.JRadioButton button0;
			java.awt.GridBagConstraints radioConstraints;
			for (int i = 0; i < getNameOptions().length; i++) {
				radioConstraints = new java.awt.GridBagConstraints();
				if (vertical) {
					radioConstraints.gridx = 0;
					radioConstraints.gridy = i;
				} else {
					radioConstraints.gridx = i;
					radioConstraints.gridy = 0;
				}
				radioConstraints.gridwidth = 1;
				radioConstraints.gridheight = 1;
				radioConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
				radioConstraints.anchor = java.awt.GridBagConstraints.CENTER;
				radioConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
				radioConstraints.weightx = 1.0;
				radioConstraints.weighty = 1.0;

				button0 = new javax.swing.JRadioButton(getNameOptions()[i]);
				button0.setOpaque(false);
				button0.setName(new Integer(i).toString());
				button0.setFont(new java.awt.Font("Arial", 0, 10));
				button0.setForeground(FontManager.BUTTON_COLOR_NORMAL);
				// if (i == 0)
				// button0.setSelected(true);

				// se añade al grupo el botón creado
				group.add(button0);

				// register a listener for the radio button
				button0.addActionListener(this);
				button0.addMouseListener(this);
				button0.addChangeListener(this);

				buttonsCollection.addElement(button0);

				radioPanel.add(button0, radioConstraints);
			}

			// layout y constraints
			setLayout(new java.awt.GridBagLayout());
			removeAll();
			if (whithTitle) {
				// title
				java.awt.GridBagConstraints constraintsTitle = new java.awt.GridBagConstraints();
				constraintsTitle.gridx = 0;
				constraintsTitle.gridy = 0;
				constraintsTitle.gridwidth = 1;
				constraintsTitle.gridheight = 1;
				constraintsTitle.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsTitle.anchor = java.awt.GridBagConstraints.CENTER;
				constraintsTitle.insets = new java.awt.Insets(3, 3, 2, 3);
				constraintsTitle.weightx = 1.0;
				constraintsTitle.weighty = 1.0;
				titleLabel.setText(getTitle());
				titleLabel.setForeground(java.awt.Color.black);
				add(titleLabel, constraintsTitle);
				// icon
				java.awt.GridBagConstraints constraintsIcon = new java.awt.GridBagConstraints();
				constraintsIcon.gridx = 1;
				constraintsIcon.gridy = 0;
				constraintsIcon.gridwidth = 1;
				constraintsIcon.gridheight = 1;
				constraintsIcon.fill = java.awt.GridBagConstraints.NONE;
				constraintsIcon.anchor = java.awt.GridBagConstraints.CENTER;
				constraintsIcon.insets = new java.awt.Insets(3, 3, 2, 3);
				constraintsIcon.weightx = 0.0;
				constraintsIcon.weighty = 0.0;
				LabelExt aLabel = new LabelExt();
				aLabel.setText("");
				this.labelIcon = aLabel;
				add(aLabel, constraintsIcon);
			}
			// radioPanel
			java.awt.GridBagConstraints constraintsRadioPanel = new java.awt.GridBagConstraints();
			constraintsRadioPanel.gridx = 0;
			constraintsRadioPanel.gridy = 1;
			constraintsRadioPanel.gridwidth = 2;
			constraintsRadioPanel.gridheight = 1;
			constraintsRadioPanel.fill = java.awt.GridBagConstraints.BOTH;
			constraintsRadioPanel.anchor = java.awt.GridBagConstraints.CENTER;
			if (whithTitle) {
				constraintsRadioPanel.insets = new java.awt.Insets(2, 13, 3, 3);
			} else {
				constraintsRadioPanel.insets = new java.awt.Insets(1, 1, 1, 1);
			}
			constraintsRadioPanel.weightx = 1.0;
			constraintsRadioPanel.weighty = 1.0;
			add(radioPanel, constraintsRadioPanel);

			if (!whithTitle) {
				this.setBorder(null);
			}
			this.setOpaque(false);
			// ...
			// setSelectedIndex(0);
			repaint();
		}
	}

	/**
	 * Sets the selectedIndex property (int) value.
	 *
	 * @param selectedIndex
	 *            The new value for the property.
	 * @see #getSelectedIndex
	 */
	public void setSelectedIndex(int selectedIndex) {
		int oldValue = fieldSelectedIndex;
		fieldSelectedIndex = selectedIndex;
		firePropertyChange("selectedIndex", new Integer(oldValue), new Integer(selectedIndex));

		// ...

		this.indexing = true;

		if (!this.optioning) {
			try {
				if ((selectedIndex >= 0) && (selectedIndex < getNameOptions().length)) {
					this.setSelectedOption(getValueOptions()[selectedIndex]);
					((javax.swing.JRadioButton) buttonsCollection.elementAt(selectedIndex)).setSelected(true);
				} else {
					this.setSelectedOption(null);
					for (int i = 0; i < buttonsCollection.size(); i++) {
						((javax.swing.JRadioButton) buttonsCollection.elementAt(i)).setSelected(false);
					}
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		try {
			if (this.labelIcon != null)
				this.labelIcon.setIcon(getIcons()[selectedIndex]);
		} catch (Throwable t) {
			t.getMessage();
			this.labelIcon.setIcon(null);
		}
		this.indexing = false;

		repaint();
	}

	/**
	 * Method generated to support the promotion of the selectedOption
	 * attribute.
	 *
	 * @param arg1
	 *            java.lang.String
	 */
	public void setSelectedOption(String arg1) {
		setselectedStringOption(arg1);
	}

	/**
	 * Set the selectedStringOption to a new value.
	 *
	 * @param newValue
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void setselectedStringOption(java.lang.String newValue) {
		if (ivjselectedStringOption != newValue) {
			try {
				String oldValue = getselectedStringOption();
				ivjselectedStringOption = newValue;
				firePropertyChange("title", oldValue, newValue);
				// user code begin {1}
				firePropertyChange("selectedOption", oldValue, newValue);
				firePropertyChange("selectedOptionChanged", oldValue, newValue);

				this.optioning = true;

				if (!this.indexing) {

					int indexSeleccionado = -1;
					try {
						for (int i = 0; i < getValueOptions().length; i++) {
							if (newValue.trim().compareTo(((String) getValueOptions()[i]).trim()) == 0)
								indexSeleccionado = i;
						}
					} catch (Throwable t) {
						t.getMessage();
					}

					if (indexSeleccionado == -1)
						for (int i = 0; i < buttonsCollection.size(); i++)
							((javax.swing.JRadioButton) buttonsCollection.elementAt(i)).setSelected(false);
					else
						((javax.swing.JRadioButton) buttonsCollection.elementAt(indexSeleccionado)).setSelected(true);

					this.setSelectedIndex(indexSeleccionado);
				}

				this.optioning = false;

				repaint();

				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		;
		// user code begin {3}
		// user code end
	}

	/**
	 * Sets the title property (java.lang.String) value.
	 *
	 * @param title
	 *            The new value for the property.
	 * @see #getTitle
	 */
	public void setTitle(String title) {
		String oldValue = fieldTitle;
		fieldTitle = title;
		firePropertyChange("title", oldValue, title);
		// ...
		titleLabel.setText(title);
		repaint();
	}

	public void setValue(String aValue) {
		setSelectedOption(aValue);
	}

	/**
	 * Sets the valueOptions property (java.lang.String[]) value.
	 *
	 * @param valueOptions
	 *            The new value for the property.
	 * @see #getValueOptions
	 */
	public void setValueOptions(java.lang.String[] valueOptions) {
		java.lang.String[] oldValue = fieldValueOptions;
		fieldValueOptions = valueOptions;
		firePropertyChange("valueOptions", oldValue, valueOptions);
	}

	public void setValueToNull() {

		// se setea en nulo la selección
		this.setSelectedOption(null);

	}

	public String SQLText() {
		if (getSelectedOption() == null || getSelectedOption().trim().length() == 0 || getSelectedIndex() < 0)
			return " NULL ";
		else {
			return " " + efren.util.StringTools.parseComilla(getSelectedOption().trim()) + " ";
		}
	}

	/**
	 * Method to handle events for the ChangeListener interface.
	 *
	 * @param e
	 *            javax.swing.event.ChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void stateChanged(javax.swing.event.ChangeEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == geteventClaimerButton())
			connEtoC1(e);
		// user code begin {2}
		// this.fireSelectedOptionChanged(new java.util.EventObject(this));
		// user code end
	}
}
