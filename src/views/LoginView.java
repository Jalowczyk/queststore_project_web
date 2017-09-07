package src.views;

import java.util.Scanner;

public class LoginView {

    private static Scanner scan = new Scanner(System.in);
    private static int inputNum;
    private static String input;

    public static String getInput() {
        do {
            input = scan.nextLine();
        } while (input.length() == 0);
        return input;
    }

    public static String getUserChoiceInput() {
        do {
            System.out.println("Please provide your role: ");
            inputNum = scan.nextInt();
        } while (inputNum <0 | inputNum >3);
        
        return Integer.toString(inputNum);
    }

    public static void setUserLoginMsg(){

        String loginMenu = "\n 1. Admin\n"
                            + " 2. Mentor\n"
                            + " 3. Student\n";

        System.out.println(loginMenu);
    }

    public static void setUserId(){
        System.out.println("Please provide your id: ");
    }

    public static void failedLoginMsg(){
        System.out.println("Wrong id or password");
    }


}



