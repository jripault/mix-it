package models;

import models.crudsiena.SienaSupport;
import play.data.validation.MaxSize;
import siena.*;

import java.util.List;

public class Session extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Filter("session")
  public Query<SpeakerSession> sessionSpeakers;

  @Filter("session")
  public Query<TagSession> tagSessions;

  @Column("track")
  public Track track;

  @Column("slot")
  public Slot slot;

  @Column("name")
  public String name;

  @Column("description")
  @MaxSize(2000)
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

  public List<Tag> findTagsBySession()
  {
    List<Tag> tags = TagSession.findBySession(this);
    return tags;
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

  public static String getColor(Long id)
  {
    Session session = all().filter("id", id).get();
    if (session.track != null)
    {
      Track track = Track.find(session.track.id);
      return track.color;
    }
    return "#FFF";
  }
}
