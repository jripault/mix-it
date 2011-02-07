package controllers;

import models.Slot;
import models.Speaker;
import models.SpeakerSerializer;
import play.mvc.Controller;

import java.util.List;

public class Slots extends Controller
{

  public static void listAsJson()
  {
    List<Slot> slots = Slot.findAll();
    renderJSON(slots);
  }
}
