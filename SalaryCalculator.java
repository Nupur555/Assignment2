import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the basic payment (4500 to 6500): ");
        double basicPayment = scanner.nextDouble();

        if (basicPayment < 4500 || basicPayment > 6500) {
            System.out.println("Invalid basic payment has been entered.");
            return;
        }

        System.out.print("Enter the age: ");
        int age = scanner.nextInt();

        double da = 0.02 * basicPayment;
        double ta = 0.01 * basicPayment;
        double hr = 0.03 * basicPayment;
        double pf = 0.005* basicPayment;
        
        if (basicPayment > 10000) {
            basicPayment -= 1000;
        }

        double totalSalary = basicPayment + da + ta + hr - pf;

        int retirementAge = 55;
        int yearsLeft = retirementAge - age;
        LocalDate currentDate = LocalDate.now();
        LocalDate retirementDate = currentDate.plusYears(yearsLeft);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\nEmployee Name: " + name);
        System.out.println("Basic Payment: " + basicPayment);
        System.out.println("DA: " + da);
        System.out.println("TA: " + ta);
        System.out.println("HR: " + hr);
        System.out.println("PF: " + pf);
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Retirement Date: " + retirementDate.format(formatter));

        scanner.close();
    }
}