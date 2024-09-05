import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private String id;
    private String name;
    private String position;

    public Employee(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + position;
    }
}

// FileHandler class
class FileHandler {

    // Read employee records from a file
    public static List<Employee> readEmployeesFromFile(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Employee employee = new Employee(parts[0], parts[1], parts[2]);
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Write employee records to a file
    public static void writeEmployeesToFile(String filePath, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Tarento\\JAVA BACKEND TASK\\8TASKS\\employees.txt";
        String outputFilePath = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Tarento\\JAVA BACKEND TASK\\8TASKS\\output_employees.txt";

        // Read employee records from file
        List<Employee> employees = FileHandler.readEmployeesFromFile(inputFilePath);

        // Optionally, print out the employees to verify
        System.out.println("Employees read from file:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Write employee records to a new file
        FileHandler.writeEmployeesToFile(outputFilePath, employees);

        System.out.println("\nEmployee records have been written to " + outputFilePath);
    }
}
