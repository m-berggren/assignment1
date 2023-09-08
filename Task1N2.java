import java.util.Scanner;

public class Task1N2 {
    public static void main(String[] args) {

        // Program takes input in the form of integers in the value x, range 0 < x < 100.
        // If input falls outside of this range a while loop will keep asking for the same input.
        // If input is valid then the value will be stored in an array of integers and while loop continues.
        // After 7 iterations the program will exit and return the input result.

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

        System.out.println("Thank you for your input.\nYour entered scores are:");
        // From input array the program prints all integers by a for loop.
        // An if-statement runs so no comma is printed before the first word.
        boolean firstWord = true;
        for (int scoreElement : scoreArray) {
            if (firstWord) {
                System.out.print(scoreElement);
                firstWord = false;
            } else {
                System.out.printf(", %s", scoreElement);
            }
        }
        input.close();

    }
}
