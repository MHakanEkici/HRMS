package javacamp.hrms.api.controllers;

import org.springframework.http.MediaType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AdminService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Admin;
import javacamp.hrms.entities.conretes.Candidate;
import javacamp.hrms.entities.conretes.Employer;
import javacamp.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping(path = "/api/users", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class UserController {

	private CandidateService candidateService;
	private EmployerService employerService;
	private AdminService adminService;

	@Autowired
	public UserController(CandidateService candidateService, EmployerService employerService, AdminService adminService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.adminService = adminService;
	}

	@PostMapping("/register/candidate")
	public Result register(@RequestBody Candidate candidate) {
		return candidateService.register(candidate);
	}

	@PostMapping("/register/employer")
	public Result register(@RequestBody Employer employer) {
		return employerService.register(employer);
	}

	@PostMapping("/logIn/candidate")
	public Result logIn(@RequestBody Candidate candidate) {
		return candidateService.logIn(candidate);
	}

	@PostMapping("/logIn/employer")
	public Result logIn(@RequestBody Employer employer) {
		return employerService.logIn(employer);
	}
	
	@PostMapping("/logIn/admin")
	public Result logIn(@RequestBody Admin admin) {
		return adminService.logIn(admin);
	}

	@GetMapping("/getAllCandidates")
	public DataResult<List<Candidate>> getAllCandidates() {
		return candidateService.getAllCandidates();

	}

	@GetMapping("/getAllEmployers")
	public DataResult<List<Employer>> getAllEmployers() {
		return employerService.getAllEmployers();

	}
	
	@GetMapping("/getAllUnconfirmedEmployers")
	public DataResult<List<Employer>> getAllUnconfirmedEmployers() {
		return employerService.getAllUnconfirmedEmployers();

	}
	
	@GetMapping("/confirmEmployer")
	public Result confirmEmployer (@RequestParam int userId ) {
		return employerService.confirmEmployer(userId);
	}

}
