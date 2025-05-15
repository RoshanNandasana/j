import java.util.Scanner;

public class SimpleCipher {
    String originalText;
    int shiftKey;

    public SimpleCipher(String originalText, int shiftKey) {
        this.originalText = originalText;
        this.shiftKey = shiftKey;
    }

    public String encrypt() {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            char ch = originalText.charAt(i);
            char encryptedChar = (char) (ch + shiftKey);
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    public String decrypt() {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            char ch = originalText.charAt(i);
            char decryptedChar = (char) (ch - shiftKey);
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String inputText = scanner.nextLine();
        System.out.print("Enter shift key: ");
        int key = scanner.nextInt();

        SimpleCipher cipher = new SimpleCipher(inputText, key);

        String encrypted = cipher.encrypt();
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = cipher.decrypt();
        System.out.println("Decrypted Text: " + decrypted);

        scanner.close();
    }
}