package efren.util.remotefile;

import java.io.*;
import java.net.*;
public class ConnectionHandler implements Runnable {
    protected Socket socketToHandle;
    public ConnectionHandler(Socket aSocketToHandle) {
        socketToHandle = aSocketToHandle;
    }
public void run() {
    try {
        PrintWriter streamWriter = new PrintWriter(socketToHandle.getOutputStream());
        BufferedReader streamReader =
            new BufferedReader(new InputStreamReader(socketToHandle.getInputStream()));
        String fileToRead = streamReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
        String line = null;
        while ((line = fileReader.readLine()) != null)
            streamWriter.println(line);
        fileReader.close();
        streamWriter.close();
        streamReader.close();
    } catch (Exception e) {
        System.out.println("Error handling a client: " + e);
    }
}
}