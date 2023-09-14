import java.util.Scanner;
public class IOScanner {
    static Scanner scannerObj = new Scanner(System.in);

    static int readInt() {
        int intNumber = scannerObj.nextInt();
        scannerObj.nextLine();
        return intNumber;
    }
    static int readIntWithMessage(String messageFromString) {
        System.out.println(messageFromString);
        int intNumber = scannerObj.nextInt();
        scannerObj.nextLine();
        return intNumber;
    }
    static String readStringWithMessage(String messageFromString) {
        System.out.println(messageFromString);
        return scannerObj.nextLine();
    }
    static void close() {
        scannerObj.close();
    }
}
