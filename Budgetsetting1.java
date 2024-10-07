import java.util.*;
import java.io.*;

public class Budgetsetting1 {
    public double m_exp;
    public String cat;
    public static Map<String, Double> expcat = new HashMap<>();

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
            String str;
            while ((str = bfr.readLine()) != null) {
                System.out.println(str);
            }
            bfr.close();
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setmonthlybudget() {
        Scanner sc = new Scanner(System.in);
        String cate;

        try {
            FileWriter f2 = new FileWriter("Budget.txt", true);
            System.out.println("Enter category to set a Budget = ");
            cate = sc.next();
            System.out.println("Enter Budget Amount for " + cate + " =");
            m_exp = sc.nextDouble();
            expcat.put(cate, m_exp);
            f2.write(cate + "=" + m_exp + "\n");
            f2.close();
            show2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
