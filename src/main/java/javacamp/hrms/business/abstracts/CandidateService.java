package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;


public interface CandidateService {
	
	public DataResult<List<Candidate>> getAllCandidates();
	
	public DataResult<Candidate> getById(int id);
	
	public Result register(Candidate candidate);
	
	public Result logIn(Candidate candidate);
	
	

}
