package com.school.controllers.WebControllers.mentor.quest_controllers;

import com.school.controllers.WebControllers.UserSessionController;
import com.school.dao.QuestDAO;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class SubmitEditQuest extends UserSessionController implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String method = httpExchange.getRequestMethod();
        String response = "";

        if(method.equals("POST")) {

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            Map inputs = parseFormData(formData);

            String title = inputs.get("title").toString();
            String info = inputs.get("information").toString();
            Integer price = Integer.parseInt(inputs.get("price").toString());
            String category = inputs.get("category").toString();


            Integer id = Integer.parseInt(inputs.get("id").toString());

            QuestDAO questDAO = new QuestDAO();
            questDAO.editArtifact(title, info, price, id);

            JtwigTemplate template = JtwigTemplate.classpathTemplate("/static/MentorTemplates/mentor_account.html");

            JtwigModel model = JtwigModel.newModel();
            model.with("quest_edited", true);
            model.with("quests", questDAO.getAllQuests());

            response = template.render(model);

        }

        final byte[] finalResponseBytes = response.getBytes("UTF-8");
        httpExchange.sendResponseHeaders(200, finalResponseBytes.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}