package javacamp.hrms.entities.conretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "candidates")
//@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User{
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Column(name = "identity_number")
	private Long identityNumber;
	
	@NotNull
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	public Candidate() {
		
	}


	public Candidate(String firstName, String lastName, Long identityNumber, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDate = birthDate;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
