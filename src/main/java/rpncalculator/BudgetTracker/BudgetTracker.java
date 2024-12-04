package rpncalculator.BudgetTracker;

import java.util.Scanner;

public class BudgetTracker {
    private double balance;

    public BudgetTracker() {
        this.balance = 0.0;
    }

    public void addIncome(double amount) {
        balance += amount;
    }

    public void addExpense(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    // Reset the balance to 0
    public void resetBalance() {
        balance = 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetTracker tracker = new BudgetTracker();

        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Reset Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: ");
                    double income = scanner.nextDouble();
                    tracker.addIncome(income);
                    break;
                case 2:
                    System.out.print("Enter expense amount: ");
                    double expense = scanner.nextDouble();
                    tracker.addExpense(expense);
                    break;
                case 3:
                    System.out.println("Current Balance: Rs" + tracker.getBalance());
                    break;
                case 4:
                    tracker.resetBalance();
                    System.out.println("Balance has been reset to Rs" + tracker.getBalance());
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
