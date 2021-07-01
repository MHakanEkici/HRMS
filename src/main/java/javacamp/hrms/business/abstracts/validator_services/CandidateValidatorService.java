package javacamp.hrms.business.abstracts.validator_services;

import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;

public interface CandidateValidatorService {

	Result validateCandidate(Candidate candidate);

	boolean isUserExist(Long identityNumber, String eMail);

	boolean isValidUserInfo(Candidate candidate);

	boolean isValidEmailAdress(String email);

	boolean isPasswordConfirmed(String password, String confirmPassword);

}
