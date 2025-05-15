import java.io.*;

public class SelfPrinting {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("SelfPrinting.java"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading file.");
        }
    }
}
