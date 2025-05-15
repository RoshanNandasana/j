import java.util.Scanner;

class CustomerAccount {
    private static int nextAccountNo = 1;
    private String customerName;
    private int accountNo;
    private String accountType;
    private double currentBalance;

    public CustomerAccount() {
        this.accountNo = nextAccountNo++;
        this.currentBalance = 0.0;
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        this.customerName = scanner.nextLine();
        System.out.print("Enter Account Type (Current/Savings): ");
        this.accountType = scanner.nextLine();
        System.out.println("Account Created Successfully! Account Number: " + this.accountNo);
    }

    public void depositAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            this.currentBalance += amount;
            System.out.println("Amount Deposited Successfully! New Balance: " + this.currentBalance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdrawAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= this.currentBalance) {
            this.currentBalance -= amount;
            System.out.println("Amount Withdrawn Successfully! Remaining Balance: " + this.currentBalance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + this.accountNo);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Account Type: " + this.accountType);
        System.out.println("Current Balance: " + this.currentBalance);
    }

    public static void main(String[] args) {
        CustomerAccount account = new CustomerAccount();
        account.createAccount();
        account.depositAmount();
        account.withdrawAmount();
        account.checkBalance();
    }
}
