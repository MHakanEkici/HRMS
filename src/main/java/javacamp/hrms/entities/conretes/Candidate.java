package javacamp.hrms.entities.conretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
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
	
	@OneToOne(mappedBy = "candidate")
	@JsonIgnore
	private CurriculumVitae curriculumVitae;
	
//	@OneToMany(mappedBy = "candidate")
//    @JsonIgnore 
//    private List<FavouriteJobAdvert> favoriteJobAdverts;
	
	public Candidate() {
		
	}

	public Candidate(String firstName, String lastName, Long identityNumber, LocalDate birthDate,
			CurriculumVitae curriculumVitae//, List<FavouriteJobAdvert> favoriteJobAdverts
			) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDate = birthDate;
		this.curriculumVitae = curriculumVitae;
//		this.favoriteJobAdverts = favoriteJobAdverts;
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

	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

//	public List<FavouriteJobAdvert> getFavoriteJobAdverts() {
//		return favoriteJobAdverts;
//	}
//
//	public void setFavoriteJobAdverts(List<FavouriteJobAdvert> favoriteJobAdverts) {
//		this.favoriteJobAdverts = favoriteJobAdverts;
//	}


}
