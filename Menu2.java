import Assignment1_old.CollectHashtags;

public class Menu2 {

    private static IOScanner input = new IOScanner();
    public static void main(String[] args) {
        

        int userOptionInMenu = 0;
        int[] arrayOfScores = readGrade();

        do {
            System.out.println("\nWelcome to the menu. Choose one of the options below: \n" +
            "1. Register new scores for students. \n" +
            "2. Print all registered grades. \n" +
            "3. Calculate the mean of the entered scores. \n" +
            "4. Find the two highest and two lowest scores. \n" +
            "5. Find the highest score and its position. \n" +
            "6. Collect hashtags from a post. \n" +
            "7. To exit. \n\n");
            System.out.println("Type your option:");

            

                printScores(arrayOfScores, "Your entered scores are: ");

            userOptionInMenu = input.readInt();

        switch (userOptionInMenu) {
            case 1 -> ScoreValue.scoreArray();
            case 2 -> GradesPrinting.();
            case 3-> MeanCalculating.calculateMean();
            case 4-> FindHighLowScore.findHighLowScore();
            case 5-> FindScorePosition.findScorePosition();
            case 6-> CollectHashtags.();
            case 7 -> System.out.println(exitConsoleMessage);
            default -> System.out.println(errorConsoleMessage);
        }

        input.close();
    }

    public static int[] readGrade() {
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
        return scoreArray;
    }

    public static void printScores(int[] intArray, String message) {
        System.out.printf("%s %n", message);
        for (int i=0; i < intArray.length; i++) {
            if (i == 0) {
            System.out.print(intArray[i]);
            } else {
            System.out.printf(", %s", intArray[i]);
            }
        }
        System.out.println();
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
}
