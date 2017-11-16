package com.school.controllers.WebControllers;

import com.school.dao.UserDAO;
import com.school.models.Student;
import com.school.models.User;
import com.sun.net.httpserver.Headers;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

import java.util.List;



public class StudentWebController implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "";
        String method = httpExchange.getRequestMethod();

        Headers requestHeaders = httpExchange.getRequestHeaders();

        Integer userID = getIdFromCookies(requestHeaders);

        if(userID == null){

            httpExchange.getResponseHeaders().set("Location", "/loginForm");
            httpExchange.sendResponseHeaders(302, -1);

        }


        else if (method.equals("GET")) {

            UserDAO userDao = new UserDAO();
            User user = userDao.getUserById(userID);

            Student student = (Student) user;

            JtwigTemplate template = JtwigTemplate.classpathTemplate("account.twig");
            JtwigModel model = JtwigModel.newModel();

            model.with("students", student);

            response = template.render(model);

            httpExchange.sendResponseHeaders(200, response.length());


        }

        else if(method.equals("POST")){
            System.out.println("postik");
        }

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }

    private static Integer getIdFromCookies(Headers requestHeaders) {

        Integer userID;
        try {
            String key = "Cookie";
            List values = requestHeaders.get(key);
            String keyValue = (String) values.get(0);
            String id = keyValue.split("=")[1];
            userID = Integer.valueOf(id);
        }catch (Exception e){
            return null;
        }

        return userID;
    }
    }





