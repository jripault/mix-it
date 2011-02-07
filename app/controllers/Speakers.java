package controllers;

import models.Speaker;
import models.SpeakerSerializer;
import play.mvc.Controller;

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
}
