package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
	
	List<VerificationCode> findByUserId(int userId);
	
}
