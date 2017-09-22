package com.school.controllers;

import com.school.dao.UserDao;
import com.school.models.User;
import com.school.views.LoginView;


public class LoginController {

    public static void roleSetting() {

        LoginView.setUserId();
        String id = LoginView.getInput();
        LoginView.setUserPassword();
        String password = LoginView.getInput();
        startLoginProcess(id, password);

}
    public static void startLoginProcess(String id, String password){

        UserDao dao = new UserDao();
        User user = dao.load(id, password);
        if(user != null) {
            user.startController();
        }else{
            LoginView.failedLoginMsg();
        }
    }
}
