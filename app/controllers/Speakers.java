package controllers;

import models.Speaker;
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
}
