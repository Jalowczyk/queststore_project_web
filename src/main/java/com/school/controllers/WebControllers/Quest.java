package com.school.controllers.WebControllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;


import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;


public class Quest implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String method = httpExchange.getRequestMethod();
        String response = "";

        if (method.equals("GET")) {

            String userAgent = httpExchange.getRequestHeaders().getFirst("User-agent");

            JtwigTemplate template = JtwigTemplate.classpathTemplate("myquests.twig");

            JtwigModel model = JtwigModel.newModel();

            response = template.render(model);
            final byte[] finalResponseBytes = response.getBytes("UTF-8");
            httpExchange.sendResponseHeaders(200, finalResponseBytes.length);

        }
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
