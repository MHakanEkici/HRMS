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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.ForeignLanguageService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.entities.conretes.ForeignLanguage;

@RestController 
@RequestMapping(path = "/api/foreignLanguages", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class ForeignLanguageController {
	
private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage) {
		return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguage>> getAll() {
		return this.foreignLanguageService.getAll();
	}
	
}
