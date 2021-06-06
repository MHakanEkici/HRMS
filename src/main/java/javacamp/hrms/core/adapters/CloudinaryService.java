package javacamp.hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	
	Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();
		
		public CloudinaryService() {
			valuesMap.put("cloud_name","df5btvemm" );
			valuesMap.put("api_key", "585717548827285" );
			valuesMap.put("api_secret","fEaoLYf9bl8QHRrW84CH5W8DhQo" );
			cloudinary = new Cloudinary(valuesMap);
		}
		
		public Map upload (MultipartFile multipartFile) throws IOException {
			File file = convert(multipartFile);
			Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return result;
		}
		
		public Map delete (int id) throws IOException {
			Map result = cloudinary.uploader().destroy(String.valueOf(id),ObjectUtils.emptyMap());
			return result;
		}
		
		
		private File convert(MultipartFile multipartFile) throws IOException {
			File file = new File(multipartFile.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(multipartFile.getBytes());
			stream.close();
			
			return file;
		}

}
