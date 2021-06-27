package javacamp.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.conretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	Optional<Employer> findByEmail(String email);
	
	Optional<Employer> findByUserId(int userId);
	
	List<Employer> findByIsConfirmed(boolean isConfirmed);
	
	@Modifying
    @Query(value= "update employers  set is_confirmed = :confirmed where user_id = :userId", nativeQuery = true)
    int setEmployerConfirmed(@Param("confirmed") boolean confirmed, @Param("userId") int userId);

}
