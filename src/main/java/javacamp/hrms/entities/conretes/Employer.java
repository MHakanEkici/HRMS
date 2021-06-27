package javacamp.hrms.entities.conretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@Column(name = "web_adress")
	private String webAdress;
	
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotNull
	@Column(name = "company_information")
	private String companyInformation;
	
	@NotNull
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts; 
	
	public Employer() {
		
	}

	public Employer(String companyName, String webAdress, String phoneNumber, String companyInformation,
			boolean isConfirmed, List<JobAdvert> jobAdverts) {
		super();
		this.companyName = companyName;
		this.webAdress = webAdress;
		this.phoneNumber = phoneNumber;
		this.companyInformation = companyInformation;
		this.isConfirmed = isConfirmed;
		this.jobAdverts = jobAdverts;
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

	public String getCompanyInformation() {
		return companyInformation;
	}

	public void setCompanyInformation(String companyInformation) {
		this.companyInformation = companyInformation;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public List<JobAdvert> getJobAdverts() {
		return jobAdverts;
	}

	public void setJobAdverts(List<JobAdvert> jobAdverts) {
		this.jobAdverts = jobAdverts;
	}

	
}
