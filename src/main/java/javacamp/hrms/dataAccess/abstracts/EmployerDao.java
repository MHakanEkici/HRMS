package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.conretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	Optional<Employer> findByEmail(String email);
	Optional<Employer> findByUserId(int userId);

}
