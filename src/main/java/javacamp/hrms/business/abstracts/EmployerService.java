package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Employer;

public interface EmployerService {
	
	public DataResult<List<Employer>> getAllEmployers();
	
	Result register(Employer employer);
	Result logIn(Employer employer);

}
