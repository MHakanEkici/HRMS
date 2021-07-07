package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import javacamp.hrms.business.abstracts.VerificationCodeService;
import javacamp.hrms.core.utilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.EmailService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.validator_services.CandidateValidatorService;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.conretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateValidatorService candidateValidatorService;
	private EmailService emailService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateValidatorService candidateValidatorService,
			EmailService emailService, VerificationCodeService verificationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateValidatorService = candidateValidatorService;
		this.emailService = emailService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result register(Candidate candidate) {
		Result validationResult = candidateValidatorService.validateCandidate(candidate);
		if (validationResult.isSuccess()) {
			candidate.setUserType("Candidate");
			Candidate newCandidate = candidateDao.save(candidate);
			emailService.sendEmail(newCandidate.getEmail(), newCandidate.getUserId());
			return new SuccessResult("Kayıt Başarılı. Lütfen e-posta adresinize gönderilen kodu doğrulayın");
		} else {
			return validationResult;
		}
	}

	@Override
	public Result update(Candidate candidate) {

		Optional<Candidate> currentCandidate = candidateDao.findById(candidate.getUserId());
		if(!currentCandidate.isPresent()){
			return new ErrorResult("Kullanıcı bulunamadı");
		}

		if(candidate.getBirthDate() != null)
			currentCandidate.get().setBirthDate(candidate.getBirthDate());
		if(candidate.getFirstName() != null)
			currentCandidate.get().setFirstName(candidate.getFirstName());
		if(candidate.getLastName() != null)
			currentCandidate.get().setLastName(candidate.getLastName());
		if(candidate.getEmail() != null) {
			if (candidateValidatorService.isValidEmailAdress(candidate.getEmail())) {
				currentCandidate.get().setEmail(candidate.getEmail());
			} else {
				return new ErrorResult("Lütfen geçerli bir e-posta adres giriniz");
			}
		}
		if(candidate.getPassword() != null)
			currentCandidate.get().setPassword(candidate.getPassword());
		if(candidate.getConfirmPassword() != null)
			currentCandidate.get().setConfirmPassword(candidate.getConfirmPassword());

		Result validationResult = candidateValidatorService.validateCandidate(currentCandidate.get());
		if (validationResult.isSuccess()) {
			candidateDao.save(currentCandidate.get());
			return new SuccessResult("Kullanıcı bilgileri güncellendi");
		} else {
			return validationResult;
		}

	}

	@Override
	public DataResult<Candidate> logIn(Candidate request) {
		Optional<Candidate> candidate = candidateDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		if(candidate.isPresent()){
			if(verificationCodeService.isCodeVerified(candidate.get().getUserId())) {
				return new SuccessDataResult<>(candidate.get());
			} else{
				return new ErrorDataResult<>("E-posta adresinize gönderilen kod ile hesap doğrulanmadı");
			}
		} else{
			return new ErrorDataResult<>("Girdiğiniz bilgilere ait kullanıcı bulunamadı");
		}
	}

	@Override
	public DataResult<List<Candidate>> getAllCandidates() {
		return new SuccessDataResult(candidateDao.findAll());
	}

	
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult(candidateDao.findById(id).get());
	}

}
