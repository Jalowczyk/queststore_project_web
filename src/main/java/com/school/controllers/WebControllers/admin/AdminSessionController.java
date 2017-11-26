package com.school.controllers.WebControllers.admin;

import com.school.controllers.WebControllers.Cookie;
import com.school.dao.UserDAO;
import com.school.models.Admin;
import com.school.models.User;

public class AdminSessionController extends Cookie {

    public Admin loadAdmin(Integer userID) {

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserById(userID);

        try {
            Admin admin = (Admin) user;
            return admin;

        } catch (java.lang.ClassCastException e) {
            return null;
        }
    }
}
