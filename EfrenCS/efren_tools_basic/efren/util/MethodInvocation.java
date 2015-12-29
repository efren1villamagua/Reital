package efren.util;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Vector;


public class MethodInvocation {

	public MethodInvocation() {
		super();
	}
	public static Method getMethod(String aMethodName, Class aClass, Class[] argTypes) throws NoSuchMethodException {
		return aClass.getMethod(aMethodName, argTypes);
	}
	public static Method getMethod(String aMethodName, Class aClass, Object[] args) throws NoSuchMethodException {
		Class[] argTypes;

		argTypes = (args == null) ? null : (new MethodInvocation()).typeArray(args);

		return getMethod(aMethodName, aClass, argTypes);
	}
	public static Method getMethod(String aMethodName, Object anObject) throws NoSuchMethodException {
		return getMethod(aMethodName, anObject, null);
	}
	public static Method getMethod(String aMethodName, Object anObject, Class[] types) throws NoSuchMethodException {
		Class aClass;
		aClass = anObject.getClass();
		return getMethod(aMethodName, aClass, types);
	}
	public static Method getMethod(String aMethodName, Object anObject, Object[] args) throws NoSuchMethodException {
		Class aClass;
		aClass = anObject.getClass();
		return getMethod(aMethodName, aClass, args);
	}
	public static Object performMethod(String aMethodName, Class aClass, Object anObject, Object[] args) {
		return performMethod(aMethodName, aClass, anObject, args, null);
	}
	public static Object performMethod(String aMethodName, Class aClass, Object anObject, Object[] args, Class[] types) {

		try {
			Method aMethod;

			if (types == null)
				aMethod = getMethod(aMethodName, aClass, args);
			else
				aMethod = getMethod(aMethodName, aClass, types);

			return aMethod.invoke(anObject, args);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("NoSuchMethodException");} //$NON-NLS-1$
		catch (InvocationTargetException e) {
			throw new RuntimeException("InvocationTargetException");} //$NON-NLS-1$
		catch (IllegalAccessException e3) {
			throw new RuntimeException("IllegalAccessException");} //$NON-NLS-1$

	}
	public static Object performMethod(String aMethodName, Object anObject) {
		return performMethod(aMethodName, anObject, null);
	}
	public static Object performMethod(String aMethodName, Object anObject, Object[] args) {

		Class aClass;
		aClass = anObject.getClass();
		return performMethod(aMethodName, aClass, anObject, args);
	}
	public static Object performMethod(String aMethodName, Object anObject, Object[] args, Class[] types) {

		Class aClass;
		aClass = anObject.getClass();
		return performMethod(aMethodName, aClass, anObject, args, types);
	}
	public static Object performStaticMethod(String aMethodName, Class aClass) {
		return performStaticMethod(aMethodName, aClass, null);
	}
	public static Object performStaticMethod(String aMethodName, Class aClass, Object[] args) {
		return performMethod(aMethodName, aClass, (Object) null, args);
	}
	private Class[] typeArray(Object[] args) {

		Vector argVector;
		Enumeration argEnum;
		Class[] argTypes = null;

		if (args != null) {
			argVector = ArrayVectorTransform.toVector(args);
			argTypes = new Class[argVector.size()];
			argEnum = argVector.elements();
			int i = 0;
			while (argEnum.hasMoreElements()) {
				argTypes[i] = argEnum.nextElement().getClass();
				i++;
			}
		}
		return argTypes;
	}
}
