package controllers;

import play.mvc.Controller;

public class Sponsors extends Controller
{

  public static void index()
  {
    renderTemplate("Application/sponsors.html");
  }
}
