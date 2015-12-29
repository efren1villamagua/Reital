package efren.seguridades.procesos.gui;

import java.awt.Container;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import efren.seguridades.gui.AccesoController;
import efren.seguridades.gui.ChangePasswordView;
import efren.seguridades.gui.SystemView;
import efren.util.ReconnectionException;
import efren.util.SwingResourceManager;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.entidades.SecOpcion;

public class MenuBuilderProcess {

	private Vector<Character> inner_charsNotUse = null;

	private Statement inner_st = null;

	// public static FlowLayout layoutForMenus = null;
	static {
		// layoutForMenus = new FlowLayout();
		// layoutForMenus.setAlignment(FlowLayout.CENTER);
		// layoutForMenus = new GridLayout(0, 1000);
	}

	public MenuBuilderProcess(Statement unSt) {
		super();
		inicializar();
		this.inner_st = unSt;
	}

	/**
	 *
	 *
	 */
	private void inicializar() {
		this.inner_charsNotUse = new Vector<Character>();
		this.inner_charsNotUse.addElement(new Character('A'));
		this.inner_charsNotUse.addElement(new Character('a'));
		this.inner_charsNotUse.addElement(new Character('r'));
		this.inner_charsNotUse.addElement(new Character('R'));
		// Bar02Panel
		this.inner_charsNotUse.addElement(new Character('n'));
		this.inner_charsNotUse.addElement(new Character('m'));
		this.inner_charsNotUse.addElement(new Character('e'));
		this.inner_charsNotUse.addElement(new Character('c'));
		this.inner_charsNotUse.addElement(new Character('N'));
		this.inner_charsNotUse.addElement(new Character('M'));
		this.inner_charsNotUse.addElement(new Character('E'));
		this.inner_charsNotUse.addElement(new Character('C'));
		// Bar02Panel en DataTablePanel
		this.inner_charsNotUse.addElement(new Character('B'));
		this.inner_charsNotUse.addElement(new Character('b'));
		// Button en FinderSQLPanel
		this.inner_charsNotUse.addElement(new Character('L'));
		this.inner_charsNotUse.addElement(new Character('l'));
		// opciones 'Extra' y 'Salir'
		this.inner_charsNotUse.addElement(new Character('X'));
		this.inner_charsNotUse.addElement(new Character('x'));
		this.inner_charsNotUse.addElement(new Character('V'));
		this.inner_charsNotUse.addElement(new Character('v'));
	}

