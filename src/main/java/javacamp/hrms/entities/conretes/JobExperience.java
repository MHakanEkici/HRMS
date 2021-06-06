package javacamp.hrms.entities.conretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "job_experiences")
public class JobExperience {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int jobExperienceId;

    @Column(name = "workplace_name")
    private String workplaceName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_date")
    private LocalDate startDateOfWork;

    @Column(name = "finish_date") 
    private LocalDate finishDateOfWork;
    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

	public JobExperience() {
		
	}

	public JobExperience(int jobExperienceId, String workplaceName, String position, LocalDate startDate,
			LocalDate finishDate, CurriculumVitae curriculumVitae) {
		super();
		this.jobExperienceId = jobExperienceId;
		this.workplaceName = workplaceName;
		this.position = position;
		this.startDateOfWork = startDate;
		this.finishDateOfWork = finishDate;
		this.curriculumVitae = curriculumVitae;
	}

	public int getJobExperienceId() {
		return jobExperienceId;
	}

	public void setJobExperienceId(int jobExperienceId) {
		this.jobExperienceId = jobExperienceId;
	}

	public String getWorkplaceName() {
		return workplaceName;
	}

	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getStartDate() {
		return startDateOfWork;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDateOfWork = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDateOfWork;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDateOfWork = finishDate;
	}

	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

}
