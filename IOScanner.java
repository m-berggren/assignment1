
import java.util.Scanner;
public class IOScanner {
    private final Scanner scanner;
    public IOScanner() {
        this.scanner = new Scanner(System.in);
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
