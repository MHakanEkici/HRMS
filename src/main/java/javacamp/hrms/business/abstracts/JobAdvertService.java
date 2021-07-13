package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.JobAdvert;
import javacamp.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {

	Result add(JobAdvert jobAdvert);
	
	Result update(JobAdvert jobAdvert);

	DataResult<JobAdvertDto> getByJobAdvertId(int jobAdvertId);
	
	DataResult<List<City>> getAllCities();
	
	DataResult<List<JobAdvertDto>> getAllSorted();

	DataResult<List<JobAdvert>> getAllPassiveJobAdverts();
	
	Result setActiveJobAdvert(int jobAdvertId);

}
