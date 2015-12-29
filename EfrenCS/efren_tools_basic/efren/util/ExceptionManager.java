package efren.util;

import java.awt.Container;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import efren.seguridades.gui.SystemView;
import efren.util.config.SystemProperties;
import efren.util.gui.ConsoleDialog;
import efren.util.gui.bars.BarraEstadosPanel;
import efren.util.gui.dialogs.InfoView;

public class ExceptionManager {
	/**
	 *
	 */
    private static ExceptionManager singleton = null;
    private BarraEstadosPanel bar = SystemProperties.RUNTIME_BARRA_STATUS;
    /**
     *
     */
	private ExceptionManager() {
	    super();
	}
	/**
	 *
	 */
	private void clear() {
	    if (this.bar != null) {
		    this.bar.setForeground(java.awt.Color.BLACK);
		    try {
		    	this.bar.setText(SystemView.singleton().getMensajeAbajo());
			} catch (Exception e) {
				e.getMessage();
				this.bar.setText("...");
			}
	    }
	}
	/**
	 *
	 */
	public void manage(Container visualParentObject, boolean showErrorWindow, Object errorSource, Throwable texc) {
		
		manage(visualParentObject, showErrorWindow, errorSource.getClass(), texc);
	}
	/**
	 *
	 */
	public void manage(Container visualParentObject, boolean showErrorWindow, Class sourceClass, Throwable texc) {

		if (texc instanceof ReconnectionException) {
			return;
		}

		String texcMessage = texc.getMessage();
	    if (texc instanceof SQLException) {
	        String sqlState = ((SQLException) texc).getSQLState();
	        if (sqlState != null) {
		        if (sqlState.compareTo("02000") == 0) {
		            texcMessage = "¡ Otro usuario o aplicación actualizó el registro antes que Ud., o el registro ya no existe !";
		        }
		        if (sqlState.compareTo("23505") == 0) {
		        	texcMessage = "¡ Se ha producido clave duplicada !";
		        }
		        if (sqlState.compareTo("23001") == 0) {
		        	texcMessage = "¡ No se puede cambiar o eliminar información de la cual dependen otros registros !";
		        }
		        if (sqlState.compareTo("54001") == 0) {
		        	texcMessage = "¡ La sentencia SQL es demasiada compleja !";
		        }
		        if (sqlState.compareTo("42818") == 0) {
		        	texcMessage = "¡ Los operandos de la sentencia SQL no son compatibles !";
		        }
		        if (sqlState.compareTo("22001") == 0) {
		        	texcMessage = "¡ Uno de los campos es demasiado largo y se lo ha truncado por la derecha !";
		        }
	        }
	    }

	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    texc.printStackTrace(pw);

	    String longMessage =
	    	"Clase: "+sourceClass.getName()+"\n"
	    	+"\tDetalle: "+texcMessage+"\n"
	    	+"\t"+sw.toString();

	    SystemLogManager.error(longMessage);
	    try {
	    	ConsoleDialog.singleton().addMessage(longMessage);
		} catch (Exception exc2) {
			exc2.getMessage();
		}


	    if (this.bar != null) {
	        this.bar.setForeground(java.awt.Color.RED);
	        this.bar.setText(texcMessage);
	    }

	    if (showErrorWindow) {
		    if (visualParentObject == null) {
		    	InfoView.showErrorDialog(SystemView.singleton(), texcMessage);
		    } else {
		    	InfoView.showErrorDialog(visualParentObject, texcMessage);
		    }
	    }

	    try {
	        if (this.bar != null) {
	            Thread aThread = new Thread(new Runnable() {
	                public void run() {
	                    try {
	                        Thread.sleep(5000);
	                        clear();
	                    } catch (Throwable t2) {
	                        t2.getMessage();
	                    }
	                }
	            });
	            aThread.start();
	        }
	    } catch (Exception ex) {
	        SystemLogManager.error(ex.getMessage());
	    }
	}
	/**
	 *
	 */
	public static ExceptionManager singleton() {
	    if (singleton == null) {
	        singleton = new ExceptionManager();
	    }
	    return singleton;
	}
}
