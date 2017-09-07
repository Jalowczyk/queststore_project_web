package src.controllers;

// import src.models.Student;
// import src.dao.DAOStudent;
import src.models.Mentor;
import src.models.User;
import src.views.MentorView;

public class MentorController {

    public static void startController(User mentor){
        
        MentorView.welcomeMsg(mentor.getName());
        MentorView.showMenu();

        String choice = MentorView.getChoice();
        startRequestProcess(choice);
    }

    public static void startRequestProcess(String choice){

        if(choice.equals("1")){
            createStudent();

        } else if(choice.equals("2")){
            showCourseInfo();

        } else if(choice.equals("3")){
            manageQuests(); //start QuestController

        } else if(choice.equals("4")){
            manageArtefacts(); //start ArtefactController

        } else if(choice.equals("5")){
            showStudentInfo(); //summary of student wallet, bought artefacts

        } else if(choice.equals("6")){
            markStudentArtefacts();
        
        } else if(choice.equals("7")){
            markStudentQuest();
        
        } else if(choice.equals("0")){
            System.exit(0);
        }
    }

    public static void createStudent(){

        System.out.println("To be implemented");
    }

    public static void showCourseInfo(){

        System.out.println("To be implemented");
    }

    public static void manageQuests(){

        System.out.println("To be implemented");
    }

    public static void manageArtefacts(){

        System.out.println("To be implemented");
    }

    public static void showStudentInfo(){

        System.out.println("To be implemented");
    }

    public static void markStudentArtefacts(){

        System.out.println("To be implemented");
    }

    public static void markStudentQuest(){

        System.out.println("To be implemented");
    }

}
