package controllers;

import models.Favorite;
import models.Session;
import play.mvc.Controller;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class Favorites extends Controller
{
  public static void star(String login, Long sessionId, Boolean starred)
  {
    if (login == null || sessionId == null || starred == null)
    {
      renderText("Error: parameters missing.\n"
        + "login: " + login
        + "\nsessionId: " + sessionId
        + "\nstarred" + starred);
    }
    else
    {
      Favorite favorite = Favorite.findByLoginAndSessionId(login, sessionId);
      Session session = Session.findById(sessionId);
      if (session != null)
      {
        if (favorite == null)
        {
          favorite = new Favorite(login, sessionId, starred);
          favorite.insert();
        }
        else
        {
          favorite.starred = starred;
          favorite.update();
        }
        renderText("ok");
      }
      else
      {
        renderText("Error: this session does not exist.");
      }
    }
  }
}
