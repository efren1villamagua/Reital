package efren.util.remotefile;

import java.awt.Container;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
//import java.util.Date;
//import java.util.Timer;
//import java.util.TimerTask;

//import efren.dialogs.InfoView;
//import efren.seguridades.gui.AccesoView;
import efren.util.config.Constantes;
import efren.util.gui.dialogs.InfoView;

public class RemoteFileClient {


    protected BufferedReader socketReader;
    protected PrintWriter socketWriter;
    protected String hostIp;
    protected int hostPort;

//    private static String fileName;
//    private static Thread runningThread;
//    private static AccesoView parentFrame;
//    private static boolean HUBO_FALLA = true;

    public RemoteFileClient(String aHostIp, int aHostPort) {
        hostIp = aHostIp;
        hostPort = aHostPort;
    }
    public String getFileAndSetupValues(String fileNameToGet) {
        StringBuffer fileLines = new StringBuffer();
        try {
            socketWriter.println(fileNameToGet);
            socketWriter.flush();
            String line = null;
            int i = 1;
            java.util.StringTokenizer stk;
            while ((line = socketReader.readLine()) != null) {
	            //esta implementación trae directamente los datos de UTIL97 y UTIL98
	            if (i == 1) {
		            stk = new java.util.StringTokenizer(line, "&&&&");
		            stk.nextToken();//para avanzar al dato
//		            efren.util.SystemProperties.RUNTIME_UTIL97 = stk.nextToken();
	            }
	            if (i == 2) {
		            stk = new java.util.StringTokenizer(line, "&&&&");
		            stk.nextToken();//para avanzar al dato
		            //efren.util.SystemProperties.RUNTIME_UTIL98 = stk.nextToken();
	            }
                fileLines.append(line + "\n");
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + fileNameToGet);
        }
        return fileLines.toString();
    }
/*
public static void main(String[] args) {
    initAll("UTIL.efren");
}
*/
    public void setUpConnection() throws Exception {
        //try {
            Socket client = new Socket(hostIp, hostPort);
            socketReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            socketWriter = new PrintWriter(client.getOutputStream());
        //} catch (UnknownHostException e) {
        //    System.out.println("Error setting up socket connection: unknown host at " + hostIp);
        //} catch (IOException e) {
        //    System.out.println("Error setting up socket connection: " + e);
        //}
    }
    public void tearDownConnection() {
        try {
            socketWriter.close();
            socketReader.close();
        } catch (IOException e) {
            System.out.println("Error tearing down socket connection: " + e);
        }
    }


public static boolean initAll(Container unContainerVisual, String aFileName) {
//      public static void initAll(String aFileName, AccesoView aParentFrame) {

/*
    try {
        RemoteFileClient.fileName = aFileName;
        RemoteFileClient.parentFrame = aParentFrame;

		Thread aThread = new Thread(new Runnable() {
			public void run() {
			    AccesoView.trayendoUTIL97 = true;

*/
    try {
    	/**ANULADO CUANDO SE CAMBIÓ EL ESQUEMA DE LOS SISTEMAS
        RemoteFileClient remoteFileClient = new RemoteFileClient(Constantes.UTIL_efren_server, new Long(Constantes.UTIL_efren_port).intValue());
        remoteFileClient.setUpConnection();
        //String fileContents = remoteFileClient.getFileAndSetupValues("./"+RemoteFileClient.fileName);
        String fileContents = remoteFileClient.getFileAndSetupValues("./"+aFileName);
        remoteFileClient.tearDownConnection();
        */
    } catch (Exception e) {
        e.getMessage();
        InfoView.showErrorDialog(unContainerVisual, "ERROR DE CONEXION AL SERVIDOR: "+e.getMessage());
        return false;
    }
    return true;

/*

		        RemoteFileClient.HUBO_FALLA = false;
		        AccesoView.trayendoUTIL97 = false;
			}
		});
		aThread.start();
		runningThread = aThread;

        int numberOfMillisecondsInTheFuture = 120000;
        Date timeToRun = new Date(System.currentTimeMillis()+numberOfMillisecondsInTheFuture);
        Timer timer = new Timer();

        timer.schedule(
                new TimerTask() {
                    public void run() {
                        if (RemoteFileClient.HUBO_FALLA) {
                            InfoView.showErrorDialog(RemoteFileClient.parentFrame, "El servidor \"remotefile\" no responde. Contáctese con el Administrador del Sistema.");
                            RemoteFileClient.parentFrame.stopAutentication();
                            System.exit(0);
                        }
                    }
                }, timeToRun
        );


    } catch (Throwable t) {
        t.getMessage();
    }
*/
}
/*
public static void initAll(String aFileName, String aServerName, int aPort) {
    try {
        RemoteFileClient remoteFileClient = new RemoteFileClient(aServerName, aPort);
        remoteFileClient.setUpConnection();
        String fileContents = remoteFileClient.getFileAndSetupValues("./"+aFileName);
        remoteFileClient.tearDownConnection();
        //System.out.println(fileContents);
    } catch (Throwable t) {
        t.getMessage();
    }
}
*/

}