package controllers;
import models.Attendee;
import play.mvc.With;

//@With(Secure.class)
@CRUD.For(Attendee.class)
public class AttendeesAdmin extends controllers.CRUD
{

}
