import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String continueInput = "yes";
        while (continueInput.equalsIgnoreCase("yes")) { 

            System.out.println("Enter first number:");
            double num1 = reader.nextDouble();

            System.out.println("Enter an operator (+, -, *, /):");
            String operator = reader.next();  

        
            if (operator.length() != 1)
                {
                    System.out.println("Error! Invalid operator input. Please enter only one operator (+, -, *, /).");
                    reader.next();
                    
                }

        
            System.out.println("Enter second number:");
            double num2 = reader.nextDouble();

            double result;

            char operatorInput = operator.charAt(0);

            switch (operatorInput) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':

                    if (num2 != 0) {
                        result = num1 / num2;
                    } 

                    else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return;
                    }
                    break;
                default:
                    System.out.println("Invalid operator! Please use +, -, *, or /.");
                    return;
                }

            System.out.println("The result is: " + result);
            System.out.print("Do you want to continue? (yes/no): ");
            continueInput = reader.next();
            
        }

        
        
    }
}