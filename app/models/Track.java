package models;

import siena.*;
import models.crudsiena.SienaSupport;

import java.util.List;

public class Track extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;


  @Column("name")
  @NotNull
  public String name;

  @Column("color")
  public String color;

  @Filter("track")
  public Query<Session> sessions;

  public Session getSessionForSlot(Slot slot)
  {
    if(slot == null)
    {
      return null;
    }

    for (Session session : sessions.fetch())
    {
      if(slot.equals(session.slot))
      {
        return session;
      }
    }
    return null;
  }

  public String toString()
  {
    return name;
  }

  static Query<Track> all()
  {
    return SienaSupport.all(Track.class);
  }

  public static List<Track> findAll()
  {
    return all().fetch();
  }

  public static Track find(Long id)
  {
    return all().filter("id", id).get();
  }
}

