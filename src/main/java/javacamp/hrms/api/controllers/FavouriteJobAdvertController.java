package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.FavouriteJobAdvertService;
import javacamp.hrms.core.utilities.DataResult;
import javacamp.hrms.core.utilities.Result;
import javacamp.hrms.entities.conretes.FavouriteJobAdvert;

@RestController
@RequestMapping(path = "/api/favouriteJobAdverts", produces = { MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" }, consumes = {
		MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" })
@ResponseBody
@CrossOrigin
public class FavouriteJobAdvertController {
	
	private FavouriteJobAdvertService favouriteJobAdvertService;
	
	@Autowired
	public FavouriteJobAdvertController(FavouriteJobAdvertService favouriteJobAdvertService) {
		super();
		this.favouriteJobAdvertService = favouriteJobAdvertService;
	}
	
	 @GetMapping("/getByUserId")
	    public ResponseEntity<?> getByCandidateId(@RequestParam int userId){
	        DataResult<List<FavouriteJobAdvert>> result=this.favouriteJobAdvertService.getByUserId(userId);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }

	    @PostMapping("/addFavouriteJobAdvert")
	    public ResponseEntity<?> addFavouriteJobAdvert(@RequestParam int userId,@RequestParam int jobAdvertId){
	        Result result=this.favouriteJobAdvertService.addFavouriteJobAdvert(userId,jobAdvertId);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }

	    @DeleteMapping("/removeFavouriteJobAdvert")
	    public ResponseEntity<?> removeFavouriteJobAdvert(@RequestParam int favouriteJobAdvertId){
	        Result result = this.favouriteJobAdvertService.removeFavouriteJobAdvert(favouriteJobAdvertId);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }

}
