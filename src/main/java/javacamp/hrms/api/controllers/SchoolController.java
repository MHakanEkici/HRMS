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

import javacamp.hrms.business.abstracts.SchoolService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.entities.conretes.School;

@RestController 
@RequestMapping(path = "/api/schools", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class SchoolController {
	
	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody School school) {
		return ResponseEntity.ok(this.schoolService.add(school));
		}

	@GetMapping("/getAllSortedJobs")
	public DataResult<List<School>> getAllByCurriculumVitaeIdSorted(@RequestParam int curriculumVitaeId) {
		return schoolService.getAllByCurriculumVitaeIdSorted(curriculumVitaeId);
	}

}
