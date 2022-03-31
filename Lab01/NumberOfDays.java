import java.util.Scanner;

public class NumberOfDays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String strMonth;
        int iYear;

        do {
            System.out.print("Enter month: ");
            strMonth = scan.nextLine();
            
            switch (strMonth) {
                case "January": case "Jan.": case "Jan":
                strMonth = "1";
                break;

                case "February": case "Feb.": case "Feb":
                strMonth = "2";
                break;

                case "March": case "Mar.": case "Mar":
                strMonth = "3";
                break;

                case "April": case "Apr.": case "Apr":
                strMonth = "4";
                break;

                case "May":
                strMonth = "5";
                break;

                case "June": case "Jun":
                strMonth = "6";
                break;

                case "July": case "Jul":
                strMonth = "7";
                break;

                case "August": case "Aug.": case "Aug":
                strMonth = "8";
                break;

                case "September": case "Sep.": case "Sep":
                strMonth = "9";
                break;

                case "October": case "Oct.": case "Oct":
                strMonth = "10";
                break;

                case "November": case "Nov.": case "Nov":
                strMonth = "11";
                break;

                case "December": case "Dec.": case "Dec":
                strMonth = "12";
                break;

                default:
                strMonth = "0";
                System.out.println("Invalid month!");
                break;
            }
        } while (strMonth == "0");

        do {
            System.out.print("Enter year: ");
            iYear = scan.nextInt();
        } while (iYear <= 99);

        boolean leapYear =
            (iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0);

        switch (strMonth) {
            case "1": case "3": case "5": case "7":
            case "8": case "10": case "12":
            System.out.println("Days In Month: 31");
            break;
            case "4": case "6": case "9": case "11":
            System.out.println("Days In Month: 30");
            break;
            case "2":
            {
                if (leapYear) System.out.println("Days In Month: 29");
                else System.out.println("Days In Month: 28");
                break;
            }
            default:
            System.out.println("Invalid!");
        }
        scan.close();
    }
}