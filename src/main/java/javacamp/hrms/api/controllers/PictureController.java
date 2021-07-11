package javacamp.hrms.api.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.ErrorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javacamp.hrms.business.abstracts.PictureService;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Picture;


@RestController
@RequestMapping("/api/pictures")
@CrossOrigin
public class PictureController {

	private PictureService pictureService;

	@Autowired
	public PictureController(PictureService pictureService) {
		super();
		this.pictureService = pictureService;
	}

	@GetMapping("getAll")
	public DataResult<List<Picture>> getAll() {
		return this.pictureService.getAll();
	}

	@PostMapping("/upload")
	public Result upload(@RequestParam MultipartFile multipartFile, @RequestParam int userId) throws IOException {

		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
		if (bufferedImage == null) {
			return new ErrorResult("Resim yüklenemedi");
		}

		return this.pictureService.uploadAndAdd(multipartFile, userId);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable("id") int id) throws IOException {
		if (!this.pictureService.isExists(id)) {
			//return new ResponseEntity("Resim bulunamadı", HttpStatus.NOT_FOUND);
			return new ErrorResult("Resim bulunamadı");
		}

		return this.pictureService.delete(id);
		//return new ResponseEntity("Resim başarıyla silindi.", HttpStatus.OK);
	}

}
