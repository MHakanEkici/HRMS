package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.ForeignLanguage;
import javacamp.hrms.entities.conretes.JobExperience;

public interface ForeignLanguageService {
	
	DataResult<List<ForeignLanguage>> getAll();
	
	DataResult<List<ForeignLanguage>> getAllByCurriculumVitaeId(int curriculumVitaeId);
	
	Result addAll(List <ForeignLanguage> foreignLanguages);
	
	Result add(ForeignLanguage foreignLanguage);
	
	Result delete(int id);
	
	Result update(ForeignLanguage foreignLanguage);

}
