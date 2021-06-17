package javacamp.hrms.api.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import javacamp.hrms.core.adapters.CloudinaryService;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.Picture;
import javacamp.hrms.entities.conretes.User;

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
	public ResponseEntity<List<Picture>> getAll() {

		List<Picture> list = this.pictureService.getAll().getData();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @RequestParam int userId)
			throws IOException {

		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
		if (bufferedImage == null) {

			return new ResponseEntity("Resim validasyonu başarısız.", HttpStatus.BAD_REQUEST);
		}

		this.pictureService.uploadAndAdd(multipartFile, userId);
		return new ResponseEntity("Picture saved.", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!this.pictureService.isExists(id)) {
			return new ResponseEntity("Böyle bir resim bulunamadı", HttpStatus.NOT_FOUND);
		}

		this.pictureService.delete(id);
		return new ResponseEntity("Resim başarıyla silindi.", HttpStatus.OK);
	}

}
