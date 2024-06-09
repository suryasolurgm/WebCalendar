import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        LocalDate localDate = LocalDate.parse(sc.nextLine());
        System.out.println(localDate);
        int offset = sc.nextInt();
        int year = localDate.getYear();
        while (localDate.getYear() == year) {
            localDate = localDate.plusDays(offset);
            if(!(localDate.getYear() == year)){
                break;
            }
            System.out.println(localDate);
        }
    }
}