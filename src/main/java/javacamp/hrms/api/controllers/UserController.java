package javacamp.hrms.api.controllers;

import org.springframework.http.MediaType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Candidate;
import javacamp.hrms.entities.conretes.Employer;

@RestController
@RequestMapping(path = "/api/users", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
public class UserController {

	private CandidateService candidateService;
	private EmployerService employerService;

	@Autowired
	public UserController(CandidateService candidateService, EmployerService employerService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
	}

	@PostMapping("/register/candidate")
	public Result register(@RequestBody Candidate candidate) {
		return candidateService.register(candidate);
	}

	@PostMapping("/register/employer")
	public Result register(@RequestBody Employer employer) {
		return employerService.register(employer);
	}

	// TODO LogIn'ler yazılcak.

	@GetMapping("/getAllCandidates")
	public DataResult<List<Candidate>> getAllCandidates() {
		return candidateService.getAllCandidates();

	}

	@GetMapping("/getAllEmployers")
	public DataResult<List<Employer>> getAllEmployers() {
		return employerService.getAllEmployers();

	}

}
