package efren.util.propertyEditor;

public class TipoCODIGOPropertyEditor extends java.beans.PropertyEditorSupport {

    String[] stringValues =
        { "CARACTERES", "NUMERICO" };
    int[] intValues = { 0, 1 };
    String[] codeGenStrings =
        {
            "efren.abm.beans.FindObjectsPanel.CARACTERES",
            "efren.abm.beans.FindObjectsPanel.NUMERICO"
         };
/**
 * TsEditor constructor comment.
 */
protected TipoCODIGOPropertyEditor() {
	super();
}
/**
 * TsEditor constructor comment.
 * @param source java.lang.Object
 */
protected TipoCODIGOPropertyEditor(Object source) {
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
