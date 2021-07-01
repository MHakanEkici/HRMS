package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.UUID;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.VerificationCodeService;
import javacamp.hrms.dataAccess.abstracts.VerificationCodeDao;
import javacamp.hrms.entities.conretes.VerificationCode;
import javax.transaction.Transactional;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public String createCode(int userId) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setUserId(userId);
		verificationCode.setCode(UUID.randomUUID().toString());
		verificationCode.setVerified(false);

		verificationCodeDao.save(verificationCode);

		return verificationCode.getCode();
	}

	@Override
	@Transactional
	public Result confirmCode(String code) {
		int confirmedCode = verificationCodeDao.confirmCode(code);
		if(confirmedCode == 1) {
			return new SuccessResult("Kod onaylandı");
		} else {
			return new ErrorResult("İşlem Başarısız");
		}
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

}
