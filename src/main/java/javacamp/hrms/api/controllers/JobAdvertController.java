package javacamp.hrms.api.controllers;

import java.util.List;

import javacamp.hrms.core.utilities.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.conretes.JobAdvert;
import javacamp.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping(path = "/api/jobAdverts", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAllSortedJobAdverts")
	public DataResult<List<JobAdvertDto>> getAllSorted() {
		return jobAdvertService.getAllSorted();
	}
	
	@GetMapping("/getJobAdvertById")
	public DataResult<JobAdvertDto> getByJobAdvertId(@RequestParam int jobAdvertId) {
		return jobAdvertService.getByJobAdvertId(jobAdvertId);
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
	
	@GetMapping("/getAllPassiveJobAdverts")
	public DataResult<List<JobAdvert>> getAllPassiveJobAdverts() {
		return jobAdvertService.getAllPassiveJobAdverts();
	}
	
	@GetMapping("/setActiveJobAdvert")
	public Result setActiveJobAdvert (@RequestParam int jobAdvertId ) {
		return jobAdvertService.setActiveJobAdvert(jobAdvertId);
	}

}
