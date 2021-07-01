package javacamp.hrms.business.abstracts.validator_services;

import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Employer;

public interface EmployerValidatorService {

	Result validateEmployer(Employer employer);

	boolean isValidUserInfo(Employer employer);

	boolean isValidEmailAdress(String eMail);

	boolean isValidDomainAdress(String webAdress, String eMail);

	boolean isUserExist(String eMail);

	boolean isPasswordConfirmed(String password, String confirmPassword);

	boolean isConfirmed(Employer employer);

}
