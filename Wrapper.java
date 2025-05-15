public class Wrapper {
    public static void main(String[] args) {
        Integer integerValue = Integer.valueOf(150);
        Double doubleVal = Double.valueOf("78.95");
        Boolean booleanVal = Boolean.valueOf("false");

        int primitiveInteger = integerValue.intValue();
        double primitiveDouble = doubleVal.doubleValue();

        int parsedInteger = Integer.parseInt("300");
        double parsedDouble = Double.parseDouble("65.43");

        System.out.println("Integer object: " + integerValue);
        System.out.println("Double object: " + doubleVal);
        System.out.println("Boolean object: " + booleanVal);
        
        System.out.println("Primitive int: " + primitiveInteger);
        System.out.println("Primitive double: " + primitiveDouble);
        
        System.out.println("Parsed int: " + parsedInteger);
        System.out.println("Parsed double: " + parsedDouble);
        
        System.out.println("Maximum of 15 and 30: " + Integer.max(15, 30));
        System.out.println("Minimum of 15 and 30: " + Integer.min(15, 30));
        System.out.println("Binary format of 50: " + Integer.toBinaryString(50));
    }
}