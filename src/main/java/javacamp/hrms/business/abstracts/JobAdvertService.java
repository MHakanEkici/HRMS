package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.JobAdvert;
import javacamp.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	public Result add(JobAdvert jobAdvert);
	
	public Result update(JobAdvert jobAdvert);
	
	public DataResult<List<City>> getAllCities();
	
	public DataResult<List<JobAdvertDto>> getAllSorted();
	
	public DataResult<JobAdvertDto> getByJobAdvertId(int jobAdvertId);
	
	Result setActiveJobAdvert(int jobAdvertId);
	
	public DataResult<List<JobAdvert>> getAllPassiveJobAdverts();
	
//	public void addCity();

}
