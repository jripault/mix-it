package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.ArrayList;
import java.util.Iterator;
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

  public static String getStats()
  {
    List<Stat> stats = new ArrayList<Stat>();
    List<Session> sessions = Session.findAll();
    for (Session session : sessions)
    {
      int value = 0;
      List<Favorite> favorites = all().filter("sessionId", session.id).fetch();
      for (Favorite favorite : favorites)
      {
        if (favorite.starred)
        {
          value++;
        }
      }
      Track track = Track.find(session.track.id);
      stats.add(new Stat(session.name, value, track.color));
    }

    return asJavascriptArray(stats);
  }

  public static class Stat
  {
    public Stat(String name, int value, String color)
    {
      this.name = name;
      this.value = value;
      this.color = color;
    }

    public int value;
    public String name;
    public String color;
  }

  public static String asJavascriptArray(List<Stat> list)
  {
    StringBuffer sbValue = new StringBuffer(15 * list.size());
    StringBuffer sbName = new StringBuffer(15 * list.size());
    StringBuffer sbResult = new StringBuffer(15 * list.size());
    sbResult.append('[');
    sbName.append('[');
    sbValue.append('[');

    Iterator<Stat> ite = list.iterator();
    int i = 0;
    while (ite.hasNext())
    {
      Stat stat = ite.next();
      if (i++ > 0)
      {
        sbName.append(',');
        sbValue.append(',');
      }
      sbName.append("'").append(stat.name.replace("'", "\\'")).append("'");
      sbValue.append(stat.value);
    }

    sbName.append(']');
    sbValue.append(']');

    sbResult.append(sbName.toString()).append(",").append(sbValue.toString());

    sbResult.append(']');
    return sbResult.toString();
  }
}

