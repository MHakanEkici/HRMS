package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.VerificationCode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
	
	List<VerificationCode> findByUserId(int userId);

	@Modifying
	@Query(value= "update verification_codes set is_verified = true where code = :code", nativeQuery = true)
	int confirmCode(@Param("code") String code);
	
}
