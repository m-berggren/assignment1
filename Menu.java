import java.util.Locale;

public class Menu {
    static String[] suffixArray = { "st", "nd", "rd", "th", "th", "th", "th" };
    static int[] arrayOfScores = new int[7];
    static int lowestScore = 0;
    static int secondLowestScore = 0;
    static int highestScore = 0;
    static int secondHighestScore = 0;

    public static void main(String[] args) {
        int userOptionInMenu;

        // call function which is responsible for entering grades
        readGrade();

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
            userOptionInMenu = IOScanner.readIntWithMessage("Type your option:");

            // define three messages to use them later in switch, and make code more readable
            String highestAndLowestMessage = "%nThe two lowest scores provided are %d, and %d%nThe two highest scores provided are %d, and %d";
            String exitConsoleMessage = "Thank you for using our grading system. Have a nice day!";
            String errorConsoleMessage = "Error - Invalid value. Please type between 1 and 7.";
            
            // execute various cases by changing value of "userOptionInMenu"
            switch (userOptionInMenu) {
                case 1 -> readGrade();
                case 2 -> printGrades("Your entered scores are:");
                case 3 -> calculateMean();
                case 4 -> {
                    highLowValues();
                    System.out.printf(highestAndLowestMessage, lowestScore, secondLowestScore, highestScore, secondHighestScore);
                }
                case 5 -> findHighestScorePosition();
                case 6 -> collectHashtags();
                case 7 -> System.out.println(exitConsoleMessage);
                default -> System.out.println(errorConsoleMessage);
            }

            // we have an option to rewrite this part of the code(switch) with the help of if statements
            // however, code will be harder to understand and not as compact

        } while (userOptionInMenu != 7); // do-while loop works while value of the variable is not equal to 7

        IOScanner.close(); // to close the scanner
    }
    public static int[] readGrade() {
        /* Function reads inputs and stores them in an array.
        While loop is used to handle cases when entered score is less than 0 or over 100,
        so loop can continue. */
        
        int i = 0;

        while(i < suffixArray.length) {
            System.out.printf("Enter the score for the %d%s student ", i + 1, suffixArray[i]);
            int score = IOScanner.readInt();

            if (score > 100 || score < 0) {
                System.out.println("Error - Input out of bound. Score can only be between 0 and 100.");
            } else {
                arrayOfScores[i] = score;
                i++;
            }
        }
        // This function will loop over arrayOfScores and print every element
        printGrades("Thank you for your input. Your entered scores are: ");

        return arrayOfScores;
    }
    public static void printGrades(String messageWithScores) {
        // This function prints all elements in arrayOfScores through a for loop.
        System.out.printf("%s%n", messageWithScores);
        for (int i=0; i < arrayOfScores.length; i++) {
            if (i == 0) {
                System.out.print(arrayOfScores[i]);
            } else {
                System.out.printf(", %s", arrayOfScores[i]);
            }
        }
        System.out.println();
    }
    public static double calculateMean() {
        // this code will help to count the mean of 7 numbers(student points),
        // which would be assigned by user in the console
        double sumOfScores = 0;

        for (double score : arrayOfScores) {
            sumOfScores = sumOfScores + score; // not to stuck in nested loop
        }

        double meanOfPoints = 0.0;
        if (arrayOfScores.length > 0) {
            meanOfPoints = sumOfScores / arrayOfScores.length; 
        }
        Locale.setDefault(Locale.ENGLISH); // with help of this command decimal symbols would be with dot
        System.out.printf("The mean of the numbers is %.2f%n", meanOfPoints);
        return meanOfPoints;
    }
    public static void highLowValues() {
        //this part of code is used to find highest and lowest values from the user's input from console
        highestScore = 0;
        secondHighestScore = 0;
        
        //here we arrange values for highest and secondHighest scores in the order of elements in array
        for(int i=0; i < arrayOfScores.length; i++) {
            if(i == 0){
                lowestScore = arrayOfScores[i];
            }
            if(i == 1){
                secondLowestScore = arrayOfScores[i];
            }
            // we use variables lowestScore, secondLowestScore throughout an array and change their values depending if the next one is lower than previous one in array 
            if (arrayOfScores[i] < lowestScore) {
                secondLowestScore = lowestScore;
                lowestScore = arrayOfScores[i];
            } else if (arrayOfScores[i] < secondLowestScore) {
                secondLowestScore = arrayOfScores[i];
            }
            // we use variables highestScore and secondHighestScore throughout an array and change their values depending if the next one is higher than previous one in array  
            if (arrayOfScores[i] > highestScore) {
                secondHighestScore = highestScore;
                highestScore = arrayOfScores[i];
            } else if (arrayOfScores[i] > secondHighestScore) {
                secondHighestScore = arrayOfScores[i];
            }
        }
    }
    public static void findHighestScorePosition(){
        //this function is used to find the position of highest score in array
        int positionOfHighestScore = -1;
        highLowValues();//we use the values of elements from the previous function
        
        boolean foundHighestScore = false;//used to find the first occurence of the element

        for (int count = 0; count < arrayOfScores.length; count++) {
            if (arrayOfScores[count] == highestScore && !foundHighestScore) { //checks elements one by one if it equals to highest score and if the highest score wasn't found
                positionOfHighestScore = count;
                foundHighestScore = true; // used to ensure that the first occuration of highest score is printed
            }
        }
        if (foundHighestScore) { //printing highest score and its affiliation to the student's number
            System.out.printf("%s %s %s %s%s %s%n", "The highest score is", highestScore, "and belongs to the",
                    positionOfHighestScore + 1, suffixArray[positionOfHighestScore], "student" ); //printing highest score and its position with the corresponding suffix for student number
        }
    }
    public static void collectHashtags() {
        /* Function collects words beginning with a hashtag.
        Words are stored in an array created by inputs.
        */
        
        String inputString = IOScanner.readStringWithMessage("Type your post: ");

        // Splits inputString into an array.
        String[] words = inputString.split("\\s+");
        String hashtags = "Hashtags found: ";

        int hashCounter = 0;

        for(int i=0; i < words.length; i++) {
            if(words[i].startsWith("#")) {

                // Adds a whitespace when 'i' is not the last element in the array.
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
