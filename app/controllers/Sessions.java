package controllers;

import models.Session;
import models.SessionSerializer;
import play.mvc.Controller;

import java.util.List;

public class Sessions extends Controller
{
  public static void index()
  {
    List<Session> sessions = Session.findAll();
    renderArgs.put("sessions", sessions);
    renderTemplate("Application/sessions.html");
  }

  public static void showSession(Long id)
  {
    Session session = Session.getSessionById(id);
    renderArgs.put("mySession", session);
    renderTemplate("Application/sessionDescription.html");
  }

  public static void listAsJson()
  {
    List<Session> sessions = Session.findAll();
    renderJSON(sessions, new SessionSerializer());
  }
}
