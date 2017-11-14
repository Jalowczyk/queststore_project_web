package com.school.controllers.WebControllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.Map;

import java.net.URLDecoder;
import java.util.HashMap;


import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class StudentRoom implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String method = httpExchange.getRequestMethod();
        String response = "";

        if (method.equals("GET")) {
            System.out.println("get");

            String userAgent = httpExchange.getRequestHeaders().getFirst("User-agent");

            JtwigTemplate template = JtwigTemplate.classpathTemplate("account.twig");

            JtwigModel model = JtwigModel.newModel();

            response = template.render(model);

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


        }

    }
}
