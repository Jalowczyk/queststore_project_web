package com.school.controllers.WebControllers;

import com.school.dao.StudentDAO;
import com.school.dao.UserDAO;
import com.school.dao.WalletDAO;
import com.school.models.Student;
import com.school.models.User;
import com.school.models.Wallet;
import com.sun.net.httpserver.Headers;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


public class StudentWebController implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "";
        String method = httpExchange.getRequestMethod();

        Headers requestHeaders = httpExchange.getRequestHeaders();

        Cookie cookies = new Cookie();
        Integer userID = cookies.getIdFromCookies(requestHeaders);

        if (userID == null) {

            httpExchange.getResponseHeaders().set("Location", "/loginForm");
            httpExchange.sendResponseHeaders(302, -1);

        } else if (method.equals("GET")) {

            UserDAO userDao = new UserDAO();
            User user = userDao.getUserById(userID);

            Student student = getStudentObject(user);
            setUpAttributes(student);

            JtwigTemplate template = JtwigTemplate.classpathTemplate("account.html");
            JtwigModel model = JtwigModel.newModel();

            model.with("students", student);

            response = template.render(model);

            httpExchange.sendResponseHeaders(200, response.length());

        } else if (method.equals("POST")) {

        }

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }

    private static Student getStudentObject(User user) {
        try {
            Student student = (Student) user;
            return student;
        } catch (java.lang.ClassCastException e) {
            return null;
        }
    }

    private static void setUpAttributes(Student student){

        StudentDAO studentDAO = new StudentDAO(student);
        WalletDAO walletDAO = new WalletDAO();
        Wallet myWallet = walletDAO.getWalletById(studentDAO.getStudentWalletId());

        student.setArtifacts(studentDAO.getStudentArtefacts());
        student.setWallet(myWallet);

    }
}





