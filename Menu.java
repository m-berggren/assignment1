
import java.util.Locale;

public class Menu {
    static IOScanner input = new IOScanner(); // input new IOScanner

    public static void main(String[] args) {
        int userOptionInMenu;

        // call function which is responsible for entering grades
        int[] arrayOfScores = readGrade();

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

            // readInt instead of nextInt because of the IOScanner
            userOptionInMenu = input.readInt();

            // define two messages to use them later in switch, and make code more readable
            String exitConsoleMessage = "Thank you for using our grading system. Have a nice day!";
            String errorConsoleMessage = "Error - Invalid value. Please type between 1 and 7.";

            // execute various cases by changing value of "userOptionInMenu"
            switch (userOptionInMenu) {
                case 1 -> arrayOfScores = readGrade();
                case 2 -> printGrades(arrayOfScores, "Your entered scores are:");
                case 3 -> calculateMean(arrayOfScores);
                case 4 -> highLowValues(arrayOfScores);
                case 5 -> findHighestScorePosition(arrayOfScores);
                case 6 -> collectHashtags();
                case 7 -> System.out.println(exitConsoleMessage);
                default -> System.out.println(errorConsoleMessage);
            }

            // we have an option to rewrite this part of the code(switch) with the help of if statements
            // however, code will be harder to understand and not as compact
            //if (userOptionInMenu > 7 || userOptionInMenu < 0 ){ System.out.println(errorMessage); }
            //else if (userOptionInMenu == 1) {}
            //else if (userOptionInMenu == 2) {}
            //else if (userOptionInMenu == 3) {}
            //else if (userOptionInMenu == 4) {}
            //else if (userOptionInMenu == 5) {}
            //else if (userOptionInMenu == 6) {}
            //else if (userOptionInMenu == 7) { System.out.println(exitMessage); }

        } while (userOptionInMenu != 7); // do-while loop works while value of the variable is not equal to 7

        input.close(); // to close the scanner
    }
    public static int[] readGrade() {
        /* Function reads inputs and stores them in an array.
        While loop is used to handle cases when entered score is less than 0 or over 100,
        so loop can continue. */

        int[] scoreArray = new int[7];
        String[] suffixArray = { "st", "nd", "rd", "th", "th", "th", "th" };
        int i = 0;

        while(i < suffixArray.length) {
            System.out.printf("Enter the score for the %d%s student ", i + 1, suffixArray[i]);
            int score = input.readInt();

            if (score > 100 || score < 0) {
                System.out.println("Error - Input out of bound. Score can only be between 0 and 100.");
            } else {
                scoreArray[i] = score;
                i++;
            }
        }
        printGrades(scoreArray, "Thank you for your input. Your entered scores are: ");

        return scoreArray;
    }
    public static void printGrades(int[] arrayForScores, String messageWithScores) {
        // This function prints all elements in a chosen array through a for loop.
        System.out.printf("%s%n", messageWithScores);
        for (int i=0; i < arrayForScores.length; i++) {
            if (i == 0) {
                System.out.print(arrayForScores[i]);
            } else {
                System.out.printf(", %s", arrayForScores[i]);
            }
        }
        System.out.println();
    }
    public static double calculateMean(int[] arrayForScores) {
        // this code will help to count the mean of 7 numbers(student points),
        // which would be assigned by user in the console
        double sumOfScores = 0;

        for (double score : arrayForScores) {
            sumOfScores = sumOfScores + score; // not to stuck in nested loop
        }

        double meanOfPoints = 0.0;
        if (arrayForScores.length > 0) {
            meanOfPoints = sumOfScores / arrayForScores.length;
        }
        Locale.setDefault(Locale.ENGLISH); // with help of this command decimal symbols would be with dot
        System.out.printf("The mean of the numbers is %.2f%n", meanOfPoints);
        return meanOfPoints;
    }
    public static int highLowValues(int[] arrayForScores) {
        int lowestScore = 0;
        int secondLowestScore = 0;
        int highestScore = 0;
        int secondHighestScore = 0;

        for(int i=0; i < arrayForScores.length; i++) {
            if(i == 0){
                lowestScore = arrayForScores[i];
            }
            if(i == 1){
                secondLowestScore = arrayForScores[i];
            }

            if (arrayForScores[i] < lowestScore) {
                secondLowestScore = lowestScore;
                lowestScore = arrayForScores[i];
            } else if (arrayForScores[i] < secondLowestScore) {
                secondLowestScore = arrayForScores[i];
            }

            if (arrayForScores[i] > highestScore) {
                secondHighestScore = highestScore;
                highestScore = arrayForScores[i];
            } else if (arrayForScores[i] > secondHighestScore) {
                secondHighestScore = arrayForScores[i];
            }
        }
        System.out.println("\nThe two lowest scores provided are " + lowestScore + ", and " + secondLowestScore);
        System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);

        return highestScore;
    }
    public static void findHighestScorePosition(int[] arrayForScores){
        int positionOfHighestScore = -1;
        int highestScore = highLowValues(arrayForScores);

        boolean foundHighestScore = false;
        String[] suffixesArray = { "st", "nd", "rd", "th", "th", "th", "th" };

        for (int count = 0; count < arrayForScores.length; count++) {
            if (arrayForScores[count] == highestScore && !foundHighestScore) {
                positionOfHighestScore = count;
                foundHighestScore = true;
            }
        }
        if (foundHighestScore) {
            System.out.printf("%s %s %s %s%s %s%n", "The highest score is", highestScore, "and belongs to the",
                    positionOfHighestScore + 1, suffixesArray[positionOfHighestScore], "student" );
        }
    }
    public static void collectHashtags() {
        /* Function collects words beginning with a hashtag.
        Words are stored in an array created from input string.
        */
        System.out.print("Type your post: ");
        String inputString = input.readString();

        String[] words = inputString.split("\\s+");
        String hashtags = "Hashtags found: ";

        int hashCounter = 0;

        for(int i=0; i < words.length; i++) {
            if(words[i].startsWith("#")) {

                if(i == words.length - 1) {
                    hashtags += words[i];
                } else {
                    hashtags += words[i] + " ";
                }
                hashCounter++;
            }
        }

        if(hashCounter > 0) {
            System.out.println(hashtags);
        } else {
            System.out.println("No hashtags were typed");
        }
    }
}