package javacamp.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.PictureService;
import javacamp.hrms.core.adapters.CloudinaryService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.core.utilities.SuccessDataResult;
import javacamp.hrms.core.utilities.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PictureDao;
import javacamp.hrms.entities.conretes.Picture;
import javacamp.hrms.entities.conretes.User;

@Service
public class PictureManager implements PictureService{
	
    private PictureDao pictureDao;
    private CloudinaryService cloudinaryService;
	
	@Autowired
	public PictureManager(PictureDao pictureDao, CloudinaryService cloudinaryService) {
		super();
		this.pictureDao = pictureDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<Picture>> getAll() {
		return new SuccessDataResult<List<Picture>>(this.pictureDao.findByOrderById(),"Başarıyla listelendi");
	}

	@Override
	public Result uploadAndAdd(MultipartFile multipartFile, int userId) throws IOException {
		Map result = cloudinaryService.upload(multipartFile);
		Picture picture = new Picture();
		picture.setPictureName((String) result.get("original_filename"));
		picture.setPictureUrl((String)result.get("url"));
		picture.setPictureId((String)result.get("public_id"));
		this.pictureDao.save(picture);
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public Result delete(int id) throws IOException {
		Map result = cloudinaryService.delete(id);
		this.pictureDao.deleteById(id);
		return new SuccessResult("Başarıyla silindi");
	}

	@Override
	public DataResult<Optional<Picture>> getById(int id) {
		return new SuccessDataResult<Optional<Picture>>(this.pictureDao.findById(id),"Başarıyla getirildi."); 
	}

	@Override
	public Boolean isExists(int id) {
		return this.pictureDao.existsById(id);
	}

}
