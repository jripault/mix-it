package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.ArrayList;
import java.util.List;

public class Favorite extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;


  @Column("login")
  @NotNull
  public String login;

  @Column("starred")
  public Boolean starred;

  @NotNull
  @Column("sessionId")
  public Long sessionId;

  @Filter("track")
  public Query<Session> sessions;

  public Favorite()
  {
  }

  public Favorite(String login, Long sessionId, Boolean starred)
  {
    this.login = login;
    this.sessionId = sessionId;
    this.starred = starred;
  }

  static Query<Favorite> all()
  {
    return SienaSupport.all(Favorite.class);
  }

  public static List<Session> getSessionForLogin(String login)
  {
    List<Favorite> favorites = all().filter("login", login).fetch();
    List<Session> sessions = new ArrayList<Session>();
    for (Favorite favorite : favorites)
    {
      Session session = Session.getSessionById(favorite.sessionId);
      if (session != null)
      {
        sessions.add(session);
      }
    }

    return sessions;
  }

  public static List<Favorite> findAll()
  {
    return all().fetch();
  }

  public static Favorite find(Long id)
  {
    return all().filter("id", id).get();
  }

  public static Favorite findByLoginAndSessionId(String login, Long sessionId)
  {
    return all().filter("login", login).filter("sessionId", sessionId).get();
  }
}

