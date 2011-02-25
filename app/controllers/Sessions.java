package controllers;

import com.google.gson.GsonBuilder;
import models.Session;
import models.SessionSerializer;
import models.Speaker;
import models.SpeakerSerializer;
import play.libs.Crypto;
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


  public static void listAsMd5()
  {
    List<Session> sessions = Session.findAll();
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapter(SessionSerializer.class, new SessionSerializer());
    String json = gson.create().toJson(sessions);
    renderText(Crypto.passwordHash(json));
  }
}
