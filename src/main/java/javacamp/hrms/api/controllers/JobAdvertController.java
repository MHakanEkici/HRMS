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
import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.JobAdvert;

@RestController
@RequestMapping(path = "/api/jobAdvert", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@GetMapping("/getAllJobs")
	public DataResult<List<JobAdvert>> getAllJobs() {
		return jobAdvertService.getAllJobAdverts();
	}
	
	@GetMapping("/getAllSortedJobs")
	public DataResult<List<JobAdvert>> getAllSorted() {
		return jobAdvertService.getAllSorted();
	}
	
	@GetMapping("/getAllCities")
	public DataResult<List<City>> getAllCities() {
		return jobAdvertService.getAllCities();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.update(jobAdvert);
	}
}
