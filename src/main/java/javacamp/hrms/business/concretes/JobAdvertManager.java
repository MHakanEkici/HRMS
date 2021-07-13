package javacamp.hrms.business.concretes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CityDao;
import javacamp.hrms.dataAccess.abstracts.JobAdvertDao;
import javacamp.hrms.entities.conretes.City;
import javacamp.hrms.entities.conretes.JobAdvert;
import javacamp.hrms.entities.dtos.JobAdvertDto;

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
		jobAdvert.setActive(false);
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İşlem Başarılı. İş ilanı eklendi.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		//TODO yazılacak
		JobAdvert newJobAdvert = jobAdvertDao.findById(jobAdvert.getJobAdvertId()).get();
		newJobAdvert = jobAdvert;
		newJobAdvert.setActive(false);
		jobAdvertDao.save(newJobAdvert);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<City>> getAllCities() {
		return new SuccessDataResult(cityDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertDto>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
		
		List<JobAdvertDto> advertDtoList = new ArrayList<>();
		
		jobAdvertDao.getAllByIsActiveTrue(sort).forEach(advert->{
			JobAdvertDto advertDto = new JobAdvertDto(); 
			
			advertDto.setActive(advert.isActive());
			advertDto.setCity(advert.getCity());
			advertDto.setCreateTime(advert.getCreateTime().toLocalDate());
			advertDto.setDeadline(advert.getDeadline());
			advertDto.setDescription(advert.getDescription());
			advertDto.setEmployer(advert.getEmployer());
			advertDto.setJob(advert.getJob());
			advertDto.setJobAdvertId(advert.getJobAdvertId());
			advertDto.setOpenPositionCount(advert.getOpenPositionCount());
			advertDto.setSalary(advert.getSalary());
			advertDto.setWorkStyle(advert.getWorkStyle());
			advertDto.setWorkTime(advert.getWorkTime());
			
			advertDtoList.add(advertDto);
		});
		return new SuccessDataResult(advertDtoList);
	}

	@Override
	public DataResult<JobAdvertDto> getByJobAdvertId(int jobAdvertId) {
		JobAdvert advert = jobAdvertDao.getByJobAdvertId(jobAdvertId);
		
		JobAdvertDto advertDto = new JobAdvertDto();
		
		advertDto.setActive(advert.isActive());
		advertDto.setCity(advert.getCity());
		advertDto.setCreateTime(advert.getCreateTime().toLocalDate());
		advertDto.setDeadline(advert.getDeadline());
		advertDto.setDescription(advert.getDescription());
		advertDto.setEmployer(advert.getEmployer());
		advertDto.setJob(advert.getJob());
		advertDto.setJobAdvertId(advert.getJobAdvertId());
		advertDto.setOpenPositionCount(advert.getOpenPositionCount());
		advertDto.setSalary(advert.getSalary());
		advertDto.setWorkStyle(advert.getWorkStyle());
		advertDto.setWorkTime(advert.getWorkTime());
		
		return new SuccessDataResult(advertDto);
	}
	 
	@Override
	public DataResult<List<JobAdvert>> getAllPassiveJobAdverts() {
		return new SuccessDataResult<>(jobAdvertDao.findByIsActive(false));
	}

	@Override
	@Transactional
	public Result setActiveJobAdvert(int jobAdvertId) {
		int updatedJobAdvert = jobAdvertDao.setJobAdvertActive(true, jobAdvertId);
		if(updatedJobAdvert == 1) {
			return new SuccessResult("İşlem Başarılı");
		}
		else {
			return new ErrorResult("İşlem Başarısız");
		}
	}
}
