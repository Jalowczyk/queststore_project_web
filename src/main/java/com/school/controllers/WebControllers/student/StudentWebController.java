package com.school.controllers.WebControllers.student;

import com.school.models.Student;
import com.sun.net.httpserver.Headers;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


public class StudentWebController extends StudentSessionController implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "";
        String method = httpExchange.getRequestMethod();

        Headers requestHeaders = httpExchange.getRequestHeaders();

        Integer userID = getIdFromCookies(requestHeaders);

        if (userID == null) {

            httpExchange.getResponseHeaders().set("Location", "/loginForm");
            httpExchange.sendResponseHeaders(302, -1);

        } else if (method.equals("GET")) {

            Student student = getUser(userID);

            JtwigTemplate template = JtwigTemplate.classpathTemplate("account.html");
            JtwigModel model = JtwigModel.newModel();

            model.with("students", student);

            response = template.render(model);
            httpExchange.sendResponseHeaders(200, response.length());
        }

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}





