package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.conretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

	Optional<Candidate> findByIdentityNumberOrEmail(Long identityNumber, String email);

	Optional<Candidate> findByEmailAndPassword(String email, String password);

}
