
import java.util.Scanner;
public class IOScanner {
    static Scanner scanner = new Scanner(System.in);

    static int readInt() {
        int intNumber = scanner.nextInt();
        scanner.nextLine();
        return intNumber;
    }
    static int readIntWithMessage(String messageFromString) {
        System.out.println(messageFromString);
        int intNumber = scanner.nextInt();
        scanner.nextLine();
        return intNumber;
    }
    static String readStringWithMessage(String messageFromString) {
        System.out.println(messageFromString);
        return scanner.nextLine();
    }
    static void close() {
        scanner.close();
    }
}
