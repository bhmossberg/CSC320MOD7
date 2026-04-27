public class FormatDemo {
    public static void main(String[] args) {
        
        double num = 1234.56789;
        int    integer = 42;
        String text = "Hello";

        System.out.println("=== All Flags, Width, Precision Demo ===\n");

        System.out.printf("%-15s : Left aligned (flag -)%n", text);
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

        System.out.printf("%-10s | %-15s | Result%n", "Format", "Meaning");
        System.out.printf("%-10s | %-15s | %f%n", "%f", "Default", value);
        System.out.printf("%-10s | %-15s | %.2f%n", "%.2f", "Precision=2", value);
        System.out.printf("%-10s | %-15s | %10.2f%n", "%10.2f", "Width=10 + Prec=2", value);
        System.out.printf("%-10s | %-15s | %-10.2f%n", "%-10.2f", "Left align", value);
        System.out.printf("%-10s | %-15s | %+10.2f%n", "%+10.2f", "Show + sign", value);
        System.out.printf("%-10s | %-15s | %010.2f%n", "%010.2f", "Zero pad", value);
        System.out.printf("%-10s | %-15s | % 10.2f%n", "% 10.2f", "Space flag", value);
        int n = 255;

        System.out.printf("%d   → Decimal: %d%n", n, n);
        System.out.printf("%o   → Octal:   %o%n", n, n);
        System.out.printf("%x   → Hex:     %x%n", n, n);
        System.out.printf("%X   → Hex upper: %X%n", n, n);

        double pi = Math.PI;
        System.out.printf("%e   → Scientific: %e%n", pi, pi);
        System.out.printf("%.4e → Precision: %.4e%n", pi, pi);

        System.out.printf("%%   → Percent sign: 50%% complete%n");
        System.out.printf("%c   → Character: %c%n", 'A', 'A');
        double positive = 123.456;
        double negative = -123.456;

        System.out.printf("Default          : %10.2f%n", positive);
        System.out.printf("Left aligned     : %-10.2f%n", positive);
        System.out.printf("With + sign      : %+10.2f%n", positive);
        System.out.printf("Left + Plus      : %-+10.2f%n", positive);
        System.out.printf("Left + Plus (neg): %-+10.2f%n", negative);
        
        System.out.println("\n--- With integers ---");
        System.out.printf("Left + Plus (int): %-+10d%n", 42);
    }
}