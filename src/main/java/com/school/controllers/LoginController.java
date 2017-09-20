package com.school.controllers;

import com.school.dao.UserDao;
import com.school.models.User;
import com.school.views.LoginView;


public class LoginController {

    public static void roleSetting() {

        LoginView.setUserId();
        String id = LoginView.getInput();
        startLoginProcess(id);

}
    public static void startLoginProcess(String id){

        UserDao dao = new UserDao();
        User user = dao.load(id);

        if(user != null) {
            user.startController();
        }else{
            LoginView.failedLoginMsg();
        }
    }
}
