package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.FavouriteJobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.dataAccess.abstracts.FavouriteJobAdvertDao;
import javacamp.hrms.dataAccess.abstracts.JobAdvertDao;
import javacamp.hrms.entities.conretes.Candidate;
import javacamp.hrms.entities.conretes.FavouriteJobAdvert;

@Service
public class FavouriteJobAdvertManager implements FavouriteJobAdvertService {
	
	private FavouriteJobAdvertDao favouriteJobAdvertDao;
	private CandidateDao candidateDao;
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
    public FavouriteJobAdvertManager(FavouriteJobAdvertDao favouriteJobAdvertDao,CandidateDao candidateDao, JobAdvertDao jobAdvertDao) {
        this.favouriteJobAdvertDao = favouriteJobAdvertDao;
        this.candidateDao=candidateDao;
        this.jobAdvertDao=jobAdvertDao;
    }

	@Override
	public DataResult<List<FavouriteJobAdvert>> getByUserId(int userId) {
		return new SuccessDataResult<List<FavouriteJobAdvert>>(this.favouriteJobAdvertDao.findByCandidate_UserId(userId));
	}

	@Override
	public Result addFavouriteJobAdvert(int userId, int jobAdvertId) {
		FavouriteJobAdvert favouriteJobAdvert=new FavouriteJobAdvert();
		Optional<Candidate> currentCandidate = candidateDao.findById(userId);
		if(!currentCandidate.isPresent()){
			return new ErrorResult("Kullanıcı bulunamadı");
		}
		if(this.favouriteJobAdvertDao.existsByCandidate_userIdAndJobAdvert_jobAdvertId(userId,jobAdvertId)){
            return new ErrorResult("Bu ilan zaten favorilerinizde");
        }
		favouriteJobAdvert.setCandidate(currentCandidate.get()); 
		favouriteJobAdvert.setJobAdvert(this.jobAdvertDao.getByJobAdvertId(jobAdvertId));
        this.favouriteJobAdvertDao.save(favouriteJobAdvert);
        return new SuccessResult("İlan favorilere eklendi");
	}

	@Override
	public Result removeFavouriteJobAdvert(int favouriteJobAdvertId) {
		this.favouriteJobAdvertDao.deleteById(favouriteJobAdvertId);
        return new SuccessResult("İlan favorilerden kandırıldı");
	}

}
