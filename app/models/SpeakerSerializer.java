package models;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class SpeakerSerializer implements JsonSerializer<Speaker>
{

  public JsonElement serialize(Speaker speaker, Type type, JsonSerializationContext jsonSerializationContext)
  {
    JsonObject obj = new JsonObject();
	obj.addProperty("id", speaker.id);
    obj.addProperty("lastName", speaker.lastName);
    obj.addProperty("firstName", speaker.firstName);
    obj.addProperty("bio", speaker.bio);
    obj.addProperty("company", speaker.company);
    obj.addProperty("urlImage", speaker.urlImage);
    obj.addProperty("twitter", speaker.twitter);
    obj.addProperty("linkedin", speaker.linkedin);
    obj.addProperty("blog", speaker.blog);

    JsonArray array = new JsonArray();
    List<Session> sessions = speaker.findSessionsBySpeaker();
    for(Session session : sessions)
    {
      array.add(new JsonPrimitive(session.id));
    }
    obj.add("sessions", array);
    return obj;
  }
}
