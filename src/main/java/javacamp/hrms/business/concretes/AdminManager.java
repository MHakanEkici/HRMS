package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.AdminService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorDataResult;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.AdminDao;
import javacamp.hrms.entities.conretes.Admin;
import java.util.Optional;

@Service
public class AdminManager implements AdminService {
	
	private AdminDao adminDao;
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	@Override
	public DataResult<Admin> logIn(Admin request) {
		Optional<Admin> admin = adminDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		if(admin.isPresent()){
			return new SuccessDataResult<>(admin.get());
		} else {
			return new ErrorDataResult<Admin>("Girdiğiniz bilgilere ait kullanıcı bulunamadı");
		}
	}

}
