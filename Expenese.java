import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Expenese
{
    private Date date;
    private double amount;
    private String description;
    private String category;
    public Expenese(Date date, double amount, String description, String category) {
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
}
public class ExpenseRecoder{
    private List<Expense> expenses;

    public ExpenseRecoder() {
        expenses = new Arraylist();
    }
    
}   public void recordExpense() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter date (yyyy-mm-dd): ");
    String date = scanner.next();

    System.out.print("Enter amount: ");
    double amount = scanner.nextDouble();

    System.out.print("Enter description: ");
    String description = scanner.next();

    System.out.print("Enter category (food, bills, shopping,school fees etc.): ");
    String category = scanner.next();

    Expense expense = new Expense(date, amount, description, category);
    expenses.add(expense);

    System.out.println("Expense recorded successfully!");
}