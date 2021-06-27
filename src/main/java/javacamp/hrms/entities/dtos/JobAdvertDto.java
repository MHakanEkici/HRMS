package javacamp.hrms.entities.dtos;

import java.time.LocalDate;

import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.Job;


public class JobAdvertDto {

	private int jobAdvertId; 
	private String description;	
	private Employer employer; 
	private City city;
	private Job job;
	private String salary;
	private String openPositionCount;
	private LocalDate deadline;
	private LocalDate createTime;
	private boolean isActive;
	private String workStyle;
	private String workTime;

	public JobAdvertDto() {
		
	}

	public JobAdvertDto(int jobAdvertId, String description, Employer employer, City city, Job job, String salary,
			String openPositionCount, LocalDate deadline, LocalDate createTime, boolean isActive, String workStyle,
			String workTime) {
		super();
		this.jobAdvertId = jobAdvertId;
		this.description = description;
		this.employer = employer;
		this.city = city;
		this.job = job;
		this.salary = salary;
		this.openPositionCount = openPositionCount;
		this.deadline = deadline;
		this.createTime = createTime;
		this.isActive = isActive;
		this.workStyle = workStyle;
		this.workTime = workTime;
	}

	public int getJobAdvertId() {
		return jobAdvertId;
	}

	public void setJobAdvertId(int jobAdvertId) {
		this.jobAdvertId = jobAdvertId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getOpenPositionCount() {
		return openPositionCount;
	}

	public void setOpenPositionCount(String openPositionCount) {
		this.openPositionCount = openPositionCount;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getWorkStyle() {
		return workStyle;
	}

	public void setWorkStyle(String workStyle) {
		this.workStyle = workStyle;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
}
