package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.AdminService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorDataResult;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.AdminDao;
import javacamp.hrms.entities.conretes.Admin;
import javacamp.hrms.entities.conretes.Candidate;

@Service
public class AdminManager implements AdminService {
	
	private AdminDao adminDao;
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	@Override
	public DataResult<Admin> logIn(Admin newAdmin) {
		boolean isMatched = false;
		Admin matchedAdmin = new Admin();
		for (Admin admin : adminDao.findAll()) {
			if (newAdmin.getEmail().equals(admin.getEmail())
					&& newAdmin.getPassword().equals(admin.getPassword())) {
				isMatched = true;
				matchedAdmin = admin;
			}

		}
		if (isMatched == true) {
			return new SuccessDataResult<Admin>(matchedAdmin);
		} else {
			return new ErrorDataResult<Admin>("Giriş Başarısız");
		}
	}

}
