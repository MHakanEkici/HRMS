package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int jobId;
	
	@Column(name = "job_name")
	private String jobName;
	
	public Job() {
		
	}

	public Job(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
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

	public void setJobName(String job) {
		this.jobName = job;
	}

}
