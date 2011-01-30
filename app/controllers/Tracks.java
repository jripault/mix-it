package controllers;

import models.Track;
import play.mvc.Controller;

import java.util.List;

public class Tracks extends Controller
{
  public static void listAsJson()
  {
    List<Track> tracks = Track.findAll();
    renderJSON(tracks);
  }

  public static void listSessionsAsJson(Long id)
  {
    Track track = Track.find(id);
    if(track != null)
    {
      renderJSON(track);
    }
  }
}
