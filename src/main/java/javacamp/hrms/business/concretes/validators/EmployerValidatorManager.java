package javacamp.hrms.business.concretes.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.validator_services.EmployerValidatorService;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.conretes.Employer;

@Service
public class EmployerValidatorManager implements EmployerValidatorService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerValidatorManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result validateEmployer(Employer employer){
		if (isValidUserInfo(employer)) {
			if (isValidEmailAdress(employer.getEmail())) {
				if (isValidDomainAdress(employer.getWebAdress(), employer.getEmail())) {
					if (!isUserExist(employer.getEmail())) {
						if (isPasswordConfirmed(employer.getPassword(), employer.getConfirmPassword())) {
							return new SuccessResult();
						} else{
							return new ErrorResult("Belirlediğiniz şifre ile tekrar girdiğiniz şifre aynı değil");
						}
					} else {
						return new ErrorResult("Bu e-posta adresiyle kayıtlı bir kullanıcı bulunmaktadır");
					}
				} else {
					return new ErrorResult("Lütfen web sitesi ile aynı domaine sahip bir e-posta giriniz");
				}
			} else {
				return new ErrorResult("Lütfen geçerli bir e-posta adres giriniz");
			}
		} else {
			return new ErrorResult("Lütfen bütün bilgileri doğru şekilde giriniz");
		}
	}

	@Override
	public boolean isValidUserInfo(Employer employer) {
		if (employer.getCompanyName() == null || employer.getCompanyName().trim().isEmpty()) {
			return false;
		} else if (employer.getPhoneNumber() == null || employer.getPhoneNumber().trim().isEmpty()) {
			return false;
		} else if (employer.getWebAdress() == null || employer.getWebAdress().trim().isEmpty()) {
			return false;
		} else if (employer.getEmail() == null || employer.getEmail().trim().isEmpty()) {
			return false;
		} else if (employer.getPassword() == null || employer.getPassword().trim().length() < 6) {
			return false;
		} else if (employer.getConfirmPassword() == null || employer.getConfirmPassword().trim().isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isValidEmailAdress(String eMail) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMail);
		return matcher.matches();
	}

	@Override
	public boolean isValidDomainAdress(String webAdress, String eMail) {
		int index = eMail.indexOf("@");
		String eMailDomainAdress = eMail.substring(index + 1, eMail.length());
		int result = webAdress.indexOf(eMailDomainAdress);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
		// return result == -1 ? false : true; --> if/else kontrolünün kısa yoldan yazım şekli.
	}

	@Override
	public boolean isUserExist(String email) {
		if (employerDao.findByEmail(email).isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isPasswordConfirmed(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isConfirmed(Employer employer) {
		return employerDao.findByUserId(employer.getUserId()).get().isConfirmed();
	}

}
