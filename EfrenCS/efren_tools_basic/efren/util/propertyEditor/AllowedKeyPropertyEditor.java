package efren.util.propertyEditor;

public class AllowedKeyPropertyEditor extends java.beans.PropertyEditorSupport {

    String[] stringValues =
        { "AK_SOLO_NUMEROS", "AK_NUMEROS_CON_FRACCION", "AK_SOLO_LETRAS", "AK_ALFANUMERICOS" };
    int[] intValues = { 0, 1, 2, 3 };
    String[] codeGenStrings =
        {
            "efren.util.gui.TextFieldExt.AllowedKey.AK_SOLO_NUMEROS",
            "efren.util.gui.TextFieldExt.AllowedKey.AK_NUMEROS_CON_FRACCION",
            "efren.util.gui.TextFieldExt.AllowedKey.AK_SOLO_LETRAS",
            "efren.util.gui.TextFieldExt.AllowedKey.AK_ALFANUMERICOS" };
/**
 * TsEditor constructor comment.
 */
protected AllowedKeyPropertyEditor() {
	super();
}
/**
 * TsEditor constructor comment.
 * @param source java.lang.Object
 */
protected AllowedKeyPropertyEditor(Object source) {
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
