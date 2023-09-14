import java.util.Scanner;
public class IOScanner {
    static Scanner scanner = new Scanner(System.in);
    
    static int readInt() {
        int intNumber = scanner.nextInt();
        scanner.nextLine();
        return intNumber;
    }
    static double readDouble() {
        double doubleNumber = scanner.nextDouble();
        scanner.nextLine();
        return doubleNumber;
    }
    static String readStringWithMessage(String messageFromString) {
        System.out.println(messageFromString);
        return scanner.nextLine();
    }
    static void close() {
        scanner.close();
    }
}
