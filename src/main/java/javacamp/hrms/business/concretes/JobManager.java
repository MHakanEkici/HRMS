package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobDao;
import javacamp.hrms.entities.conretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAllJobs() {
		return new SuccessDataResult(jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		if (jobDao.findByJobName(job.getJobName()).isPresent()) {
			return new ErrorResult("İşlem başarısız oldu. Zaten böyle bir iş pozisyonu bulunmakta.");
		}
		jobDao.save(job);
		return new SuccessResult();

	}

}
