package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	JobAdvert getByJobAdvertId(int jobAdvertId);
	
	List<JobAdvert> getAllByIsActiveTrue();
	
	List<JobAdvert> getAllByIsActiveTrue(Sort sort);

    List<JobAdvert> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
    
    List<JobAdvert> findByIsActiveTrueAndJob_JobName(String jobName);
    
    List<JobAdvert> findByIsActiveTrueAndCity_CityName(String cityName);
    
    List<JobAdvert> findByIsActive(boolean isActive);
    
    @Query(value= "select * from job_adverts "
    		+ "where employer_id = (select user_id from employers where company_name = :companyName) "
    		+ "and job_id = (select id from jobs where job_name = :jobName)", 
    		  nativeQuery = true)
    List<JobAdvert> findByCompanyNameAndJob(@Param("companyName") String companyName, @Param("jobName") String jobName);
    
    @Modifying
	@Query(value= "update job_adverts  set is_active = :active where id = :jobAdvertId", nativeQuery = true)
	int setJobAdvertActive(@Param("active") boolean active, @Param("jobAdvertId") int jobAdvertId);
    
}
