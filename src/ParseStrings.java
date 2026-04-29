import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userInput = "";
      System.out.println("Enter input string:");
      userInput = scnr.nextLine();
      while (!userInput.trim().equals("q")) {
    	  if (hasComma(userInput) == true) {
    		  String[] names = userInput.split("\\s*,\\s*");
    		  System.out.println("First word: " + names[0]);
    		  System.out.println("Second word: " + names[1]);  
    		  System.out.println();
    	  }
    	  else {
    		  System.out.println("Error: No comma in string.");
    		  System.out.println();
    	  }
          System.out.println("Enter input string:");
    	  userInput = scnr.nextLine();
      }
      
   }
   public static boolean hasComma(String userString) {
	   for (int i = 0; i < userString.length(); ++i) {
		   if (userString.charAt(i) == ',') {
			   return true;
		   }
	   }
	   return false;
   }
}
