package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmailService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.validator_services.CandidateValidatorService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.conretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private CandidateValidatorService candidateValidatorService;
	private EmailService emailService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateValidatorService candidateValidatorService, EmailService emailService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateValidatorService = candidateValidatorService;
		this.emailService = emailService;
	}

	@Override
	public Result register(Candidate candidate) {
		Result validationResult = candidateValidatorService.canCandidateRegister(candidate);
		if(validationResult.isSuccess()) {
			Candidate newCandidate = candidateDao.save(candidate);
			emailService.sendEmail(newCandidate.getEmail(), newCandidate.getUserId());
			return new SuccessResult("Kayıt Başarılı. Lütfen e-posta adresinize gönderilen kodu doğrulayın.");
		}
		else {
			return validationResult;
		}
		
	}

	@Override
	public Result logIn(Candidate candidate) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Candidate>> getAllCandidates() {
		return new SuccessDataResult(candidateDao.findAll());
	}

}
