import java.util.Scanner;

public class NumsDay_in_month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthInput;
        int year = -1;
        int month = -1;

        while (month == -1) {
            System.out.print("Enter month (name, abbreviation, 3 letters, or number): ");
            monthInput = sc.nextLine().trim();

            month = convertMonthToNumber(monthInput);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
            }
        }

        while (year < 0) {
            System.out.print("Enter year (non-negative number, full digits): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter digits only.");
                sc.next();
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Month " + month + " of year " + year + " has " + days + " days.");
    
        }
    }
    public static int convertMonthToNumber(String input) {
        input = input.toLowerCase();

        switch (input) {
            case "1": case "january": case "jan.": case "jan": return 1;
            case "2": case "february": case "feb.": case "feb": return 2;
            case "3": case "march": case "mar.": case "mar": return 3;
            case "4": case "april": case "apr.": case "apr": return 4;
            case "5": case "may": return 5;
            case "6": case "june": case "jun.": case "jun": return 6;
            case "7": case "july": case "jul.": case "jul": return 7;
            case "8": case "august": case "aug.": case "aug": return 8;
            case "9": case "september": case "sept.": case "sep": return 9;
            case "10": case "october": case "oct.": case "oct": return 10;
            case "11": case "november": case "nov.": case "nov": return 11;
            case "12": case "december": case "dec.": case "dec": return 12;
            default: return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: return 31;
            case 2:
                if (isLeapYear(year)) 
                    return 29;
                else 
                    return 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return -1;
        }
    }
}