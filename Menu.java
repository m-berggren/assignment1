import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String systemMenu = "\n Welcome to the menu. Choose one of the options below: \n 1. Register new scores for students. \n 2. Print all registered grades. \n 3. Calculate the mean of the entered scores. \n 4. Find the two highest and two lowest scores. \n 5. Find the highest score and its position. \n 6. Collect hashtags from a post. \n 7. To exit. \n";
        System.out.println(systemMenu);
        System.out.println("Type your option:");
        int userOptionInMenu = input.nextInt();

//        Only options between 1 and 7 are acceptable. If the user enters a value out
//        of the range above, print an error message saying “Error - Invalid value.
//            Please type between 1 and 7”. Once the user provides a valid option,
//                proceed to the tasks as specified above.

        do {
            if (userOptionInMenu == 1) {
                //-- space for Ex 1 --//

            }

            if (userOptionInMenu == 2) {
                //-- space for Ex 2 --//

            }
            if (userOptionInMenu == 3) {
                //-- space for Ex 3 --//

            }
            if (userOptionInMenu == 4) {
                //-- space for Ex 4 --//
            }
            if (userOptionInMenu == 5) {
                //-- space for Ex 5 --//

            }
            if (userOptionInMenu == 6) {
                //-- space for Ex 6 --//

            }
            if (userOptionInMenu == 7) {
                System.out.println("Thank you for using our grading system. Have a nice day! ");
            }
        } while (userOptionInMenu != 7);
        input.close();
    }
}