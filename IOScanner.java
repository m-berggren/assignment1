package Assignment1;
import java.util.Scanner;
public class IOScanner {
    public static Scanner input() {
        return new Scanner(System.in);
    }
    public static int readInt() {
        Scanner input = input();
        int number = input.nextInt();
        input.nextLine();
        return number;
    }
}
