package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.Picture;

public interface PictureDao extends JpaRepository<Picture, Integer>{
	
	List<Picture> findByOrderById();
	
	List<Picture> getAllByUser_UserId(int UserId);

}
