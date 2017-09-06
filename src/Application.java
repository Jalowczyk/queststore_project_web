package src;

import src.controllers.AdminController;
import src.controllers.MentorController;
import src.controllers.LoginController;
import src.models.User;
import src.views.ApplicationView;
import src.dao.DAOAdmin;
import src.dao.DAOMentor;

public class Application {
    
    public static void main(String[] args) {
        LoginController.roleSetting();
    }
}