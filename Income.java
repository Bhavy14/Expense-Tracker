import java.time.LocalDate;

public class Income {
    private LocalDate date;
    private double amount;
    private String source;
    private String description; // Add this line if you want a description field

    public Income(LocalDate date, double amount, String source, String description) {
        this.date = date;
        this.amount = amount;
        this.source = source;
        this.description = description; // Initialize description
    }

    // Getter methods
    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() { // Add this method
        return description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Source: " + source + ", Description: " + description; // Include description
    }
}
