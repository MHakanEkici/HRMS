package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ForeignLanguageService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ForeignLanguageDao;
import javacamp.hrms.entities.conretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
	
	private ForeignLanguageDao foreignLanguageDao;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult();
	}
	
	@Override
	public Result addAll(List<ForeignLanguage> foreignLanguages) {
		this.foreignLanguageDao.saveAll(foreignLanguages);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		ForeignLanguage newforeignLanguage = foreignLanguageDao.findById(foreignLanguage.getLanguageId()).get();
		newforeignLanguage = foreignLanguage;
		foreignLanguageDao.save(newforeignLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAllByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.getAllByCurriculumVitae_CurriculumVitaeId(curriculumVitaeId));
	}

}
