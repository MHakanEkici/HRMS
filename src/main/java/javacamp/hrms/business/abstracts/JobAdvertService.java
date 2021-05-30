package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.JobAdvert;

public interface JobAdvertService {
	public Result add(JobAdvert jobAdvert);
	
	public Result update(JobAdvert jobAdvert);

	public DataResult<List<JobAdvert>> getAllJobAdverts();
	
	public DataResult<List<City>> getAllCities();
	
	public DataResult<List<JobAdvert>> getAllSorted();

}
