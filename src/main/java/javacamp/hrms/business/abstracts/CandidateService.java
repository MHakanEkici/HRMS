package javacamp.hrms.business.abstracts;

import java.util.List;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;

public interface CandidateService {

	Result register(Candidate candidate);

	Result update(Candidate candidate);

	DataResult<Candidate> logIn(Candidate candidate);
	
	DataResult<List<Candidate>> getAllCandidates();
	
	DataResult<Candidate> getById(int id);

}
