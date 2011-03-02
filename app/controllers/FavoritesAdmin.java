package controllers;

import models.Favorite;
import models.TagSession;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Favorite.class)
public class FavoritesAdmin extends CRUD
{
}
