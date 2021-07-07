package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javacamp.hrms.business.abstracts.VerificationCodeService;
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

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidatorService employerValidatorService;
	private EmailService emailService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidatorService employerValidatorService,
			EmailService emailService, VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.employerValidatorService = employerValidatorService;
		this.emailService = emailService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result register(Employer employer) {
		Result validationResult = employerValidatorService.validateEmployer(employer);
		if (validationResult.isSuccess()) {
			employer.setConfirmed(false);
			employer.setUserType("Employer");
			Employer newEmployer = employerDao.save(employer);

			emailService.sendEmail(newEmployer.getEmail(), newEmployer.getUserId());

			return new SuccessResult("Kayıt Başarılı. Lütfen e-posta adresinize gönderilen kodu doğrulayın");
		} else {
			return validationResult;
		}
	}
	
	@Override
	public Result update(Employer employer) {

		Optional<Employer> currentEmployer = employerDao.findById(employer.getUserId());
		if(!currentEmployer.isPresent()){
			return new ErrorResult("Hesap bulunamadı");
		}

		if(employer.getCompanyInformation() != null)
			currentEmployer.get().setCompanyInformation(employer.getCompanyInformation());
		if(employer.getWebAdress() != null)
			currentEmployer.get().setWebAdress(employer.getWebAdress());
		if(employer.getCompanyName() != null)
			currentEmployer.get().setCompanyName(employer.getCompanyName());
		if(employer.getPhoneNumber() != null)
			currentEmployer.get().setPhoneNumber(employer.getPhoneNumber());
		if(employer.getEmail() != null)
			currentEmployer.get().setEmail(employer.getEmail());
		if(employer.getPassword() != null)
			currentEmployer.get().setPassword(employer.getPassword());
		if(employer.getConfirmPassword() != null)
			currentEmployer.get().setConfirmPassword(employer.getConfirmPassword());

		Result validationResult = employerValidatorService.validateEmployer(currentEmployer.get());
		if (validationResult.isSuccess()) {
			employerDao.save(currentEmployer.get());
			return new SuccessResult("Hesap bilgileri güncellendi");
		} else{
			return validationResult;
		}

	}

	@Override
	public DataResult<Employer> logIn(Employer request) {
		Optional<Employer> employer = employerDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		if(employer.isPresent()){
			if(employer.get().isConfirmed()) {
				if(verificationCodeService.isCodeVerified(employer.get().getUserId())){
					return new SuccessDataResult<>(employer.get());
				} else{
					return new ErrorDataResult<>("E-posta adresinize gönderilen kod ile hesap doğrulanmadı");
				}

			} else{
				return new ErrorDataResult<>("Hesabınız henüz onaylanmadı");
			}
		} else{
			return new ErrorDataResult<>("Girdiğiniz bilgilere ait kullanıcı bulunamadı");
		}
	}

	@Override
	public DataResult<List<Employer>> getAllEmployers() {
		return new SuccessDataResult(employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> getAllUnconfirmedEmployers() {
		return new SuccessDataResult<>(employerDao.findByIsConfirmed(false));
	}

	@Override
	@Transactional
	public Result confirmEmployer(int userId) {
		int confirmedEmployer = employerDao.setEmployerConfirmed(userId);
		if(confirmedEmployer == 1) {
			return new SuccessResult("Hesap onaylandı");
		} else {
			return new ErrorResult("İşlem Başarısız");
		}
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult(employerDao.findById(id).get());
	}

}
