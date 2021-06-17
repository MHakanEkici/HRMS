package javacamp.hrms.api.controllers;

import java.util.List;

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

import javacamp.hrms.business.abstracts.CurriculumVitaeService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.CurriculumVitae;
import javacamp.hrms.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping(path = "/api/curriculumVitaes", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class CurriculumVitaeController {
	
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<CurriculumVitaeDto> getByUserId(@RequestParam int userId) { 
		return this.curriculumVitaeService.getByUserId(userId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitaeDto curriculumVitaeDto) {
		return curriculumVitaeService.add(curriculumVitaeDto);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CurriculumVitaeDto curriculumVitaeDto) {
		return curriculumVitaeService.update(curriculumVitaeDto);
	}

}
