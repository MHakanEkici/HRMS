package javacamp.hrms.business.abstracts.validator_services;

import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;

public interface CandidateValidatorService {
	
	boolean isValidUserInfo(Candidate candidate);
	boolean isValidEmailAdress(String eMail);
	boolean isUserExist(Long identityNumber, String eMail);
	Result canCandidateRegister(Candidate candidate);
	

}
