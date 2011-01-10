package controllers;

import models.Session;
import play.mvc.Controller;

public class Sessions extends Controller
{
  public static void showSession(Long id)
  {
    Session session = Session.getSessionById(id);
    renderArgs.put("mySession", session);
    renderTemplate("Application/sessionDescription.html");
  }
}
