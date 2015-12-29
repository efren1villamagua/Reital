package efren.util;

/**
 * Insert the type's description here.
 * Creation date: (10/12/2003 8:02:20)
 * @author: Efrén Villamagua
 */
public class TextFilePrinterTool {
    private java.io.File file;

    java.io.FileOutputStream fos = null;
    java.io.BufferedWriter bw = null;
public TextFilePrinterTool(java.io.File aTextFile) {
    super();
    this.setFile(aTextFile);

    try {
        this.fos = new java.io.FileOutputStream(aTextFile.getAbsolutePath(), true);
        this.bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(this.fos)));
    } catch (Throwable t) {
        t.getMessage();
    }
}
public void close() {
    try {
        bw.flush();
        bw.close();
    } catch (Throwable t) {
        t.getMessage();
    }
}
public void endPage() {
    //imprime fin de página
    try {
        char fp = 12;//12 es fin de pagina
        this.bw.write(new Character(fp).toString());
    } catch (Throwable t) {
        t.getMessage();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10/12/2003 8:35:21)
 * @return java.io.File
 */
public java.io.File getFile() {
	return file;
}
public void newLine() {
    try {
        this.bw.write("\n");
    } catch (Throwable t) {
        t.getMessage();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10/12/2003 8:35:21)
 * @param newFile java.io.File
 */
public void setFile(java.io.File newFile) {
	file = newFile;
}
public void write(String aText) {
    //imprime este texto en una línea
    try {
        this.bw.write(aText);
    } catch (Throwable t) {
        t.getMessage();
    }
}
}
