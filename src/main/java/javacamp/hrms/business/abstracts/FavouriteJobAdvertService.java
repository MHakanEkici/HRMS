package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.FavouriteJobAdvert;

public interface FavouriteJobAdvertService {
	public DataResult<List<FavouriteJobAdvert>> getByUserId(int userId);

	public Result addFavouriteJobAdvert(int userId, int jobAdvertId);

	public Result removeFavouriteJobAdvert(int favouriteJobAdvertId);

}
