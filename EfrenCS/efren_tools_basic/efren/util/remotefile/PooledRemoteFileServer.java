package efren.util.remotefile;

import java.io.*;
import java.net.*;
public class PooledRemoteFileServer {
    protected int maxConnections;
    protected int listenPort;
    protected ServerSocket serverSocket;
public PooledRemoteFileServer(int aListenPort, int maxConnections) {
    listenPort = aListenPort;
    this.maxConnections = maxConnections;
}
public void acceptConnections() {
    try {
        ServerSocket server = new ServerSocket(listenPort, 5);
        Socket incomingConnection = null;
        while (true) {
            incomingConnection = server.accept();
            handleConnection(incomingConnection);
        }
    } catch (BindException e) {
        System.out.println("Unable to bind to port " + listenPort);
    } catch (IOException e) {
        System.out.println(
            "Unable to instantiate a ServerSocket on port: " + listenPort);
    }
}
protected void handleConnection(Socket connectionToHandle) {
    PooledConnectionHandler.processRequest(connectionToHandle);
}
public static void main(String[] args) {
	int puerto = -1;
	int maximoConexiones = -1;
	if (args.length < 2) {
		System.out.println("Los argumentos tienen que ser: puerto maximoConexiones");
		System.exit(0);
	} else {
		try {
			puerto = new Integer(args[0].trim()).intValue();
			maximoConexiones = new Integer(args[1].trim()).intValue();
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			System.exit(0);
		}
	}
    PooledRemoteFileServer server = new PooledRemoteFileServer(puerto, maximoConexiones);
    server.setUpHandlers();
    server.acceptConnections();
}
public void setUpHandlers() {
    for (int i = 0; i < maxConnections; i++) {
        PooledConnectionHandler currentHandler = new PooledConnectionHandler();
        new Thread(currentHandler, "Handler " + i).start();
    }
}
}