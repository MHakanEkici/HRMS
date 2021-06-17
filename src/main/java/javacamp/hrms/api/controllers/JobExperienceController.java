package javacamp.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.JobExperienceService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.entities.conretes.JobExperience;

@RestController 
@RequestMapping(path = "/api/jobExperiences", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class JobExperienceController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobExperience jobExperience) {
		return ResponseEntity.ok(this.jobExperienceService.add(jobExperience));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll() {
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getAllSortedJobExperiences")
	public DataResult<List<JobExperience>> getAllByCurriculumVitaeIdSorted(@RequestParam int curriculumVitaeId) {
		return jobExperienceService.getAllByCurriculumVitaeIdSorted(curriculumVitaeId);
	}
	
	

}
