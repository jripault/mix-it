package models;

import models.crudsiena.SienaSupport;
import siena.Column;
import siena.Generator;
import siena.Id;

public class SessionType extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  // duration in minutes
  @Column("length")
  public int length;

  @Column("name")
  public String name;
}
