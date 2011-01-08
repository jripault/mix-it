package controllers;

import models.Session;
import play.mvc.With;

//@With(Secure.class)
@CRUD.For(Session.class)
public class SessionsAdmin extends controllers.CRUD
{

}
