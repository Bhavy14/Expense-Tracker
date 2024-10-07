import java.io.*;
import java.time.LocalDate;

public class FileHandler {
    private static final String DATA_FILE = "data.txt"; // Specify your data file name

    // Load expenses and incomes from the file
    public static void loadData(ExpenseTracker tracker) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0];
                LocalDate date = LocalDate.parse(data[1]);
                double amount = Double.parseDouble(data[2]);
                String description = data[3];

                if (type.equals("Expense")) {
                    String category = data[4];
                    Expense expense = new Expense(date, amount, description, category);
                    tracker.addExpense(expense);
                } else if (type.equals("Income")) {
                    String source = data[4];
                    Income income = new Income(date, amount, source,description); 
                    tracker.addIncome(income);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

    // Save expenses and incomes to the file
    public static void saveData(ExpenseTracker tracker) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Expense expense : tracker.getExpenses()) {
                writer.write("Expense," + expense.getDate() + "," + expense.getAmount() + "," + expense.getDescription() + "," + expense.getCategory());
                writer.newLine();
            }
            for (Income income : tracker.getIncomes()) {
                writer.write("Income," + income.getDate() + "," + income.getAmount() + "," + income.getDescription() + "," + income.getSource());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving data.");
        }
    }
}
