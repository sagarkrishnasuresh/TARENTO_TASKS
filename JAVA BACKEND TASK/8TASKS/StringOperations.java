public class StringOperations {
    public static void main(String[] args) {
        String input = "Hello, World!";
        
        // Find the length of the string
        int length = input.length();
        System.out.println("Length of the string: " + length);
        
        // Convert the string to uppercase
        String upperCaseString = input.toUpperCase();
        System.out.println("Uppercase string: " + upperCaseString);
        
        // Extract a substring
        //extracting "World" from "Hello, World!"
        String substring = input.substring(7, 12);
        System.out.println("Extracted substring: " + substring);
        
        // Replace a character
        //replacing 'o' with 'a'
        String replacedString = input.replace('o', 'a');
        System.out.println("String after replacement: " + replacedString);
    }
}
