package controllers;

import models.Track;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Track.class)
public class TracksAdmin extends controllers.CRUD
{

}
