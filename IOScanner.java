import java.util.Scanner;
public class IOScanner {
    static Scanner scanner;
    public IOScanner() {
        scanner = new Scanner(System.in);
    }
    // Methods for reading int, string, double.
    public int readInt() {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
    public double readDouble() {
        double dbl = scanner.nextDouble();
        scanner.nextLine();
        return dbl;
    }
    public String readString() {
        return scanner.nextLine();
    }
    public void close() {
        scanner.close();
    }
}
