package controllers;

import models.Attendees;
import models.Favorite;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        Attendees attendees = Attendees.findAll();
        renderArgs.put("attendees", attendees);
        render();
    }

    public static void next(){
        renderTemplate("Application/next.html");
    }

    public static void description() {
        renderTemplate("Application/description.html");
    }

    public static void questionnaire() {
        renderTemplate("Application/questionnaire.html");
    }

    public static void team() {
        renderTemplate("Application/team.html");
    }

    public static void inscription() {
        Attendees attendees = Attendees.findAll();
        renderArgs.put("attendees", attendees);
        renderTemplate("Application/inscription.html");
    }

    public static void stats() {
        String stats = Favorite.getStats();
        renderArgs.put("stats", stats);
        renderTemplate("Application/stats.html");
    }
}