package controllers;

import models.Tag;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Tag.class)
public class TagsAdmin extends controllers.CRUD
{

}
