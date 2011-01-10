package controllers;

import models.Session;
import play.mvc.Controller;

public class Sessions extends Controller
{
  public static void showSession(Long id)
  {
    renderArgs.put("session", Session.getSessionById(id));
    renderArgs.put("id", id);
    renderTemplate("Application/sessionDescription.html");
  }
}
