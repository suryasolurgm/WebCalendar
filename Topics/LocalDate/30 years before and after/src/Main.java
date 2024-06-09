import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        LocalDate localdate = LocalDate.parse(sc.nextLine());
        System.out.println(localdate.minusYears(30));
        System.out.println(localdate.plusYears(30));

    }
}