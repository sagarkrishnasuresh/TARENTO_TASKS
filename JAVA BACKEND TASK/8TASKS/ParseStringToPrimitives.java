public class ParseStringToPrimitives {
    public static void main(String[] args) {
        // Sample input Strings
        String intString = "123";
        String doubleString = "45.67";
        String booleanString = "true";
        String charString = "A";

        // Parsing strings to primitive data types
        int parsedInt = Integer.parseInt(intString);
        double parsedDouble = Double.parseDouble(doubleString);
        boolean parsedBoolean = Boolean.parseBoolean(booleanString);
        char parsedChar = charString.charAt(0);  // Since char does not have a parse method

        // Printing parsed values
        System.out.println("Parsed int: " + parsedInt);
        System.out.println("Parsed double: " + parsedDouble);
        System.out.println("Parsed boolean: " + parsedBoolean);
        System.out.println("Parsed char: " + parsedChar);

        // Converting primitive types to strings using valueOf
        String intToString = String.valueOf(parsedInt);
        String doubleToString = String.valueOf(parsedDouble);
        String booleanToString = String.valueOf(parsedBoolean);
        String charToString = String.valueOf(parsedChar);

        // Printing converted string values
        System.out.println("String from int: " + intToString);
        System.out.println("String from double: " + doubleToString);
        System.out.println("String from boolean: " + booleanToString);
        System.out.println("String from char: " + charToString);
    }
}
