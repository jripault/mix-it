package models;

import siena.*;

import java.util.Date;
import java.util.List;

import models.crudsiena.SienaSupport;

public class Session extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Filter("session")
  public Query<SpeakerSession> sessionSpeakers;

  @Column("track")
  public Track track;

  @Column("slot")
  public Slot slot;

  @Column("name")
  public String name;

  @Column("description")
  public String description;

  @Column("room")
  public String room;

  @Column("type")
  public SessionType type;

  public String toString()
  {
    //TODO bad hack
    if (name == null)
    {
      Session temp = findById(this.id);
      return temp.name;
    }
    return name;
  }

  public List<Speaker> findSpeakersBySession()
  {
    List<Speaker> speakers = SpeakerSession.findBySession(this);
    return speakers;
  }

  public static Session findById(Long id)
  {
    return all().filter("id", id).get();
  }

  static Query<Session> all()
  {
    return SienaSupport.all(Session.class);
  }

  public static List<Session> findAll()
  {
    return all().fetch();
  }

  public static Session getSessionById(Long id)
  {
    return Session.all().filter("id", id).get();
  }
}
