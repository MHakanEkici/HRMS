package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.Job;

public interface JobDao extends JpaRepository<Job,Integer> {
	Optional<Job> findByJobName(String Job);
	
}
