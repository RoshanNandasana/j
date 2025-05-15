import java.util.Scanner;

public class ShiftCipher {
    String message;
    int key;

    public ShiftCipher(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String encrypt() {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch + key);
                if (Character.isUpperCase(ch) && shiftedChar > 'Z') {
                    shiftedChar -= 26;
                } else if (Character.isLowerCase(ch) && shiftedChar > 'z') {
                    shiftedChar -= 26;
                }
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch - key);
                if (Character.isUpperCase(ch) && shiftedChar < 'A') {
                    shiftedChar += 26;
                } else if (Character.isLowerCase(ch) && shiftedChar < 'a') {
                    shiftedChar += 26;
                }
                decryptedText.append(shiftedChar);
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();
        System.out.print("Enter the shift key: ");
        int key = scanner.nextInt();

        ShiftCipher cipher = new ShiftCipher(message, key);
        String encryptedText = cipher.encrypt();
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = cipher.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}