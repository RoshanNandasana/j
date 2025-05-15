import java.util.Scanner;

abstract class TextCoder {
    String inputText;
    int shiftValue;
    
    TextCoder(String text, int shift) {
        inputText = text;
        shiftValue = shift;
    }
    
    abstract String encode();
    abstract String decode();
}

class LetterSwapCoder extends TextCoder {
    String normal = "abcdefghijklmnopqrstuvwxyz";
    String coded = "qazwsxedcrfvtgbyhnujmikolp";
    
    LetterSwapCoder(String text, int shift) {
        super(text, shift);
    }
    
    String encode() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < inputText.length(); i++) {
            int pos = normal.indexOf(inputText.charAt(i));
            result.append(coded.charAt(pos));
        }
        return result.toString();
    }
    
    String decode() {
        StringBuilder result = new StringBuilder();
        String encrypted = encode();
        for(int i = 0; i < encrypted.length(); i++) {
            int pos = coded.indexOf(encrypted.charAt(i));
            result.append(normal.charAt(pos));
        }
        return result.toString();
    }
}

class ShiftCoder extends TextCoder {
    ShiftCoder(String text, int shift) {
        super(text, shift);
    }
    
    String encode() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < inputText.length(); i++) {
            char ch = (char)((inputText.charAt(i) - 'a' + shiftValue) % 26 + 'a');
            result.append(ch);
        }
        return result.toString();
    }
    
    String decode() {
        StringBuilder result = new StringBuilder();
        String encrypted = encode();
        for(int i = 0; i < encrypted.length(); i++) {
            char ch = (char)((encrypted.charAt(i) - 'a' - shiftValue + 26) % 26 + 'a');
            result.append(ch);
        }
        return result.toString();
    }
}

public class TextCoderDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter text for Letter Swap Coder:");
        String swapText = input.nextLine();
        LetterSwapCoder swapCoder = new LetterSwapCoder(swapText, 0);
        System.out.println("Encoded: " + swapCoder.encode());
        System.out.println("Decoded: " + swapCoder.decode());
        
        System.out.println("\nEnter text for Shift Coder:");
        String shiftText = input.nextLine();
        System.out.println("Enter shift value:");
        int shift = input.nextInt();
        ShiftCoder shiftCoder = new ShiftCoder(shiftText, shift);
        System.out.println("Encoded: " + shiftCoder.encode());
        System.out.println("Decoded: " + shiftCoder.decode());
    }
}