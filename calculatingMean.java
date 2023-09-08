import java.util.Locale;
import java.util.Scanner;

public class calculatingMean {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double meanOfPoints;
        meanOfPoints = (scoreArray[0] + scoreArray[1] + scoreArray[2] + scoreArray[3] + scoreArray[4] + scoreArray[5] + scoreArray[6])/scoreArray.length;
        Locale.setDefault(Locale.ENGLISH);
        System.out.printf("The mean of the numbers is: %.2f " , meanOfPoints);

    }
}
