public class StringManipulation {
    public static void main(String[] args) {
        String text = "Welcome";
        System.out.println("String: " + text);
        System.out.println("Length of String: " + text.length());
        System.out.println("Character at index 3: " + text.charAt(3));
        System.out.println("Substring (2, 5): " + text.substring(2, 5));
        System.out.println("String in uppercase: " + text.toUpperCase());
        System.out.println("String in lowercase: " + text.toLowerCase());
        System.out.println("Concatenation with ' Home': " + text.concat(" Home"));
        System.out.println("Index of 'o': " + text.indexOf('o'));

        StringBuffer sb = new StringBuffer("Welcome");
        System.out.println("StringBuffer: " + sb);
        sb.append(" Home");
        System.out.println("After append: " + sb);
        sb.insert(8, "Java ");
        System.out.println("After insert: " + sb);
        sb.replace(8, 12, "Wonderful");
        System.out.println("After replace: " + sb);
        sb.delete(8, 17);
        System.out.println("After delete: " + sb);
        sb.reverse();
        System.out.println("After reverse: " + sb);
    }
}