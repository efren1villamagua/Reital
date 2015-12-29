package efren.util.remotefile;

import java.io.*;
import java.net.*;
public class RemoteFileServer {
    int listenPort;
public RemoteFileServer(int aListenPort) {
    listenPort = aListenPort;
}
public void acceptConnections() {
    try {
        ServerSocket server = new ServerSocket(listenPort);
        Socket incomingConnection = null;
        while (true) {
            incomingConnection = server.accept();
            handleConnection(incomingConnection);
        }
    } catch (BindException e) {
        System.out.println("Unable to bind to port " + listenPort);
        System.out.println(e.getStackTrace());
    } catch (IOException e) {
        System.out.println(
            "Unable to instantiate a ServerSocket on port: " + listenPort);
    }
}
public void handleConnection(Socket incomingConnection) {
    try {

	    System.out.println("accepting from: "+incomingConnection.getInetAddress());
	    
        OutputStream outputToSocket = incomingConnection.getOutputStream();
        InputStream inputFromSocket = incomingConnection.getInputStream();
        BufferedReader streamReader =
            new BufferedReader(new InputStreamReader(inputFromSocket));
        FileReader fileReader = new FileReader(new File(streamReader.readLine()));
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);
        PrintWriter streamWriter =
            new PrintWriter(incomingConnection.getOutputStream());
        String line = null;
        while ((line = bufferedFileReader.readLine()) != null) {
            streamWriter.println(line);
        }
        fileReader.close();
        streamWriter.close();
        streamReader.close();
    } catch (Exception e) {
        System.out.println("Error handling a client: " + e);
        System.out.println(e.getStackTrace());
    }
}
public static void main(String[] args) {
    RemoteFileServer server = new RemoteFileServer(3000);
    server.acceptConnections();
}
}