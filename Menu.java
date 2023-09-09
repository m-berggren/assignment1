import java.util.Scanner;
import java.util.Locale;

public class Menu {
    public static void main(String[] args) {

        // Program takes input in the form of integers in the value x, range 0 < x <
        // 100.
        // If input falls outside of this range a while loop will keep asking for the
        // same input.
        // If input is valid then the value will be stored in an array of integers and
        // while loop continues.
        // After 7 iterations the program will exit and return the input result.

        Scanner input = new Scanner(System.in);

        int[] scoreArray = new int[7];
        String[] suffixArray = { "st", "nd", "rd", "th", "th", "th", "th" };
        int i = 0;

        System.out.println("Please enter 7 integer scores.");

        while (i < suffixArray.length) {
            System.out.printf("Enter the score for the %d%s student ", i + 1, suffixArray[i]);

            int score = input.nextInt();
            input.nextLine();

            if (score > 100 || score < 0) {
                System.out.println("Error - Input out of bound. Score can only be between 0 and 100.");
            } else {
                scoreArray[i] = score;
                i++;
            }
        }

        System.out.printf("%s %n", "Thank you for your input.\nYour entered scores are:");
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
        //task 2
         
        // task 3

        double meanOfPoints = 0;
        int sumOfScores = 0;
        for (int score : scoreArray) {
            sumOfScores += score;
        }
        if (scoreArray.length > 0) {
            meanOfPoints = (double) sumOfScores / scoreArray.length;
        }
        Locale.setDefault(Locale.ENGLISH);
        System.out.printf("The mean of the numbers is %.2f", meanOfPoints);

        // task 4

        int lowestScore = Integer.MAX_VALUE;
        int secondLowestScore = Integer.MAX_VALUE;
        int highestScore = Integer.MIN_VALUE;
        int secondHighestScore = Integer.MIN_VALUE;
        for

        (int score : scoreArray) {
            if (score < lowestScore) {
                secondLowestScore = lowestScore;
                lowestScore = score;
            } else if (score < secondLowestScore) {
                secondLowestScore = score;
            }

            if (score > highestScore) {
                secondHighestScore = highestScore;
                highestScore = score;
            } else if (score > secondHighestScore) {
                secondHighestScore = score;
            }
        }

        System.out.println(" \nType your option: \nThe two lowest scores provided are " + lowestScore + ", and "
                + secondLowestScore);
        System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);
        // task5
        int positionOfHighestScore = -1;
        boolean foundHighestScore = false;

        for (int count = 0; count < scoreArray.length; count++) {
            if (scoreArray[count] == highestScore && !foundHighestScore) {
                positionOfHighestScore = count;
                foundHighestScore = true;
            }
        }

        if (foundHighestScore) {
            System.out.printf("%s %s %s %s%s %s", "The highest score is", highestScore, "and belongs to the",
                    positionOfHighestScore + 1, suffixArray[positionOfHighestScore], "student");
        }

        input.close();
    }

}
