import java.util.Scanner;

public class DateParser {

	public static int getMonthAsInt(String monthString) {
		int monthInt;
		// Java switch/case statement                                                                
		switch (monthString) {
		case "January": 
			monthInt = 1; 
		    break;
		case "February": 
		    monthInt = 2; 
		    break;
		case "March": 
		    monthInt = 3; 
		    break;
		case "April": 
			monthInt = 4; 
			break;
		case "May": 
			monthInt = 5; 
			break;
		case "June": 
			monthInt = 6; 
			break;
		case "July": 
			monthInt = 7; 
			break;
		case "August": 
			monthInt = 8; 
			break;
		case "September": 
			monthInt = 9; 
			break;
		case "October": 
			monthInt = 10; 
			break;
		case "November": 
			monthInt = 11; 
			break;
		case "December": 
			monthInt = 12; 
			break;
		default: 
			monthInt = 0;
		}
		return monthInt;
	}

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input;

        while (true) {
            input = scnr.nextLine().trim();  

            if (input.equals("-1")) {
                break;
            }

            // Only process lines that look roughly correct
            if (!input.contains(",") || !input.contains(" ")) {
                continue;   // Ignore invalid format
            }

            try {
                // Parse using substring()
                int commaIndex = input.indexOf(',');
                String monthPart = input.substring(0, input.indexOf(' ')).trim();
                String dayPart = input.substring(input.indexOf(' ') + 1, commaIndex).trim();
                String yearPart = input.substring(commaIndex + 1).trim();

                int month = getMonthAsInt(monthPart);
                int day = Integer.parseInt(dayPart);
                int year = Integer.parseInt(yearPart);

                // Only output if month is valid
                if (month != 0) {
                    System.out.printf("%d/%d/%d%n", month, day, year);
                }

            } catch (Exception e) {
                // Ignore any line that causes parsing error
            }
        }

        scnr.close();
    }
}