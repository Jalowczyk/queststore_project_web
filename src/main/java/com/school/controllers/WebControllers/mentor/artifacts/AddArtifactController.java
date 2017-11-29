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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class AddArtifactController extends MentorSessionController implements HttpHandler {

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

            JtwigTemplate template = JtwigTemplate.classpathTemplate("/static/MentorTemplates/addartifact.html");
            JtwigModel model = JtwigModel.newModel();

            response = template.render(model);

        } else if (method.equals("POST")) {

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            Map inputs = parseFormData(formData);

            String artifactName = inputs.get("artifact_title").toString();
            String artifactInfo = inputs.get("artifact_category").toString();
            Integer artifactPrice = Integer.parseInt(inputs.get("artifact_price").toString());

            Artifact artifact = new Artifact(artifactName, artifactPrice, artifactInfo);
            ArtefactDAO artefactDAO = new ArtefactDAO();
            artefactDAO.saveArtifact(artifact);

            JtwigTemplate template = JtwigTemplate.classpathTemplate("/static/MentorTemplates/manageartifacts.html");

            JtwigModel model = JtwigModel.newModel();
            model.with("artifact_added", true);
            model.with("artifacts", artefactDAO.getAllArtifacts());


            response = template.render(model);

        }

        final byte[] finalResponseBytes = response.getBytes("UTF-8");
        httpExchange.sendResponseHeaders(200, finalResponseBytes.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

