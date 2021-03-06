package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.conretes.CurriculumVitae;


public interface CurriculumVitaeDao extends JpaRepository <CurriculumVitae, Integer> {
	
//	@Query("Select new javacamp.hrms.entities.dtos.CurriculumVitaeDto"
//			+"(c.curriculumVitaeId,s.schoolName,s.department,s.startDate,"
//			+"s.graduationDate,j.workplaceName,j.position,j.startDateOfWork,"
//			+"j.finishDateOfWork,f.languageName,f.level,c.githubAddress,c.linkedinAddress,"
//			+"c.knownTechnologies,c.coverLetter)"
//			+" From CurriculumVitae c"
//			+" Inner Join c.schools s"
//			+" Inner Join c.jobExperiences j"
//			+" Inner Join c.foreignLanguages f")
	CurriculumVitae getByCandidate_UserId(int userId);

}
