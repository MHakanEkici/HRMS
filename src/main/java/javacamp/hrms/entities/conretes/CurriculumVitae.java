package javacamp.hrms.entities.conretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int curriculumVitaeId;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "known_tecnologies")
    private String knownTechnologies;

    @Column(name = "cover_letter")
    private String coverLetter;
    
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<JobExperience> jobExperiences;
    
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<School> schools;
    
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore 
    private List<ForeignLanguage> foreignLanguages;
    
    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

	public CurriculumVitae() {
	
	}

	public CurriculumVitae(int curriculumVitaeId, String githubAddress, String linkedinAddress,
			String knownTechnologies, String coverLetter, List<JobExperience> jobExperiences, List<School> schools,
			List<ForeignLanguage> foreignLanguages, Candidate candidate) {
		super();
		this.curriculumVitaeId = curriculumVitaeId;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.knownTechnologies = knownTechnologies;
		this.coverLetter = coverLetter;
		this.jobExperiences = jobExperiences;
		this.schools = schools;
		this.foreignLanguages = foreignLanguages;
		this.candidate = candidate;
	}

	public int getCurriculumVitaeId() {
		return curriculumVitaeId;
	}

	public void setCurriculumVitaeId(int curriculumVitaeId) {
		this.curriculumVitaeId = curriculumVitaeId;
	}

	public String getGithubAddress() {
		return githubAddress;
	}

	public void setGithubAddress(String githubAddress) {
		this.githubAddress = githubAddress;
	}

	public String getLinkedinAddress() {
		return linkedinAddress;
	}

	public void setLinkedinAddress(String linkedinAddress) {
		this.linkedinAddress = linkedinAddress;
	}

	public String getKnownTechnologies() {
		return knownTechnologies;
	}

	public void setKnownTechnologies(String knownTechnologies) {
		this.knownTechnologies = knownTechnologies;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<ForeignLanguage> getForeignLanguages() {
		return foreignLanguages;
	}

	public void setForeignLanguages(List<ForeignLanguage> foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
    
}
