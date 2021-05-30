package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int codeId;
	
	@NotNull
	@Column(name = "code")
	private String code;
	
	@NotNull
	@Column(name = "user_id")
	private int userId;
	
	@NotNull 
	@Column(name = "is_verified")
	private boolean isVerified;
	
	public VerificationCode() {
		
	}

	public VerificationCode(int codeId, String code, int userId, boolean isVerified) {
		super();
		this.codeId = codeId;
		this.code = code;
		this.userId = userId;
		this.isVerified = isVerified;
	}

	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

}
