package javacamp.hrms.entities.conretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int jobId;
	
	@NotNull
	@Column(name = "job_name")
	private String jobName;
	
	@OneToMany(mappedBy = "job")
	private List<JobAdvert> jobAdverts;
	
	public Job() {
		
	}

	public Job(int jobId, String jobName, List<JobAdvert> jobAdverts) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobAdverts = jobAdverts;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<JobAdvert> getJobAdverts() {
		return jobAdverts;
	}

	public void setJobAdverts(List<JobAdvert> jobAdverts) {
		this.jobAdverts = jobAdverts;
	}

}
