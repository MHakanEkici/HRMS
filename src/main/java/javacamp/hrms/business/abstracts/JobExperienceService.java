package javacamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.JobExperience;
import javacamp.hrms.entities.conretes.School;

public interface JobExperienceService {
	
	Result add(JobExperience jobExperience);
	
	Result addAll(List <JobExperience> jobExperiences);
	
	Result delete(int id); 
	
	Result update(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAll();
	
	DataResult <List<JobExperience>> getAllByCurriculumVitaeIdSorted(int curriculumVitaeId);

}