	/**
	 *
	 * @param aMenuOpcion
	 * @param opcionesOrdenadas
	 * @return
	 */
	private JMenu __agregarHijosDe_LO(efren.util.entidades.SecOpcion aMenuOpcion, Vector opcionesOrdenadas) {
		try {
			// java.awt.Insets mg = new java.awt.Insets(0,0,0,0);

			JMenu unMenu = new JMenu();
			unMenu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
			unMenu.setText(aMenuOpcion.getNombre().trim());
			unMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			unMenu.setMnemonic(getMnemonicFor(unMenu.getText()));
			try {
				unMenu.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + aMenuOpcion.getIconName())));
			} catch (Exception e) {
				e.getMessage();
			}
			// unMenu.setMargin(mg);

			efren.util.entidades.SecOpcion mb;
			JMenuItem mi, miTemp;
			efren.util.menu.OpenWindowAction owa;
			int c = 1;
			for (int i = 0; i < opcionesOrdenadas.size(); i++) {
				mb = (efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i);
				if (aMenuOpcion.getOid() == mb.getOpcionPadreOid()) {
					if (mb.esMenu()) {
						miTemp = __agregarHijosDe_LO(mb, opcionesOrdenadas);
						if (miTemp != null) {
							unMenu.add(miTemp);
						}
						try {
							miTemp.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + mb.getIconName())));
						} catch (Exception e) {
							e.getMessage();
						}
					} else {
						if (mb.getNombre().trim().toUpperCase().compareTo("&SEPARADOR") == 0) {
							unMenu.addSeparator();
						} else {
							owa = new efren.util.menu.OpenWindowAction(mb.getNombre().trim(), mb.getNombreClase());
							mi = unMenu.add(owa);
							mi.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
							// mi.setIcon(new
							// ImageIcon(getClass().getResource("/efren/resources/images/menu_itemSimple.gif")));
							try {
								mi.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + mb.getIconName())));
							} catch (Exception e) {
								e.getMessage();
							}
							mi.setHorizontalTextPosition(JMenu.RIGHT);
							mi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
							if (c <= 9)
								mi.setText(String.valueOf(c) + " " + mi.getText());
							else
								mi.setText(new Character((char) ('A' - 10 + c)) + " " + mi.getText());
							mi.setMnemonic(mi.getText().charAt(0));
							// mi.setBackground(java.awt.Color.red);
							// mi.setMargin(mg);
							c++;
						}
					}
				}
			}
			return unMenu;
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	/**
	 *
	 * @param aMenuOpcion
	 * @param opcionesOrdenadas
	 * @return
	 */
	private JMenu __agregarHijosDe_SA(SecOpcion aMenuOpcion, Vector opcionesOrdenadas) {
		try {
			JMenu unMenu = new JMenu();
			unMenu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
			unMenu.setText(aMenuOpcion.getNombre().trim());
			unMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			unMenu.setMnemonic(getMnemonicFor(unMenu.getText()));
			try {
				unMenu.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + aMenuOpcion.getIconName())));
			} catch (Exception e) {
				e.getMessage();
			}

			SecOpcion mb;
			JMenuItem mi, miTemp;
			efren.util.menu.OpenWindowAction owa;
			int c = 1;
			for (int i = 0; i < opcionesOrdenadas.size(); i++) {
				mb = (SecOpcion) opcionesOrdenadas.elementAt(i);
				if (aMenuOpcion.getOid() == mb.getOpcionPadreOid()) {
					if (mb.esMenu()) {
						miTemp = __agregarHijosDe_SA(mb, opcionesOrdenadas);
						if (miTemp != null) {
							unMenu.add(miTemp);
						}
						try {
							miTemp.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + mb.getIconName())));
						} catch (Exception e) {
							e.getMessage();
						}
					} else {
						if (mb.getNombre().trim().toUpperCase().compareTo("&SEPARADOR") == 0) {
							unMenu.addSeparator();
						} else {
							owa = new efren.util.menu.OpenWindowAction(mb.getNombre().trim(), mb.getNombreClase());
							mi = unMenu.add(owa);
							mi.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
							// mi.setIcon(new
							// ImageIcon(getClass().getResource("/efren/resources/images/menu_itemSimple.gif")));
							try {
								mi.setIcon(new ImageIcon(getClass().getResource("/efren/resources/images/seguridades/" + mb.getIconName())));
							} catch (Exception e) {
								e.getMessage();
							}
							mi.setHorizontalTextPosition(JMenu.RIGHT);
							mi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
							if (c <= 9)
								mi.setText(String.valueOf(c) + " " + mi.getText());
							else
								mi.setText(new Character((char) ('A' - 10 + c)) + " " + mi.getText());
							mi.setMnemonic(mi.getText().charAt(0));
							// mi.setBackground(java.awt.Color.red);
							// mi.setMargin(mg);
							c++;
						}
					}
				}
			}
			return unMenu;
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	/**
	 *
	 * @param unPerfilOid
	 * @return
	 */
	public JMenuBar __buildMenuFor(long unPerfilOid, Container unContainerVisual) {

		try {
			Vector opcionesOrdenadas = new Vector();

			if (SystemProperties.SYSTEM_TYPE == Constantes.SYSTEM_TYPE_3_LO) {
				// SISTEMA LOCAL (SIN SERVIDOR DE APLICACIONES)
				efren.util.entidades.SecOpcion mb;

				java.util.Vector opciones = new java.util.Vector();
				// todas las opciones
				String sql = "SELECT " + " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE " + " , o.POSICION, o.TIMESTAMP "
						+ " , CASE WHEN (c.NOMBRE IS NULL) THEN ' ' "
						+ " ELSE RTRIM(LTRIM(c.PAQUETE)) CONCAT '.' CONCAT RTRIM(LTRIM(c.NOMBRE)) END AS NOMBRECLASE "
						+ " ,RTRIM(LTRIM(o.ICONNAME)) AS ICONNAME " + " FROM " + SystemProperties.SCHEMA_SEGURIDADES + "." + "OPCION o " + " LEFT OUTER JOIN "
						+ SystemProperties.SCHEMA_SEGURIDADES + "." + "CLASE c " + " ON o.CLASEOID = c.OID " + " WHERE o.SISTEMAOID = "
						+ SystemProperties.SISTEMA_OID + " " + " AND o.OPCIONPADREOID <> " + SystemProperties.SISTEMA_OID + " " + " ORDER BY o.POSICION ";
				ResultSet rs = this.inner_st.executeQuery(sql);
				while (rs.next()) {

					mb = new efren.util.entidades.SecOpcion();

					mb.setOid(rs.getLong(1));
					mb.setSistemaOid(rs.getLong(2));
					mb.setClaseOid(rs.getLong(3));
					mb.setOpcionPadreOid(rs.getLong(4));
					mb.setNombre(rs.getString(5).trim());
					mb.setNombre2(" " + rs.getString(5).trim());
					mb.setPosicion(rs.getInt(6));
					mb.setTimestamp(rs.getTimestamp(7));
					mb.setNombreClase(rs.getString(8));
					mb.setIconName(rs.getString("ICONNAME"));

					mb.setOP_todo(new Boolean(false));
					mb.setOP_ingresoMasivo(new Boolean(false));
					mb.setOP_ingresoContinuo(new Boolean(false));
					mb.setOP_ingreso(new Boolean(false));
					mb.setOP_modificacion(new Boolean(false));
					mb.setOP_eliminacion(new Boolean(false));
					mb.setOP_consulta(new Boolean(false));

					if (mb.getNombreClase().trim().length() == 0)
						mb.setEsMenu(true);

					mb.setPosicionAbsoluta(__convertTo4Chars(mb.getPosicion()));

					opciones.addElement(mb);
				}
				rs.close();

				// las opciones que son menúes topLevel
				java.util.Vector menues = new java.util.Vector();
				sql = "SELECT " + " o.OID, o.SISTEMAOID, o.CLASEOID, o.OPCIONPADREOID, o.NOMBRE " + " , o.POSICION, o.TIMESTAMP " + " , ' ' "
						+ " ,RTRIM(LTRIM(o.ICONNAME)) AS ICONNAME " + " FROM " + SystemProperties.SCHEMA_SEGURIDADES + "." + "OPCION o "
						+ " WHERE SISTEMAOID = " + SystemProperties.SISTEMA_OID + " " + " AND OPCIONPADREOID = " + SystemProperties.SISTEMA_OID + " "
						+ " ORDER BY o.POSICION, o.NOMBRE  ";
				rs = this.inner_st.executeQuery(sql);
				while (rs.next()) {

					mb = new efren.util.entidades.SecOpcion();

					mb.setOid(rs.getLong(1));
					mb.setSistemaOid(rs.getLong(2));
					mb.setClaseOid(rs.getLong(3));
					mb.setOpcionPadreOid(rs.getLong(4));
					mb.setNombre(rs.getString(5).trim());
					mb.setNombre2(rs.getString(5).trim().toUpperCase());
					mb.setPosicion(rs.getInt(6));
					mb.setTimestamp(rs.getTimestamp(7));
					mb.setNombreClase(rs.getString(8));
					mb.setIconName(rs.getString("ICONNAME"));

					mb.setOP_todo(new Boolean(false));
					mb.setOP_ingresoMasivo(new Boolean(false));
					mb.setOP_ingresoContinuo(new Boolean(false));
					mb.setOP_ingreso(new Boolean(false));
					mb.setOP_modificacion(new Boolean(false));
					mb.setOP_eliminacion(new Boolean(false));
					mb.setOP_consulta(new Boolean(false));

					mb.setEsMenu(true);

					mb.setPosicionAbsoluta(__convertTo4Chars(mb.getPosicion()));

					menues.addElement(mb);
				}
				rs.close();

				// las opciones por perfil (solo opciones, no menúes)
				sql = "SELECT " + " po.OPCIONOID, po.TODO, po.INGRESOMASIVO, po.INGRESOCONTINUO, po.INGRESO, po.MODIFICACION, po.ELIMINACION, po.CONSULTA "
						+ " FROM " + SystemProperties.SCHEMA_SEGURIDADES + "." + "OPCION o " + " , " + SystemProperties.SCHEMA_SEGURIDADES + "."
						+ "PERFILOPCION po " + " WHERE " + " o.SISTEMAOID = " + SystemProperties.SISTEMA_OID + " " + " AND po.PERFILOID = " + unPerfilOid + " "
						+ " AND o.OID = po.OPCIONOID ";
				rs = this.inner_st.executeQuery(sql);

				java.util.Vector opcionesPorPerfil = new java.util.Vector();
				efren.util.entidades.SecPerfilOpcion spo;
				while (rs.next()) {
					spo = new efren.util.entidades.SecPerfilOpcion();
					spo.setOpcionOid(rs.getLong(1));
					spo.setOP_todo(new Boolean(rs.getInt(2) == 0));
					spo.setOP_ingresoMasivo(new Boolean(rs.getInt(3) == 0));
					spo.setOP_ingresoContinuo(new Boolean(rs.getInt(4) == 0));
					spo.setOP_ingreso(new Boolean(rs.getInt(5) == 0));
					spo.setOP_modificacion(new Boolean(rs.getInt(6) == 0));
					spo.setOP_eliminacion(new Boolean(rs.getInt(7) == 0));
					spo.setOP_consulta(new Boolean(rs.getInt(8) == 0));
					opcionesPorPerfil.addElement(spo);
				}

				efren.util.entidades.SecOpcion so;
				// se enlaza las opciones al perfil
				for (int i = 0; i < opcionesPorPerfil.size(); i++) {
					spo = (efren.util.entidades.SecPerfilOpcion) opcionesPorPerfil.elementAt(i);
					for (int j = 0; j < opciones.size(); j++) {
						so = (efren.util.entidades.SecOpcion) opciones.elementAt(j);
						if (spo.getOpcionOid() == so.getOid()) {
							so.setOP_todo(spo.getOP_todo());
							so.setOP_ingresoMasivo(spo.getOP_ingresoMasivo());
							so.setOP_ingresoContinuo(spo.getOP_ingresoContinuo());
							so.setOP_ingreso(spo.getOP_ingreso());
							so.setOP_modificacion(spo.getOP_modificacion());
							so.setOP_eliminacion(spo.getOP_eliminacion());
							so.setOP_consulta(spo.getOP_consulta());
						}
					}
				}

				// ...
				java.util.Vector preOpcionesOrdenadas = __crearOpciones(menues, opciones);

				// contiene las opciones en orden descendente
				opcionesOrdenadas = __eliminarMenuesSinHijosHabilitados(preOpcionesOrdenadas);

				return __primBuildMenu_LO(opcionesOrdenadas);
			}

		} catch (Throwable t) {
			t.getMessage();
			if (!(t instanceof ReconnectionException)) {
				efren.util.gui.dialogs.InfoView.showErrorDialog(unContainerVisual, t);
			}
			System.exit(0);
		}
		return null;
	}

	/**
	 *
	 * @param menu
	 * @param opciones
	 * @param opcionesOrdenadas
	 */
	private void __buscarHijos(efren.util.entidades.SecOpcion menu, java.util.Vector opciones, java.util.Vector opcionesOrdenadas) {

		try {

			for (int i = 0; i < opciones.size(); i++) {
				if (menu.getOid() == ((efren.util.entidades.SecOpcion) opciones.elementAt(i)).getOpcionPadreOid()) {
					((efren.util.entidades.SecOpcion) opciones.elementAt(i)).setPosicionAbsoluta(
							menu.getPosicionAbsoluta() + "-" + ((efren.util.entidades.SecOpcion) opciones.elementAt(i)).getPosicionAbsoluta());
					menu.setNombre2(menu.getNombre2().toUpperCase());
					opcionesOrdenadas.addElement(opciones.elementAt(i));
					__buscarHijos(((efren.util.entidades.SecOpcion) opciones.elementAt(i)), opciones, opcionesOrdenadas);
					menu.setEsMenu(true);
				}
			}
		} catch (Throwable t) {
			t.getMessage();
		}
	}

	/**
	 *
	 * @param number
	 * @return
	 */
	private String __convertTo4Chars(int number) {
		if (number <= 9)
			return "000" + String.valueOf(number).trim();
		if (number <= 99)
			return "00" + String.valueOf(number).trim();
		if (number <= 999)
			return "0" + String.valueOf(number).trim();
		return String.valueOf(number).trim();
	}

	/**
	 *
	 * @param menues
	 * @param opciones
	 * @return
	 */
	private java.util.Vector __crearOpciones(java.util.Vector menues, java.util.Vector opciones) {

		try {

			java.util.Vector opcionesOrdenadas = new java.util.Vector();

			efren.util.entidades.SecOpcion menu;
			for (int i = 0; i < menues.size(); i++) {
				menu = (efren.util.entidades.SecOpcion) menues.elementAt(i);
				opcionesOrdenadas.addElement(menu);
				__buscarHijos(menu, opciones, opcionesOrdenadas);
			}
			return opcionesOrdenadas;
		} catch (Throwable t) {
			t.getMessage();
			return new java.util.Vector();
		}
	}

	/**
	 *
	 * @param opcionesOrdenadas
	 * @return
	 */
	private java.util.Vector __eliminarMenuesSinHijosHabilitados(java.util.Vector opcionesOrdenadas) {

		try {
			boolean todo, ingresoMasivo, ingresoContinuo, ingreso, modificacion, eliminacion, consulta;
			efren.util.entidades.SecOpcion so;
			for (int i = opcionesOrdenadas.size() - 1; i >= 0; i--) {
				if (((efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i)).esMenu()) {
					for (int j = 0; j < opcionesOrdenadas.size(); j++) {

						if (((efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i))
								.getOid() == ((efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(j)).getOpcionPadreOid()) {

							so = (efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(j);
							todo = so.getOP_todo().booleanValue();
							ingresoMasivo = so.getOP_ingresoMasivo().booleanValue();
							ingresoContinuo = so.getOP_ingresoContinuo().booleanValue();
							ingreso = so.getOP_ingreso().booleanValue();
							modificacion = so.getOP_modificacion().booleanValue();
							eliminacion = so.getOP_eliminacion().booleanValue();
							consulta = so.getOP_consulta().booleanValue();

							if (todo || ingresoMasivo || ingresoContinuo || ingreso || modificacion || eliminacion || consulta) {

								((efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i)).setOP_todo(new Boolean(true));

							}
						}
					}
				}
			}

			java.util.Vector opciones = new java.util.Vector();
			boolean sep = true;
			String separador = "?";
			for (int i = 0; i < opcionesOrdenadas.size(); i++) {

				so = (efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i);

				if (so.getOP_todo().booleanValue() || so.getOP_ingresoMasivo().booleanValue() || so.getOP_ingresoContinuo().booleanValue()
						|| so.getOP_ingreso().booleanValue() || so.getOP_modificacion().booleanValue() || so.getOP_eliminacion().booleanValue()
						|| so.getOP_consulta().booleanValue()) {

					if (!so.esMenu()) {

						sep = true;
						separador = "?";

						if (so.getOP_todo().booleanValue()) {
							so.setNombreClase(so.getNombreClase() + separador + "todo");
							if (sep) {
								separador = "&";
								sep = false;
							}
						} else {
							if (so.getOP_ingresoMasivo().booleanValue()) {
								so.setNombreClase(so.getNombreClase() + separador + "ingresoMasivo");
								if (sep) {
									separador = "&";
									sep = false;
								}
							}
							if (so.getOP_ingresoContinuo().booleanValue()) {
								so.setNombreClase(so.getNombreClase() + separador + "ingresoContinuo");
								if (sep) {
									separador = "&";
									sep = false;
								}
							}
							if (so.getOP_ingreso().booleanValue()) {
								so.setNombreClase(so.getNombreClase() + separador + "ingreso");
								if (sep) {
									separador = "&";
									sep = false;
								}
							}
							if (so.getOP_modificacion().booleanValue()) {
								so.setNombreClase(so.getNombreClase() + separador + "modificacion");
								if (sep) {
									separador = "&";
									sep = false;
								}
							}
							if (so.getOP_eliminacion().booleanValue()) {
								so.setNombreClase(so.getNombreClase() + separador + "eliminacion");
								if (sep) {
									separador = "&";
									sep = false;
								}
							}
							if (so.getOP_consulta().booleanValue())
								so.setNombreClase(so.getNombreClase() + separador + "consulta");
						}
					}
					opciones.addElement(opcionesOrdenadas.elementAt(i));
				}

			}
			return opciones;
		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	/**
	 *
	 * @param opcionesOrdenadas
	 * @return
	 */
	private JMenuBar __primBuildMenu_LO(java.util.Vector opcionesOrdenadas) {
		try {
			JMenuBar menuBar = new JMenuBar();
			// menuBar.setLayout(MenuBuilderProcess.layoutForMenus);

			efren.util.entidades.SecOpcion mb;
			JMenu menuTemp;
			for (int i = 0; i < opcionesOrdenadas.size(); i++) {
				mb = (efren.util.entidades.SecOpcion) opcionesOrdenadas.elementAt(i);
				if (mb.esMenu() && mb.getOpcionPadreOid() == new Long(SystemProperties.SISTEMA_OID.trim()).longValue()) {
					menuTemp = __agregarHijosDe_LO(mb, opcionesOrdenadas);
					menuBar.add(menuTemp);
				}
			}
			menuBar.add(Box.createHorizontalGlue());
			JMenu menuVentanas = menuBar.add(MenuBuilderProcess.crearMenuVentanas(this.getClass(), false));
			SystemProperties.RUNTIME_MENU_VENTANAS_DEL_SISTEMA = menuVentanas;
			menuBar.add(MenuBuilderProcess.crearMenuExtras(this.getClass(), false, false));
			// menuBar.add(MenuBuilderProcess.crearMenuItemJava(this.getClass()));
			// menuBar.add(MenuBuilderProcess.crearMenuItemAbout(this.getClass()));
			// menuBar.add(MenuBuilderProcess.crearMenuItemSalir(this.getClass(),
			// false));

			menuBar.setBorderPainted(true);

			return menuBar;

		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	/**
	 *
	 * @param opcionesOrdenadas
	 * @return
	 */
	private JMenuBar __primBuildMenu_SA(Vector<SecOpcion> opcionesOrdenadas) {
		try {
			JMenuBar menuBar = new JMenuBar();
			// menuBar.setLayout(MenuBuilderProcess.layoutForMenus);

			SecOpcion mb;
			JMenu menuTemp;
			for (int i = 0; i < opcionesOrdenadas.size(); i++) {
				mb = opcionesOrdenadas.elementAt(i);
				if (mb.esMenu() && mb.getOpcionPadreOid() == new Long(SystemProperties.SISTEMA_OID.trim()).longValue()) {
					menuTemp = __agregarHijosDe_SA(mb, opcionesOrdenadas);
					menuBar.add(menuTemp);
				}
			}
			menuBar.add(Box.createHorizontalGlue());
			JMenu menuVentanas = menuBar.add(MenuBuilderProcess.crearMenuVentanas(this.getClass(), false));
			SystemProperties.RUNTIME_MENU_VENTANAS_DEL_SISTEMA = menuVentanas;
			menuBar.add(MenuBuilderProcess.crearMenuExtras(this.getClass(), true, false));
			// menuBar.add(MenuBuilderProcess.crearMenuItemJava(this.getClass()));
			// menuBar.add(MenuBuilderProcess.crearMenuItemAbout(this.getClass()));
			// menuBar.add(MenuBuilderProcess.crearMenuItemSalir(this.getClass(),
			// false));

			menuBar.setBorderPainted(true);

			return menuBar;

		} catch (Throwable t) {
			t.getMessage();
		}
		return null;
	}

	/**
	 *
	 * @param menuName
	 * @return
	 */
	private char getMnemonicFor(String menuName) {

		boolean b = false;
		char c = menuName.charAt(0);
		for (int i = 0; i < this.inner_charsNotUse.size(); i++) {
			if (c == ((Character) this.inner_charsNotUse.elementAt(i)).charValue()) {
				b = true;
				break;
			}
		}
		if (!b) {
			this.inner_charsNotUse.addElement(new Character(c));
			return c;
		}

		b = false;
		if (menuName.length() < 2)
			return ' ';
		c = menuName.charAt(1);
		for (int i = 0; i < this.inner_charsNotUse.size(); i++) {
			if (c == ((Character) this.inner_charsNotUse.elementAt(i)).charValue()) {
				b = true;
				break;
			}
		}
		if (!b) {
			this.inner_charsNotUse.addElement(new Character(c));
			return c;
		}

		b = false;
		if (menuName.length() < 3)
			return ' ';
		c = menuName.charAt(2);
		for (int i = 0; i < this.inner_charsNotUse.size(); i++) {
			if (c == ((Character) this.inner_charsNotUse.elementAt(i)).charValue()) {
				b = true;
				break;
			}
		}
		if (!b) {
			this.inner_charsNotUse.addElement(new Character(c));
			return c;
		}

		b = false;
		if (menuName.length() < 4)
			return ' ';
		c = menuName.charAt(3);
		for (int i = 0; i < this.inner_charsNotUse.size(); i++) {
			if (c == ((Character) this.inner_charsNotUse.elementAt(i)).charValue()) {
				b = true;
				break;
			}
		}
		if (!b) {
			this.inner_charsNotUse.addElement(new Character(c));
			return c;
		}

		b = false;
		if (menuName.length() < 5)
			return ' ';
		c = menuName.charAt(4);
		for (int i = 0; i < this.inner_charsNotUse.size(); i++) {
			if (c == ((Character) this.inner_charsNotUse.elementAt(i)).charValue()) {
				b = true;
				break;
			}
		}
		if (!b) {
			this.inner_charsNotUse.addElement(new Character(c));
			return c;
		}

		return ' ';
	}

	/**
	 *
	 */
	public static JMenu crearMenuSeguridades(Class unaClase) {

		JMenu menu = new JMenu();
		menu.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/candado1.png")));
		menu.setName("JMenuSeguridades");
		menu.setMnemonic(java.awt.event.KeyEvent.VK_S);
		menu.setText("Seguridades");
		menu.setForeground(new java.awt.Color(80, 80, 80));
		menu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
		menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JMenuItem item;
		item = menu.add(new efren.util.menu.OpenWindowAction("1 Clases (views)", "efren.seguridades.abm.gui.ClaseABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/pieza_rompecabezas.png")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('1');

		item = menu.add(new efren.util.menu.OpenWindowAction("2 Sistemas", "efren.seguridades.abm.gui.SistemaABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/mundo_con_mano.png")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('2');

		item = menu.add(new efren.util.menu.OpenWindowAction("3 Opciones", "efren.seguridades.abm.gui.OpcionABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/arbol2.gif")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('3');

		item = menu.add(new efren.util.menu.OpenWindowAction("4 Perfiles", "efren.seguridades.abm.gui.PerfilABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/personas1.gif")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('4');

		item = menu.add(new efren.util.menu.OpenWindowAction("5 Dependencias", "efren.seguridades.abm.gui.DependenciaABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/arbol1.gif")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('5');

		item = menu.add(new efren.util.menu.OpenWindowAction("6 Usuarios", "efren.seguridades.abm.gui.UsuarioABMView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/persona_con_candado.gif")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('6');
		menu.addSeparator();

		item = menu.add(new efren.util.menu.OpenWindowAction("7 Permisos", "efren.seguridades.procesos.gui.RevokeGrantView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/proceso.gif")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('7');
		menu.addSeparator();

		item = menu.add(new efren.util.menu.OpenWindowAction("8 Usuarios conectados", "efren.seguridades.abm.gui.ConnectedUsersView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/pc_con_candado.png")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('8');

		return menu;

	}

	/**
	 *
	 */
	public static JMenu crearMenuUtil(Class unaClase) {

		JMenu menu = new JMenu();
		menu.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/maleta3.gif")));
		menu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
		menu.setForeground(new java.awt.Color(80, 80, 80));
		menu.setText("Util");
		menu.setMnemonic(java.awt.event.KeyEvent.VK_U);
		menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JMenuItem item = menu.add(new efren.util.menu.OpenWindowAction("1 Reporteador", "efren.reportes.ReportesDefinitionView"));
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/libreta4.png")));
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setMnemonic('1');

		return menu;
	}

	/**
	 *
	 */
	public static JMenu crearMenuVentanas(Class unaClase, boolean showText) {
		return MenuBuilderProcess.crearMenuVentanas(unaClase, showText, null);
	}

	/**
	 *
	 */
	public static JMenu crearMenuVentanas(Class unaClase, boolean showText, JMenu unMenuPadre) {

		JMenu menu = null;
		if (unMenuPadre == null) {
			menu = new JMenu();
			menu.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/fechas.png")));
			menu.setForeground(java.awt.Color.darkGray);
			menu.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
			if (showText) {
				menu.setText("Ventanas");
			} else {
				menu.setText("");
			}
			menu.setToolTipText("Ventanas");
			menu.setMnemonic('v');
			menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			menu.addMenuListener(new MenuListener() {
				public void menuCanceled(MenuEvent e) {
				}

				public void menuDeselected(MenuEvent e) {
				}

				public void menuSelected(MenuEvent e) {
					efren.util.InternalFrameManager.singleton().updateFramesList();
				}
			});
		} else {
			menu = unMenuPadre;
		}

		JMenuItem item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/errores.gif")));
		item.setText("Cerrar todas");
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setForeground(java.awt.Color.darkGray);
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.addActionListener(efren.util.InternalFrameManager.singleton());
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/cerrar6.gif")));
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setForeground(java.awt.Color.darkGray);
		item.setText("Cerrar ventana activa");
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Solo cerrar ventana activa");
		item.addActionListener(efren.util.ABMViewManager.singleton());
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		return menu;
	}

	/**
	 *
	 */
	public static JMenu crearMenuExtras(Class unaClase, boolean sePuedeCambiarClaveUsuario, boolean showText) {

		JMenu menu = new JMenu();
		menu.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/ayuda6.gif")));
		menu.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		menu.setForeground(java.awt.Color.darkGray);
		if (showText) {
			menu.setText("Extras");
		} else {
			menu.setText("");
		}
		menu.setToolTipText("Extras");
		menu.setMnemonic('x');
		menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JMenuItem item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/libro_ayuda.png")));
		item.setText("Ayuda");
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setForeground(java.awt.Color.darkGray);
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Ayuda");
		item.addActionListener(efren.util.HelpManager.singleton());
		item.setHorizontalTextPosition(JMenu.RIGHT);
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		// menu.addSeparator();

		item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/incremental.gif")));
		item.setForeground(java.awt.Color.darkGray);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setText("Actualizar");
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Actualizar tabla de datos mostrada");
		item.addActionListener(efren.util.DataTableManager.singleton());
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		// menu.addSeparator();

		item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/libreta1.gif")));
		item.setForeground(java.awt.Color.darkGray);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setText("Consola");
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Mostrar la Consola");
		item.addActionListener(efren.util.gui.ConsoleDialog.singleton());
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		// menu.addSeparator();
		/*
		 * item = new JMenuItem(); item.setIcon(new
		 * ImageIcon(unaClase.getResource(
		 * "/efren/resources/images/seguridades/carita_con_gafas2.gif")));
		 * item.setForeground(java.awt.Color.darkGray); item.setFont(new
		 * java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		 * item.setText("Apariencia"); item.setCursor(new
		 * java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); item.setToolTipText(
		 * "Cambia la apariencia");
		 * item.addActionListener(LookAndFeelDialog.singleton());
		 * item.setAccelerator(
		 * KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7,
		 * java.awt.event.ActionEvent.ALT_MASK)); menu.add(item);
		 * 
		 * //menu.addSeparator();
		 */
		if (sePuedeCambiarClaveUsuario) {
			item = new JMenuItem();
			item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/candado1.png")));
			item.setForeground(java.awt.Color.darkGray);
			item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
			item.setText("Cambiar clave");
			item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			item.setToolTipText("Cambia la clave de usuario");
			item.addActionListener(ChangePasswordView.singleton());
			item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, java.awt.event.ActionEvent.ALT_MASK));
			menu.add(item);

			// menu.addSeparator();
		}

		menu.addSeparator();
		item = new JMenuItem();
		try {
			if (SystemProperties.SISTEMA_ICONO_PATH != null) {
				ImageIcon icono = SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH);
				item.setIcon(icono);
			}
		} catch (Exception e1) {
			e1.getMessage();
			try {
				item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/cubos.png")));
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		item.setForeground(java.awt.Color.darkGray);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setText("Acerca de");
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Acerca de");
		item.addActionListener(new efren.util.gui.about.AboutDialog(SystemView.singleton()));
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.ActionEvent.ALT_MASK));
		menu.add(item);

		menu.addSeparator();
		menu.add(crearMenuItemSalir(unaClase, true));

		return menu;
	}

	/**
	 *
	 */
	public static JMenuItem crearMenuItemAbout(Class unaClase) {

		JMenuItem item = new JMenuItem();
		try {
			ImageIcon icono = SwingResourceManager.getIcon(AccesoController.classForLoadingResources.getClass(), SystemProperties.SISTEMA_ICONO_PATH);
			item.setIcon(icono);
		} catch (Exception e1) {
			e1.getMessage();
			try {
				item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/cubos.png")));
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		item.setForeground(java.awt.Color.darkGray);
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setText("Tame");
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Acerca de");
		item.addActionListener(new efren.util.gui.about.AboutDialog(SystemView.singleton()));

		return item;
	}

	/**
	 *
	 */
	/*
	 * public static JMenuItem crearMenuItemJava(Class unaClase) {
	 * 
	 * JMenuItem item = new JMenuItem(); item.setIcon(new
	 * ImageIcon(unaClase.getResource("/efren/resources/images/java-icon16.png")
	 * )); item.setForeground(java.awt.Color.darkGray); item.setFont(new
	 * java.awt.Font("Arial", java.awt.Font.PLAIN, 10)); item.setText("");
	 * item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	 * item.setToolTipText("Java"); item.addActionListener(new
	 * java.awt.event.ActionListener() { public void
	 * actionPerformed(java.awt.event.ActionEvent e) {
	 * BrowserManager.displayURL("http://www.java.com"); } });
	 * 
	 * return item; }
	 */
	/**
	 *
	 */
	public static JMenuItem crearMenuItemSalir(Class unaClase, boolean full) {

		JMenuItem item = new JMenuItem();
		item.setIcon(new ImageIcon(unaClase.getResource("/efren/resources/images/seguridades/apagar.gif")));
		item.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		item.setForeground(java.awt.Color.darkGray);
		if (full) {
			item.setText("Salir");
		} else {
			item.setText("Salir");
		}
		item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		item.setToolTipText("Salir del Sistema");
		item.addActionListener(SystemView.singleton());
		item.setHorizontalTextPosition(JMenu.RIGHT);
		if (full) {
			item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.ActionEvent.ALT_MASK));
		}
		return item;
	}
}