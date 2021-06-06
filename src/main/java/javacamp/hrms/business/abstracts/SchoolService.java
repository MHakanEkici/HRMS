package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.School;

public interface SchoolService {
	
	Result add(School school);
	
	Result addAll(List <School> schools);
	
	Result delete(int id);
	
	Result update(School school);
	
	DataResult<List<School>> getAll();
	
	DataResult<List<School>> getAllByCurriculumVitaeIdSorted(int curriculumVitaeId);

}
