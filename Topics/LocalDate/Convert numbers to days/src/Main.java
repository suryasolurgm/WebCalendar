import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int year = scn.nextInt();
        int one = scn.nextInt();
        int two = scn.nextInt();
        int three = scn.nextInt();
        System.out.println(LocalDate.ofYearDay(year, one));
        System.out.println(LocalDate.ofYearDay(year, two));
        System.out.println(LocalDate.ofYearDay(year, three));
    }
}
