package controllers;

import com.google.gson.GsonBuilder;
import models.Speaker;
import models.SpeakerSerializer;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.results.RenderJson;

import java.lang.reflect.Type;
import java.util.List;

public class Speakers extends Controller
{

  public static void index()
  {
    List<Speaker> speakers = Speaker.findAll();
    renderArgs.put("speakers", speakers);
    renderTemplate("Application/speakers.html");
  }

  public static void listAsJson()
  {
    List<Speaker> speakers = Speaker.findAll();
    renderJSON(speakers, new SpeakerSerializer());
  }

  public static void listAsMd5()
  {
    List<Speaker> speakers = Speaker.findAll();
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapter(SpeakerSerializer.class, new SpeakerSerializer());
    String json = gson.create().toJson(speakers);
    renderText(Crypto.passwordHash(json));
  }
}
