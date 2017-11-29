package com.school.controllers.WebControllers.mentor;

import com.school.controllers.WebControllers.Cookie;
import com.school.dao.StudentDAO;
import com.school.dao.UserDAO;
import com.school.dao.WalletDAO;
import com.school.models.Mentor;
import com.school.models.Student;
import com.school.models.User;
import com.school.models.Wallet;
import com.school.onlineshop.part1.Basket;

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

    public Student loadStudent(Integer userID) {

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserById(userID);

        try {
            Student student = (Student) user;
            setupStudentBalance(student);
            setupStudentBasket(student);


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
    private void setupStudentBasket(Student student) {

        StudentDAO studentDAO = new StudentDAO(student);
        Basket basket = studentDAO.getStudentBasket();
        student.setBasket(basket);

    }

}

