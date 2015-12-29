package efren.util.propertyEditor;

public class DateFormatPropertyEditor extends java.beans.PropertyEditorSupport {

    String[] stringValues =
        { "DIA_MES_ANIO", "DIA_ANIO_MES", "MES_DIA_ANIO", "MES_ANIO_DIA", "ANIO_DIA_MES", "ANIO_MES_DIA" };

    String[] dataValues = { "ddmmyy", "ddyymm", "mmddyy", "mmyydd", "yyddmm", "yymmdd" };

    String[] codeGenStrings =
        {
            "efren.util.gui.TextDate.DIA_MES_ANIO",
            "efren.util.gui.TextDate.DIA_ANIO_MES",
            "efren.util.gui.TextDate.MES_DIA_ANIO",
            "efren.util.gui.TextDate.MES_ANIO_DIA",
            "efren.util.gui.TextDate.ANIO_DIA_MES",
            "efren.util.gui.TextDate.ANIO_MES_DIA" };
/**
 * TsEditor constructor comment.
 */
protected DateFormatPropertyEditor() {
	super();
}
/**
 * TsEditor constructor comment.
 * @param source java.lang.Object
 */
protected DateFormatPropertyEditor(Object source) {
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
