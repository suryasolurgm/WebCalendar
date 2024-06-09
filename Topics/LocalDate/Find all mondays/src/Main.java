import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        LocalDate localDate = LocalDate.of(year, month, 1);
        int noofDays = localDate.lengthOfMonth();
        for (int i = 1; i <= noofDays; i++) {
            if(localDate.getDayOfWeek()== DayOfWeek.MONDAY){
                System.out.println(localDate);
            }
            localDate = localDate.plusDays(1);
        }
    }
}