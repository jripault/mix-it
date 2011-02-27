package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.ArrayList;
import java.util.List;

public class TagSession extends SienaSupport
{

  @Id
  public Long id;

  @NotNull
  @Column("session _id")
  @Index("session_index")
  public Session session;

  @NotNull
  @Column("tag_id")
  @Index("tag_index")
  public Tag tag;

  public TagSession(Tag tag, Session session)
  {
    super();
    this.tag = tag;
    this.session = session;
  }

  public static Query<TagSession> all()
  {
    return Model.all(TagSession.class);
  }

  public static List<Session> findByTag(Tag tag)
  {
    List<TagSession> tagSessions = all().filter("tag", tag).fetch();
    List<Session> sessions = new ArrayList<Session>();
    for (TagSession tagSession : tagSessions)
    {
      sessions.add(Session.findById(tagSession.session.id));
    }
    return sessions;
  }

  public static List<Tag> findBySession(Session session)
  {
    List<TagSession> tagSessions = all().filter("session", session).fetch();
    List<Tag> tags = new ArrayList<Tag>();
    for (TagSession tagSession : tagSessions)
    {
      tags.add(Tag.findById(tagSession.tag.id));
    }

    return tags;
  }

  public String toString()
  {
    return tag.toString() + " : " + session.toString();
  }
}
