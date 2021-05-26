package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.VerificationCodeService;
import javacamp.hrms.dataAccess.abstracts.JobDao;
import javacamp.hrms.dataAccess.abstracts.VerificationCodeDao;
import javacamp.hrms.entities.conretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public boolean isCodeVerified(int userId) {
		List<VerificationCode> verificationCodes = verificationCodeDao.findByUserId(userId);

		for (VerificationCode verificationCode : verificationCodes) {
			if (verificationCode.isVerified()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String createCode(int userId) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setUserId(userId);
		verificationCode.setCode(UUID.randomUUID().toString());
		verificationCode.setVerified(true); //TODO Email doğrulama simulasyonu
		verificationCodeDao.save(verificationCode);
		return verificationCode.getCode();
		
	}

}
