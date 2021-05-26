package javacamp.hrms.business.abstracts;

public interface VerificationCodeService {
	
	public boolean isCodeVerified(int userId);
	
	public String createCode(int userId);

}
