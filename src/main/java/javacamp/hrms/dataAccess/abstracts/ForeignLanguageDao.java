package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>{
	
	List<ForeignLanguage> getAllByCurriculumVitae_CurriculumVitaeId(int curriculumVitaeId);
	
	void deleteByCurriculumVitae_Candidate_UserId(int userId);

}
