package javacamp.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Picture;

public interface PictureService {
	
	DataResult<List<Picture>> getAll();
	
	Result uploadAndAdd(MultipartFile multipartFile, int userId) throws IOException;
	
	Result delete(int id) throws IOException;
	
	DataResult<Optional<Picture>> getById(int id);
	
	Boolean isExists(int id);

}
