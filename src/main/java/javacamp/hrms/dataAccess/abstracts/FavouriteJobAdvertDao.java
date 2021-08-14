package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.FavouriteJobAdvert;

public interface FavouriteJobAdvertDao extends JpaRepository<FavouriteJobAdvert,Integer> {
	
	List<FavouriteJobAdvert> findByCandidate_UserId(int userId);
	
	boolean existsByCandidate_userIdAndJobAdvert_jobAdvertId(int userId, int jobAdvertId); 

}
