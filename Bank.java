import java.util.Scanner;

class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Bank {
    private double balance;

    public Bank(double init_balance) {
        this.balance = init_balance;
    }

    public void Deposit(double amount) {
        System.out.println("Old Balance: " + balance);
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public void withdraw(double amount) throws ArithmeticException, NotEnoughMoneyException {
        System.out.println("Old Balance: " + balance);
        if (balance < amount) {
            throw new ArithmeticException("Insufficient balance to withdraw " + amount);
        }
        balance -= amount;
        if (balance < 500) {
            throw new NotEnoughMoneyException("Balance is below 500 after withdrawal. Current balance: " + balance);
        }
        System.out.println("Withdrawn: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank account = new Bank(1000);
        System.out.println("Welcome to the Bank! Your initial balance is: 1000");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.Deposit(depositAmount);
            } else if (choice == 2) {
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                try {
                    account.withdraw(withdrawAmount);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 3) {
                System.out.println("Exiting the bank system. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}