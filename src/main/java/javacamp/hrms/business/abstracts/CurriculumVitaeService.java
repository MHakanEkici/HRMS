package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {
	
	Result add(CurriculumVitaeDto curriculumVitaeDto);
	
	Result update(CurriculumVitaeDto curriculumVitaeDto);
	
	DataResult<CurriculumVitaeDto> getByUserId(int userId);

}
