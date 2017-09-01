package src;

import src.controllers.AdminController;
import src.controllers.StudentController;
import src.models.Admin;
import src.models.Mentor;
import src.views.ApplicationView;
import src.dao.DAOAdmin;
import src.dao.DAOMentor;
import src.dao.AdminDAO;
import src.dao.MentorDAO;

public class Application {

    public static void main(String[] args) {
        mainController();
    }

    public static void mainController() {

            ApplicationView.setUserLoginMsg();
            String choice = ApplicationView.getUserChoiceInput();

            ApplicationView.setUserId();
            String id = ApplicationView.getInput();

            startLoginProcess(choice, id);
        }

    public static void startLoginProcess(String choice, String id) {
    
        if(choice.equals("1")) {
    
            adminLoginProcess(id);

        }else if(choice.equals("2")){
            mentorLoginProcess(id);
        }
    }

    public static Admin getAdmin(String id) {
        DAOAdmin admin = new DAOAdmin();
        Admin createdAdmin = admin.load(id);
        return createdAdmin;
    }

    public static Mentor getMentor(String id) {

        DAOMentor mentor = new DAOMentor();
        Mentor createdMentor = mentor.load(id);
        return createdMentor;
    }

    public static void adminLoginProcess(String id){
    
        Admin createdAdmin = getAdmin(id);
        

        if (createdAdmin != null){
         
            AdminController.startController(createdAdmin);
        } else {
            ApplicationView.failedLoginMsg();
        }
    }

    public static void mentorLoginProcess(String id){

        Mentor createdMentor = getMentor(id);

        // if (createdMentor != null) {
        //     //MentorController.startController(createdMentor);
        // }else{
        //     ApplicationView.failedLoginMsg();
        // }
    }
}





