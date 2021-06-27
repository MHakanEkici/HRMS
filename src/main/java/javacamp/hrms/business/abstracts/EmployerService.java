package javacamp.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.JobAdvert;

public interface EmployerService {
	
	public DataResult<List<Employer>> getAllEmployers();
	
	Result register(Employer employer);
	
	DataResult<Employer> logIn(Employer employer);
	
	public Result update(Employer employer);
	
	Result confirmEmployer(int userId);
	
	public DataResult<List<Employer>> getAllUnconfirmedEmployers ();

}
