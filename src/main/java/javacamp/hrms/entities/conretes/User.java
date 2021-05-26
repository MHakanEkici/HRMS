package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "confirm_password")
	private String confirmPassword;
	
	@Column(name = "user_type")
	private String userType;
	
	public User() {
		
	}

	public User(int userId, String email, String password, String confirmPassword, String userType) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}



}
