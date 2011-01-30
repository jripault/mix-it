package controllers;

import models.SpeakerSession;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(SpeakerSession.class)
public class SpeakerSessionsAdmin extends CRUD
{

}
