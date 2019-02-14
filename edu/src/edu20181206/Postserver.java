package edu20181206;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Postserver {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
 
            Integer contentLength = null;
 
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
                if(line.length() == 0) {
                    break;
                }
 
                if(line.startsWith("Content-Length")) {
                    contentLength = Integer.parseInt(line.replaceAll("Content-Length: ",""));
                }
            }
 
 
            char[] data = new char[contentLength];
 
            reader.read(data);
 
            System.out.println(java.lang.String.copyValueOf(data));
 
        }
 
    }
 
}