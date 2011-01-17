package controllers;

import models.Session;
import models.Slot;
import models.Track;
import play.mvc.Controller;

import java.util.List;

public class Schedule extends Controller
{
  public static void index()
  {
    List<Session> sessions = Session.findAll();
    List<Track> tracks = Track.findAll();
    List<Slot> slots = Slot.findAll();

    renderArgs.put("tracks", tracks);
    renderArgs.put("slots", slots);
    renderArgs.put("sessions", sessions);
    renderTemplate("Application/schedule.html");
  }
}
