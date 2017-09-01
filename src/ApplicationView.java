import java.util.Scanner;

public class ApplicationView {

    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            input = scan.nextLine();
        } while (input.length() == 0);
        return input;
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
        System.out.println("Wrong login or password");
    }


}



