package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void programme() {
        List<Session> sessions = Session.findAll();
        renderArgs.put("sessions",sessions);
        renderTemplate("Application/schedule.html");
    }

    public static void speakers() {
        List<Speaker> speakers = Speaker.findAll();
        renderArgs.put("speakers",speakers);
        renderTemplate("Application/speakers.html");
    }


    public static void description() {
        renderTemplate("Application/description.html");
    }

}