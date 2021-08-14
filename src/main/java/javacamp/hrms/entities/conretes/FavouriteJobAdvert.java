package javacamp.hrms.entities.conretes;

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
@Table(name = "favourite_job_adverts")
public class FavouriteJobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name = "job_advert_id")
    private JobAdvert jobAdvert;
    
    
    public FavouriteJobAdvert() {
    	
    }


	public FavouriteJobAdvert(int id, Candidate candidate, JobAdvert jobAdvert) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.jobAdvert = jobAdvert;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}


	public JobAdvert getJobAdvert() {
		return jobAdvert;
	}


	public void setJobAdvert(JobAdvert jobAdvert) {
		this.jobAdvert = jobAdvert;
	}

}