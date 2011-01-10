package models;

import siena.*;
import models.crudsiena.SienaSupport;

import java.util.List;

public class Speaker extends SienaSupport
{

  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("name")
  @NotNull
  public String name;

  @Column("bio")
  @NotNull
  public String bio;

  @Column("url_image")
  public String urlImage;

  public String toString()
  {
    return name;
  }

  static Query<Speaker> all()
  {
    return SienaSupport.all(Speaker.class);
  }

  public static List<Speaker> findAll()
  {
    return all().fetch();
  }
}
