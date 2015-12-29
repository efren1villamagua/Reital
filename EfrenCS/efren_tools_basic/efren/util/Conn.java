package efren.util;

import java.io.File;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;

import efren.seguridades.gui.SystemAdminView;
import efren.seguridades.gui.SystemView;
import efren.util.config.Constantes;
import efren.util.config.SystemProperties;
import efren.util.gui.dialogs.InfoView;

public class Conn {
	private static java.sql.Connection con;
	//private static boolean reconectarseEnCasoError = true;
	public static java.sql.Connection conectar() {
	    try {
	        if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_2_WINDOWS_UNIX) {
	            Statement stPrueba = con.createStatement();
	            stPrueba.executeQuery("VALUES CURRENT DATE");
	            stPrueba.close();
	            //con.getCatalog();
	        }
	    } catch (java.sql.SQLException sqle) {
	        SystemLogManager.error(sqle.getMessage());
            SystemProperties.RUNTIME_BARRA_STATUS_MENSAJE = sqle.getMessage();
	        //InfoView.showErrorDialog(new JFrame(), sqle.getMessage());
/*
        	Thread aThread = new Thread(new Runnable() {
        		public void run() {
        		    try {

            			Font fontOriginal = new java.awt.Font("Arial", Font.BOLD, 10);
            			Color foregroundOriginal = new java.awt.Color(72,61,139);

            			String mensajeNuevo = "ERROR EN LA CONEXION: "+Constantes.BARRA_STATUS_MENSAJE;
            			Font fontNuevo = new Font("Arial", Font.BOLD, 12);
            			Color foregroundNuevo = Color.red;
            			Constantes.BARRA_STATUS.setText(mensajeNuevo);
            			Constantes.BARRA_STATUS.setTextFont(fontNuevo);
            			Constantes.BARRA_STATUS.setTextForeground(foregroundNuevo);

            			Thread.sleep(4000);

        		        String mensajeAbajo = Constantes.DATA_STORE_NAME+"»"+Constantes.SERVER_NAME+"»"+SystemProperties.RUNTIME_USER_NAME+"»"+SystemProperties.RUNTIME_NOMBRE_USUARIO
                        +"»(JDK"+System.getProperty("java.version")+"»"+System.getProperty("os.name")
                        +"»"+System.getProperty("os.arch")+"»"+System.getProperty("os.version")
                        +"»"+java.net.InetAddress.getLocalHost()+")»"
                        +"Conectado desde: "+efren.util.Constantes.INIT_CONECTION_CALENDAR_MANAGER.getAbsoluteRegionalDateExpression();

            			Constantes.BARRA_STATUS.setText(mensajeAbajo);
            			Constantes.BARRA_STATUS.setTextFont(fontOriginal);
            			Constantes.BARRA_STATUS.setTextForeground(foregroundOriginal);
                    } catch (Exception e) {
                        e.getMessage();
                    }
        		}
        	});
        	aThread.start();
*/

		    //SI LA CONEXION NO SIRVE NOS VOLVEMOS A RECONECTAR
		    try {
		        int opcionEscogida = -1;
		        if (SystemView.singleton() != null)
		            opcionEscogida = InfoView.showConfirmDialog(SystemView.singleton(), "La conexión al Servidor no es válida. Desea seguir intentando re-conectarse?");
		        else {
		            if (SystemAdminView.singleton() != null)
		                opcionEscogida = InfoView.showConfirmDialog(SystemAdminView.singleton(), "La conexión al Servidor no es válida. Desea seguir intentando re-conectarse?");
		            else
		                opcionEscogida = InfoView.showConfirmDialog(new JFrame(), "La conexión al Servidor no es válida. Desea seguir intentando re-conectarse?");
		        }
//		        if (reconectarseEnCasoError && opcionEscogida == InfoView.YES_OPTION) {
		        if (opcionEscogida == InfoView.YES_OPTION) {
//				    if (sqle.getMessage() !=null && sqle.getMessage().indexOf("CLI06") > 0) {
					    try {
						    con.close();
					    } catch (Throwable t) {
					    	t.getMessage();
					    }

					    String clientInformation = "S."+SystemProperties.SISTEMA_OID+"."+SystemProperties.RUNTIME_USER_NAME;
					    Properties properties = new Properties();

					    properties.put("clientProgramName", clientInformation);
			            properties.put("clientAccountingInformation", SystemProperties.RUNTIME_USER_NAME);
			            properties.put("clientUser", SystemProperties.RUNTIME_USER_NAME);

						String dbName = SystemProperties.DATA_STORE_NAME;
				        String url = null;

				        if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_1_OS400) {//as400
					        Class.forName("com.ibm.as400.access.AS400JDBCDriver");
					        url = "jdbc:as400://"+SystemProperties.DATA_STORE_IP+";prompt=false;transaction isolation=read uncommitted;libraries="+SystemProperties.SCHEMA_PRINCIPAL
					        	+";date format=iso;time format=iso";
				        } else {
					        if (SystemProperties.SERVER_TYPE == Constantes.SERVER_TYPE_2_WINDOWS_UNIX) {//windows
						        if (SystemProperties.DATA_STORE_IP == null || SystemProperties.DATA_STORE_IP.trim().length() == 0) {
						            Class.forName("COM.ibm.db2.jdbc.app.DB2Driver").newInstance();
						            url = "jdbc:db2:" + dbName;
						        } else {
						            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
						            url = "jdbc:db2://" + SystemProperties.DATA_STORE_IP + ":" + SystemProperties.DATA_STORE_PORT + "/" + dbName;
						        }
					        }
				        }

				        properties.put("user", SystemProperties.RUNTIME_USER_NAME);
			            properties.put("password", SystemProperties.RUNTIME_USER_PASSWORD);
						con = java.sql.DriverManager.getConnection(url, properties);

						java.sql.Statement st2 = con.createStatement();
				        st2.execute("SET SCHEMA='" + SystemProperties.SCHEMA_PRINCIPAL + "'");
				        st2.close();
				    } else {
				        //reconectarseEnCasoError = true;
				        int salirONo = InfoView.showConfirmDialog(SystemView.singleton(), "Desea salir del Sistema?");
				        if (salirONo == InfoView.YES_OPTION) {
				            System.exit(0);
				        }
				    }
//		        } else
//		            reconectarseEnCasoError = false;
	   	    } catch (Throwable t2) {
	   	    	efren.util.ExceptionManager.singleton().manage(new JFrame(), true, "efren.util.Conn", t2);
		    }

	    }
	    return con;
	}

	public static void setCon(java.sql.Connection aCon) {
	    con = aCon;
	}
}
