package javacamp.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.CurriculumVitaeService;
import javacamp.hrms.business.abstracts.ForeignLanguageService;
import javacamp.hrms.business.abstracts.JobExperienceService;
import javacamp.hrms.business.abstracts.PictureService;
import javacamp.hrms.business.abstracts.SchoolService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorDataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javacamp.hrms.entities.conretes.Candidate;
import javacamp.hrms.entities.conretes.CurriculumVitae;
import javacamp.hrms.entities.conretes.ForeignLanguage;
import javacamp.hrms.entities.conretes.JobExperience;
import javacamp.hrms.entities.conretes.Picture;
import javacamp.hrms.entities.conretes.School;
import javacamp.hrms.entities.dtos.CurriculumVitaeDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	
	private CurriculumVitaeDao curriculumVitaeDao;
	private CandidateService candidateService;
	private JobExperienceService jobExperienceService;
	private SchoolService schoolService;
	private ForeignLanguageService foreignLanguageService;
	private PictureService pictureService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CandidateService candidateService,
								  JobExperienceService jobExperienceService, SchoolService schoolService,
								  ForeignLanguageService foreignLanguageService, PictureService pictureService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;	
		this.candidateService = candidateService;
		this.jobExperienceService = jobExperienceService;
		this.schoolService = schoolService;
		this.foreignLanguageService = foreignLanguageService;
		this.pictureService = pictureService;
	}

	@Override
	public DataResult<CurriculumVitaeDto> getByUserId(int userId) {
		CurriculumVitae cv = curriculumVitaeDao.getByCandidate_UserId(userId);
		if(cv == null) {
			return new ErrorDataResult("İşlem başarısız, cv bulunamadı");
		}
		
		CurriculumVitaeDto cvDto = new CurriculumVitaeDto();
		
		cvDto.setCoverLetter(cv.getCoverLetter());
		cvDto.setGithubAddress(cv.getGithubAddress());
		cvDto.setLinkedinAddress(cv.getLinkedinAddress());
		cvDto.setKnownTechnologies(cv.getKnownTechnologies());
//		cvDto.setCandidate(cv.getCandidate());	
		
		List<Picture> pictures = pictureService.getAllByUserId(cv.getCandidate().getUserId()).getData();
		cvDto.setPictures(pictures);
		
		List<School> schools = schoolService.getAllByCurriculumVitaeIdSorted(cv.getCurriculumVitaeId()).getData();
		cvDto.setSchools(schools);
		
		List<JobExperience> jobExperiences = jobExperienceService.getAllByCurriculumVitaeIdSorted(cv.getCurriculumVitaeId()).getData();
		cvDto.setJobExperiences(jobExperiences);
		
		List<ForeignLanguage> foreignLanguages = foreignLanguageService.getAllByCurriculumVitaeId(cv.getCurriculumVitaeId()).getData();
		cvDto.setForeignLanguages(foreignLanguages);
		
		return new SuccessDataResult<>(cvDto);
	}

	@Override
	public Result add(CurriculumVitaeDto curriculumVitaeDto) {
		Candidate candidate = candidateService.getById(curriculumVitaeDto.getUserId()).getData();
		if(candidate == null) {
			return new ErrorResult("İşlem başarısız, kullanıcı bulunamadı");
		}
		
		CurriculumVitae currentCv = curriculumVitaeDao.getByCandidate_UserId(candidate.getUserId());
		if(currentCv != null) {
			return new ErrorDataResult("Zaten ekli bilgiler bulunmakta. Bilgilerini güncellemek için güncelleme sayfasını kullan.");
		}
			
		CurriculumVitae cv = new CurriculumVitae();
		cv.setCandidate(candidate);
		cv.setCoverLetter(curriculumVitaeDto.getCoverLetter());
		cv.setGithubAddress(curriculumVitaeDto.getGithubAddress());
		cv.setLinkedinAddress(curriculumVitaeDto.getLinkedinAddress());
		cv.setKnownTechnologies(curriculumVitaeDto.getKnownTechnologies());
		
		curriculumVitaeDao.save(cv);
		
		for(JobExperience jobExperience : curriculumVitaeDto.getJobExperiences()) {
			jobExperience.setCurriculumVitae(cv);
		}
		jobExperienceService.addAll(curriculumVitaeDto.getJobExperiences());
		
		for(School school : curriculumVitaeDto.getSchools()) {
			school.setCurriculumVitae(cv);
		}
		schoolService.addAll(curriculumVitaeDto.getSchools());
		
		for(ForeignLanguage foreignLanguage : curriculumVitaeDto.getForeignLanguages()) {
			foreignLanguage.setCurriculumVitae(cv);
		}
		foreignLanguageService.addAll(curriculumVitaeDto.getForeignLanguages());
	
		return new SuccessResult("İşlem Başarılı, CV eklendi");
	}

	@Override
	public Result update(CurriculumVitaeDto curriculumVitaeDto) {
		//TODO yazılacak
//		CurriculumVitae newCurriculumVitae = curriculumVitaeDao.findById(curriculumVitaeDto.getCurriculumVitaeId()).get();
//		newCurriculumVitae = curriculumVitaeDto;
//		curriculumVitaeDao.save(newCurriculumVitae);
		return new SuccessResult();
	}
	
}
