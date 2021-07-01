package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.entities.conretes.Admin;

public interface AdminService {
	
	DataResult<Admin> logIn(Admin admin);

}
