package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmailService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.validator_services.EmployerValidatorService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.conretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmployerValidatorService employerValidatorService;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidatorService employerValidatorService, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.employerValidatorService = employerValidatorService;
		this.emailService = emailService;
	}

	@Override
	public Result register(Employer employer) {
		Result validationResult = employerValidatorService.canEmployerRegister(employer);
		if(validationResult.isSuccess()) {
			Employer newEmployer = employerDao.save(employer);
			emailService.sendEmail(newEmployer.getEmail(), newEmployer.getUserId());
			return new SuccessResult("Kayıt Başarılı. Lütfen e-posta adresinize gönderilen kodu doğrulayın.");
		}
		else {
			return validationResult;
		}
		
	}

	@Override
	public Result logIn(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Employer>> getAllEmployers() {
		return new SuccessDataResult(employerDao.findAll());
	}

}
