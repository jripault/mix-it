package models;

import models.crudsiena.SienaSupport;
import play.data.validation.MaxSize;
import siena.*;

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
  @MaxSize(2000)
  @NotNull
  public String bio;

  @Column("twitter")
  public String twitter;

  @Column("linkedin")
  public String linkedin;

  @Column("blog")
  public String blog;

  @Column("url_image")
  public String urlImage;

  @Column("company")
  public String company;

  @Filter("speaker")
  public Query<SpeakerSession> speakerSessions;

  public String getUrlImage()
  {
    if(urlImage == null || urlImage.length() == 0)
    {
      return "public/images/logo_speaker.png";
    }
    return urlImage;
  }

  public String toString()
  {
    //TODO bad hack
    if (firstName == null)
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
