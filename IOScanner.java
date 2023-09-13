import java.util.Scanner;
public class IOScanner {
    static Scanner scanner = new Scanner(System.in);
    
    static int readInt() {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
    static double readDouble() {
        double dbl = scanner.nextDouble();
        scanner.nextLine();
        return dbl;
    }
    static String readString() {
        return scanner.nextLine();
    }
    static void close() {
        scanner.close();
    }
}
