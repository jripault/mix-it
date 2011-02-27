package controllers;

import models.TagSession;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(TagSession.class)
public class TagSessionsAdmin extends CRUD
{

}
