package com.school.controllers.WebControllers.mentor;

import com.school.controllers.WebControllers.Cookie;
import com.school.dao.UserDAO;
import com.school.models.Mentor;
import com.school.models.User;

public class MentorSessionController extends Cookie {

    public Mentor loadMentor(Integer userID) {

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserById(userID);

        try {
            Mentor mentor = (Mentor) user;
            return mentor;

        } catch (java.lang.ClassCastException e) {
            return null;
        }
    }
}

