package javacamp.hrms.entities.conretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class City {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int cityId; 
		
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobAdverts;
	
	public City() {
		
	}

	public City(int cityId, String cityName, List<JobAdvert> jobAdverts) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.jobAdverts = jobAdverts;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<JobAdvert> getJobAdverts() {
		return jobAdverts;
	}

	public void setJobAdverts(List<JobAdvert> jobAdverts) {
		this.jobAdverts = jobAdverts;
	}

}
