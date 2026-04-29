import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // (1) Get Title
        System.out.println("Enter a title for the data:");
        String title = scnr.nextLine();
        System.out.println("You entered: " + title);
        System.out.println();
        
        // (2) Get Column Headers
        System.out.println("Enter the column 1 header:");
        String col1Header = scnr.nextLine();
        System.out.println("You entered: " + col1Header);
        System.out.println();
        
        System.out.println("Enter the column 2 header:");
        String col2Header = scnr.nextLine();
        System.out.println("You entered: " + col2Header);
        System.out.println();
        
        // Storage for data
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        
        // (3) + (4) Get Data Points with error checking
        System.out.println("Enter a data point (-1 to stop input):");
        String line = scnr.nextLine();
        
        while (!line.equals("-1")) {
            
            // Check for commas
            int commaCount = 0;
            for (char c : line.toCharArray()) {
                if (c == ',') commaCount++;
            }
            
            if (commaCount == 0) {
                System.out.println("Error: No comma in string.");
            } 
            else if (commaCount > 1) {
                System.out.println("Error: Too many commas in input.");
            } 
            else {
                // Split into two parts
                String[] parts = line.split(",");
                
                if (parts.length != 2) {
                    System.out.println("Error: No comma in string.");
                } else {
                    String dataString = parts[0].trim();
                    String dataNumStr = parts[1].trim();
                    
                    try {
                        int dataInteger = Integer.parseInt(dataNumStr);
                        names.add(dataString);
                        values.add(dataInteger);
                        System.out.println("Data string: " + dataString);
                        System.out.println("Data integer: " + dataInteger);
                    } catch (Exception e) {
                        System.out.println("Error: Comma not followed by an integer.");
                    }
                }
            }
            
            System.out.println();
            System.out.println("Enter a data point (-1 to stop input):");
            line = scnr.nextLine();
        }
        
        // (5) Output Formatted Table
        System.out.println();
        System.out.printf("%33s%n", title);
        System.out.printf("%-20s|%23s%n", col1Header, col2Header);
        System.out.println("--------------------------------------------");
        
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-20s|%23d%n", names.get(i), values.get(i));
        }
        
        // (6) Output Histogram
        System.out.println();
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%20s ", names.get(i));
            
            int count = values.get(i);
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}