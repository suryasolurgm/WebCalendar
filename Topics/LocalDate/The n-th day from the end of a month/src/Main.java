import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Reading input values: year, month, and remaining days till end of month
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int daysFromEnd = scanner.nextInt();

        // Get the last day of the specified month
       // YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = LocalDate.of(year, month, daysFromEnd);
        int dayofmonth = localDate.lengthOfMonth();
        //System.out.println(dayofmonth);
        int days = dayofmonth-daysFromEnd+1;
        // Calculate the desired date by subtracting the given days from the last day of the month
        LocalDate resultDate = LocalDate.of(year, month, days);

        // Print the result in the format yyyy-MM-dd
        System.out.println(resultDate);

        scanner.close();
    }
}