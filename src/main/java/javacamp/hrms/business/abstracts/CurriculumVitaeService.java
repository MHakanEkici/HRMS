package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.CurriculumVitae;
import javacamp.hrms.entities.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {
	
	public Result add(CurriculumVitaeDto curriculumVitaeDto);
	
	public Result update(CurriculumVitaeDto curriculumVitaeDto);
	
	DataResult<CurriculumVitaeDto> getByUserId(int userId);

}
