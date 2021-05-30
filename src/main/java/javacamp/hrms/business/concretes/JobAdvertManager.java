package javacamp.hrms.business.concretes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CityDao;
import javacamp.hrms.dataAccess.abstracts.JobAdvertDao;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	private CityDao cityDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityDao cityDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao = cityDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvert.setCreateTime(OffsetDateTime.now());
		jobAdvert.setActive(true);
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İşlem Başarılı. İş ilanı eklendi.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		JobAdvert newJobAdvert = jobAdvertDao.findById(jobAdvert.getJobAdvertId()).get();
		newJobAdvert = jobAdvert;
		jobAdvertDao.save(newJobAdvert);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvert>> getAllJobAdverts() {
		return new SuccessDataResult(jobAdvertDao.getAllByIsActiveTrue());
	}

	@Override
	public DataResult<List<City>> getAllCities() {
		return new SuccessDataResult(cityDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
		return new SuccessDataResult(jobAdvertDao.getAllByIsActiveTrue(sort));
	}
	

//	@Override
//	public void addCity() {
//		
//		String[] sehirler ={"Adana","Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
//	            "Aydın", "Balıkesir","Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
//	            "Çankırı", "Çorum","Denizli","Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum ", "Eskişehir",
//	            "Gaziantep", "Giresun","Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
//	            "Kars", "Kastamonu", "Kayseri","Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya ", "Malatya",
//	            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
//	            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon  ", "Tunceli", "Şanlıurfa", "Uşak",
//	            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt ", "Karaman", "Kırıkkale", "Batman", "Şırnak",
//	            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük ", "Kilis", "Osmaniye ", "Düzce"};
//		
//		List<String> sehirListesi =  Arrays.asList(sehirler);
//		
//		List<City> cityList = new ArrayList();
//
//		for(String sehir : sehirListesi) {
//			City City = new City();
//			City.setCityName(sehir);
//			cityList.add(City);
//		}
//		
//		cityDao.saveAll(cityList);
//	}

}
