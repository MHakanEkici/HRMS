package javacamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobExperienceService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobExperienceDao;
import javacamp.hrms.entities.conretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAllByCurriculumVitaeIdSorted(int curriculumVitaeId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"startDateOfWork");
		return new SuccessDataResult<>(this.jobExperienceDao.getAllByCurriculumVitae_CurriculumVitaeId(curriculumVitaeId, sort));
	}

	@Override
	public Result add(JobExperience jobExperience) {
		if (jobExperience.getFinishDate() == null) {
			jobExperience.setFinishDate(LocalDate.parse("Devam ediyor"));
		}
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult();
	}
	
	@Override
	public Result addAll(List<JobExperience> jobExperiences) {
		for(JobExperience jobExperience:jobExperiences) {
			if (jobExperience.getFinishDate() == null) {
				jobExperience.setFinishDate(LocalDate.parse("Devam ediyor"));
			}
		}
		
		this.jobExperienceDao.saveAll(jobExperiences);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public Result update(JobExperience jobExperience) {
		//TODO yazılacak
		JobExperience newJobExperience = jobExperienceDao.findById(jobExperience.getJobExperienceId()).get();
		newJobExperience = jobExperience;
		jobExperienceDao.save(newJobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<>(this.jobExperienceDao.findAll());
	}

}
