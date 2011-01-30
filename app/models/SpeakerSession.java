package models;

import models.crudsiena.SienaSupport;
import siena.*;

import java.util.ArrayList;
import java.util.List;

public class SpeakerSession extends SienaSupport
{
     @Id
    public Long id;

    @NotNull
    @Column("session _id")
    @Index("session_index")
    public Session session;

    @NotNull
    @Column("speaker_id")
    @Index("speaker_index")
    public Speaker speaker;

    public SpeakerSession(Speaker speaker, Session session) {
        super();
        this.speaker = speaker;
        this.session = session;
    }

    public static Query<SpeakerSession> all() {
        return Model.all(SpeakerSession.class);
    }

    public static List<Session> findBySpeaker(Speaker speaker) {
        List<SpeakerSession> speakerSessions =  all().filter("speaker", speaker).fetch();
        List<Session> sessions = new ArrayList<Session>();
        for(SpeakerSession speakerSession : speakerSessions) {
            sessions.add(Session.findById(speakerSession.session.id));
        }

        return sessions;
    }
    public static List<Speaker> findBySession(Session session) {
        List<SpeakerSession> speakerSessions =  all().filter("session", session).fetch();
        List<Speaker> speakers = new ArrayList<Speaker>();
        for(SpeakerSession speakerSession : speakerSessions) {
            speakers.add(Speaker.findById(speakerSession.speaker.id));
        }

        return speakers;
    }

    public String toString() {
        return speaker.toString() + " : " + session.toString();
    }

    public static void deleteBySpeaker(Speaker speaker) {

        List<SpeakerSession> speakerSessions = all().filter("speaker", speaker).fetch();
        if(null != speakerSessions) {
            for(SpeakerSession speakerSession : speakerSessions) {
                    speakerSession.delete();
            }
        }
    }
}
