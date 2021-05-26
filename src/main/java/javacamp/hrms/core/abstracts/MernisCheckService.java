package javacamp.hrms.core.abstracts;

import javacamp.hrms.entities.conretes.Candidate;

public interface MernisCheckService {
	
	boolean checkIfRealPerson(Candidate candidate);

}
