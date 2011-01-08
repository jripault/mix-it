package controllers;

import models.SessionType;
import play.mvc.With;

//@With(Secure.class)
@CRUD.For(SessionType.class)
public class SessionTypesAdmin extends controllers.CRUD
{
}
