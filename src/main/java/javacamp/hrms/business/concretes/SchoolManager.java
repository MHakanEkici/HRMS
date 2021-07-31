package javacamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.SchoolService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.SchoolDao;
import javacamp.hrms.entities.conretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		if (school.getGraduationDate() == null) {
			school.setGraduationDate(LocalDate.parse("Devam ediyor"));
		}
		this.schoolDao.save(school);
		return new SuccessResult();
	}
	
	@Override
	public Result addAll(List<School> schools) {
		for(School school:schools) {
			if (school.getGraduationDate() == null) {
				school.setGraduationDate(LocalDate.parse("Devam ediyor"));
			}
		}
		
		this.schoolDao.saveAll(schools);
		return new SuccessResult();
		
	}

	@Override
	public Result deleteAll(int userId) {
		schoolDao.deleteByCurriculumVitae_Candidate_UserId(userId);
		return new SuccessResult();
	}

	@Override
	public Result update(School school) {
		//TODO yazılacak
		School newSchool = schoolDao.findById(school.getId()).get();
		newSchool = school;
		schoolDao.save(newSchool);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}
	
	@Override
	public DataResult<List<School>> getAllByCurriculumVitaeIdSorted(int curriculumVitaeId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationDate");
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCurriculumVitae_CurriculumVitaeId(curriculumVitaeId, sort));
	}


}
