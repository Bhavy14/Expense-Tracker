import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private List<Expense> expenses;
    private List<Income> incomes;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
    }

    // Add Expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Add Income
    public void addIncome(Income income) {
        incomes.add(income);
    }

    // Get Expenses (for file handling)
    public List<Expense> getExpenses() {
        return expenses;
    }

    // Get Incomes (for file handling)
    public List<Income> getIncomes() {
        return incomes;
    }

    // Display all Expenses
    public void displayExpenses() {
        System.out.println("\n----- Expenses -----");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Display all Incomes
    public void displayIncomes() {
        System.out.println("\n----- Incomes -----");
        for (Income income : incomes) {
            System.out.println(income);
        }
    }
}
