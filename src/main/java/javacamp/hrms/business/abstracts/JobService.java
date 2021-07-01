package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Job;

public interface JobService {

	Result add(Job job);

	DataResult<List<Job>> getAllJobs();

}
