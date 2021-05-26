//package javacamp.hrms.business.concretes;
//
//import org.springframework.stereotype.Service;
//
//import javacamp.hrms.business.abstracts.CandidateService;
//import javacamp.hrms.entities.conretes.User;
//
//@Service
//public class UserManager implements CandidateService {
//
//	private EmailService emailService;
//	private ValidatorService validatorService;
//	private UserDao userDao;
//
//	public UserManager(ValidatorService validatorService, UserDao userDao, EmailService emailService) {
//		super();
//		this.validatorService = validatorService;
//		this.userDao = userDao;
//		this.emailService = emailService;
//	}
//
//	
//	@Override
//	public boolean register(User user) {
//		boolean isRegistered = false;
//		if (validatorService.isValidUserInfo(user)) {
//			if (validatorService.isValidEmailAdress(user.getePosta())) {
//				if (validatorService.isValidPassword(user.getPassword())) {
//					if (validatorService.isUserExist(user.getePosta(), userDao)) {
//						userDao.add(user);
//						emailService.sendVerifactionEmail(user.getePosta());
//						isRegistered = true;
//					} else {
//						System.out.println("Bu ePosta adresiyle kay�tl� bir kullan�c� bulunmaktad�r.");
//					}
//				} else {
//					System.out.println("Parola en az 6 karakterden olu�mal�d�r.");
//				}
//			} else {
//				System.out.println("L�tfen ge�erli bir eMail adres giriniz");
//			}
//		} else {
//			System.out.println("L�tfen b�t�n bilgileri giriniz.");
//		}
//
//		return isRegistered;
//	}
//
//	@Override
//	public void logIn(User newUser) {
//		boolean isMatched = false;
//		for (User user : userDao.userList()) {
//			if (newUser.getePosta().equals(user.getePosta()) && newUser.getPassword().equals(user.getPassword())
//					&& user.isActive()) {
//				isMatched = true;
//			}
//
//		}
//		if (isMatched == true) {
//			System.out.println("Giri� Ba�ar�l�");
//		} else {
//			System.out.println("Giri� Ba�ar�s�z");
//		}
//
//	}
//
//}
