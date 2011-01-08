package models;

import siena.*;

import java.util.Date;
import java.util.List;

import models.crudsiena.SienaSupport;

public class Session extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("speaker")
  public Speaker speaker;

  @Column("track")
  public Track track;

  @Column("slot")
  public Slot slot;

  @Column("name")
  public String name;

  @Column("description")
  public String description;

  @Column("type")
  public SessionType type;

  public String toString()
  {
    return name + " - " + speaker.toString();
  }

  static Query<Session> all()
  {
    return SienaSupport.all(Session.class);
  }

  public static List<Session> findAll()
  {
    return all().fetch();
  }
}
