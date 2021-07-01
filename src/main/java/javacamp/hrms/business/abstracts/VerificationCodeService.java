package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.Result;

public interface VerificationCodeService {

	String createCode(int userId);

	boolean isCodeVerified(int userId);

	Result confirmCode(String code);

}
