package com.school.controllers.WebControllers.student;

import com.school.controllers.WebControllers.Cookie;
import com.school.dao.QuestDAO;
import com.school.dao.StudentDAO;
import com.school.dao.UserDAO;
import com.school.dao.WalletDAO;
import com.school.models.Student;
import com.school.models.User;
import com.school.models.Wallet;

public abstract class StudentSessionController extends Cookie {

    public Student loadStudent(Integer userID) {

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserById(userID);

        try {
            Student student = (Student) user;
            setupStudentBalance(student);

            return student;

        } catch (java.lang.ClassCastException e) {
            return null;
        }
    }


    public void setupStudentArtifacts(Student student) {

        StudentDAO studentDAO = new StudentDAO(student);
        student.setArtifacts(studentDAO.getStudentArtefacts());

    }

    public void setupStudentquests(Student student) {

        StudentDAO studentDAO = new StudentDAO(student);
        student.setQuests(studentDAO.getStudentQuests());


    }

    public void setupStudentBalance(Student student) {

        StudentDAO studentDAO = new StudentDAO(student);
        WalletDAO walletDAO = new WalletDAO();
        Wallet myWallet = walletDAO.getWalletById(studentDAO.getStudentWalletId());
        student.setWallet(myWallet);

    }
}
