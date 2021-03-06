package javacamp.hrms.entities.conretes;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "job_adverts")
public class JobAdvert {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int jobAdvertId; 
	
	@NotNull
	@Column(name = "description")
	private String description;
	
//	@NotNull
//	@Column(name = "employer_id")
//	private int employerId;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer; 
	
//	@NotNull
//	@Column(name = "city_id")
//	private int cityId;
	
	@ManyToOne
	@JoinColumn(name = "city_id") 
	private City city;
	
//	@NotNull
//	@Column(name = "job_id")
//	private int jobId;
	
	@NotNull
	@Column(name = "salary")
	private String salary;
	
	@NotNull
	@Column(name = "open_position_count")
	private String openPositionCount;
	
	@NotNull
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@NotNull
	@Column(name = "create_time")
	private OffsetDateTime createTime;
	
	@NotNull
	@Column(name = "work_style")
	private String workStyle;
	
	@NotNull
	@Column(name = "work_time")
	private String workTime;
	
	@NotNull
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "job_id") 
	private Job job;
	
//	@OneToMany(mappedBy = "jobAdvert")
//    @JsonIgnore 
//    private List<FavouriteJobAdvert> favouriteJobAdverts;
	

	public JobAdvert() {
		
	}


	public JobAdvert(int jobAdvertId, String description, Employer employer, City city, String salary,
			String openPositionCount, LocalDate deadline, OffsetDateTime createTime, String workStyle, String workTime,
			boolean isActive, Job job//, List<FavouriteJobAdvert> favouriteJobAdverts
			) {
		super();
		this.jobAdvertId = jobAdvertId;
		this.description = description;
		this.employer = employer;
		this.city = city;
		this.salary = salary;
		this.openPositionCount = openPositionCount;
		this.deadline = deadline;
		this.createTime = createTime;
		this.workStyle = workStyle;
		this.workTime = workTime;
		this.isActive = isActive;
		this.job = job;
//		this.favouriteJobAdverts = favouriteJobAdverts;
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


	public OffsetDateTime getCreateTime() {
		return createTime;
	}


	public void setCreateTime(OffsetDateTime createTime) {
		this.createTime = createTime;
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


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


//	public List<FavouriteJobAdvert> getFavoriteJobAdverts() {
//		return favouriteJobAdverts;
//	}
//
//
//	public void setFavoriteJobAdverts(List<FavouriteJobAdvert> favoriteJobAdverts) {
//		this.favouriteJobAdverts = favoriteJobAdverts;
//	}

	
	
}
