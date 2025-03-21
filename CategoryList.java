import java.io.*; 
import java.util.ArrayList;
import java.util.List;

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class CategoryList {
    private List<Category> categoryList = new ArrayList<>();

    // Add a category
    public void addCategory(Category category) {
        categoryList.add(category);
        System.out.println("Category added: " + category);
    }

    // Edit a category by index
    public void editCategory(int index, String newName) {
        if (index >= 0 && index < categoryList.size()) {
            categoryList.get(index).setName(newName);
            System.out.println("Category updated to: " + newName);
        } else {
            System.out.println("Invalid category index.");
        }
    }

    // Delete a category by index
    public void deleteCategory(int index) {
        if (index >= 0 && index < categoryList.size()) {
            System.out.println("Category removed: " + categoryList.get(index));
            categoryList.remove(index);
        } else {
            System.out.println("Invalid category index.");
        }
    }

    // View all categories
    public void viewCategories() {
        if (categoryList.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            System.out.println("Categories:");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println(i + ". " + categoryList.get(i));
            }
        }
    }

    // Get the list of categories
    public List<Category> getCategories() {
        return categoryList;
    }

    // Load categories from a file
    public void loadCategories() {
        try (BufferedReader br = new BufferedReader(new FileReader("categories.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                addCategory(new Category(line)); // Add each category from file
            }
        } catch (IOException e) {
            System.out.println("Error loading categories: " + e.getMessage());
        }
    }

    // Save categories to a file
    public void saveCategories() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("categories.txt"))) {
            for (Category category : categoryList) {
                bw.write(category.getName());
                bw.newLine(); // Write each category on a new line
            }
        } catch (IOException e) {
            System.out.println("Error saving categories: " + e.getMessage());
        }
    }
}
