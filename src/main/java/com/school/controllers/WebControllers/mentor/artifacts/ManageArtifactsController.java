package com.school.controllers.WebControllers.mentor.artifacts;

import com.school.controllers.WebControllers.mentor.MentorSessionController;
import com.school.dao.ArtefactDAO;
import com.school.models.Artifact;
import com.school.models.Mentor;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;


public class ManageArtifactsController extends MentorSessionController implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "";
        String method = httpExchange.getRequestMethod();

        Headers requestHeaders = httpExchange.getRequestHeaders();
        Integer userID = getIdFromExistingCookies(requestHeaders);


        if (userID == null) {

            httpExchange.getResponseHeaders().set("Location", "/loginForm");
            httpExchange.sendResponseHeaders(302, -1);

        } else if (method.equals("GET")) {

            Mentor mentor = loadMentor(userID);

            if (mentor != null) {
                String cookie = setupCookies(mentor);
                httpExchange.getResponseHeaders().add("Set-Cookie", cookie);
            }

            ArtefactDAO artefactDAO = new ArtefactDAO();
            ArrayList<Artifact> allArtifacts = artefactDAO.getAllArtifacts();

            JtwigTemplate template = JtwigTemplate.classpathTemplate("/static/MentorTemplates/manageartifacts.html");
            JtwigModel model = JtwigModel.newModel();
            model.with("artifacts", allArtifacts);

            response = template.render(model);
            httpExchange.sendResponseHeaders(200, response.length());
        }

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}
