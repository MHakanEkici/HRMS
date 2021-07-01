package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.ForeignLanguage;

public interface ForeignLanguageService {

	Result add(ForeignLanguage foreignLanguage);
	
	Result addAll(List <ForeignLanguage> foreignLanguages);

	Result update(ForeignLanguage foreignLanguage);
	
	Result delete(int id);

	DataResult<List<ForeignLanguage>> getAll();

	DataResult<List<ForeignLanguage>> getAllByCurriculumVitaeId(int curriculumVitaeId);

}
