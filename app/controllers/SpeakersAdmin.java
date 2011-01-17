package controllers;

import models.Speaker;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Speaker.class)
public class SpeakersAdmin extends controllers.CRUD
{

}
