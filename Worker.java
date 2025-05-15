import java.util.Scanner;

class Worker {
    private String employeeName;
    private double baseSalary;
    private double allowance;
    private double totalSalary;
    private double taxDeduction;
    private double finalSalary;

    public Worker(String employeeName, double baseSalary) {
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
        this.allowance = 0.74 * baseSalary;
        this.totalSalary = this.baseSalary + this.allowance;
        this.taxDeduction = (this.totalSalary > 100000) ? (this.totalSalary - 100000) * 0.10 : 0;
        this.finalSalary = this.totalSalary - this.taxDeduction;
    }

    public void displaySalaryInfo() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Base Salary (Yearly): Rs. " + baseSalary);
        System.out.println("Allowance: Rs. " + allowance);
        System.out.println("Total Salary: Rs. " + totalSalary);
        System.out.println("Tax Deducted at Source: Rs. " + taxDeduction);
        System.out.println("Final Salary: Rs. " + finalSalary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Base Salary: ");
        double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(employeeName, baseSalary);
        worker.displaySalaryInfo();
    }
}
