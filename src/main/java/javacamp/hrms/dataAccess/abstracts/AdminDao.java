package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.conretes.Admin;
import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin,Integer>{

    Optional<Admin> findByEmailAndPassword(String email, String password);

}
