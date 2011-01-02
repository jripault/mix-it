package models;

import siena.*;

import java.util.Date;
import models.crudsiena.SienaSupport;

public class Session extends SienaSupport
{

  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("speaker")
  public Speaker speaker;

  @Column("track")
  public Track track;

  @Column("time")
  @DateTime
  public Date hour;

  @Column("name")
  public String name;

  @Column("description")
  public String description;

  public String toString()
  {
    return name + " - " + speaker.toString() + " - " + hour;
  }
}
