package com.school.controllers.WebControllers;

import com.school.controllers.WebControllers.admin.*;
import com.school.controllers.WebControllers.mentor.MentorWebController;
import com.school.controllers.WebControllers.student.*;
import com.school.controllers.WebControllers.utilController.Static;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;


public class App {

        public static void main(String[] args) throws Exception {
            // create a server on port 8000
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            // set routes

            //log in
            server.createContext("/loginForm", new LoginWebController());
            server.createContext("/signUp", new SignUpWebController());

            //students
            server.createContext("/shop", new ShopController());
            server.createContext("/students", new StudentWebController());
            server.createContext("/artifacts", new ArtifactWebController());
            server.createContext("/quests", new StudentQuestWebController());
            server.createContext("/availablequests", new QuestWebController());
            server.createContext("/basket", new BasketController());

            //admins
            server.createContext("/admins", new AdminWebController());
            server.createContext("/add_mentor", new AddMentorController());
            server.createContext("/edit_mentor", new EditMentorController());
            server.createContext("/edit_mentor_submit", new SubmissionMentorEdition());
            server.createContext("/add_course", new AddCourseController());
            server.createContext("/show_mentor", new ShowMentorController());
            server.createContext("/show_course", new ShowCourseController());
            //static
            server.createContext("/static", new Static());
            server.setExecutor(null); // creates a default executor


            //mentors
            server.createContext("/mentors", new MentorWebController());


            // start listening
            server.start();
        }
    }

