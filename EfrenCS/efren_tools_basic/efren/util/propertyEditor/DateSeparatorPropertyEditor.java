package efren.util.propertyEditor;

public class DateSeparatorPropertyEditor extends java.beans.PropertyEditorSupport {

    String[] stringValues =
        { "BARRA_INCLINADA_A_LA_DERECHA", "BARRA_INCLINADA_A_LA_IZQUIERDA", "GUION", "GUION_UNDERSCORE" };

    String[] dataValues = { "/", "\\", "-", "_" };

    String[] codeGenStrings =
        {
            "efren.util.gui.TextDate.BARRA_INCLINADA_A_LA_DERECHA",
            "efren.util.gui.TextDate.BARRA_INCLINADA_A_LA_IZQUIERDA",
            "efren.util.gui.TextDate.GUION",
            "efren.util.gui.TextDate.GUION_UNDERSCORE" };
/**
 * TsEditor constructor comment.
 */
protected DateSeparatorPropertyEditor() {
	super();
}
/**
 * TsEditor constructor comment.
 * @param source java.lang.Object
 */
protected DateSeparatorPropertyEditor(Object source) {
	super(source);
}
   public String getAsText() {
	  for (int i=0; i< dataValues.length; i++) {
		 if (dataValues[i] == ((String) getValue()).toString())
			return stringValues[i];
	  }
	  return "";
   }                  
   public String getJavaInitializationString() {
	  for (int i=0; i< dataValues.length; i++) {
		 if (dataValues[i] == ((String) getValue()).toString())
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
			setValue(dataValues[i]);
			return;
		 }
	  }
	  throw new java.lang.IllegalArgumentException(text);
   }               
}
