import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "yes";

        while (continueInput.equalsIgnoreCase("yes")) {
            System.out.print("Enter marks obtained (out of 100): ");
            int marks = scanner.nextInt();

            char grade = calculateGrade(marks);
            System.out.println("Grade: " + grade);

            System.out.print("Do you want to continue? (yes/no): ");
            continueInput = scanner.next();
        }

        scanner.close();
        System.out.println("Thank You!");
    }

    public static char calculateGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
