package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.JobService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;

import javacamp.hrms.entities.conretes.Job;

@RestController 
@RequestMapping(path = "/api/jobs", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody  
public class JobController {

	private JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getAllJobs")
	public DataResult<List<Job>> getAllJobs() {
		return jobService.getAllJobs();
		
	}

	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return jobService.add(job);
		
	}
}
