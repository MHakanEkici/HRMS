package javacamp.hrms.business.abstracts.validator_services;

import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Employer;

public interface EmployerValidatorService {
	
	boolean isValidUserInfo(Employer employer);
	boolean isValidEmailAdress(String eMail);
	boolean isValidDomainAdress(String webAdress, String eMail);
	boolean isUserExist(String eMail);
	boolean isConfirmed(Employer employer);
	Result canEmployerRegister(Employer employer);

}
