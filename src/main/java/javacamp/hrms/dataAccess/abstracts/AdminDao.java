package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.conretes.Admin;

public interface AdminDao extends JpaRepository<Admin,Integer>{

}
