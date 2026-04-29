import java.util.Scanner;

public class StringInputStream {
    public static void main (String [] args) {
    Scanner scnr = new Scanner(System.in);
    Scanner inSS = null;
    String userInput;
    String userMonth;
    int userDate;
    int userYear;

    userInput = scnr.nextLine();
    inSS = new Scanner(userInput);

    /* Sample output:
    Month: Jan
    Date: 12
    Year: 1992 
    */
    userMonth = inSS.next();
    userDate = inSS.nextInt(); 
    userYear = inSS.nextInt();
    
    

    System.out.println("Month: " + userMonth);
    System.out.println("Date: " + userDate);
    System.out.println("Year: " + userYear);
    }
}