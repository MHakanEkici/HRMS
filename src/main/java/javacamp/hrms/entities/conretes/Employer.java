package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employers")
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_adress")
	private String webAdress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is confirmed")
	private boolean isConfirmed;
	
	public Employer() {
		
	}

	public Employer(String companyName, String webAdress, String phoneNumber, boolean isConfirmed) {
		super();
		this.companyName = companyName;
		this.webAdress = webAdress;
		this.phoneNumber = phoneNumber;
		this.isConfirmed = isConfirmed;
	}

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebAdress() {
		return webAdress;
	}

	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
}
