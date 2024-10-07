import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Expense 
{
    private LocalDate date;
    private double amount;
    private String description;
    private String category;

    public Expense(LocalDate date, double amount, String description, String category) 
    {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() 
    {
        return "\n\nExpense \n{\n Date : " + date + "\n Amount : " + amount + "\n Description : " + description + "\n Category : " + category + " \n}";
    }
}

class Income 
{
    private LocalDate date;
    private double amount;
    private String source;

    public Income(LocalDate date, double amount, String source) 
    {
        this.date = date;
        this.amount = amount;
        this.source = source;
    }

    @Override
    public String toString() 
    {
        return "Income { Date = " + date + ", Amount = " + amount + ", Source = " + source + " }";
    }
}

// Manages both expenses and incomes
public class ExpenseTracker 
{
    private List<Expense> expenseList = new ArrayList<>();
    private List<Income> incomeList = new ArrayList<>();

    // Add an expense
    public void addExpense(Expense expense) 
    {
        expenseList.add(expense);
    }

    // Add income
    public void addIncome(Income income) 
    {
        incomeList.add(income);
    }

    // Display all expenses
    public void displayExpenses() 
    {
        if (expenseList.isEmpty()) 
        {
            System.out.println("No expenses recorded.");
        } 
        else 
        {
            System.out.println("\nList of Expenses:");
            for (Expense expense : expenseList) 
            {
                System.out.println(expense);
            }
        }
    }

    // Display all incomes
    public void displayIncomes() 
    {
        if (incomeList.isEmpty()) 
        {
            System.out.println("No income recorded.");
        } 
        else 
        {
            System.out.println("\nList of Incomes:");
            for (Income income : incomeList) 
            {
                System.out.println(income);
            }
        }
    }
}
