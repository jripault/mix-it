package controllers;

import models.Session;
import play.mvc.Controller;

import java.util.List;

public class Sessions extends Controller
{
  public static void showSession(Long id)
  {
    Session session = Session.getSessionById(id);
    renderArgs.put("mySession", session);
    renderTemplate("Application/sessionDescription.html");
  }

  public static void listAsJson()
  {
    List<Session> sessions = Session.findAll();
    renderJSON(sessions);
  }
}
