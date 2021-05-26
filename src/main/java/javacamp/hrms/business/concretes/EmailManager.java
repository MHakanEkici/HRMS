package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmailService;
import javacamp.hrms.business.abstracts.VerificationCodeService;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;

@Service
public class EmailManager implements EmailService {
	
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public EmailManager(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public void sendEmail(String email, int userId) {
		String verificationCode = verificationCodeService.createCode(userId);
		System.out.println("Kod oluşturuldu, e-posta gönderildi."); 
		//TODO E-posta gönderme simule edildi. Ama kod üretildi ve veri tabanına kaydedildi.
		
	}

}
