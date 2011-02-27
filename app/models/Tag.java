package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.List;

public class Tag extends SienaSupport
{
  @Id(Generator.AUTO_INCREMENT)
  public Long id;

  @Column("name")
  public String name;

  @Filter("session")
  public Query<TagSession> tagSessions;

  public List<Session> findSessionsByTag()
  {
    List<Session> sessions = TagSession.findByTag(this);
    return sessions;
  }

  public static Tag findById(Long id)
  {
    return all().filter("id", id).get();
  }

  static Query<Tag> all()
  {
    return SienaSupport.all(Tag.class);
  }

  public static List<Tag> findAll()
  {
    return all().fetch();
  }

  @Override
  public String toString()
  {
    return name;
  }
}
