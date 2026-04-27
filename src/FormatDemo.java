public class FormatDemo {
    public static void main(String[] args) {
        
        double num = 1234.56789;
        int    integer = 42;
        String text = "Hello";

        System.out.println("=== All Flags, Width, Precision Demo ===");
        System.err.println("Double: 1234.56789, Integer: 42, String: \"Hello\"");
        System.out.printf("%-15s   : Left aligned (flag -)%n", text);
        System.out.printf("%.2s                : Truncated to 2 characters%n", text);
        System.out.printf("%+15d   : Plus sign for positive (flag +)%n", integer);
        System.out.printf("% 15d   : Leading space for positive (flag space)%n", integer);
        System.out.printf("%015d   : Zero padding (flag 0)%n", integer);
        
        System.out.printf("%n=== Width vs Precision on floating point ===%n");
        System.out.printf("Width only     : %10.0f%n", num);     // minimum 10 chars, no decimals
        System.out.printf("Precision only : %.3f%n", num);        // 3 decimal places, no width
        System.out.printf("Both           : %12.3f%n", num);      // min width 12, 3 decimals
        System.out.printf("Both + flags   : %-12.3f%n", num);     // left aligned
        System.out.printf("Zero pad + prec: %012.3f%n", num);     // zero padded
        
        double value = 123.456789;
        System.out.println("\n=== Various format examples of double 123.456789 ===");
        System.out.printf("%-10s | %-15s   | Result%n", "Format", "Meaning");
        System.out.printf("%-10s | %-15s   | %f%n", "%f", "Default", value);
        System.out.printf("%-10s | %-15s   | %.2f%n", "%.2f", "Precision=2", value);
        System.out.printf("%-10s | %-15s | %10.2f%n", "%10.2f", "Width=10 + Prec=2", value);
        System.out.printf("%-10s | %-15s   | %-10.2f%n", "%-10.2f", "Left align", value);
        System.out.printf("%-10s | %-15s   | %+10.2f%n", "%+10.2f", "Show + sign", value);
        System.out.printf("%-10s | %-15s   | %010.2f%n", "%010.2f", "Zero pad", value);
        System.out.printf("%-10s | %-15s   | % 10.2f%n", "% 10.2f", "Space flag", value);
        
        int n = 255;
        System.out.println("\n=== Integer n = 255 ===");
        System.out.printf("Decimal: %d%n", n, n);
        System.out.printf("Octal:   %o%n", n, n);
        System.out.printf("Hex:     %x%n", n, n);
        System.out.printf("Hex upper: %X%n", n, n);

        double pi = Math.PI;
        System.out.println("\n=== Double pi = 3.141592653589793 ===");
        System.out.printf("Scientific: %e%n", pi, pi);
        System.out.printf("Precision: %.4e%n", pi, pi);

        System.out.println("\n=== Percent and characters ===");
        System.out.printf("Percent sign: 50%% complete%n");
        System.out.printf("Character: %c%n", 'A', 'A');
        double positive = 123.456;
        double negative = -123.456;

        System.out.println("\n=== Flags with positive and negative numbers ===");
        System.out.printf("Default          : %10.2f%n", positive);
        System.out.printf("Left aligned     : %-10.2f%n", positive);
        System.out.printf("With + sign      : %+10.2f%n", positive);
        System.out.printf("Left + Plus      : %-+10.2f%n", positive);
        System.out.printf("Left + Plus (neg): %-+10.2f%n", negative);
        
        System.out.println("\n=== With integers ===");
        System.out.printf("Left + Plus (int): %-+10d%n", 42);
        
        System.out.println("\n=== Demonstrating flush() ===");
        System.out.print("My life has been the poem ");  // A
        System.out.println("I would have writ");         // B
        System.out.print("But I could not ");            // C
        System.out.flush();
        System.out.print("both live and utter it.\n");   // D
    }
}