package models;

import siena.*;

import models.crudsiena.SienaSupport;

public class Attendee extends SienaSupport
{

  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("name")
  @Max(200)
  @NotNull
  public String name;

  @Column("paid")
  public boolean paid;

  @Column("job")
  @Max(200)
  public String job;

  public String toString()
  {
    return name;
  }
}
