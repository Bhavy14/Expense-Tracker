//package directory
import java.io.*;
import java.util.*;

/*Users can set monthly budgets for different expense categories to avoid overspending. */
public class Budgetsetting1 {
    public double m_exp;
    public String cat;
    public static Map<String, Double> expcat = new HashMap<>();
    //public static ArrayList<String> arrlist = new ArrayList<>();

    public void set(double mexp) {
        this.m_exp = mexp;
    }

    public double get() {
        return m_exp;
    }

    public static void show2() {
        try {
            FileReader f1 = new FileReader("Budget.txt");
            BufferedReader bfr = new BufferedReader(f1);
            String str = "";
            while ((str = bfr.readLine()) != null) {
                System.out.println(str);
            }
            bfr.close();
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
/* 
    public static void show() {
        try {
            FileReader f1 = new FileReader("hello.txt");
            BufferedReader bfr = new BufferedReader(f1);
            String str = "";
            while ((str = bfr.readLine()) != null) {
                System.out.println(str);
                arrlist.add(str);
            }
            bfr.close();
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
*/
    public void setmonthlybudget() {
        Scanner sc = new Scanner(System.in);
        String cate;

        //show();

        try {
            FileWriter f2 = new FileWriter("Budget.txt", true);
            System.out.println("Enter category to set a Budget = ");
            cate = sc.next();
            System.out.println("Enter Bugdet Amount for " + cate + " =");
            m_exp = sc.nextDouble();
            expcat.put(cate, m_exp);
            for (Map.Entry<String, Double> entry : expcat.entrySet()) {
                f2.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            /*if (arrlist.contains(cate)) {
                System.out.println("Set montly bugdet for " + cate + " =");
                m_exp = sc.nextDouble();
                expcat.put(cate, m_exp);
                for (Map.Entry<String, Double> entry : expcat.entrySet()) {
                    f2.write(entry.getKey() + "=" + entry.getValue() + "\n");
                }

            } else {
                System.out.println("Invalid category");
            }*/
            f2.close();
            show2();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /*public static void main(String args[]) {
        Budgetsetting1 b = new Budgetsetting1();
        b.setmonthlybudget();
    }*/
}
