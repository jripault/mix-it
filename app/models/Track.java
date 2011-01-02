package models;

import siena.*;
import models.crudsiena.SienaSupport;

public class Track extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("name")
  @NotNull
  public String name;

  @Filter("track")
  public Query<Session> sessions;

  public String toString()
  {
    return name;
  }
}

