package models;

import siena.*;
import models.crudsiena.SienaSupport;

import java.util.List;

public class Speaker extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("lastName")
  @NotNull
  public String lastName;

  @Column("firstName")
  @NotNull
  public String firstName;

  @Column("bio")
  @NotNull
  public String bio;

  @Column("url_image")
  public String urlImage;

  @Column("company")
  public String company;

  @Filter("speaker")
  public Query<SpeakerSession> speakerSessions;

  public String toString()
  {
    //TODO bad hack
    if(firstName == null)
    {
      Speaker temp = findById(this.id);
      return temp.firstName + " " + temp.lastName;
    }
    return firstName + " " + lastName;
  }

  public List<Session> findSessionsBySpeaker()
  {
    List<Session> sessions = SpeakerSession.findBySpeaker(this);
    return sessions;
  }

  static Query<Speaker> all()
  {
    return SienaSupport.all(Speaker.class);
  }

  public static List<Speaker> findAll()
  {
    return all().fetch();
  }

  public static Speaker findById(Long id)
  {
    return all().filter("id", id).get();
  }
}
