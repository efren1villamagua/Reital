package efren.util;

/**
 * Este clase fue creada por:
 * Luis Angel Munoz Calle
 */
public class OrderedVector extends java.util.Vector {
	java.util.Vector vector;
public OrderedVector(java.util.Vector vector) {
	super();
	this.vector = vector;
}
/**
 * Este metodo fue creado por:
 * Ing Luis Angel Munoz Calle
 */
public java.util.Vector ordenar() throws NoSuchMethodException, java.lang.reflect.InvocationTargetException, IllegalAccessException {
	return ordenar("getAtributoOrdenable");
}
/**
 * Este metodo fue creado por:
 * Ing Luis Angel Munoz Calle
 */
public java.util.Vector ordenar(String atributoOrdenable) throws NoSuchMethodException, 
								java.lang.reflect.InvocationTargetException, IllegalAccessException {
    int valor1 = 0, valor2 = 0;
    String valorStr1 = null, valorStr2 = null;
    int j = 0;
    Object temp, o1, o2;
    j = vector.size();
    while (j != 0) {
        for (int i = 0; i < vector.size() - 1; i++) {
            // primer valor
            o1 = MethodInvocation.performMethod(atributoOrdenable, vector.elementAt(i));
            o2 = MethodInvocation.performMethod(atributoOrdenable, vector.elementAt(i + 1));
            if (o1 instanceof String)
                valorStr1 = o1.toString().trim();
            else {
                if (o1 instanceof Long)
                    valor1 = ((Long) o1).intValue();
                else
                    if (o1 instanceof Integer)
                        valor1 = ((Integer) o1).intValue();
                    else
                        valor1 = 0;
            }
            // segundo valor
            if (o2 instanceof String)
                valorStr2 = o2.toString().trim();
            else {
                if (o2 instanceof Long)
                    valor2 = ((Long) o2).intValue();
                else
                    if (o2 instanceof Integer)
                        valor2 = ((Integer) o2).intValue();
                    else
                        valor2 = 0;
            }
            // ...
            if (o1 instanceof String) {
            	if (valorStr1.compareTo(valorStr2) > 0) {
             	   temp = vector.elementAt(i);
             	   vector.setElementAt(vector.elementAt(i + 1), i);
             	   vector.setElementAt(temp, i + 1);
            	}	            
            } else {
            	if (valor1 > valor2) {
             	   temp = vector.elementAt(i);
             	   vector.setElementAt(vector.elementAt(i + 1), i);
             	   vector.setElementAt(temp, i + 1);
            	}
            }
        }
        j--;
    }
    return vector;
}
}
