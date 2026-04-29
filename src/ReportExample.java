import java.util.Scanner;
import java.io.StringWriter;
import java.io.PrintWriter;

public class ReportExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        pw.println("=== Shopping List Report ===");
        pw.printf("%-15s %8s%n", "Item", "Price");
        pw.println("-----------------------------");

        String item;
        double total = 0;

        System.out.println("Enter items (type 'done' to finish):");
        /* Enter items like below (type 'done' to finish):
        Banana 1.25
        Apple 0.89
        Milk 3.49
        done */
        while (!(item = sc.next()).equals("done")) {
            double price = sc.nextDouble();
            pw.printf("%-15s $%7.2f%n", item, price);
            total += price;
        }

        pw.println("-----------------------------");
        pw.printf("Total: $%.2f%n", total);

        // Now we have the full nicely formatted report as a String
        String finalReport = sw.toString();
        System.out.println(finalReport);

        // You could now:
        // - Save it to a file
        // - Send it in an email
        // - Display it in a GUI
        // - Send it to a web server
    }
}