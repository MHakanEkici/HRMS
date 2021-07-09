package javacamp.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import javacamp.hrms.entities.conretes.Candidate;
import javacamp.hrms.entities.conretes.ForeignLanguage;
import javacamp.hrms.entities.conretes.JobExperience;
import javacamp.hrms.entities.conretes.Picture;
import javacamp.hrms.entities.conretes.School;


public class CurriculumVitaeDto {
	
	private int userId;
	private List<JobExperience> jobExperiences;
	private List<ForeignLanguage> foreignLanguages;
	private List<School> schools;
	private List<Picture> pictures;
	private String githubAddress;
    private String linkedinAddress;
    private String knownTechnologies;
    private String coverLetter;
//    private Candidate candidate;
	
    public CurriculumVitaeDto() {
	
	}

	public CurriculumVitaeDto(int userId, List<School> schools, List<JobExperience> jobExperiences,
			List<ForeignLanguage> foreignLanguages, List<Picture> pictures, String githubAddress,
			String linkedinAddress, String knownTechnologies, String coverLetter 
//			Candidate candidate
			) {
		super();
		this.userId = userId;
		this.schools = schools;
		this.jobExperiences = jobExperiences;
		this.foreignLanguages = foreignLanguages;
		this.pictures = pictures;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.knownTechnologies = knownTechnologies;
		this.coverLetter = coverLetter;
//		this.candidate = candidate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public List<ForeignLanguage> getForeignLanguages() {
		return foreignLanguages;
	}

	public void setForeignLanguages(List<ForeignLanguage> foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
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

//	public Candidate getCandidate() {
//		return candidate;
//	}
//
//	public void setCandidate(Candidate candidate) {
//		this.candidate = candidate;
//	}

	

}
