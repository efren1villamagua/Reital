package efren.util.propertyEditor;

public class KeyMaskPropertyEditor extends java.beans.PropertyEditorSupport {

    String[] stringValues = { "KM_MAYUSCULAS", "KM_minusculas", "KM_Mayusculas_Y_Minusculas", "KM_Moneda", "KM_Numero" };
    int[] intValues = { 0, 1, 2, 3, 4 };
    String[] codeGenStrings =
        {
            "efren.util.gui.TextFieldExt.KeyMask.KM_MAYUSCULAS",
            "efren.util.gui.TextFieldExt.KeyMask.KM_minusculas",
            "efren.util.gui.TextFieldExt.KeyMask.KM_Mayusculas_Y_Minusculas",
            "efren.util.gui.TextFieldExt.KeyMask.KM_Moneda",
            "efren.util.gui.TextFieldExt.KeyMask.KM_Numero" };
/**
 * TsEditor constructor comment.
 */
protected KeyMaskPropertyEditor() {
	super();
}
/**
 * TsEditor constructor comment.
 * @param source java.lang.Object
 */
protected KeyMaskPropertyEditor(Object source) {
	super(source);
}
   public String getAsText() {
	  for (int i=0; i< intValues.length; i++) {
		 if (intValues[i] == ((Integer) getValue()).intValue())
			return stringValues[i];
	  }
	  return "";
   }         
   public String getJavaInitializationString() {
	  for (int i=0; i< intValues.length; i++) {
		 if (intValues[i] == ((Integer) getValue()).intValue())
			return codeGenStrings[i];
	  }
	  return "0";
   }         
   public String[] getTags() {
	  return stringValues;
   }         
   public void setAsText(String text) throws java.lang.IllegalArgumentException {
	  for (int i=0; i< stringValues.length; i++) {
		 if (stringValues[i].equals(text)) {
			setValue(new Integer(intValues[i]));
			return;
		 }
	  }
	  throw new java.lang.IllegalArgumentException(text);
   }         
}
