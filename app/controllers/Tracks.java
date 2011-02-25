package controllers;

import com.google.gson.GsonBuilder;
import models.Speaker;
import models.SpeakerSerializer;
import models.Track;
import play.libs.Crypto;
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

  public static void listAsMd5()
  {
    List<Track> tracks = Track.findAll();
    GsonBuilder gson = new GsonBuilder();
    String json = gson.create().toJson(tracks);
    renderText(Crypto.passwordHash(json));
  }
}
