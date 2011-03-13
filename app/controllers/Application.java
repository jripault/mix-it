package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller
{

  public static void index()
  {
    Attendees attendees = Attendees.findAll();
    renderArgs.put("attendees", attendees);
    render();
  }

  public static void description()
  {
    renderTemplate("Application/description.html");
  }
  
  public static void inscription()
  {
    Attendees attendees = Attendees.findAll();
    renderArgs.put("attendees", attendees);
    renderTemplate("Application/inscription.html");
  }
}