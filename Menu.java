import java.util.Locale;

public class Menu {
    static IOScanner input = new IOScanner();

    public static void main(String[] args) {
        int userOptionInMenu;
        int[] arrayOfScores = readGrade(0);

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
            userOptionInMenu = input.readInt();

            String exitConsoleMessage = "Thank you for using our grading system. Have a nice day!";
            String errorConsoleMessage = "Error - Invalid value. Please type between 1 and 7.";

            // execute various cases by changing value of "userOptionInMenu"
            switch (userOptionInMenu) {
                case 1 -> arrayOfScores = readGrade(1);
                case 2 -> printScores(arrayOfScores, "Your entered scores are:");
                case 3 -> calculateMean(arrayOfScores);
                case 4 -> highLowValues(arrayOfScores, 4);
                case 5 -> findHighestScorePosition(arrayOfScores);
                case 6 -> collectHashtags();
                case 7 -> System.out.println(exitConsoleMessage);
                default -> System.out.println(errorConsoleMessage);
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
    public static int[] readGrade(int paramValue) {
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
        if(paramValue == 1) {
            printScores(scoreArray, "Thank you for your input. Your entered scores are: ");
        } else if(paramValue == 0) {
            printScores(scoreArray, "thank you for your input. your entered scores are: ");
        }
        return scoreArray;
    }
    public static void printScores(int[] intArray, String message) {
        System.out.printf("%s%n", message);
        for (int i=0; i < intArray.length; i++) {
            if (i == 0) {
                System.out.print(intArray[i]);
            } else {
                System.out.printf(", %s", intArray[i]);
            }
        }
        System.out.println();
    }
    public static double calculateMean(int[] array) {
        // this code will help to count the mean of 7 numbers(student points),
        // which would be assigned by user in the console
        double sumOfScores = 0;

        for (double score : array) {
            sumOfScores = sumOfScores + score; // not to stuck in nested loop
        }

        double meanOfPoints = 0.0;
        if (array.length > 0) {
            meanOfPoints = sumOfScores / array.length;
        }
        Locale.setDefault(Locale.ENGLISH); // with help of this command decimal symbols would be with dot
        System.out.printf("The mean of the numbers is %.2f%n", meanOfPoints);
        return meanOfPoints;
    }
    public static void collectHashtags() {
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

    public static int highLowValues(int[] array, int intParam) {

        int lowestScore = 0;
        int secondLowestScore = 0;
        int highestScore = 0;
        int secondHighestScore = 0;

        for(int i=0; i < array.length; i++) {
            
            if(i == 0){
                lowestScore = array[i];
            }
            if(i == 1){
                secondLowestScore = array[i];
            }

            if (array[i] < lowestScore) {
                secondLowestScore = lowestScore;
                lowestScore = array[i];
            } else if (array[i] < secondLowestScore) {
                secondLowestScore = array[i];
            }

            if (array[i] > highestScore) {
                secondHighestScore = highestScore;
                highestScore = array[i];
            } else if (array[i] > secondHighestScore) {
                secondHighestScore = array[i];
            }
        }
        if(intParam == 4) {
            System.out.println("\nThe two lowest scores provided are " + lowestScore + ", and "
                + secondLowestScore);
            System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);
        }
        
        return highestScore;
    }

    public static void findHighestScorePosition(int[] array){
        int positionOfHighestScore = -1;
        int highestScore = highLowValues(array, 5);

        boolean foundHighestScore = false;
        String[] suffixArray = { "st", "nd", "rd", "th", "th", "th", "th" };

        for (int count = 0; count < array.length; count++) {
            if (array[count] == highestScore && !foundHighestScore) {
                positionOfHighestScore = count;
                foundHighestScore = true;
            }
        }

        if (foundHighestScore) {
            System.out.printf("%s %s %s %s%s %s%n", "The highest score is", highestScore, "and belongs to the",
                    positionOfHighestScore + 1, suffixArray[positionOfHighestScore], "student" );
        }
    }
}