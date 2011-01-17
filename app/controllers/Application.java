package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller
{

  public static void index()
  {
    render();
  }

  public static void description()
  {
    renderTemplate("Application/description.html");
  }
}