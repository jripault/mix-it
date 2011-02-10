package models;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class SessionSerializer implements JsonSerializer<Session>
{

  public JsonElement serialize(Session session, Type type, JsonSerializationContext jsonSerializationContext)
  {
    JsonObject obj = new JsonObject();
    if(session.slot != null)
      obj.addProperty("slot", session.slot.id);
	  
	obj.addProperty("id", session.id);
    obj.addProperty("name", session.name);
    obj.addProperty("description", session.description);
    obj.addProperty("room", session.room);
    if(session.track != null)
      obj.addProperty("track", session.track.id);

    JsonArray array = new JsonArray();
    List<Speaker> speakers = session.findSpeakersBySession();
    for(Speaker speaker : speakers)
    {
      array.add(new JsonPrimitive(speaker.id));
    }
    obj.add("speakers", array);

    return obj;
  }
}
