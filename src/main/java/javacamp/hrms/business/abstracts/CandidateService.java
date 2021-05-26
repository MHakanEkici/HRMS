package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;


public interface CandidateService {
	public DataResult<List<Candidate>> getAllCandidates();
	
	Result register(Candidate candidate);
	Result logIn(Candidate candidate);
	
	

}
