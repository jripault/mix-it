package models;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class TagSerializer implements JsonSerializer<Tag>
{

  public JsonElement serialize(Tag tag, Type type, JsonSerializationContext jsonSerializationContext)
  {
    JsonObject obj = new JsonObject();

    obj.addProperty("id", tag.id);
    obj.addProperty("name", tag.name);

    JsonArray array = new JsonArray();
    List<Session> sessions = tag.findSessionsByTag();
    for (Session session : sessions)
    {
      array.add(new JsonPrimitive(session.id));
    }
    obj.add("sessions", array);

    return obj;
  }
}
