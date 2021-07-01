package javacamp.hrms.business.abstracts;

import java.util.List;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.JobExperience;

public interface JobExperienceService {
	
	Result add(JobExperience jobExperience);
	
	Result addAll(List <JobExperience> jobExperiences);

	Result update(JobExperience jobExperience);

	Result delete(int id);
	
	DataResult<List<JobExperience>> getAll();
	
	DataResult <List<JobExperience>> getAllByCurriculumVitaeIdSorted(int curriculumVitaeId);

}
