import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        CategoryList categoryList = new CategoryList();
        Budgetsetting1 budgetSetting = new Budgetsetting1(); // For setting budget
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Load existing data from file
        FileHandler.loadData(tracker);
        categoryList.loadCategories();

        while (true) {
            System.out.println("\n-------------------------- Expense Tracker --------------------------");
            System.out.println("1. Add New Expense");
            System.out.println("2. Add New Income");
            System.out.println("3. Manage Categories");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. View Current Budget");
            System.out.println("6. View All Expenses");
            System.out.println("7. View All Incomes");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(tracker, categoryList, scanner, dateFormatter);
                    break;
                case 2:
                    addIncome(tracker, scanner, dateFormatter);
                    break;
                case 3:
                    manageCategories(categoryList, scanner);//Manage Categories
                    break;
                case 4:
                    budgetSetting.setmonthlybudget(); // Set monthly budget
                    break;
                case 5:
                    Budgetsetting1.show2(); // View current budget
                    break;
                case 6:
                    tracker.displayExpenses();
                    break;
                case 7:
                    tracker.displayIncomes();
                    break;
                case 8:
                    // Save data before exiting
                    FileHandler.saveData(tracker);
                    categoryList.saveCategories();
                    System.out.println("Exiting and saving data...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Function to add Expense
    private static void addExpense(ExpenseTracker tracker, CategoryList categoryList, Scanner scanner, DateTimeFormatter dateFormatter) {
        try {
            System.out.print("Enter date (dd-MM-yyyy): ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            // Check for categories and allow category selection or manual entry
            categoryList.viewCategories();
            String category;

            if (categoryList.getCategories().isEmpty()) {
                System.out.print("No categories available. Please enter a new category: ");
                category = scanner.nextLine();
                categoryList.addCategory(new Category(category)); // Add the new category
            } else {
                System.out.print("Enter category index (or enter a new category name): ");
                String input = scanner.nextLine();
                
                // Check if input is a number for index selection
                try {
                    int index = Integer.parseInt(input);
                    category = categoryList.getCategories().get(index).getName();
                } catch (NumberFormatException e) {
                    // If it's not a number, assume it's a new category
                    category = input;
                    // Add the new category
                    categoryList.addCategory(new Category(category)); 
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index. Adding new category.");
                    category = input;
                    // Add the new category
                    categoryList.addCategory(new Category(category)); 
                }
            }

            // Create and add the expense
            Expense expense = new Expense(date, amount, description, category);
            tracker.addExpense(expense);
            System.out.println("Expense added successfully!");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine(); // consume invalid input
        }
    }

    // Function to add Income
    private static void addIncome(ExpenseTracker tracker, Scanner scanner, DateTimeFormatter dateFormatter) {
        try {
            System.out.print("Enter date (dd-MM-yyyy): ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.print("Enter source of income: ");
            String source = scanner.nextLine();

           System.out.println("Enter income description: ");
           String description = scanner.next();

            Income income = new Income(date, amount, source, description); // Income class is inside the ExpenseTracker.java file 
            tracker.addIncome(income);
            System.out.println("Income added successfully!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine(); // consume invalid input
        }
    }

    // Function to manage Categories
    private static void manageCategories(CategoryList categoryList, Scanner scanner) {
        while (true) {
            System.out.println("\n----- Category Management -----");
            System.out.println("1. Add Category");
            System.out.println("2. Edit Category");
            System.out.println("3. Delete Category");
            System.out.println("4. View Categories");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1: // Add Category
                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();
                    categoryList.addCategory(new Category(newCategory));
                    break;
                case 2: // Edit Category
                    categoryList.viewCategories();
                    System.out.print("Enter the category index to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name for the category: ");
                    String newName = scanner.nextLine();
                    categoryList.editCategory(editIndex, newName);
                    break;
                case 3: // Delete Category
                    categoryList.viewCategories();
                    System.out.print("Enter the category index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    categoryList.deleteCategory(deleteIndex);
                    break;
                case 4: // View Categories
                    categoryList.viewCategories();
                    break;
                case 5: // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
