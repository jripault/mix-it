package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.List;

/**
 * @version $Id$
 * @author: Julien RIPAULT
 */
public class Attendees extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("number")
  @NotNull
  public int number;

  static Query<Attendees> all()
  {
    return SienaSupport.all(Attendees.class);
  }

  public static Attendees findAll()
  {
    return all().get();
  }
}
