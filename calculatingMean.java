import java.util.Locale;
import java.util.Scanner;

public class calculatingMean {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] scoreArray = new int[7];
        String[] suffixArray = {"st", "nd", "rd", "th", "th", "th", "th"};
        int i = 0;

        System.out.println("Please enter 7 integer scores.");

        while (i < suffixArray.length) {
            System.out.printf("Enter the score for the %d%s student ", i+1, suffixArray[i]);

            int score = input.nextInt();
            input.nextLine();

            if(score > 100 || score < 0) {
                System.out.println("Error - Input out of bound. Score can only be between 0 and 100.");
            } else {
                scoreArray[i] = score;
                i++;
            }
        }

        double meanOfPoints = (scoreArray[0] + scoreArray[1] + scoreArray[2] + scoreArray[3] + scoreArray[4] + scoreArray[5] + scoreArray[6])/scoreArray.length;
        Locale.setDefault(Locale.ENGLISH);
        System.out.printf("The mean of the numbers is: %.2f " ,meanOfPoints);

        input.close();
    }
}
