package controllers;

import models.Attendees;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Attendees.class)
public class AttendeesAdmin extends controllers.CRUD
{

}
