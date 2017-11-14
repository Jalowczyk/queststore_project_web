package com.school.controllers.WebControllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.Map;

import java.net.URLDecoder;
import java.util.HashMap;


import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;


public class LoginForm implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String method = httpExchange.getRequestMethod();
        String response = "";

        if (method.equals("GET")) {
            System.out.println("get");

            String userAgent = httpExchange.getRequestHeaders().getFirst("User-agent");

            JtwigTemplate template = JtwigTemplate.classpathTemplate("main_page.twig");

            JtwigModel model = JtwigModel.newModel();

            response = template.render(model);

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


        }

        if (method.equals("POST")) {

            System.out.println("post");
            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            Map inputs = parseFormData(formData);

            String firstName = inputs.get("name").toString();
            String lastName = inputs.get("message").toString();

            System.out.println(firstName);
            System.out.println(lastName);
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap();
        String[] pairs = formData.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            // We have to decode the value because it's urlencoded. see: https://en.wikipedia.org/wiki/POST_(HTTP)#Use_for_submitting_web_forms
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }

    }

