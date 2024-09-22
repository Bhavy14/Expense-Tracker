import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Expense {
    private Date date;
    private double amount;
    private String description;
    private String category;

    public Expense(Date date, double amount, String description, String category) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "Date=" + date +
                ", Amount=" + amount +
                ", Description='" + description + '\'' +
                ", Category='" + category + '\'' +
                '}';
    }
}

public class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        // Using ArrayList which implements List interface
        expenses = new ArrayList<Expense>();

    }

    // Add an expense to the collection
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Display all expenses stored in the collection
    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter date (yyyy-MM-dd): ");
                        String dateInput = scanner.nextLine();
                        Date date = dateFormat.parse(dateInput);

                        System.out.println("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline

                        System.out.println("Enter description: ");
                        String description = scanner.nextLine();

                        System.out.println("Enter category (e.g., food, bills): ");
                        String category = scanner.nextLine();

                        Expense newExpense = new Expense(date, amount, description, category);
                        tracker.addExpense(newExpense);
                        System.out.println("Expense added successfully!");

                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;

                case 2:
                    tracker.displayExpenses();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
