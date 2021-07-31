package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.School;

public interface SchoolDao extends JpaRepository <School, Integer>{
	
	List<School> getAllByCurriculumVitae_CurriculumVitaeId(int curriculumVitaeId, Sort sort);
	
	void deleteByCurriculumVitae_Candidate_UserId(int userId);

}
