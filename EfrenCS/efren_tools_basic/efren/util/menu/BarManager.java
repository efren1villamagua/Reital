package efren.util.menu;

import java.util.Vector;

public class BarManager {
	public static void manageBar(String classArgs, efren.util.gui.table.DataTablePanel container) {

		Vector<Object> opciones = new Vector<Object>();

		java.util.StringTokenizer stk = new java.util.StringTokenizer(classArgs, "&");
		while (stk.hasMoreElements()) {
			opciones.addElement(stk.nextElement());
		}

		String opcion;

		// verificamos si existe la opcion "todo"
		for (int i = 0; i < opciones.size(); i++) {
			opcion = opciones.elementAt(i).toString();
			if (opcion.compareTo("todo") == 0)
				return;
		}

		// ...
		Vector<String> opcionesPredeterminadas = new Vector<String>();
		opcionesPredeterminadas.addElement("ingresoMasivo");
		opcionesPredeterminadas.addElement("ingresoContinuo");
		opcionesPredeterminadas.addElement("ingreso");
		opcionesPredeterminadas.addElement("modificacion");
		opcionesPredeterminadas.addElement("eliminacion");
		opcionesPredeterminadas.addElement("consulta");

		Vector<String> opcionesAOcultar = new Vector<String>();
		boolean siHayOpcion = false;
		String opcionPredeterminada;
		for (int i = 0; i < opcionesPredeterminadas.size(); i++) {
			opcionPredeterminada = opcionesPredeterminadas.elementAt(i).toString();
			siHayOpcion = false;
			for (int j = 0; j < opciones.size(); j++) {
				opcion = opciones.elementAt(j).toString();
				if (opcion.compareTo(opcionPredeterminada) == 0)
					siHayOpcion = true;
			}
			if (!siHayOpcion)
				opcionesAOcultar.addElement(opcionPredeterminada);
		}

		String opcionAOcultar;
		for (int i = 0; i < opcionesAOcultar.size(); i++) {

			opcionAOcultar = opcionesAOcultar.elementAt(i).toString();

			if (opcionAOcultar.compareTo("ingresoMasivo") == 0)
				container.setOpcionesBarButton02Visible(false);
			else {
				if (opcionAOcultar.compareTo("ingresoContinuo") == 0)
					container.setOpcionesBarButton10Visible(false);
				else {
					if (opcionAOcultar.compareTo("ingreso") == 0)
						container.setOpcionesBarButton00Visible(false);
					else {
						if (opcionAOcultar.compareTo("modificacion") == 0)
							container.setOpcionesBarButton01Visible(false);
						else {
							if (opcionAOcultar.compareTo("consulta") == 0)
								container.setOpcionesBarButton02Visible(false);
							else {
								if (opcionAOcultar.compareTo("eliminacion") == 0) {
									container.setOpcionesBarButton03Visible(false);
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < opciones.size(); i++) {

			opcion = opciones.elementAt(i).toString();

			if (opcion.compareTo("ingresoMasivo") == 0)
				container.setOpcionesBarButton02Visible(true);
			else {
				if (opcion.compareTo("ingresoContinuo") == 0)
					container.setOpcionesBarButton10Visible(true);
				else {
					if (opcion.compareTo("ingreso") == 0)
						container.setOpcionesBarButton00Visible(true);
					else {
						if (opcion.compareTo("modificacion") == 0)
							container.setOpcionesBarButton01Visible(true);
						else {
							if (opcion.compareTo("consulta") == 0)
								container.setOpcionesBarButton02Visible(true);
							else {
								if (opcion.compareTo("eliminacion") == 0) {
									container.setOpcionesBarButton03Visible(true);
								}
							}
						}
					}
				}
			}
		}

	}

}
