package javacamp.hrms.business.abstracts;

import java.util.List;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAllEmployers();
	
	Result register(Employer employer);
	
	DataResult<Employer> logIn(Employer employer);
	
	Result update(Employer employer);
	
	Result confirmEmployer(int userId);
	
	DataResult<List<Employer>> getAllUnconfirmedEmployers ();

}
