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
@Table(name = "schools")
public class School {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;
    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

	public School() {
		
	}

	public School(int id, String name, String department, LocalDate startDate, LocalDate graduationDate,
			CurriculumVitae curriculumVitae) {
		super();
		this.id = id;
		this.schoolName = name;
		this.department = department;
		this.startDate = startDate;
		this.graduationDate = graduationDate;
		this.curriculumVitae = curriculumVitae;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return schoolName;
	}

	public void setName(String name) {
		this.schoolName = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

}
