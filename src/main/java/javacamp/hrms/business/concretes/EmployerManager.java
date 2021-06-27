package javacamp.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmailService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.validator_services.EmployerValidatorService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorDataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.JobAdvert;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidatorService employerValidatorService;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidatorService employerValidatorService,
			EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.employerValidatorService = employerValidatorService;
		this.emailService = emailService;
	}

	@Override
	public Result register(Employer employer) {
		Result validationResult = employerValidatorService.canEmployerRegister(employer);
		if (validationResult.isSuccess()) {
			employer.setConfirmed(false);
			employer.setUserType("Employer");
			Employer newEmployer = employerDao.save(employer);
			emailService.sendEmail(newEmployer.getEmail(), newEmployer.getUserId());
			return new SuccessResult("Kayıt Başarılı. Lütfen e-posta adresinize gönderilen kodu doğrulayın.");
		} else {
			return validationResult;
		}

	}
	
	@Override
	public Result update(Employer employer) {
		Employer newEmployer = employerDao.findById(employer.getUserId()).get();
		newEmployer = employer;
		employerDao.save(newEmployer);
		return new SuccessResult();
	}

	@Override
	public DataResult<Employer> logIn(Employer newEmployer) {
		boolean isMatched = false;
		Employer matchedEmployer = new Employer();
		for (Employer employer : employerDao.findAll()) {
			if (newEmployer.getEmail().equals(employer.getEmail())
					&& newEmployer.getPassword().equals(employer.getPassword()) && employer.isConfirmed() == true) {
				isMatched = true;
				matchedEmployer = employer;
			}

		}
		if (isMatched == true) {
			return new SuccessDataResult<Employer>(matchedEmployer);
		} 
		else {
			return new ErrorDataResult<Employer>("Giriş Başarısız");
		}

	}

	@Override
	public DataResult<List<Employer>> getAllEmployers() {
		return new SuccessDataResult(employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> getAllUnconfirmedEmployers() {
		return new SuccessDataResult<List<Employer>>(employerDao.findByIsConfirmed(false));
	}

	@Override
	@Transactional
	public Result confirmEmployer(int userId) {
		int updatedEmployer = employerDao.setEmployerConfirmed(true, userId);
		if(updatedEmployer == 1) {
			return new SuccessResult("İşlem Başarılı");
		}
		else {
			return new ErrorResult("İşlem Başarısız");
		}
	}

}
