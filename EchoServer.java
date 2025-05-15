import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running on port 12345...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                
                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        
                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received: " + message);
                            out.println("Echo: " + message);
                        }
                        
                        clientSocket.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}