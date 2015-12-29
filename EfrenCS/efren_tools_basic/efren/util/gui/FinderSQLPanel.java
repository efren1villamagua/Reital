package efren.util.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JPanel;

import efren.util.Conn;
import efren.util.ExceptionManager;
import efren.util.StringTools;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.combo.ComboTIPO;
import efren.util.gui.combo.ObjectComboBox;
import efren.util.gui.panels.PanelExt;
import efren.util.gui.panels.TitledPanel;
import efren.util.gui.table.DataTablePanel;
import efren.util.gui.text.TextDate;
import efren.util.gui.text.TextFieldExt;
import efren.util.gui.text.TextFieldExtListener;

public class FinderSQLPanel extends JPanel
		implements TextFieldExtListener, java.awt.event.ActionListener, java.awt.event.MouseListener, java.beans.PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4753301249727219710L;

	/**
	 *
	 */
	protected transient java.beans.PropertyChangeSupport propertyChange;

	private ObjectComboBox ivjObjectComboBoxCampo01 = null;

	private ObjectComboBox ivjObjectComboBoxCampo02 = null;

	private ObjectComboBox ivjObjectComboBoxCampo03 = null;

	private ObjectComboBox ivjObjectComboBoxCampo04 = null;

	private ObjectComboBox ivjObjectComboBoxCampo05 = null;

	private ObjectComboBox ivjObjectComboBoxOperador01 = null;

	private ObjectComboBox ivjObjectComboBoxOperador02 = null;

	private ObjectComboBox ivjObjectComboBoxOperador03 = null;

	private ObjectComboBox ivjObjectComboBoxOperador04 = null;

	private ObjectComboBox ivjObjectComboBoxOperador05 = null;

	private LabelExt ivjLabelExt = null;

	private LabelExt ivjLabelExt1 = null;

	private LabelExt ivjLabelExt2 = null;

	private TextDate ivjTextDateValor01 = null;

	private TextFieldExt ivjTextFieldExtValor01 = null;

	private java.lang.String fieldTABLE_NAME = new String(); // @jve:decl-index=0:

	private java.lang.String fieldSCHEMA_NAME = new String(); // @jve:decl-index=0:

	private TextDate ivjTextDateValor02 = null;

	private TextDate ivjTextDateValor03 = null;

	private TextDate ivjTextDateValor04 = null;

	private TextDate ivjTextDateValor05 = null;

	private TextFieldExt ivjTextFieldExtValor02 = null;

	private TextFieldExt ivjTextFieldExtValor03 = null;

	private TextFieldExt ivjTextFieldExtValor04 = null;

	private TextFieldExt ivjTextFieldExtValor05 = null;

	private int fieldCamposCount = 5;

	private ComboTIPO ivjComboTIPOValor01 = null;

	private ComboTIPO ivjComboTIPOValor02 = null;

	private ComboTIPO ivjComboTIPOValor03 = null;

	private ComboTIPO ivjComboTIPOValor04 = null;

	private ComboTIPO ivjComboTIPOValor05 = null;

	private java.lang.String[] _TABLA_GENERAL__SI_NO_Columns = new String[] {};

	private javax.swing.JButton ivjJButtonReset = null;

	private DataTablePanel ivjaDataTablePanel = null;

	private Vector operacionesSQL = new Vector(); // @jve:decl-index=0:

	private PanelExt panelExt = null;

	private TitledPanel titledPanel = null;

	private String selectedCampo01 = null;

	private String selectedCampo02 = null;

	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public FinderSQLPanel() {
		super();
		initialize();
	}

	/**
	 * Method to handle events for the ActionListener interface.
	 * 
	 * @param e
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButtonReset())
			connEtoC7(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformed(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		if (newEvent.getSource() == getTextFieldExtValor01())
			connEtoC10(newEvent);
		if (newEvent.getSource() == getTextFieldExtValor02())
			connEtoC11(newEvent);
		if (newEvent.getSource() == getTextFieldExtValor03())
			connEtoC12(newEvent);
		if (newEvent.getSource() == getTextFieldExtValor04())
			connEtoC13(newEvent);
		if (newEvent.getSource() == getTextFieldExtValor05())
			connEtoC14(newEvent);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void actionPerformedOnTextField(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
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
	 * connEtoC1: (ObjectComboBoxCampo01.selectedItem -->
	 * FinderSQLPanel.visualManageComboCampo01()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageComboCampo01();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC10:
	 * (TextFieldExtValor01.textFieldExt.actionPerformed(java.util.EventObject)
	 * --> FinderSQLPanel.manageActionPerformedOnTextFields()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC10(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageActionPerformedOnTextFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC11:
	 * (TextFieldExtValor02.textFieldExt.actionPerformed(java.util.EventObject)
	 * --> FinderSQLPanel.manageActionPerformedOnTextFields()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC11(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageActionPerformedOnTextFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC12:
	 * (TextFieldExtValor03.textFieldExt.actionPerformed(java.util.EventObject)
	 * --> FinderSQLPanel.manageActionPerformedOnTextFields()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC12(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageActionPerformedOnTextFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC13:
	 * (TextFieldExtValor04.textFieldExt.actionPerformed(java.util.EventObject)
	 * --> FinderSQLPanel.manageActionPerformedOnTextFields()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC13(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageActionPerformedOnTextFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC14:
	 * (TextFieldExtValor05.textFieldExt.actionPerformed(java.util.EventObject)
	 * --> FinderSQLPanel.manageActionPerformedOnTextFields()V)
	 * 
	 * @param arg1
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC14(java.util.EventObject arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageActionPerformedOnTextFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC2: (TwoFieldsPanel.initialize() -->
	 * FinderSQLPanel.initValueFields()V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC2() {
		try {
			// user code begin {1}
			// user code end
			this.initValueFields();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC3: (ObjectComboBoxCampo02.selectedItem -->
	 * FinderSQLPanel.visualManageComboCampo02()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageComboCampo02();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC4: (ObjectComboBoxCampo03.selectedItem -->
	 * FinderSQLPanel.visualManageComboCampo03()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageComboCampo03();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC5: (ObjectComboBoxCampo04.selectedItem -->
	 * FinderSQLPanel.visualManageComboCampo04()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageComboCampo04();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC6: (ObjectComboBoxCampo05.selectedItem -->
	 * FinderSQLPanel.visualManageComboCampo05()V)
	 * 
	 * @param arg1
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6(java.beans.PropertyChangeEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.visualManageComboCampo05();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC7:
	 * (JButtonReset.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * FinderSQLPanel.limpiarCriterios()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC7(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.limpiarCriterios();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC8: (JButtonReset.mouse.mouseEntered(java.awt.event.MouseEvent)
	 * --> FinderSQLPanel.manageMouseOver(Z)V)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC8(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC9: (JButtonReset.mouse.mouseExited(java.awt.event.MouseEvent) -->
	 * FinderSQLPanel.manageMouseOver(Z)V)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC9(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			this.manageMouseOver(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void field_keyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
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
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusGained(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void focusLost(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Insert the method's description here. Creation date: (14-Sep-2003
	 * 18:16:24 PM)
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] get_TABLA_GENERAL__SI_NO_Columns() {
		return _TABLA_GENERAL__SI_NO_Columns;
	}

	private DataTablePanel getaDataTablePanel() {
		// user code begin {1}
		// user code end
		return ivjaDataTablePanel;
	}

	/**
	 * Gets the camposCount property (int) value.
	 * 
	 * @return The camposCount property value.
	 * @see #setCamposCount
	 */
	public int getCamposCount() {
		return fieldCamposCount;
	}

	private ComboTIPO getComboTIPOValor01() {
		if (ivjComboTIPOValor01 == null) {
			try {
				ivjComboTIPOValor01 = new efren.util.gui.combo.ComboTIPO();
				ivjComboTIPOValor01.setName("ComboTIPOValor01");
				ivjComboTIPOValor01.setNullable(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjComboTIPOValor01;
	}

	private ComboTIPO getComboTIPOValor02() {
		if (ivjComboTIPOValor02 == null) {
			try {
				ivjComboTIPOValor02 = new efren.util.gui.combo.ComboTIPO();
				ivjComboTIPOValor02.setName("ComboTIPOValor02");
				ivjComboTIPOValor02.setNullable(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjComboTIPOValor02;
	}

	private ComboTIPO getComboTIPOValor03() {
		if (ivjComboTIPOValor03 == null) {
			try {
				ivjComboTIPOValor03 = new efren.util.gui.combo.ComboTIPO();
				ivjComboTIPOValor03.setName("ComboTIPOValor03");
				ivjComboTIPOValor03.setNullable(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjComboTIPOValor03;
	}

	private ComboTIPO getComboTIPOValor04() {
		if (ivjComboTIPOValor04 == null) {
			try {
				ivjComboTIPOValor04 = new efren.util.gui.combo.ComboTIPO();
				ivjComboTIPOValor04.setName("ComboTIPOValor04");
				ivjComboTIPOValor04.setNullable(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjComboTIPOValor04;
	}

	private ComboTIPO getComboTIPOValor05() {
		if (ivjComboTIPOValor05 == null) {
			try {
				ivjComboTIPOValor05 = new efren.util.gui.combo.ComboTIPO();
				ivjComboTIPOValor05.setName("ComboTIPOValor05");
				ivjComboTIPOValor05.setNullable(false);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjComboTIPOValor05;
	}

	/**
	 * Return the JButtonReset property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonReset() {
		if (ivjJButtonReset == null) {
			try {
				ivjJButtonReset = new javax.swing.JButton();
				ivjJButtonReset.setName("JButtonReset");
				ivjJButtonReset.setMnemonic('L');
				ivjJButtonReset.setText("Limpiar valores");
				ivjJButtonReset.setBackground(java.awt.SystemColor.info);
				ivjJButtonReset.setForeground(new java.awt.Color(0, 88, 0));
				ivjJButtonReset.setFocusPainted(false);
				ivjJButtonReset.setFont(new java.awt.Font("Arial", 1, 10));
				ivjJButtonReset.setOpaque(false);
				ivjJButtonReset.setContentAreaFilled(false);
				ivjJButtonReset.setBorderPainted(false);
				ivjJButtonReset.setBorder(null);
				ivjJButtonReset.setMargin(new Insets(0, 0, 0, 0));
				// user code begin {1}
				ivjJButtonReset.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				// user code end
				ivjJButtonReset.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent e) {
						ivjJButtonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						ivjJButtonReset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonReset;
	}

	/**
	 * Return the ObjectComboBoxCampo01 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxCampo01() {
		if (ivjObjectComboBoxCampo01 == null) {
			try {
				ivjObjectComboBoxCampo01 = new ObjectComboBox();
				ivjObjectComboBoxCampo01.setName("ObjectComboBoxCampo01");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxCampo01;
	}

	/**
	 * Return the ObjectComboBoxCampo02 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxCampo02() {
		if (ivjObjectComboBoxCampo02 == null) {
			try {
				ivjObjectComboBoxCampo02 = new ObjectComboBox();
				ivjObjectComboBoxCampo02.setName("ObjectComboBoxCampo02");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxCampo02;
	}

	/**
	 * Return the ObjectComboBoxCampo03 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxCampo03() {
		if (ivjObjectComboBoxCampo03 == null) {
			try {
				ivjObjectComboBoxCampo03 = new ObjectComboBox();
				ivjObjectComboBoxCampo03.setName("ObjectComboBoxCampo03");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxCampo03;
	}

	/**
	 * Return the ObjectComboBoxCampo04 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxCampo04() {
		if (ivjObjectComboBoxCampo04 == null) {
			try {
				ivjObjectComboBoxCampo04 = new ObjectComboBox();
				ivjObjectComboBoxCampo04.setName("ObjectComboBoxCampo04");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxCampo04;
	}

	/**
	 * Return the ObjectComboBoxCampo05 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxCampo05() {
		if (ivjObjectComboBoxCampo05 == null) {
			try {
				ivjObjectComboBoxCampo05 = new ObjectComboBox();
				ivjObjectComboBoxCampo05.setName("ObjectComboBoxCampo05");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxCampo05;
	}

	/**
	 * Return the ObjectComboBoxOperador01 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxOperador01() {
		if (ivjObjectComboBoxOperador01 == null) {
			try {
				ivjObjectComboBoxOperador01 = new ObjectComboBox();
				ivjObjectComboBoxOperador01.setName("ObjectComboBoxOperador01");
				Object ivjLocal54items[] = { "CONTIENE", "IGUAL A", "DIFERENTE A", "MENOR QUE", "MENOR O IGUAL QUE", "MAYOR QUE", "MAYOR O IGUAL QUE",
						"ES NULO", "NO ES NULO", "ESTA EN", "NO ESTA EN" };
				ivjObjectComboBoxOperador01.setItems(ivjLocal54items);
				ivjObjectComboBoxOperador01.setForeground(new Color(19, 72, 184));
				ivjObjectComboBoxOperador01.setSelectedIndex(0);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxOperador01;
	}

	/**
	 * Return the ObjectComboBoxOperador02 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxOperador02() {
		if (ivjObjectComboBoxOperador02 == null) {
			try {
				ivjObjectComboBoxOperador02 = new ObjectComboBox();
				ivjObjectComboBoxOperador02.setName("ObjectComboBoxOperador02");
				ivjObjectComboBoxOperador02.setForeground(new Color(19, 72, 184));
				Object ivjLocal54items[] = { "CONTIENE", "IGUAL A", "DIFERENTE A", "MENOR QUE", "MENOR O IGUAL QUE", "MAYOR QUE", "MAYOR O IGUAL QUE",
						"ES NULO", "NO ES NULO", "ESTA EN", "NO ESTA EN" };
				ivjObjectComboBoxOperador02.setItems(ivjLocal54items);
				ivjObjectComboBoxOperador02.setSelectedIndex(0);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxOperador02;
	}

	/**
	 * Return the ObjectComboBoxOperador03 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxOperador03() {
		if (ivjObjectComboBoxOperador03 == null) {
			try {
				ivjObjectComboBoxOperador03 = new ObjectComboBox();
				ivjObjectComboBoxOperador03.setName("ObjectComboBoxOperador03");
				ivjObjectComboBoxOperador03.setForeground(new Color(19, 72, 184));
				Object ivjLocal54items[] = { "CONTIENE", "IGUAL A", "DIFERENTE A", "MENOR QUE", "MENOR O IGUAL QUE", "MAYOR QUE", "MAYOR O IGUAL QUE",
						"ES NULO", "NO ES NULO", "ESTA EN", "NO ESTA EN" };
				ivjObjectComboBoxOperador03.setItems(ivjLocal54items);
				ivjObjectComboBoxOperador03.setSelectedIndex(0);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxOperador03;
	}

	/**
	 * Return the ObjectComboBoxOperador04 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxOperador04() {
		if (ivjObjectComboBoxOperador04 == null) {
			try {
				ivjObjectComboBoxOperador04 = new ObjectComboBox();
				ivjObjectComboBoxOperador04.setName("ObjectComboBoxOperador04");
				ivjObjectComboBoxOperador04.setForeground(new Color(19, 72, 184));
				Object ivjLocal54items[] = { "CONTIENE", "IGUAL A", "DIFERENTE A", "MENOR QUE", "MENOR O IGUAL QUE", "MAYOR QUE", "MAYOR O IGUAL QUE",
						"ES NULO", "NO ES NULO", "ESTA EN", "NO ESTA EN" };
				ivjObjectComboBoxOperador04.setItems(ivjLocal54items);
				ivjObjectComboBoxOperador04.setSelectedIndex(0);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxOperador04;
	}

	/**
	 * Return the ObjectComboBoxOperador05 property value.
	 * 
	 * @return ObjectComboBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private ObjectComboBox getObjectComboBoxOperador05() {
		if (ivjObjectComboBoxOperador05 == null) {
			try {
				ivjObjectComboBoxOperador05 = new ObjectComboBox();
				ivjObjectComboBoxOperador05.setName("ObjectComboBoxOperador05");
				ivjObjectComboBoxOperador05.setForeground(new Color(19, 72, 184));
				Object ivjLocal54items[] = { "CONTIENE", "IGUAL A", "DIFERENTE A", "MENOR QUE", "MENOR O IGUAL QUE", "MAYOR QUE", "MAYOR O IGUAL QUE",
						"ES NULO", "NO ES NULO", "ESTA EN", "NO ESTA EN" };
				ivjObjectComboBoxOperador05.setItems(ivjLocal54items);
				ivjObjectComboBoxOperador05.setSelectedIndex(0);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjObjectComboBoxOperador05;
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
	 * Gets the SCHEMA_NAME property (java.lang.String) value.
	 * 
	 * @return The SCHEMA_NAME property value.
	 * @see #setSCHEMA_NAME
	 */
	public java.lang.String getSCHEMA_NAME() {
		return fieldSCHEMA_NAME;
	}

	public DataTablePanel getDataTablePanel() {
		return getaDataTablePanel();
	}

	/**
	 * Return the LabelExt property value.
	 * 
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt() {
		if (ivjLabelExt == null) {
			try {
				ivjLabelExt = new LabelExt();
				ivjLabelExt.setName("LabelExt");
				ivjLabelExt.setText("Operadores");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt;
	}

	/**
	 * Return the LabelExt1 property value.
	 * 
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt1() {
		if (ivjLabelExt1 == null) {
			try {
				ivjLabelExt1 = new LabelExt();
				ivjLabelExt1.setName("LabelExt1");
				ivjLabelExt1.setText("Criterios");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt1;
	}

	/**
	 * Return the LabelExt2 property value.
	 * 
	 * @return LabelExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private LabelExt getLabelExt2() {
		if (ivjLabelExt2 == null) {
			try {
				ivjLabelExt2 = new LabelExt();
				ivjLabelExt2.setName("LabelExt2");
				ivjLabelExt2.setText("Valores");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjLabelExt2;
	}

	/**
	 * Gets the TABLE_NAME property (java.lang.String) value.
	 * 
	 * @return The TABLE_NAME property value.
	 * @see #setTABLE_NAME
	 */
	public java.lang.String getTABLE_NAME() {
		return fieldTABLE_NAME;
	}

	/**
	 * Return the TextDateValor01 property value.
	 * 
	 * @return TextDate
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextDate getTextDateValor01() {
		if (ivjTextDateValor01 == null) {
			try {
				ivjTextDateValor01 = new TextDate();
				ivjTextDateValor01.setName("TextDateValor01");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextDateValor01;
	}

	/**
	 * Return the TextDateValor02 property value.
	 * 
	 * @return TextDate
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextDate getTextDateValor02() {
		if (ivjTextDateValor02 == null) {
			try {
				ivjTextDateValor02 = new TextDate();
				ivjTextDateValor02.setName("TextDateValor02");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextDateValor02;
	}

	/**
	 * Return the TextDateValor03 property value.
	 * 
	 * @return TextDate
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextDate getTextDateValor03() {
		if (ivjTextDateValor03 == null) {
			try {
				ivjTextDateValor03 = new TextDate();
				ivjTextDateValor03.setName("TextDateValor03");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextDateValor03;
	}

	/**
	 * Return the TextDateValor04 property value.
	 * 
	 * @return TextDate
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextDate getTextDateValor04() {
		if (ivjTextDateValor04 == null) {
			try {
				ivjTextDateValor04 = new TextDate();
				ivjTextDateValor04.setName("TextDateValor04");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextDateValor04;
	}

	/**
	 * Return the TextDateValor05 property value.
	 * 
	 * @return TextDate
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextDate getTextDateValor05() {
		if (ivjTextDateValor05 == null) {
			try {
				ivjTextDateValor05 = new TextDate();
				ivjTextDateValor05.setName("TextDateValor05");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextDateValor05;
	}

	/**
	 * Return the TextFieldExtValor01 property value.
	 * 
	 * @return gui.TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtValor01() {
		if (ivjTextFieldExtValor01 == null) {
			try {
				ivjTextFieldExtValor01 = new TextFieldExt();
				ivjTextFieldExtValor01.setName("TextFieldExtValor01");
				ivjTextFieldExtValor01.setAceptarKeyLikeTabKey(false);
				ivjTextFieldExtValor01.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor01;
	}

	/**
	 * Return the TextFieldExtValor02 property value.
	 * 
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtValor02() {
		if (ivjTextFieldExtValor02 == null) {
			try {
				ivjTextFieldExtValor02 = new TextFieldExt();
				ivjTextFieldExtValor02.setName("TextFieldExtValor02");
				ivjTextFieldExtValor02.setAceptarKeyLikeTabKey(false);
				ivjTextFieldExtValor02.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor02;
	}

	/**
	 * Return the TextFieldExtValor03 property value.
	 * 
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtValor03() {
		if (ivjTextFieldExtValor03 == null) {
			try {
				ivjTextFieldExtValor03 = new TextFieldExt();
				ivjTextFieldExtValor03.setName("TextFieldExtValor03");
				ivjTextFieldExtValor03.setAceptarKeyLikeTabKey(false);
				ivjTextFieldExtValor03.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor03;
	}

	/**
	 * Return the TextFieldExtValor04 property value.
	 * 
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtValor04() {
		if (ivjTextFieldExtValor04 == null) {
			try {
				ivjTextFieldExtValor04 = new TextFieldExt();
				ivjTextFieldExtValor04.setName("TextFieldExtValor04");
				ivjTextFieldExtValor04.setAceptarKeyLikeTabKey(false);
				ivjTextFieldExtValor04.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor04;
	}

	/**
	 * Return the TextFieldExtValor05 property value.
	 * 
	 * @return TextFieldExt
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private TextFieldExt getTextFieldExtValor05() {
		if (ivjTextFieldExtValor05 == null) {
			try {
				ivjTextFieldExtValor05 = new TextFieldExt();
				ivjTextFieldExtValor05.setName("TextFieldExtValor05");
				ivjTextFieldExtValor05.setAceptarKeyLikeTabKey(false);
				ivjTextFieldExtValor05.setMaxLength(200);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTextFieldExtValor05;
	}

	private void handleException(Throwable exception) {
		ExceptionManager.singleton().manage(this, false, this, exception);
	}

	public void initAll() {

		if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_4_ADMIN) {
			setSCHEMA_NAME(SystemProperties.SCHEMA_SEGURIDADES);
		}

		// ...
		try {
			Vector colNames = new Vector();
			Vector colTypes = new Vector();
			String colNameTemp, colTypeTemp;

			String sql = null;
			if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_1_OS400) {// as400
				sql = "SELECT RTRIM(LTRIM(COLUMN_NAME)) AS COLNAME, RTRIM(LTRIM(DATA_TYPE)) AS COLTYPE ,"
						+ " CASE WHEN DATA_TYPE='CHARACTER VARYING' THEN 0 WHEN DATA_TYPE = 'CHARACTER' THEN 1 "
						+ " WHEN DATA_TYPE = 'SMALLINT' THEN 2 WHEN DATA_TYPE = 'INTEGER' THEN 3  " + " WHEN DATA_TYPE = 'DECIMAL' THEN 4 ELSE 5 END AS COLINT "
						+ " FROM QSYS2.COLUMNS " + " WHERE TABLE_SCHEMA='" + getSCHEMA_NAME() + "' AND TABLE_NAME ='" + getTABLE_NAME() + "' "
						+ " ORDER BY COLINT, COLNAME";
			} else {
				if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_2_WINDOWS_UNIX) {// windows,linux,unix
					sql = "SELECT RTRIM(LTRIM(NAME)) AS COLNAME, RTRIM(LTRIM(COLTYPE)) AS COLTYPE,"
							+ "CASE WHEN COLTYPE='VARCHAR' THEN 0 WHEN COLTYPE = 'CHAR' THEN 1 "
							+ " WHEN COLTYPE = 'SMALLINT' THEN 2 WHEN COLTYPE = 'INTEGER' THEN 3 " + " WHEN COLTYPE = 'DECIMAL' THEN 4 ELSE 5 END AS COLINT "
							+ " FROM SYSIBM.SYSCOLUMNS " + " WHERE TBCREATOR='" + getSCHEMA_NAME() + "' AND TBNAME='" + getTABLE_NAME() + "' "
							+ " ORDER BY COLINT, COLNAME";
				}
			}
			Statement st = Conn.conectar().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				colNameTemp = rs.getString("COLNAME").trim().toUpperCase();
				colNames.addElement(colNameTemp);
				colTypeTemp = rs.getString("COLTYPE").trim().toUpperCase();
				colTypes.addElement(colTypeTemp);
			}
			rs.close();
			st.close();

			boolean viewAll = false;
			try {
				viewAll = new Boolean(SystemProperties.FINDER_VIEW_ALL).booleanValue();
			} catch (Throwable tInt1) {
				tInt1.getMessage();
			}

			int noVisibleColumns = 0;

			for (int i = 0; i < colNames.size(); i++) {
				colNameTemp = colNames.elementAt(i).toString();
				colTypeTemp = colTypes.elementAt(i).toString();

				if ((!viewAll && ((colNameTemp.endsWith("OID") && colTypeTemp.endsWith("BIGINT"))
						|| (colNameTemp.startsWith("TIMESTAMP") && colTypeTemp.startsWith("TIMESTMP"))))
						|| (!viewAll && ((colNameTemp.endsWith("OID") && colTypeTemp.endsWith("BIGINT"))
								|| (colNameTemp.startsWith("UTC") && colTypeTemp.startsWith("TIMESTAMP"))))

				) {
					noVisibleColumns++;
					continue;// no tomamos en cuenta los campos OIDs directos y
								// de foreign keys, y los TIMESTAMP
				}
				if (getObjectComboBoxCampo01().isVisible()) {
					getObjectComboBoxCampo01().addItem(colNameTemp);
					getObjectComboBoxCampo01().addValueForItem(colTypeTemp);
				}
				if (getObjectComboBoxCampo02().isVisible()) {
					getObjectComboBoxCampo02().addItem(colNameTemp);
					getObjectComboBoxCampo02().addValueForItem(colTypeTemp);
				}
				if (getObjectComboBoxCampo03().isVisible()) {
					getObjectComboBoxCampo03().addItem(colNameTemp);
					getObjectComboBoxCampo03().addValueForItem(colTypeTemp);
				}
				if (getObjectComboBoxCampo04().isVisible()) {
					getObjectComboBoxCampo04().addItem(colNameTemp);
					getObjectComboBoxCampo04().addValueForItem(colTypeTemp);
				}
				if (getObjectComboBoxCampo05().isVisible()) {
					getObjectComboBoxCampo05().addItem(colNameTemp);
					getObjectComboBoxCampo05().addValueForItem(colTypeTemp);
				}
			}

			int cols = Math.min(5, colNames.size() - noVisibleColumns);// menos
																		// OIDs(directos
																		// y de
																		// foreign
																		// keys)
																		// y
																		// TIMESTAMP
			for (int i = 0; i < cols; i++) {
				switch (i) {
				case 0:
					if (getObjectComboBoxCampo01().isVisible()) {
						getObjectComboBoxCampo01().deselect();// solamente al
																// selecccionar
																// la primera
																// fila
						getObjectComboBoxCampo01().setSelectedIndex(0);
					}
					break;
				case 1:
					if (getObjectComboBoxCampo02().isVisible()) {
						getObjectComboBoxCampo02().setSelectedIndex(1);
					}
					break;
				case 2:
					if (getObjectComboBoxCampo03().isVisible()) {
						getObjectComboBoxCampo03().setSelectedIndex(2);
					}
					break;
				case 3:
					if (getObjectComboBoxCampo04().isVisible()) {
						getObjectComboBoxCampo04().setSelectedIndex(3);
					}
					break;
				case 4:
					if (getObjectComboBoxCampo05().isVisible()) {
						getObjectComboBoxCampo05().setSelectedIndex(4);
					}
					break;
				default:
					if (getObjectComboBoxCampo01().isVisible()) {
						getObjectComboBoxCampo01().setSelectedIndex(0);
					}
				}
			}
			try {
				getObjectComboBoxCampo01().setSelectedItem(getSelectedCampo01());
			} catch (Throwable t1) {
				t1.getMessage();
			}
			try {
				getObjectComboBoxCampo02().setSelectedItem(getSelectedCampo02());
			} catch (Throwable t1) {
				t1.getMessage();
			}
		} catch (Throwable t) {
			ExceptionManager.singleton().manage(this, true, this, t);
		}
	}

	/**
	 * Initializes connections
	 * 
	 * @exception java.lang.Exception
	 *                The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getJButtonReset().addActionListener(this);
		getJButtonReset().addMouseListener(this);
		getTextFieldExtValor01().addTextFieldExtListener(this);
		getObjectComboBoxCampo01().addPropertyChangeListener(this);
		getObjectComboBoxCampo02().addPropertyChangeListener(this);
		getObjectComboBoxCampo03().addPropertyChangeListener(this);
		getObjectComboBoxCampo04().addPropertyChangeListener(this);
		getObjectComboBoxCampo05().addPropertyChangeListener(this);
		getTextFieldExtValor02().addTextFieldExtListener(this);
		getTextFieldExtValor03().addTextFieldExtListener(this);
		getTextFieldExtValor04().addTextFieldExtListener(this);
		getTextFieldExtValor05().addTextFieldExtListener(this);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			operacionesSQL.addElement("LIKE");
			operacionesSQL.addElement("=");
			operacionesSQL.addElement("<>");
			operacionesSQL.addElement("<");
			operacionesSQL.addElement("<=");
			operacionesSQL.addElement(">");
			operacionesSQL.addElement(">=");
			operacionesSQL.addElement("IS NULL");
			operacionesSQL.addElement("IS NOT NULL");
			operacionesSQL.addElement("IN");
			operacionesSQL.addElement("NOT IN");
			// user code end
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.weighty = 1.0D;
			gridBagConstraints.gridy = 0;
			setName("FinderSQLPanel");
			setLayout(new java.awt.GridBagLayout());
			setSize(535, 180);
			this.add(getTitledPanel(), gridBagConstraints);
			/*
			 * this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
			 * createMatteBorder(1, 1, 1, 1, Color.gray),
			 * "Criterios de búsqueda", TitledBorder.LEADING, TitledBorder.TOP,
			 * new Font("Arial", Font.PLAIN, 8), new Color(0, 64, 168)));
			 */
			initConnections();
			connEtoC2();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}

	private void initValueFields() {
		getComboTIPOValor01().setVisible(false);
		getTextDateValor01().setVisible(false);
		getComboTIPOValor02().setVisible(false);
		getTextDateValor02().setVisible(false);
		getComboTIPOValor03().setVisible(false);
		getTextDateValor03().setVisible(false);
		getComboTIPOValor04().setVisible(false);
		getTextDateValor04().setVisible(false);
		getComboTIPOValor05().setVisible(false);
		getTextDateValor05().setVisible(false);

		this.limpiarCriterios();
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.awt.event.KeyEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void keyReleased(java.awt.event.KeyEvent newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	private void limpiarCriterios() {

		getTextFieldExtValor01().setValue("");
		getTextDateValor01().setValue(null);
		getComboTIPOValor01().deselect();

		getTextFieldExtValor02().setValue("");
		getTextDateValor02().setValue(null);
		getComboTIPOValor02().deselect();

		getTextFieldExtValor03().setValue("");
		getTextDateValor03().setValue(null);
		getComboTIPOValor03().deselect();

		getTextFieldExtValor04().setValue("");
		getTextDateValor04().setValue(null);
		getComboTIPOValor04().deselect();

		getTextFieldExtValor05().setValue("");
		getTextDateValor05().setValue(null);
		getComboTIPOValor05().deselect();
	}

	private void manageActionPerformedOnTextFields() {
		if (getaDataTablePanel() != null)
			getaDataTablePanel().forceFireBuscarPerformed();
	}

	private void manageCamposCount() {
		// ...
		getObjectComboBoxCampo05().setVisible(true);
		getObjectComboBoxOperador05().setVisible(true);
		getTextFieldExtValor05().setVisible(true);
		getComboTIPOValor05().setVisible(false);
		getTextDateValor05().setVisible(false);
		getObjectComboBoxCampo04().setVisible(true);
		getObjectComboBoxOperador04().setVisible(true);
		getTextFieldExtValor04().setVisible(true);
		getComboTIPOValor04().setVisible(false);
		getTextDateValor04().setVisible(false);
		getObjectComboBoxCampo03().setVisible(true);
		getObjectComboBoxOperador03().setVisible(true);
		getTextFieldExtValor03().setVisible(true);
		getComboTIPOValor03().setVisible(false);
		getTextDateValor03().setVisible(false);
		getObjectComboBoxCampo02().setVisible(true);
		getObjectComboBoxOperador02().setVisible(true);
		getTextFieldExtValor02().setVisible(true);
		getComboTIPOValor02().setVisible(false);
		getTextDateValor02().setVisible(false);
		// ...
		if (this.getCamposCount() < 5) {
			getObjectComboBoxCampo05().setVisible(false);
			getObjectComboBoxOperador05().setVisible(false);
			getTextFieldExtValor05().setVisible(false);
			getComboTIPOValor05().setVisible(false);
			getTextDateValor05().setVisible(false);
		}
		if (this.getCamposCount() < 4) {
			getObjectComboBoxCampo04().setVisible(false);
			getObjectComboBoxOperador04().setVisible(false);
			getTextFieldExtValor04().setVisible(false);
			getComboTIPOValor04().setVisible(false);
			getTextDateValor04().setVisible(false);
		}
		if (this.getCamposCount() < 3) {
			getObjectComboBoxCampo03().setVisible(false);
			getObjectComboBoxOperador03().setVisible(false);
			getTextFieldExtValor03().setVisible(false);
			getComboTIPOValor03().setVisible(false);
			getTextDateValor03().setVisible(false);
		}
		if (this.getCamposCount() < 2) {
			getObjectComboBoxCampo02().setVisible(false);
			getObjectComboBoxOperador02().setVisible(false);
			getTextFieldExtValor02().setVisible(false);
			getComboTIPOValor02().setVisible(false);
			getTextDateValor02().setVisible(false);
		}
	}

	private void manageMouseOver(boolean over) {
		if (over)
			this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		else
			this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButtonReset())
			connEtoC8(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseExited(java.awt.event.MouseEvent e) {
		// user code begin {1}
		// user code end
		if (e.getSource() == getJButtonReset())
			connEtoC9(e);
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mousePressed(java.awt.event.MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the MouseListener interface.
	 * 
	 * @param e
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the PropertyChangeListener interface.
	 * 
	 * @param evt
	 *            java.beans.PropertyChangeEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		// user code begin {1}
		// user code end
		if (evt.getSource() == getObjectComboBoxCampo01() && (evt.getPropertyName().equals("selectedItem")))
			connEtoC1(evt);
		if (evt.getSource() == getObjectComboBoxCampo02() && (evt.getPropertyName().equals("selectedItem")))
			connEtoC3(evt);
		if (evt.getSource() == getObjectComboBoxCampo03() && (evt.getPropertyName().equals("selectedItem")))
			connEtoC4(evt);
		if (evt.getSource() == getObjectComboBoxCampo04() && (evt.getPropertyName().equals("selectedItem")))
			connEtoC5(evt);
		if (evt.getSource() == getObjectComboBoxCampo05() && (evt.getPropertyName().equals("selectedItem")))
			connEtoC6(evt);
		// user code begin {2}
		// user code end
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
	 * Insert the method's description here. Creation date: (14-Sep-2003
	 * 18:16:24 PM)
	 * 
	 * @param new_TABLA_GENERAL__SI_NO_Columns
	 *            java.lang.String[]
	 */
	public void set_TABLA_GENERAL__SI_NO_Columns(java.lang.String[] new_TABLA_GENERAL__SI_NO_Columns) {
		_TABLA_GENERAL__SI_NO_Columns = new_TABLA_GENERAL__SI_NO_Columns;
	}

	private void setaDataTablePanel(DataTablePanel newValue) {
		if (ivjaDataTablePanel != newValue) {
			try {
				efren.util.gui.table.DataTablePanel oldValue = getaDataTablePanel();
				ivjaDataTablePanel = newValue;
				firePropertyChange("stContainerPanel", oldValue, newValue);
				// user code begin {1}
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
	 * Sets the camposCount property (int) value.
	 * 
	 * @param camposCount
	 *            The new value for the property.
	 * @see #getCamposCount
	 */
	public void setCamposCount(int camposCount) {

		int cc = camposCount;

		if (cc < 1)
			cc = 1;
		if (cc > 5)
			cc = 5;

		int oldValue = fieldCamposCount;
		fieldCamposCount = cc;
		firePropertyChange("camposCount", new Integer(oldValue), new Integer(cc));

		this.manageCamposCount();
	}

	/**
	 * Sets the SCHEMA_NAME property (java.lang.String) value.
	 * 
	 * @param SCHEMA_NAME
	 *            The new value for the property.
	 * @see #getSCHEMA_NAME
	 */
	public void setSCHEMA_NAME(java.lang.String SCHEMA_NAME) {
		String oldValue = fieldSCHEMA_NAME;
		fieldSCHEMA_NAME = SCHEMA_NAME;
		firePropertyChange("SCHEMA_NAME", oldValue, SCHEMA_NAME);
	}

	/**
	 * Method generated to support the promotion of the stContainerPanel
	 * attribute.
	 * 
	 * @param arg1
	 *            efren.abm.beans.DataTablePanel
	 */
	public void setDataTablePanel(DataTablePanel arg1) {
		setaDataTablePanel(arg1);
	}

	/**
	 * Sets the TABLE_NAME property (java.lang.String) value.
	 * 
	 * @param TABLE_NAME
	 *            The new value for the property.
	 * @see #getTABLE_NAME
	 */
	public void setTABLE_NAME(java.lang.String TABLE_NAME) {
		String oldValue = fieldTABLE_NAME;
		fieldTABLE_NAME = TABLE_NAME;
		firePropertyChange("TABLE_NAME", oldValue, TABLE_NAME);
	}

	/**
	 * 
	 * @return
	 */
	public String sql() {
		return this.sql("");
	}

	/**
	 * 
	 * @param arg
	 * @return
	 */
	public String sql(String arg) {

		String alias = "";
		if (arg != null) {
			alias = arg.trim();
		}

		String sql = "";
		String op, colType;
		boolean sqlIniciado = false;

		// 1
		if (getObjectComboBoxCampo01().isVisible() && getObjectComboBoxCampo01().getSelectedItem() != null
				&& getObjectComboBoxOperador01().getSelectedItem() != null) {

			if (getTextFieldExtValor01().isVisible() && !getTextFieldExtValor01().esNulo()) {// TextFieldExt

				if (sqlIniciado)
					sql = sql + " AND ";

				// op =
				// getObjectComboBoxOperador01().getSelectedItem().toString().trim();
				op = this.operacionesSQL.get(getObjectComboBoxOperador01().getSelectedIndex()).toString().trim();
				colType = getObjectComboBoxCampo01().getSelectedValueItem().toString().trim();

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR"))
					sql = sql + " RTRIM(LTRIM(UCASE(" + alias + getObjectComboBoxCampo01().getSelectedItem() + "))) " + op + " ";
				else
					sql = sql + alias + getObjectComboBoxCampo01().getSelectedItem() + " " + op + " ";

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR")) {
					sql = sql + "'" + StringTools.parseComilla(getTextFieldExtValor01().getValue().trim().toUpperCase().replace('*', '%'));
					if (op.startsWith("LIKE"))
						sql = sql + "%";
					sql = sql + "' ";
				} else
					sql = sql + getTextFieldExtValor01().getValue().trim() + " ";
				sqlIniciado = true;
			} else {
				if (getComboTIPOValor01().isVisible() && getComboTIPOValor01().getSelectedItem() != null) {// ComboTIPO

					if (sqlIniciado)
						sql = sql + " AND ";

					// op =
					// getObjectComboBoxOperador01().getSelectedItem().toString().trim();
					op = this.operacionesSQL.get(getObjectComboBoxOperador01().getSelectedIndex()).toString().trim();
					sql = sql + alias + getObjectComboBoxCampo01().getSelectedItem() + " " + op + " ";

					sql = sql + getComboTIPOValor01().SQLText() + " ";
					sqlIniciado = true;
				} else {
					if (getTextDateValor01().isVisible() && !getTextDateValor01().esNulo()) {// TextDate

						if (sqlIniciado)
							sql = sql + " AND ";

						// op =
						// getObjectComboBoxOperador01().getSelectedItem().toString().trim();
						op = this.operacionesSQL.get(getObjectComboBoxOperador01().getSelectedIndex()).toString().trim();
						sql = sql + alias + getObjectComboBoxCampo01().getSelectedItem() + " " + op + " ";

						sql = sql + getTextDateValor01().SQLText() + " ";
						sqlIniciado = true;
					}
				}
			}
		}
		// 2
		if (getObjectComboBoxCampo02().isVisible() && getObjectComboBoxCampo02().getSelectedItem() != null
				&& getObjectComboBoxOperador02().getSelectedItem() != null) {

			if (getTextFieldExtValor02().isVisible() && !getTextFieldExtValor02().esNulo()) {// TextFieldExt

				if (sqlIniciado)
					sql = sql + " AND ";

				// op =
				// getObjectComboBoxOperador02().getSelectedItem().toString().trim();
				op = this.operacionesSQL.get(getObjectComboBoxOperador02().getSelectedIndex()).toString().trim();
				colType = getObjectComboBoxCampo02().getSelectedValueItem().toString().trim();

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR"))
					sql = sql + " RTRIM(LTRIM(UCASE(" + alias + getObjectComboBoxCampo02().getSelectedItem() + "))) " + op + " ";
				else
					sql = sql + alias + getObjectComboBoxCampo02().getSelectedItem() + " " + op + " ";

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR")) {
					sql = sql + "'" + StringTools.parseComilla(getTextFieldExtValor02().getValue().trim().toUpperCase().replace('*', '%'));
					if (op.startsWith("LIKE"))
						sql = sql + "%";
					sql = sql + "' ";
				} else
					sql = sql + getTextFieldExtValor02().getValue().trim() + " ";
				sqlIniciado = true;
			} else {
				if (getComboTIPOValor02().isVisible() && getComboTIPOValor02().getSelectedItem() != null) {// ComboTIPO

					if (sqlIniciado)
						sql = sql + " AND ";

					// op =
					// getObjectComboBoxOperador02().getSelectedItem().toString().trim();
					op = this.operacionesSQL.get(getObjectComboBoxOperador02().getSelectedIndex()).toString().trim();
					sql = sql + alias + getObjectComboBoxCampo02().getSelectedItem() + " " + op + " ";

					sql = sql + getComboTIPOValor02().SQLText() + " ";
					sqlIniciado = true;
				} else {
					if (getTextDateValor02().isVisible() && !getTextDateValor02().esNulo()) {// TextDate

						if (sqlIniciado)
							sql = sql + " AND ";

						// op =
						// getObjectComboBoxOperador02().getSelectedItem().toString().trim();
						op = this.operacionesSQL.get(getObjectComboBoxOperador02().getSelectedIndex()).toString().trim();
						sql = sql + alias + getObjectComboBoxCampo02().getSelectedItem() + " " + op + " ";

						sql = sql + getTextDateValor02().SQLText() + " ";
						sqlIniciado = true;
					}
				}
			}
		}
		// 3
		if (getObjectComboBoxCampo03().isVisible() && getObjectComboBoxCampo03().getSelectedItem() != null
				&& getObjectComboBoxOperador03().getSelectedItem() != null) {

			if (getTextFieldExtValor03().isVisible() && !getTextFieldExtValor03().esNulo()) {// TextFieldExt

				if (sqlIniciado)
					sql = sql + " AND ";

				// op =
				// getObjectComboBoxOperador03().getSelectedItem().toString().trim();
				op = this.operacionesSQL.get(getObjectComboBoxOperador03().getSelectedIndex()).toString().trim();
				colType = getObjectComboBoxCampo03().getSelectedValueItem().toString().trim();

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR"))
					sql = sql + " RTRIM(LTRIM(UCASE(" + alias + getObjectComboBoxCampo03().getSelectedItem() + "))) " + op + " ";
				else
					sql = sql + alias + getObjectComboBoxCampo03().getSelectedItem() + " " + op + " ";

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR")) {
					sql = sql + "'" + StringTools.parseComilla(getTextFieldExtValor03().getValue().trim().toUpperCase().replace('*', '%'));
					if (op.startsWith("LIKE"))
						sql = sql + "%";
					sql = sql + "' ";
				} else
					sql = sql + getTextFieldExtValor03().getValue().trim() + " ";
				sqlIniciado = true;
			} else {
				if (getComboTIPOValor03().isVisible() && getComboTIPOValor03().getSelectedItem() != null) {// ComboTIPO

					if (sqlIniciado)
						sql = sql + " AND ";

					// op =
					// getObjectComboBoxOperador03().getSelectedItem().toString().trim();
					op = this.operacionesSQL.get(getObjectComboBoxOperador03().getSelectedIndex()).toString().trim();
					sql = sql + alias + getObjectComboBoxCampo03().getSelectedItem() + " " + op + " ";

					sql = sql + getComboTIPOValor03().SQLText() + " ";
					sqlIniciado = true;
				} else {
					if (getTextDateValor03().isVisible() && !getTextDateValor03().esNulo()) {// TextDate

						if (sqlIniciado)
							sql = sql + " AND ";

						// op =
						// getObjectComboBoxOperador03().getSelectedItem().toString().trim();
						op = this.operacionesSQL.get(getObjectComboBoxOperador03().getSelectedIndex()).toString().trim();
						sql = sql + alias + getObjectComboBoxCampo03().getSelectedItem() + " " + op + " ";

						sql = sql + getTextDateValor03().SQLText() + " ";
						sqlIniciado = true;
					}
				}
			}
		}
		// 4
		if (getObjectComboBoxCampo04().isVisible() && getObjectComboBoxCampo04().getSelectedItem() != null
				&& getObjectComboBoxOperador04().getSelectedItem() != null) {

			if (getTextFieldExtValor04().isVisible() && !getTextFieldExtValor04().esNulo()) {// TextFieldExt

				if (sqlIniciado)
					sql = sql + " AND ";

				// op =
				// getObjectComboBoxOperador04().getSelectedItem().toString().trim();
				op = this.operacionesSQL.get(getObjectComboBoxOperador04().getSelectedIndex()).toString().trim();
				colType = getObjectComboBoxCampo04().getSelectedValueItem().toString().trim();

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR"))
					sql = sql + " RTRIM(LTRIM(UCASE(" + alias + getObjectComboBoxCampo04().getSelectedItem() + "))) " + op + " ";
				else
					sql = sql + alias + getObjectComboBoxCampo04().getSelectedItem() + " " + op + " ";

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR")) {
					sql = sql + "'" + StringTools.parseComilla(getTextFieldExtValor04().getValue().trim().toUpperCase().replace('*', '%'));
					if (op.startsWith("LIKE"))
						sql = sql + "%";
					sql = sql + "' ";
				} else
					sql = sql + getTextFieldExtValor04().getValue().trim() + " ";
				sqlIniciado = true;
			} else {
				if (getComboTIPOValor04().isVisible() && getComboTIPOValor04().getSelectedItem() != null) {// ComboTIPO

					if (sqlIniciado)
						sql = sql + " AND ";

					// op =
					// getObjectComboBoxOperador04().getSelectedItem().toString().trim();
					op = this.operacionesSQL.get(getObjectComboBoxOperador04().getSelectedIndex()).toString().trim();
					sql = sql + alias + getObjectComboBoxCampo04().getSelectedItem() + " " + op + " ";

					sql = sql + getComboTIPOValor04().SQLText() + " ";
					sqlIniciado = true;
				} else {
					if (getTextDateValor04().isVisible() && !getTextDateValor04().esNulo()) {// TextDate

						if (sqlIniciado)
							sql = sql + " AND ";

						// op =
						// getObjectComboBoxOperador04().getSelectedItem().toString().trim();
						op = this.operacionesSQL.get(getObjectComboBoxOperador04().getSelectedIndex()).toString().trim();
						sql = sql + alias + getObjectComboBoxCampo04().getSelectedItem() + " " + op + " ";

						sql = sql + getTextDateValor04().SQLText() + " ";
						sqlIniciado = true;
					}
				}
			}
		}
		// 5
		if (getObjectComboBoxCampo05().isVisible() && getObjectComboBoxCampo05().getSelectedItem() != null
				&& getObjectComboBoxOperador05().getSelectedItem() != null) {

			if (getTextFieldExtValor05().isVisible() && !getTextFieldExtValor05().esNulo()) {// TextFieldExt

				if (sqlIniciado)
					sql = sql + " AND ";

				// op =
				// getObjectComboBoxOperador05().getSelectedItem().toString().trim();
				op = this.operacionesSQL.get(getObjectComboBoxOperador05().getSelectedIndex()).toString().trim();
				colType = getObjectComboBoxCampo05().getSelectedValueItem().toString().trim();

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR"))
					sql = sql + " RTRIM(LTRIM(UCASE(" + alias + getObjectComboBoxCampo05().getSelectedItem() + "))) " + op + " ";
				else
					sql = sql + alias + getObjectComboBoxCampo05().getSelectedItem() + " " + op + " ";

				if (colType.startsWith("CHAR") || colType.startsWith("VARCHAR")) {
					sql = sql + "'" + StringTools.parseComilla(getTextFieldExtValor05().getValue().trim().toUpperCase().replace('*', '%'));
					if (op.startsWith("LIKE"))
						sql = sql + "%";
					sql = sql + "' ";
				} else
					sql = sql + getTextFieldExtValor05().getValue().trim() + " ";
				sqlIniciado = true;
			} else {
				if (getComboTIPOValor05().isVisible() && getComboTIPOValor05().getSelectedItem() != null) {// ComboTIPO

					if (sqlIniciado)
						sql = sql + " AND ";

					// op =
					// getObjectComboBoxOperador05().getSelectedItem().toString().trim();
					op = this.operacionesSQL.get(getObjectComboBoxOperador05().getSelectedIndex()).toString().trim();
					sql = sql + alias + getObjectComboBoxCampo05().getSelectedItem() + " " + op + " ";

					sql = sql + getComboTIPOValor05().SQLText() + " ";
					sqlIniciado = true;
				} else {
					if (getTextDateValor05().isVisible() && !getTextDateValor05().esNulo()) {// TextDate

						if (sqlIniciado)
							sql = sql + " AND ";

						// op =
						// getObjectComboBoxOperador05().getSelectedItem().toString().trim();
						op = this.operacionesSQL.get(getObjectComboBoxOperador05().getSelectedIndex()).toString().trim();
						sql = sql + alias + getObjectComboBoxCampo05().getSelectedItem() + " " + op + " ";

						sql = sql + getTextDateValor05().SQLText() + " ";
						sqlIniciado = true;
					}
				}
			}
		}

		return sql;
	}

	public String argsDescription() {

		String argsDescription = "";
		boolean iniciado = false;

		// 1
		if (getObjectComboBoxCampo01().isVisible() && getObjectComboBoxCampo01().getSelectedItem() != null
				&& getObjectComboBoxOperador01().getSelectedItem() != null) {

			if (getTextFieldExtValor01().isVisible() && !getTextFieldExtValor01().esNulo()) {// TextFieldExt

				if (iniciado)
					argsDescription = argsDescription + "; ";

				argsDescription = argsDescription + getObjectComboBoxCampo01().getSelectedItem() + ": "
						+ getTextFieldExtValor01().getValue().trim().toUpperCase();
			}
		}
		// 2
		if (getObjectComboBoxCampo02().isVisible() && getObjectComboBoxCampo02().getSelectedItem() != null
				&& getObjectComboBoxOperador02().getSelectedItem() != null) {

			if (getTextFieldExtValor02().isVisible() && !getTextFieldExtValor02().esNulo()) {// TextFieldExt

				if (iniciado)
					argsDescription = argsDescription + "; ";

				argsDescription = argsDescription + getObjectComboBoxCampo02().getSelectedItem() + ": "
						+ getTextFieldExtValor02().getValue().trim().toUpperCase();
			}
		}
		// 3
		if (getObjectComboBoxCampo03().isVisible() && getObjectComboBoxCampo03().getSelectedItem() != null
				&& getObjectComboBoxOperador03().getSelectedItem() != null) {

			if (getTextFieldExtValor03().isVisible() && !getTextFieldExtValor03().esNulo()) {// TextFieldExt

				if (iniciado)
					argsDescription = argsDescription + "; ";

				argsDescription = argsDescription + getObjectComboBoxCampo03().getSelectedItem() + ": "
						+ getTextFieldExtValor03().getValue().trim().toUpperCase();
			}
		}
		// 4
		if (getObjectComboBoxCampo04().isVisible() && getObjectComboBoxCampo04().getSelectedItem() != null
				&& getObjectComboBoxOperador04().getSelectedItem() != null) {

			if (getTextFieldExtValor04().isVisible() && !getTextFieldExtValor04().esNulo()) {// TextFieldExt

				if (iniciado)
					argsDescription = argsDescription + "; ";

				argsDescription = argsDescription + getObjectComboBoxCampo04().getSelectedItem() + ": "
						+ getTextFieldExtValor04().getValue().trim().toUpperCase();
			}
		}
		// 5
		if (getObjectComboBoxCampo05().isVisible() && getObjectComboBoxCampo05().getSelectedItem() != null
				&& getObjectComboBoxOperador05().getSelectedItem() != null) {

			if (getTextFieldExtValor05().isVisible() && !getTextFieldExtValor05().esNulo()) {// TextFieldExt

				if (iniciado)
					argsDescription = argsDescription + "; ";

				argsDescription = argsDescription + getObjectComboBoxCampo05().getSelectedItem() + ": "
						+ getTextFieldExtValor05().getValue().trim().toUpperCase();
			}
		}

		return argsDescription;
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textDateMouseClicked(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	/**
	 * Method to handle events for the TextFieldExtListener interface.
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public void textFieldExtkeyReleased(java.util.EventObject newEvent) {
		// user code begin {1}
		// user code end
		// user code begin {2}
		// user code end
	}

	private void visualManageComboCampo01() {

		if (getObjectComboBoxCampo01().getSelectedIndex() < 0)
			return;

		String colType = getObjectComboBoxCampo01().getSelectedValueItem().toString();

		boolean textVisible = true, comboVisible = false, dateVisible = false;

		if (colType.compareTo("DATE") == 0) { // fechas
			textVisible = false;
			comboVisible = false;
			dateVisible = true;
			getObjectComboBoxOperador01().setSelectedIndex(4); // el operador
																// tiene que ser
																// '<='
		} else {
			if (colType.startsWith("INT") || colType.startsWith("SMALLINT") || colType.startsWith("BIGINT")) { // los
																												// que
																												// son
																												// llevados
																												// con
																												// ComboTIPO
				String item = getObjectComboBoxCampo01().getSelectedItem().toString();
				boolean si_no_tipo = false;
				if (get_TABLA_GENERAL__SI_NO_Columns() != null && get_TABLA_GENERAL__SI_NO_Columns().length > 0) {
					String si_no_col;
					for (int i = 0; i < get_TABLA_GENERAL__SI_NO_Columns().length; i++) {
						si_no_col = get_TABLA_GENERAL__SI_NO_Columns()[i];
						if (si_no_col.compareTo(item) == 0)
							si_no_tipo = true;
					}
				}
				if (si_no_tipo) {
					getComboTIPOValor01().setTABLE_NAME("_TABLA_GENERAL");
					getComboTIPOValor01().setCOLUMN_NAME("_SI_NO");
				} else {
					getComboTIPOValor01().setTABLE_NAME(this.getTABLE_NAME());
					getComboTIPOValor01().setCOLUMN_NAME(item);
				}
				try {
					if (getComboTIPOValor01().initCombo()) {
						textVisible = false;
						comboVisible = true;
						dateVisible = false;
						getObjectComboBoxOperador01().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					} else {
						getTextFieldExtValor01().setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
						getTextFieldExtValor01().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
						getTextFieldExtValor01().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
						textVisible = true;
						comboVisible = false;
						dateVisible = false;
						getObjectComboBoxOperador01().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			} else {
				if (colType.startsWith("DECIMAL") || colType.startsWith("FLOAT") || colType.startsWith("DOUBLE") || colType.startsWith("NUMERIC")) { // monedas
																																						// y
																																						// numeros
																																						// con
																																						// decimales

					getTextFieldExtValor01().setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
					getTextFieldExtValor01().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
					getTextFieldExtValor01().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
				} else {
					getTextFieldExtValor01().setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
					getTextFieldExtValor01().setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
					getTextFieldExtValor01().setHorizontalAlignment(javax.swing.JTextField.LEFT);
				}
				// para todos los demas casos mostramos el TextFieldExt
				textVisible = true;
				comboVisible = false;
				dateVisible = false;
				getObjectComboBoxOperador01().setSelectedIndex(0); // el
																	// operador
																	// tiene que
																	// ser
																	// 'LIKE'
			}
		}

		getTextFieldExtValor01().setVisible(textVisible);
		getComboTIPOValor01().setVisible(comboVisible);
		getTextDateValor01().setVisible(dateVisible);
	}

	private void visualManageComboCampo02() {

		if (getObjectComboBoxCampo02().getSelectedIndex() < 0)
			return;

		String colType = getObjectComboBoxCampo02().getSelectedValueItem().toString();

		boolean textVisible = true, comboVisible = false, dateVisible = false;

		if (colType.compareTo("DATE") == 0) { // fechas
			textVisible = false;
			comboVisible = false;
			dateVisible = true;
			getObjectComboBoxOperador02().setSelectedIndex(4); // el operador
																// tiene que ser
																// '<='
		} else {
			if (colType.startsWith("INT") || colType.startsWith("SMALLINT") || colType.startsWith("BIGINT")) { // los
																												// que
																												// son
																												// llevados
																												// con
																												// ComboTIPO
				String item = getObjectComboBoxCampo02().getSelectedItem().toString();
				boolean si_no_tipo = false;
				if (get_TABLA_GENERAL__SI_NO_Columns() != null && get_TABLA_GENERAL__SI_NO_Columns().length > 0) {
					String si_no_col;
					for (int i = 0; i < get_TABLA_GENERAL__SI_NO_Columns().length; i++) {
						si_no_col = get_TABLA_GENERAL__SI_NO_Columns()[i];
						if (si_no_col.compareTo(item) == 0)
							si_no_tipo = true;
					}
				}
				if (si_no_tipo) {
					getComboTIPOValor02().setTABLE_NAME("_TABLA_GENERAL");
					getComboTIPOValor02().setCOLUMN_NAME("_SI_NO");
				} else {
					getComboTIPOValor02().setTABLE_NAME(this.getTABLE_NAME());
					getComboTIPOValor02().setCOLUMN_NAME(item);
				}
				try {
					if (getComboTIPOValor02().initCombo()) {
						textVisible = false;
						comboVisible = true;
						dateVisible = false;
						getObjectComboBoxOperador02().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					} else {
						getTextFieldExtValor02().setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
						getTextFieldExtValor02().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
						getTextFieldExtValor02().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
						textVisible = true;
						comboVisible = false;
						dateVisible = false;
						getObjectComboBoxOperador02().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			} else {
				if (colType.startsWith("DECIMAL") || colType.startsWith("FLOAT") || colType.startsWith("DOUBLE") || colType.startsWith("NUMERIC")) { // monedas
																																						// y
																																						// numeros
																																						// con
																																						// decimales

					getTextFieldExtValor02().setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
					getTextFieldExtValor02().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
					getTextFieldExtValor02().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
				} else {
					getTextFieldExtValor02().setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
					getTextFieldExtValor02().setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
					getTextFieldExtValor02().setHorizontalAlignment(javax.swing.JTextField.LEFT);
				}
				// para todos los demas casos mostramos el TextFieldExt
				textVisible = true;
				comboVisible = false;
				dateVisible = false;
				getObjectComboBoxOperador02().setSelectedIndex(0); // el
																	// operador
																	// tiene que
																	// ser
																	// 'LIKE'
			}
		}

		getTextFieldExtValor02().setVisible(textVisible);
		getComboTIPOValor02().setVisible(comboVisible);
		getTextDateValor02().setVisible(dateVisible);
	}

	private void visualManageComboCampo03() {

		if (getObjectComboBoxCampo03().getSelectedIndex() < 0)
			return;

		String colType = getObjectComboBoxCampo03().getSelectedValueItem().toString();

		boolean textVisible = true, comboVisible = false, dateVisible = false;

		if (colType.compareTo("DATE") == 0) { // fechas
			textVisible = false;
			comboVisible = false;
			dateVisible = true;
			getObjectComboBoxOperador03().setSelectedIndex(4); // el operador
																// tiene que ser
																// '<='
		} else {
			if (colType.startsWith("INT") || colType.startsWith("SMALLINT") || colType.startsWith("BIGINT")) { // los
																												// que
																												// son
																												// llevados
																												// con
																												// ComboTIPO
				String item = getObjectComboBoxCampo03().getSelectedItem().toString();
				boolean si_no_tipo = false;
				if (get_TABLA_GENERAL__SI_NO_Columns() != null && get_TABLA_GENERAL__SI_NO_Columns().length > 0) {
					String si_no_col;
					for (int i = 0; i < get_TABLA_GENERAL__SI_NO_Columns().length; i++) {
						si_no_col = get_TABLA_GENERAL__SI_NO_Columns()[i];
						if (si_no_col.compareTo(item) == 0)
							si_no_tipo = true;
					}
				}
				if (si_no_tipo) {
					getComboTIPOValor03().setTABLE_NAME("_TABLA_GENERAL");
					getComboTIPOValor03().setCOLUMN_NAME("_SI_NO");
				} else {
					getComboTIPOValor03().setTABLE_NAME(this.getTABLE_NAME());
					getComboTIPOValor03().setCOLUMN_NAME(item);
				}
				try {
					if (getComboTIPOValor03().initCombo()) {
						textVisible = false;
						comboVisible = true;
						dateVisible = false;
						getObjectComboBoxOperador03().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					} else {
						getTextFieldExtValor03().setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
						getTextFieldExtValor03().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
						getTextFieldExtValor03().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
						textVisible = true;
						comboVisible = false;
						dateVisible = false;
						getObjectComboBoxOperador03().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			} else {
				if (colType.startsWith("DECIMAL") || colType.startsWith("FLOAT") || colType.startsWith("DOUBLE") || colType.startsWith("NUMERIC")) { // monedas
																																						// y
																																						// numeros
																																						// con
																																						// decimales

					getTextFieldExtValor03().setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
					getTextFieldExtValor03().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
					getTextFieldExtValor03().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
				} else {
					getTextFieldExtValor03().setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
					getTextFieldExtValor03().setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
					getTextFieldExtValor03().setHorizontalAlignment(javax.swing.JTextField.LEFT);
				}
				// para todos los demas casos mostramos el TextFieldExt
				textVisible = true;
				comboVisible = false;
				dateVisible = false;
				getObjectComboBoxOperador03().setSelectedIndex(0); // el
																	// operador
																	// tiene que
																	// ser
																	// 'LIKE'
			}
		}

		getTextFieldExtValor03().setVisible(textVisible);
		getComboTIPOValor03().setVisible(comboVisible);
		getTextDateValor03().setVisible(dateVisible);
	}

	private void visualManageComboCampo04() {

		if (getObjectComboBoxCampo04().getSelectedIndex() < 0)
			return;

		String colType = getObjectComboBoxCampo04().getSelectedValueItem().toString();

		boolean textVisible = true, comboVisible = false, dateVisible = false;

		if (colType.compareTo("DATE") == 0) { // fechas
			textVisible = false;
			comboVisible = false;
			dateVisible = true;
			getObjectComboBoxOperador04().setSelectedIndex(4); // el operador
																// tiene que ser
																// '<='
		} else {
			if (colType.startsWith("INT") || colType.startsWith("SMALLINT") || colType.startsWith("BIGINT")) { // los
																												// que
																												// son
																												// llevados
																												// con
																												// ComboTIPO
				String item = getObjectComboBoxCampo04().getSelectedItem().toString();
				boolean si_no_tipo = false;
				if (get_TABLA_GENERAL__SI_NO_Columns() != null && get_TABLA_GENERAL__SI_NO_Columns().length > 0) {
					String si_no_col;
					for (int i = 0; i < get_TABLA_GENERAL__SI_NO_Columns().length; i++) {
						si_no_col = get_TABLA_GENERAL__SI_NO_Columns()[i];
						if (si_no_col.compareTo(item) == 0)
							si_no_tipo = true;
					}
				}
				if (si_no_tipo) {
					getComboTIPOValor04().setTABLE_NAME("_TABLA_GENERAL");
					getComboTIPOValor04().setCOLUMN_NAME("_SI_NO");
				} else {
					getComboTIPOValor04().setTABLE_NAME(this.getTABLE_NAME());
					getComboTIPOValor04().setCOLUMN_NAME(item);
				}
				try {
					if (getComboTIPOValor04().initCombo()) {
						textVisible = false;
						comboVisible = true;
						dateVisible = false;
						getObjectComboBoxOperador04().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					} else {
						getTextFieldExtValor04().setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
						getTextFieldExtValor04().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
						getTextFieldExtValor04().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
						textVisible = true;
						comboVisible = false;
						dateVisible = false;
						getObjectComboBoxOperador04().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			} else {
				if (colType.startsWith("DECIMAL") || colType.startsWith("FLOAT") || colType.startsWith("DOUBLE") || colType.startsWith("NUMERIC")) { // monedas
																																						// y
																																						// numeros
																																						// con
																																						// decimales

					getTextFieldExtValor04().setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
					getTextFieldExtValor04().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
					getTextFieldExtValor04().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
				} else {
					getTextFieldExtValor04().setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
					getTextFieldExtValor04().setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
					getTextFieldExtValor04().setHorizontalAlignment(javax.swing.JTextField.LEFT);
				}
				// para todos los demas casos mostramos el TextFieldExt
				textVisible = true;
				comboVisible = false;
				dateVisible = false;
				getObjectComboBoxOperador04().setSelectedIndex(0); // el
																	// operador
																	// tiene que
																	// ser
																	// 'LIKE'
			}
		}

		getTextFieldExtValor04().setVisible(textVisible);
		getComboTIPOValor04().setVisible(comboVisible);
		getTextDateValor04().setVisible(dateVisible);
	}

	private void visualManageComboCampo05() {

		if (getObjectComboBoxCampo05().getSelectedIndex() < 0)
			return;

		String colType = getObjectComboBoxCampo05().getSelectedValueItem().toString();

		boolean textVisible = true, comboVisible = false, dateVisible = false;

		if (colType.compareTo("DATE") == 0) { // fechas
			textVisible = false;
			comboVisible = false;
			dateVisible = true;
			getObjectComboBoxOperador05().setSelectedIndex(4); // el operador
																// tiene que ser
																// '<='
		} else {
			if (colType.startsWith("INT") || colType.startsWith("SMALLINT") || colType.startsWith("BIGINT")) { // los
																												// que
																												// son
																												// llevados
																												// con
																												// ComboTIPO
				String item = getObjectComboBoxCampo05().getSelectedItem().toString();
				boolean si_no_tipo = false;
				if (get_TABLA_GENERAL__SI_NO_Columns() != null && get_TABLA_GENERAL__SI_NO_Columns().length > 0) {
					String si_no_col;
					for (int i = 0; i < get_TABLA_GENERAL__SI_NO_Columns().length; i++) {
						si_no_col = get_TABLA_GENERAL__SI_NO_Columns()[i];
						if (si_no_col.compareTo(item) == 0)
							si_no_tipo = true;
					}
				}
				if (si_no_tipo) {
					getComboTIPOValor05().setTABLE_NAME("_TABLA_GENERAL");
					getComboTIPOValor05().setCOLUMN_NAME("_SI_NO");
				} else {
					getComboTIPOValor05().setTABLE_NAME(this.getTABLE_NAME());
					getComboTIPOValor05().setCOLUMN_NAME(item);
				}
				try {
					if (getComboTIPOValor05().initCombo()) {
						textVisible = false;
						comboVisible = true;
						dateVisible = false;
						getObjectComboBoxOperador05().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					} else {
						getTextFieldExtValor05().setAllowedKey(TextFieldExt.AllowedKey.AK_SOLO_NUMEROS);
						getTextFieldExtValor05().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
						getTextFieldExtValor05().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
						textVisible = true;
						comboVisible = false;
						dateVisible = false;
						getObjectComboBoxOperador05().setSelectedIndex(1); // el
																			// operador
																			// tiene
																			// que
																			// ser
																			// '='
					}
				} catch (Throwable t) {
					t.getMessage();
				}
			} else {
				if (colType.startsWith("DECIMAL") || colType.startsWith("FLOAT") || colType.startsWith("DOUBLE") || colType.startsWith("NUMERIC")) { // monedas
																																						// y
																																						// numeros
																																						// con
																																						// decimales

					getTextFieldExtValor05().setAllowedKey(TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION);
					getTextFieldExtValor05().setKeyMask(TextFieldExt.KeyMask.KM_Numero);
					getTextFieldExtValor05().setHorizontalAlignment(javax.swing.JTextField.RIGHT);
				} else {
					getTextFieldExtValor05().setAllowedKey(TextFieldExt.AllowedKey.AK_ALFANUMERICOS);
					getTextFieldExtValor05().setKeyMask(TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas);
					getTextFieldExtValor05().setHorizontalAlignment(javax.swing.JTextField.LEFT);
				}
				// para todos los demas casos mostramos el TextFieldExt
				textVisible = true;
				comboVisible = false;
				dateVisible = false;
				getObjectComboBoxOperador05().setSelectedIndex(0); // el
																	// operador
																	// tiene que
																	// ser
																	// 'LIKE'
			}
		}

		getTextFieldExtValor05().setVisible(textVisible);
		getComboTIPOValor05().setVisible(comboVisible);
		getTextDateValor05().setVisible(dateVisible);
	}

	/**
	 *
	 */
	public void requestFocus() {
		if (getTextFieldExtValor01().isVisible()) {
			getTextFieldExtValor01().requestFocus();
		} else {
			if (getTextDateValor01().isVisible()) {
				getTextDateValor01().requestFocus();
			} else {
				if (getComboTIPOValor01().isVisible()) {
					getComboTIPOValor01().requestFocus();
				}
			}
		}
	}

	/**
	 * This method initializes panelExt
	 *
	 * @return efren.util.gui.panels.PanelExt
	 */
	private PanelExt getPanelExt() {
		if (panelExt == null) {
			panelExt = new PanelExt();
			java.awt.GridBagConstraints constraintsTextFieldExtValor01 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor01.gridx = 2;
			constraintsTextFieldExtValor01.gridy = 1;
			constraintsTextFieldExtValor01.gridwidth = 2;
			constraintsTextFieldExtValor01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor01.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtValor01.weightx = 1.0;
			constraintsTextFieldExtValor01.insets = new java.awt.Insets(0, 5, 1, 10);
			panelExt.add(getTextFieldExtValor01(), constraintsTextFieldExtValor01);

			java.awt.GridBagConstraints constraintsTextDateValor01 = new java.awt.GridBagConstraints();
			constraintsTextDateValor01.gridx = 2;
			constraintsTextDateValor01.gridy = 1;
			constraintsTextDateValor01.gridwidth = 2;
			constraintsTextDateValor01.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextDateValor01.weightx = 1.0;
			constraintsTextDateValor01.insets = new java.awt.Insets(1, 5, 1, 4);
			panelExt.add(getTextDateValor01(), constraintsTextDateValor01);

			java.awt.GridBagConstraints constraintsObjectComboBoxOperador01 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxOperador01.gridx = 1;
			constraintsObjectComboBoxOperador01.gridy = 1;
			constraintsObjectComboBoxOperador01.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxOperador01.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxOperador01(), constraintsObjectComboBoxOperador01);

			java.awt.GridBagConstraints constraintsObjectComboBoxCampo01 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxCampo01.gridx = 0;
			constraintsObjectComboBoxCampo01.gridy = 1;
			constraintsObjectComboBoxCampo01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxCampo01.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxCampo01.weightx = 1.0;
			constraintsObjectComboBoxCampo01.insets = new Insets(0, 4, 1, 4);
			java.awt.GridBagConstraints constraintsLabelExt1 = new java.awt.GridBagConstraints();
			constraintsLabelExt1.gridx = 0;
			constraintsLabelExt1.gridy = 0;
			constraintsLabelExt1.anchor = java.awt.GridBagConstraints.WEST;
			constraintsLabelExt1.insets = new java.awt.Insets(0, 4, 0, 4);
			panelExt.add(getLabelExt1(), constraintsLabelExt1);

			java.awt.GridBagConstraints constraintsLabelExt = new java.awt.GridBagConstraints();
			constraintsLabelExt.gridx = 1;
			constraintsLabelExt.gridy = 0;
			constraintsLabelExt.anchor = java.awt.GridBagConstraints.WEST;
			constraintsLabelExt.insets = new java.awt.Insets(0, 4, 0, 4);
			panelExt.add(getLabelExt(), constraintsLabelExt);

			java.awt.GridBagConstraints constraintsLabelExt2 = new java.awt.GridBagConstraints();
			constraintsLabelExt2.gridx = 2;
			constraintsLabelExt2.gridy = 0;
			constraintsLabelExt2.anchor = java.awt.GridBagConstraints.WEST;
			constraintsLabelExt2.insets = new java.awt.Insets(0, 4, 0, 4);
			panelExt.add(getLabelExt2(), constraintsLabelExt2);

			java.awt.GridBagConstraints constraintsObjectComboBoxCampo02 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxCampo02.gridx = 0;
			constraintsObjectComboBoxCampo02.gridy = 2;
			constraintsObjectComboBoxCampo02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxCampo02.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxCampo02.weightx = 1.0;
			constraintsObjectComboBoxCampo02.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxCampo02(), constraintsObjectComboBoxCampo02);

			java.awt.GridBagConstraints constraintsObjectComboBoxCampo03 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxCampo03.gridx = 0;
			constraintsObjectComboBoxCampo03.gridy = 3;
			constraintsObjectComboBoxCampo03.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxCampo03.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxCampo03.weightx = 1.0;
			constraintsObjectComboBoxCampo03.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxCampo03(), constraintsObjectComboBoxCampo03);

			java.awt.GridBagConstraints constraintsObjectComboBoxCampo04 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxCampo04.gridx = 0;
			constraintsObjectComboBoxCampo04.gridy = 4;
			constraintsObjectComboBoxCampo04.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxCampo04.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxCampo04.weightx = 1.0;
			constraintsObjectComboBoxCampo04.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxCampo04(), constraintsObjectComboBoxCampo04);

			java.awt.GridBagConstraints constraintsObjectComboBoxCampo05 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxCampo05.gridx = 0;
			constraintsObjectComboBoxCampo05.gridy = 5;
			constraintsObjectComboBoxCampo05.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsObjectComboBoxCampo05.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxCampo05.weightx = 1.0;
			constraintsObjectComboBoxCampo05.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxCampo05(), constraintsObjectComboBoxCampo05);

			java.awt.GridBagConstraints constraintsTextFieldExtValor02 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor02.gridx = 2;
			constraintsTextFieldExtValor02.gridy = 2;
			constraintsTextFieldExtValor02.gridwidth = 2;
			constraintsTextFieldExtValor02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor02.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtValor02.weightx = 1.0;
			constraintsTextFieldExtValor02.insets = new java.awt.Insets(0, 5, 1, 10);
			panelExt.add(getTextFieldExtValor02(), constraintsTextFieldExtValor02);

			java.awt.GridBagConstraints constraintsTextDateValor02 = new java.awt.GridBagConstraints();
			constraintsTextDateValor02.gridx = 2;
			constraintsTextDateValor02.gridy = 2;
			constraintsTextDateValor02.gridwidth = 2;
			constraintsTextDateValor02.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextDateValor02.weightx = 1.0;
			constraintsTextDateValor02.insets = new java.awt.Insets(1, 5, 1, 4);
			panelExt.add(getTextDateValor02(), constraintsTextDateValor02);

			java.awt.GridBagConstraints constraintsTextFieldExtValor03 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor03.gridx = 2;
			constraintsTextFieldExtValor03.gridy = 3;
			constraintsTextFieldExtValor03.gridwidth = 2;
			constraintsTextFieldExtValor03.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor03.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtValor03.weightx = 1.0;
			constraintsTextFieldExtValor03.insets = new java.awt.Insets(0, 5, 1, 10);
			panelExt.add(getTextFieldExtValor03(), constraintsTextFieldExtValor03);

			java.awt.GridBagConstraints constraintsTextDateValor03 = new java.awt.GridBagConstraints();
			constraintsTextDateValor03.gridx = 2;
			constraintsTextDateValor03.gridy = 3;
			constraintsTextDateValor03.gridwidth = 2;
			constraintsTextDateValor03.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextDateValor03.weightx = 1.0;
			constraintsTextDateValor03.insets = new java.awt.Insets(1, 5, 1, 4);
			panelExt.add(getTextDateValor03(), constraintsTextDateValor03);

			java.awt.GridBagConstraints constraintsTextFieldExtValor04 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor04.gridx = 2;
			constraintsTextFieldExtValor04.gridy = 4;
			constraintsTextFieldExtValor04.gridwidth = 2;
			constraintsTextFieldExtValor04.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor04.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtValor04.weightx = 1.0;
			constraintsTextFieldExtValor04.insets = new java.awt.Insets(0, 5, 1, 10);
			panelExt.add(getTextFieldExtValor04(), constraintsTextFieldExtValor04);

			java.awt.GridBagConstraints constraintsTextDateValor04 = new java.awt.GridBagConstraints();
			constraintsTextDateValor04.gridx = 2;
			constraintsTextDateValor04.gridy = 4;
			constraintsTextDateValor04.gridwidth = 2;
			constraintsTextDateValor04.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextDateValor04.weightx = 1.0;
			constraintsTextDateValor04.insets = new java.awt.Insets(1, 5, 1, 4);
			panelExt.add(getTextDateValor04(), constraintsTextDateValor04);

			java.awt.GridBagConstraints constraintsTextFieldExtValor05 = new java.awt.GridBagConstraints();
			constraintsTextFieldExtValor05.gridx = 2;
			constraintsTextFieldExtValor05.gridy = 5;
			constraintsTextFieldExtValor05.gridwidth = 2;
			constraintsTextFieldExtValor05.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsTextFieldExtValor05.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextFieldExtValor05.weightx = 1.0;
			constraintsTextFieldExtValor05.insets = new java.awt.Insets(0, 5, 1, 10);
			panelExt.add(getTextFieldExtValor05(), constraintsTextFieldExtValor05);

			java.awt.GridBagConstraints constraintsTextDateValor05 = new java.awt.GridBagConstraints();
			constraintsTextDateValor05.gridx = 2;
			constraintsTextDateValor05.gridy = 5;
			constraintsTextDateValor05.gridwidth = 2;
			constraintsTextDateValor05.anchor = java.awt.GridBagConstraints.WEST;
			constraintsTextDateValor05.weightx = 1.0;
			constraintsTextDateValor05.insets = new java.awt.Insets(1, 5, 1, 4);
			panelExt.add(getTextDateValor05(), constraintsTextDateValor05);

			java.awt.GridBagConstraints constraintsObjectComboBoxOperador02 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxOperador02.gridx = 1;
			constraintsObjectComboBoxOperador02.gridy = 2;
			constraintsObjectComboBoxOperador02.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxOperador02.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxOperador02(), constraintsObjectComboBoxOperador02);

			java.awt.GridBagConstraints constraintsObjectComboBoxOperador03 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxOperador03.gridx = 1;
			constraintsObjectComboBoxOperador03.gridy = 3;
			constraintsObjectComboBoxOperador03.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxOperador03.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxOperador03(), constraintsObjectComboBoxOperador03);

			java.awt.GridBagConstraints constraintsObjectComboBoxOperador04 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxOperador04.gridx = 1;
			constraintsObjectComboBoxOperador04.gridy = 4;
			constraintsObjectComboBoxOperador04.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxOperador04.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxOperador04(), constraintsObjectComboBoxOperador04);

			java.awt.GridBagConstraints constraintsObjectComboBoxOperador05 = new java.awt.GridBagConstraints();
			constraintsObjectComboBoxOperador05.gridx = 1;
			constraintsObjectComboBoxOperador05.gridy = 5;
			constraintsObjectComboBoxOperador05.anchor = java.awt.GridBagConstraints.WEST;
			constraintsObjectComboBoxOperador05.insets = new java.awt.Insets(1, 4, 1, 4);
			panelExt.add(getObjectComboBoxOperador05(), constraintsObjectComboBoxOperador05);

			java.awt.GridBagConstraints constraintsComboTIPOValor01 = new java.awt.GridBagConstraints();
			constraintsComboTIPOValor01.gridx = 2;
			constraintsComboTIPOValor01.gridy = 1;
			constraintsComboTIPOValor01.gridwidth = 2;
			constraintsComboTIPOValor01.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsComboTIPOValor01.anchor = java.awt.GridBagConstraints.WEST;
			constraintsComboTIPOValor01.weightx = 1.0;
			constraintsComboTIPOValor01.insets = new java.awt.Insets(1, 5, 1, 10);
			panelExt.add(getComboTIPOValor01(), constraintsComboTIPOValor01);

			java.awt.GridBagConstraints constraintsComboTIPOValor02 = new java.awt.GridBagConstraints();
			constraintsComboTIPOValor02.gridx = 2;
			constraintsComboTIPOValor02.gridy = 2;
			constraintsComboTIPOValor02.gridwidth = 2;
			constraintsComboTIPOValor02.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsComboTIPOValor02.anchor = java.awt.GridBagConstraints.WEST;
			constraintsComboTIPOValor02.weightx = 1.0;
			constraintsComboTIPOValor02.insets = new java.awt.Insets(1, 5, 1, 10);
			panelExt.add(getComboTIPOValor02(), constraintsComboTIPOValor02);

			java.awt.GridBagConstraints constraintsComboTIPOValor03 = new java.awt.GridBagConstraints();
			constraintsComboTIPOValor03.gridx = 2;
			constraintsComboTIPOValor03.gridy = 3;
			constraintsComboTIPOValor03.gridwidth = 2;
			constraintsComboTIPOValor03.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsComboTIPOValor03.anchor = java.awt.GridBagConstraints.WEST;
			constraintsComboTIPOValor03.weightx = 1.0;
			constraintsComboTIPOValor03.insets = new java.awt.Insets(1, 5, 1, 10);
			panelExt.add(getComboTIPOValor03(), constraintsComboTIPOValor03);

			java.awt.GridBagConstraints constraintsComboTIPOValor04 = new java.awt.GridBagConstraints();
			constraintsComboTIPOValor04.gridx = 2;
			constraintsComboTIPOValor04.gridy = 4;
			constraintsComboTIPOValor04.gridwidth = 2;
			constraintsComboTIPOValor04.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsComboTIPOValor04.anchor = java.awt.GridBagConstraints.WEST;
			constraintsComboTIPOValor04.weightx = 1.0;
			constraintsComboTIPOValor04.insets = new java.awt.Insets(1, 5, 1, 10);
			panelExt.add(getComboTIPOValor04(), constraintsComboTIPOValor04);

			java.awt.GridBagConstraints constraintsComboTIPOValor05 = new java.awt.GridBagConstraints();
			constraintsComboTIPOValor05.gridx = 2;
			constraintsComboTIPOValor05.gridy = 5;
			constraintsComboTIPOValor05.gridwidth = 2;
			constraintsComboTIPOValor05.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsComboTIPOValor05.anchor = java.awt.GridBagConstraints.WEST;
			constraintsComboTIPOValor05.weightx = 1.0;
			constraintsComboTIPOValor05.insets = new java.awt.Insets(1, 5, 1, 10);
			panelExt.add(getComboTIPOValor05(), constraintsComboTIPOValor05);

			java.awt.GridBagConstraints constraintsJButtonReset = new java.awt.GridBagConstraints();
			constraintsJButtonReset.gridx = 3;
			constraintsJButtonReset.gridy = 0;
			constraintsJButtonReset.anchor = java.awt.GridBagConstraints.SOUTHEAST;
			constraintsJButtonReset.insets = new java.awt.Insets(1, 0, 1, 10);
			panelExt.add(getObjectComboBoxCampo01(), constraintsObjectComboBoxCampo01);
			panelExt.add(getJButtonReset(), constraintsJButtonReset);

		}
		return panelExt;
	}

	/**
	 * This method initializes titledPanel
	 *
	 * @return efren.util.gui.panels.TitledPanel
	 */
	private TitledPanel getTitledPanel() {
		if (titledPanel == null) {
			titledPanel = new TitledPanel();
			titledPanel.setTitle("Búsqueda");
			titledPanel.add(getPanelExt(), BorderLayout.CENTER);
		}
		return titledPanel;
	}

	/**
	 * @return the selectedCampo01
	 */
	public String getSelectedCampo01() {
		return selectedCampo01;
	}

	/**
	 * @param selectedCampo01
	 *            the selectedCampo01 to set
	 */
	public void setSelectedCampo01(String selectedCampo01) {
		this.selectedCampo01 = selectedCampo01;
	}

	/**
	 * @return the selectedCampo02
	 */
	public String getSelectedCampo02() {
		return selectedCampo02;
	}

	/**
	 * @param selectedCampo02
	 *            the selectedCampo02 to set
	 */
	public void setSelectedCampo02(String selectedCampo02) {
		this.selectedCampo02 = selectedCampo02;
	}

}
