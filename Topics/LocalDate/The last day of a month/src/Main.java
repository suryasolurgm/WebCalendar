import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int noOfDayInYear = sc.nextInt();
        LocalDate localDate = LocalDate.ofYearDay(year, noOfDayInYear);
        int monthDays = localDate.lengthOfMonth();
       // System.out.println(monthDays + " days");

        int dayOfMonth = localDate.getDayOfMonth();
        //System.out.println(dayOfMonth + " days");
        if(monthDays==dayOfMonth){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}