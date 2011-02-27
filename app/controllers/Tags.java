package controllers;

import com.google.gson.GsonBuilder;
import models.Tag;
import models.TagSerializer;
import play.libs.Crypto;
import play.mvc.Controller;

import java.util.List;

public class Tags extends Controller
{
  public static void listAsJson()
  {
    List<Tag> tags = Tag.findAll();
    renderJSON(tags, new TagSerializer());
  }

  public static void listAsMd5()
  {
    List<Tag> tags = Tag.findAll();
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapter(TagSerializer.class, new TagSerializer());
    String json = gson.create().toJson(tags);
    renderText(Crypto.passwordHash(json));
  }
}
