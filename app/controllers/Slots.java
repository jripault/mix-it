package controllers;

import com.google.gson.GsonBuilder;
import models.Slot;
import models.Speaker;
import models.SpeakerSerializer;
import play.libs.Crypto;
import play.mvc.Controller;

import java.util.List;

public class Slots extends Controller
{

  public static void listAsJson()
  {
    List<Slot> slots = Slot.findAll();
    renderJSON(slots);
  }

  public static void listAsMd5()
  {
    List<Slot> slots = Slot.findAll();
    GsonBuilder gson = new GsonBuilder();
    String json = gson.create().toJson(slots);
    renderText(Crypto.passwordHash(json));
  }
}
