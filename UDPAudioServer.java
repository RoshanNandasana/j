import java.io.*;
import java.net.*;

public class UDPAudioServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(12346);
            System.out.println("UDP Server is running on port 12346...");
            
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                String filename = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received filename request: " + filename);
                
                // Read audio file
                File audioFile = new File(filename);
                byte[] fileData = new byte[(int)audioFile.length()];
                FileInputStream fis = new FileInputStream(audioFile);
                fis.read(fileData);
                fis.close();
                
                // Send file content
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(fileData, fileData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Sent audio file content");
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}