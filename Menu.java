import java.util.Locale;
import java.util.Scanner;

public class Menu {
    class ScoreValue {
        public static void Task1(String[] args) {
            int[] anArray = scoreArray();
            for(int arrayElement : anArray) {
                System.out.print(arrayElement + " ");
            }
        }
        public static int[] scoreArray() {

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
            return scoreArray;
        }
    }
    class GradesPrinting {
        //paste ex 2
    }
    class MeanCalculating {
//        public static double calculateMean () {
//            // this code will help to count the mean of 7 numbers(student points),
//            // which would be assigned by user in the console
//            double sumOfScores = 0;
//            for (double score : scoreArray()) {
//                sumOfScores = sumOfScores + score; // not to stuck in nested loop
//            }
//
//            double meanOfPoints = 0.0;
//            if (scoreArray().length > 0) {
//                meanOfPoints = sumOfScores / scoreArray().length;
//            }
//            Locale.setDefault(Locale.ENGLISH); // with help of this command decimal symbols would be with dot
//            System.out.printf("The mean of the numbers is %.2f", meanOfPoints);
//            return meanOfPoints;
//        }
    }
    class FindHighLowScore {
//        public static int findHighLowScore() {
//            int lowestScore = Integer.MAX_VALUE;
//            int secondLowestScore = Integer.MAX_VALUE;
//            int highestScore = Integer.MIN_VALUE;
//            int secondHighestScore = Integer.MIN_VALUE;
//
//            for (int score : scoreArray()) {
//                if (score < lowestScore) {
//                    secondLowestScore = lowestScore;
//                    lowestScore = score;
//                } else if (score < secondLowestScore) {
//                    secondLowestScore = score;
//                }
//
//                if (score > highestScore) {
//                    secondHighestScore = highestScore;
//                    highestScore = score;
//                } else if (score > secondHighestScore) {
//                    secondHighestScore = score;
//                }
//            }
//
//            System.out.println(" \nType your option: \nThe two lowest scores provided are " + lowestScore + ", and " + secondLowestScore);
//            System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);
//            return highestScore;
//        }
    }
    class FindScorePosition {
//        public static int findScorePosition() {
//            int positionOfHighestScore = -1;
//            boolean foundHighestScore = false;
//            int highestScore;
//
//            for (int count = 0; count < scoreArray.length; count++) {
//                if (scoreArray[count] == highestScore && !foundHighestScore) {
//                    positionOfHighestScore = count;
//                    foundHighestScore = true;
//                }
//            }
//
//            if (foundHighestScore) {
//                System.out.printf("%s %s %s %s%s %s", "The highest score is", highestScore, "and belongs to the",
//                        positionOfHighestScore + 1, suffixArray[positionOfHighestScore], "student");
//            }
//
//            return highestScore;
//        }
    }
    class CollectHashtags {
    //paste ex 6
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOptionInMenu;

        // calling a function that is responsible for entering points of student in the console
        ScoreValue.scoreArray();

        do {
            // the visual part of the menu that is printed in the console
            String systemMenu = (
                    "\n Welcome to the menu. Choose one of the options below:\n " +
                            "1. Register new scores for students.\n " +
                            "2. Print all registered grades.\n " +
                            "3. Calculate the mean of the entered scores.\n " +
                            "4. Find the two highest and two lowest scores.\n " +
                            "5. Find the highest score and its position.\n " +
                            "6. Collect hashtags from a post.\n " +
                            "7. To exit.\n"
            );
            System.out.println(systemMenu);

            // ask user to assign the value of variable "userOptionInMenu" to call the tasks in menu later
            System.out.println("Type your option:");
            userOptionInMenu = input.nextInt();
            input.nextLine();

            String exitConsoleMessage = "Thank you for using our grading system. Have a nice day!";
            String errorConsoleMessage = "Error - Invalid value. Please choose a number between 1 and 7.";

            // execute various cases by changing value of "userOptionInMenu"
            switch (userOptionInMenu) {
//                case 1 -> ScoreValue.scoreArray();
//                case 2 -> GradesPrinting.();
//                case 3-> MeanCalculating.calculateMean();
//                case 4-> FindHighLowScore.findHighLowScore();
//                case 5-> FindScorePosition.findScorePosition();
//                case 6-> CollectHashtags.();
//                case 7 -> System.out.println(exitConsoleMessage);
//                default -> System.out.println(errorConsoleMessage);
            }

            // we have an option to rewrite this part of the code(switch) with help of if statements
            // however, code will be harder to understand and not as compact
            //if (userOptionInMenu > 7 || userOptionInMenu < 0 ){ System.out.println(errorMessage); }
            //if (userOptionInMenu == 1) {}
            //if (userOptionInMenu == 2) {}
            //if (userOptionInMenu == 3) {}
            //if (userOptionInMenu == 4) {}
            //if (userOptionInMenu == 5) {}
            //if (userOptionInMenu == 6) {}
            //else if (userOptionInMenu == 7) { System.out.println(exitMessage); }

        } while (userOptionInMenu != 7); // do loop works while value of the variable is not equal to 7

        input.close(); // we should always close the scanner
    }
}