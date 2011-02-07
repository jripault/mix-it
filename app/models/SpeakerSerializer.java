package models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class SpeakerSerializer implements JsonSerializer<Speaker>
{

  public JsonElement serialize(Speaker speaker, Type type, JsonSerializationContext jsonSerializationContext)
  {
    JsonObject obj = new JsonObject();
    obj.addProperty("lastName", speaker.lastName);
    obj.addProperty("firstName", speaker.firstName);
    obj.addProperty("bio", speaker.bio);
    //obj.addProperty("urlImage", speaker.urlImage);
    return obj;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
