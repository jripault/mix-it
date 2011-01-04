package models;

import siena.*;

import java.util.Date;
import java.util.List;
import models.crudsiena.SienaSupport;

public class Session extends SienaSupport {

    @Id(Generator.AUTO_INCREMENT)
    public Long id;

    @Column("speaker")
    public Speaker speaker;

    @Column("track")
    public Track track;

    @Column("start_time")
    @DateTime
    public Date startTime;

    @Column("end_time")
    @DateTime
    public Date endTime;

    @Column("name")
    public String name;

    @Column("description")
    public String description;

    public String toString() {
        return name + " - " + speaker.toString();
    }

    static Query<Session> all() {
        return SienaSupport.all(Session.class);
    }

    public static List<Session> findAll() {
        return all().fetch();
    }
}
