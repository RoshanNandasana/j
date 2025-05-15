import java.io.*;
import java.net.*;

public class UDPAudioClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12346;
            
            // Send filename
            String filename = "audio.mp3"; // Change this to your audio file name
            byte[] sendData = filename.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            System.out.println("Requested file: " + filename);
            
            // Receive file content
            byte[] receiveData = new byte[65000]; // Larger buffer for audio data
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            
            // Save received data to file
            String outputFile = "received_audio.mp3";
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(receivePacket.getData(), 0, receivePacket.getLength());
            fos.close();
            
            System.out.println("Audio file received and saved as " + outputFile);
            clientSocket.close();
            
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}