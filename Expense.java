import java.time.LocalDate;

public class Expense {
    private LocalDate date;
    private double amount;
    private String description;
    private String category;

    public Expense(LocalDate date, double amount, String description, String category) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    // Getter methods
    public LocalDate getDate() {
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
        return "Date: " + date + ", Amount: " + amount + ", Description: " + description + ", Category: " + category;
    }
}
