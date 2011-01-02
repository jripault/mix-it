package models;

import siena.*;
import models.crudsiena.SienaSupport;

public class Speaker extends SienaSupport
{

  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("name")
  @NotNull
  public String name;


  public String toString()
  {
    return name;
  }
}
