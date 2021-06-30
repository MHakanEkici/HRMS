package javacamp.hrms.business.concretes.validators;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.validator_services.CandidateValidatorService;
import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.conretes.Candidate;

@Service
public class CandidateValidatorManager implements CandidateValidatorService {

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;

	@Autowired
	public CandidateValidatorManager(CandidateDao candidateDao, MernisCheckService mernisCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public boolean isValidUserInfo(Candidate candidate) {

		if (candidate.getFirstName() == null || candidate.getFirstName().trim().length() < 2) {
			return false;
		} else if (candidate.getLastName() == null || candidate.getLastName().trim().length() < 2) {
			return false;
		} else if (candidate.getIdentityNumber() == null || candidate.getIdentityNumber().toString().length() != 11) {
			return false;
		} else if (candidate.getBirthDate() == null || candidate.getBirthDate().isBefore(LocalDate.of(1920, 1, 1))) {
			return false;
		} else if (candidate.getPassword() == null || candidate.getPassword().trim().length() < 6) {
			return false;
		} else if (candidate.getConfirmPassword() == null || candidate.getConfirmPassword().trim().isEmpty()) {
			return false;
		} else if (candidate.getEmail() == null || candidate.getEmail().trim().isEmpty()) {
			return false;
		}

		if (!candidate.getPassword().equals(candidate.getConfirmPassword())) {
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
	public boolean isUserExist(Long identityNumber, String eMail) {
		if (candidateDao.findByIdentityNumberOrEmail(identityNumber, eMail).isPresent()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Result canCandidateRegister(Candidate candidate) {

		if (isValidUserInfo(candidate)) {
			if (isValidEmailAdress(candidate.getEmail())) {
				if (isUserExist(candidate.getIdentityNumber(), candidate.getEmail())) {
					if (mernisCheckService.checkIfRealPerson(candidate)) {
						return new SuccessResult();
					} else {
						return new ErrorResult("Mernis doğrulaması başarısız oldu.");
					}
				} else {
					return new ErrorResult("Bu TC kimlik No veya e-posta adresi ile kayıtlı bir kullanıcı bulunmaktadır.");
				}
			} else {
				return new ErrorResult("Lütfen geçerli bir e-posta adres giriniz.");
			}
		} else {
			return new ErrorResult("Lütfen bütün bilgileri doğru şekilde giriniz.");
		}

	}

}
